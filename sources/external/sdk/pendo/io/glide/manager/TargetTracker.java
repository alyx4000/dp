package external.sdk.pendo.io.glide.manager;

import external.sdk.pendo.io.glide.request.target.Target;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import sdk.pendo.io.c0.i;
import sdk.pendo.io.i0.k;

/* loaded from: classes2.dex */
public final class TargetTracker implements i {
    private final Set<Target<?>> targets = Collections.newSetFromMap(new WeakHashMap());

    public void clear() {
        this.targets.clear();
    }

    public List<Target<?>> getAll() {
        return k.a(this.targets);
    }

    @Override // sdk.pendo.io.c0.i
    public void onDestroy() {
        Iterator it = k.a(this.targets).iterator();
        while (it.hasNext()) {
            ((Target) it.next()).onDestroy();
        }
    }

    @Override // sdk.pendo.io.c0.i
    public void onStart() {
        Iterator it = k.a(this.targets).iterator();
        while (it.hasNext()) {
            ((Target) it.next()).onStart();
        }
    }

    @Override // sdk.pendo.io.c0.i
    public void onStop() {
        Iterator it = k.a(this.targets).iterator();
        while (it.hasNext()) {
            ((Target) it.next()).onStop();
        }
    }

    public void track(Target<?> target) {
        this.targets.add(target);
    }

    public void untrack(Target<?> target) {
        this.targets.remove(target);
    }
}
