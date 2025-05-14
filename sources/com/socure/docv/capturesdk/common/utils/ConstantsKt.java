package com.socure.docv.capturesdk.common.utils;

import com.socure.docv.capturesdk.api.Platform;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b0\n\u0002\u0018\u0002\n\u0002\b\u000e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"$\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0011j\b\u0012\u0004\u0012\u00020\b`\u0012X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u000e\u0010\u0015\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0017\u001a\u00020\u0018X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001a\u001a\u00020\u0018X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001b\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001c\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u0018X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0018X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0018X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020\u0018X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010%\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010&\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010'\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010(\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010)\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010*\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010+\u001a\u00020,X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010-\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010.\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010/\u001a\u00020\u0018X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u00100\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u00101\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u00102\u001a\u00020\u0018X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u00103\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u00104\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u00105\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u00106\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u00107\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u00108\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u00109\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010:\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010;\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010<\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010=\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010>\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010?\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u001a\u0010@\u001a\u00020,X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010D\"\u000e\u0010E\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010F\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010G\u001a\u00020\u0018X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010H\u001a\u00020\u0018X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010I\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u001a\u0010J\u001a\u00020,X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010B\"\u0004\bL\u0010D\"\u001a\u0010M\u001a\u00020,X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010B\"\u0004\bO\u0010D\"\u000e\u0010P\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010Q\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010R\u001a\u00020\u0006X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010S\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010T\u001a\u00020\u0018X\u0080T¢\u0006\u0002\n\u0000\"\u001a\u0010U\u001a\u00020,X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010B\"\u0004\bW\u0010D\"\u000e\u0010X\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u001a\u0010Y\u001a\u00020,X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010B\"\u0004\b[\u0010D\"\u001a\u0010\\\u001a\u00020]X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010a\"\u000e\u0010b\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u001a\u0010c\u001a\u00020\u0001X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010g\"\u000e\u0010h\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010i\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010j\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000¨\u0006k"}, d2 = {"ACCESSIBILITY_ANNOUNCEMENT_DELAY", "", "ACCESSIBILITY_CLOSE_CARD_HORIZONTAL_PERC", "", "ACCESSIBILITY_CLOSE_CARD_VERTICAL_PERC", "AUTO_MAX_ERROR", "", "BACK_CAMERA", "", "BARCODE_READER_TIMEOUT_MS", "BARCODE_TYPE", "BLUR", "BLUR_MODEL_BUFFER_COUNT", "BRIGHTNESS", "CLEAR_GRID_DURATION", "CODE_NOT_AVAILABLE", "CONSENT_EXP_MSG_SET", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getCONSENT_EXP_MSG_SET", "()Ljava/util/HashSet;", "CORNER_DETECTION", "CORNER_MODEL_BUFFER_COUNT", "DEBUG_VIEW_PAINT_STROKE_WIDTH", "", "DEFAULT_BLUR_MODEL_FILE_NAME", "DEFAULT_BLUR_THRESHOLD", "DEFAULT_CORNER_MODEL_FILE_NAME", "DEFAULT_GLARE_INTENSITY_MODEL_FILE_NAME", "DEFAULT_GLARE_INTENSITY_THRESHOLD", "DEFAULT_GLARE_MODEL_FILE_NAME", "DEFAULT_GLARE_THRESHOLD", "DEFAULT_ORIENTATION_THRESHOLD", "DEFAULT_PROGRESS_VALUE", ConstantsKt.DENIED, "DRAW_GRID_DURATION", "DRAW_GRID_UPPER_RANGE", "ENV_FACING_MODE", ConstantsKt.EXPLAINED, "FRONT_CAMERA", "GLARE", "GLARE_INTENSITY_MODEL_BUFFER_COUNT", "GLARE_MODEL_BUFFER_COUNT", "HELP_ALREADY_INITIATED", "", "HOLD_CLEAR_DURATION", "HOLD_GRID_DURATION", "INCREASING_GUIDING_BOX_AREA", "INITIAL_PROGRESS_DURATION_MS", "LICENSE_GUIDING_BOX_RATIO", "LICENSE_VERTICAL_ROTATION_ANGLE", "LINE_1", "LINE_2", "LINE_3", "MANUAL_DBG_DIM", "MANUAL_MAX_ERROR", "MESSAGE_NOT_AVAILABLE", "MIN_BACK_CAMERA_HEIGHT", "MIN_BACK_CAMERA_WIDTH", "MIN_FRONT_CAMERA_HEIGHT", "MIN_FRONT_CAMERA_WIDTH", "MRZ_TYPE", "NO_NAV_ACTION", "NO_STRING_EXTRA", "OPEN_CV_SUPPORTED", "getOPEN_CV_SUPPORTED", "()Z", "setOPEN_CV_SUPPORTED", "(Z)V", "PASSPORT_GUIDING_BOX_RATIO", "PREVIEW_DELAY", "PREVIEW_PROGRESS_BACKGROUND_RATIO", "PREVIEW_PROGRESS_BAR_BACKGROUND_RATIO", "PREVIEW_UPLOAD_DELAY", "PRINT_DETAILED_LOG", "getPRINT_DETAILED_LOG", "setPRINT_DETAILED_LOG", "PRINT_PII_IN_DEBUG_LOG", "getPRINT_PII_IN_DEBUG_LOG", "setPRINT_PII_IN_DEBUG_LOG", "PROGRESS_DELAY_DURATION_MS", "READABLE_DATE_FORMAT", "SCREEN_FLOW_INITIAL_INDEX", "SELFIE_GUIDING_BOX_RATIO", "SELFIE_WIDTH_PERCENTAGE", "SHOW_DEBUG_SCAN_STAGE", "getSHOW_DEBUG_SCAN_STAGE", "setSHOW_DEBUG_SCAN_STAGE", "SHOW_TICK_DURATION", "SILENCE_DEBUG_LOG", "getSILENCE_DEBUG_LOG", "setSILENCE_DEBUG_LOG", "SOURCE_PLATFORM", "Lcom/socure/docv/capturesdk/api/Platform;", "getSOURCE_PLATFORM", "()Lcom/socure/docv/capturesdk/api/Platform;", "setSOURCE_PLATFORM", "(Lcom/socure/docv/capturesdk/api/Platform;)V", "TAG_PREF", "TOTAL_MEMORY", "getTOTAL_MEMORY", "()J", "setTOTAL_MEMORY", "(J)V", "UNSET", "USER_FACING_MODE", "VERTICAL_LICENSE_GUIDING_BOX_RATIO", "capturesdk_productionRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConstantsKt {
    public static final long ACCESSIBILITY_ANNOUNCEMENT_DELAY = 3000;
    public static final double ACCESSIBILITY_CLOSE_CARD_HORIZONTAL_PERC = 0.94d;
    public static final double ACCESSIBILITY_CLOSE_CARD_VERTICAL_PERC = 0.6d;
    public static final int AUTO_MAX_ERROR = 10;
    public static final String BACK_CAMERA = "Back Camera";
    public static final long BARCODE_READER_TIMEOUT_MS = 500;
    public static final String BARCODE_TYPE = "barcode";
    public static final String BLUR = "blur";
    public static final int BLUR_MODEL_BUFFER_COUNT = 1;
    public static final String BRIGHTNESS = "brightness";
    public static final long CLEAR_GRID_DURATION = 300;
    public static final int CODE_NOT_AVAILABLE = -1;
    public static final String CORNER_DETECTION = "corner_detection";
    public static final int CORNER_MODEL_BUFFER_COUNT = 2;
    public static final float DEBUG_VIEW_PAINT_STROKE_WIDTH = 1.0f;
    public static final String DEFAULT_BLUR_MODEL_FILE_NAME = "blur_model.tflite";
    public static final float DEFAULT_BLUR_THRESHOLD = 0.45f;
    public static final String DEFAULT_CORNER_MODEL_FILE_NAME = "idd_model.tflite";
    public static final String DEFAULT_GLARE_INTENSITY_MODEL_FILE_NAME = "light_intensity_model.tflite";
    public static final float DEFAULT_GLARE_INTENSITY_THRESHOLD = 0.0f;
    public static final String DEFAULT_GLARE_MODEL_FILE_NAME = "glare_model.tflite";
    public static final float DEFAULT_GLARE_THRESHOLD = 0.5f;
    public static final float DEFAULT_ORIENTATION_THRESHOLD = 0.5f;
    public static final int DEFAULT_PROGRESS_VALUE = 80;
    public static final String DENIED = "DENIED";
    public static final long DRAW_GRID_DURATION = 600;
    public static final float DRAW_GRID_UPPER_RANGE = 122.0f;
    public static final String ENV_FACING_MODE = "environment";
    public static final String EXPLAINED = "EXPLAINED";
    public static final String FRONT_CAMERA = "Front Camera";
    public static final String GLARE = "glare";
    public static final int GLARE_INTENSITY_MODEL_BUFFER_COUNT = 1;
    public static final int GLARE_MODEL_BUFFER_COUNT = 2;
    public static final boolean HELP_ALREADY_INITIATED = true;
    public static final long HOLD_CLEAR_DURATION = 100;
    public static final long HOLD_GRID_DURATION = 300;
    public static final float INCREASING_GUIDING_BOX_AREA = 0.04f;
    public static final long INITIAL_PROGRESS_DURATION_MS = 1500;
    public static final String LICENSE_GUIDING_BOX_RATIO = "1.5857";
    public static final float LICENSE_VERTICAL_ROTATION_ANGLE = 90.0f;
    public static final int LINE_1 = 0;
    public static final int LINE_2 = 11;
    public static final int LINE_3 = 22;
    public static final int MANUAL_DBG_DIM = 200;
    public static final int MANUAL_MAX_ERROR = 3;
    public static final String MESSAGE_NOT_AVAILABLE = "message_not_available";
    public static final int MIN_BACK_CAMERA_HEIGHT = 1152;
    public static final int MIN_BACK_CAMERA_WIDTH = 2048;
    public static final int MIN_FRONT_CAMERA_HEIGHT = 720;
    public static final int MIN_FRONT_CAMERA_WIDTH = 1280;
    public static final String MRZ_TYPE = "mrz";
    public static final int NO_NAV_ACTION = 0;
    public static final String NO_STRING_EXTRA = "";
    private static boolean OPEN_CV_SUPPORTED = false;
    public static final String PASSPORT_GUIDING_BOX_RATIO = "1.4204";
    public static final long PREVIEW_DELAY = 1000;
    public static final float PREVIEW_PROGRESS_BACKGROUND_RATIO = 0.8f;
    public static final float PREVIEW_PROGRESS_BAR_BACKGROUND_RATIO = 0.6f;
    public static final long PREVIEW_UPLOAD_DELAY = 30000;
    private static boolean PRINT_DETAILED_LOG = false;
    private static boolean PRINT_PII_IN_DEBUG_LOG = false;
    public static final long PROGRESS_DELAY_DURATION_MS = 300;
    public static final String READABLE_DATE_FORMAT = "yyyy-MM-dd";
    public static final int SCREEN_FLOW_INITIAL_INDEX = 1;
    public static final String SELFIE_GUIDING_BOX_RATIO = "0.66";
    public static final float SELFIE_WIDTH_PERCENTAGE = 0.55f;
    private static boolean SHOW_DEBUG_SCAN_STAGE = false;
    public static final long SHOW_TICK_DURATION = 300;
    private static boolean SILENCE_DEBUG_LOG = true;
    public static final String TAG_PREF = "SDLT_";
    public static final double UNSET = 0.0d;
    public static final String USER_FACING_MODE = "user";
    public static final String VERTICAL_LICENSE_GUIDING_BOX_RATIO = "0.6306";
    private static Platform SOURCE_PLATFORM = Platform.NATIVE;
    private static long TOTAL_MEMORY = -1;
    private static final HashSet<String> CONSENT_EXP_MSG_SET = SetsKt.hashSetOf("Consent ID is invalid", "User consent has expired");

    public static final HashSet<String> getCONSENT_EXP_MSG_SET() {
        return CONSENT_EXP_MSG_SET;
    }

    public static final boolean getOPEN_CV_SUPPORTED() {
        return OPEN_CV_SUPPORTED;
    }

    public static final boolean getPRINT_DETAILED_LOG() {
        return PRINT_DETAILED_LOG;
    }

    public static final boolean getPRINT_PII_IN_DEBUG_LOG() {
        return PRINT_PII_IN_DEBUG_LOG;
    }

    public static final boolean getSHOW_DEBUG_SCAN_STAGE() {
        return SHOW_DEBUG_SCAN_STAGE;
    }

    public static final boolean getSILENCE_DEBUG_LOG() {
        return SILENCE_DEBUG_LOG;
    }

    public static final Platform getSOURCE_PLATFORM() {
        return SOURCE_PLATFORM;
    }

    public static final long getTOTAL_MEMORY() {
        return TOTAL_MEMORY;
    }

    public static final void setOPEN_CV_SUPPORTED(boolean z) {
        OPEN_CV_SUPPORTED = z;
    }

    public static final void setPRINT_DETAILED_LOG(boolean z) {
        PRINT_DETAILED_LOG = z;
    }

    public static final void setPRINT_PII_IN_DEBUG_LOG(boolean z) {
        PRINT_PII_IN_DEBUG_LOG = z;
    }

    public static final void setSHOW_DEBUG_SCAN_STAGE(boolean z) {
        SHOW_DEBUG_SCAN_STAGE = z;
    }

    public static final void setSILENCE_DEBUG_LOG(boolean z) {
        SILENCE_DEBUG_LOG = z;
    }

    public static final void setSOURCE_PLATFORM(Platform platform) {
        Intrinsics.checkNotNullParameter(platform, "<set-?>");
        SOURCE_PLATFORM = platform;
    }

    public static final void setTOTAL_MEMORY(long j) {
        TOTAL_MEMORY = j;
    }
}
