//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import java.util.HashMap;

public class VerificationOptions {
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

    public VerificationOptions(long var1) {
        this.a = var1;
    }

    public VerificationOptions(VerificationOptions.SecurityLevel var1) throws PDFNetException {
        this.a = Create(var1.a);
    }

    public void addTrustedCertificate(byte[] var1) throws PDFNetException {
        AddTrustedCertificate(this.a, var1);
    }

    public void removeTrustedCertificate(byte[] var1) throws PDFNetException {
        RemoveTrustedCertificate(this.a, var1);
    }

    public void enableModificationVerification(boolean var1) throws PDFNetException {
        EnableModificationVerification(this.a, var1);
    }

    public void enableDigestVerification(boolean var1) throws PDFNetException {
        EnableDigestVerification(this.a, var1);
    }

    public void enableTrustVerification(boolean var1) throws PDFNetException {
        EnableTrustVerification(this.a, var1);
    }

    public long __GetHandle() {
        return this.a;
    }

    static native void Destroy(long var0);

    static native long Create(int var0);

    static native void AddTrustedCertificate(long var0, byte[] var2);

    static native void RemoveTrustedCertificate(long var0, byte[] var2);

    static native void EnableModificationVerification(long var0, boolean var2);

    static native void EnableDigestVerification(long var0, boolean var2);

    static native void EnableTrustVerification(long var0, boolean var2);

    public static enum TimeMode {
        e_signing(0),
        e_timestamp(1),
        e_current(2);

        private int a;
        private static HashMap<Integer, VerificationOptions.TimeMode> b = new HashMap();

        private TimeMode(int var3) {
            this.a = var3;
        }

        static VerificationOptions.TimeMode a(int var0) {
            return (VerificationOptions.TimeMode)b.get(var0);
        }

        static {
            VerificationOptions.TimeMode[] var0;
            int var1 = (var0 = values()).length;

            for(int var2 = 0; var2 < var1; ++var2) {
                VerificationOptions.TimeMode var3 = var0[var2];
                b.put(var3.a, var3);
            }

        }
    }

    public static enum SecurityLevel {
        e_compatibility_and_archiving(0),
        e_maximum(1);

        final int a;
        private static HashMap<Integer, VerificationOptions.SecurityLevel> b = new HashMap();

        private SecurityLevel(int var3) {
            this.a = var3;
        }

        static {
            VerificationOptions.SecurityLevel[] var0;
            int var1 = (var0 = values()).length;

            for(int var2 = 0; var2 < var1; ++var2) {
                VerificationOptions.SecurityLevel var3 = var0[var2];
                b.put(var3.a, var3);
            }

        }
    }
}
