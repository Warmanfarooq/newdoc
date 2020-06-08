//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

public class Action {
    public static final int e_GoTo = 0;
    public static final int e_GoToR = 1;
    public static final int e_GoToE = 2;
    public static final int e_Launch = 3;
    public static final int e_Thread = 4;
    public static final int e_URI = 5;
    public static final int e_Sound = 6;
    public static final int e_Movie = 7;
    public static final int e_Hide = 8;
    public static final int e_Named = 9;
    public static final int e_SubmitForm = 10;
    public static final int e_ResetForm = 11;
    public static final int e_ImportData = 12;
    public static final int e_JavaScript = 13;
    public static final int e_SetOCGState = 14;
    public static final int e_Rendition = 15;
    public static final int e_Trans = 16;
    public static final int e_GoTo3DView = 17;
    public static final int e_Unknown = 18;
    public static final int e_exclude = 0;
    public static final int e_include_no_value_fields = 1;
    public static final int e_export_format = 2;
    public static final int e_get_method = 3;
    public static final int e_submit_coordinates = 4;
    public static final int e_xfdf = 5;
    public static final int e_include_append_saves = 6;
    public static final int e_include_annotations = 7;
    public static final int e_submit_pdf = 8;
    public static final int e_canonical_format = 9;
    public static final int e_excl_non_user_annots = 10;
    public static final int e_excl_F_key = 11;
    public static final int e_embed_form = 13;
    long a;
    private Object b;

    public static Action createGoto(Destination var0) throws PDFNetException {
        return new Action(CreateGoto(var0.a), var0.b);
    }

    public static Action createGoto(byte[] var0, Destination var1) throws PDFNetException {
        return new Action(CreateGoto(var0, var1.a), var1.b);
    }

    public static Action createGotoRemote(FileSpec var0, int var1) throws PDFNetException {
        return new Action(CreateGotoRemote(var0.a, var1), var0.b);
    }

    public static Action createGotoRemote(FileSpec var0, int var1, boolean var2) throws PDFNetException {
        return new Action(CreateGotoRemote(var0.a, var1, var2), var0.b);
    }

    public static Action createURI(PDFDoc var0, String var1) throws PDFNetException {
        return new Action(CreateURI(var0.__GetHandle(), var1), var0);
    }

    public static Action createSubmitForm(FileSpec var0) throws PDFNetException {
        return new Action(CreateSubmitForm(var0.a), var0.b);
    }

    public static Action createLaunch(PDFDoc var0, String var1) {
        return new Action(CreateLaunch(var0.__GetHandle(), var1), var0);
    }

    public static Action createHideField(PDFDoc var0, String[] var1) {
        return new Action(CreateHideField(var0.__GetHandle(), var1), var0);
    }

    public static Action createImportData(PDFDoc var0, String var1) {
        return new Action(CreateImportData(var0.__GetHandle(), var1), var0);
    }

    public static Action createResetForm(PDFDoc var0) {
        return new Action(CreateResetForm(var0.__GetHandle()), var0);
    }

    public static Action createJavaScript(PDFDoc var0, String var1) {
        return new Action(CreateJavaScript(var0.__GetHandle(), var1), var0);
    }

    public Action(Obj var1) throws PDFNetException {
        this.a = var1.__GetHandle();
        this.b = var1.__GetRefHandle();
    }

    public boolean needsWriteLock() throws PDFNetException {
        return NeedsWriteLock(this.a);
    }

    public KeyStrokeActionResult executeKeyStrokeAction(KeyStrokeEventData var1) throws PDFNetException {
        return new KeyStrokeActionResult(ExecuteKeyStrokeAction(this.a, var1.a));
    }

    public void Execute() throws PDFNetException {
        Execute(this.a);
    }

    public Obj GetNext() throws PDFNetException {
        return Obj.__Create(GetNext(this.a), this.b);
    }

    public boolean equals(Object var1) {
        if (var1 != null && var1.getClass().equals(this.getClass())) {
            return this.a == ((Action)var1).a;
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

    public int getType() throws PDFNetException {
        return GetType(this.a);
    }

    public Destination getDest() throws PDFNetException {
        return new Destination(GetDest(this.a), this.b);
    }

    public int getFormActionFlag(int var1) throws PDFNetException {
        return GetFormActionFlag(this.a, var1);
    }

    public void setFormActionFlag(int var1, boolean var2) throws PDFNetException {
        SetFormActionFlag(this.a, var1, var2);
    }

    public Obj getSDFObj() {
        return Obj.__Create(this.a, this.b);
    }

    Action(long var1, Object var3) {
        this.a = var1;
        this.b = var3;
    }

    public static Action __Create(long var0, Object var2) {
        return var0 == 0L ? null : new Action(var0, var2);
    }

    public long __GetHandle() {
        return this.a;
    }

    public Object __GetRefHandle() {
        return this.b;
    }

    static native boolean NeedsWriteLock(long var0);

    static native long ExecuteKeyStrokeAction(long var0, long var2);

    static native long CreateGoto(long var0);

    static native long CreateGoto(byte[] var0, long var1);

    static native long CreateGotoRemote(long var0, int var2);

    static native long CreateGotoRemote(long var0, int var2, boolean var3);

    static native long CreateURI(long var0, String var2);

    static native long CreateSubmitForm(long var0);

    static native long CreateLaunch(long var0, String var2);

    static native long CreateHideField(long var0, String[] var2);

    static native long CreateImportData(long var0, String var2);

    static native long CreateResetForm(long var0);

    static native long CreateJavaScript(long var0, String var2);

    static native void Execute(long var0);

    static native boolean IsValid(long var0);

    static native int GetType(long var0);

    static native long GetDest(long var0);

    static native int GetFormActionFlag(long var0, int var2);

    static native void SetFormActionFlag(long var0, int var2, boolean var3);

    static native long GetNext(long var0);
}
