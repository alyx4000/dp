package sdk.pendo.io.j9;

import expo.modules.interfaces.permissions.PermissionsResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import sdk.pendo.io.logging.PendoLogger;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\n\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0007\u001a\u00020\u0004R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\tR\u0017\u0010\u000f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0015R(\u0010\u001f\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0018\u0010\u0019\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\"\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010!¨\u0006'"}, d2 = {"Lsdk/pendo/io/j9/a;", "", "", "data", "", "b", "", "a", "Ljava/io/File;", "Ljava/io/File;", "realFile", "", "I", "d", "()I", "openMode", "Lkotlinx/coroutines/CoroutineScope;", "c", "Lkotlinx/coroutines/CoroutineScope;", PermissionsResponse.SCOPE_KEY, "Lkotlinx/coroutines/sync/Mutex;", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Ljava/io/BufferedOutputStream;", "e", "Ljava/io/BufferedOutputStream;", "()Ljava/io/BufferedOutputStream;", "setOut", "(Ljava/io/BufferedOutputStream;)V", "getOut$annotations", "()V", "out", "", "()Z", "exist", "Lkotlinx/coroutines/CoroutineDispatcher;", "ioDispatcher", "<init>", "(Ljava/io/File;ILkotlinx/coroutines/CoroutineDispatcher;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final File realFile;

    /* renamed from: b, reason: from kotlin metadata */
    private final int openMode;

    /* renamed from: c, reason: from kotlin metadata */
    private final CoroutineScope scope;

    /* renamed from: d, reason: from kotlin metadata */
    private final Mutex mutex;

    /* renamed from: e, reason: from kotlin metadata */
    private BufferedOutputStream out;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.utilities.fileUtils.FileThreadSafe$flush$1", f = "FileThreadSafe.kt", i = {0}, l = {119}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
    /* renamed from: sdk.pendo.io.j9.a$a, reason: collision with other inner class name */
    static final class C0166a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int A;
        Object f;
        Object s;

        C0166a(Continuation<? super C0166a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C0166a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return a.this.new C0166a(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Mutex mutex;
            a aVar;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.A;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                mutex = a.this.mutex;
                a aVar2 = a.this;
                this.f = mutex;
                this.s = aVar2;
                this.A = 1;
                if (mutex.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                aVar = aVar2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                aVar = (a) this.s;
                mutex = (Mutex) this.f;
                ResultKt.throwOnFailure(obj);
            }
            try {
                try {
                    aVar.getOut().flush();
                } catch (Exception e) {
                    PendoLogger.d(e, "FileThreadSafe flush", new Object[0]);
                }
                Unit unit = Unit.INSTANCE;
                mutex.unlock(null);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
    @DebugMetadata(c = "sdk.pendo.io.utilities.fileUtils.FileThreadSafe$writeAndFlush$1", f = "FileThreadSafe.kt", i = {0}, l = {119}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object A;
        Object f;
        int f0;
        Object s;
        final /* synthetic */ String u0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, Continuation<? super b> continuation) {
            super(2, continuation);
            this.u0 = str;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return a.this.new b(this.u0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            a aVar;
            Mutex mutex;
            String str;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f0;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Mutex mutex2 = a.this.mutex;
                aVar = a.this;
                String str2 = this.u0;
                this.f = mutex2;
                this.s = aVar;
                this.A = str2;
                this.f0 = 1;
                if (mutex2.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex = mutex2;
                str = str2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str = (String) this.A;
                aVar = (a) this.s;
                mutex = (Mutex) this.f;
                ResultKt.throwOnFailure(obj);
            }
            try {
                aVar.b(str);
                aVar.b();
                Unit unit = Unit.INSTANCE;
                mutex.unlock(null);
                return Unit.INSTANCE;
            } catch (Throwable th) {
                mutex.unlock(null);
                throw th;
            }
        }
    }

    public a(File realFile, int i, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(realFile, "realFile");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.realFile = realFile;
        this.openMode = i;
        this.scope = CoroutineScopeKt.CoroutineScope(ioDispatcher);
        this.mutex = MutexKt.Mutex$default(false, 1, null);
        this.out = new BufferedOutputStream(new FileOutputStream(realFile, true));
    }

    public final boolean c() {
        return this.realFile.exists();
    }

    /* renamed from: d, reason: from getter */
    public final int getOpenMode() {
        return this.openMode;
    }

    /* renamed from: e, reason: from getter */
    public final BufferedOutputStream getOut() {
        return this.out;
    }

    public /* synthetic */ a(File file, int i, CoroutineDispatcher coroutineDispatcher, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, i, (i2 & 4) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        try {
            this.out.flush();
        } catch (Exception e) {
            PendoLogger.d(e, "FileThreadSafe flush", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(String data) {
        if (data == null || StringsKt.isBlank(data)) {
            return;
        }
        byte[] bytes = data.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        a(bytes);
    }

    public final void a() {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new C0166a(null), 3, null);
    }

    public final void a(String data) {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new b(data, null), 3, null);
    }

    private final void a(byte[] data) {
        if (data != null) {
            try {
                this.out.write(data);
            } catch (Exception e) {
                PendoLogger.d(e, "FileThreadSafe writeToFile", new Object[0]);
            }
        }
    }
}
