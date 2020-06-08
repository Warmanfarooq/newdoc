
package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.filters.Filter;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;
import com.pdftron.sdf.ObjSet;

public class Convert {
    public static final int e_very_strict = 0;
    public static final int e_strict = 1;
    public static final int e_default = 2;
    public static final int e_keep_most = 3;
    public static final int e_keep_all = 4;
    public static final int e_off = 0;
    public static final int e_simple = 1;
    public static final int e_fast = 2;
    public static final int e_high_quality = 3;

    public Convert() {
    }

    public static void fromXps(Doc var0, String var1) throws PDFNetException {
        FromXps(var0.__GetHandle(), var1);
    }

    public static void fromXps(Doc var0, byte[] var1) throws PDFNetException {
        FromXpsBuf(var0.__GetHandle(), var1);
    }

    public static void fromEmf(Doc var0, String var1) throws PDFNetException {
        FromEmf(var0.__GetHandle(), var1);
    }

    public static void fromText(Doc var0, String var1, Obj var2) throws PDFNetException {
        FromText(var0.__GetHandle(), var1, var2.__GetHandle());
    }

    public static void toEmf(Doc var0, String var1) throws PDFNetException {
        DocToEmf(var0.__GetHandle(), var1);
    }

    public static void toEmf(Page var0, String var1) throws PDFNetException {
        PageToEmf(var0.a, var1);
    }

    public static void toSvg(Doc var0, String var1) throws PDFNetException {
        DocToSvg(var0.__GetHandle(), var1);
    }

    public static void toSvg(Doc var0, String var1, Convert.SVGOutputOptions var2) throws PDFNetException {
        DocToSvgWithOptions(var0.__GetHandle(), var1, var2.a.__GetHandle());
    }

    public static void toSvg(Page var0, String var1) throws PDFNetException {
        PageToSvg(var0.a, var1);
    }

    public static void toSvg(Page var0, String var1, Convert.SVGOutputOptions var2) throws PDFNetException {
        PageToSvgWithOptions(var0.a, var1, var2.a.__GetHandle());
    }

    public static void toXps(Doc var0, String var1) throws PDFNetException {
        DocToXps(var0.__GetHandle(), var1, 0L);
    }

    public static void toXps(Doc var0, String var1, Convert.XPSOutputOptions var2) throws PDFNetException {
        DocToXps(var0.__GetHandle(), var1, var2.a.__GetHandle());
    }

    public static void toXps(String var0, String var1) throws PDFNetException {
        FileToXps(var0, var1, 0L);
    }

    public static void toXps(String var0, String var1, Convert.XPSOutputOptions var2) throws PDFNetException {
        FileToXps(var0, var1, var2.a.__GetHandle());
    }

    public static void toXod(String var0, String var1) throws PDFNetException {
        FileToXod(var0, var1, 0L);
    }

    public static void toXod(String var0, String var1, Convert.XODOutputOptions var2) throws PDFNetException {
        FileToXod(var0, var1, var2.a.__GetHandle());
    }

    public static void toXod(Doc var0, String var1) throws PDFNetException {
        DocToXod(var0.__GetHandle(), var1, 0L);
    }

    public static void toXod(Doc var0, String var1, Convert.XODOutputOptions var2) throws PDFNetException {
        DocToXod(var0.__GetHandle(), var1, var2.a.__GetHandle());
    }

    public static Filter toXod(Doc var0) throws PDFNetException {
        return Filter.__Create(DocToXodStream(var0.__GetHandle(), 0L), (Filter)null);
    }

    public static Filter toXod(Doc var0, Convert.XODOutputOptions var1) throws PDFNetException {
        return Filter.__Create(DocToXodStream(var0.__GetHandle(), var1.a.__GetHandle()), (Filter)null);
    }

    public static Filter toXod(String var0) throws PDFNetException {
        return Filter.__Create(FileToXodStream(var0, 0L), (Filter)null);
    }

