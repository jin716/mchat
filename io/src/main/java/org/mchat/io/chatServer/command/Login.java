package org.mchat.io.chatServer.command;

import io.netty.channel.Channel;
import org.mchat.io.chatServer.ChannelCache;
import org.mchat.io.chatServer.message.ProtoMessage;
import org.mchat.io.chatServer.message.Protobuf;
import org.mchat.io.chatServer.message.Protobuf.Message.*;
import org.mchat.io.chatServer.router.RouterService;

/**
 * Created by jingli on 16/9/28.
 */
public class Login extends Command{


    public Login(ProtoMessage message, RouterService service, ChannelCache cache, Channel sender) {
        super(message, service, cache, sender);
    }

    @Override
    public void process() {
        cache.setLocalUserChannel(message.getFrom(), sender);
        Protobuf.Message message = replyOk();
        routerService.addMessage(new ProtoMessage(message));
    }

    private Protobuf.Message replyOk(){
        return Protobuf.Message.newBuilder()
               .setText("ok")
               .setType(Type.CMD)
               .setTo(this.message.getFrom()).build();
    }
}
