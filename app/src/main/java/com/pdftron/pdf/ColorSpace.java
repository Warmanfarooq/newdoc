
package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.filters.Filter;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

public class ColorSpace {
    public static final int e_device_gray = 0;
    public static final int e_device_rgb = 1;
    public static final int e_device_cmyk = 2;
    public static final int e_cal_gray = 3;
    public static final int e_cal_rgb = 4;
    public static final int e_lab = 5;
    public static final int e_icc = 6;
    public static final int e_indexed = 7;
    public static final int e_pattern = 8;
    public static final int e_separation = 9;
    public static final int e_device_n = 10;
    public static final int e_null = 11;
    long a;
    private Object b;

    public static ColorSpace createDeviceGray() throws PDFNetException {
        return __Create(CreateDeviceGrayL(), (Object)null);
    }

    public static ColorSpace createDeviceRGB() throws PDFNetException {
        return __Create(CreateDeviceRGBL(), (Object)null);
    }

    public static ColorSpace createDeviceCMYK() throws PDFNetException {
        return __Create(CreateDeviceCMYKL(), (Object)null);
    }

    public static ColorSpace createPattern() throws PDFNetException {
        return __Create(CreatePatternL(), (Object)null);
    }

    public static ColorSpace createICCFromFile(Doc var0, String var1) throws PDFNetException {
        return __Create(CreateICCFromFile(var0.__GetHandle(), var1), (Object)null);
    }

    public static ColorSpace createICCFromFilter(Doc var0, Filter var1) throws PDFNetException {
        return __Create(CreateICCFromFilter(var0.__GetHandle(), var1.__GetHandle()), (Object)null);
    }

    public static ColorSpace createICCFromBuffer(Doc var0, byte[] var1) throws PDFNetException {
        return __Create(CreateICCFromBuffer(var0.__GetHandle(), var1), (Object)null);
    }

    public ColorSpace(Obj var1) {
        this.a = var1.__GetHandle();
        this.b = var1.__GetRefHandle();
    }

    public static int getComponentNum(int var0, Obj var1) throws PDFNetException {
        return GetComponentNum(var0, var1.__GetHandle());
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

    public int getComponentNum() throws PDFNetException {
        return GetComponentNum(this.a);
    }

    public void initColor(ColorPt var1) throws PDFNetException {
        InitColor(this.a, var1.a);
    }

    public void initComponentRanges(double[] var1, double[] var2) throws PDFNetException {
        int var3;
        if ((var3 = this.getComponentNum()) == var1.length && var3 == var2.length) {
            InitComponentRanges(this.a, var1, var2);
        } else {
            throw new PDFNetException("", 0L, "", "", "Error: Arrays passed to InitComponentRanges must have a length\nequal to the number of components in the ColorSpace.");
        }
    }

    public ColorPt convert2Gray(ColorPt var1) throws PDFNetException {
        return new ColorPt(Convert2Gray(this.a, var1.a));
    }

    public ColorPt convert2RGB(ColorPt var1) throws PDFNetException {
        return new ColorPt(Convert2RGB(this.a, var1.a));
    }

    public ColorPt convert2CMYK(ColorPt var1) throws PDFNetException {
        return new ColorPt(Convert2CMYK(this.a, var1.a));
    }

    public ColorSpace getAlternateColorSpace() throws PDFNetException {
        return __Create(GetAlternateColorSpace(this.a), this.b);
    }

    public ColorSpace getBaseColorSpace() throws PDFNetException {
        return __Create(GetBaseColorSpace(this.a), this.b);
    }

    public byte[] getLookupTable() throws PDFNetException {
        return GetLookupTable(this.a);
    }

    public ColorPt getBaseColor(byte var1) throws PDFNetException {
        return new ColorPt(GetBaseColor(this.a, var1));
    }

    public Function getTintFunction() throws PDFNetException {
        return Function.a(GetTintFunction(this.a), this.b);
    }

    public boolean isAll() throws PDFNetException {
        return IsAll(this.a);
    }

    public boolean isNone() throws PDFNetException {
        return IsNone(this.a);
    }

    private ColorSpace(long var1, Object var3) {
        this.a = var1;
        this.b = var3;
    }

    public static ColorSpace __Create(long var0, Object var2) {
        return var0 == 0L ? null : new ColorSpace(var0, var2);
    }

    static native long CreateDeviceGrayL();

    static native long CreateDeviceRGBL();

    static native long CreateDeviceCMYKL();

    static native long CreatePatternL();

    static native long CreateICCFromFile(long var0, String var2);

    static native long CreateICCFromFilter(long var0, long var2);

    static native long CreateICCFromBuffer(long var0, byte[] var2);

    static native int GetComponentNum(int var0, long var1);

    static native int GetTypeStatic(long var0);

    static native int GetType(long var0);

    static native int GetComponentNum(long var0);

    static native void InitColor(long var0, long var2);

    static native void InitComponentRanges(long var0, double[] var2, double[] var3);

    static native long Convert2Gray(long var0, long var2);

    static native long Convert2RGB(long var0, long var2);

    static native long Convert2CMYK(long var0, long var2);

    static native long GetAlternateColorSpace(long var0);

    static native long GetBaseColorSpace(long var0);

    static native byte[] GetLookupTable(long var0);

    static native long GetBaseColor(long var0, byte var2);

    static native long GetTintFunction(long var0);

    static native boolean IsAll(long var0);

    static native boolean IsNone(long var0);
}
