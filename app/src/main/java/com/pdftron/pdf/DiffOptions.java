//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

public class DiffOptions extends OptionsBase {
    public DiffOptions() throws PDFNetException {
    }

    public DiffOptions(String var1) throws PDFNetException {
        super(var1);
    }

    final long a() throws PDFNetException {
        return this.mDict.__GetHandle();
    }

    public boolean getAddGroupAnnots() throws PDFNetException {
        Obj var1;
        return !(var1 = this.mDict.findObj("AddGroupAnnots")).isNull() ? var1.getBool() : false;
    }

    public DiffOptions setAddGroupAnnots(boolean var1) throws PDFNetException {
        this.mDict.putBool("AddGroupAnnots", var1);
        return this;
    }

    public int getBlendMode() throws PDFNetException {
        Obj var1;
        return !(var1 = this.mDict.findObj("BlendMode")).isNull() ? (int)var1.getNumber() : 5;
    }

    public DiffOptions setBlendMode(int var1) throws PDFNetException {
        this.mDict.putNumber("BlendMode", (double)var1);
        return this;
    }

    public ColorPt getColorA() throws PDFNetException {
        Obj var1;
        return !(var1 = this.mDict.findObj("ColorA")).isNull() ? a(var1.getNumber()) : a(-3407872.0D);
    }

    public DiffOptions setColorA(ColorPt var1) throws PDFNetException {
        this.mDict.putNumber("ColorA", a(var1));
        return this;
    }

    public ColorPt getColorB() throws PDFNetException {
        Obj var1;
        return !(var1 = this.mDict.findObj("ColorB")).isNull() ? a(var1.getNumber()) : a(-1.6724788E7D);
    }

    public DiffOptions setColorB(ColorPt var1) throws PDFNetException {
        this.mDict.putNumber("ColorB", a(var1));
        return this;
    }
}
