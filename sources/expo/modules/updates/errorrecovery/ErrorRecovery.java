package expo.modules.updates.errorrecovery;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.DefaultJSExceptionHandler;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.devsupport.DisabledDevSupportManager;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.google.android.gms.location.DeviceOrientationRequest;
import expo.modules.updates.errorrecovery.ErrorRecoveryDelegate;
import expo.modules.updates.logging.UpdatesErrorCode;
import expo.modules.updates.logging.UpdatesLogger;
import io.sentry.SentryEvent;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ErrorRecovery.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 .2\u00020\u0001:\u0001.B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u001a\u001a\u00020\u001bH\u0000¢\u0006\u0002\b\u001cJ\u0019\u0010\u001d\u001a\u00020\u001b2\n\u0010\u001e\u001a\u00060\u001fj\u0002` H\u0000¢\u0006\u0002\b!J\u000e\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$J\u000e\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020'J\b\u0010(\u001a\u00020\u001bH\u0002J\u0010\u0010)\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u0019H\u0002J\u000e\u0010+\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020\u0019J\b\u0010,\u001a\u00020\u001bH\u0002J\b\u0010-\u001a\u00020\u001bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lexpo/modules/updates/errorrecovery/ErrorRecovery;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contentAppearedListener", "Lcom/facebook/react/bridge/ReactMarker$MarkerListener;", "handler", "Landroid/os/Handler;", "getHandler$expo_updates_release", "()Landroid/os/Handler;", "setHandler$expo_updates_release", "(Landroid/os/Handler;)V", "handlerThread", "Landroid/os/HandlerThread;", "getHandlerThread$expo_updates_release", "()Landroid/os/HandlerThread;", SentryEvent.JsonKeys.LOGGER, "Lexpo/modules/updates/logging/UpdatesLogger;", "getLogger$expo_updates_release", "()Lexpo/modules/updates/logging/UpdatesLogger;", "previousExceptionHandler", "Lcom/facebook/react/bridge/DefaultJSExceptionHandler;", "weakReactInstanceManager", "Ljava/lang/ref/WeakReference;", "Lcom/facebook/react/ReactInstanceManager;", "handleContentAppeared", "", "handleContentAppeared$expo_updates_release", "handleException", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "handleException$expo_updates_release", "initialize", "delegate", "Lexpo/modules/updates/errorrecovery/ErrorRecoveryDelegate;", "notifyNewRemoteLoadStatus", "newStatus", "Lexpo/modules/updates/errorrecovery/ErrorRecoveryDelegate$RemoteLoadStatus;", "registerContentAppearedListener", "registerErrorHandler", "reactInstanceManager", "startMonitoring", "unregisterContentAppearedListener", "unregisterErrorHandler", "Companion", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ErrorRecovery {
    private static final String TAG = "ErrorRecovery";
    private final ReactMarker.MarkerListener contentAppearedListener;
    private final Context context;
    public Handler handler;
    private final HandlerThread handlerThread;
    private final UpdatesLogger logger;
    private DefaultJSExceptionHandler previousExceptionHandler;
    private WeakReference<ReactInstanceManager> weakReactInstanceManager;

    public ErrorRecovery(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.handlerThread = new HandlerThread("expo-updates-error-recovery");
        this.logger = new UpdatesLogger(context);
        this.contentAppearedListener = new ReactMarker.MarkerListener() { // from class: expo.modules.updates.errorrecovery.ErrorRecovery$$ExternalSyntheticLambda0
            @Override // com.facebook.react.bridge.ReactMarker.MarkerListener
            public final void logMarker(ReactMarkerConstants reactMarkerConstants, String str, int i) {
                ErrorRecovery.contentAppearedListener$lambda$1(ErrorRecovery.this, reactMarkerConstants, str, i);
            }
        };
    }

    /* renamed from: getHandlerThread$expo_updates_release, reason: from getter */
    public final HandlerThread getHandlerThread() {
        return this.handlerThread;
    }

    public final Handler getHandler$expo_updates_release() {
        Handler handler = this.handler;
        if (handler != null) {
            return handler;
        }
        Intrinsics.throwUninitializedPropertyAccessException("handler");
        return null;
    }

    public final void setHandler$expo_updates_release(Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "<set-?>");
        this.handler = handler;
    }

    /* renamed from: getLogger$expo_updates_release, reason: from getter */
    public final UpdatesLogger getLogger() {
        return this.logger;
    }

    public final void initialize(ErrorRecoveryDelegate delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        if (this.handler == null) {
            this.handlerThread.start();
            Looper looper = this.handlerThread.getLooper();
            Intrinsics.checkNotNullExpressionValue(looper, "handlerThread.looper");
            setHandler$expo_updates_release(new ErrorRecoveryHandler(looper, delegate, this.logger));
        }
    }

    public final void startMonitoring(ReactInstanceManager reactInstanceManager) {
        Intrinsics.checkNotNullParameter(reactInstanceManager, "reactInstanceManager");
        registerContentAppearedListener();
        registerErrorHandler(reactInstanceManager);
    }

    public final void notifyNewRemoteLoadStatus(ErrorRecoveryDelegate.RemoteLoadStatus newStatus) {
        Intrinsics.checkNotNullParameter(newStatus, "newStatus");
        UpdatesLogger.info$default(this.logger, "ErrorRecovery: remote load status changed: " + newStatus, null, 2, null);
        getHandler$expo_updates_release().sendMessage(getHandler$expo_updates_release().obtainMessage(2, newStatus));
    }

    public final void handleException$expo_updates_release(Exception exception) {
        Intrinsics.checkNotNullParameter(exception, "exception");
        this.logger.error("ErrorRecovery: exception encountered: " + exception.getLocalizedMessage(), UpdatesErrorCode.Unknown, exception);
        getHandler$expo_updates_release().sendMessage(getHandler$expo_updates_release().obtainMessage(0, exception));
    }

    public final void handleContentAppeared$expo_updates_release() {
        getHandler$expo_updates_release().sendMessage(getHandler$expo_updates_release().obtainMessage(1));
        unregisterContentAppearedListener();
        getHandler$expo_updates_release().postDelayed(new Runnable() { // from class: expo.modules.updates.errorrecovery.ErrorRecovery$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                ErrorRecovery.handleContentAppeared$lambda$0(ErrorRecovery.this);
            }
        }, DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleContentAppeared$lambda$0(ErrorRecovery this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.unregisterErrorHandler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void contentAppearedListener$lambda$1(ErrorRecovery this$0, ReactMarkerConstants reactMarkerConstants, String str, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (reactMarkerConstants == ReactMarkerConstants.CONTENT_APPEARED) {
            this$0.handleContentAppeared$expo_updates_release();
        }
    }

    private final void registerContentAppearedListener() {
        ReactMarker.addListener(this.contentAppearedListener);
    }

    private final void unregisterContentAppearedListener() {
        ReactMarker.removeListener(this.contentAppearedListener);
    }

    private final void registerErrorHandler(ReactInstanceManager reactInstanceManager) {
        if (!(reactInstanceManager.getDevSupportManager() instanceof DisabledDevSupportManager)) {
            Log.d(TAG, "Unexpected type of ReactInstanceManager.DevSupportManager. expo-updates error recovery will not behave properly.");
            return;
        }
        DevSupportManager devSupportManager = reactInstanceManager.getDevSupportManager();
        Intrinsics.checkNotNull(devSupportManager, "null cannot be cast to non-null type com.facebook.react.devsupport.DisabledDevSupportManager");
        DisabledDevSupportManager disabledDevSupportManager = (DisabledDevSupportManager) devSupportManager;
        DefaultJSExceptionHandler defaultJSExceptionHandler = new DefaultJSExceptionHandler() { // from class: expo.modules.updates.errorrecovery.ErrorRecovery$registerErrorHandler$defaultJSExceptionHandler$1
            @Override // com.facebook.react.bridge.DefaultJSExceptionHandler, com.facebook.react.bridge.JSExceptionHandler
            public void handleException(Exception e) {
                ErrorRecovery errorRecovery = ErrorRecovery.this;
                Intrinsics.checkNotNull(e);
                errorRecovery.handleException$expo_updates_release(e);
            }
        };
        Field declaredField = disabledDevSupportManager.getClass().getDeclaredField("mDefaultJSExceptionHandler");
        declaredField.setAccessible(true);
        Object obj = declaredField.get(disabledDevSupportManager);
        declaredField.set(disabledDevSupportManager, defaultJSExceptionHandler);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.facebook.react.bridge.DefaultJSExceptionHandler");
        this.previousExceptionHandler = (DefaultJSExceptionHandler) obj;
        this.weakReactInstanceManager = new WeakReference<>(reactInstanceManager);
    }

    private final void unregisterErrorHandler() {
        ReactInstanceManager reactInstanceManager;
        WeakReference<ReactInstanceManager> weakReference = this.weakReactInstanceManager;
        if (weakReference != null && (reactInstanceManager = weakReference.get()) != null) {
            if (!(reactInstanceManager.getDevSupportManager() instanceof DisabledDevSupportManager)) {
                Log.d(TAG, "Unexpected type of ReactInstanceManager.DevSupportManager. expo-updates could not unregister its error handler");
                return;
            }
            if (this.previousExceptionHandler == null) {
                return;
            }
            DevSupportManager devSupportManager = reactInstanceManager.getDevSupportManager();
            Intrinsics.checkNotNull(devSupportManager, "null cannot be cast to non-null type com.facebook.react.devsupport.DisabledDevSupportManager");
            DisabledDevSupportManager disabledDevSupportManager = (DisabledDevSupportManager) devSupportManager;
            Field declaredField = disabledDevSupportManager.getClass().getDeclaredField("mDefaultJSExceptionHandler");
            declaredField.setAccessible(true);
            declaredField.set(disabledDevSupportManager, this.previousExceptionHandler);
            this.weakReactInstanceManager = null;
        }
        getHandler$expo_updates_release().postDelayed(new Runnable() { // from class: expo.modules.updates.errorrecovery.ErrorRecovery$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ErrorRecovery.unregisterErrorHandler$lambda$5(ErrorRecovery.this);
            }
        }, DeviceOrientationRequest.OUTPUT_PERIOD_MEDIUM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void unregisterErrorHandler$lambda$5(ErrorRecovery this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.handlerThread.quitSafely();
    }
}
