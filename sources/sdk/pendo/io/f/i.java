package sdk.pendo.io.f;

import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import sdk.pendo.io.d.a;
import sdk.pendo.io.m.e;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0005\u001bB\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\u0005\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0007J\u001d\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000bJ9\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00022\u001c\u0010\u0012\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000fH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lsdk/pendo/io/f/i;", "Lsdk/pendo/io/d/a;", "Lsdk/pendo/io/m/e;", "", "logListZip", "a", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "value", "", "isValid", "(Lcom/appmattus/certificatetransparency/loglist/RawLogListResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "set", "tooBig", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "lambda", "Lsdk/pendo/io/f/i$b;", "wrap", "(Lcom/appmattus/certificatetransparency/loglist/RawLogListResult;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lsdk/pendo/io/m/c;", "Lsdk/pendo/io/m/c;", "logListService", "<init>", "(Lcom/appmattus/certificatetransparency/loglist/LogListService;)V", "b", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class i implements sdk.pendo.io.d.a<sdk.pendo.io.m.e> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final sdk.pendo.io.m.c logListService;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lsdk/pendo/io/f/i$b;", "", "<init>", "()V", "a", "b", "Lsdk/pendo/io/f/i$b$b;", "Lsdk/pendo/io/f/i$b$a;", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
    private static abstract class b {

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lsdk/pendo/io/f/i$b$a;", "Lsdk/pendo/io/f/i$b;", "Lsdk/pendo/io/m/e;", "a", "Lsdk/pendo/io/m/e;", "getError", "()Lcom/appmattus/certificatetransparency/loglist/RawLogListResult;", "error", "<init>", "(Lcom/appmattus/certificatetransparency/loglist/RawLogListResult;)V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
        public static final class a extends b {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            private final sdk.pendo.io.m.e error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(sdk.pendo.io.m.e error) {
                super(null);
                Intrinsics.checkNotNullParameter(error, "error");
                this.error = error;
            }

            /* renamed from: a, reason: from getter */
            public final sdk.pendo.io.m.e getError() {
                return this.error;
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005¨\u0006\t"}, d2 = {"Lsdk/pendo/io/f/i$b$b;", "Lsdk/pendo/io/f/i$b;", "", "a", "[B", "()[B", "bytes", "<init>", "([B)V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
        /* renamed from: sdk.pendo.io.f.i$b$b, reason: collision with other inner class name */
        public static final class C0127b extends b {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            private final byte[] bytes;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0127b(byte[] bytes) {
                super(null);
                Intrinsics.checkNotNullParameter(bytes, "bytes");
                this.bytes = bytes;
            }

            /* renamed from: a, reason: from getter */
            public final byte[] getBytes() {
                return this.bytes;
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.LogListZipNetworkDataSource", f = "LogListZipNetworkDataSource.kt", i = {0}, l = {35, 36}, m = "get", n = {"this"}, s = {"L$0"})
    static final class c extends ContinuationImpl {
        Object f;
        int f0;
        /* synthetic */ Object s;

        c(Continuation<? super c> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.s = obj;
            this.f0 |= Integer.MIN_VALUE;
            return i.this.a(this);
        }
    }

    @Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0012\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.LogListZipNetworkDataSource$get$logListZip$1", f = "LogListZipNetworkDataSource.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {})
    static final class d extends SuspendLambda implements Function1<Continuation<? super byte[]>, Object> {
        int f;

        d(Continuation<? super d> continuation) {
            super(1, continuation);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Continuation<? super byte[]> continuation) {
            return ((d) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return i.this.new d(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                sdk.pendo.io.m.c cVar = i.this.logListService;
                this.f = 1;
                obj = cVar.c(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return obj;
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.LogListZipNetworkDataSource", f = "LogListZipNetworkDataSource.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {48, 53}, m = "readZip", n = {"this", "logListJson", "signature", "zipInputStream", "this", "logListJson", "signature", "zipInputStream"}, s = {"L$0", "L$1", "L$2", "L$4", "L$0", "L$1", "L$2", "L$4"})
    static final class e extends ContinuationImpl {
        Object A;
        Object f;
        Object f0;
        Object s;
        Object t0;
        Object u0;
        Object v0;
        /* synthetic */ Object w0;
        int y0;

        e(Continuation<? super e> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.w0 = obj;
            this.y0 |= Integer.MIN_VALUE;
            return i.this.a((byte[]) null, (Continuation<? super sdk.pendo.io.m.e>) this);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Ljava/util/zip/ZipEntry;", "a", "()Ljava/util/zip/ZipEntry;"}, k = 3, mv = {1, 6, 0})
    static final class f extends Lambda implements Function0<ZipEntry> {
        final /* synthetic */ ZipInputStream f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(ZipInputStream zipInputStream) {
            super(0);
            this.f = zipInputStream;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ZipEntry invoke() {
            return this.f.getNextEntry();
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/util/zip/ZipEntry;", "it", "", "a", "(Ljava/util/zip/ZipEntry;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 6, 0})
    static final class g extends Lambda implements Function1<ZipEntry, Boolean> {
        public static final g f = new g();

        g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(ZipEntry it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Boolean.valueOf(!it.isDirectory());
        }
    }

    @Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0012\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.LogListZipNetworkDataSource$readZip$2$3$1", f = "LogListZipNetworkDataSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class h extends SuspendLambda implements Function1<Continuation<? super byte[]>, Object> {
        int f;
        final /* synthetic */ ZipInputStream s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(ZipInputStream zipInputStream, Continuation<? super h> continuation) {
            super(1, continuation);
            this.s = zipInputStream;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Continuation<? super byte[]> continuation) {
            return ((h) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new h(this.s, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ByteStreamsKt.readBytes(new sdk.pendo.io.j.d(this.s, 1048576L));
        }
    }

    @Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0012\n\u0000\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.LogListZipNetworkDataSource$readZip$2$3$2", f = "LogListZipNetworkDataSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: sdk.pendo.io.f.i$i, reason: collision with other inner class name */
    static final class C0128i extends SuspendLambda implements Function1<Continuation<? super byte[]>, Object> {
        int f;
        final /* synthetic */ ZipInputStream s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0128i(ZipInputStream zipInputStream, Continuation<? super C0128i> continuation) {
            super(1, continuation);
            this.s = zipInputStream;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Continuation<? super byte[]> continuation) {
            return ((C0128i) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new C0128i(this.s, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ByteStreamsKt.readBytes(new sdk.pendo.io.j.d(this.s, 512L));
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.LogListZipNetworkDataSource", f = "LogListZipNetworkDataSource.kt", i = {0}, l = {78}, m = "wrap", n = {"tooBig"}, s = {"L$0"})
    static final class j extends ContinuationImpl {
        Object f;
        int f0;
        /* synthetic */ Object s;

        j(Continuation<? super j> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.s = obj;
            this.f0 |= Integer.MIN_VALUE;
            return i.this.a((sdk.pendo.io.m.e) null, (Function1<? super Continuation<? super byte[]>, ? extends Object>) null, this);
        }
    }

    public i(sdk.pendo.io.m.c logListService) {
        Intrinsics.checkNotNullParameter(logListService, "logListService");
        this.logListService = logListService;
    }

    @Override // sdk.pendo.io.d.a
    public /* bridge */ /* synthetic */ Object b(sdk.pendo.io.m.e eVar, Continuation continuation) {
        return b2(eVar, (Continuation<? super Unit>) continuation);
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    public Object b2(sdk.pendo.io.m.e eVar, Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // sdk.pendo.io.d.a
    public sdk.pendo.io.d.a<sdk.pendo.io.m.e> a(sdk.pendo.io.d.a<sdk.pendo.io.m.e> aVar) {
        return a.C0099a.a(this, aVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // sdk.pendo.io.d.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(kotlin.coroutines.Continuation<? super sdk.pendo.io.m.e> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof sdk.pendo.io.f.i.c
            if (r0 == 0) goto L13
            r0 = r7
            sdk.pendo.io.f.i$c r0 = (sdk.pendo.io.f.i.c) r0
            int r1 = r0.f0
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f0 = r1
            goto L18
        L13:
            sdk.pendo.io.f.i$c r0 = new sdk.pendo.io.f.i$c
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.s
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f0
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L3d
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L6a
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L35:
            java.lang.Object r2 = r0.f
            sdk.pendo.io.f.i r2 = (sdk.pendo.io.f.i) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L53
        L3d:
            kotlin.ResultKt.throwOnFailure(r7)
            sdk.pendo.io.f.v r7 = sdk.pendo.io.f.v.f1066a
            sdk.pendo.io.f.i$d r2 = new sdk.pendo.io.f.i$d
            r2.<init>(r5)
            r0.f = r6
            r0.f0 = r4
            java.lang.Object r7 = r6.a(r7, r2, r0)
            if (r7 != r1) goto L52
            return r1
        L52:
            r2 = r6
        L53:
            sdk.pendo.io.f.i$b r7 = (sdk.pendo.io.f.i.b) r7
            boolean r4 = r7 instanceof sdk.pendo.io.f.i.b.C0127b
            if (r4 == 0) goto L6b
            sdk.pendo.io.f.i$b$b r7 = (sdk.pendo.io.f.i.b.C0127b) r7
            byte[] r7 = r7.getBytes()
            r0.f = r5
            r0.f0 = r3
            java.lang.Object r7 = r2.a(r7, r0)
            if (r7 != r1) goto L6a
            return r1
        L6a:
            return r7
        L6b:
            boolean r0 = r7 instanceof sdk.pendo.io.f.i.b.a
            if (r0 == 0) goto L76
            sdk.pendo.io.f.i$b$a r7 = (sdk.pendo.io.f.i.b.a) r7
            sdk.pendo.io.m.e r7 = r7.getError()
            return r7
        L76:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.f.i.a(kotlin.coroutines.Continuation):java.lang.Object");
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00a4 A[Catch: all -> 0x0179, TryCatch #0 {all -> 0x0179, blocks: (B:12:0x0044, B:13:0x010e, B:14:0x0113, B:15:0x009d, B:17:0x00a4, B:19:0x00bf, B:24:0x00e3, B:26:0x00eb, B:30:0x0117, B:68:0x0085), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0117 A[Catch: all -> 0x0179, TRY_LEAVE, TryCatch #0 {all -> 0x0179, blocks: (B:12:0x0044, B:13:0x010e, B:14:0x0113, B:15:0x009d, B:17:0x00a4, B:19:0x00bf, B:24:0x00e3, B:26:0x00eb, B:30:0x0117, B:68:0x0085), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v13, types: [T] */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.io.Closeable] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00dd -> B:13:0x010e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00e9 -> B:14:0x0113). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0109 -> B:13:0x010e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(byte[] r13, kotlin.coroutines.Continuation<? super sdk.pendo.io.m.e> r14) {
        /*
            Method dump skipped, instructions count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.f.i.a(byte[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // sdk.pendo.io.d.a
    public sdk.pendo.io.d.a<sdk.pendo.io.m.e> a() {
        return a.C0099a.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(sdk.pendo.io.m.e r5, kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super byte[]>, ? extends java.lang.Object> r6, kotlin.coroutines.Continuation<? super sdk.pendo.io.f.i.b> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof sdk.pendo.io.f.i.j
            if (r0 == 0) goto L13
            r0 = r7
            sdk.pendo.io.f.i$j r0 = (sdk.pendo.io.f.i.j) r0
            int r1 = r0.f0
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f0 = r1
            goto L18
        L13:
            sdk.pendo.io.f.i$j r0 = new sdk.pendo.io.f.i$j
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.s
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f0
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f
            sdk.pendo.io.m.e r5 = (sdk.pendo.io.m.e) r5
            kotlin.ResultKt.throwOnFailure(r7)     // Catch: java.lang.Exception -> L4b
            goto L43
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.f = r5     // Catch: java.lang.Exception -> L4b
            r0.f0 = r3     // Catch: java.lang.Exception -> L4b
            java.lang.Object r7 = r6.invoke(r0)     // Catch: java.lang.Exception -> L4b
            if (r7 != r1) goto L43
            return r1
        L43:
            byte[] r7 = (byte[]) r7     // Catch: java.lang.Exception -> L4b
            sdk.pendo.io.f.i$b$b r6 = new sdk.pendo.io.f.i$b$b     // Catch: java.lang.Exception -> L4b
            r6.<init>(r7)     // Catch: java.lang.Exception -> L4b
            goto L63
        L4b:
            r6 = move-exception
            boolean r7 = sdk.pendo.io.j.e.a(r6)
            if (r7 == 0) goto L58
            sdk.pendo.io.f.i$b$a r6 = new sdk.pendo.io.f.i$b$a
            r6.<init>(r5)
            goto L63
        L58:
            sdk.pendo.io.f.i$b$a r5 = new sdk.pendo.io.f.i$b$a
            sdk.pendo.io.f.s r7 = new sdk.pendo.io.f.s
            r7.<init>(r6)
            r5.<init>(r7)
            r6 = r5
        L63:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.f.i.a(sdk.pendo.io.m.e, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
