
package com.pdftron.pdf;

import com.pdftron.common.Matrix2D;
import com.pdftron.common.PDFNetException;
import com.pdftron.sdf.Obj;

public class GState {
    public static final int e_transform = 0;
    public static final int e_rendering_intent = 1;
    public static final int e_stroke_cs = 2;
    public static final int e_stroke_color = 3;
    public static final int e_fill_cs = 4;
    public static final int e_fill_color = 5;
    public static final int e_line_width = 6;
    public static final int e_line_cap = 7;
    public static final int e_line_join = 8;
    public static final int e_flatness = 9;
    public static final int e_miter_limit = 10;
    public static final int e_dash_pattern = 11;
    public static final int e_char_spacing = 12;
    public static final int e_word_spacing = 13;
    public static final int e_horizontal_scale = 14;
    public static final int e_leading = 15;
    public static final int e_font = 16;
    public static final int e_font_size = 17;
    public static final int e_text_render_mode = 18;
    public static final int e_text_rise = 19;
    public static final int e_text_knockout = 20;
    public static final int e_text_pos_offset = 21;
    public static final int e_blend_mode = 22;
    public static final int e_opacity_fill = 23;
    public static final int e_opacity_stroke = 24;
    public static final int e_alpha_is_shape = 25;
    public static final int e_soft_mask = 26;
    public static final int e_smoothnes = 27;
    public static final int e_auto_stoke_adjust = 28;
    public static final int e_stroke_overprint = 29;
    public static final int e_fill_overprint = 30;
    public static final int e_overprint_mode = 31;
    public static final int e_transfer_funct = 32;
    public static final int e_BG_funct = 33;
    public static final int e_UCR_funct = 34;
    public static final int e_halftone = 35;
    public static final int e_null = 36;
    public static final int e_butt_cap = 0;
    public static final int e_round_cap = 1;
    public static final int e_square_cap = 2;
    public static final int e_miter_join = 0;
    public static final int e_round_join = 1;
    public static final int e_bevel_join = 2;
    public static final int e_fill_text = 0;
    public static final int e_stroke_text = 1;
    public static final int e_fill_stroke_text = 2;
    public static final int e_invisible_text = 3;
    public static final int e_fill_clip_text = 4;
    public static final int e_stroke_clip_text = 5;
    public static final int e_fill_stroke_clip_text = 6;
    public static final int e_clip_text = 7;
    public static final int e_absolute_colorimetric = 0;
    public static final int e_relative_colorimetric = 1;
    public static final int e_saturation = 2;
    public static final int e_perceptual = 3;
    public static final int e_bl_compatible = 0;
    public static final int e_bl_normal = 1;
    public static final int e_bl_multiply = 2;
    public static final int e_bl_screen = 3;
    public static final int e_bl_difference = 4;
    public static final int e_bl_darken = 5;
    public static final int e_bl_lighten = 6;
    public static final int e_bl_color_dodge = 7;
    public static final int e_bl_color_burn = 8;
    public static final int e_bl_exclusion = 9;
    public static final int e_bl_hard_light = 10;
    public static final int e_bl_overlay = 11;
    public static final int e_bl_soft_light = 12;
    public static final int e_bl_luminosity = 13;
    public static final int e_bl_hue = 14;
    public static final int e_bl_saturation = 15;
    public static final int e_bl_color = 16;
    long a;
    private Object b;
    private Object c;

    public Matrix2D getTransform() throws PDFNetException {
        return Matrix2D.__Create(GetTransform(this.a));
    }

    public ColorSpace getStrokeColorSpace() throws PDFNetException {
        return ColorSpace.__Create(GetStrokeColorSpace(this.a), this.b);
    }

    public ColorSpace getFillColorSpace() throws PDFNetException {
        return ColorSpace.__Create(GetFillColorSpace(this.a), this.b);
    }

    public ColorPt getStrokeColor() throws PDFNetException {
        return new ColorPt(GetStrokeColor(this.a));
    }

    public PatternColor GetStrokePattern() throws PDFNetException {
        return PatternColor.a(GetStrokePattern(this.a), this.c);
    }

    public ColorPt getFillColor() throws PDFNetException {
        return new ColorPt(GetFillColor(this.a));
    }

    public PatternColor getFillPattern() throws PDFNetException {
        return PatternColor.a(GetFillPattern(this.a), this.c);
    }

