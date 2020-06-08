//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.common.PDFNetIterator;

public class FieldIterator extends PDFNetIterator<Field> {
    private Object a;

    public Field next() {
        try {
            return new Field(PDFNetIterator.Next(this.impl), this);
        } catch (PDFNetException var1) {
            return null;
        }
    }

    public Object clone() {
        return new FieldIterator(Clone(this.impl), this.a);
    }

    FieldIterator(long var1, Object var3) {
        super.impl = var1;
        this.a = var3;
    }
}
