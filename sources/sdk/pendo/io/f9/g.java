package sdk.pendo.io.f9;

import android.view.View;
import androidx.fragment.app.Fragment;
import io.sentry.protocol.ViewHierarchyNode;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\b\u0010\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0011\u0010\u0012B\u0013\b\u0010\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0011\u0010\u0013B\t\b\u0010¢\u0006\u0004\b\u0011\u0010\u0014J\u000e\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\b\u0010\b\u001a\u0004\u0018\u00010\u0007R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\nR'\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00000\fj\b\u0012\u0004\u0012\u00020\u0000`\r8\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u0004\u0010\u000f¨\u0006\u0015"}, d2 = {"Lsdk/pendo/io/f9/g;", "", "child", "", "a", "Landroidx/fragment/app/Fragment;", "b", "Landroid/view/View;", "c", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", "view", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", ViewHierarchyNode.JsonKeys.CHILDREN, "<init>", "(Landroidx/fragment/app/Fragment;)V", "(Landroid/view/View;)V", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<Object> view;

    /* renamed from: b, reason: from kotlin metadata */
    private final ArrayList<g> children;

    public g() {
        this.children = new ArrayList<>();
        this.view = new WeakReference<>(null);
    }

    public final void a(g child) {
        Intrinsics.checkNotNullParameter(child, "child");
        this.children.add(child);
    }

    public final Fragment b() {
        Object obj = this.view.get();
        if (obj instanceof Fragment) {
            return (Fragment) obj;
        }
        return null;
    }

    public final View c() {
        Object obj = this.view.get();
        if (obj instanceof View) {
            return (View) obj;
        }
        return null;
    }

    public g(View view) {
        this.children = new ArrayList<>();
        this.view = new WeakReference<>(view);
    }

    public final ArrayList<g> a() {
        return this.children;
    }

    public g(Fragment fragment) {
        this.children = new ArrayList<>();
        this.view = new WeakReference<>(fragment);
    }
}
