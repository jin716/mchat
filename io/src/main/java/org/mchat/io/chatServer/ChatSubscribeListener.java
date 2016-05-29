package org.mchat.io.chatServer;

import io.netty.channel.ChannelHandlerContext;
import org.mchat.io.message.MessageBuf;
import org.mchat.io.message.MessageFlagCodeNaming;
import org.mchat.io.message.ServerMessageBuilder;
import redis.clients.jedis.BinaryJedisPubSub;
import redis.clients.jedis.Client;

/**
 * Created by jingli on 16/5/28.
 */
public class ChatSubscribeListener extends BinaryJedisPubSub {

    ChannelHandlerContext ctx = null;

    public ChatSubscribeListener(ChannelHandlerContext ctx) {
        super();
        if(ctx == null)
            throw new NullPointerException("ChannelHandlerContext must not be null");
        this.ctx = ctx;
    }

    @Override
    public void onMessage(byte[] channel, byte[] message) {
        ctx.writeAndFlush(message);//订阅信息直接返回
    }


    @Override
    public void onSubscribe(byte[] channel, int subscribedChannels) {
        if(subscribedChannels>0) { //告诉客户端上线成功
            MessageBuf.Message reply_server_connected =
                    ServerMessageBuilder.buildServerAckMessage(MessageFlagCodeNaming.SERVER_CONNECTED_OK);
            ctx.writeAndFlush(reply_server_connected);
        }else{ //告诉客户端上线失败
            MessageBuf.Message reply_server_error =
                    ServerMessageBuilder.buildServerAckMessage(MessageFlagCodeNaming.SERVER_INNER_ERROR);
            ctx.writeAndFlush(reply_server_error);
        }
    }

}
