//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetIterator;

public class PageIterator extends PDFNetIterator<Page> {
    private Object a;

    public Page next() {
        return new Page(PDFNetIterator.NextD(this.impl), this.a);
    }

    public Object clone() {
        return new PageIterator(PDFNetIterator.Clone(this.impl), this.a);
    }

    PageIterator(long var1, Object var3) {
        super.impl = var1;
        this.a = var3;
    }

    final long a() {
        return super.impl;
    }
}
