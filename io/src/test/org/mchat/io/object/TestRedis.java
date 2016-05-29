package org.mchat.io.object;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mchat.io.ChatUtil;
import org.mchat.io.chatServer.ChatSubscribeListener;
import org.mchat.io.message.MessageBuf;
import org.mchat.io.redis.RedisService;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by jingli on 16/5/27.
 */

public class TestRedis {


    JedisPool pool = null;
    Jedis  redis = null;
    RedisService service = null;


    @Before
    public void setUp() {
        JedisPoolConfig config = new JedisPoolConfig();
        this.pool = new JedisPool(config, "120.24.63.70", 6379, 10000, "123qwe");
        this.redis = this.pool.getResource();
        MessageBuf.Message message = MessageBuf.Message.newBuilder()
                .setFrom("jin")
                .setTo("ling")
                .setChatId("123123123")
                .setChatIdBytes(ByteString.copyFromUtf8("asdfadfjlkasdjfzjkcv")).build();
        byte[] b = message.toByteArray();
        for(byte bb: b){
            System.out.print(bb);
        }
        System.out.println();
        service =  new RedisService(this.redis);
        this.redis.set("jin".getBytes(), b);
        this.redis.publish("jin".getBytes(),b);
    }

    @Test
    public void testMessage(){
        String channel = ChatUtil.getRecieverChannel("ling");
        byte[] b = redis.get("jin".getBytes());
        //byte[] bb = redis.subscribe(new ChatSubscribeListener(),"jin".getBytes());
        try {
            Assert.assertEquals("jin", MessageBuf.Message.parseFrom(b).getFrom()) ;
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }

}
