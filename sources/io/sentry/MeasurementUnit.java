package io.sentry;

import java.util.Locale;

/* loaded from: classes2.dex */
public interface MeasurementUnit {
    public static final String NONE = "none";

    String apiName();

    String name();

    public enum Duration implements MeasurementUnit {
        NANOSECOND,
        MICROSECOND,
        MILLISECOND,
        SECOND,
        MINUTE,
        HOUR,
        DAY,
        WEEK;

        @Override // io.sentry.MeasurementUnit
        public String apiName() {
            return name().toLowerCase(Locale.ROOT);
        }
    }

    public enum Information implements MeasurementUnit {
        BIT,
        BYTE,
        KILOBYTE,
        KIBIBYTE,
        MEGABYTE,
        MEBIBYTE,
        GIGABYTE,
        GIBIBYTE,
        TERABYTE,
        TEBIBYTE,
        PETABYTE,
        PEBIBYTE,
        EXABYTE,
        EXBIBYTE;

        @Override // io.sentry.MeasurementUnit
        public String apiName() {
            return name().toLowerCase(Locale.ROOT);
        }
    }

    public enum Fraction implements MeasurementUnit {
        RATIO,
        PERCENT;

        @Override // io.sentry.MeasurementUnit
        public String apiName() {
            return name().toLowerCase(Locale.ROOT);
        }
    }

    public static final class Custom implements MeasurementUnit {
        private final String name;

        public Custom(String str) {
            this.name = str;
        }

        @Override // io.sentry.MeasurementUnit
        public String name() {
            return this.name;
        }

        @Override // io.sentry.MeasurementUnit
        public String apiName() {
            return name().toLowerCase(Locale.ROOT);
        }
    }
}
