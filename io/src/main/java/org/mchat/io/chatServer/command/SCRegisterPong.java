package org.mchat.io.chatServer.command;

import io.netty.channel.Channel;
import org.mchat.io.chatServer.ChannelCache;
import org.mchat.io.chatServer.message.Message;


/**
 * Created by jingli on 16/7/6.
 */
public class SCRegisterPong extends Command {


    public SCRegisterPong(Message message, ChannelCache cache, Channel sender) {
        super(message, cache, sender);
    }

    @Override
    public void process() {
        cache.removeLocalUser(message.getFrom());
        cache.setLocalUserChannel(message.getFrom(),sender);
    }
}
