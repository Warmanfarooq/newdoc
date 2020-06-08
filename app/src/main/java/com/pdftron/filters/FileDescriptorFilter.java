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
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/** @deprecated */
public class FileDescriptorFilter extends CustomFilter {
    protected FileChannel mFileChannel;
    protected boolean mIsInputChannel;
    protected long mPosition;
    protected ParcelFileDescriptor mPfd;
    protected int mMySequenceNumber;
    protected FileDescriptorFilterManager mFilterManager;
    protected int mMode;
    protected FileLock mLock;
    public static final String TAG = "SaveFilter";

    public FileDescriptorFilter(int var1, ParcelFileDescriptor var2) throws PDFNetException {
        super(var1, var2);
        this.mPfd = var2;
        this.mMode = var1;
        FileInputStream var3 = new FileInputStream(var2.getFileDescriptor());
        this.mFileChannel = var3.getChannel();
        this.mLock = null;
        this.mIsInputChannel = true;
        this.mFilterManager = new FileDescriptorFilterManager();
        this.mMySequenceNumber = this.mFilterManager.getNewSequenceNumber();
        Log.d("SaveFilter", this.mMySequenceNumber + ": create FileDescriptorFilter in Input mode, actual mode: " + a(var1));
        if (!this.mFileChannel.isOpen()) {
            Log.d("SaveFilter", this.mMySequenceNumber + ": create FileDescriptorFilter file channel closed!!!");
        }

        if (var1 == 0) {
            this.mFilterManager.addReadFilter(this);
        } else {
            if (var1 == 1) {
                this.mFilterManager.addReadWriteFilter(this);
            }

        }
    }

    public FileDescriptorFilter(int var1, FileDescriptorFilter var2) throws PDFNetException {
        super(var1, var2.mPfd);
        this.mPfd = var2.mPfd;
        this.mMode = var1;
        this.mFileChannel = var2.mFileChannel;
        this.mIsInputChannel = var2.mIsInputChannel;
        this.mFilterManager = var2.mFilterManager;
        this.mMySequenceNumber = this.mFilterManager.getNewSequenceNumber();
        this.mLock = var2.mLock;
        if (!this.mIsInputChannel) {
            try {
                Log.d("SaveFilter", this.mMySequenceNumber + ": FileDescriptorFilter copy READ mode close output");
                this.mFileChannel.close();
                FileInputStream var4 = new FileInputStream(this.mPfd.getFileDescriptor());
                this.mFileChannel = var4.getChannel();
                this.mLock = null;
                this.mIsInputChannel = true;
            } catch (IOException var3) {
                var3.printStackTrace();
            }
        }

        Log.d("SaveFilter", this.mMySequenceNumber + ": copy FileDescriptorFilter in Input mode, actual mode: " + a(var1));
        if (!this.mFileChannel.isOpen()) {
            Log.e("SaveFilter", this.mMySequenceNumber + ": copy FileDescriptorFilter file channel closed!!!");
        }

        if (var1 == 0) {
            this.mFilterManager.addReadFilter(this);
        } else {
            if (var1 == 1) {
                this.mFilterManager.addReadWriteFilter(this);
            }

        }
    }

    private static String a(int var0) {
        return var0 == 0 ? "READ" : "WRITE";
    }

    protected FileDescriptorFilter(long var1, FileDescriptorFilter var3) {
        super(var1, (Filter)null);
        this.mPfd = var3.mPfd;
        this.mMode = var3.mMode;
        this.mFileChannel = var3.mFileChannel;
        this.mIsInputChannel = var3.mIsInputChannel;
        this.mFilterManager = var3.mFilterManager;
        this.mMySequenceNumber = var3.mMySequenceNumber;
        this.mLock = var3.mLock;
    }

    public static FileDescriptorFilter __Create(long var0, FileDescriptorFilter var2) {
        return new FileDescriptorFilter(var0, var2);
    }

    public void destroy() throws PDFNetException {
    }

    public int getThreadId() {
        return Process.getThreadPriority(Process.myTid());
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
                this.mFileChannel.position(0L);
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
                this.mPosition += var1;
            } else if (var3 == 2) {
                this.mPosition = this.mFileChannel.size() + var1;
            }

