//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.sdf;

public class SecurityHandler implements Cloneable {
    public static final int e_owner = 1;
    public static final int e_doc_open = 2;
    public static final int e_doc_modify = 3;
    public static final int e_print = 4;
    public static final int e_print_high = 5;
    public static final int e_extract_content = 6;
    public static final int e_mod_annot = 7;
    public static final int e_fill_forms = 8;
    public static final int e_access_support = 9;
    public static final int e_assemble_doc = 10;
    public static final int e_RC4_40 = 1;
    public static final int e_RC4_128 = 2;
    public static final int e_AES = 3;
    public static final int e_AES_256 = 4;
    long a;
    Object b;

    public boolean getPermission(int var1) {
        return GetPermission(this.a, var1);
    }

    public Object clone() {
        return new SecurityHandler(Clone(this.a), (Object)null);
    }

    public int getKeyLength() {
        return GetKeyLength(this.a);
    }

    public int getEncryptionAlgorithmID() {
        return GetEncryptionAlgorithmID(this.a);
    }

    public String getHandlerDocName() {
        return GetHandlerDocName(this.a);
    }

    public boolean isModified() {
        return IsModified(this.a);
    }

    public void setModified() {
        SetModified(this.a, true);
    }

    public void setModified(boolean var1) {
        SetModified(this.a, var1);
    }

    public SecurityHandler(int var1) {
        this.a = SecurityHandlerCreate(var1);
        this.b = null;
    }

    public SecurityHandler(int var1, int var2) {
        this.a = SecurityHandlerCreate(var1, var2);
        this.b = null;
    }

    public SecurityHandler() {
        this.a = SecurityHandlerCreate();
        this.b = null;
    }

    protected void finalize() throws Throwable {
        this.destroy();
    }

    public void destroy() {
        if (this.a != 0L && this.b == null) {
            Destroy(this.a);
            this.a = 0L;
        }

    }

    public void changeUserPassword(String var1) {
        ChangeUserPassword(this.a, var1);
    }

    public void changeUserPassword(byte[] var1) {
        ChangeUserPasswordBuffer(this.a, var1);
    }

    public String getUserPassword() {
        return GetUserPassword(this.a);
    }

    public void changeMasterPassword(String var1) {
        ChangeMasterPassword(this.a, var1);
    }

    public void changeMasterPassword(byte[] var1) {
        ChangeMasterPasswordBuffer(this.a, var1);
    }

    public String getMasterPassword() {
        return GetMasterPassword(this.a);
    }

    public void setPermission(int var1, boolean var2) {
        SetPermission(this.a, var1, var2);
    }

    public void changeRevisionNumber(int var1) {
        ChangeRevisionNumber(this.a, var1);
    }

    public void setEncryptMetadata(boolean var1) {
        SetEncryptMetadata(this.a, var1);
    }

    public int getRevisionNumber() {
        return GetRevisionNumber(this.a);
    }

    public boolean isUserPasswordRequired() {
        return IsUserPasswordRequired(this.a);
    }

    public boolean isMasterPasswordRequired() {
        return IsMasterPasswordRequired(this.a);
    }

    public boolean isAES() {
        return IsAES(this.a);
    }

    public boolean isAES(Obj var1) {
        return IsAES(this.a, var1.a);
    }

    public boolean isRC4() {
        return IsRC4(this.a);
    }

    private SecurityHandler(long var1, Object var3) {
        this.a = var1;
        this.b = var3;
    }

    public static SecurityHandler __Create(long var0, Object var2) {
        return new SecurityHandler(var0, var2);
    }

    public long __GetHandle() {
        return this.a;
    }

    public void __SetRefHandle(Object var1) {
        this.b = var1;
    }

    static native boolean GetPermission(long var0, int var2);

    static native long Clone(long var0);

    static native int GetKeyLength(long var0);

    static native int GetEncryptionAlgorithmID(long var0);

    static native String GetHandlerDocName(long var0);

    static native boolean IsModified(long var0);

    static native void SetModified(long var0, boolean var2);

    static native long SecurityHandlerCreate(int var0);

    static native long SecurityHandlerCreate(int var0, int var1);

    static native long SecurityHandlerCreate();

    static native void Destroy(long var0);

    static native void ChangeUserPassword(long var0, String var2);

    static native String GetUserPassword(long var0);

    static native void ChangeMasterPassword(long var0, String var2);

    static native String GetMasterPassword(long var0);

    static native void SetPermission(long var0, int var2, boolean var3);

    static native void ChangeRevisionNumber(long var0, int var2);

    static native void SetEncryptMetadata(long var0, boolean var2);

    static native int GetRevisionNumber(long var0);

    static native boolean IsUserPasswordRequired(long var0);

    static native boolean IsMasterPasswordRequired(long var0);

    static native boolean IsAES(long var0);

    static native boolean IsAES(long var0, long var2);

    static native boolean IsRC4(long var0);

    static native void ChangeUserPasswordBuffer(long var0, byte[] var2);

    static native void ChangeMasterPasswordBuffer(long var0, byte[] var2);
}
