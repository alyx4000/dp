package com.quantummetric.ui.internal;

import com.quantummetric.ui.internal.cj;

/* loaded from: classes5.dex */
abstract class c {

    /* renamed from: a, reason: collision with root package name */
    boolean f157a;
    boolean b;
    boolean c;
    boolean d;
    boolean e;
    boolean f;
    float g;
    float h;
    float i;
    float j;
    float k;
    short l = 0;
    String m;
    ac n;

    c() {
    }

    abstract void a(Object obj);

    /* JADX WARN: Multi-variable type inference failed */
    final void a(boolean z, boolean z2, boolean z3, boolean z4) {
        if (z) {
            this.b = true;
        } else if (!this.b) {
            if (z3) {
                this.d = true;
            } else if (z4) {
                this.e = true;
            }
        }
        this.c |= z2;
        if (this instanceof cj.b) {
            cj.a((cj.b) this, this.b, this.d, this.e);
        }
    }

    abstract String a_();
}
