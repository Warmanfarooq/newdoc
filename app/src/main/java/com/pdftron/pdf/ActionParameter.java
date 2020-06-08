//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;

public class ActionParameter {
    private Action b;
    long a;

    public ActionParameter(Action var1, Field var2) throws PDFNetException {
        this.a = ActionParameterCreateWithField(var1.a, var2.a);
        this.b = var1;
    }

    public ActionParameter(Action var1, Annot var2) throws PDFNetException {
        this.a = ActionParameterCreateWithAnnot(var1.a, var2.a);
        this.b = var1;
    }

    public ActionParameter(Action var1, Page var2) throws PDFNetException {
        this.a = ActionParameterCreateWithPage(var1.a, var2.a);
        this.b = var1;
    }

    public ActionParameter(Action var1) throws PDFNetException {
        this.a = ActionParameterCreate(var1.a);
        this.b = var1;
    }

    public Action getAction() throws PDFNetException {
        return this.b;
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

    private ActionParameter(long var1) {
        this.a = var1;
    }

    public static ActionParameter __Create(long var0) {
        return new ActionParameter(var0);
    }

    public long __GetHandle() {
        return this.a;
    }

    static native void Destroy(long var0);

    static native long ActionParameterCreateWithField(long var0, long var2);

    static native long ActionParameterCreateWithAnnot(long var0, long var2);

    static native long ActionParameterCreateWithPage(long var0, long var2);

    static native long ActionParameterCreate(long var0);
}
