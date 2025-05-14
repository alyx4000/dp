package expo.modules.adapters.branch;

import android.app.Application;
import android.content.Context;
import expo.modules.core.interfaces.ApplicationLifecycleListener;
import io.branch.rnbranch.RNBranchModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BranchApplicationLifecycleListener.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\f"}, d2 = {"Lexpo/modules/adapters/branch/BranchApplicationLifecycleListener;", "Lexpo/modules/core/interfaces/ApplicationLifecycleListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "setContext", "onCreate", "", "application", "Landroid/app/Application;", "config-plugins-react-native-branch_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BranchApplicationLifecycleListener implements ApplicationLifecycleListener {
    private Context context;

    public BranchApplicationLifecycleListener(Context context) {
        this.context = context;
    }

    public final Context getContext() {
        return this.context;
    }

    public final void setContext(Context context) {
        this.context = context;
    }

    @Override // expo.modules.core.interfaces.ApplicationLifecycleListener
    public void onCreate(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        super.onCreate(application);
        RNBranchModule.getAutoInstance(this.context);
    }
}
