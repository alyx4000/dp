package expo.modules.localauthentication;

import androidx.exifinterface.media.ExifInterface;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LocalAuthenticationModule.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a+\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u0002H\n¢\u0006\u0002\u0010\u000f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"AUTHENTICATION_TYPE_FACIAL_RECOGNITION", "", "AUTHENTICATION_TYPE_FINGERPRINT", "AUTHENTICATION_TYPE_IRIS", "DEVICE_CREDENTIAL_FALLBACK_CODE", "SECURITY_LEVEL_BIOMETRIC", "SECURITY_LEVEL_NONE", "SECURITY_LEVEL_SECRET", "addIf", "", ExifInterface.GPS_DIRECTION_TRUE, "", "condition", "", "valueToAdd", "(Ljava/util/Set;ZLjava/lang/Object;)V", "expo-local-authentication_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocalAuthenticationModuleKt {
    private static final int AUTHENTICATION_TYPE_FACIAL_RECOGNITION = 2;
    private static final int AUTHENTICATION_TYPE_FINGERPRINT = 1;
    private static final int AUTHENTICATION_TYPE_IRIS = 3;
    private static final int DEVICE_CREDENTIAL_FALLBACK_CODE = 6;
    private static final int SECURITY_LEVEL_BIOMETRIC = 2;
    private static final int SECURITY_LEVEL_NONE = 0;
    private static final int SECURITY_LEVEL_SECRET = 1;

    public static final <T> void addIf(Set<T> set, boolean z, T t) {
        Intrinsics.checkNotNullParameter(set, "<this>");
        if (z) {
            set.add(t);
        }
    }
}
