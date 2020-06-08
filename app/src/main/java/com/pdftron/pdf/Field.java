//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

public class Field extends h {
    public static final int e_button = 0;
    public static final int e_check = 1;
    public static final int e_radio = 2;
    public static final int e_text = 3;
    public static final int e_choice = 4;
    public static final int e_signature = 5;
    public static final int e_null = 6;
    public static final int e_action_trigger_keystroke = 13;
    public static final int e_action_trigger_format = 14;
    public static final int e_action_trigger_validate = 15;
    public static final int e_action_trigger_calculate = 16;
    public static final int e_read_only = 0;
    public static final int e_required = 1;
    public static final int e_no_export = 2;
    public static final int e_pushbutton_flag = 3;
    public static final int e_radio_flag = 4;
    public static final int e_toggle_to_off = 5;
    public static final int e_radios_in_unison = 6;
    public static final int e_multiline = 7;
    public static final int e_password = 8;
    public static final int e_file_select = 9;
    public static final int e_no_spellcheck = 10;
    public static final int e_no_scroll = 11;
    public static final int e_comb = 12;
    public static final int e_rich_text = 13;
    public static final int e_combo = 14;
    public static final int e_edit = 15;
    public static final int e_sort = 16;
    public static final int e_multiselect = 17;
    public static final int e_commit_on_sel_change = 18;
    public static final int e_left_justified = 0;
    public static final int e_centered = 1;
    public static final int e_right_justified = 2;
    long a;
    private Object d;

    public Field(Obj var1) throws PDFNetException {
        this.a = FieldCreate(var1.__GetHandle());
        this.d = var1.__GetRefHandle();
        this.clearList();
    }

    public void destroy() throws PDFNetException {
        if (this.a != 0L && !(this.d instanceof FieldIterator)) {
            Destroy(this.a);
            this.a = 0L;
        }

    }

    protected void finalize() throws Throwable {
        this.destroy();
    }

    public boolean isValid() throws PDFNetException {
        return IsValid(this.a);
    }

    public Obj getTriggerAction(int var1) throws PDFNetException {
        return Obj.__Create(GetTriggerAction(this.a, var1), this.d);
    }

    public int getType() throws PDFNetException {
        return GetType(this.a);
    }

    public Obj getValue() throws PDFNetException {
        return Obj.__Create(GetValue(this.a), this.d);
    }

    public String getValueAsString() throws PDFNetException {
        return GetValueAsString(this.a);
    }

    public boolean getValueAsBool() throws PDFNetException {
        return GetValueAsBool(this.a);
    }

    public ViewChangeCollection setValue(Obj var1) throws PDFNetException {
        return new ViewChangeCollection(SetValue(this.a, var1.__GetHandle()));
    }

    public ViewChangeCollection setValue(String var1) throws PDFNetException {
        return new ViewChangeCollection(SetValue(this.a, var1));
    }

    public ViewChangeCollection setValue(boolean var1) throws PDFNetException {
        return new ViewChangeCollection(SetValue(this.a, var1));
    }

    public void refreshAppearance() throws PDFNetException {
        RefreshAppearance(this.a);
    }

    public void eraseAppearance() throws PDFNetException {
        EraseAppearance(this.a);
    }

    public Obj getDefaultValue() throws PDFNetException {
        return Obj.__Create(GetDefaultValue(this.a), this.d);
    }

    public GState getDefaultAppearance() throws PDFNetException {
        return new GState(GetDefaultAppearance(this.a), this.d, (Object)null);
    }

    public String getDefaultValueAsString() throws PDFNetException {
        return GetDefaultValueAsString(this.a);
    }

    public String getName() throws PDFNetException {
        return GetName(this.a);
    }

    public String getPartialName() throws PDFNetException {
        return GetPartialName(this.a);
    }

    public void rename(String var1) throws PDFNetException {
        Rename(this.a, var1);
    }

    public boolean isAnnot() throws PDFNetException {
        return IsAnnot(this.a);
    }

    public boolean getFlag(int var1) throws PDFNetException {
        return GetFlag(this.a, var1);
    }

    public void setFlag(int var1, boolean var2) throws PDFNetException {
        SetFlag(this.a, var1, var2);
    }

    public int getJustification() throws PDFNetException {
        return GetJustification(this.a);
    }

    public void setJustification(int var1) throws PDFNetException {
        SetJustification(this.a, var1);
    }

    public void setMaxLen(int var1) throws PDFNetException {
        SetMaxLen(this.a, var1);
    }

    public int getMaxLen() throws PDFNetException {
        return GetMaxLen(this.a);
    }

    public void flatten(Page var1) throws PDFNetException {
        Flatten(this.a, var1.a);
    }

    public Obj findInheritedAttribute(String var1) throws PDFNetException {
        return Obj.__Create(FindInheritedAttribute(this.a, var1), this.d);
    }

    public Rect getUpdateRect() {
        return new Rect(GetUpdateRect(this.a));
    }

    public Obj getSDFObj() throws PDFNetException {
        return Obj.__Create(GetSDFObj(this.a), this.d);
    }

    public Obj useSignatureHandler(long var1) throws PDFNetException {
        return Obj.__Create(UseSignatureHandler(this.a, var1), this.d);
    }

    public int getOptCount() throws PDFNetException {
        return GetOptCount(this.a);
    }

    public String getOpt(int var1) throws PDFNetException {
        return GetOpt(this.a, var1);
    }

    public boolean isLockedByDigitalSignature() throws PDFNetException {
        return IsLockedByDigitalSignature(this.a);
    }

    Field(long var1, Object var3) throws PDFNetException {
        this.a = var1;
        this.d = var3;
        this.clearList();
    }

    public static Field __Create(long var0, Object var2) throws PDFNetException {
        return var0 == 0L ? null : new Field(var0, var2);
    }

    public long __GetHandle() {
        return this.a;
    }

    public Object __GetRefHandle() {
        return this.d;
    }

    static native long GetTriggerAction(long var0, int var2);

    static native long FieldCreate(long var0);

    static native void Destroy(long var0);

    static native boolean IsValid(long var0);

    static native int GetType(long var0);

    static native long GetValue(long var0);

    static native String GetValueAsString(long var0);

    static native boolean GetValueAsBool(long var0);

    static native long SetValue(long var0, long var2);

    static native long SetValue(long var0, String var2);

    static native long SetValue(long var0, boolean var2);

    static native void RefreshAppearance(long var0);

    static native void EraseAppearance(long var0);

    static native long GetDefaultValue(long var0);

    static native String GetDefaultValueAsString(long var0);

    static native long GetDefaultAppearance(long var0);

    static native String GetName(long var0);

    static native String GetPartialName(long var0);

    static native void Rename(long var0, String var2);

    static native boolean IsAnnot(long var0);

    static native boolean GetFlag(long var0, int var2);

    static native void SetFlag(long var0, int var2, boolean var3);

    static native int GetJustification(long var0);

    static native void SetJustification(long var0, int var2);

    static native void Flatten(long var0, long var2);

    static native long FindInheritedAttribute(long var0, String var2);

    static native long GetSDFObj(long var0);

    static native void SetMaxLen(long var0, int var2);

    static native int GetMaxLen(long var0);

    static native long GetUpdateRect(long var0);

    static native long UseSignatureHandler(long var0, long var2);

    static native int GetOptCount(long var0);

    static native String GetOpt(long var0, int var2);

    static native boolean IsLockedByDigitalSignature(long var0);
}
