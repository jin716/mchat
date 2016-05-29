package org.mchat.io.message;

/**
 * Created by jingli on 16/5/28.
 */
public class MessageFlagCodeNaming {

    public final static  int ACK_OK = 200; //短信发送成功

    public final static  int SERVER_CONNECTED_OK = 201; //客户端连接服务已创建

    public final static  int SERVER_INNER_ERROR = 500;  //服务器内部错误

    public final static  int SERVER_ASK_ACK = 0;

    public final static  String SERVER_NAME = "mchat_server";
}
