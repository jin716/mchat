package org.mchat.io.object;
import com.google.protobuf.ByteString;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mchat.io.message.MessageBuf;

import java.io.*;

/**
 * Created by jingli on 16/5/25.
 */
public class TestMessage {

  @Before
  public void setUp() {
      MessageBuf.Message message = MessageBuf.Message.newBuilder()
              .setFrom("jin")
              .setTo("ling")
              .setChatId("123123123")
              .setChatIdBytes(ByteString.copyFromUtf8("asdfadfjlkasdjfzjkcv")).build();
      byte[] b = message.toByteArray();
      for(byte bb : b){
          System.out.println(bb);
      }
      File file = new File("a.data");
      try {
          FileOutputStream writer = new FileOutputStream(file);
          writer.write(b);
          writer.flush();
          writer.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
  }

  @Test
  public void getFromFile(){
       File file1 = new File("a.data");
      try {
          FileInputStream in = new FileInputStream(file1);
          byte[]  bb =  new byte[in.available()];
          in.read(bb);
          in.close();
          MessageBuf.Message message1 = MessageBuf.Message.parseFrom(bb);
          Assert.assertEquals(message1.getFrom(), "jin");
      } catch (Exception e) {
          e.printStackTrace();
      }

  }






}
