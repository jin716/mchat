package org.mchat.io.chatServer;

import io.netty.channel.Channel;
import org.mchat.io.chatServer.message.Message;
import org.mchat.util.StringUtil;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by jingli on 16/6/22.
 */
public class BigPool {

    final LinkedBlockingQueue<Message> messageQueue;
    final ConcurrentHashMap<String,Channel> hostChannelMap;
    final ConcurrentHashMap<Long,Channel> localUserChannelMap;
    final ConcurrentHashMap<Long,String> remoteUserHostMap;



    public BigPool(){
        this.messageQueue = new LinkedBlockingQueue();
        hostChannelMap = new ConcurrentHashMap<String, Channel>();
        localUserChannelMap = new ConcurrentHashMap<Long, Channel>();
        remoteUserHostMap = new ConcurrentHashMap<Long, String>();
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

    public LinkedBlockingQueue<Message> getMessageQueue(){ return this.messageQueue;}


    public Channel getChannel(String host,int port){
        String key = StringUtil.hostKey(host, port);
        return  hostChannelMap.get(key);
    }

    public Channel getChannel(String host, String port) {
        String key = StringUtil.hostKey(host, port);
        return  hostChannelMap.get(key);
    }



}
