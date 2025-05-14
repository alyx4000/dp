package com.socure.docv.capturesdk.core.parser;

import android.text.TextUtils;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
public final class b {
    public com.socure.docv.capturesdk.core.extractor.model.b a(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        com.socure.docv.capturesdk.common.logger.b.d("SDLT_BP", "read: " + data);
        HashMap hashMap = new HashMap();
        for (String str : StringsKt.split$default((CharSequence) data, new String[]{a.DATA_SEPARATOR.a()}, false, 0, 6, (Object) null)) {
            if (str.length() >= 3) {
                if (str.length() > 4) {
                    String substring = str.substring(0, 5);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    if (Intrinsics.areEqual(substring, a.FORMAT.a())) {
                        a aVar = a.DRIVER_LICENSE_NUMBER;
                        String obj = StringsKt.trim((CharSequence) StringsKt.substringAfter$default(str, aVar.a(), (String) null, 2, (Object) null)).toString();
                        if (obj.length() < str.length() && TextUtils.isEmpty((CharSequence) hashMap.get(aVar.a()))) {
                            hashMap.put(aVar.a(), obj);
                        }
                    }
                }
                String substring2 = str.substring(0, 3);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                String substring3 = str.substring(3);
                Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
                String obj2 = StringsKt.trim((CharSequence) substring3).toString();
                if (!Intrinsics.areEqual(substring2, a.DRIVER_LICENSE_NUMBER.a()) || !TextUtils.isEmpty(obj2)) {
                    hashMap.put(substring2, obj2);
                }
            } else {
                if (Intrinsics.areEqual(a.COMPLIANCE_INDICATOR.a(), str)) {
                    com.socure.docv.capturesdk.common.logger.b.a("SDLT_BP", "Complaint doc");
                }
                com.socure.docv.capturesdk.common.logger.b.a("SDLT_BP", "Garbage line found: " + str, null, 4, null);
            }
        }
        com.socure.docv.capturesdk.core.extractor.model.b bVar = new com.socure.docv.capturesdk.core.extractor.model.b();
        bVar.c = (String) hashMap.get(a.FIRST_NAME.a());
        bVar.j = (String) hashMap.get(a.LAST_NAME.a());
        a aVar2 = a.BIRTH_DATE;
        bVar.q = com.socure.docv.capturesdk.core.extractor.b.b((String) hashMap.get(aVar2.a()));
        bVar.k = (String) hashMap.get(a.DRIVER_LICENSE_NUMBER.a());
        bVar.n = (String) hashMap.get(a.DRIVER_LICENSE_NAME.a());
        bVar.m = com.socure.docv.capturesdk.core.extractor.b.b((String) hashMap.get(a.EXPIRATION_DATE.a()));
        bVar.b = (String) hashMap.get(a.EYE_COLOR.a());
        bVar.d = (String) hashMap.get(a.SEX.a());
        bVar.o = (String) hashMap.get(a.HEIGHT_IN.a());
        bVar.p = (String) hashMap.get(a.HEIGHT_CM.a());
        bVar.e = (String) hashMap.get(a.STATE.a());
        bVar.f = (String) hashMap.get(a.STREET_ADDRESS.a());
        bVar.g = (String) hashMap.get(a.STREET_ADDRESS_TWO.a());
        bVar.h = (String) hashMap.get(a.POSTAL_CODE.a());
        bVar.i = (String) hashMap.get(a.CITY.a());
        bVar.l = com.socure.docv.capturesdk.core.extractor.b.b((String) hashMap.get(a.ISSUE_DATE.a()));
        bVar.r = com.socure.docv.capturesdk.core.extractor.b.b((String) hashMap.get(aVar2.a()));
        bVar.s = (String) hashMap.get(a.COUNTRY.a());
        return bVar;
    }
}
