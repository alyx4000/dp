package io.branch.referral;

import android.content.Context;
import android.text.TextUtils;
import io.branch.referral.Defines;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class AppStoreReferrer {
    private static String installID_ = "bnc_no_value";

    public static void processReferrerInfo(Context context, String str, long j, long j2, String str2) {
        PrefHelper prefHelper = PrefHelper.getInstance(context);
        if (!TextUtils.isEmpty(str2)) {
            prefHelper.setAppStoreSource(str2);
        }
        if (j > 0) {
            prefHelper.setLong("bnc_referrer_click_ts", j);
        }
        if (j2 > 0) {
            prefHelper.setLong("bnc_install_begin_ts", j2);
        }
        if (str != null) {
            try {
                String decode = URLDecoder.decode(str, "UTF-8");
                HashMap hashMap = new HashMap();
                String[] split = decode.split("&");
                prefHelper.setAppStoreReferrer(decode);
                for (String str3 : split) {
                    if (!TextUtils.isEmpty(str3)) {
                        String[] split2 = str3.split((str3.contains("=") || !str3.contains("-")) ? "=" : "-");
                        if (split2.length > 1) {
                            hashMap.put(URLDecoder.decode(split2[0], "UTF-8"), URLDecoder.decode(split2[1], "UTF-8"));
                        }
                    }
                }
                if (hashMap.containsKey(Defines.Jsonkey.LinkClickID.getKey())) {
                    String str4 = (String) hashMap.get(Defines.Jsonkey.LinkClickID.getKey());
                    installID_ = str4;
                    prefHelper.setLinkClickIdentifier(str4);
                }
                if (hashMap.containsKey(Defines.Jsonkey.IsFullAppConv.getKey()) && hashMap.containsKey(Defines.Jsonkey.ReferringLink.getKey())) {
                    prefHelper.setIsFullAppConversion(Boolean.parseBoolean((String) hashMap.get(Defines.Jsonkey.IsFullAppConv.getKey())));
                    prefHelper.setAppLink((String) hashMap.get(Defines.Jsonkey.ReferringLink.getKey()));
                }
                if (hashMap.containsKey(Defines.Jsonkey.GoogleSearchInstallReferrer.getKey())) {
                    prefHelper.setGoogleSearchInstallIdentifier((String) hashMap.get(Defines.Jsonkey.GoogleSearchInstallReferrer.getKey()));
                }
                if (hashMap.containsValue(Defines.Jsonkey.PlayAutoInstalls.getKey())) {
                    BranchPreinstall.setBranchPreInstallGoogleReferrer(context, hashMap);
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                BranchLogger.v("Illegal characters in url encoded string");
            }
        }
    }

    public static String getInstallationID() {
        return installID_;
    }
}
