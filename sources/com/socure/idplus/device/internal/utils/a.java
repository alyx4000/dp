package com.socure.idplus.device.internal.utils;

import io.sentry.protocol.SentryStackFrame;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class a {
    public static final a b;
    public static final a c;
    public static final a d;
    public static final a e;
    public static final /* synthetic */ a[] f;

    /* renamed from: a, reason: collision with root package name */
    public final String f616a;

    static {
        a aVar = new a("REACT_NATIVE", 0, "reactNative");
        b = aVar;
        a aVar2 = new a("REACT", 1, "react");
        c = aVar2;
        a aVar3 = new a("FLUTTER", 2, "flutter");
        d = aVar3;
        a aVar4 = new a("NATIVE", 3, SentryStackFrame.JsonKeys.NATIVE);
        e = aVar4;
        a[] aVarArr = {aVar, aVar2, aVar3, aVar4, new a("UNKNOWN", 4, "unknown")};
        f = aVarArr;
        EnumEntriesKt.enumEntries(aVarArr);
    }

    public a(String str, int i, String str2) {
        this.f616a = str2;
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) f.clone();
    }
}
