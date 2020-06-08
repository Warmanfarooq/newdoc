
package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;

public class ExternalAnnotManager {
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

    public ExternalAnnotManager(long var1) {
        this.a = var1;
    }

    public void mergeXFDF(String var1) throws PDFNetException {
        MergeXFDF(this.a, var1);
    }

    public String undo() throws PDFNetException {
        return Undo(this.a);
    }

    public Rect jumpToAnnotWithID(String var1) throws PDFNetException {
        return Rect.__Create(JumpToAnnotWithID(this.a, var1));
    }

    public String getLastXFDF() throws PDFNetException {
        return GetLastXFDF(this.a);
    }

    public String getLastJSON() throws PDFNetException {
        return GetLastJSON(this.a);
    }

    public String redo() throws PDFNetException {
        return Redo(this.a);
    }

    public String getNextRedoInfo() throws PDFNetException {
        return GetNextRedoInfo(this.a);
    }

    public String getNextUndoInfo() throws PDFNetException {
        return GetNextUndoInfo(this.a);
    }

    public String takeSnapshot(String var1) throws PDFNetException {
        return TakeSnapshot(this.a, var1);
    }

    public long __GetHandle() {
        return this.a;
    }

    static native void Destroy(long var0);

    static native void MergeXFDF(long var0, String var2);

    static native String Undo(long var0);

    static native long JumpToAnnotWithID(long var0, String var2);

    static native String GetLastXFDF(long var0);

    static native String GetLastJSON(long var0);

    static native String Redo(long var0);

    static native String GetNextRedoInfo(long var0);

    static native String GetNextUndoInfo(long var0);

    static native String TakeSnapshot(long var0, String var2);
}
