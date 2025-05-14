package expo.modules.updates;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.tracing.Trace;
import com.google.firebase.perf.util.Constants;
import com.socure.docv.capturesdk.common.utils.ApiConstant;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.updates.IUpdatesController;
import expo.modules.updates.UpdatesConfiguration;
import expo.modules.updates.db.entity.AssetEntity;
import expo.modules.updates.db.entity.UpdateEntity;
import expo.modules.updates.logging.UpdatesErrorCode;
import expo.modules.updates.logging.UpdatesLogEntry;
import expo.modules.updates.logging.UpdatesLogReader;
import expo.modules.updates.logging.UpdatesLogger;
import io.sentry.SentryEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* compiled from: UpdatesModule.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lexpo/modules/updates/UpdatesModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", SentryEvent.JsonKeys.LOGGER, "Lexpo/modules/updates/logging/UpdatesLogger;", "getLogger", "()Lexpo/modules/updates/logging/UpdatesLogger;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "Companion", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UpdatesModule extends Module {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "UpdatesModule";

    /* JADX INFO: Access modifiers changed from: private */
    public final UpdatesLogger getLogger() {
        return new UpdatesLogger(getContext());
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
        UpdatesModule updatesModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (updatesModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(updatesModule);
            moduleDefinitionBuilder.Name("ExpoUpdates");
            moduleDefinitionBuilder.Constants(new Function0<Map<String, ? extends Object>>() { // from class: expo.modules.updates.UpdatesModule$definition$1$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Map<String, ? extends Object> invoke() {
                    Context context;
                    Context context2;
                    UUID id;
                    context = UpdatesModule.this.getContext();
                    new UpdatesLogger(context).info("UpdatesModule: getConstants called", UpdatesErrorCode.None);
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    try {
                        IUpdatesController.UpdatesModuleConstants constantsForModule = UpdatesController.INSTANCE.getInstance().getConstantsForModule();
                        UpdateEntity launchedUpdate = constantsForModule.getLaunchedUpdate();
                        UpdateEntity embeddedUpdate = constantsForModule.getEmbeddedUpdate();
                        boolean equals = (launchedUpdate == null || (id = launchedUpdate.getId()) == null) ? false : id.equals(embeddedUpdate != null ? embeddedUpdate.getId() : null);
                        linkedHashMap.put("isEmergencyLaunch", Boolean.valueOf(constantsForModule.isEmergencyLaunch()));
                        linkedHashMap.put("isEmbeddedLaunch", Boolean.valueOf(equals));
                        linkedHashMap.put(Constants.ENABLE_DISABLE, Boolean.valueOf(constantsForModule.isEnabled()));
                        linkedHashMap.put(UpdatesConfiguration.UPDATES_CONFIGURATION_RELEASE_CHANNEL_KEY, constantsForModule.getReleaseChannel());
                        linkedHashMap.put("isUsingEmbeddedAssets", Boolean.valueOf(constantsForModule.isUsingEmbeddedAssets()));
                        String runtimeVersion = constantsForModule.getRuntimeVersion();
                        String str = "";
                        if (runtimeVersion == null) {
                            runtimeVersion = "";
                        }
                        linkedHashMap.put(UpdatesConfiguration.UPDATES_CONFIGURATION_RUNTIME_VERSION_KEY, runtimeVersion);
                        linkedHashMap.put("checkAutomatically", constantsForModule.getCheckOnLaunch().toJSString());
                        String str2 = constantsForModule.getRequestHeaders().get("expo-channel-name");
                        if (str2 != null) {
                            str = str2;
                        }
                        linkedHashMap.put("channel", str);
                        linkedHashMap.put("shouldDeferToNativeForAPIMethodAvailabilityInDevelopment", Boolean.valueOf(constantsForModule.getShouldDeferToNativeForAPIMethodAvailabilityInDevelopment()));
                        if (launchedUpdate != null) {
                            String uuid = launchedUpdate.getId().toString();
                            Intrinsics.checkNotNullExpressionValue(uuid, "launchedUpdate.id.toString()");
                            linkedHashMap.put("updateId", uuid);
                            linkedHashMap.put("commitTime", Long.valueOf(launchedUpdate.getCommitTime().getTime()));
                            String jSONObject = launchedUpdate.getManifest().toString();
                            Intrinsics.checkNotNullExpressionValue(jSONObject, "launchedUpdate.manifest.toString()");
                            linkedHashMap.put("manifestString", jSONObject);
                        }
                        Map<AssetEntity, String> localAssetFiles = constantsForModule.getLocalAssetFiles();
                        if (localAssetFiles != null) {
                            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                            for (AssetEntity assetEntity : localAssetFiles.keySet()) {
                                if (assetEntity.getKey() != null) {
                                    String key = assetEntity.getKey();
                                    Intrinsics.checkNotNull(key);
                                    String str3 = localAssetFiles.get(assetEntity);
                                    Intrinsics.checkNotNull(str3);
                                    linkedHashMap2.put(key, str3);
                                }
                            }
                            linkedHashMap.put("localAssets", linkedHashMap2);
                        }
                    } catch (Exception unused) {
                        linkedHashMap.put(Constants.ENABLE_DISABLE, false);
                        UpdatesConfiguration.Companion companion = UpdatesConfiguration.INSTANCE;
                        context2 = UpdatesModule.this.getContext();
                        linkedHashMap.put("isMissingRuntimeVersion", Boolean.valueOf(companion.isMissingRuntimeVersion(context2, null)));
                    }
                    return linkedHashMap;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("reload", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("reload", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$8$$inlined$AsyncFunction$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    UpdatesController.INSTANCE.getInstance().relaunchReactApplicationForModule(new UpdatesModule$definition$1$2$1(promise));
                }
            }) : new AsyncFunctionComponent("reload", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$8$$inlined$AsyncFunction$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$8$$inlined$AsyncFunction$3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                    }
                    UpdatesController.INSTANCE.getInstance().relaunchReactApplicationForModule(new UpdatesModule$definition$1$2$1((Promise) obj));
                    return Unit.INSTANCE;
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("getNativeStateMachineContextAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("getNativeStateMachineContextAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$8$$inlined$AsyncFunction$4
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    UpdatesController.INSTANCE.getInstance().getNativeStateMachineContext(new UpdatesModule$definition$1$3$1(promise));
                }
            }) : new AsyncFunctionComponent("getNativeStateMachineContextAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$8$$inlined$AsyncFunction$5
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$8$$inlined$AsyncFunction$6
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                    }
                    UpdatesController.INSTANCE.getInstance().getNativeStateMachineContext(new UpdatesModule$definition$1$3$1((Promise) obj));
                    return Unit.INSTANCE;
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("checkForUpdateAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("checkForUpdateAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$8$$inlined$AsyncFunction$7
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    UpdatesController.INSTANCE.getInstance().checkForUpdate(new UpdatesModule$definition$1$4$1(promise));
                }
            }) : new AsyncFunctionComponent("checkForUpdateAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$8$$inlined$AsyncFunction$8
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$8$$inlined$AsyncFunction$9
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                    }
                    UpdatesController.INSTANCE.getInstance().checkForUpdate(new UpdatesModule$definition$1$4$1((Promise) obj));
                    return Unit.INSTANCE;
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("fetchUpdateAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("fetchUpdateAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$8$$inlined$AsyncFunction$10
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    UpdatesController.INSTANCE.getInstance().fetchUpdate(new UpdatesModule$definition$1$5$1(promise));
                }
            }) : new AsyncFunctionComponent("fetchUpdateAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$8$$inlined$AsyncFunction$11
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$8$$inlined$AsyncFunction$12
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                    }
                    UpdatesController.INSTANCE.getInstance().fetchUpdate(new UpdatesModule$definition$1$5$1((Promise) obj));
                    return Unit.INSTANCE;
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("getExtraParamsAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("getExtraParamsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$8$$inlined$AsyncFunction$13
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
                    UpdatesLogger logger;
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    logger = UpdatesModule.this.getLogger();
                    UpdatesLogger.debug$default(logger, "Called getExtraParamsAsync", null, 2, null);
                    UpdatesController.INSTANCE.getInstance().getExtraParams(new UpdatesModule$definition$1$6$1(promise));
                }
            }) : new AsyncFunctionComponent("getExtraParamsAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$8$$inlined$AsyncFunction$14
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$8$$inlined$AsyncFunction$15
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    UpdatesLogger logger;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj != null) {
                        logger = UpdatesModule.this.getLogger();
                        UpdatesLogger.debug$default(logger, "Called getExtraParamsAsync", null, 2, null);
                        UpdatesController.INSTANCE.getInstance().getExtraParams(new UpdatesModule$definition$1$6$1((Promise) obj));
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("setExtraParamAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("setExtraParamAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$8$$inlined$AsyncFunction$16
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$8$$inlined$AsyncFunction$17
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$8$$inlined$AsyncFunction$18
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    UpdatesLogger logger;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj != null) {
                        String str = (String) obj;
                        String str2 = (String) args[1];
                        logger = UpdatesModule.this.getLogger();
                        UpdatesLogger.debug$default(logger, "Called setExtraParamAsync with key = " + str + ", value = " + str2, null, 2, null);
                        UpdatesController.INSTANCE.getInstance().setExtraParam(str, str2, new UpdatesModule$definition$1$7$1(promise));
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("setExtraParamAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$8$$inlined$AsyncFunction$19
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$8$$inlined$AsyncFunction$20
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$8$$inlined$AsyncFunction$21
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$8$$inlined$AsyncFunction$22
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    UpdatesLogger logger;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    String str2 = (String) it[1];
                    Object obj2 = it[2];
                    if (obj2 != null) {
                        logger = UpdatesModule.this.getLogger();
                        UpdatesLogger.debug$default(logger, "Called setExtraParamAsync with key = " + str + ", value = " + str2, null, 2, null);
                        UpdatesController.INSTANCE.getInstance().setExtraParam(str, str2, new UpdatesModule$definition$1$7$1((Promise) obj2));
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("readLogEntriesAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("readLogEntriesAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Long.class), false, new Function0<KType>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$8$$inlined$AsyncFunction$23
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Long.TYPE);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$8$$inlined$AsyncFunction$24
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    AsyncTask.execute(new UpdatesModule$definition$1$8$1(promise, UpdatesModule.this, ((Long) obj).longValue()));
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("readLogEntriesAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Long.class), false, new Function0<KType>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$8$$inlined$AsyncFunction$25
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Long.TYPE);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$8$$inlined$AsyncFunction$26
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$8$$inlined$AsyncFunction$27
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    Long l = (Long) obj;
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                    }
                    AsyncTask.execute(new UpdatesModule$definition$1$8$1((Promise) obj2, UpdatesModule.this, l.longValue()));
                    return Unit.INSTANCE;
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("clearLogEntriesAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("clearLogEntriesAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$8$$inlined$AsyncFunction$28
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
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    AsyncTask.execute(new UpdatesModule$definition$1$9$1(UpdatesModule.this, promise));
                }
            }) : new AsyncFunctionComponent("clearLogEntriesAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$8$$inlined$AsyncFunction$29
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.updates.UpdatesModule$definition$lambda$8$$inlined$AsyncFunction$30
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                    }
                    AsyncTask.execute(new UpdatesModule$definition$1$9$1(UpdatesModule.this, (Promise) obj));
                    return Unit.INSTANCE;
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* compiled from: UpdatesModule.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2)\u0010\n\u001a%\u0012\u001b\u0012\u0019\u0018\u00010\fj\u0004\u0018\u0001`\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00070\u000bH\u0000¢\u0006\u0002\b\u0011J#\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0016H\u0000¢\u0006\u0002\b\u0017R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lexpo/modules/updates/UpdatesModule$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "clearLogEntries", "", "context", "Landroid/content/Context;", "completionHandler", "Lkotlin/Function1;", "Ljava/lang/Error;", "Lkotlin/Error;", "Lkotlin/ParameterName;", "name", "_", "clearLogEntries$expo_updates_release", "readLogEntries", "", "Landroid/os/Bundle;", "maxAge", "", "readLogEntries$expo_updates_release", "expo-updates_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<Bundle> readLogEntries$expo_updates_release(Context context, long maxAge) {
            Intrinsics.checkNotNullParameter(context, "context");
            List<String> logEntries = new UpdatesLogReader(context).getLogEntries(new Date(new Date().getTime() - maxAge));
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = logEntries.iterator();
            while (it.hasNext()) {
                UpdatesLogEntry create = UpdatesLogEntry.INSTANCE.create((String) it.next());
                if (create != null) {
                    arrayList.add(create);
                }
            }
            ArrayList<UpdatesLogEntry> arrayList2 = arrayList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
            for (UpdatesLogEntry updatesLogEntry : arrayList2) {
                Bundle bundle = new Bundle();
                bundle.putLong("timestamp", updatesLogEntry.getTimestamp());
                bundle.putString("message", updatesLogEntry.getMessage());
                bundle.putString(ApiConstant.KEY_CODE, updatesLogEntry.getCode());
                bundle.putString("level", updatesLogEntry.getLevel());
                if (updatesLogEntry.getUpdateId() != null) {
                    bundle.putString("updateId", updatesLogEntry.getUpdateId());
                }
                if (updatesLogEntry.getAssetId() != null) {
                    bundle.putString("assetId", updatesLogEntry.getAssetId());
                }
                if (updatesLogEntry.getStacktrace() != null) {
                    bundle.putStringArray("stacktrace", (String[]) updatesLogEntry.getStacktrace().toArray(new String[0]));
                }
                arrayList3.add(bundle);
            }
            return arrayList3;
        }

        public final void clearLogEntries$expo_updates_release(Context context, Function1<? super Error, Unit> completionHandler) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(completionHandler, "completionHandler");
            new UpdatesLogReader(context).purgeLogEntries(new Date(), completionHandler);
        }
    }
}
