package sdk.pendo.io.h2;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.ShortCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import sdk.pendo.io.g2.b;
import sdk.pendo.io.k2.a0;
import sdk.pendo.io.k2.b1;
import sdk.pendo.io.k2.c1;
import sdk.pendo.io.k2.d0;
import sdk.pendo.io.k2.d1;
import sdk.pendo.io.k2.e;
import sdk.pendo.io.k2.f1;
import sdk.pendo.io.k2.g;
import sdk.pendo.io.k2.h;
import sdk.pendo.io.k2.h0;
import sdk.pendo.io.k2.i0;
import sdk.pendo.io.k2.j;
import sdk.pendo.io.k2.k;
import sdk.pendo.io.k2.m0;
import sdk.pendo.io.k2.n;
import sdk.pendo.io.k2.o;
import sdk.pendo.io.k2.q;
import sdk.pendo.io.k2.r;
import sdk.pendo.io.k2.v;
import sdk.pendo.io.k2.w;
import sdk.pendo.io.k2.z;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0002\u0010\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\u001a\u0010\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000\u001a\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0001\u001a\u0010\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001*\u00020\u0006\u001a\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0001\u001a\u0010\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001*\u00020\n\u001a\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0001\u001a\u0010\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001*\u00020\u000e\u001a\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001\u001a\u0010\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00130\u0001*\u00020\u0012\u001a\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0001\u001a\u0010\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00170\u0001*\u00020\u0016\u001a\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0001\u001a\u0010\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0001*\u00020\u001a\u001a\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0001\u001a\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0001\u001a\u0010\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020 0\u0001*\u00020\u001f\u001a&\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#0\u0001\"\u0004\b\u0000\u0010!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\u001a@\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010(0\u0001\"\u0004\b\u0000\u0010$\"\u0004\b\u0001\u0010%2\f\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\u001a\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020*0\u0001*\u00020)¢\u0006\u0004\b+\u0010,\u001a\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020-0\u0001*\u00020-¢\u0006\u0004\b+\u0010.\"3\u00104\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001\"\b\b\u0000\u0010!*\u00020/*\b\u0012\u0004\u0012\u00028\u00000\u00018F¢\u0006\f\u0012\u0004\b2\u00103\u001a\u0004\b0\u00101¨\u00065"}, d2 = {"Lkotlin/Char$Companion;", "Lsdk/pendo/io/g2/b;", "", "a", "", "c", "Lkotlin/Byte$Companion;", "", "", "b", "Lkotlin/Short$Companion;", "", "", "h", "Lkotlin/Int$Companion;", "", "", "f", "Lkotlin/Long$Companion;", "", "", "g", "Lkotlin/Float$Companion;", "", "", "e", "Lkotlin/Double$Companion;", "", "", "d", "", "Lkotlin/String$Companion;", "", ExifInterface.GPS_DIRECTION_TRUE, "elementSerializer", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "keySerializer", "valueSerializer", "", "Lkotlin/Boolean$Companion;", "", "serializer", "(Lkotlin/jvm/internal/BooleanCompanionObject;)Lkotlinx/serialization/KSerializer;", "", "(Lkotlin/Unit;)Lkotlinx/serialization/KSerializer;", "", "getNullable", "(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "getNullable$annotations", "(Lkotlinx/serialization/KSerializer;)V", "nullable", "kotlinx-serialization-core"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class a {
    public static final b<boolean[]> a() {
        return g.c;
    }

    public static final b<byte[]> b() {
        return j.c;
    }

    public static final b<char[]> c() {
        return n.c;
    }

    public static final b<double[]> d() {
        return q.c;
    }

    public static final b<float[]> e() {
        return v.c;
    }

    public static final b<int[]> f() {
        return z.c;
    }

    public static final b<long[]> g() {
        return h0.c;
    }

    public static final b<short[]> h() {
        return b1.c;
    }

    public static final <T> b<List<T>> a(b<T> elementSerializer) {
        Intrinsics.checkNotNullParameter(elementSerializer, "elementSerializer");
        return new e(elementSerializer);
    }

    public static final <T> b<T> b(b<T> bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<this>");
        return bVar.getDescriptor().e() ? bVar : new m0(bVar);
    }

    public static final <K, V> b<Map<K, V>> a(b<K> keySerializer, b<V> valueSerializer) {
        Intrinsics.checkNotNullParameter(keySerializer, "keySerializer");
        Intrinsics.checkNotNullParameter(valueSerializer, "valueSerializer");
        return new d0(keySerializer, valueSerializer);
    }

    public static final b<Unit> a(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "<this>");
        return f1.b;
    }

    public static final b<Boolean> a(BooleanCompanionObject booleanCompanionObject) {
        Intrinsics.checkNotNullParameter(booleanCompanionObject, "<this>");
        return h.f1262a;
    }

    public static final b<Byte> a(ByteCompanionObject byteCompanionObject) {
        Intrinsics.checkNotNullParameter(byteCompanionObject, "<this>");
        return k.f1266a;
    }

    public static final b<Character> a(CharCompanionObject charCompanionObject) {
        Intrinsics.checkNotNullParameter(charCompanionObject, "<this>");
        return o.f1271a;
    }

    public static final b<Double> a(DoubleCompanionObject doubleCompanionObject) {
        Intrinsics.checkNotNullParameter(doubleCompanionObject, "<this>");
        return r.f1275a;
    }

    public static final b<Float> a(FloatCompanionObject floatCompanionObject) {
        Intrinsics.checkNotNullParameter(floatCompanionObject, "<this>");
        return w.f1279a;
    }

    public static final b<Integer> a(IntCompanionObject intCompanionObject) {
        Intrinsics.checkNotNullParameter(intCompanionObject, "<this>");
        return a0.f1252a;
    }

    public static final b<Long> a(LongCompanionObject longCompanionObject) {
        Intrinsics.checkNotNullParameter(longCompanionObject, "<this>");
        return i0.f1264a;
    }

    public static final b<Short> a(ShortCompanionObject shortCompanionObject) {
        Intrinsics.checkNotNullParameter(shortCompanionObject, "<this>");
        return c1.f1254a;
    }

    public static final b<String> a(StringCompanionObject stringCompanionObject) {
        Intrinsics.checkNotNullParameter(stringCompanionObject, "<this>");
        return d1.f1255a;
    }
}
