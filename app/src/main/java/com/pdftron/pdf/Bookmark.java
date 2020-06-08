//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

public class Bookmark {
    long a;
    private Object b;

    public static Bookmark create(PDFDoc var0, String var1) throws PDFNetException {
        return new Bookmark(Create(var0.__GetHandle(), var1), var0);
    }

    public Bookmark() {
        this.a = 0L;
        this.b = null;
    }

    public Bookmark(Obj var1) {
        this.a = var1.__GetHandle();
        this.b = var1.__GetRefHandle();
    }

    public boolean equals(Object var1) {
        if (var1 != null && var1.getClass().equals(this.getClass())) {
            return ((Bookmark)var1).a == this.a;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (int)this.a;
    }

    public boolean isValid() throws PDFNetException {
        return IsValid(this.a);
    }

    public boolean hasChildren() throws PDFNetException {
        return HasChildren(this.a);
    }

    public Bookmark getNext() throws PDFNetException {
        return new Bookmark(GetNext(this.a), this.b);
    }

    public Bookmark getPrev() throws PDFNetException {
        return new Bookmark(GetPrev(this.a), this.b);
    }

    public Bookmark getFirstChild() throws PDFNetException {
        return new Bookmark(GetFirstChild(this.a), this.b);
    }

    public Bookmark getLastChild() throws PDFNetException {
        return new Bookmark(GetLastChild(this.a), this.b);
    }

    public Bookmark getParent() throws PDFNetException {
        return new Bookmark(GetParent(this.a), this.b);
    }

    public Bookmark find(String var1) throws PDFNetException {
        return new Bookmark(Find(this.a, var1), this.b);
    }

    public Bookmark addChild(String var1) throws PDFNetException {
        return new Bookmark(AddChild(this.a, var1), this.b);
    }

    public void addChild(Bookmark var1) throws PDFNetException {
        AddChild(this.a, var1.a);
    }

    public Bookmark addNext(String var1) throws PDFNetException {
        return new Bookmark(AddNext(this.a, var1), this.b);
    }

    public void addNext(Bookmark var1) throws PDFNetException {
        AddNext(this.a, var1.a);
    }

    public Bookmark addPrev(String var1) throws PDFNetException {
        return new Bookmark(AddPrev(this.a, var1), this.b);
    }

    public void addPrev(Bookmark var1) throws PDFNetException {
        AddPrev(this.a, var1.a);
    }

    public void delete() throws PDFNetException {
        Delete(this.a);
    }

    public void unlink() throws PDFNetException {
        Unlink(this.a);
    }

    public int getIndent() throws PDFNetException {
        return GetIndent(this.a);
    }

    public boolean isOpen() throws PDFNetException {
        return IsOpen(this.a);
    }

    public void setOpen(boolean var1) throws PDFNetException {
        SetOpen(this.a, var1);
    }

    public int getOpenCount() throws PDFNetException {
        return GetOpenCount(this.a);
    }

    public String getTitle() throws PDFNetException {
        return GetTitle(this.a);
    }

    public Obj getTitleObj() throws PDFNetException {
        return Obj.__Create(GetTitleObj(this.a), this.b);
    }

    public void setTitle(String var1) throws PDFNetException {
        SetTitle(this.a, var1);
    }

    public Action getAction() throws PDFNetException {
        return new Action(GetAction(this.a), this.b);
    }

    public void setAction(Action var1) throws PDFNetException {
        SetAction(this.a, var1.a);
    }

    public void removeAction() throws PDFNetException {
        RemoveAction(this.a);
    }

    public int getFlags() throws PDFNetException {
        return GetFlags(this.a);
    }

    public void setFlags(int var1) throws PDFNetException {
        SetFlags(this.a, var1);
    }

    public double[] getColor() throws PDFNetException {
        return GetColor(this.a);
    }

    public void setColor() throws PDFNetException {
        SetColor(this.a, 0.0D, 0.0D, 0.0D);
    }

    public void setColor(double var1, double var3, double var5) throws PDFNetException {
        SetColor(this.a, var1, var3, var5);
    }

    public Obj getSDFObj() {
        return Obj.__Create(this.a, this.b);
    }

    Bookmark(long var1, Object var3) {
        this.a = var1;
        this.b = var3;
    }

    static native long Create(long var0, String var2);

    static native boolean IsValid(long var0);

    static native boolean HasChildren(long var0);

    static native long GetNext(long var0);

    static native long GetPrev(long var0);

    static native long GetFirstChild(long var0);

    static native long GetLastChild(long var0);

    static native long GetParent(long var0);

    static native long Find(long var0, String var2);

    static native long AddChild(long var0, String var2);

    static native void AddChild(long var0, long var2);

    static native long AddNext(long var0, String var2);

    static native void AddNext(long var0, long var2);

    static native long AddPrev(long var0, String var2);

    static native void AddPrev(long var0, long var2);

    static native void Delete(long var0);

    static native void Unlink(long var0);

    static native int GetIndent(long var0);

    static native boolean IsOpen(long var0);

    static native void SetOpen(long var0, boolean var2);

    static native int GetOpenCount(long var0);

    static native String GetTitle(long var0);

    static native long GetTitleObj(long var0);

    static native void SetTitle(long var0, String var2);

    static native long GetAction(long var0);

    static native void SetAction(long var0, long var2);

    static native void RemoveAction(long var0);

    static native int GetFlags(long var0);

    static native void SetFlags(long var0, int var2);

    static native double[] GetColor(long var0);

    static native void SetColor(long var0, double var2, double var4, double var6);
}
