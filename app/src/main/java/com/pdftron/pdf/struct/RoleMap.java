//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf.struct;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

public class RoleMap {
    private long a;
    private Object b;

    public RoleMap(Obj var1) {
        this.a = var1.__GetHandle();
        this.b = var1.__GetRefHandle();
    }

    public boolean isValid() throws PDFNetException {
        return IsValid(this.a);
    }

    public String getDirectMap(String var1) throws PDFNetException {
        return GetDirectMap(this.a, var1);
    }

    public Obj getSDFObj() {
        return Obj.__Create(this.a, this.b);
    }

    RoleMap(long var1, Object var3) {
        this.a = var1;
        this.b = var3;
    }

    static native boolean IsValid(long var0);

    static native String GetDirectMap(long var0, String var2);
}