    public double getFlatness() throws PDFNetException {
        return GetFlatness(this.a);
    }

    public int getLineCap() throws PDFNetException {
        return GetLineCap(this.a);
    }

    public int getLineJoin() throws PDFNetException {
        return GetLineJoin(this.a);
    }

    public double getLineWidth() throws PDFNetException {
        return GetLineWidth(this.a);
    }

    public double getMiterLimit() throws PDFNetException {
        return GetMiterLimit(this.a);
    }

    public double[] getDashes() throws PDFNetException {
        return GetDashes(this.a);
    }

    public double getPhase() throws PDFNetException {
        return GetPhase(this.a);
    }

    public double getCharSpacing() throws PDFNetException {
        return GetCharSpacing(this.a);
    }

    public double getWordSpacing() throws PDFNetException {
        return GetWordSpacing(this.a);
    }

    public double getHorizontalScale() throws PDFNetException {
        return GetHorizontalScale(this.a);
    }

    public double getLeading() throws PDFNetException {
        return GetLeading(this.a);
    }

    public Font getFont() throws PDFNetException {
        return Font.__Create(GetFont(this.a), this.b);
    }

    public double getFontSize() throws PDFNetException {
        return GetFontSize(this.a);
    }

    public int getTextRenderMode() throws PDFNetException {
        return GetTextRenderMode(this.a);
    }

    public double getTextRise() throws PDFNetException {
        return GetTextRise(this.a);
    }

    public boolean isTextKnockout() throws PDFNetException {
        return IsTextKnockout(this.a);
    }

    public int getRenderingIntent() throws PDFNetException {
        return GetRenderingIntent(this.a);
    }

    public int getBlendMode() throws PDFNetException {
        return GetBlendMode(this.a);
    }

    public double getFillOpacity() throws PDFNetException {
        return GetFillOpacity(this.a);
    }

    public double getStrokeOpacity() throws PDFNetException {
        return GetStrokeOpacity(this.a);
    }

    public boolean getAISFlag() throws PDFNetException {
        return GetAISFlag(this.a);
    }

    public Obj getSoftMask() throws PDFNetException {
        return Obj.__Create(GetSoftMask(this.a), this.c);
    }

    public Matrix2D getSoftMaskTransform() throws PDFNetException {
        return Matrix2D.__Create(GetSoftMaskTransform(this.a));
    }

    public boolean getStrokeOverprint() throws PDFNetException {
        return GetStrokeOverprint(this.a);
    }

    public boolean getFillOverprint() throws PDFNetException {
        return GetFillOverprint(this.a);
    }

    public int getOverprintMode() throws PDFNetException {
        return GetOverprintMode(this.a);
    }

    public boolean getAutoStrokeAdjust() throws PDFNetException {
        return GetAutoStrokeAdjust(this.a);
    }

    public double getSmoothnessTolerance() throws PDFNetException {
        return GetSmoothnessTolerance(this.a);
    }

    public Obj getTransferFunct() throws PDFNetException {
        return Obj.__Create(GetTransferFunct(this.a), this.c);
    }

    public Obj getBlackGenFunct() throws PDFNetException {
        return Obj.__Create(GetBlackGenFunct(this.a), this.c);
    }

    public Obj getUCRFunct() throws PDFNetException {
        return Obj.__Create(GetUCRFunct(this.a), this.c);
    }

    public Obj getHalftone() throws PDFNetException {
        return Obj.__Create(GetHalftone(this.a), this.c);
    }

    public void setTransform(Matrix2D var1) throws PDFNetException {
        SetTransform(this.a, var1.__GetHandle());
    }

    public void setTransform(double var1, double var3, double var5, double var7, double var9, double var11) throws PDFNetException {
        SetTransform(this.a, var1, var3, var5, var7, var9, var11);
    }

    public void concat(Matrix2D var1) throws PDFNetException {
        Concat(this.a, var1.__GetHandle());
    }

    public void concat(double var1, double var3, double var5, double var7, double var9, double var11) throws PDFNetException {
        Concat(this.a, var1, var3, var5, var7, var9, var11);
    }

    public void setStrokeColorSpace(ColorSpace var1) throws PDFNetException {
        SetStrokeColorSpace(this.a, var1.a);
    }

    public void setFillColorSpace(ColorSpace var1) throws PDFNetException {
        SetFillColorSpace(this.a, var1.a);
    }

