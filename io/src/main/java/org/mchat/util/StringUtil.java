package org.mchat.util;

/**
 * Created by jingli on 16/6/22.
 */
public class StringUtil {

    static ThreadLocal<StringBuilder> stringbuilder = new ThreadLocal<StringBuilder>();

    static public StringBuilder stringBuilder(){
        StringBuilder builder = stringbuilder.get();
        if(builder == null){
            builder = new StringBuilder(256);
            stringbuilder.set(builder);
        }
        builder.setLength(0);
        return builder;
    }


    public static String hostKey(String host,int port){
        return StringUtil.stringBuilder().append(host).append(":").append(port).toString();
    }

    public static String hostKey(String host,String port){
        return StringUtil.stringBuilder().append(host).append(":").append(port).toString();
    }
}
