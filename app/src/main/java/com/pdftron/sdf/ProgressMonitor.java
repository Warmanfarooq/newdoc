
package com.pdftron.sdf;

interface ProgressMonitor {
    void setRange(int var1, int var2);

    int getRangeStart();

    int getRangeFinish();

    int getPos();

    int setPos(int var1);

    int offsetPos(int var1);

    int setStep(int var1);

    int stepIt();
}
