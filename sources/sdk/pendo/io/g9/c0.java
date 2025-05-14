package sdk.pendo.io.g9;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0001¨\u0006\u0003"}, d2 = {"Landroidx/fragment/app/Fragment;", "", "a", "pendoIO_release"}, k = 2, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class c0 {
    public static final boolean a(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        return fragment.isVisible() && !fragment.isDetached() && !fragment.isRemoving() && fragment.isAdded() && q0.a(fragment.getView(), 1);
    }
}
