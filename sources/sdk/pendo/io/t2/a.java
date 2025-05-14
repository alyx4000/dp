package sdk.pendo.io.t2;

import androidx.exifinterface.media.ExifInterface;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.ArrayList;
import org.apache.commons.lang3.time.DateUtils;
import sdk.pendo.io.o2.g;
import sdk.pendo.io.o2.h;

/* loaded from: classes6.dex */
public class a {

    /* renamed from: sdk.pendo.io.t2.a$a, reason: collision with other inner class name */
    static class C0235a {
        private static final C0235a[] c = new C0235a[0];

        /* renamed from: a, reason: collision with root package name */
        private final Object f1547a;
        private int b = 1;

        C0235a(Object obj) {
            this.f1547a = obj;
        }

        int b() {
            return this.b;
        }

        Object c() {
            return this.f1547a;
        }

        void d() {
            this.b++;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0235a)) {
                return false;
            }
            C0235a c0235a = (C0235a) obj;
            if (this.f1547a.getClass() != c0235a.f1547a.getClass() || this.b != c0235a.b) {
                return false;
            }
            Object obj2 = this.f1547a;
            if (obj2 instanceof StringBuilder) {
                return obj2.toString().equals(c0235a.f1547a.toString());
            }
            boolean z = obj2 instanceof Number;
            Object obj3 = c0235a.f1547a;
            return z ? obj2.equals(obj3) : obj2 == obj3;
        }

        public int hashCode() {
            return this.f1547a.hashCode();
        }

        public String toString() {
            return g.a(this.f1547a.toString(), this.b);
        }

        static boolean a(C0235a[] c0235aArr, Object obj) {
            for (C0235a c0235a : c0235aArr) {
                if (c0235a.c() == obj) {
                    return true;
                }
            }
            return false;
        }
    }

    static String a(C0235a[] c0235aArr, long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z) {
        int i;
        int i2;
        long j8;
        String a2;
        C0235a[] c0235aArr2 = c0235aArr;
        long j9 = j7;
        StringBuilder sb = new StringBuilder();
        int length = c0235aArr2.length;
        int i3 = 0;
        boolean z2 = false;
        while (i3 < length) {
            C0235a c0235a = c0235aArr2[i3];
            Object c = c0235a.c();
            int b = c0235a.b();
            if (c instanceof StringBuilder) {
                sb.append(c.toString());
                j8 = j9;
                i2 = length;
                i = i3;
            } else {
                if (c.equals(ViewHierarchyNode.JsonKeys.Y)) {
                    sb.append(a(j, z, b));
                } else if (c.equals("M")) {
                    sb.append(a(j2, z, b));
                } else {
                    i = i3;
                    if (c.equals("d")) {
                        sb.append(a(j3, z, b));
                        j8 = j9;
                        i2 = length;
                        z2 = false;
                    } else {
                        if (c.equals("H")) {
                            i2 = length;
                            sb.append(a(j4, z, b));
                        } else {
                            i2 = length;
                            if (c.equals("m")) {
                                sb.append(a(j5, z, b));
                            } else {
                                if (c.equals("s")) {
                                    sb.append(a(j6, z, b));
                                    j8 = j7;
                                    z2 = true;
                                } else if (c.equals(ExifInterface.LATITUDE_SOUTH)) {
                                    if (z2) {
                                        j8 = j7;
                                        a2 = a(j8, true, z ? Math.max(3, b) : 3);
                                    } else {
                                        j8 = j7;
                                        a2 = a(j8, z, b);
                                    }
                                    sb.append(a2);
                                    z2 = false;
                                } else {
                                    j8 = j7;
                                }
                                i3 = i + 1;
                                j9 = j8;
                                length = i2;
                                c0235aArr2 = c0235aArr;
                            }
                        }
                        j8 = j9;
                        z2 = false;
                        i3 = i + 1;
                        j9 = j8;
                        length = i2;
                        c0235aArr2 = c0235aArr;
                    }
                }
                j8 = j9;
                i2 = length;
                i = i3;
                z2 = false;
            }
            i3 = i + 1;
            j9 = j8;
            length = i2;
            c0235aArr2 = c0235aArr;
        }
        return sb.toString();
    }

    public static String a(long j, String str) {
        return a(j, str, true);
    }

    public static String a(long j, String str, boolean z) {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        h.a(0L, Long.MAX_VALUE, j, "durationMillis must not be negative");
        C0235a[] a2 = a(str);
        if (C0235a.a(a2, "d")) {
            long j8 = j / DateUtils.MILLIS_PER_DAY;
            j2 = j - (DateUtils.MILLIS_PER_DAY * j8);
            j3 = j8;
        } else {
            j2 = j;
            j3 = 0;
        }
        if (C0235a.a(a2, "H")) {
            long j9 = j2 / DateUtils.MILLIS_PER_HOUR;
            j2 -= DateUtils.MILLIS_PER_HOUR * j9;
            j4 = j9;
        } else {
            j4 = 0;
        }
        if (C0235a.a(a2, "m")) {
            long j10 = j2 / DateUtils.MILLIS_PER_MINUTE;
            j2 -= DateUtils.MILLIS_PER_MINUTE * j10;
            j5 = j10;
        } else {
            j5 = 0;
        }
        if (C0235a.a(a2, "s")) {
            long j11 = j2 / 1000;
            j7 = j2 - (1000 * j11);
            j6 = j11;
        } else {
            j6 = 0;
            j7 = j2;
        }
        return a(a2, 0L, 0L, j3, j4, j5, j6, j7, z);
    }

    public static String a(long j) {
        return a(j, "HH:mm:ss.SSS");
    }

    static C0235a[] a(String str) {
        String str2;
        ArrayList arrayList = new ArrayList(str.length());
        boolean z = false;
        StringBuilder sb = null;
        C0235a c0235a = null;
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (!z || charAt == '\'') {
                if (charAt != '\'') {
                    if (charAt == 'H') {
                        str2 = "H";
                    } else if (charAt == 'M') {
                        str2 = "M";
                    } else if (charAt == 'S') {
                        str2 = ExifInterface.LATITUDE_SOUTH;
                    } else if (charAt == 'd') {
                        str2 = "d";
                    } else if (charAt == 'm') {
                        str2 = "m";
                    } else if (charAt == 's') {
                        str2 = "s";
                    } else if (charAt != 'y') {
                        if (sb == null) {
                            sb = new StringBuilder();
                            arrayList.add(new C0235a(sb));
                        }
                        sb.append(charAt);
                        str2 = null;
                    } else {
                        str2 = ViewHierarchyNode.JsonKeys.Y;
                    }
                } else if (z) {
                    z = false;
                    sb = null;
                    str2 = null;
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    arrayList.add(new C0235a(sb2));
                    str2 = null;
                    sb = sb2;
                    z = true;
                }
                if (str2 != null) {
                    if (c0235a == null || !c0235a.c().equals(str2)) {
                        C0235a c0235a2 = new C0235a(str2);
                        arrayList.add(c0235a2);
                        c0235a = c0235a2;
                    } else {
                        c0235a.d();
                    }
                    sb = null;
                }
            } else {
                sb.append(charAt);
            }
        }
        if (z) {
            throw new IllegalArgumentException("Unmatched quote in format: " + str);
        }
        return (C0235a[]) arrayList.toArray(C0235a.c);
    }

    private static String a(long j, boolean z, int i) {
        String l = Long.toString(j);
        return z ? g.a(l, i, '0') : l;
    }
}
