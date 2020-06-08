//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

public class PDFDocInfo {
    private long a;
    private Object b;

    public String getTitle() throws PDFNetException {
        return GetTitle(this.a);
    }

    public Obj getTitleObj() throws PDFNetException {
        return Obj.__Create(GetTitleObj(this.a), this.b);
    }

    public void setTitle(String var1) throws PDFNetException {
        SetTitle(this.a, var1);
    }

    public String getAuthor() throws PDFNetException {
        return GetAuthor(this.a);
    }

    public Obj getAuthorObj() throws PDFNetException {
        return Obj.__Create(GetAuthorObj(this.a), this.b);
    }

    public void setAuthor(String var1) throws PDFNetException {
        SetAuthor(this.a, var1);
    }

    public String getSubject() throws PDFNetException {
        return GetSubject(this.a);
    }

    public Obj getSubjectObj() throws PDFNetException {
        return Obj.__Create(GetSubjectObj(this.a), this.b);
    }

    public void setSubject(String var1) throws PDFNetException {
        SetSubject(this.a, var1);
    }

    public String getKeywords() throws PDFNetException {
        return GetKeywords(this.a);
    }

    public Obj getKeywordsObj() throws PDFNetException {
        return Obj.__Create(GetKeywordsObj(this.a), this.b);
    }

    public void setKeywords(String var1) throws PDFNetException {
        SetKeywords(this.a, var1);
    }

    public String getCreator() throws PDFNetException {
        return GetCreator(this.a);
    }

    public Obj getCreatorObj() throws PDFNetException {
        return Obj.__Create(GetCreatorObj(this.a), this.b);
    }

    public void setCreator(String var1) throws PDFNetException {
        SetCreator(this.a, var1);
    }

    public String getProducer() throws PDFNetException {
        return GetProducer(this.a);
    }

    public Obj getProducerObj() throws PDFNetException {
        return Obj.__Create(GetProducerObj(this.a), this.b);
    }

    public void setProducer(String var1) throws PDFNetException {
        SetProducer(this.a, var1);
    }

    public Date getCreationDate() throws PDFNetException {
        return new Date(GetCreationDate(this.a));
    }

    public void setCreationDate(Date var1) throws PDFNetException {
        SetCreationDate(this.a, var1.a);
    }

    public Date getModDate() throws PDFNetException {
        return new Date(GetModDate(this.a));
    }

    public void setModDate(Date var1) throws PDFNetException {
        SetModDate(this.a, var1.a);
    }

    public Obj getSDFObj() {
        return Obj.__Create(this.a, this.b);
    }

    public PDFDocInfo(Obj var1) {
        this.a = var1.__GetHandle();
        this.b = var1.__GetRefHandle();
    }

    PDFDocInfo(long var1, Object var3) {
        this.a = var1;
        this.b = var3;
    }

    static native String GetTitle(long var0);

    static native long GetTitleObj(long var0);

    static native void SetTitle(long var0, String var2);

    static native String GetAuthor(long var0);

    static native long GetAuthorObj(long var0);

    static native void SetAuthor(long var0, String var2);

    static native String GetSubject(long var0);

    static native long GetSubjectObj(long var0);

    static native void SetSubject(long var0, String var2);

    static native String GetKeywords(long var0);

    static native long GetKeywordsObj(long var0);

    static native void SetKeywords(long var0, String var2);

    static native String GetCreator(long var0);

    static native long GetCreatorObj(long var0);

    static native void SetCreator(long var0, String var2);

    static native String GetProducer(long var0);

    static native long GetProducerObj(long var0);

    static native void SetProducer(long var0, String var2);

    static native long GetCreationDate(long var0);

    static native void SetCreationDate(long var0, long var2);

    static native long GetModDate(long var0);

    static native void SetModDate(long var0, long var2);
}
