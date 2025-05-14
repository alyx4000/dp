package sdk.pendo.io.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u00042\u00020\u0005B%\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0006\u0010\u0007\u001a\u00028\u0001\u0012\u0006\u0010\b\u001a\u00028\u0002\u0012\u0006\u0010\t\u001a\u00028\u0003¢\u0006\u0002\u0010\nJ\u000e\u0010\u0013\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\fJ\u000e\u0010\u0014\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\fJ\u000e\u0010\u0015\u001a\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\fJ\u000e\u0010\u0016\u001a\u00028\u0003HÆ\u0003¢\u0006\u0002\u0010\fJN\u0010\u0017\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u00002\b\b\u0002\u0010\u0007\u001a\u00028\u00012\b\b\u0002\u0010\b\u001a\u00028\u00022\b\b\u0002\u0010\t\u001a\u00028\u0003HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u001c\u0010\u0006\u001a\u00028\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0013\u0010\t\u001a\u00028\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\fR\u0013\u0010\u0007\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\b\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\f¨\u0006 "}, d2 = {"Lsdk/pendo/io/models/Quadruple;", "T1", "T2", "T3", "T4", "", "first", "second", "third", "fourth", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "getFirst", "()Ljava/lang/Object;", "setFirst", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getFourth", "getSecond", "getThird", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lsdk/pendo/io/models/Quadruple;", "equals", "", "other", "hashCode", "", "toString", "", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final /* data */ class Quadruple<T1, T2, T3, T4> {
    private T1 first;
    private final T4 fourth;
    private final T2 second;
    private final T3 third;

    public Quadruple(T1 t1, T2 t2, T3 t3, T4 t4) {
        this.first = t1;
        this.second = t2;
        this.third = t3;
        this.fourth = t4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Quadruple copy$default(Quadruple quadruple, Object obj, Object obj2, Object obj3, Object obj4, int i, Object obj5) {
        if ((i & 1) != 0) {
            obj = quadruple.first;
        }
        if ((i & 2) != 0) {
            obj2 = quadruple.second;
        }
        if ((i & 4) != 0) {
            obj3 = quadruple.third;
        }
        if ((i & 8) != 0) {
            obj4 = quadruple.fourth;
        }
        return quadruple.copy(obj, obj2, obj3, obj4);
    }

    public final T1 component1() {
        return this.first;
    }

    public final T2 component2() {
        return this.second;
    }

    public final T3 component3() {
        return this.third;
    }

    public final T4 component4() {
        return this.fourth;
    }

    public final Quadruple<T1, T2, T3, T4> copy(T1 first, T2 second, T3 third, T4 fourth) {
        return new Quadruple<>(first, second, third, fourth);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Quadruple)) {
            return false;
        }
        Quadruple quadruple = (Quadruple) other;
        return Intrinsics.areEqual(this.first, quadruple.first) && Intrinsics.areEqual(this.second, quadruple.second) && Intrinsics.areEqual(this.third, quadruple.third) && Intrinsics.areEqual(this.fourth, quadruple.fourth);
    }

    public final T1 getFirst() {
        return this.first;
    }

    public final T4 getFourth() {
        return this.fourth;
    }

    public final T2 getSecond() {
        return this.second;
    }

    public final T3 getThird() {
        return this.third;
    }

    public int hashCode() {
        T1 t1 = this.first;
        int hashCode = (t1 == null ? 0 : t1.hashCode()) * 31;
        T2 t2 = this.second;
        int hashCode2 = (hashCode + (t2 == null ? 0 : t2.hashCode())) * 31;
        T3 t3 = this.third;
        int hashCode3 = (hashCode2 + (t3 == null ? 0 : t3.hashCode())) * 31;
        T4 t4 = this.fourth;
        return hashCode3 + (t4 != null ? t4.hashCode() : 0);
    }

    public final void setFirst(T1 t1) {
        this.first = t1;
    }

    public String toString() {
        return "Quadruple(first=" + this.first + ", second=" + this.second + ", third=" + this.third + ", fourth=" + this.fourth + ")";
    }
}
