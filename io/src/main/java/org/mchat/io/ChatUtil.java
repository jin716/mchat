package org.mchat.io;

import static org.mchat.io.redis.RedisKeyNaming.*;

/**
 * Created by jingli on 16/5/26.
 */
public class ChatUtil {



    /**
     *
     * @param from
     * @param to
     * @return
     */
    public static String getChatChannel(String from, String to){
         return CHAT_CHANNEL_HEADER + (from.compareTo(to) > 0  ? from+to : to + from);
    }

    public static String getRecieverChannel(String to){
        return CHAT_RECIEVER_CHANNEL_HEADER + to;
    }
}
