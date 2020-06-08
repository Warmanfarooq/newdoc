//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;
import java.util.HashMap;

public class DigitalSignatureField extends h {
    private static final DigitalSignatureField.SubFilterType[] a = DigitalSignatureField.SubFilterType.values();
    private long d;
    private Object e;

    public DigitalSignatureField(Field var1) throws PDFNetException {
        this.d = Create(var1.__GetHandle());
        this.e = var1.__GetRefHandle();
        this.clearList();
    }

    public boolean hasCryptographicSignature() throws PDFNetException {
        return HasCryptographicSignature(this.d);
    }

    public DigitalSignatureField.SubFilterType getSubFilter() throws PDFNetException {
        return a[GetSubFilter(this.d)];
    }

    public String getSignatureName() throws PDFNetException {
        return GetSignatureName(this.d);
    }

    public Date getSigningTime() throws PDFNetException {
        return new Date(GetSigningTime(this.d));
    }

    public String getLocation() throws PDFNetException {
        return GetLocation(this.d);
    }

    public String getReason() throws PDFNetException {
        return GetReason(this.d);
    }

    public String getContactInfo() throws PDFNetException {
        return GetContactInfo(this.d);
    }

    public byte[] getCert(int var1) throws PDFNetException {
        return GetCert(this.d, var1);
    }

    public int getCertCount() throws PDFNetException {
        return GetCertCount(this.d);
    }

    public boolean hasVisibleAppearance() throws PDFNetException {
        return HasVisibleAppearance(this.d);
    }

    public void setContactInfo(String var1) throws PDFNetException {
        SetContactInfo(this.d, var1);
    }

    public void setLocation(String var1) throws PDFNetException {
        SetLocation(this.d, var1);
    }

    public void setReason(String var1) throws PDFNetException {
        SetReason(this.d, var1);
    }

    public void setDocumentPermissions(DigitalSignatureField.DocumentPermissions var1) throws PDFNetException {
        SetDocumentPermissions(this.d, var1.a);
    }

    public void setFieldPermissions(DigitalSignatureField.FieldPermissions var1, String[] var2) throws PDFNetException {
        SetFieldPermissions(this.d, var1.ordinal(), var2);
    }

    public void setFieldPermissions(DigitalSignatureField.FieldPermissions var1) throws PDFNetException {
        SetFieldPermissions(this.d, var1.ordinal());
    }

    public void signOnNextSave(String var1, String var2) throws PDFNetException {
        SignOnNextSave(this.d, var1, var2);
    }

    public void signOnNextSave(byte[] var1, String var2) throws PDFNetException {
        SignOnNextSave(this.d, var1, var2);
    }

    public void signOnNextSaveWithCustomHandler(long var1) throws PDFNetException {
        SignOnNextSaveWithCustomHandler(this.d, var1);
    }

    public void certifyOnNextSave(String var1, String var2) throws PDFNetException {
        CertifyOnNextSave(this.d, var1, var2);
    }

    public void certifyOnNextSave(byte[] var1, String var2) throws PDFNetException {
        CertifyOnNextSave(this.d, var1, var2);
    }

    public void certifyOnNextSaveWithCustomHandler(long var1) throws PDFNetException {
        CertifyOnNextSaveWithCustomHandler(this.d, var1);
    }

    public Obj getSDFObj() throws PDFNetException {
        return Obj.__Create(GetSDFObj(this.d), this.e);
    }

    public boolean isLockedByDigitalSignature() throws PDFNetException {
        return IsLockedByDigitalSignature(this.d);
    }

    public String[] getLockedFields() throws PDFNetException {
        return GetLockedFields(this.d);
    }

    public DigitalSignatureField.DocumentPermissions getDocumentPermissions() throws PDFNetException {
        return DigitalSignatureField.DocumentPermissions.a(GetDocumentPermissions(this.d));
    }

