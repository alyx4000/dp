package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.2.0 */
/* loaded from: classes3.dex */
final class zzbn extends AbstractSet {
    final /* synthetic */ zzbt zza;

    zzbn(zzbt zzbtVar) {
        this.zza = zzbtVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@CheckForNull Object obj) {
        int zzq;
        Map zzj = this.zza.zzj();
        if (zzj != null) {
            return zzj.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            zzq = this.zza.zzq(entry.getKey());
            if (zzq != -1) {
                Object[] objArr = this.zza.zzc;
                objArr.getClass();
                if (zzam.zza(objArr[zzq], entry.getValue())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        zzbt zzbtVar = this.zza;
        Map zzj = zzbtVar.zzj();
        return zzj != null ? zzj.entrySet().iterator() : new zzbl(zzbtVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(@CheckForNull Object obj) {
        int zzp;
        int i;
        Map zzj = this.zza.zzj();
        if (zzj != null) {
            return zzj.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        zzbt zzbtVar = this.zza;
        if (zzbtVar.zzo()) {
            return false;
        }
        zzp = zzbtVar.zzp();
        Object key = entry.getKey();
        Object value = entry.getValue();
        Object zzh = zzbt.zzh(this.zza);
        zzbt zzbtVar2 = this.zza;
        int[] iArr = zzbtVar2.zza;
        iArr.getClass();
        Object[] objArr = zzbtVar2.zzb;
        objArr.getClass();
        Object[] objArr2 = zzbtVar2.zzc;
        objArr2.getClass();
        int zzb = zzbu.zzb(key, value, zzp, zzh, iArr, objArr, objArr2);
        if (zzb == -1) {
            return false;
        }
        this.zza.zzn(zzb, zzp);
        zzbt zzbtVar3 = this.zza;
        i = zzbtVar3.zzg;
        zzbtVar3.zzg = i - 1;
        this.zza.zzl();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }
}
