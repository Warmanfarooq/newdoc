//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetIterator;

public class FontCharCodeIterator extends PDFNetIterator<Long> {
    private Object a;

    public Long next() {
        return new Long(PDFNetIterator.NextD(this.impl));
    }

    public Object clone() {
        return new FontCharCodeIterator(PDFNetIterator.Clone(this.impl), this.a);
    }

    FontCharCodeIterator(long var1, Object var3) {
        super.impl = var1;
        this.a = var3;
    }
}
