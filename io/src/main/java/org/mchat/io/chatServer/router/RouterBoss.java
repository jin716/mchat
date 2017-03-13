package org.mchat.io.chatServer.router;

import io.netty.channel.Channel;
import org.mchat.io.chatServer.ChannelCache;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;

/**
 * Created by jingli on 16/6/30.

 */
public class RouterBoss<T> implements Callable {

    private ConcurrentLinkedQueue<Routable> messages;
    private ChannelCache userCache;
    private ExecutorService executor;

    public RouterBoss(ConcurrentLinkedQueue<Routable> messages,
                      ChannelCache userCache,
                      ExecutorService executor){
        this.messages = messages;
        this.userCache = userCache;
        this.executor = executor;
    }

    public Object call() throws Exception {
        while (true) {
            Routable message = messages.poll();
            Channel to = getTo(message,this.userCache);
            executor.submit(new RouterWorker(message,to));
        }
    }


    public Channel getTo(Routable message, ChannelCache cache){
        long key = message.getto();
        Channel ch = cache.getLocalUserChannel(key);
        if(ch==null)
            ch = cache.getBackUpChannel();
        return ch;
    }
}
