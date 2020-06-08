
package com.pdftron.pdf;

import android.graphics.Bitmap;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class ImageCache {
    private final HashMap<ImageCache.Key, List<SoftReference<Bitmap>>> a;
    private boolean b;

    private ImageCache() {
        this.a = new HashMap(16);
        this.b = true;
    }

    final Bitmap a(int var1, int var2) {
        if (this.b && var1 > 0 && var2 > 0) {
            Bitmap var3 = null;
            if (!this.a.isEmpty()) {
                synchronized(this.a) {
                    ImageCache.Key var6 = new ImageCache.Key(this, var1, var2);
                    List var7;
                    if ((var7 = (List)this.a.get(var6)) == null || var7.isEmpty()) {
                        return null;
                    }

                    Iterator var8 = var7.iterator();

                    while(var8.hasNext()) {
                        Bitmap var9;
                        if ((var9 = (Bitmap)((SoftReference)var8.next()).get()) != null && var9.isMutable()) {
                            var3 = var9;
                            var8.remove();
                            break;
                        }

                        var8.remove();
                    }
                }
            }

            return var3;
        } else {
            return null;
        }
    }

    final void a(Bitmap var1) {
        if (this.b && var1 != null) {
            int var2 = var1.getWidth();
            int var3 = var1.getHeight();
            ImageCache.Key var6 = new ImageCache.Key(this, var2, var3);
            synchronized(this.a) {
                Object var4;
                if ((var4 = (List)this.a.get(var6)) == null) {
                    var4 = new ArrayList();
                    this.a.put(var6, (List<SoftReference<Bitmap>>) var4);
                }

                ((List)var4).add(new SoftReference(var1));
            }
        }
    }

    final void a() {
        synchronized(this.a) {
            this.a.clear();
        }
    }

    final void a(boolean var1) {
        this.b = var1;
    }

    final boolean b() {
        return this.b;
    }

    public class Key {
        private final int a;
        private final int b;

        public Key(ImageCache var1, int var2, int var3) {
            this.a = var2;
            this.b = var3;
        }

        public boolean equals(Object var1) {
            if (this == var1) {
                return true;
            } else if (var1 instanceof ImageCache.Key) {
                ImageCache.Key var2 = (ImageCache.Key)var1;
                return this.a == var2.a && this.b == var2.b;
            } else {
                return false;
            }
        }

        public int hashCode() {
            return this.a * 31 + this.b;
        }
    }

   public static class a {
        public static final ImageCache a = new ImageCache();
    }
}
