package sdk.pendo.io.m2;

import com.facebook.common.callercontext.ContextChain;
import com.facebook.react.uimanager.ViewProps;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.i2.j;
import sdk.pendo.io.k2.b0;
import sdk.pendo.io.m2.f;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0012\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b'\u0010(J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u0010\u0010\t\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\u0018\u001a\u00020\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006)"}, d2 = {"Lsdk/pendo/io/m2/n;", "Lsdk/pendo/io/m2/c;", "Lsdk/pendo/io/i2/f;", "descriptor", "", "index", "", ViewHierarchyNode.JsonKeys.TAG, "", "a", "m", "e", "c", "desc", "k", "Lsdk/pendo/io/l2/h;", "b", "Lsdk/pendo/io/j2/b;", "", "Lsdk/pendo/io/l2/s;", "f", "Lsdk/pendo/io/l2/s;", "getValue", "()Lkotlinx/serialization/json/JsonObject;", "value", "g", "Ljava/lang/String;", "polyDiscriminator", "h", "Lsdk/pendo/io/i2/f;", "polyDescriptor", ContextChain.TAG_INFRA, "I", ViewProps.POSITION, "j", "Z", "forceNull", "Lsdk/pendo/io/l2/a;", "json", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
class n extends c {

    /* renamed from: f, reason: from kotlin metadata */
    private final sdk.pendo.io.l2.s value;

    /* renamed from: g, reason: from kotlin metadata */
    private final String polyDiscriminator;

    /* renamed from: h, reason: from kotlin metadata */
    private final sdk.pendo.io.i2.f polyDescriptor;

    /* renamed from: i, reason: from kotlin metadata */
    private int position;

    /* renamed from: j, reason: from kotlin metadata */
    private boolean forceNull;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* synthetic */ class a extends FunctionReferenceImpl implements Function0<Map<String, ? extends Integer>> {
        a(Object obj) {
            super(0, obj, l.class, "buildAlternativeNamesMap", "buildAlternativeNamesMap(Lkotlinx/serialization/descriptors/SerialDescriptor;)Ljava/util/Map;", 1);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Map<String, Integer> invoke() {
            return l.a((sdk.pendo.io.i2.f) this.receiver);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(sdk.pendo.io.l2.a json, sdk.pendo.io.l2.s value, String str, sdk.pendo.io.i2.f fVar) {
        super(json, value, null);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
        this.polyDiscriminator = str;
        this.polyDescriptor = fVar;
    }

    private final boolean m(sdk.pendo.io.i2.f descriptor, int index) {
        boolean z = (getJson().getConfiguration().getExplicitNulls() || descriptor.d(index) || !descriptor.c(index).e()) ? false : true;
        this.forceNull = z;
        return z;
    }

    @Override // sdk.pendo.io.m2.c, sdk.pendo.io.j2.d
    public sdk.pendo.io.j2.b a(sdk.pendo.io.i2.f descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return descriptor == this.polyDescriptor ? this : super.a(descriptor);
    }

    @Override // sdk.pendo.io.m2.c
    protected sdk.pendo.io.l2.h b(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return (sdk.pendo.io.l2.h) MapsKt.getValue(s(), tag);
    }

    @Override // sdk.pendo.io.m2.c, sdk.pendo.io.k2.e1, sdk.pendo.io.j2.d
    public boolean c() {
        return !this.forceNull && super.c();
    }

    @Override // sdk.pendo.io.j2.b
    public int e(sdk.pendo.io.i2.f descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        while (this.position < descriptor.getElementsCount()) {
            int i = this.position;
            this.position = i + 1;
            String j = j(descriptor, i);
            int i2 = this.position - 1;
            this.forceNull = false;
            if (s().containsKey(j) || m(descriptor, i2)) {
                if (!this.configuration.getCoerceInputValues() || !a(descriptor, i2, j)) {
                    return i2;
                }
            }
        }
        return -1;
    }

    @Override // sdk.pendo.io.k2.l0
    protected String k(sdk.pendo.io.i2.f desc, int index) {
        Object obj;
        Intrinsics.checkNotNullParameter(desc, "desc");
        String a2 = desc.a(index);
        if (!this.configuration.getUseAlternativeNames() || s().keySet().contains(a2)) {
            return a2;
        }
        Map map = (Map) sdk.pendo.io.l2.w.a(getJson()).a(desc, (f.a) l.a(), (Function0) new a(desc));
        Iterator<T> it = s().keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Integer num = (Integer) map.get((String) obj);
            if (num != null && num.intValue() == index) {
                break;
            }
        }
        String str = (String) obj;
        return str == null ? a2 : str;
    }

    @Override // sdk.pendo.io.m2.c
    /* renamed from: t, reason: from getter and merged with bridge method [inline-methods] */
    public sdk.pendo.io.l2.s s() {
        return this.value;
    }

    public /* synthetic */ n(sdk.pendo.io.l2.a aVar, sdk.pendo.io.l2.s sVar, String str, sdk.pendo.io.i2.f fVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, sVar, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : fVar);
    }

    private final boolean a(sdk.pendo.io.i2.f descriptor, int index, String tag) {
        sdk.pendo.io.l2.a json = getJson();
        sdk.pendo.io.i2.f c = descriptor.c(index);
        if (c.e() || !(b(tag) instanceof sdk.pendo.io.l2.q)) {
            if (Intrinsics.areEqual(c.getKind(), j.b.f1196a)) {
                sdk.pendo.io.l2.h b = b(tag);
                sdk.pendo.io.l2.u uVar = b instanceof sdk.pendo.io.l2.u ? (sdk.pendo.io.l2.u) b : null;
                String b2 = uVar != null ? sdk.pendo.io.l2.i.b(uVar) : null;
                if (b2 != null && l.a(c, json, b2) == -3) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // sdk.pendo.io.m2.c, sdk.pendo.io.j2.b
    public void c(sdk.pendo.io.i2.f descriptor) {
        Set<String> plus;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (this.configuration.getIgnoreUnknownKeys() || (descriptor.getKind() instanceof sdk.pendo.io.i2.d)) {
            return;
        }
        if (this.configuration.getUseAlternativeNames()) {
            Set<String> a2 = b0.a(descriptor);
            Map map = (Map) sdk.pendo.io.l2.w.a(getJson()).a(descriptor, l.a());
            Set keySet = map == null ? null : map.keySet();
            if (keySet == null) {
                keySet = SetsKt.emptySet();
            }
            plus = SetsKt.plus((Set) a2, (Iterable) keySet);
        } else {
            plus = b0.a(descriptor);
        }
        for (String str : s().keySet()) {
            if (!plus.contains(str) && !Intrinsics.areEqual(str, this.polyDiscriminator)) {
                throw k.a(str, s().toString());
            }
        }
    }
}
