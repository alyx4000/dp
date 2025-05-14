package sdk.pendo.io.t4;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

/* loaded from: classes6.dex */
class x implements b {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f1623a = Pattern.compile("with|and|(?<!padd)in", 2);
    static final x b = new x();

    x() {
    }

    @Override // sdk.pendo.io.t4.b
    public Set<String> a(String str) {
        if (str.indexOf(47) < 0) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        for (String str2 : str.split("/")) {
            if (str2.length() > 0) {
                for (String str3 : f1623a.split(str2)) {
                    if (str3.length() > 0) {
                        hashSet.add(str3);
                    }
                }
            }
        }
        a(hashSet, "SHA1", "SHA-1");
        a(hashSet, "SHA224", McElieceCCA2KeyGenParameterSpec.SHA224);
        a(hashSet, "SHA256", "SHA-256");
        a(hashSet, "SHA384", "SHA-384");
        a(hashSet, "SHA512", "SHA-512");
        return hashSet;
    }

    private static void a(Set<String> set, String str, String str2) {
        boolean contains = set.contains(str);
        if (set.contains(str2) ^ contains) {
            if (contains) {
                str = str2;
            }
            set.add(str);
        }
    }
}
