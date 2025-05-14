package expo.modules.updates;

import android.content.Context;
import expo.modules.kotlin.Promise;
import expo.modules.updates.UpdatesModule;
import kotlin.Metadata;

/* compiled from: UpdatesModule.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
final class UpdatesModule$definition$1$8$1 implements Runnable {
    final /* synthetic */ long $maxAge;
    final /* synthetic */ Promise $promise;
    final /* synthetic */ UpdatesModule this$0;

    UpdatesModule$definition$1$8$1(Promise promise, UpdatesModule updatesModule, long j) {
        this.$promise = promise;
        this.this$0 = updatesModule;
        this.$maxAge = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Promise promise = this.$promise;
        UpdatesModule.Companion companion = UpdatesModule.INSTANCE;
        context = this.this$0.getContext();
        promise.resolve(companion.readLogEntries$expo_updates_release(context, this.$maxAge));
    }
}
