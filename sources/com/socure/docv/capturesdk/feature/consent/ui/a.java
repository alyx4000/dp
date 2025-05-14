package com.socure.docv.capturesdk.feature.consent.ui;

import android.os.Bundle;
import androidx.navigation.NavArgs;
import java.util.HashMap;

/* loaded from: classes5.dex */
public class a implements NavArgs {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f430a = new HashMap();

    public static a fromBundle(Bundle bundle) {
        a aVar = new a();
        bundle.setClassLoader(a.class.getClassLoader());
        if (!bundle.containsKey("privacyPolicyLink")) {
            throw new IllegalArgumentException("Required argument \"privacyPolicyLink\" is missing and does not have an android:defaultValue");
        }
        String string = bundle.getString("privacyPolicyLink");
        if (string == null) {
            throw new IllegalArgumentException("Argument \"privacyPolicyLink\" is marked as non-null but was passed a null value.");
        }
        aVar.f430a.put("privacyPolicyLink", string);
        if (!bundle.containsKey("closeContentDescription")) {
            throw new IllegalArgumentException("Required argument \"closeContentDescription\" is missing and does not have an android:defaultValue");
        }
        String string2 = bundle.getString("closeContentDescription");
        if (string2 == null) {
            throw new IllegalArgumentException("Argument \"closeContentDescription\" is marked as non-null but was passed a null value.");
        }
        aVar.f430a.put("closeContentDescription", string2);
        return aVar;
    }

    public String a() {
        return (String) this.f430a.get("closeContentDescription");
    }

    public String b() {
        return (String) this.f430a.get("privacyPolicyLink");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f430a.containsKey("privacyPolicyLink") != aVar.f430a.containsKey("privacyPolicyLink")) {
            return false;
        }
        if (b() == null ? aVar.b() != null : !b().equals(aVar.b())) {
            return false;
        }
        if (this.f430a.containsKey("closeContentDescription") != aVar.f430a.containsKey("closeContentDescription")) {
            return false;
        }
        return a() == null ? aVar.a() == null : a().equals(aVar.a());
    }

    public int hashCode() {
        return (((b() != null ? b().hashCode() : 0) + 31) * 31) + (a() != null ? a().hashCode() : 0);
    }

    public String toString() {
        return "ConsentDialogArgs{privacyPolicyLink=" + b() + ", closeContentDescription=" + a() + "}";
    }
}
