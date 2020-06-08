
package com.pdftron.pdf;

import com.pdftron.common.Matrix2D;
import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;
import java.io.InputStream;

public class Font {
    public static final int e_times_roman = 0;
    public static final int e_times_bold = 1;
    public static final int e_times_italic = 2;
    public static final int e_times_bold_italic = 3;
    public static final int e_helvetica = 4;
    public static final int e_helvetica_bold = 5;
    public static final int e_helvetica_oblique = 6;
    public static final int e_helvetica_bold_oblique = 7;
    public static final int e_courier = 8;
    public static final int e_courier_bold = 9;
    public static final int e_courier_oblique = 10;
    public static final int e_courier_bold_oblique = 11;
    public static final int e_symbol = 12;
    public static final int e_zapf_dingbats = 13;
    public static final int e_null = 14;
    public static final int e_IdentityH = 0;
    public static final int e_Indices = 1;
    public static final int e_Type1 = 0;
    public static final int e_TrueType = 1;
    public static final int e_MMType1 = 2;
    public static final int e_Type3 = 3;
    public static final int e_Type0 = 4;
    public static final int e_CIDType0 = 5;
    public static final int e_CIDType2 = 6;
    long a;
    Object b;

    public Font() {
        this.a = 0L;
        this.b = null;
    }

    public Font(Obj var1) {
        this.a = var1.__GetHandle();
        this.b = var1.__GetRefHandle();
    }

    public static Font create(Doc var0, int var1) throws PDFNetException {
        return __Create(Create(var0.__GetHandle(), var1, false), var0);
    }

    public static Font create(Doc var0, int var1, boolean var2) throws PDFNetException {
        return __Create(Create(var0.__GetHandle(), var1, var2), var0);
    }

    public static Font create(Doc var0, Font var1, String var2) throws PDFNetException {
        return __Create(Create(var0.__GetHandle(), var1.a, var2), var0);
    }

    public static Font create(Doc var0, String var1, String var2) throws PDFNetException {
        return __Create(Create(var0.__GetHandle(), var1, var2), var0);
    }

    public static Font createTrueTypeFont(Doc var0, String var1) throws PDFNetException {
        return __Create(CreateTrueTypeFont(var0.__GetHandle(), var1, true, true), var0);
    }

    public static Font createTrueTypeFont(Doc var0, InputStream var1) throws PDFNetException {
        return __Create(CreateTrueTypeFontFromStream(var0.__GetHandle(), var1, true, true), var0);
    }

    public static Font createTrueTypeFont(Doc var0, String var1, boolean var2) throws PDFNetException {
        return __Create(CreateTrueTypeFont(var0.__GetHandle(), var1, var2, true), var0);
    }

    public static Font createTrueTypeFont(Doc var0, InputStream var1, boolean var2) throws PDFNetException {
        return __Create(CreateTrueTypeFontFromStream(var0.__GetHandle(), var1, var2, true), var0);
    }

    public static Font createTrueTypeFont(Doc var0, String var1, boolean var2, boolean var3) throws PDFNetException {
        return __Create(CreateTrueTypeFont(var0.__GetHandle(), var1, var2, var3), var0);
    }

    public static Font createTrueTypeFont(Doc var0, InputStream var1, boolean var2, boolean var3) throws PDFNetException {
        return __Create(CreateTrueTypeFontFromStream(var0.__GetHandle(), var1, var2, var3), var0);
    }

    public static Font createCIDTrueTypeFont(Doc var0, String var1) throws PDFNetException {
        return __Create(CreateCIDTrueTypeFont(var0.__GetHandle(), var1, true, true, 0, 0L), var0);
    }

    public static Font createCIDTrueTypeFont(Doc var0, InputStream var1) throws PDFNetException {
        return __Create(CreateCIDTrueTypeFontFromStream(var0.__GetHandle(), var1, true, true, 0, 0L), var0);
    }

    public static Font createCIDTrueTypeFont(Doc var0, String var1, boolean var2, boolean var3) throws PDFNetException {
        return __Create(CreateCIDTrueTypeFont(var0.__GetHandle(), var1, var2, var3, 0, 0L), var0);
    }