    public static Filter toXod(String var0, Convert.XODOutputOptions var1) throws PDFNetException {
        return Filter.__Create(FileToXodStream(var0, var1.a.__GetHandle()), (Filter)null);
    }

    public static void toHtml(String var0, String var1) throws PDFNetException {
        FileToHtml(var0, var1, 0L);
    }

    public static void toHtml(String var0, String var1, Convert.HTMLOutputOptions var2) throws PDFNetException {
        FileToHtml(var0, var1, var2.a.__GetHandle());
    }

    public static void toHtml(Doc var0, String var1) throws PDFNetException {
        DocToHtml(var0.__GetHandle(), var1, 0L);
    }

    public static void toHtml(Doc var0, String var1, Convert.HTMLOutputOptions var2) throws PDFNetException {
        DocToHtml(var0.__GetHandle(), var1, var2.a.__GetHandle());
    }

    public static void toEpub(String var0, String var1) throws PDFNetException {
        FileToEpub(var0, var1, 0L, 0L);
    }

    public static void toEpub(String var0, String var1, Convert.HTMLOutputOptions var2) throws PDFNetException {
        FileToEpub(var0, var1, var2.a.__GetHandle(), 0L);
    }

    public static void toEpub(String var0, String var1, Convert.EPUBOutputOptions var2) throws PDFNetException {
        FileToEpub(var0, var1, 0L, var2.a.__GetHandle());
    }

    public static void toEpub(String var0, String var1, Convert.HTMLOutputOptions var2, Convert.EPUBOutputOptions var3) throws PDFNetException {
        FileToEpub(var0, var1, var2.a.__GetHandle(), var3.a.__GetHandle());
    }

    public static void toEpub(Doc var0, String var1) throws PDFNetException {
        DocToEpub(var0.__GetHandle(), var1, 0L, 0L);
    }

    public static void toEpub(Doc var0, String var1, Convert.HTMLOutputOptions var2) throws PDFNetException {
        DocToEpub(var0.__GetHandle(), var1, var2.a.__GetHandle(), 0L);
    }

    public static void toEpub(Doc var0, String var1, Convert.EPUBOutputOptions var2) throws PDFNetException {
        DocToEpub(var0.__GetHandle(), var1, 0L, var2.a.__GetHandle());
    }

    public static void toEpub(Doc var0, String var1, Convert.HTMLOutputOptions var2, Convert.EPUBOutputOptions var3) throws PDFNetException {
        DocToEpub(var0.__GetHandle(), var1, var2.a.__GetHandle(), var3.a.__GetHandle());
    }

    public static void toTiff(String var0, String var1) throws PDFNetException {
        FileToTiff(var0, var1, 0L);
    }

    public static void toTiff(String var0, String var1, Convert.TiffOutputOptions var2) throws PDFNetException {
        FileToTiff(var0, var1, var2.a.__GetHandle());
    }

    public static void toTiff(Doc var0, String var1) throws PDFNetException {
        DocToTiff(var0.__GetHandle(), var1, 0L);
    }

    public static void toTiff(Doc var0, String var1, Convert.TiffOutputOptions var2) throws PDFNetException {
        DocToTiff(var0.__GetHandle(), var1, var2.a.__GetHandle());
    }

    public static DocumentConversion universalConversion(String var0, ConversionOptions var1) throws PDFNetException {
        long var2 = 0L;
        if (var1 != null) {
            var2 = var1.a();
        }

        return new DocumentConversion(UniversalConversion(var0, var2));
    }

    public static DocumentConversion universalConversion(Filter var0, ConversionOptions var1) throws PDFNetException {
        long var2 = 0L;
        if (var1 != null) {
            var2 = var1.a();
        }

        return new DocumentConversion(UniversalConversionWithFilter(var0.__GetHandle(), var2));
    }

