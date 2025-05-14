package sdk.pendo.io.y6;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import io.sentry.protocol.Response;
import java.lang.reflect.Method;
import kotlin.KotlinNullPointerException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0003\u001a\u00020\u0002*\u00060\u0000j\u0002`\u0001H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a'\u0010\b\u001a\u00028\u0000\"\b\b\u0000\u0010\u0006*\u00020\u0005*\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u001a+\u0010\b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0006*\u00020\u0005*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007H\u0087@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\t\u001a)\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\t\u001a\u001c\u0010\u000e\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0006\u0018\u0001*\u00020\rH\u0086\b¢\u0006\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "", "a", "(Ljava/lang/Exception;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lsdk/pendo/io/y6/b;", "await", "(Lretrofit2/Call;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitNullable", "Lsdk/pendo/io/y6/r;", "awaitResponse", "Lsdk/pendo/io/y6/s;", "create", "(Lretrofit2/Retrofit;)Ljava/lang/Object;", "retrofit"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class k {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "", "it", "", "a", "(Ljava/lang/Throwable;)V", "external/sdk/pendo/io/retrofit2/KotlinExtensions$await$2$1"}, k = 3, mv = {1, 4, 0})
    static final class a extends Lambda implements Function1<Throwable, Unit> {
        final /* synthetic */ sdk.pendo.io.y6.b f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(sdk.pendo.io.y6.b bVar) {
            super(1);
            this.f = bVar;
        }

        public final void a(Throwable th) {
            this.f.cancel();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            a(th);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "", "it", "", "a", "(Ljava/lang/Throwable;)V", "external/sdk/pendo/io/retrofit2/KotlinExtensions$await$4$1"}, k = 3, mv = {1, 4, 0})
    static final class b extends Lambda implements Function1<Throwable, Unit> {
        final /* synthetic */ sdk.pendo.io.y6.b f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(sdk.pendo.io.y6.b bVar) {
            super(1);
            this.f = bVar;
        }

        public final void a(Throwable th) {
            this.f.cancel();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            a(th);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J$\u0010\u0007\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016J\u001e\u0010\u0007\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"sdk/pendo/io/y6/k$c", "Lsdk/pendo/io/y6/d;", "Lsdk/pendo/io/y6/b;", NotificationCompat.CATEGORY_CALL, "Lsdk/pendo/io/y6/r;", Response.TYPE, "", "a", "", "t", "retrofit"}, k = 1, mv = {1, 4, 0})
    public static final class c<T> implements sdk.pendo.io.y6.d<T> {
        final /* synthetic */ CancellableContinuation f;

        c(CancellableContinuation cancellableContinuation) {
            this.f = cancellableContinuation;
        }

        @Override // sdk.pendo.io.y6.d
        public void a(sdk.pendo.io.y6.b<T> call, Throwable t) {
            Intrinsics.checkParameterIsNotNull(call, "call");
            Intrinsics.checkParameterIsNotNull(t, "t");
            CancellableContinuation cancellableContinuation = this.f;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m1227constructorimpl(ResultKt.createFailure(t)));
        }

        @Override // sdk.pendo.io.y6.d
        public void a(sdk.pendo.io.y6.b<T> call, r<T> response) {
            CancellableContinuation cancellableContinuation;
            Object createFailure;
            Intrinsics.checkParameterIsNotNull(call, "call");
            Intrinsics.checkParameterIsNotNull(response, "response");
            if (response.d()) {
                createFailure = response.a();
                if (createFailure == null) {
                    Object a2 = call.a().a(j.class);
                    if (a2 == null) {
                        Intrinsics.throwNpe();
                    }
                    Intrinsics.checkExpressionValueIsNotNull(a2, "call.request().tag(Invocation::class.java)!!");
                    Method method = ((j) a2).a();
                    StringBuilder sb = new StringBuilder("Response from ");
                    Intrinsics.checkExpressionValueIsNotNull(method, "method");
                    Class<?> declaringClass = method.getDeclaringClass();
                    Intrinsics.checkExpressionValueIsNotNull(declaringClass, "method.declaringClass");
                    KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException(sb.append(declaringClass.getName()).append('.').append(method.getName()).append(" was null but response body type was declared as non-null").toString());
                    cancellableContinuation = this.f;
                    Result.Companion companion = Result.INSTANCE;
                    createFailure = ResultKt.createFailure(kotlinNullPointerException);
                } else {
                    cancellableContinuation = this.f;
                    Result.Companion companion2 = Result.INSTANCE;
                }
            } else {
                cancellableContinuation = this.f;
                sdk.pendo.io.y6.h hVar = new sdk.pendo.io.y6.h(response);
                Result.Companion companion3 = Result.INSTANCE;
                createFailure = ResultKt.createFailure(hVar);
            }
            cancellableContinuation.resumeWith(Result.m1227constructorimpl(createFailure));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001J(\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00022\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0004H\u0016J \u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"sdk/pendo/io/y6/k$d", "Lsdk/pendo/io/y6/d;", "Lsdk/pendo/io/y6/b;", NotificationCompat.CATEGORY_CALL, "Lsdk/pendo/io/y6/r;", Response.TYPE, "", "a", "", "t", "retrofit"}, k = 1, mv = {1, 4, 0})
    public static final class d<T> implements sdk.pendo.io.y6.d<T> {
        final /* synthetic */ CancellableContinuation f;

        d(CancellableContinuation cancellableContinuation) {
            this.f = cancellableContinuation;
        }

        @Override // sdk.pendo.io.y6.d
        public void a(sdk.pendo.io.y6.b<T> call, Throwable t) {
            Intrinsics.checkParameterIsNotNull(call, "call");
            Intrinsics.checkParameterIsNotNull(t, "t");
            CancellableContinuation cancellableContinuation = this.f;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m1227constructorimpl(ResultKt.createFailure(t)));
        }

        @Override // sdk.pendo.io.y6.d
        public void a(sdk.pendo.io.y6.b<T> call, r<T> response) {
            CancellableContinuation cancellableContinuation;
            Object createFailure;
            Intrinsics.checkParameterIsNotNull(call, "call");
            Intrinsics.checkParameterIsNotNull(response, "response");
            if (response.d()) {
                cancellableContinuation = this.f;
                createFailure = response.a();
                Result.Companion companion = Result.INSTANCE;
            } else {
                cancellableContinuation = this.f;
                sdk.pendo.io.y6.h hVar = new sdk.pendo.io.y6.h(response);
                Result.Companion companion2 = Result.INSTANCE;
                createFailure = ResultKt.createFailure(hVar);
            }
            cancellableContinuation.resumeWith(Result.m1227constructorimpl(createFailure));
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "L;", "it", "", "invoke", "(L;)V", "kotlin/Throwable", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    static final class e extends Lambda implements Function1<Throwable, Unit> {
        final /* synthetic */ sdk.pendo.io.y6.b f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(sdk.pendo.io.y6.b bVar) {
            super(1);
            this.f = bVar;
        }

        public final void a(Throwable th) {
            this.f.cancel();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            a(th);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J$\u0010\u0007\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016J\u001e\u0010\u0007\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"sdk/pendo/io/y6/k$f", "Lsdk/pendo/io/y6/d;", "Lsdk/pendo/io/y6/b;", NotificationCompat.CATEGORY_CALL, "Lsdk/pendo/io/y6/r;", Response.TYPE, "", "a", "", "t", "retrofit"}, k = 1, mv = {1, 4, 0})
    public static final class f<T> implements sdk.pendo.io.y6.d<T> {
        final /* synthetic */ CancellableContinuation f;

        f(CancellableContinuation cancellableContinuation) {
            this.f = cancellableContinuation;
        }

        @Override // sdk.pendo.io.y6.d
        public void a(sdk.pendo.io.y6.b<T> call, Throwable t) {
            Intrinsics.checkParameterIsNotNull(call, "call");
            Intrinsics.checkParameterIsNotNull(t, "t");
            CancellableContinuation cancellableContinuation = this.f;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m1227constructorimpl(ResultKt.createFailure(t)));
        }

        @Override // sdk.pendo.io.y6.d
        public void a(sdk.pendo.io.y6.b<T> call, r<T> response) {
            Intrinsics.checkParameterIsNotNull(call, "call");
            Intrinsics.checkParameterIsNotNull(response, "response");
            CancellableContinuation cancellableContinuation = this.f;
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m1227constructorimpl(response));
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "external/sdk/pendo/io/retrofit2/KotlinExtensions$suspendAndThrow$2$1"}, k = 3, mv = {1, 1, 15})
    static final class g implements Runnable {
        final /* synthetic */ Continuation f;
        final /* synthetic */ Exception s;

        g(Continuation continuation, Exception exc) {
            this.f = continuation;
            this.s = exc;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Continuation intercepted = IntrinsicsKt.intercepted(this.f);
            Exception exc = this.s;
            Result.Companion companion = Result.INSTANCE;
            intercepted.resumeWith(Result.m1227constructorimpl(ResultKt.createFailure(exc)));
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0006\u001a\u0004\u0018\u00010\u0005*\u00060\u0000j\u0002`\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0080@"}, d2 = {"Ljava/lang/Exception;", "Lkotlin/Exception;", "Lkotlin/coroutines/Continuation;", "", "continuation", "", "suspendAndThrow"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "external.sdk.pendo.io.retrofit2.KotlinExtensions", f = "KotlinExtensions.kt", i = {0}, l = {113}, m = "suspendAndThrow", n = {"$this$suspendAndThrow"}, s = {"L$0"})
    static final class h extends ContinuationImpl {
        Object A;
        /* synthetic */ Object f;
        int s;

        h(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.s |= Integer.MIN_VALUE;
            return k.a((Exception) null, this);
        }
    }

    public static final <T> Object a(sdk.pendo.io.y6.b<T> bVar, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.invokeOnCancellation(new a(bVar));
        bVar.a(new c(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final <T> Object b(sdk.pendo.io.y6.b<T> bVar, Continuation<? super T> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.invokeOnCancellation(new b(bVar));
        bVar.a(new d(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static final <T> Object c(sdk.pendo.io.y6.b<T> bVar, Continuation<? super r<T>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.invokeOnCancellation(new e(bVar));
        bVar.a(new f(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(java.lang.Exception r4, kotlin.coroutines.Continuation<?> r5) {
        /*
            boolean r0 = r5 instanceof sdk.pendo.io.y6.k.h
            if (r0 == 0) goto L13
            r0 = r5
            sdk.pendo.io.y6.k$h r0 = (sdk.pendo.io.y6.k.h) r0
            int r1 = r0.s
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.s = r1
            goto L18
        L13:
            sdk.pendo.io.y6.k$h r0 = new sdk.pendo.io.y6.k$h
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.s
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.A
            java.lang.Exception r4 = (java.lang.Exception) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L5c
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.A = r4
            r0.s = r3
            kotlinx.coroutines.CoroutineDispatcher r5 = kotlinx.coroutines.Dispatchers.getDefault()
            kotlin.coroutines.CoroutineContext r2 = r0.get$context()
            sdk.pendo.io.y6.k$g r3 = new sdk.pendo.io.y6.k$g
            r3.<init>(r0, r4)
            r5.mo2800dispatch(r2, r3)
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r4 != r5) goto L59
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        L59:
            if (r4 != r1) goto L5c
            return r1
        L5c:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.y6.k.a(java.lang.Exception, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
