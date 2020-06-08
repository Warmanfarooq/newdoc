//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;

public class PageSet {
    public static final int e_all = 0;
    public static final int e_odd = 1;
    public static final int e_even = 2;
    long a;

    public PageSet() {
        this.a = PageSetCreate();
    }

    public PageSet(int var1) {
        this.a = PageSetCreate(var1);
    }

    public PageSet(int var1, int var2) {
        this.a = PageSetCreate(var1, var2);
    }

    public PageSet(int var1, int var2, int var3) {
        this.a = PageSetCreate(var1, var2, var3);
    }

    public void destroy() throws PDFNetException {
        if (this.a != 0L) {
            Destroy(this.a);
            this.a = 0L;
        }

    }

    public void addPage(int var1) {
        AddPage(this.a, var1);
    }

    public void addRange(int var1, int var2) {
        AddRange(this.a, var1, var2);
    }

    public void addRange(int var1, int var2, int var3) {
        AddRange(this.a, var1, var2, var3);
    }

    public long __GetHandle() {
        return this.a;
    }

    static native long PageSetCreate();

    static native long PageSetCreate(int var0);

    static native long PageSetCreate(int var0, int var1);

    static native long PageSetCreate(int var0, int var1, int var2);

    static native void Destroy(long var0);

    static native void AddPage(long var0, int var2);

    static native void AddRange(long var0, int var2, int var3);

    static native void AddRange(long var0, int var2, int var3, int var4);
}
