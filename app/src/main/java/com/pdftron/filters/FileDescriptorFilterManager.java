//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.filters;

import android.util.Log;
import android.util.SparseArray;
import java.nio.channels.FileChannel;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FileDescriptorFilterManager {
    private boolean a = false;
    private SparseArray<CustomFilter> b;
    private final Lock c;

    public FileDescriptorFilterManager() {
        new Semaphore(1, true);
        this.c = new ReentrantLock();
        this.b = new SparseArray();
    }

    public boolean acquireLock() {
        Log.d("SaveFilterManager", "acquireLock");
        this.c.lock();
        this.a = true;
        return true;
    }

    public void releaseLock() {
        if (this.a) {
            Log.d("SaveFilterManager", "releaseLock");
            this.a = false;
            this.c.unlock();
        }

    }

    public int getNewSequenceNumber() {
        synchronized(this) {
            return FileDescriptorFilterManager.a.a().b.incrementAndGet();
        }
    }

    public void addReadFilter(CustomFilter var1) {
        synchronized(this) {
            this.a(var1);
        }
    }

    public void removeReadFilter(CustomFilter var1) {
        synchronized(this) {
            this.b(var1);
        }
    }

    public void addReadWriteFilter(CustomFilter var1) {
        synchronized(this) {
            this.a(var1);
        }
    }

    public void removeReadWriteFilter(CustomFilter var1) {
        synchronized(this) {
            this.b(var1);
        }
    }

    public void cleanup() {
        for(int var1 = 0; var1 < this.b.size(); ++var1) {
            CustomFilter var2 = (CustomFilter)this.b.valueAt(var1);
            FileChannel var3 = null;
            int var4 = -1;
            if (var2 instanceof FileDescriptorFilter) {
                var3 = ((FileDescriptorFilter)var2).mFileChannel;
                var4 = ((FileDescriptorFilter)var2).mMySequenceNumber;
            } else if (var2 instanceof FileDescriptorReadOnlyFilter) {
                var3 = ((FileDescriptorReadOnlyFilter)var2).mFileChannel;
                var4 = ((FileDescriptorReadOnlyFilter)var2).mMySequenceNumber;
            }

            if (var3 != null) {
                try {
                    if (var3.isOpen()) {
                        var3.close();
                        Log.d("SaveFilterManager", var4 + ": FileDescriptorFilter close FileChannel");
                    }
                } catch (Exception var5) {
                    var5.printStackTrace();
                }
            }
        }

    }

    private void a(CustomFilter var1) {
        synchronized(this) {
            int var3 = -1;
            if (var1 instanceof FileDescriptorFilter) {
                var3 = ((FileDescriptorFilter)var1).mMySequenceNumber;
            } else if (var1 instanceof FileDescriptorReadOnlyFilter) {
                var3 = ((FileDescriptorReadOnlyFilter)var1).mMySequenceNumber;
            }

            if (var3 >= 0) {
                this.b.put(var3, var1);
            }

        }
    }

    private void b(CustomFilter var1) {
        FileChannel var2 = null;
        int var3 = 0;
        if (var1 instanceof FileDescriptorFilter) {
            var2 = ((FileDescriptorFilter)var1).mFileChannel;
            var3 = ((FileDescriptorFilter)var1).mMySequenceNumber;
        } else if (var1 instanceof FileDescriptorReadOnlyFilter) {
            var2 = ((FileDescriptorReadOnlyFilter)var1).mFileChannel;
            var3 = ((FileDescriptorReadOnlyFilter)var1).mMySequenceNumber;
        }

        if (var2 != null) {
            synchronized(this) {
                try {
                    if (var2.isOpen()) {
                        var2.close();
                        Log.d("SaveFilterManager", var3 + ": FileDescriptorFilter close FileChannel");
                    }
                } catch (Exception var4) {
                    var4.printStackTrace();
                }

                this.b.remove(var3);
            }
        }
    }

    static class a {
        private static FileDescriptorFilterManager.a a;
        private AtomicInteger b = new AtomicInteger();

        public static FileDescriptorFilterManager.a a() {
            if (a == null) {
                a = new FileDescriptorFilterManager.a();
            }

            return a;
        }

        public a() {
        }

        public final int b() {
            return this.b.incrementAndGet();
        }
    }
}
