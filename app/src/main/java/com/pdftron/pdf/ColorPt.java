//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;

public class ColorPt {
    long a;

    public ColorPt() throws PDFNetException {
        this.a = ColorPtCreate(0.0D, 0.0D, 0.0D, 0.0D);
    }

    public ColorPt(double var1, double var3, double var5) throws PDFNetException {
        this.a = ColorPtCreate(var1, var3, var5, 1.0D);
    }

    public ColorPt(double var1, double var3, double var5, double var7) throws PDFNetException {
        this.a = ColorPtCreate(var1, var3, var5, var7);
    }

    public void destroy() throws PDFNetException {
        if (this.a != 0L) {
            Destroy(this.a);
            this.a = 0L;
        }

    }

    public boolean equals(Object var1) {
        return var1 != null && var1.getClass().equals(this.getClass()) ? Equals(this.a, ((ColorPt)var1).a) : false;
    }

    public int hashCode() {
        return HashCode(this.a);
    }

    public void set() throws PDFNetException {
        Set(this.a, 0.0D, 0.0D, 0.0D, 0.0D);
    }

    public void set(double var1, double var3, double var5, double var7) throws PDFNetException {
        Set(this.a, var1, var3, var5, var7);
    }

    public void set(int var1, double var2) throws PDFNetException {
        Set(this.a, var1, var2);
    }

    public double get(int var1) throws PDFNetException {
        return Get(this.a, var1);
    }

    public void setColorantNum(int var1) throws PDFNetException {
        SetColorantNum(this.a, var1);
    }

    protected void finalize() throws Throwable {
        this.destroy();
    }

    ColorPt(long var1) {
        this.a = var1;
    }

    public static ColorPt __Create(long var0) {
        return var0 == 0L ? null : new ColorPt(var0);
    }

    public long __GetHandle() {
        return this.a;
    }

    static native long ColorPtCreate(double var0, double var2, double var4, double var6);

    static native void Destroy(long var0);

    static native boolean Equals(long var0, long var2);

    static native int HashCode(long var0);

    static native void Set(long var0, double var2, double var4, double var6, double var8);

    static native void Set(long var0, int var2, double var3);

    static native double Get(long var0, int var2);

    static native void SetColorantNum(long var0, int var2);
}
