//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.sdf;

import com.pdftron.common.PDFNetException;

public class ResultSnapshot {
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

    public ResultSnapshot(long var1) {
        this.a = var1;
    }

    public DocSnapshot currentState() throws PDFNetException {
        return new DocSnapshot(CurrentState(this.a));
    }

    public DocSnapshot previousState() throws PDFNetException {
        return new DocSnapshot(PreviousState(this.a));
    }

    public boolean isOk() throws PDFNetException {
        return IsOk(this.a);
    }

    public boolean isNullTransition() throws PDFNetException {
        return IsNullTransition(this.a);
    }

    public long __GetHandle() {
        return this.a;
    }

    static native void Destroy(long var0);

    static native long CurrentState(long var0);

    static native long PreviousState(long var0);

    static native boolean IsOk(long var0);

    static native boolean IsNullTransition(long var0);
}
