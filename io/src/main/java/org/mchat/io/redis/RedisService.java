package org.mchat.io.redis;

import org.mchat.io.ChatUtil;
import org.mchat.io.chatServer.ChatSubscribeListener;
import org.mchat.io.message.MessageBuf;
import redis.clients.jedis.Jedis;

/**
 * Created by jingli on 16/5/26.
 */
public class RedisService{

    private Jedis jedis = null;

    public RedisService(){
        this.jedis = new Jedis("120.24.63.70",6379);
    }

    public RedisService(Jedis jedis){
         this.jedis = jedis;
    }

    public Long speakTo(MessageBuf.Message message){
        String channel = ChatUtil.getRecieverChannel(message.getTo());
        return this.jedis.publish(channel.getBytes(), message.toByteArray());
    }

    public void subscribe(ChatSubscribeListener listener,String channel){
       this.jedis.subscribe(listener,channel.getBytes());
    }







}
