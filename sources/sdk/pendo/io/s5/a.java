package sdk.pendo.io.s5;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.callercontext.ContextChain;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import sdk.pendo.io.k5.d;
import sdk.pendo.io.n5.b;
import sdk.pendo.io.n5.c;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00060\u0001j\u0002`\u0002B-\u0012\u0006\u0010\u001a\u001a\u00020\u0004\u0012\n\u0010\u001e\u001a\u00060\u0016j\u0002`\u001b\u0012\b\b\u0002\u0010!\u001a\u00020\u001f\u0012\u0006\u0010*\u001a\u00020#¢\u0006\u0004\bE\u0010FJA\u0010\f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0004\u0018\u0001`\nH\u0002¢\u0006\u0004\b\f\u0010\rJN\u0010\f\u001a\u0004\b\u00028\u0000\"\u0004\b\u0000\u0010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0004\u0018\u0001`\nH\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0010JC\u0010\f\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0004\u0018\u0001`\nH\u0002¢\u0006\u0004\b\f\u0010\u0012J\u001e\u0010\f\u001a\u00020\u00132\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002JE\u0010\u0014\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0004\u0018\u0001`\n¢\u0006\u0004\b\u0014\u0010\u0012JC\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\bj\u0004\u0018\u0001`\n¢\u0006\u0004\b\u0015\u0010\u0012J\b\u0010\u0017\u001a\u00020\u0016H\u0016R\u0017\u0010\u001a\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0015\u0010\u0019R\u001b\u0010\u001e\u001a\u00060\u0016j\u0002`\u001b8\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u001c\u001a\u0004\b\f\u0010\u001dR\u0017\u0010!\u001a\u00020\u001f8\u0006¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b!\u0010\"R \u0010*\u001a\u00020#8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b$\u0010%\u0012\u0004\b(\u0010)\u001a\u0004\b&\u0010'R$\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u00000+j\b\u0012\u0004\u0012\u00020\u0000`,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R*\u00107\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b0\u00101\u0012\u0004\b6\u0010)\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u00109\u001a\u0012\u0012\u0004\u0012\u00020\u00010+j\b\u0012\u0004\u0012\u00020\u0001`,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u0010.R<\u0010B\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0;0:j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0;`<8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b=\u0010>\u0012\u0004\bA\u0010)\u001a\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010 \u0082\u0002\u0004\n\u0002\b9¨\u0006G"}, d2 = {"Lsdk/pendo/io/s5/a;", "", "Lexternal/sdk/pendo/io/org/koin/mp/Lockable;", ExifInterface.GPS_DIRECTION_TRUE, "Lsdk/pendo/io/q5/a;", "qualifier", "Lkotlin/reflect/KClass;", "clazz", "Lkotlin/Function0;", "Lsdk/pendo/io/p5/a;", "Lexternal/sdk/pendo/io/org/koin/core/parameter/ParametersDefinition;", "parameterDef", "a", "(Lsdk/pendo/io/q5/a;Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lsdk/pendo/io/m5/a;", "instanceContext", "(Lsdk/pendo/io/q5/a;Lkotlin/reflect/KClass;Lsdk/pendo/io/m5/a;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "parameters", "(Lkotlin/reflect/KClass;Lsdk/pendo/io/q5/a;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "", "c", "b", "", "toString", "Lsdk/pendo/io/q5/a;", "()Lsdk/pendo/io/q5/a;", "scopeQualifier", "Lexternal/sdk/pendo/io/org/koin/core/scope/ScopeID;", "Ljava/lang/String;", "()Ljava/lang/String;", "id", "", "Z", "isRoot", "()Z", "Lsdk/pendo/io/h5/a;", "d", "Lsdk/pendo/io/h5/a;", "get_koin", "()Lsdk/pendo/io/h5/a;", "get_koin$annotations", "()V", "_koin", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "linkedScopes", "f", "Ljava/lang/Object;", "get_source", "()Ljava/lang/Object;", "set_source", "(Ljava/lang/Object;)V", "get_source$annotations", "_source", "g", "_callbacks", "Ljava/lang/ThreadLocal;", "Lkotlin/collections/ArrayDeque;", "Lexternal/sdk/pendo/io/org/koin/mp/ThreadLocal;", "h", "Ljava/lang/ThreadLocal;", "get_parameterStackLocal", "()Ljava/lang/ThreadLocal;", "get_parameterStackLocal$annotations", "_parameterStackLocal", ContextChain.TAG_INFRA, "_closed", "<init>", "(Lsdk/pendo/io/q5/a;Ljava/lang/String;ZLsdk/pendo/io/h5/a;)V", "koin-core"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final sdk.pendo.io.q5.a scopeQualifier;

    /* renamed from: b, reason: from kotlin metadata */
    private final String id;

    /* renamed from: c, reason: from kotlin metadata */
    private final boolean isRoot;

    /* renamed from: d, reason: from kotlin metadata */
    private final sdk.pendo.io.h5.a _koin;

    /* renamed from: e, reason: from kotlin metadata */
    private final ArrayList<a> linkedScopes;

    /* renamed from: f, reason: from kotlin metadata */
    private Object _source;

    /* renamed from: g, reason: from kotlin metadata */
    private final ArrayList<Object> _callbacks;

    /* renamed from: h, reason: from kotlin metadata */
    private final ThreadLocal<ArrayDeque<sdk.pendo.io.p5.a>> _parameterStackLocal;

    /* renamed from: i, reason: from kotlin metadata */
    private boolean _closed;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 9, 0})
    /* renamed from: sdk.pendo.io.s5.a$a, reason: collision with other inner class name */
    static final class C0233a extends Lambda implements Function0<String> {
        final /* synthetic */ sdk.pendo.io.p5.a f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0233a(sdk.pendo.io.p5.a aVar) {
            super(0);
            this.f = aVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return "| >> parameters " + this.f + ' ';
        }
    }

    public a(sdk.pendo.io.q5.a scopeQualifier, String id, boolean z, sdk.pendo.io.h5.a _koin) {
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(_koin, "_koin");
        this.scopeQualifier = scopeQualifier;
        this.id = id;
        this.isRoot = z;
        this._koin = _koin;
        this.linkedScopes = new ArrayList<>();
        this._callbacks = new ArrayList<>();
        this._parameterStackLocal = new ThreadLocal<>();
    }

    private final <T> T a(KClass<?> clazz, sdk.pendo.io.q5.a qualifier, Function0<? extends sdk.pendo.io.p5.a> parameters) {
        Iterator<a> it = this.linkedScopes.iterator();
        T t = null;
        while (it.hasNext() && (t = (T) it.next().c(clazz, qualifier, parameters)) == null) {
        }
        return t;
    }

    public final <T> T b(KClass<?> clazz, sdk.pendo.io.q5.a qualifier, Function0<? extends sdk.pendo.io.p5.a> parameters) {
        String str;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        c cVar = this._koin.getIo.sentry.SentryEvent.JsonKeys.LOGGER java.lang.String();
        b bVar = b.DEBUG;
        if (!cVar.a(bVar)) {
            return (T) a(qualifier, clazz, parameters);
        }
        if (qualifier == null || (str = " with qualifier '" + qualifier + '\'') == null) {
            str = "";
        }
        this._koin.getIo.sentry.SentryEvent.JsonKeys.LOGGER java.lang.String().a(bVar, "|- '" + sdk.pendo.io.u5.a.a(clazz) + '\'' + str + " ...");
        long a2 = sdk.pendo.io.v5.a.f1683a.a();
        T t = (T) a(qualifier, clazz, parameters);
        this._koin.getIo.sentry.SentryEvent.JsonKeys.LOGGER java.lang.String().a(bVar, "|- '" + sdk.pendo.io.u5.a.a(clazz) + "' in " + ((r0.a() - a2) / 1000000.0d) + " ms");
        return t;
    }

    public final <T> T c(KClass<?> clazz, sdk.pendo.io.q5.a qualifier, Function0<? extends sdk.pendo.io.p5.a> parameters) {
        c cVar;
        StringBuilder append;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        try {
            return (T) b(clazz, qualifier, parameters);
        } catch (sdk.pendo.io.k5.a unused) {
            cVar = this._koin.getIo.sentry.SentryEvent.JsonKeys.LOGGER java.lang.String();
            append = new StringBuilder("* Scope closed - no instance found for ").append(sdk.pendo.io.u5.a.a(clazz)).append(" on scope ").append(this);
            cVar.a(append.toString());
            return null;
        } catch (d unused2) {
            cVar = this._koin.getIo.sentry.SentryEvent.JsonKeys.LOGGER java.lang.String();
            append = new StringBuilder("* No instance found for type '").append(sdk.pendo.io.u5.a.a(clazz)).append("' on scope '").append(this).append('\'');
            cVar.a(append.toString());
            return null;
        }
    }

    public String toString() {
        return "['" + this.id + "']";
    }

    /* renamed from: a, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: b, reason: from getter */
    public final sdk.pendo.io.q5.a getScopeQualifier() {
        return this.scopeQualifier;
    }

    private final <T> T a(sdk.pendo.io.q5.a qualifier, KClass<?> clazz, Function0<? extends sdk.pendo.io.p5.a> parameterDef) {
        if (this._closed) {
            throw new sdk.pendo.io.k5.a("Scope '" + this.id + "' is closed");
        }
        ArrayDeque<sdk.pendo.io.p5.a> arrayDeque = null;
        sdk.pendo.io.p5.a invoke = parameterDef != null ? parameterDef.invoke() : null;
        if (invoke != null) {
            this._koin.getIo.sentry.SentryEvent.JsonKeys.LOGGER java.lang.String().a(b.DEBUG, new C0233a(invoke));
            arrayDeque = this._parameterStackLocal.get();
            if (arrayDeque == null) {
                arrayDeque = new ArrayDeque<>();
                this._parameterStackLocal.set(arrayDeque);
            }
            arrayDeque.addFirst(invoke);
        }
        T t = (T) a(qualifier, clazz, new sdk.pendo.io.m5.a(this._koin.getIo.sentry.SentryEvent.JsonKeys.LOGGER java.lang.String(), this, invoke), parameterDef);
        if (arrayDeque != null) {
            this._koin.getIo.sentry.SentryEvent.JsonKeys.LOGGER java.lang.String().a("| << parameters");
            arrayDeque.removeFirstOrNull();
        }
        return t;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x008f, code lost:
    
        if (r8 != null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final <T> T a(sdk.pendo.io.q5.a r6, kotlin.reflect.KClass<?> r7, sdk.pendo.io.m5.a r8, kotlin.jvm.functions.Function0<? extends sdk.pendo.io.p5.a> r9) {
        /*
            r5 = this;
            sdk.pendo.io.h5.a r0 = r5._koin
            sdk.pendo.io.r5.a r0 = r0.getInstanceRegistry()
            sdk.pendo.io.q5.a r1 = r5.scopeQualifier
            java.lang.Object r8 = r0.a(r6, r7, r1, r8)
            if (r8 != 0) goto Ldd
            sdk.pendo.io.h5.a r8 = r5._koin
            sdk.pendo.io.n5.c r8 = r8.getIo.sentry.SentryEvent.JsonKeys.LOGGER java.lang.String()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "|- ? t:'"
            r0.<init>(r1)
            java.lang.String r2 = sdk.pendo.io.u5.a.a(r7)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r2 = "' - q:'"
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.StringBuilder r0 = r0.append(r6)
            java.lang.String r3 = "' look in injected parameters"
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r0 = r0.toString()
            r8.a(r0)
            java.lang.ThreadLocal<kotlin.collections.ArrayDeque<sdk.pendo.io.p5.a>> r8 = r5._parameterStackLocal
            java.lang.Object r8 = r8.get()
            kotlin.collections.ArrayDeque r8 = (kotlin.collections.ArrayDeque) r8
            r0 = 0
            if (r8 == 0) goto L52
            java.lang.Object r8 = r8.firstOrNull()
            sdk.pendo.io.p5.a r8 = (sdk.pendo.io.p5.a) r8
            if (r8 == 0) goto L52
            java.lang.Object r8 = r8.c(r7)
            goto L53
        L52:
            r8 = r0
        L53:
            if (r8 != 0) goto Ldd
            boolean r8 = r5.isRoot
            if (r8 != 0) goto L91
            sdk.pendo.io.h5.a r8 = r5._koin
            sdk.pendo.io.n5.c r8 = r8.getIo.sentry.SentryEvent.JsonKeys.LOGGER java.lang.String()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r1)
            java.lang.String r4 = sdk.pendo.io.u5.a.a(r7)
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r2)
            java.lang.StringBuilder r3 = r3.append(r6)
            java.lang.String r4 = "' look at scope source"
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r8.a(r3)
            java.lang.Object r8 = r5._source
            if (r8 == 0) goto L91
            boolean r8 = r7.isInstance(r8)
            if (r8 == 0) goto L91
            if (r6 != 0) goto L91
            java.lang.Object r8 = r5._source
            if (r8 != 0) goto L92
        L91:
            r8 = r0
        L92:
            if (r8 != 0) goto Ldd
            sdk.pendo.io.h5.a r8 = r5._koin
            sdk.pendo.io.n5.c r8 = r8.getIo.sentry.SentryEvent.JsonKeys.LOGGER java.lang.String()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r1)
            java.lang.String r1 = sdk.pendo.io.u5.a.a(r7)
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.StringBuilder r0 = r0.append(r6)
            java.lang.String r1 = "' look in other scopes"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.a(r0)
            java.lang.Object r8 = r5.a(r7, r6, r9)
            if (r8 != 0) goto Ldd
            if (r9 == 0) goto Ld4
            java.lang.ThreadLocal<kotlin.collections.ArrayDeque<sdk.pendo.io.p5.a>> r8 = r5._parameterStackLocal
            r8.remove()
            sdk.pendo.io.h5.a r8 = r5._koin
            sdk.pendo.io.n5.c r8 = r8.getIo.sentry.SentryEvent.JsonKeys.LOGGER java.lang.String()
            java.lang.String r9 = "|- << parameters"
            r8.a(r9)
        Ld4:
            r5.a(r6, r7)
            kotlin.KotlinNothingValueException r6 = new kotlin.KotlinNothingValueException
            r6.<init>()
            throw r6
        Ldd:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.s5.a.a(sdk.pendo.io.q5.a, kotlin.reflect.KClass, sdk.pendo.io.m5.a, kotlin.jvm.functions.Function0):java.lang.Object");
    }

    private final Void a(sdk.pendo.io.q5.a qualifier, KClass<?> clazz) {
        String str;
        if (qualifier == null || (str = " and qualifier '" + qualifier + '\'') == null) {
            str = "";
        }
        throw new d("No definition found for type '" + sdk.pendo.io.u5.a.a(clazz) + '\'' + str + ". Check your Modules configuration and add missing type and/or qualifier!");
    }
}
