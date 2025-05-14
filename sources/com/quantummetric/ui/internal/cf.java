package com.quantummetric.ui.internal;

import androidx.compose.runtime.MutableIntState;
import com.quantummetric.ui.QuantumMetric;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
final class cf implements MutableIntState, cm {

    /* renamed from: a, reason: collision with root package name */
    private MutableIntState f164a;
    private h<Object> b;

    cf(MutableIntState mutableIntState) {
        this.f164a = mutableIntState;
    }

    @Override // com.quantummetric.ui.internal.cm
    public final void a(h<Object> hVar) {
        this.b = hVar;
    }

    public final /* bridge */ /* synthetic */ Object component1() {
        return (Integer) this.f164a.component1();
    }

    public final Function1<Integer, Unit> component2() {
        return this.f164a.component2();
    }

    public final int getIntValue() {
        return this.f164a.getIntValue();
    }

    /* renamed from: getValue, reason: merged with bridge method [inline-methods] */
    public final Integer m930getValue() {
        return this.f164a.getValue();
    }

    public final void setIntValue(int i) {
        boolean z;
        h<Object> hVar;
        this.f164a.setIntValue(i);
        Integer valueOf = Integer.valueOf(i);
        try {
            if (!cd.f161a && QuantumMetric.b != null) {
                z = false;
                if (!z || (hVar = this.b) == null) {
                }
                hVar.a(valueOf);
                return;
            }
            z = true;
            if (z) {
            }
        } catch (Throwable unused) {
        }
    }

    public final void setValue(int i) {
        boolean z;
        h<Object> hVar;
        this.f164a.setValue(i);
        Integer valueOf = Integer.valueOf(i);
        try {
            if (!cd.f161a && QuantumMetric.b != null) {
                z = false;
                if (!z || (hVar = this.b) == null) {
                }
                hVar.a(valueOf);
                return;
            }
            z = true;
            if (z) {
            }
        } catch (Throwable unused) {
        }
    }

    public final /* synthetic */ void setValue(Object obj) {
        boolean z;
        h<Object> hVar;
        Integer num = (Integer) obj;
        this.f164a.setValue(num);
        try {
            if (!cd.f161a && QuantumMetric.b != null) {
                z = false;
                if (!z || (hVar = this.b) == null) {
                }
                hVar.a(num);
                return;
            }
            z = true;
            if (z) {
            }
        } catch (Throwable unused) {
        }
    }
}
