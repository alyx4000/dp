package com.google.android.gms.internal.fido;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-fido@@20.1.0 */
/* loaded from: classes3.dex */
public interface zzg extends IInterface {
    void zzb(List list) throws RemoteException;

    void zzc(Status status) throws RemoteException;
}
