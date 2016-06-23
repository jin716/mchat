package org.mchat.io.chatServer;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import org.mchat.io.chatServer.message.Message;
import static org.mchat.io.chatServer.message.MessageFlagCodeNaming.*;
/**
 * Created by jingli on 16/5/26.
 */
public class ChatHandler extends ChannelHandlerAdapter {

    //RedisService service = new RedisService();

    private static int RETRY_TIME = 3;
    private static int RETRY_INTEVAL = 300;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
    }






}
