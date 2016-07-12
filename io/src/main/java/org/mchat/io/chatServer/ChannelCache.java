package org.mchat.io.chatServer;

import io.netty.channel.Channel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import org.mchat.io.chatServer.router.RouterService;
import org.mchat.util.StringUtil;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by jingli on 16/6/22.
 */
public class ChannelCache<T> {

    final ConcurrentHashMap<String,Channel> hostChannelMap = new ConcurrentHashMap<String, Channel>();;
    final ConcurrentHashMap<T,Channel> localUserChannelMap = new ConcurrentHashMap<T, Channel>();
    final ConcurrentHashMap<T,String> remoteUserHostMap= new ConcurrentHashMap<T, String>();

    static private ChannelCache instance;


    /**
     * Thread safe TODO
     * @return
     */
    static public ChannelCache getInstance(){
        if(instance == null){
            instance = new ChannelCache();
            return instance;
        }
        return instance;
    }


    public Channel getLocalUserChannel(T user){
        return  localUserChannelMap.get(user);
    }

    public void setLocalUserChannel(final T user,final Channel channel){
        localUserChannelMap.put(user,channel);
        channel.closeFuture().addListeners(new GenericFutureListener() {
            @Override
            public void operationComplete(Future future) throws Exception {
                localUserChannelMap.remove(user);
            }
        });
    }

    public void removeLocalUser(final T user){
        final Channel chan = localUserChannelMap.remove(user);
        if(chan != null)
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Future close = chan.close();
                        close.get(5, TimeUnit.SECONDS); //Try to close
                    } catch (Exception e) {
                        return;
                    }
                }
            }).start();
    }

    public Channel getRemoteUserChannel(final T user){
        String hostKey = remoteUserHostMap.get(user);
        if(hostKey!=null)
            return hostChannelMap.get(hostKey);
        return null;
    }








    public Channel getBackUpChannel(){
        return  null;
    }



    public Channel getChannel(String host,int port){
        String key = StringUtil.hostKey(host, port);
        return  hostChannelMap.get(key);
    }

    public Channel getChannel(String host, String port) {
        String key = StringUtil.hostKey(host, port);
        return  hostChannelMap.get(key);
    }



}
