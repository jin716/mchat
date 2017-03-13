package org.mchat.io.chatServer.router;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;

import java.util.concurrent.Callable;

/**
 * Created by jingli on 16/6/22.
 */
public class RouterWorker implements Callable {

    final Routable message;
    final Channel to;

    public RouterWorker(Routable message, Channel to) {
        this.message = message;
        this.to = to;
    }

    public ChannelFuture call() throws Exception {
        System.out.println("routerWorker:"+to+":"+message);
        if(to == null){
            return null;
        }
        return  to.writeAndFlush(message);
    }

}
