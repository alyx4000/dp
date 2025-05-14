package sdk.pendo.io.c3;

import io.sentry.protocol.Response;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sdk.pendo.io.k3.g;
import sdk.pendo.io.w2.d0;
import sdk.pendo.io.w2.m;
import sdk.pendo.io.w2.n;
import sdk.pendo.io.w2.u;
import sdk.pendo.io.w2.v;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u001a\u0010\u0005\u001a\u00020\t*\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0002\u001a\f\u0010\u000b\u001a\u00020\n*\u00020\u0006H\u0002\u001a\u0014\u0010\u0005\u001a\u00020\n*\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0002\u001a\u000e\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u0006H\u0002\u001a\u000e\u0010\u000e\u001a\u0004\u0018\u00010\u0001*\u00020\u0006H\u0002\u001a\u001a\u0010\u0005\u001a\u00020\t*\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0000\u001a\n\u0010\u000e\u001a\u00020\n*\u00020\u0013\u001a\u0010\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0007\"\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016\"\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u0016¨\u0006\u0019"}, d2 = {"Lsdk/pendo/io/w2/u;", "", "headerName", "", "Lsdk/pendo/io/w2/h;", "a", "Lsdk/pendo/io/k3/d;", "", "result", "", "", "c", "", "prefix", "b", "Lsdk/pendo/io/w2/n;", "Lsdk/pendo/io/w2/v;", "url", "headers", "Lsdk/pendo/io/w2/d0;", Response.TYPE, "Lsdk/pendo/io/k3/g;", "Lsdk/pendo/io/k3/g;", "QUOTED_STRING_DELIMITERS", "TOKEN_DELIMITERS", "okhttp"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final sdk.pendo.io.k3.g f948a;
    private static final sdk.pendo.io.k3.g b;

    static {
        g.Companion companion = sdk.pendo.io.k3.g.INSTANCE;
        f948a = companion.b("\"\\");
        b = companion.b("\t ,=");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "No longer supported", replaceWith = @ReplaceWith(expression = "response.promisesBody()", imports = {}))
    public static final boolean a(d0 response) {
        Intrinsics.checkNotNullParameter(response, "response");
        return b(response);
    }

    public static final boolean b(d0 d0Var) {
        Intrinsics.checkNotNullParameter(d0Var, "<this>");
        if (Intrinsics.areEqual(d0Var.getIo.sentry.SentryBaseEvent.JsonKeys.REQUEST java.lang.String().getIo.sentry.protocol.Request.JsonKeys.METHOD java.lang.String(), "HEAD")) {
            return false;
        }
        int i = d0Var.getCom.socure.docv.capturesdk.common.utils.ApiConstant.KEY_CODE java.lang.String();
        return (((i >= 100 && i < 200) || i == 204 || i == 304) && sdk.pendo.io.x2.b.a(d0Var) == -1 && !StringsKt.equals("chunked", d0.a(d0Var, "Transfer-Encoding", null, 2, null), true)) ? false : true;
    }

    private static final boolean c(sdk.pendo.io.k3.d dVar) {
        boolean z = false;
        while (!dVar.i()) {
            byte h = dVar.h(0L);
            boolean z2 = true;
            if (h != 44) {
                if (h != 32 && h != 9) {
                    z2 = false;
                }
                if (!z2) {
                    break;
                }
                dVar.readByte();
            } else {
                dVar.readByte();
                z = true;
            }
        }
        return z;
    }

    public static final List<sdk.pendo.io.w2.h> a(u uVar, String headerName) {
        Intrinsics.checkNotNullParameter(uVar, "<this>");
        Intrinsics.checkNotNullParameter(headerName, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = uVar.size();
        for (int i = 0; i < size; i++) {
            if (StringsKt.equals(headerName, uVar.a(i), true)) {
                try {
                    a(new sdk.pendo.io.k3.d().a(uVar.b(i)), arrayList);
                } catch (EOFException e) {
                    sdk.pendo.io.f3.h.INSTANCE.d().a("Unable to parse challenge", 5, e);
                }
            }
        }
        return arrayList;
    }

    private static final String b(sdk.pendo.io.k3.d dVar) {
        long b2 = dVar.b(b);
        if (b2 == -1) {
            b2 = dVar.getSize();
        }
        if (b2 != 0) {
            return dVar.i(b2);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00bc, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00bc, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void a(sdk.pendo.io.k3.d r7, java.util.List<sdk.pendo.io.w2.h> r8) {
        /*
            r0 = 0
        L1:
            r1 = r0
        L2:
            if (r1 != 0) goto Le
            c(r7)
            java.lang.String r1 = b(r7)
            if (r1 != 0) goto Le
            return
        Le:
            boolean r2 = c(r7)
            java.lang.String r3 = b(r7)
            if (r3 != 0) goto L2c
            boolean r7 = r7.i()
            if (r7 != 0) goto L1f
            return
        L1f:
            sdk.pendo.io.w2.h r7 = new sdk.pendo.io.w2.h
            java.util.Map r0 = kotlin.collections.MapsKt.emptyMap()
            r7.<init>(r1, r0)
            r8.add(r7)
            return
        L2c:
            r4 = 61
            int r5 = sdk.pendo.io.x2.b.a(r7, r4)
            boolean r6 = c(r7)
            if (r2 != 0) goto L69
            if (r6 != 0) goto L40
            boolean r2 = r7.i()
            if (r2 == 0) goto L69
        L40:
            sdk.pendo.io.w2.h r2 = new sdk.pendo.io.w2.h
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.StringBuilder r3 = r4.append(r3)
            java.lang.String r4 = "="
            java.lang.String r4 = kotlin.text.StringsKt.repeat(r4, r5)
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.util.Map r3 = java.util.Collections.singletonMap(r0, r3)
            java.lang.String r4 = "singletonMap<String, Str…ek + \"=\".repeat(eqCount))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r2.<init>(r1, r3)
            r8.add(r2)
            goto L1
        L69:
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            int r6 = sdk.pendo.io.x2.b.a(r7, r4)
            int r5 = r5 + r6
        L73:
            if (r3 != 0) goto L83
            java.lang.String r3 = b(r7)
            boolean r5 = c(r7)
            if (r5 != 0) goto Lbc
            int r5 = sdk.pendo.io.x2.b.a(r7, r4)
        L83:
            if (r5 == 0) goto Lbc
            r6 = 1
            if (r5 <= r6) goto L89
            return
        L89:
            boolean r6 = c(r7)
            if (r6 == 0) goto L90
            return
        L90:
            r6 = 34
            boolean r6 = a(r7, r6)
            if (r6 == 0) goto L9d
            java.lang.String r6 = a(r7)
            goto La1
        L9d:
            java.lang.String r6 = b(r7)
        La1:
            if (r6 != 0) goto La4
            return
        La4:
            java.lang.Object r3 = r2.put(r3, r6)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 == 0) goto Lad
            return
        Lad:
            boolean r3 = c(r7)
            if (r3 != 0) goto Lba
            boolean r3 = r7.i()
            if (r3 != 0) goto Lba
            return
        Lba:
            r3 = r0
            goto L73
        Lbc:
            sdk.pendo.io.w2.h r4 = new sdk.pendo.io.w2.h
            r4.<init>(r1, r2)
            r8.add(r4)
            r1 = r3
            goto L2
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.c3.e.a(sdk.pendo.io.k3.d, java.util.List):void");
    }

    private static final String a(sdk.pendo.io.k3.d dVar) {
        if (!(dVar.readByte() == 34)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        sdk.pendo.io.k3.d dVar2 = new sdk.pendo.io.k3.d();
        while (true) {
            long b2 = dVar.b(f948a);
            if (b2 == -1) {
                return null;
            }
            if (dVar.h(b2) == 34) {
                dVar2.a(dVar, b2);
                dVar.readByte();
                return dVar2.w();
            }
            if (dVar.getSize() == b2 + 1) {
                return null;
            }
            dVar2.a(dVar, b2);
            dVar.readByte();
            dVar2.a(dVar, 1L);
        }
    }

    public static final void a(n nVar, v url, u headers) {
        Intrinsics.checkNotNullParameter(nVar, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        if (nVar == n.b) {
            return;
        }
        List<m> a2 = m.INSTANCE.a(url, headers);
        if (a2.isEmpty()) {
            return;
        }
        nVar.a(url, a2);
    }

    private static final boolean a(sdk.pendo.io.k3.d dVar, byte b2) {
        return !dVar.i() && dVar.h(0L) == b2;
    }
}
