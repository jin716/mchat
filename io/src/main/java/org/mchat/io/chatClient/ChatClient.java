package org.mchat.io.chatClient;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

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
                    .channel(NioSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .handler(new ChatClientInitializer());

            b.connect(host, Integer.valueOf(port)).sync();

        } finally {
            // The connection is closed automatically on shutdown.
            group.shutdownGracefully();
        }
    }
}