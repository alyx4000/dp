package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.ApiCompat;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat;
import androidx.camera.core.impl.utils.MainThreadAsyncHandler;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class CameraCaptureSessionCompat {
    private final CameraCaptureSessionCompatImpl mImpl;

    interface CameraCaptureSessionCompatImpl {
        int captureBurstRequests(List<CaptureRequest> list, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

        int captureSingleRequest(CaptureRequest captureRequest, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

        int setRepeatingBurstRequests(List<CaptureRequest> list, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

        int setSingleRepeatingRequest(CaptureRequest captureRequest, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException;

        CameraCaptureSession unwrap();
    }

    private CameraCaptureSessionCompat(CameraCaptureSession cameraCaptureSession, Handler handler) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mImpl = new CameraCaptureSessionCompatApi28Impl(cameraCaptureSession);
        } else {
            this.mImpl = CameraCaptureSessionCompatBaseImpl.create(cameraCaptureSession, handler);
        }
    }

    public static CameraCaptureSessionCompat toCameraCaptureSessionCompat(CameraCaptureSession cameraCaptureSession) {
        return toCameraCaptureSessionCompat(cameraCaptureSession, MainThreadAsyncHandler.getInstance());
    }

    public static CameraCaptureSessionCompat toCameraCaptureSessionCompat(CameraCaptureSession cameraCaptureSession, Handler handler) {
        return new CameraCaptureSessionCompat(cameraCaptureSession, handler);
    }

    public CameraCaptureSession toCameraCaptureSession() {
        return this.mImpl.unwrap();
    }

    public int captureBurstRequests(List<CaptureRequest> list, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return this.mImpl.captureBurstRequests(list, executor, captureCallback);
    }

    public int captureSingleRequest(CaptureRequest captureRequest, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return this.mImpl.captureSingleRequest(captureRequest, executor, captureCallback);
    }

    public int setRepeatingBurstRequests(List<CaptureRequest> list, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return this.mImpl.setRepeatingBurstRequests(list, executor, captureCallback);
    }

    public int setSingleRepeatingRequest(CaptureRequest captureRequest, Executor executor, CameraCaptureSession.CaptureCallback captureCallback) throws CameraAccessException {
        return this.mImpl.setSingleRepeatingRequest(captureRequest, executor, captureCallback);
    }

    static final class CaptureCallbackExecutorWrapper extends CameraCaptureSession.CaptureCallback {
        private final Executor mExecutor;
        final CameraCaptureSession.CaptureCallback mWrappedCallback;

        CaptureCallbackExecutorWrapper(Executor executor, CameraCaptureSession.CaptureCallback captureCallback) {
            this.mExecutor = executor;
            this.mWrappedCallback = captureCallback;
        }

        /* renamed from: lambda$onCaptureStarted$0$androidx-camera-camera2-internal-compat-CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper, reason: not valid java name */
        /* synthetic */ void m96x20bcad62(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j, long j2) {
            this.mWrappedCallback.onCaptureStarted(cameraCaptureSession, captureRequest, j, j2);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureStarted(final CameraCaptureSession cameraCaptureSession, final CaptureRequest captureRequest, final long j, final long j2) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper.this.m96x20bcad62(cameraCaptureSession, captureRequest, j, j2);
                }
            });
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureProgressed(final CameraCaptureSession cameraCaptureSession, final CaptureRequest captureRequest, final CaptureResult captureResult) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper.this.m93x235a7742(cameraCaptureSession, captureRequest, captureResult);
                }
            });
        }

        /* renamed from: lambda$onCaptureProgressed$1$androidx-camera-camera2-internal-compat-CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper, reason: not valid java name */
        /* synthetic */ void m93x235a7742(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
            this.mWrappedCallback.onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
        }

        /* renamed from: lambda$onCaptureCompleted$2$androidx-camera-camera2-internal-compat-CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper, reason: not valid java name */
        /* synthetic */ void m91x5547c82e(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            this.mWrappedCallback.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(final CameraCaptureSession cameraCaptureSession, final CaptureRequest captureRequest, final TotalCaptureResult totalCaptureResult) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper.this.m91x5547c82e(cameraCaptureSession, captureRequest, totalCaptureResult);
                }
            });
        }

        /* renamed from: lambda$onCaptureFailed$3$androidx-camera-camera2-internal-compat-CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper, reason: not valid java name */
        /* synthetic */ void m92x9eff7bf5(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
            this.mWrappedCallback.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureFailed(final CameraCaptureSession cameraCaptureSession, final CaptureRequest captureRequest, final CaptureFailure captureFailure) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper.this.m92x9eff7bf5(cameraCaptureSession, captureRequest, captureFailure);
                }
            });
        }

        /* renamed from: lambda$onCaptureSequenceCompleted$4$androidx-camera-camera2-internal-compat-CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper, reason: not valid java name */
        /* synthetic */ void m95xdc32676f(CameraCaptureSession cameraCaptureSession, int i, long j) {
            this.mWrappedCallback.onCaptureSequenceCompleted(cameraCaptureSession, i, j);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceCompleted(final CameraCaptureSession cameraCaptureSession, final int i, final long j) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper.this.m95xdc32676f(cameraCaptureSession, i, j);
                }
            });
        }

        /* renamed from: lambda$onCaptureSequenceAborted$5$androidx-camera-camera2-internal-compat-CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper, reason: not valid java name */
        /* synthetic */ void m94x678e3bf4(CameraCaptureSession cameraCaptureSession, int i) {
            this.mWrappedCallback.onCaptureSequenceAborted(cameraCaptureSession, i);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureSequenceAborted(final CameraCaptureSession cameraCaptureSession, final int i) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper.this.m94x678e3bf4(cameraCaptureSession, i);
                }
            });
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureBufferLost(final CameraCaptureSession cameraCaptureSession, final CaptureRequest captureRequest, final Surface surface, final long j) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper.this.m90x7355e9ff(cameraCaptureSession, captureRequest, surface, j);
                }
            });
        }

        /* renamed from: lambda$onCaptureBufferLost$6$androidx-camera-camera2-internal-compat-CameraCaptureSessionCompat$CaptureCallbackExecutorWrapper, reason: not valid java name */
        /* synthetic */ void m90x7355e9ff(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Surface surface, long j) {
            ApiCompat.Api24Impl.onCaptureBufferLost(this.mWrappedCallback, cameraCaptureSession, captureRequest, surface, j);
        }
    }

    static final class StateCallbackExecutorWrapper extends CameraCaptureSession.StateCallback {
        private final Executor mExecutor;
        final CameraCaptureSession.StateCallback mWrappedCallback;

        StateCallbackExecutorWrapper(Executor executor, CameraCaptureSession.StateCallback stateCallback) {
            this.mExecutor = executor;
            this.mWrappedCallback = stateCallback;
        }

        /* renamed from: lambda$onConfigured$0$androidx-camera-camera2-internal-compat-CameraCaptureSessionCompat$StateCallbackExecutorWrapper, reason: not valid java name */
        /* synthetic */ void m101x7737ac1a(CameraCaptureSession cameraCaptureSession) {
            this.mWrappedCallback.onConfigured(cameraCaptureSession);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(final CameraCaptureSession cameraCaptureSession) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$StateCallbackExecutorWrapper$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    CameraCaptureSessionCompat.StateCallbackExecutorWrapper.this.m101x7737ac1a(cameraCaptureSession);
                }
            });
        }

        /* renamed from: lambda$onConfigureFailed$1$androidx-camera-camera2-internal-compat-CameraCaptureSessionCompat$StateCallbackExecutorWrapper, reason: not valid java name */
        /* synthetic */ void m100x3ead74e8(CameraCaptureSession cameraCaptureSession) {
            this.mWrappedCallback.onConfigureFailed(cameraCaptureSession);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(final CameraCaptureSession cameraCaptureSession) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$StateCallbackExecutorWrapper$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    CameraCaptureSessionCompat.StateCallbackExecutorWrapper.this.m100x3ead74e8(cameraCaptureSession);
                }
            });
        }

        /* renamed from: lambda$onReady$2$androidx-camera-camera2-internal-compat-CameraCaptureSessionCompat$StateCallbackExecutorWrapper, reason: not valid java name */
        /* synthetic */ void m102xb90000c9(CameraCaptureSession cameraCaptureSession) {
            this.mWrappedCallback.onReady(cameraCaptureSession);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onReady(final CameraCaptureSession cameraCaptureSession) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$StateCallbackExecutorWrapper$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    CameraCaptureSessionCompat.StateCallbackExecutorWrapper.this.m102xb90000c9(cameraCaptureSession);
                }
            });
        }

        /* renamed from: lambda$onActive$3$androidx-camera-camera2-internal-compat-CameraCaptureSessionCompat$StateCallbackExecutorWrapper, reason: not valid java name */
        /* synthetic */ void m97x7248b8e5(CameraCaptureSession cameraCaptureSession) {
            this.mWrappedCallback.onActive(cameraCaptureSession);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onActive(final CameraCaptureSession cameraCaptureSession) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$StateCallbackExecutorWrapper$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    CameraCaptureSessionCompat.StateCallbackExecutorWrapper.this.m97x7248b8e5(cameraCaptureSession);
                }
            });
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onCaptureQueueEmpty(final CameraCaptureSession cameraCaptureSession) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$StateCallbackExecutorWrapper$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    CameraCaptureSessionCompat.StateCallbackExecutorWrapper.this.m98xe6e3b40a(cameraCaptureSession);
                }
            });
        }

        /* renamed from: lambda$onCaptureQueueEmpty$4$androidx-camera-camera2-internal-compat-CameraCaptureSessionCompat$StateCallbackExecutorWrapper, reason: not valid java name */
        /* synthetic */ void m98xe6e3b40a(CameraCaptureSession cameraCaptureSession) {
            ApiCompat.Api26Impl.onCaptureQueueEmpty(this.mWrappedCallback, cameraCaptureSession);
        }

        /* renamed from: lambda$onClosed$5$androidx-camera-camera2-internal-compat-CameraCaptureSessionCompat$StateCallbackExecutorWrapper, reason: not valid java name */
        /* synthetic */ void m99xb3a739cd(CameraCaptureSession cameraCaptureSession) {
            this.mWrappedCallback.onClosed(cameraCaptureSession);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onClosed(final CameraCaptureSession cameraCaptureSession) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$StateCallbackExecutorWrapper$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    CameraCaptureSessionCompat.StateCallbackExecutorWrapper.this.m99xb3a739cd(cameraCaptureSession);
                }
            });
        }

        /* renamed from: lambda$onSurfacePrepared$6$androidx-camera-camera2-internal-compat-CameraCaptureSessionCompat$StateCallbackExecutorWrapper, reason: not valid java name */
        /* synthetic */ void m103x442ef874(CameraCaptureSession cameraCaptureSession, Surface surface) {
            ApiCompat.Api23Impl.onSurfacePrepared(this.mWrappedCallback, cameraCaptureSession, surface);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onSurfacePrepared(final CameraCaptureSession cameraCaptureSession, final Surface surface) {
            this.mExecutor.execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat$StateCallbackExecutorWrapper$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    CameraCaptureSessionCompat.StateCallbackExecutorWrapper.this.m103x442ef874(cameraCaptureSession, surface);
                }
            });
        }
    }
}
