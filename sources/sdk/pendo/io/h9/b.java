package sdk.pendo.io.h9;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import sdk.pendo.io.g9.q0;
import sdk.pendo.io.logging.PendoLogger;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0003B%\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\n\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0003\u001a\u00020\u0002H\u0007J)\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\tR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\n8\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0011\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\f\u0010\u0013\u001a\u0004\b\u000f\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lsdk/pendo/io/h9/b;", "", "", "a", "Lsdk/pendo/io/g9/q0$b;", "data", "Lkotlin/Pair;", "", "Landroid/graphics/Bitmap;", "(Lsdk/pendo/io/g9/q0$b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "Ljava/util/List;", "c", "()Ljava/util/List;", "screens", "b", "Landroid/graphics/Bitmap;", "finalBitmap", "Lsdk/pendo/io/h9/c;", "Lsdk/pendo/io/h9/c;", "()Lsdk/pendo/io/h9/c;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Ljava/util/List;Landroid/graphics/Bitmap;Lsdk/pendo/io/h9/c;)V", "d", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<q0.b> screens;

    /* renamed from: b, reason: from kotlin metadata */
    private final Bitmap finalBitmap;

    /* renamed from: c, reason: from kotlin metadata */
    private final sdk.pendo.io.h9.c listener;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.utilities.captureScreen.PixelCopyCaptureScreen$captureScreenToBitmap$1", f = "PixelCopyCaptureScreen.kt", i = {0}, l = {24}, m = "invokeSuspend", n = {"iterator"}, s = {"L$0"})
    /* renamed from: sdk.pendo.io.h9.b$b, reason: collision with other inner class name */
    static final class C0152b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object f;
        int s;

        C0152b(Continuation<? super C0152b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C0152b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new C0152b(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Iterator<q0.b> it;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.s;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Iterator<q0.b> it2 = b.this.c().iterator();
                b bVar = b.this;
                q0.b next = it2.next();
                this.f = it2;
                this.s = 1;
                if (bVar.a(next, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                it = it2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) this.f;
                ResultKt.throwOnFailure(obj);
            }
            while (it.hasNext()) {
                a.INSTANCE.a(it.next(), b.this.finalBitmap);
            }
            b.this.getListener().a(b.this.finalBitmap);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.utilities.captureScreen.PixelCopyCaptureScreen$execute$$inlined$suspendCoroutineWithTimeout$1", f = "PixelCopyCaptureScreen.kt", i = {}, l = {14}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef A;
        Object f;
        final /* synthetic */ q0.b f0;
        int s;
        final /* synthetic */ b t0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Ref.ObjectRef objectRef, Continuation continuation, q0.b bVar, b bVar2) {
            super(2, continuation);
            this.A = objectRef;
            this.f0 = bVar;
            this.t0 = bVar2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(this.A, continuation, this.f0, this.t0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Ref.ObjectRef objectRef;
            T t;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.s;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Ref.ObjectRef objectRef2 = this.A;
                this.f = objectRef2;
                this.s = 1;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(this), 1);
                cancellableContinuationImpl.initCancellability();
                try {
                    PixelCopy.request(sdk.pendo.io.n8.c.g().f().getWindow(), this.f0.b(), this.t0.finalBitmap, new e(cancellableContinuationImpl, this.t0), new Handler(Looper.getMainLooper()));
                } catch (Exception e) {
                    PendoLogger.e(e, e.getMessage(), "PixelCopy.request");
                }
                Object result = cancellableContinuationImpl.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(this);
                }
                if (result == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef = objectRef2;
                t = result;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef = (Ref.ObjectRef) this.f;
                ResultKt.throwOnFailure(obj);
                t = obj;
            }
            objectRef.element = t;
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "sdk.pendo.io.utilities.captureScreen.PixelCopyCaptureScreen", f = "PixelCopyCaptureScreen.kt", i = {0}, l = {65}, m = "execute", n = {"finalValue$iv"}, s = {"L$0"})
    static final class d extends ContinuationImpl {
        Object f;
        int f0;
        /* synthetic */ Object s;

        d(Continuation<? super d> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.s = obj;
            this.f0 |= Integer.MIN_VALUE;
            return b.this.a(null, this);
        }
    }

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "copyResult", "", "onPixelCopyFinished"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class e implements PixelCopy.OnPixelCopyFinishedListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Continuation<Pair<Integer, Bitmap>> f1169a;
        final /* synthetic */ b b;

        /* JADX WARN: Multi-variable type inference failed */
        e(Continuation<? super Pair<Integer, Bitmap>> continuation, b bVar) {
            this.f1169a = continuation;
            this.b = bVar;
        }

        @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
        public final void onPixelCopyFinished(int i) {
            if (i != 0) {
                PendoLogger.e("PixelCopyCaptureScreen -> PixelCopyFinished: " + i, new Object[0]);
            }
            Continuation<Pair<Integer, Bitmap>> continuation = this.f1169a;
            Result.Companion companion = Result.INSTANCE;
            continuation.resumeWith(Result.m1227constructorimpl(new Pair(Integer.valueOf(i), this.b.finalBitmap)));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(List<? extends q0.b> screens, Bitmap finalBitmap, sdk.pendo.io.h9.c listener) {
        Intrinsics.checkNotNullParameter(screens, "screens");
        Intrinsics.checkNotNullParameter(finalBitmap, "finalBitmap");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.screens = screens;
        this.finalBitmap = finalBitmap;
        this.listener = listener;
    }

    /* renamed from: b, reason: from getter */
    public final sdk.pendo.io.h9.c getListener() {
        return this.listener;
    }

    public final List<q0.b> c() {
        return this.screens;
    }

    public final void a() {
        BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, null, null, new C0152b(null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(sdk.pendo.io.g9.q0.b r6, kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.Integer, android.graphics.Bitmap>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof sdk.pendo.io.h9.b.d
            if (r0 == 0) goto L13
            r0 = r7
            sdk.pendo.io.h9.b$d r0 = (sdk.pendo.io.h9.b.d) r0
            int r1 = r0.f0
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f0 = r1
            goto L18
        L13:
            sdk.pendo.io.h9.b$d r0 = new sdk.pendo.io.h9.b$d
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.s
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f0
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r6 = r0.f
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L51
        L2d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L35:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            sdk.pendo.io.h9.b$c r2 = new sdk.pendo.io.h9.b$c
            r4 = 0
            r2.<init>(r7, r4, r6, r5)
            r0.f = r7
            r0.f0 = r3
            r3 = 5000(0x1388, double:2.4703E-320)
            java.lang.Object r6 = kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(r3, r2, r0)
            if (r6 != r1) goto L50
            return r1
        L50:
            r6 = r7
        L51:
            T r6 = r6.element
            kotlin.Pair r6 = (kotlin.Pair) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.h9.b.a(sdk.pendo.io.g9.q0$b, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
