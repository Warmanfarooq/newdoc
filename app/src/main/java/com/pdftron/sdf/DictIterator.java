
package com.pdftron.sdf;

import com.pdftron.common.PDFNetException;

public class DictIterator {
    long a;
    private Object b;

    public void destroy() throws PDFNetException {
        if (this.a != 0L) {
            Destroy(this.a);
            this.a = 0L;
        }

    }

    protected void finalize() throws Throwable {
        this.destroy();
    }

    public void next() throws PDFNetException {
        Next(this.a);
    }

    public Obj key() throws PDFNetException {
        return Obj.__Create(Key(this.a), this.b);
    }

    public Obj value() throws PDFNetException {
        return Obj.__Create(Value(this.a), this.b);
    }

    public boolean hasNext() throws PDFNetException {
        return HasNext(this.a);
    }

    DictIterator(long var1, Object var3) {
        this.a = var1;
        this.b = var3;
    }

    public long __GetHandle() {
        return this.a;
    }

    static native void Destroy(long var0);

    static native void Next(long var0);

    static native long Key(long var0);

    static native long Value(long var0);

    static native boolean HasNext(long var0);
}
