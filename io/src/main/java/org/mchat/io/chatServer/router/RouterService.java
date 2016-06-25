package org.mchat.io.chatServer.router;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.mchat.io.chatServer.UserCache;
import org.mchat.io.chatServer.message.Message;

import java.lang.reflect.Constructor;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by jingli on 16/6/23.
 */
public class RouterService {

    static int THREADS_NUMBER_FACTOR = 4;

    private ExecutorService executor;

    private int size = 1;

    private ConcurrentLinkedQueue<Message> messages = new ConcurrentLinkedQueue<Message>();

    final ThreadFactory routerFactory =new ThreadFactoryBuilder()
            .setDaemon(true)
            .setNameFormat("router-%d")
            .build();


    private Class<? extends Router>  routerClass = DefaultRouter.class;

    public RouterService(){
        int cores = Runtime.getRuntime().availableProcessors();
        size =  THREADS_NUMBER_FACTOR * cores;
        this.executor = getExecutor(size,Integer.MAX_VALUE,routerFactory);
    }

    public RouterService(int factor){
        if(factor <=0 )  throw new IllegalArgumentException("factor must bigger than zero");
        int cores = Runtime.getRuntime().availableProcessors();
        this.size =  factor * cores;
        this.executor = getExecutor(size, Integer.MAX_VALUE, routerFactory);
    }

    private ExecutorService getExecutor(int size, int maximumPoolSize,ThreadFactory factory){
        return Executors.newCachedThreadPool(factory);
    }



    public RouterService router(Class<? extends Router> routerClass) {
        this.routerClass = routerClass;
        return this;
    }

    private List newRouters(UserCache pool, int length) throws Exception {
        List routers = new LinkedList();
        Constructor constructor = routerClass.getConstructor(UserCache.class);
        for(int i = 0 ; i < length ; ++i){
            routers.add(constructor.newInstance(pool));
        }
        return routers;
    }


    public void begin(UserCache pool) throws Exception {
        List routers = newRouters(pool, this.size);
        try{
            executor.invokeAll(routers);
        }finally {
            if(this.executor!=null && !this.executor.isShutdown())
                this.executor.shutdown();
        }
    }




}
