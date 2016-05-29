package org.mchat.io.message;
import static org.mchat.io.message.MessageFlagCodeNaming.*;

/**
 * Created by jingli on 16/5/28.
 */
public class ServerMessageBuilder {

    /**
     * 按以原报文为模板,去掉data字段所包含的数据,按flag创建错误回复报文
     */
    static public MessageBuf.Message buildErrorMessage(MessageBuf.Message message, int flag){
        return MessageBuf.Message.newBuilder()
                .setChatId(message.getChatId())
                .setFrom(message.getFrom())
                .setTo(message.getTo())
                .setChatId(message.getChatId())
                .setLength(message.getLength())
                .setType(MessageBuf.Message.MessageType.ERROR)
                .setFlag(flag)
                .build();
    }

    /**
     * 按以原报文为模板,去掉data字段所包含的数据,按flag创建回复确认报文
     */
    static public MessageBuf.Message buildMessageAckMessage(MessageBuf.Message message, int flag){
        return MessageBuf.Message.newBuilder()
                .setChatId(message.getChatId())
                .setFrom(message.getFrom())
                .setTo(message.getTo())
                .setChatId(message.getChatId())
                .setLength(message.getLength())
                .setType(MessageBuf.Message.MessageType.ACK)
                .setFlag(flag)
                .build();
    }

    /**
     * 生成客户端成功连上服务的确认信息
     */
    static public MessageBuf.Message buildServerAckMessage(int flag){
        return MessageBuf.Message.newBuilder()
                .setFrom(SERVER_NAME)
                .setType(MessageBuf.Message.MessageType.ACK)
                .setFlag(flag)
                .build();
    }


}
