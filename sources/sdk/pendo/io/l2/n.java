package sdk.pendo.io.l2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\u000e\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0013\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0017"}, d2 = {"Lsdk/pendo/io/l2/n;", "Lsdk/pendo/io/l2/u;", "", "toString", "", "other", "", "equals", "", "hashCode", "f", "Z", "b", "()Z", "isString", "s", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "content", "body", "<init>", "(Ljava/lang/Object;Z)V", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class n extends u {

    /* renamed from: f, reason: from kotlin metadata */
    private final boolean isString;

    /* renamed from: s, reason: from kotlin metadata */
    private final String content;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(Object body, boolean z) {
        super(null);
        Intrinsics.checkNotNullParameter(body, "body");
        this.isString = z;
        this.content = body.toString();
    }

    @Override // sdk.pendo.io.l2.u
    /* renamed from: a, reason: from getter */
    public String getContent() {
        return this.content;
    }

    /* renamed from: b, reason: from getter */
    public boolean getIsString() {
        return this.isString;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(n.class), Reflection.getOrCreateKotlinClass(other.getClass()))) {
            return false;
        }
        n nVar = (n) other;
        return getIsString() == nVar.getIsString() && Intrinsics.areEqual(getContent(), nVar.getContent());
    }

    public int hashCode() {
        return (Boolean.valueOf(getIsString()).hashCode() * 31) + getContent().hashCode();
    }

    @Override // sdk.pendo.io.l2.u
    public String toString() {
        if (!getIsString()) {
            return getContent();
        }
        StringBuilder sb = new StringBuilder();
        sdk.pendo.io.m2.v.a(sb, getContent());
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
