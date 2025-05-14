package com.socure.docv.capturesdk.core.pipeline;

import com.socure.docv.capturesdk.common.utils.Utils;
import com.socure.docv.capturesdk.core.pipeline.model.ScanType;
import com.socure.docv.capturesdk.core.processor.image.f;
import com.socure.docv.capturesdk.core.processor.model.DetectionType;
import java.util.TreeMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final TreeMap<DetectionType, com.socure.docv.capturesdk.core.processor.interfaces.b> f382a;

    public d(a aVar) {
        this(aVar.b());
    }

    public d(TreeMap<DetectionType, com.socure.docv.capturesdk.core.processor.interfaces.b> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.f382a = map;
    }

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final com.socure.docv.capturesdk.di.c f383a;
        public final ScanType b;
        public final TreeMap<DetectionType, com.socure.docv.capturesdk.core.processor.interfaces.b> c;
        public com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.a d;

        /* renamed from: com.socure.docv.capturesdk.core.pipeline.d$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0039a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f384a;

            static {
                int[] iArr = new int[DetectionType.values().length];
                iArr[DetectionType.CORNER.ordinal()] = 1;
                iArr[DetectionType.BLUR.ordinal()] = 2;
                iArr[DetectionType.GLARE.ordinal()] = 3;
                iArr[DetectionType.BRIGHTNESS.ordinal()] = 4;
                iArr[DetectionType.SELFIE.ordinal()] = 5;
                iArr[DetectionType.BARCODE.ordinal()] = 6;
                f384a = iArr;
            }
        }

        public a(com.socure.docv.capturesdk.di.c dependencyGraph, ScanType scanType) {
            Intrinsics.checkNotNullParameter(dependencyGraph, "dependencyGraph");
            Intrinsics.checkNotNullParameter(scanType, "scanType");
            this.f383a = dependencyGraph;
            this.b = scanType;
            this.c = new TreeMap<>();
        }

        public final a a(com.socure.docv.capturesdk.feature.scanner.presentation.viewmodel.a dic) {
            Intrinsics.checkNotNullParameter(dic, "dic");
            this.d = dic;
            if (dic != null) {
                TreeMap<DetectionType, com.socure.docv.capturesdk.core.processor.interfaces.b> treeMap = this.c;
                DetectionType detectionType = DetectionType.CORNER;
                if (treeMap.containsKey(detectionType)) {
                    com.socure.docv.capturesdk.core.processor.interfaces.b bVar = this.c.get(detectionType);
                    if (bVar == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.socure.docv.capturesdk.core.processor.frame.CornerProcessor");
                    }
                    com.socure.docv.capturesdk.core.processor.frame.b bVar2 = (com.socure.docv.capturesdk.core.processor.frame.b) bVar;
                    Intrinsics.checkNotNullParameter(dic, "dic");
                    if (Utils.INSTANCE.showDebugImage$capturesdk_productionRelease()) {
                        bVar2.c = dic;
                    }
                } else {
                    TreeMap<DetectionType, com.socure.docv.capturesdk.core.processor.interfaces.b> treeMap2 = this.c;
                    DetectionType detectionType2 = DetectionType.SELFIE;
                    if (treeMap2.containsKey(detectionType2)) {
                        com.socure.docv.capturesdk.core.processor.interfaces.b bVar3 = this.c.get(detectionType2);
                        if (bVar3 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.socure.docv.capturesdk.core.processor.image.SelfieFaceProcessor");
                        }
                        f fVar = (f) bVar3;
                        Intrinsics.checkNotNullParameter(dic, "dic");
                        if (Utils.INSTANCE.showDebugImage$capturesdk_productionRelease()) {
                            fVar.e = dic;
                        }
                    }
                }
            }
            return this;
        }

        public final TreeMap<DetectionType, com.socure.docv.capturesdk.core.processor.interfaces.b> b() {
            return this.c;
        }

        public final a a(DetectionType... steps) {
            com.socure.docv.capturesdk.core.processor.interfaces.b bVar;
            Intrinsics.checkNotNullParameter(steps, "steps");
            for (DetectionType detectionType : steps) {
                switch (C0039a.f384a[detectionType.ordinal()]) {
                    case 1:
                        bVar = new com.socure.docv.capturesdk.core.processor.frame.b(this.f383a, this.b);
                        break;
                    case 2:
                        bVar = new com.socure.docv.capturesdk.core.processor.image.b(this.f383a);
                        break;
                    case 3:
                        bVar = new com.socure.docv.capturesdk.core.processor.image.d(this.f383a);
                        break;
                    case 4:
                        bVar = new com.socure.docv.capturesdk.core.processor.image.c();
                        break;
                    case 5:
                        bVar = new f(this.f383a);
                        break;
                    case 6:
                        bVar = new com.socure.docv.capturesdk.core.processor.image.a();
                        break;
                    default:
                        throw new NoWhenBranchMatchedException();
                }
                if (this.c.containsKey(detectionType)) {
                    throw new IllegalArgumentException("Processor of this type already added");
                }
                this.c.put(detectionType, bVar);
            }
            return this;
        }

        public final d a() {
            return new d(this);
        }
    }
}
