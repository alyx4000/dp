package sdk.pendo.io.y6;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import kotlin.coroutines.Continuation;
import sdk.pendo.io.w2.d0;
import sdk.pendo.io.w2.e;
import sdk.pendo.io.w2.e0;
import sdk.pendo.io.y6.w;

/* loaded from: classes4.dex */
abstract class i<ResponseT, ReturnT> extends t<ReturnT> {

    /* renamed from: a, reason: collision with root package name */
    private final q f1828a;
    private final e.a b;
    private final f<e0, ResponseT> c;

    static final class a<ResponseT, ReturnT> extends i<ResponseT, ReturnT> {
        private final sdk.pendo.io.y6.c<ResponseT, ReturnT> d;

        a(q qVar, e.a aVar, f<e0, ResponseT> fVar, sdk.pendo.io.y6.c<ResponseT, ReturnT> cVar) {
            super(qVar, aVar, fVar);
            this.d = cVar;
        }

        @Override // sdk.pendo.io.y6.i
        protected ReturnT a(sdk.pendo.io.y6.b<ResponseT> bVar, Object[] objArr) {
            return this.d.a(bVar);
        }
    }

    static final class b<ResponseT> extends i<ResponseT, Object> {
        private final sdk.pendo.io.y6.c<ResponseT, sdk.pendo.io.y6.b<ResponseT>> d;
        private final boolean e;

        b(q qVar, e.a aVar, f<e0, ResponseT> fVar, sdk.pendo.io.y6.c<ResponseT, sdk.pendo.io.y6.b<ResponseT>> cVar, boolean z) {
            super(qVar, aVar, fVar);
            this.d = cVar;
            this.e = z;
        }

        @Override // sdk.pendo.io.y6.i
        protected Object a(sdk.pendo.io.y6.b<ResponseT> bVar, Object[] objArr) {
            sdk.pendo.io.y6.b<ResponseT> a2 = this.d.a(bVar);
            Continuation continuation = (Continuation) objArr[objArr.length - 1];
            try {
                return this.e ? k.b(a2, continuation) : k.a(a2, continuation);
            } catch (Exception e) {
                return k.a(e, (Continuation<?>) continuation);
            }
        }
    }

    static final class c<ResponseT> extends i<ResponseT, Object> {
        private final sdk.pendo.io.y6.c<ResponseT, sdk.pendo.io.y6.b<ResponseT>> d;

        c(q qVar, e.a aVar, f<e0, ResponseT> fVar, sdk.pendo.io.y6.c<ResponseT, sdk.pendo.io.y6.b<ResponseT>> cVar) {
            super(qVar, aVar, fVar);
            this.d = cVar;
        }

        @Override // sdk.pendo.io.y6.i
        protected Object a(sdk.pendo.io.y6.b<ResponseT> bVar, Object[] objArr) {
            sdk.pendo.io.y6.b<ResponseT> a2 = this.d.a(bVar);
            Continuation continuation = (Continuation) objArr[objArr.length - 1];
            try {
                return k.c(a2, continuation);
            } catch (Exception e) {
                return k.a(e, (Continuation<?>) continuation);
            }
        }
    }

    i(q qVar, e.a aVar, f<e0, ResponseT> fVar) {
        this.f1828a = qVar;
        this.b = aVar;
        this.c = fVar;
    }

    private static <ResponseT, ReturnT> sdk.pendo.io.y6.c<ResponseT, ReturnT> a(s sVar, Method method, Type type, Annotation[] annotationArr) {
        try {
            return (sdk.pendo.io.y6.c<ResponseT, ReturnT>) sVar.a(type, annotationArr);
        } catch (RuntimeException e) {
            throw w.a(method, e, "Unable to create call adapter for %s", type);
        }
    }

    @Nullable
    protected abstract ReturnT a(sdk.pendo.io.y6.b<ResponseT> bVar, Object[] objArr);

    private static <ResponseT> f<e0, ResponseT> a(s sVar, Method method, Type type) {
        try {
            return sVar.b(type, method.getAnnotations());
        } catch (RuntimeException e) {
            throw w.a(method, e, "Unable to create converter for %s", type);
        }
    }

    @Override // sdk.pendo.io.y6.t
    @Nullable
    final ReturnT a(Object[] objArr) {
        return a(new l(this.f1828a, objArr, this.b, this.c), objArr);
    }

    static <ResponseT, ReturnT> i<ResponseT, ReturnT> a(s sVar, Method method, q qVar) {
        Type genericReturnType;
        boolean z;
        boolean z2 = qVar.k;
        Annotation[] annotations = method.getAnnotations();
        if (z2) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            Type a2 = w.a(0, (ParameterizedType) genericParameterTypes[genericParameterTypes.length - 1]);
            if (w.b(a2) == r.class && (a2 instanceof ParameterizedType)) {
                a2 = w.b(0, (ParameterizedType) a2);
                z = true;
            } else {
                z = false;
            }
            genericReturnType = new w.b(null, sdk.pendo.io.y6.b.class, a2);
            annotations = v.a(annotations);
        } else {
            genericReturnType = method.getGenericReturnType();
            z = false;
        }
        sdk.pendo.io.y6.c a3 = a(sVar, method, genericReturnType, annotations);
        Type a4 = a3.a();
        if (a4 == d0.class) {
            throw w.a(method, "'" + w.b(a4).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
        }
        if (a4 == r.class) {
            throw w.a(method, "Response must include generic type (e.g., Response<String>)", new Object[0]);
        }
        if (qVar.c.equals("HEAD") && !Void.class.equals(a4)) {
            throw w.a(method, "HEAD method must use Void as response type.", new Object[0]);
        }
        f a5 = a(sVar, method, a4);
        e.a aVar = sVar.b;
        return !z2 ? new a(qVar, aVar, a5, a3) : z ? new c(qVar, aVar, a5, a3) : new b(qVar, aVar, a5, a3, false);
    }
}
