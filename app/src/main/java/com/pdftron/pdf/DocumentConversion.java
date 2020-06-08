//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;

public class DocumentConversion {
    public static final int e_success = 0;
    public static final int e_incomplete = 1;
    public static final int e_failure = 2;
    private long a;

    public void destroy() throws PDFNetException {
        if (this.a != 0L) {
            Destroy(this.a);
            this.a = 0L;
        }

    }

    protected void finalize() throws Throwable {
        this.destroy();
    }

    public DocumentConversion(long var1) {
        this.a = var1;
    }

    public int tryConvert() throws PDFNetException {
        return TryConvert(this.a);
    }

    public void convert() throws PDFNetException {
        Convert(this.a);
    }

    public void convertNextPage() throws PDFNetException {
        ConvertNextPage(this.a);
    }

    public PDFDoc getDoc() throws PDFNetException {
        return PDFDoc.__Create(GetDoc(this.a));
    }

    public int getConversionStatus() throws PDFNetException {
        return GetConversionStatus(this.a);
    }

    public void cancelConversion() throws PDFNetException {
        CancelConversion(this.a);
    }

    public boolean isCancelled() throws PDFNetException {
        return IsCancelled(this.a);
    }

    public boolean hasProgressTracking() throws PDFNetException {
        return HasProgressTracking(this.a);
    }

    public double getProgress() throws PDFNetException {
        return GetProgress(this.a);
    }

    public String getProgressLabel() throws PDFNetException {
        return GetProgressLabel(this.a);
    }

    public int getNumConvertedPages() throws PDFNetException {
        return GetNumConvertedPages(this.a);
    }

    public String getErrorString() throws PDFNetException {
        return GetErrorString(this.a);
    }

    public int getNumWarnings() throws PDFNetException {
        return GetNumWarnings(this.a);
    }

    public String getWarningString(int var1) throws PDFNetException {
        return GetWarningString(this.a, var1);
    }

    public long __GetHandle() {
        return this.a;
    }

    public static DocumentConversion __Create(long var0) {
        return new DocumentConversion(var0);
    }

    static native void Destroy(long var0);

    static native int TryConvert(long var0);

    static native void Convert(long var0);

    static native void ConvertNextPage(long var0);

    static native long GetDoc(long var0);

    static native int GetConversionStatus(long var0);

    static native void CancelConversion(long var0);

    static native boolean IsCancelled(long var0);

    static native boolean HasProgressTracking(long var0);

    static native double GetProgress(long var0);

    static native String GetProgressLabel(long var0);

    static native int GetNumConvertedPages(long var0);

    static native String GetErrorString(long var0);

    static native int GetNumWarnings(long var0);

    static native String GetWarningString(long var0, int var2);
}
