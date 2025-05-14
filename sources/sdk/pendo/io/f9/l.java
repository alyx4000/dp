package sdk.pendo.io.f9;

import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.Pendo;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.sdk.flutter.FlutterScreenManager;
import sdk.pendo.io.sdk.flutter.IFlutterBridge;
import sdk.pendo.io.sdk.react.PlatformStateManager;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\tR\u001c\u0010\u000f\u001a\n \f*\u0004\u0018\u00010\u000b0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lsdk/pendo/io/f9/l;", "", "Lsdk/pendo/io/Pendo$PendoOptions$Framework;", Pendo.PendoOptions.FRAMEWORK, "Lsdk/pendo/io/Pendo$PendoOptions;", "pendoOptions", "Lsdk/pendo/io/f9/f;", "a", "Lsdk/pendo/io/sdk/react/PlatformStateManager;", "Lsdk/pendo/io/sdk/react/PlatformStateManager;", "platformStateManager", "", "kotlin.jvm.PlatformType", "b", "Ljava/lang/String;", "TAG", "<init>", "(Lsdk/pendo/io/sdk/react/PlatformStateManager;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final PlatformStateManager platformStateManager;

    /* renamed from: b, reason: from kotlin metadata */
    private final String TAG;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1100a;

        static {
            int[] iArr = new int[Pendo.PendoOptions.Framework.values().length];
            try {
                iArr[Pendo.PendoOptions.Framework.NATIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Pendo.PendoOptions.Framework.FLUTTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Pendo.PendoOptions.Framework.XAMARIN_FORMS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Pendo.PendoOptions.Framework.MAUI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Pendo.PendoOptions.Framework.REACT_NATIVE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f1100a = iArr;
        }
    }

    public l(PlatformStateManager platformStateManager) {
        Intrinsics.checkNotNullParameter(platformStateManager, "platformStateManager");
        this.TAG = "l";
        this.platformStateManager = platformStateManager;
    }

    public final f a(Pendo.PendoOptions.Framework framework, Pendo.PendoOptions pendoOptions) {
        Intrinsics.checkNotNullParameter(framework, "framework");
        Intrinsics.checkNotNullParameter(pendoOptions, "pendoOptions");
        PendoLogger.i(this.TAG + " getScreenManagerByFramework, framework: " + framework, new Object[0]);
        if (this.platformStateManager.isTrackEventSolutionOnly()) {
            return new m();
        }
        int i = a.f1100a[framework.ordinal()];
        if (i == 1) {
            return new k(pendoOptions);
        }
        if (i != 2) {
            if (i != 3 && i != 4 && i != 5) {
                throw new NoWhenBranchMatchedException();
            }
            return new k(pendoOptions);
        }
        Map<String, Object> additionalOptions = pendoOptions.getAdditionalOptions();
        IFlutterBridge iFlutterBridge = null;
        if (additionalOptions != null) {
            Object obj = additionalOptions.get(Pendo.PendoOptions.FLUTTER_BRIDGE);
            iFlutterBridge = (IFlutterBridge) (obj instanceof IFlutterBridge ? obj : null);
        }
        return new FlutterScreenManager(pendoOptions, iFlutterBridge);
    }
}
