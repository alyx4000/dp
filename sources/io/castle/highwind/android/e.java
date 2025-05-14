package io.castle.highwind.android;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.autofill.HintConstants;
import com.scottyab.rootbeer.RootBeer;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;

/* loaded from: classes2.dex */
public final class e extends u {

    /* renamed from: a, reason: collision with root package name */
    public final Context f768a;
    public String g;
    public final Pattern b = Pattern.compile("MemTotal:\\s+(\\d+) kB", 8);
    public final Pattern c = Pattern.compile("MemAvailable:\\s+(\\d+) kB", 8);
    public final Pattern d = Pattern.compile("processor\\s+:\\s+(\\d+)", 8);
    public final Pattern e = Pattern.compile("cpu family\\s+:\\s+(\\d+)", 8);
    public final int f = a();
    public final String h = Build.MANUFACTURER;
    public final String i = Build.MODEL;
    public final boolean j = a.f769a.a();

    public e(Context context) {
        this.f768a = context;
    }

    public final int a() {
        String group;
        Matcher matcher = this.e.matcher(a("/proc/cpuinfo"));
        if (!matcher.find() || (group = matcher.group(1)) == null) {
            return 0;
        }
        return Integer.parseInt(group);
    }

    public final String b() {
        if (this.g == null) {
            Integer[] numArr = new Integer[10];
            numArr[0] = Integer.valueOf(this.j ? 1 : 0);
            numArr[1] = Integer.valueOf(this.f768a.getPackageManager().hasSystemFeature("android.hardware.wifi") ? 1 : 0);
            TelephonyManager telephonyManager = (TelephonyManager) this.f768a.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
            numArr[2] = Integer.valueOf((telephonyManager.getPhoneType() == 1 || telephonyManager.getPhoneType() == 2) ? 1 : 0);
            RootBeer rootBeer = new RootBeer(this.f768a);
            rootBeer.setLogging(false);
            numArr[3] = Integer.valueOf(rootBeer.isRooted() ? 1 : 0);
            numArr[4] = Integer.valueOf(this.f768a.getPackageManager().hasSystemFeature("android.hardware.location.gps") ? 1 : 0);
            numArr[5] = Integer.valueOf(this.f768a.getPackageManager().hasSystemFeature("android.hardware.sensor.light") ? 1 : 0);
            numArr[6] = Integer.valueOf(this.f768a.getPackageManager().hasSystemFeature("android.hardware.sensor.compass") ? 1 : 0);
            numArr[7] = Integer.valueOf(this.f768a.getPackageManager().hasSystemFeature("android.hardware.sensor.accelerometer") ? 1 : 0);
            numArr[8] = Integer.valueOf(((SensorManager) this.f768a.getSystemService("sensor")).getDefaultSensor(2) != null ? 1 : 0);
            numArr[9] = Integer.valueOf(this.f768a.getPackageManager().hasSystemFeature("android.hardware.fingerprint") ? 1 : 0);
            Integer[] numArr2 = (Integer[]) ArraysKt.reversedArray(numArr);
            this.g = w.a(numArr2.length) + w.a(Integer.parseInt(ArraysKt.joinToString$default(numArr2, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), CharsKt.checkRadix(2)), (int) Math.ceil(numArr2.length / 8.0d));
        }
        String str = this.g;
        if (str == null) {
            return null;
        }
        return str;
    }

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0073a f769a = new C0073a();
        public static final String[] b = {"/dev/socket/genyd", "/dev/socket/baseband_genyd"};
        public static final String[] c = {"/dev/socket/qemud", "/dev/qemu_pipe"};
        public static final String[] d = {"ueventd.android_x86.rc", "x86.prop", "ueventd.ttVM_x86.rc", "init.ttVM_x86.rc", "fstab.ttVM_x86", "fstab.vbox86", "init.vbox86.rc", "ueventd.vbox86.rc"};
        public static final String[] e = {"fstab.andy", "ueventd.andy.rc"};
        public static final String[] f = {"fstab.nox", "init.nox.rc", "ueventd.nox.rc"};

        /* renamed from: io.castle.highwind.android.e$a$a, reason: collision with other inner class name */
        public static final class C0073a {
            public final boolean a(String[] strArr) {
                for (String str : strArr) {
                    if (new File(str).exists()) {
                        return true;
                    }
                }
                return false;
            }

