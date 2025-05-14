package expo.modules.localauthentication;

import android.app.Activity;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.tracing.Trace;
import com.facebook.react.bridge.BaseJavaModule;
import com.socure.docv.capturesdk.common.utils.ApiConstant;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.EventListenerWithSenderAndPayload;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.events.OnActivityResultPayload;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.Queues;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import io.sentry.ProfilingTraceData;
import java.util.LinkedHashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: LocalAuthenticationModule.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010&\u001a\u00020'H\u0003J\b\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020.H\u0002J \u00102\u001a\u0002032\n\b\u0002\u00104\u001a\u0004\u0018\u0001002\n\b\u0002\u00105\u001a\u0004\u0018\u000100H\u0002J\b\u00106\u001a\u000207H\u0016J\u0010\u00108\u001a\u00020\u00182\u0006\u00109\u001a\u000200H\u0002J\u0010\u0010:\u001a\u00020\u00182\u0006\u00101\u001a\u00020.H\u0002J\u0018\u0010;\u001a\u00020)2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010&\u001a\u00020'H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR#\u0010 \u001a\n \"*\u0004\u0018\u00010!0!8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\f\u001a\u0004\b#\u0010$R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lexpo/modules/localauthentication/LocalAuthenticationModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "authOptions", "Lexpo/modules/localauthentication/AuthOptions;", "authenticationCallback", "Landroidx/biometric/BiometricPrompt$AuthenticationCallback;", "biometricManager", "Landroidx/biometric/BiometricManager;", "getBiometricManager", "()Landroidx/biometric/BiometricManager;", "biometricManager$delegate", "Lkotlin/Lazy;", "biometricPrompt", "Landroidx/biometric/BiometricPrompt;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity", "()Landroid/app/Activity;", "isAuthenticating", "", "isDeviceSecure", "()Z", "isRetryingWithDeviceCredentials", "keyguardManager", "Landroid/app/KeyguardManager;", "getKeyguardManager", "()Landroid/app/KeyguardManager;", "packageManager", "Landroid/content/pm/PackageManager;", "kotlin.jvm.PlatformType", "getPackageManager", "()Landroid/content/pm/PackageManager;", "packageManager$delegate", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "authenticate", "", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "options", "canAuthenticateUsingWeakBiometrics", "", "convertErrorCode", "", ApiConstant.KEY_CODE, "createResponse", "Landroid/os/Bundle;", "error", "warning", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "hasSystemFeature", "feature", "isBiometricUnavailable", "promptDeviceCredentialsFallback", "expo-local-authentication_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LocalAuthenticationModule extends Module {
    private AuthOptions authOptions;
    private BiometricPrompt biometricPrompt;
    private boolean isAuthenticating;
    private boolean isRetryingWithDeviceCredentials;
    private Promise promise;

    /* renamed from: biometricManager$delegate, reason: from kotlin metadata */
    private final Lazy biometricManager = LazyKt.lazy(new Function0<BiometricManager>() { // from class: expo.modules.localauthentication.LocalAuthenticationModule$biometricManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final BiometricManager invoke() {
            Context context;
            context = LocalAuthenticationModule.this.getContext();
            return BiometricManager.from(context);
        }
    });

    /* renamed from: packageManager$delegate, reason: from kotlin metadata */
    private final Lazy packageManager = LazyKt.lazy(new Function0<PackageManager>() { // from class: expo.modules.localauthentication.LocalAuthenticationModule$packageManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final PackageManager invoke() {
            Context context;
            context = LocalAuthenticationModule.this.getContext();
            return context.getPackageManager();
        }
    });
    private final BiometricPrompt.AuthenticationCallback authenticationCallback = new BiometricPrompt.AuthenticationCallback() { // from class: expo.modules.localauthentication.LocalAuthenticationModule$authenticationCallback$1
        @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
        public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult result) {
            Promise promise;
            Intrinsics.checkNotNullParameter(result, "result");
            LocalAuthenticationModule.this.isAuthenticating = false;
            LocalAuthenticationModule.this.isRetryingWithDeviceCredentials = false;
            LocalAuthenticationModule.this.biometricPrompt = null;
            promise = LocalAuthenticationModule.this.promise;
            if (promise != null) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("success", true);
                promise.resolve(bundle);
            }
            LocalAuthenticationModule.this.promise = null;
            LocalAuthenticationModule.this.authOptions = null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x002b, code lost:
        
            r1 = r3.this$0.promise;
         */
        /* JADX WARN: Code restructure failed: missing block: B:7:0x001d, code lost:
        
            r0 = r3.this$0.authOptions;
         */
        @Override // androidx.biometric.BiometricPrompt.AuthenticationCallback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onAuthenticationError(int r4, java.lang.CharSequence r5) {
            /*
                r3 = this;
                java.lang.String r0 = "errString"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                expo.modules.localauthentication.LocalAuthenticationModule r0 = expo.modules.localauthentication.LocalAuthenticationModule.this
                boolean r0 = expo.modules.localauthentication.LocalAuthenticationModule.access$isBiometricUnavailable(r0, r4)
                if (r0 == 0) goto L3d
                expo.modules.localauthentication.LocalAuthenticationModule r0 = expo.modules.localauthentication.LocalAuthenticationModule.this
                boolean r0 = expo.modules.localauthentication.LocalAuthenticationModule.access$isDeviceSecure(r0)
                if (r0 == 0) goto L3d
                expo.modules.localauthentication.LocalAuthenticationModule r0 = expo.modules.localauthentication.LocalAuthenticationModule.this
                boolean r0 = expo.modules.localauthentication.LocalAuthenticationModule.access$isRetryingWithDeviceCredentials$p(r0)
                if (r0 != 0) goto L3d
                expo.modules.localauthentication.LocalAuthenticationModule r0 = expo.modules.localauthentication.LocalAuthenticationModule.this
                expo.modules.localauthentication.AuthOptions r0 = expo.modules.localauthentication.LocalAuthenticationModule.access$getAuthOptions$p(r0)
                if (r0 == 0) goto L3d
                boolean r1 = r0.getDisableDeviceFallback()
                if (r1 != 0) goto L3d
                expo.modules.localauthentication.LocalAuthenticationModule r1 = expo.modules.localauthentication.LocalAuthenticationModule.this
                expo.modules.kotlin.Promise r1 = expo.modules.localauthentication.LocalAuthenticationModule.access$getPromise$p(r1)
                if (r1 == 0) goto L3d
                expo.modules.localauthentication.LocalAuthenticationModule r4 = expo.modules.localauthentication.LocalAuthenticationModule.this
                r5 = 1
                expo.modules.localauthentication.LocalAuthenticationModule.access$setRetryingWithDeviceCredentials$p(r4, r5)
                expo.modules.localauthentication.LocalAuthenticationModule.access$promptDeviceCredentialsFallback(r4, r0, r1)
                return
            L3d:
                expo.modules.localauthentication.LocalAuthenticationModule r0 = expo.modules.localauthentication.LocalAuthenticationModule.this
                r1 = 0
                expo.modules.localauthentication.LocalAuthenticationModule.access$setAuthenticating$p(r0, r1)
                expo.modules.localauthentication.LocalAuthenticationModule r0 = expo.modules.localauthentication.LocalAuthenticationModule.this
                expo.modules.localauthentication.LocalAuthenticationModule.access$setRetryingWithDeviceCredentials$p(r0, r1)
                expo.modules.localauthentication.LocalAuthenticationModule r0 = expo.modules.localauthentication.LocalAuthenticationModule.this
                r1 = 0
                expo.modules.localauthentication.LocalAuthenticationModule.access$setBiometricPrompt$p(r0, r1)
                expo.modules.localauthentication.LocalAuthenticationModule r0 = expo.modules.localauthentication.LocalAuthenticationModule.this
                expo.modules.kotlin.Promise r0 = expo.modules.localauthentication.LocalAuthenticationModule.access$getPromise$p(r0)
                if (r0 == 0) goto L67
                expo.modules.localauthentication.LocalAuthenticationModule r2 = expo.modules.localauthentication.LocalAuthenticationModule.this
                java.lang.String r4 = expo.modules.localauthentication.LocalAuthenticationModule.access$convertErrorCode(r2, r4)
                java.lang.String r5 = r5.toString()
                android.os.Bundle r4 = expo.modules.localauthentication.LocalAuthenticationModule.access$createResponse(r2, r4, r5)
                r0.resolve(r4)
            L67:
                expo.modules.localauthentication.LocalAuthenticationModule r4 = expo.modules.localauthentication.LocalAuthenticationModule.this
                expo.modules.localauthentication.LocalAuthenticationModule.access$setPromise$p(r4, r1)
                expo.modules.localauthentication.LocalAuthenticationModule r4 = expo.modules.localauthentication.LocalAuthenticationModule.this
                expo.modules.localauthentication.LocalAuthenticationModule.access$setAuthOptions$p(r4, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: expo.modules.localauthentication.LocalAuthenticationModule$authenticationCallback$1.onAuthenticationError(int, java.lang.CharSequence):void");
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public final String convertErrorCode(int code) {
        switch (code) {
            case 1:
            case 11:
            case 12:
            case 14:
                return "not_available";
            case 2:
                return "unable_to_process";
            case 3:
                return ProfilingTraceData.TRUNCATION_REASON_TIMEOUT;
            case 4:
                return "no_space";
            case 5:
            case 10:
            case 13:
                return "user_cancel";
            case 6:
            case 8:
            default:
                return "unknown";
            case 7:
            case 9:
                return "lockout";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isBiometricUnavailable(int code) {
        return code == 1 || code == 2 || code == 4 || code == 11 || code == 12;
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        LocalAuthenticationModule localAuthenticationModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (localAuthenticationModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(localAuthenticationModule);
            moduleDefinitionBuilder.Name("ExpoLocalAuthentication");
            AsyncFunctionComponent asyncFunctionComponent = new AsyncFunctionComponent("supportedAuthenticationTypesAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.localauthentication.LocalAuthenticationModule$definition$lambda$8$$inlined$AsyncFunctionWithoutArgs$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    int canAuthenticateUsingWeakBiometrics;
                    boolean hasSystemFeature;
                    boolean hasSystemFeature2;
                    boolean hasSystemFeature3;
                    boolean hasSystemFeature4;
                    Intrinsics.checkNotNullParameter(it, "it");
                    LinkedHashSet linkedHashSet = new LinkedHashSet();
                    canAuthenticateUsingWeakBiometrics = LocalAuthenticationModule.this.canAuthenticateUsingWeakBiometrics();
                    if (canAuthenticateUsingWeakBiometrics != 12) {
                        hasSystemFeature = LocalAuthenticationModule.this.hasSystemFeature("android.hardware.fingerprint");
                        LocalAuthenticationModuleKt.addIf(linkedHashSet, hasSystemFeature, 1);
                        hasSystemFeature2 = LocalAuthenticationModule.this.hasSystemFeature("android.hardware.biometrics.face");
                        LocalAuthenticationModuleKt.addIf(linkedHashSet, hasSystemFeature2, 2);
                        hasSystemFeature3 = LocalAuthenticationModule.this.hasSystemFeature("android.hardware.biometrics.iris");
                        LocalAuthenticationModuleKt.addIf(linkedHashSet, hasSystemFeature3, 3);
                        hasSystemFeature4 = LocalAuthenticationModule.this.hasSystemFeature("com.samsung.android.bio.face");
                        LocalAuthenticationModuleKt.addIf(linkedHashSet, hasSystemFeature4, 2);
                    }
                    return linkedHashSet;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("supportedAuthenticationTypesAsync", asyncFunctionComponent);
            AsyncFunctionComponent asyncFunctionComponent2 = asyncFunctionComponent;
            AsyncFunctionComponent asyncFunctionComponent3 = new AsyncFunctionComponent("hasHardwareAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.localauthentication.LocalAuthenticationModule$definition$lambda$8$$inlined$AsyncFunctionWithoutArgs$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    int canAuthenticateUsingWeakBiometrics;
                    Intrinsics.checkNotNullParameter(it, "it");
                    canAuthenticateUsingWeakBiometrics = LocalAuthenticationModule.this.canAuthenticateUsingWeakBiometrics();
                    return Boolean.valueOf(canAuthenticateUsingWeakBiometrics != 12);
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("hasHardwareAsync", asyncFunctionComponent3);
            AsyncFunctionComponent asyncFunctionComponent4 = asyncFunctionComponent3;
            AsyncFunctionComponent asyncFunctionComponent5 = new AsyncFunctionComponent("isEnrolledAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.localauthentication.LocalAuthenticationModule$definition$lambda$8$$inlined$AsyncFunctionWithoutArgs$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    int canAuthenticateUsingWeakBiometrics;
                    Intrinsics.checkNotNullParameter(it, "it");
                    canAuthenticateUsingWeakBiometrics = LocalAuthenticationModule.this.canAuthenticateUsingWeakBiometrics();
                    return Boolean.valueOf(canAuthenticateUsingWeakBiometrics == 0);
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("isEnrolledAsync", asyncFunctionComponent5);
            AsyncFunctionComponent asyncFunctionComponent6 = asyncFunctionComponent5;
            AsyncFunctionComponent asyncFunctionComponent7 = new AsyncFunctionComponent("getEnrolledLevelAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.localauthentication.LocalAuthenticationModule$definition$lambda$8$$inlined$AsyncFunctionWithoutArgs$4
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r2v3, types: [int] */
                /* JADX WARN: Type inference failed for: r2v5 */
                /* JADX WARN: Type inference failed for: r2v6 */
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    boolean isDeviceSecure;
                    int canAuthenticateUsingWeakBiometrics;
                    Intrinsics.checkNotNullParameter(it, "it");
                    isDeviceSecure = LocalAuthenticationModule.this.isDeviceSecure();
                    canAuthenticateUsingWeakBiometrics = LocalAuthenticationModule.this.canAuthenticateUsingWeakBiometrics();
                    ?? r2 = isDeviceSecure;
                    if (canAuthenticateUsingWeakBiometrics == 0) {
                        r2 = 2;
                    }
                    return Integer.valueOf((int) r2);
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("getEnrolledLevelAsync", asyncFunctionComponent7);
            AsyncFunctionComponent asyncFunctionComponent8 = asyncFunctionComponent7;
            moduleDefinitionBuilder.getAsyncFunctions().put("authenticateAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("authenticateAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(AuthOptions.class), false, new Function0<KType>() { // from class: expo.modules.localauthentication.LocalAuthenticationModule$definition$lambda$8$$inlined$AsyncFunction$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(AuthOptions.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.localauthentication.LocalAuthenticationModule$definition$lambda$8$$inlined$AsyncFunction$2
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    Activity currentActivity;
                    KeyguardManager keyguardManager;
                    Bundle createResponse;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj != null) {
                        AuthOptions authOptions = (AuthOptions) obj;
                        currentActivity = LocalAuthenticationModule.this.getCurrentActivity();
                        FragmentActivity fragmentActivity = currentActivity instanceof FragmentActivity ? (FragmentActivity) currentActivity : null;
                        if (fragmentActivity != null) {
                            keyguardManager = LocalAuthenticationModule.this.getKeyguardManager();
                            if (!keyguardManager.isDeviceSecure()) {
                                createResponse = LocalAuthenticationModule.this.createResponse("not_enrolled", "KeyguardManager#isDeviceSecure() returned false");
                                promise.resolve(createResponse);
                                return;
                            } else {
                                LocalAuthenticationModule.this.authOptions = authOptions;
                                BuildersKt__Builders_commonKt.launch$default(LocalAuthenticationModule.this.getAppContext().getMainQueue(), null, null, new LocalAuthenticationModule$definition$1$5$1(LocalAuthenticationModule.this, fragmentActivity, authOptions, promise, null), 3, null);
                                return;
                            }
                        }
                        promise.reject(new Exceptions.MissingActivity());
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.localauthentication.AuthOptions");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("authenticateAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(AuthOptions.class), false, new Function0<KType>() { // from class: expo.modules.localauthentication.LocalAuthenticationModule$definition$lambda$8$$inlined$AsyncFunction$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(AuthOptions.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.localauthentication.LocalAuthenticationModule$definition$lambda$8$$inlined$AsyncFunction$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.localauthentication.LocalAuthenticationModule$definition$lambda$8$$inlined$AsyncFunction$5
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Activity currentActivity;
                    KeyguardManager keyguardManager;
                    Bundle createResponse;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.localauthentication.AuthOptions");
                    }
                    AuthOptions authOptions = (AuthOptions) obj;
                    Object obj2 = it[1];
                    if (obj2 != null) {
                        Promise promise = (Promise) obj2;
                        currentActivity = LocalAuthenticationModule.this.getCurrentActivity();
                        FragmentActivity fragmentActivity = currentActivity instanceof FragmentActivity ? (FragmentActivity) currentActivity : null;
                        if (fragmentActivity != null) {
                            keyguardManager = LocalAuthenticationModule.this.getKeyguardManager();
                            if (!keyguardManager.isDeviceSecure()) {
                                createResponse = LocalAuthenticationModule.this.createResponse("not_enrolled", "KeyguardManager#isDeviceSecure() returned false");
                                promise.resolve(createResponse);
                            } else {
                                LocalAuthenticationModule.this.authOptions = authOptions;
                                BuildersKt__Builders_commonKt.launch$default(LocalAuthenticationModule.this.getAppContext().getMainQueue(), null, null, new LocalAuthenticationModule$definition$1$5$1(LocalAuthenticationModule.this, fragmentActivity, authOptions, promise, null), 3, null);
                            }
                        } else {
                            promise.reject(new Exceptions.MissingActivity());
                        }
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            AsyncFunctionComponent asyncFunctionComponent9 = new AsyncFunctionComponent("cancelAuthenticate", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.localauthentication.LocalAuthenticationModule$definition$lambda$8$$inlined$AsyncFunction$6
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    BiometricPrompt biometricPrompt;
                    Intrinsics.checkNotNullParameter(it, "it");
                    biometricPrompt = LocalAuthenticationModule.this.biometricPrompt;
                    if (biometricPrompt != null) {
                        biometricPrompt.cancelAuthentication();
                    }
                    LocalAuthenticationModule.this.isAuthenticating = false;
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("cancelAuthenticate", asyncFunctionComponent9);
            asyncFunctionComponent9.runOnQueue(Queues.MAIN);
            moduleDefinitionBuilder.getEventListeners().put(EventName.ON_ACTIVITY_RESULT, new EventListenerWithSenderAndPayload(EventName.ON_ACTIVITY_RESULT, new Function2<Activity, OnActivityResultPayload, Unit>() { // from class: expo.modules.localauthentication.LocalAuthenticationModule$definition$lambda$8$$inlined$OnActivityResult$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Activity activity, OnActivityResultPayload onActivityResultPayload) {
                    invoke2(activity, onActivityResultPayload);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Activity sender, OnActivityResultPayload payload) {
                    Fragment findFragmentByTag;
                    Promise promise;
                    Bundle createResponse;
                    Promise promise2;
                    Intrinsics.checkNotNullParameter(sender, "sender");
                    Intrinsics.checkNotNullParameter(payload, "payload");
                    int requestCode = payload.getRequestCode();
                    int resultCode = payload.getResultCode();
                    Intent data = payload.getData();
                    if (requestCode == 6) {
                        if (resultCode == -1) {
                            promise2 = LocalAuthenticationModule.this.promise;
                            if (promise2 != null) {
                                promise2.resolve(LocalAuthenticationModule.createResponse$default(LocalAuthenticationModule.this, null, null, 3, null));
                            }
                        } else {
                            promise = LocalAuthenticationModule.this.promise;
                            if (promise != null) {
                                createResponse = LocalAuthenticationModule.this.createResponse("user_cancel", "Device Credentials canceled");
                                promise.resolve(createResponse);
                            }
                        }
                        LocalAuthenticationModule.this.isAuthenticating = false;
                        LocalAuthenticationModule.this.isRetryingWithDeviceCredentials = false;
                        LocalAuthenticationModule.this.biometricPrompt = null;
                        LocalAuthenticationModule.this.promise = null;
                        LocalAuthenticationModule.this.authOptions = null;
                        return;
                    }
                    if (!(sender instanceof FragmentActivity) || (findFragmentByTag = ((FragmentActivity) sender).getSupportFragmentManager().findFragmentByTag("androidx.biometric.BiometricFragment")) == null) {
                        return;
                    }
                    findFragmentByTag.onActivityResult(requestCode & 65535, resultCode, data);
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
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

    /* JADX INFO: Access modifiers changed from: private */
    public final KeyguardManager getKeyguardManager() {
        Object systemService = getContext().getSystemService("keyguard");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.KeyguardManager");
        return (KeyguardManager) systemService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Activity getCurrentActivity() {
        return getAppContext().getCurrentActivity();
    }

    private final BiometricManager getBiometricManager() {
        return (BiometricManager) this.biometricManager.getValue();
    }

    private final PackageManager getPackageManager() {
        return (PackageManager) this.packageManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void authenticate(FragmentActivity fragmentActivity, AuthOptions options, Promise promise) {
        if (this.isAuthenticating) {
            Promise promise2 = this.promise;
            if (promise2 != null) {
                promise2.resolve(createResponse$default(this, "app_cancel", null, 2, null));
            }
            this.promise = promise;
            return;
        }
        String promptMessage = options.getPromptMessage();
        String cancelLabel = options.getCancelLabel();
        boolean disableDeviceFallback = options.getDisableDeviceFallback();
        boolean requireConfirmation = options.getRequireConfirmation();
        this.isAuthenticating = true;
        this.promise = promise;
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(newSingleThreadExecutor, "newSingleThreadExecutor()");
        this.biometricPrompt = new BiometricPrompt(fragmentActivity, newSingleThreadExecutor, this.authenticationCallback);
        BiometricPrompt.PromptInfo.Builder builder = new BiometricPrompt.PromptInfo.Builder();
        builder.setTitle(promptMessage);
        if (disableDeviceFallback) {
            builder.setNegativeButtonText(cancelLabel);
        } else {
            builder.setAllowedAuthenticators(33023);
        }
        builder.setConfirmationRequired(requireConfirmation);
        BiometricPrompt.PromptInfo build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "promptInfoBuilder.build()");
        try {
            BiometricPrompt biometricPrompt = this.biometricPrompt;
            Intrinsics.checkNotNull(biometricPrompt);
            biometricPrompt.authenticate(build);
        } catch (NullPointerException e) {
            promise.reject(new UnexpectedException("Canceled authentication due to an internal error", e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void promptDeviceCredentialsFallback(AuthOptions options, Promise promise) {
        FragmentActivity fragmentActivity = (FragmentActivity) getCurrentActivity();
        if (fragmentActivity == null) {
            promise.resolve(createResponse("not_available", "getCurrentActivity() returned null"));
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(getAppContext().getMainQueue(), null, null, new LocalAuthenticationModule$promptDeviceCredentialsFallback$1(this, options.getPromptMessage(), fragmentActivity, promise, options.getRequireConfirmation(), null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean hasSystemFeature(String feature) {
        return getPackageManager().hasSystemFeature(feature);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isDeviceSecure() {
        return getKeyguardManager().isDeviceSecure();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int canAuthenticateUsingWeakBiometrics() {
        return getBiometricManager().canAuthenticate(255);
    }

    static /* synthetic */ Bundle createResponse$default(LocalAuthenticationModule localAuthenticationModule, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        return localAuthenticationModule.createResponse(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bundle createResponse(String error, String warning) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("success", error == null);
        if (error != null) {
            bundle.putString("error", error);
        }
        if (warning != null) {
            bundle.putString("warning", warning);
        }
        return bundle;
    }
}
