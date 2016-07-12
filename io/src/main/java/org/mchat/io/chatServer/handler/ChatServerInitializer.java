package org.mchat.io.chatServer.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import org.mchat.io.chatServer.message.Protobuf;
import org.mchat.io.chatServer.router.RouterService;

/**
 * Created by jingli on 16/5/26.
 */
public class ChatServerInitializer<T extends Channel> extends ChannelInitializer{

    RouterService service;

    public ChatServerInitializer RouterService(RouterService service){
        this.service = service;
        return this;
    }


    @Override
    protected void initChannel(Channel socketChannel) throws Exception {
        socketChannel.pipeline().addLast("protobufDecoder", new ProtobufDecoder(Protobuf.Parent.getDefaultInstance()));
        socketChannel.pipeline().addLast(new CommandHandler());
        socketChannel.pipeline().addLast(new RouterHandler());
    }
}
