
package com.pdftron.filters;

import com.pdftron.common.PDFNetException;

public class FilterReader {
    private Filter b;
    long a;

    public FilterReader() throws PDFNetException {
        this.a = FilterReaderCreate();
        this.b = null;
    }

    public FilterReader(Filter var1) throws PDFNetException {
        this.a = FilterReaderCreate(var1.impl);
        this.b = var1;
    }

    protected void finalize() throws PDFNetException {
        this.destroy();
    }

    public void destroy() throws PDFNetException {
        if (this.a != 0L) {
            Destroy(this.a);
            this.a = 0L;
        }

    }

    public int get() throws PDFNetException {
        return Get(this.a);
    }

    public int peek() throws PDFNetException {
        return Peek(this.a);
    }

    public long read(byte[] var1) throws PDFNetException {
        return Read(this.a, var1);
    }

    public void attachFilter(Filter var1) throws PDFNetException {
        this.b = var1;
        AttachFilter(this.a, var1.impl);
    }

    public Filter getAttachedFilter() throws PDFNetException {
        return this.b;
    }

    public void seek(long var1, int var3) throws PDFNetException {
        Seek(this.a, var1, var3);
    }

    public long tell() throws PDFNetException {
        return Tell(this.a);
    }

    public long count() throws PDFNetException {
        return Count(this.a);
    }

    public void flush() throws PDFNetException {
        Flush(this.a);
    }

    public void flushAll() throws PDFNetException {
        FlushAll(this.a);
    }

    public long __GetHandle() {
        return this.a;
    }

    static native long FilterReaderCreate();

    static native long FilterReaderCreate(long var0);

    static native void Destroy(long var0);

    static native int Get(long var0);

    static native int Peek(long var0);

    static native long Read(long var0, byte[] var2);

    static native void AttachFilter(long var0, long var2);

    static native void Seek(long var0, long var2, int var4);

    static native long Tell(long var0);

    static native long Count(long var0);

    static native void Flush(long var0);

    static native void FlushAll(long var0);
}