    public static DocumentConversion appendUniversalConversion(DocumentConversion var0, String var1, ConversionOptions var2) throws PDFNetException {
        long var3 = 0L;
        if (var2 != null) {
            var3 = var2.a();
        }

        return new DocumentConversion(AppendUniversalConversion(var0.__GetHandle(), var1, var3));
    }

    public static DocumentConversion appendUniversalConversion(DocumentConversion var0, Filter var1, ConversionOptions var2) throws PDFNetException {
        long var3 = 0L;
        if (var2 != null) {
            var3 = var2.a();
        }

        return new DocumentConversion(AppendUniversalConversionWithFilter(var0.__GetHandle(), var1.__GetHandle(), var3));
    }

    public static void wordToPdf(Doc var0, String var1, WordToPDFOptions var2) throws PDFNetException {
        long var3 = 0L;
        if (var2 != null) {
            var3 = var2.a();
        }

        WordToPdf(var0.__GetHandle(), var1, var3);
    }

    public static DocumentConversion wordToPdfConversion(Doc var0, String var1, WordToPDFOptions var2) throws PDFNetException {
        long var3 = 0L;
        if (var2 != null) {
            var3 = var2.a();
        }

        return new DocumentConversion(WordToPdfConversion(var0.__GetHandle(), var1, var3));
    }

    public static void wordToPdf(Doc var0, Filter var1, WordToPDFOptions var2) throws PDFNetException {
        long var3 = 0L;
        if (var2 != null) {
            var3 = var2.a();
        }

        WordToPdfWithFilter(var0.__GetHandle(), var1.__GetHandle(), var3);
    }

    public static DocumentConversion wordToPdfConversion(Doc var0, Filter var1, WordToPDFOptions var2) throws PDFNetException {
        long var3 = 0L;
        if (var2 != null) {
            var3 = var2.a();
        }

        return new DocumentConversion(WordToPdfConversionWithFilter(var0.__GetHandle(), var1.__GetHandle(), var3));
    }

    public static void officeToPdf(Doc var0, String var1, ConversionOptions var2) throws PDFNetException {
        long var3 = 0L;
        if (var2 != null) {
            var3 = var2.a();
        }

        OfficeToPdf(var0.__GetHandle(), var1, var3);
    }

    public static DocumentConversion streamingPdfConversion(String var0, ConversionOptions var1) throws PDFNetException {
        long var2 = 0L;
        if (var1 != null) {
            var2 = var1.a();
        }

        return new DocumentConversion(UniversalConversion(var0, var2));
    }

    public static void officeToPdf(Doc var0, Filter var1, ConversionOptions var2) throws PDFNetException {
        long var3 = 0L;
        if (var2 != null) {
            var3 = var2.a();
        }

        OfficeToPdfWithFilter(var0.__GetHandle(), var1.__GetHandle(), var3);
    }

    public static DocumentConversion streamingPdfConversion(Filter var0, ConversionOptions var1) throws PDFNetException {
        long var2 = 0L;
        if (var1 != null) {
            var2 = var1.a();
        }

        return new DocumentConversion(UniversalConversionWithFilter(var0.__GetHandle(), var2));
    }

    public static DocumentConversion streamingPdfConversion(Doc var0, String var1, ConversionOptions var2) throws PDFNetException {
        long var3 = 0L;
        if (var2 != null) {
            var3 = var2.a();
        }

        return new DocumentConversion(UniversalConversionWithPdf(var0.__GetHandle(), var1, var3));
    }

    public static DocumentConversion streamingPdfConversion(Doc var0, Filter var1, ConversionOptions var2) throws PDFNetException {
        long var3 = 0L;
        if (var2 != null) {
            var3 = var2.a();
        }

        return new DocumentConversion(UniversalConversionWithPdfAndFilter(var0.__GetHandle(), var1.__GetHandle(), var3));
    }

    public static BlackBoxContext createBlackBoxContext(String var0) throws PDFNetException {
        return new BlackBoxContext(CreateBlackBoxContext(var0));
    }

