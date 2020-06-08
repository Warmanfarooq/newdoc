//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;

public class ViewChangeCollection {
    long a;

    public ViewChangeCollection() throws PDFNetException {
        this.a = ViewChangeCollectionCreate();
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

    ViewChangeCollection(long var1) {
        this.a = var1;
    }

    public static ViewChangeCollection __Create(long var0) {
        return new ViewChangeCollection(var0);
    }

    public long __GetHandle() {
        return this.a;
    }

    static native long ViewChangeCollectionCreate();

    static native void Destroy(long var0);
}
