//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.fdf;

import com.pdftron.common.PDFNetIterator;

public class FDFFieldIterator extends PDFNetIterator<FDFField> {
    private Object a;

    public FDFField next() {
        return new FDFField(Next(this.impl), this);
    }

    public Object clone() {
        return new FDFFieldIterator(Clone(this.impl), this.a);
    }

    FDFFieldIterator(long var1, Object var3) {
        super.impl = var1;
        this.a = var3;
    }
}
