//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

public class Destination {
    public static final int e_XYZ = 0;
    public static final int e_Fit = 1;
    public static final int e_FitH = 2;
    public static final int e_FitV = 3;
    public static final int e_FitR = 4;
    public static final int e_FitB = 5;
    public static final int e_FitBH = 6;
    public static final int e_FitBV = 7;
    long a;
    Object b;

    public static Destination createXYZ(Page var0, double var1, double var3, double var5) throws PDFNetException {
        return new Destination(CreateXYZ(var0.a, var1, var3, var5), var0.b);
    }

    public static Destination createFit(Page var0) throws PDFNetException {
        return new Destination(CreateFit(var0.a), var0.b);
    }

    public static Destination createFitH(Page var0, double var1) throws PDFNetException {
        return new Destination(CreateFitH(var0.a, var1), var0.b);
    }

    public static Destination createFitV(Page var0, double var1) throws PDFNetException {
        return new Destination(CreateFitV(var0.a, var1), var0.b);
    }

    public static Destination createFitR(Page var0, double var1, double var3, double var5, double var7) throws PDFNetException {
        return new Destination(CreateFitR(var0.a, var1, var3, var5, var7), var0.b);
    }

    public static Destination createFitB(Page var0) throws PDFNetException {
        return new Destination(CreateFitB(var0.a), var0.b);
    }

    public static Destination createFitBH(Page var0, double var1) throws PDFNetException {
        return new Destination(CreateFitBH(var0.a, var1), var0.b);
    }

    public static Destination createFitBV(Page var0, double var1) throws PDFNetException {
        return new Destination(CreateFitBV(var0.a, var1), var0.b);
    }

    public Destination(Obj var1) {
        this.a = Create(var1.__GetHandle());
        this.b = var1.__GetRefHandle();
    }

    public boolean isValid() throws PDFNetException {
        return IsValid(this.a);
    }

    public int getFitType() throws PDFNetException {
        return GetFitType(this.a);
    }

    public Page getPage() throws PDFNetException {
        return new Page(GetPage(this.a), this.b);
    }

    public void setPage(Page var1) throws PDFNetException {
        SetPage(this.a, var1.a);
    }

    public Obj getSDFObj() {
        return Obj.__Create(this.a, this.b);
    }

    public Obj getExplicitDestObj() throws PDFNetException {
        return Obj.__Create(GetExplicitDestObj(this.a), this.b);
    }

    Destination(long var1, Object var3) {
        this.a = var1;
        this.b = var3;
    }

    static native long CreateXYZ(long var0, double var2, double var4, double var6);

    static native long CreateFit(long var0);

    static native long CreateFitH(long var0, double var2);

    static native long CreateFitV(long var0, double var2);

    static native long CreateFitR(long var0, double var2, double var4, double var6, double var8);

    static native long CreateFitB(long var0);

    static native long CreateFitBH(long var0, double var2);

    static native long CreateFitBV(long var0, double var2);

    static native long Create(long var0);

    static native boolean IsValid(long var0);

    static native int GetFitType(long var0);

    static native long GetPage(long var0);

    static native void SetPage(long var0, long var2);

    static native long GetExplicitDestObj(long var0);
}
