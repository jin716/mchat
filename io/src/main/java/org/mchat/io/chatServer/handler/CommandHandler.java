package org.mchat.io.chatServer.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.mchat.io.chatServer.ChannelCache;
import org.mchat.io.chatServer.command.Command;
import org.mchat.io.chatServer.command.CommandFactroy;
import org.mchat.io.chatServer.message.Protobuf;
import org.mchat.io.chatServer.message.Message;

/**
 * Created by jingli on 16/5/26.
 */
public class CommandHandler extends SimpleChannelInboundHandler<Protobuf.Message> {


    @Override
    protected void messageReceived(ChannelHandlerContext ctx, Protobuf.Message msg) throws Exception {
        ChannelCache cache = ChannelCache.getInstance();
        Command command = CommandFactroy.getInstance(new Message(msg),cache,ctx.channel());
        if(command != null){
            command.process();
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

    }
}