    public static BlackBoxContext createBlackBoxContextConvert(String var0, String var1) throws PDFNetException {
        return new BlackBoxContext(CreateBlackBoxContextConvert(var0, var1));
    }

    public static void toPdf(Doc var0, String var1) throws PDFNetException {
        FileToPdf(var0.__GetHandle(), var1);
    }

    public static void fromCAD(Doc var0, String var1, CADConvertOptions var2) throws PDFNetException {
        long var3 = 0L;
        if (var2 != null) {
            var3 = var2.a();
        }

        FromCAD(var0.__GetHandle(), var1, var3);
    }

    public static void fromTiff(Doc var0, Filter var1) throws PDFNetException {
        FromTiff(var0.__GetHandle(), var1.__GetHandle());
    }

    public static boolean requiresPrinter(String var0) throws PDFNetException {
        return RequiresPrinter(var0);
    }

    static native void FromXps(long var0, String var2);

    static native void FromXpsBuf(long var0, byte[] var2);

    static native void FromEmf(long var0, String var2);

    static native void FromText(long var0, String var2, long var3);

    static native void DocToEmf(long var0, String var2);

    static native void PageToEmf(long var0, String var2);

    static native void DocToSvg(long var0, String var2);

    static native void DocToSvgWithOptions(long var0, String var2, long var3);

    static native void PageToSvg(long var0, String var2);

    static native void PageToSvgWithOptions(long var0, String var2, long var3);

    static native void DocToXps(long var0, String var2, long var3);

    static native void FileToXps(String var0, String var1, long var2);

    static native void FileToXod(String var0, String var1, long var2);

    static native void DocToXod(long var0, String var2, long var3);

    static native long FileToXodStream(String var0, long var1);

    static native long DocToXodStream(long var0, long var2);

    static native void FileToHtml(String var0, String var1, long var2);

    static native void DocToHtml(long var0, String var2, long var3);

    static native void FileToEpub(String var0, String var1, long var2, long var4);

    static native void DocToEpub(long var0, String var2, long var3, long var5);

    static native void FileToTiff(String var0, String var1, long var2);

    static native void DocToTiff(long var0, String var2, long var3);

    static native long UniversalConversion(String var0, long var1);

    static native long UniversalConversionWithFilter(long var0, long var2);

    static native long UniversalConversionWithPdf(long var0, String var2, long var3);

    static native long UniversalConversionWithPdfAndFilter(long var0, long var2, long var4);

    static native long AppendUniversalConversion(long var0, String var2, long var3);

    static native long AppendUniversalConversionWithFilter(long var0, long var2, long var4);

    static native void OfficeToPdf(long var0, String var2, long var3);

    static native void WordToPdf(long var0, String var2, long var3);

    static native long WordToPdfConversion(long var0, String var2, long var3);

    static native void OfficeToPdfWithFilter(long var0, long var2, long var4);

    static native void WordToPdfWithFilter(long var0, long var2, long var4);

    static native long WordToPdfConversionWithFilter(long var0, long var2, long var4);

    static native long CreateBlackBoxContext(String var0);

    static native long CreateBlackBoxContextConvert(String var0, String var1);

    static native void FileToPdf(long var0, String var2);

    static native void FromCAD(long var0, String var2, long var3);

    static native void FromTiff(long var0, long var2);

    static native boolean RequiresPrinter(String var0);

    public static class SVGOutputOptions {
        public static final int e_op_off = 0;
        public static final int e_op_on = 1;
        public static final int e_op_pdfx_on = 2;
        Obj a;
        private ObjSet b;

        public SVGOutputOptions() {
            try {
                this.b = new ObjSet();
                this.a = this.b.createDict();
            } catch (PDFNetException var1) {
                System.err.println("Error occurred when creating SVGOutputOptions.");
            }
        }

        public void setEmbedImages(boolean var1) throws PDFNetException {
            this.a.putBool("EMBEDIMAGES", var1);
        }

