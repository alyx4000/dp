package androidx.core.content;

import androidx.core.util.Predicate;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class IntentSanitizer$Builder$$ExternalSyntheticLambda2 implements Predicate {
    public final /* synthetic */ String f$0;

    public /* synthetic */ IntentSanitizer$Builder$$ExternalSyntheticLambda2(String str) {
        this.f$0 = str;
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        boolean equals;
        equals = this.f$0.equals((String) obj);
        return equals;
    }
}
