package org.koin.ext;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: StringExt.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0002"}, d2 = {"clearQuotes", "", "koin-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class StringExtKt {
    public static final String clearQuotes(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (str.length() <= 1) {
            return str;
        }
        String str2 = str;
        if (StringsKt.first(str2) != '\"' || StringsKt.last(str2) != '\"') {
            return str;
        }
        String substring = str.substring(1, StringsKt.getLastIndex(str2));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }
}
