package io.castle.highwind.android;

import android.content.Context;

/* loaded from: classes2.dex */
public final class d extends s {
    public final d0 f;
    public final f g;
    public final p h;

    public d(String str, Context context, String str2, String str3, String str4, int i) {
        super(str, str2, str4);
        d0 d0Var = new d0(context);
        this.f = d0Var;
        this.g = new f(context, str3, d0Var, i);
        this.h = new p(context, str3);
    }

    @Override // io.castle.highwind.android.s
    public final Integer a() {
        return 6;
    }

    @Override // io.castle.highwind.android.s
    public final z b() {
        return this.h;
    }

    @Override // io.castle.highwind.android.s
    public final void c() {
    }

    @Override // io.castle.highwind.android.s
    public final int d() {
        return 2;
    }

    @Override // io.castle.highwind.android.s
    public final z e() {
        return this.g;
    }

    @Override // io.castle.highwind.android.s
    public final void g() {
        this.f.a();
    }

    @Override // io.castle.highwind.android.s
    public final String a(byte[] bArr) {
        return k.f775a.a(bArr);
    }
}
