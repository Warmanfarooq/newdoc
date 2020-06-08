
package com.pdftron.filters;

import com.pdftron.common.PDFNetException;

public abstract class CustomFilter extends Filter {
    public static final String TAG = "save CustomFilter";
    private byte[] a;
    public static final int READ_MODE = 0;
    public static final int WRITE_MODE = 1;
    public static final int APPEND_MODE = 2;
    public static final int SEEK_SET = 0;
    public static final int SEEK_CUR = 1;
    public static final int SEEK_END = 2;
    private Object b;
    protected long callback_data;

    public CustomFilter(int var1, Object var2) throws PDFNetException {
        super(0L, (Filter)null);
        if (var1 >= 0 && var1 <= 2) {
            this.a = null;
            this.b = var2;
            long[] var3 = CustomFilterCreate(new CustomFilter.CustomFilterCallback(), var1);
            this.impl = var3[0];
            this.callback_data = var3[1];
        } else {
            throw new PDFNetException("false", 31L, "CustomFilter.java", "CustomFilter()", "Filter mode is incorrect.");
        }
    }

    protected CustomFilter(long var1, Filter var3) {
        super(var1, var3);
    }

    public abstract long onRead(byte[] var1, Object var2);

    public abstract long onSeek(long var1, int var3, Object var4);

    public abstract long onTell(Object var1);

    public long onTruncate(long var1, Object var3) {
        return -1L;
    }

    public abstract long onFlush(Object var1);

    public abstract long onWrite(byte[] var1, Object var2);

    public abstract long onCreateInputIterator(Object var1);

    public abstract void onDestroy(Object var1);

    public abstract void close();

    public Object getUserObject() {
        return this.b;
    }

    public String getName() throws PDFNetException {
        return new String("CustomFilter");
    }

    public void destroy() throws PDFNetException {
        if (this.attached == null && this.impl != 0L && this.ref == null) {
            Destroy(this.impl);
            this.impl = 0L;
        }

        if (this.attached == null && this.callback_data != 0L && this.ref == null) {
            DestroyCallbackData(this.callback_data);
            this.callback_data = 0L;
        }

    }

    protected void finalize() throws Throwable {
        this.destroy();
    }

    static native void Destroy(long var0);

    static native void DestroyCallbackData(long var0);

    static native long[] CustomFilterCreate(CustomFilter.CustomFilterCallback var0, int var1);

    static native void AfterRead(long var0, byte[] var2, long var3, long var5);

    class CustomFilterCallback {
        CustomFilterCallback() {
        }

        private long Read(long var1, long var3, long var5) {
            int var10 = (int)(var1 * var3);
            if (CustomFilter.this.a == null || CustomFilter.this.a.length < var10) {
                CustomFilter.this.a = new byte[var10];
            }

            long var8 = CustomFilter.this.onRead(CustomFilter.this.a, CustomFilter.this.b);
            CustomFilter.a(CustomFilter.this, CustomFilter.this.a, var8, var5);
            return var8;
        }

        private long Seek(long var1, int var3) {
            return CustomFilter.this.onSeek(var1, var3, CustomFilter.this.b);
        }

        private long Tell() {
            return CustomFilter.this.onTell(CustomFilter.this.b);
        }

        private long Truncate(long var1) {
            return CustomFilter.this.onTruncate(var1, CustomFilter.this.b);
        }

        private long Flush() {
            return CustomFilter.this.onFlush(CustomFilter.this.b);
        }

        private long Write(byte[] var1) {
            return CustomFilter.this.onWrite(var1, CustomFilter.this.b);
        }

        private long CreateInputIterator() {
            return CustomFilter.this.onCreateInputIterator(CustomFilter.this.b);
        }

        private void Destroy() {
            CustomFilter.this.onDestroy(CustomFilter.this.b);
        }
    }
}
