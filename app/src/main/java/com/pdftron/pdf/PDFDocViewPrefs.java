//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

public class PDFDocViewPrefs {
    public static final int e_UseNone = 0;
    public static final int e_UseThumbs = 1;
    public static final int e_UseBookmarks = 2;
    public static final int e_FullScreen = 3;
    public static final int e_UseOC = 4;
    public static final int e_UseAttachments = 5;
    public static final int e_Default = 0;
    public static final int e_SinglePage = 1;
    public static final int e_OneColumn = 2;
    public static final int e_TwoColumnLeft = 3;
    public static final int e_TwoColumnRight = 4;
    public static final int e_TwoPageLeft = 5;
    public static final int e_TwoPageRight = 6;
    public static final int e_HideToolbar = 0;
    public static final int e_HideMenubar = 1;
    public static final int e_HideWindowUI = 2;
    public static final int e_FitWindow = 3;
    public static final int e_CenterWindow = 4;
    public static final int e_DisplayDocTitle = 5;
    private long a;
    private Object b;

    public void setInitialPage(Destination var1) throws PDFNetException {
        SetInitialPage(this.a, var1.a);
    }

    public void setPageMode(int var1) throws PDFNetException {
        SetPageMode(this.a, var1);
    }

    public int getPageMode() throws PDFNetException {
        return GetPageMode(this.a);
    }

    public void setLayoutMode(int var1) throws PDFNetException {
        SetLayoutMode(this.a, var1);
    }

    public int getLayoutMode() throws PDFNetException {
        return GetLayoutMode(this.a);
    }

    public void setPref(int var1, boolean var2) throws PDFNetException {
        SetPref(this.a, var1, var2);
    }

    public boolean getPref(int var1) throws PDFNetException {
        return GetPref(this.a, var1);
    }

    public void setNonFullScreenPageMode(int var1) throws PDFNetException {
        SetNonFullScreenPageMode(this.a, var1);
    }

    public int getNonFullScreenPageMode() throws PDFNetException {
        return GetNonFullScreenPageMode(this.a);
    }

    public void setDirection(boolean var1) throws PDFNetException {
        SetDirection(this.a, var1);
    }

    public boolean getDirection() throws PDFNetException {
        return GetDirection(this.a);
    }

    public void setViewArea(int var1) throws PDFNetException {
        SetViewArea(this.a, var1);
    }

    public int getViewArea() throws PDFNetException {
        return GetViewArea(this.a);
    }

    public void setViewClip(int var1) throws PDFNetException {
        SetViewClip(this.a, var1);
    }

    public int getViewClip() throws PDFNetException {
        return GetViewClip(this.a);
    }

    public void setPrintArea(int var1) throws PDFNetException {
        SetPrintArea(this.a, var1);
    }

    public int getPrintArea() throws PDFNetException {
        return GetPrintArea(this.a);
    }

    public void setPrintClip(int var1) throws PDFNetException {
        SetPrintClip(this.a, var1);
    }

    public int getPrintClip() throws PDFNetException {
        return GetPrintClip(this.a);
    }

    public Obj getSDFObj() {
        return Obj.__Create(this.a, this.b);
    }

    public PDFDocViewPrefs(Obj var1) {
        this.a = var1.__GetHandle();
        this.b = var1.__GetRefHandle();
    }

    PDFDocViewPrefs(long var1, Object var3) {
        this.a = var1;
        this.b = var3;
    }

    static native void SetInitialPage(long var0, long var2);

    static native void SetPageMode(long var0, int var2);

    static native int GetPageMode(long var0);

    static native void SetLayoutMode(long var0, int var2);

    static native int GetLayoutMode(long var0);

    static native void SetPref(long var0, int var2, boolean var3);

    static native boolean GetPref(long var0, int var2);

    static native void SetNonFullScreenPageMode(long var0, int var2);

    static native int GetNonFullScreenPageMode(long var0);

    static native void SetDirection(long var0, boolean var2);

    static native boolean GetDirection(long var0);

    static native void SetViewArea(long var0, int var2);

    static native int GetViewArea(long var0);

    static native void SetViewClip(long var0, int var2);

    static native int GetViewClip(long var0);

    static native void SetPrintArea(long var0, int var2);

    static native int GetPrintArea(long var0);

    static native void SetPrintClip(long var0, int var2);

    static native int GetPrintClip(long var0);
}
