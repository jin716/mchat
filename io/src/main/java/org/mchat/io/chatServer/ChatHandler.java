package org.mchat.io.chatServer;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.mchat.io.message.MessageBuf;
import org.mchat.io.message.MessageFlagCodeNaming;
import org.mchat.io.message.ServerMessageBuilder;
import org.mchat.io.redis.RedisService;
import static org.mchat.io.message.MessageFlagCodeNaming.*;
/**
 * Created by jingli on 16/5/26.
 */
public class ChatHandler extends ChannelHandlerAdapter {

    RedisService service = new RedisService();

    private static int RETRY_TIME = 3;
    private static int RETRY_INTEVAL = 300;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        if(msg instanceof  MessageBuf.Message){
            MessageBuf.Message message = (MessageBuf.Message) msg;
            if(message.getType() == MessageBuf.Message.MessageType.ACK) {
                //客户端确认上线消息
                String channel = null;    //TODO
                service.subscribe(new ChatSubscribeListener(ctx), channel);
            }
            else send(ctx,message);//客户端发送信息
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        askClientOnline(ctx); //跟客户确认上线消息
    }




    private void send(ChannelHandlerContext ctx, MessageBuf.Message message){
        Long reciever = 0L; //订阅者计数
        int retry = 0 ; //重试计数
        while (reciever == 0 && retry < RETRY_TIME ){//自动重试
            reciever = service.speakTo(message);//发送到缓存
            retry++;
            try {
                Thread.sleep(RETRY_INTEVAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //重试也无法送达,返回服务错误给客户端
        if(retry >= RETRY_TIME) {
            tellClientServerError(ctx, message);
            return;
        }
        //发送到缓存不会通知客户端,直到收到客户端确认回馈.
    }

    /**
     * 跟客户确认上线消息
     */
    private void askClientOnline(ChannelHandlerContext ctx){
        MessageBuf.Message ask_online = ServerMessageBuilder
                .buildServerAckMessage(SERVER_ASK_ACK);
        ctx.writeAndFlush(ask_online);
    }


    /**
     * 通知客户端,信息发送失败
     */
    private void tellClientServerError(ChannelHandlerContext ctx, MessageBuf.Message message) {
        System.out.println("重试过多:"+message.toString());
        MessageBuf.Message error_reply = ServerMessageBuilder
                .buildErrorMessage(message, SERVER_INNER_ERROR);
        ctx.writeAndFlush(error_reply);
    }




}
