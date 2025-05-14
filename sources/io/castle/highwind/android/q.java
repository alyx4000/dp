package io.castle.highwind.android;

import android.util.Base64;
import kotlin.text.Charsets;

/* loaded from: classes2.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final a f779a = new a();

    public static final class a {
        public final String a(Integer[] numArr) {
            return new String(Base64.encode(r.a(numArr), 11), Charsets.UTF_8);
        }
    }
}
