package org.mchat.io.chatServer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.apache.log4j.Logger;
import org.mchat.io.chatServer.router.RouterService;
/**
 * Created by jingli on 16/5/26.
 */
public class ChatServer {

    private int port;
    static Logger logger = Logger.getLogger(ChatServer.class);

    public ChatServer(int port){
        this.port = port;
    }

    public void run(){
        RouterService service = RouterService.getInstance();
        try {
            service.startService();
        } catch (Exception e) {
            e.printStackTrace();
        }

        EventLoopGroup boss = new NioEventLoopGroup(1);
        EventLoopGroup worker = new NioEventLoopGroup();
        try {
            logger.info("binding:" + port);
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boss, worker)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChatServerInitializer<SocketChannel>()
                    );
            bootstrap.bind(port).sync().channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }

    }

    public static void main(String[] args){

        if(args.length!=1) {
            System.out.println("port.");
            return;
        };

        ChatServer server = new ChatServer(Integer.valueOf(args[0]));
        server.run();
    }

}
