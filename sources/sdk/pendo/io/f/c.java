package sdk.pendo.io.f;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import sdk.pendo.io.d.a;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0010\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u0004\u001a\u0004\u0018\u00018\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u000b\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lsdk/pendo/io/f/c;", "", "Value", "Lsdk/pendo/io/d/a;", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "value", "", "b", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/lang/Object;", "cachedValue", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public class c<Value> implements sdk.pendo.io.d.a<Value> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private Value cachedValue;

    @Override // sdk.pendo.io.d.a
    public sdk.pendo.io.d.a<Value> a(sdk.pendo.io.d.a<Value> aVar) {
        return a.C0099a.a(this, aVar);
    }

    @Override // sdk.pendo.io.d.a
    public Object b(Value value, Continuation<? super Unit> continuation) {
        return a(this, value, continuation);
    }

    @Override // sdk.pendo.io.d.a
    public Object a(Continuation<? super Value> continuation) {
        return a(this, continuation);
    }

    static /* synthetic */ Object a(c cVar, Continuation continuation) {
        return cVar.cachedValue;
    }

    @Override // sdk.pendo.io.d.a
    public <MappedValue> sdk.pendo.io.d.a<MappedValue> a(Function1<? super Value, ? extends MappedValue> function1) {
        return a.C0099a.a(this, function1);
    }

    @Override // sdk.pendo.io.d.a
    public sdk.pendo.io.d.a<Value> a() {
        return a.C0099a.a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object a(c cVar, Object obj, Continuation continuation) {
        cVar.cachedValue = obj;
        return Unit.INSTANCE;
    }
}
