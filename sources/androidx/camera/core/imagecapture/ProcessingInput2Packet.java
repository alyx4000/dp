package androidx.camera.core.imagecapture;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.imagecapture.ProcessingNode;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.internal.CameraCaptureResultImageInfo;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import androidx.core.util.Preconditions;
import java.io.IOException;

/* loaded from: classes.dex */
final class ProcessingInput2Packet implements Operation<ProcessingNode.InputPacket, Packet<ImageProxy>> {
    ProcessingInput2Packet() {
    }

    @Override // androidx.camera.core.processing.Operation
    public Packet<ImageProxy> apply(ProcessingNode.InputPacket inputPacket) throws ImageCaptureException {
        Exif createFromImageProxy;
        Matrix matrix;
        int i;
        ImageProxy imageProxy = inputPacket.getImageProxy();
        ProcessingRequest processingRequest = inputPacket.getProcessingRequest();
        if (imageProxy.getFormat() == 256) {
            try {
                createFromImageProxy = Exif.createFromImageProxy(imageProxy);
                imageProxy.getPlanes()[0].getBuffer().rewind();
            } catch (IOException e) {
                throw new ImageCaptureException(1, "Failed to extract EXIF data.", e);
            }
        } else {
            createFromImageProxy = null;
        }
        CameraCaptureResult cameraCaptureResult = ((CameraCaptureResultImageInfo) imageProxy.getImageInfo()).getCameraCaptureResult();
        Rect cropRect = processingRequest.getCropRect();
        Matrix sensorToBufferTransform = processingRequest.getSensorToBufferTransform();
        int rotationDegrees = processingRequest.getRotationDegrees();
        if (ImagePipeline.EXIF_ROTATION_AVAILABILITY.shouldUseExifOrientation(imageProxy)) {
            Preconditions.checkNotNull(createFromImageProxy, "The image must have JPEG exif.");
            Preconditions.checkState(isSizeMatch(createFromImageProxy, imageProxy), "Exif size does not match image size.");
            Matrix halTransform = getHalTransform(processingRequest.getRotationDegrees(), new Size(createFromImageProxy.getWidth(), createFromImageProxy.getHeight()), createFromImageProxy.getRotation());
            Rect updatedCropRect = getUpdatedCropRect(processingRequest.getCropRect(), halTransform);
            matrix = getUpdatedTransform(processingRequest.getSensorToBufferTransform(), halTransform);
            i = createFromImageProxy.getRotation();
            cropRect = updatedCropRect;
        } else {
            matrix = sensorToBufferTransform;
            i = rotationDegrees;
        }
        return Packet.of(imageProxy, createFromImageProxy, cropRect, i, matrix, cameraCaptureResult);
    }

    private static boolean isSizeMatch(Exif exif, ImageProxy imageProxy) {
        return exif.getWidth() == imageProxy.getWidth() && exif.getHeight() == imageProxy.getHeight();
    }

    private static Matrix getUpdatedTransform(Matrix matrix, Matrix matrix2) {
        Matrix matrix3 = new Matrix(matrix);
        matrix3.postConcat(matrix2);
        return matrix3;
    }

    private static Rect getUpdatedCropRect(Rect rect, Matrix matrix) {
        RectF rectF = new RectF(rect);
        matrix.mapRect(rectF);
        Rect rect2 = new Rect();
        rectF.round(rect2);
        return rect2;
    }

    private static Matrix getHalTransform(int i, Size size, int i2) {
        int i3 = i - i2;
        Size size2 = TransformUtils.is90or270(TransformUtils.within360(i3)) ? new Size(size.getHeight(), size.getWidth()) : size;
        return TransformUtils.getRectToRect(new RectF(0.0f, 0.0f, size2.getWidth(), size2.getHeight()), new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight()), i3);
    }
}
