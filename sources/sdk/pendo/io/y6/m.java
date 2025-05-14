package sdk.pendo.io.y6;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import javax.annotation.Nullable;
import sdk.pendo.io.w2.e0;
import sdk.pendo.io.y6.f;

/* loaded from: classes4.dex */
final class m extends f.a {

    /* renamed from: a, reason: collision with root package name */
    static final f.a f1831a = new m();

    static final class a<T> implements f<e0, Optional<T>> {

        /* renamed from: a, reason: collision with root package name */
        final f<e0, T> f1832a;

        a(f<e0, T> fVar) {
            this.f1832a = fVar;
        }

        @Override // sdk.pendo.io.y6.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Optional<T> convert(e0 e0Var) {
            return Optional.ofNullable(this.f1832a.convert(e0Var));
        }
    }

    m() {
    }

    @Override // sdk.pendo.io.y6.f.a
    @Nullable
    public f<e0, ?> responseBodyConverter(Type type, Annotation[] annotationArr, s sVar) {
        if (f.a.getRawType(type) != Optional.class) {
            return null;
        }
        return new a(sVar.b(f.a.getParameterUpperBound(0, (ParameterizedType) type), annotationArr));
    }
}
