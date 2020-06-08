//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import java.util.HashMap;

public class VerificationResult {
    private Object a;
    private long b;

    public void destroy() throws PDFNetException {
        if (this.b != 0L) {
            Destroy(this.b);
            this.b = 0L;
        }

    }

    protected void finalize() throws Throwable {
        this.destroy();
    }

    public VerificationResult(long var1, Object var3) {
        this.b = var1;
        this.a = var3;
    }

    public DigitalSignatureField getDigitalSignatureField() throws PDFNetException {
        return DigitalSignatureField.__Create(GetDigitalSignatureField(this.__GetHandle()), this.__GetRefHandle());
    }

    public boolean getVerificationStatus() throws PDFNetException {
        return GetVerificationStatus(this.b);
    }

    public VerificationResult.DocumentStatus getDocumentStatus() throws PDFNetException {
        return VerificationResult.DocumentStatus.a(GetDocumentStatus(this.b));
    }

    public VerificationResult.DigestStatus getDigestStatus() throws PDFNetException {
        return VerificationResult.DigestStatus.a(GetDigestStatus(this.b));
    }

    public VerificationResult.TrustStatus getTrustStatus() throws PDFNetException {
        return VerificationResult.TrustStatus.a(GetTrustStatus(this.b));
    }

    public VerificationResult.ModificationPermissionsStatus getPermissionsStatus() throws PDFNetException {
        return VerificationResult.ModificationPermissionsStatus.a(GetPermissionsStatus(this.b));
    }

    public boolean hasTrustVerificationResult() throws PDFNetException {
        return HasTrustVerificationResult(this.b);
    }

    public TrustVerificationResult getTrustVerificationResult() throws PDFNetException {
        return new TrustVerificationResult(GetTrustVerificationResult(this.b));
    }

    public DisallowedChange[] getDisallowedChanges() throws PDFNetException {
        long[] var1;
        DisallowedChange[] var2 = new DisallowedChange[(var1 = GetDisallowedChanges(this.b)).length];

        for(int var3 = 0; var3 < var1.length; ++var3) {
            var2[var3] = new DisallowedChange(var1[var3]);
        }

        return var2;
    }

    public DigestAlgorithm getSignersDigestAlgorithm() throws PDFNetException {
        return DigestAlgorithm.a(GetSignersDigestAlgorithm(this.b));
    }

    public long __GetHandle() {
        return this.b;
    }

    public Object __GetRefHandle() {
        return this.a;
    }

    static native void Destroy(long var0);

    static native long GetDigitalSignatureField(long var0);

    static native boolean GetVerificationStatus(long var0);

    static native int GetDocumentStatus(long var0);

    static native int GetDigestStatus(long var0);

    static native int GetTrustStatus(long var0);

    static native int GetPermissionsStatus(long var0);

    static native boolean HasTrustVerificationResult(long var0);

    static native long GetTrustVerificationResult(long var0);

    static native long[] GetDisallowedChanges(long var0);

    static native int GetSignersDigestAlgorithm(long var0);

    public static enum ModificationPermissionsStatus {
        e_invalidated_by_disallowed_changes(0),
        e_has_allowed_changes(1),
        e_unmodified(2),
        e_permissions_verification_disabled(3),
        e_no_permissions_status(4);

        private int a;
        private static HashMap<Integer, VerificationResult.ModificationPermissionsStatus> b = new HashMap();

        private ModificationPermissionsStatus(int var3) {
            this.a = var3;
        }

        static VerificationResult.ModificationPermissionsStatus a(int var0) {
            return (VerificationResult.ModificationPermissionsStatus)b.get(var0);
        }

        static {
            VerificationResult.ModificationPermissionsStatus[] var0;
            int var1 = (var0 = values()).length;

            for(int var2 = 0; var2 < var1; ++var2) {
                VerificationResult.ModificationPermissionsStatus var3 = var0[var2];
                b.put(var3.a, var3);
            }

        }
    }

    public static enum TrustStatus {
        e_trust_verified(0),
        e_untrusted(1),
        e_trust_verification_disabled(2),
        e_no_trust_status(3);

        private int a;
        private static HashMap<Integer, VerificationResult.TrustStatus> b = new HashMap();

        private TrustStatus(int var3) {
            this.a = var3;
        }

        static VerificationResult.TrustStatus a(int var0) {
            return (VerificationResult.TrustStatus)b.get(var0);
        }

        static {
            VerificationResult.TrustStatus[] var0;
            int var1 = (var0 = values()).length;

            for(int var2 = 0; var2 < var1; ++var2) {
                VerificationResult.TrustStatus var3 = var0[var2];
                b.put(var3.a, var3);
            }

        }
    }

    public static enum DigestStatus {
        e_digest_invalid(0),
        e_digest_verified(1),
        e_digest_verification_disabled(2),
        e_weak_digest_algorithm_but_digest_verifiable(3),
        e_no_digest_status(4),
        e_unsupported_encoding(5);

        private int a;
        private static HashMap<Integer, VerificationResult.DigestStatus> b = new HashMap();

        private DigestStatus(int var3) {
            this.a = var3;
        }

        static VerificationResult.DigestStatus a(int var0) {
            return (VerificationResult.DigestStatus)b.get(var0);
        }

        static {
            VerificationResult.DigestStatus[] var0;
            int var1 = (var0 = values()).length;

            for(int var2 = 0; var2 < var1; ++var2) {
                VerificationResult.DigestStatus var3 = var0[var2];
                b.put(var3.a, var3);
            }

        }
    }

    public static enum DocumentStatus {
        e_no_error(0),
        e_corrupt_file(1),
        e_unsigned(2),
        e_bad_byteranges(3),
        e_corrupt_cryptographic_contents(4);

        private int a;
        private static HashMap<Integer, VerificationResult.DocumentStatus> b = new HashMap();

        private DocumentStatus(int var3) {
            this.a = var3;
        }

        static VerificationResult.DocumentStatus a(int var0) {
            return (VerificationResult.DocumentStatus)b.get(var0);
        }

        static {
            VerificationResult.DocumentStatus[] var0;
            int var1 = (var0 = values()).length;

            for(int var2 = 0; var2 < var1; ++var2) {
                VerificationResult.DocumentStatus var3 = var0[var2];
                b.put(var3.a, var3);
            }

        }
    }
}
