package org.mchat.io.chatServer.router;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.mchat.io.chatServer.ChannelCache;

import java.util.concurrent.*;

/**
 * Created by jingli on 16/6/23.
 */
public class RouterService<T> {

    static int THREADS_NUMBER_FACTOR = 20;
    int boss_thread = Runtime.getRuntime().availableProcessors();
    ExecutorService bossExecutor = Executors.newFixedThreadPool(boss_thread);
    ExecutorService workerExecutor;
    private int size = 1;
    final private ConcurrentLinkedQueue<Routable> messages;
    private ChannelCache cache;

    final ThreadFactory routerFactory =new ThreadFactoryBuilder()
            .setDaemon(true)
            .setNameFormat("router-%d")
            .build();


    public RouterService(){
        this(ChannelCache.getInstance(),new ConcurrentLinkedQueue<Routable>());
    }

    public RouterService(ConcurrentLinkedQueue<Routable> messages){
        this(ChannelCache.getInstance(),messages);
    }

    public RouterService(ChannelCache userCache,ConcurrentLinkedQueue<Routable> messages){
        this(THREADS_NUMBER_FACTOR,userCache,messages);
    }

    public RouterService(int factor,ChannelCache cache, ConcurrentLinkedQueue<Routable> messages){
        if(factor <=0 )  throw new IllegalArgumentException("factor must bigger than zero");
        int cores = Runtime.getRuntime().availableProcessors();
        this.size =  factor * cores;
        this.cache = cache;
        this.workerExecutor = getExecutor(size, Integer.MAX_VALUE, routerFactory);
        this.messages = messages;
    }



    private ExecutorService getExecutor(int size, int maximumPoolSize,ThreadFactory factory){
        return Executors.newCachedThreadPool(factory);
    }

    public void addMessage(Routable message){
        messages.add(message);
    }



    public void startService() throws Exception {
        for(int i = 0 ; i < boss_thread ; ++i){
            bossExecutor.submit(new RouterBoss(messages, cache, workerExecutor));
        }
    }





}
