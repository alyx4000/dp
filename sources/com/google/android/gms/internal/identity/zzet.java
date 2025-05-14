package com.google.android.gms.internal.identity;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-location@@21.1.0 */
/* loaded from: classes3.dex */
final class zzet extends zzes {
    static final zzes zza = new zzet(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzet(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzem.zzc(i, this.zzc, "index");
        return Objects.requireNonNull(this.zzb[i]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.identity.zzep
    final Object[] zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.identity.zzep
    final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.identity.zzep
    final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.identity.zzep
    final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.identity.zzes, com.google.android.gms.internal.identity.zzep
    final int zzg(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }
}
