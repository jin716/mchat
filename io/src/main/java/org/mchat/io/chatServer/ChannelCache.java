package org.mchat.io.chatServer;

import io.netty.channel.Channel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import org.mchat.util.StringUtil;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jingli on 16/6/22.
 */
public class ChannelCache {

    final ConcurrentHashMap<String,Channel> hostChannelMap = new ConcurrentHashMap<String, Channel>();;
    final ConcurrentHashMap<Long,Channel> localUserChannelMap = new ConcurrentHashMap<Long, Channel>();
    final ConcurrentHashMap<Long,String> remoteUserHostMap= new ConcurrentHashMap<Long, String>();

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


    public Channel getLocalUserChannel(Long user){
        return  localUserChannelMap.get(user);
    }



    synchronized public void setLocalUserChannel(final Long user,final Channel channel){
        Long key = null;
        final Channel chan = localUserChannelMap.remove(user);
        if(chan != null)
            chan.close();
        localUserChannelMap.put(user,channel);
        channel.closeFuture().addListeners(new GenericFutureListener() {
                public void operationComplete(Future future) throws Exception {
                    localUserChannelMap.remove(user);}
        });
    }

    //todo
    //how to close better
    public void removeLocalUser(final Long user){
        final Channel chan = localUserChannelMap.remove(user);
        if(chan != null)
            chan.close();
    }

    public Channel getRemoteUserChannel(final Long user){
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
