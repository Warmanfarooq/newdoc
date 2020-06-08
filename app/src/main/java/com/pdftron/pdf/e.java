//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import android.graphics.Bitmap;

final class e {
    long a;
    int b;
    int c;
    Bitmap d;
    int e;
    int f;
    int g;
    int h;
    boolean i;
    int j;
    int k;
    boolean l;
    int m;
    CurvePainter n;

    e() {
        this.a = -1L;
        this.b = 0;
        this.c = 0;
        this.d = null;
        this.e = 0;
        this.f = 0;
        this.i = false;
        this.j = 0;
    }

    e(int var1, long var2, int var4) {
        this.a = var2;
        this.b = 0;
        this.c = 0;
        this.d = null;
        this.e = 0;
        this.f = 0;
        this.i = false;
        this.j = 0;
        this.k = var4;
    }

    public final boolean equals(Object var1) {
        if (var1 instanceof e) {
            e var2 = (e)var1;
            return this.a == var2.a;
        } else {
            return false;
        }
    }

    public final int hashCode() {
        return (int)(this.a ^ this.a >>> 32);
    }
}
