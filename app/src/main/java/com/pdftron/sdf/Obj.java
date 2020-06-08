//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.sdf;

import com.pdftron.common.Matrix2D;
import com.pdftron.common.PDFNetException;
import com.pdftron.filters.Filter;
import com.pdftron.filters.FilterWriter;
import com.pdftron.helpers.DoubleRectangle2D;

public class Obj {
    public static final int e_null = 0;
    public static final int e_bool = 1;
    public static final int e_number = 2;
    public static final int e_name = 3;
    public static final int e_string = 4;
    public static final int e_dict = 5;
    public static final int e_array = 6;
    public static final int e_stream = 7;
    long a;
    Object b;

    public int getType() throws PDFNetException {
        return GetType(this.a);
    }

    public boolean isBool() throws PDFNetException {
        return IsBool(this.a);
    }

    public boolean isNumber() throws PDFNetException {
        return IsNumber(this.a);
    }

    public boolean isNull() throws PDFNetException {
        return IsNull(this.a);
    }

    public boolean isString() throws PDFNetException {
        return IsString(this.a);
    }

    public boolean isName() throws PDFNetException {
        return IsName(this.a);
    }

    public boolean isIndirect() throws PDFNetException {
        return IsIndirect(this.a);
    }

    public boolean isContainer() throws PDFNetException {
        return IsContainer(this.a);
    }

    public boolean isDict() throws PDFNetException {
        return IsDict(this.a);
    }

    public boolean isArray() throws PDFNetException {
        return IsArray(this.a);
    }

    public boolean isStream() throws PDFNetException {
        return IsStream(this.a);
    }

    public SDFDoc getDoc() throws PDFNetException {
        return new SDFDoc(GetDoc(this.a), this.b);
    }

    public void write(FilterWriter var1) throws PDFNetException {
        Write(this.a, var1.__GetHandle());
    }

    public long size() throws PDFNetException {
        return Size(this.a);
    }

    public long getObjNum() throws PDFNetException {
        return GetObjNum(this.a);
    }

    public short getGenNum() throws PDFNetException {
        return GetGenNum(this.a);
    }

    public long getOffset() throws PDFNetException {
        return GetOffset(this.a);
    }

    public boolean isFree() throws PDFNetException {
        return IsFree(this.a);
    }

    public void setMark(boolean var1) throws PDFNetException {
        SetMark(this.a, var1);
    }

    public boolean isMarked() throws PDFNetException {
        return IsMarked(this.a);
    }

    public boolean isLoaded() throws PDFNetException {
        return IsLoaded(this.a);
    }

    public boolean isEqual(Obj var1) throws PDFNetException {
        return IsEqual(this.a, var1.a);
    }

    public boolean getBool() throws PDFNetException {
        return GetBool(this.a);
    }

    public void setBool(boolean var1) throws PDFNetException {
        SetBool(this.a, var1);
    }

    public double getNumber() throws PDFNetException {
        return GetNumber(this.a);
    }

    public void setNumber(double var1) throws PDFNetException {
        SetNumber(this.a, var1);
    }

    public byte[] getBuffer() throws PDFNetException {
        return GetBuffer(this.a);
    }

    public byte[] getRawBuffer() throws PDFNetException {
        return GetRawBuffer(this.a);
    }

    public String getAsPDFText() throws PDFNetException {
        return GetAsPDFText(this.a);
    }

    public void setString(byte[] var1) throws PDFNetException {
        SetString(this.a, var1);
    }

    public void setString(String var1) throws PDFNetException {
        SetString(this.a, var1);
    }

    public String getName() throws PDFNetException {
        return GetName(this.a);
    }

    public void setName(String var1) throws PDFNetException {
        SetName(this.a, var1);
    }

    public DictIterator getDictIterator() throws PDFNetException {
        return new DictIterator(GetDictIterator(this.a), this.b);
    }

