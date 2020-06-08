
package com.pdftron.common;

import java.util.Iterator;

public abstract class PDFNetIterator<T> implements Cloneable, Iterator {
    protected long impl;

    public PDFNetIterator() {
    }

    public void Destroy() throws PDFNetException {
        Destroy(this.impl);
    }

    public abstract T next();

    public abstract Object clone();

    public boolean hasNext() {
        return HasNext(this.impl);
    }

    public void remove() {
    }

    static native void Destroy(long var0);

    static native boolean HasNext(long var0);

    protected static native long Next(long var0);

    protected static native long NextD(long var0);

    protected static native long Clone(long var0);
}
