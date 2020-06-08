
package com.pdftron.pdf;

import com.pdftron.common.PDFNetException;
import java.util.HashMap;
import java.util.LinkedList;

abstract class h implements __Delete {
    static HashMap b = new HashMap();
    private Thread a;
    long c;

    h() {
    }

    protected void finalize() throws Throwable {
        if (this.c != 0L) {
            Object var1;
            synchronized(b) {
                var1 = b.get(this.a);
            }

            if (var1 != null) {
                synchronized(var1) {
                    ((LinkedList)var1).add(this);
                    return;
                }
            }
        }

    }

    protected void clearList() throws PDFNetException {
        this.a = Thread.currentThread();
        Object var1;
        synchronized(b) {
            var1 = b.get(this.a);
        }

        if (var1 != null) {
            synchronized(var1) {
                LinkedList var6 = (LinkedList)var1;

                while(!var6.isEmpty()) {
                    ((__Delete)var6.removeFirst()).destroy();
                }

            }
        } else {
            LinkedList var2 = new LinkedList();
            synchronized(b) {
                b.put(this.a, var2);
            }
        }
    }

    public abstract void destroy() throws PDFNetException;
}
