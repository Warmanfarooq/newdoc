//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.filters;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import android.util.Log;
import com.pdftron.common.PDFNetException;
import com.pdftron.filters.FileDescriptorFilterManager.a;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class SecondaryFileFilter extends CustomFilter {
    private static final String a = SecondaryFileFilter.class.getName();
    private Context b;
    private Uri c;
    private ParcelFileDescriptor d;
    private ParcelFileDescriptor e;
    private AutoCloseInputStream f;
    private AutoCloseOutputStream g;
    private long h;
    private boolean i;
    private int j;

    public SecondaryFileFilter(Context var1, Uri var2) throws PDFNetException, FileNotFoundException {
        this(var1, var2, 0);
    }

    public SecondaryFileFilter(Context var1, Uri var2, int var3) throws PDFNetException, FileNotFoundException {
        super(var3, var2);
        this.i = false;
        this.j = com.pdftron.filters.FileDescriptorFilterManager.a.a().b();
        this.b = var1;
        this.c = var2;
        this.d = var1.getContentResolver().openFileDescriptor(var2, "r");
        this.f = new AutoCloseInputStream(this.d);
        if (var3 != 0) {
            this.e = var1.getContentResolver().openFileDescriptor(var2, "rw");
            this.g = new AutoCloseOutputStream(this.e);
        }

    }

    public SecondaryFileFilter(int var1, SecondaryFileFilter var2) throws PDFNetException, IOException {
        super(var1, var2.c);
        this.i = false;
        this.j = com.pdftron.filters.FileDescriptorFilterManager.a.a().b();
        this.attached = var2;
        this.a(var2);
    }

    protected SecondaryFileFilter(long var1, SecondaryFileFilter var3) throws IOException {
        super(var1, var3);
        this.i = false;
        this.j = com.pdftron.filters.FileDescriptorFilterManager.a.a().b();
        this.a(var3);
    }

    private void a(SecondaryFileFilter var1) throws IOException {
        this.b = var1.b;
        this.c = var1.c;
        this.d = var1.d;
        this.f = var1.f;
        if (var1.e != null) {
            this.e = var1.e;
            this.g = var1.g;
        }

    }

    public static SecondaryFileFilter __Create(long var0, SecondaryFileFilter var2) throws IOException {
        return new SecondaryFileFilter(var0, var2);
    }

    public long size() throws PDFNetException {
        try {
            return this.f.getChannel().size();
        } catch (Exception var2) {
            var2.printStackTrace();
            return super.size();
        }
    }

    public long onRead(byte[] var1, Object var2) {
        try {
            if (!this.f.getChannel().isOpen()) {
                this.d = this.b.getContentResolver().openFileDescriptor(this.c, "r");
                this.f = new AutoCloseInputStream(this.d);
            }

            FileChannel var7;
            (var7 = this.f.getChannel()).position(this.h);
            ByteBuffer var5 = ByteBuffer.wrap(var1);
            int var6 = var7.read(var5);
            this.h = var7.position();
            return (long)var6;
        } catch (Exception var4) {
            Log.e(a, "onRead exception for filter #: " + this.getSequenceNumber());
            var4.printStackTrace();
            return -1L;
        }
    }

    public long onSeek(long var1, int var3, Object var4) {
        byte var6 = 0;

        try {
            if (var3 == 0) {
                this.h = var1 >= 0L ? var1 : 0L;
            } else if (var3 == 1) {
                this.h += var1;
            } else if (var3 == 2) {
                this.h = this.size() + var1;
            }
        } catch (Exception var5) {
            var5.printStackTrace();
            Log.e(a, "onSeek exception for filter #: " + this.getSequenceNumber());
            var6 = -1;
        }

        return (long)var6;
    }

    public long onTell(Object var1) {
        return this.h;
    }

    public long onFlush(Object var1) {
        if (this.g == null) {
            return 0L;
        } else {
            FileChannel var3 = this.g.getChannel();

            try {
                var3.truncate(this.h);
                return var3.size();
            } catch (Exception var2) {
                Log.e(a, "onFlush exception for filter #: " + this.getSequenceNumber());
                var2.printStackTrace();
                return -1L;
            }
        }
    }

    public long onWrite(byte[] var1, Object var2) {
        if (this.g == null) {
            return 0L;
        } else {
            try {
                ByteBuffer var4 = ByteBuffer.wrap(var1);
                FileChannel var6;
                (var6 = this.g.getChannel()).position(this.h);
                int var5 = var6.write(var4);
                this.h = var6.position();
                return (long)var5;
            } catch (Exception var3) {
                Log.e(a, "onWrite exception for filter #: " + this.getSequenceNumber());
                var3.printStackTrace();
                return -1L;
            }
        }
    }

    public long onTruncate(long var1, Object var3) {
        if (this.g == null) {
            return 0L;
        } else {
            FileChannel var5 = this.g.getChannel();

            try {
                var5.truncate(var1);
                return var5.size();
            } catch (Exception var4) {
                Log.e(a, "onTruncate exception for filter #: " + this.getSequenceNumber());
                var4.printStackTrace();
                return -1L;
            }
        }
    }

    public long onCreateInputIterator(Object var1) {
        try {
            return (new SecondaryFileFilter(this.b, this.c, 0)).__GetHandle();
        } catch (Exception var2) {
            Log.e(a, "onCreateInputIterator exception for filter #: " + this.j);
            var2.printStackTrace();
            return 0L;
        }
    }

    public SecondaryFileFilter createOutputIterator() {
        try {
            return new SecondaryFileFilter(this.b, this.c, 1);
        } catch (Exception var2) {
            Log.e(a, "createOutputIterator exception for filter #: " + this.getSequenceNumber());
            var2.printStackTrace();
            return null;
        }
    }

    public void onDestroy(Object var1) {
        if (this.attached == null) {
            this.close();
            this.impl = 0L;
            this.callback_data = 0L;
        }
    }

    public void close() {
        if (!this.i) {
            this.cleanup();
            this.i = true;
        }
    }

    public void cleanup() {
        try {
            if (this.g != null) {
                this.g.getChannel().close();
                this.g.close();
            }
        } catch (Exception var3) {
            Log.e(a, "close exception for filter #: " + this.getSequenceNumber());
            var3.printStackTrace();
        }

        try {
            this.f.close();
        } catch (Exception var2) {
            Log.e(a, "close exception for filter #: " + this.getSequenceNumber());
            var2.printStackTrace();
        }
    }

    public void force(boolean var1) throws IOException {
        if (this.e != null && this.g != null) {
            this.g.getChannel().force(var1);
            this.e.getFileDescriptor().sync();
        }

    }

    public String getSequenceNumber() {
        return "[" + this.j + "]";
    }

    public int getRawSequenceNumber() {
        return this.j;
    }
}
