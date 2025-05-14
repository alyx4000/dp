package expo.modules.devmenu.modules;

import android.content.Context;
import androidx.tracing.Trace;
import com.facebook.react.bridge.ReadableMap;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
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

/* compiled from: DevMenuPreferences.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lexpo/modules/devmenu/modules/DevMenuPreferences;", "Lexpo/modules/kotlin/modules/Module;", "()V", "preferencesHandel", "Lexpo/modules/devmenu/modules/DevMenuPreferencesHandle;", "getPreferencesHandel", "()Lexpo/modules/devmenu/modules/DevMenuPreferencesHandle;", "preferencesHandel$delegate", "Lkotlin/Lazy;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-dev-menu_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DevMenuPreferences extends Module {

    /* renamed from: preferencesHandel$delegate, reason: from kotlin metadata */
    private final Lazy preferencesHandel = LazyKt.lazy(new Function0<DevMenuPreferencesHandle>() { // from class: expo.modules.devmenu.modules.DevMenuPreferences$preferencesHandel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DevMenuPreferencesHandle invoke() {
            Context reactContext = DevMenuPreferences.this.getAppContext().getReactContext();
            if (reactContext != null) {
                return new DevMenuPreferencesHandle(reactContext);
            }
            throw new Exceptions.ReactContextLost();
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final DevMenuPreferencesHandle getPreferencesHandel() {
        return (DevMenuPreferencesHandle) this.preferencesHandel.getValue();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent asyncFunctionComponent;
        DevMenuPreferences devMenuPreferences = this;
        Trace.beginSection("[ExpoModulesCore] " + (devMenuPreferences.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(devMenuPreferences);
            moduleDefinitionBuilder.Name("DevMenuPreferences");
            AsyncFunctionComponent asyncFunctionComponent2 = new AsyncFunctionComponent("getPreferencesAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.devmenu.modules.DevMenuPreferences$definition$lambda$2$$inlined$AsyncFunctionWithoutArgs$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    DevMenuPreferencesHandle preferencesHandel;
                    Intrinsics.checkNotNullParameter(it, "it");
                    preferencesHandel = DevMenuPreferences.this.getPreferencesHandel();
                    return preferencesHandel.serialize();
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("getPreferencesAsync", asyncFunctionComponent2);
            AsyncFunctionComponent asyncFunctionComponent3 = asyncFunctionComponent2;
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            if (ReadableMap.class == Promise.class) {
                asyncFunctionComponent = new AsyncFunctionWithPromiseComponent("setPreferencesAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.devmenu.modules.DevMenuPreferences$definition$lambda$2$$inlined$AsyncFunction$1
                    {
                        super(2);
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        DevMenuPreferencesHandle preferencesHandel;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        preferencesHandel = DevMenuPreferences.this.getPreferencesHandel();
                        preferencesHandel.setPreferences((ReadableMap) promise);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                asyncFunctionComponent = new AsyncFunctionComponent("setPreferencesAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableMap.class), false, new Function0<KType>() { // from class: expo.modules.devmenu.modules.DevMenuPreferences$definition$lambda$2$$inlined$AsyncFunction$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(ReadableMap.class);
                    }
                }))}, new Function1<Object[], Object>() { // from class: expo.modules.devmenu.modules.DevMenuPreferences$definition$lambda$2$$inlined$AsyncFunction$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object[] it) {
                        DevMenuPreferencesHandle preferencesHandel;
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object obj = it[0];
                        if (obj != null) {
                            preferencesHandel = DevMenuPreferences.this.getPreferencesHandel();
                            preferencesHandel.setPreferences((ReadableMap) obj);
                            return Unit.INSTANCE;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.facebook.react.bridge.ReadableMap");
                    }
                });
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("setPreferencesAsync", asyncFunctionComponent);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
