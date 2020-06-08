//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.sdf;

import com.pdftron.common.PDFNetException;

public class UndoManager {
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

    public UndoManager(long var1) {
        this.a = var1;
    }

    public DocSnapshot discardAllSnapshots() throws PDFNetException {
        return new DocSnapshot(DiscardAllSnapshots(this.a));
    }

    public ResultSnapshot undo() throws PDFNetException {
        return new ResultSnapshot(Undo(this.a));
    }

    public boolean canUndo() throws PDFNetException {
        return CanUndo(this.a);
    }

    public DocSnapshot getNextUndoSnapshot() throws PDFNetException {
        return new DocSnapshot(GetNextUndoSnapshot(this.a));
    }

    public ResultSnapshot redo() throws PDFNetException {
        return new ResultSnapshot(Redo(this.a));
    }

    public boolean canRedo() throws PDFNetException {
        return CanRedo(this.a);
    }

    public DocSnapshot getNextRedoSnapshot() throws PDFNetException {
        return new DocSnapshot(GetNextRedoSnapshot(this.a));
    }

    public ResultSnapshot takeSnapshot() throws PDFNetException {
        return new ResultSnapshot(TakeSnapshot(this.a));
    }

    public long __GetHandle() {
        return this.a;
    }

    static native void Destroy(long var0);

    static native long DiscardAllSnapshots(long var0);

    static native long Undo(long var0);

    static native boolean CanUndo(long var0);

    static native long GetNextUndoSnapshot(long var0);

    static native long Redo(long var0);

    static native boolean CanRedo(long var0);

    static native long GetNextRedoSnapshot(long var0);

    static native long TakeSnapshot(long var0);
}
