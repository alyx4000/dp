package sdk.pendo.io.r8;

import io.sentry.SentryBaseEvent;
import io.sentry.protocol.Response;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.j9.b;
import sdk.pendo.io.k0.l;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.w2.b0;
import sdk.pendo.io.w2.d0;
import sdk.pendo.io.w2.v;
import sdk.pendo.io.w2.w;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\t\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/r8/a;", "Lsdk/pendo/io/w2/w;", "", "error", "url", "", "b", "Lsdk/pendo/io/w2/d0;", Response.TYPE, "a", "content", "Lsdk/pendo/io/w2/w$a;", "chain", "Lsdk/pendo/io/j9/a;", "Lsdk/pendo/io/j9/a;", "getFile", "()Lsdk/pendo/io/j9/a;", "file", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class a implements w {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final sdk.pendo.io.j9.a file;

    public a() {
        b a2 = b.INSTANCE.a();
        File externalFilesDir = PendoInternal.m().getExternalFilesDir(null);
        Intrinsics.checkNotNull(externalFilesDir);
        this.file = b.a(a2, "PNDQaLogs.txt", externalFilesDir, null, false, 12, null);
    }

    private final String a(String error, String url) {
        l lVar = new l();
        try {
            lVar.a("content", error);
            lVar.a(SentryBaseEvent.JsonKeys.REQUEST, url);
            lVar.a("timestamp", Long.valueOf(System.currentTimeMillis()));
        } catch (Exception e) {
            PendoLogger.d(e, "could not create file content json " + lVar, new Object[0]);
        }
        String iVar = lVar.toString();
        Intrinsics.checkNotNullExpressionValue(iVar, "toString(...)");
        return iVar;
    }

    private final void b(String error, String url) {
        a(a(error, url));
    }

    private final String a(d0 response, String url) {
        l lVar = new l();
        try {
            String str = response.getCom.socure.docv.capturesdk.common.utils.ApiConstant.KEY_CODE java.lang.String() + " " + url;
            lVar.a("content", sdk.pendo.io.g9.a.f1122a.a(response.getBody()));
            lVar.a(SentryBaseEvent.JsonKeys.REQUEST, str);
            lVar.a("timestamp", Long.valueOf(System.currentTimeMillis()));
        } catch (Exception e) {
            PendoLogger.d(e, "could not create file content json " + lVar, new Object[0]);
        }
        String iVar = lVar.toString();
        Intrinsics.checkNotNullExpressionValue(iVar, "toString(...)");
        return iVar;
    }

    private final void b(d0 response, String url) {
        a(a(response, url));
    }

    @Override // sdk.pendo.io.w2.w
    public d0 a(w.a chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        b0 b0Var = chain.getIo.sentry.SentryBaseEvent.JsonKeys.REQUEST java.lang.String();
        v url = b0Var.getUrl();
        try {
            d0 a2 = chain.a(b0Var);
            b(a2, url.getUrl());
            return a2;
        } catch (Exception e) {
            b(e.toString(), url.getUrl());
            throw e;
        }
    }

    private final void a(String content) {
        sdk.pendo.io.j9.a aVar = this.file;
        if (aVar != null) {
            aVar.a(content + "\n");
        }
    }
}
