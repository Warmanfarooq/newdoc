//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;
import com.pdftron.sdf.ObjSet;

public class ViewerOptimizedOptions {
    public static final int e_op_off = 0;
    public static final int e_op_on = 1;
    public static final int e_op_pdfx_on = 2;
    Obj a;
    private ObjSet b;

    public ViewerOptimizedOptions() {
        try {
            this.b = new ObjSet();
            this.a = this.b.createDict();
        } catch (PDFNetException var1) {
            System.err.println("Error Occurred when creating ViewerOptimizedOptions.");
        }
    }

    public void setThumbnailRenderingThreshold(int var1) throws PDFNetException {
        this.a.putNumber("COMPLEXITY_THRESHOLD", (double)var1);
    }

    public void setThumbnailSize(int var1) throws PDFNetException {
        this.a.putNumber("THUMB_SIZE", (double)var1);
    }

    public void setOverprint(int var1) throws PDFNetException {
        switch(var1) {
            case 0:
                this.a.putName("OVERPRINT_MODE", "OFF");
                return;
            case 1:
                this.a.putName("OVERPRINT_MODE", "ON");
                return;
            case 2:
                this.a.putName("OVERPRINT_MODE", "PDFX");
            default:
        }
    }
}
