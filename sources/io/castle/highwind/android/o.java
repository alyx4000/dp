package io.castle.highwind.android;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* loaded from: classes2.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public static final a f778a = new a();

    public static final class a {
        public final String a(String str, String str2) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            for (char c : str.toCharArray()) {
                arrayList.add(Integer.toString(Integer.parseInt(Character.toString(c), CharsKt.checkRadix(16)) ^ Integer.parseInt(Character.toString(str2.toCharArray()[i]), CharsKt.checkRadix(16)), CharsKt.checkRadix(16)));
                i = (i + 1) % str2.length();
            }
            return CollectionsKt.joinToString$default(arrayList, "", null, null, 0, null, null, 62, null);
        }

        public final String a(int i) {
            int max = Math.max(Math.min(i, 268435455), 0);
            return w.a(max >> 24) + w.a(i >> 16) + w.a(max >> 8) + w.a(i);
        }

        public final String a(String str, int i) {
            List split$default = StringsKt.split$default((CharSequence) str, new String[]{"."}, false, 0, 6, (Object) null);
            int parseInt = Integer.parseInt((String) split$default.get(0), CharsKt.checkRadix(10)) - 1;
            int parseInt2 = Integer.parseInt((String) split$default.get(1), CharsKt.checkRadix(10));
            return w.a((Integer.parseInt((String) split$default.get(2), CharsKt.checkRadix(10)) & 63) | (i << 13) | ((parseInt & 3) << 11) | ((parseInt2 & 31) << 6), 2);
        }
    }
}