    public DictIterator find(String var1) throws PDFNetException {
        return new DictIterator(Find(this.a, var1), this.b);
    }

    public Obj findObj(String var1) throws PDFNetException {
        return __Create(FindObj(this.a, var1), this.b);
    }

    public DictIterator get(String var1) throws PDFNetException {
        return new DictIterator(Get(this.a, var1), this.b);
    }

    public Obj putName(String var1, String var2) throws PDFNetException {
        return __Create(PutName(this.a, var1, var2), this.b);
    }

    public Obj putArray(String var1) throws PDFNetException {
        return __Create(PutArray(this.a, var1), this.b);
    }

    public Obj putBool(String var1, boolean var2) throws PDFNetException {
        return __Create(PutBool(this.a, var1, var2), this.b);
    }

    public Obj putDict(String var1) throws PDFNetException {
        return __Create(PutDict(this.a, var1), this.b);
    }

    public Obj putNumber(String var1, double var2) throws PDFNetException {
        return __Create(PutNumber(this.a, var1, var2), this.b);
    }

    public Obj putString(String var1, String var2) throws PDFNetException {
        return __Create(PutString(this.a, var1, var2), this.b);
    }

    public Obj putString(String var1, byte[] var2) throws PDFNetException {
        return __Create(PutString(this.a, var1, var2), this.b);
    }

    public Obj putText(String var1, String var2) throws PDFNetException {
        return __Create(PutText(this.a, var1, var2), this.b);
    }

    public void putNull(String var1) throws PDFNetException {
        PutNull(this.a, var1);
    }

    public Obj put(String var1, Obj var2) throws PDFNetException {
        return __Create(Put(this.a, var1, var2.a), this.b);
    }

    public Obj putRect(String var1, double var2, double var4, double var6, double var8) throws PDFNetException {
        return __Create(PutRect(this.a, var1, var2, var4, var6, var8), this.b);
    }

    public Obj putRect(String var1, DoubleRectangle2D var2) throws PDFNetException {
        return __Create(PutRect(this.a, var1, var2.x, var2.y, var2.x + var2.width, var2.y + var2.height), this.b);
    }

    public Obj putMatrix(String var1, Matrix2D var2) throws PDFNetException {
        return __Create(PutMatrix(this.a, var1, var2.__GetHandle()), this.b);
    }

    public void erase(String var1) throws PDFNetException {
        Erase(this.a, var1);
    }

    public void erase(DictIterator var1) throws PDFNetException {
        Erase(this.a, var1.__GetHandle());
    }

    public boolean rename(String var1, String var2) throws PDFNetException {
        return Rename(this.a, var1, var2);
    }

    public Obj getAt(int var1) throws PDFNetException {
        return __Create(GetAt(this.a, var1), this.b);
    }

    public Obj insertName(int var1, String var2) throws PDFNetException {
        return __Create(InsertName(this.a, var1, var2), this.b);
    }

    public Obj insertArray(int var1) throws PDFNetException {
        return __Create(InsertArray(this.a, var1), this.b);
    }

    public Obj insertBool(int var1, boolean var2) throws PDFNetException {
        return __Create(InsertBool(this.a, var1, var2), this.b);
    }

    public Obj insertDict(int var1) throws PDFNetException {
        return __Create(InsertDict(this.a, var1), this.b);
    }

    public Obj insertNumber(int var1, double var2) throws PDFNetException {
        return __Create(InsertNumber(this.a, var1, var2), this.b);
    }

    public Obj insertString(int var1, String var2) throws PDFNetException {
        return __Create(InsertString(this.a, var1, var2), this.b);
    }

    public Obj insertString(int var1, byte[] var2) throws PDFNetException {
        return __Create(InsertString(this.a, var1, var2), this.b);
    }

    public Obj insertText(int var1, String var2) throws PDFNetException {
        return __Create(InsertText(this.a, var1, var2), this.b);
    }

