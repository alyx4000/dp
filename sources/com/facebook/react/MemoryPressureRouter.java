package com.facebook.react;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import com.facebook.react.bridge.MemoryPressureListener;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class MemoryPressureRouter implements ComponentCallbacks2 {
    private final Set<MemoryPressureListener> mListeners = Collections.synchronizedSet(new LinkedHashSet());

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    public MemoryPressureRouter(Context context) {
        context.getApplicationContext().registerComponentCallbacks(this);
    }

    public void destroy(Context context) {
        context.getApplicationContext().unregisterComponentCallbacks(this);
    }

    public void addMemoryPressureListener(MemoryPressureListener memoryPressureListener) {
        this.mListeners.add(memoryPressureListener);
    }

    public void removeMemoryPressureListener(MemoryPressureListener memoryPressureListener) {
        this.mListeners.remove(memoryPressureListener);
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        dispatchMemoryPressure(i);
    }

    private void dispatchMemoryPressure(int i) {
        Set<MemoryPressureListener> set = this.mListeners;
        for (MemoryPressureListener memoryPressureListener : (MemoryPressureListener[]) set.toArray(new MemoryPressureListener[set.size()])) {
            memoryPressureListener.handleMemoryPressure(i);
        }
    }
}
