package com.google.android.gms.internal.fido;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
/* loaded from: classes3.dex */
final class zzbl extends zzcb {
    boolean zza;
    final /* synthetic */ Object zzb;

    zzbl(Object obj) {
        this.zzb = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.zza;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.zza) {
            throw new NoSuchElementException();
        }
        this.zza = true;
        return this.zzb;
    }
}
