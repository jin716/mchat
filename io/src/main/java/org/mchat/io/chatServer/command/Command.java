package org.mchat.io.chatServer.command;

import io.netty.channel.Channel;
import org.mchat.io.chatServer.ChannelCache;
import org.mchat.io.chatServer.message.Message;


/**
 * Created by jingli on 16/7/6.
 */
public abstract class Command {
    final Message message;
    final ChannelCache cache;
    final Channel sender;

    public Command(final Message message, final ChannelCache cache, final Channel sender) {
        this.message = message;
        this.cache = cache;
        this.sender = sender;
    }

    abstract public void process();

}
