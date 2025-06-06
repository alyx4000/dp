package com.facebook.drawee.controller;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.MotionEvent;
import com.amplitude.reactnative.DatabaseConstants;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.components.RetryManager;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.gestures.GestureDetector;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import com.facebook.fresco.middleware.MiddlewareUtils;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.ui.common.ForwardingControllerListener2;
import com.facebook.fresco.ui.common.LoggingListener;
import com.facebook.fresco.ui.common.OnFadeListener;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class AbstractDraweeController<T, INFO> implements DraweeController, DeferredReleaser.Releasable, GestureDetector.ClickListener {
    private static final Map<String, Object> COMPONENT_EXTRAS = ImmutableMap.of("component_tag", "drawee");
    private static final Map<String, Object> SHORTCUT_EXTRAS = ImmutableMap.of("origin", "memory_bitmap", "origin_sub", "shortcut");
    private static final Class<?> TAG = AbstractDraweeController.class;
    private Object mCallerContext;

    @Nullable
    private String mContentDescription;

    @Nullable
    protected ControllerListener<INFO> mControllerListener;

    @Nullable
    private Drawable mControllerOverlay;

    @Nullable
    private ControllerViewportVisibilityListener mControllerViewportVisibilityListener;

    @Nullable
    private DataSource<T> mDataSource;
    private final DeferredReleaser mDeferredReleaser;

    @Nullable
    protected Drawable mDrawable;

    @Nullable
    private T mFetchedImage;

    @Nullable
    private GestureDetector mGestureDetector;
    private boolean mHasFetchFailed;
    private String mId;
    private boolean mIsAttached;
    private boolean mIsRequestSubmitted;
    private boolean mIsVisibleInViewportHint;

    @Nullable
    protected LoggingListener mLoggingListener;
    private boolean mRetainImageOnFailure;

    @Nullable
    private RetryManager mRetryManager;

    @Nullable
    private SettableDraweeHierarchy mSettableDraweeHierarchy;
    private final Executor mUiThreadImmediateExecutor;
    private final DraweeEventTracker mEventTracker = DraweeEventTracker.newInstance();
    protected ForwardingControllerListener2<INFO> mControllerListener2 = new ForwardingControllerListener2<>();
    private boolean mJustConstructed = true;
    private boolean mLogWithHighSamplingRate = false;

    protected abstract Drawable createDrawable(T t);

    @Nullable
    protected T getCachedImage() {
        return null;
    }

    protected abstract DataSource<T> getDataSource();

    @Nullable
    protected abstract INFO getImageInfo(T t);

    @Nullable
    protected Uri getMainUri() {
        return null;
    }

    @Nullable
    public abstract Map<String, Object> obtainExtrasFromImage(INFO info);

    protected void onImageLoadedFromCacheImmediately(String str, T t) {
    }

    protected abstract void releaseDrawable(@Nullable Drawable drawable);

    protected abstract void releaseImage(@Nullable T t);

    private static class InternalForwardingListener<INFO> extends ForwardingControllerListener<INFO> {
        private InternalForwardingListener() {
        }

        public static <INFO> InternalForwardingListener<INFO> createInternal(ControllerListener<? super INFO> controllerListener, ControllerListener<? super INFO> controllerListener2) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("AbstractDraweeController#createInternal");
            }
            InternalForwardingListener<INFO> internalForwardingListener = new InternalForwardingListener<>();
            internalForwardingListener.addListener(controllerListener);
            internalForwardingListener.addListener(controllerListener2);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            return internalForwardingListener;
        }
    }

    public AbstractDraweeController(DeferredReleaser deferredReleaser, Executor executor, String str, Object obj) {
        this.mDeferredReleaser = deferredReleaser;
        this.mUiThreadImmediateExecutor = executor;
        init(str, obj);
    }

    protected void initialize(String str, Object obj) {
        init(str, obj);
        this.mJustConstructed = false;
        this.mLogWithHighSamplingRate = false;
    }

    private synchronized void init(String str, Object obj) {
        DeferredReleaser deferredReleaser;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("AbstractDraweeController#init");
        }
        this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_INIT_CONTROLLER);
        if (!this.mJustConstructed && (deferredReleaser = this.mDeferredReleaser) != null) {
            deferredReleaser.cancelDeferredRelease(this);
        }
        this.mIsAttached = false;
        this.mIsVisibleInViewportHint = false;
        releaseFetch();
        this.mRetainImageOnFailure = false;
        RetryManager retryManager = this.mRetryManager;
        if (retryManager != null) {
            retryManager.init();
        }
        GestureDetector gestureDetector = this.mGestureDetector;
        if (gestureDetector != null) {
            gestureDetector.init();
            this.mGestureDetector.setClickListener(this);
        }
        ControllerListener<INFO> controllerListener = this.mControllerListener;
        if (controllerListener instanceof InternalForwardingListener) {
            ((InternalForwardingListener) controllerListener).clearListeners();
        } else {
            this.mControllerListener = null;
        }
        this.mControllerViewportVisibilityListener = null;
        SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
        if (settableDraweeHierarchy != null) {
            settableDraweeHierarchy.reset();
            this.mSettableDraweeHierarchy.setControllerOverlay(null);
            this.mSettableDraweeHierarchy = null;
        }
        this.mControllerOverlay = null;
        if (FLog.isLoggable(2)) {
            FLog.v(TAG, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.mId, str);
        }
        this.mId = str;
        this.mCallerContext = obj;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
        if (this.mLoggingListener != null) {
            setUpLoggingListener();
        }
    }

    @Override // com.facebook.drawee.components.DeferredReleaser.Releasable
    public void release() {
        this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_RELEASE_CONTROLLER);
        RetryManager retryManager = this.mRetryManager;
        if (retryManager != null) {
            retryManager.reset();
        }
        GestureDetector gestureDetector = this.mGestureDetector;
        if (gestureDetector != null) {
            gestureDetector.reset();
        }
        SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
        if (settableDraweeHierarchy != null) {
            settableDraweeHierarchy.reset();
        }
        releaseFetch();
    }

    private void releaseFetch() {
        Map<String, Object> map;
        boolean z = this.mIsRequestSubmitted;
        this.mIsRequestSubmitted = false;
        this.mHasFetchFailed = false;
        DataSource<T> dataSource = this.mDataSource;
        Map<String, Object> map2 = null;
        if (dataSource != null) {
            map = dataSource.getExtras();
            this.mDataSource.close();
            this.mDataSource = null;
        } else {
            map = null;
        }
        Drawable drawable = this.mDrawable;
        if (drawable != null) {
            releaseDrawable(drawable);
        }
        if (this.mContentDescription != null) {
            this.mContentDescription = null;
        }
        this.mDrawable = null;
        T t = this.mFetchedImage;
        if (t != null) {
            Map<String, Object> obtainExtrasFromImage = obtainExtrasFromImage(getImageInfo(t));
            logMessageAndImage("release", this.mFetchedImage);
            releaseImage(this.mFetchedImage);
            this.mFetchedImage = null;
            map2 = obtainExtrasFromImage;
        }
        if (z) {
            reportRelease(map, map2);
        }
    }

    public String getId() {
        return this.mId;
    }

    public Object getCallerContext() {
        return this.mCallerContext;
    }

    protected RetryManager getRetryManager() {
        if (this.mRetryManager == null) {
            this.mRetryManager = new RetryManager();
        }
        return this.mRetryManager;
    }

    @Nullable
    protected GestureDetector getGestureDetector() {
        return this.mGestureDetector;
    }

    protected void setGestureDetector(@Nullable GestureDetector gestureDetector) {
        this.mGestureDetector = gestureDetector;
        if (gestureDetector != null) {
            gestureDetector.setClickListener(this);
        }
    }

    protected void setRetainImageOnFailure(boolean z) {
        this.mRetainImageOnFailure = z;
    }

    protected boolean isLogWithHighSamplingRate() {
        return this.mLogWithHighSamplingRate;
    }

    protected void setLogWithHighSamplingRate(boolean z) {
        this.mLogWithHighSamplingRate = z;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    @Nullable
    public String getContentDescription() {
        return this.mContentDescription;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void setContentDescription(@Nullable String str) {
        this.mContentDescription = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void addControllerListener(ControllerListener<? super INFO> controllerListener) {
        Preconditions.checkNotNull(controllerListener);
        ControllerListener<INFO> controllerListener2 = this.mControllerListener;
        if (controllerListener2 instanceof InternalForwardingListener) {
            ((InternalForwardingListener) controllerListener2).addListener(controllerListener);
        } else if (controllerListener2 != null) {
            this.mControllerListener = InternalForwardingListener.createInternal(controllerListener2, controllerListener);
        } else {
            this.mControllerListener = controllerListener;
        }
    }

    public void addControllerListener2(ControllerListener2<INFO> controllerListener2) {
        this.mControllerListener2.addListener(controllerListener2);
    }

    public void removeControllerListener2(ControllerListener2<INFO> controllerListener2) {
        this.mControllerListener2.removeListener(controllerListener2);
    }

    public void setLoggingListener(LoggingListener loggingListener) {
        this.mLoggingListener = loggingListener;
    }

    @Nullable
    protected LoggingListener getLoggingListener() {
        return this.mLoggingListener;
    }

    public void removeControllerListener(ControllerListener<? super INFO> controllerListener) {
        Preconditions.checkNotNull(controllerListener);
        ControllerListener<INFO> controllerListener2 = this.mControllerListener;
        if (controllerListener2 instanceof InternalForwardingListener) {
            ((InternalForwardingListener) controllerListener2).removeListener(controllerListener);
        } else if (controllerListener2 == controllerListener) {
            this.mControllerListener = null;
        }
    }

    protected ControllerListener<INFO> getControllerListener() {
        ControllerListener<INFO> controllerListener = this.mControllerListener;
        return controllerListener == null ? BaseControllerListener.getNoOpListener() : controllerListener;
    }

    protected ControllerListener2<INFO> getControllerListener2() {
        return this.mControllerListener2;
    }

    public void setControllerViewportVisibilityListener(@Nullable ControllerViewportVisibilityListener controllerViewportVisibilityListener) {
        this.mControllerViewportVisibilityListener = controllerViewportVisibilityListener;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    @Nullable
    public DraweeHierarchy getHierarchy() {
        return this.mSettableDraweeHierarchy;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void setHierarchy(@Nullable DraweeHierarchy draweeHierarchy) {
        if (FLog.isLoggable(2)) {
            FLog.v(TAG, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, draweeHierarchy);
        }
        this.mEventTracker.recordEvent(draweeHierarchy != null ? DraweeEventTracker.Event.ON_SET_HIERARCHY : DraweeEventTracker.Event.ON_CLEAR_HIERARCHY);
        if (this.mIsRequestSubmitted) {
            this.mDeferredReleaser.cancelDeferredRelease(this);
            release();
        }
        SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
        if (settableDraweeHierarchy != null) {
            settableDraweeHierarchy.setControllerOverlay(null);
            this.mSettableDraweeHierarchy = null;
        }
        if (draweeHierarchy != null) {
            Preconditions.checkArgument(Boolean.valueOf(draweeHierarchy instanceof SettableDraweeHierarchy));
            SettableDraweeHierarchy settableDraweeHierarchy2 = (SettableDraweeHierarchy) draweeHierarchy;
            this.mSettableDraweeHierarchy = settableDraweeHierarchy2;
            settableDraweeHierarchy2.setControllerOverlay(this.mControllerOverlay);
        }
        if (this.mLoggingListener != null) {
            setUpLoggingListener();
        }
    }

    private void setUpLoggingListener() {
        SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
        if (settableDraweeHierarchy instanceof GenericDraweeHierarchy) {
            ((GenericDraweeHierarchy) settableDraweeHierarchy).setOnFadeListener(new OnFadeListener() { // from class: com.facebook.drawee.controller.AbstractDraweeController.1
                @Override // com.facebook.fresco.ui.common.OnFadeListener
                public void onShownImmediately() {
                }

                @Override // com.facebook.fresco.ui.common.OnFadeListener
                public void onFadeFinished() {
                    if (AbstractDraweeController.this.mLoggingListener != null) {
                        AbstractDraweeController.this.mLoggingListener.onFadeFinished(AbstractDraweeController.this.mId);
                    }
                }

                @Override // com.facebook.fresco.ui.common.OnFadeListener
                public void onFadeStarted() {
                    if (AbstractDraweeController.this.mLoggingListener != null) {
                        AbstractDraweeController.this.mLoggingListener.onFadeStarted(AbstractDraweeController.this.mId);
                    }
                }
            });
        }
    }

    protected void setControllerOverlay(@Nullable Drawable drawable) {
        this.mControllerOverlay = drawable;
        SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
        if (settableDraweeHierarchy != null) {
            settableDraweeHierarchy.setControllerOverlay(drawable);
        }
    }

    @Nullable
    protected Drawable getControllerOverlay() {
        return this.mControllerOverlay;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void onAttach() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("AbstractDraweeController#onAttach");
        }
        if (FLog.isLoggable(2)) {
            FLog.v(TAG, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, this.mIsRequestSubmitted ? "request already submitted" : "request needs submit");
        }
        this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        Preconditions.checkNotNull(this.mSettableDraweeHierarchy);
        this.mDeferredReleaser.cancelDeferredRelease(this);
        this.mIsAttached = true;
        if (!this.mIsRequestSubmitted) {
            submitRequest();
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void onDetach() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("AbstractDraweeController#onDetach");
        }
        if (FLog.isLoggable(2)) {
            FLog.v(TAG, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
        this.mIsAttached = false;
        this.mDeferredReleaser.scheduleDeferredRelease(this);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void onViewportVisibilityHint(boolean z) {
        ControllerViewportVisibilityListener controllerViewportVisibilityListener = this.mControllerViewportVisibilityListener;
        if (controllerViewportVisibilityListener != null) {
            if (z && !this.mIsVisibleInViewportHint) {
                controllerViewportVisibilityListener.onDraweeViewportEntry(this.mId);
            } else if (!z && this.mIsVisibleInViewportHint) {
                controllerViewportVisibilityListener.onDraweeViewportExit(this.mId);
            }
        }
        this.mIsVisibleInViewportHint = z;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (FLog.isLoggable(2)) {
            FLog.v(TAG, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.mId, motionEvent);
        }
        GestureDetector gestureDetector = this.mGestureDetector;
        if (gestureDetector == null) {
            return false;
        }
        if (!gestureDetector.isCapturingGesture() && !shouldHandleGesture()) {
            return false;
        }
        this.mGestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    protected boolean shouldHandleGesture() {
        return shouldRetryOnTap();
    }

    private boolean shouldRetryOnTap() {
        RetryManager retryManager;
        return this.mHasFetchFailed && (retryManager = this.mRetryManager) != null && retryManager.shouldRetryOnTap();
    }

    @Override // com.facebook.drawee.gestures.GestureDetector.ClickListener
    public boolean onClick() {
        if (FLog.isLoggable(2)) {
            FLog.v(TAG, "controller %x %s: onClick", Integer.valueOf(System.identityHashCode(this)), this.mId);
        }
        if (!shouldRetryOnTap()) {
            return false;
        }
        this.mRetryManager.notifyTapToRetry();
        this.mSettableDraweeHierarchy.reset();
        submitRequest();
        return true;
    }

    protected void submitRequest() {
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("AbstractDraweeController#submitRequest");
        }
        T cachedImage = getCachedImage();
        if (cachedImage != null) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("AbstractDraweeController#submitRequest->cache");
            }
            this.mDataSource = null;
            this.mIsRequestSubmitted = true;
            this.mHasFetchFailed = false;
            this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_SUBMIT_CACHE_HIT);
            reportSubmit(this.mDataSource, getImageInfo(cachedImage));
            onImageLoadedFromCacheImmediately(this.mId, cachedImage);
            onNewResultInternal(this.mId, this.mDataSource, cachedImage, 1.0f, true, true, true);
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
                return;
            }
            return;
        }
        this.mEventTracker.recordEvent(DraweeEventTracker.Event.ON_DATASOURCE_SUBMIT);
        this.mSettableDraweeHierarchy.setProgress(0.0f, true);
        this.mIsRequestSubmitted = true;
        this.mHasFetchFailed = false;
        DataSource<T> dataSource = getDataSource();
        this.mDataSource = dataSource;
        reportSubmit(dataSource, null);
        if (FLog.isLoggable(2)) {
            FLog.v(TAG, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.mId, Integer.valueOf(System.identityHashCode(this.mDataSource)));
        }
        final String str = this.mId;
        final boolean hasResult = this.mDataSource.hasResult();
        this.mDataSource.subscribe(new BaseDataSubscriber<T>() { // from class: com.facebook.drawee.controller.AbstractDraweeController.2
            @Override // com.facebook.datasource.BaseDataSubscriber
            public void onNewResultImpl(DataSource<T> dataSource2) {
                boolean isFinished = dataSource2.isFinished();
                boolean hasMultipleResults = dataSource2.hasMultipleResults();
                float progress = dataSource2.getProgress();
                T result = dataSource2.getResult();
                if (result != null) {
                    AbstractDraweeController.this.onNewResultInternal(str, dataSource2, result, progress, isFinished, hasResult, hasMultipleResults);
                } else if (isFinished) {
                    AbstractDraweeController.this.onFailureInternal(str, dataSource2, new NullPointerException(), true);
                }
            }

            @Override // com.facebook.datasource.BaseDataSubscriber
            public void onFailureImpl(DataSource<T> dataSource2) {
                AbstractDraweeController.this.onFailureInternal(str, dataSource2, dataSource2.getFailureCause(), true);
            }

            @Override // com.facebook.datasource.BaseDataSubscriber, com.facebook.datasource.DataSubscriber
            public void onProgressUpdate(DataSource<T> dataSource2) {
                boolean isFinished = dataSource2.isFinished();
                AbstractDraweeController.this.onProgressUpdateInternal(str, dataSource2, dataSource2.getProgress(), isFinished);
            }
        }, this.mUiThreadImmediateExecutor);
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onNewResultInternal(String str, DataSource<T> dataSource, @Nullable T t, float f, boolean z, boolean z2, boolean z3) {
        try {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("AbstractDraweeController#onNewResultInternal");
            }
            if (!isExpectedDataSource(str, dataSource)) {
                logMessageAndImage("ignore_old_datasource @ onNewResult", t);
                releaseImage(t);
                dataSource.close();
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                    return;
                }
                return;
            }
            this.mEventTracker.recordEvent(z ? DraweeEventTracker.Event.ON_DATASOURCE_RESULT : DraweeEventTracker.Event.ON_DATASOURCE_RESULT_INT);
            try {
                Drawable createDrawable = createDrawable(t);
                T t2 = this.mFetchedImage;
                Drawable drawable = this.mDrawable;
                this.mFetchedImage = t;
                this.mDrawable = createDrawable;
                try {
                    if (z) {
                        logMessageAndImage("set_final_result @ onNewResult", t);
                        this.mDataSource = null;
                        getSettableDraweeHierarchy().setImage(createDrawable, 1.0f, z2);
                        reportSuccess(str, t, dataSource);
                    } else if (z3) {
                        logMessageAndImage("set_temporary_result @ onNewResult", t);
                        getSettableDraweeHierarchy().setImage(createDrawable, 1.0f, z2);
                        reportSuccess(str, t, dataSource);
                    } else {
                        logMessageAndImage("set_intermediate_result @ onNewResult", t);
                        getSettableDraweeHierarchy().setImage(createDrawable, f, z2);
                        reportIntermediateSet(str, t);
                    }
                    if (drawable != null && drawable != createDrawable) {
                        releaseDrawable(drawable);
                    }
                    if (t2 != null && t2 != t) {
                        logMessageAndImage("release_previous_result @ onNewResult", t2);
                        releaseImage(t2);
                    }
                    if (FrescoSystrace.isTracing()) {
                        FrescoSystrace.endSection();
                    }
                } catch (Throwable th) {
                    if (drawable != null && drawable != createDrawable) {
                        releaseDrawable(drawable);
                    }
                    if (t2 != null && t2 != t) {
                        logMessageAndImage("release_previous_result @ onNewResult", t2);
                        releaseImage(t2);
                    }
                    throw th;
                }
            } catch (Exception e) {
                logMessageAndImage("drawable_failed @ onNewResult", t);
                releaseImage(t);
                onFailureInternal(str, dataSource, e, z);
                if (FrescoSystrace.isTracing()) {
                    FrescoSystrace.endSection();
                }
            }
        } catch (Throwable th2) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onFailureInternal(String str, DataSource<T> dataSource, Throwable th, boolean z) {
        Drawable drawable;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("AbstractDraweeController#onFailureInternal");
        }
        if (!isExpectedDataSource(str, dataSource)) {
            logMessageAndFailure("ignore_old_datasource @ onFailure", th);
            dataSource.close();
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
                return;
            }
            return;
        }
        this.mEventTracker.recordEvent(z ? DraweeEventTracker.Event.ON_DATASOURCE_FAILURE : DraweeEventTracker.Event.ON_DATASOURCE_FAILURE_INT);
        if (z) {
            logMessageAndFailure("final_failed @ onFailure", th);
            this.mDataSource = null;
            this.mHasFetchFailed = true;
            SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
            if (settableDraweeHierarchy != null) {
                if (this.mRetainImageOnFailure && (drawable = this.mDrawable) != null) {
                    settableDraweeHierarchy.setImage(drawable, 1.0f, true);
                } else if (shouldRetryOnTap()) {
                    settableDraweeHierarchy.setRetry(th);
                } else {
                    settableDraweeHierarchy.setFailure(th);
                }
            }
            reportFailure(th, dataSource);
        } else {
            logMessageAndFailure("intermediate_failed @ onFailure", th);
            reportIntermediateFailure(th);
        }
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProgressUpdateInternal(String str, DataSource<T> dataSource, float f, boolean z) {
        if (!isExpectedDataSource(str, dataSource)) {
            logMessageAndFailure("ignore_old_datasource @ onProgress", null);
            dataSource.close();
        } else {
            if (z) {
                return;
            }
            this.mSettableDraweeHierarchy.setProgress(f, false);
        }
    }

    private boolean isExpectedDataSource(String str, DataSource<T> dataSource) {
        if (dataSource == null && this.mDataSource == null) {
            return true;
        }
        return str.equals(this.mId) && dataSource == this.mDataSource && this.mIsRequestSubmitted;
    }

    private void logMessageAndImage(String str, T t) {
        if (FLog.isLoggable(2)) {
            FLog.v(TAG, "controller %x %s: %s: image: %s %x", Integer.valueOf(System.identityHashCode(this)), this.mId, str, getImageClass(t), Integer.valueOf(getImageHash(t)));
        }
    }

    private void logMessageAndFailure(String str, Throwable th) {
        if (FLog.isLoggable(2)) {
            FLog.v(TAG, "controller %x %s: %s: failure: %s", Integer.valueOf(System.identityHashCode(this)), this.mId, str, th);
        }
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    @Nullable
    public Animatable getAnimatable() {
        Object obj = this.mDrawable;
        if (obj instanceof Animatable) {
            return (Animatable) obj;
        }
        return null;
    }

    protected String getImageClass(@Nullable T t) {
        return t != null ? t.getClass().getSimpleName() : "<null>";
    }

    protected int getImageHash(@Nullable T t) {
        return System.identityHashCode(t);
    }

    public String toString() {
        return Objects.toStringHelper(this).add("isAttached", this.mIsAttached).add("isRequestSubmitted", this.mIsRequestSubmitted).add("hasFetchFailed", this.mHasFetchFailed).add("fetchedImage", getImageHash(this.mFetchedImage)).add(DatabaseConstants.EVENT_TABLE_NAME, this.mEventTracker.toString()).toString();
    }

    protected void reportSubmit(DataSource<T> dataSource, @Nullable INFO info) {
        getControllerListener().onSubmit(this.mId, this.mCallerContext);
        getControllerListener2().onSubmit(this.mId, this.mCallerContext, obtainExtras(dataSource, (DataSource<T>) info, getMainUri()));
    }

    private void reportIntermediateSet(String str, @Nullable T t) {
        INFO imageInfo = getImageInfo(t);
        getControllerListener().onIntermediateImageSet(str, imageInfo);
        getControllerListener2().onIntermediateImageSet(str, imageInfo);
    }

    private void reportIntermediateFailure(Throwable th) {
        getControllerListener().onIntermediateImageFailed(this.mId, th);
        getControllerListener2().onIntermediateImageFailed(this.mId);
    }

    private void reportSuccess(String str, @Nullable T t, @Nullable DataSource<T> dataSource) {
        INFO imageInfo = getImageInfo(t);
        getControllerListener().onFinalImageSet(str, imageInfo, getAnimatable());
        getControllerListener2().onFinalImageSet(str, imageInfo, obtainExtras(dataSource, (DataSource<T>) imageInfo, (Uri) null));
    }

    private void reportFailure(Throwable th, @Nullable DataSource<T> dataSource) {
        ControllerListener2.Extras obtainExtras = obtainExtras(dataSource, (DataSource<T>) null, (Uri) null);
        getControllerListener().onFailure(this.mId, th);
        getControllerListener2().onFailure(this.mId, th, obtainExtras);
    }

    private void reportRelease(@Nullable Map<String, Object> map, @Nullable Map<String, Object> map2) {
        getControllerListener().onRelease(this.mId);
        getControllerListener2().onRelease(this.mId, obtainExtras(map, map2, (Uri) null));
    }

    private ControllerListener2.Extras obtainExtras(@Nullable Map<String, Object> map, @Nullable Map<String, Object> map2, @Nullable Uri uri) {
        String str;
        PointF pointF;
        SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
        if (settableDraweeHierarchy instanceof GenericDraweeHierarchy) {
            GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) settableDraweeHierarchy;
            String valueOf = String.valueOf(genericDraweeHierarchy.getActualImageScaleType());
            pointF = genericDraweeHierarchy.getActualImageFocusPoint();
            str = valueOf;
        } else {
            str = null;
            pointF = null;
        }
        return MiddlewareUtils.obtainExtras(COMPONENT_EXTRAS, SHORTCUT_EXTRAS, map, null, getDimensions(), str, pointF, map2, getCallerContext(), isLogWithHighSamplingRate(), uri);
    }

    private ControllerListener2.Extras obtainExtras(@Nullable DataSource<T> dataSource, @Nullable INFO info, @Nullable Uri uri) {
        return obtainExtras(dataSource == null ? null : dataSource.getExtras(), obtainExtrasFromImage(info), uri);
    }

    @Nullable
    private Rect getDimensions() {
        SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
        if (settableDraweeHierarchy == null) {
            return null;
        }
        return settableDraweeHierarchy.getBounds();
    }

    private SettableDraweeHierarchy getSettableDraweeHierarchy() {
        SettableDraweeHierarchy settableDraweeHierarchy = this.mSettableDraweeHierarchy;
        if (settableDraweeHierarchy != null) {
            return settableDraweeHierarchy;
        }
        throw new IllegalStateException("mSettableDraweeHierarchy is null; Caller context: " + this.mCallerContext);
    }
}
