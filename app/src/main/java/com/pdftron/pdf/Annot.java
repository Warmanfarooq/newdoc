//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;

public class Annot {
    public static final int e_Text = 0;
    public static final int e_Link = 1;
    public static final int e_FreeText = 2;
    public static final int e_Line = 3;
    public static final int e_Square = 4;
    public static final int e_Circle = 5;
    public static final int e_Polygon = 6;
    public static final int e_Polyline = 7;
    public static final int e_Highlight = 8;
    public static final int e_Underline = 9;
    public static final int e_Squiggly = 10;
    public static final int e_StrikeOut = 11;
    public static final int e_Stamp = 12;
    public static final int e_Caret = 13;
    public static final int e_Ink = 14;
    public static final int e_Popup = 15;
    public static final int e_FileAttachment = 16;
    public static final int e_Sound = 17;
    public static final int e_Movie = 18;
    public static final int e_Widget = 19;
    public static final int e_Screen = 20;
    public static final int e_PrinterMark = 21;
    public static final int e_TrapNet = 22;
    public static final int e_Watermark = 23;
    public static final int e_3D = 24;
    public static final int e_Redact = 25;
    public static final int e_Projection = 26;
    public static final int e_RichMedia = 27;
    public static final int e_Unknown = 28;
    public static final int e_action_trigger_activate = 0;
    public static final int e_action_trigger_annot_enter = 1;
    public static final int e_action_trigger_annot_exit = 2;
    public static final int e_action_trigger_annot_down = 3;
    public static final int e_action_trigger_annot_up = 4;
    public static final int e_action_trigger_annot_focus = 5;
    public static final int e_action_trigger_annot_blur = 6;
    public static final int e_action_trigger_annot_page_open = 7;
    public static final int e_action_trigger_annot_page_close = 8;
    public static final int e_action_trigger_annot_page_visible = 9;
    public static final int e_action_trigger_annot_page_invisible = 10;
    public static final int e_invisible = 0;
    public static final int e_hidden = 1;
    public static final int e_print = 2;
    public static final int e_no_zoom = 3;
    public static final int e_no_rotate = 4;
    public static final int e_no_view = 5;
    public static final int e_read_only = 6;
    public static final int e_locked = 7;
    public static final int e_toggle_no_view = 8;
    public static final int e_locked_contents = 9;
    public static final int e_normal = 0;
    public static final int e_rollover = 1;
    public static final int e_down = 2;
    long a;
    private Object b;

    public static Annot create(Doc var0, int var1, Rect var2) throws PDFNetException {
        return new Annot(Create(var0.__GetHandle(), var1, var2.a), var0);
    }

    public Annot(Obj var1) {
        this.a = var1.__GetHandle();
        this.b = var1.__GetRefHandle();
    }

    public Annot() {
        this.a = 0L;
        this.b = null;
    }

    public Obj getTriggerAction(int var1) throws PDFNetException {
        return Obj.__Create(GetTriggerAction(this.a, var1), this.b);
    }

