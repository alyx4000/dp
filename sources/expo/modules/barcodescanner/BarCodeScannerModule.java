package expo.modules.barcodescanner;

import android.content.Context;
import android.util.Log;
import androidx.tracing.Trace;
import expo.modules.core.errors.ModuleDestroyedException;
import expo.modules.interfaces.barcodescanner.BarCodeScannerSettings;
import expo.modules.interfaces.imageloader.ImageLoaderInterface;
import expo.modules.interfaces.permissions.Permissions;
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
import expo.modules.kotlin.views.ConcreteViewProp;
import expo.modules.kotlin.views.ViewDefinitionBuilder;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: BarCodeScannerModule.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lexpo/modules/barcodescanner/BarCodeScannerModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "barCodeScannerProvider", "Lexpo/modules/barcodescanner/BarCodeScannerProvider;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "moduleCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "permissionsManager", "Lexpo/modules/interfaces/permissions/Permissions;", "getPermissionsManager", "()Lexpo/modules/interfaces/permissions/Permissions;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "Companion", "expo-barcode-scanner_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BarCodeScannerModule extends Module {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "BarCodeScannerModule";
    private final BarCodeScannerProvider barCodeScannerProvider = new BarCodeScannerProvider();
    private final CoroutineScope moduleCoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());

    /* JADX INFO: Access modifiers changed from: private */
    public final Context getContext() {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.ReactContextLost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Permissions getPermissionsManager() {
        Permissions permissions = getAppContext().getPermissions();
        if (permissions != null) {
            return permissions;
        }
        throw new Exceptions.PermissionsModuleNotFound();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        BarCodeScannerModule barCodeScannerModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (barCodeScannerModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(barCodeScannerModule);
            moduleDefinitionBuilder.Name("ExpoBarCodeScanner");
            moduleDefinitionBuilder.Constants(TuplesKt.to("BarCodeType", MapsKt.mapOf(TuplesKt.to("aztec", 4096), TuplesKt.to("ean13", 32), TuplesKt.to("ean8", 64), TuplesKt.to("qr", 256), TuplesKt.to("pdf417", 2048), TuplesKt.to("upc_e", 1024), TuplesKt.to("datamatrix", 16), TuplesKt.to("code39", 2), TuplesKt.to("code93", 4), TuplesKt.to("itf14", 128), TuplesKt.to("codabar", 8), TuplesKt.to("code128", 1), TuplesKt.to("upc_a", 512))), TuplesKt.to("Type", MapsKt.mapOf(TuplesKt.to("front", 1), TuplesKt.to("back", 2))));
            moduleDefinitionBuilder.getAsyncFunctions().put("requestPermissionsAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("requestPermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.barcodescanner.BarCodeScannerModule$definition$lambda$5$$inlined$AsyncFunction$1
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
                    Permissions permissionsManager;
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    permissionsManager = BarCodeScannerModule.this.getPermissionsManager();
                    Permissions.askForPermissionsWithPermissionsManager(permissionsManager, promise, "android.permission.CAMERA");
                }
            }) : new AsyncFunctionComponent("requestPermissionsAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.barcodescanner.BarCodeScannerModule$definition$lambda$5$$inlined$AsyncFunction$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.barcodescanner.BarCodeScannerModule$definition$lambda$5$$inlined$AsyncFunction$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Permissions permissionsManager;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj != null) {
                        permissionsManager = BarCodeScannerModule.this.getPermissionsManager();
                        Permissions.askForPermissionsWithPermissionsManager(permissionsManager, (Promise) obj, "android.permission.CAMERA");
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("getPermissionsAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("getPermissionsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.barcodescanner.BarCodeScannerModule$definition$lambda$5$$inlined$AsyncFunction$4
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
                    Permissions permissionsManager;
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    permissionsManager = BarCodeScannerModule.this.getPermissionsManager();
                    Permissions.getPermissionsWithPermissionsManager(permissionsManager, promise, "android.permission.CAMERA");
                }
            }) : new AsyncFunctionComponent("getPermissionsAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.barcodescanner.BarCodeScannerModule$definition$lambda$5$$inlined$AsyncFunction$5
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.barcodescanner.BarCodeScannerModule$definition$lambda$5$$inlined$AsyncFunction$6
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Permissions permissionsManager;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj != null) {
                        permissionsManager = BarCodeScannerModule.this.getPermissionsManager();
                        Permissions.getPermissionsWithPermissionsManager(permissionsManager, (Promise) obj, "android.permission.CAMERA");
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("scanFromURLAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("scanFromURLAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.barcodescanner.BarCodeScannerModule$definition$lambda$5$$inlined$AsyncFunction$7
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(List.class), false, new Function0<KType>() { // from class: expo.modules.barcodescanner.BarCodeScannerModule$definition$lambda$5$$inlined$AsyncFunction$8
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Integer.TYPE)));
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.barcodescanner.BarCodeScannerModule$definition$lambda$5$$inlined$AsyncFunction$9
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = args[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.Int>");
                    }
                    List list = (List) obj2;
                    ImageLoaderInterface imageLoader = BarCodeScannerModule.this.getAppContext().getImageLoader();
                    if (imageLoader != null) {
                        imageLoader.loadImageForManipulationFromURL(str, new BarCodeScannerModule$definition$1$3$1(BarCodeScannerModule.this, list, promise, str));
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("scanFromURLAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.barcodescanner.BarCodeScannerModule$definition$lambda$5$$inlined$AsyncFunction$10
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(List.class), false, new Function0<KType>() { // from class: expo.modules.barcodescanner.BarCodeScannerModule$definition$lambda$5$$inlined$AsyncFunction$11
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(Integer.TYPE)));
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.barcodescanner.BarCodeScannerModule$definition$lambda$5$$inlined$AsyncFunction$12
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.barcodescanner.BarCodeScannerModule$definition$lambda$5$$inlined$AsyncFunction$13
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.Int>");
                    }
                    List list = (List) obj2;
                    Object obj3 = it[2];
                    if (obj3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                    }
                    Promise promise = (Promise) obj3;
                    ImageLoaderInterface imageLoader = BarCodeScannerModule.this.getAppContext().getImageLoader();
                    if (imageLoader == null) {
                        return null;
                    }
                    imageLoader.loadImageForManipulationFromURL(str, new BarCodeScannerModule$definition$1$3$1(BarCodeScannerModule.this, list, promise, str));
                    return Unit.INSTANCE;
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: expo.modules.barcodescanner.BarCodeScannerModule$definition$lambda$5$$inlined$OnDestroy$1
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
                    CoroutineScope coroutineScope;
                    try {
                        coroutineScope = BarCodeScannerModule.this.moduleCoroutineScope;
                        CoroutineScopeKt.cancel(coroutineScope, new ModuleDestroyedException(null, 1, null));
                    } catch (IllegalStateException unused) {
                        Log.e(BarCodeScannerModule.TAG, "The scope does not have a job in it");
                    }
                }
            }));
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(BarCodeScannerView.class);
            if (!(moduleDefinitionBuilder.getViewManagerDefinition() == null)) {
                throw new IllegalArgumentException("The module definition may have exported only one view manager.".toString());
            }
            ViewDefinitionBuilder viewDefinitionBuilder = new ViewDefinitionBuilder(orCreateKotlinClass, new LazyKType(Reflection.getOrCreateKotlinClass(BarCodeScannerView.class), false, new Function0<KType>() { // from class: expo.modules.barcodescanner.BarCodeScannerModule$definition$lambda$5$$inlined$View$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(BarCodeScannerView.class);
                }
            }, 2, null));
            viewDefinitionBuilder.Events("onBarCodeScanned");
            viewDefinitionBuilder.getProps().put("type", new ConcreteViewProp("type", new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.barcodescanner.BarCodeScannerModule$definition$lambda$5$lambda$4$$inlined$Prop$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Integer.TYPE);
                }
            })), new Function2<BarCodeScannerView, Integer, Unit>() { // from class: expo.modules.barcodescanner.BarCodeScannerModule$definition$1$5$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(BarCodeScannerView barCodeScannerView, Integer num) {
                    invoke(barCodeScannerView, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(BarCodeScannerView view, int i) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setCameraType(i);
                }
            }));
            viewDefinitionBuilder.getProps().put("barCodeTypes", new ConcreteViewProp("barCodeTypes", new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ArrayList.class), true, new Function0<KType>() { // from class: expo.modules.barcodescanner.BarCodeScannerModule$definition$lambda$5$lambda$4$$inlined$Prop$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(ArrayList.class, KTypeProjection.INSTANCE.invariant(Reflection.nullableTypeOf(Double.class)));
                }
            })), new Function2<BarCodeScannerView, ArrayList<Double>, Unit>() { // from class: expo.modules.barcodescanner.BarCodeScannerModule$definition$1$5$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(BarCodeScannerView barCodeScannerView, ArrayList<Double> arrayList) {
                    invoke2(barCodeScannerView, arrayList);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(BarCodeScannerView view, ArrayList<Double> arrayList) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    if (arrayList != null) {
                        BarCodeScannerSettings barCodeScannerSettings = new BarCodeScannerSettings();
                        barCodeScannerSettings.putTypes(arrayList);
                        view.setBarCodeScannerSettings(barCodeScannerSettings);
                    }
                }
            }));
            moduleDefinitionBuilder.setViewManagerDefinition(viewDefinitionBuilder.build());
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* compiled from: BarCodeScannerModule.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/barcodescanner/BarCodeScannerModule$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG$expo_barcode_scanner_release", "()Ljava/lang/String;", "expo-barcode-scanner_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG$expo_barcode_scanner_release() {
            return BarCodeScannerModule.TAG;
        }
    }
}
