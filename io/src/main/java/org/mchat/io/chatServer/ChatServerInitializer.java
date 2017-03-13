package org.mchat.io.chatServer;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import org.mchat.io.chatServer.message.Protobuf;

/**
 * Created by jingli on 16/5/26.
 */
public class ChatServerInitializer<T extends Channel> extends ChannelInitializer{




    @Override
    protected void initChannel(Channel socketChannel) throws Exception {
        socketChannel.pipeline().addLast("frameDecoder",new ProtobufVarint32FrameDecoder());
        socketChannel.pipeline().addLast("protobufDecoder", new ProtobufDecoder(Protobuf.Parent.getDefaultInstance()));
        socketChannel.pipeline().addLast(new RouterHandler());
    }
}
