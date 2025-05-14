package expo.modules.devmenu.modules;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import androidx.tracing.Trace;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import expo.interfaces.devmenu.DevMenuPreferencesInterface;
import expo.modules.core.utilities.EmulatorUtilities;
import expo.modules.devmenu.DevMenuManager;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;

/* compiled from: DevMenuInternalModule.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lexpo/modules/devmenu/modules/DevMenuInternalModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-dev-menu_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DevMenuInternalModule extends Module {
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
        DevMenuInternalModule devMenuInternalModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (devMenuInternalModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(devMenuInternalModule);
            moduleDefinitionBuilder.Name("ExpoDevMenuInternal");
            moduleDefinitionBuilder.Constants(TuplesKt.to("doesDeviceSupportKeyCommands", Boolean.valueOf(EmulatorUtilities.INSTANCE.isRunningOnEmulator())));
            AsyncFunctionComponent asyncFunctionComponent = new AsyncFunctionComponent("loadFontsAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunctionWithoutArgs$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Context context;
                    Intrinsics.checkNotNullParameter(it, "it");
                    DevMenuManager devMenuManager = DevMenuManager.INSTANCE;
                    context = DevMenuInternalModule.this.getContext();
                    devMenuManager.loadFonts(context);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("loadFontsAsync", asyncFunctionComponent);
            AsyncFunctionComponent asyncFunctionComponent2 = asyncFunctionComponent;
            moduleDefinitionBuilder.getAsyncFunctions().put("dispatchCallableAsync", ReadableMap.class == Promise.class ? new AsyncFunctionWithPromiseComponent("dispatchCallableAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    DevMenuManager.INSTANCE.dispatchCallable((String) obj, (ReadableMap) promise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("dispatchCallableAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableMap.class), true, new Function0<KType>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(ReadableMap.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$5
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    ReadableMap readableMap = (ReadableMap) it[1];
                    DevMenuManager.INSTANCE.dispatchCallable((String) obj, readableMap);
                    return Unit.INSTANCE;
                }
            }));
            AsyncFunctionComponent asyncFunctionComponent3 = new AsyncFunctionComponent("hideMenu", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunctionWithoutArgs$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    DevMenuManager.INSTANCE.hideMenu();
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("hideMenu", asyncFunctionComponent3);
            AsyncFunctionComponent asyncFunctionComponent4 = asyncFunctionComponent3;
            AsyncFunctionComponent asyncFunctionComponent5 = new AsyncFunctionComponent("closeMenu", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunctionWithoutArgs$3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    DevMenuManager.INSTANCE.closeMenu();
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("closeMenu", asyncFunctionComponent5);
            AsyncFunctionComponent asyncFunctionComponent6 = asyncFunctionComponent5;
            moduleDefinitionBuilder.getAsyncFunctions().put("setOnboardingFinished", Boolean.class == Promise.class ? new AsyncFunctionWithPromiseComponent("setOnboardingFinished", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$6
                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    boolean booleanValue = ((Boolean) promise).booleanValue();
                    DevMenuPreferencesInterface settings = DevMenuManager.INSTANCE.getSettings();
                    if (settings == null) {
                        return;
                    }
                    settings.setOnboardingFinished(booleanValue);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("setOnboardingFinished", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$7
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Boolean.TYPE);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$8
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    DevMenuPreferencesInterface settings = DevMenuManager.INSTANCE.getSettings();
                    if (settings != null) {
                        settings.setOnboardingFinished(booleanValue);
                    }
                    return Unit.INSTANCE;
                }
            }));
            AsyncFunctionComponent asyncFunctionComponent7 = new AsyncFunctionComponent("openDevMenuFromReactNative", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Activity currentActivity;
                    Intrinsics.checkNotNullParameter(it, "it");
                    ReactInstanceManager reactInstanceManager = DevMenuManager.INSTANCE.getReactInstanceManager();
                    if (reactInstanceManager != null) {
                        final DevSupportManager devSupportManager = reactInstanceManager.getDevSupportManager();
                        ReactContext currentReactContext = reactInstanceManager.getCurrentReactContext();
                        if (currentReactContext != null && (currentActivity = currentReactContext.getCurrentActivity()) != null) {
                            Intrinsics.checkNotNullExpressionValue(currentActivity, "instanceManager.currentR…y ?: return@AsyncFunction");
                            currentActivity.runOnUiThread(new Runnable() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$1$6$1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    DevMenuManager.INSTANCE.closeMenu();
                                    DevSupportManager.this.setDevSupportEnabled(true);
                                    DevSupportManager.this.showDevOptionsDialog();
                                }
                            });
                        }
                    }
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("openDevMenuFromReactNative", asyncFunctionComponent7);
            AsyncFunctionComponent asyncFunctionComponent8 = asyncFunctionComponent7;
            moduleDefinitionBuilder.getAsyncFunctions().put("onScreenChangeAsync", String.class == Promise.class ? new AsyncFunctionWithPromiseComponent("onScreenChangeAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$10
                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    DevMenuManager.INSTANCE.setCurrentScreen((String) promise);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("onScreenChangeAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$11
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(String.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$12
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    DevMenuManager.INSTANCE.setCurrentScreen((String) it[0]);
                    return Unit.INSTANCE;
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("fetchDataSourceAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("fetchDataSourceAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$13
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$14
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj != null) {
                        BuildersKt__Builders_commonKt.launch$default(DevMenuManager.INSTANCE.getCoroutineScope(), null, null, new DevMenuInternalModule$definition$1$8$1((String) obj, promise, null), 3, null);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("fetchDataSourceAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$15
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$16
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$17
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Job launch$default;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = it[1];
                    if (obj2 != null) {
                        launch$default = BuildersKt__Builders_commonKt.launch$default(DevMenuManager.INSTANCE.getCoroutineScope(), null, null, new DevMenuInternalModule$definition$1$8$1(str, (Promise) obj2, null), 3, null);
                        return launch$default;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("copyToClipboardAsync", String.class == Promise.class ? new AsyncFunctionWithPromiseComponent("copyToClipboardAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$18
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Context context;
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    context = DevMenuInternalModule.this.getContext();
                    Object systemService = context.getSystemService("clipboard");
                    Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                    ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(null, (String) promise));
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("copyToClipboardAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$19
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$20
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Context context;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj != null) {
                        context = DevMenuInternalModule.this.getContext();
                        Object systemService = context.getSystemService("clipboard");
                        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
                        ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText(null, (String) obj));
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("fireCallback", String.class == Promise.class ? new AsyncFunctionWithPromiseComponent("fireCallback", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$21
                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Object obj;
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    String str = (String) promise;
                    Iterator<T> it = DevMenuManager.INSTANCE.getRegisteredCallbacks().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        } else {
                            obj = it.next();
                            if (Intrinsics.areEqual(((DevMenuManager.Callback) obj).getName(), str)) {
                                break;
                            }
                        }
                    }
                    DevMenuManager.Callback callback = (DevMenuManager.Callback) obj;
                    if (callback == null) {
                        throw new UnexpectedException("Callback with name: " + str + " is not registered");
                    }
                    DevMenuManager.INSTANCE.sendEventToDelegateBridge("registeredCallbackFired", str);
                    if (callback.getShouldCollapse()) {
                        DevMenuManager.INSTANCE.closeMenu();
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("fireCallback", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$22
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.devmenu.modules.DevMenuInternalModule$definition$lambda$11$$inlined$AsyncFunction$23
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Object obj;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj2 = it[0];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj2;
                    Iterator<T> it2 = DevMenuManager.INSTANCE.getRegisteredCallbacks().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it2.next();
                        if (Intrinsics.areEqual(((DevMenuManager.Callback) obj).getName(), str)) {
                            break;
                        }
                    }
                    DevMenuManager.Callback callback = (DevMenuManager.Callback) obj;
                    if (callback == null) {
                        throw new UnexpectedException("Callback with name: " + str + " is not registered");
                    }
                    DevMenuManager.INSTANCE.sendEventToDelegateBridge("registeredCallbackFired", str);
                    if (callback.getShouldCollapse()) {
                        DevMenuManager.INSTANCE.closeMenu();
                    }
                    return Unit.INSTANCE;
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
