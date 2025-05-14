package com.socure.docv.capturesdk.feature.scanner;

import android.graphics.Bitmap;
import com.socure.docv.capturesdk.common.utils.CameraManager;
import com.socure.docv.capturesdk.common.utils.FeedManager;
import com.socure.docv.capturesdk.core.pipeline.model.ScanType;
import com.socure.docv.capturesdk.feature.scanner.data.CameraSource;
import com.socure.docv.capturesdk.feature.scanner.data.VideoManager;
import com.socure.docv.capturesdk.feature.scanner.data.VideoSource;
import com.socure.docv.capturesdk.feature.scanner.data.ViewDimensions;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final ViewDimensions f479a;
    public Function1<? super Bitmap, Unit> b;
    public Function1<? super Bitmap, Unit> c;
    public com.socure.docv.capturesdk.core.provider.interfaces.c d;

    public static final class a extends Lambda implements Function1<Bitmap, Unit> {
        public a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Bitmap bitmap) {
            b.this.c.invoke(bitmap);
            return Unit.INSTANCE;
        }
    }

    /* renamed from: com.socure.docv.capturesdk.feature.scanner.b$b, reason: collision with other inner class name */
    public static final class C0047b extends Lambda implements Function1<Bitmap, Unit> {
        public C0047b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Bitmap bitmap) {
            b.this.b.invoke(bitmap);
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function1<Bitmap, Unit> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Bitmap bitmap) {
            b.this.b.invoke(bitmap);
            return Unit.INSTANCE;
        }
    }

    public b(boolean z, FeedManager feedManager, ScanType scanType, ViewDimensions viewDimensions, Function1<? super Bitmap, Unit> frameCallBack, Function1<? super Bitmap, Unit> videoPreviewCallback) {
        Intrinsics.checkNotNullParameter(feedManager, "feedManager");
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        Intrinsics.checkNotNullParameter(viewDimensions, "viewDimensions");
        Intrinsics.checkNotNullParameter(frameCallBack, "frameCallBack");
        Intrinsics.checkNotNullParameter(videoPreviewCallback, "videoPreviewCallback");
        this.f479a = viewDimensions;
        this.b = frameCallBack;
        this.c = videoPreviewCallback;
        this.d = a(z, feedManager, scanType);
    }

    public final com.socure.docv.capturesdk.core.provider.interfaces.c a(boolean z, FeedManager feedManager, ScanType scanType) {
        return z ? new VideoSource((VideoManager) feedManager, feedManager.getCropCoordinates(), scanType, new a(), new C0047b()) : new CameraSource((CameraManager) feedManager, feedManager.getCropCoordinates(), scanType, this.f479a, new c());
    }
}
