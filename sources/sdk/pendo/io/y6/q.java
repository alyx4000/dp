package sdk.pendo.io.y6;

import com.extole.android.sdk.impl.http.HttpRequest;
import com.google.firebase.perf.FirebasePerformance;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import kotlin.coroutines.Continuation;
import sdk.pendo.io.w2.b0;
import sdk.pendo.io.w2.u;
import sdk.pendo.io.w2.x;
import sdk.pendo.io.w2.y;
import sdk.pendo.io.y6.n;
import sdk.pendo.io.z6.y;

/* loaded from: classes4.dex */
final class q {

    /* renamed from: a, reason: collision with root package name */
    private final Method f1853a;
    private final sdk.pendo.io.w2.v b;
    final String c;

    @Nullable
    private final String d;

    @Nullable
    private final sdk.pendo.io.w2.u e;

    @Nullable
    private final x f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final n<?>[] j;
    final boolean k;

    static final class a {
        private static final Pattern x = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
        private static final Pattern y = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");

        /* renamed from: a, reason: collision with root package name */
        final s f1854a;
        final Method b;
        final Annotation[] c;
        final Annotation[][] d;
        final Type[] e;
        boolean f;
        boolean g;
        boolean h;
        boolean i;
        boolean j;
        boolean k;
        boolean l;
        boolean m;

        @Nullable
        String n;
        boolean o;
        boolean p;
        boolean q;

        @Nullable
        String r;

        @Nullable
        sdk.pendo.io.w2.u s;

        @Nullable
        x t;

        @Nullable
        Set<String> u;

        @Nullable
        n<?>[] v;
        boolean w;

        a(s sVar, Method method) {
            this.f1854a = sVar;
            this.b = method;
            this.c = method.getAnnotations();
            this.e = method.getGenericParameterTypes();
            this.d = method.getParameterAnnotations();
        }

        private static Class<?> a(Class<?> cls) {
            return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
        }