    public Obj insertNull(int var1) throws PDFNetException {
        return __Create(InsertNull(this.a, var1), this.b);
    }

    public Obj insert(int var1, Obj var2) throws PDFNetException {
        return __Create(Insert(this.a, var1, var2.a), this.b);
    }

    public Obj insertRect(int var1, double var2, double var4, double var6, double var8) throws PDFNetException {
        return __Create(InsertRect(this.a, var1, var2, var4, var6, var8), this.b);
    }

    public Obj insertRect(int var1, DoubleRectangle2D var2) throws PDFNetException {
        return __Create(InsertRect(this.a, var1, var2.x, var2.y, var2.x + var2.width, var2.y + var2.height), this.b);
    }

    public Obj insertMatrix(int var1, Matrix2D var2) throws PDFNetException {
        return __Create(InsertMatrix(this.a, var1, var2.__GetHandle()), this.b);
    }

    public Obj pushBackName(String var1) throws PDFNetException {
        return __Create(PushBackName(this.a, var1), this.b);
    }

    public Obj pushBackArray() throws PDFNetException {
        return __Create(PushBackArray(this.a), this.b);
    }

    public Obj pushBackBool(boolean var1) throws PDFNetException {
        return __Create(PushBackBool(this.a, var1), this.b);
    }

    public Obj pushBackDict() throws PDFNetException {
        return __Create(PushBackDict(this.a), this.b);
    }

    public Obj pushBackNumber(double var1) throws PDFNetException {
        return __Create(PushBackNumber(this.a, var1), this.b);
    }

    public Obj pushBackString(String var1) throws PDFNetException {
        return __Create(PushBackString(this.a, var1), this.b);
    }

    public Obj pushBackString(byte[] var1) throws PDFNetException {
        return __Create(PushBackString(this.a, var1), this.b);
    }

    public Obj pushBackText(String var1) throws PDFNetException {
        return __Create(PushBackText(this.a, var1), this.b);
    }

    public Obj pushBackNull() throws PDFNetException {
        return __Create(PushBackNull(this.a), this.b);
    }

    public Obj pushBack(Obj var1) throws PDFNetException {
        return __Create(PushBack(this.a, var1.a), this.b);
    }

    public Obj pushBackRect(double var1, double var3, double var5, double var7) throws PDFNetException {
        return __Create(PushBackRect(this.a, var1, var3, var5, var7), this.b);
    }

    public Obj pushBackRect(DoubleRectangle2D var1) throws PDFNetException {
        return __Create(PushBackRect(this.a, var1.x, var1.y, var1.x + var1.width, var1.y + var1.height), this.b);
    }

    public Obj pushBackMatrix(Matrix2D var1) throws PDFNetException {
        return __Create(PushBackMatrix(this.a, var1.__GetHandle()), this.b);
    }

    public void eraseAt(int var1) throws PDFNetException {
        EraseAt(this.a, var1);
    }

    public long getRawStreamLength() throws PDFNetException {
        return GetRawStreamLength(this.a);
    }

    public Filter getRawStream(boolean var1) throws PDFNetException {
        return Filter.__Create(GetRawStream(this.a, var1), (Filter)null);
    }

    public Filter getDecodedStream() throws PDFNetException {
        return Filter.__Create(GetDecodedStream(this.a), (Filter)null);
    }

    public void setStreamData(byte[] var1, Filter var2) throws PDFNetException {
        if (var2 != null) {
            var2.__SetRefHandle(this);
        }

        SetStreamData(this.a, var1, var2.__GetHandle());
    }

    private Obj(long var1, Object var3) {
        this.a = var1;
        this.b = var3;
    }

    public static Obj __Create(long var0, Object var2) {
        return var0 == 0L ? null : new Obj(var0, var2);
    }

    public long __GetHandle() {
        return this.a;
    }

    public Object __GetRefHandle() {
        return this.b;
    }

    static native int GetType(long var0);

    static native long GetDoc(long var0);

    static native void Write(long var0, long var2);

