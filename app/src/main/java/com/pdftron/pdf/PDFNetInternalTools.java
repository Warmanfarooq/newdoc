//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;

public class PDFNetInternalTools {
    public static final int e_debugger = 0;
    public static final int e_disk = 1;
    public static final int e_callback = 2;
    public static final int e_console = 3;
    public static final int e_trace = 0;
    public static final int e_debug = 1;
    public static final int e_info = 2;
    public static final int e_warning = 3;
    public static final int e_error = 4;
    public static final int e_fatal = 5;
    public static final int e_disabled = 6;
//    private static AnalyticsHandlerCallback a = null;
//    private static AssertHandlerCallback b = null;

    private PDFNetInternalTools() {
    }

    public static boolean isLogSystemAvailable() throws PDFNetException {
        return IsLogSystemAvailable();
    }

    public static boolean configureLogFromJsonString(String var0) throws PDFNetException {
        return ConfigureLogFromJsonString(var0);
    }

    public static String getDefaultConfigFile() throws PDFNetException {
        return GetDefaultConfigFile();
    }

    public static String runUniversalConversionTests(String var0) throws PDFNetException {
        return RunUniversalConversionTests(var0);
    }

    public static void logMessage(int var0, String var1, String var2, int var3) throws PDFNetException {
        LogMessage(var0, var1, var2, var3);
    }

    public static void logStreamMessage(int var0, String var1, String var2, String var3, int var4) throws PDFNetException {
        LogStreamMessage(var0, var1, var2, var3, var4);
    }

    public static boolean setLogLocation(String var0, String var1) throws PDFNetException {
        return SetLogLocation(var0, var1);
    }

    public static boolean setLogFileName(String var0) throws PDFNetException {
        return SetLogFileName(var0);
    }

    public static void setThresholdForLogStream(String var0, int var1) throws PDFNetException {
        SetThresholdForLogStream(var0, var1);
    }

    public static void setDefaultLogThreshold(int var0) throws PDFNetException {
        SetDefaultLogThreshold(var0);
    }

    public static void setCutoffLogThreshold(int var0) throws PDFNetException {
        SetCutoffLogThreshold(var0);
    }

    public static boolean enableLogBackend(int var0) throws PDFNetException {
        return EnableLogBackend(var0);
    }

    public static void disableLogBackend(int var0) throws PDFNetException {
        DisableLogBackend(var0);
    }

//    public static void setAnalyticsHandler(AnalyticsHandlerCallback var0) throws PDFNetException {
//        a = var0;
//        SetAnalyticsHandler(var0);
//    }
//
//    public static void setAssertHandler(AssertHandlerCallback var0) throws PDFNetException {
//        b = var0;
//        SetAssertHandler(var0);
//    }
//
//    public static String getPDFViewTileSummary() throws PDFNetException {
//        return GetPDFViewTileSummary();
//    }
//
//    public static boolean checkDocIntegrity(PDFDoc var0) throws PDFNetException {
//        return CheckDocIntegrity(var0.__GetHandle());
//    }

    static native boolean IsLogSystemAvailable();

    static native boolean ConfigureLogFromJsonString(String var0);

    static native String GetDefaultConfigFile();

    static native String RunUniversalConversionTests(String var0);

    static native void LogMessage(int var0, String var1, String var2, int var3);

    static native void LogStreamMessage(int var0, String var1, String var2, String var3, int var4);

    static native boolean SetLogLocation(String var0, String var1);

    static native boolean SetLogFileName(String var0);

    static native void SetThresholdForLogStream(String var0, int var1);

    static native void SetDefaultLogThreshold(int var0);

    static native void SetCutoffLogThreshold(int var0);

    static native boolean EnableLogBackend(int var0);

    static native void DisableLogBackend(int var0);

    static native String GetPDFViewTileSummary();

//    static native void SetAnalyticsHandler(AnalyticsHandlerCallback var0);

//    static native void SetAssertHandler(AssertHandlerCallback var0);

    static native boolean CheckDocIntegrity(long var0);
}
