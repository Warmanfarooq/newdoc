//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.filters.Filter;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

public class FileSpec {
    long a;
    Object b;

    public static FileSpec create(Doc var0, String var1) throws PDFNetException {
        return new FileSpec(Create(var0.__GetHandle(), var1, true), var0);
    }

    public static FileSpec create(Doc var0, String var1, boolean var2) throws PDFNetException {
        return new FileSpec(Create(var0.__GetHandle(), var1, var2), var0);
    }

    public static FileSpec createURL(Doc var0, String var1) throws PDFNetException {
        return new FileSpec(CreateURL(var0.__GetHandle(), var1), var0);
    }

    public FileSpec(Obj var1) {
        this.a = var1.__GetHandle();
        this.b = var1.__GetRefHandle();
    }

    public boolean equals(Object var1) {
        if (var1 != null && var1.getClass().equals(this.getClass())) {
            return this.a == ((FileSpec)var1).a;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (int)this.a;
    }

    public boolean isValid() throws PDFNetException {
        return IsValid(this.a);
    }

    public boolean export() throws PDFNetException {
        return Export(this.a, "");
    }

    public boolean export(String var1) throws PDFNetException {
        return Export(this.a, var1);
    }

    public Filter getFileData() throws PDFNetException {
        return Filter.__Create(GetFileData(this.a), (Filter)null);
    }

    public String getFilePath() throws PDFNetException {
        return GetFilePath(this.a);
    }

    public void setDesc(String var1) throws PDFNetException {
        SetDesc(this.a, var1);
    }

    public Obj getSDFObj() {
        return Obj.__Create(this.a, this.b);
    }

    private FileSpec(long var1, Object var3) {
        this.a = var1;
        this.b = var3;
    }

    public static FileSpec __Create(long var0, Object var2) {
        return var0 == 0L ? null : new FileSpec(var0, var2);
    }

    public long __GetHandle() {
        return this.a;
    }

    public Object __GetRefHandle() {
        return this.b;
    }

    static native long Create(long var0, String var2, boolean var3);

    static native long CreateURL(long var0, String var2);

    static native boolean IsValid(long var0);

    static native boolean Export(long var0, String var2);

    static native long GetFileData(long var0);

    static native String GetFilePath(long var0);

    static native void SetDesc(long var0, String var2);
}
