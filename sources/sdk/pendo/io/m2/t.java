package sdk.pendo.io.m2;

import androidx.exifinterface.media.ExifInterface;
import com.amplitude.reactnative.DatabaseConstants;
import com.facebook.common.callercontext.ContextChain;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.i2.j;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\u0006\u00100\u001a\u00020,\u0012\u0006\u00103\u001a\u000201\u0012\u0006\u00106\u001a\u000204\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\bD\u0010EJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\u000eH\u0002J\b\u0010\u0006\u001a\u00020\u0013H\u0016J\u0010\u0010\u0010\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u000bH\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010\u001d\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020#H\u0016J\b\u0010%\u001a\u00020\u000eH\u0016J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010&\u001a\u00020\u0003H\u0016J#\u0010*\u001a\u00028\u0000\"\u0004\b\u0000\u0010'2\f\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000(H\u0016¢\u0006\u0004\b*\u0010+R\u0017\u00100\u001a\u00020,8\u0006¢\u0006\f\n\u0004\b\u0010\u0010-\u001a\u0004\b.\u0010/R\u0014\u00103\u001a\u0002018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u00102R\u0014\u00106\u001a\u0002048\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0015\u00105R\u001a\u0010;\u001a\u0002078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u00108\u001a\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010<R\u0014\u0010@\u001a\u00020>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010?R\u0016\u0010C\u001a\u0004\u0018\u00010A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010B¨\u0006F"}, d2 = {"Lsdk/pendo/io/m2/t;", "Lsdk/pendo/io/l2/g;", "Lsdk/pendo/io/j2/a;", "Lsdk/pendo/io/i2/f;", "descriptor", "", "g", ContextChain.TAG_PRODUCT, "", "r", "index", "", "j", "f", "", DatabaseConstants.KEY_FIELD, "a", "q", "s", "Lsdk/pendo/io/l2/h;", "Lsdk/pendo/io/j2/b;", "c", "", "k", "e", "b", "", "", "l", "h", "", "", "n", "", "o", "", "d", "m", "enumDescriptor", ExifInterface.GPS_DIRECTION_TRUE, "Lsdk/pendo/io/g2/a;", "deserializer", "decodeSerializableValue", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "Lsdk/pendo/io/l2/a;", "Lsdk/pendo/io/l2/a;", "getJson", "()Lkotlinx/serialization/json/Json;", "json", "Lsdk/pendo/io/m2/x;", "Lsdk/pendo/io/m2/x;", "mode", "Lsdk/pendo/io/m2/a;", "Lsdk/pendo/io/m2/a;", "lexer", "Lsdk/pendo/io/n2/c;", "Lsdk/pendo/io/n2/c;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "serializersModule", "I", "currentIndex", "Lsdk/pendo/io/l2/f;", "Lsdk/pendo/io/l2/f;", "configuration", "Lsdk/pendo/io/m2/h;", "Lsdk/pendo/io/m2/h;", "elementMarker", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;Lkotlinx/serialization/json/internal/AbstractJsonLexer;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public class t extends sdk.pendo.io.j2.a implements sdk.pendo.io.l2.g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final sdk.pendo.io.l2.a json;

    /* renamed from: b, reason: from kotlin metadata */
    private final x mode;

    /* renamed from: c, reason: from kotlin metadata */
    public final sdk.pendo.io.m2.a lexer;

    /* renamed from: d, reason: from kotlin metadata */
    private final sdk.pendo.io.n2.c serializersModule;

    /* renamed from: e, reason: from kotlin metadata */
    private int currentIndex;

    /* renamed from: f, reason: from kotlin metadata */
    private final sdk.pendo.io.l2.f configuration;

    /* renamed from: g, reason: from kotlin metadata */
    private final h elementMarker;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1384a;

        static {
            int[] iArr = new int[x.values().length];
            iArr[x.LIST.ordinal()] = 1;
            iArr[x.MAP.ordinal()] = 2;
            iArr[x.POLY_OBJ.ordinal()] = 3;
            iArr[x.OBJ.ordinal()] = 4;
            f1384a = iArr;
        }
    }

    public t(sdk.pendo.io.l2.a json, x mode, sdk.pendo.io.m2.a lexer, sdk.pendo.io.i2.f descriptor) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(lexer, "lexer");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.json = json;
        this.mode = mode;
        this.lexer = lexer;
        this.serializersModule = json.getSerializersModule();
        this.currentIndex = -1;
        sdk.pendo.io.l2.f configuration = json.getConfiguration();
        this.configuration = configuration;
        this.elementMarker = configuration.getExplicitNulls() ? null : new h(descriptor);
    }

    private final int f(sdk.pendo.io.i2.f descriptor) {
        int a2;
        boolean z;
        boolean p = this.lexer.p();
        while (true) {
            boolean z2 = false;
            if (!this.lexer.a()) {
                if (p) {
                    sdk.pendo.io.m2.a.a(this.lexer, "Unexpected trailing comma", 0, 2, null);
                    throw new KotlinNothingValueException();
                }
                h hVar = this.elementMarker;
                if (hVar == null) {
                    return -1;
                }
                return hVar.b();
            }
            String s = s();
            this.lexer.a(':');
            a2 = l.a(descriptor, this.json, s);
            if (a2 == -3) {
                z2 = true;
                z = false;
            } else {
                if (!this.configuration.getCoerceInputValues() || !j(descriptor, a2)) {
                    break;
                }
                z = this.lexer.p();
            }
            p = z2 ? a(s) : z;
        }
        h hVar2 = this.elementMarker;
        if (hVar2 != null) {
            hVar2.a(a2);
        }
        return a2;
    }

    private final boolean j(sdk.pendo.io.i2.f descriptor, int index) {
        String a2;
        sdk.pendo.io.l2.a aVar = this.json;
        sdk.pendo.io.i2.f c = descriptor.c(index);
        if (!c.e() && (!this.lexer.q())) {
            return true;
        }
        if (!Intrinsics.areEqual(c.getKind(), j.b.f1196a) || (a2 = this.lexer.a(this.configuration.getIsLenient())) == null || l.a(c, aVar, a2) != -3) {
            return false;
        }
        this.lexer.g();
        return true;
    }

    private final void p() {
        if (this.lexer.m() != 4) {
            return;
        }
        sdk.pendo.io.m2.a.a(this.lexer, "Unexpected leading comma", 0, 2, null);
        throw new KotlinNothingValueException();
    }

    private final int q() {
        boolean p = this.lexer.p();
        if (!this.lexer.a()) {
            if (!p) {
                return -1;
            }
            sdk.pendo.io.m2.a.a(this.lexer, "Unexpected trailing comma", 0, 2, null);
            throw new KotlinNothingValueException();
        }
        int i = this.currentIndex;
        if (i != -1 && !p) {
            sdk.pendo.io.m2.a.a(this.lexer, "Expected end of the array or comma", 0, 2, null);
            throw new KotlinNothingValueException();
        }
        int i2 = i + 1;
        this.currentIndex = i2;
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int r() {
        /*
            r6 = this;
            int r0 = r6.currentIndex
            int r1 = r0 % 2
            r2 = 1
            r3 = 0
            if (r1 == 0) goto La
            r1 = r2
            goto Lb
        La:
            r1 = r3
        Lb:
            r4 = -1
            if (r1 == 0) goto L17
            if (r0 == r4) goto L1e
            sdk.pendo.io.m2.a r0 = r6.lexer
            boolean r0 = r0.p()
            goto L1f
        L17:
            sdk.pendo.io.m2.a r0 = r6.lexer
            r5 = 58
            r0.a(r5)
        L1e:
            r0 = r3
        L1f:
            sdk.pendo.io.m2.a r5 = r6.lexer
            boolean r5 = r5.a()
            if (r5 == 0) goto L5d
            if (r1 == 0) goto L56
            int r1 = r6.currentIndex
            if (r1 != r4) goto L42
            sdk.pendo.io.m2.a r1 = r6.lexer
            r0 = r0 ^ r2
            int r3 = sdk.pendo.io.m2.a.a(r1)
            if (r0 == 0) goto L37
            goto L56
        L37:
            java.lang.String r0 = "Unexpected trailing comma"
            r1.b(r0, r3)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L42:
            sdk.pendo.io.m2.a r1 = r6.lexer
            int r3 = sdk.pendo.io.m2.a.a(r1)
            if (r0 == 0) goto L4b
            goto L56
        L4b:
            java.lang.String r0 = "Expected comma after the key-value pair"
            r1.b(r0, r3)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        L56:
            int r0 = r6.currentIndex
            int r4 = r0 + 1
            r6.currentIndex = r4
            goto L5f
        L5d:
            if (r0 != 0) goto L60
        L5f:
            return r4
        L60:
            sdk.pendo.io.m2.a r0 = r6.lexer
            java.lang.String r1 = "Expected '}', but had ',' instead"
            r2 = 0
            r4 = 2
            sdk.pendo.io.m2.a.a(r0, r1, r3, r4, r2)
            kotlin.KotlinNothingValueException r0 = new kotlin.KotlinNothingValueException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.m2.t.r():int");
    }

    private final String s() {
        return this.configuration.getIsLenient() ? this.lexer.i() : this.lexer.d();
    }

    @Override // sdk.pendo.io.j2.d
    public sdk.pendo.io.j2.b a(sdk.pendo.io.i2.f descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        x a2 = y.a(this.json, descriptor);
        this.lexer.a(a2.begin);
        p();
        int i = a.f1384a[a2.ordinal()];
        return (i == 1 || i == 2 || i == 3) ? new t(this.json, a2, this.lexer, descriptor) : (this.mode == a2 && this.json.getConfiguration().getExplicitNulls()) ? this : new t(this.json, a2, this.lexer, descriptor);
    }

    @Override // sdk.pendo.io.j2.a, sdk.pendo.io.j2.d
    public boolean b() {
        return this.configuration.getIsLenient() ? this.lexer.c() : this.lexer.b();
    }

    @Override // sdk.pendo.io.j2.a, sdk.pendo.io.j2.d
    public boolean c() {
        h hVar = this.elementMarker;
        return !(hVar == null ? false : hVar.getIsUnmarkedNull()) && this.lexer.q();
    }

    @Override // sdk.pendo.io.j2.a, sdk.pendo.io.j2.d
    public char d() {
        String h = this.lexer.h();
        if (h.length() == 1) {
            return h.charAt(0);
        }
        sdk.pendo.io.m2.a.a(this.lexer, "Expected single char, but got '" + h + '\'', 0, 2, null);
        throw new KotlinNothingValueException();
    }

    @Override // sdk.pendo.io.j2.b
    public int e(sdk.pendo.io.i2.f descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        int i = a.f1384a[this.mode.ordinal()];
        return i != 2 ? i != 4 ? q() : f(descriptor) : r();
    }

    @Override // sdk.pendo.io.l2.g
    public sdk.pendo.io.l2.h g() {
        return new q(this.json.getConfiguration(), this.lexer).a();
    }

    @Override // sdk.pendo.io.j2.a, sdk.pendo.io.j2.d
    public int h() {
        long f = this.lexer.f();
        int i = (int) f;
        if (f == i) {
            return i;
        }
        sdk.pendo.io.m2.a.a(this.lexer, "Failed to parse int for input '" + f + '\'', 0, 2, null);
        throw new KotlinNothingValueException();
    }

    @Override // sdk.pendo.io.j2.b
    /* renamed from: i, reason: from getter */
    public sdk.pendo.io.n2.c getSerializersModule() {
        return this.serializersModule;
    }

    @Override // sdk.pendo.io.j2.a, sdk.pendo.io.j2.d
    public Void k() {
        return null;
    }

    @Override // sdk.pendo.io.j2.a, sdk.pendo.io.j2.d
    public short l() {
        long f = this.lexer.f();
        short s = (short) f;
        if (f == s) {
            return s;
        }
        sdk.pendo.io.m2.a.a(this.lexer, "Failed to parse short for input '" + f + '\'', 0, 2, null);
        throw new KotlinNothingValueException();
    }

    @Override // sdk.pendo.io.j2.a, sdk.pendo.io.j2.d
    public String m() {
        return this.configuration.getIsLenient() ? this.lexer.i() : this.lexer.g();
    }

    @Override // sdk.pendo.io.j2.a, sdk.pendo.io.j2.d
    public float n() {
        sdk.pendo.io.m2.a aVar = this.lexer;
        String h = aVar.h();
        boolean z = false;
        try {
            float parseFloat = Float.parseFloat(h);
            if (!this.json.getConfiguration().getAllowSpecialFloatingPointValues()) {
                if (!Float.isInfinite(parseFloat) && !Float.isNaN(parseFloat)) {
                    z = true;
                }
                if (!z) {
                    k.a(this.lexer, Float.valueOf(parseFloat));
                    throw new KotlinNothingValueException();
                }
            }
            return parseFloat;
        } catch (IllegalArgumentException unused) {
            sdk.pendo.io.m2.a.a(aVar, "Failed to parse type 'float' for input '" + h + '\'', 0, 2, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override // sdk.pendo.io.j2.a, sdk.pendo.io.j2.d
    public double o() {
        sdk.pendo.io.m2.a aVar = this.lexer;
        String h = aVar.h();
        boolean z = false;
        try {
            double parseDouble = Double.parseDouble(h);
            if (!this.json.getConfiguration().getAllowSpecialFloatingPointValues()) {
                if (!Double.isInfinite(parseDouble) && !Double.isNaN(parseDouble)) {
                    z = true;
                }
                if (!z) {
                    k.a(this.lexer, Double.valueOf(parseDouble));
                    throw new KotlinNothingValueException();
                }
            }
            return parseDouble;
        } catch (IllegalArgumentException unused) {
            sdk.pendo.io.m2.a.a(aVar, "Failed to parse type 'double' for input '" + h + '\'', 0, 2, null);
            throw new KotlinNothingValueException();
        }
    }

    private final void g(sdk.pendo.io.i2.f descriptor) {
        while (e(descriptor) != -1) {
        }
    }

    @Override // sdk.pendo.io.j2.a, sdk.pendo.io.j2.d
    public long a() {
        return this.lexer.f();
    }

    @Override // sdk.pendo.io.j2.d
    public int b(sdk.pendo.io.i2.f enumDescriptor) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        return l.b(enumDescriptor, this.json, m());
    }

    @Override // sdk.pendo.io.j2.b
    public void c(sdk.pendo.io.i2.f descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (this.json.getConfiguration().getIgnoreUnknownKeys() && descriptor.getElementsCount() == 0) {
            g(descriptor);
        }
        this.lexer.a(this.mode.end);
    }

    @Override // sdk.pendo.io.l2.g
    /* renamed from: f, reason: from getter */
    public final sdk.pendo.io.l2.a getJson() {
        return this.json;
    }

    @Override // sdk.pendo.io.j2.a, sdk.pendo.io.j2.d
    public byte j() {
        long f = this.lexer.f();
        byte b = (byte) f;
        if (f == b) {
            return b;
        }
        sdk.pendo.io.m2.a.a(this.lexer, "Failed to parse byte for input '" + f + '\'', 0, 2, null);
        throw new KotlinNothingValueException();
    }

    @Override // sdk.pendo.io.j2.a, sdk.pendo.io.j2.d
    public <T> T a(sdk.pendo.io.g2.a<T> deserializer) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        return (T) r.a(this, deserializer);
    }

    private final boolean a(String key) {
        if (this.configuration.getIgnoreUnknownKeys()) {
            this.lexer.b(this.configuration.getIsLenient());
        } else {
            this.lexer.a(key);
        }
        return this.lexer.p();
    }
}
