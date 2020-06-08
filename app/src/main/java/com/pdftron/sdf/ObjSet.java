//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.sdf;

import com.pdftron.common.PDFNetException;

public class ObjSet {
    private long a = Create();

    public ObjSet() {
    }

    public void destroy() {
        if (this.a != 0L) {
            Destroy(this.a);
            this.a = 0L;
        }

    }

    protected void finalize() throws Throwable {
        this.destroy();
    }

    public Obj createName(String var1) throws PDFNetException {
        return Obj.__Create(CreateName(this.a, var1), this);
    }

    public Obj createArray() throws PDFNetException {
        return Obj.__Create(CreateArray(this.a), this);
    }

    public Obj createBool(boolean var1) throws PDFNetException {
        return Obj.__Create(CreateBool(this.a, var1), this);
    }

    public Obj createDict() throws PDFNetException {
        return Obj.__Create(CreateDict(this.a), this);
    }

    public Obj createNull() throws PDFNetException {
        return Obj.__Create(CreateNull(this.a), this);
    }

    public Obj createNumber(double var1) throws PDFNetException {
        return Obj.__Create(CreateNumber(this.a, var1), this);
    }

    public Obj createString(String var1) throws PDFNetException {
        return Obj.__Create(CreateString(this.a, var1), this);
    }

    public Obj createFromJson(String var1) throws PDFNetException {
        return Obj.__Create(CreateFromJson(this.a, var1), this);
    }

    static native long Create();

    static native void Destroy(long var0);

    static native long CreateName(long var0, String var2);

    static native long CreateArray(long var0);

    static native long CreateBool(long var0, boolean var2);

    static native long CreateDict(long var0);

    static native long CreateNull(long var0);

    static native long CreateNumber(long var0, double var2);

    static native long CreateString(long var0, String var2);

    static native long CreateFromJson(long var0, String var2);
}
