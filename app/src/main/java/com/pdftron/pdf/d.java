//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import com.pdftron.pdf.ImageCache.a;

final class d {
    private SparseArray<c> a = new SparseArray();

    d() {
    }

    final int a() {
        return this.a.size();
    }

    final int[] b() {
        int var1;
        int[] var2 = new int[var1 = this.a.size()];

        for(int var3 = 0; var3 < var1; ++var3) {
            var2[var3] = this.a.keyAt(var3);
        }

        return var2;
    }

    final c a(int var1) {
        return (c)this.a.get(var1);
    }

    final Bitmap a(int var1, Bitmap var2, Rect var3, Rect var4) {
        c var5 = new c();

        try {
            var5.a = var2;
            var5.b = var3;
            var5.c = var4;
            this.a.put(var1, var5);
        } catch (Exception var6) {
        } catch (OutOfMemoryError var7) {
            com.pdftron.pdf.ImageCache.a.a().a();
            com.pdftron.pdf.b.a.a().b();
            if (PDFViewCtrl.b) {
                PDFViewCtrl.a(4, "Don't add thumb " + var1 + " due to out of memory", PDFViewCtrl.a(false));
            } else {
                Log.e("PDFNet", "Don't add thumb " + var1 + " due to out of memory");
            }

            var5.a = null;
        }

        return var5.a;
    }

    final void b(int var1) {
        c var2;
        if ((var2 = (c)this.a.get(var1)) != null) {
            com.pdftron.pdf.ImageCache.a.a().a(var2.a);
        }

        this.a.remove(var1);
    }

    final void c() {
        ImageCache var1;
        if ((var1 = com.pdftron.pdf.ImageCache.a.a()).b()) {
            int var2 = 0;

            for(int var3 = this.a.size(); var2 < var3; ++var2) {
                c var4 = (c)this.a.valueAt(var2);
                var1.a(var4.a);
            }
        }

        this.a.clear();
    }
}
