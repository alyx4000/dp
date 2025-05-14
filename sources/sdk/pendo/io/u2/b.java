package sdk.pendo.io.u2;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public abstract class b<L, R> implements Map.Entry<L, R>, Comparable<b<L, R>>, Serializable {
    public static final b<?, ?>[] f = new a[0];

    private static final class a<L, R> extends b<L, R> {
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(b<L, R> bVar) {
        return new sdk.pendo.io.p2.a().a(a(), bVar.a()).a(b(), bVar.b()).a();
    }

    public abstract L a();

    public abstract R b();

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return Objects.equals(getKey(), entry.getKey()) && Objects.equals(getValue(), entry.getValue());
    }

    @Override // java.util.Map.Entry
    public final L getKey() {
        return a();
    }

    @Override // java.util.Map.Entry
    public R getValue() {
        return b();
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
    }

    public String toString() {
        return "(" + a() + ',' + b() + ')';
    }

    public static <L, R> b<L, R> a(L l, R r) {
        return sdk.pendo.io.u2.a.b(l, r);
    }
}