    public void setStrokeColor(ColorPt var1) throws PDFNetException {
        SetStrokeColorPt(this.a, var1.a);
    }

    public void setStrokeColor(PatternColor var1) throws PDFNetException {
        SetStrokeColor(this.a, var1.a);
    }

    public void setStrokeColor(PatternColor var1, ColorPt var2) throws PDFNetException {
        SetStrokeColor(this.a, var1.a, var2.a);
    }

    public void setFillColor(ColorPt var1) throws PDFNetException {
        SetFillColorPt(this.a, var1.a);
    }

    public void setFillColor(PatternColor var1) throws PDFNetException {
        SetFillColor(this.a, var1.a);
    }

    public void setFillColor(PatternColor var1, ColorPt var2) throws PDFNetException {
        SetFillColor(this.a, var1.a, var2.a);
    }

    public void setFlatness(double var1) throws PDFNetException {
        SetFlatness(this.a, var1);
    }

    public void setLineCap(int var1) throws PDFNetException {
        SetLineCap(this.a, var1);
    }

    public void setLineJoin(int var1) throws PDFNetException {
        SetLineJoin(this.a, var1);
    }

    public void setLineWidth(double var1) throws PDFNetException {
        SetLineWidth(this.a, var1);
    }

    public void setMiterLimit(double var1) throws PDFNetException {
        SetMiterLimit(this.a, var1);
    }

    public void setDashPattern(double[] var1, double var2) throws PDFNetException {
        SetDashPattern(this.a, var1, var2);
    }

    public void setCharSpacing(double var1) throws PDFNetException {
        SetCharSpacing(this.a, var1);
    }

    public void setWordSpacing(double var1) throws PDFNetException {
        SetWordSpacing(this.a, var1);
    }

    public void setHorizontalScale(double var1) throws PDFNetException {
        SetHorizontalScale(this.a, var1);
    }

    public void setLeading(double var1) throws PDFNetException {
        SetLeading(this.a, var1);
    }

    public void setFont(Font var1, double var2) throws PDFNetException {
        SetFont(this.a, var1.a, var2);
    }

    public void setTextRenderMode(int var1) throws PDFNetException {
        SetTextRenderMode(this.a, var1);
    }

    public void setTextRise(double var1) throws PDFNetException {
        SetTextRise(this.a, var1);
    }

    public void setTextKnockout(boolean var1) throws PDFNetException {
        SetTextKnockout(this.a, var1);
    }

    public void setRenderingIntent(int var1) throws PDFNetException {
        SetRenderingIntent(this.a, var1);
    }

    public void setBlendMode(int var1) throws PDFNetException {
        SetBlendMode(this.a, var1);
    }

    public void setFillOpacity(double var1) throws PDFNetException {
        SetFillOpacity(this.a, var1);
    }

    public void setStrokeOpacity(double var1) throws PDFNetException {
        SetStrokeOpacity(this.a, var1);
    }

    public void setAISFlag(boolean var1) throws PDFNetException {
        SetAISFlag(this.a, var1);
    }

    public void setSoftMask(Obj var1) throws PDFNetException {
        SetSoftMask(this.a, var1.__GetHandle());
    }

    public void setStrokeOverprint(boolean var1) throws PDFNetException {
        SetStrokeOverprint(this.a, var1);
    }

    public void setFillOverprint(boolean var1) throws PDFNetException {
        SetFillOverprint(this.a, var1);
    }

    public void setOverprintMode(int var1) throws PDFNetException {
        SetOverprintMode(this.a, var1);
    }

    public void setAutoStrokeAdjust(boolean var1) throws PDFNetException {
        SetAutoStrokeAdjust(this.a, var1);
    }

    public void setSmoothnessTolerance(double var1) throws PDFNetException {
        SetSmoothnessTolerance(this.a, var1);
    }

    public void setBlackGenFunct(Obj var1) throws PDFNetException {
        SetBlackGenFunct(this.a, var1.__GetHandle());
    }

    public void setUCRFunct(Obj var1) throws PDFNetException {
        SetUCRFunct(this.a, var1.__GetHandle());
    }

    public void setTransferFunct(Obj var1) throws PDFNetException {
        SetTransferFunct(this.a, var1.__GetHandle());
    }

    public void setHalftone(Obj var1) throws PDFNetException {
        SetHalftone(this.a, var1.__GetHandle());
    }