            this.mFileChannel.position(this.mPosition);
            this.mFileChannel.position(0L);
        } catch (Exception var5) {
            var6 = -1;
            Log.e("SaveFilter", this.mMySequenceNumber + ": save FileDescriptorFilter onSeek ERROR: " + this.getThreadId() + "| isInputFilter:" + (this.mMode == 0));
            var5.printStackTrace();
        }

        return (long)var6;
    }

    public long onTell(Object var1) {
        return this.mPosition;
    }

    public long onTruncate(long var1, Object var3) {
        this.switchToWriteMode();
        if (this.mLock != null && !this.mIsInputChannel) {
            try {
                if (this.mPosition > var1) {
                    this.mPosition = var1;
                }

                this.mFileChannel.truncate(var1);
                this.mFileChannel.position(0L);
                return this.mFileChannel.size();
            } catch (IOException var4) {
                var4.printStackTrace();
            }
        }

        return 0L;
    }

    public long onFlush(Object var1) {
        long var2 = -1L;
        if (this.mLock != null) {
            Log.d("SaveFilter", this.mMySequenceNumber + ":" + this.getThreadId() + ": FileDescriptorFilter onFlush position: " + this.mPosition + " | mIsInputChannel: " + this.mIsInputChannel);

            try {
                this.mFileChannel.truncate(this.mPosition);
                var2 = 0L;
            } catch (IOException var6) {
                Log.e("SaveFilter", var6.getMessage());
            } finally {
                this.mFilterManager.releaseLock();
                Log.d("SaveFilter", this.mMySequenceNumber + ":" + this.getThreadId() + ": onFlush releaseLock");
            }
        }

        return var2;
    }

    public long onWrite(byte[] var1, Object var2) {
        ByteBuffer var4 = ByteBuffer.wrap(var1);
        this.switchToWriteMode();
        if (this.mLock != null && !this.mIsInputChannel) {
            try {
                this.mFileChannel.position(this.mPosition);
                int var5 = this.mFileChannel.write(var4);
                this.mPosition = this.mFileChannel.position();
                return (long)var5;
            } catch (IOException var3) {
                var3.printStackTrace();
            }
        }

        return 0L;
    }

    public boolean switchToWriteMode() {
        if (this.mIsInputChannel) {
            try {
                this.mFileChannel.close();
                FileOutputStream var1 = new FileOutputStream(this.mPfd.getFileDescriptor());
                this.mFileChannel = var1.getChannel();

                try {
                    this.mLock = this.mFileChannel.lock();
                } catch (IOException var2) {
                    this.mLock = null;
                    var2.printStackTrace();
                }

                if (!this.mFilterManager.acquireLock()) {
                    this.mLock = null;
                }

                this.mIsInputChannel = false;
            } catch (IOException var3) {
                var3.printStackTrace();
            }
        }

        return !this.mIsInputChannel;
    }

    public long onCreateInputIterator(Object var1) {
        Log.d("SaveFilter", this.mMySequenceNumber + ":" + this.getThreadId() + ": FileDescriptorFilter onCreateInputIterator position: " + this.mPosition);

        try {
            FileDescriptorFilter var3 = new FileDescriptorFilter(0, this);
            this.callback_data = var3.callback_data;
            this.mPfd = var3.mPfd;
            this.mMode = var3.mMode;
            this.mFileChannel = var3.mFileChannel;
            this.mIsInputChannel = var3.mIsInputChannel;
            this.mFilterManager = var3.mFilterManager;
            this.mMySequenceNumber = var3.mMySequenceNumber;
            this.mLock = var3.mLock;
            return var3.__GetHandle();
        } catch (Exception var2) {
            var2.printStackTrace();
            return 0L;
        }
    }

    public void onDestroy(Object var1) {
        try {
            if (this.mMode == 0) {
                this.mFilterManager.removeReadFilter(this);
            } else {
                this.mFilterManager.removeReadWriteFilter(this);
            }

            this.impl = 0L;
            this.callback_data = 0L;
        } catch (Exception var2) {
            var2.printStackTrace();
        }
    }

    public FileDescriptorFilter createOutputIterator() {
        try {
            if (this.mFileChannel == null) {
                Log.e("SaveFilter", this.mMySequenceNumber + ":" + this.getThreadId() + ": FileDescriptorFilter createOutputIterator: FileChannel IS NULL!!!");
            }

            if (this.mFileChannel != null && !this.mFileChannel.isOpen()) {
                Log.e("SaveFilter", this.mMySequenceNumber + ":" + this.getThreadId() + ": FileDescriptorFilter createOutputIterator: FileChannel IS CLOSED!!!");
            }

            FileDescriptorFilter var1;
            (var1 = new FileDescriptorFilter(1, this.mPfd)).seek(0L, 2);
            Log.d("SaveFilter", this.mMySequenceNumber + ": FileDescriptorFilter createOutputIterator: " + var1.mMySequenceNumber + " | position: " + var1.mPosition);
            return var1;
        } catch (Exception var2) {
            var2.printStackTrace();
            return null;
        }
    }

    public boolean canWriteOnInputFilter() {
        return true;
    }

    public void close() {
        this.mFilterManager.cleanup();

        try {
            this.mPfd.close();
            Log.d("SaveFilter", this.mMySequenceNumber + ": FileDescriptorFilter close ParcelFileDescriptor");
        } catch (Exception var2) {
            var2.printStackTrace();
        }
    }
}
