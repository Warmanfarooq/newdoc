//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

public class CADConvertOptions extends OptionsBase {
    public CADConvertOptions() throws PDFNetException {
    }

    public CADConvertOptions(String var1) throws PDFNetException {
        super(var1);
    }

    final long a() throws PDFNetException {
        return this.mDict.__GetHandle();
    }

    public boolean getLineWeight() throws PDFNetException {
        Obj var1;
        return (var1 = this.mDict.findObj("Line-weight")) != null ? var1.getBool() : false;
    }

    public CADConvertOptions setLineWeight(boolean var1) throws PDFNetException {
        this.putBool("Line-weight", var1);
        return this;
    }

    public boolean getAutoRotate() throws PDFNetException {
        Obj var1;
        return (var1 = this.mDict.findObj("Auto-rotate")) != null ? var1.getBool() : false;
    }

    public CADConvertOptions setAutoRotate(boolean var1) throws PDFNetException {
        this.putBool("Auto-rotate", var1);
        return this;
    }

    public double getPageHeight() throws PDFNetException {
        Obj var1;
        return (var1 = this.mDict.findObj("Page-height")) != null ? var1.getNumber() : 594.0D;
    }

    public CADConvertOptions setPageHeight(double var1) throws PDFNetException {
        this.putNumber("Page-height", var1);
        return this;
    }

    public double getPageWidth() throws PDFNetException {
        Obj var1;
        return (var1 = this.mDict.findObj("Page-width")) != null ? var1.getNumber() : 840.0D;
    }

    public CADConvertOptions setPageWidth(double var1) throws PDFNetException {
        this.putNumber("Page-width", var1);
        return this;
    }

    public double getRasterDPI() throws PDFNetException {
        Obj var1;
        return (var1 = this.mDict.findObj("Raster-dpi")) != null ? var1.getNumber() : 72.0D;
    }

    public CADConvertOptions setRasterDPI(double var1) throws PDFNetException {
        this.putNumber("Raster-dpi", var1);
        return this;
    }

    public CADConvertOptions addSheets(String var1) throws PDFNetException {
        this.pushBackText("Sheets", var1);
        return this;
    }
}
