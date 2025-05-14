package sdk.pendo.io.j;

import java.util.GregorianCalendar;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.TimeZones;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000\"\u001c\u0010\u0006\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0005\"\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"", "", "a", "Ljava/util/TimeZone;", "kotlin.jvm.PlatformType", "Ljava/util/TimeZone;", TimeZones.GMT_ID, "Lkotlin/text/Regex;", "b", "Lkotlin/text/Regex;", "Rfc3339Pattern", "certificatetransparency"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private static final TimeZone f1215a = TimeZone.getTimeZone(TimeZones.GMT_ID);
    private static final Regex b = new Regex("^(\\d{4})-(\\d{2})-(\\d{2})([Tt](\\d{2}):(\\d{2}):(\\d{2})(\\.\\d+)?)?([Zz]|([+-])(\\d{2}):(\\d{2}))?");

    public static final long a(String str) {
        int i;
        int i2;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(str, "<this>");
        MatchResult matchEntire = b.matchEntire(str);
        if (matchEntire == null) {
            throw new NumberFormatException("Invalid RFC3339 date/time format: " + str);
        }
        int parseInt = Integer.parseInt(matchEntire.getGroupValues().get(1));
        int parseInt2 = Integer.parseInt(matchEntire.getGroupValues().get(2)) - 1;
        int parseInt3 = Integer.parseInt(matchEntire.getGroupValues().get(3));
        boolean z = matchEntire.getGroupValues().get(4).length() > 0;
        String str2 = matchEntire.getGroupValues().get(9);
        boolean z2 = str2.length() > 0;
        if (z2 && !z) {
            throw new NumberFormatException("Invalid RFC33339 date/time format, cannot specify time zone shift without specifying time: " + str);
        }
        if (z) {
            int parseInt4 = Integer.parseInt(matchEntire.getGroupValues().get(5));
            int parseInt5 = Integer.parseInt(matchEntire.getGroupValues().get(6));
            int parseInt6 = Integer.parseInt(matchEntire.getGroupValues().get(7));
            if (matchEntire.getGroupValues().get(8).length() > 0) {
                String substring = matchEntire.getGroupValues().get(8).substring(1);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                int parseInt7 = Integer.parseInt(substring);
                Intrinsics.checkNotNullExpressionValue(matchEntire.getGroupValues().get(8).substring(1), "this as java.lang.String).substring(startIndex)");
                i = (int) (parseInt7 / Math.pow(10.0d, r3.length() - 3));
                i4 = parseInt6;
            } else {
                i4 = parseInt6;
                i = 0;
            }
            i3 = parseInt5;
            i2 = parseInt4;
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(f1215a);
        gregorianCalendar.set(parseInt, parseInt2, parseInt3, i2, i3, i4);
        gregorianCalendar.set(14, i);
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        if (!z || !z2 || Character.toUpperCase(str2.charAt(0)) == 'Z') {
            return timeInMillis;
        }
        int parseInt8 = (Integer.parseInt(matchEntire.getGroupValues().get(11)) * 60) + Integer.parseInt(matchEntire.getGroupValues().get(12));
        if (matchEntire.getGroupValues().get(10).charAt(0) == '-') {
            parseInt8 = -parseInt8;
        }
        return timeInMillis - (parseInt8 * DateUtils.MILLIS_PER_MINUTE);
    }
}
