package org.mchat.io.chatServer;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created by jingli on 16/5/26.
 */
public class ChatServer {

    private int port;

    public ChatServer(int port){
        this.port = port;
    }

    public void run(){
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            System.out.println("binding:" + port);
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(boss).group(worker)
                    .channel(NioServerSocketChannel.class)
                    .handler(new ChatServerChannelInitializer<SocketChannel>());
            ChannelFuture future = bootstrap.bind(this.port);
            future.channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }

    }

}
