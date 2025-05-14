package sdk.pendo.io.d;

import com.facebook.react.uimanager.ViewProps;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001J\u0015\u0010\u0003\u001a\u0004\u0018\u00018\u0000H¦@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u0003\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\bJ\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J,\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0000\"\b\b\u0001\u0010\n*\u00020\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000bH\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lsdk/pendo/io/d/a;", "", "Value", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "value", "", "b", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "MappedValue", "Lkotlin/Function1;", ViewProps.TRANSFORM, "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public interface a<Value> {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* renamed from: sdk.pendo.io.d.a$a, reason: collision with other inner class name */
    public static final class C0099a {

        @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0015\u0010\u0002\u001a\u0004\u0018\u00018\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0002\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0006J\u001b\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"sdk/pendo/io/d/a$a$a", "Lsdk/pendo/io/d/a;", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "value", "", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "b", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
        /* renamed from: sdk.pendo.io.d.a$a$a, reason: collision with other inner class name */
        public static final class C0100a implements a<Value> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ a<Value> f970a;
            final /* synthetic */ a<Value> b;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            @DebugMetadata(c = "external.sdk.pendo.io.com.appmattus.certificatetransparency.datasource.DataSource$compose$1", f = "DataSource.kt", i = {0, 1, 1, 2}, l = {57, 59, 62, 62}, m = "get", n = {"this", "this", "result", "this"}, s = {"L$0", "L$0", "L$1", "L$0"})
            /* renamed from: sdk.pendo.io.d.a$a$a$a, reason: collision with other inner class name */
            static final class C0101a extends ContinuationImpl {
                /* synthetic */ Object A;
                Object f;
                Object s;
                int t0;

                C0101a(Continuation<? super C0101a> continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.A = obj;
                    this.t0 |= Integer.MIN_VALUE;
                    return C0100a.this.a(this);
                }
            }

            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@"}, d2 = {"", "Value", "Lkotlinx/coroutines/CoroutineScope;", "", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
            @DebugMetadata(c = "external.sdk.pendo.io.com.appmattus.certificatetransparency.datasource.DataSource$compose$1$set$2", f = "DataSource.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: sdk.pendo.io.d.a$a$a$b */
            static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Unit>>, Object> {
                final /* synthetic */ a<Value> A;
                int f;
                final /* synthetic */ Value f0;
                private /* synthetic */ Object s;
                final /* synthetic */ a<Value> t0;

                @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@"}, d2 = {"", "Value", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
                @DebugMetadata(c = "external.sdk.pendo.io.com.appmattus.certificatetransparency.datasource.DataSource$compose$1$set$2$1", f = "DataSource.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: sdk.pendo.io.d.a$a$a$b$a, reason: collision with other inner class name */
                static final class C0102a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Value A;
                    int f;
                    final /* synthetic */ a<Value> s;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C0102a(a<Value> aVar, Value value, Continuation<? super C0102a> continuation) {
                        super(2, continuation);
                        this.s = aVar;
                        this.A = value;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C0102a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C0102a(this.s, this.A, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.f;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            a<Value> aVar = this.s;
                            Value value = this.A;
                            this.f = 1;
                            if (aVar.b(value, this) == coroutine_suspended) {
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

                @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@"}, d2 = {"", "Value", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
                @DebugMetadata(c = "external.sdk.pendo.io.com.appmattus.certificatetransparency.datasource.DataSource$compose$1$set$2$2", f = "DataSource.kt", i = {}, l = {70}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: sdk.pendo.io.d.a$a$a$b$b, reason: collision with other inner class name */
                static final class C0103b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ Value A;
                    int f;
                    final /* synthetic */ a<Value> s;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C0103b(a<Value> aVar, Value value, Continuation<? super C0103b> continuation) {
                        super(2, continuation);
                        this.s = aVar;
                        this.A = value;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C0103b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C0103b(this.s, this.A, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.f;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            a<Value> aVar = this.s;
                            Value value = this.A;
                            this.f = 1;
                            if (aVar.b(value, this) == coroutine_suspended) {
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

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                b(a<Value> aVar, Value value, a<Value> aVar2, Continuation<? super b> continuation) {
                    super(2, continuation);
                    this.A = aVar;
                    this.f0 = value;
                    this.t0 = aVar2;
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<Unit>> continuation) {
                    return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    b bVar = new b(this.A, this.f0, this.t0, continuation);
                    bVar.s = obj;
                    return bVar;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Deferred async$default;
                    Deferred async$default2;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.f;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        CoroutineScope coroutineScope = (CoroutineScope) this.s;
                        async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new C0102a(this.A, this.f0, null), 3, null);
                        async$default2 = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new C0103b(this.t0, this.f0, null), 3, null);
                        this.f = 1;
                        obj = AwaitKt.awaitAll(new Deferred[]{async$default, async$default2}, this);
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

            C0100a(a<Value> aVar, a<Value> aVar2) {
                this.f970a = aVar;
                this.b = aVar2;
            }

            @Override // sdk.pendo.io.d.a
            public a<Value> a(a<Value> aVar) {
                return C0099a.a(this, aVar);
            }

            @Override // sdk.pendo.io.d.a
            public Object b(Value value, Continuation<? super Unit> continuation) {
                Object coroutineScope = CoroutineScopeKt.coroutineScope(new b(this.f970a, value, this.b, null), continuation);
                return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:19:0x0097  */
            /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:28:0x0084  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x0086  */
            /* JADX WARN: Removed duplicated region for block: B:36:0x0078 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:37:0x0079  */
            /* JADX WARN: Removed duplicated region for block: B:38:0x005b  */
            /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
            @Override // sdk.pendo.io.d.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public java.lang.Object a(kotlin.coroutines.Continuation<? super Value> r10) {
                /*
                    r9 = this;
                    boolean r0 = r10 instanceof sdk.pendo.io.d.a.C0099a.C0100a.C0101a
                    if (r0 == 0) goto L13
                    r0 = r10
                    sdk.pendo.io.d.a$a$a$a r0 = (sdk.pendo.io.d.a.C0099a.C0100a.C0101a) r0
                    int r1 = r0.t0
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.t0 = r1
                    goto L18
                L13:
                    sdk.pendo.io.d.a$a$a$a r0 = new sdk.pendo.io.d.a$a$a$a
                    r0.<init>(r10)
                L18:
                    java.lang.Object r10 = r0.A
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.t0
                    r3 = 0
                    r4 = 4
                    r5 = 3
                    r6 = 2
                    r7 = 1
                    if (r2 == 0) goto L5b
                    if (r2 == r7) goto L53
                    if (r2 == r6) goto L46
                    if (r2 == r5) goto L3e
                    if (r2 != r4) goto L36
                    java.lang.Object r3 = r0.f
                    kotlin.ResultKt.throwOnFailure(r10)
                    goto La5
                L36:
                    java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r10.<init>(r0)
                    throw r10
                L3e:
                    java.lang.Object r2 = r0.f
                    sdk.pendo.io.d.a$a$a r2 = (sdk.pendo.io.d.a.C0099a.C0100a) r2
                    kotlin.ResultKt.throwOnFailure(r10)
                    goto L95
                L46:
                    java.lang.Object r2 = r0.s
                    java.lang.Object r6 = r0.f
                    sdk.pendo.io.d.a$a$a r6 = (sdk.pendo.io.d.a.C0099a.C0100a) r6
                    kotlin.ResultKt.throwOnFailure(r10)
                    r8 = r6
                    r6 = r2
                    r2 = r8
                    goto L7c
                L53:
                    java.lang.Object r2 = r0.f
                    sdk.pendo.io.d.a$a$a r2 = (sdk.pendo.io.d.a.C0099a.C0100a) r2
                    kotlin.ResultKt.throwOnFailure(r10)
                    goto L6c
                L5b:
                    kotlin.ResultKt.throwOnFailure(r10)
                    sdk.pendo.io.d.a<Value> r10 = r9.f970a
                    r0.f = r9
                    r0.t0 = r7
                    java.lang.Object r10 = r10.a(r0)
                    if (r10 != r1) goto L6b
                    return r1
                L6b:
                    r2 = r9
                L6c:
                    r0.f = r2
                    r0.s = r10
                    r0.t0 = r6
                    java.lang.Object r6 = r2.a(r10, r0)
                    if (r6 != r1) goto L79
                    return r1
                L79:
                    r8 = r6
                    r6 = r10
                    r10 = r8
                L7c:
                    java.lang.Boolean r10 = (java.lang.Boolean) r10
                    boolean r10 = r10.booleanValue()
                    if (r10 == 0) goto L86
                    r3 = r6
                    goto La5
                L86:
                    sdk.pendo.io.d.a<Value> r10 = r2.b
                    r0.f = r2
                    r0.s = r3
                    r0.t0 = r5
                    java.lang.Object r10 = r10.a(r0)
                    if (r10 != r1) goto L95
                    return r1
                L95:
                    if (r10 == 0) goto La5
                    sdk.pendo.io.d.a<Value> r2 = r2.f970a
                    r0.f = r10
                    r0.t0 = r4
                    java.lang.Object r0 = r2.b(r10, r0)
                    if (r0 != r1) goto La4
                    return r1
                La4:
                    r3 = r10
                La5:
                    return r3
                */
                throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.d.a.C0099a.C0100a.a(kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Override // sdk.pendo.io.d.a
            public Object a(Value value, Continuation<? super Boolean> continuation) {
                return this.f970a.a(value, continuation);
            }

            @Override // sdk.pendo.io.d.a
            public <MappedValue> a<MappedValue> a(Function1<? super Value, ? extends MappedValue> function1) {
                return C0099a.a(this, function1);
            }

            @Override // sdk.pendo.io.d.a
            public a<Value> a() {
                return C0099a.a(this);
            }
        }

        /* JADX INFO: Add missing generic type declarations: [MappedValue] */
        @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0015\u0010\u0002\u001a\u0004\u0018\u00018\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"sdk/pendo/io/d/a$a$b", "Lsdk/pendo/io/d/a;", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "value", "", "b", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
        /* renamed from: sdk.pendo.io.d.a$a$b */
        public static final class b<MappedValue> implements a<MappedValue> {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ a<Value> f971a;
            final /* synthetic */ Function1<Value, MappedValue> b;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            @DebugMetadata(c = "external.sdk.pendo.io.com.appmattus.certificatetransparency.datasource.DataSource$oneWayTransform$1", f = "DataSource.kt", i = {0}, l = {117}, m = "get", n = {"this"}, s = {"L$0"})
            /* renamed from: sdk.pendo.io.d.a$a$b$a, reason: collision with other inner class name */
            static final class C0104a extends ContinuationImpl {
                Object f;
                int f0;
                /* synthetic */ Object s;

                C0104a(Continuation<? super C0104a> continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.s = obj;
                    this.f0 |= Integer.MIN_VALUE;
                    return b.this.a(this);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            b(a<Value> aVar, Function1<? super Value, ? extends MappedValue> function1) {
                this.f971a = aVar;
                this.b = function1;
            }

            @Override // sdk.pendo.io.d.a
            public a<MappedValue> a(a<MappedValue> aVar) {
                return C0099a.a(this, aVar);
            }

            @Override // sdk.pendo.io.d.a
            public Object b(MappedValue mappedvalue, Continuation<? super Unit> continuation) {
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0048  */
            /* JADX WARN: Removed duplicated region for block: B:14:0x004f A[ORIG_RETURN, RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
            /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
            @Override // sdk.pendo.io.d.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public java.lang.Object a(kotlin.coroutines.Continuation<? super MappedValue> r5) {
                /*
                    r4 = this;
                    boolean r0 = r5 instanceof sdk.pendo.io.d.a.C0099a.b.C0104a
                    if (r0 == 0) goto L13
                    r0 = r5
                    sdk.pendo.io.d.a$a$b$a r0 = (sdk.pendo.io.d.a.C0099a.b.C0104a) r0
                    int r1 = r0.f0
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f0 = r1
                    goto L18
                L13:
                    sdk.pendo.io.d.a$a$b$a r0 = new sdk.pendo.io.d.a$a$b$a
                    r0.<init>(r5)
                L18:
                    java.lang.Object r5 = r0.s
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.f0
                    r3 = 1
                    if (r2 == 0) goto L35
                    if (r2 != r3) goto L2d
                    java.lang.Object r0 = r0.f
                    sdk.pendo.io.d.a$a$b r0 = (sdk.pendo.io.d.a.C0099a.b) r0
                    kotlin.ResultKt.throwOnFailure(r5)
                    goto L46
                L2d:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r0)
                    throw r5
                L35:
                    kotlin.ResultKt.throwOnFailure(r5)
                    sdk.pendo.io.d.a<Value> r5 = r4.f971a
                    r0.f = r4
                    r0.f0 = r3
                    java.lang.Object r5 = r5.a(r0)
                    if (r5 != r1) goto L45
                    return r1
                L45:
                    r0 = r4
                L46:
                    if (r5 == 0) goto L4f
                    kotlin.jvm.functions.Function1<Value, MappedValue> r0 = r0.b
                    java.lang.Object r5 = r0.invoke(r5)
                    goto L50
                L4f:
                    r5 = 0
                L50:
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.d.a.C0099a.b.a(kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Override // sdk.pendo.io.d.a
            public Object a(MappedValue mappedvalue, Continuation<? super Boolean> continuation) {
                return C0099a.a(this, mappedvalue, continuation);
            }

            @Override // sdk.pendo.io.d.a
            public <MappedValue> a<MappedValue> a(Function1<? super MappedValue, ? extends MappedValue> function1) {
                return C0099a.a(this, function1);
            }

            @Override // sdk.pendo.io.d.a
            public a<MappedValue> a() {
                return C0099a.a(this);
            }
        }

        @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0015\u0010\u0002\u001a\u0004\u0018\u00018\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0002\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0006J\u001b\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0006R \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"sdk/pendo/io/d/a$a$c", "Lsdk/pendo/io/d/a;", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "value", "", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "b", "Lkotlinx/coroutines/Deferred;", "Lkotlinx/coroutines/Deferred;", "job", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
        /* renamed from: sdk.pendo.io.d.a$a$c */
        public static final class c implements a<Value> {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            private Deferred<? extends Value> job;
            final /* synthetic */ a<Value> b;

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            @DebugMetadata(c = "external.sdk.pendo.io.com.appmattus.certificatetransparency.datasource.DataSource$reuseInflight$1", f = "DataSource.kt", i = {}, l = {90, 99}, m = "get", n = {}, s = {})
            /* renamed from: sdk.pendo.io.d.a$a$c$a, reason: collision with other inner class name */
            static final class C0105a extends ContinuationImpl {
                int A;
                /* synthetic */ Object f;

                C0105a(Continuation<? super C0105a> continuation) {
                    super(continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f = obj;
                    this.A |= Integer.MIN_VALUE;
                    return c.this.a(this);
                }
            }

            @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@"}, d2 = {"", "Value", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/Deferred;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
            @DebugMetadata(c = "external.sdk.pendo.io.com.appmattus.certificatetransparency.datasource.DataSource$reuseInflight$1$get$2", f = "DataSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: sdk.pendo.io.d.a$a$c$b */
            static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Deferred<? extends Value>>, Object> {
                int f;
                final /* synthetic */ a<Value> f0;
                private /* synthetic */ Object s;

                @Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@"}, d2 = {"", "Value", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
                @DebugMetadata(c = "external.sdk.pendo.io.com.appmattus.certificatetransparency.datasource.DataSource$reuseInflight$1$get$2$1", f = "DataSource.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: sdk.pendo.io.d.a$a$c$b$a, reason: collision with other inner class name */
                static final class C0106a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Value>, Object> {
                    int f;
                    final /* synthetic */ a<Value> s;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C0106a(a<Value> aVar, Continuation<? super C0106a> continuation) {
                        super(2, continuation);
                        this.s = aVar;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Value> continuation) {
                        return ((C0106a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C0106a(this.s, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.f;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            a<Value> aVar = this.s;
                            this.f = 1;
                            obj = aVar.a(this);
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

                @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@"}, d2 = {"", "Value", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
                @DebugMetadata(c = "external.sdk.pendo.io.com.appmattus.certificatetransparency.datasource.DataSource$reuseInflight$1$get$2$2$1", f = "DataSource.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: sdk.pendo.io.d.a$a$c$b$b, reason: collision with other inner class name */
                static final class C0107b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ c A;
                    int f;
                    final /* synthetic */ Deferred<Value> s;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C0107b(Deferred<? extends Value> deferred, c cVar, Continuation<? super C0107b> continuation) {
                        super(2, continuation);
                        this.s = deferred;
                        this.A = cVar;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                        return ((C0107b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return new C0107b(this.s, this.A, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        int i = this.f;
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            Deferred<Value> deferred = this.s;
                            this.f = 1;
                            if (deferred.join(this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        this.A.job = null;
                        return Unit.INSTANCE;
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                b(a<Value> aVar, Continuation<? super b> continuation) {
                    super(2, continuation);
                    this.f0 = aVar;
                }

                @Override // kotlin.jvm.functions.Function2
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Deferred<? extends Value>> continuation) {
                    return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    b bVar = c.this.new b(this.f0, continuation);
                    bVar.s = obj;
                    return bVar;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Deferred async$default;
                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    if (this.f != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope = (CoroutineScope) this.s;
                    Deferred deferred = c.this.job;
                    if (deferred != null) {
                        return deferred;
                    }
                    async$default = BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new C0106a(this.f0, null), 3, null);
                    c cVar = c.this;
                    cVar.job = async$default;
                    BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new C0107b(async$default, cVar, null), 3, null);
                    return async$default;
                }
            }

            c(a<Value> aVar) {
                this.b = aVar;
            }

            @Override // sdk.pendo.io.d.a
            public Object b(Value value, Continuation<? super Unit> continuation) {
                Object b2 = this.b.b(value, continuation);
                return b2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? b2 : Unit.INSTANCE;
            }

            @Override // sdk.pendo.io.d.a
            public a<Value> a(a<Value> aVar) {
                return C0099a.a(this, aVar);
            }

            /* JADX WARN: Removed duplicated region for block: B:11:0x0057 A[PHI: r7
  0x0057: PHI (r7v7 java.lang.Object) = (r7v6 java.lang.Object), (r7v1 java.lang.Object) binds: [B:17:0x0054, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:18:0x0056 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
            /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
            @Override // sdk.pendo.io.d.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public java.lang.Object a(kotlin.coroutines.Continuation<? super Value> r7) {
                /*
                    r6 = this;
                    boolean r0 = r7 instanceof sdk.pendo.io.d.a.C0099a.c.C0105a
                    if (r0 == 0) goto L13
                    r0 = r7
                    sdk.pendo.io.d.a$a$c$a r0 = (sdk.pendo.io.d.a.C0099a.c.C0105a) r0
                    int r1 = r0.A
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.A = r1
                    goto L18
                L13:
                    sdk.pendo.io.d.a$a$c$a r0 = new sdk.pendo.io.d.a$a$c$a
                    r0.<init>(r7)
                L18:
                    java.lang.Object r7 = r0.f
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.A
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L38
                    if (r2 == r4) goto L34
                    if (r2 != r3) goto L2c
                    kotlin.ResultKt.throwOnFailure(r7)
                    goto L57
                L2c:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r0)
                    throw r7
                L34:
                    kotlin.ResultKt.throwOnFailure(r7)
                    goto L4c
                L38:
                    kotlin.ResultKt.throwOnFailure(r7)
                    sdk.pendo.io.d.a$a$c$b r7 = new sdk.pendo.io.d.a$a$c$b
                    sdk.pendo.io.d.a<Value> r2 = r6.b
                    r5 = 0
                    r7.<init>(r2, r5)
                    r0.A = r4
                    java.lang.Object r7 = kotlinx.coroutines.CoroutineScopeKt.coroutineScope(r7, r0)
                    if (r7 != r1) goto L4c
                    return r1
                L4c:
                    kotlinx.coroutines.Deferred r7 = (kotlinx.coroutines.Deferred) r7
                    r0.A = r3
                    java.lang.Object r7 = r7.await(r0)
                    if (r7 != r1) goto L57
                    return r1
                L57:
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.d.a.C0099a.c.a(kotlin.coroutines.Continuation):java.lang.Object");
            }

            @Override // sdk.pendo.io.d.a
            public Object a(Value value, Continuation<? super Boolean> continuation) {
                return this.b.a(value, continuation);
            }

            @Override // sdk.pendo.io.d.a
            public <MappedValue> a<MappedValue> a(Function1<? super Value, ? extends MappedValue> function1) {
                return C0099a.a(this, function1);
            }

            @Override // sdk.pendo.io.d.a
            public a<Value> a() {
                return C0099a.a(this);
            }
        }

        public static <Value> a<Value> a(a<Value> aVar, a<Value> b2) {
            Intrinsics.checkNotNullParameter(b2, "b");
            return new C0100a(aVar, b2);
        }

        public static <Value> Object a(a<Value> aVar, Value value, Continuation<? super Boolean> continuation) {
            return Boxing.boxBoolean(value != null);
        }

        public static <Value, MappedValue> a<MappedValue> a(a<Value> aVar, Function1<? super Value, ? extends MappedValue> transform) {
            Intrinsics.checkNotNullParameter(transform, "transform");
            return new b(aVar, transform);
        }

        public static <Value> a<Value> a(a<Value> aVar) {
            return new c(aVar);
        }
    }

    Object a(Value value, Continuation<? super Boolean> continuation);

    Object a(Continuation<? super Value> continuation);

    a<Value> a();

    <MappedValue> a<MappedValue> a(Function1<? super Value, ? extends MappedValue> transform);

    a<Value> a(a<Value> b);

    Object b(Value value, Continuation<? super Unit> continuation);
}
