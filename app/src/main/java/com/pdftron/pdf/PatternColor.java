
package com.pdftron.pdf;

import com.pdftron.common.Matrix2D;
import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

public class PatternColor {
    public static final int e_uncolored_tiling_pattern = 0;
    public static final int e_colored_tiling_pattern = 1;
    public static final int e_shading = 2;
    public static final int e_null = 3;
    public static final int e_constant_spacing = 0;
    public static final int e_no_distortion = 1;
    public static final int e_constant_spacing_fast_fill = 2;
    long a;
    private Object b;

    public PatternColor(Obj var1) {
        this.a = var1.__GetHandle();
        this.b = var1.__GetRefHandle();
    }

    public static int getType(Obj var0) throws PDFNetException {
        return GetTypeObj(var0.__GetHandle());
    }

    public int getType() throws PDFNetException {
        return GetType(this.a);
    }

    public Obj getSDFObj() throws PDFNetException {
        return Obj.__Create(this.a, this.b);
    }

    public Matrix2D getMatrix() throws PDFNetException {
        return Matrix2D.__Create(GetMatrix(this.a));
    }

    public Shading getShading() throws PDFNetException {
        return Shading.a(GetShading(this.a), this.b);
    }

    public int getTilingType() throws PDFNetException {
        return GetTilingType(this.a);
    }

    public Rect getBBox() throws PDFNetException {
        return new Rect(GetBBox(this.a));
    }

    public double getXStep() throws PDFNetException {
        return GetXStep(this.a);
    }

    public double getYStep() throws PDFNetException {
        return GetYStep(this.a);
    }

    static PatternColor a(long var0, Object var2) {
        return var0 != 0L ? new PatternColor(var0, var2) : null;
    }

    private PatternColor(long var1, Object var3) {
        this.a = var1;
        this.b = var3;
    }

    static native int GetTypeObj(long var0);

    static native int GetType(long var0);

    static native long GetMatrix(long var0);

    static native long GetShading(long var0);

    static native int GetTilingType(long var0);

    static native long GetBBox(long var0);

    static native double GetXStep(long var0);

    static native double GetYStep(long var0);
}
