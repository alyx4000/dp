package expo.modules.application;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.provider.Settings;
import androidx.tracing.Trace;
import com.android.installreferrer.api.InstallReferrerClient;
import com.iterable.iterableapi.IterableConstants;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.objects.PropertyComponentBuilder;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* compiled from: ApplicationModule.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0006R\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\n \r*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0006¨\u0006\u001a"}, d2 = {"Lexpo/modules/application/ApplicationModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", IterableConstants.KEY_APPLICATION_NAME, "", "getApplicationName", "()Ljava/lang/String;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "packageManager", "Landroid/content/pm/PackageManager;", "kotlin.jvm.PlatformType", "getPackageManager", "()Landroid/content/pm/PackageManager;", "packageName", "getPackageName", "versionCode", "", "getVersionCode", "()I", "versionName", "getVersionName", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-application_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ApplicationModule extends Module {
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
        ApplicationModule applicationModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (applicationModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(applicationModule);
            moduleDefinitionBuilder.Name("ExpoApplication");
            moduleDefinitionBuilder.Constants(new Function0<Map<String, ? extends Object>>() { // from class: expo.modules.application.ApplicationModule$definition$1$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Map<String, ? extends Object> invoke() {
                    String applicationName;
                    String packageName;
                    String versionName;
                    int versionCode;
                    applicationName = ApplicationModule.this.getApplicationName();
                    packageName = ApplicationModule.this.getPackageName();
                    versionName = ApplicationModule.this.getVersionName();
                    versionCode = ApplicationModule.this.getVersionCode();
                    return MapsKt.mapOf(TuplesKt.to(IterableConstants.KEY_APPLICATION_NAME, applicationName), TuplesKt.to("applicationId", packageName), TuplesKt.to("nativeApplicationVersion", versionName), TuplesKt.to("nativeBuildVersion", String.valueOf(versionCode)));
                }
            });
            PropertyComponentBuilder propertyComponentBuilder = new PropertyComponentBuilder("androidId");
            propertyComponentBuilder.setGetter(new SyncFunctionComponent("get", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.application.ApplicationModule$definition$lambda$4$$inlined$Property$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Context context;
                    Intrinsics.checkNotNullParameter(it, "it");
                    context = ApplicationModule.this.getContext();
                    return Settings.Secure.getString(context.getContentResolver(), "android_id");
                }
            }));
            moduleDefinitionBuilder.getProperties().put("androidId", propertyComponentBuilder);
            AsyncFunctionComponent asyncFunctionComponent2 = new AsyncFunctionComponent("getInstallationTimeAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.application.ApplicationModule$definition$lambda$4$$inlined$AsyncFunctionWithoutArgs$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Context context;
                    Context context2;
                    PackageInfo packageInfoCompat;
                    Intrinsics.checkNotNullParameter(it, "it");
                    context = ApplicationModule.this.getContext();
                    PackageManager packageManager = context.getPackageManager();
                    context2 = ApplicationModule.this.getContext();
                    String packageName = context2.getPackageName();
                    Intrinsics.checkNotNullExpressionValue(packageManager, "packageManager");
                    Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
                    packageInfoCompat = ApplicationModuleKt.getPackageInfoCompat(packageManager, packageName, 0);
                    return Double.valueOf(packageInfoCompat.firstInstallTime);
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("getInstallationTimeAsync", asyncFunctionComponent2);
            AsyncFunctionComponent asyncFunctionComponent3 = asyncFunctionComponent2;
            AsyncFunctionComponent asyncFunctionComponent4 = new AsyncFunctionComponent("getLastUpdateTimeAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.application.ApplicationModule$definition$lambda$4$$inlined$AsyncFunctionWithoutArgs$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Context context;
                    Context context2;
                    PackageInfo packageInfoCompat;
                    Intrinsics.checkNotNullParameter(it, "it");
                    context = ApplicationModule.this.getContext();
                    PackageManager packageManager = context.getPackageManager();
                    context2 = ApplicationModule.this.getContext();
                    String packageName = context2.getPackageName();
                    Intrinsics.checkNotNullExpressionValue(packageManager, "packageManager");
                    Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
                    packageInfoCompat = ApplicationModuleKt.getPackageInfoCompat(packageManager, packageName, 0);
                    return Double.valueOf(packageInfoCompat.lastUpdateTime);
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("getLastUpdateTimeAsync", asyncFunctionComponent4);
            AsyncFunctionComponent asyncFunctionComponent5 = asyncFunctionComponent4;
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            if (Promise.class == Promise.class) {
                asyncFunctionComponent = new AsyncFunctionWithPromiseComponent("getInstallReferrerAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.application.ApplicationModule$definition$lambda$4$$inlined$AsyncFunction$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Context context;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        StringBuilder sb = new StringBuilder();
                        context = ApplicationModule.this.getContext();
                        InstallReferrerClient build = InstallReferrerClient.newBuilder(context).build();
                        build.startConnection(new ApplicationModule$definition$1$5$1(build, sb, promise));
                    }
                });
            } else {
                asyncFunctionComponent = new AsyncFunctionComponent("getInstallReferrerAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.application.ApplicationModule$definition$lambda$4$$inlined$AsyncFunction$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Promise.class);
                    }
                }))}, new Function1<Object[], Object>() { // from class: expo.modules.application.ApplicationModule$definition$lambda$4$$inlined$AsyncFunction$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object[] it) {
                        Context context;
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object obj = it[0];
                        if (obj == null) {
                            throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                        }
                        StringBuilder sb = new StringBuilder();
                        context = ApplicationModule.this.getContext();
                        InstallReferrerClient build = InstallReferrerClient.newBuilder(context).build();
                        build.startConnection(new ApplicationModule$definition$1$5$1(build, sb, (Promise) obj));
                        return Unit.INSTANCE;
                    }
                });
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("getInstallReferrerAsync", asyncFunctionComponent);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getApplicationName() {
        return getContext().getApplicationInfo().loadLabel(getContext().getPackageManager()).toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getPackageName() {
        return getContext().getPackageName();
    }

    private final PackageManager getPackageManager() {
        return getContext().getPackageManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getVersionName() {
        PackageInfo packageInfoCompat;
        PackageManager packageManager = getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "packageManager");
        String packageName = getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
        packageInfoCompat = ApplicationModuleKt.getPackageInfoCompat(packageManager, packageName, 0);
        return packageInfoCompat.versionName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getVersionCode() {
        PackageInfo packageInfoCompat;
        long longVersionCode;
        PackageManager packageManager = getPackageManager();
        Intrinsics.checkNotNullExpressionValue(packageManager, "packageManager");
        String packageName = getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
        packageInfoCompat = ApplicationModuleKt.getPackageInfoCompat(packageManager, packageName, 0);
        longVersionCode = ApplicationModuleKt.getLongVersionCode(packageInfoCompat);
        return (int) longVersionCode;
    }
}
