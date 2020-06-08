//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;

public class DisallowedChange {
    private long a;

    public void destroy() throws PDFNetException {
        if (this.a != 0L) {
            Destroy(this.a);
            this.a = 0L;
        }

    }

    protected void finalize() throws Throwable {
        this.destroy();
    }

    public DisallowedChange(long var1) {
        this.a = var1;
    }

    public int getObjNum() throws PDFNetException {
        return GetObjNum(this.a);
    }

    public int getType() throws PDFNetException {
        return GetType(this.a);
    }

    public String getTypeAsString() throws PDFNetException {
        return GetTypeAsString(this.a);
    }

    public long __GetHandle() {
        return this.a;
    }

    static native void Destroy(long var0);

    static native int GetObjNum(long var0);

    static native int GetType(long var0);

    static native String GetTypeAsString(long var0);

    public class Type {
        public static final int e_form_filled = 0;
        public static final int e_digital_signature_signed = 1;
        public static final int e_page_template_instantiated = 2;
        public static final int e_annotation_created_or_updated_or_deleted = 3;
        public static final int e_other = 4;
        public static final int e_unknown = 5;

        public Type(DisallowedChange var1) {
        }
    }
}
