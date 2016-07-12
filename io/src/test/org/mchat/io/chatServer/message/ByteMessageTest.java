package org.mchat.io.chatServer.message;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import junit.framework.TestCase;

/**
 * Created by jingli on 16/6/26.
 */
public class ByteMessageTest  extends TestCase {


    @Override
    protected void setUp() throws Exception {


    }

    public void testRouterByteBuf() {
        ByteBuf bb = Unpooled.directBuffer(500);
        System.out.println(bb.refCnt());
        bb.setInt(0,500);
        bb.setByte(32,1);
        bb.setLong(40,001);
        bb.setLong(104,002);
        bb.setBytes(216,new String("hello world").getBytes());
        ByteMessage message = new ByteMessage(bb);
        assertEquals(message.getFrom().longValue(),(long)001);
        assertEquals(message.getto().longValue(),(long)002);

        bb.resetReaderIndex();
        byte[] b = new byte[bb.capacity()];
        bb.setBytes(0,b);
        for(int i = 0 ; i < b.length; ++i){
            if(i == 32 || i == 40 || i == 104 || i == 216)
                System.out.println();
            System.out.print(bb.readByte());
        }
        bb.release();
    }



    // 在每个Test运行之后运行
    @Override
    protected void tearDown() throws Exception {
    }
}
