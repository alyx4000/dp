package com.swmansion.reanimated.layoutReanimation;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.layoutanimation.LayoutAnimationController;
import com.facebook.react.uimanager.layoutanimation.LayoutAnimationListener;
import com.swmansion.reanimated.ReanimatedModule;
import com.swmansion.rnscreens.ScreenStackViewManager;
import com.swmansion.rnscreens.ScreenViewManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* compiled from: ReanimatedNativeHierarchyManager.java */
/* loaded from: classes5.dex */
class ReaLayoutAnimator extends LayoutAnimationController {
    private final ReactApplicationContext mContext;
    private final WeakReference<NativeViewHierarchyManager> mWeakNativeViewHierarchyManager;
    private AnimationsManager mAnimationsManager = null;
    private volatile boolean mInitialized = false;
    private final ArrayList<View> viewsToSnapshot = new ArrayList<>();

    ReaLayoutAnimator(ReactApplicationContext reactApplicationContext, NativeViewHierarchyManager nativeViewHierarchyManager) {
        this.mContext = reactApplicationContext;
        this.mWeakNativeViewHierarchyManager = new WeakReference<>(nativeViewHierarchyManager);
    }

    public void maybeInit() {
        if (this.mInitialized) {
            return;
        }
        this.mInitialized = true;
        AnimationsManager animationsManager = ((ReanimatedModule) this.mContext.getNativeModule(ReanimatedModule.class)).getNodesManager().getAnimationsManager();
        this.mAnimationsManager = animationsManager;
        animationsManager.setReanimatedNativeHierarchyManager((ReanimatedNativeHierarchyManager) this.mWeakNativeViewHierarchyManager.get());
    }

    @Override // com.facebook.react.uimanager.layoutanimation.LayoutAnimationController
    public boolean shouldAnimateLayout(View view) {
        if (isLayoutAnimationEnabled()) {
            return (view == null || view.getParent() == null) ? false : true;
        }
        return super.shouldAnimateLayout(view);
    }

    @Override // com.facebook.react.uimanager.layoutanimation.LayoutAnimationController
    public void reset() {
        super.reset();
        Iterator<View> it = this.viewsToSnapshot.iterator();
        while (it.hasNext()) {
            View next = it.next();
            this.mAnimationsManager.onViewCreate(next, (ViewGroup) next.getParent(), new Snapshot(next, this.mWeakNativeViewHierarchyManager.get()));
        }
        this.viewsToSnapshot.clear();
    }

    @Override // com.facebook.react.uimanager.layoutanimation.LayoutAnimationController
    public void applyLayoutUpdate(View view, int i, int i2, int i3, int i4) {
        if (!isLayoutAnimationEnabled()) {
            super.applyLayoutUpdate(view, i, i2, i3, i4);
            return;
        }
        UiThreadUtil.assertOnUiThread();
        maybeInit();
        if (view.getWidth() == 0 || view.getHeight() == 0) {
            if (!this.mAnimationsManager.hasAnimationForTag(view.getId(), 1)) {
                super.applyLayoutUpdate(view, i, i2, i3, i4);
                this.mAnimationsManager.maybeRegisterSharedView(view);
                return;
            } else {
                view.layout(i, i2, i3 + i, i4 + i2);
                if (view.getId() != -1) {
                    this.viewsToSnapshot.add(view);
                    return;
                }
                return;
            }
        }
        Snapshot snapshot = new Snapshot(view, this.mWeakNativeViewHierarchyManager.get());
        view.layout(i, i2, i3 + i, i4 + i2);
        this.mAnimationsManager.onViewUpdate(view, snapshot, new Snapshot(view, this.mWeakNativeViewHierarchyManager.get()));
    }

    @Override // com.facebook.react.uimanager.layoutanimation.LayoutAnimationController
    public void deleteView(View view, final LayoutAnimationListener layoutAnimationListener) {
        if (!isLayoutAnimationEnabled()) {
            super.deleteView(view, layoutAnimationListener);
            return;
        }
        UiThreadUtil.assertOnUiThread();
        NativeViewHierarchyManager nativeViewHierarchyManager = this.mWeakNativeViewHierarchyManager.get();
        try {
            if (nativeViewHierarchyManager.resolveViewManager(view.getId()).getName().equals(ScreenViewManager.REACT_CLASS) && view.getParent() != null && (view.getParent().getParent() instanceof View)) {
                try {
                    if (nativeViewHierarchyManager.resolveViewManager(((View) view.getParent().getParent()).getId()).getName().equals(ScreenStackViewManager.REACT_CLASS)) {
                        this.mAnimationsManager.cancelAnimationsInSubviews(view);
                        super.deleteView(view, layoutAnimationListener);
                        return;
                    }
                } catch (IllegalViewOperationException e) {
                    e.printStackTrace();
                    this.mAnimationsManager.cancelAnimationsInSubviews(view);
                    super.deleteView(view, layoutAnimationListener);
                    return;
                }
            }
            maybeInit();
            AnimationsManager animationsManager = this.mAnimationsManager;
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            Objects.requireNonNull(layoutAnimationListener);
            animationsManager.onViewRemoval(view, viewGroup, new Runnable() { // from class: com.swmansion.reanimated.layoutReanimation.ReaLayoutAnimator$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    LayoutAnimationListener.this.onAnimationEnd();
                }
            });
        } catch (IllegalViewOperationException e2) {
            e2.printStackTrace();
            this.mAnimationsManager.cancelAnimationsInSubviews(view);
            super.deleteView(view, layoutAnimationListener);
        }
    }

    public boolean isLayoutAnimationEnabled() {
        maybeInit();
        return this.mAnimationsManager.isLayoutAnimationEnabled();
    }

    public AnimationsManager getAnimationsManager() {
        return this.mAnimationsManager;
    }
}