    static native boolean IsEqual(long var0, long var2);

    static native boolean IsBool(long var0);

    static native boolean GetBool(long var0);

    static native void SetBool(long var0, boolean var2);

    static native boolean IsNumber(long var0);

    static native double GetNumber(long var0);

    static native void SetNumber(long var0, double var2);

    static native boolean IsNull(long var0);

    static native boolean IsString(long var0);

    static native byte[] GetBuffer(long var0);

    static native byte[] GetRawBuffer(long var0);

    static native String GetAsPDFText(long var0);

    static native void SetString(long var0, byte[] var2);

    static native void SetString(long var0, String var2);

    static native boolean IsName(long var0);

    static native String GetName(long var0);

    static native void SetName(long var0, String var2);

    static native boolean IsIndirect(long var0);

    static native long GetObjNum(long var0);

    static native short GetGenNum(long var0);

    static native long GetOffset(long var0);

    static native boolean IsFree(long var0);

    static native void SetMark(long var0, boolean var2);

    static native boolean IsMarked(long var0);

    static native boolean IsLoaded(long var0);

    static native boolean IsContainer(long var0);

    static native long Size(long var0);

    static native long GetDictIterator(long var0);

    static native boolean IsDict(long var0);

    static native long Find(long var0, String var2);

    static native long FindObj(long var0, String var2);

    static native long Get(long var0, String var2);

    static native long PutName(long var0, String var2, String var3);

    static native long PutArray(long var0, String var2);

    static native long PutBool(long var0, String var2, boolean var3);

    static native long PutDict(long var0, String var2);

    static native long PutNumber(long var0, String var2, double var3);

    static native long PutString(long var0, String var2, String var3);

    static native long PutString(long var0, String var2, byte[] var3);

    static native long PutText(long var0, String var2, String var3);

    static native void PutNull(long var0, String var2);

    static native long Put(long var0, String var2, long var3);

    static native long PutRect(long var0, String var2, double var3, double var5, double var7, double var9);

    static native long PutMatrix(long var0, String var2, long var3);

    static native void Erase(long var0, String var2);

    static native void Erase(long var0, long var2);

    static native boolean Rename(long var0, String var2, String var3);

    static native boolean IsArray(long var0);

    static native long GetAt(long var0, int var2);

    static native long InsertName(long var0, int var2, String var3);

    static native long InsertArray(long var0, int var2);

    static native long InsertBool(long var0, int var2, boolean var3);

    static native long InsertDict(long var0, int var2);

    static native long InsertNumber(long var0, int var2, double var3);

    static native long InsertString(long var0, int var2, String var3);

    static native long InsertString(long var0, int var2, byte[] var3);

    static native long InsertText(long var0, int var2, String var3);

    static native long InsertNull(long var0, int var2);

    static native long Insert(long var0, int var2, long var3);

    static native long InsertRect(long var0, int var2, double var3, double var5, double var7, double var9);

    static native long InsertMatrix(long var0, int var2, long var3);

    static native long PushBackName(long var0, String var2);

    static native long PushBackArray(long var0);

    static native long PushBackBool(long var0, boolean var2);

    static native long PushBackDict(long var0);

    static native long PushBackNumber(long var0, double var2);

    static native long PushBackString(long var0, String var2);

    static native long PushBackString(long var0, byte[] var2);

    static native long PushBackText(long var0, String var2);

    static native long PushBackNull(long var0);

    static native long PushBack(long var0, long var2);

    static native long PushBackRect(long var0, double var2, double var4, double var6, double var8);

    static native long PushBackMatrix(long var0, long var2);

    static native void EraseAt(long var0, int var2);

    static native boolean IsStream(long var0);

    static native long GetRawStreamLength(long var0);

    static native long GetRawStream(long var0, boolean var2);

    static native long GetDecodedStream(long var0);

    static native void SetStreamData(long var0, byte[] var2, long var3);
}
