package sdk.pendo.io.a;

import java.util.Arrays;

/* loaded from: classes6.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private final String f823a;
    private final String b;
    private final q c;
    private final Object[] d;

    public i(String str, String str2, q qVar, Object... objArr) {
        this.f823a = str;
        this.b = str2;
        this.c = qVar;
        this.d = objArr;
    }

    public q a() {
        return this.c;
    }

    Object[] b() {
        return this.d;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.f823a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f823a.equals(iVar.f823a) && this.b.equals(iVar.b) && this.c.equals(iVar.c) && Arrays.equals(this.d, iVar.d);
    }

    public int hashCode() {
        return ((this.f823a.hashCode() ^ Integer.rotateLeft(this.b.hashCode(), 8)) ^ Integer.rotateLeft(this.c.hashCode(), 16)) ^ Integer.rotateLeft(Arrays.hashCode(this.d), 24);
    }

    public String toString() {
        return this.f823a + " : " + this.b + ' ' + this.c + ' ' + Arrays.toString(this.d);
    }
}
