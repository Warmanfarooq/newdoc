//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;

public class CurvePainter {
    public static final int DRAW_MODE_PATH = 0;
    public static final int DRAW_MODE_LINES = 1;
    private byte[] a;
    private double[] b = new double[2];
    private double[] c = new double[2];
    private double[] d = new double[2];
    private double[] e = new double[2];
    private double[] f = new double[2];
    private double[] g = new double[6];
    private int h = 0;
    private int i = 0;
    private int j = 0;
    private boolean k;
    private ArrayList<float[]> l;
    private int m = 0;
    private Path n;
    private Bitmap o;
    private int[] p;
    private Paint q;
    private Paint r;
    private int s;
    private int t;
    private float u;
    private int v;
    private boolean w;
    private Rect x;

    public static CurvePainter create(CurvePainter var0) {
        if (var0 == null) {
            return null;
        } else {
            CurvePainter var1;
            if (var0.getBuffer() != null) {
                var1 = new CurvePainter(var0.getBuffer());
            } else {
                var1 = new CurvePainter(var0.getBitmap());
            }

            var1.setRect(var0.getRect());
            var1.setMultBlend(var0.getMultBlend());
            return var1;
        }
    }

    public CurvePainter(Bitmap var1) {
        this.a();
        this.o = var1;
    }

    public CurvePainter(String var1) throws UnsupportedEncodingException {
        this.a();
        this.a = var1.getBytes("US-ASCII");
    }

    public CurvePainter(int[] var1) {
        this.a();
        this.p = var1;
        int var2 = var1.length - 1;

        int var3;
        for(var3 = 0; var2 >= 0 && var1[var2] == 0; --var2) {
        }

        int var4;
        if (var2 >= 0) {
            for(var4 = var1[var2]; var3 < 4 && (var4 >> (3 - var3 << 3) & 255) == 0; ++var3) {
            }
        }

        this.a = new byte[(var2 + 1 << 2) - var3];
        if (var2 >= 0) {
            for(var4 = 0; var4 < 4 - var3; ++var4) {
                this.a[(var2 << 2) + var4] = (byte)(var1[var2] >> (var4 << 3));
            }

            for(var4 = 0; var4 < var2; ++var4) {
                this.a[4 * var4] = (byte)var1[var4];
                this.a[4 * var4 + 1] = (byte)(var1[var4] >> 8);
                this.a[4 * var4 + 2] = (byte)(var1[var4] >> 16);
                this.a[4 * var4 + 3] = (byte)(var1[var4] >>> 24);
            }
        }

        try {
            String var6 = new String(this.a, "US-ASCII");
            Log.d("painter", var6);
        } catch (Exception var5) {
            var5.printStackTrace();
        }
    }

    private void a() {
        this.l = new ArrayList();
        this.n = new Path();
        this.q = new Paint();
        this.q.setAntiAlias(true);
        this.q.setStyle(Style.STROKE);
        this.r = new Paint(this.q);
        this.r.setStyle(Style.FILL);
        this.r.setColor(0);
    }

    public void setRect(Rect var1) {
        this.x = var1;
    }

    public Rect getRect() {
        return this.x;
    }

    public void setMultBlend(boolean var1) {
        this.w = var1;
        if (var1) {
            this.q.setXfermode(new PorterDuffXfermode(Mode.MULTIPLY));
            this.r.setXfermode(new PorterDuffXfermode(Mode.MULTIPLY));
        }

    }

    public boolean getMultBlend() {
        return this.w;
    }

    public void draw(Canvas var1, float var2, float var3, double var4, double var6, double var8, double var10) {
        this.v = 0;
        this.e[0] = var4;
        this.e[1] = var6;
        this.d[0] = (double)var2;
        this.d[1] = (double)var3;
        this.f[0] = var8;
        this.f[1] = var10;
        this.s = 0;
        this.u = 0.0F;
        this.t = 0;
        this.h = 0;
        this.i = 0;

        do {
            CurvePainter var12 = this;

            for(int var13 = 0; var13 < var12.g.length; ++var13) {
                var12.g[var13] = 0.0D;
            }

            var12.n.reset();
            var12.l.clear();
            var12.m = 0;

            for(boolean var14 = false; var12.h < var12.a.length && !var14; var14 = var12.b()) {
            }

            this.r.setColor(this.s);
            if (this.s != 0) {
                this.a(var1, this.v, this.r);
            }

            this.q.setColor(this.t);
            this.q.setStrokeWidth(this.u);
            if (this.u > 0.0F && this.t != 0) {
                this.a(var1, this.v, this.q);
            }
        } while(this.h < this.a.length);

    }

    private void a(Canvas var1, int var2, Paint var3) {
        if (var2 == 0) {
            var1.drawPath(this.n, var3);
        } else {
            var2 = 0;

            for(Iterator var4 = this.l.iterator(); var4.hasNext(); ++var2) {
                float[] var5;
                int var6 = (var5 = (float[])var4.next()).length;
                if (var2 == this.l.size() - 1) {
                    var6 = this.m;
                }

                var1.drawLines(var5, 0, var6, var3);
            }

        }
    }

