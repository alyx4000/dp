package sdk.pendo.io.e8;

import android.app.Activity;
import android.graphics.Bitmap;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import org.json.JSONArray;
import org.json.JSONObject;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.f9.f;
import sdk.pendo.io.logging.PendoLogger;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0007B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b,\u0010\u0012J\u001b\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u000e\u0010\u0007\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0007\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Lsdk/pendo/io/e8/a;", "Lkotlinx/coroutines/CoroutineScope;", "Lsdk/pendo/io/h9/c;", "Lsdk/pendo/io/g8/a;", "Landroid/app/Activity;", "activity", "", "a", "(Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/Job;", "Landroid/graphics/Bitmap;", "bitmap", "Lsdk/pendo/io/e8/a$a;", "f", "Lsdk/pendo/io/e8/a$a;", "getListener", "()Lsdk/pendo/io/e8/a$a;", "setListener", "(Lsdk/pendo/io/e8/a$a;)V", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lsdk/pendo/io/f9/f;", "s", "Lkotlin/Lazy;", "()Lsdk/pendo/io/f9/f;", "screenManager", "Lorg/json/JSONObject;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lorg/json/JSONObject;", ActivationManager.SCREEN_DATA_KEY, "Lorg/json/JSONArray;", "f0", "Lorg/json/JSONArray;", "viewTreeJSON", "t0", "Lkotlinx/coroutines/Job;", "job", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "u0", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "coroutineExceptionHandler", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "<init>", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class a extends sdk.pendo.io.g8.a implements CoroutineScope, sdk.pendo.io.h9.c {

    /* renamed from: A, reason: from kotlin metadata */
    private JSONObject retroactiveScreenData;

    /* renamed from: f, reason: from kotlin metadata */
    private InterfaceC0122a listener;

    /* renamed from: f0, reason: from kotlin metadata */
    private JSONArray viewTreeJSON;

    /* renamed from: s, reason: from kotlin metadata */
    private final Lazy screenManager;

    /* renamed from: t0, reason: from kotlin metadata */
    private Job job;

    /* renamed from: u0, reason: from kotlin metadata */
    private final CoroutineExceptionHandler coroutineExceptionHandler;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0004"}, d2 = {"Lsdk/pendo/io/e8/a$a;", "", "", "a", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    /* renamed from: sdk.pendo.io.e8.a$a, reason: collision with other inner class name */
    public interface InterfaceC0122a {
        void a();
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.async.CaptureScreenJob$doInBackground$2", f = "CaptureScreenJob.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity A;
        int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Activity activity, Continuation<? super b> continuation) {
            super(2, continuation);
            this.A = activity;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return a.this.new b(this.A, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            try {
                a aVar = a.this;
                aVar.retroactiveScreenData = aVar.a().j();
                a aVar2 = a.this;
                aVar2.viewTreeJSON = aVar2.a().a();
                a.this.a().a(this.A, a.this);
            } catch (Exception e) {
                PendoLogger.e(e, "Screen capture background operation", new Object[0]);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.async.CaptureScreenJob$executeTask$1", f = "CaptureScreenJob.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity A;
        int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Activity activity, Continuation<? super c> continuation) {
            super(2, continuation);
            this.A = activity;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return a.this.new c(this.A, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                a aVar = a.this;
                Activity activity = this.A;
                this.f = 1;
                if (aVar.a(activity, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "exception", "", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0})
    public static final class d extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public d(CoroutineExceptionHandler.Companion companion) {
            super(companion);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(CoroutineContext context, Throwable exception) {
            PendoLogger.e(exception);
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0004\u001a\u00028\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "invoke", "()Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    public static final class e extends Lambda implements Function0<f> {
        final /* synthetic */ Function0 A;
        final /* synthetic */ sdk.pendo.io.i5.a f;
        final /* synthetic */ sdk.pendo.io.q5.a s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(sdk.pendo.io.i5.a aVar, sdk.pendo.io.q5.a aVar2, Function0 function0) {
            super(0);
            this.f = aVar;
            this.s = aVar2;
            this.A = function0;
        }

        /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Object, sdk.pendo.io.f9.f] */
        @Override // kotlin.jvm.functions.Function0
        public final f invoke() {
            sdk.pendo.io.i5.a aVar = this.f;
            return (aVar instanceof sdk.pendo.io.i5.b ? ((sdk.pendo.io.i5.b) aVar).getScope() : aVar.getKoin().getScopeRegistry().getRootScope()).b(Reflection.getOrCreateKotlinClass(f.class), this.s, this.A);
        }
    }

    public a(InterfaceC0122a listener) {
        CompletableJob Job$default;
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        this.screenManager = LazyKt.lazy(sdk.pendo.io.v5.b.f1684a.a(), (Function0) new e(this, null, null));
        Job$default = JobKt__JobKt.Job$default((Job) null, 1, (Object) null);
        this.job = Job$default;
        this.coroutineExceptionHandler = new d(CoroutineExceptionHandler.INSTANCE);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return Dispatchers.getMain().plus(this.job).plus(this.coroutineExceptionHandler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object a(Activity activity, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new b(activity, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final Job a(Activity activity) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(activity, "activity");
        launch$default = BuildersKt__Builders_commonKt.launch$default(this, null, null, new c(activity, null), 3, null);
        return launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final f a() {
        return (f) this.screenManager.getValue();
    }

    @Override // sdk.pendo.io.h9.c
    public void a(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        sdk.pendo.io.v8.a.a(this.retroactiveScreenData, this.viewTreeJSON, bitmap);
        this.listener.a();
    }
}
