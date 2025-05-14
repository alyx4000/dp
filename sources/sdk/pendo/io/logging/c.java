package sdk.pendo.io.logging;

import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import javax.interceptor.Interceptor;
import javax.net.ssl.SSLPeerUnverifiedException;
import sdk.pendo.io.c8.d;
import sdk.pendo.io.g9.d;
import sdk.pendo.io.logging.PendoLogger;

/* loaded from: classes6.dex */
public class c extends PendoLogger.x {
    private void g(String str, Object... objArr) {
        if (sdk.pendo.io.p8.a.d().f()) {
            d.a(d.b.ERROR_REASON_CONFIGURATION, str, objArr);
        }
    }

    @Override // sdk.pendo.io.logging.PendoLogger.x
    public void a(String str, Object... objArr) {
        sdk.pendo.io.o8.b.b().a(str, "D");
    }

    @Override // sdk.pendo.io.logging.PendoLogger.x
    public void b(String str, Object... objArr) {
        super.b(null, str, objArr);
        g(str, objArr);
        sdk.pendo.io.o8.b.b().a(str, ExifInterface.LONGITUDE_EAST);
    }

    @Override // sdk.pendo.io.logging.PendoLogger.x
    public void c(String str, Object... objArr) {
        sdk.pendo.io.o8.b.b().a(str, "I");
    }

    @Override // sdk.pendo.io.logging.PendoLogger.x
    public void d(String str, Object... objArr) {
        sdk.pendo.io.o8.b.b().a(str, ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
    }

    @Override // sdk.pendo.io.logging.PendoLogger.x
    public void e(String str, Object... objArr) {
        super.e(null, str, objArr);
        sdk.pendo.io.o8.b.b().a(str, ExifInterface.LONGITUDE_WEST);
    }

    private void g(Throwable th, String str, Object... objArr) {
        if (th instanceof SSLPeerUnverifiedException) {
            PendoLogger.d("Cannot send SSLPeerUnverifiedException to server yet.", new Object[0]);
        } else if (sdk.pendo.io.p8.a.d().f()) {
            sdk.pendo.io.g9.d.a(th, (objArr == null || objArr.length <= 0) ? null : objArr[0].toString(), str);
        }
    }

    @Override // sdk.pendo.io.logging.PendoLogger.x
    public void a(Throwable th, String str, Object... objArr) {
        sdk.pendo.io.o8.b.b().a(str, "D", th.toString());
    }

    @Override // sdk.pendo.io.logging.PendoLogger.x
    public void b(Throwable th) {
        super.b(th);
        g(th, th.getMessage(), new Object[0]);
        sdk.pendo.io.o8.b.b().a(th.getMessage(), ExifInterface.LONGITUDE_EAST, th.toString());
    }

    @Override // sdk.pendo.io.logging.PendoLogger.x
    public void c(Throwable th, String str, Object... objArr) {
        sdk.pendo.io.o8.b.b().a(str, "I", th.toString());
    }

    @Override // sdk.pendo.io.logging.PendoLogger.x
    public void d(Throwable th, String str, Object... objArr) {
        sdk.pendo.io.o8.b.b().a(str, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, th.toString());
    }

    @Override // sdk.pendo.io.logging.PendoLogger.x
    public void e(Throwable th, String str, Object... objArr) {
        super.e(th, str, objArr);
        sdk.pendo.io.o8.b.b().a(str, ExifInterface.LONGITUDE_WEST, th.toString());
    }

    @Override // sdk.pendo.io.logging.PendoLogger.x
    protected final void a(int i, String str, String str2, Throwable th) {
        int min;
        if (str2.length() < 4000) {
            if (i == 7) {
                Log.wtf("Pendo", str2);
                return;
            } else {
                Log.println(i, "Pendo", str2);
                return;
            }
        }
        int length = str2.length();
        int i2 = 0;
        while (i2 < length) {
            int indexOf = str2.indexOf(10, i2);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i2 + Interceptor.Priority.PLATFORM_AFTER);
                String substring = str2.substring(i2, min);
                if (i == 7) {
                    Log.wtf("Pendo", substring);
                } else {
                    Log.println(i, "Pendo", substring);
                }
                if (min >= indexOf) {
                    break;
                } else {
                    i2 = min;
                }
            }
            i2 = min + 1;
        }
    }

    @Override // sdk.pendo.io.logging.PendoLogger.x
    public void b(Throwable th, String str, Object... objArr) {
        super.b(th, str, objArr);
        g(th, str, objArr);
        sdk.pendo.io.o8.b.b().a(str, ExifInterface.LONGITUDE_EAST, th.toString());
    }
}
