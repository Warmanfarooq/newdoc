//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

final class f {
    private SparseArray<f.a> d = new SparseArray();
    private SparseArray<f.b> e = new SparseArray();
    private SparseArray<f.b> f = new SparseArray();
    int a;
    boolean b;
    int c;

    final boolean a(int var1) {
        if (var1 - this.c >= 0) {
            this.c = var1;
            return true;
        } else {
            return false;
        }
    }

    f() {
    }

    private f.b c(int var1, int var2) {
        if (var2 == 1) {
            if (this.f.get(var1) == null) {
                this.f.put(var1, new f.b());
            }

            return (f.b)this.f.get(var1);
        } else {
            if (this.e.get(var1) == null) {
                this.e.put(var1, new f.b());
            }

            return (f.b)this.e.get(var1);
        }
    }

    final void b(int var1) {
        if ((f.a)this.d.get(var1) == null) {
            f.a var2 = new f.a(this, var1);
            this.d.put(var1, var2);
        }

    }

    final f.a c(int var1) {
        return (f.a)this.d.get(var1);
    }

    final boolean a() {
        return this.d(2);
    }

    final boolean d(int var1) {
        if (var1 == 0) {
            return a(this.e);
        } else if (var1 == 1) {
            return a(this.f);
        } else {
            return a(this.e) && a(this.f);
        }
    }

