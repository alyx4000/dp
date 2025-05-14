package com.socure.docv.capturesdk.common.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import androidx.core.content.ContextCompat;
import androidx.core.view.PointerIconCompat;
import com.google.gson.Gson;
import com.socure.docv.capturesdk.api.DocumentType;
import com.socure.docv.capturesdk.common.analytics.model.MetricData;
import com.socure.docv.capturesdk.common.logger.b;
import com.socure.docv.capturesdk.common.network.model.stepup.Address;
import com.socure.docv.capturesdk.common.network.model.stepup.ExtractedStepUpData;
import com.socure.docv.capturesdk.common.network.model.stepup.Label;
import com.socure.docv.capturesdk.common.network.model.stepup.NewLabels;
import com.socure.docv.capturesdk.common.network.model.stepup.Screens;
import com.socure.docv.capturesdk.common.network.model.stepup.UploadImage;
import com.socure.docv.capturesdk.common.network.model.stepup.UploadStatus;
import com.socure.docv.capturesdk.common.network.model.stepup.Websdk;
import com.socure.docv.capturesdk.core.extractor.model.a;
import com.socure.docv.capturesdk.core.extractor.model.d;
import com.socure.docv.capturesdk.core.pipeline.model.Facet;
import com.socure.docv.capturesdk.core.pipeline.model.ScanType;
import com.socure.docv.capturesdk.core.processor.model.CaptureMetadata;
import com.socure.docv.capturesdk.core.processor.model.DetectionMetric;
import com.socure.docv.capturesdk.core.processor.model.DetectionType;
import com.socure.docv.capturesdk.core.processor.model.Output;
import com.socure.docv.capturesdk.feature.scanner.data.DetectionCallback;
import com.socure.docv.capturesdk.feature.scanner.data.Dimension;
import io.sentry.SentryEnvelopeItemHeader;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.CharRange;
import kotlin.text.StringsKt;
import okhttp3.MultipartBody;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