    public static Font createCIDTrueTypeFont(Doc var0, InputStream var1, boolean var2, boolean var3) throws PDFNetException {
        return __Create(CreateCIDTrueTypeFontFromStream(var0.__GetHandle(), var1, var2, var3, 0, 0L), var0);
    }

    public static Font createCIDTrueTypeFont(Doc var0, String var1, boolean var2, boolean var3, int var4) throws PDFNetException {
        return __Create(CreateCIDTrueTypeFont(var0.__GetHandle(), var1, var2, var3, var4, 0L), var0);
    }

    public static Font createCIDTrueTypeFont(Doc var0, InputStream var1, boolean var2, boolean var3, int var4) throws PDFNetException {
        return __Create(CreateCIDTrueTypeFontFromStream(var0.__GetHandle(), var1, var2, var3, var4, 0L), var0);
    }

    public static Font createCIDTrueTypeFont(Doc var0, String var1, boolean var2, boolean var3, int var4, long var5) throws PDFNetException {
        return __Create(CreateCIDTrueTypeFont(var0.__GetHandle(), var1, var2, var3, var4, var5), var0);
    }

    public static Font createCIDTrueTypeFont(Doc var0, InputStream var1, boolean var2, boolean var3, int var4, long var5) throws PDFNetException {
        return __Create(CreateCIDTrueTypeFontFromStream(var0.__GetHandle(), var1, var2, var3, var4, var5), var0);
    }

    public static Font createType1Font(Doc var0, String var1) throws PDFNetException {
        return __Create(CreateType1Font(var0.__GetHandle(), var1, true), var0);
    }

    public static Font createType1Font(Doc var0, String var1, boolean var2) throws PDFNetException {
        return __Create(CreateType1Font(var0.__GetHandle(), var1, var2), var0);
    }

    public int getType() throws PDFNetException {
        return GetType(this.a);
    }

    public boolean isSimple() throws PDFNetException {
        return IsSimple(this.a);
    }

    public static int getType(Obj var0) throws PDFNetException {
        return GetTypeStatic(var0.__GetHandle());
    }

    public Obj GetSDFObj() {
        return Obj.__Create(this.a, this.b);
    }

    public Obj GetDescriptor() throws PDFNetException {
        return Obj.__Create(GetDescriptor(this.a), this.b);
    }

    public String getName() throws PDFNetException {
        return GetName(this.a);
    }

    public String getFamilyName() throws PDFNetException {
        return GetFamilyName(this.a);
    }

    public boolean isFixedWidth() throws PDFNetException {
        return IsFixedWidth(this.a);
    }

    public boolean isSerif() throws PDFNetException {
        return IsSerif(this.a);
    }

    public boolean isSymbolic() throws PDFNetException {
        return IsSymbolic(this.a);
    }

    public boolean isItalic() throws PDFNetException {
        return IsItalic(this.a);
    }

    public boolean isAllCap() throws PDFNetException {
        return IsAllCap(this.a);
    }

    public boolean isForceBold() throws PDFNetException {
        return IsForceBold(this.a);
    }

    public boolean isHorizontalMode() throws PDFNetException {
        return IsHorizontalMode(this.a);
    }

    public double getWidth(long var1) throws PDFNetException {
        return GetWidth(this.a, var1);
    }

    public double getMaxWidth() throws PDFNetException {
        return GetMaxWidth(this.a);
    }

    public double getMissingWidth() throws PDFNetException {
        return GetMissingWidth(this.a);
    }

    public FontCharCodeIterator getCharCodeIterator() throws PDFNetException {
        return new FontCharCodeIterator(GetCharCodeIterator(this.a), this.b);
    }

    public PathData getGlyphPath(long var1, boolean var3) {
        return GetGlyphPath(this.a, var1, var3, 0L);
    }

    public PathData getGlyphPath(long var1, boolean var3, Matrix2D var4) {
        return GetGlyphPath(this.a, var1, var3, var4.__GetHandle());
    }

