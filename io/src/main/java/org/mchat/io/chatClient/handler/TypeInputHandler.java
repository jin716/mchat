package org.mchat.io.chatClient.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.mchat.io.chatServer.ChannelCache;
import org.mchat.io.chatServer.command.Command;
import org.mchat.io.chatServer.command.CommandFactroy;
import org.mchat.io.chatServer.message.ProtoMessage;
import org.mchat.io.chatServer.message.Protobuf;
import org.mchat.io.chatServer.router.RouterService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jingli on 16/5/26.
 */
public class TypeInputHandler extends SimpleChannelInboundHandler<Protobuf.Message> {

    final RouterService service = null;



    @Override
    protected void messageReceived(ChannelHandlerContext ctx, Protobuf.Message msg) throws Exception {
        ChannelCache cache = ChannelCache.getInstance();
        RouterService service = RouterService.getInstance();
        Command command = CommandFactroy.
                getInstance(new ProtoMessage(msg), cache, ctx.channel(),service);
        if(command != null){
            command.process();

        }

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Runnable shell = new Runnable() {
            @Override
            public void run() {
                 while (true){
                     BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                     try {
                         String line = reader.readLine();

                     } catch (IOException e) {
                     }

                 }
            }
        };
    }
}
