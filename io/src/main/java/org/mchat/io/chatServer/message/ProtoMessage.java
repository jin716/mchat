package org.mchat.io.chatServer.message;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import org.mchat.io.chatServer.message.Protobuf;
import org.mchat.io.chatServer.router.Routable;

import java.util.List;

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
    public long getFrom() {
        return this.data.getFrom();
    }

    @Override
    public long getto() {
        return this.data.getTo();
    }

    public static void main(String[] args){
        String text = "test";
        Protobuf.Message message = Protobuf.Message.newBuilder()
                .setFrom(1234l)
                .setTo(4321l)
                .setType(Protobuf.Message.Type.CMD)
                .setText("login")
                .build();

        Protobuf.Parent parent = Protobuf.Parent.newBuilder().setMessage(message)
                .build();
                System.out.println(message);
        byte[] bb = message.toByteArray();
        for(byte b : bb){
            System.out.print(Integer.toBinaryString(b));
        }
        System.out.println();
        bb = parent.toByteArray();
        StringBuilder sb = new StringBuilder();
        for(byte b : bb){
            sb.append(b);
        }
        System.out.println(sb.toString());;
        System.out.println(sb.length());
    }


}
