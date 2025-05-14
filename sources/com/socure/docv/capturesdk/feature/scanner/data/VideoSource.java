package com.socure.docv.capturesdk.feature.scanner.data;

import android.graphics.Bitmap;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.socure.docv.capturesdk.core.pipeline.model.CaptureType;
import com.socure.docv.capturesdk.core.pipeline.model.ScanType;
import com.socure.docv.capturesdk.core.provider.interfaces.a;
import com.socure.docv.capturesdk.core.provider.interfaces.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0014\u0010!\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0004\u0012\u00020\u00020\u001f\u0012\u0014\u0010#\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0004\u0012\u00020\u00020\u001f¢\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J(\u0010\u0010\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\u0002H\u0016R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R&\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00168\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\"\u0010!\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0004\u0012\u00020\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\"\u0010#\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0004\u0012\u00020\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\"R\"\u0010&\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0004\u0012\u00020\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/socure/docv/capturesdk/feature/scanner/data/VideoSource;", "Lcom/socure/docv/capturesdk/core/provider/interfaces/c;", "", "startGeneratingFrame", "stopGeneratingFrame", "", "enable", "toggleAnalysisMode", "Lcom/socure/docv/capturesdk/core/pipeline/model/CaptureType;", "captureType", "", "currentCount", "Lcom/socure/docv/capturesdk/feature/scanner/data/ViewDimensions;", "viewDimensions", "Lcom/socure/docv/capturesdk/core/provider/interfaces/a;", "captureListener", "takePicture", "updateViewDimensions", "freeze", "Lcom/socure/docv/capturesdk/feature/scanner/data/VideoManager;", "videoManager", "Lcom/socure/docv/capturesdk/feature/scanner/data/VideoManager;", "", "", "cropViewCoordinates", "Ljava/util/List;", "getCropViewCoordinates", "()Ljava/util/List;", "Lcom/socure/docv/capturesdk/core/pipeline/model/ScanType;", "scanType", "Lcom/socure/docv/capturesdk/core/pipeline/model/ScanType;", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "previewListener", "Lkotlin/jvm/functions/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "getFrameListener", "()Lkotlin/jvm/functions/Function1;", "frameListener", "<init>", "(Lcom/socure/docv/capturesdk/feature/scanner/data/VideoManager;Ljava/util/List;Lcom/socure/docv/capturesdk/core/pipeline/model/ScanType;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final class VideoSource implements c {
    private final List<List<Double>> cropViewCoordinates;
    private final Function1<Bitmap, Unit> listener;
    private final Function1<Bitmap, Unit> previewListener;
    private final ScanType scanType;
    private final VideoManager videoManager;

    /* JADX WARN: Multi-variable type inference failed */
    public VideoSource(VideoManager videoManager, List<List<Double>> cropViewCoordinates, ScanType scanType, Function1<? super Bitmap, Unit> previewListener, Function1<? super Bitmap, Unit> listener) {
        Intrinsics.checkNotNullParameter(videoManager, "videoManager");
        Intrinsics.checkNotNullParameter(cropViewCoordinates, "cropViewCoordinates");
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        Intrinsics.checkNotNullParameter(previewListener, "previewListener");
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.videoManager = videoManager;
        this.cropViewCoordinates = cropViewCoordinates;
        this.scanType = scanType;
        this.previewListener = previewListener;
        this.listener = listener;
    }

    @Override // com.socure.docv.capturesdk.core.provider.interfaces.c
    public void freeze() {
    }

    public List<List<Double>> getCropViewCoordinates() {
        return this.cropViewCoordinates;
    }

    public Function1<Bitmap, Unit> getFrameListener() {
        return this.listener;
    }

    @Override // com.socure.docv.capturesdk.core.provider.interfaces.c
    public void startGeneratingFrame() {
    }

    @Override // com.socure.docv.capturesdk.core.provider.interfaces.c
    public void stopGeneratingFrame() {
    }

    @Override // com.socure.docv.capturesdk.core.provider.interfaces.c
    public void takePicture(CaptureType captureType, int currentCount, ViewDimensions viewDimensions, a captureListener) {
        Intrinsics.checkNotNullParameter(captureType, "captureType");
        Intrinsics.checkNotNullParameter(viewDimensions, "viewDimensions");
        Intrinsics.checkNotNullParameter(captureListener, "captureListener");
    }

    @Override // com.socure.docv.capturesdk.core.provider.interfaces.c
    public void toggleAnalysisMode(boolean enable) {
    }

    @Override // com.socure.docv.capturesdk.core.provider.interfaces.c
    public void updateViewDimensions(ViewDimensions viewDimensions) {
        Intrinsics.checkNotNullParameter(viewDimensions, "viewDimensions");
    }
}