        public void setNoFonts(boolean var1) throws PDFNetException {
            this.a.putBool("NOFONTS", var1);
        }

        public void setSvgFonts(boolean var1) throws PDFNetException {
            this.a.putBool("SVGFONTS", var1);
        }

        public void setEmbedFonts(boolean var1) throws PDFNetException {
            this.a.putBool("EMBEDFONTS", var1);
        }

        public void setNoUnicode(boolean var1) throws PDFNetException {
            this.a.putBool("NOUNICODE", var1);
        }

        public void setIndividualCharPlacement(boolean var1) throws PDFNetException {
            this.a.putBool("INDIVIDUALCHARPLACEMENT", var1);
        }

        public void setRemoveCharPlacement(boolean var1) throws PDFNetException {
            this.a.putBool("REMOVECHARPLACEMENT", var1);
        }

        public void setFlattenContent(int var1) throws PDFNetException {
            Convert.b(this.a, var1);

        }

        public void setFlattenThreshold(int var1) throws PDFNetException {
            Convert.a(this.a, var1);
        }

        public void setCompress(boolean var1) throws PDFNetException {
            this.a.putBool("SVGZ", var1);
        }

        public void setOutputThumbnails(boolean var1) throws PDFNetException {
            this.a.putBool("NOTHUMBS", !var1);
        }

        public void setThumbnailSize(int var1) throws PDFNetException {
            this.a.putNumber("THUMB_SIZE", (double)var1);
        }

        public void setCreateXmlWrapper(boolean var1) throws PDFNetException {
            this.a.putBool("NOXMLDOC", !var1);
        }

        public void setDtd(boolean var1) throws PDFNetException {
            this.a.putBool("OMITDTD", !var1);
        }

