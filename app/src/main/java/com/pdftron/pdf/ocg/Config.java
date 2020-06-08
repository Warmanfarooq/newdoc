//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf.ocg;

import com.pdftron.common.PDFNetException;
import com.pdftron.pdf.PDFDoc;
import com.pdftron.sdf.Obj;

public class Config {
    long a;
    Object b;

    public static Config create(PDFDoc var0, boolean var1) throws PDFNetException {
        return new Config(Create(var0.__GetHandle(), var1), var0);
    }

    public boolean IsValid() {
        return this.a != 0L;
    }

    public Config(Obj var1) {
        this.a = var1.__GetHandle();
        this.b = var1.__GetRefHandle();
    }

    public Obj getOrder() throws PDFNetException {
        return Obj.__Create(GetOrder(this.a), this.b);
    }

    public void setOrder(Obj var1) throws PDFNetException {
        SetOrder(this.a, var1.__GetHandle());
    }

    public String getName() throws PDFNetException {
        return GetName(this.a);
    }

    public void setName(String var1) throws PDFNetException {
        SetName(this.a, var1);
    }

    public String getCreator() throws PDFNetException {
        return GetCreator(this.a);
    }

    public void setCreator(String var1) throws PDFNetException {
        SetCreator(this.a, var1);
    }

    public String getInitBaseState() throws PDFNetException {
        return GetInitBaseState(this.a);
    }

    public Obj getInitOnStates() throws PDFNetException {
        return Obj.__Create(GetInitOnStates(this.a), this.b);
    }

    public Obj getInitOffStates() throws PDFNetException {
        return Obj.__Create(GetInitOffStates(this.a), this.b);
    }

    public void setInitBaseState(String var1) throws PDFNetException {
        SetInitBaseState(this.a, var1);
    }

    public void setInitOnStates(Obj var1) throws PDFNetException {
        SetInitOnStates(this.a, var1.__GetHandle());
    }

    public void setInitOffStates(Obj var1) throws PDFNetException {
        SetInitOffStates(this.a, var1.__GetHandle());
    }

    public Obj getIntent() throws PDFNetException {
        return Obj.__Create(GetIntent(this.a), this.b);
    }

    public void setIntent(Obj var1) throws PDFNetException {
        SetIntent(this.a, var1.__GetHandle());
    }

    public Obj getLockedOCGs() throws PDFNetException {
        return Obj.__Create(GetLockedOCGs(this.a), this.b);
    }

    public void setLockedOCGs(Obj var1) throws PDFNetException {
        SetLockedOCGs(this.a, var1.__GetHandle());
    }

    public Obj getSDFObj() throws PDFNetException {
        return Obj.__Create(this.a, this.b);
    }

    private Config(long var1, Object var3) {
        this.a = var1;
        this.b = var3;
    }

    public static Config __Create(long var0, Object var2) {
        return var0 == 0L ? null : new Config(var0, var2);
    }

    static native long Create(long var0, boolean var2);

    static native long GetOrder(long var0);

    static native void SetOrder(long var0, long var2);

    static native String GetName(long var0);

    static native void SetName(long var0, String var2);

    static native String GetCreator(long var0);

    static native void SetCreator(long var0, String var2);

    static native String GetInitBaseState(long var0);

    static native long GetInitOnStates(long var0);

    static native long GetInitOffStates(long var0);

    static native void SetInitBaseState(long var0, String var2);

    static native void SetInitOnStates(long var0, long var2);

    static native void SetInitOffStates(long var0, long var2);

    static native long GetIntent(long var0);

    static native void SetIntent(long var0, long var2);

    static native long GetLockedOCGs(long var0);

    static native void SetLockedOCGs(long var0, long var2);
}