    public char[] mapToUnicode(long var1) throws PDFNetException {
        return MapToUnicode(this.a, var1);
    }

    public String[] getEncoding() throws PDFNetException {
        return GetEncoding(this.a);
    }

    public boolean isEmbedded() throws PDFNetException {
        return IsEmbedded(this.a);
    }

    public String getEmbeddedFontName() throws PDFNetException {
        return GetEmbeddedFontName(this.a);
    }

    public Obj getEmbeddedFont() throws PDFNetException {
        return Obj.__Create(GetEmbeddedFont(this.a), this.b);
    }

    public int getEmbeddedFontBufSize() throws PDFNetException {
        return GetEmbeddedFontBufSize(this.a);
    }

    public short getUnitsPerEm() throws PDFNetException {
        return GetUnitsPerEm(this.a);
    }

    public Rect getBBox() throws PDFNetException {
        return new Rect(GetBBox(this.a));
    }

    public double getAscent() throws PDFNetException {
        return GetAscent(this.a);
    }

    public double getDescent() throws PDFNetException {
        return GetDescent(this.a);
    }

    public int getStandardType1FontType() throws PDFNetException {
        return GetStandardType1FontType(this.a);
    }

    public boolean isCFF() throws PDFNetException {
        return IsCFF(this.a);
    }

    public Matrix2D getType3FontMatrix() throws PDFNetException {
        return Matrix2D.__Create(GetType3FontMatrix(this.a));
    }

    public Obj getType3GlyphStream(long var1) {
        return Obj.__Create(GetType3GlyphStream(this.a, var1), this.b);
    }

    private Font(long var1, Object var3) {
        this.a = var1;
        this.b = var3;
    }

    public static Font __Create(long var0, Object var2) {
        return var0 == 0L ? null : new Font(var0, var2);
    }

    public long __GetHandle() {
        return this.a;
    }

    public Object __GetRefHandle() {
        return this.b;
    }

    static native long Create(long var0, int var2, boolean var3);

    static native long Create(long var0, long var2, String var4);

    static native long Create(long var0, String var2, String var3);

    static native long CreateTrueTypeFont(long var0, String var2, boolean var3, boolean var4);

    static native long CreateTrueTypeFontFromStream(long var0, InputStream var2, boolean var3, boolean var4);

    static native long CreateCIDTrueTypeFont(long var0, String var2, boolean var3, boolean var4, int var5, long var6);

    static native long CreateCIDTrueTypeFontFromStream(long var0, InputStream var2, boolean var3, boolean var4, int var5, long var6);

    static native long CreateType1Font(long var0, String var2, boolean var3);

    static native int GetType(long var0);

    static native boolean IsSimple(long var0);

    static native int GetTypeStatic(long var0);

    static native long GetDescriptor(long var0);

    static native String GetName(long var0);

    static native String GetFamilyName(long var0);

    static native boolean IsFixedWidth(long var0);

    static native boolean IsSerif(long var0);

    static native boolean IsSymbolic(long var0);

    static native boolean IsItalic(long var0);

    static native boolean IsAllCap(long var0);

    static native boolean IsForceBold(long var0);

    static native boolean IsHorizontalMode(long var0);

    static native double GetWidth(long var0, long var2);

    static native double GetMaxWidth(long var0);

    static native double GetMissingWidth(long var0);

    static native long GetCharCodeIterator(long var0);

    static native PathData GetGlyphPath(long var0, long var2, boolean var4, long var5);

    static native char[] MapToUnicode(long var0, long var2);

    static native String[] GetEncoding(long var0);

    static native boolean IsEmbedded(long var0);

    static native String GetEmbeddedFontName(long var0);

    static native long GetEmbeddedFont(long var0);

    static native int GetEmbeddedFontBufSize(long var0);

    static native short GetUnitsPerEm(long var0);

    static native long GetBBox(long var0);

    static native double GetAscent(long var0);

    static native double GetDescent(long var0);

    static native int GetStandardType1FontType(long var0);

    static native boolean IsCFF(long var0);

    static native long GetType3FontMatrix(long var0);

    static native long GetType3GlyphStream(long var0, long var2);
}