    public void clearSignature() throws PDFNetException {
        ClearSignature(this.d);
    }

    public VerificationResult verify(VerificationOptions var1) throws PDFNetException {
        return new VerificationResult(Verify(this.d, var1.__GetHandle()), this.__GetRefHandle());
    }

    public long __GetHandle() {
        return this.d;
    }

    DigitalSignatureField(long var1, Object var3) throws PDFNetException {
        this.d = var1;
        this.e = var3;
        this.clearList();
    }

    public static DigitalSignatureField __Create(long var0, Object var2) throws PDFNetException {
        return var0 == 0L ? null : new DigitalSignatureField(var0, var2);
    }

    public void destroy() throws PDFNetException {
        if (this.d != 0L && !(this.e instanceof DigitalSignatureFieldIterator)) {
            Destroy(this.d);
            this.d = 0L;
        }

    }

    protected void finalize() throws Throwable {
        this.destroy();
    }

    public Object __GetRefHandle() {
        return this.e;
    }

    static native void Destroy(long var0);

    static native long Create(long var0);

    static native boolean HasCryptographicSignature(long var0);

    static native int GetSubFilter(long var0);

    static native String GetSignatureName(long var0);

    static native long GetSigningTime(long var0);

    static native String GetLocation(long var0);

    static native String GetReason(long var0);

    static native String GetContactInfo(long var0);

    static native byte[] GetCert(long var0, int var2);

    static native int GetCertCount(long var0);

    static native boolean HasVisibleAppearance(long var0);

    static native void SetContactInfo(long var0, String var2);

    static native void SetLocation(long var0, String var2);

    static native void SetReason(long var0, String var2);

    static native void SetDocumentPermissions(long var0, int var2);

    static native void SetFieldPermissions(long var0, int var2, String[] var3);

    static native void SetFieldPermissions(long var0, int var2);

    static native void SignOnNextSave(long var0, String var2, String var3);

    static native void SignOnNextSave(long var0, byte[] var2, String var3);

    static native void SignOnNextSaveWithCustomHandler(long var0, long var2);

    static native void CertifyOnNextSave(long var0, String var2, String var3);

    static native void CertifyOnNextSave(long var0, byte[] var2, String var3);

    static native void CertifyOnNextSaveWithCustomHandler(long var0, long var2);

    static native long GetSDFObj(long var0);

    static native boolean IsLockedByDigitalSignature(long var0);

    static native String[] GetLockedFields(long var0);

    static native int GetDocumentPermissions(long var0);

    static native void ClearSignature(long var0);

    static native long Verify(long var0, long var2);

    public static enum FieldPermissions {
        e_lock_all,
        e_include,
        e_exclude;

        private FieldPermissions() {
        }
    }

    public static enum DocumentPermissions {
        e_no_changes_allowed(1),
        e_formfilling_signing_allowed(2),
        e_annotating_formfilling_signing_allowed(3),
        e_unrestricted(4);

        final int a;
        private static HashMap<Integer, DigitalSignatureField.DocumentPermissions> b = new HashMap();

        private DocumentPermissions(int var3) {
            this.a = var3;
        }

        static DigitalSignatureField.DocumentPermissions a(int var0) {
            return (DigitalSignatureField.DocumentPermissions)b.get(var0);
        }

        static {
            DigitalSignatureField.DocumentPermissions[] var0;
            int var1 = (var0 = values()).length;

            for(int var2 = 0; var2 < var1; ++var2) {
                DigitalSignatureField.DocumentPermissions var3 = var0[var2];
                b.put(var3.a, var3);
            }

        }
    }

    public static enum SubFilterType {
        e_adbe_x509_rsa_sha1,
        e_adbe_pkcs7_detached,
        e_adbe_pkcs7_sha1,
        e_ETSI_CAdES_detached,
        e_ETSI_RFC3161,
        e_unknown,
        e_absent;

        private SubFilterType() {
        }
    }
}
