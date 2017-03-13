package org.mchat.io.chatServer;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.mchat.io.chatServer.message.ProtoMessage;
import org.mchat.io.chatServer.message.Protobuf;
import org.mchat.io.chatServer.router.RouterService;

import static org.mchat.io.chatServer.message.Protobuf.Message.Type.CMD;
import static org.mchat.io.chatServer.message.Protobuf.Message.Type.TEXT;

/**
 * Created by jingli on 16/5/26.
 */
public class RouterHandler extends SimpleChannelInboundHandler<Protobuf.Parent> {

    final RouterService service = RouterService.getInstance();

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, Protobuf.Parent parent) throws Exception {
        System.out.println(parent);
        Protobuf.Message msg = parent.getMessage();

        if(TEXT.equals(msg.getType())){
            service.addMessage(new ProtoMessage(msg));
        }
        if(CMD.equals(msg.getType())){
            if("login".equals(msg.getText()))   {
                 service.getCache().setLocalUserChannel(msg.getFrom(),ctx.channel());
            }
        }


    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client connected!:"+ctx.channel().remoteAddress());
    }
}
