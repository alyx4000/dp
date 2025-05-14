package com.quantummetric.ui.internal;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class bf extends HashMap<String, Object> implements x {

    /* renamed from: a, reason: collision with root package name */
    boolean f108a = false;

    bf() {
    }

    @Override // com.quantummetric.ui.internal.x
    public final byte[] a() {
        return de.f(de.a((Map<String, ?>) this).toString());
    }

    @Override // com.quantummetric.ui.internal.x
    public final String b() {
        return de.a((Map<String, ?>) this).toString();
    }
}
