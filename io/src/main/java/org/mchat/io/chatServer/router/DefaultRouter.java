package org.mchat.io.chatServer.router;

import io.netty.channel.Channel;
import org.mchat.io.chatServer.message.Message;
import org.mchat.io.chatServer.BigPool;

/**
 * Created by jingli on 16/6/23.
 */
public class DefaultRouter extends Router {

    public DefaultRouter(BigPool pool) {
        super(pool);
    }

    void forward(Message message){
        long to = message.getto();
        Channel channel = pool.getLocalUserChannel(to);
        if(channel == null)
            channel = pool.getRemoteUserChannel(to);
        if(channel == null)
            channel = pool.getBackUpChannel();
        if(channel == null)
            throw new RuntimeException("fetal error , no channel is available");
        channel.writeAndFlush(message);
    }
}
