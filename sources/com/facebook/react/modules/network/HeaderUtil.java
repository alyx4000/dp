package com.facebook.react.modules.network;

/* loaded from: classes3.dex */
public class HeaderUtil {
    public static String stripHeaderName(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        boolean z = false;
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt <= ' ' || charAt >= 127) {
                z = true;
            } else {
                sb.append(charAt);
            }
        }
        return z ? sb.toString() : str;
    }

    public static String stripHeaderValue(String str) {
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        boolean z = false;
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if ((charAt <= 31 || charAt >= 127) && charAt != '\t') {
                z = true;
            } else {
                sb.append(charAt);
            }
        }
        return z ? sb.toString() : str;
    }
}
