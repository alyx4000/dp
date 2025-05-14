package androidx.camera.core.processing;

import androidx.camera.core.CameraEffect;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProcessor;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class InternalImageProcessor {
    private final Executor mExecutor;
    private final ImageProcessor mImageProcessor;

    public InternalImageProcessor(CameraEffect cameraEffect) {
        Preconditions.checkArgument(cameraEffect.getTargets() == 4);
        this.mExecutor = cameraEffect.getProcessorExecutor();
        this.mImageProcessor = (ImageProcessor) Objects.requireNonNull(cameraEffect.getImageProcessor());
    }

    public ImageProcessor.Response safeProcess(final ImageProcessor.Request request) throws ImageCaptureException {
        try {
            return (ImageProcessor.Response) CallbackToFutureAdapter.getFuture(new CallbackToFutureAdapter.Resolver() { // from class: androidx.camera.core.processing.InternalImageProcessor$$ExternalSyntheticLambda1
                @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
                public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
                    return InternalImageProcessor.this.m192xe9947096(request, completer);
                }
            }).get();
        } catch (InterruptedException | ExecutionException e) {
            Throwable cause = e.getCause();
            Throwable th = e;
            if (cause != null) {
                th = e.getCause();
            }
            throw new ImageCaptureException(0, "Failed to invoke ImageProcessor.", th);
        }
    }

    /* renamed from: lambda$safeProcess$1$androidx-camera-core-processing-InternalImageProcessor, reason: not valid java name */
    /* synthetic */ Object m192xe9947096(final ImageProcessor.Request request, final CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mExecutor.execute(new Runnable() { // from class: androidx.camera.core.processing.InternalImageProcessor$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                InternalImageProcessor.this.m191xe85e1db7(completer, request);
            }
        });
        return "InternalImageProcessor#process " + request.hashCode();
    }

    /* renamed from: lambda$safeProcess$0$androidx-camera-core-processing-InternalImageProcessor, reason: not valid java name */
    /* synthetic */ void m191xe85e1db7(CallbackToFutureAdapter.Completer completer, ImageProcessor.Request request) {
        try {
            completer.set(this.mImageProcessor.process(request));
        } catch (Exception e) {
            completer.setException(e);
        }
    }
}
