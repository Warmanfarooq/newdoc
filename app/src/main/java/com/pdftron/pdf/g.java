
package com.pdftron.pdf;

import android.graphics.RectF;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

final class g {
    private Interpolator a = new DecelerateInterpolator();
    private int b;
    private int c;
    private boolean d = true;
    private RectF e = new RectF();
    private RectF f = new RectF();
    private RectF g = new RectF();
    private SparseArray<RectF> h = new SparseArray();
    private SparseArray<RectF> i = new SparseArray();
    private SparseArray<RectF> j = new SparseArray();
    private long k;

    g(int var1) {
        this.b = var1;
        this.c = this.b + 500;
    }

    final void a(boolean var1) {
        this.d = true;
    }

    final void a(RectF var1, RectF var2, SparseArray<RectF> var3, SparseArray<RectF> var4) {
        this.d = true;
        this.e = new RectF();
        this.f = new RectF();
        this.g = new RectF();
        this.h.clear();
        this.i.clear();
        this.j.clear();
        this.k = SystemClock.elapsedRealtime();
        this.d = false;
        this.e.set(var1);
        this.f.set(var2);
        b(var3, this.h);
        b(var4, this.i);
    }

    final boolean a() {
        return this.d;
    }

    final int b() {
        if (this.d) {
            return 0;
        } else {
            long var1;
            if ((var1 = SystemClock.elapsedRealtime() - this.k) >= (long)this.c) {
                this.d = true;
                this.g.set(this.f);
                a(this.i, this.j);
                return 2;
            } else if (var1 >= (long)this.b) {
                this.g.set(this.f);
                a(this.i, this.j);
                return 1;
            } else {
                float var9 = (float)var1 / (float)this.b;
                float var2 = this.e.left + (this.f.left - this.e.left) * this.a.getInterpolation(var9);
                float var3 = this.e.top + (this.f.top - this.e.top) * this.a.getInterpolation(var9);
                float var4 = this.e.right + (this.f.right - this.e.right) * this.a.getInterpolation(var9);
                float var5 = this.e.bottom + (this.f.bottom - this.e.bottom) * this.a.getInterpolation(var9);
                this.g.set(var2, var3, var4, var5);
                int var6;
                int var7;
                RectF var8;
                int var10;
                RectF var11;
                if (this.i.size() < this.h.size()) {
                    for(var6 = 0; var6 < this.i.size(); ++var6) {
                        var7 = this.i.keyAt(var6);
                        if ((var10 = this.h.indexOfKey(var7)) >= 0) {
                            var11 = (RectF)this.h.valueAt(var10);
                            var8 = (RectF)this.i.valueAt(var6);
                            var2 = var11.left - (var11.left - var8.left) * this.a.getInterpolation(var9);
                            var3 = var11.top - (var11.top - var8.top) * this.a.getInterpolation(var9);
                            var4 = var11.right - (var11.right - var8.right) * this.a.getInterpolation(var9);
                            var5 = var11.bottom - (var11.bottom - var8.bottom) * this.a.getInterpolation(var9);
                            this.j.put(var7, new RectF(var2, var3, var4, var5));
                        }
                    }
                } else {
                    for(var6 = 0; var6 < this.h.size(); ++var6) {
                        var7 = this.h.keyAt(var6);
                        if ((var10 = this.i.indexOfKey(var7)) >= 0) {
                            var11 = (RectF)this.h.valueAt(var6);
                            var8 = (RectF)this.i.valueAt(var10);
                            var2 = var11.left - (var11.left - var8.left) * this.a.getInterpolation(var9);
                            var3 = var11.top - (var11.top - var8.top) * this.a.getInterpolation(var9);
                            var4 = var11.right - (var11.right - var8.right) * this.a.getInterpolation(var9);
                            var5 = var11.bottom - (var11.bottom - var8.bottom) * this.a.getInterpolation(var9);
                            this.j.put(var7, new RectF(var2, var3, var4, var5));
                        }
                    }
                }

                return 1;
            }
        }
    }

    final SparseArray<RectF> c() {
        return this.j;
    }

    private static void a(SparseArray<RectF> var0, SparseArray<RectF> var1) {
        if (var0 != null && var1 != null) {
            for(int var2 = 0; var2 < var1.size(); ++var2) {
                int var3;
                if ((var3 = var0.indexOfKey(var1.keyAt(var2))) >= 0) {
                    var1.put(var1.keyAt(var2), var0.valueAt(var3));
                }
            }

        }
    }

    private static void b(SparseArray<RectF> var0, SparseArray<RectF> var1) {
        if (var0 != null && var1 != null) {
            var1.clear();

            for(int var2 = 0; var2 < var0.size(); ++var2) {
                var1.put(var0.keyAt(var2), var0.valueAt(var2));
            }

        }
    }
}
