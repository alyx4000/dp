package io.branch.referral.validators;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import io.branch.referral.Branch;
import io.branch.referral.BranchLogger;
import io.branch.referral.Defines;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class DeepLinkRoutingValidator {
    private static final String BRANCH_VALIDATE_TEST_KEY = "_branch_validate";
    private static final int BRANCH_VALIDATE_TEST_VALUE = 60514;
    private static final int LAUNCH_TEST_TEMPLATE_DELAY = 500;
    private static final String URI_REDIRECT_KEY = "$uri_redirect_mode";
    private static final String URI_REDIRECT_MODE = "2";
    private static final String VALIDATE_LINK_PARAM_KEY = "validate";
    private static final String VALIDATE_SDK_LINK_PARAM_KEY = "bnc_validate";
    private static WeakReference<Activity> current_activity_reference;

    public static void validate(WeakReference<Activity> weakReference) {
        current_activity_reference = weakReference;
        if (TextUtils.isEmpty(getLatestReferringLink()) || weakReference == null) {
            return;
        }
        final JSONObject latestReferringParams = Branch.getInstance().getLatestReferringParams();
        if (latestReferringParams.optInt(BRANCH_VALIDATE_TEST_KEY) == BRANCH_VALIDATE_TEST_VALUE) {
            if (latestReferringParams.optBoolean(Defines.Jsonkey.Clicked_Branch_Link.getKey())) {
                validateDeeplinkRouting(latestReferringParams);
                return;
            } else {
                displayErrorMessage();
                return;
            }
        }
        if (latestReferringParams.optBoolean(VALIDATE_SDK_LINK_PARAM_KEY)) {
            new Handler().postDelayed(new Runnable() { // from class: io.branch.referral.validators.DeepLinkRoutingValidator.1
                @Override // java.lang.Runnable
                public void run() {
                    DeepLinkRoutingValidator.launchTestTemplate(DeepLinkRoutingValidator.getUpdatedLinkWithTestStat(latestReferringParams, ""));
                }
            }, 500L);
        }
    }

    private static void validateDeeplinkRouting(final JSONObject jSONObject) {
        if (current_activity_reference.get() != null) {
            new AlertDialog.Builder(current_activity_reference.get(), R.style.Theme.Material.Dialog.Alert).setTitle("Branch Deeplinking Routing").setMessage("Good news - we got link data. Now a question for you, astute developer: did the app deep link to the specific piece of content you expected to see?").setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: io.branch.referral.validators.DeepLinkRoutingValidator.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    DeepLinkRoutingValidator.launchTestTemplate(DeepLinkRoutingValidator.getUpdatedLinkWithTestStat(jSONObject, "g"));
                }
            }).setNegativeButton("No", new DialogInterface.OnClickListener() { // from class: io.branch.referral.validators.DeepLinkRoutingValidator.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    DeepLinkRoutingValidator.launchTestTemplate(DeepLinkRoutingValidator.getUpdatedLinkWithTestStat(jSONObject, "r"));
                }
            }).setNeutralButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: io.branch.referral.validators.DeepLinkRoutingValidator.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }).setCancelable(false).setIcon(R.drawable.sym_def_app_icon).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void launchTestTemplate(String str) {
        if (current_activity_reference.get() != null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str).buildUpon().appendQueryParameter(URI_REDIRECT_KEY, "2").build());
            intent.addFlags(268435456);
            intent.setPackage("com.android.chrome");
            current_activity_reference.get().getPackageManager().queryIntentActivities(intent, 0);
            try {
                current_activity_reference.get().startActivity(intent);
            } catch (ActivityNotFoundException unused) {
                intent.setPackage(null);
                current_activity_reference.get().startActivity(intent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getUpdatedLinkWithTestStat(JSONObject jSONObject, String str) {
        String str2;
        String str3 = "";
        try {
            str3 = jSONObject.getString("~" + Defines.Jsonkey.ReferringLink.getKey());
            str2 = str3.split("\\?")[0];
        } catch (Exception unused) {
            BranchLogger.v("Failed to get referring link");
            str2 = str3;
        }
        String str4 = str2 + "?validate=true";
        if (!TextUtils.isEmpty(str)) {
            try {
                str4 = ((((str4 + (jSONObject.getString("ct").equals("t1") ? new StringBuilder("&t1=").append(str) : new StringBuilder("&t1=").append(jSONObject.getString("t1"))).toString()) + (jSONObject.getString("ct").equals("t2") ? new StringBuilder("&t2=").append(str) : new StringBuilder("&t2=").append(jSONObject.getString("t2"))).toString()) + (jSONObject.getString("ct").equals("t3") ? new StringBuilder("&t3=").append(str) : new StringBuilder("&t3=").append(jSONObject.getString("t3"))).toString()) + (jSONObject.getString("ct").equals("t4") ? new StringBuilder("&t4=").append(str) : new StringBuilder("&t4=").append(jSONObject.getString("t4"))).toString()) + (jSONObject.getString("ct").equals("t5") ? new StringBuilder("&t5=").append(str) : new StringBuilder("&t5=").append(jSONObject.getString("t5"))).toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str4 + "&os=android";
    }

    private static void displayErrorMessage() {
        if (current_activity_reference.get() != null) {
            new AlertDialog.Builder(current_activity_reference.get(), R.style.Theme.Material.Dialog.Alert).setTitle("Branch Deeplink Routing Support").setMessage("Bummer. It seems like +clicked_branch_link is false - we didn't deep link.  Double check that the link you're clicking has the same branch_key that is being used in your Manifest file. Return to Chrome when you're ready to test again.").setNeutralButton("Got it", new DialogInterface.OnClickListener() { // from class: io.branch.referral.validators.DeepLinkRoutingValidator.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            }).setCancelable(false).setIcon(R.drawable.sym_def_app_icon).show();
        }
    }

    private static String getLatestReferringLink() {
        return (Branch.getInstance() == null || Branch.getInstance().getLatestReferringParams() == null) ? "" : Branch.getInstance().getLatestReferringParams().optString("~" + Defines.Jsonkey.ReferringLink.getKey());
    }
}
