package com.facebook.common.internal;

import java.util.Arrays;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class Objects {
    @CheckReturnValue
    public static boolean equal(@Nullable Object obj, @Nullable Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int hashCode(@Nullable Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static ToStringHelper toStringHelper(Object obj) {
        return new ToStringHelper(obj.getClass().getSimpleName());
    }

    public static ToStringHelper toStringHelper(Class<?> cls) {
        return new ToStringHelper(cls.getSimpleName());
    }

    public static ToStringHelper toStringHelper(String str) {
        return new ToStringHelper(str);
    }

    public static <T> T firstNonNull(@Nullable T t, @Nullable T t2) {
        return t != null ? t : (T) Preconditions.checkNotNull(t2);
    }

    public static final class ToStringHelper {
        private final String className;
        private final ValueHolder holderHead;
        private ValueHolder holderTail;
        private boolean omitNullValues;

        private ToStringHelper(String str) {
            ValueHolder valueHolder = new ValueHolder();
            this.holderHead = valueHolder;
            this.holderTail = valueHolder;
            this.omitNullValues = false;
            this.className = (String) Preconditions.checkNotNull(str);
        }

        public ToStringHelper omitNullValues() {
            this.omitNullValues = true;
            return this;
        }

        public ToStringHelper add(String str, @Nullable Object obj) {
            return addHolder(str, obj);
        }

        public ToStringHelper add(String str, boolean z) {
            return addHolder(str, String.valueOf(z));
        }

        public ToStringHelper add(String str, char c) {
            return addHolder(str, String.valueOf(c));
        }

        public ToStringHelper add(String str, double d) {
            return addHolder(str, String.valueOf(d));
        }

        public ToStringHelper add(String str, float f) {
            return addHolder(str, String.valueOf(f));
        }

        public ToStringHelper add(String str, int i) {
            return addHolder(str, String.valueOf(i));
        }

        public ToStringHelper add(String str, long j) {
            return addHolder(str, String.valueOf(j));
        }

        public ToStringHelper addValue(@Nullable Object obj) {
            return addHolder(obj);
        }

        public ToStringHelper addValue(boolean z) {
            return addHolder(String.valueOf(z));
        }

        public ToStringHelper addValue(char c) {
            return addHolder(String.valueOf(c));
        }

        public ToStringHelper addValue(double d) {
            return addHolder(String.valueOf(d));
        }

        public ToStringHelper addValue(float f) {
            return addHolder(String.valueOf(f));
        }

        public ToStringHelper addValue(int i) {
            return addHolder(String.valueOf(i));
        }

        public ToStringHelper addValue(long j) {
            return addHolder(String.valueOf(j));
        }

        public String toString() {
            boolean z = this.omitNullValues;
            StringBuilder append = new StringBuilder(32).append(this.className).append('{');
            String str = "";
            for (ValueHolder valueHolder = this.holderHead.next; valueHolder != null; valueHolder = valueHolder.next) {
                Object obj = valueHolder.value;
                if (!z || obj != null) {
                    append.append(str);
                    if (valueHolder.name != null) {
                        append.append(valueHolder.name).append('=');
                    }
                    if (obj != null && obj.getClass().isArray()) {
                        String deepToString = Arrays.deepToString(new Object[]{obj});
                        append.append((CharSequence) deepToString, 1, deepToString.length() - 1);
                    } else {
                        append.append(obj);
                    }
                    str = ", ";
                }
            }
            return append.append('}').toString();
        }

        private ValueHolder addHolder() {
            ValueHolder valueHolder = new ValueHolder();
            this.holderTail.next = valueHolder;
            this.holderTail = valueHolder;
            return valueHolder;
        }

        private ToStringHelper addHolder(@Nullable Object obj) {
            addHolder().value = obj;
            return this;
        }

        private ToStringHelper addHolder(String str, @Nullable Object obj) {
            ValueHolder addHolder = addHolder();
            addHolder.value = obj;
            addHolder.name = (String) Preconditions.checkNotNull(str);
            return this;
        }

        private static final class ValueHolder {

            @Nullable
            String name;

            @Nullable
            ValueHolder next;

            @Nullable
            Object value;

            private ValueHolder() {
            }
        }
    }

    private Objects() {
    }
}
