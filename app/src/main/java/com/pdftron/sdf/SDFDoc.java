//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.sdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.filters.Filter;
import com.pdftron.filters.FilterReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class SDFDoc extends Doc {
    /** @deprecated */
    public static final int e_incremental = 1;
    /** @deprecated */
    public static final int e_remove_unused = 2;
    /** @deprecated */
    public static final int e_hex_strings = 4;
    /** @deprecated */
    public static final int e_omit_xref = 8;
    /** @deprecated */
    public static final int e_linearized = 16;
    /** @deprecated */
    public static final int e_compatibility = 32;
    private Object a;

    public SDFDoc() throws PDFNetException {
        this.impl = SDFDocCreate();
        this.a = null;
    }

    public SDFDoc(String var1) throws PDFNetException {
        this.impl = SDFDocCreate(var1);
        this.a = null;
    }

    public SDFDoc(Filter var1) throws PDFNetException {
        var1.__SetRefHandle(this);
        this.impl = SDFDocCreate(var1.__GetHandle());
        this.a = null;
    }

    public SDFDoc(byte[] var1) throws PDFNetException {
        this.impl = SDFDocCreate(var1);
    }

    public SDFDoc(InputStream var1) throws PDFNetException, IOException {
        this(var1, 1048576);
    }

    public SDFDoc(InputStream var1, int var2) throws PDFNetException, IOException {
        long var3 = 0L;

        try {
            var3 = MemStreamCreateMemFilt((long)var1.available());
            byte[] var8 = new byte[var2];

            int var5;
            while((var5 = var1.read(var8)) != -1) {
                MemStreamWriteData(var3, var8, var5);
            }

            this.impl = MemStreamCreateDoc(var3);
        } catch (PDFNetException var6) {
            Filter.__Create(var3, (Filter)null).destroy();
            throw var6;
        } catch (IOException var7) {
            Filter.__Create(var3, (Filter)null).destroy();
            throw var7;
        }
    }

    public void close() throws PDFNetException {
        if (this.impl != 0L && this.a == null) {
            Destroy(this.impl);
            this.impl = 0L;
        }

    }

    protected void finalize() throws Throwable {
        this.close();
    }

    public boolean isEncrypted() throws PDFNetException {
        return IsEncrypted(this.impl);
    }

    public boolean initSecurityHandler() throws PDFNetException {
        return InitSecurityHandler(this.impl, (Object)null);
    }

    public boolean initSecurityHandler(Object var1) throws PDFNetException {
        return InitSecurityHandler(this.impl, var1);
    }

    public boolean initStdSecurityHandler(String var1) throws PDFNetException {
        return InitStdSecurityHandler(this.impl, var1);
    }

    public boolean initStdSecurityHandler(byte[] var1) throws PDFNetException {
        return InitStdSecurityHandlerBuffer(this.impl, var1);
    }

    public boolean isModified() throws PDFNetException {
        return IsModified(this.impl);
    }

    public boolean hasRepairedXRef() throws PDFNetException {
        return HasRepairedXRef(this.impl);
    }

    public void enableDiskCaching(boolean var1) {
        EnableDiskCaching(this.impl, var1);
    }

    public boolean isFullSaveRequired() throws PDFNetException {
        return IsFullSaveRequired(this.impl);
    }

    /** @deprecated */
    public boolean canSaveToPath(String var1, long var2) throws PDFNetException {
        return CanSaveToPath(this.impl, var1, var2);
    }

    public boolean canSaveToPath(String var1, SDFDoc.SaveMode var2) throws PDFNetException {
        return CanSaveToPath(this.impl, var1, (long)var2.getValue());
    }

    public Obj getTrailer() throws PDFNetException {
        return Obj.__Create(GetTrailer(this.impl), this);
    }

    public Obj getObj(long var1) throws PDFNetException {
        return Obj.__Create(GetObj(this.impl, var1), this);
    }

    public Obj importObj(Obj var1, boolean var2) throws PDFNetException {
        return Obj.__Create(ImportObj(this.impl, var1.a, var2), this);
    }

    public Obj[] importObjs(Obj[] var1) throws PDFNetException {
        return this.importObjs(var1, (Obj[])null);
    }

    public Obj[] importObjs(Obj[] var1, Obj[] var2) throws PDFNetException {
        long[] var3 = new long[var1.length];
        long[] var4 = null;

        int var5;
        for(var5 = 0; var5 < var3.length; ++var5) {
            var3[var5] = var1[var5].a;
        }

        if (var2 != null) {
            var4 = new long[var2.length];

            for(var5 = 0; var5 < var4.length; ++var5) {
                var4[var5] = var2[var5].a;
            }
        }

        long[] var7;
        var1 = new Obj[(var7 = ImportObjs(this.impl, var3, var4)).length];

        for(int var6 = 0; var6 < var7.length; ++var6) {
            var1[var6] = Obj.__Create(var7[var6], this);
        }

        return var1;
    }

    public long xRefSize() throws PDFNetException {
        return XRefSize(this.impl);
    }

    public void clearMarks() throws PDFNetException {
        ClearMarks(this.impl);
    }

    /** @deprecated */
    public void save(String var1, long var2, ProgressMonitor var4, String var5) throws PDFNetException {
        Save(this.impl, var1, var2, var4, var5);
    }

    public void save(String var1, SDFDoc.SaveMode var2, ProgressMonitor var3, String var4) throws PDFNetException {
        Save(this.impl, var1, (long)var2.getValue(), var3, var4);
    }

    /** @deprecated */
    public byte[] save(long var1, ProgressMonitor var3, String var4) throws PDFNetException {
        return Save(this.impl, var1, var3, var4);
    }

    public byte[] save(SDFDoc.SaveMode var1, ProgressMonitor var2, String var3) throws PDFNetException {
        return Save(this.impl, (long)var1.getValue(), var2, var3);
    }

    /** @deprecated */
    public void save(OutputStream var1, long var2, ProgressMonitor var4, String var5) throws PDFNetException, IOException {
        this.save(var1, var2, var4, var5, 1048576);
    }

    public void save(OutputStream var1, SDFDoc.SaveMode var2, ProgressMonitor var3, String var4) throws PDFNetException, IOException {
        this.save(var1, (long)var2.getValue(), var3, var4, 1048576);
    }

    /** @deprecated */
    public void save(OutputStream var1, long var2, ProgressMonitor var4, String var5, int var6) throws PDFNetException, IOException {
        long[] var15;
        long var8 = (var15 = SaveStream(this.impl, var2, var4, var5))[0];
        long var10 = var15[1];
        byte[] var16 = new byte[var6];

        for(long var13 = var10 - (long)var6; var8 < var13; var8 += (long)var6) {
            ReadData(var16, var6, var8);
            var1.write(var16);
        }

        int var3;
        if ((var3 = (int)(var10 - var8)) > 0) {
            ReadData(var16, var3, var8);
            var1.write(var16, 0, var3);
        }

    }

    public void save(OutputStream var1, SDFDoc.SaveMode var2, ProgressMonitor var3, String var4, int var5) throws PDFNetException, IOException {
        this.save(var1, (long)var2.getValue(), var3, var4, var5);
    }

    public String getHeader() throws PDFNetException {
        return GetHeader(this.impl);
    }

    public SecurityHandler getSecurityHandler() {
        return SecurityHandler.__Create(GetSecurityHandler(this.impl), this);
    }

    public void setSecurityHandler(SecurityHandler var1) {
        var1.b = this;
        SetSecurityHandler(this.impl, var1.a);
    }

    public void swap(long var1, long var3) throws PDFNetException {
        Swap(this.impl, var1, var3);
    }

    public Obj createIndirectName(String var1) throws PDFNetException {
        return Obj.__Create(CreateIndirectName(this.impl, var1), this);
    }

    public Obj createIndirectArray() throws PDFNetException {
        return Obj.__Create(CreateIndirectArray(this.impl), this);
    }

    public Obj createIndirectBool(boolean var1) throws PDFNetException {
        return Obj.__Create(CreateIndirectBool(this.impl, var1), this);
    }

    public Obj createIndirectDict() throws PDFNetException {
        return Obj.__Create(CreateIndirectDict(this.impl), this);
    }

    public Obj createIndirectNull() throws PDFNetException {
        return Obj.__Create(CreateIndirectNull(this.impl), this);
    }

    public Obj createIndirectNumber(double var1) throws PDFNetException {
        return Obj.__Create(CreateIndirectNumber(this.impl, var1), this);
    }

    public Obj createIndirectString(byte[] var1) throws PDFNetException {
        return Obj.__Create(CreateIndirectString(this.impl, var1), this);
    }

    public Obj createIndirectString(String var1) throws PDFNetException {
        return Obj.__Create(CreateIndirectString(this.impl, var1), this);
    }

    public Obj createIndirectStream(FilterReader var1) throws PDFNetException {
        return Obj.__Create(CreateIndirectStream(this.impl, var1.__GetHandle(), 0L), this);
    }

    public Obj createIndirectStream(FilterReader var1, Filter var2) throws PDFNetException {
        if (var2 != null) {
            var2.__SetRefHandle(this);
        }

        return Obj.__Create(CreateIndirectStream(this.impl, var1.__GetHandle(), var2.__GetHandle()), this);
    }

    public Obj createIndirectStream(byte[] var1) throws PDFNetException {
        return Obj.__Create(CreateIndirectStream(this.impl, var1, 0L), this);
    }

    public Obj createIndirectStream(byte[] var1, Filter var2) throws PDFNetException {
        if (var2 != null) {
            var2.__SetRefHandle(this);
        }

        return Obj.__Create(CreateIndirectStream(this.impl, var1, var2.__GetHandle()), this);
    }

    public boolean isLinearized() throws PDFNetException {
        return IsLinearized(this.impl);
    }

    public Obj getLinearizationDict() throws PDFNetException {
        return Obj.__Create(GetLinearizationDict(this.impl), this);
    }

    public Obj getHintStream() throws PDFNetException {
        return Obj.__Create(GetHintStream(this.impl), this);
    }

    public void lock() throws PDFNetException {
        Lock(this.impl);
    }

    public void unlock() throws PDFNetException {
        Unlock(this.impl);
    }

    public boolean timedLock(int var1) throws PDFNetException {
        return TryLock(this.impl, var1);
    }

    public void lockRead() throws PDFNetException {
        LockRead(this.impl);
    }

    public void unlockRead() throws PDFNetException {
        UnlockRead(this.impl);
    }

    public boolean tryLockRead() throws PDFNetException {
        return TryLockRead(this.impl, 0);
    }

    public boolean timedLockRead(int var1) throws PDFNetException {
        return TryLockRead(this.impl, var1);
    }

    public String getFileName() throws PDFNetException {
        return GetFileName(this.impl);
    }

    SDFDoc(long var1, Object var3) {
        this.impl = var1;
        this.a = var3;
    }

    public static SDFDoc __Create(long var0, Object var2) {
        return new SDFDoc(var0, var2);
    }

    public void __SetRef(Object var1) {
        this.a = var1;
    }

    public Object __GetRefHandle() {
        return this.a;
    }

    public long __GetHandle() {
        return this.impl;
    }

    public void removeSecurity() {
        RemoveSecurity(this.impl);
    }

    static native long SDFDocCreate();

    static native long SDFDocCreate(String var0);

    static native long SDFDocCreate(long var0);

    static native long SDFDocCreate(byte[] var0);

    static native long MemStreamCreateMemFilt(long var0) throws PDFNetException;

    static native void MemStreamWriteData(long var0, byte[] var2, int var3);

    static native long MemStreamCreateDoc(long var0);

    static native void Destroy(long var0);

    static native boolean IsEncrypted(long var0);

    static native boolean InitSecurityHandler(long var0, Object var2);

    static native boolean InitStdSecurityHandler(long var0, String var2);

    static native boolean InitStdSecurityHandlerBuffer(long var0, byte[] var2);

    static native boolean IsModified(long var0);

    static native boolean HasRepairedXRef(long var0);

    static native boolean IsFullSaveRequired(long var0);

    static native boolean CanSaveToPath(long var0, String var2, long var3);

    static native void EnableDiskCaching(long var0, boolean var2);

    static native long GetTrailer(long var0);

    static native long GetObj(long var0, long var2);

    static native long ImportObj(long var0, long var2, boolean var4);

    static native long[] ImportObjs(long var0, long[] var2, long[] var3);

    static native long XRefSize(long var0);

    static native void ClearMarks(long var0);

    static native void Save(long var0, String var2, long var3, ProgressMonitor var5, String var6);

    static native byte[] Save(long var0, long var2, ProgressMonitor var4, String var5);

    static native long[] SaveStream(long var0, long var2, ProgressMonitor var4, String var5);

    static native void ReadData(byte[] var0, int var1, long var2);

    static native String GetHeader(long var0);

    static native long GetSecurityHandler(long var0);

    static native void SetSecurityHandler(long var0, long var2);

    static native void RemoveSecurity(long var0);

    static native void Swap(long var0, long var2, long var4);

    static native long CreateIndirectName(long var0, String var2);

    static native long CreateIndirectArray(long var0);

    static native long CreateIndirectBool(long var0, boolean var2);

    static native long CreateIndirectDict(long var0);

    static native long CreateIndirectNull(long var0);

    static native long CreateIndirectNumber(long var0, double var2);

    static native long CreateIndirectString(long var0, byte[] var2);

    static native long CreateIndirectString(long var0, String var2);

    static native long CreateIndirectStream(long var0, long var2, long var4);

    static native long CreateIndirectStream(long var0, byte[] var2, long var3);

    static native boolean IsLinearized(long var0);

    static native long GetLinearizationDict(long var0);

    static native long GetHintStream(long var0);

    static native void Lock(long var0);

    static native void Unlock(long var0);

    static native boolean TryLock(long var0, int var2);

    static native void LockRead(long var0);

    static native void UnlockRead(long var0);

    static native boolean TryLockRead(long var0, int var2);

    static native String GetFileName(long var0);

    public static enum SaveMode {
        INCREMENTAL(1),
        REMOVE_UNUSED(2),
        HEX_STRINGS(4),
        OMIT_XREF(8),
        LINEARIZED(16),
        COMPATIBILITY(32),
        NO_FLAGS(0);

        private final int a;

        private SaveMode(int var3) {
            this.a = var3;
        }

        public final int getValue() {
            return this.a;
        }
    }
}
