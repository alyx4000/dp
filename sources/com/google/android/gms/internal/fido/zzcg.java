package com.google.android.gms.internal.fido;

import java.io.IOException;
import java.math.RoundingMode;
import javax.annotation.CheckForNull;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
/* loaded from: classes3.dex */
class zzcg extends zzch {

    @CheckForNull
    private volatile zzch zza;
    final zzcd zzb;

    @CheckForNull
    final Character zzc;

    zzcg(zzcd zzcdVar, @CheckForNull Character ch) {
        this.zzb = zzcdVar;
        boolean z = true;
        if (ch != null) {
            ch.charValue();
            if (zzcdVar.zzc('=')) {
                z = false;
            }
        }
        if (!z) {
            throw new IllegalArgumentException(zzaq.zza("Padding character %s was already in alphabet", ch));
        }
        this.zzc = ch;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzcg) {
            zzcg zzcgVar = (zzcg) obj;
            if (this.zzb.equals(zzcgVar.zzb)) {
                Character ch = this.zzc;
                Character ch2 = zzcgVar.zzc;
                if (ch == ch2) {
                    return true;
                }
                if (ch != null && ch.equals(ch2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.zzb.hashCode();
        Character ch = this.zzc;
        return hashCode ^ (ch == null ? 0 : ch.hashCode());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        sb.append(this.zzb);
        if (8 % this.zzb.zzb != 0) {
            if (this.zzc == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(this.zzc);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    zzch zza(zzcd zzcdVar, @CheckForNull Character ch) {
        return new zzcg(zzcdVar, ch);
    }

    @Override // com.google.android.gms.internal.fido.zzch
    void zzb(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        zzap.zze(0, i2, bArr.length);
        while (i3 < i2) {
            zze(appendable, bArr, i3, Math.min(this.zzb.zzd, i2 - i3));
            i3 += this.zzb.zzd;
        }
    }

    @Override // com.google.android.gms.internal.fido.zzch
    final int zzc(int i) {
        zzcd zzcdVar = this.zzb;
        return zzcdVar.zzc * zzcj.zza(i, zzcdVar.zzd, RoundingMode.CEILING);
    }

    @Override // com.google.android.gms.internal.fido.zzch
    public final zzch zzd() {
        zzch zzchVar = this.zza;
        if (zzchVar == null) {
            zzcd zzb = this.zzb.zzb();
            zzchVar = zzb == this.zzb ? this : zza(zzb, this.zzc);
            this.zza = zzchVar;
        }
        return zzchVar;
    }

    final void zze(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        zzap.zze(i, i + i2, bArr.length);
        int i3 = 0;
        zzap.zzc(i2 <= this.zzb.zzd);
        long j = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            j = (j | (bArr[i + i4] & UByte.MAX_VALUE)) << 8;
        }
        int i5 = ((i2 + 1) * 8) - this.zzb.zzb;
        while (i3 < i2 * 8) {
            zzcd zzcdVar = this.zzb;
            appendable.append(zzcdVar.zza(zzcdVar.zza & ((int) (j >>> (i5 - i3)))));
            i3 += this.zzb.zzb;
        }
        if (this.zzc != null) {
            while (i3 < this.zzb.zzd * 8) {
                this.zzc.charValue();
                appendable.append('=');
                i3 += this.zzb.zzb;
            }
        }
    }

    zzcg(String str, String str2, @CheckForNull Character ch) {
        this(new zzcd(str, str2.toCharArray()), ch);
    }
}