@Metadata(bv = {}, d1 = {"\u0000ô\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0014\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0011\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u000b\b\u0002¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0016\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012J\u000f\u0010\u0018\u001a\u00020\u0015H\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001d\u001a\u00020\u0015H\u0000¢\u0006\u0004\b\u001c\u0010\u0017J\u0017\u0010 \u001a\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010%\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020!H\u0000¢\u0006\u0004\b#\u0010$J\u001f\u0010+\u001a\u00020!2\u0006\u0010&\u001a\u00020!2\u0006\u0010(\u001a\u00020'H\u0000¢\u0006\u0004\b)\u0010*J%\u00100\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!\u0018\u00010-2\u0006\u0010,\u001a\u00020!H\u0000¢\u0006\u0004\b.\u0010/J\u0017\u00104\u001a\u0002012\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b2\u00103J\u000f\u00108\u001a\u000205H\u0000¢\u0006\u0004\b6\u00107J\u001e\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u00109\u001a\u00020\u0015J\u001e\u0010;\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u00109\u001a\u00020\u0015J\u0010\u0010<\u001a\u00020\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u000e\u0010=\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0002J\u0017\u0010C\u001a\u00020@2\u0006\u0010?\u001a\u00020>H\u0000¢\u0006\u0004\bA\u0010BJY\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0D2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0D2*\u0010G\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0-0F\"\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0-¢\u0006\u0004\bH\u0010IJ\u0017\u0010M\u001a\u00020\f2\u0006\u0010J\u001a\u000201H\u0000¢\u0006\u0004\bK\u0010LJ)\u0010Q\u001a\u0004\u0018\u00010\f2\u0016\u0010N\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0000¢\u0006\u0004\bO\u0010PJ/\u0010Q\u001a\u00020\f2\u0016\u0010N\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\bO\u0010RJ'\u0010V\u001a\u00020S2\u0016\u0010N\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nH\u0000¢\u0006\u0004\bT\u0010UJ+\u0010[\u001a\u00020\f2\u0006\u0010W\u001a\u00020\f2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010X\u001a\u00020SH\u0000¢\u0006\u0004\bY\u0010ZJ3\u0010b\u001a\u00020\f2\"\u0010_\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020]0\\j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020]`^H\u0000¢\u0006\u0004\b`\u0010aJ1\u0010h\u001a\b\u0012\u0004\u0012\u00020c0F2\f\u0010d\u001a\b\u0012\u0004\u0012\u00020c0F2\f\u0010e\u001a\b\u0012\u0004\u0012\u00020c0FH\u0000¢\u0006\u0004\bf\u0010gJ-\u0010o\u001a\u0004\u0018\u00010\f2\u0006\u0010i\u001a\u00020\f2\b\b\u0002\u0010j\u001a\u00020\f2\b\b\u0002\u0010l\u001a\u00020kH\u0000¢\u0006\u0004\bm\u0010nJ\u001f\u0010t\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010q\u001a\u00020pH\u0000¢\u0006\u0004\br\u0010sJ\u0017\u0010w\u001a\u00020\f2\u0006\u0010q\u001a\u00020pH\u0000¢\u0006\u0004\bu\u0010vJ\u0012\u0010{\u001a\u0004\u0018\u00010z2\b\u0010y\u001a\u0004\u0018\u00010xJ6\u0010|\u001a\u0004\u0018\u00010z2\"\u0010_\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020]0\\j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020]`^2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J,\u0010}\u001a\u0004\u0018\u00010z2\"\u0010_\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020]0\\j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020]`^J\u0010\u0010\u0081\u0001\u001a\u00030\u0080\u00012\u0006\u0010\u007f\u001a\u00020~J!\u0010\u0084\u0001\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\b\u0010\u0083\u0001\u001a\u00030\u0082\u0001J*\u0010\u0084\u0001\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\b\u0010\u0086\u0001\u001a\u00030\u0085\u00012\u0007\u0010\u0087\u0001\u001a\u00020\u0015J\u001b\u0010\u008b\u0001\u001a\u0002012\u0007\u0010\u0088\u0001\u001a\u000201H\u0000¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001JO\u0010\u0091\u0001\u001a!\u0012\u0004\u0012\u00020]\u0012\u0017\u0012\u0015\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0-0\u008e\u00010-2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u008d\u0001\u001a\u00030\u008c\u00012\n\b\u0002\u0010y\u001a\u0004\u0018\u00010xH\u0000¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001¨\u0006\u0094\u0001"}, d2 = {"Lcom/socure/docv/capturesdk/common/utils/Utils;", "", "Landroid/content/Context;", "context", "Lcom/socure/docv/capturesdk/core/pipeline/model/ScanType;", "scanType", "Ljava/io/File;", "getExternalScanVideoFolderPath", "Ljava/util/ArrayList;", "Lcom/socure/docv/capturesdk/common/utils/Screen;", "Lkotlin/collections/ArrayList;", "getSelfieFlow", "", "getFacet", "docType", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Screens;", "screens", "getHelpTitle", "", "bytes", "getBytesToHr", "", "showDebugImage$capturesdk_productionRelease", "()Z", "showDebugImage", "getVideoPath$capturesdk_productionRelease", "(Landroid/content/Context;Lcom/socure/docv/capturesdk/core/pipeline/model/ScanType;)Ljava/lang/String;", "getVideoPath", "isAutomationFlavor$capturesdk_productionRelease", "isAutomationFlavor", "isSelfie$capturesdk_productionRelease", "(Lcom/socure/docv/capturesdk/core/pipeline/model/ScanType;)Z", "isSelfie", "", "floatArray", "cornersFound$capturesdk_productionRelease", "([F)Z", "cornersFound", "coordinatesArray", "", "horizontalConf", "appendResultAndHorizontalConf$capturesdk_productionRelease", "([FF)[F", "appendResultAndHorizontalConf", "combinedArray", "Lkotlin/Pair;", "separateHorizontalConfArray$capturesdk_productionRelease", "([F)Lkotlin/Pair;", "separateHorizontalConfArray", "", "getLensFacing$capturesdk_productionRelease", "(Lcom/socure/docv/capturesdk/core/pipeline/model/ScanType;)I", "getLensFacing", "Landroid/graphics/RectF;", "getSelfieGuidingBoxDimension$capturesdk_productionRelease", "()Landroid/graphics/RectF;", "getSelfieGuidingBoxDimension", "enableSelfie", "getLicFlow", "getPassportFlow", "getEventType", "hasCameraPermission", "Lcom/socure/docv/capturesdk/core/processor/model/DetectionMetric;", "detectionMetric", "Lcom/socure/docv/capturesdk/feature/scanner/data/DetectionCallback;", "getDetectionCallback$capturesdk_productionRelease", "(Lcom/socure/docv/capturesdk/core/processor/model/DetectionMetric;)Lcom/socure/docv/capturesdk/feature/scanner/data/DetectionCallback;", "getDetectionCallback", "", "map", "", "args", "argsIntoAttrs", "(Ljava/util/Map;[Lkotlin/Pair;)Ljava/util/Map;", SentryEnvelopeItemHeader.JsonKeys.LENGTH, "randomString$capturesdk_productionRelease", "(I)Ljava/lang/String;", "randomString", "screenFlow", "getDocSelFacet$capturesdk_productionRelease", "(Ljava/util/ArrayList;)Ljava/lang/String;", "getDocSelFacet", "(Ljava/util/ArrayList;Lcom/socure/docv/capturesdk/core/pipeline/model/ScanType;)Ljava/lang/String;", "Lcom/socure/docv/capturesdk/common/analytics/a;", "getSelection$capturesdk_productionRelease", "(Ljava/util/ArrayList;)Lcom/socure/docv/capturesdk/common/analytics/a;", "getSelection", "event", "docSelection", "replacePlaceholders$capturesdk_productionRelease", "(Ljava/lang/String;Lcom/socure/docv/capturesdk/core/pipeline/model/ScanType;Lcom/socure/docv/capturesdk/common/analytics/a;)Ljava/lang/String;", "replacePlaceholders", "Ljava/util/LinkedHashMap;", "Lcom/socure/docv/capturesdk/common/network/model/stepup/UploadImage;", "Lkotlin/collections/LinkedHashMap;", "uploadImageMap", "getJObjFromMap$capturesdk_productionRelease", "(Ljava/util/LinkedHashMap;)Ljava/lang/String;", "getJObjFromMap", "Lcom/socure/docv/capturesdk/core/processor/model/DetectionType;", "autoSteps", "manualCaptureSteps", "getSuperSetSteps$capturesdk_productionRelease", "([Lcom/socure/docv/capturesdk/core/processor/model/DetectionType;[Lcom/socure/docv/capturesdk/core/processor/model/DetectionType;)[Lcom/socure/docv/capturesdk/core/processor/model/DetectionType;", "getSuperSetSteps", "date", "format", "Ljava/util/Locale;", "locale", "getFormattedDate$capturesdk_productionRelease", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Locale;)Ljava/lang/String;", "getFormattedDate", "Lcom/socure/docv/capturesdk/common/network/model/stepup/NewLabels;", "newLabels", "getContBtnText$capturesdk_productionRelease", "(Lcom/socure/docv/capturesdk/core/pipeline/model/ScanType;Lcom/socure/docv/capturesdk/common/network/model/stepup/NewLabels;)Ljava/lang/String;", "getContBtnText", "getRetakeBtnText$capturesdk_productionRelease", "(Lcom/socure/docv/capturesdk/common/network/model/stepup/NewLabels;)Ljava/lang/String;", "getRetakeBtnText", "Lcom/socure/docv/capturesdk/core/extractor/model/a;", "extractedData", "Lcom/socure/docv/capturesdk/common/network/model/stepup/ExtractedStepUpData;", "rawToStepUpExtractedData", "getBaseExtractedData", "getBaseExtractedDataForEnd", "Lcom/socure/docv/capturesdk/common/analytics/model/MetricData;", "metricData", "Lokhttp3/MultipartBody$Part;", "getMultiPartBodyFromMetricData", "Lcom/socure/docv/capturesdk/common/network/model/stepup/Websdk;", "websdk", "getScreenSequence", "Lcom/socure/docv/capturesdk/api/DocumentType;", ApiConstant.DOCUMENT_TYPE, "selfieEnabled", "dp", "dpToPx$capturesdk_productionRelease", "(I)I", "dpToPx", "Lcom/socure/docv/capturesdk/core/processor/model/Output;", "output", "", "getOutputAndMetaData$capturesdk_productionRelease", "(Lcom/socure/docv/capturesdk/core/pipeline/model/ScanType;Lcom/socure/docv/capturesdk/core/processor/model/Output;Lcom/socure/docv/capturesdk/core/extractor/model/a;)Lkotlin/Pair;", "getOutputAndMetaData", "<init>", "()V", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes5.dex */
public final class Utils {
    public static final Utils INSTANCE = new Utils();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[ScanType.values().length];
            iArr[ScanType.LICENSE_FRONT.ordinal()] = 1;
            iArr[ScanType.LICENSE_BACK.ordinal()] = 2;
            iArr[ScanType.SELFIE.ordinal()] = 3;
            iArr[ScanType.PASSPORT.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[DetectionType.values().length];
            iArr2[DetectionType.CORNER.ordinal()] = 1;
            iArr2[DetectionType.BLUR.ordinal()] = 2;
            iArr2[DetectionType.BRIGHTNESS.ordinal()] = 3;
            iArr2[DetectionType.GLARE.ordinal()] = 4;
            iArr2[DetectionType.SELFIE.ordinal()] = 5;
            iArr2[DetectionType.BARCODE.ordinal()] = 6;
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[DocumentType.values().length];
            iArr3[DocumentType.LICENSE.ordinal()] = 1;
            iArr3[DocumentType.PASSPORT.ordinal()] = 2;
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    private Utils() {
    }

    private final File getExternalScanVideoFolderPath(Context context, ScanType scanType) {
        File externalFilesDir = context.getExternalFilesDir(null);
        String absolutePath = externalFilesDir != null ? externalFilesDir.getAbsolutePath() : null;
        String str = File.separator;
        return new File(absolutePath + str + scanType.name() + str);
    }

    private final String getFacet(ScanType scanType) {
        Facet facet;
        int i = WhenMappings.$EnumSwitchMapping$0[scanType.ordinal()];
        if (i != 1) {
            if (i == 2) {
                facet = Facet.DOC_BACK;
            } else if (i == 3) {
                facet = Facet.SELFIE;
            } else if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            return facet.getValue();
        }
        facet = Facet.DOC_FRONT;
        return facet.getValue();
    }

    public static /* synthetic */ String getFormattedDate$capturesdk_productionRelease$default(Utils utils, String str, String str2, Locale US, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = "yyyyMMdd";
        }
        if ((i & 4) != 0) {
            US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
        }
        return utils.getFormattedDate$capturesdk_productionRelease(str, str2, US);
    }

    public static /* synthetic */ Pair getOutputAndMetaData$capturesdk_productionRelease$default(Utils utils, ScanType scanType, Output output, a aVar, int i, Object obj) {
        if ((i & 4) != 0) {
            aVar = null;
        }
        return utils.getOutputAndMetaData$capturesdk_productionRelease(scanType, output, aVar);
    }

    private final ArrayList<Screen> getSelfieFlow() {
        ArrayList<Screen> arrayList = new ArrayList<>();
        arrayList.add(new Screen(1, State.INCOMPLETE, ScanType.SELFIE));
        return arrayList;
    }

    public static /* synthetic */ String replacePlaceholders$capturesdk_productionRelease$default(Utils utils, String str, ScanType scanType, com.socure.docv.capturesdk.common.analytics.a aVar, int i, Object obj) {
        if ((i & 2) != 0) {
            scanType = null;
        }
        return utils.replacePlaceholders$capturesdk_productionRelease(str, scanType, aVar);
    }

    public final float[] appendResultAndHorizontalConf$capturesdk_productionRelease(float[] coordinatesArray, float horizontalConf) {
        Intrinsics.checkNotNullParameter(coordinatesArray, "coordinatesArray");
        List<Float> mutableList = ArraysKt.toMutableList(coordinatesArray);
        mutableList.add(Float.valueOf(horizontalConf));
        return CollectionsKt.toFloatArray(mutableList);
    }

    public final Map<String, String> argsIntoAttrs(Map<String, String> map, Pair<String, String>... args) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(args, "args");
        if (!(!(args.length == 0))) {
            return map;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Pair<String, String> pair : args) {
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        linkedHashMap.putAll(map);
        return linkedHashMap;
    }

    public final boolean cornersFound$capturesdk_productionRelease(float[] floatArray) {
        Intrinsics.checkNotNullParameter(floatArray, "floatArray");
        return floatArray.length == 12 && floatArray[2] >= 0.9f && floatArray[5] >= 0.9f && floatArray[8] >= 0.9f && floatArray[11] >= 0.9f;
    }

    public final int dpToPx$capturesdk_productionRelease(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public final ExtractedStepUpData getBaseExtractedData(LinkedHashMap<ScanType, UploadImage> uploadImageMap, ScanType scanType) {
        UploadImage uploadImage;
        Intrinsics.checkNotNullParameter(uploadImageMap, "uploadImageMap");
        b.b("SDLT_UTIL", "getBaseExtractedData called");
        if (scanType == null || (uploadImage = uploadImageMap.get(scanType)) == null) {
            return null;
        }
        return uploadImage.getExtractedData();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0033, code lost:
    
        if (r3 != null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x001e, code lost:
    
        if (r3 != null) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:?, code lost:
    
        return r3.getExtractedData();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.socure.docv.capturesdk.common.network.model.stepup.ExtractedStepUpData getBaseExtractedDataForEnd(java.util.LinkedHashMap<com.socure.docv.capturesdk.core.pipeline.model.ScanType, com.socure.docv.capturesdk.common.network.model.stepup.UploadImage> r3) {
        /*
            r2 = this;
            java.lang.String r0 = "uploadImageMap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "SDLT_UTIL"
            java.lang.String r1 = "getBaseExtractedDataForEnd called"
            com.socure.docv.capturesdk.common.logger.b.b(r0, r1)
            java.util.Set r0 = r3.keySet()
            com.socure.docv.capturesdk.core.pipeline.model.ScanType r1 = com.socure.docv.capturesdk.core.pipeline.model.ScanType.LICENSE_BACK
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L21
            java.lang.Object r3 = r3.get(r1)
            com.socure.docv.capturesdk.common.network.model.stepup.UploadImage r3 = (com.socure.docv.capturesdk.common.network.model.stepup.UploadImage) r3
            if (r3 == 0) goto L3a
            goto L35
        L21:
            java.util.Set r0 = r3.keySet()
            com.socure.docv.capturesdk.core.pipeline.model.ScanType r1 = com.socure.docv.capturesdk.core.pipeline.model.ScanType.PASSPORT
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L3a
            java.lang.Object r3 = r3.get(r1)
            com.socure.docv.capturesdk.common.network.model.stepup.UploadImage r3 = (com.socure.docv.capturesdk.common.network.model.stepup.UploadImage) r3
            if (r3 == 0) goto L3a
        L35:
            com.socure.docv.capturesdk.common.network.model.stepup.ExtractedStepUpData r3 = r3.getExtractedData()
            goto L3b
        L3a:
            r3 = 0
        L3b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.socure.docv.capturesdk.common.utils.Utils.getBaseExtractedDataForEnd(java.util.LinkedHashMap):com.socure.docv.capturesdk.common.network.model.stepup.ExtractedStepUpData");
    }

    public final String getBytesToHr(long bytes) {
        StringBuilder append;
        String str;
        if (bytes > 1048576) {
            append = new StringBuilder().append(bytes / 1048576);
            str = " MB";
        } else if (bytes > 1024) {
            append = new StringBuilder().append(bytes / 1024);
            str = " KB";
        } else {
            append = new StringBuilder().append(bytes);
            str = " B";
        }
        return append.append(str).toString();
    }

    public final String getContBtnText$capturesdk_productionRelease(ScanType scanType, NewLabels newLabels) {
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        Intrinsics.checkNotNullParameter(newLabels, "newLabels");
        int i = WhenMappings.$EnumSwitchMapping$0[scanType.ordinal()];
        if (i != 1 && i != 2) {
            if (i == 3) {
                return newLabels.getPreviewSelfieSubmit();
            }
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return newLabels.getPreviewDocSubmit();
    }

    public final DetectionCallback getDetectionCallback$capturesdk_productionRelease(DetectionMetric detectionMetric) {
        Intrinsics.checkNotNullParameter(detectionMetric, "detectionMetric");
        switch (WhenMappings.$EnumSwitchMapping$1[detectionMetric.getDetectionType().ordinal()]) {
            case 1:
                DetectionCallback detectionCallback = detectionMetric.getDetectionCallback();
                DetectionCallback detectionCallback2 = DetectionCallback.DOCUMENT_TOO_CLOSE;
                return detectionCallback == detectionCallback2 ? detectionCallback2 : DetectionCallback.CORNER_DETECTION_FAILED;
            case 2:
                return DetectionCallback.BLUR_DETECTED;
            case 3:
                return DetectionCallback.LOW_BRIGHTNESS;
            case 4:
                return DetectionCallback.GLARE_DETECTED;
            case 5:
                DetectionCallback detectionCallback3 = detectionMetric.getDetectionCallback();
                return detectionCallback3 == null ? DetectionCallback.FACE_NOT_FOUND : detectionCallback3;
            case 6:
                return DetectionCallback.BARCODE_NOT_FOUND;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final String getDocSelFacet$capturesdk_productionRelease(ArrayList<Screen> screenFlow) {
        Intrinsics.checkNotNullParameter(screenFlow, "screenFlow");
        if (ScreenKt.isComplete(screenFlow)) {
            return null;
        }
        return getSelection$capturesdk_productionRelease(screenFlow).a() + "_" + getFacet(ScreenKt.getCurrent(screenFlow).getScanType());
    }

    public final String getDocSelFacet$capturesdk_productionRelease(ArrayList<Screen> screenFlow, ScanType scanType) {
        Intrinsics.checkNotNullParameter(screenFlow, "screenFlow");
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        return getSelection$capturesdk_productionRelease(screenFlow).a() + "_" + getFacet(scanType);
    }

    public final String getEventType(ScanType scanType) {
        if (scanType == null) {
            return "";
        }
        int i = WhenMappings.$EnumSwitchMapping$0[scanType.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return ApiConstant.LIC_BACK_UPDATE_EVENT;
            }
            if (i == 3) {
                return ApiConstant.SELFIE_UPDATE_EVENT;
            }
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
        }
        return ApiConstant.LIC_FRONT_UPDATE_EVENT;
    }

    public final String getFormattedDate$capturesdk_productionRelease(String date, String format, Locale locale) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(locale, "locale");
        try {
            Date parse = new SimpleDateFormat(format, locale).parse(date);
            if (parse != null) {
                return new SimpleDateFormat(ConstantsKt.READABLE_DATE_FORMAT, locale).format(parse).toString();
            }
            return null;
        } catch (Exception e) {
            b.a("SDLT_UTIL", "ex in getFormattedDate: " + e.getLocalizedMessage(), null, 4, null);
            return null;
        }
    }

    public final String getHelpTitle(ScanType docType, Screens screens) {
        Label header;
        Intrinsics.checkNotNullParameter(docType, "docType");
        Intrinsics.checkNotNullParameter(screens, "screens");
        int i = WhenMappings.$EnumSwitchMapping$0[docType.ordinal()];
        if (i == 1) {
            header = screens.getFrontId().getHeader();
        } else if (i == 2) {
            header = screens.getBackId().getHeader();
        } else if (i == 3) {
            header = screens.getSelfie().getHeader();
        } else {
            if (i != 4) {
                throw new NoWhenBranchMatchedException();
            }
            header = screens.getPassport().getHeader();
        }
        return header.getLabel();
    }

    public final String getJObjFromMap$capturesdk_productionRelease(LinkedHashMap<ScanType, UploadImage> uploadImageMap) {
        Intrinsics.checkNotNullParameter(uploadImageMap, "uploadImageMap");
        ArrayList arrayList = new ArrayList();
        Collection<UploadImage> values = uploadImageMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "uploadImageMap.values");
        for (UploadImage uploadImage : values) {
            if (uploadImage.getUploadStatus() == UploadStatus.ERROR) {
                arrayList.add(INSTANCE.getFacet(uploadImage.getScanType()));
            }
        }
        String json = new Gson().toJson(arrayList);
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(failedItems)");
        return json;
    }

    public final int getLensFacing$capturesdk_productionRelease(ScanType scanType) {
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        return scanType != ScanType.SELFIE ? 1 : 0;
    }

    public final ArrayList<Screen> getLicFlow(boolean enableSelfie) {
        ArrayList<Screen> arrayList = new ArrayList<>();
        State state = State.INCOMPLETE;
        arrayList.add(new Screen(1, state, ScanType.LICENSE_FRONT));
        arrayList.add(new Screen(2, state, ScanType.LICENSE_BACK));
        if (enableSelfie) {
            arrayList.add(new Screen(3, state, ScanType.SELFIE));
        }
        return arrayList;
    }

    public final MultipartBody.Part getMultiPartBodyFromMetricData(MetricData metricData) {
        Intrinsics.checkNotNullParameter(metricData, "metricData");
        String json = new Gson().toJson(metricData);
        Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(metricData)");
        return ApiUtilsKt.toMetricRequestBody(json);
    }

    public final Pair<UploadImage, List<Pair<String, String>>> getOutputAndMetaData$capturesdk_productionRelease(ScanType scanType, Output output, a extractedData) {
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        Intrinsics.checkNotNullParameter(output, "output");
        b.b("SDLT_UTIL", "getOutputAndMetaData called");
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("compressed_image_width", String.valueOf(output.getFinalBitmap().getWidth())));
        arrayList.add(new Pair("compressed_image_height", String.valueOf(output.getFinalBitmap().getHeight())));
        UploadImage uploadImage = new UploadImage();
        ImageUtils imageUtils = ImageUtils.INSTANCE;
        uploadImage.setDocumentBody(imageUtils.getMultipartBody$capturesdk_productionRelease(output, scanType));
        uploadImage.setScanType(scanType);
        uploadImage.setCaptureType(output.getCaptureType());
        uploadImage.setExtractedData(rawToStepUpExtractedData(extractedData));
        uploadImage.setDimension(new Dimension(output.getFinalBitmap().getWidth(), output.getFinalBitmap().getHeight()));
        uploadImage.setSelfieMetrics(UtilsKt.getSelfieMetrics(output));
        uploadImage.setImage(imageUtils.bitmapToByteArray$capturesdk_productionRelease(output.getFinalBitmap()));
        arrayList.add(new Pair("compressed_file_size", String.valueOf(uploadImage.getImage().length)));
        CaptureMetadata captureMetadata = output.getCaptureMetadata();
        if (captureMetadata != null) {
            arrayList.add(new Pair("captured_image_width", String.valueOf(captureMetadata.getResolution().getWidth())));
            arrayList.add(new Pair("captured_image_height", String.valueOf(captureMetadata.getResolution().getHeight())));
            Integer originalSize = captureMetadata.getOriginalSize();
            if (originalSize != null) {
                arrayList.add(new Pair("captured_file_size", String.valueOf(originalSize.intValue())));
            }
        }
        return new Pair<>(uploadImage, arrayList);
    }

    public final ArrayList<Screen> getPassportFlow(boolean enableSelfie) {
        ArrayList<Screen> arrayList = new ArrayList<>();
        State state = State.INCOMPLETE;
        arrayList.add(new Screen(1, state, ScanType.PASSPORT));
        if (enableSelfie) {
            arrayList.add(new Screen(2, state, ScanType.SELFIE));
        }
        return arrayList;
    }

    public final String getRetakeBtnText$capturesdk_productionRelease(NewLabels newLabels) {
        Intrinsics.checkNotNullParameter(newLabels, "newLabels");
        return newLabels.getRetake();
    }

    public final ArrayList<Screen> getScreenSequence(DocumentType documentType, boolean selfieEnabled) {
        Intrinsics.checkNotNullParameter(documentType, "documentType");
        b.b("SDLT_UTIL", "getScreenSequence with docType called");
        int i = WhenMappings.$EnumSwitchMapping$2[documentType.ordinal()];
        if (i == 1) {
            return getLicFlow(selfieEnabled);
        }
        if (i == 2) {
            return getPassportFlow(selfieEnabled);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final ArrayList<Screen> getScreenSequence(Websdk websdk) {
        Intrinsics.checkNotNullParameter(websdk, "websdk");
        b.b("SDLT_UTIL", "getScreenSequence called");
        String str = (String) CollectionsKt.firstOrNull((List) websdk.getDocumentTypes());
        return Intrinsics.areEqual(str, ApiConstant.DOCUMENT_TYPE_LICENSE) ? getLicFlow(websdk.getEnableSelfie().getValue()) : Intrinsics.areEqual(str, ApiConstant.DOCUMENT_TYPE_PASSPORT) ? getPassportFlow(websdk.getEnableSelfie().getValue()) : str == null ? getSelfieFlow() : new ArrayList<>();
    }

    public final com.socure.docv.capturesdk.common.analytics.a getSelection$capturesdk_productionRelease(ArrayList<Screen> screenFlow) {
        Intrinsics.checkNotNullParameter(screenFlow, "screenFlow");
        Iterator<T> it = screenFlow.iterator();
        while (it.hasNext()) {
            if (((Screen) it.next()).getScanType() == ScanType.PASSPORT) {
                return com.socure.docv.capturesdk.common.analytics.a.PASSPORT;
            }
        }
        return com.socure.docv.capturesdk.common.analytics.a.ID;
    }

    public final RectF getSelfieGuidingBoxDimension$capturesdk_productionRelease() {
        float f = Resources.getSystem().getDisplayMetrics().widthPixels;
        float f2 = 0.65f * f;
        float f3 = 1.3333334f * f2;
        float f4 = (f - f2) / 2;
        float dpToPx$capturesdk_productionRelease = dpToPx$capturesdk_productionRelease(60);
        return new RectF(f4, dpToPx$capturesdk_productionRelease, f2 + f4, f3 + dpToPx$capturesdk_productionRelease);
    }

    public final DetectionType[] getSuperSetSteps$capturesdk_productionRelease(DetectionType[] autoSteps, DetectionType[] manualCaptureSteps) {
        Intrinsics.checkNotNullParameter(autoSteps, "autoSteps");
        Intrinsics.checkNotNullParameter(manualCaptureSteps, "manualCaptureSteps");
        Set mutableSet = ArraysKt.toMutableSet(autoSteps);
        mutableSet.addAll(ArraysKt.toHashSet(manualCaptureSteps));
        Object[] array = mutableSet.toArray(new DetectionType[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (DetectionType[]) array;
    }

    public final String getVideoPath$capturesdk_productionRelease(Context context, ScanType scanType) {
        File file;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        File[] listFiles = getExternalScanVideoFolderPath(context, scanType).listFiles();
        String absolutePath = (listFiles == null || (file = listFiles[0]) == null) ? null : file.getAbsolutePath();
        if (absolutePath == null) {
            absolutePath = "";
        }
        b.b("SDLT_UTIL", "getVideoPath: " + absolutePath);
        return absolutePath;
    }

    public final boolean hasCameraPermission(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return ContextCompat.checkSelfPermission(context, "android.permission.CAMERA") == 0;
    }

    public final boolean isAutomationFlavor$capturesdk_productionRelease() {
        return StringsKt.equals(Scanner.FLAVOR_AUTOMATION, "production", false);
    }

    public final boolean isSelfie$capturesdk_productionRelease(ScanType scanType) {
        Intrinsics.checkNotNullParameter(scanType, "scanType");
        return scanType == ScanType.SELFIE;
    }

    public final String randomString$capturesdk_productionRelease(int length) {
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            arrayList.add(Character.valueOf(((Character) CollectionsKt.random(CollectionsKt.plus((Collection) CollectionsKt.plus((Iterable) new CharRange('a', 'z'), (Iterable) new CharRange('A', Matrix.MATRIX_TYPE_ZERO)), (Iterable) new CharRange('0', '9')), Random.INSTANCE)).charValue()));
        }
        return CollectionsKt.joinToString$default(arrayList, "", null, null, 0, null, null, 62, null);
    }

    public final ExtractedStepUpData rawToStepUpExtractedData(a extractedData) {
        ExtractedStepUpData extractedStepUpData;
        ExtractedStepUpData extractedStepUpData2 = null;
        if (extractedData != null) {
            ScanType scanType = extractedData.f375a;
            int i = scanType == null ? -1 : WhenMappings.$EnumSwitchMapping$0[scanType.ordinal()];
            if (i == 2) {
                com.socure.docv.capturesdk.core.extractor.model.b bVar = (com.socure.docv.capturesdk.core.extractor.model.b) extractedData;
                extractedStepUpData = new ExtractedStepUpData(null, null, null, "barcode", null, null, null, null, null, null, PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, null);
                extractedStepUpData.setFirstName(bVar.c);
                extractedStepUpData.setDob(bVar.q);
                extractedStepUpData.setExpirationDate(bVar.m);
                extractedStepUpData.setDocumentNumber(bVar.k);
                extractedStepUpData.setFullName(bVar.n);
                extractedStepUpData.setIssueDate(bVar.l);
                extractedStepUpData.setAddress(bVar.f);
                extractedStepUpData.setParsedAddress(new Address(bVar.s, bVar.f, bVar.g, bVar.i, bVar.e, bVar.h));
            } else if (i == 4) {
                d dVar = (d) extractedData;
                extractedStepUpData = new ExtractedStepUpData(null, null, null, ConstantsKt.MRZ_TYPE, null, null, null, null, null, null, PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW, null);
                extractedStepUpData.setFirstName(dVar.d);
                extractedStepUpData.setDob(dVar.h);
                extractedStepUpData.setExpirationDate(dVar.j);
                extractedStepUpData.setDocumentNumber(dVar.f);
                extractedStepUpData.setFullName(dVar.e);
                extractedStepUpData.setSurName(dVar.c);
            }
            extractedStepUpData2 = extractedStepUpData;
        }
        b.b("SDLT_UTIL", "updateExtractData: " + new Gson().toJson(extractedData));
        return extractedStepUpData2;
    }

    public final String replacePlaceholders$capturesdk_productionRelease(String event, ScanType scanType, com.socure.docv.capturesdk.common.analytics.a docSelection) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(docSelection, "docSelection");
        String replace$default = StringsKt.contains((CharSequence) event, (CharSequence) "[Document_Type]", false) ? StringsKt.replace$default(event, "[Document_Type]", docSelection.a(), false, 4, (Object) null) : event;
        return (scanType == null || !StringsKt.contains((CharSequence) event, (CharSequence) "[Capture_Type]", false)) ? replace$default : StringsKt.replace$default(replace$default, "[Capture_Type]", getFacet(scanType), false, 4, (Object) null);
    }

    public final Pair<float[], float[]> separateHorizontalConfArray$capturesdk_productionRelease(float[] combinedArray) {
        Intrinsics.checkNotNullParameter(combinedArray, "combinedArray");
        if (combinedArray.length != 13) {
            return null;
        }
        return new Pair<>(CollectionsKt.toFloatArray(ArraysKt.takeLast(combinedArray, 1)), CollectionsKt.toFloatArray(ArraysKt.take(combinedArray, 12)));
    }

    public final boolean showDebugImage$capturesdk_productionRelease() {
        return ConstantsKt.getSHOW_DEBUG_SCAN_STAGE();
    }
}