        q a() {
            for (Annotation annotation : this.c) {
                a(annotation);
            }
            if (this.n == null) {
                throw w.a(this.b, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
            if (!this.o) {
                if (this.q) {
                    throw w.a(this.b, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
                if (this.p) {
                    throw w.a(this.b, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
            }
            int length = this.d.length;
            this.v = new n[length];
            int i = length - 1;
            int i2 = 0;
            while (i2 < length) {
                this.v[i2] = a(i2, this.e[i2], this.d[i2], i2 == i);
                i2++;
            }
            if (this.r == null && !this.m) {
                throw w.a(this.b, "Missing either @%s URL or @Url parameter.", this.n);
            }
            boolean z = this.p;
            if (!z && !this.q && !this.o && this.h) {
                throw w.a(this.b, "Non-body HTTP method cannot contain @Body.", new Object[0]);
            }
            if (z && !this.f) {
                throw w.a(this.b, "Form-encoded method must contain at least one @Field.", new Object[0]);
            }
            if (!this.q || this.g) {
                return new q(this);
            }
            throw w.a(this.b, "Multipart method must contain at least one @Part.", new Object[0]);
        }

        private sdk.pendo.io.w2.u a(String[] strArr) {
            u.a aVar = new u.a();
            for (String str : strArr) {
                int indexOf = str.indexOf(58);
                if (indexOf == -1 || indexOf == 0 || indexOf == str.length() - 1) {
                    throw w.a(this.b, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String substring = str.substring(0, indexOf);
                String trim = str.substring(indexOf + 1).trim();
                if (HttpRequest.HEADER_CONTENT_TYPE.equalsIgnoreCase(substring)) {
                    try {
                        this.t = x.a(trim);
                    } catch (IllegalArgumentException e) {
                        throw w.a(this.b, e, "Malformed content type: %s", trim);
                    }
                } else {
                    aVar.a(substring, trim);
                }
            }
            return aVar.a();
        }

        private void a(String str, String str2, boolean z) {
            String str3 = this.n;
            if (str3 != null) {
                throw w.a(this.b, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
            }
            this.n = str;
            this.o = z;
            if (str2.isEmpty()) {
                return;
            }
            int indexOf = str2.indexOf(63);
            if (indexOf != -1 && indexOf < str2.length() - 1) {
                String substring = str2.substring(indexOf + 1);
                if (x.matcher(substring).find()) {
                    throw w.a(this.b, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", substring);
                }
            }
            this.r = str2;
            this.u = a(str2);
        }

        private void a(Annotation annotation) {
            String value;
            String str;
            String value2;
            String str2;
            if (annotation instanceof sdk.pendo.io.z6.b) {
                value = ((sdk.pendo.io.z6.b) annotation).value();
                str = "DELETE";
            } else if (annotation instanceof sdk.pendo.io.z6.f) {
                value = ((sdk.pendo.io.z6.f) annotation).value();
                str = "GET";
            } else {
                if (!(annotation instanceof sdk.pendo.io.z6.g)) {
                    if (annotation instanceof sdk.pendo.io.z6.n) {
                        value2 = ((sdk.pendo.io.z6.n) annotation).value();
                        str2 = FirebasePerformance.HttpMethod.PATCH;
                    } else if (annotation instanceof sdk.pendo.io.z6.o) {
                        value2 = ((sdk.pendo.io.z6.o) annotation).value();
                        str2 = "POST";
                    } else if (annotation instanceof sdk.pendo.io.z6.p) {
                        value2 = ((sdk.pendo.io.z6.p) annotation).value();
                        str2 = "PUT";
                    } else {
                        if (!(annotation instanceof sdk.pendo.io.z6.m)) {
                            if (annotation instanceof sdk.pendo.io.z6.h) {
                                sdk.pendo.io.z6.h hVar = (sdk.pendo.io.z6.h) annotation;
                                a(hVar.method(), hVar.path(), hVar.hasBody());
                                return;
                            }
                            if (annotation instanceof sdk.pendo.io.z6.k) {
                                String[] value3 = ((sdk.pendo.io.z6.k) annotation).value();
                                if (value3.length == 0) {
                                    throw w.a(this.b, "@Headers annotation is empty.", new Object[0]);
                                }
                                this.s = a(value3);
                                return;
                            }
                            if (annotation instanceof sdk.pendo.io.z6.l) {
                                if (this.p) {
                                    throw w.a(this.b, "Only one encoding annotation is allowed.", new Object[0]);
                                }
                                this.q = true;
                                return;
                            } else {
                                if (annotation instanceof sdk.pendo.io.z6.e) {
                                    if (this.q) {
                                        throw w.a(this.b, "Only one encoding annotation is allowed.", new Object[0]);
                                    }
                                    this.p = true;
                                    return;
                                }
                                return;
                            }
                        }
                        value = ((sdk.pendo.io.z6.m) annotation).value();
                        str = "OPTIONS";
                    }
                    a(str2, value2, true);
                    return;
                }
                value = ((sdk.pendo.io.z6.g) annotation).value();
                str = "HEAD";
            }
            a(str, value, false);
        }

        @Nullable
        private n<?> a(int i, Type type, @Nullable Annotation[] annotationArr, boolean z) {
            n<?> nVar;
            if (annotationArr != null) {
                nVar = null;
                for (Annotation annotation : annotationArr) {
                    n<?> a2 = a(i, type, annotationArr, annotation);
                    if (a2 != null) {
                        if (nVar != null) {
                            throw w.a(this.b, i, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                        }
                        nVar = a2;
                    }
                }
            } else {
                nVar = null;
            }
            if (nVar != null) {
                return nVar;
            }
            if (z) {
                try {
                    if (w.b(type) == Continuation.class) {
                        this.w = true;
                        return null;
                    }
                } catch (NoClassDefFoundError unused) {
                }
            }
            throw w.a(this.b, i, "No Retrofit annotation found.", new Object[0]);
        }

        @Nullable
        private n<?> a(int i, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof y) {
                a(i, type);
                if (this.m) {
                    throw w.a(this.b, i, "Multiple @Url method annotations found.", new Object[0]);
                }
                if (this.i) {
                    throw w.a(this.b, i, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.j) {
                    throw w.a(this.b, i, "A @Url parameter must not come after a @Query.", new Object[0]);
                }
                if (this.k) {
                    throw w.a(this.b, i, "A @Url parameter must not come after a @QueryName.", new Object[0]);
                }
                if (this.l) {
                    throw w.a(this.b, i, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
                }
                if (this.r != null) {
                    throw w.a(this.b, i, "@Url cannot be used with @%s URL", this.n);
                }
                this.m = true;
                if (type == sdk.pendo.io.w2.v.class || type == String.class || type == URI.class || ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName()))) {
                    return new n.p(this.b, i);
                }
                throw w.a(this.b, i, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
            }
            if (annotation instanceof sdk.pendo.io.z6.s) {
                a(i, type);
                if (this.j) {
                    throw w.a(this.b, i, "A @Path parameter must not come after a @Query.", new Object[0]);
                }
                if (this.k) {
                    throw w.a(this.b, i, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                }
                if (this.l) {
                    throw w.a(this.b, i, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                }
                if (this.m) {
                    throw w.a(this.b, i, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.r == null) {
                    throw w.a(this.b, i, "@Path can only be used with relative url on @%s", this.n);
                }
                this.i = true;
                sdk.pendo.io.z6.s sVar = (sdk.pendo.io.z6.s) annotation;
                String value = sVar.value();
                a(i, value);
                return new n.k(this.b, i, value, this.f1854a.c(type, annotationArr), sVar.encoded());
            }
            if (annotation instanceof sdk.pendo.io.z6.t) {
                a(i, type);
                sdk.pendo.io.z6.t tVar = (sdk.pendo.io.z6.t) annotation;
                String value2 = tVar.value();
                boolean encoded = tVar.encoded();
                Class<?> b = w.b(type);
                this.j = true;
                if (Iterable.class.isAssignableFrom(b)) {
                    if (!(type instanceof ParameterizedType)) {
                        throw w.a(this.b, i, b.getSimpleName() + " must include generic type (e.g., " + b.getSimpleName() + "<String>)", new Object[0]);
                    }
                    return new n.l(value2, this.f1854a.c(w.b(0, (ParameterizedType) type), annotationArr), encoded).b();
                }
                if (!b.isArray()) {
                    return new n.l(value2, this.f1854a.c(type, annotationArr), encoded);
                }
                return new n.l(value2, this.f1854a.c(a(b.getComponentType()), annotationArr), encoded).a();
            }
            if (annotation instanceof sdk.pendo.io.z6.v) {
                a(i, type);
                boolean encoded2 = ((sdk.pendo.io.z6.v) annotation).encoded();
                Class<?> b2 = w.b(type);
                this.k = true;
                if (Iterable.class.isAssignableFrom(b2)) {
                    if (!(type instanceof ParameterizedType)) {
                        throw w.a(this.b, i, b2.getSimpleName() + " must include generic type (e.g., " + b2.getSimpleName() + "<String>)", new Object[0]);
                    }
                    return new n.C0275n(this.f1854a.c(w.b(0, (ParameterizedType) type), annotationArr), encoded2).b();
                }
                if (!b2.isArray()) {
                    return new n.C0275n(this.f1854a.c(type, annotationArr), encoded2);
                }
                return new n.C0275n(this.f1854a.c(a(b2.getComponentType()), annotationArr), encoded2).a();
            }
            if (annotation instanceof sdk.pendo.io.z6.u) {
                a(i, type);
                Class<?> b3 = w.b(type);
                this.l = true;
                if (!Map.class.isAssignableFrom(b3)) {
                    throw w.a(this.b, i, "@QueryMap parameter type must be Map.", new Object[0]);
                }
                Type b4 = w.b(type, b3, Map.class);
                if (!(b4 instanceof ParameterizedType)) {
                    throw w.a(this.b, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType = (ParameterizedType) b4;
                Type b5 = w.b(0, parameterizedType);
                if (String.class != b5) {
                    throw w.a(this.b, i, "@QueryMap keys must be of type String: " + b5, new Object[0]);
                }
                return new n.m(this.b, i, this.f1854a.c(w.b(1, parameterizedType), annotationArr), ((sdk.pendo.io.z6.u) annotation).encoded());
            }
            if (annotation instanceof sdk.pendo.io.z6.i) {
                a(i, type);
                String value3 = ((sdk.pendo.io.z6.i) annotation).value();
                Class<?> b6 = w.b(type);
                if (Iterable.class.isAssignableFrom(b6)) {
                    if (!(type instanceof ParameterizedType)) {
                        throw w.a(this.b, i, b6.getSimpleName() + " must include generic type (e.g., " + b6.getSimpleName() + "<String>)", new Object[0]);
                    }
                    return new n.f(value3, this.f1854a.c(w.b(0, (ParameterizedType) type), annotationArr)).b();
                }
                if (!b6.isArray()) {
                    return new n.f(value3, this.f1854a.c(type, annotationArr));
                }
                return new n.f(value3, this.f1854a.c(a(b6.getComponentType()), annotationArr)).a();
            }
            if (annotation instanceof sdk.pendo.io.z6.j) {
                if (type == sdk.pendo.io.w2.u.class) {
                    return new n.h(this.b, i);
                }
                a(i, type);
                Class<?> b7 = w.b(type);
                if (!Map.class.isAssignableFrom(b7)) {
                    throw w.a(this.b, i, "@HeaderMap parameter type must be Map.", new Object[0]);
                }
                Type b8 = w.b(type, b7, Map.class);
                if (!(b8 instanceof ParameterizedType)) {
                    throw w.a(this.b, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType2 = (ParameterizedType) b8;
                Type b9 = w.b(0, parameterizedType2);
                if (String.class != b9) {
                    throw w.a(this.b, i, "@HeaderMap keys must be of type String: " + b9, new Object[0]);
                }
                return new n.g(this.b, i, this.f1854a.c(w.b(1, parameterizedType2), annotationArr));
            }
            if (annotation instanceof sdk.pendo.io.z6.c) {
                a(i, type);
                if (!this.p) {
                    throw w.a(this.b, i, "@Field parameters can only be used with form encoding.", new Object[0]);
                }
                sdk.pendo.io.z6.c cVar = (sdk.pendo.io.z6.c) annotation;
                String value4 = cVar.value();
                boolean encoded3 = cVar.encoded();
                this.f = true;
                Class<?> b10 = w.b(type);
                if (Iterable.class.isAssignableFrom(b10)) {
                    if (!(type instanceof ParameterizedType)) {
                        throw w.a(this.b, i, b10.getSimpleName() + " must include generic type (e.g., " + b10.getSimpleName() + "<String>)", new Object[0]);
                    }
                    return new n.d(value4, this.f1854a.c(w.b(0, (ParameterizedType) type), annotationArr), encoded3).b();
                }
                if (!b10.isArray()) {
                    return new n.d(value4, this.f1854a.c(type, annotationArr), encoded3);
                }
                return new n.d(value4, this.f1854a.c(a(b10.getComponentType()), annotationArr), encoded3).a();
            }
            if (annotation instanceof sdk.pendo.io.z6.d) {
                a(i, type);
                if (!this.p) {
                    throw w.a(this.b, i, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
                }
                Class<?> b11 = w.b(type);
                if (!Map.class.isAssignableFrom(b11)) {
                    throw w.a(this.b, i, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                Type b12 = w.b(type, b11, Map.class);
                if (!(b12 instanceof ParameterizedType)) {
                    throw w.a(this.b, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType3 = (ParameterizedType) b12;
                Type b13 = w.b(0, parameterizedType3);
                if (String.class != b13) {
                    throw w.a(this.b, i, "@FieldMap keys must be of type String: " + b13, new Object[0]);
                }
                f c = this.f1854a.c(w.b(1, parameterizedType3), annotationArr);
                this.f = true;
                return new n.e(this.b, i, c, ((sdk.pendo.io.z6.d) annotation).encoded());
            }
            if (annotation instanceof sdk.pendo.io.z6.q) {
                a(i, type);
                if (!this.q) {
                    throw w.a(this.b, i, "@Part parameters can only be used with multipart encoding.", new Object[0]);
                }
                sdk.pendo.io.z6.q qVar = (sdk.pendo.io.z6.q) annotation;
                this.g = true;
                String value5 = qVar.value();
                Class<?> b14 = w.b(type);
                if (value5.isEmpty()) {
                    if (Iterable.class.isAssignableFrom(b14)) {
                        if (!(type instanceof ParameterizedType)) {
                            throw w.a(this.b, i, b14.getSimpleName() + " must include generic type (e.g., " + b14.getSimpleName() + "<String>)", new Object[0]);
                        }
                        if (y.c.class.isAssignableFrom(w.b(w.b(0, (ParameterizedType) type)))) {
                            return n.o.f1847a.b();
                        }
                        throw w.a(this.b, i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                    if (b14.isArray()) {
                        if (y.c.class.isAssignableFrom(b14.getComponentType())) {
                            return n.o.f1847a.a();
                        }
                        throw w.a(this.b, i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                    if (y.c.class.isAssignableFrom(b14)) {
                        return n.o.f1847a;
                    }
                    throw w.a(this.b, i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                }
                sdk.pendo.io.w2.u a2 = sdk.pendo.io.w2.u.a("Content-Disposition", "form-data; name=\"" + value5 + "\"", "Content-Transfer-Encoding", qVar.encoding());
                if (Iterable.class.isAssignableFrom(b14)) {
                    if (!(type instanceof ParameterizedType)) {
                        throw w.a(this.b, i, b14.getSimpleName() + " must include generic type (e.g., " + b14.getSimpleName() + "<String>)", new Object[0]);
                    }
                    Type b15 = w.b(0, (ParameterizedType) type);
                    if (y.c.class.isAssignableFrom(w.b(b15))) {
                        throw w.a(this.b, i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    return new n.i(this.b, i, a2, this.f1854a.a(b15, annotationArr, this.c)).b();
                }
                if (!b14.isArray()) {
                    if (y.c.class.isAssignableFrom(b14)) {
                        throw w.a(this.b, i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    return new n.i(this.b, i, a2, this.f1854a.a(type, annotationArr, this.c));
                }
                Class<?> a3 = a(b14.getComponentType());
                if (y.c.class.isAssignableFrom(a3)) {
                    throw w.a(this.b, i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                }
                return new n.i(this.b, i, a2, this.f1854a.a(a3, annotationArr, this.c)).a();
            }
            if (annotation instanceof sdk.pendo.io.z6.r) {
                a(i, type);
                if (!this.q) {
                    throw w.a(this.b, i, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
                }
                this.g = true;
                Class<?> b16 = w.b(type);
                if (!Map.class.isAssignableFrom(b16)) {
                    throw w.a(this.b, i, "@PartMap parameter type must be Map.", new Object[0]);
                }
                Type b17 = w.b(type, b16, Map.class);
                if (!(b17 instanceof ParameterizedType)) {
                    throw w.a(this.b, i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType4 = (ParameterizedType) b17;
                Type b18 = w.b(0, parameterizedType4);
                if (String.class != b18) {
                    throw w.a(this.b, i, "@PartMap keys must be of type String: " + b18, new Object[0]);
                }
                Type b19 = w.b(1, parameterizedType4);
                if (y.c.class.isAssignableFrom(w.b(b19))) {
                    throw w.a(this.b, i, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                }
                return new n.j(this.b, i, this.f1854a.a(b19, annotationArr, this.c), ((sdk.pendo.io.z6.r) annotation).encoding());
            }
            if (annotation instanceof sdk.pendo.io.z6.a) {
                a(i, type);
                if (this.p || this.q) {
                    throw w.a(this.b, i, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                }
                if (this.h) {
                    throw w.a(this.b, i, "Multiple @Body method annotations found.", new Object[0]);
                }
                try {
                    f a4 = this.f1854a.a(type, annotationArr, this.c);
                    this.h = true;
                    return new n.c(this.b, i, a4);
                } catch (RuntimeException e) {
                    throw w.a(this.b, e, i, "Unable to create @Body converter for %s", type);
                }
            }
            if (!(annotation instanceof sdk.pendo.io.z6.x)) {
                return null;
            }
            a(i, type);
            Class<?> b20 = w.b(type);
            for (int i2 = i - 1; i2 >= 0; i2--) {
                n<?> nVar = this.v[i2];
                if ((nVar instanceof n.q) && ((n.q) nVar).f1849a.equals(b20)) {
                    throw w.a(this.b, i, "@Tag type " + b20.getName() + " is duplicate of parameter #" + (i2 + 1) + " and would always overwrite its value.", new Object[0]);
                }
            }
            return new n.q(b20);
        }

        static Set<String> a(String str) {
            Matcher matcher = x.matcher(str);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (matcher.find()) {
                linkedHashSet.add(matcher.group(1));
            }
            return linkedHashSet;
        }

        private void a(int i, String str) {
            if (!y.matcher(str).matches()) {
                throw w.a(this.b, i, "@Path parameter name must match %s. Found: %s", x.pattern(), str);
            }
            if (!this.u.contains(str)) {
                throw w.a(this.b, i, "URL \"%s\" does not contain \"{%s}\".", this.r, str);
            }
        }

        private void a(int i, Type type) {
            if (w.c(type)) {
                throw w.a(this.b, i, "Parameter type must not include a type variable or wildcard: %s", type);
            }
        }
    }

    q(a aVar) {
        this.f1853a = aVar.b;
        this.b = aVar.f1854a.c;
        this.c = aVar.n;
        this.d = aVar.r;
        this.e = aVar.s;
        this.f = aVar.t;
        this.g = aVar.o;
        this.h = aVar.p;
        this.i = aVar.q;
        this.j = aVar.v;
        this.k = aVar.w;
    }

    b0 a(Object[] objArr) {
        n<?>[] nVarArr = this.j;
        int length = objArr.length;
        if (length != nVarArr.length) {
            throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + nVarArr.length + ")");
        }
        p pVar = new p(this.c, this.b, this.d, this.e, this.f, this.g, this.h, this.i);
        if (this.k) {
            length--;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            arrayList.add(objArr[i]);
            nVarArr[i].a(pVar, objArr[i]);
        }
        return pVar.a().a((Class<? super Class>) j.class, (Class) new j(this.f1853a, arrayList)).a();
    }

    static q a(s sVar, Method method) {
        return new a(sVar, method).a();
    }
}
