package org.mchat.io.chatClient;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.mchat.io.chatServer.message.Protobuf;

/**
 * Created by jingli on 16/5/26.
 */
public class TypeInputHandler extends SimpleChannelInboundHandler<Protobuf.Message> {



    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, Protobuf.Message msg) throws Exception {
        System.out.println(msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.write(login(888666L));
        for (int i = 0; i < 1; i++) {
            ctx.write(req(i));
        }
        ctx.flush();
    }

    private Protobuf.Parent req(int i){
        for (;;) {
            String line = "text: " + i;
            Protobuf.Message message = Protobuf.Message.newBuilder()
                    .setText(line)
                    .setType(Protobuf.Message.Type.TEXT)
                    .setFrom(Long.valueOf("123"))
                    .setTo(Long.valueOf("321")).build();
            Protobuf.Parent parent =  Protobuf.Parent.newBuilder()
                    .setMessage(message)
                    .build();
            return parent;
        }
    }

    private Protobuf.Parent login(Long name){
        for (;;) {
            Protobuf.Message message = Protobuf.Message.newBuilder()
                    .setText("login")
                    .setType(Protobuf.Message.Type.CMD)
                    .setFrom(Long.valueOf(name))
                    .setTo(Long.valueOf("8888888")).build();
            Protobuf.Parent parent =  Protobuf.Parent.newBuilder()
                    .setMessage(message)
                    .build();
            return parent;
        }
    }
}
