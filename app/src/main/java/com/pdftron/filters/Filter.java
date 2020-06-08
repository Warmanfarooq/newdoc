

package com.pdftron.filters;

import com.pdftron.common.PDFNetException;

public class Filter {
    protected long impl;
    protected Filter attached;
    protected Object ref;

    public void destroy() throws PDFNetException {
        if (this.attached == null && this.ref == null && this.impl != 0L) {
            Destroy(this.impl);
            this.impl = 0L;
        }

    }

    protected void finalize() throws Throwable {
        this.destroy();
    }

    public void attachFilter(Filter var1) throws PDFNetException {
        if (var1 != null) {
            AttachFilter(this.impl, var1.impl);
            var1.attached = this;
        }

    }

    public Filter releaseAttachedFilter() throws PDFNetException {
        long var1;
        return (var1 = ReleaseAttachedFilter(this.impl)) == 0L ? null : new Filter(var1, (Filter)null);
    }

    public Filter getAttachedFilter() throws PDFNetException {
        return new Filter(GetAttachedFilter(this.impl), this);
    }

    public Filter getSourceFilter() throws PDFNetException {
        long var1 = GetSourceFilter(this.impl);

        Filter var3;
        for(var3 = this; var3.attached != null; var3 = var3.attached) {
        }

        return new Filter(var1, var3);
    }

    public String getName() throws PDFNetException {
        return GetName(this.impl);
    }

    public String getDecodeName() throws PDFNetException {
        return GetDecodeName(this.impl);
    }

    public void setStreamLength(long var1) throws PDFNetException {
        SetStreamLength(this.impl, var1);
    }

    public void flush() throws PDFNetException {
        Flush(this.impl);
    }

    public void flushAll() throws PDFNetException {
        FlushAll(this.impl);
    }

    public boolean isInputFilter() throws PDFNetException {
        return IsInputFilter(this.impl);
    }

    public boolean canSeek() throws PDFNetException {
        return CanSeek(this.impl);
    }

    public void seek(long var1, int var3) throws PDFNetException {
        Seek(this.impl, var1, var3);
    }

    public long size() throws PDFNetException {
        return Size(this.impl);
    }

    public long tell() throws PDFNetException {
        return Tell(this.impl);
    }

    public Filter createInputIterator() throws PDFNetException {
        return new Filter(CreateInputIterator(this.impl), (Filter)null);
    }

    public String getFilePath() throws PDFNetException {
        return GetFilePath(this.impl);
    }

    public void writeToFile(String var1, boolean var2) {
        WriteToFile(this.impl, var1, var2);
    }

    protected Filter(long var1, Filter var3) {
        this.impl = var1;
        this.attached = var3;
    }

    public static Filter __Create(long var0, Filter var2) {
        return new Filter(var0, var2);
    }

    public long __GetHandle() {
        return this.impl;
    }

    public void __SetRefHandle(Object var1) {
        this.ref = var1;
    }

    static native void Destroy(long var0);

    static native void AttachFilter(long var0, long var2);

    static native long ReleaseAttachedFilter(long var0);

    static native long GetAttachedFilter(long var0);

    static native long GetSourceFilter(long var0);

    static native String GetName(long var0);

    static native String GetDecodeName(long var0);

    static native void SetStreamLength(long var0, long var2);

    static native void Flush(long var0);

    static native void FlushAll(long var0);

    static native boolean IsInputFilter(long var0);

    static native boolean CanSeek(long var0);

    static native void Seek(long var0, long var2, int var4);

    static native long Size(long var0);

    static native long Tell(long var0);

    static native long CreateInputIterator(long var0);

    static native String GetFilePath(long var0);

    static native void WriteToFile(long var0, String var2, boolean var3);
}
