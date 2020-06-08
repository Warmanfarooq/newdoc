//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf.ocg;

import com.pdftron.common.PDFNetException;
import com.pdftron.pdf.PDFDoc;
import com.pdftron.sdf.Obj;

public class Group {
    long a;
    private Object b;

    public static Group create(PDFDoc var0, String var1) throws PDFNetException {
        return new Group(Create(var0.__GetHandle(), var1), var0);
    }

    public Group(Obj var1) {
        this.a = var1.__GetHandle();
        this.b = var1.__GetRefHandle();
    }

    public boolean isValid() throws PDFNetException {
        return IsValid(this.a);
    }

    public String getName() throws PDFNetException {
        return GetName(this.a);
    }

    public void setName(String var1) throws PDFNetException {
        SetName(this.a, var1);
    }

    public boolean getCurrentState(Context var1) throws PDFNetException {
        return GetCurrentState(this.a, var1.a);
    }

    public void setCurrentState(Context var1, boolean var2) throws PDFNetException {
        SetCurrentState(this.a, var1.a, var2);
    }

    public boolean getInitialState(Config var1) throws PDFNetException {
        return GetInitialState(this.a, var1.a);
    }

    public void setInitialState(Config var1, boolean var2) throws PDFNetException {
        SetInitialState(this.a, var1.a, var2);
    }

    public Obj getIntent() throws PDFNetException {
        return Obj.__Create(GetIntent(this.a), this.b);
    }

    public void setIntent(Obj var1) throws PDFNetException {
        SetIntent(this.a, var1.__GetHandle());
    }

    public boolean isLocked(Config var1) throws PDFNetException {
        return IsLocked(this.a, var1.a);
    }

    public void setLocked(Config var1, boolean var2) throws PDFNetException {
        SetLocked(this.a, var1.a, var2);
    }

    public boolean hasUsage() throws PDFNetException {
        return HasUsage(this.a);
    }

    public Obj getSDFObj() throws PDFNetException {
        return Obj.__Create(this.a, this.b);
    }

    public static Group __Create(long var0, Object var2) {
        return new Group(var0, var2);
    }

    private Group(long var1, Object var3) {
        this.a = var1;
        this.b = var3;
    }

    static native long Create(long var0, String var2);

    static native boolean IsValid(long var0);

    static native String GetName(long var0);

    static native void SetName(long var0, String var2);

    static native boolean GetCurrentState(long var0, long var2);

    static native void SetCurrentState(long var0, long var2, boolean var4);

    static native boolean GetInitialState(long var0, long var2);

    static native void SetInitialState(long var0, long var2, boolean var4);

    static native long GetIntent(long var0);

    static native void SetIntent(long var0, long var2);

    static native boolean IsLocked(long var0, long var2);

    static native void SetLocked(long var0, long var2, boolean var4);

    static native boolean HasUsage(long var0);
}
