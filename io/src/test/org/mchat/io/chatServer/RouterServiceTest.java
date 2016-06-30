package org.mchat.io.chatServer;

import io.netty.channel.Channel;
import io.netty.channel.embedded.EmbeddedChannel;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;
import org.junit.Assert;
import org.mchat.io.chatServer.router.RouterService;

/**
 * Created by jingli on 16/6/24.
 */
public class RouterServiceTest extends TestCase {

    UserCache userCache = new UserCache();
    RouterService routerService = new RouterService(userCache);
    EmbeddedChannel[] channels;

    @Override
    protected void setUp() throws Exception {
        int users_size = 10;
        for(int i = 0 ; i < users_size ; ++i){
            channels[i] = new EmbeddedChannel();
        }
        for(int i = 0 ; i < users_size ; ++i){
            userCache.setLocalUserChannel(new Long(i),channels[i]);
        }


    }

    public void testSendLocal() {

    }

    // 在每个Test运行之后运行
    @Override
    protected void tearDown() throws Exception {
    }


}
