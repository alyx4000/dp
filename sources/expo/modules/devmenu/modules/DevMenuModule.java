package expo.modules.devmenu.modules;

import android.app.Activity;
import androidx.tracing.Trace;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import expo.interfaces.devmenu.DevMenuManagerInterface;
import expo.modules.devmenu.DevMenuManager;
import expo.modules.devmenu.DevMenuUtilsKt;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* compiled from: DevMenuModule.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lexpo/modules/devmenu/modules/DevMenuModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity", "()Landroid/app/Activity;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-dev-menu_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DevMenuModule extends Module {
    public final Activity getCurrentActivity() {
        Activity currentActivity = getAppContext().getCurrentActivity();
        if (currentActivity != null) {
            return currentActivity;
        }
        throw new Exceptions.MissingActivity();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent asyncFunctionComponent;
        DevMenuModule devMenuModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (devMenuModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(devMenuModule);
            moduleDefinitionBuilder.Name(DevMenuUtilsKt.DEV_MENU_TAG);
            AsyncFunctionComponent asyncFunctionComponent2 = new AsyncFunctionComponent("openMenu", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.devmenu.modules.DevMenuModule$definition$lambda$5$$inlined$AsyncFunctionWithoutArgs$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    DevMenuManagerInterface.DefaultImpls.openMenu$default(DevMenuManager.INSTANCE, DevMenuModule.this.getCurrentActivity(), null, 2, null);
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("openMenu", asyncFunctionComponent2);
            AsyncFunctionComponent asyncFunctionComponent3 = asyncFunctionComponent2;
            AsyncFunctionComponent asyncFunctionComponent4 = new AsyncFunctionComponent("closeMenu", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.devmenu.modules.DevMenuModule$definition$lambda$5$$inlined$AsyncFunctionWithoutArgs$2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    DevMenuManager.INSTANCE.closeMenu();
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("closeMenu", asyncFunctionComponent4);
            AsyncFunctionComponent asyncFunctionComponent5 = asyncFunctionComponent4;
            AsyncFunctionComponent asyncFunctionComponent6 = new AsyncFunctionComponent("hideMenu", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.devmenu.modules.DevMenuModule$definition$lambda$5$$inlined$AsyncFunctionWithoutArgs$3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    DevMenuManager.INSTANCE.hideMenu();
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("hideMenu", asyncFunctionComponent6);
            AsyncFunctionComponent asyncFunctionComponent7 = asyncFunctionComponent6;
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            if (ReadableArray.class == Promise.class) {
                asyncFunctionComponent = new AsyncFunctionWithPromiseComponent("addDevMenuCallbacks", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.devmenu.modules.DevMenuModule$definition$lambda$5$$inlined$AsyncFunction$1
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        ReadableArray readableArray = (ReadableArray) promise;
                        int size = readableArray.size();
                        for (int i = 0; i < size; i++) {
                            ReadableMap map = readableArray.getMap(i);
                            Intrinsics.checkNotNullExpressionValue(map, "callbacks.getMap(i)");
                            String string = map.getString("name");
                            if (string != null) {
                                Intrinsics.checkNotNullExpressionValue(string, "callback.getString(\"name\") ?: continue");
                                DevMenuManager.INSTANCE.getRegisteredCallbacks().add(new DevMenuManager.Callback(string, map.hasKey("shouldCollapse") ? map.getBoolean("shouldCollapse") : true));
                            }
                        }
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                asyncFunctionComponent = new AsyncFunctionComponent("addDevMenuCallbacks", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArray.class), false, new Function0<KType>() { // from class: expo.modules.devmenu.modules.DevMenuModule$definition$lambda$5$$inlined$AsyncFunction$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(ReadableArray.class);
                    }
                }))}, new Function1<Object[], Object>() { // from class: expo.modules.devmenu.modules.DevMenuModule$definition$lambda$5$$inlined$AsyncFunction$3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object[] it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object obj = it[0];
                        if (obj == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.facebook.react.bridge.ReadableArray");
                        }
                        ReadableArray readableArray = (ReadableArray) obj;
                        int size = readableArray.size();
                        for (int i = 0; i < size; i++) {
                            ReadableMap map = readableArray.getMap(i);
                            Intrinsics.checkNotNullExpressionValue(map, "callbacks.getMap(i)");
                            String string = map.getString("name");
                            if (string != null) {
                                Intrinsics.checkNotNullExpressionValue(string, "callback.getString(\"name\") ?: continue");
                                DevMenuManager.INSTANCE.getRegisteredCallbacks().add(new DevMenuManager.Callback(string, map.hasKey("shouldCollapse") ? map.getBoolean("shouldCollapse") : true));
                            }
                        }
                        return Unit.INSTANCE;
                    }
                });
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("addDevMenuCallbacks", asyncFunctionComponent);
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: expo.modules.devmenu.modules.DevMenuModule$definition$lambda$5$$inlined$OnDestroy$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    DevMenuManager.INSTANCE.getRegisteredCallbacks().clear();
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
