//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.common.PDFNetIterator;

public class DigitalSignatureFieldIterator extends PDFNetIterator<DigitalSignatureField> {
    private Object a;

    public DigitalSignatureField next() {
        try {
            return new DigitalSignatureField(PDFNetIterator.Next(this.impl), this);
        } catch (PDFNetException var1) {
            return null;
        }
    }

    public Object clone() {
        return new DigitalSignatureFieldIterator(Clone(this.impl), this.a);
    }

    DigitalSignatureFieldIterator(long var1, Object var3) {
        super.impl = var1;
        this.a = var3;
    }
}
