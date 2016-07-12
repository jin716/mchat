package org.mchat.io.chatServer.command;


import io.netty.channel.Channel;
import org.mchat.io.chatServer.ChannelCache;
import org.mchat.io.chatServer.message.Message;
import org.mchat.io.chatServer.message.Protobuf.Message.Type;



/**
 * Created by jingli on 16/7/6.
 */
public class CommandFactroy {

    static public Command getInstance(Message message,ChannelCache cache, Channel replyTo){
        Type type = message.data.getType();
        if(type == Type.ACK){
            if(message.data.getFlag() == 1){
                return new SCRegisterPong(message,cache, replyTo);
            }
            return null;//default;
        }
        return null;
    }
}
