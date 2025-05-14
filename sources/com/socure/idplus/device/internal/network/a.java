package com.socure.idplus.device.internal.network;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f580a;
    public final String b;
    public final String c;

    public a(Integer num, String str, String str2) {
        this.f580a = num;
        this.b = str;
        this.c = str2;
    }

    public final String a() {
        return this.c;
    }

    public final Integer b() {
        return this.f580a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual(this.f580a, aVar.f580a) && Intrinsics.areEqual(this.b, aVar.b) && Intrinsics.areEqual(this.c, aVar.c);
    }

    public final int hashCode() {
        Integer num = this.f580a;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        return "DataError(responseCode=" + this.f580a + ", code=" + this.b + ", message=" + this.c + ")";
    }
}
