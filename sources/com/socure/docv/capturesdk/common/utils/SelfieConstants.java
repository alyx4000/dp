package com.socure.docv.capturesdk.common.utils;

import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/socure/docv/capturesdk/common/utils/SelfieConstants;", "", "()V", "EXPAND_GUIDING_BOX_PERCENTAGE", "", "FACE_NOT_ALIGNED", "", "FACE_NOT_FOUND", "FACE_ORIENTATION_WRONG", "FACE_TOO_SMALL", "MAX_ANALYSIS_BITMAP_WIDTH", "MAX_FACE_SIZE_RATIO", "", "MIN_FACE_SIZE_RATIO", "READY_FOR_SELFIE_CAPTURE", "SELFIE_ANALYSIS_GUIDING_MESSAGE_DELAY", "", "SELFIE_FACE_MAX_ANGLE", "SELFIE_FACE_MIN_ANGLE", "SELFIE_FACE_TIMEOUT_MS", "SELFIE_GB_WIDTH", "SELFIE_OVAL_DEVICE_WIDTH_RATIO", "", "SELFIE_OVAL_RECT_ASPECT_RATIO", "SELFIE_OVAL_TOP_MARGIN", "capturesdk_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SelfieConstants {
    public static final int EXPAND_GUIDING_BOX_PERCENTAGE = 30;
    public static final String FACE_NOT_ALIGNED = "not_center_aligned";
    public static final String FACE_NOT_FOUND = "no_face";
    public static final String FACE_ORIENTATION_WRONG = "not_parallel";
    public static final String FACE_TOO_SMALL = "face_small";
    public static final SelfieConstants INSTANCE = new SelfieConstants();
    public static final int MAX_ANALYSIS_BITMAP_WIDTH = 300;
    public static final double MAX_FACE_SIZE_RATIO = 0.8d;
    public static final double MIN_FACE_SIZE_RATIO = 2.5d;
    public static final String READY_FOR_SELFIE_CAPTURE = "perfect_capture";
    public static final long SELFIE_ANALYSIS_GUIDING_MESSAGE_DELAY = 1000;
    public static final int SELFIE_FACE_MAX_ANGLE = 9;
    public static final int SELFIE_FACE_MIN_ANGLE = -9;
    public static final long SELFIE_FACE_TIMEOUT_MS = 350;
    public static final int SELFIE_GB_WIDTH = 0;
    public static final float SELFIE_OVAL_DEVICE_WIDTH_RATIO = 0.65f;
    public static final float SELFIE_OVAL_RECT_ASPECT_RATIO = 1.3333334f;
    public static final int SELFIE_OVAL_TOP_MARGIN = 60;

    private SelfieConstants() {
    }
}
