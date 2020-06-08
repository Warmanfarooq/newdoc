package com.pdftron.filters;

import com.pdftron.common.PDFNetException;

public class FilterWriter {
    private Filter a;
    private long b;

    public void destroy() throws PDFNetException {
        if (this.b != 0L) {
            Destroy(this.b);
            this.b = 0L;
        }

    }

    protected void finalize() throws PDFNetException {
        this.destroy();
    }

    public FilterWriter() throws PDFNetException {
        this.b = FilterWriterCreate();
        this.a = null;
    }

    public FilterWriter(Filter var1) throws PDFNetException {
        this.b = FilterWriterCreate(var1.impl);
        this.a = var1;
    }

    public void writeUChar(byte var1) throws PDFNetException {
        WriteUChar(this.b, var1);
    }

    public void writeInt(int var1) throws PDFNetException {
        WriteInt(this.b, var1);
    }

    public void writeString(String var1) throws PDFNetException {
        WriteString(this.b, var1);
    }

    public void writeFilter(FilterReader var1) throws PDFNetException {
        WriteFilter(this.b, var1.a);
    }

    public void writeLine(String var1) throws PDFNetException {
        WriteLine(this.b, var1);
    }

    public long writeBuffer(byte[] var1) throws PDFNetException {
        return WriteBuffer(this.b, var1);
    }

    public void attachFilter(Filter var1) throws PDFNetException {
        AttachFilter(this.b, var1.impl);
        this.a = var1;
    }

    public Filter getAttachedFilter() throws PDFNetException {
        return this.a;
    }

    public void seek(long var1, int var3) throws PDFNetException {
        Seek(this.b, var1, var3);
    }

    public long tell() throws PDFNetException {
        return Tell(this.b);
    }

    public long count() throws PDFNetException {
        return Count(this.b);
    }

    public void flush() throws PDFNetException {
        Flush(this.b);
    }

    public void flushAll() throws PDFNetException {
        FlushAll(this.b);
    }

    public long __GetHandle() {
        return this.b;
    }

    static native void Destroy(long var0);

    static native long FilterWriterCreate();

    static native long FilterWriterCreate(long var0);

    static native void WriteUChar(long var0, byte var2);

    static native void WriteInt(long var0, int var2);

    static native void WriteString(long var0, String var2);

    static native void WriteFilter(long var0, long var2);

    static native void WriteLine(long var0, String var2);

    static native long WriteBuffer(long var0, byte[] var2);

    static native void AttachFilter(long var0, long var2);

    static native void Seek(long var0, long var2, int var4);

    static native long Tell(long var0);

    static native long Count(long var0);

    static native void Flush(long var0);

    static native void FlushAll(long var0);
}
