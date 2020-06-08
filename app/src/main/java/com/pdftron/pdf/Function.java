
package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

public class Function {
    public static final int e_sampled = 0;
    public static final int e_exponential = 2;
    public static final int e_stitching = 3;
    public static final int e_postscript = 4;
    private long a;
    private Object b;

    public Function(Obj var1) {
        this.a = FunctionCreateFromObj(var1.__GetHandle());
        this.b = var1.__GetRefHandle();
    }

    public void destroy() {
        if (this.a != 0L) {
            Destroy(this.a);
            this.a = 0L;
        }

    }

    protected void finalize() throws Throwable {
        this.destroy();
    }

    public int getType() throws PDFNetException {
        return GetType(this.a);
    }

    public int getInputCardinality() throws PDFNetException {
        return GetInputCardinality(this.a);
    }

    public int getOutputCardinality() throws PDFNetException {
        return GetOutputCardinality(this.a);
    }

    public double[] eval(double[] var1) throws PDFNetException {
        return Eval(this.a, var1);
    }

    public Obj getSDFObj() {
        return Obj.__Create(GetSDFObj(this.a), this.b);
    }

    private Function(long var1, Object var3) {
        this.a = var1;
        this.b = var3;
    }

    static Function a(long var0, Object var2) {
        return var0 == 0L ? null : new Function(var0, var2);
    }

    static native long FunctionCreateFromObj(long var0);

    static native void Destroy(long var0);

    static native int GetType(long var0);

    static native int GetInputCardinality(long var0);

    static native int GetOutputCardinality(long var0);

    static native double[] Eval(long var0, double[] var2);

    static native long GetSDFObj(long var0);
}
