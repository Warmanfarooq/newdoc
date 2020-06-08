//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;

public class BlackBoxContext {
    public static final int e_success = 0;
    public static final int e_incomplete = 1;
    public static final int e_failure = 2;
    private long a;

    public synchronized void destroy() throws PDFNetException {
        if (this.a != 0L) {
            Destroy(this.a);
            this.a = 0L;
        }

    }

    public void destroyImpl() throws PDFNetException {
        this.destroy();
    }

    protected void finalize() throws Throwable {
        this.destroy();
    }

    public BlackBoxContext(long var1) {
        this.a = var1;
    }

    public String doOperation(String var1) throws PDFNetException {
        return DoOperation(this.a, var1);
    }

    public PDFDoc getDoc() throws PDFNetException {
        return PDFDoc.__Create(GetDoc(this.a));
    }

    public long __GetHandle() {
        return this.a;
    }

    static native void Destroy(long var0);

    static native String DoOperation(long var0, String var2);

    static native long GetDoc(long var0);
}
