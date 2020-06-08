//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf.struct;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

public class ClassMap {
    private long a;
    private Object b;

    public ClassMap(Obj var1) {
        this.a = var1.__GetHandle();
        this.b = var1.__GetRefHandle();
    }

    public boolean isValid() throws PDFNetException {
        return IsValid(this.a);
    }

    public Obj getSDFObj() {
        return Obj.__Create(this.a, this.b);
    }

    ClassMap(long var1, Object var3) {
        this.a = var1;
        this.b = var3;
    }

    static native boolean IsValid(long var0);
}
