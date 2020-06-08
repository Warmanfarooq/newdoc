//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.helpers.DoubleRectangle2D;
import com.pdftron.sdf.Obj;

public class Rect {
    long a;

    public Rect() throws PDFNetException {
        this.a = RectCreate(0.0D, 0.0D, 0.0D, 0.0D);
    }

    public Rect(Obj var1) throws PDFNetException {
        this.a = RectCreate(var1.__GetHandle());
    }

    public Rect(double var1, double var3, double var5, double var7) throws PDFNetException {
        this.a = RectCreate(var1, var3, var5, var7);
    }

    public Rect(DoubleRectangle2D var1) throws PDFNetException {
        this.a = RectCreate(var1.x, var1.y, var1.x + var1.width, var1.y + var1.height);
    }

    Rect(long var1) {
        this.a = var1;
    }

    public static Rect __Create(long var0) {
        return var0 == 0L ? null : new Rect(var0);
    }

    public long __GetHandle() {
        return this.a;
    }

    public boolean equals(Object var1) {
        return var1 != null && var1.getClass().equals(this.getClass()) ? Equals(this.a, ((Rect)var1).a) : false;
    }

    public int hashCode() {
        return HashCode(this.a);
    }

    public void attach(Obj var1) throws PDFNetException {
        Attach(this.a, var1.__GetHandle());
    }

    public boolean update() throws PDFNetException {
        return Update(this.a, 0L);
    }

    public boolean update(Obj var1) throws PDFNetException {
        return Update(this.a, var1.__GetHandle());
    }

    public double[] get() throws PDFNetException {
        return Get(this.a);
    }

    public void set(double var1, double var3, double var5, double var7) throws PDFNetException {
        Set(this.a, var1, var3, var5, var7);
    }

    public void set(DoubleRectangle2D var1) throws PDFNetException {
        Set(this.a, var1.x, var1.y, var1.x + var1.width, var1.y + var1.height);
    }

    public double getWidth() throws PDFNetException {
        return Width(this.a);
    }

    public double getHeight() throws PDFNetException {
        return Height(this.a);
    }

    public boolean contains(double var1, double var3) throws PDFNetException {
        return Contains(this.a, var1, var3);
    }

    public boolean intersectRect(Rect var1, Rect var2) throws PDFNetException {
        return IntersectRect(this.a, var1.a, var2.a);
    }

    public void normalize() throws PDFNetException {
        Normalize(this.a);
    }

    public void inflate(double var1) {
        Inflate(this.a, var1);
    }

    public void inflate(double var1, double var3) {
        Inflate(this.a, var1, var3);
    }

    public void destroy() {
        if (this.a != 0L) {
            Destroy(this.a);
            this.a = 0L;
        }

    }

    public DoubleRectangle2D getRectangle() throws PDFNetException {
        double[] var1 = Get(this.a);
        return new DoubleRectangle2D(var1[0], var1[1], var1[2] - var1[0], var1[3] - var1[1]);
    }

    public double getX1() throws PDFNetException {
        return GetX1(this.a);
    }

    public double getY1() throws PDFNetException {
        return GetY1(this.a);
    }

    public double getX2() throws PDFNetException {
        return GetX2(this.a);
    }

    public double getY2() throws PDFNetException {
        return GetY2(this.a);
    }

    public void setX1(double var1) throws PDFNetException {
        SetX1(this.a, var1);
    }

    public void setY1(double var1) throws PDFNetException {
        SetY1(this.a, var1);
    }

    public void setX2(double var1) throws PDFNetException {
        SetX2(this.a, var1);
    }

    public void setY2(double var1) throws PDFNetException {
        SetY2(this.a, var1);
    }

    protected void finalize() throws Throwable {
        this.destroy();
    }

    static native long RectCreate(long var0);

    static native long RectCreate(double var0, double var2, double var4, double var6);

    static native boolean Equals(long var0, long var2);

    static native int HashCode(long var0);

    static native void Attach(long var0, long var2);

    static native boolean Update(long var0, long var2);

    static native double[] Get(long var0);

    static native void Set(long var0, double var2, double var4, double var6, double var8);

    static native double Width(long var0);

    static native double Height(long var0);

    static native boolean Contains(long var0, double var2, double var4);

    static native boolean IntersectRect(long var0, long var2, long var4);

    static native void Normalize(long var0);

    static native void Inflate(long var0, double var2);

    static native void Inflate(long var0, double var2, double var4);

    static native void Destroy(long var0);

    static native double GetX1(long var0);

    static native double GetY1(long var0);

    static native double GetX2(long var0);

    static native double GetY2(long var0);

    static native void SetX1(long var0, double var2);

    static native void SetY1(long var0, double var2);

    static native void SetX2(long var0, double var2);

    static native void SetY2(long var0, double var2);
}
