package com.socure.docv.capturesdk.core.provider.interfaces;

import android.graphics.Bitmap;
import androidx.camera.core.ImageCaptureException;
import com.socure.docv.capturesdk.core.processor.model.CaptureMetadata;

/* loaded from: classes5.dex */
public interface a {
    void a(int i, Bitmap bitmap, CaptureMetadata captureMetadata, Bitmap bitmap2);

    void a(int i, ImageCaptureException imageCaptureException);
}
