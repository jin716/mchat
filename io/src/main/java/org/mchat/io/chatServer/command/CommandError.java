package org.mchat.io.chatServer.command;

/**
 * Created by jingli on 16/9/28.
 */
public class CommandError extends Exception {

    public CommandError(){
        super();
    }

    public CommandError(String msg){
        super(msg);
    }
}
