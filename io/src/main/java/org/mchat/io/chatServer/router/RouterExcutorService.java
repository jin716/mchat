package org.mchat.io.chatServer.router;

import io.netty.channel.Channel;
import org.mchat.io.chatServer.BigPool;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jingli on 16/6/23.
 */
public class RouterExcutorService{

    static int THREADS_NUMBER_FACTOR = 4;

    private ExecutorService executor;

    private int size = 1;

    private Class<? extends Router>  routerClass = DefaultRouter.class;

    public RouterExcutorService(){
        int cores = Runtime.getRuntime().availableProcessors();
        this.size =  THREADS_NUMBER_FACTOR * cores;
        this.executor = Executors.newFixedThreadPool(size);
    }

    public RouterExcutorService(int factor){
        if(factor <=0 )  throw new IllegalArgumentException("factor must bigger than zero");
        int cores = Runtime.getRuntime().availableProcessors();
        this.size =  factor * cores;
        this.executor = Executors.newFixedThreadPool(size);
    }

    public RouterExcutorService router(Class<? extends Router> routerClass) {
        this.routerClass = routerClass;
        return this;
    }

    private List newRouters(BigPool pool, int length) throws Exception {
        List routers = new LinkedList();
        Constructor constructor = routerClass.getConstructor(BigPool.class);
        for(int i = 0 ; i < length ; ++i){
            routers.add(constructor.newInstance(pool));
        }
        return routers;
    }


    public void start(BigPool pool) throws Exception {
        List routers = newRouters(pool, this.size);
        try{
            executor.invokeAll(routers);
        }finally {
            if(this.executor!=null && !this.executor.isShutdown())
                this.executor.shutdown();
        }
    }




}
