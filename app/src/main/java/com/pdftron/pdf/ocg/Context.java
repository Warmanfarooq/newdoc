//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf.ocg;

import com.pdftron.common.PDFNetException;

public class Context {
    public static final int e_VisibleOC = 0;
    public static final int e_AllOC = 1;
    public static final int e_NoOC = 2;
    long a;
    private Object b;
    private boolean c = true;

    public Context(Context var1) throws PDFNetException {
        this.a = ContextCreateCtx(var1.a);
        this.b = var1.b;
        this.c = true;
    }

    public Context(Config var1) throws PDFNetException {
        this.a = ContextCreateCfg(var1.a);
        this.b = var1.b;
        this.c = true;
    }

    protected void finalize() throws Throwable {
        if (this.c) {
            Destroy(this.a);
        }

        this.a = 0L;
        this.b = null;
    }

    public boolean getState(Group var1) throws PDFNetException {
        return GetState(this.a, var1.a);
    }

    public void setState(Group var1, boolean var2) throws PDFNetException {
        SetState(this.a, var1.a, var2);
    }

    public void resetStates(boolean var1) throws PDFNetException {
        ResetStates(this.a, var1);
    }

    public void setNonOCDrawing(boolean var1) throws PDFNetException {
        SetNonOCDrawing(this.a, var1);
    }

    public void setOCDrawMode(int var1) throws PDFNetException {
        SetOCDrawMode(this.a, var1);
    }

    public int getOCMode() throws PDFNetException {
        return GetOCMode(this.a);
    }

    public long __GetHandle() {
        return this.a;
    }

    private Context(long var1, Object var3) {
        this.a = var1;
        this.b = var3;
        this.c = false;
    }

    public static Context __Create(long var0, Object var2) {
        return var0 == 0L ? null : new Context(var0, var2);
    }

    static native long ContextCreateCtx(long var0);

    static native long ContextCreateCfg(long var0);

    static native void Destroy(long var0);

    static native boolean GetState(long var0, long var2);

    static native void SetState(long var0, long var2, boolean var4);

    static native void ResetStates(long var0, boolean var2);

    static native void SetNonOCDrawing(long var0, boolean var2);

    static native void SetOCDrawMode(long var0, int var2);

    static native int GetOCMode(long var0);
}
