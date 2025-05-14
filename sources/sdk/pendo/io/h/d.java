package sdk.pendo.io.h;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import sdk.pendo.io.f.f;
import sdk.pendo.io.f.h;
import sdk.pendo.io.f.k;
import sdk.pendo.io.f.m;
import sdk.pendo.io.f.o;
import sdk.pendo.io.f.w;
import sdk.pendo.io.m.b;
import sdk.pendo.io.m.e;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0005\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0006H\u0002J\u000e\u0010\u0005\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\bR\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lsdk/pendo/io/h/d;", "", "Lsdk/pendo/io/m/e$a;", "rawLogListResult", "Lsdk/pendo/io/m/b$a;", "a", "Lsdk/pendo/io/m/e$b;", "Lsdk/pendo/io/m/b;", "Lsdk/pendo/io/m/e;", "Lsdk/pendo/io/h/c;", "Lsdk/pendo/io/h/c;", "logListVerifier", "Lsdk/pendo/io/h/a;", "b", "Lsdk/pendo/io/h/a;", "logListJsonParser", "<init>", "(Lcom/appmattus/certificatetransparency/internal/loglist/parser/LogListVerifier;Lcom/appmattus/certificatetransparency/internal/loglist/parser/LogListJsonParser;)V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final c logListVerifier;

    /* renamed from: b, reason: from kotlin metadata */
    private final a logListJsonParser;

    public d(c logListVerifier, a logListJsonParser) {
        Intrinsics.checkNotNullParameter(logListVerifier, "logListVerifier");
        Intrinsics.checkNotNullParameter(logListJsonParser, "logListJsonParser");
        this.logListVerifier = logListVerifier;
        this.logListJsonParser = logListJsonParser;
    }

    public final sdk.pendo.io.m.b a(e rawLogListResult) {
        Intrinsics.checkNotNullParameter(rawLogListResult, "rawLogListResult");
        if (rawLogListResult instanceof e.b) {
            return a((e.b) rawLogListResult);
        }
        if (rawLogListResult instanceof e.a) {
            return a((e.a) rawLogListResult);
        }
        throw new NoWhenBranchMatchedException();
    }

    public /* synthetic */ d(c cVar, a aVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new c(null, 1, null) : cVar, (i & 2) != 0 ? new b() : aVar);
    }

    private final b.a a(e.a rawLogListResult) {
        return rawLogListResult instanceof m ? new f(((m) rawLogListResult).getException()) : rawLogListResult instanceof o ? new h(((o) rawLogListResult).getException()) : sdk.pendo.io.f.e.f1043a;
    }

    private final sdk.pendo.io.m.b a(e.b rawLogListResult) {
        byte[] logList = rawLogListResult.getLogList();
        k a2 = this.logListVerifier.a(logList, rawLogListResult.getSignature());
        if (a2 instanceof k.b) {
            return this.logListJsonParser.a(new String(logList, Charsets.UTF_8));
        }
        if (a2 instanceof k.a) {
            return new w((k.a) a2);
        }
        throw new NoWhenBranchMatchedException();
    }
}