    public Bitmap getBitmap() {
        return this.o;
    }

    public int[] getBuffer() {
        return this.p;
    }

    private boolean b() {
        byte var1 = this.a[this.i];
        ++this.i;
        ++this.h;

        while(this.i < this.a.length && this.a[this.i] <= 57) {
            ++this.i;
        }

        if (var1 >= 65 && var1 <= 90) {
            var1 = (byte)(var1 - 65 + 97);
            this.k = false;
        } else {
            this.k = true;
        }

        label194: {
            int var2;
            CurvePainter var13;
            switch(var1) {
                case 99:
                    var2 = this.h;
                    var13 = this;

                    do {
                        var2 = var13.b(var2, 0);
                        var2 = var13.b(var2, 1);
                        var2 = var13.b(var2, 2);
                        if (var13.j == 0) {
                            var13.b[0] = var13.c[0];
                            var13.b[1] = var13.c[1];
                        }

                        ++var13.j;
                        var13.c[0] = var13.g[4];
                        var13.c[1] = var13.g[5];
                        if (var13.v == 0) {
                            var13.n.cubicTo((float)var13.g[0], (float)var13.g[1], (float)var13.g[2], (float)var13.g[3], (float)var13.g[4], (float)var13.g[5]);
                        }
                    } while(var2 < var13.i);

                    var13.g[0] = var13.g[2];
                    var13.g[1] = var13.g[3];
                case 100:
                case 102:
                case 103:
                case 105:
                case 106:
                case 107:
                case 110:
                case 111:
                case 112:
                case 113:
                case 114:
                case 117:
                case 119:
                case 120:
                case 121:
                default:
                    break label194;
                case 101:
                    this.h = this.i;
                    return true;
                case 104:
                    var2 = this.h;
                    var13 = this;

                    do {
                        var2 = var13.a(var2, 0);
                        if (var13.j == 0) {
                            var13.b[0] = var13.c[0];
                            var13.b[1] = var13.c[1];
                        }

                        ++var13.j;
                        if (var13.v == 1) {
                            var13.a(var13.c[0]);
                            var13.a(var13.c[1]);
                            var13.a(var13.g[0]);
                            var13.a(var13.c[1]);
                        }

                        if (var13.v == 0) {
                            var13.n.lineTo((float)var13.g[0], (float)var13.c[1]);
                        }

                        var13.c[0] = var13.g[0];
                    } while(var2 < var13.i);

                    var13.g[1] = var13.c[1];
                    break label194;
                case 108:
                    this.a(this.h);
                    break label194;
                case 109:
                    var2 = this.h;
                    var2 = this.b(var2, 0);
                    this.c[0] = this.g[0];
                    this.c[1] = this.g[1];
                    if (this.v == 0) {
                        this.n.moveTo((float)this.c[0], (float)this.c[1]);
                    }

                    this.j = 0;
                    if (var2 != this.i) {
                        this.a(var2);
                    }
                    break label194;
                case 115:
                case 116:
                    var2 = this.h;
                    var13 = this;

                    while(true) {
                        var2 = var13.b(var2, 1);
                        var2 = var13.b(var2, 2);
                        if (var13.j == 0) {
                            var13.b[0] = var13.c[0];
                            var13.b[1] = var13.c[1];
                        }

                        ++var13.j;
                        var13.c[0] = var13.g[4];
                        var13.c[1] = var13.g[5];
                        if (var13.v == 0) {
                            var13.n.cubicTo((float)var13.g[0], (float)var13.g[1], (float)var13.g[2], (float)var13.g[3], (float)var13.g[4], (float)var13.g[5]);
                        }

                        var13.g[0] = var13.g[2];
                        var13.g[1] = var13.g[3];
                        if (var2 >= var13.i) {
                            break label194;
                        }
                    }
                case 118:
                    var2 = this.h;
                    var13 = this;

                    do {
                        var2 = var13.a(var2, 1);
                        if (var13.j == 0) {
                            var13.b[0] = var13.c[0];
                            var13.b[1] = var13.c[1];
                        }

                        ++var13.j;
                        if (var13.v == 1) {
                            var13.a(var13.c[0]);
                            var13.a(var13.c[1]);
                            var13.a(var13.c[0]);
                            var13.a(var13.g[1]);
                        }

                        if (var13.v == 0) {
                            var13.n.lineTo((float)var13.c[0], (float)var13.g[1]);
                        }

                        var13.c[1] = var13.g[1];
                    } while(var2 < var13.i);

                    var13.g[0] = var13.c[0];
                    break label194;
                case 122:
                    if (this.j > 0) {
                        if (this.v == 1) {
                            this.a(this.c[0]);
                            this.a(this.c[1]);
                            this.a(this.b[0]);
                            this.a(this.b[1]);
                        }

                        if (this.v == 0) {
                            this.n.lineTo((float)this.b[0], (float)this.b[1]);
                            this.n.close();
                        }

                        this.c[0] = this.b[0];
                        this.c[1] = this.b[1];
                    }

                    this.j = 0;
                    break label194;
                case 123:
            }

            while(true) {
                if (this.i >= this.a.length || this.a[this.i] == 125) {
                    try {
                        var2 = this.h;
                        String var14;
                        int var3 = (var14 = new String(this.a, var2, this.i - var2, "US-ASCII")).indexOf(58) + 1;
                        char var4 = var14.charAt(0);
                        char var10000 = var3 > 2 ? var14.charAt(1) : 0;
                        char var5 = var10000;
                        double var9;
                        if (var10000 == 0) {
                            if (var4 == 'w') {
                                var9 = Double.valueOf(var14.substring(var3));
                                this.u = (float)(var9 * (this.f[0] + this.f[1]) * 0.5D);
                            } else if (var4 == 's') {
                                this.t = (int)Long.parseLong(var14.substring(var3), 16);
                            } else if (var4 == 'f') {
                                this.s = (int)Long.parseLong(var14.substring(var3), 16);
                            } else {
                                double[] var15;
                                if (var4 == 'h') {
                                    var9 = Double.valueOf(var14.substring(var3));
                                    var15 = this.e;
                                    var15[0] *= var9;
                                    var15 = this.f;
                                    var15[0] *= var9;
                                } else if (var4 == 'v') {
                                    var9 = Double.valueOf(var14.substring(var3));
                                    var15 = this.e;
                                    var15[1] *= var9;
                                    var15 = this.f;
                                    var15[1] *= var9;
                                } else if (var4 == 'm') {
                                    if (var14.charAt(var3) == 'l') {
                                        this.v = 1;
                                    }
                                } else if (var4 == 'j') {
                                    char var12;
                                    this.q.setStrokeJoin((var12 = var14.charAt(var3)) == 'r' ? Join.ROUND : (var12 == 'b' ? Join.BEVEL : Join.MITER));
                                }
                            }
                        } else if (var4 == 's' && var5 == 'c') {
                            this.q.setStrokeCap(a(var14.charAt(var3)));
                        } else if (var4 == 'e' && var5 == 'c') {
                            this.q.setStrokeCap(a(var14.charAt(var3)));
                        } else if (var4 == 'm' && var5 == 'l') {
                            var9 = Double.valueOf(var14.substring(var3));
                            this.q.setStrokeMiter((float)var9);
                        }
                    } catch (Exception var11) {
                        var11.printStackTrace();
                    }

                    ++this.i;
                    break;
                }

                ++this.i;
            }
        }

        this.h = this.i;
        return false;
    }

