
package com.pdftron.pdf;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Bitmap.Config;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint.Align;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Debug;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.os.Build.VERSION;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.GestureDetector;
import android.view.InputDevice;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.OverScroller;
import android.widget.TextView;
import android.widget.VideoView;
import android.widget.TextView.OnEditorActionListener;
import com.pdftron.common.Matrix2D;
import com.pdftron.common.PDFNetException;
import com.pdftron.filters.Filter;
import com.pdftron.filters.SecondaryFileFilter;
import com.pdftron.sdf.DictIterator;
import com.pdftron.sdf.Obj;
import com.pdftron.sdf.ObjSet;
import com.pdftron.sdf.SDFDoc;
import com.pdftron.sdf.SecurityHandler;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.Bidi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;
import java.util.Map.Entry;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PDFViewCtrl extends ViewGroup {
    private static final String c = PDFViewCtrl.class.getName();
    static boolean a = false;
    static boolean b = false;
    private static boolean d;
    protected PDFDoc mDoc;
    protected SecondaryFileFilter mDocumentConversionFilter;
    private ExternalAnnotManager e;
    private OverScroller f;
    private OverScroller g;
    private OverScroller h;
    private com.pdftron.pdf.g i;
    private final Lock j;
    private final Lock k;
    private com.pdftron.pdf.f l;
    private com.pdftron.pdf.d m;
    private Bitmap n;
    private boolean o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private int v;
    private boolean w;
    private int x;
    private int y;
    private int z;
    private boolean A;
    private boolean B;
    private PointF C;
    private final Lock D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private SparseArray<Rect> J;
    private List<Integer> K;
    private static int L;
    private Set<Long> M;
    private boolean N;
    private int O;
    private int P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private boolean W;
    private boolean aa;
    private boolean ab;
    private boolean ac;
    private boolean ad;
    private MotionEvent ae;
    private boolean af;
    private Matrix ag;
    private Matrix ah;
    private Rect ai;
    private Rect aj;
    private RectF ak;
    private RectF al;
    private Paint am;
    private Paint an;
    private Paint ao;
    private Paint ap;
    private Paint aq;
    private Paint ar;
    private Paint as;
    private Paint at;
    private Paint au;
    private Paint av;
    private Paint aw;
    private Paint ax;
    private Paint ay;
    private Paint az;
    private com.pdftron.pdf.f.a[] aA;
    private int aB;
    private int aC;
    private int aD;
    private int aE;
    private int aF;
    private int aG;
    private int aH;
    private int aI;
    private int aJ;
    private int aK;
    private int aL;
    private int aM;
    private RectF aN;
    private RectF aO;
    private SparseArray<RectF> aP;
    private SparseArray<RectF> aQ;
    private int aR;
    private float aS;
    private float aT;
    private float aU;
    private float aV;
    private float aW;
    private float aX;
    private float aY;
    private int aZ;
    private int ba;
    private float bb;
    private float bc;
    private float bd;
    private float be;
    private float bf;
    private boolean bg;
    private double bh;
    private double bi;
    private PDFViewCtrl.ZoomLimitMode bj;
    private double bk;
    private double bl;
    private double bm;
    private double bn;
    private double bo;
    private int bp;
    private float bq;
    private float br;
    private boolean bs;
    private PointF bt;
    private float bu;
    private boolean bv;
    private boolean bw;
    private boolean bx;
    private int by;
    private boolean bz;
    private boolean bA;
    private PDFViewCtrl.TextSearchListener bB;
    private CopyOnWriteArrayList<PDFViewCtrl.DocumentDownloadListener> bC;
    private CopyOnWriteArrayList<PDFViewCtrl.UniversalDocumentConversionListener> bD;
    private boolean bE;
    private CopyOnWriteArrayList<PDFViewCtrl.PageChangeListener> bF;
    private int bG;
    private int bH;
    private PDFViewCtrl.PageChangeState bI;
    private CopyOnWriteArrayList<PDFViewCtrl.DocumentLoadListener> bJ;
    private boolean bK;
    private PDFViewCtrl.ErrorReportListener bL;
    private ArrayList<PDFViewCtrl.ThumbAsyncListener> bM;
    private PDFViewCtrl.ActionCompletedListener bN;
    private PDFViewCtrl.RenderingListener bO;
    private PDFViewCtrl.UniversalDocumentProgressIndicatorListener bP;
    private boolean bQ;
    private PDFViewCtrl.c bR;
    private PDFViewCtrl.ToolManager bS;
    private PDFViewCtrl.PageViewMode bT;
    private PDFViewCtrl.PageViewMode bU;
    private PDFViewCtrl.PagePresentationMode bV;
    private boolean bW;
    private boolean bX;
    private boolean bY;
    private boolean bZ;
    private boolean ca;
    private boolean cb;
    private int cc;
    private int cd;
    private PDFViewCtrl.j ce;
    private Object cf;
    private int cg;
    private int ch;
    private final Lock ci;
    private boolean cj;
    private boolean ck;
    private boolean cl;
    private int cm;
    private int cn;
    private boolean co;
    private boolean cp;
    private int cq;
    private int cr;
    private float cs;
    private float ct;
    private float cu;
    private boolean cv;
    private SparseIntArray cw;
    private SparseIntArray cx;
    private PDFViewCtrl.PageViewMode cy;
    private boolean cz;
    private boolean cA;
    private boolean cB;
    private ArrayList<PDFViewCtrl.OnCanvasSizeChangeListener> cC;
    private PDFViewCtrl.u cD;
    private int cE;
    private SparseArray<double[]> cF;
    public static final double SCROLL_ZOOM_FACTOR = 1.5D;
    public static int DEFAULT_BG_COLOR;
    public static int DEFAULT_DARK_BG_COLOR;
    private Rect cG;
    private Rect cH;
    private Rect cI;
    private Rect cJ;
    private Rect cK;
    private Rect cL;
    private Rect cM;
    private RectF cN;
    private RectF cO;
    private RectF cP;
    private float cQ;
    private float cR;
    private float cS;
    private float cT;
    private PDFViewCtrl.UniversalDocumentConversionListener cU;
    private boolean cV;
    private int[] cW;
    private long cX;
    private long cY;
    private long cZ;
    private GestureDetector da;
    private ScaleGestureDetector db;
    private final PDFViewCtrl.i dc;
    private final PDFViewCtrl.m dd;
    private final PDFViewCtrl.k de;
    private final PDFViewCtrl.d df;
    private final PDFViewCtrl.b dg;
    private final PDFViewCtrl.l dh;
    private final PDFViewCtrl.h di;
    private final PDFViewCtrl.q dj;
    private final PDFViewCtrl.p dk;
    private final PDFViewCtrl.t dl;
    private final PDFViewCtrl.g dm;
    private final PDFViewCtrl.e dn;
    private final PDFViewCtrl.f doo;
    private final PDFViewCtrl.s dp;
    private final PDFViewCtrl.a dq;
    private final PDFViewCtrl.r dr;
    private Thread ds;

    static void a(int var0, String var1, int var2) {
        try {
            PDFNetInternalTools.logMessage(var0, "WRAPPER - " + Process.myTid() + " - " + var2 + ": " + var1, "PDFViewCtrl.java", var2);
        } catch (Exception var3) {
        }
    }

    static int a(boolean var0) {
        if (d) {
            int var2 = var0 ? 0 : 1;
            StackTraceElement[] var1 = Thread.currentThread().getStackTrace();
            if (L + var2 >= var1.length) {
                var2 = var1.length - 1 - L;
            }

            return var1[L + var2].getLineNumber();
        } else {
            return 0;
        }
    }

    public void refreshAndUpdate(ViewChangeCollection var1) throws PDFNetException {
        RefreshAndUpdate(this.cY, var1.a);
    }

    private long b() {
        long var7 = Runtime.getRuntime().maxMemory();
        if (b) {
            a(1, "getAllowedMaxHeapSize: " + var7, a(true));
        }

        long var1 = var7;
        var7 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (b) {
            a(1, "getAllocatedHeapSize: " + var7, a(true));
        }

        long var5;
        if ((var5 = var1 - var7) < 10485760L) {
            var5 = 0L;
        }

        if (b) {
            a(1, "getAvailableHeapSize: " + var5, a(true));
        }

        return var5;
    }

    public PDFViewCtrl(Context var1, AttributeSet var2) {
        this(var1, var2, 0);
    }

    public PDFViewCtrl(Context var1, AttributeSet var2, int var3) {
        super(var1, var2, var3);
        this.j = new ReentrantLock();
        this.k = new ReentrantLock();
        this.C = new PointF(0.0F, 0.0F);
        this.D = new ReentrantLock();
        this.E = 0;
        this.F = 0;
        this.G = 3;
        this.H = 3;
        this.I = 0;
        this.J = new SparseArray();
        this.M = new HashSet();
        this.aB = 0;
        this.aC = 0;
        this.aD = 0;
        this.aE = 0;
        this.aF = 0;
        this.aG = 0;
        this.aH = 0;
        this.aI = 0;
        this.aJ = 0;
        this.aK = 0;
        this.aL = 0;
        this.aM = 0;
        this.aN = new RectF();
        this.aO = new RectF();
        this.aP = new SparseArray();
        this.aQ = new SparseArray();
        this.bm = 1.0D;
        this.ci = new ReentrantLock();
        this.ck = true;
        this.cl = false;
        this.cm = 0;
        this.cn = 0;
        this.co = false;
        this.cp = false;
        this.cq = PDFViewCtrl.o.d;
        this.cv = false;
        this.cw = new SparseIntArray();
        this.cx = new SparseIntArray();
        this.cz = false;
        this.cA = false;
        this.cB = true;
        this.cE = 0;
        this.cG = new Rect();
        this.cH = new Rect();
        this.cI = new Rect();
        this.cJ = new Rect();
        this.cK = new Rect();
        this.cL = new Rect();
        this.cM = new Rect();
        this.cN = new RectF();
        this.cO = new RectF();
        this.cP = new RectF();
        this.cQ = 1.7014117E38F;
        this.cR = -1.7014117E38F;
        this.cS = 1.7014117E38F;
        this.cT = -1.7014117E38F;
        this.cU = new PDFViewCtrl.UniversalDocumentConversionListener() {
            public final void onConversionEvent(PDFViewCtrl.ConversionState var1, int var2) {
                switch(var1) {
                    case PROGRESS:
                        return;
                    case FINISHED:
                        if (PDFViewCtrl.this.mDocumentConversionFilter != null) {
                            PDFViewCtrl.this.mDocumentConversionFilter.close();
                            PDFViewCtrl.this.mDocumentConversionFilter = null;
                        }

                        PDFViewCtrl.this.removeUniversalDocumentConversionListener(PDFViewCtrl.this.cU);
                        return;
                    case FAILED:
                        if (PDFViewCtrl.this.mDocumentConversionFilter != null) {
                            PDFViewCtrl.this.mDocumentConversionFilter.close();
                            PDFViewCtrl.this.mDocumentConversionFilter = null;
                        }

                        PDFViewCtrl.this.removeUniversalDocumentConversionListener(PDFViewCtrl.this.cU);
                    default:
                }
            }
        };
        this.cV = false;
        this.da = new GestureDetector(this.getContext(), new SimpleOnGestureListener() {
            public final boolean onScroll(MotionEvent var1, MotionEvent var2, float var3, float var4) {
                if (var2.getButtonState() == 2) {
                    return false;
                } else {
                    InputDevice var10000 = var1 != null ? InputDevice.getDevice(var1.getDeviceId()) : null;
                    InputDevice var5 = var10000;
                    if (var10000 == null || (var5.getSources() & 8194) == 0) {
                        PDFViewCtrl.this.Q = true;
                    }

                    return PDFViewCtrl.this.onScroll(var1, var2, var3, var4);
                }
            }

            public final boolean onFling(MotionEvent var1, MotionEvent var2, float var3, float var4) {
                if (var2.getButtonState() == 2) {
                    return false;
                } else {
                    PDFViewCtrl.this.Q = false;
                    PDFViewCtrl.c(c(), true);
                    return PDFViewCtrl.this.onFling(var1, var2, var3, var4);
                }
            }

            public final boolean onDoubleTap(MotionEvent var1) {
                if (var1.getButtonState() == 2) {
                    return false;
                } else {
                    return PDFViewCtrl.this.ce.b ? true : PDFViewCtrl.this.onDoubleTap(var1);
                }
            }

            public final boolean onDoubleTapEvent(MotionEvent var1) {
                if (var1.getButtonState() == 2) {
                    return false;
                } else {
                    return PDFViewCtrl.this.ce.b ? true : PDFViewCtrl.this.onDoubleTapEvent(var1);
                }
            }

            public final boolean onDown(MotionEvent var1) {
                return var1.getButtonState() == 2 ? false : PDFViewCtrl.this.onDown(var1);
            }

            public final void onLongPress(MotionEvent var1) {
                if (var1.getButtonState() != 2) {
                    PDFViewCtrl.this.onLongPress(var1);
                }
            }

            public final void onShowPress(MotionEvent var1) {
                if (var1.getButtonState() != 2) {
                    PDFViewCtrl.this.onShowPress(var1);
                }
            }

            public final boolean onSingleTapUp(MotionEvent var1) {
                if (var1.getButtonState() == 2) {
                    return true;
                } else {
                    return PDFViewCtrl.this.ce.b ? true : PDFViewCtrl.this.onSingleTapUp(var1);
                }
            }

            public final boolean onSingleTapConfirmed(MotionEvent var1) {
                if (var1.getButtonState() == 2) {
                    return false;
                } else if (PDFViewCtrl.this.ce.b) {
                    return true;
                } else if (!PDFViewCtrl.this.ac) {
                    return PDFViewCtrl.this.onSingleTapConfirmed(var1);
                } else {
                    PDFViewCtrl.this.ac = false;
                    return false;
                }
            }
        }, (Handler)null, true);
        this.db = new ScaleGestureDetector(this.getContext(), new SimpleOnScaleGestureListener() {
            public final boolean onScale(ScaleGestureDetector var1) {
                PDFViewCtrl.this.T = false;
                return PDFViewCtrl.this.onScale(var1);
            }

            public final boolean onScaleBegin(ScaleGestureDetector var1) {
                PDFViewCtrl.f(PDFViewCtrl.this, true);
                PDFViewCtrl.g(PDFViewCtrl.this, true);
                PDFViewCtrl.h(PDFViewCtrl.this, false);
                PDFViewCtrl.this.W = true;
                return PDFViewCtrl.this.onScaleBegin(var1);
            }

            public final void onScaleEnd(ScaleGestureDetector var1) {
                PDFViewCtrl.this.T = true;
                PDFViewCtrl.this.W = false;
                PDFViewCtrl.this.onScaleEnd(var1);
            }
        });
        this.dc = new PDFViewCtrl.i(this);
        this.dd = new PDFViewCtrl.m(this);
        this.de = new PDFViewCtrl.k(this);
        this.df = new PDFViewCtrl.d(this);
        this.dg = new PDFViewCtrl.b(this);
        this.dh = new PDFViewCtrl.l(this);
        this.di = new PDFViewCtrl.h(this);
        this.dj = new PDFViewCtrl.q(this);
        this.dk = new PDFViewCtrl.p(this);
        this.dl = new PDFViewCtrl.t(this);
        this.dm = new PDFViewCtrl.g(this);
        this.dn = new PDFViewCtrl.e(this);
        this.doo = new PDFViewCtrl.f(this);
        this.dp = new PDFViewCtrl.s(this);
        this.dq = new PDFViewCtrl.a(this);
        this.dr = new PDFViewCtrl.r(this);
        Context var13 = var1;
        PDFViewCtrl var11 = this;
        this.bQ = false;
        this.s = true;
        this.o = false;
        this.r = false;
        this.t = false;
        this.u = false;
        this.cF = new SparseArray();
        this.N = true;
        this.O = 2000;
        this.P = 750;
        this.Q = false;
        this.R = false;
        this.S = false;
        this.T = false;
        this.bg = false;
        this.ab = false;
        this.ad = false;
        this.A = false;
        this.v = 0;
        this.bB = null;
        this.by = 0;
        this.bz = false;
        this.bA = false;
        this.bF = null;
        this.bG = 1;
        this.bH = 1;
        this.bI = PDFViewCtrl.PageChangeState.END;
        this.bC = null;
        this.bO = null;
        this.bP = null;
        this.bK = false;
        this.bL = null;
        this.bh = 0.0D;
        this.bi = 500000.0D;
        this.bj = PDFViewCtrl.ZoomLimitMode.NONE;
        this.bk = 1.0D;
        this.bl = this.bk;
        this.bn = 1.0D;
        this.bo = this.bn;
        this.bT = PDFViewCtrl.PageViewMode.FIT_PAGE;
        this.bU = PDFViewCtrl.PageViewMode.NOT_DEFINED;
        this.bV = PDFViewCtrl.PagePresentationMode.SINGLE;
        this.aA = new com.pdftron.pdf.f.a[2];
        this.K = new ArrayList(10);
        this.x = Color.argb(255, 255, 255, 255);
        this.y = Color.argb(255, 255, 255, 255);
        this.am = new Paint();
        this.am.setColor(this.x);
        this.am.setStyle(Style.FILL);
        this.am.setAntiAlias(true);
        this.am.setFilterBitmap(false);
        this.an = new Paint(this.am);
        this.an.setXfermode(new PorterDuffXfermode(Mode.MULTIPLY));
        this.bW = true;
        this.bY = true;
        this.z = DEFAULT_BG_COLOR;
        this.setBackgroundColor(this.z);
        this.ao = new Paint();
        this.ao.setColor(this.z);
        this.ao.setStyle(Style.FILL);
        this.ao.setAntiAlias(true);
        this.ao.setFilterBitmap(false);
        if (a) {
            this.ap = new Paint();
            this.ap.setColor(Color.argb(50, 240, 177, 114));
            this.ap.setStyle(Style.FILL);
            this.ap.setAntiAlias(true);
            this.ap.setFilterBitmap(false);
            this.aq = new Paint();
            this.aq.setColor(Color.argb(50, 255, 0, 0));
            this.aq.setStyle(Style.STROKE);
            this.aq.setAntiAlias(true);
            this.aq.setFilterBitmap(false);
            this.ar = new Paint(this.ap);
            this.ar.setColor(Color.argb(50, 10, 186, 181));
            this.as = new Paint(this.ar);
            this.as.setColor(Color.argb(50, 255, 198, 123));
            this.at = new Paint();
            this.at.setColor(Color.argb(50, 255, 0, 0));
            this.at.setStyle(Style.FILL);
            this.at.setAntiAlias(true);
            this.at.setFilterBitmap(false);
            this.au = new Paint();
            this.au.setColor(Color.argb(50, 0, 0, 255));
            this.au.setStyle(Style.FILL);
            this.au.setAntiAlias(true);
            this.au.setFilterBitmap(false);
            this.av = new Paint();
            this.av.setColor(-16777216);
            this.av.setStrokeJoin(Join.ROUND);
            this.av.setStrokeCap(Cap.ROUND);
            this.av.setStyle(Style.STROKE);
            this.av.setTextAlign(Align.LEFT);
            this.av.setTextSize(30.0F);
            this.aw = new Paint();
            this.aw.setColor(Color.argb(100, 0, 255, 0));
            this.aw.setStyle(Style.FILL);
            this.aw.setAntiAlias(true);
            this.aw.setFilterBitmap(false);
            this.ax = new Paint();
            this.ax.setColor(Color.argb(100, 0, 255, 100));
            this.ax.setStyle(Style.FILL);
            this.ax.setAntiAlias(true);
            this.ax.setFilterBitmap(false);
            this.ay = new Paint();
            this.ay.setColor(Color.argb(100, 100, 255, 0));
            this.ay.setStyle(Style.FILL);
            this.ay.setAntiAlias(true);
            this.ay.setFilterBitmap(false);
            this.az = new Paint();
            this.az.setColor(Color.argb(100, 100, 255, 100));
            this.az.setStyle(Style.FILL);
            this.az.setAntiAlias(true);
            this.az.setFilterBitmap(false);
        }

        this.mDoc = null;
        this.l = new com.pdftron.pdf.f();
        this.m = new com.pdftron.pdf.d();
        this.f = new OverScroller(var13);
        this.g = new OverScroller(var13);
        this.h = new OverScroller(var13);
        this.ah = new Matrix();
        this.ag = new Matrix();
        this.ai = new Rect();
        this.aj = new Rect();
        this.ak = new RectF();
        this.al = new RectF();
        this.da.setIsLongpressEnabled(false);
        this.bZ = true;
        this.ac = false;
        this.setFocusable(true);
        this.setFocusableInTouchMode(true);
        this.setVerticalScrollBarEnabled(true);
        this.setHorizontalScrollBarEnabled(true);
        this.setScrollBarStyle(50331648);
        this.setWillNotDraw(false);
        this.ca = true;
        this.cb = true;
        this.cc = var13.getResources().getInteger(17694722);
        this.cd = 1000;
        this.ce = new PDFViewCtrl.j(this.cc, this.cd);
        this.aR = var13.getResources().getInteger(17694720);
        this.i = new com.pdftron.pdf.g(this.aR);
        this.cf = null;
        this.cg = 0;
        this.ch = 0;
        this.cj = false;
        this.cD = new PDFViewCtrl.u(this);

        try {
            long[] var16 = var11.PDFViewCtrlCreate(var11.new RenderCallback());
            var11.cY = var16[0];
            var11.cZ = var16[1];
            var11.cX = SetJavaScriptEventCallback(var11.cY, new com.pdftron.pdf.a(var13), (Object)null);
            var11.setImageSmoothing(false);
            var11.setCaching(false);
            var11.setOverprint(PDFViewCtrl.OverPrintMode.PDFX);
            var11.setPageViewMode(var11.bT);
            var11.setPageRefViewMode(var11.bT);
            PDFViewCtrl.PagePresentationMode var14 = var11.bV;
            var11.bV = var11.getPagePresentationMode();
            var11.setPagePresentationMode(var14);
            long var8 = Runtime.getRuntime().maxMemory() / 1048576L;
            var11.setRenderedContentCacheSize((long)((double)var8 * 0.25D));
        } catch (Exception var10) {
            return;
        }

        if (d && d) {
            int var12 = a(true);
            int var15 = a(true);
            if (var12 == var15) {
                L = 3;
            }
        }

        com.pdftron.pdf.b.a.a().a(64);
    }

    public boolean isValid() {
        return this.cY != 0L;
    }

    protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
        int var6 = this.cm;
        int var7 = this.cn;
        boolean var8 = this.co;
        this.cm = 0;
        this.cn = 0;
        this.co = false;
        int var9 = var4 - var2;
        int var10 = var5 - var3;
        if (this.aB == var9 && this.aC == var10 && this.mDoc != null && !this.t && !this.bg) {
            if (this.bK) {
                this.df.removeMessages(0);
                this.df.sendEmptyMessage(0);
            }

        } else {
            this.aC = var10;
            this.aB = var9;
            if (this.mDoc != null && this.aB > 0 && this.aC > 0) {
                this.bg = false;

                try {
                    OnSize(this.cY, this.aB, this.aC, this.aB, false);
                } catch (Exception var17) {
                }

                if (this.t) {
                    this.t = false;
                    this.setPagePresentationMode(this.bV);
                    this.setPageViewMode(this.bT);
                    this.scrollTo(0, 0);
                    this.bk = this.j();
                    this.bl = this.a(this.bk);
                    this.bn = this.k();
                    this.bo = this.a(this.bn);
                    this.bH = this.getCurrentPage();
                    this.bG = this.bH;
                    if (this.bS != null) {
                        this.bS.onSetDoc();
                    }
                }

                this.c();
                if (var6 != 0 || var7 != 0) {
                    OnScroll(this.cY, var6, var7, false);
                }

                this.scrollTo(this.p(), this.q());
                this.requestRendering();
            } else if (this.mDoc == null) {
                this.aD = 0;
                this.aE = 0;
                this.aF = 0;
                this.aJ = 0;
            }

            if (var1 && this.mDoc != null && this.bj == PDFViewCtrl.ZoomLimitMode.RELATIVE) {
                double var11 = this.getZoom();
                this.bk = this.j();
                this.bl = this.a(this.bk);
                this.bn = this.k();
                this.bo = this.a(this.bn);
                double var13;
                double var15;
                if (this.cv) {
                    var13 = this.bh * this.bn;
                    var15 = this.bi * this.bo;
                } else {
                    var13 = this.bh * this.bk;
                    var15 = this.bi * this.bl;
                }

                if (var11 < var13) {
                    if (this.cv) {
                        if (this.cy == PDFViewCtrl.PageViewMode.FIT_PAGE || this.cy == PDFViewCtrl.PageViewMode.FIT_WIDTH || this.cy == PDFViewCtrl.PageViewMode.FIT_HEIGHT) {
                            this.setPageViewMode(this.cy, this.aB / 2, this.aC / 2, var8);
                        }
                    } else {
                        PDFViewCtrl.PageViewMode var18 = this.bU;
                        if (this.bU != PDFViewCtrl.PageViewMode.FIT_PAGE && this.bU != PDFViewCtrl.PageViewMode.FIT_WIDTH && this.bU != PDFViewCtrl.PageViewMode.FIT_HEIGHT) {
                            var18 = this.getPageRefViewMode();
                        }

                        this.setPageViewMode(var18, this.aB / 2, this.aC / 2, var8);
                    }
                }

                if (var11 > var15) {
                    this.setZoom(this.aB / 2, this.aC / 2, var15, var8, var8);
                }

                this.requestRendering();
            }

            if (this.aC > 0 && this.aB > 0 && this.mDoc != null) {
                this.df.removeMessages(0);
                this.df.sendEmptyMessage(0);
                if (this.bS != null && !this.bQ) {
                    this.bQ = true;
                    this.bS.onControlReady();
                }

                this.cD.c();
            }

            if (this.bS != null) {
                this.bS.onLayout(var1, var2, var3, var4, var5);
            }

        }
    }

    protected void onSizeChanged(int var1, int var2, int var3, int var4) {
        super.onSizeChanged(var1, var2, var3, var4);
    }

    protected void onMeasure(int var1, int var2) {
        int var3 = MeasureSpec.getSize(var1);
        int var4 = MeasureSpec.getSize(var2);
        this.setMeasuredDimension(var3, var4);
        var3 = this.getChildCount();

        for(var4 = 0; var4 < var3; ++var4) {
            View var5;
            if ((var5 = this.getChildAt(var4)).getVisibility() != 8) {
                this.measureChild(var5, var1, var2);
            }
        }

    }

    private void c() {
        this.cV = false;
        this.cw.clear();
        this.cx.clear();
        this.aD = GetTilingRegionWidth(this.cY);
        this.aE = GetTilingRegionHeight(this.cY);
        this.l.b(this.getCurCanvasId());
        this.cD.c();
        if (!this.cv || !this.f()) {
            this.r();
        }

        if (this.cC != null) {
            Iterator var1 = this.cC.iterator();

            while(var1.hasNext()) {
                ((PDFViewCtrl.OnCanvasSizeChangeListener)var1.next()).onCanvasSizeChanged();
            }
        }

    }

    public boolean onGenericMotionEvent(MotionEvent var1) {
        this.D.lock();
        this.C.x = var1.getX();
        this.C.y = var1.getY();
        this.D.unlock();
        return this.bS != null && this.bS.onGenericMotionEvent(var1) ? true : super.onGenericMotionEvent(var1);
    }

    public PointF getCurrentMousePosition() {
        this.D.lock();
        PointF var1 = new PointF(this.C.x, this.C.y);
        this.D.unlock();
        return var1;
    }

    public boolean onTouchEvent(MotionEvent var1) {
        int[] var2 = new int[]{0, 0};
        this.getLocationOnScreen(var2);
        PointF var4 = new PointF(var1.getRawX() - (float)var2[0], var1.getRawY() - (float)var2[1]);
        var1.setLocation(var4.x, var4.y);
        super.onTouchEvent(var1);
        if (this.mDoc == null) {
            return true;
        } else if (!this.bZ) {
            return true;
        } else {
            if (this.dk.hasMessages(0)) {
                this.dk.removeMessages(0);
                this.dk.dispatchMessage(this.dk.obtainMessage(0));
            }

            if (this.dl.hasMessages(0)) {
                this.dl.removeMessages(0);
                this.dl.dispatchMessage(this.dl.obtainMessage(0));
            }

            if (var1.getToolType(0) == 2 && !this.bY) {
                if (var1.getAction() == 211) {
                    if (this.bS != null) {
                        this.bS.onDown(var1);
                    }
                } else if (var1.getAction() == 213) {
                    if (this.bS != null) {
                        this.bS.onMove(var1, var1, -1.0F, -1.0F);
                    }
                } else if (var1.getAction() == 212 && this.bS != null) {
                    this.bS.onUp(var1, PDFViewCtrl.PriorEventMode.OTHER);
                }
            }

            boolean var5;
            if (!(var5 = this.da.onTouchEvent(var1)) && var1.getAction() == 2 && this.bS != null) {
                this.bS.onMove(var1, var1, -1.0F, -1.0F);
            }

            if (var1.getPointerCount() > 1 && (var1.getAction() & 255) == 5 && this.bS != null) {
                this.bS.onPointerDown(var1);
            }

            this.af = false;
            boolean var3;
            if (VERSION.SDK_INT >= 19) {
                var3 = true;
                if (this.bS != null) {
                    var3 = !this.bS.isCreatingAnnotation();
                }

                this.db.setQuickScaleEnabled(this.bX && var3);
            }

            if (var1.getAction() == 2 && this.bt != null) {
                if (var1.getY() < this.bt.y) {
                    this.bv = true;
                    if (a) {
                        Log.d(c, "scale: ABOVE");
                    }
                } else {
                    this.bv = false;
                    if (a) {
                        Log.d(c, "scale: BELOW");
                    }
                }
            }

            if (VERSION.SDK_INT >= 23) {
                this.db.setStylusScaleEnabled(this.bY);
            }

            var3 = this.db.onTouchEvent(var1);
            if (var1.getAction() == 0) {
                this.di.removeMessages(1);
                this.ae = MotionEvent.obtain(var1);
                this.di.sendEmptyMessageAtTime(1, var1.getDownTime() + 500L);
            } else if (var1.getAction() == 1 || var5 || this.af) {
                this.di.removeMessages(1);
            }

            var5 |= var3;
            if (var1.getAction() == 1) {
                this.cq = PDFViewCtrl.o.d;
                if (this.Q) {
                    this.onUp(var1, PDFViewCtrl.PriorEventMode.SCROLLING);
                    this.Q = false;
                    this.S = false;
                } else if (this.S && this.T) {
                    this.onUp(var1, PDFViewCtrl.PriorEventMode.PINCH);
                    this.S = false;
                } else if (this.U) {
                    this.U = false;
                    this.onUp(var1, PDFViewCtrl.PriorEventMode.DOUBLE_TAP);
                } else if (this.R) {
                    this.onUp(var1, PDFViewCtrl.PriorEventMode.FLING);
                } else {
                    this.onUp(var1, PDFViewCtrl.PriorEventMode.OTHER);
                }
            }

            return var5;
        }
    }

    protected void onDraw(Canvas var1) {
        if (this.mDoc != null) {
            boolean var2 = false;

            try {
                this.j.lock();
                var2 = true;
                boolean var3 = a(this.bV);
                int var4 = this.getCurCanvasId();
                int var5 = this.getScrollX();
                int var6 = this.getScrollY();
                if (this.n()) {
                    if (var3) {
                        if (this.cv) {
                            this.aL = this.getScrollOffsetForCanvasId(var4);
                        }

                        var6 -= this.aL;
                    } else {
                        if (this.cv) {
                            this.aH = this.getScrollOffsetForCanvasId(var4);
                        }

                        var5 -= this.aH;
                    }
                }

                int var7;
                if ((var7 = this.i.b()) == 2) {
                    this.cD.c();
                    Iterator var8 = this.K.iterator();

                    while(var8.hasNext()) {
                        int var9 = (Integer)var8.next();
                        Rect var10;
                        if ((var10 = (Rect)this.J.get(var9, (Object)null)) != null) {
                            com.pdftron.pdf.b.a.a().a(var10);
                            this.J.remove(var9);
                        }
                    }
                }

                if (!this.f() && !this.r && !this.dg.hasMessages(0)) {
                    this.dg.sendEmptyMessage(0);
                }

                int var94 = 0;
                com.pdftron.pdf.f.a var97;
                int var98;
                if ((var97 = this.l.c(var4)) == null && !this.isContinuousPagePresentationMode(this.bV)) {
                    var98 = this.getCurCanvasId();
                    if (this.l.c(var98) == null) {
                        this.l.b(var98);
                    }

                    var97 = this.l.c(var4);
                }

                if (var97 != null) {
                    ++var94;
                    this.aA[0] = var97;
                }

                boolean var99 = false;
                int var11 = var5;
                int var12 = var6;
                int var13;
                int var14;
                if (this.ce.b) {
                    var13 = this.ce.z;
                    if (this.ce.c) {
                        if (var3) {
                            var13 = this.t();
                        } else {
                            var13 = this.s();
                        }
                    }

                    var3 = false | this.a(var1, var13, !this.r);
                    if (!this.l.a()) {
                        this.a(var1, var13);
                    }

                    if (this.ce.b(var13, var13)) {
                        var14 = this.ce.d(var13);
                        var3 |= this.a(var1, var14, !this.r);
                        if (!this.l.a()) {
                            this.a(var1, var14);
                        }
                    }

                    if (this.ce.c(var13, var13)) {
                        var14 = this.ce.e(var13);
                        var3 |= this.a(var1, var14, !this.r);
                        if (!this.l.a()) {
                            this.a(var1, var14);
                        }
                    }

                    if (!var3) {
                        PDFViewCtrl.u.a(this.cD, false);
                    }

                    var99 = true;
                }

                var13 = 0;
                int var90 = 0;
                if (this.n()) {
                    if (a(this.bV)) {
                        if (this.cv) {
                            this.aL = this.getScrollOffsetForCanvasId(var4);
                        }

                        var90 = this.aL;
                    } else {
                        if (this.cv) {
                            this.aH = this.getScrollOffsetForCanvasId(var4);
                        }

                        var13 = this.aH;
                    }
                }

                if (this.r) {
                    this.a(var1, var5, var6, var5, var6, false);
                    this.J.clear();
                }

                if (var7 == 1) {
                    var94 = 0;
                }

                boolean var89;
                for(var14 = 0; var14 < var94; ++var14) {
                    var89 = false;
                    var97 = this.aA[var14];
                    if (!this.l.a() && !var99) {
                        this.cG.set(var5, var6, var5 + this.aB, var6 + this.aC);
                        if (this.r) {
                            var13 = -var5;
                            var90 = -var6;
                        }

                        double[] var15;
                        int var16 = (var15 = this.a((double)this.cG.left, (double)this.cG.top, (double)this.cG.right, (double)this.cG.bottom)).length;

                        for(int var17 = 0; var17 < var16; var17 += 5) {
                            int var18 = (int)var15[var17];
                            this.cH.set((int)(var15[var17 + 1] + 0.5D), (int)(var15[var17 + 2] + 0.5D), (int)(var15[var17 + 3] + 0.5D), (int)(var15[var17 + 4] + 0.5D));
                            this.cI.set(this.cH);
                            if (this.cH.intersect(this.cG)) {
                                this.cJ.set(this.cH.left - this.cI.left, this.cH.top - this.cI.top, this.cH.right - this.cI.left, this.cH.bottom - this.cI.top);
                                int var19 = this.cH.width() * this.cH.height();
                                Collection var20 = this.l.b(var18, 0);
                                int var21 = 0;
                                Iterator var108 = var20.iterator();

                                while(var108.hasNext()) {
                                    com.pdftron.pdf.e var22 = (com.pdftron.pdf.e)var108.next();
                                    this.cK.set(var22.e, var22.f, var22.e + var22.b, var22.f + var22.c);
                                    if (this.cK.intersect(this.cJ)) {
                                        var21 += this.cK.width() * this.cK.height();
                                        this.a(var1, var22, var13, var90);
                                    }
                                }

                                Iterator var109 = this.l.f(var18).iterator();

                                while(var109.hasNext()) {
                                    com.pdftron.pdf.e var23 = (com.pdftron.pdf.e)var109.next();
                                    this.cK.set(var23.e, var23.f, var23.e + var23.b, var23.f + var23.c);
                                    if (!this.M.contains(var23.a)) {
                                        this.a(var1, var23, var13, var90);
                                    }
                                }

                                if (var19 > var21) {
                                    var89 = true;
                                } else if (this.r) {
                                    Rect var110;
                                    (var110 = com.pdftron.pdf.b.a.a().a()).set(this.cI.left - this.cG.left, this.cI.top - this.cG.top, this.cI.right - this.cG.left, this.cI.bottom - this.cG.top);
                                    this.J.put(var18, var110);
                                }
                            }
                        }
                    } else {
                        var89 = true;
                    }

                    if (!this.r && var89 && !var99) {
                        this.a(var1, var11, var12, var5, var12, true);
                    }
                }

                if (var97 == null) {
                    this.a(var1, var11, var12, var5, var12, false);
                }

                if (!this.r) {
                    PDFViewCtrl var100;
                    if (var7 == 1) {
                        this.k.lock();

                        try {
                            Canvas var104 = var1;
                            var100 = this;
                            this.am.setFilterBitmap(true);
                            SparseArray var102 = this.i.c();

                            for(var90 = 0; var90 < var102.size(); ++var90) {
                                var4 = var100.i.c().keyAt(var90);
                                var100.cO.set((RectF)var102.get(var4));
                                Bitmap var92;
                                if ((var92 = var100.a(var4, var100.cN)) != null) {
                                    var104.drawBitmap(var92, (Rect)null, var100.cO, var100.am);
                                } else {
                                    var104.drawRect(var100.cO.left, var100.cO.top, var100.cO.right, var100.cO.bottom, var100.am);
                                }

                                Rect var95;
                                if ((var95 = (Rect)var100.J.get(var4)) != null) {
                                    var100.cP.set(var95);
                                    var100.ah.setRectToRect(var100.cP, var100.cO, ScaleToFit.CENTER);
                                    var104.save();

                                    try {
                                        var104.clipRect(var100.cO.left, var100.cO.top, var100.cO.right, var100.cO.bottom);
                                        var100.k.lock();

                                        try {
                                            if (var100.n != null) {
                                                var104.drawBitmap(var100.n, var100.ah, var100.am);
                                            }
                                        } finally {
                                            var100.k.unlock();
                                        }

                                        if (a) {
                                            Paint var96 = var100.aw;
                                            if (var4 % 4 == 1) {
                                                var96 = var100.ax;
                                            }

                                            if (var4 % 4 == 2) {
                                                var96 = var100.ay;
                                            }

                                            if (var4 % 4 == 3) {
                                                var96 = var100.az;
                                            }

                                            var104.drawRect(var100.cO, var96);
                                        }
                                    } finally {
                                        var104.restore();
                                    }
                                }
                            }

                            var100.am.setFilterBitmap(false);
                            var100.h();
                        } finally {
                            this.k.unlock();
                        }
                    } else {
                        if (this.u) {
                            this.u = false;
                            if (this.bS != null) {
                                this.bS.onDoubleTapZoomAnimationEnd();
                            }
                        }

                        this.k.lock();

                        try {
                            if (this.n != null && this.J.size() > 0) {
                                label3580: {
                                    Canvas var101 = var1;
                                    var100 = this;
                                    var90 = this.getScrollX();
                                    var4 = this.getScrollY();
                                    RectF var91 = new RectF((float)var90, (float)var4, (float)(var90 + this.aB), (float)(var4 + this.aC));
                                    var6 = 0;
                                    var7 = 0;
                                    if (this.n()) {
                                        if (a(this.bV)) {
                                            var7 = this.getScrollOffsetForCanvasId(this.v);
                                        } else {
                                            var6 = this.getScrollOffsetForCanvasId(this.v);
                                        }

                                        if (!RectF.intersects(new RectF((float)var6, (float)var7, (float)(var6 + this.aD), (float)(this.aE + var7)), var91)) {
                                            break label3580;
                                        }
                                    }

                                    var94 = 0;
                                    var12 = 0;
                                    if (var99 && (this.cv || this.ce.B || this.ce.C || this.ce.D)) {
                                        var94 = this.ce.H - (this.cv ? var6 : 0);
                                        var12 = this.ce.I - (this.cv ? var7 : 0);
                                    }

                                    var90 -= var6;
                                    var4 -= var7;
                                    double[] var93;
                                    if ((var93 = this.a((double)var90, (double)var4, (double)(var90 + this.aB), (double)(var4 + this.aC))) != null) {
                                        var89 = false;
                                        var98 = 0;
                                        var13 = var93.length;

                                        while(true) {
                                            if (var98 >= var13) {
                                                if (!var89) {
                                                    var100.J.clear();
                                                }
                                                break;
                                            }

                                            var14 = (int)var93[var98];
                                            Rect var105;
                                            if ((var105 = (Rect)var100.J.get(var14)) != null) {
                                                var100.ak.set((float)var105.left, (float)var105.top, (float)var105.right, (float)var105.bottom);
                                                var100.al.set((float)var93[var98 + 1] + (float)var6 - (float)var94, (float)var93[var98 + 2] + (float)var7 - (float)var12, (float)var93[var98 + 3] + (float)var6 - (float)var94, (float)var93[var98 + 4] + (float)var7 - (float)var12);
                                                var100.ah.setRectToRect(var100.ak, var100.al, ScaleToFit.CENTER);
                                                var101.save();
                                                boolean var48 = false;

                                                try {
                                                    var48 = true;
                                                    if (var100.n() && !var100.al.intersect(new RectF((float)var6, (float)var7, (float)(var6 + var100.aD), (float)(var7 + var100.aE)))) {
                                                        Log.e("DRAW", "these should intersect");
                                                    }

                                                    var101.clipRect(var100.al.left, var100.al.top, var100.al.right, var100.al.bottom);
                                                    var100.k.lock();

                                                    try {
                                                        if (var100.n != null) {
                                                            var101.drawBitmap(var100.n, var100.ah, var100.am);
                                                        }
                                                    } finally {
                                                        var100.k.unlock();
                                                    }

                                                    if (a) {
                                                        Paint var107 = var100.aw;
                                                        if (var14 % 4 == 1) {
                                                            var107 = var100.ax;
                                                        }

                                                        if (var14 % 4 == 2) {
                                                            var107 = var100.ay;
                                                        }

                                                        if (var14 % 4 == 3) {
                                                            var107 = var100.az;
                                                        }

                                                        var101.drawRect(var100.al, var107);
                                                        var48 = false;
                                                    } else {
                                                        var48 = false;
                                                    }
                                                } finally {
                                                    if (var48) {
                                                        var101.restore();
                                                        RectF.intersects(var91, var100.al);
                                                    }
                                                }

                                                var101.restore();
                                                var89 |= RectF.intersects(var91, var100.al);
                                            }

                                            var98 += 5;
                                        }
                                    }
                                }
                            }
                        } finally {
                            this.k.unlock();
                        }
                    }
                }

                if (this.ca && !this.isContinuousPagePresentationMode(this.bV)) {
                    boolean var103 = false;
                    if (this.bS != null) {
                        if (a(this.bV)) {
                            var103 = this.bS.onDrawEdgeEffects(var1, this.getScrollX(), this.aJ);
                        } else {
                            var103 = this.bS.onDrawEdgeEffects(var1, this.aF, this.getScrollY());
                        }
                    }

                    if (var103) {
                        this.h();
                    }
                }

                this.j.unlock();
                var2 = false;
                if (this.bS != null && (!this.f() || this.r)) {
                    boolean var106 = false;
                    if (this.r) {
                        var1.save();
                        var106 = true;
                        var1.translate((float)(-this.getScrollX()), (float)(-this.getScrollY()));
                    }

                    this.bS.onDraw(var1, this.ag);
                    if (var106) {
                        var1.restore();
                    }
                }

                return;
            } catch (Exception var87) {
                if (var87.getMessage() != null) {
                    if (b) {
                        a(4, "OnDraw Error: " + var87.getMessage(), a(true));
                    } else {
                        Log.e("PDFNet", "onDraw Error: " + var87.getMessage());
                    }
                }
            } finally {
                if (var2) {
                    this.j.unlock();
                }

            }

        }
    }

    private void a(Canvas var1, com.pdftron.pdf.e var2, int var3, int var4) {
        int var5 = this.cK.left - var2.e;
        int var6 = this.cK.top - var2.f;
        this.ai.set(var5, var6, var5 + this.cK.width(), var6 + this.cK.height());
        var5 = this.cI.left + this.cK.left + var3;
        var6 = this.cI.top + this.cK.top + var4;
        if (var2.k == 1) {
            var5 += var2.g;
            var6 += var2.h;
        }

        this.aj.set(var5, var6, var5 + this.cK.width(), var6 + this.cK.height());
        boolean var17 = false;
        Paint var7 = this.am;
        if (var2.k == 1) {
            if (var2.l) {
                var7 = this.an;
            }

            if (var2.d == null) {
                double var11 = this.getZoom();
                var5 = this.cI.left + var2.e + var3;
                var6 = this.cI.top + var2.f + var4;
                this.aj.set(var5, var6, var5 + var2.b, var6 + var2.c);
                var1.save();

                try {
                    var1.clipRect(this.aj);
                    var2.n.draw(var1, (float)var5, (float)var6, var11, var11, var11, var11);
                } catch (Exception var15) {
                    var15.printStackTrace();
                } finally {
                    var1.restore();
                }

                var17 = true;
            }
        }

        if (!var17) {
            var1.drawBitmap(var2.d, this.ai, this.aj, var7);
        }

        if (a) {
            if (var2.k == 0) {
                String var19 = var2.a + "-t";
                var1.drawText(var19, (float)this.aj.left, (float)this.aj.bottom, this.av);
                var1.drawRect(this.aj, this.ap);
                var1.drawLine((float)this.aj.left, (float)this.aj.top, (float)this.aj.right, (float)this.aj.bottom, this.aq);
                var1.drawRect(this.aj, this.aq);
                return;
            }

            if (var2.k == 1) {
                Paint var18 = this.ar;
                if (var17) {
                    var18 = this.as;
                }

                var1.drawRect(this.aj, var18);
            }
        }

    }

    private boolean a(Canvas var1, int var2, boolean var3) {
        boolean var4 = false;
        boolean var5 = a(this.bV);

        try {
            int var6 = var5 ? 0 : this.getScrollOffsetForCanvasId(var2);
            int var7 = var5 ? this.getScrollOffsetForCanvasId(var2) : 0;
            double[] var8;
            if ((var8 = (double[])this.cF.get(var2)) != null) {
                int var9 = var8.length / 5;
                int var10 = this.ce.z;
                int var11 = 0;
                int var12 = 0;
                if (this.cv) {
                    if (var5) {
                        if (var2 == var10) {
                            var11 = this.ce.H;
                            var12 = this.ce.v + this.ce.I - var7;
                        } else if (var2 < var10) {
                            var12 = this.ce.v + this.ce.I - var7;
                        }

                        if (var2 < var10) {
                            var11 = Math.max(0, b(var8) - this.aB);
                        }

                        if (var2 != var10 && (var10 = this.cw.get(var2, -2147483648)) != -2147483648) {
                            var11 = var10;
                        }
                    } else {
                        if (var2 == var10) {
                            var11 = this.ce.v + this.ce.H - var6;
                            var12 = this.ce.I;
                        } else if (var2 < var10 && !this.cj || var2 > var10 && this.cj) {
                            var11 = this.ce.v + this.ce.H - var6;
                        }

                        if (var2 < var10) {
                            var12 = Math.max(0, this.a(var8) - this.aC);
                        }

                        if (var2 != var10 && (var10 = this.cx.get(var2, -2147483648)) != -2147483648) {
                            var12 = var10;
                        }
                    }
                } else if ((this.ce.B || this.ce.C || this.ce.D) && var2 == var10) {
                    var11 = this.ce.H;
                    var12 = this.ce.I;
                }

                for(var10 = 0; var10 < var9; ++var10) {
                    int var13 = var10 * 5;
                    int var14 = (int)var8[var13];
                    boolean var15 = false;
                    Bitmap var16;
                    float var17;
                    float var18;
                    float var19;
                    if (var3 && (var16 = this.a(var14, this.cN)) != null) {
                        var17 = (float)var16.getWidth();
                        var18 = (float)var16.getHeight();
                        var19 = (float)var8[var13 + 1];
                        float var20 = (float)var8[var13 + 2];
                        float var21 = (float)var8[var13 + 3];
                        float var22 = (float)var8[var13 + 4];
                        float var23 = var21 - var19;
                        float var24 = var22 - var20;
                        var1.save();

                        try {
                            var1.clipRect(var19 + (float)var6 - (float)(this.cv ? 0 : var11), var20 + (float)var7 - (float)(this.cv ? 0 : var12), var21 + (float)var6 - (float)(this.cv ? 0 : var11), var22 + (float)var7 - (float)(this.cv ? 0 : var12), Op.INTERSECT);
                            float var25 = var17 - this.cN.left - this.cN.right;
                            float var26 = var18 - this.cN.top - this.cN.bottom;
                            var19 -= this.cN.left * (var23 / var25);
                            var21 += this.cN.right * (var23 / var25);
                            var20 -= this.cN.top * (var24 / var26);
                            var22 += this.cN.bottom * (var24 / var26);
                            var23 = var21 - var19;
                            var24 = var22 - var20;
                            var25 = Math.max((float)var11, var19);
                            var26 = Math.max((float)var12, var20);
                            var21 = Math.min((float)(var11 + this.aB), var21);
                            var22 = Math.min((float)(var12 + this.aC), var22);
                            float var27 = var17 * ((var25 - var19) / var23);
                            float var28 = var18 * ((var26 - var20) / var24);
                            var17 *= (var21 - var19) / var23;
                            var18 *= (var22 - var20) / var24;
                            var19 = var25 + (float)var6 - (float)(this.cv ? 0 : var11);
                            var20 = var26 + (float)var7 - (float)(this.cv ? 0 : var12);
                            var21 = var21 + (float)var6 - (float)(this.cv ? 0 : var11);
                            var22 = var22 + (float)var7 - (float)(this.cv ? 0 : var12);
                            this.ak.set(var27, var28, var17, var18);
                            this.al.set(var19, var20, var21, var22);
                            if (this.ah.setRectToRect(this.ak, this.al, ScaleToFit.CENTER)) {
                                this.am.setFilterBitmap(true);
                                var1.drawBitmap(var16, this.ah, this.am);
                                this.am.setFilterBitmap(false);
                                if (a) {
                                    var1.drawRect(this.al, this.au);
                                }

                                var15 = true;
                            }
                        } finally {
                            var1.restore();
                        }
                    }

                    if (!var15) {
                        float var33 = (float)var8[var13 + 1] + (float)var6 - (float)(this.cv ? 0 : var11);
                        var17 = (float)var8[var13 + 2] + (float)var7 - (float)(this.cv ? 0 : var12);
                        var18 = (float)var8[var13 + 3] + (float)var6 - (float)(this.cv ? 0 : var11);
                        var19 = (float)var8[var13 + 4] + (float)var7 - (float)(this.cv ? 0 : var12);
                        var1.drawRect(var33, var17, var18, var19, this.am);
                        if (var14 == this.cD.b) {
                            PDFViewCtrl.u.a(this.cD, true);
                            PDFViewCtrl.u.a(this.cD, var33, var17, var18, var19);
                            var4 = true;
                        }
                    }
                }

                if (!this.cv && var2 == this.ce.z && this.ce.B && !this.ce.c) {
                    if (var5) {
                        this.cM.set(0, var7 + this.aC, this.aB, var7 + (this.aC << 1));
                    } else {
                        this.cM.set(var6 + this.aB, 0, var6 + (this.aB << 1), this.aC);
                    }

                    var1.drawRect(this.cM, this.ao);
                    if (var5) {
                        this.cM.set(0, var7 - this.aC, this.aB, var7);
                    } else {
                        this.cM.set(var6 - this.aB, 0, var6, this.aC);
                    }

                    var1.drawRect(this.cM, this.ao);
                }
            }
        } catch (Exception var32) {
            Log.e("PDFNet", "drawThumbnailForCanvas error for canvas " + var2 + ": " + var32.toString());
            var4 = false;
        }

        return var4;
    }

    private void a(Canvas var1, int var2) {
        try {
            int var3 = this.getScrollX();
            int var4 = this.getScrollY();
            this.cG.set(var3, var4, var3 + this.aB, var4 + this.aC);
            double[] var16;
            if ((var16 = (double[])this.cF.get(var2)) != null && var16.length != 0) {
                var4 = var16.length;
                boolean var5;
                int var6 = (var5 = a(this.bV)) ? 0 : this.getScrollOffsetForCanvasId(var2);
                int var7 = this.getScrollY();
                int var8 = var5 ? this.getScrollOffsetForCanvasId(var2) : 0;
                int var9 = this.getScrollX();
                int var10 = this.ce.z;
                int var11 = 0;
                int var12 = 0;
                int var13;
                if (this.cv) {
                    if (var2 == var10) {
                        if (var5) {
                            var11 = this.ce.H;
                        } else {
                            var12 = this.ce.I;
                        }
                    } else if (var2 < var10) {
                        if (var5) {
                            var11 = Math.max(0, b(var16) - this.aB);
                        } else {
                            var12 = Math.max(0, this.a(var16) - this.aC);
                        }
                    }

                    if (var2 != var10) {
                        var10 = this.cw.get(var2, -2147483648);
                        var13 = this.cx.get(var2, -2147483648);
                        if (var5) {
                            if (var10 != -2147483648) {
                                var11 = var10;
                            }
                        } else if (var13 != -2147483648) {
                            var12 = var13;
                        }
                    }
                } else if ((this.ce.B || this.ce.C || this.ce.D) && var2 == var10) {
                    var11 = this.ce.H;
                    var12 = this.ce.I;
                }

                if (var5) {
                    this.cL.set(var9, var8, var9 + this.aB, var8 + this.aC);
                } else {
                    this.cL.set(var6, var7, var6 + this.aB, var7 + this.aC);
                }

                for(var10 = 0; var10 < var4; var10 += 5) {
                    var13 = (int)var16[var10];
                    this.cH.set((int)(var16[var10 + 1] + 0.5D) + this.cL.left - var11, (int)(var16[var10 + 2] + 0.5D) + this.cL.top - var12, (int)var16[var10 + 3] + this.cL.left - var11, (int)var16[var10 + 4] + this.cL.top - var12);
                    this.cI.set(this.cH);
                    if (this.cH.intersect(this.cG)) {
                        this.cJ.set(this.cH.left - this.cI.left, this.cH.top - this.cI.top, this.cH.right - this.cI.left, this.cH.bottom - this.cI.top);
                        Iterator var17 = this.l.b(var13, 0).iterator();

                        while(var17.hasNext()) {
                            com.pdftron.pdf.e var18 = (com.pdftron.pdf.e)var17.next();
                            this.cK.set(var18.e, var18.f, var18.e + var18.b, var18.f + var18.c);
                            if (this.cK.intersect(this.cJ)) {
                                this.a(var1, var18, 0, 0);
                            }
                        }

                        Iterator var19 = this.l.b(var13, 1).iterator();

                        while(var19.hasNext()) {
                            com.pdftron.pdf.e var14 = (com.pdftron.pdf.e)var19.next();
                            this.cK.set(var14.e, var14.f, var14.e + var14.b, var14.f + var14.c);
                            if (this.cK.intersect(this.cJ) && !this.M.contains(var14.a)) {
                                this.a(var1, var14, 0, 0);
                            }
                        }
                    }
                }

                if (!this.cv && (var11 > 0 || var12 > 0)) {
                    if (var5) {
                        this.cM.set(0, var8 - var12, this.aB, var8);
                    } else {
                        this.cM.set(var6 - var11, 0, var6, this.aC);
                    }

                    var1.drawRect(this.cM, this.ao);
                }

            }
        } catch (Exception var15) {
            Log.e("PDFNet", "drawFullResTileForCanvas error for canvas " + var2 + ": " + var15.toString());
        }
    }

    private void a(int var1) {
        this.aQ.clear();
        var1 = this.getScrollY() - var1;
        double[] var9;
        int var2 = (var9 = this.a(0.0D, (double)(var1 - 5 * this.aC), (double)this.aD, (double)(var1 + 6 * this.aC))).length / 5;

        int var3;
        float var6;
        for(var3 = 0; var3 < var2; ++var3) {
            int var4 = var3 * 5;
            int var5 = (int)var9[var4];
            var6 = (float)var9[var4 + 1];
            float var7 = (float)var9[var4 + 2];
            float var8 = (float)var9[var4 + 3];
            float var10 = (float)var9[var4 + 4];
            this.aQ.put(var5, new RectF(var6, var7, var8, var10));
        }

        for(var3 = 0; var3 < this.aP.size(); ++var3) {
            RectF var11;
            float var12 = (var11 = (RectF)this.aP.valueAt(var3)).left + (float)this.getScrollX();
            var6 = var11.top + (float)this.getScrollY();
            var11.set(var12, var6, var11.width() + var12, var11.height() + var6);
        }

    }

    private void d() {
        float var1 = (float)this.getZoom();
        float var2 = this.aV * var1;
        float var3 = this.aW * var1;
        float[] var5;
        (var5 = new float[2])[0] = 0.0F;
        var5[1] = 0.0F;
        float var6 = (float)this.getScrollX();
        float var7 = (float)this.getScrollY();
        if (this.n()) {
            if (a(this.bV)) {
                if (this.cv) {
                    this.aL = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
                }

                var7 -= (float)this.aL;
            } else {
                if (this.cv) {
                    this.aH = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
                }

                var6 -= (float)this.aH;
            }
        }

        float var9;
        if (var6 <= 0.0F || var7 <= 0.0F) {
            double[] var4;
            float var8 = (float)(var4 = this.convCanvasPtToScreenPt(0.0D, 0.0D))[0];
            var9 = (float)var4[1];
            if (var6 <= 0.0F && var8 > 0.0F) {
                var5[0] = var8;
            }

            if (var7 <= 0.0F && var9 > 0.0F) {
                var5[1] = var9;
            }
        }

        var2 += var5[0];
        var3 += var5[1];
        var9 = var1;
        var1 /= this.aS;
        float var10 = var2 - var1 * this.aT;
        var6 = var3 - var1 * this.aU;
        var2 += ((float)this.aB - this.aT) * var1;
        var1 = var3 + ((float)this.aC - this.aU) * var1;
        var3 = 0.0F;
        var7 = 0.0F;
        if (this.ba > 1 && this.isContinuousPagePresentationMode(this.bV)) {
            double[] var11 = this.convPagePtToCanvasPt((double)this.aX, (double)this.aY, this.aZ);
            var3 = (this.aV - (float)var11[0]) * var9;
            var7 = (this.aW - (float)var11[1]) * var9;
        }

        this.aN.set((float)this.getScrollX(), (float)this.getScrollY(), (float)(this.getScrollX() + this.aB), (float)(this.getScrollY() + this.aC));
        this.aO.set(var10 - var3, var6 - var7, var2 - var3, var1 - var7);
    }

    public boolean onKeyUp(int var1, KeyEvent var2) {
        boolean var3 = false;
        if (this.bS != null) {
            var3 = this.bS.onKeyUp(var1, var2);
        }

        return var3;
    }

    protected boolean onDoubleTap(MotionEvent var1) {
        boolean var2 = this.bX;
        if (VERSION.SDK_INT >= 19) {
            var2 = this.db.isQuickScaleEnabled();
        }

        if (var2) {
            this.bt = new PointF(var1.getX(), var1.getY());
            return false;
        } else {
            var2 = this.handleDoubleTap(var1);
            if (this.bS != null) {
                this.bS.onDoubleTapEnd(var1);
            }

            return var2;
        }
    }

    protected boolean handleDoubleTap(MotionEvent var1) {
        this.U = true;
        boolean var2 = false;
        if (this.bS != null) {
            var2 = this.bS.onDoubleTap(var1);
        }

        if (!var2 && this.mDoc != null) {
            this.cancelRendering();
            double var3 = this.getZoom();
            double var5 = this.j();
            if (Math.abs(var3 - var5) > 0.009999999776482582D) {
                this.a(this.bT, true);
            } else {
                var5 = this.b(var3 * 2.0D);
                this.a(var1.getX(), var1.getY(), var5);
            }
        }

        return true;
    }

    protected boolean onDoubleTapEvent(MotionEvent var1) {
        boolean var2 = false;
        if (this.bS != null) {
            var2 = this.bS.onDoubleTapEvent(var1);
        }

        if (!var2) {
            switch(var1.getActionMasked()) {
                case 0:
                    this.V = true;
                    break;
                case 1:
                    this.V = false;
                    boolean var3 = this.bX;
                    if (VERSION.SDK_INT >= 19) {
                        var3 = this.db.isQuickScaleEnabled();
                    }

                    if (!this.W && var3) {
                        var2 = this.handleDoubleTap(var1);
                        if (this.bS != null) {
                            this.bS.onDoubleTapEnd(var1);
                        }
                    }
            }
        }

        return var2;
    }

    protected boolean onDown(MotionEvent var1) {
        this.cr = PDFViewCtrl.n.d;
        this.cu = 1.0F;
        this.ct = 0.0F;
        this.cs = 0.0F;
        this.ad = false;
        if (!this.f.isFinished()) {
            this.ad = true;
            this.f.forceFinished(true);
        }

        if (!this.ce.b && this.s && this.mDoc != null) {
            int var2 = this.getScrollX();
            int var3 = this.getScrollY();
            if (a(this.bV)) {
                if (this.cv) {
                    this.aL = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
                }

                if (var3 >= this.aL && this.n()) {
                    var3 -= this.aL;
                }
            } else {
                if (this.cv) {
                    this.aH = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
                }

                if (var2 >= this.aH && this.n()) {
                    var2 -= this.aH;
                }
            }

            var2 -= this.p();
            var3 -= this.q();
            if (var2 != 0 || var3 != 0) {
                this.scrollBy(var2, var3);
            }
        }

        this.bs = false;
        this.a(var1.getX(), var1.getY());
        if (this.bS != null) {
            this.bS.onDown(var1);
        }

        if (this.mDoc != null && !this.isContinuousPagePresentationMode(this.bV)) {
            OverScroller var4;
            if (!(var4 = this.g()).isFinished()) {
                var4.abortAnimation();
            }

            this.ce.a(var1);
        }

        return true;
    }

    protected boolean onFling(MotionEvent var1, MotionEvent var2, float var3, float var4) {
        if (this.i.b() == 1) {
            return true;
        } else if (this.ce.b && this.mDoc != null) {
            return this.ce.a(var3, var4);
        } else if (this.bS != null && this.bS.onUp(var2, PDFViewCtrl.PriorEventMode.FLING)) {
            return true;
        } else {
            if (this.mDoc != null) {
                if (this.ca && !this.isContinuousPagePresentationMode(this.bV) && this.o()) {
                    return true;
                }

                int var8 = this.aD - this.aB;
                int var9 = this.aE - this.aC;
                if ((double)Math.abs(var3) < (double)Math.abs(var4) * 1.5D) {
                    var3 = 0.0F;
                }

                var3 = (float)((double)var3 * 0.75D);
                var4 = (float)((double)var4 * 0.75D);
                int var5 = this.getScrollX();
                int var6 = this.getScrollY();
                if (a(this.bV)) {
                    if (this.cv) {
                        this.aL = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
                    }

                    if (var6 >= this.aL && this.n()) {
                        var6 -= this.aL;
                    }
                } else {
                    if (this.cv) {
                        this.aH = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
                    }

                    if (var5 >= this.aH && this.n()) {
                        var5 -= this.aH;
                    }
                }

                this.f.fling(var5, var6, -((int)var3), -((int)var4), 0, var8, 0, var9);
                if (this.s) {
                    var8 = this.f.getFinalX() - this.f.getStartX();
                    var9 = this.f.getFinalY() - this.f.getStartY();

                    try {
                        OnScroll(this.cY, var8, var9, false);
                    } catch (Exception var7) {
                    }

                    this.requestRendering();
                }

                this.invalidate();
            }

            return true;
        }
    }

    protected void onFlingStop() {
        if (!this.ce.b) {
            this.cD.b();
        }

        if (this.bS != null) {
            this.bS.onFlingStop();
        }

    }

    protected void onLongPress(MotionEvent var1) {
        if (!this.ce.b && this.bW) {
            if (!this.W && !this.V) {
                if (this.bS != null) {
                    this.bS.onLongPress(var1);
                }

            }
        }
    }

    private boolean e() {
        return this.cr == PDFViewCtrl.n.c || this.cr == PDFViewCtrl.n.b;
    }

    private boolean f() {
        return this.o && !this.e();
    }

    protected boolean onScaleBegin(ScaleGestureDetector var1) {
        this.bs = false;
        if (!this.ck) {
            return false;
        } else {
            boolean var2 = false;
            int var3;
            if (this.ca && !this.isContinuousPagePresentationMode(this.bV) && this.ce.b && this.mDoc != null) {
                var2 = true;
                if ((!this.cB || this.bS == null || !this.bS.isCreatingAnnotation()) && (float)Math.abs(this.ce.v) < this.ce.n && !this.ce.c) {
                    var3 = this.getPageNumberFromScreenPt((double)var1.getFocusX(), (double)var1.getFocusY());
                    this.b(var3);
                    this.ce.d = true;
                    var2 = false;
                }
            }

            if (var2) {
                return false;
            } else {
                this.cD.d();
                if (this.bS != null && this.bS.onScaleBegin(var1.getFocusX(), var1.getFocusY())) {
                    this.ab = true;
                    return true;
                } else {
                    if (this.mDoc != null) {
                        this.cancelRenderingAsync();
                        this.p = 1;
                        this.q = this.getPageCount();
                        if (!this.isContinuousPagePresentationMode(this.bV)) {
                            var3 = GetCurCanvasId(this.cY);
                            double[] var4;
                            if ((var4 = GetPageRectsOnCanvas(this.cY, var3)).length > 0) {
                                this.p = (int)var4[0];
                                this.q = (int)var4[var4.length - 5];
                            }
                        }

                        this.o = true;
                        this.b(var1.getFocusX(), var1.getFocusY());
                        this.bu = -1.0F;
                        this.aa = false;
                        this.be = -1.0F;
                        this.bf = -1.0F;
                        this.dj.removeMessages(0);
                        this.dj.sendEmptyMessageDelayed(0, 1000L);
                    }

                    return true;
                }
            }
        }
    }

    protected boolean onScale(ScaleGestureDetector var1) {
        if (!this.ck) {
            return true;
        } else if (this.i.b() == 1) {
            return true;
        } else {
            boolean var2 = false;
            if (!this.ce.d && this.ca && !this.isContinuousPagePresentationMode(this.bV) && this.ce.b && this.mDoc != null) {
                var2 = true;
                if ((float)Math.abs(this.ce.v) < this.ce.n && !this.ce.c) {
                    int var6 = this.getPageNumberFromScreenPt((double)var1.getFocusX(), (double)var1.getFocusY());
                    this.b(var6);
                    this.ce.d = true;
                    var2 = false;
                }
            }

            if (var2) {
                return true;
            } else {
                if (!this.ab && this.mDoc != null) {
                    this.bs = true;
                    this.bc = var1.getFocusX();
                    this.bd = var1.getFocusY();
                    if (this.be < 0.0F) {
                        this.be = this.bc;
                    }

                    if (this.bf < 0.0F) {
                        this.bf = this.bd;
                    }

                    float var7 = -this.bc + this.be;
                    float var3 = -this.bd + this.bf;
                    this.be = this.bc;
                    this.bf = this.bd;
                    float var4 = var1.getScaleFactor();
                    if (this.bu < 0.0F) {
                        this.bu = var4;
                    }

                    if (this.bS != null && this.bS.isCreatingAnnotation() && this.cr == PDFViewCtrl.n.d) {
                        this.cu *= var4;
                        if (this.cu <= 2.0F && this.cu >= 0.5F && var4 <= 1.25F && var4 >= 0.8F) {
                            if ((double)var1.getCurrentSpan() < 1.1D * (double)var1.getPreviousSpan() && var1.getCurrentSpan() > 0.9090909F * var1.getPreviousSpan()) {
                                DisplayMetrics var5 = Resources.getSystem().getDisplayMetrics();
                                float var8 = 32.0F * ((float)var5.densityDpi / 160.0F);
                                this.ct += var7;
                                this.cs += var3;
                                if (Math.abs(this.ct) > var8 && Math.abs(this.ct) > Math.abs(this.cs)) {
                                    this.cr = PDFViewCtrl.n.c;
                                } else if (Math.abs(this.cs) > var8) {
                                    this.cr = PDFViewCtrl.n.b;
                                }
                            }
                        } else {
                            this.cr = PDFViewCtrl.n.a;
                        }
                    }

                    if (this.e()) {
                        if (this.cr != PDFViewCtrl.n.c) {
                            var7 = 0.0F;
                        }

                        if (this.cr != PDFViewCtrl.n.b) {
                            var3 = 0.0F;
                        }

                        this.scrollBy((int)var7, (int)var3);
                        return true;
                    }

                    this.scrollBy((int)var7, (int)var3);
                    var7 = var4;
                    if (this.V) {
                        if (this.bv && this.bw) {
                            var7 = this.bu;
                            if (a) {
                                Log.d(c, "scale: HIT MIN AND ABOVE");
                            }
                        }

                        if (!this.bv && this.bx) {
                            var7 = this.bu;
                            if (a) {
                                Log.d(c, "scale: HIT MAX AND BELOW");
                            }
                        }

                        this.bu = var7;
                    }

                    if (this.V) {
                        this.aa = true;
                        var7 = (float)this.b((double)(this.bb * var7));
                    } else {
                        var7 = (float)this.b((double)(this.bb * var4));
                    }

                    if (Math.abs((double)var7 - this.getZoom()) >= 0.01D) {
                        if (this.V) {
                            this.setZoom((double)var7);
                        } else {
                            this.setZoom((int)((double)this.bc + 0.5D), (int)((double)this.bd + 0.5D), (double)var7);
                        }

                        this.dj.removeMessages(0);
                        this.dj.sendEmptyMessageDelayed(0, 1000L);
                        this.invalidate();
                    }
                }

                return this.bS != null && this.bS.onScale(var1.getFocusX(), var1.getFocusY());
            }
        }
    }

    protected void onScaleEnd(ScaleGestureDetector var1) {
        this.o = false;
        if (!this.e()) {
            this.c();
            if (this.ck) {
                boolean var2 = false;
                if (!this.ce.d && this.ca && !this.isContinuousPagePresentationMode(this.bV) && this.ce.b && this.mDoc != null) {
                    var2 = true;
                    if ((float)Math.abs(this.ce.v) < this.ce.n && !this.ce.c) {
                        int var3 = this.getPageNumberFromScreenPt((double)var1.getFocusX(), (double)var1.getFocusY());
                        this.b(var3);
                        this.ce.d = true;
                        var2 = false;
                    }
                }

                if (!var2) {
                    if (!this.ab && this.mDoc != null) {
                        this.bc = var1.getFocusX();
                        this.bd = var1.getFocusY();
                        float var4 = var1.getScaleFactor();
                        if (this.aa) {
                            var4 = (float)this.b((double)(this.bb * this.bu));
                        } else {
                            var4 = (float)this.b((double)(this.bb * var4));
                        }

                        this.dj.removeMessages(0);
                        if (this.aa) {
                            this.setZoom((double)var4);
                        } else {
                            this.setZoom((int)this.bc, (int)this.bd, (double)var4);
                        }
                    }

                    this.ce.d = false;
                    this.bt = null;
                    if (this.bS != null && !this.e()) {
                        this.bS.onScaleEnd(var1.getFocusX(), var1.getFocusY());
                        this.invalidate();
                    }

                    this.invalidate();
                    this.cD.c();
                }
            }
        }
    }

    protected boolean onSingleTapConfirmed(MotionEvent var1) {
        if (!this.ad && this.bS != null) {
            this.bS.onSingleTapConfirmed(var1);
            this.dk.sendEmptyMessageDelayed(0, 200L);
        }

        return false;
    }

    protected boolean onScroll(MotionEvent var1, MotionEvent var2, float var3, float var4) {
        if (this.i.b() == 1) {
            return true;
        } else if (this.ce.d) {
            return true;
        } else {
            float var6;
            float var8;
            float var10;
            if (this.bS != null && this.bS.isCreatingAnnotation() && var2.getPointerCount() == 2 && !this.o) {
                if (this.cr == PDFViewCtrl.n.d) {
                    DisplayMetrics var5 = Resources.getSystem().getDisplayMetrics();
                    var6 = 16.0F * ((float)var5.densityDpi / 160.0F);
                    this.ct += var3;
                    this.cs += var4;
                    float var7 = var2.getX(0) - this.cQ;
                    var10 = var2.getX(1) - this.cR;
                    var8 = var2.getY(0) - this.cS;
                    float var9 = var2.getY(1) - this.cT;
                    this.cQ = var2.getX(0);
                    this.cR = var2.getX(1);
                    this.cS = var2.getY(0);
                    this.cT = var2.getY(1);
                    if (var7 <= 0.0F && var10 >= 0.0F || var7 >= 0.0F && var10 <= 0.0F) {
                        this.ct = 0.0F;
                    }

                    if (var8 <= 0.0F && var9 >= 0.0F || var8 >= 0.0F && var9 <= 0.0F) {
                        this.cs = 0.0F;
                    }

                    if (Math.abs(this.ct) > var6 && Math.abs(this.ct) > Math.abs(this.cs)) {
                        this.cr = PDFViewCtrl.n.c;
                        var3 = this.ct;
                    } else if (Math.abs(this.cs) > var6) {
                        this.cr = PDFViewCtrl.n.b;
                        var4 = this.cs;
                    }
                }

                if (!this.ce.b && this.e()) {
                    if (this.cr != PDFViewCtrl.n.c) {
                        var3 = 0.0F;
                    }

                    if (this.cr != PDFViewCtrl.n.b) {
                        var4 = 0.0F;
                    }

                    this.scrollBy((int)var3, (int)var4);
                }
            }

            if (this.bS != null && this.bS.onMove(var1, var2, var3, var4)) {
                return true;
            } else {
                if (this.mDoc != null) {
                    if (this.ca && !this.isContinuousPagePresentationMode(this.bV)) {
                        if (!this.ce.b) {
                            this.ce.H = !this.ce.B && !this.cv ? 0 : this.getScrollX();
                            this.ce.I = this.getScrollY();
                        }

                        this.ce.b(var2);
                        if (this.o()) {
                            return true;
                        }
                    }

                    if (this.bs) {
                        this.a(var2.getX(), var2.getY());
                        this.bs = false;
                    }

                    if (this.ce.b && this.bS != null && this.bS.isCreatingAnnotation() && var2.getPointerCount() == 2) {
                        return true;
                    }

                    PDFViewCtrl.j.b(this.ce, false);
                    var10 = var2.getX();
                    var6 = var2.getY();
                    double[] var11;
                    var10 = (float)(var11 = this.convPagePtToScreenPt((double)this.bq, (double)this.br, this.bp))[0] - var10;
                    var8 = (float)var11[1] - var6;
                    if (this.cp) {
                        if (this.cq == PDFViewCtrl.o.d) {
                            if (Math.abs(var4) > Math.abs(var3) * 1.4F) {
                                this.cq = PDFViewCtrl.o.a;
                            } else if (Math.abs(var3) > Math.abs(var4) * 1.4F) {
                                this.cq = PDFViewCtrl.o.b;
                            } else {
                                this.cq = PDFViewCtrl.o.c;
                            }
                        }

                        switch(SyntheticClass_1.a[this.cq - 1]) {
                            case 1:
                                var10 = 0.0F;
                                break;
                            case 2:
                                var8 = 0.0F;
                        }
                    }

                    this.scrollBy((int)var10, (int)var8);
                }

                return true;
            }
        }
    }

    protected void onScrollChanged(int var1, int var2, int var3, int var4) {
        if (this.bS != null) {
            this.bS.onScrollChanged(var1, var2, var3, var4);
        }

    }

    protected void onShowPress(MotionEvent var1) {
        if (this.bS != null) {
            this.bS.onShowPress(var1);
        }

    }

    protected boolean onSingleTapUp(MotionEvent var1) {
        if (this.bS != null) {
            this.bS.onSingleTapUp(var1);
        }

        return false;
    }

    protected boolean onUp(MotionEvent var1, PDFViewCtrl.PriorEventMode var2) {
        boolean var3 = false;
        if (this.ce.b && this.mDoc != null) {
            var3 = this.ce.a(0.0F, 0.0F);
            var2 = PDFViewCtrl.PriorEventMode.PAGE_SLIDING;
        }

        if (this.bS != null) {
            var3 = this.bS.onUp(var1, var2);
        }

        if (!var3 && var2 == PDFViewCtrl.PriorEventMode.SCROLLING) {
            this.requestRendering();
        }

        return true;
    }

    protected int computeVerticalScrollRange() {
        if (this.cv) {
            return this.aJ;
        } else {
            if (this.ca && !this.isContinuousPagePresentationMode(this.bV)) {
                if (a(this.bV)) {
                    if (this.aC == this.aE || this.ce.b) {
                        return this.aK;
                    }
                } else if (this.ce.b) {
                    return this.aC;
                }
            }

            return this.aE;
        }
    }

    protected int computeHorizontalScrollRange() {
        if (this.cv) {
            return this.aF;
        } else {
            return !this.ca || this.isContinuousPagePresentationMode(this.bV) || this.aB != this.aD && !this.ce.b ? this.aD : this.aG;
        }
    }

    public void computeScroll() {
        int var3;
        if (!this.g.computeScrollOffset() && !this.h.computeScrollOffset()) {
            if (this.ce.u != -1) {
                this.b(this.ce.s);
            }

            boolean var4 = true;
            int var2;
            if (!this.s) {
                if (this.f.computeScrollOffset()) {
                    var4 = false;
                    var2 = this.f.getCurrX() - this.getScrollX();
                    var3 = this.f.getCurrY() - this.getScrollY();
                    if (var2 != 0 || var3 != 0) {
                        this.scrollBy(var2, var3);
                    }
                }
            } else if (this.f.computeScrollOffset()) {
                var4 = false;
                var2 = 0;
                var3 = 0;
                if (this.n()) {
                    if (a(this.bV)) {
                        if (this.cv) {
                            this.aL = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
                        }

                        var3 = this.aL;
                    } else {
                        if (this.cv) {
                            this.aH = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
                        }

                        var2 = this.aH;
                    }
                }

                super.scrollTo(this.f.getCurrX() + var2, this.f.getCurrY() + var3);
                this.h();
            }

            if (this.R && var4) {
                this.R = false;
                this.onFlingStop();
            }

        } else {
            PDFViewCtrl.j var10000;
            OverScroller var1;
            if ((var1 = this.g()) == this.g) {
                var10000 = this.ce;
                var3 = this.g.getCurrX() + this.aB / 2;
                var10000.t = this.f(var3);
            } else if (var1 == this.h) {
                var10000 = this.ce;
                var3 = this.h.getCurrY() + this.aC / 2;
                var10000.t = this.f(var3);
            }

            if (a(this.bV)) {
                if (this.aE > this.aC) {
                    if (this.ce.x) {
                        this.ce.t = this.ce.a(this.ce.t);
                    } else {
                        this.ce.t = this.ce.b(this.ce.t);
                    }
                }
            } else if (this.aD > this.aB) {
                if (this.ce.w) {
                    this.ce.t = this.ce.a(this.ce.t);
                } else {
                    this.ce.t = this.ce.b(this.ce.t);
                }
            }

            this.ce.t = Math.max(1, Math.min(this.ce.t, this.getPageCount()));
            if (this.ce.c && (!this.ce.G || this.ce.t != this.ce.z) && this.ce.A) {
                SetCurrentPage(this.cY, this.ce.t);
                this.requestRendering();
            }

            super.scrollTo(var1.getCurrX(), var1.getCurrY());
            this.h();
        }
    }

    private OverScroller g() {
        return a(this.bV) ? this.h : this.g;
    }

    private static boolean a(PDFViewCtrl.PagePresentationMode var0) {
        return var0 == PDFViewCtrl.PagePresentationMode.SINGLE_VERT || var0 == PDFViewCtrl.PagePresentationMode.FACING_VERT || var0 == PDFViewCtrl.PagePresentationMode.FACING_COVER_VERT;
    }

    private void b(int var1) {
        this.setCurrentPage(var1);
        this.ce.t = var1;
        PDFViewCtrl.j.h(this.ce, -1);
        PDFViewCtrl.j.s(this.ce);
        if (this.cv) {
            double[] var2;
            int var3;
            if (a(this.bV)) {
                var1 = this.aE - this.aC;
                var2 = this.e(this.ce.s);
                var3 = Math.max(0, b(var2) - this.aB);
                if (this.ce.o > this.ce.s) {
                    this.scrollTo(var3, var1);
                } else if (this.ce.o < this.ce.s) {
                    this.scrollTo(0, 0);
                }

                var1 = this.cw.get(this.ce.s, -2147483648);
                if (this.ce.o != this.ce.s) {
                    if (var1 == -2147483648) {
                        return;
                    }

                    this.scrollTo(var1, this.q());
                } else {
                    if (!this.ce.e) {
                        return;
                    }

                    PDFViewCtrl.j.c(this.ce, false);
                    if (var1 == -2147483648) {
                        var1 = this.h(this.ce.o);
                        if (this.ce.L < var1) {
                            var3 = 0;
                        }

                        this.scrollTo(var3, this.ce.K - this.getScrollOffsetForCanvasId(this.ce.o));
                        return;
                    }

                    this.scrollTo(var1, this.ce.K - this.getScrollOffsetForCanvasId(this.ce.o));
                }
            } else {
                var1 = this.aD - this.aB;
                var2 = this.e(this.ce.s);
                var3 = Math.max(0, this.a(var2) - this.aC);
                if (this.cj) {
                    if (this.ce.o > this.ce.s) {
                        this.scrollTo(0, var3);
                    } else if (this.ce.o < this.ce.s) {
                        this.scrollTo(var1, 0);
                    }
                } else if (this.ce.o > this.ce.s) {
                    this.scrollTo(var1, var3);
                } else if (this.ce.o < this.ce.s) {
                    this.scrollTo(0, 0);
                }

                var1 = this.cx.get(this.ce.s, -2147483648);
                if (this.ce.o != this.ce.s) {
                    if (var1 != -2147483648) {
                        this.scrollTo(this.p(), var1);
                        return;
                    }
                } else if (this.ce.e) {
                    PDFViewCtrl.j.c(this.ce, false);
                    if (var1 != -2147483648) {
                        this.scrollTo(this.ce.J - this.getScrollOffsetForCanvasId(this.ce.o), var1);
                        return;
                    }

                    var1 = this.h(this.ce.o);
                    if (this.ce.L < var1) {
                        var3 = 0;
                    }

                    this.scrollTo(this.ce.J - this.getScrollOffsetForCanvasId(this.ce.o), var3);
                }
            }
        }

    }

    public double getZoom() {
        return GetZoom(this.cY);
    }

    public boolean setZoom(double var1) {
        var1 = this.b(var1);
        boolean var3 = SetZoom(this.cY, var1, false);
        this.c();
        this.scrollTo(this.p(), this.q());
        return var3;
    }

    public boolean setZoom(double var1, boolean var3) {
        return !var3 ? this.setZoom(var1) : this.a((float)this.aB / 2.0F, (float)this.aC / 2.0F, var1);
    }

    public boolean setZoom(int var1, int var2, double var3) {
        var3 = this.b(var3);
        boolean var5 = SetZoom(this.cY, var1, var2, var3, false);
        this.c();
        this.scrollTo(this.p(), this.q());
        return var5;
    }

    public boolean setZoom(int var1, int var2, double var3, boolean var5) {
        return !var5 ? this.setZoom(var1, var2, var3) : this.a((float)var1, (float)var2, var3);
    }

    public boolean setZoom(int var1, int var2, double var3, boolean var5, boolean var6) {
        if (!var6) {
            return this.setZoom(var1, var2, var3, var5);
        } else {
            this.i.a(true);
            if (this.cv) {
                if (a(this.bV)) {
                    this.aL = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
                } else {
                    this.aH = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
                }
            }

            this.d(this.aL);
            this.c((float)var1, (float)var2);
            this.b((float)var1, (float)var2);
            boolean var7;
            if (var7 = this.setZoom(var1, var2, var3, var5)) {
                this.m();
                this.a(this.aL);
                this.d();
                if (!this.isContinuousPagePresentationMode(this.bV)) {
                    this.aO.left += (float)this.aH;
                    this.aO.right += (float)this.aH;
                    this.aO.top += (float)this.aL;
                    this.aO.bottom += (float)this.aL;

                    for(var2 = 0; var2 < this.aQ.size(); ++var2) {
                        RectF var8;
                        (var8 = (RectF)this.aQ.valueAt(var2)).left = var8.left + (float)this.aH;
                        var8.right += (float)this.aH;
                        var8.top += (float)this.aL;
                        var8.bottom += (float)this.aL;
                    }
                }

                if (this.bS != null) {
                    this.bS.onDoubleTapZoomAnimationBegin();
                }

                this.i.a(this.aN, this.aO, this.aP, this.aQ);
                this.u = true;
            }

            return var7;
        }
    }

    public void setZoomLimits(PDFViewCtrl.ZoomLimitMode var1, double var2, double var4) throws PDFNetException {
        this.bj = var1;
        this.bU = PDFViewCtrl.PageViewMode.NOT_DEFINED;
        if (var2 < 0.0D) {
            var2 = 0.0D;
        }

        if (var2 > var4) {
            var4 = var2;
        }

        if (this.bj == PDFViewCtrl.ZoomLimitMode.RELATIVE) {
            if (var2 > 1.0D) {
                var2 = 1.0D;
            }

            if (var4 < 1.0D) {
                var4 = 1.0D;
            }
        }

        this.bh = var2;
        this.bi = var4;
    }

    public void setMinimumRefZoomForMaximumZoomLimit(double var1) {
        this.bm = var1;
        this.bl = this.a(this.bk);
        this.bo = this.a(this.bo);
    }

    public void setRelativeZoomLimits(PDFViewCtrl.PageViewMode var1, double var2, double var4) throws PDFNetException {
        if (var1 != PDFViewCtrl.PageViewMode.FIT_PAGE && var1 != PDFViewCtrl.PageViewMode.FIT_WIDTH && var1 != PDFViewCtrl.PageViewMode.FIT_HEIGHT) {
            Log.e("PDFNet", "ref_view_mode must be one of PageViewMode.FIT_PAGE, PageViewMode.FIT_WIDTH, or PageViewMode.FIT_HEIGHT");
        } else {
            this.bU = var1;
            this.bj = PDFViewCtrl.ZoomLimitMode.RELATIVE;
            if (var2 > 1.0D) {
                var2 = 1.0D;
            }

            if (var4 < 1.0D) {
                var4 = 1.0D;
            }

            this.bh = var2;
            this.bi = var4;
            this.bk = this.j();
            this.bl = this.a(this.bk);
            this.bn = this.k();
            this.bo = this.a(this.bn);
        }
    }

    public double getZoomForViewMode(PDFViewCtrl.PageViewMode var1) throws PDFNetException {
        if (var1 != PDFViewCtrl.PageViewMode.FIT_PAGE && var1 != PDFViewCtrl.PageViewMode.FIT_WIDTH && var1 != PDFViewCtrl.PageViewMode.FIT_HEIGHT) {
            throw new PDFNetException("", 0L, "PDFViewCtrl", "getZoomForViewMode", "viewMode must be one of PageViewMode.FIT_PAGE, PageViewMode.FIT_WIDTH, or PageViewMode.FIT_HEIGHT");
        } else {
            return GetRefZoom(this.cY, var1.getValue());
        }
    }

    public boolean smartZoom(int var1, int var2) {
        this.cancelRendering();
        boolean var3 = false;

        try {
            if (var3 = SmartZoom(this.cY, var1, var2)) {
                this.c();
                this.scrollTo(this.p(), this.q());
            } else {
                this.requestRendering();
            }
        } catch (Exception var4) {
            this.requestRendering();
        }

        return var3;
    }

    public boolean smartZoom(int var1, int var2, boolean var3) {
        if (!var3) {
            return this.smartZoom(var1, var2);
        } else {
            this.i.a(true);
            if (a(this.bV)) {
                if (this.cv) {
                    this.aL = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
                }
            } else if (this.cv) {
                this.aH = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
            }

            this.d(this.aL);
            this.c((float)var1, (float)var2);
            this.b((float)var1, (float)var2);
            this.K.clear();
            boolean var4;
            if (var4 = this.smartZoom(var1, var2)) {
                this.m();
                this.a(this.aL);
                this.d();
                if (!this.isContinuousPagePresentationMode(this.bV)) {
                    this.aO.left += (float)this.aH;
                    this.aO.right += (float)this.aH;
                    this.aO.top += (float)this.aL;
                    this.aO.bottom += (float)this.aL;

                    for(var2 = 0; var2 < this.aQ.size(); ++var2) {
                        RectF var5;
                        (var5 = (RectF)this.aQ.valueAt(var2)).left = var5.left + (float)this.aH;
                        var5.right += (float)this.aH;
                        var5.top += (float)this.aL;
                        var5.bottom += (float)this.aL;
                    }
                }

                if (this.bS != null) {
                    this.bS.onDoubleTapZoomAnimationBegin();
                }

                this.i.a(this.aN, this.aO, this.aP, this.aQ);
                this.u = true;
            }

            return var4;
        }
    }

    public void setLongPressEnabled(boolean var1) {
        this.bW = var1;
    }

    public boolean getLongPressEnabled() {
        return this.bW;
    }

    @TargetApi(19)
    public void setQuickScaleEnabled(boolean var1) {
        if (VERSION.SDK_INT >= 19) {
            this.bX = var1;
        }

    }

    @TargetApi(19)
    public boolean getQuickScaleEnabled() {
        return this.bX;
    }

    @TargetApi(23)
    public boolean isStylusScaleEnabled() {
        return this.bY;
    }

    @TargetApi(23)
    public void setStylusScaleEnabled(boolean var1) {
        this.bY = var1;
    }

    public void scrollBy(int var1, int var2) {
        try {
            OnScroll(this.cY, var1, var2, false);
        } catch (Exception var3) {
        }

        if (this.cv) {
            if (a(this.bV)) {
                this.aL = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
            } else {
                this.aH = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
            }
        }

        if (this.n()) {
            super.scrollTo(this.p() + this.aH, this.q() + this.aL);
        } else {
            super.scrollTo(this.p(), this.q());
        }

        if (this.f.isFinished() && !this.Q && !this.f()) {
            this.requestRendering();
        }

    }

    public void scrollTo(int var1, int var2) {
        try {
            OnScroll(this.cY, var1 - this.p(), var2 - this.q(), false);
        } catch (Exception var3) {
        }

        if (this.cv) {
            if (a(this.bV)) {
                this.aL = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
            } else {
                this.aH = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
            }
        }

        if (this.n()) {
            super.scrollTo(this.p() + this.aH, this.q() + this.aL);
        } else {
            super.scrollTo(this.p(), this.q());
        }

        if (!this.f()) {
            this.requestRendering();
        }

    }

    public boolean canScrollHorizontally(int var1) {
        int var2;
        if ((var2 = this.computeHorizontalScrollOffset()) != 1) {
            return super.canScrollHorizontally(var1);
        } else {
            int var3;
            if ((var3 = this.computeHorizontalScrollRange() - this.computeHorizontalScrollExtent()) == 0) {
                return false;
            } else if (var1 < 0) {
                return var2 > 1;
            } else {
                return var2 < var3 - 1;
            }
        }
    }

    private void h() {
        if (VERSION.SDK_INT >= 16) {
            this.postInvalidateOnAnimation();
        } else {
            this.invalidate();
        }
    }

    public boolean getDirectionalLockEnabled() {
        return this.cp;
    }

    public void setDirectionalLockEnabled(boolean var1) {
        this.cp = var1;
    }

    public void setMaintainZoomEnabled(boolean var1) throws PDFNetException {
        if (a(this.bV)) {
            Log.e(c, "Non-continuous vertical mode is not available in maintain zoom mode, turning off maintain zoom mode...");
            var1 = false;
        }

        this.cv = var1;
        if (this.cv) {
            SetPageRefViewMode(this.cY, PDFViewCtrl.PageViewMode.ZOOM.getValue());
        } else {
            SetPageRefViewMode(this.cY, this.bT.getValue());
        }
    }

    public boolean isMaintainZoomEnabled() {
        return this.cv;
    }

    public void setZoomingInAddingAnnotationEnabled(boolean var1) {
        this.cB = var1;
    }

    public boolean isZoomingInAddingAnnotationEnabled() {
        return this.cB;
    }

    public int getCurrentPage() {
        if (this.mDoc != null) {
            if (this.ca && this.ce.b) {
                return this.ce.t;
            } else if (!this.f.isFinished() && this.s && (this.isContinuousPagePresentationMode(this.bV) || this.isFacingPagePresentationMode(this.bV))) {
                int var1 = this.getScrollX();
                int var2 = this.getScrollY();
                double[] var3;
                if ((var3 = this.a((double)var1, (double)var2, (double)(var1 + this.aB), (double)(var2 + this.aC))) != null && var3.length != 0) {
                    int var4 = var3.length / 5;
                    double var5 = 0.0D;
                    int var7 = 0;

                    for(int var8 = 0; var8 < var4; ++var8) {
                        int var9 = var8 * 5;
                        double var10 = var3[var9 + 1];
                        double var12 = var3[var9 + 2];
                        double var14 = var3[var9 + 3];
                        double var16 = var3[var9 + 4];
                        var10 = var10 < (double)var1 ? (double)var1 : var10;
                        var12 = var12 < (double)var2 ? (double)var2 : var12;
                        var14 = var14 > (double)(var1 + this.aB) ? (double)(var1 + this.aB) : var14;
                        var16 = var16 > (double)(var2 + this.aC) ? (double)(var2 + this.aC) : var16;
                        double var18;
                        if ((var18 = (var18 = (var14 - var10) * (var16 - var12)) < 0.0D ? -var18 : var18) > var5) {
                            var5 = var18;
                            var7 = (int)var3[var9];
                        }
                    }

                    if (var7 > this.getPageCount()) {
                        var7 = this.getPageCount();
                    }

                    return var7;
                } else {
                    return GetCurrentPage(this.cY);
                }
            } else {
                return GetCurrentPage(this.cY);
            }
        } else {
            return 0;
        }
    }

    public void setInteractionEnabled(boolean var1) {
        this.bZ = var1;
    }

    private boolean a(Bitmap var1) {
        boolean var2 = true;
        int var3 = this.getChildCount();
        int[] var4 = null;
        if (var3 > 0) {
            var4 = new int[var3];

            for(int var5 = 0; var5 < var3; ++var5) {
                View var6 = this.getChildAt(var5);
                var4[var5] = var6.getVisibility();
                if (!(var6 instanceof VideoView)) {
                    var6.setVisibility(4);
                }
            }
        }

        Drawable var16 = this.getBackground();
        boolean var10 = false;

        View var14;
        int var19;
        label285: {
            label286: {
                try {
                    label252: {
                        try {
                            var10 = true;
                            if (var16 != null) {
                                this.setBackground((Drawable)null);
                            }

                            Canvas var18;
                            (var18 = new Canvas()).setBitmap(var1);
                            this.r = true;
                            this.draw(var18);
                            this.r = false;
                            var10 = false;
                            break label285;
                        } catch (Exception var11) {
                            var10 = false;
                            break label252;
                        } catch (OutOfMemoryError var12) {
                            if (b) {
                                a(4, "Taking snapshot ran out of memory", a(true));
                            } else {
                                Log.e("PDFNet", "Taking snapshot ran out of memory");
                            }
                        }

                        this.de.a();
                        var2 = false;
                        var10 = false;
                        break label286;
                    }
                } finally {
                    if (var10) {
                        this.r = false;
                        if (var16 != null) {
                            this.setBackground(var16);
                        }

                        if (var3 > 0) {
                            for(int var15 = 0; var15 < var3; ++var15) {
                                View var17;
                                if (!((var17 = this.getChildAt(var15)) instanceof VideoView)) {
                                    var17.setVisibility(var4[var15]);
                                }
                            }
                        }

                    }
                }

                var2 = false;
                this.r = false;
                if (var16 != null) {
                    this.setBackground(var16);
                }

                if (var3 > 0) {
                    for(var19 = 0; var19 < var3; ++var19) {
                        if (!((var14 = this.getChildAt(var19)) instanceof VideoView)) {
                            var14.setVisibility(var4[var19]);
                        }
                    }
                }

                return var2;
            }

            this.r = false;
            if (var16 != null) {
                this.setBackground(var16);
            }

            if (var3 > 0) {
                for(var19 = 0; var19 < var3; ++var19) {
                    if (!((var14 = this.getChildAt(var19)) instanceof VideoView)) {
                        var14.setVisibility(var4[var19]);
                    }
                }
            }

            return var2;
        }

        this.r = false;
        if (var16 != null) {
            this.setBackground(var16);
        }

        if (var3 > 0) {
            for(var19 = 0; var19 < var3; ++var19) {
                if (!((var14 = this.getChildAt(var19)) instanceof VideoView)) {
                    var14.setVisibility(var4[var19]);
                }
            }
        }

        return var2;
    }

    public void setDebug(boolean var1) {
        a = var1;
        b = var1;
        d = a || b;
    }

    public void setBuiltInPageSlidingEnabled(boolean var1) {
        this.cb = var1;
        this.ca = var1;
    }

    public void setBuiltInPageSlidingState(boolean var1) {
        if (this.cb) {
            this.ca = var1;
        }

    }

    public void setBuiltInPageSlidingThreshSpeed(int var1) {
        this.cd = var1;
    }

    public void setBuiltInPageSlidingAnimationDuration(int var1) {
        this.cc = var1;
    }

    public void setBuiltInZoomAnimationDuration(int var1) {
        this.aR = var1;
    }

    public boolean gotoFirstPage() {
        return this.a(-2, 0);
    }

    public boolean gotoLastPage() {
        return this.a(2, 0);
    }

    public boolean canGotoPreviousPage() {
        return this.a(this.getCurrentPage(), false);
    }

    public boolean canGotoNextPage() {
        return this.a(this.getCurrentPage(), true);
    }

    public boolean gotoPreviousPage() {
        return this.a(-1, 0);
    }

    public void gotoPreviousPage(boolean var1) {
        if (var1 && !this.isContinuousPagePresentationMode(this.bV) && this.n()) {
            int var2 = this.getResources().getInteger(17694720);
            this.ce.a(this.ce.d(this.getCurCanvasId()), var2);
        } else {
            this.gotoPreviousPage();
        }
    }

    public boolean gotoNextPage() {
        return this.a(1, 0);
    }

    public void gotoNextPage(boolean var1) {
        if (var1 && !this.isContinuousPagePresentationMode(this.bV) && this.n()) {
            int var2 = this.getResources().getInteger(17694720);
            this.ce.a(this.ce.e(this.getCurCanvasId()), var2);
        } else {
            this.gotoNextPage();
        }
    }

    public boolean setCurrentPage(int var1) {
        return this.a(0, var1);
    }

    public boolean showRect(int var1, com.pdftron.pdf.Rect var2) throws PDFNetException {
        this.setCurrentPage(var1);
        boolean var3 = ShowRect(this.cY, var1, var2.a);
        this.c();
        this.scrollTo(this.p(), this.q());
        return var3;
    }

    public com.pdftron.pdf.Rect jumpToAnnotWithID(String var1) {
        if (this.e == null) {
            return null;
        } else {
            try {
                com.pdftron.pdf.Rect var3 = this.e.jumpToAnnotWithID(var1);
                this.c();
                this.scrollTo(this.p(), this.q());
                return var3;
            } catch (Exception var2) {
                return null;
            }
        }
    }

    public Matrix getPageSlidingCanvasTransform() {
        Matrix var1;
        (var1 = new Matrix()).set(this.ag);
        return var1;
    }

    public boolean isContinuousPagePresentationMode(PDFViewCtrl.PagePresentationMode var1) {
        return var1 == PDFViewCtrl.PagePresentationMode.SINGLE_CONT || var1 == PDFViewCtrl.PagePresentationMode.FACING_CONT || var1 == PDFViewCtrl.PagePresentationMode.FACING_COVER_CONT;
    }

    public boolean isFacingPagePresentationMode(PDFViewCtrl.PagePresentationMode var1) {
        return var1 == PDFViewCtrl.PagePresentationMode.FACING || var1 == PDFViewCtrl.PagePresentationMode.FACING_CONT || var1 == PDFViewCtrl.PagePresentationMode.FACING_COVER || var1 == PDFViewCtrl.PagePresentationMode.FACING_COVER_CONT || var1 == PDFViewCtrl.PagePresentationMode.FACING_VERT || var1 == PDFViewCtrl.PagePresentationMode.FACING_COVER_VERT;
    }

    public PDFDoc openPDFUri(Uri var1, String var2) throws PDFNetException, FileNotFoundException {
        return this.openPDFUri(var1, var2, (String)null, (PDFViewCtrl.HTTPRequestOptions)null);
    }

    public PDFDoc openPDFUri(Uri var1, String var2, String var3, PDFViewCtrl.HTTPRequestOptions var4) throws PDFNetException, FileNotFoundException {
        if (var1 == null) {
            return null;
        } else {
            String var5 = var1.toString();
            PDFDoc var9;
            if ("content".equals(var1.getScheme())) {
                SecondaryFileFilter var10 = null;
                boolean var7 = false;

                try {
                    var7 = true;
                    var10 = new SecondaryFileFilter(this.getContext(), var1);
                    var9 = new PDFDoc(var10);
                    var7 = false;
                } finally {
                    if (var7) {
                        if (var10 != null) {
                            var10.close();
                        }

                    }
                }

                this.a(var9, var2);
                return var9;
            } else if (!URLUtil.isHttpUrl(var5) && !URLUtil.isHttpsUrl(var5)) {
                var5 = var1.getPath();
                var9 = new PDFDoc(var5);
                this.a(var9, var2);
                return var9;
            } else {
                this.openUrlAsync(var5, var3, var2, var4);
                return null;
            }
        }
    }

    private void a(PDFDoc var1, String var2) throws PDFNetException {
        if (var2 == null) {
            var2 = "";
        }

        if (!var1.initStdSecurityHandler(var2)) {
            throw new PDFNetException("", 0L, "PDFViewCtrl", "openPDFUri", "Incorrect password");
        } else if (var1.getPageCount() <= 0) {
            throw new PDFNetException("", 0L, "PDFViewCtrl", "openPDFUri", "Trying to open PDF with no pages.");
        } else {
            this.setDoc(var1);
        }
    }

    public DocumentConversion openNonPDFUri(Uri var1, ConversionOptions var2) throws PDFNetException, FileNotFoundException {
        DocumentConversion var4;
        if ("content".equals(var1.getScheme())) {
            this.mDocumentConversionFilter = new SecondaryFileFilter(this.getContext(), var1);
            var4 = Convert.universalConversion(this.mDocumentConversionFilter, var2);
        } else {
            String var5 = var1.getPath();
            if (!(new File(var5)).exists()) {
                return null;
            }

            var4 = Convert.universalConversion(var5, var2);
        }

        this.openUniversalDocument(var4);
        this.addUniversalDocumentConversionListener(this.cU);
        return var4;
    }

    public PDFDoc getDoc() {
        return this.mDoc;
    }

    public void setDoc(PDFDoc var1) throws PDFNetException {
        this.closeDoc();
        this.ci.lock();

        try {
            if (var1 != null) {
                boolean var2 = false;
                SecurityHandler var3;
                if ((var3 = var1.getSecurityHandler()) != null) {
                    if (var3.getPermission(2)) {
                        this.a(var1, false);
                    } else {
                        var2 = true;
                    }
                } else if (!(var2 = !var1.initSecurityHandler())) {
                    this.a(var1, false);
                }

                if (var2) {
                    if (this.bR == null) {
                        this.bR = new PDFViewCtrl.c(this.getContext());
                    }

                    this.bR.a(var1);
                    this.bR.show();
                }
            }
        } catch (Exception var6) {
            throw new PDFNetException("", 0L, "PDFViewCtrl", "setDoc", var6.getMessage());
        } finally {
            this.ci.unlock();
        }

    }

    public void openUniversalDocument(DocumentConversion var1) throws PDFNetException {
        this.cg = 0;
        this.ch = 0;
        this.closeDoc();

        try {
            OpenUniversalDocumentNoDoc(this.cY, var1.__GetHandle());
            this.cD.a = var1;
            this.bE = true;
        } catch (Exception var4) {
            Exception var5 = var4;
            if (this.bC != null) {
                Iterator var2 = this.bC.iterator();

                while(var2.hasNext()) {
                    ((PDFViewCtrl.DocumentDownloadListener)var2.next()).onDownloadEvent(PDFViewCtrl.DownloadState.FAILED, 0, 0, 0, var5.getMessage());
                }
            }
        }

        this.requestLayout();
    }

    public void openUrlAsync(String var1, String var2, String var3, PDFViewCtrl.HTTPRequestOptions var4) throws PDFNetException {
        this.cg = 0;
        this.ch = 0;
        this.closeDoc();

        try {
            long var8 = var4 == null ? 0L : var4.a.__GetHandle();
            var2 = var2 == null ? "" : var2;
            var3 = var3 == null ? "" : var3;
            OpenURL(this.cY, var1, var2, var3, var8);
            this.bE = true;
        } catch (Exception var7) {
            Exception var5 = var7;
            if (this.bC != null) {
                Iterator var6 = this.bC.iterator();

                while(var6.hasNext()) {
                    ((PDFViewCtrl.DocumentDownloadListener)var6.next()).onDownloadEvent(PDFViewCtrl.DownloadState.FAILED, 0, 0, 0, var5.getMessage());
                }
            }

        }
    }

    public void closeDoc() throws PDFNetException {
        this.ci.lock();

        try {
            if (this.mDoc != null || this.cD.a != null) {
                this.i();
                this.j.lock();

                try {
                    this.l.b();
                    this.m.c();
                } finally {
                    this.j.unlock();
                }

                CloseDoc(this.cY);
                ++this.cE;
                this.cD.a();
                this.mDoc = null;
                this.i();
                if (this.mDoc != null) {
                    this.bg = true;
                    this.requestLayout();
                }
            }
        } finally {
            this.ci.unlock();
        }

    }

    public void docLockRead() throws PDFNetException {
        if (this.cY == 0L) {
            throw new PDFNetException("", 0L, "PDFViewCtrl.java", "docLockRead", "PDFViewCtrl is destroyed");
        } else {
            DocLockRead(this.cY);
        }
    }

    public boolean docTryLockRead(int var1) throws PDFNetException {
        return this.cY == 0L ? false : DocTryLockRead(this.cY, var1);
    }

    public boolean docUnlockRead() {
        if (this.cY == 0L) {
            return false;
        } else {
            try {
                DocUnlockRead(this.cY);
                return true;
            } catch (Exception var2) {
                var2.printStackTrace();
                return false;
            }
        }
    }

    public void docLock(boolean var1) throws PDFNetException {
        if (this.cY == 0L) {
            throw new PDFNetException("", 0L, "PDFViewCtrl.java", "docLock", "PDFViewCtrl is destroyed");
        } else {
            this.B = var1;
            DocLock(this.cY, var1);
        }
    }

    public boolean docTryLock(int var1) throws PDFNetException {
        return this.cY == 0L ? false : DocTryLock(this.cY, var1);
    }

    public boolean docUnlock() {
        if (this.cY == 0L) {
            return false;
        } else {
            try {
                DocUnlock(this.cY);
                if (this.B) {
                    this.B = false;
                    this.requestRendering();
                }

                return true;
            } catch (Exception var2) {
                var2.printStackTrace();
                return false;
            }
        }
    }

    public void setToolManager(PDFViewCtrl.ToolManager var1) {
        this.bS = var1;
    }

    public PDFViewCtrl.ToolManager getToolManager() {
        return this.bS;
    }

    public void addDocumentDownloadListener(PDFViewCtrl.DocumentDownloadListener var1) {
        if (this.bC == null) {
            this.bC = new CopyOnWriteArrayList();
        }

        if (!this.bC.contains(var1)) {
            this.bC.add(var1);
        }

    }

    public void removeDocumentDownloadListener(PDFViewCtrl.DocumentDownloadListener var1) {
        if (this.bC != null) {
            this.bC.remove(var1);
        }

    }

    public void addOnCanvasSizeChangeListener(PDFViewCtrl.OnCanvasSizeChangeListener var1) {
        if (this.cC == null) {
            this.cC = new ArrayList();
        }

        if (!this.cC.contains(var1)) {
            this.cC.add(var1);
        }

    }

    public void removeOnCanvasSizeChangeListener(PDFViewCtrl.OnCanvasSizeChangeListener var1) {
        if (this.cC != null) {
            this.cC.remove(var1);
        }

    }

    public void addUniversalDocumentConversionListener(PDFViewCtrl.UniversalDocumentConversionListener var1) {
        if (this.bD == null) {
            this.bD = new CopyOnWriteArrayList();
        }

        if (!this.bD.contains(var1)) {
            this.bD.add(var1);
        }

    }

    public void removeUniversalDocumentConversionListener(PDFViewCtrl.UniversalDocumentConversionListener var1) {
        if (this.bD != null) {
            this.bD.remove(var1);
        }

    }

    public void addPageChangeListener(PDFViewCtrl.PageChangeListener var1) {
        if (this.bF == null) {
            this.bF = new CopyOnWriteArrayList();
        }

        this.bF.add(var1);
    }

    public void removePageChangeListener(PDFViewCtrl.PageChangeListener var1) {
        if (this.bF != null) {
            this.bF.remove(var1);
        }

    }

    public void setRenderingListener(PDFViewCtrl.RenderingListener var1) {
        this.bO = var1;
    }

    public void addDocumentLoadListener(PDFViewCtrl.DocumentLoadListener var1) {
        if (this.bJ == null) {
            this.bJ = new CopyOnWriteArrayList();
        }

        if (!this.bJ.contains(var1)) {
            this.bJ.add(var1);
        }

    }

    public void removeDocumentLoadListener(PDFViewCtrl.DocumentLoadListener var1) {
        if (this.bJ != null) {
            this.bJ.remove(var1);
        }

    }

    public void setErrorReportListener(PDFViewCtrl.ErrorReportListener var1) {
        this.bL = var1;
    }

    public void addThumbAsyncListener(PDFViewCtrl.ThumbAsyncListener var1) {
        if (this.bM == null) {
            this.bM = new ArrayList();
        }

        if (!this.bM.contains(var1)) {
            this.bM.add(var1);
        }

    }

    public void removeThumbAsyncListener(PDFViewCtrl.ThumbAsyncListener var1) {
        if (this.bM != null) {
            this.bM.remove(var1);
        }

    }

    public void setActionCompletedListener(PDFViewCtrl.ActionCompletedListener var1) {
        this.bN = var1;
    }

    public void setTextSearchListener(PDFViewCtrl.TextSearchListener var1) {
        this.bB = var1;
    }

    public void setUniversalDocumentProgressIndicatorListener(PDFViewCtrl.UniversalDocumentProgressIndicatorListener var1) {
        this.bP = var1;
    }

    public void postCustomEvent(Object var1) {
        if (this.dl.hasMessages(0)) {
            this.dl.removeMessages(0);
        }

        this.cf = var1;
        this.dl.sendEmptyMessage(0);
    }

    public void closeTool() {
        if (this.bS != null) {
            this.bS.onClose();
        }

    }

    public double[] convScreenPtToCanvasPt(double var1, double var3) {
        return ConvScreenPtToCanvasPt(this.cY, var1, var3);
    }

    public double[] convScreenPtToCanvasPt(double var1, double var3, int var5) {
        return ConvScreenPtToCanvasPt(this.cY, var1, var3, var5);
    }

    public double[] convScreenPtToPagePt(double var1, double var3) {
        return ConvScreenPtToPagePt(this.cY, var1, var3, -1);
    }

    public double[] convScreenPtToPagePt(double var1, double var3, int var5) {
        return ConvScreenPtToPagePt(this.cY, var1, var3, var5);
    }

    public double[] convCanvasPtToScreenPt(double var1, double var3) {
        return ConvCanvasPtToScreenPt(this.cY, var1, var3);
    }

    public double[] convCanvasPtToScreenPt(double var1, double var3, int var5) {
        return ConvCanvasPtToScreenPt(this.cY, var1, var3, var5);
    }

    public double[] convCanvasPtToPagePt(double var1, double var3) {
        return ConvCanvasPtToPagePt(this.cY, var1, var3, -1);
    }

    public double[] convCanvasPtToPagePt(double var1, double var3, int var5) {
        return ConvCanvasPtToPagePt(this.cY, var1, var3, var5);
    }

    public double[] convPagePtToCanvasPt(double var1, double var3) {
        return ConvPagePtToCanvasPt(this.cY, var1, var3, -1);
    }

    public double[] convPagePtToCanvasPt(double var1, double var3, int var5) {
        return ConvPagePtToCanvasPt(this.cY, var1, var3, var5);
    }

    public double[] convPagePtToScreenPt(double var1, double var3, int var5) {
        return ConvPagePtToScreenPt(this.cY, var1, var3, var5);
    }

    /** @deprecated */
    @Deprecated
    public double[] convPagePtToHorizonalScrollingPt(double var1, double var3, int var5) {
        return this.convPagePtToHorizontalScrollingPt(var1, var3, var5);
    }

    public double[] convPagePtToHorizontalScrollingPt(double var1, double var3, int var5) {
        int var6 = this.h(var5);
        double[] var7 = this.convPagePtToScreenPt(var1, var3, var5);
        if (!this.isContinuousPagePresentationMode(this.bV)) {
            boolean var2 = false;
            if (a(this.bV)) {
                if (this.aC == this.aE || this.ce.b) {
                    var7[0] += (double)this.getScrollX();
                    var7[1] += (double)this.getScrollOffsetForCanvasId(var6);
                    var2 = true;
                }
            } else if (this.aB == this.aD || this.ce.b) {
                var7[0] += (double)this.getScrollOffsetForCanvasId(var6);
                var7[1] += (double)this.getScrollY();
                var2 = true;
            }

            if (!var2) {
                var7[0] += (double)this.getScrollX();
                var7[1] += (double)this.getScrollY();
            }
        } else {
            var7[0] += (double)this.getScrollX();
            var7[1] += (double)this.getScrollY();
        }

        return var7;
    }

    public double[] convHorizontalScrollingPtToPagePt(double var1, double var3, int var5) {
        int var6 = this.h(var5);
        if (!this.isContinuousPagePresentationMode(this.bV)) {
            boolean var7 = false;
            if (a(this.bV)) {
                if (this.aC == this.aE || this.ce.b) {
                    var1 -= (double)this.getScrollX();
                    var3 -= (double)this.getScrollOffsetForCanvasId(var6);
                    var7 = true;
                }
            } else if (this.aB == this.aD || this.ce.b) {
                var1 -= (double)this.getScrollOffsetForCanvasId(var6);
                var3 -= (double)this.getScrollY();
                var7 = true;
            }

            if (!var7) {
                var1 -= (double)this.getScrollX();
                var3 -= (double)this.getScrollY();
            }
        } else {
            var1 -= (double)this.getScrollX();
            var3 -= (double)this.getScrollY();
        }

        return this.convScreenPtToPagePt(var1, var3, var5);
    }

    public PointF snapToNearestInDoc(double var1, double var3) {
        double[] var5 = SnapToNearestInDoc(this.cY, var1, var3);
        return new PointF((float)var5[0], (float)var5[1]);
    }

    public boolean isSlidingWhileZoomed() {
        return this.ce.b && (this.ce.B || this.ce.C || this.ce.D);
    }

    public int getPageNumberFromScreenPt(double var1, double var3) {
        return GetPageNumberFromScreenPt(this.cY, var1, var3);
    }

    public void prepareWords(int var1) {
        try {
            PrepareWords(this.cY, var1);
        } catch (Exception var2) {
            var2.printStackTrace();
        }
    }

    public boolean wereWordsPrepared(int var1) {
        try {
            return WereWordsPrepared(this.cY, var1);
        } catch (Exception var2) {
            var2.printStackTrace();
            return false;
        }
    }

    public boolean isThereTextInRect(double var1, double var3, double var5, double var7) {
        try {
            return IsThereTextInRect(this.cY, var1, var3, var5, var7);
        } catch (Exception var9) {
            var9.printStackTrace();
            return false;
        }
    }

    public void prepareAnnotsForMouse(int var1) {
        this.prepareAnnotsForMouse(var1, 15.0D, 7.0D);
    }

    public void prepareAnnotsForMouse(int var1, double var2, double var4) {
        try {
            double var6 = (double)this.a((float)var2);
            double var8 = (double)this.a((float)var4);
            PrepareAnnotsForMouse(this.cY, var1, var6, var8);
        } catch (Exception var10) {
            var10.printStackTrace();
        }
    }

    public boolean wereAnnotsForMousePrepared(int var1) {
        try {
            return WereAnnotsForMousePrepared(this.cY, var1);
        } catch (Exception var2) {
            var2.printStackTrace();
            return false;
        }
    }

    public int getAnnotTypeUnder(double var1, double var3) {
        try {
            return GetAnnotTypeUnder(this.cY, var1, var3);
        } catch (Exception var5) {
            var5.printStackTrace();
            return 28;
        }
    }

    public void setTextSelectionMode(PDFViewCtrl.TextSelectionMode var1) {
        SetTextSelectionMode(this.cY, var1.getValue());
    }

    public boolean select(double var1, double var3, double var5, double var7) {
        return Select(this.cY, var1, var3, var5, var7);
    }

    public boolean select(double var1, double var3, int var5, double var6, double var8, int var10) {
        return Select(this.cY, var1, var3, var5, var6, var8, var10);
    }

    public boolean selectByRect(double var1, double var3, double var5, double var7) {
        return SelectByRect(this.cY, var1, var3, var5, var7);
    }

    public boolean selectByStructWithSmartSnapping(double var1, double var3, double var5, double var7) {
        return SelectByStructWithSmartSnapping(this.cY, var1, var3, var5, var7);
    }

    public boolean selectByStructWithSnapping(double var1, double var3, double var5, double var7, boolean var9, boolean var10) {
        return SelectByStructWithSnapping(this.cY, var1, var3, var5, var7, var9, var10);
    }

    public boolean selectWithHighlights(Highlights var1) {
        return SelectByHighlights(this.cY, var1.a);
    }

    public boolean selectAndJumpWithHighlights(Highlights var1) {
        boolean var2;
        if (var2 = this.selectWithHighlights(var1)) {
            if (!this.isContinuousPagePresentationMode(this.bV)) {
                this.r();
            }

            this.scrollTo(this.p(), this.q());
            this.invalidate();
        }

        return var2;
    }

    public boolean selectWithSelection(PDFViewCtrl.Selection var1) {
        return SelectBySelection(this.cY, var1.a);
    }

    public void selectAll() {
        SelectAll(this.cY);
    }

    public boolean hasSelection() {
        return HasSelection(this.cY);
    }

    public void clearSelection() {
        ClearSelection(this.cY);
    }

    public PDFViewCtrl.Selection getSelection(int var1) {
        return new PDFViewCtrl.Selection(this,GetSelection(this.cY, var1),  (byte)0);
    }

    public int getSelectionBeginPage() {
        return GetSelectionBeginPage(this.cY);
    }

    public int getSelectionEndPage() {
        return GetSelectionEndPage(this.cY);
    }

    public boolean hasSelectionOnPage(int var1) {
        return HasSelectionOnPage(this.cY, var1);
    }

    public void findText(String var1, boolean var2, boolean var3, boolean var4, boolean var5) {
        this.findText(var1, var2, var3, var4, var5, -1);
    }

    public void findText(String var1, boolean var2, boolean var3, boolean var4, boolean var5, int var6) {
        var1 = var1;
        StringBuilder var7 = new StringBuilder(var1);
        if (Bidi.requiresBidi(var1.toCharArray(), 0, var1.length())) {
            Bidi var8 = new Bidi(var1, -2);
            var7 = new StringBuilder();

            for(int var9 = 0; var9 < var8.getRunCount(); ++var9) {
                String var10 = var1.substring(var8.getRunStart(var9), var8.getRunLimit(var9));
                if (var8.getRunLevel(var9) % 2 == 1) {
                    var10 = (new StringBuffer(var10)).reverse().toString();
                }

                var7.append(var10);
            }
        }

        var1 = var7.toString();
        this.cancelFindText();
        if (this.mDoc == null) {
            if (this.bB != null) {
                this.bB.onTextSearchEnd(PDFViewCtrl.TextSearchResult.INVALID_INPUT);
            }

        } else {
            synchronized(this) {
                ++this.by;
            }

            if (this.bB != null) {
                this.bB.onTextSearchStart();
            }

            this.ds = new Thread(new Runnable() {
                public final void run() {
                    try {
                        while(PDFViewCtrl.this.by > 0) {
                            Thread.sleep(50L);
                            PDFViewCtrl.this.dr.sendEmptyMessage(0);
                        }

                    } catch (InterruptedException var1) {
                    }
                }
            });
            this.ds.start();

            try {
                FindTextAsync(this.cY, var1, var2, var3, var4, var5, var6);
            } catch (Exception var12) {
                synchronized(this) {
                    this.bA = var5;
                }
            }
        }
    }

    public void cancelFindText() {
        synchronized(this) {
            if (this.by > 0) {
                if (this.ds != null) {
                    this.ds.interrupt();
                }

                this.dr.removeMessages(0);
                CancelFindText(this.cY);
                this.bz = true;
            }

        }
    }

    public void cancelRendering() {
        this.dc.removeMessages(0);
        if (this.cY != 0L) {
            try {
                CancelRendering(this.cY);
                return;
            } catch (Exception var1) {
            }
        }

    }

    public void cancelRenderingAsync() {
        this.dc.removeMessages(0);
        if (this.cY != 0L) {
            try {
                CancelRenderingAsync(this.cY);
                return;
            } catch (Exception var1) {
            }
        }

    }

    public void requestRendering() {
        if (this.cY != 0L && !this.cl) {
            try {
                RequestRender(this.cY);
                return;
            } catch (Exception var3) {
                Log.e("PDFNet", "RR1 " + var3.getMessage());
                this.purgeMemory();

                try {
                    RequestRender(this.cY);
                    return;
                } catch (Exception var2) {
                    if (var2.getMessage() != null) {
                        Log.e("PDFNet", "RR2 " + var2.getMessage());
                    }
                }
            }
        }

    }

    public boolean isFinishedRendering() {
        try {
            return IsFinishedRendering(this.cY, false);
        } catch (Exception var1) {
            return false;
        }
    }

    public boolean isFinishedRendering(boolean var1) {
        try {
            return IsFinishedRendering(this.cY, var1);
        } catch (Exception var2) {
            return false;
        }
    }

    public void waitForRendering(int var1) {
        long var2 = SystemClock.uptimeMillis();

        while(!this.isFinishedRendering(true)) {
            try {
                Thread.sleep(20L);
            } catch (InterruptedException var4) {
            }

            if (SystemClock.uptimeMillis() - var2 >= (long)var1) {
                break;
            }
        }

    }

    public void waitForRendering() {
        this.waitForRendering(1500);
    }

    public boolean isHardwareAccelerated() {
        return super.isHardwareAccelerated();
    }

    public void updatePageLayout() throws PDFNetException {
        UpdatePageLayout(this.cY);
        this.c();
        this.bg = true;
        this.requestLayout();
        this.j.lock();

        try {
            int[] var1;
            int[] var2;
            int var3 = (var2 = var1 = this.m.b()).length;

            for(int var4 = 0; var4 < var3; ++var4) {
                int var5 = var2[var4];
                this.m.a(var5).c = null;
            }

            int var25;
            if ((var25 = this.getPageBox()) != 1) {
                label296: {
                    boolean var27 = false;
                    boolean var17 = false;

                    label280: {
                        try {
                            var17 = true;
                            this.docLockRead();
                            var27 = true;
                            PDFDoc var28 = this.getDoc();
                            int[] var30 = var1;
                            int var6 = var1.length;

                            for(int var7 = 0; var7 < var6; ++var7) {
                                int var22;
                                if ((var22 = var30[var7]) > 0 && var22 <= this.getPageCount()) {
                                    com.pdftron.pdf.c var8 = this.m.a(var22);
                                    Page var23;
                                    if ((var23 = var28.getPage(var22)) != null) {
                                        var8.c = var23.getBox(var25);
                                    }
                                }
                            }

                            var17 = false;
                            break label280;
                        } catch (PDFNetException var18) {
                            var18.printStackTrace();
                            var17 = false;
                        } finally {
                            if (var17) {
                                if (var27) {
                                    this.docUnlockRead();
                                }

                            }
                        }

                        if (var27) {
                            this.docUnlockRead();
                        }
                        break label296;
                    }

                    this.docUnlockRead();
                }
            }
        } catch (Exception var20) {
            var20.printStackTrace();
        } finally {
            this.j.unlock();
        }

        if (this.mDoc != null && this.bj == PDFViewCtrl.ZoomLimitMode.RELATIVE) {
            boolean var24 = !this.isFinishedRendering();
            double var26 = this.getZoom();
            this.cancelRendering();
            this.bk = this.j();
            this.bl = this.a(this.bk);
            this.bn = this.k();
            this.bo = this.a(this.bn);
            if (this.cv) {
                this.setPageViewMode(this.cy);
            }

            double var29;
            double var31;
            if (this.cv) {
                var29 = this.bh * this.bn;
                var31 = this.bi * this.bo;
            } else {
                var29 = this.bh * this.bk;
                var31 = this.bi * this.bl;
            }

            if (var26 < var29) {
                this.setZoom(var29);
            }

            if (var26 > var31) {
                this.setZoom(var31);
            }

            if (var24) {
                this.requestRendering();
            }
        }

    }

    public void update() throws PDFNetException {
        this.update(false);
    }

    public void update(boolean var1) throws PDFNetException {
        Update(this.cY, var1);
    }

    public void update(com.pdftron.pdf.Rect var1) throws PDFNetException {
        Update(this.cY, var1.a);
    }

    public void update(Annot var1, int var2) throws PDFNetException {
        Update(this.cY, var1.a, var2);
    }

    public void update(Field var1) throws PDFNetException {
        UpdateField(this.cY, var1.a);
    }

    public void resume() {
        this.cl = false;
        if (this.bK) {
            this.requestLayout();
        }

        if (this.cY != 0L && this.mDoc != null) {
            this.requestRendering();
        }

    }

    public void pause() {
        this.i();
        this.cl = true;
    }

    private void i() {
        try {
            if (this.bE) {
                if (this.bC != null) {
                    Iterator var1 = this.bC.iterator();

                    while(var1.hasNext()) {
                        ((PDFViewCtrl.DocumentDownloadListener)var1.next()).onDownloadEvent(PDFViewCtrl.DownloadState.FAILED, 0, 0, 0, "cancelled");
                    }
                }

                CloseDoc(this.cY);
                this.bE = false;
            }

            this.cancelAllThumbRequests();
            this.cancelRendering();
            this.cancelFindText();
            this.closeTool();
            this.l();
        } catch (Exception var3) {
        }
    }

    public void destroy() {
        if (this.cY != 0L) {
            ImageCache var1;
            (var1 = com.pdftron.pdf.ImageCache.a.a()).a(false);
            var1.a();
            com.pdftron.pdf.b.a.a().b();
            var1.a(true);
            if (this.bS != null) {
                this.bS.onDestroy();
            }

            this.ci.lock();

            try {
                if (this.bR != null && this.bR.isShowing()) {
                    this.bR.dismiss();
                }
            } catch (Exception var17) {
            }

            try {
                this.pause();
                this.j.lock();

                try {
                    this.l.b();
                    this.m.c();
                } finally {
                    this.j.unlock();
                }

                CloseDoc(this.cY);
                this.mDoc = null;
                this.pause();
                if (this.cY != 0L) {
                    try {
                        Destroy(this.cY);
                        this.cY = 0L;
                    } catch (Exception var15) {
                    }
                }

                this.l();
                if (this.cZ != 0L) {
                    try {
                        DestroyRenderData(this.cZ, 0L, 0L, 0L, 0L, 0L, this.cX);
                        this.cZ = 0L;
                    } catch (Exception var14) {
                    }
                }

                if (this.mDocumentConversionFilter != null) {
                    this.mDocumentConversionFilter.close();
                    this.mDocumentConversionFilter = null;
                }

                return;
            } catch (Exception var18) {
                if (var18.getMessage() != null) {
                    Log.e("PDFNet", var18.getMessage());
                }
            } finally {
                this.ci.unlock();
            }

        }
    }

    public void onConfigurationChanged(Configuration var1) {
        if (this.bS != null) {
            this.bS.onConfigurationChanged(var1);
        }

    }

    public void purgeMemory() {
        this.A = true;
        ImageCache var1;
        (var1 = com.pdftron.pdf.ImageCache.a.a()).a(false);
        var1.a();
        com.pdftron.pdf.b.a.a().b();

        try {
            this.cancelRendering();
            PurgeMemory(this.cY);
            this.k.lock();
            this.n = null;
            this.k.unlock();
        } finally {
            var1.a(true);
            this.A = false;
        }

    }

    public void requestLayout() {
        super.requestLayout();
    }

    public long[] getAllCanvasPixelSizes() {
        return GetAllCanvasPixelSizes(this.cY);
    }

    public double getCanvasWidth() {
        return GetCanvasWidth(this.cY);
    }

    public double getCanvasHeight() {
        return GetCanvasHeight(this.cY);
    }

    public int getViewCanvasWidth() {
        return this.aD;
    }

    public int getViewCanvasHeight() {
        return this.aE;
    }

    public PDFViewCtrl.PagePresentationMode getPagePresentationMode() {
        return this.bV == null || this.bV != PDFViewCtrl.PagePresentationMode.SINGLE_VERT && this.bV != PDFViewCtrl.PagePresentationMode.FACING_VERT && this.bV != PDFViewCtrl.PagePresentationMode.FACING_COVER_VERT ? PDFViewCtrl.PagePresentationMode.valueOf(GetPagePresentationMode(this.cY)) : this.bV;
    }

    public void setPagePresentationMode(PDFViewCtrl.PagePresentationMode var1) {
        if (this.cv && a(var1)) {
            Log.e(c, "Non-continuous vertical mode is not available in maintain zoom mode, turning off maintain zoom mode...");

            try {
                this.setMaintainZoomEnabled(false);
            } catch (Exception var8) {
            }
        }

        try {
            if (var1 != this.bV) {
                if (!this.f.isFinished()) {
                    this.f.forceFinished(true);
                    if (this.s && this.mDoc != null) {
                        int var2 = this.getScrollX();
                        int var3 = this.getScrollY();
                        if (a(var1)) {
                            if (this.cv) {
                                this.aL = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
                            }

                            if (var3 >= this.aL && this.n()) {
                                var3 -= this.aL;
                            }
                        } else {
                            if (this.cv) {
                                this.aH = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
                            }

                            if (var2 >= this.aH && this.n()) {
                                var2 -= this.aH;
                            }
                        }

                        int var4 = var2 - this.p();
                        int var5 = var3 - this.q();
                        if (var4 != 0 || var5 != 0) {
                            this.scrollBy(var4, var5);
                        }
                    }
                }

                this.aF = 0;
                this.aG = 0;
                this.aH = 0;
                this.aI = 0;
                this.aJ = 0;
                this.aK = 0;
                this.aL = 0;
                this.aM = 0;
                this.bV = var1;
                SetPagePresentationMode(this.cY, (var1 = this.bV) == PDFViewCtrl.PagePresentationMode.SINGLE_VERT ? PDFViewCtrl.PagePresentationMode.SINGLE.getValue() : (var1 == PDFViewCtrl.PagePresentationMode.FACING_VERT ? PDFViewCtrl.PagePresentationMode.FACING.getValue() : (var1 == PDFViewCtrl.PagePresentationMode.FACING_COVER_VERT ? PDFViewCtrl.PagePresentationMode.FACING_COVER.getValue() : var1.getValue())));
                this.requestLayout();
                if (this.mDoc != null && this.bj == PDFViewCtrl.ZoomLimitMode.RELATIVE) {
                    double var10 = this.getZoom();
                    this.bk = this.j();
                    this.bl = this.a(this.bk);
                    this.bn = this.k();
                    this.bo = this.a(this.bn);
                    double var6;
                    double var11;
                    if (this.cv) {
                        var11 = this.bh * this.bn;
                        var6 = this.bi * this.bo;
                    } else {
                        var11 = this.bh * this.bk;
                        var6 = this.bi * this.bl;
                    }

                    if (var10 < var11) {
                        this.setZoom(var11);
                        return;
                    }

                    if (var10 > var6) {
                        this.setZoom(var6);
                        return;
                    }
                }

                this.c();
                this.scrollTo(this.p(), this.q());
            }

        } catch (Exception var9) {
        }
    }

    public PDFViewCtrl.PageViewMode getPageViewMode() {
        return PDFViewCtrl.PageViewMode.valueOf(GetPageViewMode(this.cY));
    }

    private void a(PDFViewCtrl.PageViewMode var1, boolean var2) {
        if (this.getPageViewMode() != var1 || var2) {
            if (!this.f.isFinished()) {
                this.f.forceFinished(true);
                if (this.s && this.mDoc != null) {
                    int var3 = this.getScrollX();
                    int var4 = this.getScrollY();
                    if (a(this.bV)) {
                        if (this.cv) {
                            this.aL = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
                        }

                        if (var4 >= this.aL && this.n()) {
                            var4 -= this.aL;
                        }
                    } else {
                        if (this.cv) {
                            this.aH = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
                        }

                        if (var3 >= this.aH && this.n()) {
                            var3 -= this.aH;
                        }
                    }

                    int var5 = var3 - this.p();
                    int var6 = var4 - this.q();
                    if (var5 != 0 || var6 != 0) {
                        this.scrollBy(var5, var6);
                    }
                }
            }

            SetPageViewMode(this.cY, var1.getValue());
            this.bT = var1;
            this.requestLayout();
            if (this.mDoc != null && this.bj == PDFViewCtrl.ZoomLimitMode.RELATIVE) {
                double var9 = this.getZoom();
                this.bk = this.j();
                this.bl = this.a(this.bk);
                double var7;
                double var10;
                if (this.cv) {
                    var10 = this.bh * this.bn;
                    var7 = this.bi * this.bo;
                } else {
                    var10 = this.bh * this.bk;
                    var7 = this.bi * this.bl;
                }

                if (var9 < var10) {
                    this.setZoom(var10);
                    return;
                }

                if (var9 > var7) {
                    this.setZoom(var7);
                    return;
                }
            }

            this.c();
            this.scrollTo(this.p(), this.q());
        }

    }

    public void setPageViewMode(PDFViewCtrl.PageViewMode var1) {
        try {
            this.a(var1, false);
        } catch (Exception var2) {
        }
    }

    public void setPageViewMode(PDFViewCtrl.PageViewMode var1, int var2, int var3, boolean var4) {
        if (!var4) {
            this.setPageViewMode(var1);
        } else {
            this.i.a(true);
            if (this.cv) {
                if (a(this.bV)) {
                    this.aL = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
                } else {
                    this.aH = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
                }
            }

            this.d(this.aL);
            this.c((float)var2, (float)var3);
            this.b((float)var2, (float)var3);
            this.K.clear();
            this.setPageViewMode(var1);
            this.m();
            this.a(this.aL);
            this.d();
            boolean var5 = this.isContinuousPagePresentationMode(this.bV);
            boolean var7 = a(this.bV);
            if (!var5) {
                if (var7) {
                    this.aO.top += (float)this.getScrollY();
                    this.aO.bottom += (float)this.getScrollY();
                } else {
                    this.aO.left += (float)this.getScrollX();
                    this.aO.right += (float)this.getScrollX();
                }

                for(int var6 = 0; var6 < this.aQ.size(); ++var6) {
                    RectF var8 = (RectF)this.aQ.valueAt(var6);
                    if (var7) {
                        var8.top += (float)this.getScrollY();
                        var8.bottom += (float)this.getScrollY();
                    } else {
                        var8.left += (float)this.getScrollX();
                        var8.right += (float)this.getScrollX();
                    }
                }
            }

            if (this.bS != null) {
                this.bS.onDoubleTapZoomAnimationBegin();
            }

            this.i.a(this.aN, this.aO, this.aP, this.aQ);
            this.u = true;
        }
    }

    public PDFViewCtrl.PageViewMode getPageRefViewMode() {
        return PDFViewCtrl.PageViewMode.valueOf(GetPageRefViewMode(this.cY));
    }

    public void setPageRefViewMode(PDFViewCtrl.PageViewMode var1) throws PDFNetException {
        if (var1 != PDFViewCtrl.PageViewMode.ZOOM && this.cv) {
            throw new PDFNetException("", 0L, "PDFViewCtrl", "setPageRefViewMode", "Page Ref View Mode cannot be other than PAGE_VIEW_ZOOM when maintain zoom level feature is enabled.");
        } else {
            SetPageRefViewMode(this.cY, var1.getValue());
        }
    }

    public void setPreferredViewMode(PDFViewCtrl.PageViewMode var1) {
        this.cy = var1;
    }

    public PDFViewCtrl.PageViewMode getPreferredViewMode() {
        return this.cy;
    }

    public void setVerticalAlign(int var1) throws PDFNetException {
        SetVerticalAlign(this.cY, var1);
    }

    public void setHorizontalAlign(int var1) throws PDFNetException {
        SetHorizontalAlign(this.cY, var1);
    }

    private double j() {
        double var1;
        if (this.bU != PDFViewCtrl.PageViewMode.FIT_PAGE && this.bU != PDFViewCtrl.PageViewMode.FIT_WIDTH && this.bU != PDFViewCtrl.PageViewMode.FIT_HEIGHT) {
            var1 = GetRefZoom(this.cY, this.getPageRefViewMode().getValue());
        } else {
            var1 = GetRefZoom(this.cY, this.bU.getValue());
        }

        return var1;
    }

    private double a(double var1) {
        return var1 < this.bm ? this.bm : var1;
    }

    private double k() {
        double var1 = 1.0D;
        if (this.cy == PDFViewCtrl.PageViewMode.FIT_PAGE || this.cy == PDFViewCtrl.PageViewMode.FIT_WIDTH || this.cy == PDFViewCtrl.PageViewMode.FIT_HEIGHT) {
            var1 = GetRefZoom(this.cY, this.cy.getValue());
        }

        return var1;
    }

    private double c(int var1) {
        double var2 = 1.0D;
        if (this.cy == PDFViewCtrl.PageViewMode.FIT_PAGE || this.cy == PDFViewCtrl.PageViewMode.FIT_WIDTH || this.cy == PDFViewCtrl.PageViewMode.FIT_HEIGHT) {
            var2 = GetRefZoomForPage(this.cY, this.cy.getValue(), var1);
        }

        return var2;
    }

    public void setPageSpacingDP(int var1, int var2, int var3, int var4) {
        this.setPageSpacing((int)(this.a((float)var1) + 0.5F), (int)(this.a((float)var2) + 0.5F), (int)(this.a((float)var3) + 0.5F), (int)(this.a((float)var4) + 0.5F));
    }

    public void setPageSpacing(int var1, int var2, int var3, int var4) {
        this.G = var1;
        this.H = var2;
        this.I = var3;
        SetPageSpacing(this.cY, var1, var2, var3, var4);
    }

    public void setDisplayCutout(int var1, int var2) {
        this.E = var1;
        this.F = var2;
        this.setPageSpacing(this.G, this.H, this.I, Math.max(var1, var2));
    }

    public int getDisplayCutoutTop() {
        return this.E;
    }

    public int getDisplayCutoutBottom() {
        return this.F;
    }

    public void setProgressiveRendering(boolean var1) {
        this.N = var1;
    }

    public void setProgressiveRendering(boolean var1, int var2, int var3) {
        this.N = var1;
        if (this.N) {
            this.O = var2 > 0 ? var2 : this.O;
            this.P = var3 > 0 ? var3 : this.P;
        }

    }

    public void setupThumbnails(boolean var1, boolean var2, boolean var3, int var4, long var5, double var7) throws PDFNetException {
        this.cancelRendering();
        this.m.c();
        SetupThumbnails(this.cY, var1, var2, var3, var4, var5, var7);
        this.dd.sendEmptyMessage(0);
    }

    public void clearThumbCache() throws PDFNetException {
        ClearThumbCache(this.cY);
    }

    public void setOCGContext(com.pdftron.pdf.ocg.Context var1) throws PDFNetException {
        if (var1 == null) {
            SetOCGContext(this.cY, 0L);
        } else {
            SetOCGContext(this.cY, var1.__GetHandle());
        }
    }

    /** @deprecated */
    @Deprecated
    public void updateOCGContext() throws PDFNetException {
        UpdateOCGContext(this.cY);
    }

    public com.pdftron.pdf.ocg.Context getOCGContext() throws PDFNetException {
        return com.pdftron.pdf.ocg.Context.__Create(GetOCGContext(this.cY), this);
    }

    public void cancelAllThumbRequests() throws PDFNetException {
        if (this.cY != 0L) {
            CancelAllThumbRequests(this.cY);
        }

    }

    public void getThumbAsync(int var1) throws PDFNetException {
        GetThumbAsync(this.cY, (long)var1, this.cZ);
    }

    public boolean getProgressiveRendering() {
        return this.N;
    }

    public void setCaching(boolean var1) throws PDFNetException {
        SetCaching(this.cY, var1);
    }

    public void setUrlExtraction(boolean var1) throws PDFNetException {
        SetUrlExtraction(this.cY, var1);
    }

    public PDFViewCtrl.LinkInfo getLinkAt(int var1, int var2) throws PDFNetException {
        return GetLinkAt(this.cY, var1, var2);
    }

    public void setRenderedContentCacheSize(long var1) throws PDFNetException {
        SetMemInfo(this.cY, 0.0D, (double)(var1 << 10 << 10));
    }

    public void setImageSmoothing(boolean var1) throws PDFNetException {
        SetImageSmoothing(this.cY, var1);
        this.update();
    }

    public boolean getRightToLeftLanguage() {
        return this.cj;
    }

    public void setRightToLeftLanguage(boolean var1) throws PDFNetException {
        if (var1 != this.cj) {
            this.cj = var1;
            SetRightToLeftLanguage(this.cY, var1);
            this.updatePageLayout();
            this.update(true);
        }

    }

    public int getPageBox() throws PDFNetException {
        return GetPageBox(this.cY);
    }

    public void setPageBox(int var1) throws PDFNetException {
        SetPageBox(this.cY, var1);
    }

    public void setDefaultPageColor(int var1, int var2, int var3) throws PDFNetException {
        this.setDefaultPageColor(Color.argb(255, var1, var2, var3));
    }

    public void setDefaultPageColor(int var1) throws PDFNetException {
        int var2 = Color.red(var1);
        int var3 = Color.green(var1);
        int var4 = Color.blue(var1);
        var1 = Color.argb(Color.alpha(var1), var2, var3, var4);
        if (this.x != var1) {
            SetDefaultPageColor(this.cY, (byte)var2, (byte)var3, (byte)var4);
            this.y = this.x = var1;
            this.am.setColor(this.x);
            this.update();
        }

    }

    public void setClientBackgroundColor(int var1, int var2, int var3, boolean var4) throws PDFNetException {
        var1 = Color.argb(var4 ? 0 : 255, var1, var2, var3);
        if (this.z != var1) {
            var2 = Color.red(var1);
            var3 = Color.green(var1);
            int var6 = Color.blue(var1);
            int var5 = Color.alpha(var1);
            SetBackgroundColor(this.cY, (byte)var2, (byte)var3, (byte)var6, (byte)var5);
            this.z = var1;
            this.setBackgroundColor(this.z);
            this.ao.setColor(this.z);
            this.invalidate();
            this.update();
        }

    }

    public void hideAnnotation(Annot var1) {
        if (this.cA) {
            this.M.add(var1.__GetHandle());
            this.invalidate();
        } else {
            HideAnnotation(this.cY, var1.a);
        }
    }

    public void showAnnotation(Annot var1) {
        if (this.cA) {
            this.M.remove(var1.__GetHandle());
            this.invalidate();
        } else {
            ShowAnnotation(this.cY, var1.a);
        }
    }

    public int getClientBackgroundColor() {
        return this.z;
    }

    public void setDrawAnnotations(boolean var1) throws PDFNetException {
        SetDrawAnnotations(this.cY, var1);
        this.update(true);
    }

    public void setAntiAliasing(boolean var1) throws PDFNetException {
        SetAntiAliasing(this.cY, var1);
        this.update(true);
    }

    public void setHighlightFields(boolean var1) throws PDFNetException {
        SetHighlightFields(this.cY, var1);
        this.update(true);
    }

    public void setFieldHighlightColor(ColorPt var1) throws PDFNetException {
        SetFieldHighlightColor(this.cY, var1.__GetHandle());
        this.update(true);
    }

    public void setSignatureHighlightColor(ColorPt var1) throws PDFNetException {
        SetSignatureHighlightColor(this.cY, var1.__GetHandle());
        this.update(true);
    }

    public void setRequiredFieldBorderColor(ColorPt var1) throws PDFNetException {
        SetRequiredFieldBorderColor(this.cY, var1.__GetHandle());
        this.update(true);
    }

    public void setPathHinting(boolean var1) throws PDFNetException {
        SetPathHinting(this.cY, var1);
        this.update(true);
    }

    public void setPageBorderVisibility(boolean var1) throws PDFNetException {
        SetPageBorderVisibility(this.cY, var1);
    }

    public void setPageTransparencyGrid(boolean var1) throws PDFNetException {
        SetPageTransparencyGrid(this.cY, var1);
    }

    public void setThinLineAdjustment(boolean var1, boolean var2) throws PDFNetException {
        SetThinLineAdjustment(this.cY, var1, var2);
        this.update(true);
    }

    public void setOverprint(PDFViewCtrl.OverPrintMode var1) throws PDFNetException {
        SetOverprint(this.cY, var1.getValue());
        this.update(true);
    }

    public void setGamma(double var1) throws PDFNetException {
        SetGamma(this.cY, var1);
        this.update(true);
    }

    public void setNextOnLayoutAdjustments(int var1, int var2, boolean var3) {
        this.cm = var1;
        this.cn = var2;
        this.co = var3;
    }

    public void getContentSize(int[] var1) {
        double[] var2 = this.a(0.0D, 0.0D, (double)this.aD, (double)this.aE);
        int var3 = 0;
        int var4 = 0;
        int var5 = 0;
        int var6 = 0;
        if (var2.length > 0) {
            var3 = (int)Math.min(var2[1], var2[3]);
            var4 = (int)Math.max(var2[1], var2[3]);
            var5 = (int)Math.min(var2[2], var2[4]);
            var6 = (int)Math.max(var2[2], var2[4]);
            int var7 = 5;

            for(int var8 = var2.length; var7 < var8; var7 += 5) {
                var3 = (int)Math.min(var2[var7 + 1], Math.min(var2[var7 + 3], (double)var3));
                var4 = (int)Math.max(var2[var7 + 1], Math.max(var2[var7 + 3], (double)var4));
                var5 = (int)Math.min(var2[var7 + 2], Math.min(var2[var7 + 4], (double)var5));
                var6 = (int)Math.max(var2[var7 + 2], Math.max(var2[var7 + 4], (double)var6));
            }
        }

        int[] var9 = GetPageSpacing(this.cY);
        var1[0] = var4 - var3 + var9[2] + var9[2];
        var1[1] = var6 - var5 + var9[3] + var9[3];
    }

    public void setDevicePixelDensity(double var1, double var3) {
        SetDevicePixelDensity(this.cY, var1, var3);
    }

    public com.pdftron.pdf.Rect getScreenRectForAnnot(Annot var1, int var2) throws PDFNetException {
        return new com.pdftron.pdf.Rect(GetScreenRectForAnnot(this.cY, var1.a, var2));
    }

    public com.pdftron.pdf.Rect getPageRectForAnnot(Annot var1, int var2) throws PDFNetException {
        com.pdftron.pdf.Rect var22 = this.getScreenRectForAnnot(var1, var2);
        double[] var3;
        double var5 = (var3 = this.convScreenPtToPagePt(var22.getX1(), var22.getY1(), var2))[0];
        double var7 = var3[1];
        double[] var23;
        double var10 = (var23 = this.convScreenPtToPagePt(var22.getX2(), var22.getY2(), var2))[0];
        double var12 = var23[1];
        double var14 = var5 < var10 ? var5 : var10;
        double var16 = var5 > var10 ? var5 : var10;
        double var18 = var7 < var12 ? var7 : var12;
        double var20 = var7 > var12 ? var7 : var12;
        return new com.pdftron.pdf.Rect(var14, var18, var16, var20);
    }

    public Annot getAnnotationAt(int var1, int var2) {
        return this.getAnnotationAt(var1, var2, 15.0D, 7.0D);
    }

    public Annot getAnnotationAt(int var1, int var2, double var3, double var5) {
        if (this.mDoc == null) {
            return null;
        } else {
            double var7 = (double)this.a((float)var3);
            double var9 = (double)this.a((float)var5);

            try {
                return new Annot(GetAnnotationAt(this.cY, var1, var2, var7, var9), this);
            } catch (Exception var11) {
                return null;
            }
        }
    }

    public ArrayList<Annot> getAnnotationListAt(int var1, int var2, int var3, int var4) {
        ArrayList var5 = new ArrayList();

        try {
            long[] var13;
            var2 = (var13 = GetAnnotationListAt(this.cY, var1, var2, var3, var4)).length;

            for(var3 = 0; var3 < var2; ++var3) {
                long var10 = var13[var3];
                var5.add(new Annot(var10, this));
            }
        } catch (Exception var12) {
        }

        return var5;
    }

    public ArrayList<Annot> getAnnotationsOnPage(int var1) {
        ArrayList var2 = new ArrayList();

        try {
            long[] var10;
            int var3 = (var10 = GetAnnotationsOnPage(this.cY, var1)).length;

            for(int var4 = 0; var4 < var3; ++var4) {
                long var7 = var10[var4];
                var2.add(new Annot(var7, this));
            }
        } catch (Exception var9) {
        }

        return var2;
    }

    public CurvePainter getAnnotationPainter(int var1, long var2) {
        this.j.lock();

        try {
            com.pdftron.pdf.e var6;
            if ((var6 = this.l.a(var1, var2, 1)) != null && var6.n != null) {
                CurvePainter var7 = CurvePainter.create(var6.n);
                return var7;
            }
        } finally {
            this.j.unlock();
        }

        return null;
    }

    public void setColorPostProcessMode(int var1) throws PDFNetException {
        if (var1 != this.getColorPostProcessMode()) {
            SetColorPostProcessMode(this.cY, var1);
            if (var1 == 3) {
                int var2 = Color.alpha(var1 = this.y);
                int var3 = Color.red(var1);
                int var4 = Color.green(var1);
                var1 = Color.blue(var1);
                this.x = Color.argb(var2, 255 - var3, 255 - var4, 255 - var1);
                this.am.setColor(this.x);
            } else if (var1 == 0) {
                this.x = this.y;
                this.am.setColor(this.x);
            }

            this.update();
        }

    }

    public void setColorPostProcessColors(int var1, int var2) throws PDFNetException {
        SetColorPostProcessColors(this.cY, var1, var2);
        this.x = var1;
        this.am.setColor(this.x);
        this.update();
    }

    public void setColorPostProcessMapFile(Filter var1) throws PDFNetException {
        SetColorPostProcessMapFile(this.cY, var1.__GetHandle());
        this.x = -5422;
        this.am.setColor(this.x);
        this.update();
    }

    public ColorPt getPostProcessedColor(ColorPt var1) {
        return new ColorPt(GetPostProcessedColor(this.cY, var1.__GetHandle()));
    }

    public boolean isUndoRedoEnabled() {
        return this.cz;
    }

    public void enableUndoRedo() throws PDFNetException {
        EnableUndoRedo(this.cY);
        this.cz = true;
    }

    public String undo() throws PDFNetException {
        return this.e != null ? this.e.undo() : Undo(this.cY);
    }

    public String redo() throws PDFNetException {
        return this.e != null ? this.e.redo() : Redo(this.cY);
    }

    public String takeUndoSnapshot(String var1) throws PDFNetException {
        if (this.e != null) {
            return this.e.takeSnapshot(var1);
        } else {
            TakeSnapshot(this.cY, var1);
            return null;
        }
    }

    public String getNextUndoInfo() throws PDFNetException {
        return this.e != null ? this.e.getNextUndoInfo() : GetNextUndoInfo(this.cY);
    }

    public String getNextRedoInfo() throws PDFNetException {
        return this.e != null ? this.e.getNextRedoInfo() : GetNextRedoInfo(this.cY);
    }

    public void revertAllChanges() throws PDFNetException {
        RevertAllChanges(this.cY);
    }

    public ExternalAnnotManager enableExternalAnnotManager(String var1) throws PDFNetException {
        this.e = new ExternalAnnotManager(GetExternalAnnotManager(this.cY, var1));
        return this.e;
    }

    public ExternalAnnotManager getExternalAnnotManager() throws PDFNetException, NullPointerException {
        if (this.e == null) {
            throw new NullPointerException("ExternalAnnotManager is not set");
        } else {
            return this.e;
        }
    }

    public void enableAnnotationLayer() {
        EnableFloatingAnnotTiles(this.cY, this.cZ, 33);
        this.cA = true;
    }

    public boolean isAnnotationLayerEnabled() {
        return this.cA;
    }

    public int getColorPostProcessMode() throws PDFNetException {
        return GetColorPostProcessMode(this.cY);
    }

    private boolean a(Obj var1, HashSet<Long> var2) {
        boolean var3 = false;

        try {
            if (var1 != null) {
                Long var4 = var1.__GetHandle();
                if (!var2.contains(var4)) {
                    var2.add(var4);
                    Action var6;
                    int var7;
                    var3 = (var7 = (var6 = new Action(var1)).getType()) == 0 || var7 == 9 || this.a(var6.GetNext(), var2);
                }
            }
        } catch (PDFNetException var5) {
            var5.printStackTrace();
        }

        return var3;
    }

    public void executeAction(Action var1) throws PDFNetException {
        ActionParameter var2 = new ActionParameter(var1);
        this.executeAction(var2);
    }

    public void executeAction(ActionParameter var1) throws PDFNetException {
        int var2 = this.getCurrentPage();
        Obj var3 = var1.getAction().getSDFObj();
        HashSet var4 = new HashSet();
        double var6 = this.getZoom();
        ExecuteAction(this.cY, var1.a);
        if (this.a(var3, var4)) {
            if (!this.cv) {
                var6 = this.getZoom();
            }

            int[] var23 = GetVisiblePages(this.cY);
            int var26 = -1;
            if (var23.length > 0) {
                var26 = var23[0];
            }

            double var10 = 0.0D;
            double var12 = 0.0D;
            double[] var24;
            if (var26 > 0) {
                var10 = (var24 = this.convScreenPtToPagePt(0.0D, 0.0D, var26))[0];
                var12 = var24[1];
            }

            int var25;
            if ((var25 = this.getCurrentPage()) != var2) {
                this.setCurrentPage(var25);
            }

            double var21;
            if (this.bj == PDFViewCtrl.ZoomLimitMode.RELATIVE) {
                if (this.cv) {
                    var21 = this.bh * this.bn;
                } else {
                    var21 = this.bh * this.bk;
                }
            } else {
                var21 = this.bh;
            }

            double var15 = var21;
            if (this.bj == PDFViewCtrl.ZoomLimitMode.RELATIVE) {
                if (this.cv) {
                    var21 = this.bi * this.bo;
                } else {
                    var21 = this.bi * this.bl;
                }
            } else {
                var21 = this.bi;
            }

            if (var6 < var15) {
                var6 = var15;
            } else if (var6 > var21) {
                var6 = var21;
            }

            this.setZoom(var6);
            if (var26 > 0) {
                var10 = (var24 = this.convPagePtToScreenPt(var10, var12, var26))[0];
                var12 = var24[1];
                this.scrollTo((int)var10 + this.p(), (int)var12 + this.q());
            }

            this.bk = this.j();
            this.bl = this.a(this.bk);
        }

    }

    public static void setViewerCache(SDFDoc var0, int var1, boolean var2) throws PDFNetException {
        SetViewerCache(var0.__GetHandle(), var1, var2);
    }

    public void rotateClockwise() {
        RotateClockwise(this.cY);
    }

    public void rotateCounterClockwise() {
        RotateCounterClockwise(this.cY);
    }

    public int getPageRotation() {
        return GetRotation(this.cY);
    }

    public int getHScrollPos() {
        return this.isMaintainZoomEnabled() ? this.p() : this.getScrollX();
    }

    @TargetApi(14)
    public void setHScrollPos(int var1) {
        this.setScrollX(var1);
    }

    public int getVScrollPos() {
        return this.isMaintainZoomEnabled() ? this.q() : this.getScrollY();
    }

    @TargetApi(14)
    public void setVScrollPos(int var1) {
        this.setScrollY(var1);
    }

    public Matrix2D getDeviceTransform() {
        return Matrix2D.__Create(GetDeviceTransform(this.cY, -1));
    }

    public Matrix2D getDeviceTransform(int var1) {
        return Matrix2D.__Create(GetDeviceTransform(this.cY, var1));
    }

    public void setZoomEnabled(boolean var1) {
        this.ck = var1;
    }

    public boolean getZoomEnabled() {
        return this.ck;
    }

    protected void finalize() throws Throwable {
        super.finalize();
        this.destroy();
    }

    public void purgeMemoryDueToOOM() {
        ImageCache var1;
        (var1 = com.pdftron.pdf.ImageCache.a.a()).a(false);
        var1.a();
        var1.a(true);
        com.pdftron.pdf.b.a.a().b();
        this.de.a();
    }

    private void l() {
        this.dd.removeCallbacksAndMessages((Object)null);
        this.dg.removeCallbacksAndMessages((Object)null);
        this.dj.removeCallbacksAndMessages((Object)null);
        this.di.removeCallbacksAndMessages((Object)null);
        this.dh.removeCallbacksAndMessages((Object)null);
        this.dk.removeCallbacksAndMessages((Object)null);
        this.dl.removeCallbacksAndMessages((Object)null);
        this.dr.removeCallbacksAndMessages((Object)null);
        this.dm.removeCallbacksAndMessages((Object)null);
        this.dn.removeCallbacksAndMessages((Object)null);
        this.df.removeCallbacksAndMessages((Object)null);
        this.doo.removeCallbacksAndMessages((Object)null);
        this.dp.removeCallbacksAndMessages((Object)null);
        this.dq.removeCallbacksAndMessages((Object)null);
    }

    private void a(float var1, float var2) {
        this.bp = this.getPageNumberFromScreenPt((double)var1, (double)var2);
        if (this.bp <= 0) {
            this.bp = this.getCurrentPage();
        }

        double[] var3 = this.convScreenPtToPagePt((double)var1, (double)var2, this.bp);
        this.bq = (float)var3[0];
        this.br = (float)var3[1];
    }

    private boolean a(long var1, int var3, int var4) {
        boolean var5 = true;

        try {
            var5 = DownloaderUpdatePage(this.cY, var1, var3, var4);
        } catch (Exception var6) {
        }

        return var5;
    }

    private boolean e(long var1) {
        try {
            return DownloaderIsCorrectDoc(this.cY, var1);
        } catch (Exception var3) {
            return false;
        }
    }

    private boolean a(int var1, int var2) {
        try {
            if (this.mDoc != null) {
                int var3 = this.getCurrentPage();
                boolean var4 = false;
                boolean var5 = !this.isContinuousPagePresentationMode(this.bV);
                switch(var1) {
                    case -2:
                        var4 = GotoFirstPage(this.cY);
                        break;
                    case -1:
                        var4 = GotoPreviousPage(this.cY);
                        break;
                    case 0:
                        var4 = SetCurrentPage(this.cY, var2);
                        break;
                    case 1:
                        var4 = GotoNextPage(this.cY);
                        break;
                    case 2:
                        var4 = GotoLastPage(this.cY);
                }

                if (var4) {
                    if (!this.f.isFinished()) {
                        this.f.forceFinished(true);
                    }

                    if (var5) {
                        this.aD = GetTilingRegionWidth(this.cY);
                        this.aE = GetTilingRegionHeight(this.cY);
                        if (!this.r) {
                            if (var3 != var2 && !this.cv && (!this.ce.G || this.getPagePresentationMode() != PDFViewCtrl.PagePresentationMode.FACING_COVER && this.getPagePresentationMode() != PDFViewCtrl.PagePresentationMode.FACING && this.getPagePresentationMode() != PDFViewCtrl.PagePresentationMode.FACING_COVER_VERT && this.getPagePresentationMode() != PDFViewCtrl.PagePresentationMode.FACING_VERT || Math.abs(var3 - var2) != 1)) {
                                this.bk = this.j();
                                this.bl = this.a(this.bk);
                            }

                            this.bI = PDFViewCtrl.PageChangeState.END;
                            this.dg.removeMessages(0);
                            this.dg.sendEmptyMessage(0);
                            PDFViewCtrl.j.d(this.ce, false);
                            var1 = this.getCurrentPage();
                            this.r();
                            if (this.bS != null) {
                                this.bS.onPageTurning(this.ce.y, var1);
                            }
                        }
                    }

                    var1 = this.h(var3);
                    var3 = this.h(var2);
                    if (this.cv && var1 != var3) {
                        this.cw.put(var1, this.p());
                        this.cx.put(var1, this.q());
                    }

                    if (!this.r) {
                        int var6 = this.cw.get(var3, -2147483648);
                        int var7 = this.cx.get(var3, -2147483648);
                        if (var5 && this.cv && var3 != var1 && var6 != -2147483648 && var7 != -2147483648) {
                            this.scrollTo(var6, var7);
                        } else {
                            this.scrollTo(this.p(), this.q());
                        }

                        this.invalidate();
                    }

                    if (this.cv) {
                        this.bn = Math.min(this.bn, this.c(var2));
                        this.bo = Math.max(this.bo, this.c(var2));
                        this.bo = this.a(this.bo);
                    } else {
                        this.bk = this.j();
                        this.bl = this.a(this.bk);
                    }
                }

                return var4;
            }
        } catch (Exception var8) {
            var8.printStackTrace();
        }

        return false;
    }

    private void b(float var1, float var2) {
        this.bb = (float)this.getZoom();
        this.bc = var1;
        this.bd = var2;
        if (this.w || this.n == null || this.J.size() <= 0) {
            PDFViewCtrl var9 = this;

            try {
                var9.k.lock();

                try {
                    if (var9.n == null || var9.n.getWidth() != var9.aB || var9.n.getHeight() != var9.aC) {
                        ImageCache var10;
                        (var10 = com.pdftron.pdf.ImageCache.a.a()).a(var9.n);
                        Bitmap var11;
                        if ((var11 = var10.a(var9.aB, var9.aC)) == null) {
                            var11 = Bitmap.createBitmap(var9.aB, var9.aC, Config.ARGB_8888);
                        }

                        var9.n = var11;
                    }

                    if (var9.a(var9.n)) {
                        var9.w = false;
                        var9.v = var9.getCurCanvasId();
                        if (var9.J.size() == 0) {
                            Log.e("DRAW", "Error, we got a snapshot, but rects are empty");
                        }
                    } else {
                        Log.e("DRAW", "Error, couldn't take a snapshot");
                        var9.de.a();
                    }
                } finally {
                    var9.k.unlock();
                }
            } catch (Exception var7) {
                return;
            } catch (OutOfMemoryError var8) {
                if (b) {
                    a(4, "No snapshot due to out of memory", a(true));
                } else {
                    Log.e("PDFNet", "No snapshot due to out of memory");
                }

                this.de.a();
            }

        }
    }

    private void m() {
        float var1 = (float)this.convPagePtToScreenPt((double)this.aX, (double)this.aY, this.aZ)[1] - this.aU;
        this.scrollBy(0, (int)var1);
    }

    private void d(int var1) {
        this.aP.clear();
        var1 = this.getScrollY() - var1;
        double[] var11;
        int var2 = (var11 = this.a(0.0D, (double)(var1 - 5 * this.aC), (double)this.aD, (double)(var1 + 6 * this.aC))).length / 5;
        int var3 = 0;
        int var4 = 0;
        if (a(this.bV)) {
            if (this.cv) {
                this.aL = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
            }

            if (this.n()) {
                var4 = this.aL;
            }
        } else {
            if (this.cv) {
                this.aH = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
            }

            if (this.n()) {
                var3 = this.aH;
            }
        }

        for(int var5 = 0; var5 < var2; ++var5) {
            int var6 = var5 * 5;
            int var7 = (int)var11[var6];
            float var8 = (float)var11[var6 + 1];
            float var9 = (float)var11[var6 + 2];
            float var10 = (float)var11[var6 + 3];
            float var12 = (float)var11[var6 + 4];
            this.aP.put(var7, new RectF(var8 - (float)this.getScrollX() + (float)var3, var9 - (float)this.getScrollY() + (float)var4, var10 - (float)this.getScrollX() + (float)var3, var12 - (float)this.getScrollY() + (float)var4));
        }

    }

    private void c(float var1, float var2) {
        this.cD.d();
        this.aS = (float)this.getZoom();
        this.aT = var1;
        this.aU = var2;
        this.ba = this.getCurrentPage();
        double[] var3 = this.convScreenPtToCanvasPt((double)this.aT, (double)this.aU);
        this.aV = (float)var3[0];
        this.aW = (float)var3[1];
        this.aZ = this.getPageNumberFromScreenPt((double)this.aT, (double)this.aU);
        var3 = this.convScreenPtToPagePt((double)this.aT, (double)this.aU, this.aZ);
        this.aX = (float)var3[0];
        this.aY = (float)var3[1];
    }

    private boolean a(float var1, float var2, double var3) {
        this.b(var1, var2);
        this.K.clear();
        var3 = this.b(var3);
        boolean var5 = SetZoom(this.cY, (int)this.bc, (int)this.bd, var3, false);
        this.c();
        this.scrollTo(this.p(), this.q());
        return var5;
    }

    private double b(double var1) {
        if (this.bj == PDFViewCtrl.ZoomLimitMode.NONE) {
            return var1;
        } else {
            double var3;
            double var5;
            if (this.bj == PDFViewCtrl.ZoomLimitMode.RELATIVE) {
                if (this.cv) {
                    var3 = this.bh * this.bn;
                    var5 = this.bi * this.bo;
                } else {
                    var3 = this.bh * this.bk;
                    var5 = this.bi * this.bl;
                }
            } else {
                var3 = this.bh;
                var5 = this.bi;
            }

            if (var3 >= 0.0D && var1 < var3) {
                var1 = var3;
                if (a) {
                    Log.d(c, "scale: hit MIN_ZOOM");
                }

                this.bw = true;
            } else {
                this.bw = false;
            }

            if (var5 >= 0.0D && var1 > var5) {
                var1 = var5;
                if (a) {
                    Log.d(c, "scale: hit MAX_ZOOM");
                }

                this.bx = true;
            } else {
                this.bx = false;
            }

            return var1;
        }
    }

    private boolean n() {
        if (this.isContinuousPagePresentationMode(this.bV)) {
            return false;
        } else if (a(this.bV)) {
            return this.ce.b || this.cv || this.aC == this.aE;
        } else {
            return this.ce.b || this.cv || this.aB == this.aD;
        }
    }

    private boolean o() {
        if (this.isContinuousPagePresentationMode(this.bV)) {
            return false;
        } else {
            return this.aB == this.aD && this.aC == this.aE || this.ce.b;
        }
    }

    private boolean a(int var1, boolean var2) {
        if (this.isContinuousPagePresentationMode(this.bV)) {
            return false;
        } else if (var2) {
            return var1 < this.getPageCount();
        } else {
            return var1 > 1;
        }
    }

    private float a(float var1) {
        float var2 = this.getContext().getResources().getDisplayMetrics().density;
        return var1 * var2;
    }

    public int getPageCount() {
        return GetPagesCount(this.cY);
    }

    public int[] getVisiblePages() {
        return GetVisiblePages(this.cY);
    }

    public int[] getVisiblePagesInTransition() {
        if (!this.ce.b) {
            return GetVisiblePages(this.cY);
        } else {
            int var1 = this.aB != this.aD && !this.cv ? this.aI : this.getScrollX();
            int var2 = this.aC != this.aE && !this.cv ? this.aM : this.getScrollY();
            var1 = a(this.bV) ? this.f(var2) : this.f(var1);
            var2 = this.ce.d(var1);
            int var3 = this.ce.e(var1);
            ArrayList var4 = new ArrayList();
            Iterator var7 = this.g(var2).iterator();

            Integer var5;
            while(var7.hasNext()) {
                var5 = (Integer)var7.next();
                if (!var4.contains(var5)) {
                    var4.add(var5);
                }
            }

            var7 = this.g(var1).iterator();

            while(var7.hasNext()) {
                var5 = (Integer)var7.next();
                if (!var4.contains(var5)) {
                    var4.add(var5);
                }
            }

            var7 = this.g(var3).iterator();

            while(var7.hasNext()) {
                var5 = (Integer)var7.next();
                if (!var4.contains(var5)) {
                    var4.add(var5);
                }
            }

            int[] var9 = new int[var4.size()];
            int var10 = 0;

            for(Iterator var6 = var4.iterator(); var6.hasNext(); ++var10) {
                Integer var8 = (Integer)var6.next();
                var9[var10] = var8;
            }

            return var9;
        }
    }

    private void a(Canvas var1, int var2, int var3, int var4, int var5, boolean var6) {
        double[] var28;
        if ((var28 = this.a((double)var4, (double)var5, (double)(var4 + this.aB), (double)(var5 + this.aC))) != null) {
            var5 = var28.length / 5;
            int var7 = 0;
            int var8 = 0;
            if (this.n()) {
                if (a(this.bV)) {
                    if (this.cv) {
                        this.aL = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
                    }

                    var8 = this.aL;
                } else {
                    if (this.cv) {
                        this.aH = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
                    }

                    var7 = this.aH;
                }
            }

            boolean var9 = false;

            for(int var10 = 0; var10 < var5; ++var10) {
                int var11 = var10 * 5;
                int var12 = (int)var28[var11];
                boolean var14 = false;
                float var16;
                float var17;
                float var29;
                float var30;
                if (var6) {
                    RectF var15 = new RectF();
                    Bitmap var13;
                    if ((var13 = this.a(var12, var15)) != null) {
                        var29 = (float)var13.getWidth();
                        var16 = (float)var13.getHeight();
                        var17 = (float)var28[var11 + 1];
                        float var18 = (float)var28[var11 + 2];
                        float var19 = (float)var28[var11 + 3];
                        float var20 = (float)var28[var11 + 4];
                        float var21 = var19 - var17;
                        float var22 = var20 - var18;
                        var1.save();

                        try {
                            var1.clipRect(var17 + (float)var7, var18 + (float)var8, var19 + (float)var7, var20 + (float)var8, Op.INTERSECT);
                            float var23 = var29 + var15.left + var15.right;
                            float var24 = var16 + var15.top + var15.bottom;
                            var17 -= var15.left * (var21 / var23);
                            var19 += var15.right * (var21 / var23);
                            var18 -= var15.top * (var22 / var24);
                            var20 += var15.bottom * (var22 / var24);
                            var21 = var19 - var17;
                            var22 = var20 - var18;
                            var30 = Math.max((float)var2, var17);
                            var23 = Math.max((float)var3, var18);
                            var19 = Math.min((float)(var2 + this.aB), var19);
                            var20 = Math.min((float)(var3 + this.aC), var20);
                            var24 = var29 * ((var30 - var17) / var21);
                            float var25 = var16 * ((var23 - var18) / var22);
                            var29 *= (var19 - var17) / var21;
                            var16 *= (var20 - var18) / var22;
                            this.ak.set(var24, var25, var29, var16);
                            this.al.set(var30 + (float)var7, var23 + (float)var8, var19 + (float)var7, var20 + (float)var8);
                            this.ah.setRectToRect(this.ak, this.al, ScaleToFit.CENTER);
                            this.am.setFilterBitmap(true);
                            var1.drawBitmap(var13, this.ah, this.am);
                            this.am.setFilterBitmap(false);
                            if (a) {
                                var1.drawRect(this.al, this.at);
                            }

                            var14 = true;
                        } finally {
                            var1.restore();
                        }
                    }
                }

                if (!var14) {
                    var30 = (float)var28[var11 + 1] + (float)var7;
                    var29 = (float)var28[var11 + 2] + (float)var8;
                    var16 = (float)var28[var11 + 3] + (float)var7;
                    var17 = (float)var28[var11 + 4] + (float)var8;
                    var1.drawRect(var30, var29, var16, var17, this.am);
                    if (var12 == this.cD.b) {
                        PDFViewCtrl.u.a(this.cD, true);
                        PDFViewCtrl.u.a(this.cD, var30, var29, var16, var17);
                        var9 = true;
                    }
                }
            }

            if (!var9) {
                PDFViewCtrl.u.a(this.cD, false);
            }

        }
    }

    private void a(PDFDoc var1, boolean var2) throws PDFNetException {
        this.cancelRendering();
        this.j.lock();

        try {
            this.l.b();
            this.m.c();
        } finally {
            this.j.unlock();
        }

        if (!var2) {
            try {
                SetDoc(this.cY, var1.__GetHandle());
                this.mDoc = var1;
            } catch (Exception var5) {
                this.mDoc = null;
                this.invalidate();
                throw new PDFNetException("", 0L, "PDFViewCtrl.java", "setDocHelper", var5.getMessage());
            }
        } else {
            this.mDoc = var1;
        }

        if (this.mDoc == null) {
            throw new PDFNetException("", 0L, "PDFViewCtrl.java", "setDocHelper", "PDFDoc is null");
        } else {
            this.closeTool();
            if (this.bS != null) {
                this.bQ = true;
                this.bS.onControlReady();
            }

            this.bK = true;
            this.t = true;
            this.bg = true;
            this.requestLayout();
        }
    }

    private double[] a(double var1, double var3, double var5, double var7) {
        return GetPageRects(this.cY, var1, var3, var5, var7);
    }

    private double[] e(int var1) {
        return GetPageRectsOnCanvas(this.cY, var1);
    }

    public int getCurCanvasId() {
        return GetCurCanvasId(this.cY);
    }

    private int p() {
        return (int)(GetHScrollPos(this.cY) + 0.5D);
    }

    private int q() {
        return (int)(GetVScrollPos(this.cY) + 0.5D);
    }

    private Bitmap a(int var1, RectF var2) {
        com.pdftron.pdf.c var3;
        return (var3 = this.m.a(var1)) != null ? this.a(var3.a, var1, var3.b, var3.c, var2) : null;
    }

    private Bitmap a(Bitmap var1, int var2, com.pdftron.pdf.Rect var3, com.pdftron.pdf.Rect var4, RectF var5) {
        if (var1 == null) {
            return null;
        } else {
            int var6 = this.getPageRotation();
            int var7 = 0;
            int var8 = 0;
            int var9 = var1.getWidth();
            int var10 = var1.getHeight();
            float var11 = 0.0F;

            try {
                if (GetPageBox(this.cY) != 1 && var3 != null && var4 != null) {
                    if (var3.getHeight() > 0.0D && var4.getWidth() > 0.0D) {
                        double var13 = (var4.getX1() - var3.getX1()) / var3.getWidth();
                        double var15 = (var3.getX2() - var4.getX2()) / var3.getWidth();
                        double var17 = (var3.getY2() - var4.getY2()) / var3.getHeight();
                        double var19 = (var4.getY1() - var3.getY1()) / var3.getHeight();
                        double var22;
                        switch(this.mDoc.getPage(var2).getRotation()) {
                            case 1:
                                var22 = var13;
                                var13 = var19;
                                var19 = var15;
                                var15 = var17;
                                var17 = var22;
                                break;
                            case 2:
                                var22 = var13;
                                var13 = var15;
                                var15 = var22;
                                var22 = var19;
                                var19 = var17;
                                var17 = var22;
                                break;
                            case 3:
                                var22 = var13;
                                var13 = var17;
                                var17 = var15;
                                var15 = var19;
                                var19 = var22;
                        }

                        double var24 = var13 * (double)var9;
                        double var26 = (1.0D - var15) * (double)var9;
                        double var28 = var17 * (double)var10;
                        double var30 = (1.0D - var19) * (double)var10;
                        var7 = (int)var24;
                        int var35 = (int)Math.ceil(var26);
                        var8 = (int)var28;
                        int var36 = (int)Math.ceil(var30);
                        var5.set((float)(var24 - (double)var7), (float)(var28 - (double)var8), (float)((double)var35 - var26), (float)((double)var36 - var30));
                        var9 = var35 - var7;
                        var10 = var36 - var8;
                    }
                } else {
                    var5.set(0.0F, 0.0F, 0.0F, 0.0F);
                }
            } catch (Exception var34) {
                var5.set(0.0F, 0.0F, 0.0F, 0.0F);
            }

            switch(var6) {
                case 1:
                    var11 = var5.left;
                    var5.left = var5.bottom;
                    var5.bottom = var5.right;
                    var5.right = var5.top;
                    var5.top = var11;
                    var11 = 90.0F;
                    break;
                case 2:
                    var11 = var5.left;
                    var5.left = var5.right;
                    var5.right = var11;
                    var11 = var5.top;
                    var5.top = var5.bottom;
                    var5.bottom = var11;
                    var11 = 180.0F;
                    break;
                case 3:
                    var11 = var5.left;
                    var5.left = var5.top;
                    var5.top = var5.right;
                    var5.right = var5.bottom;
                    var5.bottom = var11;
                    var11 = 270.0F;
            }

            try {
                Matrix var12;
                (var12 = new Matrix()).postRotate(var11);
                return Bitmap.createBitmap(var1, var7, var8, var9, var10, var12, true);
            } catch (Exception var32) {
                return var1;
            } catch (OutOfMemoryError var33) {
                if (b) {
                    a(4, "Rotate thumbnail for page " + var2 + " ran out of memory", a(true));
                } else {
                    Log.e("PDFNet", "Rotate thumbnail for page " + var2 + " ran out of memory");
                }

                this.de.a();
                return var1;
            }
        }
    }

    private void r() {
        boolean var1 = a(this.bV);
        PDFViewCtrl.PagePresentationMode var2 = this.getPagePresentationMode();
        int var3 = this.getPageCount();
        if (!this.cv) {
            if (var1) {
                if (this.aC != this.aE) {
                    this.aJ = 0;
                    this.aL = 0;
                    return;
                }
            } else if (this.aB != this.aD) {
                this.aF = 0;
                this.aH = 0;
                return;
            }

            if (var2 == PDFViewCtrl.PagePresentationMode.SINGLE) {
                this.aF = (int)((float)(this.aB * var3) + this.ce.k * (float)(var3 - 1));
                this.aH = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
            } else if (var2 == PDFViewCtrl.PagePresentationMode.FACING) {
                this.aF = (int)((float)(this.aB * (int)Math.ceil((double)var3 / 2.0D)) + this.ce.k * (float)((int)(Math.ceil((double)var3 / 2.0D) - 1.0D)));
                this.aH = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
            } else if (var2 == PDFViewCtrl.PagePresentationMode.FACING_COVER) {
                this.aF = (int)((float)(this.aB * (int)Math.ceil((double)(var3 + 1) / 2.0D)) + this.ce.k * (float)((int)(Math.ceil((double)(var3 + 1) / 2.0D) - 1.0D)));
                this.aH = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
            } else if (var2 == PDFViewCtrl.PagePresentationMode.SINGLE_VERT) {
                this.aJ = (int)((float)(this.aC * var3) + this.ce.k * (float)(var3 - 1));
                this.aL = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
            } else if (var2 == PDFViewCtrl.PagePresentationMode.FACING_VERT) {
                this.aJ = (int)((float)(this.aC * (int)Math.ceil((double)var3 / 2.0D)) + this.ce.k * (float)((int)(Math.ceil((double)var3 / 2.0D) - 1.0D)));
                this.aL = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
            } else if (var2 == PDFViewCtrl.PagePresentationMode.FACING_COVER_VERT) {
                this.aJ = (int)((float)(this.aC * (int)Math.ceil((double)(var3 + 1) / 2.0D)) + this.ce.k * (float)((int)(Math.ceil((double)(var3 + 1) / 2.0D) - 1.0D)));
                this.aL = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
            }

            if (var1) {
                this.aK = this.aJ;
                this.aM = this.aL;
            } else {
                this.aG = this.aF;
                this.aI = this.aH;
            }
        } else {
            if (!this.f()) {
                ++var3;
                byte var4 = 0;
                if (var2 != PDFViewCtrl.PagePresentationMode.FACING && var2 != PDFViewCtrl.PagePresentationMode.FACING_VERT) {
                    if (var2 == PDFViewCtrl.PagePresentationMode.FACING_COVER || var2 == PDFViewCtrl.PagePresentationMode.FACING_COVER_VERT) {
                        var3 = i(var3) ? var3 + 1 : var3 + 2;
                        var4 = -1;
                    }
                } else {
                    var3 = !i(var3) ? var3 + 1 : var3 + 2;
                }

                if (var1) {
                    this.aL = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
                    this.aJ = this.getScrollOffsetForCanvasId(var3);
                    return;
                }

                this.aH = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
                this.aF = !this.cj ? this.getScrollOffsetForCanvasId(var3) : this.getScrollOffsetForCanvasId(var4);
            }

        }
    }

    private int a(double[] var1) {
        if (var1 != null && var1.length >= 5) {
            int var2 = (int)var1[4];
            if (var1.length > 5 && (!this.cj && var1[3] < var1[8] || this.cj && var1[3] > var1[8])) {
                var2 = (int)var1[9];
            }

            return var2;
        } else {
            return 0;
        }
    }

    private static int b(double[] var0) {
        if (var0 != null && var0.length >= 5) {
            int var1 = (int)var0[3];
            if (var0.length > 5 && var0[2] < var0[7]) {
                var1 = (int)var0[8];
            }

            return var1;
        } else {
            return 0;
        }
    }

    public boolean turnPageInNonContinuousMode(int var1, boolean var2) {
        if (this.isContinuousPagePresentationMode(this.bV)) {
            return false;
        } else {
            int var3;
            int var4;
            if (a(this.bV)) {
                if (this.aC == this.aE) {
                    if (var2) {
                        if (var1 < this.getPageCount()) {
                            this.gotoNextPage();
                            return true;
                        }
                    } else if (var1 > 1) {
                        this.gotoPreviousPage();
                        return true;
                    }

                    return false;
                }

                if (var1 > 0) {
                    if (this.cv) {
                        this.aL = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
                    }

                    var3 = this.getScrollY() - this.aL;
                    if (var2) {
                        var4 = this.getHeight();
                        if ((float)(var3 + var4) >= (float)this.aE - 1.0F) {
                            if (var1 < this.getPageCount()) {
                                this.ce.a().a(this.ce.e(this.getCurCanvasId()), 0);
                            }

                            return true;
                        }
                    } else if ((float)var3 <= 1.0F) {
                        if (var1 > 1) {
                            this.ce.a();
                            this.ce.a().a(this.ce.d(this.getCurCanvasId()), 0);
                        }

                        return true;
                    }
                }
            } else {
                if (this.aB == this.aD) {
                    if (var2) {
                        if (var1 < this.getPageCount()) {
                            this.gotoNextPage();
                            return true;
                        }
                    } else if (var1 > 1) {
                        this.gotoPreviousPage();
                        return true;
                    }

                    return false;
                }

                if (var1 > 0) {
                    if (this.cv) {
                        this.aH = this.getScrollOffsetForCanvasId(this.getCurCanvasId());
                    }

                    var3 = this.getScrollX() - this.aH;
                    if (var2) {
                        var4 = this.getWidth();
                        if ((float)(var3 + var4) >= (float)this.aD - 1.0F) {
                            if (var1 < this.getPageCount()) {
                                if (!this.cj) {
                                    this.ce.a().a(this.ce.e(this.getCurCanvasId()), 0);
                                } else {
                                    this.ce.a().a(this.ce.d(this.getCurCanvasId()), 0);
                                }
                            }

                            return true;
                        }
                    } else if ((float)var3 <= 1.0F) {
                        if (var1 > 1) {
                            this.ce.a();
                            if (!this.cj) {
                                this.ce.a().a(this.ce.d(this.getCurCanvasId()), 0);
                            } else {
                                this.ce.a().a(this.ce.e(this.getCurCanvasId()), 0);
                            }
                        }

                        return true;
                    }
                }
            }

            return false;
        }
    }

    public int getScrollOffsetForCanvasId(int var1) {
        PDFViewCtrl.PagePresentationMode var2;
        boolean var3;
        boolean var4 = !(var3 = a(var2 = this.getPagePresentationMode())) && this.cj;
        int var5 = this.getPageCount();
        int var7;
        int var13;
        if (this.cv) {
            var13 = var5;
            if ((var2 == PDFViewCtrl.PagePresentationMode.FACING_COVER || var2 == PDFViewCtrl.PagePresentationMode.FACING_COVER_VERT) && i(var5) || (var2 == PDFViewCtrl.PagePresentationMode.FACING || var2 == PDFViewCtrl.PagePresentationMode.FACING_VERT) && !i(var5)) {
                var13 = var5 + 1;
            }

            var7 = var2 != PDFViewCtrl.PagePresentationMode.SINGLE && var2 != PDFViewCtrl.PagePresentationMode.SINGLE_VERT ? 2 : 1;
            if (!this.f() && !this.cV) {
                int var12 = (int)this.ce.k;
                long[] var8;
                if ((var8 = this.getAllCanvasPixelSizes()) == null || var8.length == 0) {
                    return 0;
                }

                this.cW = new int[var5 + 2];
                this.cW[0] = 0;
                var5 = var2 != PDFViewCtrl.PagePresentationMode.FACING && var2 != PDFViewCtrl.PagePresentationMode.FACING_VERT ? 1 : 2;
                int var9 = !var4 ? 1 : var8.length - 2;
                int var10 = !var4 ? 3 : -3;

                for(int var11 = 0; var5 <= var13; var9 += var10) {
                    this.cW[var5] = var11 += (int)var8[var9] + var12;
                    var5 += var7;
                }

                this.cV = true;
            }

            if (this.cW != null && this.cW.length != 0) {
                if (var4) {
                    if (var2 == PDFViewCtrl.PagePresentationMode.FACING_COVER) {
                        --var13;
                    }

                    return this.cW[Math.min(this.cW.length - 1, Math.max(0, var13 - var1))];
                } else {
                    return this.cW[Math.min(this.cW.length - 1, Math.max(0, var1 - var7))];
                }
            } else {
                return 0;
            }
        } else {
            if (var4) {
                byte var6 = 1;
                var7 = var5;
                if (this.getPagePresentationMode() == PDFViewCtrl.PagePresentationMode.FACING) {
                    var7 = i(var5) ? var5 : var5 + 1;
                    var6 = 2;
                } else if (this.getPagePresentationMode() == PDFViewCtrl.PagePresentationMode.FACING_COVER) {
                    var7 = i(var5) ? var5 + 1 : var5;
                }

                var1 = var7 - var1 + var6;
            }

            var13 = 0;
            if (var2 != PDFViewCtrl.PagePresentationMode.SINGLE && var2 != PDFViewCtrl.PagePresentationMode.SINGLE_VERT) {
                if (var2 != PDFViewCtrl.PagePresentationMode.FACING && var2 != PDFViewCtrl.PagePresentationMode.FACING_VERT) {
                    if (var2 == PDFViewCtrl.PagePresentationMode.FACING_COVER || var2 == PDFViewCtrl.PagePresentationMode.FACING_COVER_VERT) {
                        var13 = (int)((float)((var3 ? this.aC : this.aB) * ((var1 + 1) / 2 - 1)) + this.ce.k * (float)((var1 + 1) / 2 - 1));
                    }
                } else {
                    var13 = (int)((float)((var3 ? this.aC : this.aB) * (var1 / 2 - 1)) + this.ce.k * (float)(var1 / 2 - 1));
                }
            } else {
                var13 = (int)((float)((var3 ? this.aC : this.aB) * (var1 - 1)) + this.ce.k * (float)(var1 - 1));
            }

            return var13;
        }
    }

    private int s() {
        int var1 = this.aB != this.aD && !this.cv ? this.aI : this.getScrollX();
        int var2 = var1 + this.aB / 2;
        return this.f(var2);
    }

    private int t() {
        int var1 = this.aC != this.aE && !this.cv ? this.aM : this.getScrollY();
        int var2 = var1 + this.aC / 2;
        return this.f(var2);
    }

    private int f(int var1) {
        PDFViewCtrl.PagePresentationMode var2;
        boolean var3;
        boolean var4 = !(var3 = a(var2 = this.getPagePresentationMode())) && this.cj;
        int var5 = this.getPageCount();
        int var8;
        if (this.cv) {
            byte var13 = 1;
            byte var14 = 1;
            int var12 = 1;
            var8 = var5;
            if (var2 != PDFViewCtrl.PagePresentationMode.FACING && var2 != PDFViewCtrl.PagePresentationMode.FACING_VERT) {
                if (var2 == PDFViewCtrl.PagePresentationMode.FACING_COVER || var2 == PDFViewCtrl.PagePresentationMode.FACING_COVER_VERT) {
                    var13 = 2;
                    var14 = 1;
                    var8 = (var5 + 2) / 2;
                    if (i(var5)) {
                        ++var5;
                    }
                }
            } else {
                var13 = 2;
                var14 = 2;
                var8 = (var5 + 1) / 2;
                if (i(var5)) {
                    ++var5;
                }
            }

            int var10;
            while(var12 != var8) {
                var10 = (var12 + var8) / 2;
                int var9 = !var4 ? var13 * var10 + var14 : var5 - (var13 * var10 + var14) + 1;
                if (this.getScrollOffsetForCanvasId(var9) <= var1) {
                    var12 = var10 + 1;
                } else {
                    var8 = var10;
                }
            }

            var10 = var13 * var12 - (var13 - 1) * (2 - var14);
            if (var4) {
                var10 = var5 - var10 + 1;
            }

            return var10;
        } else {
            float var6 = (float)var1 + 0.5F;
            int var7 = this.getCurCanvasId();
            if (var2 != PDFViewCtrl.PagePresentationMode.SINGLE && var2 != PDFViewCtrl.PagePresentationMode.SINGLE_VERT) {
                if (var2 != PDFViewCtrl.PagePresentationMode.FACING && var2 != PDFViewCtrl.PagePresentationMode.FACING_VERT) {
                    if (var2 == PDFViewCtrl.PagePresentationMode.FACING_COVER || var2 == PDFViewCtrl.PagePresentationMode.FACING_COVER_VERT) {
                        var8 = i(this.getPageCount()) ? this.getPageCount() + 1 : this.getPageCount();
                        var7 = ((int)(var6 / (var3 ? (float)this.aC : (float)this.aB + this.ce.k)) + 1 << 1) - 1;
                        var7 = Math.max(1, Math.min(var7, var8));
                    }
                } else {
                    var8 = i(this.getPageCount()) ? this.getPageCount() : this.getPageCount() + 1;
                    var7 = (int)(var6 / (var3 ? (float)this.aC : (float)this.aB + this.ce.k)) + 1 << 1;
                    var7 = Math.max(2, Math.min(var7, var8));
                }
            } else {
                var7 = (int)(var6 / (var3 ? (float)this.aC : (float)this.aB + this.ce.k)) + 1;
                var7 = Math.max(1, Math.min(var7, this.getPageCount()));
            }

            if (var4) {
                byte var11 = 1;
                var8 = this.getPageCount();
                if (this.getPagePresentationMode() == PDFViewCtrl.PagePresentationMode.FACING) {
                    var8 = i(var8) ? var8 : var8 + 1;
                    var11 = 2;
                } else if (this.getPagePresentationMode() == PDFViewCtrl.PagePresentationMode.FACING_COVER) {
                    var8 = i(var8) ? var8 + 1 : var8;
                }

                var7 = var8 - var7 + var11;
            }

            return var7;
        }
    }

    public int getScrollXOffsetInTools(int var1) {
        int var2 = 0;
        if (this.cv && this.ce.b) {
            int var3 = this.ce.z;
            var1 = this.h(var1);
            if (var3 != var1) {
                var2 = this.ce.H - this.getScrollOffsetForCanvasId(var3);
            }
        }

        return var2;
    }

    public int getScrollYOffsetInTools(int var1) {
        int var2 = 0;
        if (this.cv && this.ce.b) {
            int var3 = this.ce.z;
            if ((var1 = this.h(var1)) == var3) {
                var2 = this.ce.I;
            } else {
                double[] var4;
                if (var1 < var3 && (var4 = (double[])this.cF.get(var1)) != null) {
                    var2 = Math.max(0, this.a(var4) - this.aC);
                }
            }

            int var5;
            if (var1 != var3 && (var5 = this.cx.get(var1, -2147483648)) != -2147483648) {
                var2 = var5;
            }
        }

        return var2;
    }

    public boolean isCurrentSlidingCanvas(int var1) {
        int var2 = this.ce.z;
        var1 = this.h(var1);
        return var2 == var1;
    }

    public int getSlidingScrollX() {
        int var1 = 0;
        if (this.ce.b) {
            var1 = this.ce.H;
        }

        return var1;
    }

    public int getSlidingScrollY() {
        int var1 = 0;
        if (this.ce.b) {
            var1 = this.ce.I;
        }

        return var1;
    }

    private ArrayList<Integer> g(int var1) {
        ArrayList var2 = new ArrayList();
        if (this.getPagePresentationMode() != PDFViewCtrl.PagePresentationMode.SINGLE && this.getPagePresentationMode() != PDFViewCtrl.PagePresentationMode.SINGLE_VERT) {
            if (this.getPagePresentationMode() == PDFViewCtrl.PagePresentationMode.FACING || this.getPagePresentationMode() == PDFViewCtrl.PagePresentationMode.FACING_COVER || this.getPagePresentationMode() == PDFViewCtrl.PagePresentationMode.FACING_VERT || this.getPagePresentationMode() == PDFViewCtrl.PagePresentationMode.FACING_COVER_VERT) {
                int var3 = Math.max(1, Math.min(var1, this.getPageCount()));
                var2.add(var3);
                --var1;
                if ((var1 = Math.max(1, Math.min(var1, this.getPageCount()))) != var3) {
                    var2.add(0, var1);
                }
            }
        } else {
            var1 = Math.max(1, Math.min(var1, this.getPageCount()));
            var2.add(var1);
        }

        return var2;
    }

    private int h(int var1) {
        PDFViewCtrl.PagePresentationMode var2 = this.getPagePresentationMode();
        int var3 = var1;
        if (var2 != PDFViewCtrl.PagePresentationMode.FACING && var2 != PDFViewCtrl.PagePresentationMode.FACING_VERT) {
            if ((var2 == PDFViewCtrl.PagePresentationMode.FACING_COVER || var2 == PDFViewCtrl.PagePresentationMode.FACING_COVER_VERT) && i(var1)) {
                var3 = var1 + 1;
            }
        } else if (!i(var1)) {
            var3 = var1 + 1;
        }

        return var3;
    }

    private static boolean i(int var0) {
        return (var0 & 1) == 0;
    }

    private static native long SetJavaScriptEventCallback(long var0, JavaScriptEventProc var2, Object var3);

    private static native void RefreshAndUpdate(long var0, long var2);

    private native long[] PDFViewCtrlCreate(PDFViewCtrl.RenderCallback var1);

    private static native void Destroy(long var0);

    private static native void DestroyRenderData(long var0, long var2, long var4, long var6, long var8, long var10, long var12);

    private static native void PurgeMemory(long var0);

    private static native void SetMemInfo(long var0, double var2, double var4);

    private static native void SetDoc(long var0, long var2);

    private static native void CloseDoc(long var0);

    private static native long GetExternalAnnotManager(long var0, String var2);

    private static native void EnableFloatingAnnotTiles(long var0, long var2, int var4);

    private static native void EnableUndoRedo(long var0);

    private static native String Undo(long var0);

    private static native String Redo(long var0);

    private static native void TakeSnapshot(long var0, String var2);

    private static native String GetNextUndoInfo(long var0);

    private static native String GetNextRedoInfo(long var0);

    private static native void RevertAllChanges(long var0);

    private static native void DocLock(long var0, boolean var2);

    private static native void DocUnlock(long var0);

    private static native boolean DocTryLock(long var0, int var2);

    private static native boolean DocTryLockRead(long var0, int var2);

    private static native void DocLockRead(long var0);

    private static native void DocUnlockRead(long var0);

    private static native void RequestRender(long var0);

    private static native void SetCaching(long var0, boolean var2);

    private static native void SetImageSmoothing(long var0, boolean var2);

    private static native void SetRightToLeftLanguage(long var0, boolean var2);

    private static native void SetPageBox(long var0, int var2);

    private static native void SetOverprint(long var0, int var2);

    private static native void SetGamma(long var0, double var2);

    private static native void HideAnnotation(long var0, long var2);

    private static native void ShowAnnotation(long var0, long var2);

    private static native void SetDrawAnnotations(long var0, boolean var2);

    private static native void SetHighlightFields(long var0, boolean var2);

    private static native void SetFieldHighlightColor(long var0, long var2);

    private static native void SetSignatureHighlightColor(long var0, long var2);

    private static native void SetRequiredFieldBorderColor(long var0, long var2);

    private static native void SetAntiAliasing(long var0, boolean var2);

    private static native void SetThinLineAdjustment(long var0, boolean var2, boolean var3);

    private static native void SetPathHinting(long var0, boolean var2);

    private static native void SetDefaultPageColor(long var0, byte var2, byte var3, byte var4);

    private static native void SetBackgroundColor(long var0, byte var2, byte var3, byte var4, byte var5);

    private static native void SetVerticalAlign(long var0, int var2);

    private static native void SetHorizontalAlign(long var0, int var2);

    private static native void SetPageBorderVisibility(long var0, boolean var2);

    private static native void SetPageTransparencyGrid(long var0, boolean var2);

    private static native void SetUrlExtraction(long var0, boolean var2);

    private static native PDFViewCtrl.LinkInfo GetLinkAt(long var0, int var2, int var3);

    private static native void OnSize(long var0, int var2, int var3, int var4, boolean var5);

    private static native void OnScroll(long var0, int var2, int var3, boolean var4);

    private static native double GetZoom(long var0);

    private static native boolean SetZoom(long var0, double var2, boolean var4);

    private static native boolean SetZoom(long var0, int var2, int var3, double var4, boolean var6);

    private static native boolean SmartZoom(long var0, int var2, int var3);

    private static native void CancelRendering(long var0);

    private static native void CancelRenderingAsync(long var0);

    private static native void DoProgressiveRender(long var0);

    private static native boolean IsFinishedRendering(long var0, boolean var2);

    private static native void CancelAllThumbRequests(long var0);

    private static native void GetThumbAsync(long var0, long var2, long var4);

    private static native void SetupThumbnails(long var0, boolean var2, boolean var3, boolean var4, int var5, long var6, double var8);

    private static native void ClearThumbCache(long var0);

    private static native void SetPageViewMode(long var0, int var2);

    private static native int GetPageViewMode(long var0);

    private static native void SetPagePresentationMode(long var0, int var2);

    private static native int GetPagePresentationMode(long var0);

    private static native void SetPageRefViewMode(long var0, int var2);

    private static native int GetPageRefViewMode(long var0);

    private static native double GetRefZoom(long var0, int var2);

    private static native double GetRefZoomForPage(long var0, int var2, int var3);

    private static native void SetColorPostProcessMode(long var0, int var2);

    private static native void SetColorPostProcessColors(long var0, int var2, int var3);

    private static native void SetColorPostProcessMapFile(long var0, long var2);

    private static native int GetColorPostProcessMode(long var0);

    private static native long GetPostProcessedColor(long var0, long var2);

    private static native int GetPageBox(long var0);

    private static native int GetPagesCount(long var0);

    private static native int[] GetVisiblePages(long var0);

    private static native int GetCurrentPage(long var0);

    private static native boolean GotoFirstPage(long var0);

    private static native boolean GotoLastPage(long var0);

    private static native boolean GotoNextPage(long var0);

    private static native boolean GotoPreviousPage(long var0);

    private static native boolean SetCurrentPage(long var0, int var2);

    private static native boolean ShowRect(long var0, int var2, long var3);

    private static native long[] GetAllCanvasPixelSizes(long var0);

    private static native double GetCanvasWidth(long var0);

    private static native double GetCanvasHeight(long var0);

    private static native int GetTilingRegionWidth(long var0);

    private static native int GetTilingRegionHeight(long var0);

    private static native double GetHScrollPos(long var0);

    private static native double GetVScrollPos(long var0);

    private static native void RotateClockwise(long var0);

    private static native void RotateCounterClockwise(long var0);

    private static native int GetRotation(long var0);

    private static native void SetPageSpacing(long var0, int var2, int var3, int var4, int var5);

    private static native int[] GetPageSpacing(long var0);

    private static native int GetCurCanvasId(long var0);

    private static native double[] GetPageRects(long var0, double var2, double var4, double var6, double var8);

    private static native double[] GetPageRectsOnCanvas(long var0, int var2);

    private static native double[] ConvScreenPtToPagePt(long var0, double var2, double var4, int var6);

    private static native double[] ConvScreenPtToCanvasPt(long var0, double var2, double var4);

    private static native double[] ConvScreenPtToCanvasPt(long var0, double var2, double var4, int var6);

    private static native double[] ConvCanvasPtToScreenPt(long var0, double var2, double var4);

    private static native double[] ConvCanvasPtToScreenPt(long var0, double var2, double var4, int var6);

    private static native double[] ConvCanvasPtToPagePt(long var0, double var2, double var4, int var6);

    private static native double[] ConvPagePtToCanvasPt(long var0, double var2, double var4, int var6);

    private static native double[] ConvPagePtToScreenPt(long var0, double var2, double var4, int var6);

    private static native double[] SnapToNearestInDoc(long var0, double var2, double var4);

    private static native long GetDeviceTransform(long var0, int var2);

    private static native int GetPageNumberFromScreenPt(long var0, double var2, double var4);

    private static native void SetDevicePixelDensity(long var0, double var2, double var4);

    private static native long GetScreenRectForAnnot(long var0, long var2, int var4);

    private static native long GetAnnotationAt(long var0, int var2, int var3, double var4, double var6);

    private static native long[] GetAnnotationListAt(long var0, int var2, int var3, int var4, int var5);

    private static native long[] GetAnnotationsOnPage(long var0, int var2);

    private static native void UpdatePageLayout(long var0);

    private static native void Update(long var0, boolean var2);

    private static native void Update(long var0, long var2);

    private static native void Update(long var0, long var2, int var4);

    private static native void UpdateField(long var0, long var2);

    private static native void ExecuteAction(long var0, long var2);

    private static native void PrepareWords(long var0, int var2);

    private static native boolean WereWordsPrepared(long var0, int var2);

    private static native boolean IsThereTextInRect(long var0, double var2, double var4, double var6, double var8);

    private static native void PrepareAnnotsForMouse(long var0, int var2, double var3, double var5);

    private static native boolean WereAnnotsForMousePrepared(long var0, int var2);

    private static native int GetAnnotTypeUnder(long var0, double var2, double var4);

    private static native void SetTextSelectionMode(long var0, int var2);

    private static native boolean Select(long var0, double var2, double var4, double var6, double var8);

    private static native boolean Select(long var0, double var2, double var4, int var6, double var7, double var9, int var11);

    private static native boolean SelectByRect(long var0, double var2, double var4, double var6, double var8);

    private static native boolean SelectByStructWithSmartSnapping(long var0, double var2, double var4, double var6, double var8);

    private static native boolean SelectByStructWithSnapping(long var0, double var2, double var4, double var6, double var8, boolean var10, boolean var11);

    private static native boolean SelectByHighlights(long var0, long var2);

    private static native void SelectAll(long var0);

    private static native boolean SelectBySelection(long var0, long var2);

    private static native void FindTextAsync(long var0, String var2, boolean var3, boolean var4, boolean var5, boolean var6, int var7);

    private static native void CancelFindText(long var0);

    private static native double GetFindTextProgress(long var0);

    private static native boolean HasSelection(long var0);

    private static native void ClearSelection(long var0);

    private static native long GetSelection(long var0, int var2);

    private static native int GetSelectionBeginPage(long var0);

    private static native int GetSelectionEndPage(long var0);

    private static native boolean HasSelectionOnPage(long var0, int var2);

    private static native int SelectionGetPageNum(long var0);

    private static native double[] SelectionGetQuads(long var0);

    private static native String SelectionGetAsUnicode(long var0);

    private static native String SelectionGetAsHtml(long var0);

    private static native boolean DownloaderUpdatePage(long var0, long var2, int var4, int var5);

    private static native void DownloaderUpdateOutline(long var0, long var2);

    private static native void DownloaderUpdateThumb(long var0, long var2, int var4, int var5);

    private static native void DownloaderFinishedDownload(long var0, long var2);

    private static native void DownloaderOpened(long var0, long var2);

    private static native boolean DownloaderIsCorrectDoc(long var0, long var2);

    private static native void OpenURL(long var0, String var2, String var3, String var4, long var5);

    private static native void OpenUniversalDocumentNoDoc(long var0, long var2);

    private static native void SetViewerCache(long var0, int var2, boolean var3);

    private static native long GetOCGContext(long var0);

    private static native void SetOCGContext(long var0, long var2);

    private static native void UpdateOCGContext(long var0);

    private static String c(InputStream var0) {
        if (var0 == null) {
            return "";
        } else {
            BufferedReader var1 = null;
            StringBuilder var2 = new StringBuilder();
            boolean var12 = false;

            label146: {
                try {
                    var12 = true;
                    var1 = new BufferedReader(new InputStreamReader(var0));

                    String var3;
                    while((var3 = var1.readLine()) != null) {
                        var2.append(var3);
                    }

                    var12 = false;
                    break label146;
                } catch (IOException var19) {
                    var19.printStackTrace();
                    var12 = false;
                } finally {
                    if (var12) {
                        if (var1 != null) {
                            try {
                                var1.close();
                            } catch (IOException var14) {
                                var14.printStackTrace();
                            }
                        }

                        try {
                            var0.close();
                        } catch (IOException var13) {
                            var13.printStackTrace();
                        }

                    }
                }

                if (var1 != null) {
                    try {
                        var1.close();
                    } catch (IOException var16) {
                        var16.printStackTrace();
                    }
                }

                try {
                    var0.close();
                } catch (IOException var15) {
                    var15.printStackTrace();
                }

                return var2.toString();
            }

            try {
                var1.close();
            } catch (IOException var18) {
                var18.printStackTrace();
            }

            try {
                var0.close();
            } catch (IOException var17) {
                var17.printStackTrace();
            }

            return var2.toString();
        }
    }

    public void docLockRead(PDFViewCtrl.LockRunnable var1) throws Exception {
        boolean var2 = false;
        boolean var4 = false;

        try {
            var4 = true;
            this.docLockRead();
            var2 = true;
            var1.run();
            var4 = false;
        } finally {
            if (var4) {
                if (var2) {
                    this.docUnlockRead();
                }

            }
        }

        this.docUnlockRead();
    }

    public void docLock(boolean var1, PDFViewCtrl.LockRunnable var2) throws Exception {
        boolean var3 = false;
        boolean var5 = false;

        try {
            var5 = true;
            this.docLock(var1);
            var3 = true;
            var2.run();
            var5 = false;
        } finally {
            if (var5) {
                if (var3) {
                    this.docUnlock();
                }

            }
        }

        this.docUnlock();
    }

    static {
        d = a || b;
        L = 2;
        DEFAULT_BG_COLOR = -1709592;
        DEFAULT_DARK_BG_COLOR = -14606047;
    }

    public interface LockRunnable {
        void run() throws Exception;
    }

    class j {
        private boolean a;
        private boolean b = false;
        private boolean c = false;
        private boolean d = false;
        private boolean e = false;
        private boolean f = false;
        private float g;
        private float h;
        private float i;
        private float j;
        private float k = PDFViewCtrl.this.a(10.0F);
        private final float l;
        private final int m;
        private final float n;
        private int o;
        private int p;
        private int q;
        private int r;
        private int s;
        private int t;
        private int u = -1;
        private int v;
        private boolean w = false;
        private boolean x = false;
        private int y;
        private int z;
        private boolean A;
        private boolean B;
        private boolean C;
        private boolean D;
        private boolean E = false;
        private boolean F = false;
        private boolean G;
        private int H;
        private int I;
        private int J;
        private int K;
        private int L;

        j(int var2, int var3) {
            this.l = PDFViewCtrl.this.a((float)var3);
            this.m = var2;
            this.n = PDFViewCtrl.this.a(30.0F);
            this.B = false;
            this.C = false;
            this.D = false;
            this.a = false;
        }

        final PDFViewCtrl.j a() {
            this.o = PDFViewCtrl.this.getCurrentPage();
            this.s = this.o;
            this.t = this.o;
            this.u = -1;
            this.q = PDFViewCtrl.this.getPageCount();
            boolean var1 = this.b;
            if (!this.b) {
                this.A = false;
                this.z = PDFViewCtrl.this.getCurCanvasId();
                this.y = PDFViewCtrl.this.getCurrentPage();
            }

            this.r = this.q;
            PDFViewCtrl.PagePresentationMode var2;
            if ((var2 = PDFViewCtrl.this.getPagePresentationMode()) != PDFViewCtrl.PagePresentationMode.FACING && var2 != PDFViewCtrl.PagePresentationMode.FACING_VERT) {
                if (var2 == PDFViewCtrl.PagePresentationMode.FACING_COVER || var2 == PDFViewCtrl.PagePresentationMode.FACING_COVER_VERT) {
                    this.r = PDFViewCtrl.f(PDFViewCtrl.this, this.q) ? this.q + 1 : this.q;
                }
            } else {
                this.r = PDFViewCtrl.f(PDFViewCtrl.this, this.q) ? this.q : this.q + 1;
            }

            this.E = false;
            this.F = true;
            this.d = false;
            this.G = false;
            this.a = false;
            PDFViewCtrl.ao(PDFViewCtrl.this);
            this.C = false;
            this.D = false;
            if (PDFViewCtrl.a((PDFViewCtrl)PDFViewCtrl.this, (PDFViewCtrl.PagePresentationMode)var2)) {
                if (PDFViewCtrl.this.aC == PDFViewCtrl.this.aE) {
                    this.B = false;
                    if (PDFViewCtrl.this.aB != PDFViewCtrl.this.aD) {
                        this.D = true;
                    }
                } else {
                    this.B = true;
                }
            } else if (PDFViewCtrl.this.aB == PDFViewCtrl.this.aD) {
                this.B = false;
                if (PDFViewCtrl.this.aC != PDFViewCtrl.this.aE) {
                    this.C = true;
                }
            } else {
                this.B = true;
            }

            if (this.c) {
                this.e = true;
                if (PDFViewCtrl.a((PDFViewCtrl)PDFViewCtrl.this, (PDFViewCtrl.PagePresentationMode)var2)) {
                    this.p = PDFViewCtrl.this.t();
                } else {
                    this.p = PDFViewCtrl.this.s();
                }
            } else {
                this.p = PDFViewCtrl.this.getCurCanvasId();
            }

            if (!var1) {
                if (PDFViewCtrl.a((PDFViewCtrl)PDFViewCtrl.this, (PDFViewCtrl.PagePresentationMode)var2)) {
                    this.H = PDFViewCtrl.this.getScrollX();
                    this.I = !this.B && !PDFViewCtrl.this.cv ? PDFViewCtrl.this.getScrollY() : 0;
                } else {
                    this.H = !this.B && !PDFViewCtrl.this.cv ? 0 : PDFViewCtrl.this.getScrollX();
                    this.I = PDFViewCtrl.this.getScrollY();
                }
            }

            this.v = 0;
            return this;
        }

        final void a(MotionEvent var1) {
            this.g = var1.getX();
            this.h = var1.getY();
            this.i = var1.getX();
            this.j = var1.getY();
            this.a();
        }

        final boolean b(MotionEvent var1) {
            if (this.F && this.q != 0) {
                float var2 = var1.getX();
                float var12 = var1.getY();
                int var3 = PDFViewCtrl.this.getScrollX();
                int var4 = PDFViewCtrl.this.getScrollY();
                float var5 = this.i - var2;
                float var6 = this.j - var12;
                float var7 = var2 - this.g;
                float var8 = var12 - this.h;
                this.i = var2;
                this.j = var12;
                boolean var13 = false;
                if (PDFViewCtrl.this.cv) {
                    PDFViewCtrl.this.r();
                    if (PDFViewCtrl.a((PDFViewCtrl)PDFViewCtrl.this, (PDFViewCtrl.PagePresentationMode)PDFViewCtrl.this.bV)) {
                        PDFViewCtrl.this.aL = PDFViewCtrl.this.getScrollOffsetForCanvasId(PDFViewCtrl.this.getCurCanvasId());
                        PDFViewCtrl.this.aM = PDFViewCtrl.this.aL;
                    } else {
                        PDFViewCtrl.this.aH = PDFViewCtrl.this.getScrollOffsetForCanvasId(PDFViewCtrl.this.getCurCanvasId());
                        PDFViewCtrl.this.aI = PDFViewCtrl.this.aH;
                    }
                }

                int var14 = this.B && !PDFViewCtrl.this.cv ? var3 : var3 - PDFViewCtrl.this.aI;
                int var9 = !this.B && !PDFViewCtrl.this.cv ? PDFViewCtrl.this.getScrollX() : PDFViewCtrl.this.aI + Math.abs(this.v);
                int var10 = this.B && !PDFViewCtrl.this.cv ? var4 : var4 - PDFViewCtrl.this.aM;
                int var11 = !this.B && !PDFViewCtrl.this.cv ? PDFViewCtrl.this.getScrollY() : PDFViewCtrl.this.aM + Math.abs(this.v);
                if (!this.b) {
                    if (!PDFViewCtrl.a((PDFViewCtrl)PDFViewCtrl.this, (PDFViewCtrl.PagePresentationMode)PDFViewCtrl.this.bV) && Math.abs(var7) > Math.abs(var8)) {
                        if (var7 >= 3.0F) {
                            if ((float)var14 <= 1.0F) {
                                if (var3 != var9 && !PDFViewCtrl.this.cv && !this.a) {
                                    this.a = true;
                                    PDFViewCtrl.super.scrollTo(var9, 0);
                                }

                                this.b = true;
                            }
                        } else if (var7 <= -3.0F && (float)(var14 + PDFViewCtrl.this.aB) >= (float)PDFViewCtrl.this.getViewCanvasWidth() - 1.0F) {
                            if (var3 != var9 && !PDFViewCtrl.this.cv && !this.a) {
                                this.a = true;
                                PDFViewCtrl.super.scrollTo(var9, 0);
                            }

                            this.b = true;
                        }
                    } else if (PDFViewCtrl.a((PDFViewCtrl)PDFViewCtrl.this, (PDFViewCtrl.PagePresentationMode)PDFViewCtrl.this.bV) && Math.abs(var8) > Math.abs(var7)) {
                        if (var8 >= 3.0F) {
                            if ((float)var10 <= 1.0F) {
                                if (var4 != var11 && !PDFViewCtrl.this.cv && !this.a) {
                                    this.a = true;
                                    PDFViewCtrl.super.scrollTo(0, var11);
                                }

                                this.b = true;
                            }
                        } else if (var8 <= -3.0F && (float)(var10 + PDFViewCtrl.this.aC) >= (float)PDFViewCtrl.this.getViewCanvasHeight() - 1.0F) {
                            if (var4 != var11 && !PDFViewCtrl.this.cv && !this.a) {
                                this.a = true;
                                PDFViewCtrl.super.scrollTo(0, var11);
                            }

                            this.b = true;
                        }
                    } else if (this.b) {
                        return true;
                    }
                }

                if (this.b) {
                    this.c(this.p);
                    if (this.b(this.o, this.p)) {
                        this.c(this.d(this.p));
                    }

                    if (this.c(this.o, this.p)) {
                        this.c(this.e(this.p));
                    }

                    int var15;
                    if (PDFViewCtrl.a((PDFViewCtrl)PDFViewCtrl.this, (PDFViewCtrl.PagePresentationMode)PDFViewCtrl.this.bV)) {
                        if (var6 < 0.0F) {
                            this.x = false;
                            var14 = 0;
                            if (var11 > 0) {
                                var14 = Math.max(-var11, (int)var6);
                                this.v += var14;
                            } else if ((this.o == 1 || this.o == 2) && PDFViewCtrl.this.bS != null) {
                                PDFViewCtrl.this.bS.onPullEdgeEffects(-1, Math.abs(var6) / (float)PDFViewCtrl.this.aC);
                            }

                            var3 = PDFViewCtrl.this.getScrollY();
                            PDFViewCtrl.this.h.startScroll(0, var3, 0, var14, 0);
                            var13 = true;
                        } else if (var6 > 0.0F) {
                            this.x = true;
                            if (PDFViewCtrl.this.cv) {
                                var14 = PDFViewCtrl.this.aJ - PDFViewCtrl.this.aC - (int)PDFViewCtrl.this.ce.k - PDFViewCtrl.this.getScrollY();
                            } else {
                                var14 = (this.B ? PDFViewCtrl.this.aK : PDFViewCtrl.this.aJ) - var11 - PDFViewCtrl.this.aC;
                            }

                            var3 = 0;
                            if (var14 > 0) {
                                var3 = Math.min(var14, (int)var6);
                                this.v += var3;
                            } else if (this.o == this.q && PDFViewCtrl.this.bS != null) {
                                PDFViewCtrl.this.bS.onPullEdgeEffects(1, Math.abs(var6) / (float)PDFViewCtrl.this.aC);
                                PDFViewCtrl.this.cD.a(true);
                            }

                            var15 = PDFViewCtrl.this.getScrollY();
                            PDFViewCtrl.this.h.startScroll(0, var15, 0, var3, 0);
                            var13 = true;
                        }

                        if (!this.A) {
                            var14 = PDFViewCtrl.this.getScrollOffsetForCanvasId(this.z);
                            var3 = PDFViewCtrl.this.getScrollY();
                            if (Math.abs(var14 - var3) > PDFViewCtrl.this.aC) {
                                this.A = true;
                            }
                        }
                    } else {
                        if (var5 < 0.0F) {
                            this.w = false;
                            var14 = 0;
                            if (var9 > 0) {
                                var14 = Math.max(-var9, (int)var5);
                                this.v += var14;
                            } else if ((!PDFViewCtrl.this.cj ? this.o == 1 || this.o == 2 : this.o == this.q) && PDFViewCtrl.this.bS != null) {
                                PDFViewCtrl.this.bS.onPullEdgeEffects(-1, Math.abs(var5) / (float)PDFViewCtrl.this.aB);
                                if (PDFViewCtrl.this.cj) {
                                    PDFViewCtrl.this.cD.a(true);
                                }
                            }

                            var3 = PDFViewCtrl.this.getScrollX();
                            PDFViewCtrl.this.g.startScroll(var3, 0, var14, 0, 0);
                            var13 = true;
                        } else if (var5 > 0.0F) {
                            this.w = true;
                            if (PDFViewCtrl.this.cv) {
                                var14 = PDFViewCtrl.this.aF - PDFViewCtrl.this.aB - (int)PDFViewCtrl.this.ce.k - PDFViewCtrl.this.getScrollX();
                            } else {
                                var14 = (this.B ? PDFViewCtrl.this.aG : PDFViewCtrl.this.aF) - var9 - PDFViewCtrl.this.aB;
                            }

                            var3 = 0;
                            if (var14 > 0) {
                                var3 = Math.min(var14, (int)var5);
                                this.v += var3;
                            } else if ((!PDFViewCtrl.this.cj ? this.o == this.q : this.o == 1 || this.o == 2) && PDFViewCtrl.this.bS != null) {
                                PDFViewCtrl.this.bS.onPullEdgeEffects(1, Math.abs(var5) / (float)PDFViewCtrl.this.aB);
                                if (!PDFViewCtrl.this.cj) {
                                    PDFViewCtrl.this.cD.a(true);
                                }
                            }

                            var15 = PDFViewCtrl.this.getScrollX();
                            PDFViewCtrl.this.g.startScroll(var15, 0, var3, 0, 0);
                            var13 = true;
                        }

                        if (!this.A) {
                            var14 = PDFViewCtrl.this.getScrollOffsetForCanvasId(this.z);
                            var3 = PDFViewCtrl.this.getScrollX();
                            if (Math.abs(var14 - var3) > PDFViewCtrl.this.aB) {
                                this.A = true;
                            }
                        }
                    }

                    if (!this.f) {
                        PDFViewCtrl.this.bI = PDFViewCtrl.PageChangeState.BEGIN;
                        PDFViewCtrl.this.dg.removeMessages(0);
                        PDFViewCtrl.this.dg.sendEmptyMessage(0);
                        this.f = true;
                    }

                    if (this.t <= 0) {
                        this.t = 1;
                    }

                    if (this.t > this.q) {
                        this.t = this.q;
                    }
                }

                if (var13) {
                    PDFViewCtrl.this.invalidate();
                }

                return var13;
            } else {
                return false;
            }
        }

        final boolean a(float var1, float var2) {
            if (this.F && !this.E) {
                PDFViewCtrl.ao(PDFViewCtrl.this);
                boolean var3 = false;
                int var10;
                if (PDFViewCtrl.a((PDFViewCtrl)PDFViewCtrl.this, (PDFViewCtrl.PagePresentationMode)PDFViewCtrl.this.bV)) {
                    if (Math.abs(var2) > this.l) {
                        if (var2 < 0.0F) {
                            this.x = true;
                            if (this.c()) {
                                this.u = this.e();
                                var10 = this.u;
                                this.a(var10, -1);
                                var3 = true;
                            }
                        } else {
                            this.x = false;
                            if (this.b()) {
                                this.u = this.d();
                                var10 = this.u;
                                this.a(var10, -1);
                                var3 = true;
                            }
                        }
                    }
                } else if (Math.abs(var1) > this.l) {
                    if (var1 < 0.0F) {
                        this.w = true;
                        if (!PDFViewCtrl.this.cj) {
                            if (this.c()) {
                                this.u = this.e();
                                var10 = this.u;
                                this.a(var10, -1);
                                var3 = true;
                            }
                        } else if (this.b()) {
                            this.u = this.d();
                            var10 = this.u;
                            this.a(var10, -1);
                            var3 = true;
                        }
                    } else {
                        this.w = false;
                        if (!PDFViewCtrl.this.cj) {
                            if (this.b()) {
                                this.u = this.d();
                                var10 = this.u;
                                this.a(var10, -1);
                                var3 = true;
                            }
                        } else if (this.c()) {
                            this.u = this.e();
                            var10 = this.u;
                            this.a(var10, -1);
                            var3 = true;
                        }
                    }
                }

                if (!var3) {
                    this.G = true;
                    var10 = PDFViewCtrl.this.getWidth();
                    int var12 = PDFViewCtrl.this.getHeight();
                    int var4 = PDFViewCtrl.this.getScrollX();
                    int var5 = PDFViewCtrl.this.getScrollY();
                    boolean var6;
                    if (var6 = PDFViewCtrl.a((PDFViewCtrl)PDFViewCtrl.this, (PDFViewCtrl.PagePresentationMode)PDFViewCtrl.this.bV)) {
                        var5 = PDFViewCtrl.this.h.computeScrollOffset() ? PDFViewCtrl.this.h.getCurrY() : PDFViewCtrl.this.getScrollY();
                    } else {
                        var4 = PDFViewCtrl.this.g.computeScrollOffset() ? PDFViewCtrl.this.g.getCurrX() : PDFViewCtrl.this.getScrollX();
                    }

                    int var7 = this.p;
                    int var8 = 0;
                    int var9 = 0;
                    if (var6) {
                        var9 = var5 - PDFViewCtrl.this.getScrollOffsetForCanvasId(var7);
                    } else {
                        var8 = var4 - PDFViewCtrl.this.getScrollOffsetForCanvasId(var7);
                    }

                    byte var11 = 1;
                    PDFViewCtrl.PagePresentationMode var13;
                    if ((var13 = PDFViewCtrl.this.getPagePresentationMode()) == PDFViewCtrl.PagePresentationMode.FACING || var13 == PDFViewCtrl.PagePresentationMode.FACING_VERT) {
                        var11 = 2;
                    }

                    label179: {
                        boolean var14 = var6 ? this.p > var11 : (!PDFViewCtrl.this.cj ? this.p > var11 : this.p < this.r);
                        boolean var15 = var6 ? this.p < this.q : (!PDFViewCtrl.this.cj ? this.p < this.q : this.p > var11);
                        if (var6) {
                            if (var9 >= 0 || !var14 || Math.abs(var9) <= var12 / 2) {
                                if (var9 > 0 && var15) {
                                    if (PDFViewCtrl.this.cv) {
                                        var9 = PDFViewCtrl.this.getScrollY() - PDFViewCtrl.this.ce.I;
                                    }

                                    if (var9 > var12 / 2) {
                                        var7 = this.e(var7);
                                    }
                                }
                                break label179;
                            }
                        } else if (var8 < 0 && var14 && Math.abs(var8) > var10 / 2) {
                            if (PDFViewCtrl.this.cj) {
                                var7 = this.e(var7);
                                break label179;
                            }
                        } else {
                            if (var8 <= 0 || !var15) {
                                break label179;
                            }

                            if (PDFViewCtrl.this.cv) {
                                var8 = PDFViewCtrl.this.getScrollX() - PDFViewCtrl.this.ce.H;
                            }

                            if (var8 <= var10 / 2) {
                                break label179;
                            }

                            if (!PDFViewCtrl.this.cj) {
                                var7 = this.e(var7);
                                break label179;
                            }
                        }

                        var7 = this.d(var7);
                    }

                    this.a(var7, -1);
                }

                this.E = true;
                return true;
            } else {
                return false;
            }
        }

        private int a(int var1) {
            int var2 = var1;

            try {
                double[] var7;
                if ((var7 = PDFViewCtrl.this.e(var1)) != null) {
                    int var3 = var7.length / 5;

                    for(int var4 = 0; var4 < var3; ++var4) {
                        int var5 = var4 * 5;
                        if ((var5 = (int)var7[var5]) < var2) {
                            var2 = var5;
                        }
                    }
                }
            } catch (Exception var6) {
            }

            return var2;
        }

        private int b(int var1) {
            int var2 = var1;

            try {
                double[] var7;
                if ((var7 = PDFViewCtrl.this.e(var1)) != null) {
                    int var3 = var7.length / 5;

                    for(int var4 = 0; var4 < var3; ++var4) {
                        int var5 = var4 * 5;
                        if ((var5 = (int)var7[var5]) > var2) {
                            var2 = var5;
                        }
                    }
                }
            } catch (Exception var6) {
            }

            return var2;
        }

        private void c(int var1) {
            if (PDFViewCtrl.this.mDoc != null && var1 > 0 && var1 <= this.r) {
                if (PDFViewCtrl.this.cF.get(var1) == null) {
                    try {
                        double[] var2;
                        if ((var2 = PDFViewCtrl.this.e(var1)) != null) {
                            int var3 = var2.length / 5;
                            boolean var4 = true;

                            for(int var5 = 0; var5 < var3; ++var5) {
                                int var6 = var5 * 5;
                                var6 = (int)var2[var6];
                                PDFViewCtrl.PagePresentationMode var7;
                                if ((var7 = PDFViewCtrl.this.getPagePresentationMode()) != PDFViewCtrl.PagePresentationMode.SINGLE && var7 != PDFViewCtrl.PagePresentationMode.SINGLE_VERT) {
                                    if (var7 == PDFViewCtrl.PagePresentationMode.FACING || var7 == PDFViewCtrl.PagePresentationMode.FACING_VERT) {
                                        if (var6 > var1 || var6 < var1 - 1) {
                                            var4 = false;
                                        }
                                        continue;
                                    }

                                    if (var7 != PDFViewCtrl.PagePresentationMode.FACING_COVER && var7 != PDFViewCtrl.PagePresentationMode.FACING_COVER_VERT || var6 <= var1 && var6 >= var1 - 1) {
                                        continue;
                                    }
                                } else if (var6 == var1) {
                                    continue;
                                }

                                var4 = false;
                            }

                            if (var4) {
                                PDFViewCtrl.this.cF.put(var1, var2);
                            }
                        }

                    } catch (Exception var8) {
                    }
                }
            }
        }

        private void a(int var1, int var2) {
            this.b = true;
            int var3 = PDFViewCtrl.this.getCurCanvasId();
            if (PDFViewCtrl.this.cv && var3 != var1) {
                PDFViewCtrl.this.cw.put(var3, PDFViewCtrl.this.p());
                PDFViewCtrl.this.cx.put(var3, PDFViewCtrl.this.q());
            }

            this.u = Math.max(1, Math.min(var1, this.r));
            this.s = Math.max(1, Math.min(var1, this.q));
            if (this.u == this.z) {
                this.s = this.y;
            }

            var1 = PDFViewCtrl.this.getScrollX();
            int var4 = PDFViewCtrl.this.getScrollY();
            if (PDFViewCtrl.a((PDFViewCtrl)PDFViewCtrl.this, (PDFViewCtrl.PagePresentationMode)PDFViewCtrl.this.bV)) {
                var4 = PDFViewCtrl.this.h.computeScrollOffset() ? PDFViewCtrl.this.h.getCurrY() : PDFViewCtrl.this.getScrollY();
                this.K = PDFViewCtrl.this.getScrollOffsetForCanvasId(this.u);
            } else {
                var1 = PDFViewCtrl.this.g.computeScrollOffset() ? PDFViewCtrl.this.g.getCurrX() : PDFViewCtrl.this.getScrollX();
                this.J = PDFViewCtrl.this.getScrollOffsetForCanvasId(this.u);
            }

            if (!this.c) {
                this.L = var3;
            }

            if (PDFViewCtrl.this.cv) {
                if (this.p == this.u) {
                    PDFViewCtrl.PagePresentationMode var7;
                    int var5 = (var7 = PDFViewCtrl.this.getPagePresentationMode()) != PDFViewCtrl.PagePresentationMode.FACING && var7 != PDFViewCtrl.PagePresentationMode.FACING_COVER && var7 != PDFViewCtrl.PagePresentationMode.FACING_VERT && var7 != PDFViewCtrl.PagePresentationMode.FACING_COVER_VERT ? 1 : 2;
                    int var6;
                    if (PDFViewCtrl.a((PDFViewCtrl)PDFViewCtrl.this, (PDFViewCtrl.PagePresentationMode)var7)) {
                        var3 = this.p + var5;
                        var3 = PDFViewCtrl.this.getScrollOffsetForCanvasId(var3);
                        var5 = Math.abs(var4 - PDFViewCtrl.this.getScrollOffsetForCanvasId(this.p));
                        var6 = Math.abs(var4 + PDFViewCtrl.this.aC - var3);
                        if (var5 > var6) {
                            this.K = var3 - PDFViewCtrl.this.aC - (int)PDFViewCtrl.this.ce.k;
                        }
                    } else {
                        var3 = this.p + (!PDFViewCtrl.this.cj ? var5 : -var5);
                        var3 = PDFViewCtrl.this.getScrollOffsetForCanvasId(var3);
                        var5 = Math.abs(var1 - PDFViewCtrl.this.getScrollOffsetForCanvasId(this.p));
                        var6 = Math.abs(var1 + PDFViewCtrl.this.aB - var3);
                        if (var5 > var6) {
                            this.J = var3 - PDFViewCtrl.this.aB - (int)PDFViewCtrl.this.ce.k;
                        }
                    }
                } else if (PDFViewCtrl.a((PDFViewCtrl)PDFViewCtrl.this, (PDFViewCtrl.PagePresentationMode)PDFViewCtrl.this.bV)) {
                    if (this.p > this.u) {
                        this.K = PDFViewCtrl.this.getScrollOffsetForCanvasId(this.p) - PDFViewCtrl.this.aC - (int)PDFViewCtrl.this.ce.k;
                    }
                } else if (this.p > this.u && !PDFViewCtrl.this.cj || this.p < this.u && PDFViewCtrl.this.cj) {
                    this.J = PDFViewCtrl.this.getScrollOffsetForCanvasId(this.p) - PDFViewCtrl.this.aB - (int)PDFViewCtrl.this.ce.k;
                }
            }

            if (PDFViewCtrl.a((PDFViewCtrl)PDFViewCtrl.this, (PDFViewCtrl.PagePresentationMode)PDFViewCtrl.this.bV)) {
                var3 = this.K - var4;
                if (var2 < 0) {
                    var2 = Math.min(1000, (int)((float)Math.abs(var3) / (float)PDFViewCtrl.this.getHeight() * (float)this.m));
                }

                PDFViewCtrl.this.h.startScroll(0, var4, 0, var3, var2);
            } else {
                var3 = this.J - var1;
                if (var2 < 0) {
                    var2 = Math.min(1000, (int)((float)Math.abs(var3) / (float)PDFViewCtrl.this.getWidth() * (float)this.m));
                }

                PDFViewCtrl.this.g.startScroll(var1, 0, var3, 0, var2);
            }

            this.c = true;
            this.c(this.u);
            if (this.b(this.u, this.u)) {
                this.c(this.d(this.u));
            }

            if (this.c(this.u, this.u)) {
                this.c(this.e(this.u));
            }

            if (this.p != this.u) {
                this.c(this.u);
                if (this.b(this.p, this.p)) {
                    this.c(this.d(this.p));
                }

                if (this.c(this.p, this.p)) {
                    this.c(this.e(this.p));
                }
            }

            PDFViewCtrl.this.invalidate();
        }

        private boolean b(int var1, int var2) {
            if (this.q <= 1) {
                return false;
            } else {
                PDFViewCtrl.PagePresentationMode var3;
                if ((var3 = PDFViewCtrl.this.getPagePresentationMode()) != PDFViewCtrl.PagePresentationMode.SINGLE && var3 != PDFViewCtrl.PagePresentationMode.SINGLE_VERT) {
                    if (var3 != PDFViewCtrl.PagePresentationMode.FACING && var3 != PDFViewCtrl.PagePresentationMode.FACING_VERT) {
                        if (var3 != PDFViewCtrl.PagePresentationMode.FACING_COVER && var3 != PDFViewCtrl.PagePresentationMode.FACING_COVER_VERT) {
                            return false;
                        } else {
                            return var2 >= 2;
                        }
                    } else {
                        return this.q > 2 && var2 > 2;
                    }
                } else {
                    return var1 > 1;
                }
            }
        }

        private boolean b() {
            return this.b(this.o, this.p);
        }

        private boolean c(int var1, int var2) {
            if (this.q <= 1) {
                return false;
            } else {
                PDFViewCtrl.PagePresentationMode var3;
                if ((var3 = PDFViewCtrl.this.getPagePresentationMode()) != PDFViewCtrl.PagePresentationMode.SINGLE && var3 != PDFViewCtrl.PagePresentationMode.SINGLE_VERT) {
                    if (var3 != PDFViewCtrl.PagePresentationMode.FACING && var3 != PDFViewCtrl.PagePresentationMode.FACING_VERT) {
                        if (var3 != PDFViewCtrl.PagePresentationMode.FACING_COVER && var3 != PDFViewCtrl.PagePresentationMode.FACING_COVER_VERT) {
                            return false;
                        } else {
                            return var2 < this.q;
                        }
                    } else {
                        return this.q > 2 && var2 < this.q;
                    }
                } else {
                    return var1 < this.q;
                }
            }
        }

        private boolean c() {
            return this.c(this.o, this.p);
        }

        private int d(int var1) {
            PDFViewCtrl.PagePresentationMode var2 = PDFViewCtrl.this.getPagePresentationMode();
            int var3 = var1;
            if (var2 != PDFViewCtrl.PagePresentationMode.SINGLE && var2 != PDFViewCtrl.PagePresentationMode.SINGLE_VERT) {
                if (var2 != PDFViewCtrl.PagePresentationMode.FACING && var2 != PDFViewCtrl.PagePresentationMode.FACING_VERT) {
                    if ((var2 == PDFViewCtrl.PagePresentationMode.FACING_COVER || var2 == PDFViewCtrl.PagePresentationMode.FACING_COVER_VERT) && var1 > 2) {
                        var3 = var1 - 2;
                    }
                } else if (var1 > 3) {
                    var3 = var1 - 2;
                }
            } else if (var1 > 1) {
                var3 = var1 - 1;
            }

            if (var3 < 0) {
                var3 = var1;
            }

            return var3;
        }

        private int d() {
            return this.d(this.p);
        }

        private int e(int var1) {
            PDFViewCtrl.PagePresentationMode var2 = PDFViewCtrl.this.getPagePresentationMode();
            int var3 = PDFViewCtrl.this.getPageCount();
            int var4 = var1;
            if (var2 != PDFViewCtrl.PagePresentationMode.SINGLE && var2 != PDFViewCtrl.PagePresentationMode.SINGLE_VERT) {
                if (var2 != PDFViewCtrl.PagePresentationMode.FACING && var2 != PDFViewCtrl.PagePresentationMode.FACING_VERT) {
                    if (var2 != PDFViewCtrl.PagePresentationMode.FACING_COVER && var2 != PDFViewCtrl.PagePresentationMode.FACING_COVER_VERT || var1 >= var3 || (var4 = var1 + 2) <= var3) {
                        return var4;
                    }

                    if (PDFViewCtrl.f(PDFViewCtrl.this, this.q)) {
                        var4 = var3 + 1;
                        return var4;
                    }
                } else {
                    if (var1 >= var3 || (var4 = var1 + 2) <= var3) {
                        return var4;
                    }

                    if (!PDFViewCtrl.f(PDFViewCtrl.this, this.q)) {
                        var4 = var3 + 1;
                        return var4;
                    }
                }

                var4 = var3;
            } else if (var1 < var3) {
                var4 = var1 + 1;
            }

            return var4;
        }

        private int e() {
            return this.e(this.p);
        }
    }

    class c extends AlertDialog {
        private EditText b;
        private PDFDoc c = null;
        private int d = 0;

        c(Context var2) {
            super(var2);
            this.setTitle("Password");
            this.b = new EditText(var2);
            this.b.setLayoutParams(new LayoutParams(-1, -1));
            this.b.setSingleLine();
            this.b.setTransformationMethod(new PasswordTransformationMethod());
            this.b.setOnEditorActionListener(new OnEditorActionListener(PDFViewCtrl.this) {
                public final boolean onEditorAction(TextView var1, int var2, KeyEvent var3) {
                    if (var2 != 0 && var2 != 6 && (var3 == null || var3.getKeyCode() != 66)) {
                        return false;
                    } else {
                        PDFViewCtrl.c.a(c.this);
                        return true;
                    }
                }
            });
            this.setOnShowListener(new OnShowListener(PDFViewCtrl.this) {
                public final void onShow(DialogInterface var1) {
                    Button var10000 = PDFViewCtrl.this.bR != null ? PDFViewCtrl.this.bR.getButton(-1) : null;
                    Button var2 = var10000;
                    if (var10000 != null) {
                        var2.setOnClickListener(new OnClickListener() {
                            public final void onClick(View var1) {
                                PDFViewCtrl.c.a(c.this);
                            }
                        });
                    }

                }
            });
            this.setView(this.b, 8, 8, 8, 8);
            this.setButton(-1, "OK", new android.content.DialogInterface.OnClickListener(this, PDFViewCtrl.this) {
                public final void onClick(DialogInterface var1, int var2) {
                }
            });
            this.setButton(-2, "Cancel", new android.content.DialogInterface.OnClickListener(this, PDFViewCtrl.this) {
                public final void onClick(DialogInterface var1, int var2) {
                }
            });
        }

        public final void a(PDFDoc var1) {
            this.c = var1;
            this.d = 0;
        }

        public final void show() {
            this.b.setText("");
            super.show();
        }
    }

    static class r extends Handler {
        private final WeakReference<PDFViewCtrl> a;

        r(PDFViewCtrl var1) {
            this.a = new WeakReference(var1);
        }

        public final void handleMessage(Message var1) {
            int var2;
            PDFViewCtrl var3;
            if ((var3 = (PDFViewCtrl)this.a.get()) != null && var3.bB != null && (var2 = (int)(PDFViewCtrl.am(var3) * 100.0F)) >= 0) {
                var3.bB.onTextSearchProgress(var2);
            }

        }
    }

    static class a extends Handler {
        private final WeakReference<PDFViewCtrl> a;

        a(PDFViewCtrl var1) {
            this.a = new WeakReference(var1);
        }

        public final void handleMessage(Message var1) {
            PDFViewCtrl var2;
            if ((var2 = (PDFViewCtrl)this.a.get()) != null && var2.bN != null && var1.obj instanceof Vector) {
                Action var3 = (Action)((Vector)var1.obj).elementAt(0);
                var2.bN.onActionCompleted(var3);
            }

        }
    }

    static class s extends Handler {
        private final WeakReference<PDFViewCtrl> a;

        s(PDFViewCtrl var1) {
            this.a = new WeakReference(var1);
        }

        public final void handleMessage(Message var1) {
            PDFViewCtrl var2;
            if ((var2 = (PDFViewCtrl)this.a.get()) != null && var2.bM != null && var1.obj instanceof Vector) {
                Vector var7;
                int var3 = (Integer)(var7 = (Vector)var1.obj).elementAt(0);
                int[] var4 = (int[])var7.elementAt(1);
                int var5 = (Integer)var7.elementAt(2);
                int var8 = (Integer)var7.elementAt(3);
                Iterator var9 = var2.bM.iterator();

                while(var9.hasNext()) {
                    ((PDFViewCtrl.ThumbAsyncListener)var9.next()).onThumbReceived(var3, var4, var5, var8);
                }
            }

        }
    }

    static class f extends Handler {
        private final WeakReference<PDFViewCtrl> a;

        f(PDFViewCtrl var1) {
            this.a = new WeakReference(var1);
        }

        public final void handleMessage(Message var1) {
            PDFViewCtrl var2;
            if ((var2 = (PDFViewCtrl)this.a.get()) != null && var2.bL != null && var1.obj instanceof Vector) {
                String var3 = (String)((Vector)var1.obj).elementAt(0);
                var2.bL.onErrorReportEvent(var3);
            }

        }
    }

    static class e extends Handler {
        private final WeakReference<PDFViewCtrl> a;

        e(PDFViewCtrl var1) {
            this.a = new WeakReference(var1);
        }

        public final void handleMessage(Message var1) {
            PDFViewCtrl var2;
            if ((var2 = (PDFViewCtrl)this.a.get()) != null && var1.obj instanceof Vector) {
                Vector var9;
                PDFViewCtrl.DownloadState var3 = PDFViewCtrl.DownloadState.valueOf((Integer)(var9 = (Vector)var1.obj).elementAt(0));
                Long var4 = (Long)var9.elementAt(1);
                Integer var5 = (Integer)var9.elementAt(2);
                Integer var6 = (Integer)var9.elementAt(3);
                String var7 = (String)var9.elementAt(4);
                if ((Integer)var9.elementAt(5) != var2.cE) {
                    Log.i("UNIVERSAL", "Got Event for conversion but sequence number doesn't match");
                    return;
                }

                if (var3 != PDFViewCtrl.DownloadState.FAILED && !var2.e(var4)) {
                    return;
                }

                Iterator var10;
                if (var3 == PDFViewCtrl.DownloadState.PAGE) {
                    var2.cD.a(var4, var5, var6, var7);
                    if (!var2.ce.b && !var2.R) {
                        var2.cD.b();
                    }

                    if (var2.cD.a == null) {
                        var2.cg++;
                        if (var2.cg > var2.ch) {
                            var2.cg = var2.ch;
                        }
                    }
                } else if (var3 == PDFViewCtrl.DownloadState.THUMB) {
                    PDFViewCtrl.b(var2, var4, var5, var6);
                } else if (var3 == PDFViewCtrl.DownloadState.OUTLINE) {
                    PDFViewCtrl.c(var2, var4);
                } else if (var3 == PDFViewCtrl.DownloadState.FINISHED) {
                    var2.cD.f = var4;
                    if (!var2.ce.b && !var2.R) {
                        var2.cD.e();
                    }
                } else if (var3 == PDFViewCtrl.DownloadState.FAILED) {
                    if (var2.cD.a != null) {
                        var2.cD.d();
                        if (var2.bD != null) {
                            var10 = var2.bD.iterator();

                            while(var10.hasNext()) {
                                ((PDFViewCtrl.UniversalDocumentConversionListener)var10.next()).onConversionEvent(PDFViewCtrl.ConversionState.FAILED, 0);
                            }
                        }
                    }
                } else if (var3 == PDFViewCtrl.DownloadState.OPENED) {
                    PDFViewCtrl.d(var2, var4);

                    try {
                        PDFViewCtrl.e(var2, var4);
                    } catch (PDFNetException var8) {
                        var8.printStackTrace();
                    }
                }

                if (var3 == PDFViewCtrl.DownloadState.FINISHED || var3 == PDFViewCtrl.DownloadState.FAILED) {
                    PDFViewCtrl.n(var2, false);
                }

                if (var2.cD.a == null) {
                    if (var3 == PDFViewCtrl.DownloadState.PAGE || var3 == PDFViewCtrl.DownloadState.FINISHED || var3 == PDFViewCtrl.DownloadState.NAMED_DESTS || var3 == PDFViewCtrl.DownloadState.THUMB || var3 == PDFViewCtrl.DownloadState.OUTLINE || var3 == PDFViewCtrl.DownloadState.FAILED) {
                        if (var2.bC != null) {
                            var10 = var2.bC.iterator();

                            while(var10.hasNext()) {
                                ((PDFViewCtrl.DocumentDownloadListener)var10.next()).onDownloadEvent(var3, var5, var2.cg, var2.ch, var7);
                            }
                        }

                        if (var2.bS != null) {
                            var2.bS.onDocumentDownloadEvent(var3, var5, var2.cg, var2.ch, var7);
                        }
                    }

                    if (!var2.dd.hasMessages(0)) {
                        var2.dd.sendEmptyMessageDelayed(0, 200L);
                    }
                }
            }

        }
    }

    static class g extends Handler {
        private final WeakReference<PDFViewCtrl> a;

        g(PDFViewCtrl var1) {
            this.a = new WeakReference(var1);
        }

        public final void handleMessage(Message var1) {
            PDFViewCtrl var2;
            if ((var2 = (PDFViewCtrl)this.a.get()) != null && var1.obj instanceof Vector) {
                Vector var7;
                boolean var3 = (Boolean)(var7 = (Vector)var1.obj).elementAt(0);
                PDFViewCtrl.Selection var8 = (PDFViewCtrl.Selection)var7.elementAt(1);
                synchronized((PDFViewCtrl)this.a.get()) {
                    var2.by--;
                }

                if (var2.ds != null) {
                    var2.ds.interrupt();
                }

                var2.dr.removeMessages(0);
                if (var3) {
                    var2.selectWithSelection(var8);
                    if (!var2.isContinuousPagePresentationMode(var2.bV)) {
                        var2.r();
                    }

                    var2.scrollTo(var2.p(), var2.q());
                    var2.invalidate();
                    if (var2.bB != null) {
                        var2.bB.onTextSearchEnd(PDFViewCtrl.TextSearchResult.FOUND);
                        return;
                    }
                } else {
                    boolean var4 = false;
                    boolean var9 = false;
                    synchronized(this) {
                        if (var2.bz) {
                            PDFViewCtrl.l(var2, false);
                            var4 = true;
                        }

                        if (var2.bA) {
                            PDFViewCtrl.m(var2, false);
                            var9 = true;
                        }
                    }

                    if (var2.bB != null) {
                        if (var4) {
                            var2.bB.onTextSearchEnd(PDFViewCtrl.TextSearchResult.CANCELED);
                            return;
                        }

                        if (var9) {
                            var2.bB.onTextSearchEnd(PDFViewCtrl.TextSearchResult.INVALID_INPUT);
                            return;
                        }

                        var2.bB.onTextSearchEnd(PDFViewCtrl.TextSearchResult.NOT_FOUND);
                    }
                }
            }

        }
    }

    static class t extends Handler {
        private final WeakReference<PDFViewCtrl> a;

        t(PDFViewCtrl var1) {
            this.a = new WeakReference(var1);
        }

        public final void handleMessage(Message var1) {
            PDFViewCtrl var2;
            if ((var2 = (PDFViewCtrl)this.a.get()) != null && var2.bS != null) {
                var2.bS.onCustomEvent(var2.cf);
            }

        }
    }

    static class p extends Handler {
        private final WeakReference<PDFViewCtrl> a;

        p(PDFViewCtrl var1) {
            this.a = new WeakReference(var1);
        }

        public final void handleMessage(Message var1) {
            PDFViewCtrl var2;
            if ((var2 = (PDFViewCtrl)this.a.get()) != null && var2.bS != null) {
                var2.bS.onPostSingleTapConfirmed();
            }

        }
    }

    static class q extends Handler {
        private final WeakReference<PDFViewCtrl> a;

        q(PDFViewCtrl var1) {
            this.a = new WeakReference(var1);
        }

        public final void handleMessage(Message var1) {
            PDFViewCtrl var2;
            if ((var2 = (PDFViewCtrl)this.a.get()) != null) {
                var2.requestRendering();
            }

        }
    }

    static class h extends Handler {
        private final WeakReference<PDFViewCtrl> a;

        h(PDFViewCtrl var1) {
            this.a = new WeakReference(var1);
        }

        public final void handleMessage(Message var1) {
            PDFViewCtrl var2;
            if ((var2 = (PDFViewCtrl)this.a.get()) != null) {
                var2.onLongPress(var2.ae);
                if (VERSION.SDK_INT >= 18) {
                    var2.ac = true;
                }
            }

        }
    }

    static class l extends Handler {
        private final WeakReference<PDFViewCtrl> a;

        l(PDFViewCtrl var1) {
            this.a = new WeakReference(var1);
        }

        public final void handleMessage(Message var1) {
            PDFViewCtrl var2;
            if ((var2 = (PDFViewCtrl)this.a.get()) != null && var2.bO != null) {
                if (var1.what == 0) {
                    var2.bO.onRenderingStarted();
                    return;
                }

                var2.bO.onRenderingFinished();
            }

        }
    }

    static class b extends Handler {
        private final WeakReference<PDFViewCtrl> a;

        b(PDFViewCtrl var1) {
            this.a = new WeakReference(var1);
        }

        public final void handleMessage(Message var1) {
            PDFViewCtrl var5;
            if ((var5 = (PDFViewCtrl)this.a.get()) != null && var5.bF != null) {
                var5.bH = var5.getCurrentPage();
                if (var5.bG != var5.bH || var5.bI == PDFViewCtrl.PageChangeState.BEGIN || var5.bI == PDFViewCtrl.PageChangeState.END) {
                    if (var5.bG != var5.bH && var5.bI == PDFViewCtrl.PageChangeState.SILENT) {
                        var5.bI = PDFViewCtrl.PageChangeState.END;
                    }

                    int var2 = var5.bG;
                    var5.bG = var5.bH;
                    PDFViewCtrl.PageChangeState var3;
                    Iterator var6;
                    if ((var3 = var5.bI) == PDFViewCtrl.PageChangeState.BEGIN) {
                        var6 = var5.bF.iterator();

                        while(var6.hasNext()) {
                            ((PDFViewCtrl.PageChangeListener)var6.next()).onPageChange(var2, var2, PDFViewCtrl.PageChangeState.BEGIN);
                        }

                        var5.bI = PDFViewCtrl.PageChangeState.ONGOING;
                        return;
                    }

                    if (var3 == PDFViewCtrl.PageChangeState.ONGOING) {
                        var6 = var5.bF.iterator();

                        while(var6.hasNext()) {
                            ((PDFViewCtrl.PageChangeListener)var6.next()).onPageChange(var2, var5.bH, PDFViewCtrl.PageChangeState.ONGOING);
                        }

                        return;
                    }

                    if (var3 == PDFViewCtrl.PageChangeState.END) {
                        var5.bI = PDFViewCtrl.PageChangeState.SILENT;
                        var6 = var5.bF.iterator();

                        while(var6.hasNext()) {
                            ((PDFViewCtrl.PageChangeListener)var6.next()).onPageChange(var5.bH, var5.bH, PDFViewCtrl.PageChangeState.END);
                        }
                    }
                }
            }

        }
    }

    static class d extends Handler {
        private final WeakReference<PDFViewCtrl> a;

        d(PDFViewCtrl var1) {
            this.a = new WeakReference(var1);
        }

        public final void handleMessage(Message var1) {
            PDFViewCtrl var4;
            if ((var4 = (PDFViewCtrl)this.a.get()) != null) {
                if (var4.bJ != null && var4.bK) {
                    PDFViewCtrl.k(var4, false);
                    Iterator var2 = var4.bJ.iterator();

                    while(var2.hasNext()) {
                        ((PDFViewCtrl.DocumentLoadListener)var2.next()).onDocumentLoaded();
                    }
                }

                var4.cD.c();
            }

        }
    }

    static class k extends Handler {
        private final WeakReference<PDFViewCtrl> a;

        k(PDFViewCtrl var1) {
            this.a = new WeakReference(var1);
        }

        public final void a() {
            PDFViewCtrl var1;
            if ((var1 = (PDFViewCtrl)this.a.get()) != null) {
                PDFViewCtrl.j(var1, true);
                if (!this.hasMessages(0)) {
                    this.sendEmptyMessage(0);
                }
            }

        }

        public final void handleMessage(Message var1) {
            PDFViewCtrl var3;
            if ((var3 = (PDFViewCtrl)this.a.get()) != null && var3.cY != 0L) {
                var3.purgeMemory();

                try {
                    var3.update();
                    return;
                } catch (PDFNetException var2) {
                }
            }

        }
    }

    static class m extends Handler {
        private final WeakReference<PDFViewCtrl> a;

        m(PDFViewCtrl var1) {
            this.a = new WeakReference(var1);
        }

        public final void handleMessage(Message var1) {
            PDFViewCtrl var2;
            if ((var2 = (PDFViewCtrl)this.a.get()) != null) {
                var2.requestRendering();
                if (var1.what == 1 && var2.bS != null) {
                    var2.bS.onRenderingFinished();
                }
            }

        }
    }

    static class i extends Handler {
        private final WeakReference<PDFViewCtrl> a;

        i(PDFViewCtrl var1) {
            this.a = new WeakReference(var1);
        }

        public final void handleMessage(Message var1) {
            PDFViewCtrl var2;
            if ((var2 = (PDFViewCtrl)this.a.get()) != null) {
                PDFViewCtrl.L(var2);
                this.sendEmptyMessageDelayed(0, (long)var2.P);
            }

        }
    }

    class RenderCallback {
        private static final int TILE_TYPE_FINAL_RENDER = 0;
        private static final int TILE_TYPE_PROGRESSIVE_RENDER = 1;
        private static final int TILE_TYPE_OFFSCREEN_RENDER = 2;
        private static final int TILE_TYPE_LOW_RES_PREVIEW = 3;
        private static final int ANNOT_OPERATION_NORMAL_ANNOT_BITMAP = 1;
        private static final int ANNOT_OPERATION_MULT_BLEND_ANNOT_BITMAP = 2;
        private static final int ANNOT_OPERATION_NORMAL_ANNOT_VECTOR = 3;
        private static final int ANNOT_OPERATION_MULT_BLEND_ANNOT_VECTOR = 4;
        private static final int ANNOT_OPERATION_RESIZE_ANNOT_BITMAP = 128;
        private static final int ANNOT_OPERATION_REMOVE_ANNOT_BITMAP = 129;
        private static final int ANNOT_OPERATION_CLEAR_ALL_ANNOT_BITMAPS = 130;
        private static final int ANNOT_OPERATION_ANNOT_RENDERS_COMPLETE = 131;
        private static final int ANNOT_OPERATION_REINDEX_ANNOT_BITMAP = 132;

        RenderCallback() {
        }

        @SuppressLint({"DefaultLocale"})
        private void AnnotBitmapProc(PDFViewCtrl var1, int var2, int[] var3, int var4, int var5, int var6, int var7, int var8, long var9, long var11, long var13, int var15, int var16, int var17, int var18) {
            if (PDFViewCtrl.a) {
                Log.d("annotlayer", "operation: " + var2);
                Log.d("annotlayer", String.format("w: %d, h: %d, pg: %d", var4, var5, var7));
                Log.d("annotlayer", String.format("annot_index %d, key %d, x: %d, y: %d, xOff: %d, yOff: %d", var8, var9, var11, var13, var15, var16));
            }

            if (var2 == 128) {
                if (PDFViewCtrl.this.l.a(var18)) {
                    PDFViewCtrl.this.j.lock();

                    try {
                        PDFViewCtrl.this.l.a(var9, var7, (long)var15, (long)var16, (int)var11, (int)var13, var4, var5);
                        return;
                    } catch (Exception var44) {
                        if (PDFViewCtrl.a) {
                            var44.printStackTrace();
                        }
                    } finally {
                        PDFViewCtrl.this.j.unlock();
                    }

                }
            } else if (var2 == 132) {
                if (PDFViewCtrl.this.l.a(var18)) {
                    PDFViewCtrl.this.j.lock();

                    try {
                        PDFViewCtrl.this.l.a(var9, var7, var4);
                        return;
                    } catch (Exception var46) {
                        if (PDFViewCtrl.a) {
                            var46.printStackTrace();
                        }
                    } finally {
                        PDFViewCtrl.this.j.unlock();
                    }

                }
            } else if (var2 == 129) {
                this.removeTileProc(-1, var9, var7, var18, 1);
            } else if (var2 == 130) {
                this.removeTileProc(-1, -1L, -1, var18, 1);
            } else if (var2 == 131) {
                PDFViewCtrl.this.dd.sendEmptyMessage(0);
                PDFViewCtrl.this.postInvalidate();
            } else if (PDFViewCtrl.this.A) {
                if (PDFViewCtrl.b) {
                    PDFViewCtrl.a(4, String.format("Ignore annotation %d due to out of memory", var8), PDFViewCtrl.a(false));
                } else {
                    Log.e("PDFNet", String.format("Ignore annotation %d due to out of memory", var8));
                }
            } else if (!PDFViewCtrl.this.f() || var7 < PDFViewCtrl.this.p || var7 > PDFViewCtrl.this.q) {
                if (var3 != null && var3.length != 0) {
                    Bitmap var51 = null;
                    CurvePainter var53 = null;
                    if (var2 != 1 && var2 != 2) {
                        if (var2 == 3 || var2 == 4) {
                            (var53 = new CurvePainter(var3)).setMultBlend(var2 == 4);
                            var53.setRect(new Rect((int)var11, (int)var13, (int)(var11 + (long)var15), (int)(var13 + (long)var16)));
                        }
                    } else {
                        if ((var51 = com.pdftron.pdf.ImageCache.a.a().a(var4, var5)) == null) {
                            try {
                                var51 = Bitmap.createBitmap(var3, var4, var5, Config.ARGB_8888);
                            } catch (OutOfMemoryError var43) {
                                if (PDFViewCtrl.b) {
                                    PDFViewCtrl.a(4, "Can't create bitmap due to out of memory:" + var8, PDFViewCtrl.a(false));
                                } else {
                                    Log.e("PDFNet", "Can't create bitmap due to out of memory:" + var8);
                                }

                                PDFViewCtrl.this.de.a();
                                return;
                            }
                        } else {
                            var51.setPixels(var3, 0, var4, 0, 0, var4, var5);
                        }

                        (var53 = new CurvePainter(var51)).setRect(new Rect((int)((double)var15 + 0.5D), (int)((double)var16 + 0.5D), (int)((double)(var15 + var4) + 0.5D), (int)((double)(var16 + var5) + 0.5D)));
                    }

                    PDFViewCtrl.this.j.lock();
                    if (PDFViewCtrl.a) {
                        Log.i("annotlayer", String.format("Got tile: page %d - index %d - sequence %d", var7, var8, var18));
                    }

                    try {
                        Log.d("annotlayer", "addTile core w: " + var4 + " h:" + var5);
                        boolean var52 = var2 == 2 || var2 == 4;
                        PDFViewCtrl.this.l.a(var9, var7, (long)var15, (long)var16, (int)var11, (int)var13, var4, var5, var51, var53, var18, 1, var52, var8);
                    } catch (Exception var48) {
                        if (PDFViewCtrl.a) {
                            var48.printStackTrace();
                        }
                    } catch (OutOfMemoryError var49) {
                        if (PDFViewCtrl.b) {
                            PDFViewCtrl.a(4, "Will invoke purge memory when batch of tiles is done", PDFViewCtrl.a(false));
                        } else {
                            Log.e("PDFNet", "Will invoke purge memory when batch of tiles is done");
                        }

                        PDFViewCtrl.this.de.a();
                    } finally {
                        PDFViewCtrl.this.j.unlock();
                    }

                    if (PDFViewCtrl.this.bS != null) {
                        PDFViewCtrl.this.bS.onAnnotPainterUpdated(var7, var9, CurvePainter.create(var53));
                    }

                } else {
                    if (PDFViewCtrl.b) {
                        PDFViewCtrl.a(4, String.format("Null buffer, will invoke purge memory", var8), PDFViewCtrl.a(false));
                    } else {
                        Log.e("PDFNet", "not enough memory to allocate the bitmap");
                    }

                    PDFViewCtrl.this.de.a();
                }
            }
        }

        @SuppressLint({"DefaultLocale"})
        private void DeluxeCreateTileProc(PDFViewCtrl var1, int[] var2, int var3, int var4, int var5, int var6, long var7, long var9, int var11, int var12, int var13, int var14, int var15, int var16, int var17) {
            if (PDFViewCtrl.this.A) {
                if (PDFViewCtrl.b) {
                    PDFViewCtrl.a(4, String.format("Ignore Tile %d due to out of memory", var11), PDFViewCtrl.a(false));
                } else {
                    Log.e("PDFNet", String.format("Ignore Tile %d due to out of memory", var11));
                }
            } else if (!PDFViewCtrl.this.f() || var16 == 3 || var6 < PDFViewCtrl.this.p || var6 > PDFViewCtrl.this.q) {
                if (var2 != null && var2.length != 0) {
                    Bitmap var63;
                    if ((var63 = com.pdftron.pdf.ImageCache.a.a().a(var3, var4)) == null) {
                        try {
                            var63 = Bitmap.createBitmap(var2, var3, var4, Config.ARGB_8888);
                        } catch (OutOfMemoryError var56) {
                            if (PDFViewCtrl.b) {
                                PDFViewCtrl.a(4, "Can't create bitmap due to out of memory:" + var11, PDFViewCtrl.a(false));
                            } else {
                                Log.e("PDFNet", "Can't create bitmap due to out of memory:" + var11);
                            }

                            PDFViewCtrl.this.de.a();
                            return;
                        }
                    } else {
                        var63.setPixels(var2, 0, var3, 0, 0, var3, var4);
                    }

                    com.pdftron.pdf.Rect var64 = null;
                    com.pdftron.pdf.Rect var65 = null;
                    if (var16 == 3) {
                        label659: {
                            boolean var18 = false;
                            boolean var55 = false;

                            label645: {
                                try {
                                    var55 = true;
                                    new com.pdftron.pdf.Rect();
                                    new com.pdftron.pdf.Rect();
                                    PDFViewCtrl.this.docLockRead();
                                    var18 = true;
                                    Page var19;
                                    var64 = (var19 = PDFViewCtrl.this.getDoc().getPage(var6)).getCropBox();
                                    var65 = var19.getBox(PDFViewCtrl.this.getPageBox());
                                    var55 = false;
                                    break label645;
                                } catch (Exception var61) {
                                    var55 = false;
                                } finally {
                                    if (var55) {
                                        if (var18) {
                                            PDFViewCtrl.this.docUnlockRead();
                                        }

                                    }
                                }

                                if (var18) {
                                    PDFViewCtrl.this.docUnlockRead();
                                }
                                break label659;
                            }

                            PDFViewCtrl.this.docUnlockRead();
                        }
                    }

                    PDFViewCtrl.this.j.lock();
                    if (PDFViewCtrl.a) {
                        Log.i("TILES", String.format("Got tile: page %d - id %d - sequence %d", var6, var11, var17));
                    }

                    if (!PDFViewCtrl.this.l.b) {
                        PDFViewCtrl.this.l.b = true;
                        PDFViewCtrl.this.l.a = var17 - 1;
                    }

                    try {
                        if (var16 != 3) {
                            if (PDFViewCtrl.this.l.c(var14) == null) {
                                PDFViewCtrl.this.l.b(var14);
                            }

                            com.pdftron.pdf.f var10000 = PDFViewCtrl.this.l;
                            long var27 = (long)var11;
                            var10000.a(var27, var6, var7, var9, var12, var13, var3, var4, var63, (CurvePainter)null, var17, 0, false, -1);
                        } else {
                            PDFViewCtrl.this.m.a(var6, var63, var64, var65);
                            if (PDFViewCtrl.a) {
                                Log.d(PDFViewCtrl.c, "received thumbnails for page: " + var6);
                            }
                        }
                    } catch (Exception var58) {
                        if (PDFViewCtrl.a) {
                            var58.printStackTrace();
                        }
                    } catch (OutOfMemoryError var59) {
                        if (PDFViewCtrl.b) {
                            PDFViewCtrl.a(4, "Will invoke purge memory when batch of tiles is done", PDFViewCtrl.a(false));
                        } else {
                            Log.e("PDFNet", "Will invoke purge memory when batch of tiles is done");
                        }

                        PDFViewCtrl.this.de.a();
                    } finally {
                        PDFViewCtrl.this.j.unlock();
                    }

                    if (var16 == 3) {
                        PDFViewCtrl.this.postInvalidate();
                    } else if (var15 == 0) {
                        PDFViewCtrl.this.k.lock();

                        try {
                            PDFViewCtrl.a((PDFViewCtrl)PDFViewCtrl.this, true);
                            Rect var66;
                            if ((var66 = (Rect)PDFViewCtrl.this.J.get(var6)) != null) {
                                if (PDFViewCtrl.this.i != null && !PDFViewCtrl.this.i.a()) {
                                    PDFViewCtrl.this.K.add(var6);
                                } else {
                                    com.pdftron.pdf.b.a.a().a(var66);
                                    PDFViewCtrl.this.J.remove(var6);
                                    if (PDFViewCtrl.this.J.size() == 0) {
                                        PDFViewCtrl.this.K.clear();
                                    }
                                }
                            }
                        } finally {
                            PDFViewCtrl.this.k.unlock();
                        }

                        if (var16 == 0) {
                            PDFViewCtrl.this.dd.sendEmptyMessage(1);
                        }

                        PDFViewCtrl.this.postInvalidate();
                    }

                    if (PDFViewCtrl.b || PDFViewCtrl.a) {
                        MemoryInfo var67 = new MemoryInfo();
                        ActivityManager var68;
                        if ((var68 = (ActivityManager)PDFViewCtrl.this.getContext().getSystemService("activity")) != null) {
                            var68.getMemoryInfo(var67);
                            if (PDFViewCtrl.b) {
                                PDFViewCtrl.a(1, "available memory size: " + var67.availMem / 1048576L + "MB, " + "native heap allocated size: " + Debug.getNativeHeapAllocatedSize() / 1048576L + "MB", PDFViewCtrl.a(false));
                            }
                        }

                        if (PDFViewCtrl.a) {
                            Log.v("MemorySize", "available memory size: " + var67.availMem / 1048576L + "MB");
                            Log.v("MemorySize", "native heap allocated size: " + Debug.getNativeHeapAllocatedSize() / 1048576L + "MB");
                        }
                    }

                } else {
                    if (PDFViewCtrl.b) {
                        PDFViewCtrl.a(4, String.format("Null buffer, will invoke purge memory", var11), PDFViewCtrl.a(false));
                    } else {
                        Log.e("PDFNet", "not enough memory to allocate the bitmap");
                    }

                    PDFViewCtrl.this.de.a();
                }
            }
        }

        private void CreateTileProc(PDFViewCtrl var1, int[] var2, int var3, int var4, int var5, int var6, int var7, long var8, boolean var10, boolean var11, int var12, boolean var13, int var14, int var15, int var16, int var17, int var18, int var19) {
        }

        private void RemoveTileProc(int var1, long var2, int var4, int var5) {
            this.removeTileProc(var1, var2, var4, var5, 0);
        }

        private void removeTileProc(int var1, long var2, int var4, int var5, int var6) {
            PDFViewCtrl.this.j.lock();
            boolean var7 = true;
            if (var6 == 0) {
                PDFViewCtrl.this.l.b = true;
                PDFViewCtrl.this.l.a = var5;
            } else if (var6 == 1 && !PDFViewCtrl.this.l.a(var5)) {
                return;
            }

            boolean var12 = false;

            try {
                var12 = true;
                if (var4 > 0 && var2 <= 0L) {
                    try {
                        PDFViewCtrl.this.m.b(var4);
                        if (PDFViewCtrl.a) {
                            Log.i("TILES", String.format("Removing thumb - id %d, thumb count %d, doc %s", var4, PDFViewCtrl.this.m.a(), PDFViewCtrl.this.mDoc.getFileName()));
                        }
                    } finally {
                        PDFViewCtrl.this.j.unlock();
                        var7 = false;
                    }

                    return;
                }

                if (PDFViewCtrl.this.l.d(var6)) {
                    PDFViewCtrl.this.j.unlock();
                    return;
                }

                try {
                    if (var1 < 0 && var2 < 0L) {
                        if (PDFViewCtrl.a) {
                            Log.i("TILES", String.format("Removing all tiles - sequence %d, doc %s", var5, PDFViewCtrl.this.mDoc.getFileName()));
                        }

                        PDFViewCtrl.this.l.e(var6);
                        if (var6 == 1) {
                            PDFViewCtrl.this.l.c = var5;
                        }
                    } else if (var1 < 0 && var2 >= 0L && var4 > 0) {
                        if (var6 == 1) {
                            PDFViewCtrl.this.l.a(var4, var2, var5, var6);
                        }
                    } else if (var1 > 0 && var2 < 0L) {
                        double[] var25 = PDFViewCtrl.this.e(var1);
                        int var26 = 0;

                        for(int var3 = var25.length; var26 < var3; var26 += 5) {
                            if (PDFViewCtrl.a) {
                                Log.i("TILES", String.format("Removing page %d - sequence %d, doc %s", (int)var25[var26], var5, PDFViewCtrl.this.mDoc.getFileName()));
                            }

                            PDFViewCtrl.this.l.a((int)var25[var26], var6);
                        }
                    } else if (var1 >= 0 && var2 >= 0L) {
                        PDFViewCtrl.this.l.a(var4, var2, var5, var6);
                        if (PDFViewCtrl.a) {
                            Log.i("TILES", String.format("Removing page %d - id %d, sequence %d, tile count %d, doc %s", var4, var2, var5, PDFViewCtrl.this.l.c(), PDFViewCtrl.this.mDoc.getFileName()));
                        }
                    }
                } finally {
                    PDFViewCtrl.this.j.unlock();
                    var7 = false;
                }

                var12 = false;
                return;
            } catch (Exception var23) {
                Log.e("TILES", "Error in remove tile proc!!!! " + var23.toString());
                var12 = false;
            } finally {
                if (var12) {
                    if (var7) {
                        PDFViewCtrl.this.j.unlock();
                    }

                }
            }

            if (var7) {
                PDFViewCtrl.this.j.unlock();
            }
        }

        private long GetAvailableTileBytes() {
            return PDFViewCtrl.this.b();
        }

        private void RenderBegin(PDFViewCtrl var1, boolean var2) {
            PDFViewCtrl.this.dc.removeMessages(0);
            PDFViewCtrl.this.dc.sendEmptyMessageDelayed(0, (long)PDFViewCtrl.this.O);
            if (var2 && PDFViewCtrl.this.bO != null) {
                PDFViewCtrl.this.dh.sendEmptyMessage(0);
            }

        }

        private void RenderEnd(boolean var1) {
            PDFViewCtrl.this.dc.removeMessages(0);
            if (var1 && PDFViewCtrl.this.bO != null) {
                PDFViewCtrl.this.dh.sendEmptyMessage(1);
            }

        }

        private void FindTextProcCallback(boolean var1, long var2) {
            Thread.yield();
            Message var4;
            (var4 = new Message()).setTarget(PDFViewCtrl.this.dm);
            PDFViewCtrl.Selection var5 = PDFViewCtrl.this.new Selection(PDFViewCtrl.this, var2, PDFViewCtrl.this, (byte)0);
            Vector var3;
            (var3 = new Vector()).add(var1);
            var3.add(var5);
            var4.obj = var3;
            var4.sendToTarget();
        }

        private void PartDownloadedProcCallback(int var1, long var2, int var4, int var5, String var6, PDFViewCtrl var7) {
            Thread.yield();
            Message var9;
            (var9 = new Message()).setTarget(PDFViewCtrl.this.dn);
            Vector var8;
            (var8 = new Vector()).add(var1);
            var8.add(var2);
            var8.add(var4);
            var8.add(var5);
            var8.add(var6);
            var8.add(PDFViewCtrl.this.cE);
            var9.obj = var8;
            var9.sendToTarget();
        }

        private void ErrorReportProcCallback(String var1) {
            Thread.yield();
            Message var2;
            (var2 = new Message()).setTarget(PDFViewCtrl.this.doo);
            Vector var3;
            (var3 = new Vector()).add(var1);
            var2.obj = var3;
            var2.sendToTarget();
        }

        private void ThumbAsyncHandlerProc(int var1, boolean var2, int[] var3, int var4, int var5) {
            Thread.yield();
            Message var6;
            (var6 = new Message()).setTarget(PDFViewCtrl.this.dp);
            if (var2) {
                Vector var7;
                (var7 = new Vector()).add(var1);
                var7.add(var3);
                var7.add(var4);
                var7.add(var5);
                var6.obj = var7;
                var6.sendToTarget();
            }

        }

        private void OnRequestRenderInWorkerThreadCallback() {
        }

        private void DoActionCompletedCallback(PDFViewCtrl var1, long var2) {
            Thread.yield();
            Action var4 = new Action(var2, (Object)null);
            Message var5;
            (var5 = new Message()).setTarget(PDFViewCtrl.this.dq);
            Vector var3;
            (var3 = new Vector()).add(var4);
            var5.obj = var3;
            var5.sendToTarget();
        }
    }

    public static class PrivateDownloader {
        protected PrivateDownloader() {
        }

        protected static void partDownloadRequested(long var0, long var2) {
            if (var0 != 0L && var2 != 0L) {
                Boolean var4 = false;
                String var5 = "";
                Obj var28 = Obj.__Create(var0, (Object)null);
                Obj var1 = Obj.__Create(var2, (Object)null);
                HttpURLConnection var31 = null;
                boolean var18 = false;

                label410: {
                    label411: {
                        label412: {
                            label413: {
                                try {
                                    var18 = true;
                                    Obj var3;
                                    if ((var3 = var28.findObj("url")) == null) {
                                        var18 = false;
                                        break label410;
                                    }

                                    String var6 = var3.getAsPDFText();
                                    String var32 = var28.findObj("method").getAsPDFText();
                                    var31 = (HttpURLConnection)(new URL(var6)).openConnection();
                                    if (var32.equalsIgnoreCase("head")) {
                                        var31.setRequestMethod("HEAD");
                                    } else {
                                        if (!var32.equalsIgnoreCase("get")) {
                                            var1.putString("message", "Unsupported HTTP Method called");
                                            var18 = false;
                                            break label412;
                                        }

                                        var31.setRequestMethod("GET");
                                        var4 = true;
                                    }

                                    if ((var3 = var28.findObj("headers")) != null) {
                                        DictIterator var29 = var3.getDictIterator();

                                        while(var29.hasNext()) {
                                            var6 = var29.key().getName();
                                            String var7 = var29.value().getAsPDFText();
                                            var31.setRequestProperty(var6, var7);
                                            var29.next();
                                        }
                                    }

                                    int var30 = var31.getResponseCode();
                                    var1.putNumber("status", (double)var30);
                                    var3 = var1.putDict("headers");
                                    Iterator var34 = var31.getHeaderFields().entrySet().iterator();

                                    while(var34.hasNext()) {
                                        var6 = (String)((Entry)var34.next()).getKey();
                                        String var8 = var31.getHeaderField(var6);
                                        var3.putString(var6, var8);
                                    }

                                    if (var4) {
                                        if (var30 != 200 && var30 != 206) {
                                            var18 = false;
                                        } else {
                                            int var33;
                                            byte[] var35;
                                            if ((var33 = var31.getContentLength()) > 0) {
                                                var35 = new byte[var33];
                                                (new DataInputStream(var31.getInputStream())).readFully(var35);
                                            } else {
                                                var35 = PDFViewCtrl.a(var31.getInputStream());
                                            }

                                            if (var35 != null) {
                                                var1.putString("response_body", var35);
                                                var1.putNumber("response_length", (double)var35.length);
                                                var18 = false;
                                            } else {
                                                var18 = false;
                                            }
                                        }
                                    } else {
                                        var18 = false;
                                    }
                                    break label413;
                                } catch (IOException var25) {
                                    if (var31 != null) {
                                        var5 = PDFViewCtrl.c(var31.getErrorStream());
                                        Log.e("PDFNet", var5);
                                        var18 = false;
                                    } else {
                                        var18 = false;
                                    }
                                } catch (Exception var26) {
                                    if ((var5 = var26.getMessage()) != null) {
                                        Log.e("PDFNet", var5);
                                        var18 = false;
                                        break label411;
                                    }

                                    var18 = false;
                                    break label411;
                                } finally {
                                    if (var18) {
                                        if (var31 != null) {
                                            var31.disconnect();
                                        }

                                        try {
                                            if (var5 != null && var5.length() > 0) {
                                                var1.putNumber("status", 400.0D);
                                                var1.putString("message", var5);
                                            }
                                        } catch (Exception var22) {
                                            if ((var5 = var22.getMessage()) != null) {
                                                Log.e("PDFNet", var22.getMessage() + "\n" + var5);
                                            }
                                        }

                                    }
                                }

                                if (var31 != null) {
                                    var31.disconnect();
                                }

                                try {
                                    if (var5 != null && var5.length() > 0) {
                                        var1.putNumber("status", 400.0D);
                                        var1.putString("message", var5);
                                    }

                                    return;
                                } catch (Exception var20) {
                                    if ((var5 = var20.getMessage()) != null) {
                                        Log.e("PDFNet", var20.getMessage() + "\n" + var5);
                                    }

                                    return;
                                }
                            }

                            if (var31 != null) {
                                var31.disconnect();
                            }

                            try {
                                if (var5.length() > 0) {
                                    var1.putNumber("status", 400.0D);
                                    var1.putString("message", var5);
                                }

                                return;
                            } catch (Exception var24) {
                                if ((var5 = var24.getMessage()) != null) {
                                    Log.e("PDFNet", var24.getMessage() + "\n" + var5);
                                }

                                return;
                            }
                        }

                        if (var31 != null) {
                            var31.disconnect();
                        }

                        try {
                            if (var5.length() > 0) {
                                var1.putNumber("status", 400.0D);
                                var1.putString("message", var5);
                            }

                            return;
                        } catch (Exception var21) {
                            if ((var5 = var21.getMessage()) != null) {
                                Log.e("PDFNet", var21.getMessage() + "\n" + var5);
                            }

                            return;
                        }
                    }

                    if (var31 != null) {
                        var31.disconnect();
                    }

                    try {
                        if (var5 != null && var5.length() > 0) {
                            var1.putNumber("status", 400.0D);
                            var1.putString("message", var5);
                        }

                        return;
                    } catch (Exception var23) {
                        if ((var5 = var23.getMessage()) != null) {
                            Log.e("PDFNet", var23.getMessage() + "\n" + var5);
                        }

                        return;
                    }
                }

                try {
                    if (var5.length() > 0) {
                        var1.putNumber("status", 400.0D);
                        var1.putString("message", var5);
                    }

                } catch (Exception var19) {
                    if ((var5 = var19.getMessage()) != null) {
                        Log.e("PDFNet", var19.getMessage() + "\n" + var5);
                    }

                }
            }
        }
    }

    static class u {
        DocumentConversion a = null;
        int b = -1;
        private final WeakReference<PDFViewCtrl> c;
        private Queue<PDFViewCtrl.u.a> d = new LinkedList();
        private Handler e = new Handler();
        private long f = 0L;
        private boolean g = false;
        private com.pdftron.pdf.Rect h;
        private boolean i = false;
        private boolean j = false;

        u(PDFViewCtrl var1) {
            this.c = new WeakReference(var1);

            try {
                this.h = new com.pdftron.pdf.Rect();
            } catch (Exception var2) {
            }
        }

        final void a() {
            this.d();
            this.b = -1;
            this.i = false;
            this.a = null;
            this.d.clear();
            this.f = 0L;
            this.j = false;
            this.e.removeCallbacksAndMessages((Object)null);
        }

        final void a(long var1, int var3, int var4, String var5) {
            this.d.add(new PDFViewCtrl.u.a(var1, var3, var4, var5));
        }

        final void b() {
            if (this.d.size() > 0) {
                PDFViewCtrl var1;
                if ((var1 = (PDFViewCtrl)this.c.get()) == null) {
                    return;
                }

                int var2 = 0;
                boolean var3 = false;
                boolean var4 = false;

                try {
                    if (var4 = var1.docTryLockRead(50)) {
                        while(this.d.size() > 0) {
                            if (var2 >= 100 && var1.cD.a == null) {
                                var3 = true;
                                break;
                            }

                            PDFViewCtrl.u.a var5 = (PDFViewCtrl.u.a)this.d.remove();
                            var1.a(var5.a, var5.b, var5.c);
                            ++var2;
                        }
                    }
                } catch (PDFNetException var8) {
                } finally {
                    if (var4) {
                        var1.docUnlockRead();
                    }

                }

                if (var3) {
                    this.e.postDelayed(new Runnable() {
                        public final void run() {
                            PDFViewCtrl var1;
                            if ((var1 = (PDFViewCtrl)u.this.c.get()) != null) {
                                if (!var1.ce.b && !var1.R) {
                                    u.this.b();
                                }

                            }
                        }
                    }, 50L);
                }

                int var11 = var1.getPageCount();
                var1.ch = var11;
                if (var1.bD != null) {
                    Iterator var10 = var1.bD.iterator();

                    while(var10.hasNext()) {
                        ((PDFViewCtrl.UniversalDocumentConversionListener)var10.next()).onConversionEvent(PDFViewCtrl.ConversionState.PROGRESS, var11);
                    }
                }

                this.a(false);
                this.b = var11 + 1;
                PDFViewCtrl.h(var1);
                if (this.d.size() == 0) {
                    this.e();
                }

                if (!var1.dd.hasMessages(0)) {
                    var1.dd.sendEmptyMessageDelayed(0, 200L);
                }
            }

        }

        private void e() {
            if (this.f != 0L) {
                PDFViewCtrl var1;
                if ((var1 = (PDFViewCtrl)this.c.get()) == null) {
                    return;
                }

                PDFViewCtrl.a(var1, this.f);
                var1.cD.d();
                this.f = 0L;
                this.a(false);
                if (var1.cD.a != null && var1.bD != null) {
                    Iterator var3 = var1.bD.iterator();

                    while(var3.hasNext()) {
                        ((PDFViewCtrl.UniversalDocumentConversionListener)var3.next()).onConversionEvent(PDFViewCtrl.ConversionState.FINISHED, 0);
                    }
                }
            }

        }

        final void c() {
            this.d();

            try {
                PDFViewCtrl var1;
                if ((var1 = (PDFViewCtrl)this.c.get()) != null) {
                    if (this.f() && !this.g) {
                        var1.bP.onAddProgressIndicator();
                        this.g = true;
                        var1.bP.onProgressIndicatorPageVisibilityChanged(false);
                        this.i = false;
                    }

                }
            } catch (PDFNetException var2) {
            }
        }

        final void d() {
            PDFViewCtrl var1;
            if ((var1 = (PDFViewCtrl)this.c.get()) != null) {
                if (this.g && var1.bP != null) {
                    var1.bP.onRemoveProgressIndicator();
                    this.g = false;
                    this.i = false;
                }

            }
        }

        final void a(boolean var1) {
            PDFViewCtrl var2;
            if ((var2 = (PDFViewCtrl)this.c.get()) != null) {
                try {
                    if (!this.f() || !var1 || this.j) {
                        if (!var1 && this.j && var2.bP != null) {
                            var2.bP.onRemoveContentPendingIndicator();
                            this.j = false;
                        }

                        return;
                    }

                    var2.bP.onShowContentPendingIndicator();
                    this.j = true;
                } catch (PDFNetException var3) {
                }

            }
        }

        private boolean f() throws PDFNetException {
            PDFViewCtrl var1 = (PDFViewCtrl)this.c.get();
            return this.a != null && this.a.getConversionStatus() == 1 && var1 != null && var1.bP != null;
        }

        static class a {
            long a;
            int b;
            int c;

            a(long var1, int var3, int var4, String var5) {
                this.a = var1;
                this.b = var3;
                this.c = var4;
            }
        }
    }

    public static class LinkInfo {
        private String mUrl = "";
        private double mX1 = 0.0D;
        private double mX2 = 0.0D;
        private double mY1 = 0.0D;
        private double mY2 = 0.0D;

        private LinkInfo() {
        }

        public String getURL() {
            return this.mUrl;
        }

        public com.pdftron.pdf.Rect getRect() {
            try {
                return new com.pdftron.pdf.Rect(this.mX1, this.mY1, this.mX2, this.mY2);
            } catch (PDFNetException var1) {
                return null;
            }
        }
    }

    public class Selection {
        private long a;

        public int getPageNum() {
            return PDFViewCtrl.SelectionGetPageNum(this.a);
        }

        public double[] getQuads() {
            return PDFViewCtrl.SelectionGetQuads(this.a);
        }

        public String getAsUnicode() {
            return PDFViewCtrl.SelectionGetAsUnicode(this.a);
        }

        public String getAsHtml() {
            return PDFViewCtrl.SelectionGetAsHtml(this.a);
        }

        private Selection(PDFViewCtrl var1, long var2, Object var4) {
            this.a = var2;
        }
    }

    public static class HTTPRequestOptions {
        Obj a;
        private ObjSet b;

        public HTTPRequestOptions() {
            try {
                this.b = new ObjSet();
                this.a = this.b.createDict();
            } catch (PDFNetException var1) {
                System.err.println("Error Occurred when creating HTTPRequestOptions.");
            }
        }

        public void addHeader(String var1, String var2) throws PDFNetException {
            this.a.putText(var1, var2);
        }

        public void restrictDownloadUsage(boolean var1) throws PDFNetException {
            this.a.putBool("MINIMAL_DOWNLOAD", var1);
        }

        public void skipByteRangeTest(boolean var1) throws PDFNetException {
            this.a.putBool("SKIP_BYTE_RANGE_TEST", var1);
        }

        public void useRemoteFileSize(long var1) throws PDFNetException {
            this.a.putNumber("FORCE_REMOTE_SIZE", (double)var1);
        }
    }

    public interface ToolManager {
        void onControlReady();

        void onClose();

        void onCustomEvent(Object var1);

        boolean onKeyUp(int var1, KeyEvent var2);

        boolean onDoubleTap(MotionEvent var1);

        boolean onDoubleTapEvent(MotionEvent var1);

        void onDoubleTapEnd(MotionEvent var1);

        boolean onDown(MotionEvent var1);

        boolean onPointerDown(MotionEvent var1);

        void onDocumentDownloadEvent(PDFViewCtrl.DownloadState var1, int var2, int var3, int var4, String var5);

        void onDraw(Canvas var1, Matrix var2);

        boolean onFlingStop();

        void onLayout(boolean var1, int var2, int var3, int var4, int var5);

        boolean onLongPress(MotionEvent var1);

        boolean onMove(MotionEvent var1, MotionEvent var2, float var3, float var4);

        void onScrollChanged(int var1, int var2, int var3, int var4);

        void onPageTurning(int var1, int var2);

        boolean onScale(float var1, float var2);

        boolean onScaleBegin(float var1, float var2);

        boolean onScaleEnd(float var1, float var2);

        void onSetDoc();

        boolean onShowPress(MotionEvent var1);

        boolean onSingleTapConfirmed(MotionEvent var1);

        void onPostSingleTapConfirmed();

        boolean onSingleTapUp(MotionEvent var1);

        boolean onUp(MotionEvent var1, PDFViewCtrl.PriorEventMode var2);

        boolean onGenericMotionEvent(MotionEvent var1);

        void onChangePointerIcon(PointerIcon var1);

        void onConfigurationChanged(Configuration var1);

        boolean onDrawEdgeEffects(Canvas var1, int var2, int var3);

        void onReleaseEdgeEffects();

        void onPullEdgeEffects(int var1, float var2);

        void onDoubleTapZoomAnimationBegin();

        void onDoubleTapZoomAnimationEnd();

        void onRenderingFinished();

        boolean isCreatingAnnotation();

        void onDestroy();

        void onAnnotPainterUpdated(int var1, long var2, CurvePainter var4);
    }

    public interface UniversalDocumentProgressIndicatorListener {
        void onAddProgressIndicator();

        void onPositionProgressIndicatorPage(com.pdftron.pdf.Rect var1);

        void onProgressIndicatorPageVisibilityChanged(boolean var1);

        void onRemoveProgressIndicator();

        void onShowContentPendingIndicator();

        void onRemoveContentPendingIndicator();
    }

    public interface DocumentLoadListener {
        void onDocumentLoaded();
    }

    public interface TextSearchListener {
        void onTextSearchStart();

        void onTextSearchProgress(int var1);

        void onTextSearchEnd(PDFViewCtrl.TextSearchResult var1);
    }

    public interface RenderingListener {
        void onRenderingStarted();

        void onRenderingFinished();
    }

    public interface OnCanvasSizeChangeListener {
        void onCanvasSizeChanged();
    }

    public interface PageChangeListener {
        void onPageChange(int var1, int var2, PDFViewCtrl.PageChangeState var3);
    }

    public interface ActionCompletedListener {
        void onActionCompleted(Action var1);
    }

    public interface ThumbAsyncListener {
        void onThumbReceived(int var1, int[] var2, int var3, int var4);
    }

    public interface ErrorReportListener {
        void onErrorReportEvent(String var1);
    }

    public interface UniversalDocumentConversionListener {
        void onConversionEvent(PDFViewCtrl.ConversionState var1, int var2);
    }

    public interface DocumentDownloadListener {
        void onDownloadEvent(PDFViewCtrl.DownloadState var1, int var2, int var3, int var4, String var5);
    }

    public static enum ConversionState {
        FINISHED(0),
        PROGRESS(1),
        FAILED(2);

        private final int a;

        private ConversionState(int var3) {
            this.a = var3;
        }

        public final int getValue() {
            return this.a;
        }
    }

    public static enum DownloadState {
        PAGE(0),
        THUMB(1),
        NAMED_DESTS(2),
        OUTLINE(3),
        FINISHED(4),
        FAILED(5),
        OPENED(6);

        private final int a;
        private static SparseArray<PDFViewCtrl.DownloadState> b = new SparseArray(7);

        private DownloadState(int var3) {
            this.a = var3;
        }

        public final int getValue() {
            return this.a;
        }

        public static PDFViewCtrl.DownloadState valueOf(int var0) {
            return (PDFViewCtrl.DownloadState)b.get(var0);
        }

        static {
            PDFViewCtrl.DownloadState[] var0;
            int var1 = (var0 = values()).length;

            for(int var2 = 0; var2 < var1; ++var2) {
                PDFViewCtrl.DownloadState var3 = var0[var2];
                b.put(var3.a, var3);
            }

        }
    }

    public static enum PageChangeState {
        BEGIN(-1),
        ONGOING(0),
        END(1),
        SILENT(0);

        private final int a;

        private PageChangeState(int var3) {
            this.a = var3;
        }

        public final int getValue() {
            return this.a;
        }
    }

    public static enum ZoomLimitMode {
        ABSOLUTE(1),
        RELATIVE(2),
        NONE(3);

        private final int a;

        private ZoomLimitMode(int var3) {
            this.a = var3;
        }

        public final int getValue() {
            return this.a;
        }
    }

    public static enum OverPrintMode {
        OFF(0),
        ON(1),
        PDFX(2);

        private final int a;

        private OverPrintMode(int var3) {
            this.a = var3;
        }

        public final int getValue() {
            return this.a;
        }
    }

    public static enum TextSelectionMode {
        STRUCTURAL(0),
        RECTANGULAR(1);

        private final int a;

        private TextSelectionMode(int var3) {
            this.a = var3;
        }

        public final int getValue() {
            return this.a;
        }
    }

    public static enum TextSearchResult {
        NOT_FOUND(0),
        FOUND(1),
        CANCELED(-1),
        INVALID_INPUT(2);

        private final int a;

        private TextSearchResult(int var3) {
            this.a = var3;
        }

        public final int getValue() {
            return this.a;
        }
    }

    public static enum PagePresentationMode {
        SINGLE(1),
        SINGLE_CONT(2),
        FACING(3),
        FACING_CONT(4),
        FACING_COVER(5),
        FACING_COVER_CONT(6),
        SINGLE_VERT(7),
        FACING_VERT(8),
        FACING_COVER_VERT(9);

        private final int a;
        private static SparseArray<PDFViewCtrl.PagePresentationMode> b = new SparseArray(7);

        private PagePresentationMode(int var3) {
            this.a = var3;
        }

        public final int getValue() {
            return this.a;
        }

        public static PDFViewCtrl.PagePresentationMode valueOf(int var0) {
            return (PDFViewCtrl.PagePresentationMode)b.get(var0);
        }

        static {
            PDFViewCtrl.PagePresentationMode[] var0;
            int var1 = (var0 = values()).length;

            for(int var2 = 0; var2 < var1; ++var2) {
                PDFViewCtrl.PagePresentationMode var3 = var0[var2];
                b.put(var3.a, var3);
            }

        }
    }

    public static enum PageViewMode {
        FIT_PAGE(0),
        FIT_WIDTH(1),
        FIT_HEIGHT(2),
        ZOOM(3),
        NOT_DEFINED(-1);

        private final int a;
        private static SparseArray<PDFViewCtrl.PageViewMode> b = new SparseArray(5);

        private PageViewMode(int var3) {
            this.a = var3;
        }

        public final int getValue() {
            return this.a;
        }

        public static PDFViewCtrl.PageViewMode valueOf(int var0) {
            return (PDFViewCtrl.PageViewMode)b.get(var0);
        }

        static {
            PDFViewCtrl.PageViewMode[] var0;
            int var1 = (var0 = values()).length;

            for(int var2 = 0; var2 < var1; ++var2) {
                PDFViewCtrl.PageViewMode var3 = var0[var2];
                b.put(var3.a, var3);
            }

        }
    }

    public static enum PriorEventMode {
        SCROLLING(1),
        PINCH(2),
        FLING(3),
        DOUBLE_TAP(4),
        PAGE_SLIDING(5),
        OTHER(0);

        private final int a;

        private PriorEventMode(int var3) {
            this.a = var3;
        }

        public final int getValue() {
            return this.a;
        }
    }

    static enum n {
        a = 1,
        b = 2,
        c = 3,
        d = 4;
    }

    static enum o {
        a = 1,
        b = 2,
        c = 3,
        d = 4;

        public static int[] a() {
            return (int[])e.clone();
        }
    }
}
