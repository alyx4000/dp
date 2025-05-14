package com.quantummetric.ui.internal;

import java.io.Serializable;
import javax.crypto.Cipher;

/* loaded from: classes5.dex */
final class bo implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    String f125a;
    long e;
    int f;
    int g;
    long h;
    long i;
    final bg j;
    final bf k;
    String b = "";
    String c = ai.f;
    String d = ai.g;
    transient Cipher l = ab.d();

    bo(String str, long j, bg bgVar, bf bfVar) {
        this.f125a = str;
        this.e = j;
        this.j = bgVar;
        this.k = bfVar;
    }

    public final void a() {
        if (this.j.size() > 0) {
            this.j.clear();
        }
        if (this.k.size() > 0) {
            this.k.clear();
        }
    }

    public final String toString() {
        return "{" + this.f125a + "', id='" + this.b + "', s=" + this.e + ", e=" + this.j.size() + ", oob=" + this.k.size() + '}';
    }
}
