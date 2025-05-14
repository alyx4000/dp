package sdk.pendo.io.m5;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u0017\u0010\t\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0003\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u000b¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/m5/c;", ExifInterface.GPS_DIRECTION_TRUE, "Lsdk/pendo/io/m5/b;", "b", "()Ljava/lang/Object;", "Lsdk/pendo/io/m5/a;", "context", "", "c", "a", "(Lsdk/pendo/io/m5/a;)Ljava/lang/Object;", "Ljava/lang/Object;", "value", "Lsdk/pendo/io/j5/a;", "beanDefinition", "<init>", "(Lsdk/pendo/io/j5/a;)V", "koin-core"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class c<T> extends b<T> {

    /* renamed from: c, reason: from kotlin metadata */
    private T value;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "a", "()V"}, k = 3, mv = {1, 9, 0})
    static final class a extends Lambda implements Function0<Unit> {
        final /* synthetic */ c<T> f;
        final /* synthetic */ sdk.pendo.io.m5.a s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(c<T> cVar, sdk.pendo.io.m5.a aVar) {
            super(0);
            this.f = cVar;
            this.s = aVar;
        }

        public final void a() {
            if (this.f.c(this.s)) {
                return;
            }
            c<T> cVar = this.f;
            ((c) cVar).value = cVar.a(this.s);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(sdk.pendo.io.j5.a<T> beanDefinition) {
        super(beanDefinition);
        Intrinsics.checkNotNullParameter(beanDefinition, "beanDefinition");
    }

    @Override // sdk.pendo.io.m5.b
    public T b(sdk.pendo.io.m5.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        sdk.pendo.io.v5.b.f1684a.a(this, new a(this, context));
        return b();
    }

    public boolean c(sdk.pendo.io.m5.a context) {
        return this.value != null;
    }

    private final T b() {
        T t = this.value;
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("Single instance created couldn't return value".toString());
    }

    @Override // sdk.pendo.io.m5.b
    public T a(sdk.pendo.io.m5.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.value == null ? (T) super.a(context) : b();
    }
}