    GState(long var1, Object var3, Object var4) {
        this.a = var1;
        this.b = var3;
        this.c = var4;
    }

    static native long GetTransform(long var0);

    static native long GetStrokeColorSpace(long var0);

    static native long GetFillColorSpace(long var0);

    static native long GetStrokeColor(long var0);

    static native long GetStrokePattern(long var0);

    static native long GetFillColor(long var0);

    static native long GetFillPattern(long var0);

    static native double GetFlatness(long var0);

    static native int GetLineCap(long var0);

    static native int GetLineJoin(long var0);

    static native double GetLineWidth(long var0);

    static native double GetMiterLimit(long var0);

    static native double[] GetDashes(long var0);

    static native double GetPhase(long var0);

    static native double GetCharSpacing(long var0);

    static native double GetWordSpacing(long var0);

    static native double GetHorizontalScale(long var0);

    static native double GetLeading(long var0);

    static native long GetFont(long var0);

    static native double GetFontSize(long var0);

    static native int GetTextRenderMode(long var0);

    static native double GetTextRise(long var0);

    static native boolean IsTextKnockout(long var0);

    static native int GetRenderingIntent(long var0);

    static native int GetBlendMode(long var0);

    static native double GetFillOpacity(long var0);

    static native double GetStrokeOpacity(long var0);

    static native boolean GetAISFlag(long var0);

    static native long GetSoftMask(long var0);

    static native long GetSoftMaskTransform(long var0);

    static native boolean GetStrokeOverprint(long var0);

    static native boolean GetFillOverprint(long var0);

    static native int GetOverprintMode(long var0);

    static native boolean GetAutoStrokeAdjust(long var0);

    static native double GetSmoothnessTolerance(long var0);

    static native long GetTransferFunct(long var0);

    static native long GetBlackGenFunct(long var0);

    static native long GetUCRFunct(long var0);

    static native long GetHalftone(long var0);

    static native void SetTransform(long var0, long var2);

    static native void SetTransform(long var0, double var2, double var4, double var6, double var8, double var10, double var12);

    static native void Concat(long var0, long var2);

    static native void Concat(long var0, double var2, double var4, double var6, double var8, double var10, double var12);

    static native void SetStrokeColorSpace(long var0, long var2);

    static native void SetFillColorSpace(long var0, long var2);

    static native void SetStrokeColorPt(long var0, long var2);

    static native void SetStrokeColor(long var0, long var2);

    static native void SetStrokeColor(long var0, long var2, long var4);

    static native void SetFillColorPt(long var0, long var2);

    static native void SetFillColor(long var0, long var2);

    static native void SetFillColor(long var0, long var2, long var4);

    static native void SetFlatness(long var0, double var2);

    static native void SetLineCap(long var0, int var2);

    static native void SetLineJoin(long var0, int var2);

    static native void SetLineWidth(long var0, double var2);

    static native void SetMiterLimit(long var0, double var2);

    static native void SetDashPattern(long var0, double[] var2, double var3);

    static native void SetCharSpacing(long var0, double var2);

    static native void SetWordSpacing(long var0, double var2);

    static native void SetHorizontalScale(long var0, double var2);

    static native void SetLeading(long var0, double var2);

    static native void SetFont(long var0, long var2, double var4);

    static native void SetTextRenderMode(long var0, int var2);

    static native void SetTextRise(long var0, double var2);

    static native void SetTextKnockout(long var0, boolean var2);

    static native void SetRenderingIntent(long var0, int var2);

    static native void SetBlendMode(long var0, int var2);

    static native void SetFillOpacity(long var0, double var2);

    static native void SetStrokeOpacity(long var0, double var2);

    static native void SetAISFlag(long var0, boolean var2);

    static native void SetSoftMask(long var0, long var2);

    static native void SetStrokeOverprint(long var0, boolean var2);

    static native void SetFillOverprint(long var0, boolean var2);

    static native void SetOverprintMode(long var0, int var2);

    static native void SetAutoStrokeAdjust(long var0, boolean var2);

    static native void SetSmoothnessTolerance(long var0, double var2);

    static native void SetBlackGenFunct(long var0, long var2);

    static native void SetUCRFunct(long var0, long var2);

    static native void SetTransferFunct(long var0, long var2);

    static native void SetHalftone(long var0, long var2);
}
