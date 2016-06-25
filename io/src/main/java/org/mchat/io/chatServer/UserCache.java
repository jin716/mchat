package org.mchat.io.chatServer;

import io.netty.channel.Channel;
import org.mchat.io.chatServer.message.Message;
import org.mchat.util.StringUtil;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by jingli on 16/6/22.
 */
public class UserCache {

    final ConcurrentHashMap<String,Channel> hostChannelMap;
    final ConcurrentHashMap<Long,Channel> localUserChannelMap = new ConcurrentHashMap<Long, Channel>();
    final ConcurrentHashMap<Long,String> remoteUserHostMap= new ConcurrentHashMap<Long, String>();



    public UserCache(){
        hostChannelMap = new ConcurrentHashMap<String, Channel>();
    }

    public Channel getLocalUserChannel(Long user){
        return  localUserChannelMap.get(user);
    }

    public Channel getRemoteUserChannel(Long user){
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
