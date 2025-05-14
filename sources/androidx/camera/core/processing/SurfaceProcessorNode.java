package androidx.camera.core.processing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.Preconditions;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes.dex */
public class SurfaceProcessorNode implements Node<SurfaceEdge, SurfaceEdge> {
    final CameraInternal mCameraInternal;
    private final SurfaceOutput.GlTransformOptions mGlTransformOptions;
    private SurfaceEdge mInputEdge;
    private SurfaceEdge mOutputEdge;
    final SurfaceProcessorInternal mSurfaceProcessor;

    public SurfaceProcessorNode(CameraInternal cameraInternal, SurfaceOutput.GlTransformOptions glTransformOptions, SurfaceProcessorInternal surfaceProcessorInternal) {
        this.mCameraInternal = cameraInternal;
        this.mGlTransformOptions = glTransformOptions;
        this.mSurfaceProcessor = surfaceProcessorInternal;
    }

    @Override // androidx.camera.core.processing.Node
    public SurfaceEdge transform(SurfaceEdge surfaceEdge) {
        Threads.checkMainThread();
        Preconditions.checkArgument(surfaceEdge.getSurfaces().size() == 1, "Multiple input stream not supported yet.");
        this.mInputEdge = surfaceEdge;
        SettableSurface settableSurface = surfaceEdge.getSurfaces().get(0);
        SettableSurface createOutputSurface = createOutputSurface(settableSurface);
        sendSurfacesToProcessorWhenReady(settableSurface, createOutputSurface);
        SurfaceEdge create = SurfaceEdge.create(Collections.singletonList(createOutputSurface));
        this.mOutputEdge = create;
        return create;
    }

    /* renamed from: androidx.camera.core.processing.SurfaceProcessorNode$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$androidx$camera$core$SurfaceOutput$GlTransformOptions;

        static {
            int[] iArr = new int[SurfaceOutput.GlTransformOptions.values().length];
            $SwitchMap$androidx$camera$core$SurfaceOutput$GlTransformOptions = iArr;
            try {
                iArr[SurfaceOutput.GlTransformOptions.APPLY_CROP_ROTATE_AND_MIRRORING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$camera$core$SurfaceOutput$GlTransformOptions[SurfaceOutput.GlTransformOptions.USE_SURFACE_TEXTURE_TRANSFORM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private SettableSurface createOutputSurface(SettableSurface settableSurface) {
        Size rectToSize;
        int i = AnonymousClass2.$SwitchMap$androidx$camera$core$SurfaceOutput$GlTransformOptions[this.mGlTransformOptions.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return new SettableSurface(settableSurface.getTargets(), settableSurface.getSize(), settableSurface.getFormat(), settableSurface.getSensorToBufferTransform(), false, settableSurface.getCropRect(), settableSurface.getRotationDegrees(), settableSurface.getMirroring());
            }
            throw new AssertionError("Unknown GlTransformOptions: " + this.mGlTransformOptions);
        }
        Size size = settableSurface.getSize();
        Rect cropRect = settableSurface.getCropRect();
        int rotationDegrees = settableSurface.getRotationDegrees();
        boolean mirroring = settableSurface.getMirroring();
        if (TransformUtils.is90or270(rotationDegrees)) {
            rectToSize = new Size(cropRect.height(), cropRect.width());
        } else {
            rectToSize = TransformUtils.rectToSize(cropRect);
        }
        Size size2 = rectToSize;
        Matrix matrix = new Matrix(settableSurface.getSensorToBufferTransform());
        matrix.postConcat(TransformUtils.getRectToRect(TransformUtils.sizeToRectF(size), new RectF(cropRect), rotationDegrees, mirroring));
        return new SettableSurface(settableSurface.getTargets(), size2, settableSurface.getFormat(), matrix, false, TransformUtils.sizeToRect(size2), 0, false);
    }

    private void sendSurfacesToProcessorWhenReady(final SettableSurface settableSurface, final SettableSurface settableSurface2) {
        final SurfaceRequest createSurfaceRequest = settableSurface.createSurfaceRequest(this.mCameraInternal);
        Futures.addCallback(settableSurface2.createSurfaceOutputFuture(this.mGlTransformOptions, settableSurface.getSize(), settableSurface.getCropRect(), settableSurface.getRotationDegrees(), settableSurface.getMirroring()), new FutureCallback<SurfaceOutput>() { // from class: androidx.camera.core.processing.SurfaceProcessorNode.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(SurfaceOutput surfaceOutput) {
                Preconditions.checkNotNull(surfaceOutput);
                SurfaceProcessorNode.this.mSurfaceProcessor.onOutputSurface(surfaceOutput);
                SurfaceProcessorNode.this.mSurfaceProcessor.onInputSurface(createSurfaceRequest);
                SurfaceProcessorNode.this.setupSurfaceUpdatePipeline(settableSurface, createSurfaceRequest, settableSurface2, surfaceOutput);
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(Throwable th) {
                createSurfaceRequest.willNotProvideSurface();
            }
        }, CameraXExecutors.mainThreadExecutor());
    }

    void setupSurfaceUpdatePipeline(final SettableSurface settableSurface, SurfaceRequest surfaceRequest, final SettableSurface settableSurface2, final SurfaceOutput surfaceOutput) {
        surfaceRequest.setTransformationInfoListener(CameraXExecutors.mainThreadExecutor(), new SurfaceRequest.TransformationInfoListener() { // from class: androidx.camera.core.processing.SurfaceProcessorNode$$ExternalSyntheticLambda0
            @Override // androidx.camera.core.SurfaceRequest.TransformationInfoListener
            public final void onTransformationInfoUpdate(SurfaceRequest.TransformationInfo transformationInfo) {
                SurfaceProcessorNode.lambda$setupSurfaceUpdatePipeline$0(SurfaceOutput.this, settableSurface, settableSurface2, transformationInfo);
            }
        });
    }

    static /* synthetic */ void lambda$setupSurfaceUpdatePipeline$0(SurfaceOutput surfaceOutput, SettableSurface settableSurface, SettableSurface settableSurface2, SurfaceRequest.TransformationInfo transformationInfo) {
        int rotationDegrees = transformationInfo.getRotationDegrees() - surfaceOutput.getRotationDegrees();
        if (settableSurface.getMirroring()) {
            rotationDegrees = -rotationDegrees;
        }
        settableSurface2.setRotationDegrees(TransformUtils.within360(rotationDegrees));
    }

    @Override // androidx.camera.core.processing.Node
    public void release() {
        this.mSurfaceProcessor.release();
        CameraXExecutors.mainThreadExecutor().execute(new Runnable() { // from class: androidx.camera.core.processing.SurfaceProcessorNode$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                SurfaceProcessorNode.this.m198x89e7b484();
            }
        });
    }

    /* renamed from: lambda$release$1$androidx-camera-core-processing-SurfaceProcessorNode, reason: not valid java name */
    /* synthetic */ void m198x89e7b484() {
        SurfaceEdge surfaceEdge = this.mOutputEdge;
        if (surfaceEdge != null) {
            Iterator<SettableSurface> it = surfaceEdge.getSurfaces().iterator();
            while (it.hasNext()) {
                it.next().close();
            }
        }
    }
}
