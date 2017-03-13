package org.mchat.io.chatServer;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.mchat.io.chatServer.command.Command;
import org.mchat.io.chatServer.command.CommandFactroy;
import org.mchat.io.chatServer.message.ProtoMessage;
import org.mchat.io.chatServer.message.Protobuf;
import org.mchat.io.chatServer.router.RouterService;

/**
 * Created by jingli on 16/5/26.
 */
public class CommandHandler extends SimpleChannelInboundHandler<Protobuf.Message> {


    @Override
    protected void messageReceived(ChannelHandlerContext ctx, Protobuf.Message msg) throws Exception {
        ChannelCache cache = ChannelCache.getInstance();
        RouterService service = RouterService.getInstance();
        Command command = CommandFactroy.
                getInstance(new ProtoMessage(msg), cache, ctx.channel(), service);
        if(command != null){
            command.process();
            return;
        }
        ctx.fireChannelRead(msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

    }
}
