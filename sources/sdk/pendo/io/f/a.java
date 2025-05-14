package sdk.pendo.io.f;

import androidx.core.app.NotificationCompat;
import io.sentry.protocol.Response;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import sdk.pendo.io.w2.d0;
import sdk.pendo.io.w2.e0;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\u001a\u0017\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0004"}, d2 = {"Lsdk/pendo/io/w2/e;", "", "await", "(Lokhttp3/Call;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "certificatetransparency"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class a {

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.CallExtKt$await$2", f = "CallExt.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: sdk.pendo.io.f.a$a, reason: collision with other inner class name */
    static final class C0125a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {
        final /* synthetic */ sdk.pendo.io.w2.e A;
        Object f;
        int s;

        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"sdk/pendo/io/f/a$a$a", "Lsdk/pendo/io/w2/f;", "Lsdk/pendo/io/w2/e;", NotificationCompat.CATEGORY_CALL, "Lsdk/pendo/io/w2/d0;", Response.TYPE, "", "a", "Ljava/io/IOException;", "e", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
        /* renamed from: sdk.pendo.io.f.a$a$a, reason: collision with other inner class name */
        public static final class C0126a implements sdk.pendo.io.w2.f {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CancellableContinuation<byte[]> f1039a;

            /* JADX WARN: Multi-variable type inference failed */
            C0126a(CancellableContinuation<? super byte[]> cancellableContinuation) {
                this.f1039a = cancellableContinuation;
            }

            @Override // sdk.pendo.io.w2.f
            public void a(sdk.pendo.io.w2.e call, IOException e) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(e, "e");
                if (this.f1039a.isCancelled()) {
                    return;
                }
                CancellableContinuation<byte[]> cancellableContinuation = this.f1039a;
                Result.Companion companion = Result.INSTANCE;
                cancellableContinuation.resumeWith(Result.m1227constructorimpl(ResultKt.createFailure(e)));
            }

            @Override // sdk.pendo.io.w2.f
            public void a(sdk.pendo.io.w2.e call, d0 response) {
                Object m1227constructorimpl;
                CancellableContinuation<byte[]> cancellableContinuation;
                Object createFailure;
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                try {
                    e0 b = response.b();
                    byte[] b2 = b != null ? b.b() : null;
                    if (!response.s()) {
                        cancellableContinuation = this.f1039a;
                        Result.Companion companion = Result.INSTANCE;
                        createFailure = ResultKt.createFailure(new IOException("Invalid response " + response.getCom.socure.docv.capturesdk.common.utils.ApiConstant.KEY_CODE java.lang.String()));
                    } else {
                        if (b2 != null) {
                            CancellableContinuation<byte[]> cancellableContinuation2 = this.f1039a;
                            Result.Companion companion2 = Result.INSTANCE;
                            m1227constructorimpl = Result.m1227constructorimpl(b2);
                            cancellableContinuation = cancellableContinuation2;
                            cancellableContinuation.resumeWith(m1227constructorimpl);
                        }
                        cancellableContinuation = this.f1039a;
                        Result.Companion companion3 = Result.INSTANCE;
                        createFailure = ResultKt.createFailure(new IOException("No data"));
                    }
                    m1227constructorimpl = Result.m1227constructorimpl(createFailure);
                    cancellableContinuation.resumeWith(m1227constructorimpl);
                } catch (Exception e) {
                    CancellableContinuation<byte[]> cancellableContinuation3 = this.f1039a;
                    Result.Companion companion4 = Result.INSTANCE;
                    cancellableContinuation3.resumeWith(Result.m1227constructorimpl(ResultKt.createFailure(e)));
                }
            }
        }

        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "a", "(Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 6, 0})
        /* renamed from: sdk.pendo.io.f.a$a$b */
        static final class b extends Lambda implements Function1<Throwable, Unit> {
            final /* synthetic */ sdk.pendo.io.w2.e f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(sdk.pendo.io.w2.e eVar) {
                super(1);
                this.f = eVar;
            }

            public final void a(Throwable th) {
                try {
                    this.f.cancel();
                } catch (Throwable unused) {
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                a(th);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0125a(sdk.pendo.io.w2.e eVar, Continuation<? super C0125a> continuation) {
            super(2, continuation);
            this.A = eVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super byte[]> continuation) {
            return ((C0125a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C0125a(this.A, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.s;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                sdk.pendo.io.w2.e eVar = this.A;
                this.f = eVar;
                this.s = 1;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
                cancellableContinuationImpl.initCancellability();
                eVar.a(new C0126a(cancellableContinuationImpl));
                cancellableContinuationImpl.invokeOnCancellation(new b(eVar));
                obj = cancellableContinuationImpl.getResult();
                if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(this);
                }
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

    public static final Object a(sdk.pendo.io.w2.e eVar, Continuation<? super byte[]> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new C0125a(eVar, null), continuation);
    }
}
