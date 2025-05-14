package external.sdk.pendo.io.mozilla.javascript;

import com.extole.android.sdk.impl.http.HttpRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* loaded from: classes2.dex */
final class NativeDate extends IdScriptableObject {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ConstructorId_UTC = -1;
    private static final int ConstructorId_now = -3;
    private static final int ConstructorId_parse = -2;
    private static final double HalfTimeDomain = 8.64E15d;
    private static final double HoursPerDay = 24.0d;
    private static final int Id_constructor = 1;
    private static final int Id_getDate = 17;
    private static final int Id_getDay = 19;
    private static final int Id_getFullYear = 13;
    private static final int Id_getHours = 21;
    private static final int Id_getMilliseconds = 27;
    private static final int Id_getMinutes = 23;
    private static final int Id_getMonth = 15;
    private static final int Id_getSeconds = 25;
    private static final int Id_getTime = 11;
    private static final int Id_getTimezoneOffset = 29;
    private static final int Id_getUTCDate = 18;
    private static final int Id_getUTCDay = 20;
    private static final int Id_getUTCFullYear = 14;
    private static final int Id_getUTCHours = 22;
    private static final int Id_getUTCMilliseconds = 28;
    private static final int Id_getUTCMinutes = 24;
    private static final int Id_getUTCMonth = 16;
    private static final int Id_getUTCSeconds = 26;
    private static final int Id_getYear = 12;
    private static final int Id_setDate = 39;
    private static final int Id_setFullYear = 43;
    private static final int Id_setHours = 37;
    private static final int Id_setMilliseconds = 31;
    private static final int Id_setMinutes = 35;
    private static final int Id_setMonth = 41;
    private static final int Id_setSeconds = 33;
    private static final int Id_setTime = 30;
    private static final int Id_setUTCDate = 40;
    private static final int Id_setUTCFullYear = 44;
    private static final int Id_setUTCHours = 38;
    private static final int Id_setUTCMilliseconds = 32;
    private static final int Id_setUTCMinutes = 36;
    private static final int Id_setUTCMonth = 42;
    private static final int Id_setUTCSeconds = 34;
    private static final int Id_setYear = 45;
    private static final int Id_toDateString = 4;
    private static final int Id_toGMTString = 8;
    private static final int Id_toISOString = 46;
    private static final int Id_toJSON = 47;
    private static final int Id_toLocaleDateString = 7;
    private static final int Id_toLocaleString = 5;
    private static final int Id_toLocaleTimeString = 6;
    private static final int Id_toSource = 9;
    private static final int Id_toString = 2;
    private static final int Id_toTimeString = 3;
    private static final int Id_toUTCString = 8;
    private static final int Id_valueOf = 10;
    private static final double LocalTZA;
    private static final int MAXARGS = 7;
    private static final int MAX_PROTOTYPE_ID = 47;
    private static final double MinutesPerDay = 1440.0d;
    private static final double MinutesPerHour = 60.0d;
    private static final double SecondsPerDay = 86400.0d;
    private static final double SecondsPerHour = 3600.0d;
    private static final double SecondsPerMinute = 60.0d;
    private static final String js_NaN_date_str = "Invalid Date";
    private static final double msPerDay = 8.64E7d;
    private static final double msPerHour = 3600000.0d;
    private static final double msPerMinute = 60000.0d;
    private static final double msPerSecond = 1000.0d;
    private static final long serialVersionUID = -8307438915861678966L;
    private double date;
    private static final Object DATE_TAG = HttpRequest.HEADER_DATE;
    private static final TimeZone thisTimeZone = TimeZone.getDefault();
    private static final DateFormat timeZoneFormatter = new SimpleDateFormat("zzz");
    private static final DateFormat localeDateTimeFormatter = new SimpleDateFormat("MMMM d, yyyy h:mm:ss a z");
    private static final DateFormat localeDateFormatter = new SimpleDateFormat("MMMM d, yyyy");
    private static final DateFormat localeTimeFormatter = new SimpleDateFormat("h:mm:ss a z");

    static {
        LocalTZA = r0.getRawOffset();
    }

