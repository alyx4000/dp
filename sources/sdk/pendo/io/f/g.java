package sdk.pendo.io.f;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.d.a;
import sdk.pendo.io.m.e;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0003\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\bR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lsdk/pendo/io/f/g;", "Lsdk/pendo/io/d/a;", "Lsdk/pendo/io/m/e;", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "value", "", "isValid", "(Lcom/appmattus/certificatetransparency/loglist/RawLogListResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "set", "Lsdk/pendo/io/m/c;", "Lsdk/pendo/io/m/c;", "logListService", "<init>", "(Lcom/appmattus/certificatetransparency/loglist/LogListService;)V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class g implements sdk.pendo.io.d.a<sdk.pendo.io.m.e> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final sdk.pendo.io.m.c logListService;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.LogListNetworkDataSource", f = "LogListNetworkDataSource.kt", i = {0, 1}, l = {35, 41}, m = "get", n = {"this", "logListJson"}, s = {"L$0", "L$0"})
    static final class a extends ContinuationImpl {
        Object f;
        int f0;
        /* synthetic */ Object s;

        a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.s = obj;
            this.f0 |= Integer.MIN_VALUE;
            return g.this.a(this);
        }
    }

    public g(sdk.pendo.io.m.c logListService) {
        Intrinsics.checkNotNullParameter(logListService, "logListService");
        this.logListService = logListService;
    }

    @Override // sdk.pendo.io.d.a
    public sdk.pendo.io.d.a<sdk.pendo.io.m.e> a(sdk.pendo.io.d.a<sdk.pendo.io.m.e> aVar) {
        return a.C0099a.a(this, aVar);
    }

    @Override // sdk.pendo.io.d.a
    public /* bridge */ /* synthetic */ Object b(sdk.pendo.io.m.e eVar, Continuation continuation) {
        return b2(eVar, (Continuation<? super Unit>) continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0061 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    @Override // sdk.pendo.io.d.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(kotlin.coroutines.Continuation<? super sdk.pendo.io.m.e> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof sdk.pendo.io.f.g.a
            if (r0 == 0) goto L13
            r0 = r7
            sdk.pendo.io.f.g$a r0 = (sdk.pendo.io.f.g.a) r0
            int r1 = r0.f0
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f0 = r1
            goto L18
        L13:
            sdk.pendo.io.f.g$a r0 = new sdk.pendo.io.f.g$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.s
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f0
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L42
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r0 = r0.f
            byte[] r0 = (byte[]) r0
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L30
            goto L65
        L30:
            r7 = move-exception
            goto L6d
        L32:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L3a:
            java.lang.Object r2 = r0.f
            sdk.pendo.io.f.g r2 = (sdk.pendo.io.f.g) r2
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L7d
            goto L53
        L42:
            kotlin.ResultKt.throwOnFailure(r7)
            sdk.pendo.io.m.c r7 = r6.logListService     // Catch: java.lang.Exception -> L7d
            r0.f = r6     // Catch: java.lang.Exception -> L7d
            r0.f0 = r4     // Catch: java.lang.Exception -> L7d
            java.lang.Object r7 = r7.b(r0)     // Catch: java.lang.Exception -> L7d
            if (r7 != r1) goto L52
            return r1
        L52:
            r2 = r6
        L53:
            byte[] r7 = (byte[]) r7     // Catch: java.lang.Exception -> L7d
            sdk.pendo.io.m.c r2 = r2.logListService     // Catch: java.lang.Exception -> L30
            r0.f = r7     // Catch: java.lang.Exception -> L30
            r0.f0 = r3     // Catch: java.lang.Exception -> L30
            java.lang.Object r0 = r2.a(r0)     // Catch: java.lang.Exception -> L30
            if (r0 != r1) goto L62
            return r1
        L62:
            r5 = r0
            r0 = r7
            r7 = r5
        L65:
            byte[] r7 = (byte[]) r7     // Catch: java.lang.Exception -> L30
            sdk.pendo.io.m.e$b r1 = new sdk.pendo.io.m.e$b
            r1.<init>(r0, r7)
            return r1
        L6d:
            boolean r0 = sdk.pendo.io.j.e.a(r7)
            if (r0 == 0) goto L76
            sdk.pendo.io.f.p r7 = sdk.pendo.io.f.p.f1060a
            goto L7c
        L76:
            sdk.pendo.io.f.o r0 = new sdk.pendo.io.f.o
            r0.<init>(r7)
            r7 = r0
        L7c:
            return r7
        L7d:
            r7 = move-exception
            boolean r0 = sdk.pendo.io.j.e.a(r7)
            if (r0 == 0) goto L87
            sdk.pendo.io.f.n r7 = sdk.pendo.io.f.n.f1058a
            goto L8d
        L87:
            sdk.pendo.io.f.m r0 = new sdk.pendo.io.f.m
            r0.<init>(r7)
            r7 = r0
        L8d:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.f.g.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    public Object b2(sdk.pendo.io.m.e eVar, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // sdk.pendo.io.d.a
    public /* bridge */ /* synthetic */ Object a(sdk.pendo.io.m.e eVar, Continuation continuation) {
        return a2(eVar, (Continuation<? super Boolean>) continuation);
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    public Object a2(sdk.pendo.io.m.e eVar, Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(eVar instanceof e.b);
    }

    @Override // sdk.pendo.io.d.a
    public <MappedValue> sdk.pendo.io.d.a<MappedValue> a(Function1<? super sdk.pendo.io.m.e, ? extends MappedValue> function1) {
        return a.C0099a.a(this, function1);
    }

    @Override // sdk.pendo.io.d.a
    public sdk.pendo.io.d.a<sdk.pendo.io.m.e> a() {
        return a.C0099a.a(this);
    }
}
