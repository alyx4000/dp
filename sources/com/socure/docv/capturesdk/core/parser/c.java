package com.socure.docv.capturesdk.core.parser;

import android.text.TextUtils;
import com.google.firebase.ktx.BuildConfig;
import com.socure.docv.capturesdk.common.utils.Utils;
import com.socure.docv.capturesdk.core.extractor.model.d;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public final class c {
    public final int a(char c) {
        if (c == '<') {
            return 0;
        }
        return Character.isDigit(c) ? CharsKt.digitToInt(c) : c - '7';
    }

    public final d a(Pair<String, String> mrzLines) {
        String str;
        Intrinsics.checkNotNullParameter(mrzLines, "mrzLines");
        if (mrzLines.getFirst().length() != 44 || mrzLines.getSecond().length() != 44) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_BP", "Invalid line lengths", null, 4, null);
            return null;
        }
        d dVar = new d();
        String substring = mrzLines.getFirst().substring(2, 5);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        dVar.b = substring;
        String substring2 = mrzLines.getFirst().substring(5);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
        com.socure.docv.capturesdk.common.logger.b.d("SDLT_BP", "namePart: " + substring2);
        Matcher matcher = Pattern.compile("(.*[A-Z])").matcher(substring2);
        String group = matcher.find() ? matcher.group() : null;
        com.socure.docv.capturesdk.common.logger.b.d("SDLT_BP", "countryCode: " + substring + " | rawName: " + group);
        if (group != null) {
            List split$default = StringsKt.split$default((CharSequence) group, new String[]{"<<"}, false, 0, 6, (Object) null);
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_BP", "names: " + CollectionsKt.joinToString$default(split$default, ", ", null, null, 0, null, null, 62, null));
            int i = 0;
            for (Object obj : split$default) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str2 = (String) obj;
                if (i == 0) {
                    if (StringsKt.contains$default((CharSequence) str2, (CharSequence) "<", false, 2, (Object) null)) {
                        str2 = CollectionsKt.joinToString$default(StringsKt.split$default((CharSequence) str2, new String[]{"<"}, false, 0, 6, (Object) null), " ", null, null, 0, null, null, 62, null);
                    }
                    dVar.c = str2;
                } else if (i == 1) {
                    if (StringsKt.contains$default((CharSequence) str2, (CharSequence) "<", false, 2, (Object) null)) {
                        str2 = CollectionsKt.joinToString$default(StringsKt.split$default((CharSequence) str2, new String[]{"<"}, false, 0, 6, (Object) null), " ", null, null, 0, null, null, 62, null);
                    }
                    dVar.d = str2;
                }
                i = i2;
            }
            dVar.e = (TextUtils.isEmpty(dVar.d) || TextUtils.isEmpty(dVar.c)) ? !TextUtils.isEmpty(dVar.d) ? dVar.d : !TextUtils.isEmpty(dVar.c) ? dVar.c : null : dVar.d + " " + dVar.c;
            com.socure.docv.capturesdk.common.logger.b.d("SDLT_BP", "Name: first: " + dVar.d + " | surname: " + dVar.c);
        }
        String substring3 = mrzLines.getSecond().substring(0, 9);
        Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
        dVar.f = a(substring3);
        String substring4 = mrzLines.getSecond().substring(9, 10);
        Intrinsics.checkNotNullExpressionValue(substring4, "this as java.lang.String…ing(startIndex, endIndex)");
        dVar.l = Boolean.valueOf(a(substring3, substring4));
        String substring5 = mrzLines.getSecond().substring(10, 13);
        Intrinsics.checkNotNullExpressionValue(substring5, "this as java.lang.String…ing(startIndex, endIndex)");
        if (TextUtils.isEmpty(dVar.b)) {
            dVar.b = substring5;
        }
        dVar.g = dVar.b;
        String substring6 = mrzLines.getSecond().substring(13, 19);
        Intrinsics.checkNotNullExpressionValue(substring6, "this as java.lang.String…ing(startIndex, endIndex)");
        String a2 = a(substring6);
        dVar.h = a2 != null ? Utils.getFormattedDate$capturesdk_productionRelease$default(Utils.INSTANCE, a2, "yyMMdd", null, 4, null) : null;
        String substring7 = mrzLines.getSecond().substring(19, 20);
        Intrinsics.checkNotNullExpressionValue(substring7, "this as java.lang.String…ing(startIndex, endIndex)");
        dVar.m = Boolean.valueOf(a(substring6, substring7));
        String substring8 = mrzLines.getSecond().substring(20, 21);
        Intrinsics.checkNotNullExpressionValue(substring8, "this as java.lang.String…ing(startIndex, endIndex)");
        int hashCode = substring8.hashCode();
        if (hashCode == 60) {
            if (substring8.equals("<")) {
                str = BuildConfig.VERSION_NAME;
            }
            str = null;
        } else if (hashCode != 70) {
            if (hashCode == 77 && substring8.equals("M")) {
                str = "MALE";
            }
            str = null;
        } else {
            if (substring8.equals("F")) {
                str = "FEMALE";
            }
            str = null;
        }
        dVar.i = str;
        String substring9 = mrzLines.getSecond().substring(21, 27);
        Intrinsics.checkNotNullExpressionValue(substring9, "this as java.lang.String…ing(startIndex, endIndex)");
        String a3 = a(substring9);
        dVar.j = a3 != null ? Utils.getFormattedDate$capturesdk_productionRelease$default(Utils.INSTANCE, a3, "yyMMdd", null, 4, null) : null;
        String substring10 = mrzLines.getSecond().substring(27, 28);
        Intrinsics.checkNotNullExpressionValue(substring10, "this as java.lang.String…ing(startIndex, endIndex)");
        dVar.n = Boolean.valueOf(a(substring9, substring10));
        String substring11 = mrzLines.getSecond().substring(28, 42);
        Intrinsics.checkNotNullExpressionValue(substring11, "this as java.lang.String…ing(startIndex, endIndex)");
        dVar.k = a(substring11);
        String substring12 = mrzLines.getSecond().substring(42, 43);
        Intrinsics.checkNotNullExpressionValue(substring12, "this as java.lang.String…ing(startIndex, endIndex)");
        dVar.o = Boolean.valueOf(a(substring11, substring12));
        String substring13 = mrzLines.getSecond().substring(43);
        Intrinsics.checkNotNullExpressionValue(substring13, "this as java.lang.String).substring(startIndex)");
        String second = mrzLines.getSecond();
        StringBuilder sb = new StringBuilder();
        String substring14 = second.substring(0, 10);
        Intrinsics.checkNotNullExpressionValue(substring14, "this as java.lang.String…ing(startIndex, endIndex)");
        StringBuilder append = sb.append(substring14);
        String substring15 = second.substring(13, 20);
        Intrinsics.checkNotNullExpressionValue(substring15, "this as java.lang.String…ing(startIndex, endIndex)");
        StringBuilder append2 = append.append(substring15);
        String substring16 = second.substring(21, 43);
        Intrinsics.checkNotNullExpressionValue(substring16, "this as java.lang.String…ing(startIndex, endIndex)");
        String sb2 = append2.append(substring16).toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder()\n        …r\n            .toString()");
        dVar.p = Boolean.valueOf(a(sb2, substring13));
        com.socure.docv.capturesdk.common.logger.b.d("SDLT_BP", "runningStartIndex: 43 | docNum: " + substring3 + " | docNumberCheckDigit: " + substring4 + " | countryCodeL2: " + substring5 + " | dob: " + substring6 + " | dobCheckDigit: " + substring7 + " | sex: " + substring8 + " | doe: " + substring9 + " | doeCheckDigit: " + substring10 + " | optionalData: " + substring11 + " | optDataCheckDigit: " + substring12 + " | overallCheckDigit: " + substring13 + " | ");
        return dVar;
    }

    public final String a(String str) {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_BP", "cleanFillers: " + str);
        int indexOf$default = StringsKt.indexOf$default((CharSequence) str, "<", 0, false, 6, (Object) null);
        if (indexOf$default >= 0) {
            str = str.substring(0, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            r0 = 0
            char r1 = r10.charAt(r0)
            boolean r1 = java.lang.Character.isDigit(r1)
            if (r1 == 0) goto L10
            int r10 = java.lang.Integer.parseInt(r10)
            goto L1b
        L10:
            java.lang.String r1 = "<"
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r1)
            if (r10 == 0) goto L1a
            r10 = r0
            goto L1b
        L1a:
            r10 = -1
        L1b:
            if (r10 >= 0) goto L1e
            return r0
        L1e:
            int r1 = r9.length()
            r2 = 1
            r3 = r0
            r4 = r3
            r5 = r2
        L26:
            if (r3 >= r1) goto L5a
            r6 = 3
            if (r5 == r2) goto L45
            r7 = 2
            if (r5 == r7) goto L3b
            if (r5 == r6) goto L31
            goto L50
        L31:
            char r7 = r9.charAt(r3)
            int r7 = r8.a(r7)
            int r7 = r7 * r2
            goto L4f
        L3b:
            char r7 = r9.charAt(r3)
            int r7 = r8.a(r7)
            int r7 = r7 * r6
            goto L4f
        L45:
            char r7 = r9.charAt(r3)
            int r7 = r8.a(r7)
            int r7 = r7 * 7
        L4f:
            int r4 = r4 + r7
        L50:
            int r7 = r5 + 1
            if (r5 != r6) goto L56
            r5 = r2
            goto L57
        L56:
            r5 = r7
        L57:
            int r3 = r3 + 1
            goto L26
        L5a:
            int r4 = r4 % 10
            if (r10 != r4) goto L5f
            r0 = r2
        L5f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.socure.docv.capturesdk.core.parser.c.a(java.lang.String, java.lang.String):boolean");
    }
}