    private int a(int var1, int var2) {
        int var3 = var1 + 1;

        try {
            while(var3 < this.i && this.a[var3] != 44 && this.a[var3] != 32 && this.a[var3] != 45) {
                ++var3;
            }

            this.g[var2] = (double)Float.valueOf(new String(this.a, var1, var3 - var1));
            double[] var10000 = this.g;
            var10000[var2] *= this.e[var2 & 1];
            if (this.k) {
                var10000 = this.g;
                var10000[var2] += this.c[var2 & 1];
            } else {
                var10000 = this.g;
                var10000[var2] += this.d[var2 & 1];
            }

            if (var3 != this.i && this.a[var3] == 44) {
                ++var3;
            }

            while(var3 < this.i && this.a[var3] == 32) {
                ++var3;
            }
        } catch (Exception var4) {
        }

        return var3;
    }

    private int b(int var1, int var2) {
        var1 = this.a(var1, var2 << 1);
        return this.a(var1, (var2 << 1) + 1);
    }

    private static Cap a(char var0) {
        if (var0 == 'r') {
            return Cap.ROUND;
        } else {
            return var0 == 's' ? Cap.SQUARE : Cap.BUTT;
        }
    }

    private void a(int var1) {
        do {
            var1 = this.b(var1, 0);
            if (this.j == 0) {
                this.b[0] = this.c[0];
                this.b[1] = this.c[1];
            }

            ++this.j;
            if (this.v == 1) {
                this.a(this.c[0]);
                this.a(this.c[1]);
                this.a(this.g[0]);
                this.a(this.g[1]);
            } else if (this.v == 0) {
                this.n.lineTo((float)this.g[0], (float)this.g[1]);
            }

            this.c[0] = this.g[0];
            this.c[1] = this.g[1];
        } while(var1 < this.i);

    }

    private void a(double var1) {
        try {
            if (this.l.size() == 0 || this.m == 4096) {
                this.l.add(new float[4096]);
                this.m = 0;
            }

            int var3 = this.l.size();
            ((float[])this.l.get(var3 - 1 > 0 ? var3 - 1 : 0))[this.m++] = (float)var1;
        } catch (Exception var4) {
            var4.printStackTrace();
        }
    }
}
