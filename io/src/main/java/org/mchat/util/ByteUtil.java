package org.mchat.util;

/**
 * Created by jingli on 16/8/29.
 */
public class ByteUtil {

    public static long byteToLong(byte[] data){
        long tmp = 0;
        long res = 0;
        for(int i = 0 ; i < 8 ; ++i){
            res <<= 8;
            //tmp = data[i];
            tmp = data[i]&0xff;
            res |= tmp;
        }
        return res;
    }





}
