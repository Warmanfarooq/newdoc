//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

public class Date {
    long a;

    public Date() throws PDFNetException {
        this.a = DateCreate();
    }

    public Date(Obj var1) throws PDFNetException {
        this.a = DateCreate(var1.__GetHandle());
    }

    public Date(short var1, byte var2, byte var3, byte var4, byte var5, byte var6) throws PDFNetException {
        this.a = DateCreate(var1, var2, var3, var4, var5, var6);
    }

    public boolean isValid() throws PDFNetException {
        return IsValid(this.a);
    }

    public boolean equals(Object var1) {
        return var1 != null && var1.getClass().equals(this.getClass()) ? Equals(this.a, ((Date)var1).a) : false;
    }

    public int hashCode() {
        return HashCode(this.a);
    }

    public void attach(Obj var1) throws PDFNetException {
        Attach(this.a, var1.__GetHandle());
    }

    public boolean update() throws PDFNetException {
        return Update(this.a, 0L);
    }

    public boolean update(Obj var1) throws PDFNetException {
        return Update(this.a, var1.__GetHandle());
    }

    public void setCurrentTime() {
        SetCurrentTime(this.a);
    }

    public short getYear() throws PDFNetException {
        return GetYear(this.a);
    }

    public byte getMonth() throws PDFNetException {
        return GetMonth(this.a);
    }

    public byte getDay() throws PDFNetException {
        return GetDay(this.a);
    }

    public byte getHour() throws PDFNetException {
        return GetHour(this.a);
    }

    public byte getMinute() throws PDFNetException {
        return GetMinute(this.a);
    }

    public byte getSecond() throws PDFNetException {
        return GetSecond(this.a);
    }

    public byte getUT() throws PDFNetException {
        return GetUT(this.a);
    }

    public byte getUTHour() throws PDFNetException {
        return GetUTHour(this.a);
    }

    public byte getUTMinutes() throws PDFNetException {
        return GetUTMinutes(this.a);
    }

    public void setYear(short var1) throws PDFNetException {
        SetYear(this.a, var1);
    }

    public void setMonth(byte var1) throws PDFNetException {
        SetMonth(this.a, var1);
    }

    public void setDay(byte var1) throws PDFNetException {
        SetDay(this.a, var1);
    }

    public void setHour(byte var1) throws PDFNetException {
        SetHour(this.a, var1);
    }

    public void setMinute(byte var1) throws PDFNetException {
        SetMinute(this.a, var1);
    }

    public void setSecond(byte var1) throws PDFNetException {
        SetSecond(this.a, var1);
    }

    public void setUT(byte var1) throws PDFNetException {
        SetUT(this.a, var1);
    }

    public void setUTHour(byte var1) throws PDFNetException {
        SetUTHour(this.a, var1);
    }

    public void seUTMinutes(byte var1) throws PDFNetException {
        SetUTMinutes(this.a, var1);
    }

    Date(long var1) {
        this.a = var1;
    }

    public static Date __Create(long var0) {
        return var0 == 0L ? null : new Date(var0);
    }

    public long __GetHandle() {
        return this.a;
    }

    static native long DateCreate();

    static native long DateCreate(long var0);

    static native long DateCreate(short var0, byte var1, byte var2, byte var3, byte var4, byte var5);

    static native boolean IsValid(long var0);

    static native boolean Equals(long var0, long var2);

    static native int HashCode(long var0);

    static native void Attach(long var0, long var2);

    static native boolean Update(long var0, long var2);

    static native boolean SetCurrentTime(long var0);

    static native short GetYear(long var0);

    static native byte GetMonth(long var0);

    static native byte GetDay(long var0);

    static native byte GetHour(long var0);

    static native byte GetMinute(long var0);

    static native byte GetSecond(long var0);

    static native byte GetUT(long var0);

    static native byte GetUTHour(long var0);

    static native byte GetUTMinutes(long var0);

    static native void SetYear(long var0, short var2);

    static native void SetMonth(long var0, byte var2);

    static native void SetDay(long var0, byte var2);

    static native void SetHour(long var0, byte var2);

    static native void SetMinute(long var0, byte var2);

    static native void SetSecond(long var0, byte var2);

    static native void SetUT(long var0, byte var2);

    static native void SetUTHour(long var0, byte var2);

    static native void SetUTMinutes(long var0, byte var2);
}
