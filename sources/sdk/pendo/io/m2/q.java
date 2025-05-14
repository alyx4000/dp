package sdk.pendo.io.m2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import kotlin.DeepRecursiveFunction;
import kotlin.DeepRecursiveKt;
import kotlin.DeepRecursiveScope;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J#\u0010\u0006\u001a\u00020\u0002*\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00020\u0004H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0002R\u0014\u0010\u000f\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lsdk/pendo/io/m2/q;", "", "Lsdk/pendo/io/l2/h;", "d", "Lkotlin/DeepRecursiveScope;", "", "a", "(Lkotlin/DeepRecursiveScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b", "", "isString", "Lsdk/pendo/io/l2/u;", "c", "Lsdk/pendo/io/m2/a;", "Lsdk/pendo/io/m2/a;", "lexer", "Z", "isLenient", "", "I", "stackDepth", "Lsdk/pendo/io/l2/f;", "configuration", "<init>", "(Lkotlinx/serialization/json/JsonConfiguration;Lkotlinx/serialization/json/internal/AbstractJsonLexer;)V", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final sdk.pendo.io.m2.a lexer;

    /* renamed from: b, reason: from kotlin metadata */
    private final boolean isLenient;

    /* renamed from: c, reason: from kotlin metadata */
    private int stackDepth;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0002*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001H\u008a@"}, d2 = {"Lkotlin/DeepRecursiveScope;", "", "Lsdk/pendo/io/l2/h;", "it", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "external.sdk.pendo.io.kotlinx.serialization.json.internal.JsonTreeReader$readDeepRecursive$1", f = "JsonTreeReader.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends RestrictedSuspendLambda implements Function3<DeepRecursiveScope<Unit, sdk.pendo.io.l2.h>, Unit, Continuation<? super sdk.pendo.io.l2.h>, Object> {
        int f;
        private /* synthetic */ Object s;

        a(Continuation<? super a> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(DeepRecursiveScope<Unit, sdk.pendo.io.l2.h> deepRecursiveScope, Unit unit, Continuation<? super sdk.pendo.io.l2.h> continuation) {
            a aVar = q.this.new a(continuation);
            aVar.s = deepRecursiveScope;
            return aVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                DeepRecursiveScope deepRecursiveScope = (DeepRecursiveScope) this.s;
                byte m = q.this.lexer.m();
                if (m == 1) {
                    return q.this.a(true);
                }
                if (m == 0) {
                    return q.this.a(false);
                }
                if (m != 6) {
                    if (m == 8) {
                        return q.this.b();
                    }
                    sdk.pendo.io.m2.a.a(q.this.lexer, "Can't begin reading element, unexpected token", 0, 2, null);
                    throw new KotlinNothingValueException();
                }
                q qVar = q.this;
                this.f = 1;
                obj = qVar.a((DeepRecursiveScope<Unit, sdk.pendo.io.l2.h>) deepRecursiveScope, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return (sdk.pendo.io.l2.h) obj;
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "external.sdk.pendo.io.kotlinx.serialization.json.internal.JsonTreeReader", f = "JsonTreeReader.kt", i = {0, 0, 0, 0}, l = {23}, m = "readObject", n = {"$this$readObject", "this_$iv", "result$iv", "key$iv"}, s = {"L$0", "L$1", "L$2", "L$3"})
    static final class b extends ContinuationImpl {
        Object A;
        Object f;
        Object f0;
        Object s;
        /* synthetic */ Object t0;
        int v0;

        b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.t0 = obj;
            this.v0 |= Integer.MIN_VALUE;
            return q.this.a((DeepRecursiveScope<Unit, sdk.pendo.io.l2.h>) null, this);
        }
    }

    public q(sdk.pendo.io.l2.f configuration, sdk.pendo.io.m2.a lexer) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(lexer, "lexer");
        this.lexer = lexer;
        this.isLenient = configuration.getIsLenient();
    }

    private final sdk.pendo.io.l2.h c() {
        return (sdk.pendo.io.l2.h) DeepRecursiveKt.invoke(new DeepRecursiveFunction(new a(null)), Unit.INSTANCE);
    }

    private final sdk.pendo.io.l2.h d() {
        byte a2 = this.lexer.a((byte) 6);
        if (this.lexer.m() == 4) {
            sdk.pendo.io.m2.a.a(this.lexer, "Unexpected leading comma", 0, 2, null);
            throw new KotlinNothingValueException();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (true) {
            if (!this.lexer.a()) {
                break;
            }
            String h = this.isLenient ? this.lexer.h() : this.lexer.g();
            this.lexer.a((byte) 5);
            linkedHashMap.put(h, a());
            a2 = this.lexer.e();
            if (a2 != 4) {
                if (a2 != 7) {
                    sdk.pendo.io.m2.a.a(this.lexer, "Expected end of the object or comma", 0, 2, null);
                    throw new KotlinNothingValueException();
                }
            }
        }
        if (a2 == 6) {
            this.lexer.a((byte) 7);
        } else if (a2 == 4) {
            sdk.pendo.io.m2.a.a(this.lexer, "Unexpected trailing comma", 0, 2, null);
            throw new KotlinNothingValueException();
        }
        return new sdk.pendo.io.l2.s(linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final sdk.pendo.io.l2.h b() {
        int i;
        byte e = this.lexer.e();
        if (this.lexer.m() == 4) {
            sdk.pendo.io.m2.a.a(this.lexer, "Unexpected leading comma", 0, 2, null);
            throw new KotlinNothingValueException();
        }
        ArrayList arrayList = new ArrayList();
        while (this.lexer.a()) {
            arrayList.add(a());
            e = this.lexer.e();
            if (e != 4) {
                sdk.pendo.io.m2.a aVar = this.lexer;
                boolean z = e == 9;
                i = aVar.currentPosition;
                if (!z) {
                    aVar.b("Expected end of the array or comma", i);
                    throw new KotlinNothingValueException();
                }
            }
        }
        if (e == 8) {
            this.lexer.a((byte) 9);
        } else if (e == 4) {
            sdk.pendo.io.m2.a.a(this.lexer, "Unexpected trailing comma", 0, 2, null);
            throw new KotlinNothingValueException();
        }
        return new sdk.pendo.io.l2.b(arrayList);
    }

    public final sdk.pendo.io.l2.h a() {
        byte m = this.lexer.m();
        if (m == 1) {
            return a(true);
        }
        if (m == 0) {
            return a(false);
        }
        if (m != 6) {
            if (m == 8) {
                return b();
            }
            sdk.pendo.io.m2.a.a(this.lexer, Intrinsics.stringPlus("Cannot begin reading element, unexpected token: ", Byte.valueOf(m)), 0, 2, null);
            throw new KotlinNothingValueException();
        }
        int i = this.stackDepth + 1;
        this.stackDepth = i;
        this.stackDepth--;
        return i == 200 ? c() : d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x009f -> B:10:0x00a9). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(kotlin.DeepRecursiveScope<kotlin.Unit, sdk.pendo.io.l2.h> r19, kotlin.coroutines.Continuation<? super sdk.pendo.io.l2.h> r20) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.m2.q.a(kotlin.DeepRecursiveScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final sdk.pendo.io.l2.u a(boolean isString) {
        String h = (this.isLenient || !isString) ? this.lexer.h() : this.lexer.g();
        return (isString || !Intrinsics.areEqual(h, "null")) ? new sdk.pendo.io.l2.n(h, isString) : sdk.pendo.io.l2.q.INSTANCE;
    }
}
