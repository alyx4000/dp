package io.sentry.metrics;

import com.google.android.gms.location.DeviceOrientationRequest;
import io.sentry.MeasurementUnit;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class MetricsHelper {
    public static final long FLUSHER_SLEEP_TIME_MS = 5000;
    public static final int MAX_TOTAL_WEIGHT = 100000;
    private static final int ROLLUP_IN_SECONDS = 10;
    private static final char TAGS_ESCAPE_CHAR = '\\';
    private static final char TAGS_KEY_VALUE_DELIMITER = '=';
    private static final char TAGS_PAIR_DELIMITER = ',';
    private static final Pattern INVALID_KEY_CHARACTERS_PATTERN = Pattern.compile("[^a-zA-Z0-9_/.-]+");
    private static final Pattern INVALID_VALUE_CHARACTERS_PATTERN = Pattern.compile("[^\\w\\d\\s_:/@\\.\\{\\}\\[\\]$-]+");
    private static final Pattern INVALID_METRIC_UNIT_CHARACTERS_PATTERN = Pattern.compile("[^a-zA-Z0-9_/.]+");
    private static long FLUSH_SHIFT_MS = (long) (new Random().nextFloat() * 10000.0f);

    public static long getDayBucketKey(Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar2.set(1, calendar.get(1));
        calendar2.set(2, calendar.get(2));
        calendar2.set(5, calendar.get(5));
        return calendar2.getTimeInMillis() / 1000;
    }

    public static long getTimeBucketKey(long j) {
        long j2 = ((j / 1000) / 10) * 10;
        return j >= 0 ? j2 : j2 - 1;
    }

    public static long getCutoffTimestampMs(long j) {
        return (j - DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM) - FLUSH_SHIFT_MS;
    }

    public static String sanitizeKey(String str) {
        return INVALID_KEY_CHARACTERS_PATTERN.matcher(str).replaceAll("_");
    }

    public static String sanitizeValue(String str) {
        return INVALID_VALUE_CHARACTERS_PATTERN.matcher(str).replaceAll("");
    }

    public static String toStatsdType(MetricType metricType) {
        int i = AnonymousClass1.$SwitchMap$io$sentry$metrics$MetricType[metricType.ordinal()];
        if (i == 1) {
            return "c";
        }
        if (i == 2) {
            return "g";
        }
        if (i == 3) {
            return "d";
        }
        if (i == 4) {
            return "s";
        }
        throw new IllegalArgumentException("Invalid Metric Type: " + metricType.name());
    }

    public static String getMetricBucketKey(MetricType metricType, String str, MeasurementUnit measurementUnit, Map<String, String> map) {
        return String.format("%s_%s_%s_%s", toStatsdType(metricType), str, getUnitName(measurementUnit), GetTagsKey(map));
    }

    private static String getUnitName(MeasurementUnit measurementUnit) {
        return measurementUnit != null ? measurementUnit.apiName() : "none";
    }

    private static String GetTagsKey(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String escapeString = escapeString(entry.getKey());
            String escapeString2 = escapeString(entry.getValue());
            if (sb.length() > 0) {
                sb.append(TAGS_PAIR_DELIMITER);
            }
            sb.append(escapeString).append(TAGS_KEY_VALUE_DELIMITER).append(escapeString2);
        }
        return sb.toString();
    }

    private static String escapeString(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == ',' || charAt == '=') {
                sb.append('\\');
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    /* renamed from: io.sentry.metrics.MetricsHelper$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$sentry$MeasurementUnit$Duration;
        static final /* synthetic */ int[] $SwitchMap$io$sentry$metrics$MetricType;

        static {
            int[] iArr = new int[MeasurementUnit.Duration.values().length];
            $SwitchMap$io$sentry$MeasurementUnit$Duration = iArr;
            try {
                iArr[MeasurementUnit.Duration.NANOSECOND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$sentry$MeasurementUnit$Duration[MeasurementUnit.Duration.MICROSECOND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$sentry$MeasurementUnit$Duration[MeasurementUnit.Duration.MILLISECOND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$sentry$MeasurementUnit$Duration[MeasurementUnit.Duration.SECOND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$sentry$MeasurementUnit$Duration[MeasurementUnit.Duration.MINUTE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$sentry$MeasurementUnit$Duration[MeasurementUnit.Duration.HOUR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$sentry$MeasurementUnit$Duration[MeasurementUnit.Duration.DAY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$sentry$MeasurementUnit$Duration[MeasurementUnit.Duration.WEEK.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[MetricType.values().length];
            $SwitchMap$io$sentry$metrics$MetricType = iArr2;
            try {
                iArr2[MetricType.Counter.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$sentry$metrics$MetricType[MetricType.Gauge.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$sentry$metrics$MetricType[MetricType.Distribution.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$io$sentry$metrics$MetricType[MetricType.Set.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public static double convertNanosTo(MeasurementUnit.Duration duration, long j) {
        switch (AnonymousClass1.$SwitchMap$io$sentry$MeasurementUnit$Duration[duration.ordinal()]) {
            case 1:
                return j;
            case 2:
                return j / 1000.0d;
            case 3:
                return j / 1000000.0d;
            case 4:
                return j / 1.0E9d;
            case 5:
                return j / 6.0E10d;
            case 6:
                return j / 3.6E12d;
            case 7:
                return j / 8.64E13d;
            case 8:
                return (j / 8.64E13d) / 7.0d;
            default:
                throw new IllegalArgumentException("Unknown Duration unit: " + duration.name());
        }
    }

    public static void encodeMetrics(long j, Collection<Metric> collection, StringBuilder sb) {
        for (Metric metric : collection) {
            sb.append(sanitizeKey(metric.getKey()));
            sb.append("@");
            sb.append(sanitizeUnit(getUnitName(metric.getUnit())));
            for (Object obj : metric.serialize()) {
                sb.append(":");
                sb.append(obj);
            }
            sb.append("|");
            sb.append(toStatsdType(metric.getType()));
            Map<String, String> tags = metric.getTags();
            if (tags != null) {
                sb.append("|#");
                boolean z = true;
                for (Map.Entry<String, String> entry : tags.entrySet()) {
                    String sanitizeKey = sanitizeKey(entry.getKey());
                    if (z) {
                        z = false;
                    } else {
                        sb.append(",");
                    }
                    sb.append(sanitizeKey);
                    sb.append(":");
                    sb.append(sanitizeValue(entry.getValue()));
                }
            }
            sb.append("|T");
            sb.append(j);
            sb.append("\n");
        }
    }

    public static String sanitizeUnit(String str) {
        return INVALID_METRIC_UNIT_CHARACTERS_PATTERN.matcher(str).replaceAll("_");
    }

    public static Map<String, String> mergeTags(Map<String, String> map, Map<String, String> map2) {
        if (map == null) {
            return Collections.unmodifiableMap(map2);
        }
        HashMap hashMap = new HashMap(map);
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            String key = entry.getKey();
            if (!hashMap.containsKey(key)) {
                hashMap.put(key, entry.getValue());
            }
        }
        return hashMap;
    }

    public static void setFlushShiftMs(long j) {
        FLUSH_SHIFT_MS = j;
    }
}
