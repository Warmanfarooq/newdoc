//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.pdf.VerificationOptions.TimeMode;

public class TrustVerificationResult {
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

    public TrustVerificationResult(long var1) {
        this.a = var1;
    }

    public boolean wasSuccessful() throws PDFNetException {
        return WasSuccessful(this.a);
    }

    public String getResultString() throws PDFNetException {
        return GetResultString(this.a);
    }

    public long getTimeOfTrustVerification() throws PDFNetException {
        return GetTimeOfTrustVerification(this.a);
    }

    public TimeMode getTimeOfTrustVerificationEnum() throws PDFNetException {
        return TimeMode.a(GetTimeOfTrustVerificationEnum(this.a));
    }

    public long __GetHandle() {
        return this.a;
    }

    static native void Destroy(long var0);

    static native boolean WasSuccessful(long var0);

    static native String GetResultString(long var0);

    static native long GetTimeOfTrustVerification(long var0);

    static native int GetTimeOfTrustVerificationEnum(long var0);
}
