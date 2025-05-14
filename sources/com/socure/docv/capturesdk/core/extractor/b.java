package com.socure.docv.capturesdk.core.extractor;

import com.socure.docv.capturesdk.common.utils.Utils;
import com.socure.docv.capturesdk.common.utils.UtilsKt;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public final class b {
    public static final int a(String str, String str2) {
        if (str != null || str2 == null) {
            if ((str2 != null ? str2.length() : 0) <= (str != null ? str.length() : 0)) {
                return 0;
            }
        }
        return 1;
    }

    public static final String a(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        Matcher matcher = Pattern.compile("(P<)([A-Z]{3})([A-Z]+)(<<)([A-Z]+)(<+)").matcher(text);
        int length = 44 - text.length();
        if (!matcher.find() || length <= 0) {
            return text;
        }
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_EU", "First line fell short of <, so adding " + length + " of them");
        return text + StringsKt.repeat("<", length);
    }

    public static final String a(String text, int i, boolean z) {
        Intrinsics.checkNotNullParameter(text, "text");
        String upperCase = UtilsKt.fixSpecialChars(new Regex("\\s+").replace(text, "")).toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        if (i != 1) {
            return upperCase;
        }
        String fixAlphabets = UtilsKt.fixAlphabets(upperCase);
        if (z) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_EU", "started with PK and ended with filler hence changing it to P<");
            fixAlphabets = StringsKt.replaceRange((CharSequence) fixAlphabets, 1, 2, (CharSequence) "<").toString();
        }
        return a(fixAlphabets);
    }

    public static final boolean a(com.socure.docv.capturesdk.core.extractor.model.b bVar, com.socure.docv.capturesdk.core.extractor.model.b next) {
        Unit unit;
        int i;
        Intrinsics.checkNotNullParameter(next, "next");
        if (bVar != null) {
            i = a(bVar.m, next.m) + a(bVar.n, next.n) + a(bVar.k, next.k) + a(bVar.q, next.q) + a(bVar.j, next.j) + a(bVar.c, next.c) + 0;
            unit = Unit.INSTANCE;
        } else {
            unit = null;
            i = 0;
        }
        if (unit == null) {
            i = 1;
        }
        return i > 0;
    }

    public static final String b(String str) {
        if (str != null) {
            return Utils.getFormattedDate$capturesdk_productionRelease$default(Utils.INSTANCE, str, null, null, 6, null);
        }
        return null;
    }
}
