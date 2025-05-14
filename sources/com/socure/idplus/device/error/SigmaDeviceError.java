package com.socure.idplus.device.error;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/socure/idplus/device/error/SigmaDeviceError;", "", "(Ljava/lang/String;I)V", "NetworkConnectionError", "DataUploadError", "DataFetchError", "UnknownError", "ContextFetchError", "device-risk-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SigmaDeviceError {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SigmaDeviceError[] $VALUES;
    public static final SigmaDeviceError NetworkConnectionError = new SigmaDeviceError("NetworkConnectionError", 0);
    public static final SigmaDeviceError DataUploadError = new SigmaDeviceError("DataUploadError", 1);
    public static final SigmaDeviceError DataFetchError = new SigmaDeviceError("DataFetchError", 2);
    public static final SigmaDeviceError UnknownError = new SigmaDeviceError("UnknownError", 3);
    public static final SigmaDeviceError ContextFetchError = new SigmaDeviceError("ContextFetchError", 4);

    private static final /* synthetic */ SigmaDeviceError[] $values() {
        return new SigmaDeviceError[]{NetworkConnectionError, DataUploadError, DataFetchError, UnknownError, ContextFetchError};
    }

    static {
        SigmaDeviceError[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private SigmaDeviceError(String str, int i) {
    }

    public static EnumEntries<SigmaDeviceError> getEntries() {
        return $ENTRIES;
    }

    public static SigmaDeviceError valueOf(String str) {
        return (SigmaDeviceError) Enum.valueOf(SigmaDeviceError.class, str);
    }

    public static SigmaDeviceError[] values() {
        return (SigmaDeviceError[]) $VALUES.clone();
    }
}
