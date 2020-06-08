//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

public class WordToPDFOptions extends ConversionOptions {
    public WordToPDFOptions() throws PDFNetException {
    }

    public WordToPDFOptions(String var1) throws PDFNetException {
        super(var1);
    }

    final long a() throws PDFNetException {
        return this.mDict.__GetHandle();
    }

    public String getLayoutResourcesPluginPath() throws PDFNetException {
        Obj var1;
        return (var1 = this.mDict.findObj("LayoutResourcesPluginPath")) != null && !var1.isNull() ? var1.getAsPDFText() : "";
    }

    public WordToPDFOptions setLayoutResourcesPluginPath(String var1) throws PDFNetException {
        this.mDict.putString("LayoutResourcesPluginPath", var1);
        return this;
    }

    public String getResourceDocPath() throws PDFNetException {
        Obj var1;
        return (var1 = this.mDict.findObj("ResourceDocPath")) != null && !var1.isNull() ? var1.getAsPDFText() : "";
    }

    public WordToPDFOptions setResourceDocPath(String var1) throws PDFNetException {
        this.mDict.putString("ResourceDocPath", var1);
        return this;
    }

    public String getSmartSubstitutionPluginPath() throws PDFNetException {
        Obj var1;
        return (var1 = this.mDict.findObj("SmartSubstitutionPluginPath")) != null && !var1.isNull() ? var1.getAsPDFText() : "";
    }

    public WordToPDFOptions setSmartSubstitutionPluginPath(String var1) throws PDFNetException {
        this.mDict.putString("SmartSubstitutionPluginPath", var1);
        return this;
    }
}
