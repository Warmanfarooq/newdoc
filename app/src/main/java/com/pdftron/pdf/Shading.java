//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.Matrix2D;
import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

public class Shading {
    public static final int e_function_shading = 0;
    public static final int e_axial_shading = 1;
    public static final int e_radial_shading = 2;
    public static final int e_free_gouraud_shading = 3;
    public static final int e_lattice_gouraud_shading = 4;
    public static final int e_coons_shading = 5;
    public static final int e_tensor_shading = 6;
    public static final int e_null = 7;
    long a;
    Object b;

    public Shading(Obj var1) {
        this.a = var1.__GetHandle();
        this.b = var1.__GetRefHandle();
    }

    public static int getType(Obj var0) throws PDFNetException {
        return GetTypeStatic(var0.__GetHandle());
    }

    public int getType() throws PDFNetException {
        return GetType(this.a);
    }

    public Obj getSDFObj() {
        return Obj.__Create(this.a, this.b);
    }

    public ColorSpace getBaseColorSpace() throws PDFNetException {
        return ColorSpace.__Create(GetBaseColorSpace(this.a), this.b);
    }

    public boolean hasBBox() throws PDFNetException {
        return HasBBox(this.a);
    }

    public Rect getBBox() throws PDFNetException {
        return new Rect(GetBBox(this.a));
    }

    public boolean hasBackground() throws PDFNetException {
        return HasBackground(this.a);
    }

    public ColorPt getBackground() throws PDFNetException {
        return new ColorPt(GetBackground(this.a));
    }

    public boolean getAntialias() throws PDFNetException {
        return GetAntialias(this.a);
    }

    public double getParamStart() throws PDFNetException {
        return GetParamStart(this.a);
    }

    public double getParamEnd() throws PDFNetException {
        return GetParamEnd(this.a);
    }

    public boolean isExtendStart() throws PDFNetException {
        return IsExtendStart(this.a);
    }

    public boolean isExtendEnd() throws PDFNetException {
        return IsExtendEnd(this.a);
    }

    public ColorPt getColor(double var1) throws PDFNetException {
        return new ColorPt(GetColor(this.a, var1));
    }

    public double[] getCoords() throws PDFNetException {
        return GetCoords(this.a);
    }

    public double[] getCoordsRadial() throws PDFNetException {
        return GetCoordsRadial(this.a);
    }

    public double[] getDomain() throws PDFNetException {
        return GetDomain(this.a);
    }

    public Matrix2D getMatrix() throws PDFNetException {
        return Matrix2D.__Create(GetMatrix(this.a));
    }

    public ColorPt getColor(double var1, double var3) throws PDFNetException {
        return new ColorPt(GetColor(this.a, var1, var3));
    }

    private Shading(long var1, Object var3) {
        this.a = var1;
        this.b = var3;
    }

    static Shading a(long var0, Object var2) {
        return var0 == 0L ? null : new Shading(var0, var2);
    }

    static native int GetTypeStatic(long var0);

    static native int GetType(long var0);

    static native long GetBaseColorSpace(long var0);

    static native boolean HasBBox(long var0);

    static native long GetBBox(long var0);

    static native boolean HasBackground(long var0);

    static native long GetBackground(long var0);

    static native boolean GetAntialias(long var0);

    static native double GetParamStart(long var0);

    static native double GetParamEnd(long var0);

    static native boolean IsExtendStart(long var0);

    static native boolean IsExtendEnd(long var0);

    static native long GetColor(long var0, double var2);

    static native double[] GetCoords(long var0);

    static native double[] GetCoordsRadial(long var0);

    static native double[] GetDomain(long var0);

    static native long GetMatrix(long var0);

    static native long GetColor(long var0, double var2, double var4);
}
