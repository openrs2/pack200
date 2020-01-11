package org.apache.harmony.unpack200;

import java.io.OutputStream;

public final class NullOutputStream extends OutputStream {
    public static final OutputStream INSTANCE = new NullOutputStream();

    private NullOutputStream() {
        /* empty */
    }

    @Override
    public void write(int i) {
        /* empty */
    }

    @Override
    public void write(byte[] b) {
        /* empty */
    }

    @Override
    public void write(byte[] b, int off, int len) {
        /* empty */
    }
}
