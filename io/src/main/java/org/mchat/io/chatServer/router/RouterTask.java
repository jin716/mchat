package org.mchat.io.chatServer.router;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import org.mchat.io.chatServer.message.Message;
import org.mchat.io.chatServer.UserCache;

import java.util.concurrent.Callable;

/**
 * Created by jingli on 16/6/22.
 */
public class RouterTask implements Callable {

    final Message message;
    final Channel to;

    public RouterTask(Message message, Channel to) {
        this.message = message;
        this.to = to;
    }

    @Override
    public ChannelFuture call() throws Exception {
        ChannelFuture future = to.writeAndFlush(message);
        return future;
    }

}
