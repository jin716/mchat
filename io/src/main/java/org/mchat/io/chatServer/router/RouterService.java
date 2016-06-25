package org.mchat.io.chatServer.router;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.netty.channel.Channel;
import org.mchat.io.chatServer.UserCache;
import org.mchat.io.chatServer.message.Message;

import java.util.concurrent.*;

/**
 * Created by jingli on 16/6/23.
 */
public class RouterService {

    static int THREADS_NUMBER_FACTOR = 20;

    private ExecutorService executor;

    private int size = 1;

    private ConcurrentLinkedQueue<Message> messages = new ConcurrentLinkedQueue<Message>();

    private UserCache userCache;

    final ThreadFactory routerFactory =new ThreadFactoryBuilder()
            .setDaemon(true)
            .setNameFormat("router-%d")
            .build();


    public RouterService(UserCache userCache){
        this(THREADS_NUMBER_FACTOR,userCache);
    }

    public RouterService(int factor,UserCache userCache){
        if(factor <=0 )  throw new IllegalArgumentException("factor must bigger than zero");
        int cores = Runtime.getRuntime().availableProcessors();
        this.size =  factor * cores;
        this.userCache = userCache;
        this.executor = getExecutor(size, Integer.MAX_VALUE, routerFactory);
    }

    private ExecutorService getExecutor(int size, int maximumPoolSize,ThreadFactory factory){
        return Executors.newCachedThreadPool(factory);
    }



    public void begin(UserCache pool) throws Exception {
        try{
            while (true) {
                Message message = messages.poll();
                Channel to = getTo(message,this.userCache);
                executor.submit(new RouterTask(message,to));
            }
        }finally {
            if(this.executor!=null && !this.executor.isShutdown())
                this.executor.shutdown();
        }
    }

    public Channel getTo(Message message, UserCache cache){
        Long key = message.getto();
        Channel ch = cache.getLocalUserChannel(key);
        if(ch==null)
               ch =  cache.getRemoteUserChannel(key);
        if(ch==null)
               ch = cache.getBackUpChannel();
        return ch;
    }



}
