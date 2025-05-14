package sdk.pendo.io.m5;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u0006*\u0004\b\u0000\u0010\u00012\u00060\u0002j\u0002`\u0003:\u0001\bB\u0015\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\r\u001a\u00020\fH\u0016R\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8\u0006¢\u0006\f\n\u0004\b\b\u0010\u000f\u001a\u0004\b\b\u0010\u0010¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/m5/b;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lexternal/sdk/pendo/io/org/koin/mp/Lockable;", "Lsdk/pendo/io/m5/a;", "context", "b", "(Lsdk/pendo/io/m5/a;)Ljava/lang/Object;", "a", "other", "", "equals", "", "hashCode", "Lsdk/pendo/io/j5/a;", "Lsdk/pendo/io/j5/a;", "()Lsdk/pendo/io/j5/a;", "beanDefinition", "<init>", "(Lsdk/pendo/io/j5/a;)V", "koin-core"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public abstract class b<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final sdk.pendo.io.j5.a<T> beanDefinition;

    public b(sdk.pendo.io.j5.a<T> beanDefinition) {
        Intrinsics.checkNotNullParameter(beanDefinition, "beanDefinition");
        this.beanDefinition = beanDefinition;
    }

    public T a(a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        context.getLogger().a("| (+) '" + this.beanDefinition + '\'');
        try {
            sdk.pendo.io.p5.a parameters = context.getParameters();
            if (parameters == null) {
                parameters = sdk.pendo.io.p5.b.a();
            }
            return this.beanDefinition.a().invoke(context.getScope(), parameters);
        } catch (Exception e) {
            context.getLogger().b("* Instance creation error : could not create instance for '" + this.beanDefinition + "': " + sdk.pendo.io.v5.b.f1684a.a(e));
            throw new sdk.pendo.io.k5.c("Could not create instance for '" + this.beanDefinition + '\'', e);
        }
    }

    public abstract T b(a context);

    public boolean equals(Object other) {
        b bVar = other instanceof b ? (b) other : null;
        return Intrinsics.areEqual(this.beanDefinition, bVar != null ? bVar.beanDefinition : null);
    }

    public int hashCode() {
        return this.beanDefinition.hashCode();
    }

    public final sdk.pendo.io.j5.a<T> a() {
        return this.beanDefinition;
    }
}
