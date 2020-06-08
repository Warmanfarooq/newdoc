//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

public class PathData {
    public static final int e_moveto = 1;
    public static final int e_lineto = 2;
    public static final int e_cubicto = 3;
    public static final int e_conicto = 4;
    public static final int e_rect = 5;
    public static final int e_closepath = 6;
    private byte[] a;
    private double[] b;
    private boolean c;

    public PathData(boolean var1, byte[] var2, double[] var3) {
        this.a = var2;
        this.c = var1;
        this.b = var3;
    }

    public void setOperators(byte[] var1) {
        this.a = var1;
    }

    public void setPoints(double[] var1) {
        this.b = var1;
    }

    public byte[] getOperators() {
        return this.a;
    }

    public double[] getPoints() {
        return this.b;
    }

    public boolean isDefined() {
        return this.c;
    }
}
