package org.mchat.io.chatServer.command;

import io.netty.channel.Channel;
import org.mchat.io.chatServer.ChannelCache;
import org.mchat.io.chatServer.message.ProtoMessage;
import org.mchat.io.chatServer.router.RouterService;


/**
 * Created by jingli on 16/7/6.
 */
public abstract class Command {
    final ProtoMessage message;
    final ChannelCache cache;
    final Channel sender;
    final RouterService routerService;
    private String[] cmds = null;

    public Command(final ProtoMessage message,final RouterService service,
                   final ChannelCache cache, final Channel sender) {
        this.message = message;
        this.cache = cache;
        this.sender = sender;
        this.routerService = service;
    }

    public void setArgs(String[] cmds){
        cmds = cmds;
    }

    abstract public void process();

}