        public void setAnnots(boolean var1) throws PDFNetException {
            this.a.putBool("NOANNOTS", !var1);
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

    public static class TiffOutputOptions {
        public static final int e_media = 0;
        public static final int e_crop = 1;
        public static final int e_bleed = 2;
        public static final int e_trim = 3;
        public static final int e_art = 4;
        public static final int e_op_off = 0;
        public static final int e_op_on = 1;
        public static final int e_op_pdfx_on = 2;
        Obj a;
        private ObjSet b;

        public TiffOutputOptions() {
            try {
                this.b = new ObjSet();
                this.a = this.b.createDict();
            } catch (PDFNetException var1) {
                System.err.println("Error Occurred when creating TiffOutputOptions.");
            }
        }

        public void setBox(int var1) throws PDFNetException {
            switch(var1) {
                case 0:
                    this.a.putName("BOX", "media");
                    return;
                case 1:
                    this.a.putName("BOX", "crop");
                    return;
                case 2:
                    this.a.putName("BOX", "bleed");
                    return;
                case 3:
                    this.a.putName("BOX", "trim");
                    return;
                case 4:
                    this.a.putName("BOX", "art");
                default:
            }
        }

        public void setRotate(int var1) throws PDFNetException {
            switch(var1) {
                case 0:
                    this.a.putName("ROTATE", "0");
                    return;
                case 90:
                    this.a.putName("ROTATE", "90");
                    return;
                case 180:
                    this.a.putName("ROTATE", "180");
                    return;
                case 270:
                    this.a.putName("ROTATE", "270");
                default:
            }
        }

        public void setRotate(double var1, double var3, double var5, double var7) throws PDFNetException {
            this.a.putNumber("CLIP_X1", var1);
            this.a.putNumber("CLIP_Y1", var3);
            this.a.putNumber("CLIP_X2", var5);
            this.a.putNumber("CLIP_Y2", var7);
        }

        public void setPages(String var1) throws PDFNetException {
            this.a.putName("PAGES", var1);
        }

        public void setOverprint(int var1) throws PDFNetException {
            switch(var1) {
                case 0:
                    this.a.putName("OVERPRINT", "off");
                    return;
                case 1:
                    this.a.putName("OVERPRINT", "on");
                    return;
                case 2:
                    this.a.putName("OVERPRINT", "pdfx");
                default:
            }
        }

        public void setCMYK(boolean var1) throws PDFNetException {
            this.a.putBool("CMYK", var1);
        }

        public void setDither(boolean var1) throws PDFNetException {
            this.a.putBool("DITHER", var1);
        }

        public void setGray(boolean var1) throws PDFNetException {
            this.a.putBool("GRAY", var1);
        }

        public void setMono(boolean var1) throws PDFNetException {
            this.a.putBool("MONO", var1);
        }

        public void setAnnots(boolean var1) throws PDFNetException {
            this.a.putBool("ANNOTS", var1);
        }

        public void setSmooth(boolean var1) throws PDFNetException {
            this.a.putBool("SMOOTH", var1);
        }

        public void setPrintmode(boolean var1) throws PDFNetException {
            this.a.putBool("PRINTMODE", var1);
        }

        public void setTransparentPage(boolean var1) throws PDFNetException {
            this.a.putBool("TRANSPARENT_PAGE", var1);
        }

        public void setPalettized(boolean var1) throws PDFNetException {
            this.a.putBool("PALETTIZED", var1);
        }

        public void setDPI(double var1) throws PDFNetException {
            this.a.putNumber("DPI", var1);
        }

        public void setGamma(double var1) throws PDFNetException {
            this.a.putNumber("GAMMA", var1);
        }

        public void setHRes(int var1) throws PDFNetException {
            this.a.putNumber("HRES", (double)var1);
        }

        public void setVRes(int var1) throws PDFNetException {
            this.a.putNumber("VRES", (double)var1);
        }
    }

    public static class EPUBOutputOptions {
        Obj a;
        private ObjSet b;

        public EPUBOutputOptions() {
            try {
                this.b = new ObjSet();
                this.a = this.b.createDict();
            } catch (PDFNetException var1) {
                System.err.println("Error Occurred when creating EPUBOutputOptions.");
            }
        }

        public void setExpanded(boolean var1) throws PDFNetException {
            this.a.putBool("EPUB_EXPANDED", var1);
        }

        public void setReuseCover(boolean var1) throws PDFNetException {
            this.a.putBool("EPUB_REUSE_COVER", var1);
        }
    }

    public static class HTMLOutputOptions {
        Obj a;
        private ObjSet b;

        public HTMLOutputOptions() {
            try {
                this.b = new ObjSet();
                this.a = this.b.createDict();
            } catch (PDFNetException var1) {
                System.err.println("Error Occurred when creating HTMLOutputOptions.");
            }
        }

        public void setPreferJPG(boolean var1) throws PDFNetException {
            this.a.putBool("PREFER_JPEG", var1);
        }

        public void setJPGQuality(int var1) throws PDFNetException {
            this.a.putNumber("JPEG_QUALITY", (double)var1);
        }

        public void setDPI(int var1) throws PDFNetException {
            this.a.putNumber("DPI", (double)var1);
        }

        public void setMaximumImagePixels(int var1) throws PDFNetException {
            this.a.putNumber("MAX_IMAGE_PIXELS", (double)var1);
        }

        public void setReflow(boolean var1) throws PDFNetException {
            this.a.putBool("REFLOW", var1);
        }

        public void setScale(double var1) throws PDFNetException {
            this.a.putNumber("SCALE", var1);
        }

        public void setExternalLinks(boolean var1) throws PDFNetException {
            this.a.putBool("EXTERNAL_LINKS", var1);
        }

        public void setInternalLinks(boolean var1) throws PDFNetException {
            this.a.putBool("INTERNAL_LINKS", var1);
        }

        public void setSimplifyText(boolean var1) throws PDFNetException {
            this.a.putBool("SIMPLIFY_TEXT", var1);
        }
    }

    public static class XODOutputOptions extends Convert.XPSOutputCommonOptions {
        public static final int e_internal_xfdf = 0;
        public static final int e_external_xfdf = 1;
        public static final int e_flatten = 2;

        public XODOutputOptions() {
        }

        public void setOutputThumbnails(boolean var1) throws PDFNetException {
            this.a.putBool("NOTHUMBS", !var1);
        }

        public void setThumbnailSize(int var1) throws PDFNetException {
            this.setThumbnailSize(var1, var1);
        }

        public void setThumbnailSize(int var1, int var2) throws PDFNetException {
            this.a.putNumber("THUMB_SIZE", (double)var1);
            this.a.putNumber("LARGE_THUMB_SIZE", (double)var2);
        }

        public void setElementLimit(int var1) throws PDFNetException {
            this.a.putNumber("ELEMENTLIMIT", (double)var1);
        }

        public void setOpacityMaskWorkaround(boolean var1) throws PDFNetException {
            this.a.putBool("MASKRENDER", var1);
        }

        public void setMaximumImagePixels(int var1) throws PDFNetException {
            this.a.putNumber("MAX_IMAGE_PIXELS", (double)var1);
        }

        public void setFlattenThreshold(int var1) throws PDFNetException {
            Convert.a(this.a, var1);
        }

        public void setFlattenContent(int var1) throws PDFNetException {
            Convert.b(this.a, var1);
        }

        public void setPreferJPG(boolean var1) throws PDFNetException {
            this.a.putBool("PREFER_JPEG", var1);
        }

        public void setJPGQuality(int var1) throws PDFNetException {
            this.a.putNumber("JPEG_QUALITY", (double)var1);
        }

        public void setSilverlightTextWorkaround(boolean var1) throws PDFNetException {
            this.a.putBool("REMOVE_ROTATED_TEXT", var1);
        }

        public void setAnnotationOutput(int var1) throws PDFNetException {
            switch(var1) {
                case 0:
                    this.a.putName("ANNOTATION_OUTPUT", "INTERNAL");
                    return;
                case 1:
                    this.a.putName("ANNOTATION_OUTPUT", "EXTERNAL");
                    return;
                case 2:
                    this.a.putName("ANNOTATION_OUTPUT", "FLATTEN");
                default:
            }
        }

        public void setExternalParts(boolean var1) throws PDFNetException {
            this.a.putBool("EXTERNAL_PARTS", var1);
        }

        public void setEncryptPassword(String var1) throws PDFNetException {
            this.a.putName("ENCRYPT_PASSWORD", var1);
        }

        public void UseSilverlightFlashCompatible(boolean var1) throws PDFNetException {
            this.a.putBool("COMPATIBLE_XOD", var1);
        }
    }

    public static class XPSOutputOptions extends Convert.XPSOutputCommonOptions {
        public XPSOutputOptions() {
        }

        public void setOpenXps(boolean var1) throws PDFNetException {
            this.a.putBool("OPENXPS", var1);
        }
    }

    public static class XPSOutputCommonOptions {
        public static final int e_op_off = 0;
        public static final int e_op_on = 1;
        public static final int e_op_pdfx_on = 2;
        Obj a;
        private ObjSet b;

        public XPSOutputCommonOptions() {
            try {
                this.b = new ObjSet();
                this.a = this.b.createDict();
            } catch (PDFNetException var1) {
                System.err.println("Error Occurred when creating XPSOutputCommonOptions.");
            }
        }

        public void setPrintMode(boolean var1) throws PDFNetException {
            this.a.putBool("PRINTMODE", var1);
        }

        public void setDPI(int var1) throws PDFNetException {
            this.a.putNumber("DPI", (double)var1);
        }

        public void setRenderPages(boolean var1) throws PDFNetException {
            this.a.putBool("RENDER", var1);
        }

        public void setThickenLines(boolean var1) throws PDFNetException {
            this.a.putBool("THICKENLINES", var1);
        }

        public void generateURLLinks(boolean var1) throws PDFNetException {
            this.a.putBool("URL_LINKS", var1);
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
}
