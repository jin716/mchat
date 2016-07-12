package org.mchat.io.chatServer.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.mchat.io.chatServer.message.Protobuf;
import org.mchat.io.chatServer.message.Message;
import org.mchat.io.chatServer.router.RouterService;

/**
 * Created by jingli on 16/5/26.
 */
public class RouterHandler extends SimpleChannelInboundHandler<Protobuf.Message> {

    final RouterService service;

    public  RouterHandler(RouterService service){
         this.service = service;
    }


    @Override
    protected void messageReceived(ChannelHandlerContext ctx, Protobuf.Message msg) throws Exception {
        if(msg.getType() == Protobuf.Message.Type.TEXT){
            service.addMessage(new Message(msg));
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

    }
}
