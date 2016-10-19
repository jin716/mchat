package org.mchat.io.chatServer.message;

import com.google.protobuf.InvalidProtocolBufferException;
import org.mchat.io.chatServer.message.Protobuf;
import org.mchat.io.chatServer.router.Routable;

/**
 * Created by jingli on 16/7/4.
 */
public class ProtoMessage implements Routable {

    final public Protobuf.Message data;

    public ProtoMessage(byte[] bytes) throws InvalidProtocolBufferException {
        this.data = Protobuf.Message.parseFrom(bytes);
    }

    public ProtoMessage(Protobuf.Message message){
         this.data = message;
    }


    @Override
    public Object getFrom() {
        return this.data.getFrom();
    }

    @Override
    public Object getto() {
        return this.data.getTo();
    }




}
