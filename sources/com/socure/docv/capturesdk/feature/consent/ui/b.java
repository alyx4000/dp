package com.socure.docv.capturesdk.feature.consent.ui;

import android.os.Bundle;
import androidx.navigation.NavDirections;
import com.socure.docv.capturesdk.R;
import java.util.HashMap;

/* loaded from: classes5.dex */
public class b implements NavDirections {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f431a;

    public b(String str, String str2) {
        HashMap hashMap = new HashMap();
        this.f431a = hashMap;
        if (str == null) {
            throw new IllegalArgumentException("Argument \"privacyPolicyLink\" is marked as non-null but was passed a null value.");
        }
        hashMap.put("privacyPolicyLink", str);
        if (str2 == null) {
            throw new IllegalArgumentException("Argument \"closeContentDescription\" is marked as non-null but was passed a null value.");
        }
        hashMap.put("closeContentDescription", str2);
    }

    public String a() {
        return (String) this.f431a.get("closeContentDescription");
    }

    public String b() {
        return (String) this.f431a.get("privacyPolicyLink");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f431a.containsKey("privacyPolicyLink") != bVar.f431a.containsKey("privacyPolicyLink")) {
            return false;
        }
        if (b() == null ? bVar.b() != null : !b().equals(bVar.b())) {
            return false;
        }
        if (this.f431a.containsKey("closeContentDescription") != bVar.f431a.containsKey("closeContentDescription")) {
            return false;
        }
        return a() == null ? bVar.a() == null : a().equals(bVar.a());
    }

    @Override // androidx.navigation.NavDirections
    public int getActionId() {
        return R.id.action_consent_privacy_dialog;
    }

    @Override // androidx.navigation.NavDirections
    public Bundle getArguments() {
        Bundle bundle = new Bundle();
        if (this.f431a.containsKey("privacyPolicyLink")) {
            bundle.putString("privacyPolicyLink", (String) this.f431a.get("privacyPolicyLink"));
        }
        if (this.f431a.containsKey("closeContentDescription")) {
            bundle.putString("closeContentDescription", (String) this.f431a.get("closeContentDescription"));
        }
        return bundle;
    }

    public int hashCode() {
        return (((((b() != null ? b().hashCode() : 0) + 31) * 31) + (a() != null ? a().hashCode() : 0)) * 31) + R.id.action_consent_privacy_dialog;
    }

    public String toString() {
        return "ActionConsentPrivacyDialog(actionId=" + R.id.action_consent_privacy_dialog + "){privacyPolicyLink=" + b() + ", closeContentDescription=" + a() + "}";
    }
}
