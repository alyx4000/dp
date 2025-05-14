package com.socure.docv.capturesdk.core.extractor;

import android.graphics.Bitmap;
import android.util.Log;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceDetection;
import com.google.mlkit.vision.face.FaceDetector;
import com.google.mlkit.vision.face.FaceDetectorOptions;
import com.socure.docv.capturesdk.common.utils.ImageUtils;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Bitmap f364a;
    public final i b;
    public final FaceDetector c;

    @DebugMetadata(c = "com.socure.docv.capturesdk.core.extractor.FaceReader$readBlocking$1", f = "FaceReader.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Face>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f365a;
        public final /* synthetic */ Task<List<Face>> b;
        public final /* synthetic */ long c;
        public final /* synthetic */ c d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Task<List<Face>> task, long j, c cVar, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = task;
            this.c = j;
            this.d = cVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            a aVar = new a(this.b, this.c, this.d, continuation);
            aVar.f365a = obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public Object invoke(CoroutineScope coroutineScope, Continuation<? super Face> continuation) {
            a aVar = new a(this.b, this.c, this.d, continuation);
            aVar.f365a = coroutineScope;
            return aVar.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            List<? extends Face> faces = (List) Tasks.await(this.b, this.c, TimeUnit.MILLISECONDS);
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_FD", "readBlocking resumed at: " + System.currentTimeMillis());
            if (faces.isEmpty()) {
                return null;
            }
            c cVar = this.d;
            Intrinsics.checkNotNullExpressionValue(faces, "faces");
            Face a2 = cVar.a(faces);
            return a2 == null ? faces.get(0) : a2;
        }
    }

    public c(Bitmap bitmap, i reader, int i) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(reader, "reader");
        this.f364a = bitmap;
        this.b = reader;
        FaceDetectorOptions build = new FaceDetectorOptions.Builder().setPerformanceMode(i).setLandmarkMode(1).setContourMode(1).setClassificationMode(1).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n        .setPe…DE_NONE)\n        .build()");
        FaceDetector client = FaceDetection.getClient(build);
        Intrinsics.checkNotNullExpressionValue(client, "getClient(options)");
        this.c = client;
    }

    public /* synthetic */ c(Bitmap bitmap, i iVar, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(bitmap, iVar, (i2 & 4) != 0 ? 2 : i);
    }

    public static final void a(c this$0, Exception it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_FD", "failure called at: " + System.currentTimeMillis() + " : ex: " + Log.getStackTraceString(it));
        this$0.b.a(null, false);
    }

    public static final void b(c this$0, Exception it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_FD", "secondProcess - failure called at: " + System.currentTimeMillis() + " : ex: " + Log.getStackTraceString(it));
        this$0.b.a(null, false);
    }

    public final float a(float f) {
        float abs = Math.abs(f);
        if (abs < 75.0f || abs > 105.0f) {
            return 0.0f;
        }
        return (f < 0.0f ? -1.0f : 1.0f) * 90.0f;
    }

    public final Face a(long j) {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_FD", "readBlocking called at: " + System.currentTimeMillis());
        InputImage fromBitmap = InputImage.fromBitmap(this.f364a, 0);
        Intrinsics.checkNotNullExpressionValue(fromBitmap, "fromBitmap(bitmap, 0)");
        Task<List<Face>> process = this.c.process(fromBitmap);
        Intrinsics.checkNotNullExpressionValue(process, "scanner.process(inputImage)");
        try {
            return (Face) BuildersKt.runBlocking(Dispatchers.getIO(), new a(process, j, this, null));
        } catch (Throwable th) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_FD", "readBlocking failure called at: " + System.currentTimeMillis() + " : Message: " + th.getLocalizedMessage() + ", Exception: " + Log.getStackTraceString(th));
            return null;
        }
    }

    public final Face a(List<? extends Face> list) {
        Unit unit;
        Face face = null;
        for (Face face2 : list) {
            int abs = Math.abs(face2.getBoundingBox().height() * face2.getBoundingBox().width());
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_FD", "Face data: " + face2 + " | Face area: " + abs + " | z rotation: " + face2.getHeadEulerAngleZ());
            if (face != null) {
                if (Math.abs(face.getBoundingBox().height() * face.getBoundingBox().width()) <= abs) {
                    face = face2;
                }
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                face = face2;
            }
        }
        return face;
    }

    public final void a() {
        InputImage fromBitmap = InputImage.fromBitmap(this.f364a, 0);
        Intrinsics.checkNotNullExpressionValue(fromBitmap, "fromBitmap(bitmap, 0)");
        this.c.process(fromBitmap).addOnSuccessListener(new OnSuccessListener() { // from class: com.socure.docv.capturesdk.core.extractor.c$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                c.a(c.this, (List) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.socure.docv.capturesdk.core.extractor.c$$ExternalSyntheticLambda3
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                c.a(c.this, exc);
            }
        });
    }

    public final void a(Bitmap bitmap, final com.socure.docv.capturesdk.core.extractor.model.c cVar) {
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_FD", "secondProcess called at: " + System.currentTimeMillis());
        InputImage fromBitmap = InputImage.fromBitmap(ImageUtils.INSTANCE.rotateBitmap$capturesdk_productionRelease(bitmap, 180.0f), 0);
        Intrinsics.checkNotNullExpressionValue(fromBitmap, "fromBitmap(ImageUtils.ro…eBitmap(bitmap, 180F), 0)");
        this.c.process(fromBitmap).addOnSuccessListener(new OnSuccessListener() { // from class: com.socure.docv.capturesdk.core.extractor.c$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                c.a(c.this, cVar, (List) obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.socure.docv.capturesdk.core.extractor.c$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                c.b(c.this, exc);
            }
        });
    }

    public static final void a(c this$0, List it) {
        Unit unit;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_FD", "success called at: " + System.currentTimeMillis() + " | No. of Faces: " + it.size());
        Intrinsics.checkNotNullExpressionValue(it, "it");
        Face a2 = this$0.a((List<? extends Face>) it);
        com.socure.docv.capturesdk.core.extractor.model.c cVar = new com.socure.docv.capturesdk.core.extractor.model.c();
        if (a2 != null) {
            cVar.b = this$0.a(a2.getHeadEulerAngleZ());
            this$0.b.a(cVar, true);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            if (it.size() == 0) {
                this$0.a(this$0.f364a, cVar);
            } else {
                this$0.b.a(null, false);
            }
        }
    }

    public static final void a(c this$0, com.socure.docv.capturesdk.core.extractor.model.c extractedFace, List it) {
        Unit unit;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(extractedFace, "$extractedFace");
        com.socure.docv.capturesdk.common.logger.b.a("SDLT_FD", "secondProcess - success called at: " + System.currentTimeMillis() + " | No. of Faces: " + it.size());
        Intrinsics.checkNotNullExpressionValue(it, "it");
        Face a2 = this$0.a((List<? extends Face>) it);
        if (a2 != null) {
            extractedFace.getClass();
            extractedFace.b = this$0.a(a2.getHeadEulerAngleZ()) + 180.0f;
            this$0.b.a(extractedFace, true);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this$0.b.a(null, false);
        }
    }
}
