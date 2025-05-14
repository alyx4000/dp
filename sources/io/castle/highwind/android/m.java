package io.castle.highwind.android;

import androidx.autofill.HintConstants;
import io.castle.highwind.android.a0;
import io.castle.highwind.android.b0;
import io.castle.highwind.android.o;
import java.util.Date;
import java.util.List;
import java.util.Random;
import kotlin.collections.CollectionsKt;
import kotlin.text.CharsKt;

/* loaded from: classes2.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public final l f776a;

    public m(l lVar) {
        this.f776a = lVar;
    }

    public final String encodeCustomEvent(String str, String str2) {
        return a0.a.a(str, 5, str2, CollectionsKt.listOf((Object[]) new String[]{"name", "properties"}), CollectionsKt.listOf("properties"), 32);
    }

    public final String encodePayload(String str, String str2, List<String> list) {
        l lVar = this.f776a;
        String a2 = w.a(new Random().nextInt(256));
        b0.a aVar = b0.f763a;
        o.a aVar2 = o.f778a;
        String a3 = aVar.a(aVar2.a((int) ((new Date().getTime() / 1000) - 1535000000)), Integer.toString(new Random().nextInt(16) & 15, CharsKt.checkRadix(16)));
        String a4 = w.a(list.size());
        String substring = str.substring(3);
        String str3 = str2 + a4 + CollectionsKt.joinToString$default(list, "", null, null, 0, null, null, 62, null);
        return lVar.a(w.c(a2 + aVar2.a(w.a(48) + aVar.a(w.b(substring), 8, w.b(String.valueOf(substring.toCharArray()[9])).toCharArray()[0], a3 + aVar.a(a3, 4, a3.toCharArray()[3], str3 + w.a(str3.length() & 255))), a2)));
    }

    public final String encodeScreenEvent(String str, String str2) {
        return a0.a.a(str, 3, str2, CollectionsKt.listOf("name"), null, 48);
    }

    public final String encodeUserJwtPayloadSet(String str) {
        return a0.f762a.a(4, str, CollectionsKt.listOf("jwt"), CollectionsKt.emptyList(), true);
    }

    public final String encodeUserPayloadSet(String str) {
        return a0.f762a.a(0, str, CollectionsKt.listOf((Object[]) new String[]{"id", "email", HintConstants.AUTOFILL_HINT_PHONE, "registered_at", "traits", "signature", "name"}), CollectionsKt.listOf("traits"), false);
    }

    public abstract String token();
}
