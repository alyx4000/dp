package sdk.pendo.io.f4;

import sdk.pendo.io.m3.t;
import sdk.pendo.io.m3.v;

/* loaded from: classes6.dex */
public class c extends t implements h {
    private v A = null;
    private sdk.pendo.io.v4.c f;
    private byte[] s;

    public c(sdk.pendo.io.v4.c cVar, byte[] bArr) {
        this.f = cVar;
        this.s = sdk.pendo.io.d5.a.a(bArr);
        h();
    }

    private void h() {
        v vVar;
        if (sdk.pendo.io.v4.a.b(this.f)) {
            vVar = h.c;
        } else {
            if (!sdk.pendo.io.v4.a.a(this.f)) {
                throw new IllegalArgumentException("This type of ECCurve is not implemented");
            }
            vVar = h.d;
        }
        this.A = vVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0061  */
    @Override // sdk.pendo.io.m3.t, sdk.pendo.io.m3.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public sdk.pendo.io.m3.a0 b() {
        /*
            r3 = this;
            sdk.pendo.io.m3.h r0 = new sdk.pendo.io.m3.h
            r1 = 3
            r0.<init>(r1)
            sdk.pendo.io.m3.v r1 = r3.A
            sdk.pendo.io.m3.v r2 = sdk.pendo.io.f4.h.c
            boolean r1 = r1.b(r2)
            if (r1 == 0) goto L35
            sdk.pendo.io.f4.f r1 = new sdk.pendo.io.f4.f
            sdk.pendo.io.v4.c r2 = r3.f
            sdk.pendo.io.v4.d r2 = r2.a()
            r1.<init>(r2)
            sdk.pendo.io.m3.a0 r1 = r1.b()
            r0.a(r1)
            sdk.pendo.io.f4.f r1 = new sdk.pendo.io.f4.f
            sdk.pendo.io.v4.c r2 = r3.f
            sdk.pendo.io.v4.d r2 = r2.b()
            r1.<init>(r2)
        L2d:
            sdk.pendo.io.m3.a0 r1 = r1.b()
            r0.a(r1)
            goto L5d
        L35:
            sdk.pendo.io.m3.v r1 = r3.A
            sdk.pendo.io.m3.v r2 = sdk.pendo.io.f4.h.d
            boolean r1 = r1.b(r2)
            if (r1 == 0) goto L5d
            sdk.pendo.io.f4.f r1 = new sdk.pendo.io.f4.f
            sdk.pendo.io.v4.c r2 = r3.f
            sdk.pendo.io.v4.d r2 = r2.a()
            r1.<init>(r2)
            sdk.pendo.io.m3.a0 r1 = r1.b()
            r0.a(r1)
            sdk.pendo.io.f4.f r1 = new sdk.pendo.io.f4.f
            sdk.pendo.io.v4.c r2 = r3.f
            sdk.pendo.io.v4.d r2 = r2.b()
            r1.<init>(r2)
            goto L2d
        L5d:
            byte[] r1 = r3.s
            if (r1 == 0) goto L6b
            sdk.pendo.io.m3.j1 r1 = new sdk.pendo.io.m3.j1
            byte[] r2 = r3.s
            r1.<init>(r2)
            r0.a(r1)
        L6b:
            sdk.pendo.io.m3.w1 r1 = new sdk.pendo.io.m3.w1
            r1.<init>(r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.f4.c.b():sdk.pendo.io.m3.a0");
    }
}
