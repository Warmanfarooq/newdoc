//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.Matrix2D;
import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

public class Page {
    public static final int e_action_trigger_page_open = 11;
    public static final int e_action_trigger_page_close = 12;
    public static final int e_media = 0;
    public static final int e_crop = 1;
    public static final int e_bleed = 2;
    public static final int e_trim = 3;
    public static final int e_art = 4;
    public static final int e_user_crop = 5;
    public static final int e_0 = 0;
    public static final int e_90 = 1;
    public static final int e_180 = 2;
    public static final int e_270 = 3;
    long a;
    Object b;

    public Page() {
        this.a = 0L;
    }

    public Page(Obj var1) {
        this.a = var1.__GetHandle();
        this.b = var1.__GetRefHandle();
    }

    public boolean isValid() throws PDFNetException {
        return IsValid(this.a);
    }

    public int getIndex() throws PDFNetException {
        return GetIndex(this.a);
    }

    public Obj getTriggerAction(int var1) throws PDFNetException {
        return Obj.__Create(GetTriggerAction(this.a, var1), this.b);
    }

    public Rect getBox(int var1) throws PDFNetException {
        return new Rect(GetBox(this.a, var1));
    }

    public void setBox(int var1, Rect var2) throws PDFNetException {
        SetBox(this.a, var1, var2.a);
    }

    public Rect getCropBox() throws PDFNetException {
        return new Rect(GetCropBox(this.a));
    }

    public void setCropBox(Rect var1) throws PDFNetException {
        SetCropBox(this.a, var1.a);
    }

    public Rect getMediaBox() throws PDFNetException {
        return new Rect(GetMediaBox(this.a));
    }

    public void setMediaBox(Rect var1) throws PDFNetException {
        SetMediaBox(this.a, var1.a);
    }

    public Rect getVisibleContentBox() throws PDFNetException {
        return new Rect(GetVisibleContentBox(this.a));
    }

    public static int addRotations(int var0, int var1) throws PDFNetException {
        return AddRotations(var0, var1);
    }

    public static int subtractRotations(int var0, int var1) throws PDFNetException {
        return SubtractRotations(var0, var1);
    }

    public static int rotationToDegree(int var0) throws PDFNetException {
        return RotationToDegree(var0);
    }

    public static int degreeToRotation(int var0) throws PDFNetException {
        return DegreeToRotation(var0);
    }

    public int getRotation() throws PDFNetException {
        return GetRotation(this.a);
    }

    public void setRotation(int var1) throws PDFNetException {
        SetRotation(this.a, var1);
    }

    public double getPageWidth() throws PDFNetException {
        return GetPageWidth(this.a, 1);
    }

    public double getPageWidth(int var1) throws PDFNetException {
        return GetPageWidth(this.a, var1);
    }

    public double getPageHeight() throws PDFNetException {
        return GetPageHeight(this.a, 1);
    }

    public double getPageHeight(int var1) throws PDFNetException {
        return GetPageHeight(this.a, var1);
    }

    public Matrix2D getDefaultMatrix() throws PDFNetException {
        return Matrix2D.__Create(GetDefaultMatrix(this.a, false, 1, 0));
    }

    public Matrix2D getDefaultMatrix(boolean var1, int var2, int var3) throws PDFNetException {
        return Matrix2D.__Create(GetDefaultMatrix(this.a, var1, var2, var3));
    }

    public Obj getAnnots() throws PDFNetException {
        return Obj.__Create(GetAnnots(this.a), this.b);
    }

    public int getNumAnnots() throws PDFNetException {
        return GetNumAnnots(this.a);
    }

    public Annot getAnnot(int var1) throws PDFNetException {
        return new Annot(GetAnnot(this.a, var1), this.b);
    }

    public void annotInsert(int var1, Annot var2) throws PDFNetException {
        AnnotInsert(this.a, var1, var2.a);
    }

    public void annotPushBack(Annot var1) throws PDFNetException {
        AnnotPushBack(this.a, var1.a);
    }

    public void annotPushFront(Annot var1) throws PDFNetException {
        AnnotPushFront(this.a, var1.a);
    }

    public void annotRemove(Annot var1) throws PDFNetException {
        AnnotRemove(this.a, var1.a);
    }

    public void annotRemove(int var1) throws PDFNetException {
        AnnotRemove(this.a, var1);
    }

    public void scale(double var1) throws PDFNetException {
        Scale(this.a, var1);
    }

    public void flattenField(Field var1) throws PDFNetException {
        FlattenField(this.a, var1.a);
    }

    public boolean hasTransition() throws PDFNetException {
        return HasTransition(this.a);
    }

    public double getUserUnitSize() throws PDFNetException {
        return GetUserUnitSize(this.a);
    }

    public void setUserUnitSize(double var1) throws PDFNetException {
        SetUserUnitSize(this.a, var1);
    }

    public Obj getResourceDict() throws PDFNetException {
        return Obj.__Create(GetResourceDict(this.a), this.b);
    }

    public Obj getContents() throws PDFNetException {
        return Obj.__Create(GetContents(this.a), this.b);
    }

    public Obj getSDFObj() {
        return Obj.__Create(this.a, this.b);
    }

    public Obj findInheritedAttribute(String var1) throws PDFNetException {
        return Obj.__Create(this.a, var1);
    }

    public Obj getThumb() throws PDFNetException {
        return Obj.__Create(GetThumb(this.a), this.b);
    }

    public int[] getThumbInfo() throws PDFNetException {
        return GetThumbInfo(this.a);
    }

    public static Page __Create(long var0, Object var2) {
        return new Page(var0, var2);
    }

    Page(long var1, Object var3) {
        this.a = var1;
        this.b = var3;
    }

    public long __GetHandle() {
        return this.a;
    }

    static native long GetTriggerAction(long var0, int var2);

    static native boolean IsValid(long var0);

    static native int GetIndex(long var0);

    static native long GetBox(long var0, int var2);

    static native void SetBox(long var0, int var2, long var3);

    static native long GetCropBox(long var0);

    static native void SetCropBox(long var0, long var2);

    static native long GetMediaBox(long var0);

    static native void SetMediaBox(long var0, long var2);

    static native long GetVisibleContentBox(long var0);

    static native int AddRotations(int var0, int var1);

    static native int SubtractRotations(int var0, int var1);

    static native int RotationToDegree(int var0);

    static native int DegreeToRotation(int var0);

    static native int GetRotation(long var0);

    static native void SetRotation(long var0, int var2);

    static native double GetPageWidth(long var0, int var2);

    static native double GetPageHeight(long var0, int var2);

    static native long GetDefaultMatrix(long var0, boolean var2, int var3, int var4);

    static native long GetAnnots(long var0);

    static native int GetNumAnnots(long var0);

    static native long GetAnnot(long var0, int var2);

    static native void AnnotInsert(long var0, int var2, long var3);

    static native void AnnotPushBack(long var0, long var2);

    static native void AnnotPushFront(long var0, long var2);

    static native void AnnotRemove(long var0, long var2);

    static native void AnnotRemove(long var0, int var2);

    static native void Scale(long var0, double var2);

    static native void FlattenField(long var0, long var2);

    static native boolean HasTransition(long var0);

    static native double GetUserUnitSize(long var0);

    static native void SetUserUnitSize(long var0, double var2);

    static native long GetResourceDict(long var0);

    static native long GetContents(long var0);

    static native int[] GetThumbInfo(long var0);

    static native long GetThumb(long var0);
}
