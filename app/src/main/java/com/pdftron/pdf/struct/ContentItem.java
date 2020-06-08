//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf.struct;

import com.pdftron.common.PDFNetException;
import com.pdftron.pdf.Page;
import com.pdftron.sdf.Obj;

public class ContentItem {
    public static final int e_MCR = 0;
    public static final int e_MCID = 1;
    public static final int e_OBJR = 2;
    public static final int e_Unknown = 3;
    private long a;
    private Object b;

    public void destroy() throws PDFNetException {
        if (this.a != 0L) {
            Destroy(this.a);
            this.a = 0L;
        }

    }

    protected void finalize() throws Throwable {
        this.destroy();
    }

    public int getType() throws PDFNetException {
        return GetType(this.a);
    }

    public SElement getParent() throws PDFNetException {
        return new SElement(GetParent(this.a), this.b);
    }

    public Page getPage() throws PDFNetException {
        return Page.__Create(GetPage(this.a), this.b);
    }

    public Obj getSDFObj() throws PDFNetException {
        return Obj.__Create(GetSDFObj(this.a), this.b);
    }

    public int getMCID() throws PDFNetException {
        return GetMCID(this.a);
    }

    public Obj getContainingStm() throws PDFNetException {
        return Obj.__Create(GetContainingStm(this.a), this.b);
    }

    public Obj getStmOwner() throws PDFNetException {
        return Obj.__Create(GetStmOwner(this.a), this.b);
    }

    public Obj getRefObj() throws PDFNetException {
        return Obj.__Create(GetRefObj(this.a), this.b);
    }

    ContentItem(long var1, Object var3) {
        this.a = var1;
        this.b = var3;
    }

    static native void Destroy(long var0);

    static native int GetType(long var0);

    static native long GetParent(long var0);

    static native long GetPage(long var0);

    static native long GetSDFObj(long var0);

    static native int GetMCID(long var0);

    static native long GetContainingStm(long var0);

    static native long GetStmOwner(long var0);

    static native long GetRefObj(long var0);
}
