//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;

public class KeyStrokeActionResult {
    private long a;

    public boolean isValid() throws PDFNetException {
        return IsValid(this.a);
    }

    public String getText() throws PDFNetException {
        return GetText(this.a);
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

    KeyStrokeActionResult(long var1) {
        this.a = var1;
    }

    static native void Destroy(long var0);

    static native boolean IsValid(long var0);

    static native String GetText(long var0);
}
