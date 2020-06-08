//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.sdf;

import com.pdftron.common.PDFNetException;

public class DocSnapshot {
    private long a;

    public void destroy() throws PDFNetException {
        if (this.a != 0L) {
            Destroy(this.a);
            this.a = 0L;
        }

    }

    protected void finalize() throws Throwable {
        this.destroy();
    }

    public DocSnapshot(long var1) {
        this.a = var1;
    }

    public int getHash() throws PDFNetException {
        return GetHash(this.a);
    }

    public boolean isValid() throws PDFNetException {
        return IsValid(this.a);
    }

    public boolean equals(DocSnapshot var1) throws PDFNetException {
        return Equals(this.a, var1.__GetHandle());
    }

    public long __GetHandle() {
        return this.a;
    }

    static native void Destroy(long var0);

    static native int GetHash(long var0);

    static native boolean IsValid(long var0);

    static native boolean Equals(long var0, long var2);
}
