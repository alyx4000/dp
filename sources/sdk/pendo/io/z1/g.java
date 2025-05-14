package sdk.pendo.io.z1;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.TreeMap;

/* loaded from: classes4.dex */
public class g {
    public static TimeZone d;

    /* renamed from: a, reason: collision with root package name */
    static TreeMap<String, Integer> f1872a = new TreeMap<>(new a());
    static TreeMap<String, Integer> b = new TreeMap<>(new a());
    private static HashSet<String> c = new HashSet<>();
    static TreeMap<String, TimeZone> e = new TreeMap<>();

    public static class a implements Comparator<String> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str.compareToIgnoreCase(str2);
        }
    }

    static {
        c.add("à");
        c.add("at");
        c.add("MEZ");
        c.add("Uhr");
        c.add("h");
        c.add("pm");
        c.add("PM");
        c.add("am");
        c.add("AM");
        c.add("min");
        c.add("um");
        c.add("o'clock");
        for (String str : TimeZone.getAvailableIDs()) {
            e.put(str, TimeZone.getTimeZone(str));
        }
        for (Locale locale : DateFormatSymbols.getAvailableLocales()) {
            if (!"ja".equals(locale.getLanguage()) && !"ko".equals(locale.getLanguage()) && !"zh".equals(locale.getLanguage())) {
                DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance(locale);
                String[] months = dateFormatSymbols.getMonths();
                for (int i = 0; i < months.length; i++) {
                    if (months[i].length() != 0) {
                        a(f1872a, months[i], Integer.valueOf(i));
                    }
                }
                String[] shortMonths = dateFormatSymbols.getShortMonths();
                for (int i2 = 0; i2 < shortMonths.length; i2++) {
                    String str2 = shortMonths[i2];
                    if (str2.length() != 0 && !Character.isDigit(str2.charAt(str2.length() - 1))) {
                        a(f1872a, shortMonths[i2], Integer.valueOf(i2));
                        a(f1872a, shortMonths[i2].replace(".", ""), Integer.valueOf(i2));
                    }
                }
                String[] weekdays = dateFormatSymbols.getWeekdays();
                for (int i3 = 0; i3 < weekdays.length; i3++) {
                    String str3 = weekdays[i3];
                    if (str3.length() != 0) {
                        a(b, str3, Integer.valueOf(i3));
                        a(b, str3.replace(".", ""), Integer.valueOf(i3));
                    }
                }
                String[] shortWeekdays = dateFormatSymbols.getShortWeekdays();
                for (int i4 = 0; i4 < shortWeekdays.length; i4++) {
                    String str4 = shortWeekdays[i4];
                    if (str4.length() != 0) {
                        a(b, str4, Integer.valueOf(i4));
                        a(b, str4.replace(".", ""), Integer.valueOf(i4));
                    }
                }
            }
        }
    }

    private static Date a(StringTokenizer stringTokenizer, Calendar calendar, String str) {
        if (str == null) {
            if (!stringTokenizer.hasMoreTokens()) {
                return calendar.getTime();
            }
            str = stringTokenizer.nextToken();
        }
        return b(stringTokenizer, calendar, str);
    }

    private static Date b(StringTokenizer stringTokenizer, Calendar calendar, String str) {
        String a2;
        String a3;
        String a4;
        calendar.set(11, Integer.parseInt(a(stringTokenizer, str, calendar)));
        if (stringTokenizer.hasMoreTokens() && (a2 = a(stringTokenizer, stringTokenizer.nextToken(), calendar)) != null) {
            calendar.set(12, Integer.parseInt(a2));
            if (stringTokenizer.hasMoreTokens() && (a3 = a(stringTokenizer, stringTokenizer.nextToken(), calendar)) != null) {
                calendar.set(13, Integer.parseInt(a3));
                if (stringTokenizer.hasMoreTokens() && (a4 = a(stringTokenizer, stringTokenizer.nextToken(), calendar)) != null) {
                    String a5 = a(stringTokenizer, a4, calendar);
                    if (a5.length() == 4 && Character.isDigit(a5.charAt(0))) {
                        calendar.set(1, a(a5));
                    }
                    return calendar.getTime();
                }
                return calendar.getTime();
            }
            return calendar.getTime();
        }
        return calendar.getTime();
    }

    private static Date c(StringTokenizer stringTokenizer, String str) {
        String str2;
        GregorianCalendar a2 = a();
        a2.set(1, Integer.parseInt(str));
        if (!stringTokenizer.hasMoreTokens()) {
            return a2.getTime();
        }
        a2.set(2, b(stringTokenizer.nextToken()).intValue());
        if (!stringTokenizer.hasMoreTokens()) {
            return a2.getTime();
        }
        String nextToken = stringTokenizer.nextToken();
        if (!Character.isDigit(nextToken.charAt(0))) {
            return a2.getTime();
        }
        if (nextToken.length() == 5 && nextToken.charAt(2) == 'T') {
            a2.set(5, Integer.parseInt(nextToken.substring(0, 2)));
            str2 = nextToken.substring(3);
        } else {
            a2.set(5, Integer.parseInt(nextToken));
            str2 = null;
        }
        return a(stringTokenizer, a2, str2);
    }

    public static Date a(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Date) {
            return (Date) obj;
        }
        if (obj instanceof Number) {
            return new Date(((Number) obj).longValue());
        }
        if (!(obj instanceof String)) {
            throw new RuntimeException("Primitive: Can not convert " + obj.getClass().getName() + " to int");
        }
        StringTokenizer stringTokenizer = new StringTokenizer(((String) obj).replace("p.m.", "pm").replace("a.m.", "am"), " -/:,.+年月日曜時分秒");
        if (!stringTokenizer.hasMoreTokens()) {
            return null;
        }
        String nextToken = stringTokenizer.nextToken();
        if (nextToken.length() == 4 && Character.isDigit(nextToken.charAt(0))) {
            return c(stringTokenizer, nextToken);
        }
        if (b.containsKey(nextToken)) {
            if (!stringTokenizer.hasMoreTokens()) {
                return null;
            }
            nextToken = stringTokenizer.nextToken();
        }
        if (f1872a.containsKey(nextToken)) {
            return b(stringTokenizer, nextToken);
        }
        if (Character.isDigit(nextToken.charAt(0))) {
            return a(stringTokenizer, nextToken);
        }
        return null;
    }

    private static Date b(StringTokenizer stringTokenizer, String str) {
        GregorianCalendar a2 = a();
        Integer num = f1872a.get(str);
        if (num == null) {
            throw new NullPointerException("can not parse " + str + " as month");
        }
        a2.set(2, num.intValue());
        if (!stringTokenizer.hasMoreTokens()) {
            return null;
        }
        a2.set(5, Integer.parseInt(stringTokenizer.nextToken()));
        if (!stringTokenizer.hasMoreTokens()) {
            return null;
        }
        String nextToken = stringTokenizer.nextToken();
        if (Character.isLetter(nextToken.charAt(0))) {
            if (!stringTokenizer.hasMoreTokens()) {
                return null;
            }
            nextToken = stringTokenizer.nextToken();
        }
        if (nextToken.length() == 4) {
            a2.set(1, a(nextToken));
        } else if (nextToken.length() == 2) {
            return b(stringTokenizer, a2, nextToken);
        }
        return a(stringTokenizer, a2, (String) null);
    }

    private static void a(TreeMap<String, Integer> treeMap, String str, Integer num) {
        treeMap.put(str, num);
        treeMap.put(str.replace("é", "e").replace("û", "u"), num);
    }

    private static Integer b(String str) {
        int intValue;
        if (Character.isDigit(str.charAt(0))) {
            intValue = Integer.parseInt(str) - 1;
        } else {
            Integer num = f1872a.get(str);
            if (num == null) {
                throw new NullPointerException("can not parse " + str + " as month");
            }
            intValue = num.intValue();
        }
        return Integer.valueOf(intValue);
    }

    private static Date a(StringTokenizer stringTokenizer, String str) {
        GregorianCalendar a2 = a();
        a2.set(5, Integer.parseInt(str));
        if (!stringTokenizer.hasMoreTokens()) {
            return null;
        }
        a2.set(2, b(stringTokenizer.nextToken()).intValue());
        if (!stringTokenizer.hasMoreTokens()) {
            return null;
        }
        a2.set(1, a(stringTokenizer.nextToken()));
        return a(stringTokenizer, a2, (String) null);
    }

    private static int a(String str) {
        int parseInt = Integer.parseInt(str);
        return parseInt < 100 ? parseInt > 30 ? parseInt + 2000 : parseInt + 1900 : parseInt;
    }

    private static GregorianCalendar a() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(2000, 0, 0, 0, 0, 0);
        TimeZone timeZone = d;
        if (timeZone != null) {
            gregorianCalendar.setTimeZone(timeZone);
        }
        TimeZone timeZone2 = gregorianCalendar.getTimeZone();
        if (timeZone2 == null) {
            timeZone2 = TimeZone.getDefault();
        }
        gregorianCalendar.setTimeInMillis(-timeZone2.getRawOffset());
        return gregorianCalendar;
    }

    private static String a(StringTokenizer stringTokenizer, String str, Calendar calendar) {
        while (true) {
            TimeZone timeZone = e.get(str);
            if (timeZone != null) {
                calendar.setTimeZone(timeZone);
                if (!stringTokenizer.hasMoreTokens()) {
                    return null;
                }
            } else {
                if (!c.contains(str)) {
                    return str;
                }
                if (str.equalsIgnoreCase("pm")) {
                    calendar.add(9, 1);
                }
                if (str.equalsIgnoreCase("am")) {
                    calendar.add(9, 0);
                }
                if (!stringTokenizer.hasMoreTokens()) {
                    return null;
                }
            }
            str = stringTokenizer.nextToken();
        }
    }
}
