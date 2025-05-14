package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.2.0 */
/* loaded from: classes3.dex */
public abstract class zzcg extends zzby implements Set {

    @CheckForNull
    private transient zzcd zza;

    zzcg() {
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this || obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (containsAll(set)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        return zzcz.zza(this);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzby, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zzd */
    public abstract zzdb iterator();

    public final zzcd zzf() {
        zzcd zzcdVar = this.zza;
        if (zzcdVar != null) {
            return zzcdVar;
        }
        zzcd zzg = zzg();
        this.zza = zzg;
        return zzg;
    }

    zzcd zzg() {
        Object[] array = toArray();
        int i = zzcd.zzd;
        return zzcd.zzg(array, array.length);
    }
}
