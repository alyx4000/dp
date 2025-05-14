package expo.modules.webbrowser;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.os.BundleKt;
import androidx.tracing.Trace;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* compiled from: WebBrowserModule.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0080.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lexpo/modules/webbrowser/WebBrowserModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "connectionHelper", "Lexpo/modules/webbrowser/CustomTabsConnectionHelper;", "getConnectionHelper$expo_web_browser_release", "()Lexpo/modules/webbrowser/CustomTabsConnectionHelper;", "setConnectionHelper$expo_web_browser_release", "(Lexpo/modules/webbrowser/CustomTabsConnectionHelper;)V", "customTabsResolver", "Lexpo/modules/webbrowser/CustomTabsActivitiesHelper;", "getCustomTabsResolver$expo_web_browser_release", "()Lexpo/modules/webbrowser/CustomTabsActivitiesHelper;", "setCustomTabsResolver$expo_web_browser_release", "(Lexpo/modules/webbrowser/CustomTabsActivitiesHelper;)V", "createCustomTabsIntent", "Landroid/content/Intent;", "options", "Lexpo/modules/webbrowser/OpenBrowserOptions;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "givenOrPreferredPackageName", "", "packageName", "expo-web-browser_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class WebBrowserModule extends Module {
    public CustomTabsConnectionHelper connectionHelper;
    public CustomTabsActivitiesHelper customTabsResolver;

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        WebBrowserModule webBrowserModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (webBrowserModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(webBrowserModule);
            moduleDefinitionBuilder.Name("ExpoWebBrowser");
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$11$$inlined$OnCreate$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WebBrowserModule.this.setCustomTabsResolver$expo_web_browser_release(new CustomTabsActivitiesHelper(WebBrowserModule.this.getAppContext().getActivityProvider()));
                    WebBrowserModule webBrowserModule2 = WebBrowserModule.this;
                    Context reactContext = webBrowserModule2.getAppContext().getReactContext();
                    if (reactContext != null) {
                        webBrowserModule2.setConnectionHelper$expo_web_browser_release(new CustomTabsConnectionHelper(reactContext));
                        return;
                    }
                    throw new IllegalArgumentException("Cannot initialize WebBrowser, ReactContext is null".toString());
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.ACTIVITY_DESTROYS, new BasicEventListener(EventName.ACTIVITY_DESTROYS, new Function0<Unit>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$11$$inlined$OnActivityDestroys$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    WebBrowserModule.this.getConnectionHelper$expo_web_browser_release().destroy();
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("warmUpAsync", String.class == Promise.class ? new AsyncFunctionWithPromiseComponent("warmUpAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$11$$inlined$AsyncFunction$1
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    String givenOrPreferredPackageName;
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    givenOrPreferredPackageName = WebBrowserModule.this.givenOrPreferredPackageName((String) promise);
                    WebBrowserModule.this.getConnectionHelper$expo_web_browser_release().warmUp(givenOrPreferredPackageName);
                    BundleKt.bundleOf(TuplesKt.to("servicePackage", givenOrPreferredPackageName));
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("warmUpAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$11$$inlined$AsyncFunction$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(String.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$11$$inlined$AsyncFunction$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    String givenOrPreferredPackageName;
                    Intrinsics.checkNotNullParameter(it, "it");
                    givenOrPreferredPackageName = WebBrowserModule.this.givenOrPreferredPackageName((String) it[0]);
                    WebBrowserModule.this.getConnectionHelper$expo_web_browser_release().warmUp(givenOrPreferredPackageName);
                    return BundleKt.bundleOf(TuplesKt.to("servicePackage", givenOrPreferredPackageName));
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("coolDownAsync", String.class == Promise.class ? new AsyncFunctionWithPromiseComponent("coolDownAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$11$$inlined$AsyncFunction$4
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    String givenOrPreferredPackageName;
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    givenOrPreferredPackageName = WebBrowserModule.this.givenOrPreferredPackageName((String) promise);
                    if (WebBrowserModule.this.getConnectionHelper$expo_web_browser_release().coolDown(givenOrPreferredPackageName)) {
                        BundleKt.bundleOf(TuplesKt.to("servicePackage", givenOrPreferredPackageName));
                    } else {
                        new Bundle();
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("coolDownAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$11$$inlined$AsyncFunction$5
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(String.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$11$$inlined$AsyncFunction$6
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    String givenOrPreferredPackageName;
                    Intrinsics.checkNotNullParameter(it, "it");
                    givenOrPreferredPackageName = WebBrowserModule.this.givenOrPreferredPackageName((String) it[0]);
                    if (WebBrowserModule.this.getConnectionHelper$expo_web_browser_release().coolDown(givenOrPreferredPackageName)) {
                        return BundleKt.bundleOf(TuplesKt.to("servicePackage", givenOrPreferredPackageName));
                    }
                    return new Bundle();
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("mayInitWithUrlAsync", String.class == Promise.class ? new AsyncFunctionWithPromiseComponent("mayInitWithUrlAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$11$$inlined$AsyncFunction$7
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$11$$inlined$AsyncFunction$8
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    String givenOrPreferredPackageName;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj != null) {
                        givenOrPreferredPackageName = WebBrowserModule.this.givenOrPreferredPackageName((String) promise);
                        CustomTabsConnectionHelper connectionHelper$expo_web_browser_release = WebBrowserModule.this.getConnectionHelper$expo_web_browser_release();
                        Uri parse = Uri.parse((String) obj);
                        Intrinsics.checkNotNullExpressionValue(parse, "parse(url)");
                        connectionHelper$expo_web_browser_release.mayInitWithUrl(givenOrPreferredPackageName, parse);
                        BundleKt.bundleOf(TuplesKt.to("servicePackage", givenOrPreferredPackageName));
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("mayInitWithUrlAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$11$$inlined$AsyncFunction$9
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$11$$inlined$AsyncFunction$10
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(String.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$11$$inlined$AsyncFunction$11
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    String givenOrPreferredPackageName;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj != null) {
                        givenOrPreferredPackageName = WebBrowserModule.this.givenOrPreferredPackageName((String) it[1]);
                        CustomTabsConnectionHelper connectionHelper$expo_web_browser_release = WebBrowserModule.this.getConnectionHelper$expo_web_browser_release();
                        Uri parse = Uri.parse((String) obj);
                        Intrinsics.checkNotNullExpressionValue(parse, "parse(url)");
                        connectionHelper$expo_web_browser_release.mayInitWithUrl(givenOrPreferredPackageName, parse);
                        return BundleKt.bundleOf(TuplesKt.to("servicePackage", givenOrPreferredPackageName));
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }));
            AsyncFunctionComponent asyncFunctionComponent = new AsyncFunctionComponent("getCustomTabsSupportingBrowsersAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$11$$inlined$AsyncFunctionWithoutArgs$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ArrayList<String> customTabsResolvingActivities = WebBrowserModule.this.getCustomTabsResolver$expo_web_browser_release().getCustomTabsResolvingActivities();
                    ArrayList<String> customTabsResolvingServices = WebBrowserModule.this.getCustomTabsResolver$expo_web_browser_release().getCustomTabsResolvingServices();
                    String preferredCustomTabsResolvingActivity = WebBrowserModule.this.getCustomTabsResolver$expo_web_browser_release().getPreferredCustomTabsResolvingActivity(customTabsResolvingActivities);
                    String defaultCustomTabsResolvingActivity = WebBrowserModule.this.getCustomTabsResolver$expo_web_browser_release().getDefaultCustomTabsResolvingActivity();
                    if (!CollectionsKt.contains(customTabsResolvingActivities, defaultCustomTabsResolvingActivity)) {
                        defaultCustomTabsResolvingActivity = null;
                    }
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("browserPackages", customTabsResolvingActivities);
                    bundle.putStringArrayList("servicePackages", customTabsResolvingServices);
                    bundle.putString("preferredBrowserPackage", preferredCustomTabsResolvingActivity);
                    bundle.putString("defaultBrowserPackage", defaultCustomTabsResolvingActivity);
                    return bundle;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("getCustomTabsSupportingBrowsersAsync", asyncFunctionComponent);
            AsyncFunctionComponent asyncFunctionComponent2 = asyncFunctionComponent;
            moduleDefinitionBuilder.getAsyncFunctions().put("openBrowserAsync", OpenBrowserOptions.class == Promise.class ? new AsyncFunctionWithPromiseComponent("openBrowserAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$11$$inlined$AsyncFunction$12
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$11$$inlined$AsyncFunction$13
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    Intent createCustomTabsIntent;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj != null) {
                        createCustomTabsIntent = WebBrowserModule.this.createCustomTabsIntent((OpenBrowserOptions) promise);
                        createCustomTabsIntent.setData(Uri.parse((String) obj));
                        if (!WebBrowserModule.this.getCustomTabsResolver$expo_web_browser_release().canResolveIntent(createCustomTabsIntent)) {
                            throw new NoMatchingActivityException();
                        }
                        WebBrowserModule.this.getCustomTabsResolver$expo_web_browser_release().startCustomTabs(createCustomTabsIntent);
                        BundleKt.bundleOf(TuplesKt.to("type", "opened"));
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("openBrowserAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$11$$inlined$AsyncFunction$14
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(OpenBrowserOptions.class), false, new Function0<KType>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$11$$inlined$AsyncFunction$15
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(OpenBrowserOptions.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.webbrowser.WebBrowserModule$definition$lambda$11$$inlined$AsyncFunction$16
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intent createCustomTabsIntent;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = it[1];
                    if (obj2 != null) {
                        createCustomTabsIntent = WebBrowserModule.this.createCustomTabsIntent((OpenBrowserOptions) obj2);
                        createCustomTabsIntent.setData(Uri.parse(str));
                        if (!WebBrowserModule.this.getCustomTabsResolver$expo_web_browser_release().canResolveIntent(createCustomTabsIntent)) {
                            throw new NoMatchingActivityException();
                        }
                        WebBrowserModule.this.getCustomTabsResolver$expo_web_browser_release().startCustomTabs(createCustomTabsIntent);
                        return BundleKt.bundleOf(TuplesKt.to("type", "opened"));
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.webbrowser.OpenBrowserOptions");
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    public final CustomTabsActivitiesHelper getCustomTabsResolver$expo_web_browser_release() {
        CustomTabsActivitiesHelper customTabsActivitiesHelper = this.customTabsResolver;
        if (customTabsActivitiesHelper != null) {
            return customTabsActivitiesHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("customTabsResolver");
        return null;
    }

    public final void setCustomTabsResolver$expo_web_browser_release(CustomTabsActivitiesHelper customTabsActivitiesHelper) {
        Intrinsics.checkNotNullParameter(customTabsActivitiesHelper, "<set-?>");
        this.customTabsResolver = customTabsActivitiesHelper;
    }

    public final CustomTabsConnectionHelper getConnectionHelper$expo_web_browser_release() {
        CustomTabsConnectionHelper customTabsConnectionHelper = this.connectionHelper;
        if (customTabsConnectionHelper != null) {
            return customTabsConnectionHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("connectionHelper");
        return null;
    }

    public final void setConnectionHelper$expo_web_browser_release(CustomTabsConnectionHelper customTabsConnectionHelper) {
        Intrinsics.checkNotNullParameter(customTabsConnectionHelper, "<set-?>");
        this.connectionHelper = customTabsConnectionHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Intent createCustomTabsIntent(OpenBrowserOptions options) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        Integer toolbarColor = options.getToolbarColor();
        if (toolbarColor != null) {
            builder.setToolbarColor(toolbarColor.intValue());
        }
        Integer secondaryToolbarColor = options.getSecondaryToolbarColor();
        if (secondaryToolbarColor != null) {
            builder.setSecondaryToolbarColor(secondaryToolbarColor.intValue());
        }
        builder.setShowTitle(options.getShowTitle());
        if (options.getEnableDefaultShareMenuItem()) {
            builder.addDefaultShareMenuItem();
        }
        Intent intent = builder.build().intent;
        Intrinsics.checkNotNullExpressionValue(intent, "builder.build().intent");
        intent.putExtra(CustomTabsIntent.EXTRA_ENABLE_URLBAR_HIDING, options.getEnableBarCollapsing());
        String browserPackage = options.getBrowserPackage();
        if (!TextUtils.isEmpty(browserPackage)) {
            intent.setPackage(browserPackage);
        }
        if (options.getShouldCreateTask()) {
            intent.addFlags(268435456);
            if (!options.getShowInRecents()) {
                intent.addFlags(8388608);
                intent.addFlags(1073741824);
            }
        }
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0017 A[Catch: PackageManagerNotFoundException -> 0x0020, CurrentActivityNotFoundException -> 0x0026, TRY_LEAVE, TryCatch #2 {CurrentActivityNotFoundException -> 0x0026, PackageManagerNotFoundException -> 0x0020, blocks: (B:23:0x0005, B:5:0x0017), top: B:22:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String givenOrPreferredPackageName(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 1
            r1 = 0
            r2 = 0
            if (r5 == 0) goto L14
            r3 = r5
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch: expo.modules.webbrowser.PackageManagerNotFoundException -> L20 expo.modules.core.errors.CurrentActivityNotFoundException -> L26
            int r3 = r3.length()     // Catch: expo.modules.webbrowser.PackageManagerNotFoundException -> L20 expo.modules.core.errors.CurrentActivityNotFoundException -> L26
            if (r3 <= 0) goto L10
            r3 = r0
            goto L11
        L10:
            r3 = r1
        L11:
            if (r3 == 0) goto L14
            goto L15
        L14:
            r5 = r2
        L15:
            if (r5 != 0) goto L2c
            expo.modules.webbrowser.CustomTabsActivitiesHelper r5 = r4.getCustomTabsResolver$expo_web_browser_release()     // Catch: expo.modules.webbrowser.PackageManagerNotFoundException -> L20 expo.modules.core.errors.CurrentActivityNotFoundException -> L26
            java.lang.String r5 = r5.getPreferredCustomTabsResolvingActivity(r2)     // Catch: expo.modules.webbrowser.PackageManagerNotFoundException -> L20 expo.modules.core.errors.CurrentActivityNotFoundException -> L26
            goto L2c
        L20:
            expo.modules.webbrowser.NoPreferredPackageFound r5 = new expo.modules.webbrowser.NoPreferredPackageFound
            r5.<init>()
            throw r5
        L26:
            expo.modules.webbrowser.NoPreferredPackageFound r5 = new expo.modules.webbrowser.NoPreferredPackageFound
            r5.<init>()
            throw r5
        L2c:
            if (r5 == 0) goto L3f
            r3 = r5
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 <= 0) goto L38
            goto L39
        L38:
            r0 = r1
        L39:
            if (r0 == 0) goto L3c
            r2 = r5
        L3c:
            if (r2 == 0) goto L3f
            return r2
        L3f:
            expo.modules.webbrowser.NoPreferredPackageFound r5 = new expo.modules.webbrowser.NoPreferredPackageFound
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.webbrowser.WebBrowserModule.givenOrPreferredPackageName(java.lang.String):java.lang.String");
    }
}
