package sdk.pendo.io.f4;

import sdk.pendo.io.m3.v;

/* loaded from: classes6.dex */
public class a {
    public static v a(String str) {
        v a2 = b.a(str);
        if (a2 == null) {
            a2 = sdk.pendo.io.a4.a.a(str);
        }
        if (a2 == null) {
            a2 = sdk.pendo.io.v3.a.a(str);
        }
        if (a2 == null) {
            a2 = sdk.pendo.io.b4.a.a(str);
        }
        if (a2 == null) {
            a2 = sdk.pendo.io.n3.a.a(str);
        }
        if (a2 == null) {
            a2 = sdk.pendo.io.r3.b.a(str);
        }
        if (a2 == null) {
            a2 = sdk.pendo.io.u3.a.a(str);
        }
        return (a2 == null && str.equals("curve25519")) ? sdk.pendo.io.q3.a.c : a2;
    }
}
