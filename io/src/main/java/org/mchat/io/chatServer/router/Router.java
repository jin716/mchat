package org.mchat.io.chatServer.router;

import org.mchat.io.chatServer.message.Message;
import org.mchat.io.chatServer.BigPool;

import java.util.concurrent.Callable;

/**
 * Created by jingli on 16/6/22.
 */
public abstract class Router implements Callable<java.lang.Boolean> {

    final BigPool pool;
    private boolean state;

    public Router(BigPool pool){
          this.pool = pool;
          state = true;
    }

    @Override
    public java.lang.Boolean call() throws Exception {
        while(state){
            Message message = pool.getMessageQueue().take();
            if(message != null){
                forward(message);
            }
        }
        return true;
    }

    abstract void forward(Message message);
}
