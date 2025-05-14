package com.socure.idplus.device.internal.permission;

import com.google.android.gms.stats.CodePackage;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f584a;
    public static final /* synthetic */ b[] b;

    static {
        b bVar = new b(CodePackage.LOCATION, 0);
        f584a = bVar;
        b[] bVarArr = {bVar, new b("NETWORK", 1), new b("WIFI", 2), new b("READ_PHONE", 3)};
        b = bVarArr;
        EnumEntriesKt.enumEntries(bVarArr);
    }

    public b(String str, int i) {
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) b.clone();
    }
}
