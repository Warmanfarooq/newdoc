//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf.struct;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

public class STree {
    private long a;
    private Object b;

    public STree(Obj var1) {
        this.a = var1.__GetHandle();
        this.b = var1.__GetRefHandle();
    }

    public boolean isValid() throws PDFNetException {
        return IsValid(this.a);
    }

    public int getNumKids() throws PDFNetException {
        return GetNumKids(this.a);
    }

    public SElement getKid(int var1) throws PDFNetException {
        return new SElement(GetKid(this.a, var1), this.b);
    }

    public SElement getElement(String var1) throws PDFNetException {
        return new SElement(GetElement(this.a, var1), this.b);
    }

    public SElement getElement(byte[] var1) throws PDFNetException {
        return new SElement(GetElement(this.a, var1), this.b);
    }

    public RoleMap getRoleMap() throws PDFNetException {
        return new RoleMap(GetRoleMap(this.a), this.b);
    }

    public ClassMap getClassMap() throws PDFNetException {
        return new ClassMap(GetClassMap(this.a), this.b);
    }

    public Obj getSDFObj() throws PDFNetException {
        return Obj.__Create(this.a, this.b);
    }

    public static STree __Create(long var0, Object var2) {
        return new STree(var0, var2);
    }

    STree(long var1, Object var3) {
        this.a = var1;
        this.b = var3;
    }

    static native boolean IsValid(long var0);

    static native int GetNumKids(long var0);

    static native long GetKid(long var0, int var2);

    static native long GetElement(long var0, String var2);

    static native long GetElement(long var0, byte[] var2);

    static native long GetRoleMap(long var0);

    static native long GetClassMap(long var0);
}
