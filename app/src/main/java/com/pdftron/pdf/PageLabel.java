//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

public class PageLabel {
    public static final int e_decimal = 0;
    public static final int e_roman_uppercase = 1;
    public static final int e_roman_lowercase = 2;
    public static final int e_alphabetic_uppercase = 3;
    public static final int e_alphabetic_lowercase = 4;
    public static final int e_none = 5;
    long a;
    private Object b;

    public static PageLabel create(Doc var0, int var1) throws PDFNetException {
        return new PageLabel(Create(var0.__GetHandle(), var1, "", 1), var0);
    }

    public static PageLabel create(Doc var0, int var1, String var2) throws PDFNetException {
        return new PageLabel(Create(var0.__GetHandle(), var1, var2, 1), var0);
    }

    public static PageLabel create(Doc var0, int var1, String var2, int var3) throws PDFNetException {
        return new PageLabel(Create(var0.__GetHandle(), var1, var2, var3), var0);
    }

    public PageLabel() throws PDFNetException {
        this.a = PageLabelCreate(0L, -1, -1);
    }

    public PageLabel(Obj var1) throws PDFNetException {
        this.a = PageLabelCreate(var1.__GetHandle(), -1, -1);
    }

    public PageLabel(Obj var1, int var2) throws PDFNetException {
        this.a = PageLabelCreate(var1.__GetHandle(), var2, -1);
    }

    public PageLabel(Obj var1, int var2, int var3) throws PDFNetException {
        this.a = PageLabelCreate(var1.__GetHandle(), var2, var3);
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

    public boolean equals(Object var1) {
        return var1 != null && var1.getClass().equals(this.getClass()) ? Equals(this.a, ((PageLabel)var1).a) : false;
    }

    public int hashCode() {
        return HashCode(this.a);
    }

    public boolean isValid() throws PDFNetException {
        return IsValid(this.a);
    }

    public String getLabelTitle(int var1) throws PDFNetException {
        return GetLabelTitle(this.a, var1);
    }

    public void setStyle(int var1) throws PDFNetException {
        SetStyle(this.a, var1);
    }

    public int getStyle() throws PDFNetException {
        return GetStyle(this.a);
    }

    public String getPrefix() throws PDFNetException {
        return GetPrefix(this.a);
    }

    public void setPrefix(String var1) throws PDFNetException {
        SetPrefix(this.a, var1);
    }

    public int getStart() throws PDFNetException {
        return GetStart(this.a);
    }

    public void setStart(int var1) throws PDFNetException {
        SetStart(this.a, var1);
    }

    public int getFirstPageNum() throws PDFNetException {
        return GetFirstPageNum(this.a);
    }

    public int getLastPageNum() throws PDFNetException {
        return GetLastPageNum(this.a);
    }

    public Obj getSDFObj() throws PDFNetException {
        return Obj.__Create(GetSDFObj(this.a), this.b);
    }

    PageLabel(long var1, Object var3) {
        this.a = var1;
        this.b = var3;
    }

    static native long Create(long var0, int var2, String var3, int var4);

    static native long PageLabelCreate(long var0, int var2, int var3);

    static native void Destroy(long var0);

    static native boolean Equals(long var0, long var2);

    static native int HashCode(long var0);

    static native boolean IsValid(long var0);

    static native String GetLabelTitle(long var0, int var2);

    static native void SetStyle(long var0, int var2);

    static native int GetStyle(long var0);

    static native String GetPrefix(long var0);

    static native void SetPrefix(long var0, String var2);

    static native int GetStart(long var0);

    static native void SetStart(long var0, int var2);

    static native int GetFirstPageNum(long var0);

    static native int GetLastPageNum(long var0);

    static native long GetSDFObj(long var0);
}
