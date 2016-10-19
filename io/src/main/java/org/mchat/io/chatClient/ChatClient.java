package org.mchat.io.chatClient;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.mchat.io.chatServer.message.Protobuf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;

/**
 * Created by jingli on 16/10/12.
 */
public final class ChatClient {

    public static void main(String[] args) throws Exception {
        if(args.length != 4) {
            System.out.println("error args: [ip] [port] [user] [talkTo]");
            return;
        }

        String host = args[0];
        String port = args[1];
        String user = args[2];
        String to = args[3];



        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
                    .channel(NioSocketChannel.class) ;
            // Start the connection attempt.
            Channel ch = b.connect(host, Integer.valueOf(port)).sync().channel();

            // Read commands from the stdin.
            ChannelFuture lastWriteFuture = null;
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            for (;;) {
                String line = in.readLine();
                if (line == null) {
                    break;
                }
                Protobuf.Message message = Protobuf.Message.newBuilder()
                        .setText(line)
                        .setType(Protobuf.Message.Type.TEXT)
                        .setTo(Long.valueOf(to)).build();
                ByteBuffer bb = ByteBuffer.allocate(500);
                bb.put(message.toByteArray());

                // Sends the received line to the server.
                lastWriteFuture = ch.writeAndFlush(line + "\r\n");

                // If user typed the 'bye' command, wait until the server closes
                // the connection.
                if ("bye".equals(line.toLowerCase())) {
                    ch.closeFuture().sync();
                    break;
                }
            }

            // Wait until all messages are flushed before closing the channel.
            if (lastWriteFuture != null) {
                lastWriteFuture.sync();
            }
        } finally {
            // The connection is closed automatically on shutdown.
            group.shutdownGracefully();
        }
    }
}