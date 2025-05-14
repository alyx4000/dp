package io.branch.referral;

import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class BranchPartnerParameters {
    private static final Pattern HEXADECIMAL_PATTERN = Pattern.compile("\\p{XDigit}+");
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, String>> partnerParameters = new ConcurrentHashMap<>();

    void clearAllParameters() {
        this.partnerParameters.clear();
    }

    ConcurrentHashMap<String, String> parametersForPartner(String str) {
        ConcurrentHashMap<String, String> concurrentHashMap = this.partnerParameters.get(str);
        if (concurrentHashMap != null) {
            return concurrentHashMap;
        }
        ConcurrentHashMap<String, String> concurrentHashMap2 = new ConcurrentHashMap<>();
        this.partnerParameters.put(str, concurrentHashMap2);
        return concurrentHashMap2;
    }

    private void addParameterWithName(String str, String str2, String str3) {
        parametersForPartner(str3).put(str, str2);
    }

    void addFacebookParameter(String str, String str2) {
        if (isSha256Hashed(str2)) {
            addParameterWithName(str, str2, "fb");
        } else {
            BranchLogger.w("Invalid partner parameter passed. Value must be a SHA 256 hash.");
        }
    }

    void addSnapParameter(String str, String str2) {
        if (isSha256Hashed(str2)) {
            addParameterWithName(str, str2, "snap");
        } else {
            BranchLogger.w("Invalid partner parameter passed. Value must be a SHA 256 hash.");
        }
    }

    boolean isSha256Hashed(String str) {
        return str != null && str.length() == 64 && isHexadecimal(str);
    }

    boolean isHexadecimal(String str) {
        if (str == null) {
            return false;
        }
        if (str.length() == 0) {
            return true;
        }
        return HEXADECIMAL_PATTERN.matcher(str).matches();
    }

    ConcurrentHashMap<String, ConcurrentHashMap<String, String>> allParams() {
        return this.partnerParameters;
    }
}
