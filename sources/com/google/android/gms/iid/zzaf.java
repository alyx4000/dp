package com.google.android.gms.iid;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Tasks;
import com.iterable.iterableapi.IterableConstants;
import io.sentry.protocol.App;
import java.io.IOException;
import java.security.KeyPair;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class zzaf {
    private PendingIntent zzaf;
    private Messenger zzaj;
    private Map<String, Object> zzcz = new ArrayMap();
    private Messenger zzda;
    private MessengerCompat zzdb;
    private Context zzl;
    private static final zzaj<Boolean> zzct = zzai.zzy().zzd("gcm_iid_use_messenger_ipc", true);
    private static String zzcu = null;
    private static boolean zzcv = false;
    private static int zzcw = 0;
    private static int zzcx = 0;
    private static int zzcp = 0;
    private static BroadcastReceiver zzcy = null;

    public zzaf(Context context) {
        this.zzl = context;
    }

    public static boolean zzk(Context context) {
        if (zzcu != null) {
            zzl(context);
        }
        return zzcv;
    }

    public static String zzl(Context context) {
        boolean z;
        String str = zzcu;
        if (str != null) {
            return str;
        }
        zzcw = Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        boolean z2 = true;
        if (!PlatformVersion.isAtLeastO()) {
            Iterator<ResolveInfo> it = packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0).iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                if (zzd(packageManager, it.next().serviceInfo.packageName, "com.google.android.c2dm.intent.REGISTER")) {
                    zzcv = false;
                    z = true;
                    break;
                }
            }
            if (z) {
                return zzcu;
            }
        }
        Iterator<ResolveInfo> it2 = packageManager.queryBroadcastReceivers(new Intent("com.google.iid.TOKEN_REQUEST"), 0).iterator();
        while (true) {
            if (!it2.hasNext()) {
                z2 = false;
                break;
            }
            if (zzd(packageManager, it2.next().activityInfo.packageName, "com.google.iid.TOKEN_REQUEST")) {
                zzcv = true;
                break;
            }
        }
        if (z2) {
            return zzcu;
        }
        Log.w("InstanceID", "Failed to resolve IID implementation package, falling back");
        if (zzd(packageManager, "com.google.android.gms")) {
            zzcv = PlatformVersion.isAtLeastO();
            return zzcu;
        }
        if (!PlatformVersion.isAtLeastLollipop() && zzd(packageManager, "com.google.android.gsf")) {
            zzcv = false;
            return zzcu;
        }
        Log.w("InstanceID", "Google Play services is missing, unable to get tokens");
        return null;
    }

    private static boolean zzd(PackageManager packageManager, String str, String str2) {
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", str) == 0) {
            return zzd(packageManager, str);
        }
        Log.w("InstanceID", new StringBuilder(String.valueOf(str).length() + 56 + String.valueOf(str2).length()).append("Possible malicious package ").append(str).append(" declares ").append(str2).append(" without permission").toString());
        return false;
    }

    private static boolean zzd(PackageManager packageManager, String str) {
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 0);
            zzcu = applicationInfo.packageName;
            zzcx = applicationInfo.uid;
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    private static int zzm(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(zzl(context), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return -1;
        }
    }

    public final void zze(Message message) {
        if (message == null) {
            return;
        }
        if (message.obj instanceof Intent) {
            Intent intent = (Intent) message.obj;
            intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
            if (intent.hasExtra("google.messenger")) {
                Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                if (parcelableExtra instanceof MessengerCompat) {
                    this.zzdb = (MessengerCompat) parcelableExtra;
                }
                if (parcelableExtra instanceof Messenger) {
                    this.zzda = (Messenger) parcelableExtra;
                }
            }
            zzh((Intent) message.obj);
            return;
        }
        Log.w("InstanceID", "Dropping invalid message");
    }

    private final synchronized void zzg(Intent intent) {
        if (this.zzaf == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.zzaf = PendingIntent.getBroadcast(this.zzl, 0, intent2, 0);
        }
        intent.putExtra(App.TYPE, this.zzaf);
    }

    static String zzi(Bundle bundle) throws IOException {
        if (bundle == null) {
            throw new IOException(InstanceID.ERROR_SERVICE_NOT_AVAILABLE);
        }
        String string = bundle.getString("registration_id");
        if (string == null) {
            string = bundle.getString("unregistered");
        }
        if (string != null) {
            return string;
        }
        String string2 = bundle.getString("error");
        if (string2 != null) {
            throw new IOException(string2);
        }
        String valueOf = String.valueOf(bundle);
        Log.w("InstanceID", new StringBuilder(String.valueOf(valueOf).length() + 29).append("Unexpected response from GCM ").append(valueOf).toString(), new Throwable());
        throw new IOException(InstanceID.ERROR_SERVICE_NOT_AVAILABLE);
    }

    private final void zzd(String str, Object obj) {
        synchronized (getClass()) {
            Object obj2 = this.zzcz.get(str);
            this.zzcz.put(str, obj);
            zzd(obj2, obj);
        }
    }

    private static void zzd(Object obj, Object obj2) {
        if (obj instanceof ConditionVariable) {
            ((ConditionVariable) obj).open();
        }
        if (obj instanceof Messenger) {
            Messenger messenger = (Messenger) obj;
            Message obtain = Message.obtain();
            obtain.obj = obj2;
            try {
                messenger.send(obtain);
            } catch (RemoteException e) {
                String valueOf = String.valueOf(e);
                Log.w("InstanceID", new StringBuilder(String.valueOf(valueOf).length() + 24).append("Failed to send response ").append(valueOf).toString());
            }
        }
    }

    public final void zzh(Intent intent) {
        String str;
        if (intent == null) {
            if (Log.isLoggable("InstanceID", 3)) {
                Log.d("InstanceID", "Unexpected response: null");
                return;
            }
            return;
        }
        String action = intent.getAction();
        if (!"com.google.android.c2dm.intent.REGISTRATION".equals(action) && !IterableConstants.INSTANCE_ID_CLASS.equals(action)) {
            if (Log.isLoggable("InstanceID", 3)) {
                String valueOf = String.valueOf(intent.getAction());
                Log.d("InstanceID", valueOf.length() != 0 ? "Unexpected response ".concat(valueOf) : new String("Unexpected response "));
                return;
            }
            return;
        }
        String stringExtra = intent.getStringExtra("registration_id");
        if (stringExtra == null) {
            stringExtra = intent.getStringExtra("unregistered");
        }
        if (stringExtra == null) {
            String stringExtra2 = intent.getStringExtra("error");
            if (stringExtra2 == null) {
                String valueOf2 = String.valueOf(intent.getExtras());
                Log.w("InstanceID", new StringBuilder(String.valueOf(valueOf2).length() + 49).append("Unexpected response, no error or registration id ").append(valueOf2).toString());
                return;
            }
            if (Log.isLoggable("InstanceID", 3)) {
                String valueOf3 = String.valueOf(stringExtra2);
                Log.d("InstanceID", valueOf3.length() != 0 ? "Received InstanceID error ".concat(valueOf3) : new String("Received InstanceID error "));
            }
            String str2 = null;
            if (stringExtra2.startsWith("|")) {
                String[] split = stringExtra2.split("\\|");
                if (!"ID".equals(split[1])) {
                    String valueOf4 = String.valueOf(stringExtra2);
                    Log.w("InstanceID", valueOf4.length() != 0 ? "Unexpected structured response ".concat(valueOf4) : new String("Unexpected structured response "));
                }
                if (split.length > 2) {
                    String str3 = split[2];
                    str = split[3];
                    if (str.startsWith(":")) {
                        str = str.substring(1);
                    }
                    str2 = str3;
                } else {
                    str = "UNKNOWN";
                }
                stringExtra2 = str;
                intent.putExtra("error", stringExtra2);
            }
            if (str2 == null) {
                synchronized (getClass()) {
                    for (String str4 : this.zzcz.keySet()) {
                        Object obj = this.zzcz.get(str4);
                        this.zzcz.put(str4, stringExtra2);
                        zzd(obj, stringExtra2);
                    }
                }
                return;
            }
            zzd(str2, (Object) stringExtra2);
            return;
        }
        Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
        if (!matcher.matches()) {
            if (Log.isLoggable("InstanceID", 3)) {
                String valueOf5 = String.valueOf(stringExtra);
                Log.d("InstanceID", valueOf5.length() != 0 ? "Unexpected response string: ".concat(valueOf5) : new String("Unexpected response string: "));
                return;
            }
            return;
        }
        String group = matcher.group(1);
        String group2 = matcher.group(2);
        Bundle extras = intent.getExtras();
        extras.putString("registration_id", group2);
        zzd(group, (Object) extras);
    }

    final Bundle zzd(Bundle bundle, KeyPair keyPair) throws IOException {
        int zzm = zzm(this.zzl);
        bundle.putString("gmsv", Integer.toString(zzm));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", Integer.toString(InstanceID.zzg(this.zzl)));
        bundle.putString("app_ver_name", InstanceID.zzh(this.zzl));
        bundle.putString("cliv", "iid-12451000");
        bundle.putString("appid", InstanceID.zzd(keyPair));
        if (zzm >= 12000000 && zzct.get().booleanValue()) {
            try {
                return (Bundle) Tasks.await(new zzr(this.zzl).zzd(1, bundle));
            } catch (InterruptedException | ExecutionException e) {
                if (Log.isLoggable("InstanceID", 3)) {
                    String valueOf = String.valueOf(e);
                    Log.d("InstanceID", new StringBuilder(String.valueOf(valueOf).length() + 22).append("Error making request: ").append(valueOf).toString());
                }
                if ((e.getCause() instanceof zzaa) && ((zzaa) e.getCause()).getErrorCode() == 4) {
                    return zzj(bundle);
                }
                return null;
            }
        }
        return zzj(bundle);
    }

    private final Bundle zzj(Bundle bundle) throws IOException {
        Bundle zzk = zzk(bundle);
        if (zzk == null || !zzk.containsKey("google.messenger")) {
            return zzk;
        }
        Bundle zzk2 = zzk(bundle);
        if (zzk2 == null || !zzk2.containsKey("google.messenger")) {
            return zzk2;
        }
        return null;
    }

    private static synchronized String zzx() {
        String num;
        synchronized (zzaf.class) {
            int i = zzcp;
            zzcp = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0193 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final android.os.Bundle zzk(android.os.Bundle r9) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 489
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.iid.zzaf.zzk(android.os.Bundle):android.os.Bundle");
    }
}
