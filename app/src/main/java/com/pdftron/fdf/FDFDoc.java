//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.fdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.filters.Filter;
import com.pdftron.sdf.Obj;
import com.pdftron.sdf.SDFDoc;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FDFDoc {
    private long a;

    public FDFDoc() throws PDFNetException {
        this.a = FDFDocCreate();
    }

    public FDFDoc(SDFDoc var1) throws PDFNetException {
        if (var1.__GetRefHandle() != null) {
            throw new PDFNetException("false", 36L, "FDFDoc.java", "FDFDoc(SDFDoc)", "SDFDoc is already owned by another document.");
        } else {
            this.a = var1.__GetHandle();
            var1.__SetRef(this);
        }
    }

    public FDFDoc(String var1) throws PDFNetException {
        this.a = FDFDocCreate(var1);
    }

    public FDFDoc(Filter var1) throws PDFNetException {
        var1.__SetRefHandle(this);
        this.a = FDFDocCreate(var1.__GetHandle());
    }

    public FDFDoc(byte[] var1) throws PDFNetException {
        this.a = FDFDocCreate(var1);
    }

    public FDFDoc(InputStream var1) throws PDFNetException, IOException {
        this(var1, 1048576);
    }

    public FDFDoc(InputStream var1, int var2) throws PDFNetException, IOException {
        long var3 = 0L;

        try {
            var3 = MemStreamCreateMemFilt((long)var1.available());
            byte[] var8 = new byte[var2];

            int var5;
            while((var5 = var1.read(var8)) != -1) {
                MemStreamWriteData(var3, var8, var5);
            }

            this.a = MemStreamCreateDoc(var3);
        } catch (PDFNetException var6) {
            Filter.__Create(var3, (Filter)null).destroy();
            throw var6;
        } catch (IOException var7) {
            Filter.__Create(var3, (Filter)null).destroy();
            throw var7;
        }
    }

    protected void finalize() throws Throwable {
        this.close();
    }

    public void close() throws PDFNetException {
        if (this.a != 0L) {
            Close(this.a);
            this.a = 0L;
        }

    }

    public boolean isModified() throws PDFNetException {
        return IsModified(this.a);
    }

    public void save(String var1) throws PDFNetException {
        Save(this.a, var1);
    }

    public byte[] save() throws PDFNetException {
        return Save(this.a);
    }

    public void save(OutputStream var1) throws PDFNetException, IOException {
        this.save(var1, 1048576);
    }

    public void save(OutputStream var1, int var2) throws PDFNetException, IOException {
        long[] var3;
        long var4 = (var3 = SaveStream(this.a))[0];
        long var6 = var3[1];
        byte[] var11 = new byte[var2];

        for(long var9 = var6 - (long)var2; var4 < var9; var4 += (long)var2) {
            ReadData(var11, var2, var4);
            var1.write(var11);
        }

        if ((var2 = (int)(var6 - var4)) > 0) {
            ReadData(var11, var2, var4);
            var1.write(var11, 0, var2);
        }

    }

    public Obj getTrailer() throws PDFNetException {
        return Obj.__Create(GetTrailer(this.a), this);
    }

    public Obj getRoot() throws PDFNetException {
        return Obj.__Create(GetRoot(this.a), this);
    }

    public Obj getFDF() throws PDFNetException {
        return Obj.__Create(GetFDF(this.a), this);
    }

    public String getPDFFileName() throws PDFNetException {
        return GetPDFFileName(this.a);
    }

    public void setPDFFileName(String var1) throws PDFNetException {
        SetPDFFileName(this.a, var1);
    }

    public Obj getID() throws PDFNetException {
        return Obj.__Create(GetID(this.a), this);
    }

    public void setID(Obj var1) throws PDFNetException {
        SetID(this.a, var1.__GetHandle());
    }

    public FDFFieldIterator getFieldIterator() throws PDFNetException {
        return new FDFFieldIterator(GetFieldIteratorBegin(this.a), this);
    }

    public FDFFieldIterator getFieldIterator(String var1) throws PDFNetException {
        return new FDFFieldIterator(GetFieldIterator(this.a, var1), this);
    }

    public FDFField getField(String var1) throws PDFNetException {
        long var2;
        return (var2 = GetField(this.a, var1)) != 0L ? new FDFField(var2, this) : null;
    }

    public FDFField fieldCreate(String var1, int var2) throws PDFNetException {
        return new FDFField(FieldCreate(this.a, var1, var2, 0L), this);
    }

    public FDFField fieldCreate(String var1, int var2, Obj var3) throws PDFNetException {
        return new FDFField(FieldCreate(this.a, var1, var2, var3.__GetHandle()), this);
    }

    public FDFField fieldCreate(String var1, int var2, String var3) throws PDFNetException {
        return new FDFField(FieldCreate(this.a, var1, var2, var3), this);
    }

    public SDFDoc getSDFDoc() {
        return SDFDoc.__Create(this.a, this);
    }

    public static FDFDoc createFromXFDF(String var0) throws PDFNetException {
        if (var0 == null) {
            throw new PDFNetException("false", 454L, "FDFDoc.java", "createFromXFDF(String)", "Argument may not be null.");
        } else {
            return new FDFDoc(CreateFromXFDF(var0));
        }
    }

    public void saveAsXFDF(String var1) throws PDFNetException {
        SaveAsXFDF(this.a, var1);
    }

    public String saveAsXFDF() throws PDFNetException {
        return SaveAsXFDF(this.a);
    }

    public void mergeAnnots(String var1) throws PDFNetException {
        MergeAnnots(this.a, var1, "");
    }

    public void mergeAnnots(String var1, String var2) throws PDFNetException {
        MergeAnnots(this.a, var1, var2);
    }

    public long __GetHandle() {
        return this.a;
    }

    public static FDFDoc __Create(long var0) {
        return new FDFDoc(var0);
    }

    private FDFDoc(long var1) {
        this.a = var1;
    }

    static native long FDFDocCreate();

    static native long FDFDocCreate(String var0);

    static native long FDFDocCreate(long var0);

    static native long FDFDocCreate(byte[] var0);

    static native long MemStreamCreateMemFilt(long var0) throws PDFNetException;

    static native void MemStreamWriteData(long var0, byte[] var2, int var3);

    static native long MemStreamCreateDoc(long var0);

    static native void Close(long var0);

    static native boolean IsModified(long var0);

    static native void Save(long var0, String var2);

    static native byte[] Save(long var0);

    static native long[] SaveStream(long var0);

    static native void ReadData(byte[] var0, int var1, long var2);

    static native long GetTrailer(long var0);

    static native long GetRoot(long var0);

    static native long GetFDF(long var0);

    static native String GetPDFFileName(long var0);

    static native void SetPDFFileName(long var0, String var2);

    static native long GetID(long var0);

    static native void SetID(long var0, long var2);

    static native long GetFieldIteratorBegin(long var0);

    static native long GetFieldIterator(long var0, String var2);

    static native long GetField(long var0, String var2);

    static native long FieldCreate(long var0, String var2, int var3, long var4);

    static native long FieldCreate(long var0, String var2, int var3, String var4);

    static native long CreateFromXFDF(String var0);

    static native long SaveAsXFDF(long var0, String var2);

    static native String SaveAsXFDF(long var0);

    static native long MergeAnnots(long var0, String var2, String var3);
}
