package com.socure.docv.capturesdk.core.extractor;

import android.util.Log;
import com.socure.docv.capturesdk.common.utils.UtilsKt;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final Pattern f373a = Pattern.compile("(P[A-Z0-9<]{1})([A-Z]{3})([A-Z0-9<]{39})");
    public final Pattern b = Pattern.compile("([A-Z0-9<]{9})([0-9]{1})([A-Z]{3})([0-9]{6})([0-9]{1})([M|F|X|<]{1})([0-9]{6})([0-9]{1})([A-Z0-9<]{14})([0-9<]{1})([0-9]{1})");

    public final String a(int i, String str) {
        if (str.length() - i < 44) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_MRZ_M", "First line is still less than 44 after cleaning hence returning", null, 4, null);
            return str;
        }
        String substring = str.substring(i, 44);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        String substring2 = str.substring(44);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
        return substring + substring2;
    }

    public final String a(String str) {
        String substring = str.substring(10, 13);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        com.socure.docv.capturesdk.common.logger.b.d("SDLT_MRZ_M", "Found country to fix: " + substring);
        String substring2 = str.substring(0, 10);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
        String fixAlphabets = UtilsKt.fixAlphabets(substring);
        String substring3 = str.substring(13);
        Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
        return substring2 + fixAlphabets + substring3;
    }

    public final Pair<String, String> a(int i, List<String> blocks, boolean z) {
        String str;
        Intrinsics.checkNotNullParameter(blocks, "blocks");
        com.socure.docv.capturesdk.common.logger.b.d("SDLT_MRZ_M", "matcher called at index: " + i);
        try {
            String a2 = b.a(blocks.get(i), 1, z);
            Matcher matcher = this.f373a.matcher(a(StringsKt.indexOf$default((CharSequence) a2, "P<", 0, false, 6, (Object) null), a2));
            if (matcher.find()) {
                String group = matcher.group();
                com.socure.docv.capturesdk.common.logger.b.d("SDLT_MRZ_M", "Line 1 detected: " + group);
                StringBuilder sb = new StringBuilder();
                int size = blocks.size();
                for (int i2 = i + 1; i2 < size; i2++) {
                    sb.append(b.a(blocks.get(i2), 2, false));
                }
                String sb2 = sb.toString();
                Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
                String a3 = a(sb2);
                com.socure.docv.capturesdk.common.logger.b.d("SDLT_MRZ_M", "Trying to match line 2 in remaining text: " + a3);
                Matcher matcher2 = this.b.matcher(a3);
                if (matcher2.find()) {
                    String group2 = matcher2.group();
                    com.socure.docv.capturesdk.common.logger.b.d("SDLT_MRZ_M", "Line 2 detected: " + group2);
                    return new Pair<>(group, group2);
                }
                str = "line2 was not detected";
            } else {
                str = "Line 1 not detected";
            }
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_MRZ_M", str, null, 4, null);
        } catch (Exception e) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_MRZ_M", "Matcher exception stacktrace: " + Log.getStackTraceString(e), null, 4, null);
        }
        return null;
    }
}
