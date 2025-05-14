package com.quantummetric.ui.internal;

import androidx.compose.runtime.SnapshotMutableStateImpl;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.snapshots.StateRecord;
import com.quantummetric.ui.QuantumMetric;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
final class cg<T> extends SnapshotMutableStateImpl<T> implements cm {

    /* renamed from: a, reason: collision with root package name */
    private SnapshotMutableStateImpl<T> f165a;
    private h<Object> b;

    cg(SnapshotMutableStateImpl<T> snapshotMutableStateImpl) {
        super(snapshotMutableStateImpl.getValue(), snapshotMutableStateImpl.getPolicy());
        this.f165a = snapshotMutableStateImpl;
    }

    @Override // com.quantummetric.ui.internal.cm
    public final void a(h<Object> hVar) {
        this.b = hVar;
    }

    public final T component1() {
        return (T) this.f165a.component1();
    }

    public final Function1<T, Unit> component2() {
        return this.f165a.component2();
    }

    public final StateRecord getFirstStateRecord() {
        return this.f165a.getFirstStateRecord();
    }

    public final SnapshotMutationPolicy<T> getPolicy() {
        return this.f165a.getPolicy();
    }

    public final T getValue() {
        return (T) this.f165a.getValue();
    }

    public final StateRecord mergeRecords(StateRecord stateRecord, StateRecord stateRecord2, StateRecord stateRecord3) {
        return this.f165a.mergeRecords(stateRecord, stateRecord2, stateRecord3);
    }

    public final void prependStateRecord(StateRecord stateRecord) {
        this.f165a.prependStateRecord(stateRecord);
    }

    public final void setValue(T t) {
        boolean z;
        h<Object> hVar;
        if (!cd.f161a && QuantumMetric.b != null) {
            z = false;
            if (!z && (hVar = this.b) != null) {
                hVar.a(t);
            }
            this.f165a.setValue(t);
        }
        z = true;
        if (!z) {
            hVar.a(t);
        }
        this.f165a.setValue(t);
    }
}
