package com.socure.docv.capturesdk.feature.scanner.data;

import android.app.Activity;
import android.widget.VideoView;
import com.socure.docv.capturesdk.core.provider.interfaces.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/socure/docv/capturesdk/feature/scanner/data/FrameGenerator;", "", "Lcom/socure/docv/capturesdk/core/provider/interfaces/b;", "frameDispatcher", "", "addFrameDispatcher", "", "manualCaptureOnly", "Z", "Landroid/app/Activity;", "activity", "Landroid/app/Activity;", "Landroid/widget/VideoView;", "videoView", "Landroid/widget/VideoView;", "", "filePath", "Ljava/lang/String;", "Lcom/socure/docv/capturesdk/feature/scanner/data/FrameGeneratorCallback;", "callback", "Lcom/socure/docv/capturesdk/feature/scanner/data/FrameGeneratorCallback;", "Lcom/socure/docv/capturesdk/core/provider/interfaces/b;", "<init>", "(ZLandroid/app/Activity;Landroid/widget/VideoView;Ljava/lang/String;Lcom/socure/docv/capturesdk/feature/scanner/data/FrameGeneratorCallback;)V", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final class FrameGenerator {
    private final Activity activity;
    private final FrameGeneratorCallback callback;
    private final String filePath;
    private b frameDispatcher;
    private final boolean manualCaptureOnly;
    private final VideoView videoView;

    public FrameGenerator(boolean z, Activity activity, VideoView videoView, String filePath, FrameGeneratorCallback callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.manualCaptureOnly = z;
        this.activity = activity;
        this.videoView = videoView;
        this.filePath = filePath;
        this.callback = callback;
    }

    public final void addFrameDispatcher(b frameDispatcher) {
        Intrinsics.checkNotNullParameter(frameDispatcher, "frameDispatcher");
        this.frameDispatcher = frameDispatcher;
    }
}
