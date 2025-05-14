package sdk.pendo.io.m2;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.callercontext.ContextChain;
import io.sentry.profilemeasurements.ProfileMeasurement;
import io.sentry.protocol.ViewHierarchyNode;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import sdk.pendo.io.i2.j;
import sdk.pendo.io.i2.k;
import sdk.pendo.io.k2.l0;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0004\u0012\u0006\u00106\u001a\u000202\u0012\u0006\u0010:\u001a\u00020\u0003¢\u0006\u0004\bB\u0010CJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0014\u0010\f\u001a\u00020\u000b*\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\r\u001a\u00020\u0003H\u0016J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0014J\u0010\u0010\f\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0005H\u0004J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0005H$J\u0018\u0010\f\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0010H\u0014J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0005H\u0014J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0005H\u0014J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0005H\u0014J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0005H\u0014J\u0010\u0010!\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u0005H\u0014J\u0010\u0010\r\u001a\u00020\"2\u0006\u0010\u0016\u001a\u00020\u0005H\u0014J\u0010\u0010$\u001a\u00020#2\u0006\u0010\u0016\u001a\u00020\u0005H\u0014J\u0010\u0010&\u001a\u00020%2\u0006\u0010\u0016\u001a\u00020\u0005H\u0014J\u0010\u0010'\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0014J#\u0010+\u001a\u00028\u0000\"\u0004\b\u0000\u0010(2\f\u0010*\u001a\b\u0012\u0004\u0012\u00028\u00000)H\u0016¢\u0006\u0004\b+\u0010,JA\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010(*\u00020-*\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0019\u00100\u001a\u0015\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00018\u00000.¢\u0006\u0002\b/H\u0082\b¢\u0006\u0004\b\u0006\u00101R\u001a\u00106\u001a\u0002028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u00103\u001a\u0004\b4\u00105R\u001a\u0010:\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u00107\u001a\u0004\b8\u00109R\u0014\u0010=\u001a\u00020;8\u0004X\u0085\u0004¢\u0006\u0006\n\u0004\b&\u0010<R\u0014\u0010A\u001a\u00020>8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@\u0082\u0001\u0003DEF¨\u0006G"}, d2 = {"Lsdk/pendo/io/m2/c;", "Lsdk/pendo/io/k2/l0;", "Lsdk/pendo/io/l2/g;", "Lsdk/pendo/io/l2/h;", "r", "", "primitive", "", "m", "Lsdk/pendo/io/l2/u;", "type", "Lsdk/pendo/io/l2/n;", "a", "g", "parentName", "childName", "Lsdk/pendo/io/i2/f;", "descriptor", "Lsdk/pendo/io/j2/b;", "", "c", "", ViewHierarchyNode.JsonKeys.TAG, "l", "b", "enumDescriptor", "", "", "d", "", "j", "h", "", ContextChain.TAG_INFRA, "", "", "f", "", "e", "k", ExifInterface.GPS_DIRECTION_TRUE, "Lsdk/pendo/io/g2/a;", "deserializer", "decodeSerializableValue", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "block", "(Lkotlinx/serialization/json/JsonPrimitive;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lsdk/pendo/io/l2/a;", "Lsdk/pendo/io/l2/a;", "getJson", "()Lkotlinx/serialization/json/Json;", "json", "Lsdk/pendo/io/l2/h;", "getValue", "()Lkotlinx/serialization/json/JsonElement;", "value", "Lsdk/pendo/io/l2/f;", "Lsdk/pendo/io/l2/f;", "configuration", "Lsdk/pendo/io/n2/c;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonElement;)V", "Lsdk/pendo/io/m2/m;", "Lsdk/pendo/io/m2/n;", "Lsdk/pendo/io/m2/o;", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
abstract class c extends l0 implements sdk.pendo.io.l2.g {

    /* renamed from: c, reason: from kotlin metadata */
    private final sdk.pendo.io.l2.a json;

    /* renamed from: d, reason: from kotlin metadata */
    private final sdk.pendo.io.l2.h value;

    /* renamed from: e, reason: from kotlin metadata */
    protected final sdk.pendo.io.l2.f configuration;

    private c(sdk.pendo.io.l2.a aVar, sdk.pendo.io.l2.h hVar) {
        this.json = aVar;
        this.value = hVar;
        this.configuration = getJson().getConfiguration();
    }

    private final sdk.pendo.io.l2.n a(sdk.pendo.io.l2.u uVar, String str) {
        sdk.pendo.io.l2.n nVar = uVar instanceof sdk.pendo.io.l2.n ? (sdk.pendo.io.l2.n) uVar : null;
        if (nVar != null) {
            return nVar;
        }
        throw k.a(-1, "Unexpected 'null' when " + str + " was expected");
    }

    private final Void m(String primitive) {
        throw k.a(-1, "Failed to parse '" + primitive + '\'', r().toString());
    }

    private final sdk.pendo.io.l2.h r() {
        String p = p();
        sdk.pendo.io.l2.h b2 = p == null ? null : b2(p);
        return b2 == null ? s() : b2;
    }

    /* renamed from: b, reason: avoid collision after fix types in other method */
    protected abstract sdk.pendo.io.l2.h b2(String tag);

    @Override // sdk.pendo.io.k2.e1, sdk.pendo.io.j2.d
    public boolean c() {
        return !(r() instanceof sdk.pendo.io.l2.q);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sdk.pendo.io.k2.e1
    /* renamed from: d, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public byte b(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        try {
            int e = sdk.pendo.io.l2.i.e(l(tag));
            Byte valueOf = -128 <= e && e <= 127 ? Byte.valueOf((byte) e) : null;
            if (valueOf != null) {
                return valueOf.byteValue();
            }
            m(ProfileMeasurement.UNIT_BYTES);
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException unused) {
            m(ProfileMeasurement.UNIT_BYTES);
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sdk.pendo.io.k2.e1
    /* renamed from: e, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public char c(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        try {
            return StringsKt.single(l(tag).getContent());
        } catch (IllegalArgumentException unused) {
            m("char");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sdk.pendo.io.k2.e1
    /* renamed from: f, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public double d(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        try {
            double c = sdk.pendo.io.l2.i.c(l(tag));
            if (!getJson().getConfiguration().getAllowSpecialFloatingPointValues()) {
                if (!((Double.isInfinite(c) || Double.isNaN(c)) ? false : true)) {
                    throw k.a(Double.valueOf(c), tag, r().toString());
                }
            }
            return c;
        } catch (IllegalArgumentException unused) {
            m("double");
            throw new KotlinNothingValueException();
        }
    }

    @Override // sdk.pendo.io.l2.g
    public sdk.pendo.io.l2.h g() {
        return r();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sdk.pendo.io.k2.e1
    /* renamed from: h, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public int f(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        try {
            return sdk.pendo.io.l2.i.e(l(tag));
        } catch (IllegalArgumentException unused) {
            m("int");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sdk.pendo.io.k2.e1
    /* renamed from: i, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public long g(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        try {
            return sdk.pendo.io.l2.i.f(l(tag));
        } catch (IllegalArgumentException unused) {
            m("long");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sdk.pendo.io.k2.e1
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public short h(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        try {
            int e = sdk.pendo.io.l2.i.e(l(tag));
            Short valueOf = -32768 <= e && e <= 32767 ? Short.valueOf((short) e) : null;
            if (valueOf != null) {
                return valueOf.shortValue();
            }
            m("short");
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException unused) {
            m("short");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sdk.pendo.io.k2.e1
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public String i(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        sdk.pendo.io.l2.u l = l(tag);
        if (!getJson().getConfiguration().getIsLenient() && !a(l, "string").getIsString()) {
            throw k.a(-1, "String literal for key '" + tag + "' should be quoted.\nUse 'isLenient = true' in 'Json {}` builder to accept non-compliant JSON.", r().toString());
        }
        if (l instanceof sdk.pendo.io.l2.q) {
            throw k.a(-1, "Unexpected 'null' value instead of string literal", r().toString());
        }
        return l.getContent();
    }

    protected final sdk.pendo.io.l2.u l(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        sdk.pendo.io.l2.h b2 = b2(tag);
        sdk.pendo.io.l2.u uVar = b2 instanceof sdk.pendo.io.l2.u ? (sdk.pendo.io.l2.u) b2 : null;
        if (uVar != null) {
            return uVar;
        }
        throw k.a(-1, "Expected JsonPrimitive at " + tag + ", found " + b2, r().toString());
    }

    public abstract sdk.pendo.io.l2.h s();

    public /* synthetic */ c(sdk.pendo.io.l2.a aVar, sdk.pendo.io.l2.h hVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, hVar);
    }

    @Override // sdk.pendo.io.j2.d
    public sdk.pendo.io.j2.b a(sdk.pendo.io.i2.f descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        sdk.pendo.io.l2.h r = r();
        sdk.pendo.io.i2.j kind = descriptor.getKind();
        if (Intrinsics.areEqual(kind, k.b.f1198a) ? true : kind instanceof sdk.pendo.io.i2.d) {
            sdk.pendo.io.l2.a json = getJson();
            if (r instanceof sdk.pendo.io.l2.b) {
                return new o(json, (sdk.pendo.io.l2.b) r);
            }
            throw k.a(-1, "Expected " + Reflection.getOrCreateKotlinClass(sdk.pendo.io.l2.b.class) + " as the serialized body of " + descriptor.getSerialName() + ", but had " + Reflection.getOrCreateKotlinClass(r.getClass()));
        }
        if (!Intrinsics.areEqual(kind, k.c.f1199a)) {
            sdk.pendo.io.l2.a json2 = getJson();
            if (r instanceof sdk.pendo.io.l2.s) {
                return new n(json2, (sdk.pendo.io.l2.s) r, null, null, 12, null);
            }
            throw k.a(-1, "Expected " + Reflection.getOrCreateKotlinClass(sdk.pendo.io.l2.s.class) + " as the serialized body of " + descriptor.getSerialName() + ", but had " + Reflection.getOrCreateKotlinClass(r.getClass()));
        }
        sdk.pendo.io.l2.a json3 = getJson();
        sdk.pendo.io.i2.f a2 = y.a(descriptor.c(0), json3.getSerializersModule());
        sdk.pendo.io.i2.j kind2 = a2.getKind();
        if ((kind2 instanceof sdk.pendo.io.i2.e) || Intrinsics.areEqual(kind2, j.b.f1196a)) {
            sdk.pendo.io.l2.a json4 = getJson();
            if (r instanceof sdk.pendo.io.l2.s) {
                return new p(json4, (sdk.pendo.io.l2.s) r);
            }
            throw k.a(-1, "Expected " + Reflection.getOrCreateKotlinClass(sdk.pendo.io.l2.s.class) + " as the serialized body of " + descriptor.getSerialName() + ", but had " + Reflection.getOrCreateKotlinClass(r.getClass()));
        }
        if (!json3.getConfiguration().getAllowStructuredMapKeys()) {
            throw k.a(a2);
        }
        sdk.pendo.io.l2.a json5 = getJson();
        if (r instanceof sdk.pendo.io.l2.b) {
            return new o(json5, (sdk.pendo.io.l2.b) r);
        }
        throw k.a(-1, "Expected " + Reflection.getOrCreateKotlinClass(sdk.pendo.io.l2.b.class) + " as the serialized body of " + descriptor.getSerialName() + ", but had " + Reflection.getOrCreateKotlinClass(r.getClass()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sdk.pendo.io.k2.e1
    /* renamed from: c, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public boolean a(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        sdk.pendo.io.l2.u l = l(tag);
        if (!getJson().getConfiguration().getIsLenient() && a(l, "boolean").getIsString()) {
            throw k.a(-1, "Boolean literal for key '" + tag + "' should be unquoted.\nUse 'isLenient = true' in 'Json {}` builder to accept non-compliant JSON.", r().toString());
        }
        try {
            Boolean a2 = sdk.pendo.io.l2.i.a(l);
            if (a2 != null) {
                return a2.booleanValue();
            }
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException unused) {
            m("boolean");
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sdk.pendo.io.k2.e1
    /* renamed from: g, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public float e(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        try {
            float d = sdk.pendo.io.l2.i.d(l(tag));
            if (!getJson().getConfiguration().getAllowSpecialFloatingPointValues()) {
                if (!((Float.isInfinite(d) || Float.isNaN(d)) ? false : true)) {
                    throw k.a(Float.valueOf(d), tag, r().toString());
                }
            }
            return d;
        } catch (IllegalArgumentException unused) {
            m("float");
            throw new KotlinNothingValueException();
        }
    }

    @Override // sdk.pendo.io.k2.l0
    protected String a(String parentName, String childName) {
        Intrinsics.checkNotNullParameter(parentName, "parentName");
        Intrinsics.checkNotNullParameter(childName, "childName");
        return childName;
    }

    @Override // sdk.pendo.io.l2.g
    /* renamed from: f, reason: from getter */
    public sdk.pendo.io.l2.a getJson() {
        return this.json;
    }

    @Override // sdk.pendo.io.j2.b
    /* renamed from: i */
    public sdk.pendo.io.n2.c getSerializersModule() {
        return getJson().getSerializersModule();
    }

    @Override // sdk.pendo.io.k2.e1, sdk.pendo.io.j2.d
    public <T> T a(sdk.pendo.io.g2.a<T> deserializer) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        return (T) r.a(this, deserializer);
    }

    @Override // sdk.pendo.io.j2.b
    public void c(sdk.pendo.io.i2.f descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // sdk.pendo.io.k2.e1
    public int a(String tag, sdk.pendo.io.i2.f enumDescriptor) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        return l.b(enumDescriptor, getJson(), l(tag).getContent());
    }
}
