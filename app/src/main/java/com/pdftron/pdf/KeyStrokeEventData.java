//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;

public class KeyStrokeEventData {
    long a;

    public KeyStrokeEventData(String var1, String var2, String var3, int var4, int var5) throws PDFNetException {
        this.a = KeyStrokeEventDataCreate(var1, var2, var3, var4, var5);
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

    static native void Destroy(long var0);

    static native long KeyStrokeEventDataCreate(String var0, String var1, String var2, int var3, int var4);
}
