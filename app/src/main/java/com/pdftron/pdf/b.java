//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import android.graphics.Rect;

final class b {
    private final Object a;
    private Rect[] b;
    private int c;

    private b() {
        this.a = new Object();
        this.b = new Rect[4096];
    }

    public final Rect a() {
        synchronized(this.a) {
            if (this.c > 0) {
                int var2 = this.c - 1;
                Rect var3 = this.b[var2];
                this.b[var2] = null;
                --this.c;
                if (var3 == null) {
                    var3 = new Rect();
                }

                return var3;
            } else {
                return new Rect();
            }
        }
    }

    public final void a(Rect var1) {
        if (var1 != null) {
            var1.set(0, 0, 0, 0);
            synchronized(this.a) {
                if (this.b == null) {
                    this.b = new Rect[4096];
                }

                if (this.c < 4096) {
                    this.b[this.c] = var1;
                    ++this.c;
                }

            }
        }
    }

    public final void a(int var1) {
        if (64 > 4096 - this.c) {
            var1 = 4096 - this.c;
        }

        for(int var2 = 0; var2 < var1; ++var2) {
            this.a(new Rect());
        }

    }

    public final void b() {
        synchronized(this.a) {
            this.b = null;
            this.c = 0;
        }
    }

    static class a {
         static final b a = new b((byte)0);
    }
}
