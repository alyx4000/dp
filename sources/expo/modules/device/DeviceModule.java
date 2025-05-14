package expo.modules.device;

import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.FeatureInfo;
import android.os.Build;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.tracing.Trace;
import com.facebook.device.yearclass.YearClass;
import com.iterable.iterableapi.IterableConstants;
import expo.modules.core.utilities.EmulatorUtilities;
import expo.modules.device.DeviceModule;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;

/* compiled from: DeviceModule.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0013"}, d2 = {"Lexpo/modules/device/DeviceModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "deviceYearClass", "", "getDeviceYearClass", "()I", IterableConstants.DEVICE_SYSTEM_NAME, "", "getSystemName", "()Ljava/lang/String;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "Companion", "DeviceType", "expo-device_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DeviceModule extends Module {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: DeviceModule.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lexpo/modules/device/DeviceModule$DeviceType;", "", "JSValue", "", "(Ljava/lang/String;II)V", "getJSValue", "()I", "UNKNOWN", "PHONE", "TABLET", "DESKTOP", "TV", "expo-device_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public enum DeviceType {
        UNKNOWN(0),
        PHONE(1),
        TABLET(2),
        DESKTOP(3),
        TV(4);

        private final int JSValue;

        DeviceType(int i) {
            this.JSValue = i;
        }

        public final int getJSValue() {
            return this.JSValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context getContext() {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.ReactContextLost();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent asyncFunctionComponent;
        DeviceModule deviceModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (deviceModule.getClass() + ".ModuleDefinition"));
        try {
            final ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(deviceModule);
            moduleDefinitionBuilder.Name("ExpoDevice");
            moduleDefinitionBuilder.Constants(new Function0<Map<String, ? extends Object>>() { // from class: expo.modules.device.DeviceModule$definition$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Code restructure failed: missing block: B:7:0x00bc, code lost:
                
                    if (java.lang.Boolean.valueOf(true ^ (r1.length == 0)).booleanValue() != false) goto L11;
                 */
                @Override // kotlin.jvm.functions.Function0
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.util.Map<java.lang.String, ? extends java.lang.Object> invoke() {
                    /*
                        Method dump skipped, instructions count: 336
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: expo.modules.device.DeviceModule$definition$1$1.invoke():java.util.Map");
                }
            });
            AsyncFunctionComponent asyncFunctionComponent2 = new AsyncFunctionComponent("getDeviceTypeAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.device.DeviceModule$definition$lambda$8$$inlined$AsyncFunctionWithoutArgs$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Context context;
                    DeviceModule.DeviceType deviceType;
                    Intrinsics.checkNotNullParameter(it, "it");
                    DeviceModule.Companion companion = DeviceModule.INSTANCE;
                    context = DeviceModule.this.getContext();
                    deviceType = companion.getDeviceType(context);
                    return Integer.valueOf(deviceType.getJSValue());
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("getDeviceTypeAsync", asyncFunctionComponent2);
            AsyncFunctionComponent asyncFunctionComponent3 = asyncFunctionComponent2;
            AsyncFunctionComponent asyncFunctionComponent4 = new AsyncFunctionComponent("getUptimeAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.device.DeviceModule$definition$lambda$8$$inlined$AsyncFunctionWithoutArgs$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Double.valueOf(SystemClock.uptimeMillis());
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("getUptimeAsync", asyncFunctionComponent4);
            AsyncFunctionComponent asyncFunctionComponent5 = asyncFunctionComponent4;
            AsyncFunctionComponent asyncFunctionComponent6 = new AsyncFunctionComponent("getMaxMemoryAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.device.DeviceModule$definition$lambda$8$$inlined$AsyncFunctionWithoutArgs$3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    long maxMemory = Runtime.getRuntime().maxMemory();
                    if (maxMemory != Long.MAX_VALUE) {
                        return Double.valueOf(maxMemory);
                    }
                    return -1;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("getMaxMemoryAsync", asyncFunctionComponent6);
            AsyncFunctionComponent asyncFunctionComponent7 = asyncFunctionComponent6;
            AsyncFunctionComponent asyncFunctionComponent8 = new AsyncFunctionComponent("isRootedExperimentalAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.device.DeviceModule$definition$lambda$8$$inlined$AsyncFunctionWithoutArgs$4
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    boolean isRunningOnEmulator;
                    Intrinsics.checkNotNullParameter(it, "it");
                    isRunningOnEmulator = DeviceModule.INSTANCE.isRunningOnEmulator();
                    boolean z = true;
                    boolean z2 = !isRunningOnEmulator;
                    String str = Build.TAGS;
                    if ((!z2 || str == null || !StringsKt.contains$default((CharSequence) str, (CharSequence) "test-keys", false, 2, (Object) null)) && !new File("/system/app/Superuser.apk").exists() && (!z2 || !new File("/system/xbin/su").exists())) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("isRootedExperimentalAsync", asyncFunctionComponent8);
            AsyncFunctionComponent asyncFunctionComponent9 = asyncFunctionComponent8;
            AsyncFunctionComponent asyncFunctionComponent10 = new AsyncFunctionComponent("isSideLoadingEnabledAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.device.DeviceModule$definition$lambda$8$$inlined$AsyncFunctionWithoutArgs$5
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Context context;
                    Intrinsics.checkNotNullParameter(it, "it");
                    context = DeviceModule.this.getContext();
                    return Boolean.valueOf(context.getApplicationContext().getPackageManager().canRequestPackageInstalls());
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("isSideLoadingEnabledAsync", asyncFunctionComponent10);
            AsyncFunctionComponent asyncFunctionComponent11 = asyncFunctionComponent10;
            AsyncFunctionComponent asyncFunctionComponent12 = new AsyncFunctionComponent("getPlatformFeaturesAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.device.DeviceModule$definition$lambda$8$$inlined$AsyncFunctionWithoutArgs$6
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Context context;
                    Intrinsics.checkNotNullParameter(it, "it");
                    context = DeviceModule.this.getContext();
                    FeatureInfo[] systemAvailableFeatures = context.getApplicationContext().getPackageManager().getSystemAvailableFeatures();
                    Intrinsics.checkNotNullExpressionValue(systemAvailableFeatures, "context.applicationConte…r.systemAvailableFeatures");
                    List filterNotNull = ArraysKt.filterNotNull(systemAvailableFeatures);
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(filterNotNull, 10));
                    Iterator it2 = filterNotNull.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(((FeatureInfo) it2.next()).name);
                    }
                    return arrayList;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("getPlatformFeaturesAsync", asyncFunctionComponent12);
            AsyncFunctionComponent asyncFunctionComponent13 = asyncFunctionComponent12;
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            if (String.class == Promise.class) {
                asyncFunctionComponent = new AsyncFunctionWithPromiseComponent("hasPlatformFeatureAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.device.DeviceModule$definition$lambda$8$$inlined$AsyncFunction$1
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Context context;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        context = DeviceModule.this.getContext();
                        context.getApplicationContext().getPackageManager().hasSystemFeature((String) promise);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                asyncFunctionComponent = new AsyncFunctionComponent("hasPlatformFeatureAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.device.DeviceModule$definition$lambda$8$$inlined$AsyncFunction$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }))}, new Function1<Object[], Object>() { // from class: expo.modules.device.DeviceModule$definition$lambda$8$$inlined$AsyncFunction$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object[] it) {
                        Context context;
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object obj = it[0];
                        if (obj != null) {
                            context = DeviceModule.this.getContext();
                            return Boolean.valueOf(context.getApplicationContext().getPackageManager().hasSystemFeature((String) obj));
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                });
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("hasPlatformFeatureAsync", asyncFunctionComponent);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getDeviceYearClass() {
        return YearClass.get(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getSystemName() {
        String it = Build.VERSION.BASE_OS;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        if (!(it.length() > 0)) {
            it = null;
        }
        return it == null ? "Android" : it;
    }

    /* compiled from: DeviceModule.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005¨\u0006\f"}, d2 = {"Lexpo/modules/device/DeviceModule$Companion;", "", "()V", "isRunningOnEmulator", "", "()Z", "getDeviceType", "Lexpo/modules/device/DeviceModule$DeviceType;", "context", "Landroid/content/Context;", "getDeviceTypeFromPhysicalSize", "getDeviceTypeFromResourceConfiguration", "expo-device_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean isRunningOnEmulator() {
            return EmulatorUtilities.INSTANCE.isRunningOnEmulator();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final DeviceType getDeviceType(Context context) {
            if (context.getApplicationContext().getPackageManager().hasSystemFeature("amazon.hardware.fire_tv")) {
                return DeviceType.TV;
            }
            UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
            if (uiModeManager != null && uiModeManager.getCurrentModeType() == 4) {
                return DeviceType.TV;
            }
            DeviceType deviceTypeFromResourceConfiguration = getDeviceTypeFromResourceConfiguration(context);
            return deviceTypeFromResourceConfiguration != DeviceType.UNKNOWN ? deviceTypeFromResourceConfiguration : getDeviceTypeFromPhysicalSize(context);
        }

        private final DeviceType getDeviceTypeFromResourceConfiguration(Context context) {
            int i = context.getResources().getConfiguration().smallestScreenWidthDp;
            if (i == 0) {
                return DeviceType.UNKNOWN;
            }
            if (i >= 600) {
                return DeviceType.TABLET;
            }
            return DeviceType.PHONE;
        }

        private final DeviceType getDeviceTypeFromPhysicalSize(Context context) {
            double d;
            double d2;
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return DeviceType.UNKNOWN;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                Intrinsics.checkNotNullExpressionValue(windowManager.getCurrentWindowMetrics().getBounds(), "windowManager.currentWindowMetrics.bounds");
                double d3 = context.getResources().getConfiguration().densityDpi;
                d = r0.width() / d3;
                d2 = r0.height() / d3;
            } else {
                windowManager.getDefaultDisplay().getRealMetrics(new DisplayMetrics());
                d = r8.widthPixels / r8.xdpi;
                d2 = r8.heightPixels / r8.ydpi;
            }
            double sqrt = Math.sqrt(Math.pow(d, 2.0d) + Math.pow(d2, 2.0d));
            boolean z = false;
            if (3.0d <= sqrt && sqrt <= 6.9d) {
                z = true;
            }
            if (z) {
                return DeviceType.PHONE;
            }
            if (sqrt > 6.9d && sqrt <= 18.0d) {
                return DeviceType.TABLET;
            }
            return DeviceType.UNKNOWN;
        }
    }
}