    private static boolean a(SparseArray<f.b> var0) {
        int var1 = 0;

        for(int var2 = var0.size(); var1 < var2; ++var1) {
            int var3 = var0.keyAt(var1);
            if (!((f.b)var0.get(var3)).a.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    final void b() {
        this.e(2);
    }

    final void e(int var1) {
        ImageCache var2 = com.pdftron.pdf.ImageCache.a.a();
        int var3;
        int var4;
        int var5;
        e var6;
        Iterator var7;
        if (var1 == 0 || var1 == 2) {
            if (var2.b()) {
                var3 = 0;

                for(var4 = this.e.size(); var3 < var4; ++var3) {
                    var5 = this.e.keyAt(var3);
                    var7 = ((f.b)this.e.get(var5)).a.values().iterator();

                    while(var7.hasNext()) {
                        var6 = (e)var7.next();
                        var2.a(var6.d);
                    }
                }
            }

            this.e.clear();
        }

        if (var1 == 1 || var1 == 2) {
            if (var2.b()) {
                var3 = 0;

                for(var4 = this.f.size(); var3 < var4; ++var3) {
                    var5 = this.f.keyAt(var3);
                    var7 = ((f.b)this.f.get(var5)).a.values().iterator();

                    while(var7.hasNext()) {
                        var6 = (e)var7.next();
                        var2.a(var6.d);
                    }
                }
            }

            this.f.clear();
        }

        this.d.clear();
    }

    final void a(int var1, int var2) {
        f.b var5 = this.c(var1, var2);
        ImageCache var6;
        if ((var6 = com.pdftron.pdf.ImageCache.a.a()).b()) {
            Iterator var3 = var5.a.values().iterator();

            while(var3.hasNext()) {
                e var4 = (e)var3.next();
                var6.a(var4.d);
            }
        }

        var5.a.clear();
        var5.b = var5.c.a;
    }

    final void a(int var1, long var2, int var4, int var5) {
        f.b var6 = this.c(var1, var5);
        e var7;
        if ((var7 = this.a(var1, var2, var5)) != null) {
            var6.a.remove(var7);
            com.pdftron.pdf.ImageCache.a.a().a(var7.d);
            var7.d = null;
            var7.n = null;
        } else {
            if (var5 == 0) {
                e var8;
                (var8 = new e(var1, var2, var5)).b = -1;
                var8.c = -1;
                var8.i = true;
                var8.j = var4;
                var6.a.put(var8, var8);
            }

        }
    }

    final int c() {
        int var1 = 0;
        int var2 = 0;

        for(int var3 = this.e.size(); var2 < var3; ++var2) {
            int var4 = this.e.keyAt(var2);
            f.b var5 = (f.b)this.e.get(var4);
            var1 += var5.a.size();
        }

        return var1;
    }

    final e a(int var1, long var2, int var4) {
        f.b var5;
        if (var4 == 1) {
            if ((var5 = (f.b)this.f.get(var1)) != null && var5.a != null) {
                return (e)var5.a.get(new e(var1, var2, var4));
            }
        } else if ((var5 = (f.b)this.e.get(var1)) != null && var5.a != null) {
            return (e)var5.a.get(new e(var1, var2, var4));
        }

        return null;
    }

    final Collection<e> b(int var1, int var2) {
        return this.c(var1, var2).a.values();
    }

    final Collection<e> f(int var1) {
        Collection var2 = this.c(var1, 1).a.values();
        ArrayList var3;
        Collections.sort(var3 = new ArrayList(var2), new Comparator<e>(this) {
        });
        return var3;
    }

    final e a(long var1, int var3, long var4, long var6, int var8, int var9, int var10, int var11, Bitmap var12, CurvePainter var13, int var14, int var15, boolean var16, int var17) {
        f.b var18 = this.c(var3, var15);
        ImageCache var19 = com.pdftron.pdf.ImageCache.a.a();
        if (var15 == 1) {
            if (!this.a(var14)) {
                return null;
            }
        } else if (var15 == 0 && var14 - var18.b < 0) {
            var19.a(var12);
            if (PDFViewCtrl.a) {
                Log.e("TILES", "Evicting tile since it's sequence number is too low");
            }

            return null;
        }

        e var20 = null;
        if (var3 >= 0 && var1 >= 0L && (var20 = this.a(var3, var1, var15)) != null && var20.i) {
            int var21 = var14 - var20.j;
            this.a(var3, var1, var14, var15);
            if (var21 < 0) {
                var19.a(var12);
                return null;
            }

            var20 = null;
        }

        if (var20 != null) {
            var19.a(var20.d);
        }

        if (var20 != null && var20.c == var11 && var20.b == var10) {
            var20.e = var8;
            var20.f = var9;
            var20.b = var10;
            var20.c = var11;
            if (var12 != null) {
                var20.d = var12;
                if (var20.k == 1) {
                    var20.n = var13;
                }

                var20.g = (int)((double)var4 + 0.5D);
                var20.h = (int)((double)var6 + 0.5D);
            } else if (var13 != null) {
                var20.d = null;
                var20.n = var13;
                var20.b = (int)((double)var4 + 0.5D);
                var20.c = (int)((double)var6 + 0.5D);
            }

            var20.k = var15;
            var20.l = var16;
            var20.m = var17;
            return var20;
        } else {
            (var20 = new e(var3, var1, var15)).e = var8;
            var20.f = var9;
            var20.b = var10;
            var20.c = var11;
            if (var12 != null) {
                var20.d = var12;
                if (var20.k == 1) {
                    var20.n = var13;
                }

                var20.g = (int)((double)var4 + 0.5D);
                var20.h = (int)((double)var6 + 0.5D);
            } else if (var13 != null) {
                var20.d = null;
                var20.n = var13;
                var20.b = (int)((double)var4 + 0.5D);
                var20.c = (int)((double)var6 + 0.5D);
            }

            var20.k = var15;
            var20.l = var16;
            var20.m = var17;
            var18.a.put(var20, var20);
            if (var15 == 1) {
                Log.d("annotlayer", "put tile: w:" + var20.b + " h:" + var20.c);
            }

            return var20;
        }
    }

    final void a(long var1, int var3, long var4, long var6, int var8, int var9, int var10, int var11) {
        e var12;
        if (var3 >= 0 && var1 >= 0L && (var12 = this.a(var3, var1, 1)) != null) {
            var12.e = var8;
            var12.f = var9;
            var12.g = (int)((double)var4 + 0.5D);
            var12.h = (int)((double)var6 + 0.5D);
            var12.b = var10;
            var12.c = var11;
            this.c(var3, 1).a.put(var12, var12);
        }

    }

    final void a(long var1, int var3, int var4) {
        e var5;
        if (var3 >= 0 && var1 >= 0L && (var5 = this.a(var3, var1, 1)) != null) {
            var5.m = var4;
            this.c(var3, 1).a.put(var5, var5);
        }

    }

    class a {
        private int a;

        a(f var1, int var2) {
            this.a = var2;
        }

        public final boolean equals(Object var1) {
            if (var1 instanceof f.a) {
                f.a var2 = (f.a)var1;
                return this.a == var2.a;
            } else {
                return false;
            }
        }

        public final int hashCode() {
            return this.a;
        }
    }

    class b {
        HashMap<e, e> a = new HashMap();
        int b;

        b() {
            this.b = f.this.a;
        }
    }
}
