package org.mchat.io.chatClient;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import org.mchat.io.chatServer.message.Protobuf;

/**
 * Created by jingli on 16/5/26.
 */
public class ChatClientInitializer extends ChannelInitializer{

    Long user = null;
    Long other = null;

    public ChatClientInitializer(){

    }

    public ChatClientInitializer(Long user, Long other){
        this.user = user;
        this.other = other;
    }

    @Override
    protected void initChannel(Channel socketChannel) throws Exception {
        socketChannel.pipeline()
                .addLast(new ProtobufVarint32FrameDecoder())
                .addLast(new ProtobufDecoder(
                        Protobuf.Parent.getDefaultInstance()))
                .addLast(new ProtobufVarint32LengthFieldPrepender())
                .addLast(new ProtobufEncoder())
                .addLast(new TypeInputHandler());
    }
}
