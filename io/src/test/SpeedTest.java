import io.netty.buffer.ByteBuf;
import io.netty.buffer.UnpooledByteBufAllocator;
import junit.framework.TestCase;
import org.mchat.io.chatServer.router.Routable;
import org.mchat.util.Time;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by jingli on 16/7/4.
 */
public class SpeedTest  extends TestCase {

    int size = 20000000;
    Random random = new Random();

    //200000 19millis

    List<ByteMessage>  bytes = new ArrayList<ByteMessage>(size);
    List<MessageBuf.Message>  protos = new ArrayList<MessageBuf.Message>(size);


    @Override
    protected void setUp() throws Exception {
        for(int i = 0 ; i < 200000 ; i++ ){
            ByteBuf b =  UnpooledByteBufAllocator.DEFAULT.buffer(500);
            b.setLong(40, random.nextLong());
            b.setLong(104,random.nextLong());
            bytes.add(new ByteMessage(b));
            protos.add(MessageBuf.Message.newBuilder().setFrom(random.nextLong())
                    .setTo(random.nextLong()).build().);
        }
    }

    public void testSpeed() {
        Time time = new Time();



        time.reset();
        time.point();
        for(Routable r:bytes){
            r.getFrom() ;
            r.getto();
        }
        time.point();
        System.out.println("byte " + bytes.size() + " "+ time.toString());


        time.reset();
        time.point();
        for(MessageBuf.Message r:protos){
            r.getFrom() ;
            r.getTo();
        }
        time.point();
        System.out.println("buff " + protos.size() + " "+ time.toString());



    }

    @Override
    protected void tearDown() throws Exception {
        for(ByteMessage r:bytes){
            r.release();
        }
        bytes.clear();
        protos.clear();
    }
}
