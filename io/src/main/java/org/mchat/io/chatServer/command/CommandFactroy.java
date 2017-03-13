package org.mchat.io.chatServer.command;


import com.google.protobuf.ByteString;
import io.netty.channel.Channel;
import org.mchat.io.chatServer.ChannelCache;
import org.mchat.io.chatServer.message.ProtoMessage;
import org.mchat.io.chatServer.message.Protobuf.Message.Type;
import org.mchat.io.chatServer.router.RouterService;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;


/**
 * Created by jingli on 16/7/6.
 */
public class CommandFactroy {

    final static public String CLASS_PACKAGE = "org.mchat.io.chatServer.command";

    static public Command getInstance(ProtoMessage message,
                                      ChannelCache cache,
                                      Channel replyTo,
                                      RouterService service){
        Type type = message.data.getType();
        if(type == Type.CMD){
            String cmd = message.data.getText();
            if(cmd == null) return null;
            String[] cmds = cmd.split(" ");
            String className = CommandFactroy.class.getPackage().getName() +
                    "."+cmds[0].substring(0, 1).toUpperCase() + cmds[0].substring(1);
            try {
                Command command = (Command) Class.forName(className).getConstructor()
                        .newInstance(message,service, cache,replyTo);
                command.setArgs(cmds);
                return command;
            }catch (Exception e) {
               return null;
            }

        }
        return null;
    }

    public static void main(String[] args){
        String[] ars = {"1","bb","cc"};
        String[] args2 = Arrays.copyOfRange(ars,1,3);
        for(String s : args2){
            System.out.println(s);
        };
    }
}
