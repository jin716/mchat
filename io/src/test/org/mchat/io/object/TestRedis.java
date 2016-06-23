package org.mchat.io.object;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mchat.io.ChatUtil;
import org.mchat.io.message.MessageBuf;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by jingli on 16/5/27.
 */

public class TestRedis {


    JedisPool pool = null;
    Jedis  redis = null;


}