    public boolean equals(Object var1) {
        if (var1 != null && var1 instanceof Annot) {
            return this.a == ((Annot)var1).a;
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

    public Obj getSDFObj() throws PDFNetException {
        return Obj.__Create(this.a, this.b);
    }

    public int getType() throws PDFNetException {
        return GetType(this.a);
    }

    public boolean isMarkup() throws PDFNetException {
        return IsMarkup(this.a);
    }

    public String getContents() throws PDFNetException {
        return GetContents(this.a);
    }

    public void setContents(String var1) throws PDFNetException {
        SetContents(this.a, var1);
    }

    public Rect getRect() throws PDFNetException {
        return new Rect(GetRect(this.a));
    }

    public Rect getVisibleContentBox() throws PDFNetException {
        return new Rect(GetVisibleContentBox(this.a));
    }

    public void setRect(Rect var1) throws PDFNetException {
        SetRect(this.a, var1.a);
    }

    public Page getPage() throws PDFNetException {
        return new Page(GetPage(this.a), this.b);
    }

    public void setPage(Page var1) throws PDFNetException {
        SetPage(this.a, var1.a);
    }

    public Obj getUniqueID() throws PDFNetException {
        return Obj.__Create(GetUniqueID(this.a), this.b);
    }

    public void setUniqueID(String var1) throws PDFNetException {
        SetUniqueID(this.a, var1);
    }

    public Date getDate() throws PDFNetException {
        return new Date(GetDate(this.a));
    }

    public void setDate(Date var1) throws PDFNetException {
        SetDate(this.a, var1.a);
    }

    public void setDateToNow() throws PDFNetException {
        SetDateToNow(this.a);
    }

    public boolean getFlag(int var1) throws PDFNetException {
        return GetFlag(this.a, var1);
    }

    public void setFlag(int var1, boolean var2) throws PDFNetException {
        SetFlag(this.a, var1, var2);
    }

    public Annot.BorderStyle getBorderStyle() throws PDFNetException {
        return new Annot.BorderStyle(GetBorderStyle(this.a));
    }

    public void setBorderStyle(Annot.BorderStyle var1) throws PDFNetException {
        SetBorderStyle(this.a, var1.a);
    }

    public Obj getAppearance() throws PDFNetException {
        return Obj.__Create(GetAppearance(this.a, 0, (String)null), this.b);
    }

    public Obj getAppearance(int var1) throws PDFNetException {
        return Obj.__Create(GetAppearance(this.a, var1, (String)null), this.b);
    }

    public Obj getAppearance(int var1, String var2) throws PDFNetException {
        return Obj.__Create(GetAppearance(this.a, var1, var2), this.b);
    }

    public void setAppearance(Obj var1) throws PDFNetException {
        SetAppearance(this.a, var1.__GetHandle(), 0, (String)null);
    }

    public void removeAppearance(int var1, String var2) throws PDFNetException {
        RemoveAppearance(this.a, var1, var2);
    }

    public void setAppearance(Obj var1, int var2) throws PDFNetException {
        SetAppearance(this.a, var1.__GetHandle(), var2, (String)null);
    }

    public void setAppearance(Obj var1, int var2, String var3) throws PDFNetException {
        SetAppearance(this.a, var1.__GetHandle(), var2, var3);
    }

    public void flatten(Page var1) throws PDFNetException {
        Flatten(this.a, var1.a);
    }

    public String getActiveAppearanceState() throws PDFNetException {
        return GetActiveAppearanceState(this.a);
    }

    public void setActiveAppearanceState(String var1) throws PDFNetException {
        SetActiveAppearanceState(this.a, var1);
    }

    public ColorPt getColorAsRGB() throws PDFNetException {
        return new ColorPt(GetColorAsRGB(this.a));
    }

    public ColorPt getColorAsCMYK() throws PDFNetException {
        return new ColorPt(GetColorAsCMYK(this.a));
    }

    public ColorPt getColorAsGray() throws PDFNetException {
        return new ColorPt(GetColorAsGray(this.a));
    }

    public int getColorCompNum() throws PDFNetException {
        return GetColorCompNum(this.a);
    }

    public void setColor(ColorPt var1) throws PDFNetException {
        this.setColor(var1, 3);
    }

    public void setColor(ColorPt var1, int var2) throws PDFNetException {
        SetColor(this.a, var1.a, var2);
    }

    public int GetStructParent() throws PDFNetException {
        return GetStructParent(this.a);
    }

    public void setStructParent(int var1) throws PDFNetException {
        SetStructParent(this.a, var1);
    }

    public Obj getOptionalContent() throws PDFNetException {
        return Obj.__Create(GetOptionalContent(this.a), this.b);
    }

    public void setOptionalContent(Obj var1) throws PDFNetException {
        SetOptionalContent(this.a, var1.__GetHandle());
    }

    public int getRotation() throws PDFNetException {
        return GetRotation(this.a);
    }

    public void setRotation(int var1) throws PDFNetException {
        SetRotation(this.a, var1);
    }

    public void refreshAppearance() throws PDFNetException {
        RefreshAppearance(this.a);
    }

    public String getCustomData(String var1) throws PDFNetException {
        return GetCustomData(this.a, var1);
    }

    public void setCustomData(String var1, String var2) throws PDFNetException {
        SetCustomData(this.a, var1, var2);
    }

    public void deleteCustomData(String var1) throws PDFNetException {
        DeleteCustomData(this.a, var1);
    }

    public void resize(Rect var1) throws PDFNetException {
        Resize(this.a, var1.a);
    }

    protected Annot(long var1, Object var3) {
        this.a = var1;
        this.b = var3;
    }

    public static Annot __Create(long var0, Object var2) {
        return var0 == 0L ? null : new Annot(var0, var2);
    }

    public long __GetHandle() {
        return this.a;
    }

    public Object __GetRefHandle() {
        return this.b;
    }

    static native long GetTriggerAction(long var0, int var2);

    static native long Create(long var0, int var2, long var3);

    static native boolean IsValid(long var0);

    static native int GetType(long var0);

    static native long GetRect(long var0);

    static native long GetVisibleContentBox(long var0);

    static native boolean IsMarkup(long var0);

    static native void SetRect(long var0, long var2);

    static native String GetContents(long var0);

    static native void SetContents(long var0, String var2);

    static native long GetPage(long var0);

    static native long SetPage(long var0, long var2);

    static native boolean GetFlag(long var0, int var2);

    static native void SetFlag(long var0, int var2, boolean var3);

    static native long GetDate(long var0);

    static native void SetDate(long var0, long var2);

    static native void SetDateToNow(long var0);

    static native long GetUniqueID(long var0);

    static native void SetUniqueID(long var0, String var2);

    static native long GetColorAsRGB(long var0);

    static native long GetColorAsCMYK(long var0);

    static native long GetColorAsGray(long var0);

    static native int GetColorCompNum(long var0);

    static native void SetColor(long var0, long var2, int var4);

    static native int GetStructParent(long var0);

    static native void SetStructParent(long var0, int var2);

    static native long GetOptionalContent(long var0);

    static native void SetOptionalContent(long var0, long var2);

    static native int GetRotation(long var0);

    static native void SetRotation(long var0, int var2);

    static native void RefreshAppearance(long var0);

    static native void Resize(long var0, long var2);

    static native long BorderStyleCreate(int var0, int var1, int var2, int var3);

    static native long BorderStyleCreate(int var0, int var1, int var2, int var3, double[] var4);

    static native void BorderStyleDestroy(long var0);

    static native int BSGetStyle(long var0);

    static native void BSSetStyle(long var0, int var2);

    static native int BSGetHR(long var0);

    static native void BSSetHR(long var0, int var2);

    static native int BSGetVR(long var0);

    static native void BSSetVR(long var0, int var2);

    static native double BSGetWidth(long var0);

    static native void BSSetWidth(long var0, double var2);

    static native double[] BSGetDash(long var0);

    static native void BSSetDash(long var0, double[] var2);

    static native long GetBorderStyle(long var0);

    static native void SetBorderStyle(long var0, long var2);

    static native long GetAppearance(long var0, int var2, String var3);

    static native void SetAppearance(long var0, long var2, int var4, String var5);

    static native void RemoveAppearance(long var0, int var2, String var3);

    static native void Flatten(long var0, long var2);

    static native String GetActiveAppearanceState(long var0);

    static native void SetActiveAppearanceState(long var0, String var2);

    static native String GetCustomData(long var0, String var2);

    static native void SetCustomData(long var0, String var2, String var3);

    static native void DeleteCustomData(long var0, String var2);

    public static class BorderStyle {
        public static final int e_solid = 0;
        public static final int e_dashed = 1;
        public static final int e_beveled = 2;
        public static final int e_inset = 3;
        public static final int e_underline = 4;
        long a;

        public BorderStyle(int var1, int var2, int var3, int var4) throws PDFNetException {
            this.a = Annot.BorderStyleCreate(var1, var2, var3, var4);
        }

        public BorderStyle(int var1, int var2, int var3, int var4, double[] var5) throws PDFNetException {
            this.a = Annot.BorderStyleCreate(var1, var2, var3, var4, var5);
        }

        public void destroy() throws PDFNetException {
            if (this.a != 0L) {
                Annot.BorderStyleDestroy(this.a);
                this.a = 0L;
            }

        }

        protected void finalize() throws Throwable {
            this.destroy();
        }

        public int getStyle() throws PDFNetException {
            return Annot.BSGetStyle(this.a);
        }

        public void setStyle(int var1) throws PDFNetException {
            Annot.BSSetStyle(this.a, var1);
        }

        public int getHR() throws PDFNetException {
            return Annot.BSGetHR(this.a);
        }

        public void setHR(int var1) throws PDFNetException {
            Annot.BSSetHR(this.a, var1);
        }

        public int getVR() throws PDFNetException {
            return Annot.BSGetVR(this.a);
        }

        public void setVR(int var1) throws PDFNetException {
            Annot.BSSetVR(this.a, var1);
        }

        public double getWidth() throws PDFNetException {
            return Annot.BSGetWidth(this.a);
        }

        public void setWidth(double var1) throws PDFNetException {
            Annot.BSSetWidth(this.a, var1);
        }

        public double[] getDash() throws PDFNetException {
            return Annot.BSGetDash(this.a);
        }

        public void setDash(double[] var1) throws PDFNetException {
            Annot.BSSetDash(this.a, var1);
        }

        BorderStyle(long var1) {
            this.a = var1;
        }
    }
}
