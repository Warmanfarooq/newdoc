//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import java.util.ArrayList;

public class RectCollection {
    private ArrayList<Rect> a = new ArrayList();

    public RectCollection() {
    }

    public void addRect(Rect var1) {
        this.a.add(var1);
    }

    public void addRect(double var1, double var3, double var5, double var7) throws PDFNetException {
        this.a.add(new Rect(var1, var3, var5, var7));
    }

    public Rect getRectAt(int var1) {
        return (Rect)this.a.get(var1);
    }

    public int getNumRects() {
        return this.a.size();
    }

    public void clear() {
        this.a.clear();
    }
}
