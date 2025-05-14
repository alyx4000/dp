package com.socure.idplus.device.internal.utils;

import com.scottyab.rootbeer.Const;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* loaded from: classes5.dex */
public abstract class b {
    public static boolean a() {
        boolean z = false;
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(new String[]{"/system/xbin/which", Const.BINARY_SU});
            if (new BufferedReader(new InputStreamReader(process.getInputStream())).readLine() != null) {
                z = true;
            }
        } catch (Throwable th) {
            try {
                com.socure.idplus.device.internal.common.utils.a.a("DeviceUtils", "could not fetch process " + th);
            } finally {
                if (process != null) {
                    process.destroy();
                }
            }
        }
        return z;
    }
}
