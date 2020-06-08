//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import com.pdftron.fdf.FDFDoc;
import com.pdftron.filters.FileDescriptorFilter;
import com.pdftron.filters.FileDescriptorReadOnlyFilter;
import com.pdftron.filters.Filter;
import com.pdftron.filters.FilterReader;
import com.pdftron.filters.SecondaryFileFilter;
import com.pdftron.pdf.DigitalSignatureField.DocumentPermissions;
import com.pdftron.pdf.ocg.Config;
import com.pdftron.pdf.struct.STree;
import com.pdftron.sdf.Doc;
import com.pdftron.sdf.Obj;
import com.pdftron.sdf.SDFDoc;
import com.pdftron.sdf.SecurityHandler;
import com.pdftron.sdf.SignatureHandler;
import com.pdftron.sdf.UndoManager;
import com.pdftron.sdf.SDFDoc.SaveMode;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class PDFDoc extends Doc {
    /** @deprecated */
    public static final int e_none = 0;
    /** @deprecated */
    public static final int e_insert_bookmark = 1;
    public static final int e_forms_only = 0;
    public static final int e_annots_only = 1;
    public static final int e_both = 2;
    /** @deprecated */
    public static final int e_flatten_forms_only = 1;
    /** @deprecated */
    public static final int e_flatten_annots_only = 2;
    /** @deprecated */
    public static final int e_flatten_link_only = 4;
    /** @deprecated */
    public static final int e_flatten_all = 8;
    public Filter mCustomFilter;
    private String a;
    /** @deprecated */
    public static final int e_action_trigger_doc_will_close = 17;
    /** @deprecated */
    public static final int e_action_trigger_doc_will_save = 18;
    /** @deprecated */
    public static final int e_action_trigger_doc_did_save = 19;
    /** @deprecated */
    public static final int e_action_trigger_doc_will_print = 20;
    /** @deprecated */
    public static final int e_action_trigger_doc_did_print = 21;

    public PDFDoc() throws PDFNetException {
        this.mCustomFilter = null;
        this.a = null;
        this.impl = PDFDocCreate();
    }

    public PDFDoc(SDFDoc var1) throws PDFNetException {
        this.mCustomFilter = null;
        this.a = null;
        if (var1.__GetRefHandle() != null) {
            throw new PDFNetException("false", 78L, "PDFDoc.java", "PDFDoc(SDFDoc)", "SDFDoc is already owned by another document.");
        } else {
            this.impl = var1.__GetHandle();
            var1.__SetRef(this);
        }
    }

    public PDFDoc(String var1) throws PDFNetException {
        this.mCustomFilter = null;
        this.a = null;
        this.a = var1;
        this.impl = PDFDocCreate(var1);
    }

    public PDFDoc(Filter var1) throws PDFNetException {
        this.mCustomFilter = null;
        this.a = null;
        this.mCustomFilter = var1;
        var1.__SetRefHandle(this);
        this.impl = PDFDocCreateFilter(var1.__GetHandle());
    }

    public PDFDoc(byte[] var1) throws PDFNetException {
        this.mCustomFilter = null;
        this.a = null;
        if (var1 == null) {
            throw new PDFNetException("", 0L, "PDFDoc.java", "PDFDoc(byte[])", "Memory buffer is null.");
        } else {
            this.impl = PDFDocCreate(var1);
        }
    }

    public PDFDoc(InputStream var1) throws PDFNetException, IOException {
        this(var1, 1048576);
    }

    public PDFDoc(InputStream var1, int var2) throws PDFNetException, IOException {
        this.mCustomFilter = null;
        this.a = null;
        long var3 = 0L;

        try {
            var3 = MemStreamCreateMemFilt((long)var1.available());
            byte[] var11 = new byte[var2];

            int var5;
            while((var5 = var1.read(var11)) != -1) {
                MemStreamWriteData(var3, var11, var5);
            }

            long var7 = var3;
            var3 = 0L;
            this.impl = MemStreamCreateDoc(var7);
        } catch (PDFNetException var9) {
            Filter.__Create(var3, (Filter)null).destroy();
            throw var9;
        } catch (IOException var10) {
            Filter.__Create(var3, (Filter)null).destroy();
            throw var10;
        }
    }

    protected void finalize() throws Throwable {
        this.close();
    }

    public void close() throws PDFNetException {
        if (this.impl != 0L) {
            Close(this.impl);
            this.impl = 0L;
            this.a();
            this.mCustomFilter = null;
            this.a = null;
        }

    }

    private void a() throws PDFNetException {
        if (this.mCustomFilter != null) {
            if (this.mCustomFilter instanceof FileDescriptorFilter) {
                ((FileDescriptorFilter)this.mCustomFilter).close();
                return;
            }

            if (this.mCustomFilter instanceof FileDescriptorReadOnlyFilter) {
                ((FileDescriptorReadOnlyFilter)this.mCustomFilter).close();
                return;
            }

            if (this.mCustomFilter instanceof SecondaryFileFilter) {
                ((SecondaryFileFilter)this.mCustomFilter).close();
            }
        }

    }

    /** @deprecated */
    public Obj getTriggerAction(int var1) throws PDFNetException {
        return Obj.__Create(GetTriggerAction(this.impl, var1), this);
    }

    public Obj getTriggerAction(PDFDoc.ActionTriggerMode var1) throws PDFNetException {
        return Obj.__Create(GetTriggerAction(this.impl, var1.getValue()), this);
    }

    public boolean isEncrypted() throws PDFNetException {
        return IsEncrypted(this.impl);
    }

    public boolean initSecurityHandler() throws PDFNetException {
        return InitSecurityHandler(this.impl, (Object)null);
    }

    public boolean initSecurityHandler(Object var1) throws PDFNetException {
        return InitSecurityHandler(this.impl, var1);
    }

    public boolean initStdSecurityHandler(String var1) throws PDFNetException {
        return InitStdSecurityHandler(this.impl, var1);
    }

    public boolean initStdSecurityHandler(byte[] var1) throws PDFNetException {
        return InitStdSecurityHandlerBuffer(this.impl, var1);
    }

    public SecurityHandler getSecurityHandler() {
        SecurityHandler var1;
        return (var1 = SecurityHandler.__Create(GetSecurityHandler(this.impl), this)).__GetHandle() == 0L ? null : var1;
    }

    public void setSecurityHandler(SecurityHandler var1) {
        SetSecurityHandler(this.impl, var1.__GetHandle());
        var1.__SetRefHandle(this);
    }

    public PDFDocInfo getDocInfo() throws PDFNetException {
        return new PDFDocInfo(GetDocInfo(this.impl), this);
    }

    public PDFDocViewPrefs getViewPrefs() throws PDFNetException {
        return new PDFDocViewPrefs(GetViewPrefs(this.impl), this);
    }

    public boolean isModified() throws PDFNetException {
        return IsModified(this.impl);
    }

    public boolean hasChangesSinceSnapshot() throws PDFNetException {
        return HasChangesSinceSnapshot(this.impl);
    }

    public boolean hasRepairedXRef() throws PDFNetException {
        return HasRepairedXRef(this.impl);
    }

    public boolean isLinearized() throws PDFNetException {
        return IsLinearized(this.impl);
    }

    /** @deprecated */
    public void save(String var1, long var2, ProgressMonitor var4) throws PDFNetException {
        Save(this.impl, var1, var2, var4);
    }

    public void save(String var1, SaveMode var2, ProgressMonitor var3) throws PDFNetException {
        this.save(var1, (long)var2.getValue(), var3);
    }

    public void save(String var1, SaveMode[] var2, ProgressMonitor var3) throws PDFNetException {
        long var4 = 0L;
        if (var2 != null) {
            int var6 = (var2 = var2).length;

            for(int var7 = 0; var7 < var6; ++var7) {
                SaveMode var8 = var2[var7];
                var4 |= (long)var8.getValue();
            }
        }

        this.save(var1, var4, var3);
    }

    /** @deprecated */
    public byte[] save(long var1, ProgressMonitor var3) throws PDFNetException {
        return Save(this.impl, var1, var3);
    }

    public byte[] save(SaveMode var1, ProgressMonitor var2) throws PDFNetException {
        return this.save((long)var1.getValue(), var2);
    }

    public byte[] save(SaveMode[] var1, ProgressMonitor var2) throws PDFNetException {
        long var3 = 0L;
        if (var1 != null) {
            int var5 = (var1 = var1).length;

            for(int var6 = 0; var6 < var5; ++var6) {
                SaveMode var7 = var1[var6];
                var3 |= (long)var7.getValue();
            }
        }

        return this.save(var3, var2);
    }

    /** @deprecated */
    public void save(OutputStream var1, long var2, ProgressMonitor var4) throws PDFNetException, IOException {
        this.save(var1, var2, var4, 1048576);
    }

    public void save(OutputStream var1, SaveMode var2, ProgressMonitor var3) throws PDFNetException, IOException {
        this.save(var1, (long)var2.getValue(), var3, 1048576);
    }

    public void save(OutputStream var1, SaveMode[] var2, ProgressMonitor var3) throws PDFNetException, IOException {
        long var4 = 0L;
        if (var2 != null) {
            int var6 = (var2 = var2).length;

            for(int var7 = 0; var7 < var6; ++var7) {
                SaveMode var8 = var2[var7];
                var4 |= (long)var8.getValue();
            }
        }

        this.save(var1, var4, var3, 1048576);
    }

    /** @deprecated */
    public void save(OutputStream var1, long var2, ProgressMonitor var4, int var5) throws PDFNetException, IOException {
        long[] var14;
        long var7 = (var14 = SaveStream(this.impl, var2, var4))[0];
        long var9 = var14[1];
        byte[] var15 = new byte[var5];

        for(long var12 = var9 - (long)var5; var7 < var12; var7 += (long)var5) {
            ReadData(var15, var5, var7);
            var1.write(var15);
        }

        int var3;
        if ((var3 = (int)(var9 - var7)) > 0) {
            ReadData(var15, var3, var7);
            var1.write(var15, 0, var3);
        }

    }

    public void save(OutputStream var1, SaveMode var2, ProgressMonitor var3, int var4) throws PDFNetException, IOException {
        this.save(var1, (long)var2.getValue(), var3, var4);
    }

    public void save(OutputStream var1, SaveMode[] var2, ProgressMonitor var3, int var4) throws PDFNetException, IOException {
        long var5 = 0L;
        if (var2 != null) {
            int var7 = (var2 = var2).length;

            for(int var8 = 0; var8 < var7; ++var8) {
                SaveMode var9 = var2[var8];
                var5 |= (long)var9.getValue();
            }
        }

        this.save(var1, var5, var3, var4);
    }

    /** @deprecated */
    public void save(Filter var1, long var2) throws PDFNetException, IOException {
        if (var1 instanceof FileDescriptorFilter && var1.isInputFilter() && ((FileDescriptorFilter)var1).canWriteOnInputFilter()) {
            FileDescriptorFilter var7;
            if ((var7 = ((FileDescriptorFilter)var1).createOutputIterator()) != null && !var7.isInputFilter()) {
                SaveCustomFilter(this.impl, var7.__GetHandle(), var2);
            }

            this.a();
            this.mCustomFilter = var1;
            var1.__SetRefHandle(this);
        } else if (var1 instanceof SecondaryFileFilter && var1.isInputFilter()) {
            SecondaryFileFilter var4;
            if ((var4 = ((SecondaryFileFilter)var1).createOutputIterator()) != null && !var4.isInputFilter()) {
                try {
                    SaveCustomFilter(this.impl, var4.__GetHandle(), var2);
                } finally {
                    var4.close();
                }

            }
        } else if (!var1.isInputFilter()) {
            SaveCustomFilter(this.impl, var1.__GetHandle(), var2);
        } else {
            throw new PDFNetException("false", 568L, "PDFDoc.java", "PDFDoc(save)", "The filter is not an output filter.");
        }
    }

    public void save(Filter var1, SaveMode var2) throws PDFNetException, IOException {
        this.save(var1, (long)var2.getValue());
    }

    public void save(Filter var1, SaveMode[] var2) throws PDFNetException, IOException {
        long var3 = 0L;
        if (var2 != null) {
            int var5 = (var2 = var2).length;

            for(int var6 = 0; var6 < var5; ++var6) {
                SaveMode var7 = var2[var6];
                var3 |= (long)var7.getValue();
            }
        }

        this.save(var1, var3);
    }

    /** @deprecated */
    public void save(long var1) throws PDFNetException, IOException {
        if (var1 != 32769L) {
            throw new PDFNetException("false", 580L, "PDFDoc.java", "PDFDoc(save)", "This flag is not supported.");
        } else if (this.mCustomFilter != null && this.mCustomFilter instanceof FileDescriptorFilter) {
            FileDescriptorFilter var8;
            if ((var8 = ((FileDescriptorFilter)this.mCustomFilter).createOutputIterator()) != null && !var8.isInputFilter()) {
                long var4 = SaveCustomFilter2(this.impl, var8.__GetHandle(), var1);
                this.mCustomFilter = FileDescriptorFilter.__Create(var4, var8);
            } else {
                throw new PDFNetException("false", 1034L, "PDFDoc.java", "PDFDoc.save(long)", "The filter is not an output filter.");
            }
        } else if (this.mCustomFilter != null && this.mCustomFilter instanceof SecondaryFileFilter) {
            SecondaryFileFilter var3;
            if ((var3 = ((SecondaryFileFilter)this.mCustomFilter).createOutputIterator()) != null && !var3.isInputFilter()) {
                try {
                    SaveCustomFilter2(this.impl, var3.__GetHandle(), var1);
                } finally {
                    var3.close();
                }

            } else {
                throw new PDFNetException("false", 1047L, "PDFDoc.java", "PDFDoc.save(long)", "The filter is not an output filter.");
            }
        } else {
            throw new PDFNetException("false", 580L, "PDFDoc.java", "PDFDoc(save)", "Custom filter is not valid.");
        }
    }

    public void save() throws PDFNetException, IOException {
        if (this.a != null) {
            Save(this.impl, this.a, 1L, (ProgressMonitor)null);
        } else {
            this.save(32769L);
        }
    }

    public boolean saveIncrementalData(String var1) throws PDFNetException {
        return SaveIncrementalData(this.impl, var1);
    }

    public PageIterator getPageIterator() throws PDFNetException {
        return new PageIterator(GetPageIteratorBegin(this.impl), this);
    }

    public PageIterator getPageIterator(int var1) throws PDFNetException {
        return new PageIterator(GetPageIterator(this.impl, var1), this);
    }

    public Page getPage(int var1) throws PDFNetException {
        long var2;
        return (var2 = GetPage(this.impl, var1)) != 0L ? new Page(var2, this) : null;
    }

    public void pageRemove(PageIterator var1) throws PDFNetException {
        PageRemove(this.impl, var1.a());
    }

    public void pageInsert(PageIterator var1, Page var2) throws PDFNetException {
        PageInsert(this.impl, var1.a(), var2.a);
    }

    /** @deprecated */
    public void insertPages(int var1, PDFDoc var2, int var3, int var4, int var5, ProgressMonitor var6) throws PDFNetException {
        PageSet var7;
        (var7 = new PageSet()).addRange(var3, var4);
        this.insertPages(var1, var2, var7, var5, var6);
        var7.destroy();
    }

    public void insertPages(int var1, PDFDoc var2, int var3, int var4, PDFDoc.InsertBookmarkMode var5, ProgressMonitor var6) throws PDFNetException {
        this.insertPages(var1, var2, var3, var4, var5.getValue(), var6);
    }

    /** @deprecated */
    public void insertPages(int var1, PDFDoc var2, PageSet var3, int var4, ProgressMonitor var5) throws PDFNetException {
        InsertPageSet(this.impl, var1, var2.impl, var3.a, var4, var5);
    }

    public void insertPages(int var1, PDFDoc var2, PageSet var3, PDFDoc.InsertBookmarkMode var4, ProgressMonitor var5) throws PDFNetException {
        this.insertPages(var1, var2, var3, var4.getValue(), var5);
    }

    /** @deprecated */
    public void movePages(int var1, PDFDoc var2, int var3, int var4, int var5, ProgressMonitor var6) throws PDFNetException {
        PageSet var7;
        (var7 = new PageSet()).addRange(var3, var4);
        this.movePages(var1, var2, var7, var5, var6);
        var7.destroy();
    }

    public void movePages(int var1, PDFDoc var2, int var3, int var4, PDFDoc.InsertBookmarkMode var5, ProgressMonitor var6) throws PDFNetException {
        this.movePages(var1, var2, var3, var4, var5.getValue(), var6);
    }

    /** @deprecated */
    public void movePages(int var1, PDFDoc var2, PageSet var3, int var4, ProgressMonitor var5) throws PDFNetException {
        MovePageSet(this.impl, var1, var2.impl, var3.a, var4, var5);
    }

    public void movePages(int var1, PDFDoc var2, PageSet var3, PDFDoc.InsertBookmarkMode var4, ProgressMonitor var5) throws PDFNetException {
        MovePageSet(this.impl, var1, var2.impl, var3.a, var4.getValue(), var5);
    }

    public void pagePushFront(Page var1) throws PDFNetException {
        PagePushFront(this.impl, var1.a);
    }

    public void pagePushBack(Page var1) throws PDFNetException {
        PagePushBack(this.impl, var1.a);
    }

    public Page[] importPages(Page[] var1) throws PDFNetException {
        return this.importPages(var1, false);
    }

    public Page[] importPages(Page[] var1, boolean var2) throws PDFNetException {
        long[] var3 = new long[var1.length];

        for(int var4 = 0; var4 < var1.length; ++var4) {
            var3[var4] = var1[var4].a;
        }

        long[] var6;
        var1 = new Page[(var6 = ImportPages(this.impl, var3, var2)).length];

        for(int var5 = 0; var5 < var6.length; ++var5) {
            var1[var5] = new Page(var6[var5], this);
        }

        return var1;
    }

    public Page pageCreate() throws PDFNetException {
        return this.pageCreate(new Rect(0.0D, 0.0D, 612.0D, 792.0D));
    }

    public Page pageCreate(Rect var1) throws PDFNetException {
        return new Page(PageCreate(this.impl, var1.a), this);
    }

    public Bookmark getFirstBookmark() throws PDFNetException {
        return new Bookmark(GetFirstBookmark(this.impl), this);
    }

    public void addRootBookmark(Bookmark var1) throws PDFNetException {
        AddRootBookmark(this.impl, var1.a);
    }

    public Obj getTrailer() throws PDFNetException {
        return Obj.__Create(GetTrailer(this.impl), this);
    }

    public Obj getRoot() throws PDFNetException {
        return Obj.__Create(GetRoot(this.impl), this);
    }

    public void initializeJSContext() throws PDFNetException {
        JSContextInitialize(this.impl);
    }

    public Obj getPages() throws PDFNetException {
        return Obj.__Create(GetPages(this.impl), this);
    }

    public int getPageCount() throws PDFNetException {
        return GetPagesCount(this.impl);
    }

    public FieldIterator getFieldIterator() throws PDFNetException {
        return new FieldIterator(GetFieldIteratorBegin(this.impl), this);
    }

    public FieldIterator getFieldIterator(String var1) throws PDFNetException {
        return new FieldIterator(GetFieldIterator(this.impl, var1), this);
    }

    public Field getField(String var1) throws PDFNetException {
        long var2;
        return (var2 = GetField(this.impl, var1)) != 0L ? new Field(var2, this) : null;
    }

    public Field fieldCreate(String var1, int var2) throws PDFNetException {
        return new Field(FieldCreate(this.impl, var1, var2, 0L, 0L), this);
    }

    public Field fieldCreate(String var1, int var2, Obj var3) throws PDFNetException {
        return new Field(FieldCreate(this.impl, var1, var2, var3.__GetHandle(), 0L), this);
    }

    public Field fieldCreate(String var1, int var2, Obj var3, Obj var4) throws PDFNetException {
        return new Field(FieldCreate(this.impl, var1, var2, var3.__GetHandle(), var4.__GetHandle()), this);
    }

    public Field fieldCreate(String var1, int var2, String var3, String var4) throws PDFNetException {
        return new Field(FieldCreate(this.impl, var1, var2, var3, var4), this);
    }

    public Field fieldCreate(String var1, int var2, String var3) throws PDFNetException {
        return new Field(FieldCreate(this.impl, var1, var2, var3, ""), this);
    }

    public void refreshFieldAppearances() throws PDFNetException {
        RefreshFieldAppearances(this.impl);
    }

    public void flattenAnnotations(boolean var1) throws PDFNetException {
        FlattenAnnotations(this.impl, var1);
    }

    public void flattenAnnotations() throws PDFNetException {
        FlattenAnnotations(this.impl, true);
    }

    /** @deprecated */
    public void flattenAnnotationsAdvanced(long var1) throws PDFNetException {
        FlattenAnnotationsAdvanced(this.impl, var1);
    }

    public void flattenAnnotationsAdvanced(PDFDoc.FlattenMode[] var1) throws PDFNetException {
        long var2 = 0L;
        if (var1 != null) {
            int var4 = (var1 = var1).length;

            for(int var5 = 0; var5 < var4; ++var5) {
                PDFDoc.FlattenMode var6 = var1[var5];
                var2 |= (long)var6.getValue();
            }
        }

        FlattenAnnotationsAdvanced(this.impl, var2);
    }

    public Obj getAcroForm() throws PDFNetException {
        return Obj.__Create(GetAcroForm(this.impl), this);
    }

    public FDFDoc fdfExtract() throws PDFNetException {
        return FDFDoc.__Create(FDFExtract(this.impl, 0));
    }

    public FDFDoc fdfExtract(int var1) throws PDFNetException {
        return FDFDoc.__Create(FDFExtract(this.impl, var1));
    }

    public FDFDoc fdfExtract(ArrayList<Annot> var1) throws PDFNetException {
        long[] var2 = new long[var1.size()];

        for(int var3 = 0; var3 < var1.size(); ++var3) {
            Annot var4 = (Annot)var1.get(var3);
            var2[var3] = var4.getSDFObj().__GetHandle();
        }

        return FDFDoc.__Create(FDFExtract(this.impl, var2));
    }

    public FDFDoc fdfExtract(Annot[] var1) throws PDFNetException {
        long[] var2 = new long[var1.length];

        for(int var3 = 0; var3 < var1.length; ++var3) {
            var2[var3] = var1[var3].getSDFObj().__GetHandle();
        }

        return FDFDoc.__Create(FDFExtract(this.impl, var2));
    }

    public FDFDoc fdfExtract(ArrayList<Annot> var1, ArrayList<Annot> var2, ArrayList<Annot> var3) throws PDFNetException {
        if (var1 == null) {
            var1 = new ArrayList(0);
        }

        if (var2 == null) {
            var2 = new ArrayList(0);
        }

        if (var3 == null) {
            var3 = new ArrayList(0);
        }

        long[] var4 = new long[var1.size()];

        for(int var5 = 0; var5 < var1.size(); ++var5) {
            Annot var6 = (Annot)var1.get(var5);
            var4[var5] = var6.getSDFObj().__GetHandle();
        }

        long[] var10 = new long[var2.size()];

        for(int var11 = 0; var11 < var2.size(); ++var11) {
            Annot var7 = (Annot)var2.get(var11);
            var10[var11] = var7.getSDFObj().__GetHandle();
        }

        long[] var12 = new long[var3.size()];

        for(int var8 = 0; var8 < var3.size(); ++var8) {
            Annot var9 = (Annot)var3.get(var8);
            var12[var8] = var9.getSDFObj().__GetHandle();
        }

        return FDFDoc.__Create(FDFExtract(this.impl, var4, var10, var12));
    }

    public void fdfMerge(FDFDoc var1) throws PDFNetException {
        FDFMerge(this.impl, var1.__GetHandle());
    }

    public void fdfUpdate(FDFDoc var1) throws PDFNetException {
        FDFUpdate(this.impl, var1.__GetHandle());
    }

    public void mergeXFDF(Filter var1, String var2) throws PDFNetException {
        MergeXFDF(this.impl, var1.__GetHandle(), var2);
    }

    public void mergeXFDFString(String var1, String var2) throws PDFNetException {
        MergeXFDFString(this.impl, var1, var2);
    }

    public Action getOpenAction() throws PDFNetException {
        return new Action(GetOpenAction(this.impl), this);
    }

    public void setOpenAction(Action var1) throws PDFNetException {
        SetOpenAction(this.impl, var1.a);
    }

    public void addFileAttachment(String var1, FileSpec var2) throws PDFNetException {
        AddFileAttachment(this.impl, var1, var2.a);
    }

    public PageLabel getPageLabel(int var1) throws PDFNetException {
        return new PageLabel(GetPageLabel(this.impl, var1), this);
    }

    public void setPageLabel(int var1, PageLabel var2) throws PDFNetException {
        SetPageLabel(this.impl, var1, var2.a);
    }

    public void removePageLabel(int var1) throws PDFNetException {
        RemovePageLabel(this.impl, var1);
    }

    public STree getStructTree() throws PDFNetException {
        return STree.__Create(GetStructTree(this.impl), this);
    }

    public boolean hasOC() throws PDFNetException {
        return HasOC(this.impl);
    }

    public Obj getOCGs() throws PDFNetException {
        return Obj.__Create(GetOCGs(this.impl), this);
    }

    public Config getOCGConfig() throws PDFNetException {
        return Config.__Create(GetOCGConfig(this.impl), this);
    }

    public Obj createIndirectName(String var1) throws PDFNetException {
        return Obj.__Create(CreateIndirectName(this.impl, var1), this);
    }

    public Obj createIndirectArray() throws PDFNetException {
        return Obj.__Create(CreateIndirectArray(this.impl), this);
    }

    public Obj createIndirectBool(boolean var1) throws PDFNetException {
        return Obj.__Create(CreateIndirectBool(this.impl, var1), this);
    }

    public Obj createIndirectDict() throws PDFNetException {
        return Obj.__Create(CreateIndirectDict(this.impl), this);
    }

    public Obj createIndirectNull() throws PDFNetException {
        return Obj.__Create(CreateIndirectNull(this.impl), this);
    }

    public Obj createIndirectNumber(double var1) throws PDFNetException {
        return Obj.__Create(CreateIndirectNumber(this.impl, var1), this);
    }

    public Obj createIndirectString(byte[] var1) throws PDFNetException {
        return Obj.__Create(CreateIndirectString(this.impl, var1), this);
    }

    public Obj createIndirectString(String var1) throws PDFNetException {
        return Obj.__Create(CreateIndirectString(this.impl, var1), this);
    }

    public Obj createIndirectStream(FilterReader var1) throws PDFNetException {
        return Obj.__Create(CreateIndirectStream(this.impl, var1.__GetHandle(), 0L), this);
    }

    public Obj createIndirectStream(FilterReader var1, Filter var2) throws PDFNetException {
        if (var2 != null) {
            var2.__SetRefHandle(this);
        }

        return Obj.__Create(CreateIndirectStream(this.impl, var1.__GetHandle(), var2.__GetHandle()), this);
    }

    public Obj createIndirectStream(byte[] var1) throws PDFNetException {
        return Obj.__Create(CreateIndirectStream(this.impl, var1, 0L), this);
    }

    public Obj createIndirectStream(byte[] var1, Filter var2) throws PDFNetException {
        if (var2 != null) {
            var2.__SetRefHandle(this);
        }

        return Obj.__Create(CreateIndirectStream(this.impl, var1, var2.__GetHandle()), this);
    }

    public SDFDoc getSDFDoc() {
        return SDFDoc.__Create(this.impl, this);
    }

    public void lock() throws PDFNetException {
        Lock(this.impl);
    }

    public void unlock() throws PDFNetException {
        Unlock(this.impl);
    }

    public boolean tryLock() throws PDFNetException {
        return TryLock(this.impl, 0);
    }

    public boolean timedLock(int var1) throws PDFNetException {
        return TryLock(this.impl, var1);
    }

    public void lockRead() throws PDFNetException {
        LockRead(this.impl);
    }

    public void unlockRead() throws PDFNetException {
        UnlockRead(this.impl);
    }

    public boolean tryLockRead() throws PDFNetException {
        return TryLockRead(this.impl, 0);
    }

    public boolean timedLockRead(int var1) throws PDFNetException {
        return TryLockRead(this.impl, var1);
    }

    public String getFileName() throws PDFNetException {
        return GetFileName(this.impl);
    }

    public void generateThumbnails(long var1) throws PDFNetException {
        GenerateThumbnails(this.impl, var1);
    }

    public void appendVisualDiff(Page var1, Page var2, DiffOptions var3) throws PDFNetException {
        AppendVisualDiff(this.impl, var1 != null ? var1.a : 0L, var2 != null ? var2.a : 0L, var3 != null ? var3.a() : 0L);
    }

    public long getDownloadedByteCount() throws PDFNetException {
        return GetDownloadedByteCount(this.impl);
    }

    public long getTotalRemoteByteCount() throws PDFNetException {
        return GetTotalRemoteByteCount(this.impl);
    }

    public boolean hasDownloader() throws PDFNetException {
        return HasDownloader(this.impl);
    }

    public UndoManager getUndoManager() throws PDFNetException {
        return new UndoManager(GetUndoManager(this.impl));
    }

    public void removeSecurity() {
        RemoveSecurity(this.impl);
    }

    public void addHighlights(String var1) {
        AddHighlights(this.impl, var1);
    }

    public boolean isTagged() {
        return IsTagged(this.impl);
    }

    public boolean hasSignatures() {
        return HasSignatures(this.impl);
    }

    public long addSignatureHandler(SignatureHandler var1) throws PDFNetException {
        return AddSignatureHandler(this.impl, var1);
    }

    public long addStdSignatureHandler(String var1, String var2) throws PDFNetException {
        return AddStdSignatureHandlerFromFile(this.impl, var1, var2);
    }

    public long addStdSignatureHandler(byte[] var1, String var2) throws PDFNetException {
        return AddStdSignatureHandlerFromBuffer(this.impl, var1, var2);
    }

    public void removeSignatureHandler(long var1) throws PDFNetException {
        RemoveSignatureHandler(this.impl, var1);
    }

    public SignatureHandler getSignatureHandler(long var1) throws PDFNetException {
        return GetSignatureHandler(this.impl, var1);
    }

    public DigitalSignatureField createDigitalSignatureField(String var1) throws PDFNetException {
        return new DigitalSignatureField(CreateDigitalSignatureField(this.impl, var1), this);
    }

    public DigitalSignatureField createDigitalSignatureField() throws PDFNetException {
        return new DigitalSignatureField(CreateDigitalSignatureField(this.impl), this);
    }

    public DigitalSignatureFieldIterator getDigitalSignatureFieldIterator() throws PDFNetException {
        return new DigitalSignatureFieldIterator(GetDigitalSignatureFieldIteratorBegin(this.impl), this);
    }

    public DocumentPermissions getDigitalSignaturePermissions() throws PDFNetException {
        return DocumentPermissions.a(GetDigitalSignaturePermissions(this.impl));
    }

    public void saveViewerOptimized(String var1, ViewerOptimizedOptions var2) {
        SaveViewerOptimized(this.impl, var1, var2.a.__GetHandle());
    }

    PDFDoc(long var1) {
        this.mCustomFilter = null;
        this.a = null;
        this.impl = var1;
    }

    public static PDFDoc __Create(long var0) {
        return new PDFDoc(var0);
    }

    public long __GetHandle() {
        return this.impl;
    }

    static native long PDFDocCreate();

    static native long PDFDocCreate(String var0);

    static native long PDFDocCreateFilter(long var0);

    static native long PDFDocCreate(byte[] var0);

    static native long GetTriggerAction(long var0, int var2);

    static native long MemStreamCreateMemFilt(long var0) throws PDFNetException;

    static native void MemStreamWriteData(long var0, byte[] var2, int var3);

    static native long MemStreamCreateDoc(long var0);

    static native void Close(long var0);

    static native boolean IsEncrypted(long var0);

    static native boolean InitSecurityHandler(long var0, Object var2);

    static native boolean InitStdSecurityHandler(long var0, String var2);

    static native boolean InitStdSecurityHandlerBuffer(long var0, byte[] var2);

    static native long GetSecurityHandler(long var0);

    static native void SetSecurityHandler(long var0, long var2);

    static native long GetDocInfo(long var0);

    static native long GetViewPrefs(long var0);

    static native boolean IsModified(long var0);

    static native boolean HasChangesSinceSnapshot(long var0);

    static native boolean HasRepairedXRef(long var0);

    static native boolean IsLinearized(long var0);

    static native boolean SaveIncrementalData(long var0, String var2);

    static native void Save(long var0, String var2, long var3, ProgressMonitor var5);

    static native byte[] Save(long var0, long var2, ProgressMonitor var4);

    static native long[] SaveStream(long var0, long var2, ProgressMonitor var4);

    static native void SaveCustomFilter(long var0, long var2, long var4);

    static native long SaveCustomFilter2(long var0, long var2, long var4);

    static native void ReadData(byte[] var0, int var1, long var2);

    static native void RemoveSecurity(long var0);

    static native long GetPageIteratorBegin(long var0);

    static native long GetPageIterator(long var0, int var2);

    static native long GetPage(long var0, int var2);

    static native void PageRemove(long var0, long var2);

    static native void PageInsert(long var0, long var2, long var4);

    static native void InsertPageSet(long var0, int var2, long var3, long var5, int var7, ProgressMonitor var8);

    static native void MovePageSet(long var0, int var2, long var3, long var5, int var7, ProgressMonitor var8);

    static native void PagePushFront(long var0, long var2);

    static native void PagePushBack(long var0, long var2);

    static native long[] ImportPages(long var0, long[] var2, boolean var3);

    static native long PageCreate(long var0, long var2);

    static native long GetFirstBookmark(long var0);

    static native void AddRootBookmark(long var0, long var2);

    static native long GetTrailer(long var0);

    static native long GetRoot(long var0);

    static native void JSContextInitialize(long var0);

    static native long GetPages(long var0);

    static native int GetPagesCount(long var0);

    static native long GetFieldIteratorBegin(long var0);

    static native long GetFieldIterator(long var0, String var2);

    static native long GetField(long var0, String var2);

    static native long FieldCreate(long var0, String var2, int var3, long var4, long var6);

    static native long FieldCreate(long var0, String var2, int var3, String var4, String var5);

    static native void RefreshFieldAppearances(long var0);

    static native void FlattenAnnotations(long var0, boolean var2);

    static native void FlattenAnnotationsAdvanced(long var0, long var2);

    static native long GetAcroForm(long var0);

    static native long FDFExtract(long var0, int var2);

    static native long FDFExtract(long var0, long[] var2);

    static native long FDFExtract(long var0, long[] var2, long[] var3, long[] var4);

    static native void FDFMerge(long var0, long var2);

    static native void FDFUpdate(long var0, long var2);

    static native void MergeXFDF(long var0, long var2, String var4);

    static native void MergeXFDFString(long var0, String var2, String var3);

    static native long GetOpenAction(long var0);

    static native void SetOpenAction(long var0, long var2);

    static native void AddFileAttachment(long var0, String var2, long var3);

    static native long GetPageLabel(long var0, int var2);

    static native void SetPageLabel(long var0, int var2, long var3);

    static native void RemovePageLabel(long var0, int var2);

    static native long GetStructTree(long var0);

    static native boolean HasOC(long var0);

    static native long GetOCGs(long var0);

    static native long GetOCGConfig(long var0);

    static native long CreateIndirectName(long var0, String var2);

    static native long CreateIndirectArray(long var0);

    static native long CreateIndirectBool(long var0, boolean var2);

    static native long CreateIndirectDict(long var0);

    static native long CreateIndirectNull(long var0);

    static native long CreateIndirectNumber(long var0, double var2);

    static native long CreateIndirectString(long var0, byte[] var2);

    static native long CreateIndirectString(long var0, String var2);

    static native long CreateIndirectStream(long var0, long var2, long var4);

    static native long CreateIndirectStream(long var0, byte[] var2, long var3);

    static native void Lock(long var0);

    static native void Unlock(long var0);

    static native boolean TryLock(long var0, int var2);

    static native void LockRead(long var0);

    static native void UnlockRead(long var0);

    static native boolean TryLockRead(long var0, int var2);

    static native void AddHighlights(long var0, String var2);

    static native boolean IsTagged(long var0);

    static native String GetFileName(long var0);

    static native void GenerateThumbnails(long var0, long var2);

    static native void AppendVisualDiff(long var0, long var2, long var4, long var6);

    static native long GetDownloadedByteCount(long var0);

    static native long GetTotalRemoteByteCount(long var0);

    static native boolean HasDownloader(long var0);

    static native long GetUndoManager(long var0);

    static native boolean HasSignatures(long var0);

    static native long AddSignatureHandler(long var0, SignatureHandler var2);

    static native long AddStdSignatureHandlerFromFile(long var0, String var2, String var3);

    static native long AddStdSignatureHandlerFromBuffer(long var0, byte[] var2, String var3);

    static native SignatureHandler RemoveSignatureHandler(long var0, long var2);

    static native SignatureHandler GetSignatureHandler(long var0, long var2);

    static native long CreateDigitalSignatureField(long var0, String var2);

    static native long CreateDigitalSignatureField(long var0);

    static native long GetDigitalSignatureFieldIteratorBegin(long var0);

    static native int GetDigitalSignaturePermissions(long var0);

    static native void SaveViewerOptimized(long var0, String var2, long var3);

    public static enum ActionTriggerMode {
        DOC_WILL_CLOSE(17),
        DOC_WILL_SAVE(18),
        DOC_DID_SAVE(19),
        DOC_WILL_PRINT(20),
        DOC_DID_PRINT(21);

        private final int a;

        private ActionTriggerMode(int var3) {
            this.a = var3;
        }

        public final int getValue() {
            return this.a;
        }
    }

    public static enum FlattenMode {
        FORMS(1),
        ANNOTS(2),
        LINK(4),
        ALL(8);

        private final int a;

        private FlattenMode(int var3) {
            this.a = var3;
        }

        public final int getValue() {
            return this.a;
        }
    }

    public static enum InsertBookmarkMode {
        NONE(0),
        INSERT(1),
        INSERT_GOTO(2);

        private final int a;

        private InsertBookmarkMode(int var3) {
            this.a = var3;
        }

        public final int getValue() {
            return this.a;
        }
    }
}
