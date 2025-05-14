package com.socure.docv.capturesdk.common.analytics;

import android.app.Application;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import androidx.core.app.FrameMetricsAggregator;
import com.google.gson.Gson;
import com.socure.docv.capturesdk.common.analytics.model.Barcode;
import com.socure.docv.capturesdk.common.analytics.model.CameraDevice;
import com.socure.docv.capturesdk.common.analytics.model.Capabilities;
import com.socure.docv.capturesdk.common.analytics.model.Document;
import com.socure.docv.capturesdk.common.analytics.model.Documents;
import com.socure.docv.capturesdk.common.analytics.model.MetricCaptureData;
import com.socure.docv.capturesdk.common.analytics.model.MetricData;
import com.socure.docv.capturesdk.common.analytics.model.MinMaxInt;
import com.socure.docv.capturesdk.common.analytics.model.Mrz;
import com.socure.docv.capturesdk.common.analytics.model.Selfie;
import com.socure.docv.capturesdk.common.analytics.model.Settings;
import com.socure.docv.capturesdk.common.utils.ApiConstant;
import com.socure.docv.capturesdk.common.utils.ConstantsKt;
import com.socure.docv.capturesdk.common.utils.Screen;
import com.socure.docv.capturesdk.common.utils.UtilsKt;
import com.socure.docv.capturesdk.core.pipeline.model.CaptureType;
import com.socure.docv.capturesdk.core.pipeline.model.ScanType;
import com.socure.docv.capturesdk.core.processor.model.CaptureMetadata;
import com.socure.docv.capturesdk.core.processor.model.DetectionMetric;
import com.socure.docv.capturesdk.core.processor.model.DetectionType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Application f288a;
    public MetricData b;

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f289a;

        static {
            int[] iArr = new int[ScanType.values().length];
            iArr[ScanType.LICENSE_FRONT.ordinal()] = 1;
            iArr[ScanType.PASSPORT.ordinal()] = 2;
            iArr[ScanType.LICENSE_BACK.ordinal()] = 3;
            iArr[ScanType.SELFIE.ordinal()] = 4;
            f289a = iArr;
        }
    }

    public c(Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        this.f288a = application;
    }

    public final int a(int i, int i2) {
        return i2 == 0 ? i : a(i2, i % i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x017b, code lost:
    
        if (r6 > ((java.lang.Number) r8).intValue()) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.socure.docv.capturesdk.common.analytics.model.Capabilities a(android.hardware.camera2.CameraManager r18, java.lang.String r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 480
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.socure.docv.capturesdk.common.analytics.c.a(android.hardware.camera2.CameraManager, java.lang.String, java.lang.String):com.socure.docv.capturesdk.common.analytics.model.Capabilities");
    }

    public final Document a(CaptureType captureType, List<DetectionMetric> list) {
        Object obj;
        Object obj2;
        Double valueOf;
        Object obj3;
        Object obj4;
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_MM", "updateModelDetails called");
        Document document = new Document(null, null, null, null, null, null, null, null, null, FrameMetricsAggregator.EVERY_DURATION, null);
        document.setCaptureMode(captureType.getValue());
        Iterator<T> it = list.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            if (((DetectionMetric) obj2).getDetectionType() == DetectionType.BRIGHTNESS) {
                break;
            }
        }
        DetectionMetric detectionMetric = (DetectionMetric) obj2;
        if (detectionMetric == null || (valueOf = detectionMetric.getOutputMeasure()) == null) {
            valueOf = Double.valueOf(0.0d);
        }
        document.setBrightness(valueOf);
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj3 = null;
                break;
            }
            obj3 = it2.next();
            if (((DetectionMetric) obj3).getDetectionType() == DetectionType.GLARE) {
                break;
            }
        }
        document.setGlare(UtilsKt.getGlareData((DetectionMetric) obj3));
        Iterator<T> it3 = list.iterator();
        while (true) {
            if (!it3.hasNext()) {
                obj4 = null;
                break;
            }
            obj4 = it3.next();
            if (((DetectionMetric) obj4).getDetectionType() == DetectionType.BLUR) {
                break;
            }
        }
        document.setBlur(UtilsKt.getBlurData((DetectionMetric) obj4));
        Iterator<T> it4 = list.iterator();
        while (true) {
            if (!it4.hasNext()) {
                break;
            }
            Object next = it4.next();
            if (((DetectionMetric) next).getDetectionType() == DetectionType.CORNER) {
                obj = next;
                break;
            }
        }
        document.setEdge(UtilsKt.getCornerData((DetectionMetric) obj));
        return document;
    }

    public final String a(CameraManager cameraManager, int i) {
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_MM", "getCameraId called");
        String[] cameraIdList = cameraManager.getCameraIdList();
        Intrinsics.checkNotNullExpressionValue(cameraIdList, "cManager.cameraIdList");
        for (String str : cameraIdList) {
            CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
            Intrinsics.checkNotNullExpressionValue(cameraCharacteristics, "cManager.getCameraCharacteristics(cameraId)");
            Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
            if (num != null && num.intValue() == i) {
                return str;
            }
        }
        return null;
    }

    public final String a(String str) {
        Object obj;
        MetricData metricData = this.b;
        if (metricData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("metricData");
            metricData = null;
        }
        Iterator<T> it = metricData.getDevices().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((CameraDevice) obj).getLabel(), str)) {
                break;
            }
        }
        CameraDevice cameraDevice = (CameraDevice) obj;
        if (cameraDevice != null) {
            return cameraDevice.getDeviceId();
        }
        return null;
    }

    public final void a(MetricCaptureData metricCaptureData) {
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_MM", "updateDocumentMetric scanType: " + metricCaptureData + ".scanType || metricList: " + new Gson().toJson(metricCaptureData.getMetrics()));
        try {
            MetricData metricData = this.b;
            if (metricData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("metricData");
                metricData = null;
            }
            if (metricData.getDocuments() == null) {
                MetricData metricData2 = this.b;
                if (metricData2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("metricData");
                    metricData2 = null;
                }
                metricData2.setDocuments(new Documents(null, null, null, 7, null));
            }
            int i = a.f289a[metricCaptureData.getScanType().ordinal()];
            if (i != 1 && i != 2 && i != 3) {
                if (i != 4) {
                    return;
                }
                com.socure.docv.capturesdk.common.logger.b.b("SDLT_MM", "updating the selfie");
                MetricData metricData3 = this.b;
                if (metricData3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("metricData");
                    metricData3 = null;
                }
                Documents documents = metricData3.getDocuments();
                if (documents == null) {
                    return;
                }
                documents.setSelfPortrait(new Selfie(metricCaptureData.getCaptureType().getValue(), a(ConstantsKt.FRONT_CAMERA), metricCaptureData.getFaces()));
                return;
            }
            Document a2 = a(metricCaptureData.getCaptureType(), metricCaptureData.getMetrics());
            a2.setDeviceId(a(ConstantsKt.BACK_CAMERA));
            a2.setFaces(metricCaptureData.getFaces());
            if (metricCaptureData.getScanType() == ScanType.LICENSE_BACK) {
                a2.setBarcode(new Barcode(metricCaptureData.getExtractionDataDetected(), null, null, 6, null));
                com.socure.docv.capturesdk.common.logger.b.b("SDLT_MM", "updating the back document");
                MetricData metricData4 = this.b;
                if (metricData4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("metricData");
                    metricData4 = null;
                }
                Documents documents2 = metricData4.getDocuments();
                if (documents2 == null) {
                    return;
                }
                documents2.setDocumentBack(a2);
                return;
            }
            if (metricCaptureData.getScanType() == ScanType.PASSPORT) {
                a2.setMrz(new Mrz(metricCaptureData.getExtractionDataDetected()));
            }
            com.socure.docv.capturesdk.common.logger.b.b("SDLT_MM", "updating the front document");
            MetricData metricData5 = this.b;
            if (metricData5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("metricData");
                metricData5 = null;
            }
            Documents documents3 = metricData5.getDocuments();
            if (documents3 == null) {
                return;
            }
            documents3.setDocumentFront(a2);
        } catch (Throwable th) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_MM", "updateDocumentMetric error: " + th.getLocalizedMessage(), null, 4, null);
        }
    }

    public final void a(ScanType scanType, CaptureMetadata captureMetadata) {
        String str;
        Object obj;
        CameraDevice cameraDevice;
        Unit unit;
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_MM", "updateCaptureMetaData");
        try {
            MetricData metricData = this.b;
            if (metricData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("metricData");
                metricData = null;
            }
            if (captureMetadata != null) {
                Iterator<T> it = metricData.getDevices().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    } else {
                        obj = it.next();
                        if (Intrinsics.areEqual(((CameraDevice) obj).getLabel(), UtilsKt.getLabel(scanType))) {
                            break;
                        }
                    }
                }
                CameraDevice cameraDevice2 = (CameraDevice) obj;
                if (cameraDevice2 != null) {
                    int indexOf = metricData.getDevices().indexOf(cameraDevice2);
                    com.socure.docv.capturesdk.common.logger.b.b("SDLT_MM", "index is " + indexOf);
                    Settings settings = cameraDevice2.getSettings();
                    if (settings != null) {
                        settings.setWidth(Integer.valueOf(captureMetadata.getResolution().getWidth()));
                        settings.setHeight(Integer.valueOf(captureMetadata.getResolution().getHeight()));
                        cameraDevice2.setSettings(settings);
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        com.socure.docv.capturesdk.common.logger.b.a("SDLT_MM", "cameraDevice settings is null");
                    }
                    MetricData metricData2 = this.b;
                    if (metricData2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("metricData");
                        metricData2 = null;
                    }
                    cameraDevice = metricData2.getDevices().set(indexOf, cameraDevice2);
                } else {
                    cameraDevice = null;
                }
                if (cameraDevice != null) {
                    return;
                } else {
                    str = "updateCaptureMetaData currentDevice is null";
                }
            } else {
                str = "updateCaptureMetaData captureMetadata is null";
            }
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_MM", str);
        } catch (Throwable th) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_MM", "updateCaptureMetaData error: " + th.getLocalizedMessage(), null, 4, null);
        }
    }

    public final void b(MetricCaptureData metricCaptureData) {
        Intrinsics.checkNotNullParameter(metricCaptureData, "metricCaptureData");
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_MM", "setSettingResolution called");
        try {
            a(metricCaptureData.getScanType(), metricCaptureData.getCaptureMetadata());
            a(metricCaptureData);
            Gson gson = new Gson();
            MetricData metricData = this.b;
            if (metricData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("metricData");
                metricData = null;
            }
            com.socure.docv.capturesdk.common.logger.b.b("SDLT_MM", "setSettingResolution metricData: " + gson.toJson(metricData));
        } catch (Throwable th) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_MM", "updatingMetricData error msg: " + th.getMessage(), null, 4, null);
        }
    }

    public final void a(String str, String str2) {
        Unit unit;
        MinMaxInt frameRate;
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_MM", "setMetricData - label: " + str + " || facingMode: " + str2);
        try {
            if (this.b == null) {
                com.socure.docv.capturesdk.common.logger.b.a("SDLT_MM", "metricData is null");
                this.b = new MetricData(null, null, null, 7, null);
            } else {
                com.socure.docv.capturesdk.common.logger.b.b("SDLT_MM", "metricData is not null");
            }
            Object systemService = this.f288a.getSystemService("camera");
            if (systemService == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.hardware.camera2.CameraManager");
            }
            CameraManager cameraManager = (CameraManager) systemService;
            CameraDevice cameraDevice = new CameraDevice(null, new Capabilities(null, null, new MinMaxInt(0, 0, 3, null), null, null, new MinMaxInt(0, 0, 3, null), 27, null), null, null, null, 29, null);
            cameraDevice.setLabel(str);
            cameraDevice.setDeviceId(a(cameraManager, !Intrinsics.areEqual(str, ConstantsKt.FRONT_CAMERA) ? 1 : 0));
            cameraDevice.setModelID(cameraDevice.getDeviceId());
            String deviceId = cameraDevice.getDeviceId();
            if (deviceId != null) {
                cameraDevice.setCapabilities(a(cameraManager, deviceId, str));
                Capabilities capabilities = cameraDevice.getCapabilities();
                com.socure.docv.capturesdk.common.logger.b.b("SDLT_MM", "getSettingData called");
                Settings settings = new Settings(null, null, null, null, null, 31, null);
                settings.setFacingMode(str2);
                settings.setDeviceId(deviceId);
                settings.setFrameRate((capabilities == null || (frameRate = capabilities.getFrameRate()) == null) ? null : Integer.valueOf(frameRate.getMax()));
                cameraDevice.setSettings(settings);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                com.socure.docv.capturesdk.common.logger.b.a("SDLT_MM", "deviceId is null");
            }
            MetricData metricData = this.b;
            if (metricData == null) {
                Intrinsics.throwUninitializedPropertyAccessException("metricData");
                metricData = null;
            }
            metricData.getDevices().add(cameraDevice);
        } catch (Throwable th) {
            com.socure.docv.capturesdk.common.logger.b.a("SDLT_MM", "setMetricData error: " + th.getLocalizedMessage(), null, 4, null);
        }
    }

    public final void a(ArrayList<Screen> screens) {
        boolean z;
        MetricData metricData;
        Object obj;
        Intrinsics.checkNotNullParameter(screens, "screens");
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_MM", "setScanType called scanTypes: " + CollectionsKt.joinToString$default(screens, null, null, null, 0, null, null, 63, null));
        if (!(screens instanceof Collection) || !screens.isEmpty()) {
            for (Screen screen : screens) {
                if (screen.getScanType() == ScanType.LICENSE_FRONT || screen.getScanType() == ScanType.LICENSE_BACK || screen.getScanType() == ScanType.PASSPORT) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (z) {
            a(ConstantsKt.BACK_CAMERA, "environment");
        }
        Iterator<T> it = screens.iterator();
        while (true) {
            metricData = null;
            if (it.hasNext()) {
                obj = it.next();
                if (((Screen) obj).getScanType() == ScanType.SELFIE) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (((Screen) obj) != null) {
            a(ConstantsKt.FRONT_CAMERA, "user");
        }
        com.socure.docv.capturesdk.common.logger.b.b("SDLT_MM", "updateUserAgent called");
        MetricData metricData2 = this.b;
        if (metricData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("metricData");
        } else {
            metricData = metricData2;
        }
        metricData.setUserAgent(ApiConstant.USER_AGENT_VALUE);
    }
}
