package com.google.android.gms.internal.mlkit_common;

import java.util.AbstractMap;

/* compiled from: com.google.mlkit:common@@18.8.0 */
/* loaded from: classes3.dex */
final class zzay extends zzar {
    final /* synthetic */ zzaz zza;

    zzay(zzaz zzazVar) {
        this.zza = zzazVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i) {
        int i2;
        Object[] objArr;
        Object[] objArr2;
        i2 = this.zza.zzc;
        zzaf.zza(i, i2, "index");
        zzaz zzazVar = this.zza;
        objArr = zzazVar.zzb;
        int i3 = i + i;
        Object obj = objArr[i3];
        obj.getClass();
        objArr2 = zzazVar.zzb;
        Object obj2 = objArr2[i3 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        int i;
        i = this.zza.zzc;
        return i;
    }
}
