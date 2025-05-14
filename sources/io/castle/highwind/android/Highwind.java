package io.castle.highwind.android;

import android.content.Context;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes2.dex */
public final class Highwind extends m {
    public static final int ID_SOURCE_GENERATED = 0;
    public final d b;
    public static final Companion Companion = new Companion(null);
    public static final int ID_SOURCE_WIDEVINE = 1;

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Highwind(Context context, String str, String str2, String str3, String str4, int i) {
        super(new b());
        this.b = new d(str2, context, str, str3, str4, i);
    }

    @Override // io.castle.highwind.android.m
    public String token() {
        return this.b.f();
    }
}
