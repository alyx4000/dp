package io.castle.highwind.android;

import io.castle.highwind.android.b0;
import io.castle.highwind.android.o;
import java.util.Date;
import java.util.Random;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* loaded from: classes2.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    public final String f780a;
    public final String b = w.a(9);
    public final String c = w.a(255);
    public final String d;
    public final String e;

    public s(String str, String str2, String str3) {
        this.f780a = str3;
        this.d = StringsKt.replace$default(str, "-", "", false, 4, (Object) null);
        this.e = o.f778a.a(str2, 2);
        if (!StringsKt.startsWith$default(str3, "pk_", false, 2, (Object) null) || str3.length() != 35) {
            throw new IllegalArgumentException("Invalid publishable key");
        }
    }

    public abstract Integer a();

    public abstract String a(byte[] bArr);

    public abstract z b();

    public abstract void c();

    public abstract int d();

    public abstract z e();

    public final String f() {
        String str;
        g();
        int time = (int) ((new Date().getTime() / 1000) - 1535000000);
        String a2 = w.a(new Random().nextInt(256));
        String num = Integer.toString(new Random().nextInt(16) & 15, CharsKt.checkRadix(16));
        y a3 = e().a();
        String str2 = a3.f782a;
        c();
        String a4 = w.a((a3.b & 31) | 64);
        String a5 = w.a(this.f780a.substring(3));
        StringBuilder sb = new StringBuilder();
        b0.a aVar = b0.f763a;
        o.a aVar2 = o.f778a;
        StringBuilder append = sb.append(aVar.a(aVar2.a(time), num));
        String valueOf = String.valueOf(time);
        String sb2 = append.append(aVar.a(w.a(Integer.parseInt(StringsKt.slice(valueOf, RangesKt.until(valueOf.length() - 3, valueOf.length()))), 2), num)).toString();
        if (d() == 1) {
            str = a4 + str2 + this.c;
        } else {
            z b = b();
            y a6 = b != null ? b.a() : null;
            str = a4 + str2 + w.a((a6.b & 31) | ((a().intValue() & 7) << 5)) + (a6 != null ? a6.f782a : null) + this.c;
        }
        String a7 = aVar.a(sb2, 4, sb2.toCharArray()[3], str);
        String str3 = this.d;
        String str4 = this.b + a5 + this.e + this.d + aVar.a(str3, 8, str3.toCharArray()[9], sb2 + a7);
        return a(w.c(a2 + aVar2.a(str4 + w.a(str4.length()), a2)).getBytes(Charsets.ISO_8859_1));
    }

    public abstract void g();
}