            /* JADX WARN: Removed duplicated region for block: B:39:0x00b2  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final boolean a() {
                /*
                    r10 = this;
                    java.lang.String r0 = android.os.Build.MANUFACTURER
                    java.lang.String r1 = "Genymotion"
                    r2 = 0
                    r3 = 2
                    r4 = 0
                    boolean r0 = kotlin.text.StringsKt.contains$default(r0, r1, r2, r3, r4)
                    r1 = 1
                    if (r0 != 0) goto Laf
                    java.lang.String r0 = android.os.Build.MODEL
                    java.lang.String r5 = "google_sdk"
                    boolean r6 = kotlin.text.StringsKt.contains$default(r0, r5, r2, r3, r4)
                    if (r6 != 0) goto Laf
                    java.lang.String r6 = "sdk_gphone"
                    boolean r6 = kotlin.text.StringsKt.startsWith$default(r0, r6, r2, r3, r4)
                    if (r6 != 0) goto Laf
                    java.util.Locale r6 = java.util.Locale.ROOT
                    java.lang.String r7 = r0.toLowerCase(r6)
                    java.lang.String r8 = "droid4x"
                    boolean r7 = kotlin.text.StringsKt.contains$default(r7, r8, r2, r3, r4)
                    if (r7 != 0) goto Laf
                    java.lang.String r7 = "Emulator"
                    boolean r7 = kotlin.text.StringsKt.contains$default(r0, r7, r2, r3, r4)
                    if (r7 != 0) goto Laf
                    java.lang.String r7 = "Android SDK built for x86"
                    boolean r0 = kotlin.text.StringsKt.contains$default(r0, r7, r2, r3, r4)
                    if (r0 != 0) goto Laf
                    java.lang.String r0 = android.os.Build.HARDWARE
                    java.lang.String r7 = "goldfish"
                    boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r7)
                    if (r7 != 0) goto Laf
                    java.lang.String r7 = "vbox86"
                    boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r7)
                    if (r7 != 0) goto Laf
                    java.lang.String r0 = r0.toLowerCase(r6)
                    java.lang.String r7 = "nox"
                    boolean r0 = kotlin.text.StringsKt.contains$default(r0, r7, r2, r3, r4)
                    if (r0 != 0) goto Laf
                    java.lang.String r0 = android.os.Build.FINGERPRINT
                    java.lang.String r8 = "generic"
                    boolean r0 = kotlin.text.StringsKt.startsWith$default(r0, r8, r2, r3, r4)
                    if (r0 != 0) goto Laf
                    java.lang.String r0 = android.os.Build.PRODUCT
                    java.lang.String r9 = "sdk"
                    boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r9)
                    if (r9 != 0) goto Laf
                    boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r5)
                    if (r5 != 0) goto Laf
                    java.lang.String r5 = "sdk_x86"
                    boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r5)
                    if (r5 != 0) goto Laf
                    java.lang.String r5 = "vbox86p"
                    boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r5)
                    if (r5 != 0) goto Laf
                    java.lang.String r0 = r0.toLowerCase(r6)
                    boolean r0 = kotlin.text.StringsKt.contains$default(r0, r7, r2, r3, r4)
                    if (r0 != 0) goto Laf
                    java.lang.String r0 = android.os.Build.BOARD
                    java.lang.String r0 = r0.toLowerCase(r6)
                    boolean r0 = kotlin.text.StringsKt.contains$default(r0, r7, r2, r3, r4)
                    if (r0 != 0) goto Laf
                    java.lang.String r0 = android.os.Build.BRAND
                    boolean r0 = kotlin.text.StringsKt.startsWith$default(r0, r8, r2, r3, r4)
                    if (r0 == 0) goto Lad
                    java.lang.String r0 = android.os.Build.DEVICE
                    boolean r0 = kotlin.text.StringsKt.startsWith$default(r0, r8, r2, r3, r4)
                    if (r0 == 0) goto Lad
                    goto Laf
                Lad:
                    r0 = r2
                    goto Lb0
                Laf:
                    r0 = r1
                Lb0:
                    if (r0 != 0) goto Le0
                    java.lang.String[] r0 = io.castle.highwind.android.e.a.b
                    boolean r0 = r10.a(r0)
                    if (r0 != 0) goto Ldd
                    java.lang.String[] r0 = io.castle.highwind.android.e.a.e
                    boolean r0 = r10.a(r0)
                    if (r0 != 0) goto Ldd
                    java.lang.String[] r0 = io.castle.highwind.android.e.a.f
                    boolean r0 = r10.a(r0)
                    if (r0 != 0) goto Ldd
                    java.lang.String[] r0 = io.castle.highwind.android.e.a.d
                    boolean r0 = r10.a(r0)
                    if (r0 != 0) goto Ldd
                    java.lang.String[] r0 = io.castle.highwind.android.e.a.c
                    boolean r0 = r10.a(r0)
                    if (r0 == 0) goto Ldb
                    goto Ldd
                Ldb:
                    r0 = r2
                    goto Lde
                Ldd:
                    r0 = r1
                Lde:
                    if (r0 == 0) goto Le1
                Le0:
                    r2 = r1
                Le1:
                    return r2
                */
                throw new UnsupportedOperationException("Method not decompiled: io.castle.highwind.android.e.a.C0073a.a():boolean");
            }
        }
    }

    public final String a(String str) {
        String str2 = "";
        try {
            String[] strArr = {"/system/bin/cat", str};
            byte[] bArr = new byte[1024];
            try {
                InputStream inputStream = new ProcessBuilder((String[]) Arrays.copyOf(strArr, 2)).start().getInputStream();
                String str3 = "";
                while (inputStream.read(bArr) != -1) {
                    try {
                        str3 = str3 + new String(bArr, Charsets.UTF_8);
                    } catch (IOException unused) {
                        str2 = str3;
                        return str2;
                    }
                }
                inputStream.close();
                return str3;
            } catch (IOException unused2) {
            }
        } catch (Exception unused3) {
            return "";
        }
    }
}
