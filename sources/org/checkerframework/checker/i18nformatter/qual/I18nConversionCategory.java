package org.checkerframework.checker.i18nformatter.qual;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import sdk.pendo.io.events.ConditionData;

/* loaded from: classes6.dex */
public enum I18nConversionCategory {
    UNUSED(null, null),
    GENERAL(null, null),
    DATE(new Class[]{Date.class, Number.class}, new String[]{"date", "time"}),
    NUMBER(new Class[]{Number.class}, new String[]{ConditionData.NUMBER_VALUE, "choice"});

    public final String[] strings;
    public final Class<? extends Object>[] types;

    I18nConversionCategory(Class[] clsArr, String[] strArr) {
        this.types = clsArr;
        this.strings = strArr;
    }

    public static I18nConversionCategory stringToI18nConversionCategory(String str) {
        String lowerCase = str.toLowerCase();
        I18nConversionCategory[] i18nConversionCategoryArr = {DATE, NUMBER};
        for (int i = 0; i < 2; i++) {
            I18nConversionCategory i18nConversionCategory = i18nConversionCategoryArr[i];
            for (String str2 : i18nConversionCategory.strings) {
                if (str2.equals(lowerCase)) {
                    return i18nConversionCategory;
                }
            }
        }
        throw new IllegalArgumentException("Invalid format type " + lowerCase);
    }

    private static <E> Set<E> arrayToSet(E[] eArr) {
        return new HashSet(Arrays.asList(eArr));
    }

    public static boolean isSubsetOf(I18nConversionCategory i18nConversionCategory, I18nConversionCategory i18nConversionCategory2) {
        return intersect(i18nConversionCategory, i18nConversionCategory2) == i18nConversionCategory;
    }

    public static I18nConversionCategory intersect(I18nConversionCategory i18nConversionCategory, I18nConversionCategory i18nConversionCategory2) {
        I18nConversionCategory i18nConversionCategory3 = UNUSED;
        if (i18nConversionCategory == i18nConversionCategory3) {
            return i18nConversionCategory2;
        }
        if (i18nConversionCategory2 == i18nConversionCategory3) {
            return i18nConversionCategory;
        }
        I18nConversionCategory i18nConversionCategory4 = GENERAL;
        if (i18nConversionCategory == i18nConversionCategory4) {
            return i18nConversionCategory2;
        }
        if (i18nConversionCategory2 == i18nConversionCategory4) {
            return i18nConversionCategory;
        }
        Set arrayToSet = arrayToSet(i18nConversionCategory.types);
        arrayToSet.retainAll(arrayToSet(i18nConversionCategory2.types));
        I18nConversionCategory[] i18nConversionCategoryArr = {DATE, NUMBER};
        for (int i = 0; i < 2; i++) {
            I18nConversionCategory i18nConversionCategory5 = i18nConversionCategoryArr[i];
            if (arrayToSet(i18nConversionCategory5.types).equals(arrayToSet)) {
                return i18nConversionCategory5;
            }
        }
        throw new RuntimeException();
    }

    public static I18nConversionCategory union(I18nConversionCategory i18nConversionCategory, I18nConversionCategory i18nConversionCategory2) {
        I18nConversionCategory i18nConversionCategory3 = UNUSED;
        return (i18nConversionCategory == i18nConversionCategory3 || i18nConversionCategory2 == i18nConversionCategory3 || i18nConversionCategory == (i18nConversionCategory3 = GENERAL) || i18nConversionCategory2 == i18nConversionCategory3 || i18nConversionCategory == (i18nConversionCategory3 = DATE) || i18nConversionCategory2 == i18nConversionCategory3) ? i18nConversionCategory3 : NUMBER;
    }

    @Override // java.lang.Enum
    public String toString() {
        StringBuilder sb = new StringBuilder(name());
        if (this.types == null) {
            sb.append(" conversion category (all types)");
        } else {
            sb.append(" conversion category (one of: ");
            Class<? extends Object>[] clsArr = this.types;
            int length = clsArr.length;
            boolean z = true;
            int i = 0;
            while (i < length) {
                Class<? extends Object> cls = clsArr[i];
                if (!z) {
                    sb.append(", ");
                }
                sb.append(cls.getCanonicalName());
                i++;
                z = false;
            }
            sb.append(")");
        }
        return sb.toString();
    }
}