    private NativeDate() {
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int DateFromTime(double r3) {
        /*
            int r0 = YearFromTime(r3)
            double r3 = Day(r3)
            double r1 = (double) r0
            double r1 = DayFromYear(r1)
            double r3 = r3 - r1
            int r3 = (int) r3
            int r3 = r3 + (-59)
            r4 = 31
            if (r3 >= 0) goto L1f
            r0 = -28
            if (r3 >= r0) goto L1a
            int r3 = r3 + r4
        L1a:
            int r3 = r3 + 28
            int r3 = r3 + 1
            return r3
        L1f:
            boolean r0 = IsLeapYear(r0)
            if (r0 == 0) goto L2c
            if (r3 != 0) goto L2a
            r3 = 29
            return r3
        L2a:
            int r3 = r3 + (-1)
        L2c:
            int r0 = r3 / 30
            r1 = 275(0x113, float:3.85E-43)
            r2 = 30
            switch(r0) {
                case 0: goto L5f;
                case 1: goto L57;
                case 2: goto L54;
                case 3: goto L4f;
                case 4: goto L4c;
                case 5: goto L49;
                case 6: goto L46;
                case 7: goto L43;
                case 8: goto L40;
                case 9: goto L3e;
                case 10: goto L3a;
                default: goto L35;
            }
        L35:
            java.lang.RuntimeException r3 = external.sdk.pendo.io.mozilla.javascript.Kit.codeBug()
            throw r3
        L3a:
            int r3 = r3 - r1
            int r3 = r3 + 1
            return r3
        L3e:
            r4 = r1
            goto L58
        L40:
            r0 = 245(0xf5, float:3.43E-43)
            goto L51
        L43:
            r4 = 214(0xd6, float:3.0E-43)
            goto L58
        L46:
            r0 = 184(0xb8, float:2.58E-43)
            goto L51
        L49:
            r0 = 153(0x99, float:2.14E-43)
            goto L51
        L4c:
            r4 = 122(0x7a, float:1.71E-43)
            goto L58
        L4f:
            r0 = 92
        L51:
            r2 = r4
            r4 = r0
            goto L58
        L54:
            r4 = 61
            goto L58
        L57:
            r2 = r4
        L58:
            int r3 = r3 - r4
            if (r3 >= 0) goto L5c
            int r3 = r3 + r2
        L5c:
            int r3 = r3 + 1
            return r3
        L5f:
            int r3 = r3 + 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.NativeDate.DateFromTime(double):int");
    }

    private static double Day(double d) {
        return Math.floor(d / msPerDay);
    }

    private static double DayFromMonth(int i, int i2) {
        int i3;
        int i4;
        int i5 = i * 30;
        if (i >= 7) {
            i4 = i / 2;
        } else {
            if (i < 2) {
                i3 = i5 + i;
                if (i >= 2 && IsLeapYear(i2)) {
                    i3++;
                }
                return i3;
            }
            i4 = (i - 1) / 2;
        }
        i3 = i5 + (i4 - 1);
        if (i >= 2) {
            i3++;
        }
        return i3;
    }

    private static double DayFromYear(double d) {
        return ((((d - 1970.0d) * 365.0d) + Math.floor((d - 1969.0d) / 4.0d)) - Math.floor((d - 1901.0d) / 100.0d)) + Math.floor((d - 1601.0d) / 400.0d);
    }

    private static double DaylightSavingTA(double d) {
        if (d < 0.0d) {
            d = MakeDate(MakeDay(EquivalentYear(YearFromTime(d)), MonthFromTime(d), DateFromTime(d)), TimeWithinDay(d));
        }
        if (thisTimeZone.inDaylightTime(new Date((long) d))) {
            return msPerHour;
        }
        return 0.0d;
    }

    private static int DaysInMonth(int i, int i2) {
        return i2 == 2 ? IsLeapYear(i) ? 29 : 28 : i2 >= 8 ? 31 - (i2 & 1) : (i2 & 1) + 30;
    }

    private static double DaysInYear(double d) {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            return Double.NaN;
        }
        return IsLeapYear((int) d) ? 366.0d : 365.0d;
    }

    private static int EquivalentYear(int i) {
        int DayFromYear = (((int) DayFromYear(i)) + 4) % 7;
        if (DayFromYear < 0) {
            DayFromYear += 7;
        }
        if (IsLeapYear(i)) {
            switch (DayFromYear) {
                case 0:
                    return 1984;
                case 1:
                    return 1996;
                case 2:
                    return 1980;
                case 3:
                    return 1992;
                case 4:
                    return 1976;
                case 5:
                    return 1988;
                case 6:
                    return 1972;
            }
        }
        switch (DayFromYear) {
            case 0:
                return 1978;
            case 1:
                return 1973;
            case 2:
                return 1985;
            case 3:
                return 1986;
            case 4:
                return 1981;
            case 5:
                return 1971;
            case 6:
                return 1977;
        }
        throw Kit.codeBug();
    }

    private static int HourFromTime(double d) {
        double floor = Math.floor(d / msPerHour) % HoursPerDay;
        if (floor < 0.0d) {
            floor += HoursPerDay;
        }
        return (int) floor;
    }

    private static boolean IsLeapYear(int i) {
        return i % 4 == 0 && (i % 100 != 0 || i % 400 == 0);
    }

    private static double LocalTime(double d) {
        return LocalTZA + d + DaylightSavingTA(d);
    }

    private static double MakeDate(double d, double d2) {
        return (d * msPerDay) + d2;
    }

    private static double MakeDay(double d, double d2, double d3) {
        double floor = d + Math.floor(d2 / 12.0d);
        double d4 = d2 % 12.0d;
        if (d4 < 0.0d) {
            d4 += 12.0d;
        }
        return ((Math.floor(TimeFromYear(floor) / msPerDay) + DayFromMonth((int) d4, (int) floor)) + d3) - 1.0d;
    }

    private static double MakeTime(double d, double d2, double d3, double d4) {
        return (((((d * 60.0d) + d2) * 60.0d) + d3) * msPerSecond) + d4;
    }

    private static int MinFromTime(double d) {
        double floor = Math.floor(d / msPerMinute) % 60.0d;
        if (floor < 0.0d) {
            floor += 60.0d;
        }
        return (int) floor;
    }

    private static int MonthFromTime(double d) {
        int i;
        int YearFromTime = YearFromTime(d);
        int Day = ((int) (Day(d) - DayFromYear(YearFromTime))) - 59;
        if (Day < 0) {
            return Day < -28 ? 0 : 1;
        }
        if (IsLeapYear(YearFromTime)) {
            if (Day == 0) {
                return 1;
            }
            Day--;
        }
        int i2 = Day / 30;
        switch (i2) {
            case 0:
                return 2;
            case 1:
                i = 31;
                break;
            case 2:
                i = 61;
                break;
            case 3:
                i = 92;
                break;
            case 4:
                i = 122;
                break;
            case 5:
                i = 153;
                break;
            case 6:
                i = 184;
                break;
            case 7:
                i = 214;
                break;
            case 8:
                i = 245;
                break;
            case 9:
                i = 275;
                break;
            case 10:
                return 11;
            default:
                throw Kit.codeBug();
        }
        return Day >= i ? i2 + 2 : i2 + 1;
    }

    private static int SecFromTime(double d) {
        double floor = Math.floor(d / msPerSecond) % 60.0d;
        if (floor < 0.0d) {
            floor += 60.0d;
        }
        return (int) floor;
    }

    private static double TimeClip(double d) {
        if (Double.isNaN(d) || d == Double.POSITIVE_INFINITY || d == Double.NEGATIVE_INFINITY || Math.abs(d) > HalfTimeDomain) {
            return Double.NaN;
        }
        double d2 = d + 0.0d;
        return d > 0.0d ? Math.floor(d2) : Math.ceil(d2);
    }

    private static double TimeFromYear(double d) {
        return DayFromYear(d) * msPerDay;
    }

    private static double TimeWithinDay(double d) {
        double d2 = d % msPerDay;
        return d2 < 0.0d ? d2 + msPerDay : d2;
    }

    private static int WeekDay(double d) {
        double Day = (Day(d) + 4.0d) % 7.0d;
        if (Day < 0.0d) {
            Day += 7.0d;
        }
        return (int) Day;
    }

    private static int YearFromTime(double d) {
        if (Double.isInfinite(d) || Double.isNaN(d)) {
            return 0;
        }
        double floor = Math.floor(d / 3.1556952E10d) + 1970.0d;
        double TimeFromYear = TimeFromYear(floor);
        if (TimeFromYear > d) {
            floor -= 1.0d;
        } else if (TimeFromYear + (DaysInYear(floor) * msPerDay) <= d) {
            floor += 1.0d;
        }
        return (int) floor;
    }

    private static void append0PaddedUint(StringBuilder sb, int i, int i2) {
        int i3;
        if (i < 0) {
            Kit.codeBug();
        }
        int i4 = i2 - 1;
        if (i >= 10) {
            i3 = 1000000000;
            if (i < 1000000000) {
                i3 = 1;
                while (true) {
                    int i5 = i3 * 10;
                    if (i < i5) {
                        break;
                    }
                    i4--;
                    i3 = i5;
                }
            } else {
                i4 -= 9;
            }
        } else {
            i3 = 1;
        }
        while (i4 > 0) {
            sb.append('0');
            i4--;
        }
        while (i3 != 1) {
            sb.append((char) ((i / i3) + 48));
            i %= i3;
            i3 /= 10;
        }
        sb.append((char) (i + 48));
    }

    private static void appendMonthName(StringBuilder sb, int i) {
        int i2 = i * 3;
        for (int i3 = 0; i3 != 3; i3++) {
            sb.append("JanFebMarAprMayJunJulAugSepOctNovDec".charAt(i2 + i3));
        }
    }

    private static void appendWeekDayName(StringBuilder sb, int i) {
        int i2 = i * 3;
        for (int i3 = 0; i3 != 3; i3++) {
            sb.append("SunMonTueWedThuFriSat".charAt(i2 + i3));
        }
    }

    private static String date_format(double d, int i) {
        StringBuilder sb = new StringBuilder(60);
        double LocalTime = LocalTime(d);
        if (i != 3) {
            appendWeekDayName(sb, WeekDay(LocalTime));
            sb.append(' ');
            appendMonthName(sb, MonthFromTime(LocalTime));
            sb.append(' ');
            append0PaddedUint(sb, DateFromTime(LocalTime), 2);
            sb.append(' ');
            int YearFromTime = YearFromTime(LocalTime);
            if (YearFromTime < 0) {
                sb.append('-');
                YearFromTime = -YearFromTime;
            }
            append0PaddedUint(sb, YearFromTime, 4);
            if (i != 4) {
                sb.append(' ');
            }
        }
        if (i != 4) {
            append0PaddedUint(sb, HourFromTime(LocalTime), 2);
            sb.append(':');
            append0PaddedUint(sb, MinFromTime(LocalTime), 2);
            sb.append(':');
            append0PaddedUint(sb, SecFromTime(LocalTime), 2);
            int floor = (int) Math.floor((LocalTZA + DaylightSavingTA(d)) / msPerMinute);
            int i2 = ((floor / 60) * 100) + (floor % 60);
            if (i2 > 0) {
                sb.append(" GMT+");
            } else {
                sb.append(" GMT-");
                i2 = -i2;
            }
            append0PaddedUint(sb, i2, 4);
            if (d < 0.0d) {
                d = MakeDate(MakeDay(EquivalentYear(YearFromTime(LocalTime)), MonthFromTime(d), DateFromTime(d)), TimeWithinDay(d));
            }
            sb.append(" (");
            Date date = new Date((long) d);
            DateFormat dateFormat = timeZoneFormatter;
            synchronized (dateFormat) {
                sb.append(dateFormat.format(date));
            }
            sb.append(')');
        }
        return sb.toString();
    }

    private static double date_msecFromArgs(Object[] objArr) {
        double[] dArr = new double[7];
        for (int i = 0; i < 7; i++) {
            if (i < objArr.length) {
                double number = ScriptRuntime.toNumber(objArr[i]);
                if (Double.isNaN(number) || Double.isInfinite(number)) {
                    return Double.NaN;
                }
                dArr[i] = ScriptRuntime.toInteger(objArr[i]);
            } else if (i == 2) {
                dArr[i] = 1.0d;
            } else {
                dArr[i] = 0.0d;
            }
        }
        double d = dArr[0];
        if (d >= 0.0d && d <= 99.0d) {
            dArr[0] = d + 1900.0d;
        }
        return date_msecFromDate(dArr[0], dArr[1], dArr[2], dArr[3], dArr[4], dArr[5], dArr[6]);
    }

    private static double date_msecFromDate(double d, double d2, double d3, double d4, double d5, double d6, double d7) {
        return MakeDate(MakeDay(d, d2, d3), MakeTime(d4, d5, d6, d7));
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0142 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0143  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static double date_parseString(java.lang.String r35) {
        /*
            Method dump skipped, instructions count: 580
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.NativeDate.date_parseString(java.lang.String):double");
    }

    static void init(Scriptable scriptable, boolean z) {
        NativeDate nativeDate = new NativeDate();
        nativeDate.date = Double.NaN;
        nativeDate.exportAsJSClass(47, scriptable, z);
    }

    private static double internalUTC(double d) {
        double d2 = d - LocalTZA;
        return d2 - DaylightSavingTA(d2);
    }

    private static Object jsConstructor(Object[] objArr) {
        double TimeClip;
        NativeDate nativeDate = new NativeDate();
        if (objArr.length == 0) {
            TimeClip = now();
        } else {
            if (objArr.length != 1) {
                double date_msecFromArgs = date_msecFromArgs(objArr);
                if (!Double.isNaN(date_msecFromArgs) && !Double.isInfinite(date_msecFromArgs)) {
                    date_msecFromArgs = TimeClip(internalUTC(date_msecFromArgs));
                }
                nativeDate.date = date_msecFromArgs;
                return nativeDate;
            }
            Object obj = objArr[0];
            if (obj instanceof NativeDate) {
                TimeClip = ((NativeDate) obj).date;
            } else {
                if (obj instanceof Scriptable) {
                    obj = ((Scriptable) obj).getDefaultValue(null);
                }
                TimeClip = TimeClip(obj instanceof CharSequence ? date_parseString(obj.toString()) : ScriptRuntime.toNumber(obj));
            }
        }
        nativeDate.date = TimeClip;
        return nativeDate;
    }

    private static double jsStaticFunction_UTC(Object[] objArr) {
        if (objArr.length == 0) {
            return Double.NaN;
        }
        return TimeClip(date_msecFromArgs(objArr));
    }

    private static String js_toISOString(double d) {
        StringBuilder sb = new StringBuilder(27);
        int YearFromTime = YearFromTime(d);
        int i = 6;
        if (YearFromTime < 0) {
            sb.append('-');
            YearFromTime = -YearFromTime;
        } else if (YearFromTime <= 9999) {
            i = 4;
        }
        append0PaddedUint(sb, YearFromTime, i);
        sb.append('-');
        append0PaddedUint(sb, MonthFromTime(d) + 1, 2);
        sb.append('-');
        append0PaddedUint(sb, DateFromTime(d), 2);
        sb.append('T');
        append0PaddedUint(sb, HourFromTime(d), 2);
        sb.append(':');
        append0PaddedUint(sb, MinFromTime(d), 2);
        sb.append(':');
        append0PaddedUint(sb, SecFromTime(d), 2);
        sb.append('.');
        append0PaddedUint(sb, msFromTime(d), 3);
        sb.append(Matrix.MATRIX_TYPE_ZERO);
        return sb.toString();
    }

    private static String js_toUTCString(double d) {
        StringBuilder sb = new StringBuilder(60);
        appendWeekDayName(sb, WeekDay(d));
        sb.append(", ");
        append0PaddedUint(sb, DateFromTime(d), 2);
        sb.append(' ');
        appendMonthName(sb, MonthFromTime(d));
        sb.append(' ');
        int YearFromTime = YearFromTime(d);
        if (YearFromTime < 0) {
            sb.append('-');
            YearFromTime = -YearFromTime;
        }
        append0PaddedUint(sb, YearFromTime, 4);
        sb.append(' ');
        append0PaddedUint(sb, HourFromTime(d), 2);
        sb.append(':');
        append0PaddedUint(sb, MinFromTime(d), 2);
        sb.append(':');
        append0PaddedUint(sb, SecFromTime(d), 2);
        sb.append(" GMT");
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static double makeDate(double r19, java.lang.Object[] r21, int r22) {
        /*
            r0 = r21
            int r1 = r0.length
            r2 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            if (r1 != 0) goto L8
            return r2
        L8:
            r1 = 2
            r4 = 3
            r5 = 0
            r6 = 1
            switch(r22) {
                case 39: goto L20;
                case 40: goto L1e;
                case 41: goto L1b;
                case 42: goto L19;
                case 43: goto L16;
                case 44: goto L14;
                default: goto Lf;
            }
        Lf:
            java.lang.RuntimeException r0 = external.sdk.pendo.io.mozilla.javascript.Kit.codeBug()
            throw r0
        L14:
            r7 = r5
            goto L17
        L16:
            r7 = r6
        L17:
            r8 = r4
            goto L22
        L19:
            r7 = r5
            goto L1c
        L1b:
            r7 = r6
        L1c:
            r8 = r1
            goto L22
        L1e:
            r7 = r5
            goto L21
        L20:
            r7 = r6
        L21:
            r8 = r6
        L22:
            int r9 = r0.length
            if (r9 >= r8) goto L27
            int r9 = r0.length
            goto L28
        L27:
            r9 = r8
        L28:
            double[] r10 = new double[r4]
            r11 = r5
            r12 = r11
        L2c:
            if (r11 >= r9) goto L4c
            r13 = r0[r11]
            double r13 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.toNumber(r13)
            boolean r15 = java.lang.Double.isNaN(r13)
            if (r15 != 0) goto L48
            boolean r15 = java.lang.Double.isInfinite(r13)
            if (r15 == 0) goto L41
            goto L48
        L41:
            double r13 = external.sdk.pendo.io.mozilla.javascript.ScriptRuntime.toInteger(r13)
            r10[r11] = r13
            goto L49
        L48:
            r12 = r6
        L49:
            int r11 = r11 + 1
            goto L2c
        L4c:
            if (r12 == 0) goto L4f
            return r2
        L4f:
            boolean r0 = java.lang.Double.isNaN(r19)
            if (r0 == 0) goto L5b
            if (r8 >= r4) goto L58
            return r2
        L58:
            r2 = 0
            goto L64
        L5b:
            if (r7 == 0) goto L62
            double r2 = LocalTime(r19)
            goto L64
        L62:
            r2 = r19
        L64:
            if (r8 < r4) goto L6d
            if (r9 <= 0) goto L6d
            r4 = r10[r5]
            r13 = r4
            r5 = r6
            goto L73
        L6d:
            int r0 = YearFromTime(r2)
            double r11 = (double) r0
            r13 = r11
        L73:
            if (r8 < r1) goto L7e
            if (r5 >= r9) goto L7e
            int r0 = r5 + 1
            r4 = r10[r5]
            r15 = r4
            r5 = r0
            goto L84
        L7e:
            int r0 = MonthFromTime(r2)
            double r0 = (double) r0
            r15 = r0
        L84:
            if (r8 < r6) goto L8b
            if (r5 >= r9) goto L8b
            r0 = r10[r5]
            goto L90
        L8b:
            int r0 = DateFromTime(r2)
            double r0 = (double) r0
        L90:
            r17 = r0
            double r0 = MakeDay(r13, r15, r17)
            double r2 = TimeWithinDay(r2)
            double r0 = MakeDate(r0, r2)
            if (r7 == 0) goto La4
            double r0 = internalUTC(r0)
        La4:
            double r0 = TimeClip(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.NativeDate.makeDate(double, java.lang.Object[], int):double");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static double makeTime(double r22, java.lang.Object[] r24, int r25) {
        /*
            Method dump skipped, instructions count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.NativeDate.makeTime(double, java.lang.Object[], int):double");
    }

    private static int msFromTime(double d) {
        double d2 = d % msPerSecond;
        if (d2 < 0.0d) {
            d2 += msPerSecond;
        }
        return (int) d2;
    }

    private static double now() {
        return System.currentTimeMillis();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x00ca, code lost:
    
        if (r7 != '-') goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x00dd, code lost:
    
        if (r7 != '-') goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x00fa, code lost:
    
        if (r7 == 'T') goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x010a, code lost:
    
        r12 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0108, code lost:
    
        if (r7 == 'T') goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0075, code lost:
    
        if (r12 != 7) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x00b8, code lost:
    
        if (r7 != '-') goto L77;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0123 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01ad A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static double parseISOString(java.lang.String r35) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.NativeDate.parseISOString(java.lang.String):double");
    }

    private static String toLocale_helper(double d, int i) {
        DateFormat dateFormat;
        String format;
        if (i == 5) {
            dateFormat = localeDateTimeFormatter;
        } else if (i == 6) {
            dateFormat = localeTimeFormatter;
        } else {
            if (i != 7) {
                throw new AssertionError();
            }
            dateFormat = localeDateFormatter;
        }
        synchronized (dateFormat) {
            format = dateFormat.format(new Date((long) d));
        }
        return format;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject, external.sdk.pendo.io.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        double d;
        if (!idFunctionObject.hasTag(DATE_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int methodId = idFunctionObject.methodId();
        if (methodId == 1) {
            return scriptable2 != null ? date_format(now(), 2) : jsConstructor(objArr);
        }
        if (methodId == 47) {
            Scriptable object = ScriptRuntime.toObject(context, scriptable, scriptable2);
            Object primitive = ScriptRuntime.toPrimitive(object, ScriptRuntime.NumberClass);
            if (primitive instanceof Number) {
                double doubleValue = ((Number) primitive).doubleValue();
                if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                    return null;
                }
            }
            Object property = ScriptableObject.getProperty(object, "toISOString");
            if (property == Scriptable.NOT_FOUND) {
                throw ScriptRuntime.typeError2("msg.function.not.found.in", "toISOString", ScriptRuntime.toString(object));
            }
            if (!(property instanceof Callable)) {
                throw ScriptRuntime.typeError3("msg.isnt.function.in", "toISOString", ScriptRuntime.toString(object), ScriptRuntime.toString(property));
            }
            Object call = ((Callable) property).call(context, scriptable, object, ScriptRuntime.emptyArgs);
            if (ScriptRuntime.isPrimitive(call)) {
                return call;
            }
            throw ScriptRuntime.typeError1("msg.toisostring.must.return.primitive", ScriptRuntime.toString(call));
        }
        if (methodId == -3) {
            return ScriptRuntime.wrapNumber(now());
        }
        if (methodId == -2) {
            return ScriptRuntime.wrapNumber(date_parseString(ScriptRuntime.toString(objArr, 0)));
        }
        if (methodId == -1) {
            return ScriptRuntime.wrapNumber(jsStaticFunction_UTC(objArr));
        }
        if (!(scriptable2 instanceof NativeDate)) {
            throw IdScriptableObject.incompatibleCallError(idFunctionObject);
        }
        NativeDate nativeDate = (NativeDate) scriptable2;
        double d2 = nativeDate.date;
        switch (methodId) {
            case 2:
            case 3:
            case 4:
                return !Double.isNaN(d2) ? date_format(d2, methodId) : js_NaN_date_str;
            case 5:
            case 6:
            case 7:
                return !Double.isNaN(d2) ? toLocale_helper(d2, methodId) : js_NaN_date_str;
            case 8:
                return !Double.isNaN(d2) ? js_toUTCString(d2) : js_NaN_date_str;
            case 9:
                return "(new Date(" + ScriptRuntime.toString(d2) + "))";
            case 10:
            case 11:
                return ScriptRuntime.wrapNumber(d2);
            case 12:
            case 13:
            case 14:
                if (!Double.isNaN(d2)) {
                    if (methodId != 14) {
                        d2 = LocalTime(d2);
                    }
                    d2 = YearFromTime(d2);
                    if (methodId == 12 && (!context.hasFeature(1) || (1900.0d <= d2 && d2 < 2000.0d))) {
                        d2 -= 1900.0d;
                    }
                }
                return ScriptRuntime.wrapNumber(d2);
            case 15:
            case 16:
                if (!Double.isNaN(d2)) {
                    if (methodId == 15) {
                        d2 = LocalTime(d2);
                    }
                    d2 = MonthFromTime(d2);
                }
                return ScriptRuntime.wrapNumber(d2);
            case 17:
            case 18:
                if (!Double.isNaN(d2)) {
                    if (methodId == 17) {
                        d2 = LocalTime(d2);
                    }
                    d2 = DateFromTime(d2);
                }
                return ScriptRuntime.wrapNumber(d2);
            case 19:
            case 20:
                if (!Double.isNaN(d2)) {
                    if (methodId == 19) {
                        d2 = LocalTime(d2);
                    }
                    d2 = WeekDay(d2);
                }
                return ScriptRuntime.wrapNumber(d2);
            case 21:
            case 22:
                if (!Double.isNaN(d2)) {
                    if (methodId == 21) {
                        d2 = LocalTime(d2);
                    }
                    d2 = HourFromTime(d2);
                }
                return ScriptRuntime.wrapNumber(d2);
            case 23:
            case 24:
                if (!Double.isNaN(d2)) {
                    if (methodId == 23) {
                        d2 = LocalTime(d2);
                    }
                    d2 = MinFromTime(d2);
                }
                return ScriptRuntime.wrapNumber(d2);
            case 25:
            case 26:
                if (!Double.isNaN(d2)) {
                    if (methodId == 25) {
                        d2 = LocalTime(d2);
                    }
                    d2 = SecFromTime(d2);
                }
                return ScriptRuntime.wrapNumber(d2);
            case 27:
            case 28:
                if (!Double.isNaN(d2)) {
                    if (methodId == 27) {
                        d2 = LocalTime(d2);
                    }
                    d2 = msFromTime(d2);
                }
                return ScriptRuntime.wrapNumber(d2);
            case 29:
                if (!Double.isNaN(d2)) {
                    d2 = (d2 - LocalTime(d2)) / msPerMinute;
                }
                return ScriptRuntime.wrapNumber(d2);
            case 30:
                double TimeClip = TimeClip(ScriptRuntime.toNumber(objArr, 0));
                nativeDate.date = TimeClip;
                return ScriptRuntime.wrapNumber(TimeClip);
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
                double makeTime = makeTime(d2, objArr, methodId);
                nativeDate.date = makeTime;
                return ScriptRuntime.wrapNumber(makeTime);
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
                double makeDate = makeDate(d2, objArr, methodId);
                nativeDate.date = makeDate;
                return ScriptRuntime.wrapNumber(makeDate);
            case 45:
                double number = ScriptRuntime.toNumber(objArr, 0);
                if (Double.isNaN(number) || Double.isInfinite(number)) {
                    d = Double.NaN;
                } else {
                    double LocalTime = Double.isNaN(d2) ? 0.0d : LocalTime(d2);
                    if (number >= 0.0d && number <= 99.0d) {
                        number += 1900.0d;
                    }
                    d = TimeClip(internalUTC(MakeDate(MakeDay(number, MonthFromTime(LocalTime), DateFromTime(LocalTime)), TimeWithinDay(LocalTime))));
                }
                nativeDate.date = d;
                return ScriptRuntime.wrapNumber(d);
            case 46:
                if (Double.isNaN(d2)) {
                    throw ScriptRuntime.rangeError(ScriptRuntime.getMessage0("msg.invalid.date"));
                }
                return js_toISOString(d2);
            default:
                throw new IllegalArgumentException(String.valueOf(methodId));
        }
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        Object obj = DATE_TAG;
        addIdFunctionProperty(idFunctionObject, obj, -3, "now", 0);
        addIdFunctionProperty(idFunctionObject, obj, -2, "parse", 1);
        addIdFunctionProperty(idFunctionObject, obj, -1, "UTC", 7);
        super.fillConstructorProperties(idFunctionObject);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0217 A[FALL_THROUGH] */
    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected int findPrototypeId(java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 590
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: external.sdk.pendo.io.mozilla.javascript.NativeDate.findPrototypeId(java.lang.String):int");
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public String getClassName() {
        return HttpRequest.HEADER_DATE;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.ScriptableObject, external.sdk.pendo.io.mozilla.javascript.Scriptable
    public Object getDefaultValue(Class<?> cls) {
        if (cls == null) {
            cls = ScriptRuntime.StringClass;
        }
        return super.getDefaultValue(cls);
    }

    double getJSTimeValue() {
        return this.date;
    }

    @Override // external.sdk.pendo.io.mozilla.javascript.IdScriptableObject
    protected void initPrototypeId(int i) {
        String str;
        String str2;
        int i2 = 4;
        int i3 = 0;
        switch (i) {
            case 1:
                i2 = 7;
                str = "constructor";
                i3 = i2;
                str2 = str;
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 2:
                str2 = "toString";
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 3:
                str2 = "toTimeString";
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 4:
                str2 = "toDateString";
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 5:
                str2 = "toLocaleString";
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 6:
                str2 = "toLocaleTimeString";
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 7:
                str2 = "toLocaleDateString";
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 8:
                str2 = "toUTCString";
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 9:
                str2 = "toSource";
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 10:
                str2 = "valueOf";
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 11:
                str2 = "getTime";
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 12:
                str2 = "getYear";
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 13:
                str2 = "getFullYear";
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 14:
                str2 = "getUTCFullYear";
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 15:
                str2 = "getMonth";
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 16:
                str2 = "getUTCMonth";
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 17:
                str2 = "getDate";
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 18:
                str2 = "getUTCDate";
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 19:
                str2 = "getDay";
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 20:
                str2 = "getUTCDay";
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 21:
                str2 = "getHours";
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 22:
                str2 = "getUTCHours";
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 23:
                str2 = "getMinutes";
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 24:
                str2 = "getUTCMinutes";
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 25:
                str2 = "getSeconds";
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 26:
                str2 = "getUTCSeconds";
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 27:
                str2 = "getMilliseconds";
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 28:
                str2 = "getUTCMilliseconds";
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 29:
                str2 = "getTimezoneOffset";
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 30:
                str2 = "setTime";
                i3 = 1;
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 31:
                str2 = "setMilliseconds";
                i3 = 1;
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 32:
                str2 = "setUTCMilliseconds";
                i3 = 1;
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 33:
                str2 = "setSeconds";
                i3 = 2;
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 34:
                str2 = "setUTCSeconds";
                i3 = 2;
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 35:
                str2 = "setMinutes";
                i3 = 3;
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 36:
                str2 = "setUTCMinutes";
                i3 = 3;
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 37:
                str = "setHours";
                i3 = i2;
                str2 = str;
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 38:
                str = "setUTCHours";
                i3 = i2;
                str2 = str;
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 39:
                str2 = "setDate";
                i3 = 1;
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 40:
                str2 = "setUTCDate";
                i3 = 1;
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 41:
                str2 = "setMonth";
                i3 = 2;
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 42:
                str2 = "setUTCMonth";
                i3 = 2;
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 43:
                str2 = "setFullYear";
                i3 = 3;
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 44:
                str2 = "setUTCFullYear";
                i3 = 3;
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 45:
                str2 = "setYear";
                i3 = 1;
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 46:
                str2 = "toISOString";
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            case 47:
                str2 = "toJSON";
                i3 = 1;
                initPrototypeMethod(DATE_TAG, i, str2, i3);
                return;
            default:
                throw new IllegalArgumentException(String.valueOf(i));
        }
    }
}
