//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf.struct;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

public class SElement {
    private long a;
    private Object b;

    public SElement() throws PDFNetException {
        this.a = SElementCreate(0L);
    }

    public SElement(Obj var1) throws PDFNetException {
        this.a = SElementCreate(var1.__GetHandle());
    }

    public boolean isValid() throws PDFNetException {
        return IsValid(this.a);
    }

    public String getType() throws PDFNetException {
        return GetType(this.a);
    }

    public int getNumKids() throws PDFNetException {
        return GetNumKids(this.a);
    }

    public boolean isContentItem(int var1) throws PDFNetException {
        return IsContentItem(this.a, var1);
    }

    public ContentItem getAsContentItem(int var1) throws PDFNetException {
        return new ContentItem(GetAsContentItem(this.a, var1), this.b);
    }

    public SElement getAsStructElem(int var1) throws PDFNetException {
        return new SElement(GetAsStructElem(this.a, var1), this.b);
    }

    public SElement getParent() throws PDFNetException {
        return new SElement(GetParent(this.a), this.b);
    }

    public STree getStructTreeRoot() throws PDFNetException {
        return new STree(GetStructTreeRoot(this.a), this.b);
    }

    public boolean hasTitle() throws PDFNetException {
        return HasTitle(this.a);
    }

    public String getTitle() throws PDFNetException {
        return GetTitle(this.a);
    }

    public Obj getID() throws PDFNetException {
        return Obj.__Create(GetID(this.a), this.b);
    }

    public boolean hasActualText() throws PDFNetException {
        return HasActualText(this.a);
    }

    public String getActualText() throws PDFNetException {
        return GetActualText(this.a);
    }

    public boolean hasAlt() throws PDFNetException {
        return HasAlt(this.a);
    }

    public String getAlt() throws PDFNetException {
        return GetAlt(this.a);
    }

    public Obj getSDFObj() throws PDFNetException {
        return Obj.__Create(GetSDFObj(this.a), this.b);
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

    public static SElement __Create(long var0, Object var2) {
        return new SElement(var0, var2);
    }

    SElement(long var1, Object var3) {
        this.a = var1;
        this.b = var3;
    }

    static native void Destroy(long var0);

    static native long SElementCreate(long var0);

    static native boolean IsValid(long var0);

    static native String GetType(long var0);

    static native int GetNumKids(long var0);

    static native boolean IsContentItem(long var0, int var2);

    static native long GetAsContentItem(long var0, int var2);

    static native long GetAsStructElem(long var0, int var2);

    static native long GetParent(long var0);

    static native long GetStructTreeRoot(long var0);

    static native boolean HasTitle(long var0);

    static native String GetTitle(long var0);

    static native long GetID(long var0);

    static native boolean HasActualText(long var0);

    static native String GetActualText(long var0);

    static native boolean HasAlt(long var0);

    static native String GetAlt(long var0);

    static native long GetSDFObj(long var0);
}
