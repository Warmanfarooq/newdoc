//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.fdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

public class FDFField {
    private long a;
    private Object b;

    public FDFField(Obj var1, Obj var2) throws PDFNetException {
        this.a = FDFFieldCreate(var1.__GetHandle(), var2.__GetHandle());
        this.b = var1.__GetRefHandle();
    }

    public void destroy() throws PDFNetException {
        if (this.a != 0L) {
            Destroy(this.a);
            this.a = 0L;
        }

    }

    protected void finalize() throws Throwable {
        this.destroy();
    }

    public Obj getValue() throws PDFNetException {
        return Obj.__Create(GetValue(this.a), this.b);
    }

    public void setValue(Obj var1) throws PDFNetException {
        SetValue(this.a, var1.__GetHandle());
    }

    public String getName() throws PDFNetException {
        return GetName(this.a);
    }

    public String getPartialName() throws PDFNetException {
        return GetPartialName(this.a);
    }

    public Obj getSDFObj() throws PDFNetException {
        return Obj.__Create(GetSDFObj(this.a), this.b);
    }

    public Obj findAttribute(String var1) throws PDFNetException {
        return Obj.__Create(FindAttribute(this.a, var1), this.b);
    }

    FDFField(long var1, Object var3) {
        this.a = var1;
        this.b = var3;
    }

    static native long FDFFieldCreate(long var0, long var2);

    static native void Destroy(long var0);

    static native long GetValue(long var0);

    static native void SetValue(long var0, long var2);

    static native String GetName(long var0);

    static native String GetPartialName(long var0);

    static native long GetSDFObj(long var0);

    static native long FindAttribute(long var0, String var2);
}
