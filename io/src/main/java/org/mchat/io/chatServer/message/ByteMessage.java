package org.mchat.io.chatServer.message;

import org.mchat.io.chatServer.router.Routable;

/**
 * Created by jingli on 16/8/29.
 */
public class ByteMessage implements Routable {

    private byte[] data = null;
    long form;
    long to;

    public ByteMessage(byte[] bytes)  {
        this.data = bytes;

    }

    @Override
    public long getFrom() {
        return this.form;
    }

    @Override
    public long getto() {
        return this.to;
    }
}
