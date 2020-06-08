//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;
import com.pdftron.sdf.ObjSet;

public class OptionsBase {
    protected ObjSet mObjSet = new ObjSet();
    protected Obj mDict;

    public OptionsBase() throws PDFNetException {
        this.mDict = this.mObjSet.createDict();
    }

    public OptionsBase(String var1) throws PDFNetException {
        this.mDict = this.mObjSet.createFromJson(var1);
    }

    long a() throws PDFNetException {
        return this.mDict.__GetHandle();
    }

    private Obj a(String var1) throws PDFNetException {
        Obj var2;
        if ((var2 = this.mDict.findObj(var1)) == null) {
            var2 = this.mDict.putArray(var1);
        }

        return var2;
    }

    static ColorPt a(double var0) throws PDFNetException {
        long var2 = (long)var0;
        return new ColorPt((double)(var2 >> 16 & 255L) / 255.0D, (double)(var2 >> 8 & 255L) / 255.0D, (double)(var2 & 255L) / 255.0D, (double)(var2 >> 24 & 255L) / 255.0D);
    }

    static double a(ColorPt var0) throws PDFNetException {
        long var1 = (long)(255.0D * var0.get(0));
        long var3 = (long)(255.0D * var0.get(1));
        long var5 = (long)(255.0D * var0.get(2));
        return (double)(4278190080L | (255L & var1) << 16 | (255L & var3) << 8 | 255L & var5);
    }

    protected void putNumber(String var1, double var2) throws PDFNetException {
        this.mDict.putNumber(var1, var2);
    }

    protected void putBool(String var1, Boolean var2) throws PDFNetException {
        this.mDict.putBool(var1, var2);
    }

    protected void putText(String var1, String var2) throws PDFNetException {
        this.mDict.putText(var1, var2);
    }

    protected void putRect(String var1, Rect var2) throws PDFNetException {
        this.mDict.putRect(var1, var2.getX1(), var2.getY1(), var2.getX2(), var2.getY2());
    }

    protected void pushBackNumber(String var1, double var2) throws PDFNetException {
        this.a(var1).pushBackNumber(var2);
    }

    protected void pushBackBool(String var1, Boolean var2) throws PDFNetException {
        this.a(var1).pushBackBool(var2);
    }

    protected void pushBackText(String var1, String var2) throws PDFNetException {
        this.a(var1).pushBackText(var2);
    }

    protected void pushBackRect(String var1, Rect var2) throws PDFNetException {
        this.a(var1).pushBackRect(var2.getX1(), var2.getY1(), var2.getX2(), var2.getY2());
    }

    protected void insertRectCollection(String var1, RectCollection var2, int var3) throws PDFNetException {
        Obj var5 = this.a(var1);

        while(var5.size() <= (long)var3) {
            var5.pushBackArray();
        }

        var5 = var5.getAt(var3);

        for(var3 = 0; var3 < var2.getNumRects(); ++var3) {
            Rect var4 = var2.getRectAt(var3);
            var5.pushBackRect(var4.getX1(), var4.getY1(), var4.getX2(), var4.getY2());
        }

    }

    protected static Rect rectFromArray(Obj var0) throws PDFNetException {
        return new Rect(var0.getAt(0).getNumber(), var0.getAt(1).getNumber(), var0.getAt(2).getNumber(), var0.getAt(3).getNumber());
    }
}
