//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.filters;

import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.util.Log;
import com.pdftron.common.PDFNetException;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/** @deprecated */
public class FileDescriptorReadOnlyFilter extends CustomFilter {
    protected FileChannel mFileChannel;
    protected boolean mIsInputChannel;
    protected long mPosition;
    protected ParcelFileDescriptor mPfd;
    protected int mMySequenceNumber;
    protected FileDescriptorFilterManager mFilterManager;
    protected int mMode;
    protected FileLock mLock;

    public FileDescriptorReadOnlyFilter(int var1, ParcelFileDescriptor var2) throws PDFNetException {
        super(var1, var2);
        this.mPfd = var2;
        this.mMode = var1;
        FileInputStream var3 = new FileInputStream(var2.getFileDescriptor());
        this.mFileChannel = var3.getChannel();
        this.mLock = null;
        this.mIsInputChannel = true;
        this.mFilterManager = new FileDescriptorFilterManager();
        this.mMySequenceNumber = this.mFilterManager.getNewSequenceNumber();
        Log.d("save CustomFilter", this.mMySequenceNumber + ": create FileDescriptorFilter in Input mode, actual mode: " + a(var1));
        if (!this.mFileChannel.isOpen()) {
            Log.d("save CustomFilter", this.mMySequenceNumber + ": create FileDescriptorFilter file channel closed!!!");
        }

        if (var1 == 0) {
            this.mFilterManager.addReadFilter(this);
        }

    }

    public FileDescriptorReadOnlyFilter(int var1, FileDescriptorReadOnlyFilter var2) throws PDFNetException {
        super(var1, var2.mPfd);
        this.mPfd = var2.mPfd;
        this.mMode = var1;
        this.mFilterManager = var2.mFilterManager;
        this.mMySequenceNumber = this.mFilterManager.getNewSequenceNumber();

        try {
            Log.d("save CustomFilter", this.mMySequenceNumber + ": FileDescriptorFilter copy READ mode close output");
            FileInputStream var4 = new FileInputStream(this.mPfd.getFileDescriptor());
            this.mFileChannel = var4.getChannel();
            this.mLock = null;
            this.mIsInputChannel = true;
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        Log.d("save CustomFilter", this.mMySequenceNumber + ": copy FileDescriptorFilter in Input mode, actual mode: " + a(var1));
        if (!this.mFileChannel.isOpen()) {
            Log.e("save CustomFilter", this.mMySequenceNumber + ": copy FileDescriptorFilter file channel closed!!!");
        }

        if (var1 == 0) {
            this.mFilterManager.addReadFilter(this);
        }

    }

    private static String a(int var0) {
        return var0 == 0 ? "READ" : "WRITE";
    }

    public long onRead(byte[] var1, Object var2) {
        try {
            ByteBuffer var6 = ByteBuffer.wrap(var1);
            if (!this.mIsInputChannel) {
                try {
                    this.mFileChannel.close();
                    this.mLock = null;
                    FileInputStream var7 = new FileInputStream(this.mPfd.getFileDescriptor());
                    this.mFileChannel = var7.getChannel();
                    this.mIsInputChannel = true;
                } catch (IOException var3) {
                    var3.printStackTrace();
                }
            }

            try {
                this.mFileChannel.position(this.mPosition);
                int var8 = this.mFileChannel.read(var6);
                this.mPosition = this.mFileChannel.position();
                return (long)var8;
            } catch (IOException var4) {
                var4.printStackTrace();
            }
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return 0L;
    }

    public long onSeek(long var1, int var3, Object var4) {
        byte var6 = 0;

        try {
            if (var3 == 0) {
                this.mPosition = var1 >= 0L ? var1 : 0L;
            } else if (var3 == 1) {
                this.mPosition = var1 + this.mFileChannel.position();
            } else if (var3 == 2) {
                this.mPosition = this.mFileChannel.size() + var1;
            }

            this.mFileChannel.position(this.mPosition);
        } catch (Exception var5) {
            var6 = -1;
            Log.e("save CustomFilter", this.mMySequenceNumber + ": save FileDescriptorFilter onSeek ERROR: " + Process.getThreadPriority(Process.myTid()) + "| isInputFilter:" + (this.mMode == 0));
            var5.printStackTrace();
        }

        return (long)var6;
    }

    public long onTell(Object var1) {
        long var2 = -1L;

        try {
            var2 = this.mFileChannel.position();
        } catch (IOException var4) {
            var4.printStackTrace();
        }

        return var2;
    }

    public long onFlush(Object var1) {
        Log.e("save CustomFilter", this.mMySequenceNumber + ": onFlush on ReadOnly filter:  " + Process.getThreadPriority(Process.myTid()) + "| isInputFilter:" + (this.mMode == 0));
        return 0L;
    }

    public long onWrite(byte[] var1, Object var2) {
        Log.e("save CustomFilter", this.mMySequenceNumber + ": onWrite on ReadOnly filter:  " + Process.getThreadPriority(Process.myTid()) + "| isInputFilter:" + (this.mMode == 0));
        return 0L;
    }

    public long onCreateInputIterator(Object var1) {
        Log.d("save CustomFilter", this.mMySequenceNumber + ":" + Process.getThreadPriority(Process.myTid()) + ": FileDescriptorFilter onCreateInputIterator position: " + this.mPosition);

        try {
            return (new FileDescriptorReadOnlyFilter(0, this)).__GetHandle();
        } catch (Exception var2) {
            var2.printStackTrace();
            return 0L;
        }
    }

    public void onDestroy(Object var1) {
        try {
            if (this.mMode == 0) {
                this.mFilterManager.removeReadFilter(this);
            }

            this.impl = 0L;
            this.callback_data = 0L;
        } catch (Exception var2) {
            var2.printStackTrace();
        }
    }

    public void close() {
        this.mFilterManager.cleanup();

        try {
            this.mPfd.close();
            Log.d("save CustomFilter", this.mMySequenceNumber + ": FileDescriptorFilter close ParcelFileDescriptor");
        } catch (Exception var2) {
            var2.printStackTrace();
        }
    }
}
