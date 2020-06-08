//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

public class Highlights {
    long a;

    public Highlights() {
        this.a = HighlightsCreate();
    }

    public void destroy() {
        if (this.a != 0L) {
            Delete(this.a);
            this.a = 0L;
        }

    }

    protected void finalize() throws Throwable {
        this.destroy();
    }

    public void load(String var1) {
        Load(this.a, var1);
    }

    public void save(String var1) {
        Save(this.a, var1);
    }

    public void add(Highlights var1) {
        Add(this.a, var1.a);
    }

    public void clear() {
        Clear(this.a);
    }

    public void begin(PDFDoc var1) {
        Begin(this.a, var1.__GetHandle());
    }

    public boolean hasNext() {
        return HasNext(this.a);
    }

    public void next() {
        Next(this.a);
    }

    public int getCurrentPageNumber() {
        return GetCurrentPageNumber(this.a);
    }

    public double[] getCurrentQuads() {
        return GetCurrentQuads(this.a);
    }

    public Highlights(long var1) {
        this.a = var1;
    }

    static native long HighlightsCreate();

    static native void Delete(long var0);

    static native void Load(long var0, String var2);

    static native void Save(long var0, String var2);

    static native void Add(long var0, long var2);

    static native void Clear(long var0);

    static native void Begin(long var0, long var2);

    static native boolean HasNext(long var0);

    static native void Next(long var0);

    static native int GetCurrentPageNumber(long var0);

    static native double[] GetCurrentQuads(long var0);
}
