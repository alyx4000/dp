package com.google.android.gms.internal.fido;

import java.util.Arrays;
import org.tensorflow.lite.schema.BuiltinOptions;

/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
/* loaded from: classes3.dex */
public final class zzdp extends zzdr {
    private final String zza;

    zzdp(String str) {
        this.zza = str;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        int length;
        int length2;
        zzdr zzdrVar = (zzdr) obj;
        if (zzd(BuiltinOptions.NonMaxSuppressionV5Options) != zzdrVar.zza()) {
            length2 = zzdrVar.zza();
            length = zzd(BuiltinOptions.NonMaxSuppressionV5Options);
        } else {
            String str = this.zza;
            int length3 = str.length();
            String str2 = ((zzdp) zzdrVar).zza;
            if (length3 == str2.length()) {
                return str.compareTo(str2);
            }
            length = str.length();
            length2 = str2.length();
        }
        return length - length2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.zza.equals(((zzdp) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(zzd(BuiltinOptions.NonMaxSuppressionV5Options)), this.zza});
    }

    public final String toString() {
        return "\"" + this.zza + "\"";
    }

    @Override // com.google.android.gms.internal.fido.zzdr
    protected final int zza() {
        return zzd(BuiltinOptions.NonMaxSuppressionV5Options);
    }
}
