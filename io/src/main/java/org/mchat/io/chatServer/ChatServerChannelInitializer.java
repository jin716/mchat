package org.mchat.io.chatServer;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.protobuf.ProtobufDecoder;

/**
 * Created by jingli on 16/5/26.
 */
public class ChatServerChannelInitializer<T extends Channel> extends ChannelInitializer{



    @Override
    protected void initChannel(Channel socketChannel) throws Exception {

        //socketChannel.pipeline().addLast(new ProtobufDecoder());
        socketChannel.pipeline().addLast(new ChatHandler());
    }
}
