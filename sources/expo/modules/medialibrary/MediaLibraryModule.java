package expo.modules.medialibrary;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentSender;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.util.Log;
import androidx.tracing.Trace;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.core.errors.ModuleDestroyedException;
import expo.modules.core.interfaces.ActivityProvider;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventListenerWithSenderAndPayload;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.events.OnActivityResultPayload;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.medialibrary.MediaLibraryModule;
import expo.modules.medialibrary.MediaLibraryUtils;
import expo.modules.medialibrary.albums.AlbumUtilsKt;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* compiled from: MediaLibraryModule.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 12\u00020\u0001:\u0003012B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0016\u001a\u00020\u00042\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0016J#\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020\u0010H\u0003¢\u0006\u0002\u0010!J\u001b\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020\u0010H\u0003¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020\u0010H\u0002J\b\u0010%\u001a\u00020\u0010H\u0002J\u001e\u0010&\u001a\u00020\u00192\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001e0(2\u0006\u0010)\u001a\u00020\u0004H\u0002J!\u0010*\u001a\u00020\u00192\b\b\u0002\u0010+\u001a\u00020\u00102\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0082\bJ!\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u000e\b\u0004\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0082\bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0018\u00010\u000eR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0011R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0018\u00010\u000eR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lexpo/modules/medialibrary/MediaLibraryModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "awaitingAction", "Lexpo/modules/medialibrary/MediaLibraryModule$Action;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity", "()Landroid/app/Activity;", "imagesObserver", "Lexpo/modules/medialibrary/MediaLibraryModule$MediaStoreContentObserver;", "isMissingPermissions", "", "()Z", "isMissingWritePermission", "moduleCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "videosObserver", "actionIfUserGrantedPermission", "block", "Lkotlin/Function0;", "", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "getGranularPermissions", "", "", "writeOnly", "shouldAdd", "(ZZ)[Ljava/lang/String;", "getManifestPermissions", "(Z)[Ljava/lang/String;", "hasReadPermissions", "hasWritePermissions", "runActionWithPermissions", "assetsId", "", "action", "throwUnlessPermissionsGranted", "isWrite", "withModuleScope", "Lkotlinx/coroutines/Job;", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "Action", "Companion", "MediaStoreContentObserver", "expo-media-library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MediaLibraryModule extends Module {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "MediaLibraryModule";
    private static final int WRITE_REQUEST_CODE = 7463;
    private Action awaitingAction;
    private MediaStoreContentObserver imagesObserver;
    private final CoroutineScope moduleCoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
    private MediaStoreContentObserver videosObserver;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MediaLibraryModule.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bâ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lexpo/modules/medialibrary/MediaLibraryModule$Action;", "", "runWithPermissions", "", "permissionsWereGranted", "", "expo-media-library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    interface Action {
        void runWithPermissions(boolean permissionsWereGranted);
    }

    public static final /* synthetic */ Context access$getContext(MediaLibraryModule mediaLibraryModule) {
        return mediaLibraryModule.getContext();
    }

    public static final /* synthetic */ CoroutineScope access$getModuleCoroutineScope$p(MediaLibraryModule mediaLibraryModule) {
        return mediaLibraryModule.moduleCoroutineScope;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context getContext() {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.ReactContextLost();
    }

    private final Activity getCurrentActivity() {
        ActivityProvider activityProvider = getAppContext().getActivityProvider();
        Activity currentActivity = activityProvider != null ? activityProvider.getCurrentActivity() : null;
        if (currentActivity != null) {
            return currentActivity;
        }
        throw new Exceptions.MissingActivity();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        MediaLibraryModule mediaLibraryModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (mediaLibraryModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(mediaLibraryModule);
            moduleDefinitionBuilder.Name("ExpoMediaLibrary");
            moduleDefinitionBuilder.Constants(new Function0<Map<String, ? extends Object>>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$1$1
                @Override // kotlin.jvm.functions.Function0
                public final Map<String, ? extends Object> invoke() {
                    return MapsKt.mapOf(TuplesKt.to("MediaType", MediaType.INSTANCE.getConstants()), TuplesKt.to("SortBy", SortBy.INSTANCE.getConstants()), TuplesKt.to("CHANGE_LISTENER_NAME", MediaLibraryConstantsKt.LIBRARY_DID_CHANGE_EVENT));
                }
            });
            moduleDefinitionBuilder.Events(MediaLibraryConstantsKt.LIBRARY_DID_CHANGE_EVENT);
            moduleDefinitionBuilder.getAsyncFunctions().put("requestPermissionsAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("requestPermissionsAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Boolean.TYPE);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$2
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    String[] manifestPermissions;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    Permissions permissions = MediaLibraryModule.this.getAppContext().getPermissions();
                    manifestPermissions = MediaLibraryModule.this.getManifestPermissions(booleanValue);
                    Permissions.askForPermissionsWithPermissionsManager(permissions, promise, (String[]) Arrays.copyOf(manifestPermissions, manifestPermissions.length));
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("requestPermissionsAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Boolean.TYPE);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$5
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    String[] manifestPermissions;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    Boolean bool = (Boolean) obj;
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                    }
                    boolean booleanValue = bool.booleanValue();
                    Permissions permissions = MediaLibraryModule.this.getAppContext().getPermissions();
                    manifestPermissions = MediaLibraryModule.this.getManifestPermissions(booleanValue);
                    Permissions.askForPermissionsWithPermissionsManager(permissions, (Promise) obj2, (String[]) Arrays.copyOf(manifestPermissions, manifestPermissions.length));
                    return Unit.INSTANCE;
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("getPermissionsAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("getPermissionsAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$6
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Boolean.TYPE);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$7
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    String[] manifestPermissions;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    boolean booleanValue = ((Boolean) obj).booleanValue();
                    Permissions permissions = MediaLibraryModule.this.getAppContext().getPermissions();
                    manifestPermissions = MediaLibraryModule.this.getManifestPermissions(booleanValue);
                    Permissions.getPermissionsWithPermissionsManager(permissions, promise, (String[]) Arrays.copyOf(manifestPermissions, manifestPermissions.length));
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("getPermissionsAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$8
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Boolean.TYPE);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$9
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$10
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    String[] manifestPermissions;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    Boolean bool = (Boolean) obj;
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                    }
                    boolean booleanValue = bool.booleanValue();
                    Permissions permissions = MediaLibraryModule.this.getAppContext().getPermissions();
                    manifestPermissions = MediaLibraryModule.this.getManifestPermissions(booleanValue);
                    Permissions.getPermissionsWithPermissionsManager(permissions, (Promise) obj2, (String[]) Arrays.copyOf(manifestPermissions, manifestPermissions.length));
                    return Unit.INSTANCE;
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("saveToLibraryAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("saveToLibraryAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$11
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$12
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj != null) {
                        String str = (String) obj;
                        if (!MediaLibraryModule.this.isMissingWritePermission()) {
                            BuildersKt__Builders_commonKt.launch$default(MediaLibraryModule.this.moduleCoroutineScope, null, null, new MediaLibraryModule$definition$lambda$48$lambda$4$lambda$3$$inlined$withModuleScope$1(promise, null, MediaLibraryModule.this, str, promise), 3, null);
                            return;
                        }
                        throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_WRITE_PERMISSION_MESSAGE);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("saveToLibraryAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$13
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$14
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$15
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
                    if (obj2 != null) {
                        Promise promise = (Promise) obj2;
                        if (!MediaLibraryModule.this.isMissingWritePermission()) {
                            BuildersKt__Builders_commonKt.launch$default(MediaLibraryModule.this.moduleCoroutineScope, null, null, new MediaLibraryModule$definition$lambda$48$lambda$4$lambda$3$$inlined$withModuleScope$1(promise, null, MediaLibraryModule.this, str, promise), 3, null);
                            return Unit.INSTANCE;
                        }
                        throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_WRITE_PERMISSION_MESSAGE);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("createAssetAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("createAssetAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$16
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$17
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj != null) {
                        String str = (String) obj;
                        if (!MediaLibraryModule.this.isMissingWritePermission()) {
                            BuildersKt__Builders_commonKt.launch$default(MediaLibraryModule.this.moduleCoroutineScope, null, null, new MediaLibraryModule$definition$lambda$48$lambda$7$lambda$6$$inlined$withModuleScope$1(promise, null, MediaLibraryModule.this, str, promise), 3, null);
                            return;
                        }
                        throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_WRITE_PERMISSION_MESSAGE);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("createAssetAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$18
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$19
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$20
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
                    if (obj2 != null) {
                        Promise promise = (Promise) obj2;
                        if (!MediaLibraryModule.this.isMissingWritePermission()) {
                            BuildersKt__Builders_commonKt.launch$default(MediaLibraryModule.this.moduleCoroutineScope, null, null, new MediaLibraryModule$definition$lambda$48$lambda$7$lambda$6$$inlined$withModuleScope$1(promise, null, MediaLibraryModule.this, str, promise), 3, null);
                            return Unit.INSTANCE;
                        }
                        throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_WRITE_PERMISSION_MESSAGE);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("addAssetsToAlbumAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("addAssetsToAlbumAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(List.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$21
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)));
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$22
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$23
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Boolean.TYPE);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$24
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    MediaLibraryModule.Action actionIfUserGrantedPermission;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                    }
                    List list = (List) obj;
                    Object obj2 = args[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj2;
                    Object obj3 = args[2];
                    if (obj3 != null) {
                        boolean booleanValue = ((Boolean) obj3).booleanValue();
                        if (!MediaLibraryModule.this.isMissingWritePermission()) {
                            actionIfUserGrantedPermission = MediaLibraryModule.this.actionIfUserGrantedPermission(new MediaLibraryModule$definition$1$6$1$action$1(MediaLibraryModule.this, promise, list, str, booleanValue));
                            MediaLibraryModule mediaLibraryModule2 = MediaLibraryModule.this;
                            if (booleanValue) {
                                list = CollectionsKt.emptyList();
                            }
                            mediaLibraryModule2.runActionWithPermissions(list, actionIfUserGrantedPermission);
                            return;
                        }
                        throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_WRITE_PERMISSION_MESSAGE);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("addAssetsToAlbumAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(List.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$25
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)));
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$26
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$27
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Boolean.TYPE);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$28
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$29
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    MediaLibraryModule.Action actionIfUserGrantedPermission;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                    }
                    List list = (List) obj;
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj2;
                    Object obj3 = it[2];
                    if (obj3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    Boolean bool = (Boolean) obj3;
                    Object obj4 = it[3];
                    if (obj4 != null) {
                        Promise promise = (Promise) obj4;
                        boolean booleanValue = bool.booleanValue();
                        if (!MediaLibraryModule.this.isMissingWritePermission()) {
                            actionIfUserGrantedPermission = MediaLibraryModule.this.actionIfUserGrantedPermission(new MediaLibraryModule$definition$1$6$1$action$1(MediaLibraryModule.this, promise, list, str, booleanValue));
                            MediaLibraryModule mediaLibraryModule2 = MediaLibraryModule.this;
                            if (booleanValue) {
                                list = CollectionsKt.emptyList();
                            }
                            mediaLibraryModule2.runActionWithPermissions(list, actionIfUserGrantedPermission);
                            return Unit.INSTANCE;
                        }
                        throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_WRITE_PERMISSION_MESSAGE);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("removeAssetsFromAlbumAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("removeAssetsFromAlbumAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(List.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$30
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)));
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$31
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$32
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    MediaLibraryModule.Action actionIfUserGrantedPermission;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                    }
                    List list = (List) obj;
                    Object obj2 = args[1];
                    if (obj2 != null) {
                        String str = (String) obj2;
                        if (!MediaLibraryModule.this.isMissingWritePermission()) {
                            actionIfUserGrantedPermission = MediaLibraryModule.this.actionIfUserGrantedPermission(new MediaLibraryModule$definition$1$7$1$action$1(MediaLibraryModule.this, promise, list, str));
                            MediaLibraryModule.this.runActionWithPermissions(list, actionIfUserGrantedPermission);
                            return;
                        }
                        throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_WRITE_PERMISSION_MESSAGE);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("removeAssetsFromAlbumAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(List.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$33
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)));
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$34
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$35
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$36
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    MediaLibraryModule.Action actionIfUserGrantedPermission;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                    }
                    List list = (List) obj;
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj2;
                    Object obj3 = it[2];
                    if (obj3 != null) {
                        Promise promise = (Promise) obj3;
                        if (!MediaLibraryModule.this.isMissingWritePermission()) {
                            actionIfUserGrantedPermission = MediaLibraryModule.this.actionIfUserGrantedPermission(new MediaLibraryModule$definition$1$7$1$action$1(MediaLibraryModule.this, promise, list, str));
                            MediaLibraryModule.this.runActionWithPermissions(list, actionIfUserGrantedPermission);
                            return Unit.INSTANCE;
                        }
                        throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_WRITE_PERMISSION_MESSAGE);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("deleteAssetsAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("deleteAssetsAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(List.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$37
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)));
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$38
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    MediaLibraryModule.Action actionIfUserGrantedPermission;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj != null) {
                        List list = (List) obj;
                        if (!MediaLibraryModule.this.isMissingWritePermission()) {
                            actionIfUserGrantedPermission = MediaLibraryModule.this.actionIfUserGrantedPermission(new MediaLibraryModule$definition$1$8$1$action$1(MediaLibraryModule.this, promise, list));
                            MediaLibraryModule.this.runActionWithPermissions(list, actionIfUserGrantedPermission);
                            return;
                        }
                        throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_WRITE_PERMISSION_MESSAGE);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("deleteAssetsAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(List.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$39
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)));
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$40
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$41
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    MediaLibraryModule.Action actionIfUserGrantedPermission;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                    }
                    List list = (List) obj;
                    Object obj2 = it[1];
                    if (obj2 != null) {
                        Promise promise = (Promise) obj2;
                        if (!MediaLibraryModule.this.isMissingWritePermission()) {
                            actionIfUserGrantedPermission = MediaLibraryModule.this.actionIfUserGrantedPermission(new MediaLibraryModule$definition$1$8$1$action$1(MediaLibraryModule.this, promise, list));
                            MediaLibraryModule.this.runActionWithPermissions(list, actionIfUserGrantedPermission);
                            return Unit.INSTANCE;
                        }
                        throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_WRITE_PERMISSION_MESSAGE);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("deleteAssetsAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("deleteAssetsAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(List.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$42
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)));
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$43
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    MediaLibraryModule.Action actionIfUserGrantedPermission;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj != null) {
                        List list = (List) obj;
                        if (!MediaLibraryModule.this.isMissingWritePermission()) {
                            actionIfUserGrantedPermission = MediaLibraryModule.this.actionIfUserGrantedPermission(new MediaLibraryModule$definition$1$9$1$action$1(MediaLibraryModule.this, promise, list));
                            MediaLibraryModule.this.runActionWithPermissions(list, actionIfUserGrantedPermission);
                            return;
                        }
                        throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_WRITE_PERMISSION_MESSAGE);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("deleteAssetsAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(List.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$44
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)));
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$45
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$46
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    MediaLibraryModule.Action actionIfUserGrantedPermission;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                    }
                    List list = (List) obj;
                    Object obj2 = it[1];
                    if (obj2 != null) {
                        Promise promise = (Promise) obj2;
                        if (!MediaLibraryModule.this.isMissingWritePermission()) {
                            actionIfUserGrantedPermission = MediaLibraryModule.this.actionIfUserGrantedPermission(new MediaLibraryModule$definition$1$9$1$action$1(MediaLibraryModule.this, promise, list));
                            MediaLibraryModule.this.runActionWithPermissions(list, actionIfUserGrantedPermission);
                            return Unit.INSTANCE;
                        }
                        throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_WRITE_PERMISSION_MESSAGE);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("getAssetInfoAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("getAssetInfoAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$47
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Map.class), true, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$48
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.nullableTypeOf(Object.class)));
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$49
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj != null) {
                        String str = (String) obj;
                        if (!MediaLibraryModule.this.isMissingPermissions()) {
                            BuildersKt__Builders_commonKt.launch$default(MediaLibraryModule.this.moduleCoroutineScope, null, null, new MediaLibraryModule$definition$lambda$48$lambda$18$lambda$17$$inlined$withModuleScope$1(promise, null, MediaLibraryModule.this, str, promise), 3, null);
                            return;
                        }
                        throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_PERMISSIONS_MESSAGE);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("getAssetInfoAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$50
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Map.class), true, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$51
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.nullableTypeOf(Object.class)));
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$52
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$53
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
                    Object obj2 = it[2];
                    if (obj2 != null) {
                        Promise promise = (Promise) obj2;
                        if (!MediaLibraryModule.this.isMissingPermissions()) {
                            BuildersKt__Builders_commonKt.launch$default(MediaLibraryModule.this.moduleCoroutineScope, null, null, new MediaLibraryModule$definition$lambda$48$lambda$18$lambda$17$$inlined$withModuleScope$1(promise, null, MediaLibraryModule.this, str, promise), 3, null);
                            return Unit.INSTANCE;
                        }
                        throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_PERMISSIONS_MESSAGE);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("getAlbumsAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("getAlbumsAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Map.class), true, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$54
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.nullableTypeOf(Object.class)));
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$55
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    if (!MediaLibraryModule.this.isMissingPermissions()) {
                        BuildersKt__Builders_commonKt.launch$default(MediaLibraryModule.this.moduleCoroutineScope, null, null, new MediaLibraryModule$definition$lambda$48$lambda$21$lambda$20$$inlined$withModuleScope$1(promise, null, MediaLibraryModule.this, promise), 3, null);
                        return;
                    }
                    throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_PERMISSIONS_MESSAGE);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("getAlbumsAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Map.class), true, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$56
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(Map.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)), KTypeProjection.INSTANCE.invariant(Reflection.nullableTypeOf(Object.class)));
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$57
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$58
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[1];
                    if (obj != null) {
                        Promise promise = (Promise) obj;
                        if (!MediaLibraryModule.this.isMissingPermissions()) {
                            BuildersKt__Builders_commonKt.launch$default(MediaLibraryModule.this.moduleCoroutineScope, null, null, new MediaLibraryModule$definition$lambda$48$lambda$21$lambda$20$$inlined$withModuleScope$1(promise, null, MediaLibraryModule.this, promise), 3, null);
                            return Unit.INSTANCE;
                        }
                        throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_PERMISSIONS_MESSAGE);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("getAlbumAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("getAlbumAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$59
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$60
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj != null) {
                        String str = (String) obj;
                        if (!MediaLibraryModule.this.isMissingPermissions()) {
                            BuildersKt__Builders_commonKt.launch$default(MediaLibraryModule.this.moduleCoroutineScope, null, null, new MediaLibraryModule$definition$lambda$48$lambda$24$lambda$23$$inlined$withModuleScope$1(promise, null, MediaLibraryModule.this, str, promise), 3, null);
                            return;
                        }
                        throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_PERMISSIONS_MESSAGE);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("getAlbumAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$61
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$62
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$63
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
                    if (obj2 != null) {
                        Promise promise = (Promise) obj2;
                        if (!MediaLibraryModule.this.isMissingPermissions()) {
                            BuildersKt__Builders_commonKt.launch$default(MediaLibraryModule.this.moduleCoroutineScope, null, null, new MediaLibraryModule$definition$lambda$48$lambda$24$lambda$23$$inlined$withModuleScope$1(promise, null, MediaLibraryModule.this, str, promise), 3, null);
                            return Unit.INSTANCE;
                        }
                        throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_PERMISSIONS_MESSAGE);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("createAlbumAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("createAlbumAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$64
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$65
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$66
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Boolean.TYPE);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$67
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    MediaLibraryModule.Action actionIfUserGrantedPermission;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = args[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str2 = (String) obj2;
                    Object obj3 = args[2];
                    if (obj3 != null) {
                        boolean booleanValue = ((Boolean) obj3).booleanValue();
                        if (!MediaLibraryModule.this.isMissingWritePermission()) {
                            actionIfUserGrantedPermission = MediaLibraryModule.this.actionIfUserGrantedPermission(new MediaLibraryModule$definition$1$13$1$action$1(MediaLibraryModule.this, promise, str, str2, booleanValue));
                            MediaLibraryModule.this.runActionWithPermissions(booleanValue ? CollectionsKt.emptyList() : CollectionsKt.listOf(str2), actionIfUserGrantedPermission);
                            return;
                        }
                        throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_WRITE_PERMISSION_MESSAGE);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("createAlbumAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$68
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$69
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$70
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Boolean.TYPE);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$71
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$72
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    MediaLibraryModule.Action actionIfUserGrantedPermission;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str2 = (String) obj2;
                    Object obj3 = it[2];
                    if (obj3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                    }
                    Boolean bool = (Boolean) obj3;
                    Object obj4 = it[3];
                    if (obj4 != null) {
                        Promise promise = (Promise) obj4;
                        boolean booleanValue = bool.booleanValue();
                        if (!MediaLibraryModule.this.isMissingWritePermission()) {
                            actionIfUserGrantedPermission = MediaLibraryModule.this.actionIfUserGrantedPermission(new MediaLibraryModule$definition$1$13$1$action$1(MediaLibraryModule.this, promise, str, str2, booleanValue));
                            MediaLibraryModule.this.runActionWithPermissions(booleanValue ? CollectionsKt.emptyList() : CollectionsKt.listOf(str2), actionIfUserGrantedPermission);
                            return Unit.INSTANCE;
                        }
                        throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_WRITE_PERMISSION_MESSAGE);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("deleteAlbumsAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("deleteAlbumsAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(List.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$73
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)));
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$74
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    MediaLibraryModule.Action actionIfUserGrantedPermission;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj != null) {
                        List list = (List) obj;
                        if (!MediaLibraryModule.this.isMissingWritePermission()) {
                            actionIfUserGrantedPermission = MediaLibraryModule.this.actionIfUserGrantedPermission(new MediaLibraryModule$definition$1$14$1$action$1(MediaLibraryModule.this, promise, list));
                            Context context = MediaLibraryModule.this.getContext();
                            String[] strArr = (String[]) list.toArray(new String[0]);
                            MediaLibraryModule.this.runActionWithPermissions(AlbumUtilsKt.getAssetsInAlbums(context, (String[]) Arrays.copyOf(strArr, strArr.length)), actionIfUserGrantedPermission);
                            return;
                        }
                        throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_WRITE_PERMISSION_MESSAGE);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("deleteAlbumsAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(List.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$75
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)));
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$76
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$77
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    MediaLibraryModule.Action actionIfUserGrantedPermission;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                    }
                    List list = (List) obj;
                    Object obj2 = it[1];
                    if (obj2 != null) {
                        Promise promise = (Promise) obj2;
                        if (!MediaLibraryModule.this.isMissingWritePermission()) {
                            actionIfUserGrantedPermission = MediaLibraryModule.this.actionIfUserGrantedPermission(new MediaLibraryModule$definition$1$14$1$action$1(MediaLibraryModule.this, promise, list));
                            Context context = MediaLibraryModule.this.getContext();
                            String[] strArr = (String[]) list.toArray(new String[0]);
                            MediaLibraryModule.this.runActionWithPermissions(AlbumUtilsKt.getAssetsInAlbums(context, (String[]) Arrays.copyOf(strArr, strArr.length)), actionIfUserGrantedPermission);
                            return Unit.INSTANCE;
                        }
                        throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_WRITE_PERMISSION_MESSAGE);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("getAssetsAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("getAssetsAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(AssetsOptions.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$78
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(AssetsOptions.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$79
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj != null) {
                        AssetsOptions assetsOptions = (AssetsOptions) obj;
                        if (!MediaLibraryModule.this.isMissingPermissions()) {
                            BuildersKt__Builders_commonKt.launch$default(MediaLibraryModule.this.moduleCoroutineScope, null, null, new MediaLibraryModule$definition$lambda$48$lambda$31$lambda$30$$inlined$withModuleScope$1(promise, null, MediaLibraryModule.this, assetsOptions, promise), 3, null);
                            return;
                        }
                        throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_PERMISSIONS_MESSAGE);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.medialibrary.AssetsOptions");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("getAssetsAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(AssetsOptions.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$80
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(AssetsOptions.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$81
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$82
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.medialibrary.AssetsOptions");
                    }
                    AssetsOptions assetsOptions = (AssetsOptions) obj;
                    Object obj2 = it[1];
                    if (obj2 != null) {
                        Promise promise = (Promise) obj2;
                        if (!MediaLibraryModule.this.isMissingPermissions()) {
                            BuildersKt__Builders_commonKt.launch$default(MediaLibraryModule.this.moduleCoroutineScope, null, null, new MediaLibraryModule$definition$lambda$48$lambda$31$lambda$30$$inlined$withModuleScope$1(promise, null, MediaLibraryModule.this, assetsOptions, promise), 3, null);
                            return Unit.INSTANCE;
                        }
                        throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_PERMISSIONS_MESSAGE);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("migrateAlbumIfNeededAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("migrateAlbumIfNeededAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$83
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$84
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    MediaLibraryModule.Action actionIfUserGrantedPermission;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    if (Build.VERSION.SDK_INT < 30) {
                        return;
                    }
                    List<String> assetsInAlbums = AlbumUtilsKt.getAssetsInAlbums(MediaLibraryModule.this.getContext(), str);
                    ArrayList arrayList = new ArrayList();
                    Iterator<T> it = assetsInAlbums.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (((String) next).length() > 0) {
                            arrayList.add(next);
                        }
                    }
                    String[] strArr = (String[]) arrayList.toArray(new String[0]);
                    if (strArr.length == 0) {
                        return;
                    }
                    MediaLibraryUtils mediaLibraryUtils = MediaLibraryUtils.INSTANCE;
                    Context context = MediaLibraryModule.this.getContext();
                    SpreadBuilder spreadBuilder = new SpreadBuilder(2);
                    spreadBuilder.add(null);
                    spreadBuilder.addSpread(strArr);
                    List<MediaLibraryUtils.AssetFile> assetsById = mediaLibraryUtils.getAssetsById(context, (String[]) spreadBuilder.toArray(new String[spreadBuilder.size()]));
                    List<MediaLibraryUtils.AssetFile> list = assetsById;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Object obj2 : list) {
                        File parentFile = ((MediaLibraryUtils.AssetFile) obj2).getParentFile();
                        Object obj3 = linkedHashMap.get(parentFile);
                        if (obj3 == null) {
                            obj3 = (List) new ArrayList();
                            linkedHashMap.put(parentFile, obj3);
                        }
                        ((List) obj3).add(obj2);
                    }
                    if (linkedHashMap.size() != 1) {
                        throw new EmptyAlbumException();
                    }
                    File parentFile2 = assetsById.get(0).getParentFile();
                    if (parentFile2 == null) {
                        throw new AlbumPathException();
                    }
                    Intrinsics.checkNotNullExpressionValue(parentFile2, "assets[0].parentFile ?: throw AlbumPathException()");
                    if (parentFile2.canWrite()) {
                        return;
                    }
                    actionIfUserGrantedPermission = MediaLibraryModule.this.actionIfUserGrantedPermission(new MediaLibraryModule$definition$1$16$action$1(MediaLibraryModule.this, assetsById, parentFile2, promise));
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    Iterator<T> it2 = list.iterator();
                    while (it2.hasNext()) {
                        arrayList2.add(((MediaLibraryUtils.AssetFile) it2.next()).getAssetId());
                    }
                    MediaLibraryModule.this.runActionWithPermissions(arrayList2, actionIfUserGrantedPermission);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("migrateAlbumIfNeededAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$85
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$86
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$87
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    MediaLibraryModule.Action actionIfUserGrantedPermission;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                    }
                    Promise promise = (Promise) obj2;
                    if (Build.VERSION.SDK_INT >= 30) {
                        List<String> assetsInAlbums = AlbumUtilsKt.getAssetsInAlbums(MediaLibraryModule.this.getContext(), str);
                        ArrayList arrayList = new ArrayList();
                        for (Object obj3 : assetsInAlbums) {
                            if (((String) obj3).length() > 0) {
                                arrayList.add(obj3);
                            }
                        }
                        String[] strArr = (String[]) arrayList.toArray(new String[0]);
                        if (!(strArr.length == 0)) {
                            MediaLibraryUtils mediaLibraryUtils = MediaLibraryUtils.INSTANCE;
                            Context context = MediaLibraryModule.this.getContext();
                            SpreadBuilder spreadBuilder = new SpreadBuilder(2);
                            spreadBuilder.add(null);
                            spreadBuilder.addSpread(strArr);
                            List<MediaLibraryUtils.AssetFile> assetsById = mediaLibraryUtils.getAssetsById(context, (String[]) spreadBuilder.toArray(new String[spreadBuilder.size()]));
                            List<MediaLibraryUtils.AssetFile> list = assetsById;
                            LinkedHashMap linkedHashMap = new LinkedHashMap();
                            for (Object obj4 : list) {
                                File parentFile = ((MediaLibraryUtils.AssetFile) obj4).getParentFile();
                                Object obj5 = linkedHashMap.get(parentFile);
                                if (obj5 == null) {
                                    obj5 = (List) new ArrayList();
                                    linkedHashMap.put(parentFile, obj5);
                                }
                                ((List) obj5).add(obj4);
                            }
                            if (linkedHashMap.size() != 1) {
                                throw new EmptyAlbumException();
                            }
                            File parentFile2 = assetsById.get(0).getParentFile();
                            if (parentFile2 == null) {
                                throw new AlbumPathException();
                            }
                            Intrinsics.checkNotNullExpressionValue(parentFile2, "assets[0].parentFile ?: throw AlbumPathException()");
                            if (!parentFile2.canWrite()) {
                                actionIfUserGrantedPermission = MediaLibraryModule.this.actionIfUserGrantedPermission(new MediaLibraryModule$definition$1$16$action$1(MediaLibraryModule.this, assetsById, parentFile2, promise));
                                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                                Iterator<T> it2 = list.iterator();
                                while (it2.hasNext()) {
                                    arrayList2.add(((MediaLibraryUtils.AssetFile) it2.next()).getAssetId());
                                }
                                MediaLibraryModule.this.runActionWithPermissions(arrayList2, actionIfUserGrantedPermission);
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("albumNeedsMigrationAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("albumNeedsMigrationAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$88
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$89
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj != null) {
                        String str = (String) obj;
                        if (MediaLibraryModule.this.isMissingPermissions()) {
                            throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_PERMISSIONS_MESSAGE);
                        }
                        if (Build.VERSION.SDK_INT >= 30) {
                            BuildersKt__Builders_commonKt.launch$default(MediaLibraryModule.this.moduleCoroutineScope, null, null, new MediaLibraryModule$definition$1$17$1$1(MediaLibraryModule.this, str, promise, null), 3, null);
                        }
                        promise.resolve(false);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("albumNeedsMigrationAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$90
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$91
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$AsyncFunction$92
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
                    if (obj2 != null) {
                        Promise promise = (Promise) obj2;
                        if (MediaLibraryModule.this.isMissingPermissions()) {
                            throw new PermissionsException(MediaLibraryConstantsKt.ERROR_NO_PERMISSIONS_MESSAGE);
                        }
                        if (Build.VERSION.SDK_INT >= 30) {
                            BuildersKt__Builders_commonKt.launch$default(MediaLibraryModule.this.moduleCoroutineScope, null, null, new MediaLibraryModule$definition$1$17$1$1(MediaLibraryModule.this, str, promise, null), 3, null);
                        }
                        promise.resolve(false);
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            AsyncFunctionComponent asyncFunctionComponent = new AsyncFunctionComponent("startObserving", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$OnStartObserving$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    MediaLibraryModule.MediaStoreContentObserver mediaStoreContentObserver;
                    Intrinsics.checkNotNullParameter(it, "it");
                    mediaStoreContentObserver = MediaLibraryModule.this.imagesObserver;
                    if (mediaStoreContentObserver == null) {
                        Handler handler = new Handler(Looper.getMainLooper());
                        ContentResolver contentResolver = MediaLibraryModule.this.getContext().getContentResolver();
                        MediaLibraryModule mediaLibraryModule2 = MediaLibraryModule.this;
                        MediaLibraryModule.MediaStoreContentObserver mediaStoreContentObserver2 = new MediaLibraryModule.MediaStoreContentObserver(MediaLibraryModule.this, handler, 1);
                        contentResolver.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, mediaStoreContentObserver2);
                        mediaLibraryModule2.imagesObserver = mediaStoreContentObserver2;
                        MediaLibraryModule mediaLibraryModule3 = MediaLibraryModule.this;
                        MediaLibraryModule.MediaStoreContentObserver mediaStoreContentObserver3 = new MediaLibraryModule.MediaStoreContentObserver(MediaLibraryModule.this, handler, 3);
                        contentResolver.registerContentObserver(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, true, mediaStoreContentObserver3);
                        mediaLibraryModule3.videosObserver = mediaStoreContentObserver3;
                    }
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("startObserving", asyncFunctionComponent);
            AsyncFunctionComponent asyncFunctionComponent2 = asyncFunctionComponent;
            AsyncFunctionComponent asyncFunctionComponent3 = new AsyncFunctionComponent("stopObserving", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$OnStopObserving$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    MediaLibraryModule.MediaStoreContentObserver mediaStoreContentObserver;
                    MediaLibraryModule.MediaStoreContentObserver mediaStoreContentObserver2;
                    Intrinsics.checkNotNullParameter(it, "it");
                    ContentResolver contentResolver = MediaLibraryModule.this.getContext().getContentResolver();
                    mediaStoreContentObserver = MediaLibraryModule.this.imagesObserver;
                    if (mediaStoreContentObserver != null) {
                        contentResolver.unregisterContentObserver(mediaStoreContentObserver);
                        MediaLibraryModule.this.imagesObserver = null;
                    }
                    mediaStoreContentObserver2 = MediaLibraryModule.this.videosObserver;
                    if (mediaStoreContentObserver2 != null) {
                        contentResolver.unregisterContentObserver(mediaStoreContentObserver2);
                        MediaLibraryModule.this.videosObserver = null;
                    }
                    return Unit.INSTANCE;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("stopObserving", asyncFunctionComponent3);
            AsyncFunctionComponent asyncFunctionComponent4 = asyncFunctionComponent3;
            moduleDefinitionBuilder.getEventListeners().put(EventName.ON_ACTIVITY_RESULT, new EventListenerWithSenderAndPayload(EventName.ON_ACTIVITY_RESULT, new Function2<Activity, OnActivityResultPayload, Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$OnActivityResult$1
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
                    MediaLibraryModule.Action action;
                    Intrinsics.checkNotNullParameter(sender, "sender");
                    Intrinsics.checkNotNullParameter(payload, "payload");
                    action = MediaLibraryModule.this.awaitingAction;
                    if (action != null) {
                        if (!(payload.getRequestCode() == 7463)) {
                            action = null;
                        }
                        if (action != null) {
                            action.runWithPermissions(payload.getResultCode() == -1);
                            MediaLibraryModule.this.awaitingAction = null;
                        }
                    }
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: expo.modules.medialibrary.MediaLibraryModule$definition$lambda$48$$inlined$OnDestroy$1
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
                    try {
                        CoroutineScopeKt.cancel(MediaLibraryModule.this.moduleCoroutineScope, new ModuleDestroyedException(null, 1, null));
                    } catch (IllegalStateException unused) {
                        Log.e(MediaLibraryModule.TAG, "The scope does not have a job in it");
                    }
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    private final Job withModuleScope(Promise promise, Function0<Unit> block) {
        Job launch$default;
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.moduleCoroutineScope, null, null, new MediaLibraryModule$withModuleScope$1(block, promise, null), 3, null);
        return launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isMissingPermissions() {
        return hasReadPermissions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isMissingWritePermission() {
        return hasWritePermissions();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String[] getManifestPermissions(boolean r11) {
        /*
            r10 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 29
            java.lang.String r2 = "android.permission.ACCESS_MEDIA_LOCATION"
            r3 = 1
            r4 = 0
            if (r0 < r1) goto L18
            expo.modules.medialibrary.MediaLibraryUtils r0 = expo.modules.medialibrary.MediaLibraryUtils.INSTANCE
            android.content.Context r1 = r10.getContext()
            boolean r0 = r0.hasManifestPermission(r1, r2)
            if (r0 == 0) goto L18
            r0 = r3
            goto L19
        L18:
            r0 = r4
        L19:
            int r1 = android.os.Build.VERSION.SDK_INT
            java.lang.String r5 = "android.permission.WRITE_EXTERNAL_STORAGE"
            r6 = 33
            if (r1 >= r6) goto L2f
            expo.modules.medialibrary.MediaLibraryUtils r1 = expo.modules.medialibrary.MediaLibraryUtils.INSTANCE
            android.content.Context r7 = r10.getContext()
            boolean r1 = r1.hasManifestPermission(r7, r5)
            if (r1 == 0) goto L2f
            r1 = r3
            goto L30
        L2f:
            r1 = r4
        L30:
            int r7 = android.os.Build.VERSION.SDK_INT
            if (r7 < r6) goto L74
            java.lang.String r6 = "android.permission.READ_MEDIA_VIDEO"
            java.lang.String r7 = "android.permission.READ_MEDIA_IMAGES"
            java.lang.String r8 = "android.permission.READ_MEDIA_AUDIO"
            java.lang.String[] r6 = new java.lang.String[]{r8, r6, r7}
            java.util.List r6 = kotlin.collections.CollectionsKt.listOf(r6)
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            boolean r7 = r6 instanceof java.util.Collection
            if (r7 == 0) goto L53
            r7 = r6
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L53
        L51:
            r6 = r3
            goto L70
        L53:
            java.util.Iterator r6 = r6.iterator()
        L57:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L51
            java.lang.Object r7 = r6.next()
            java.lang.String r7 = (java.lang.String) r7
            expo.modules.medialibrary.MediaLibraryUtils r8 = expo.modules.medialibrary.MediaLibraryUtils.INSTANCE
            android.content.Context r9 = r10.getContext()
            boolean r7 = r8.hasManifestPermission(r9, r7)
            if (r7 != 0) goto L57
            r6 = r4
        L70:
            if (r6 == 0) goto L74
            r6 = r3
            goto L75
        L74:
            r6 = r4
        L75:
            kotlin.jvm.internal.SpreadBuilder r7 = new kotlin.jvm.internal.SpreadBuilder
            r8 = 4
            r7.<init>(r8)
            r8 = 0
            if (r1 == 0) goto L7f
            goto L80
        L7f:
            r5 = r8
        L80:
            r7.add(r5)
            if (r11 != 0) goto L88
            if (r6 != 0) goto L88
            goto L89
        L88:
            r3 = r4
        L89:
            if (r3 == 0) goto L8e
            java.lang.String r1 = "android.permission.READ_EXTERNAL_STORAGE"
            goto L8f
        L8e:
            r1 = r8
        L8f:
            r7.add(r1)
            if (r0 == 0) goto L95
            goto L96
        L95:
            r2 = r8
        L96:
            r7.add(r2)
            java.lang.String[] r11 = r10.getGranularPermissions(r11, r6)
            r7.addSpread(r11)
            int r11 = r7.size()
            java.lang.String[] r11 = new java.lang.String[r11]
            java.lang.Object[] r11 = r7.toArray(r11)
            java.util.List r11 = kotlin.collections.CollectionsKt.listOfNotNull(r11)
            java.util.Collection r11 = (java.util.Collection) r11
            java.lang.String[] r0 = new java.lang.String[r4]
            java.lang.Object[] r11 = r11.toArray(r0)
            java.lang.String[] r11 = (java.lang.String[]) r11
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.medialibrary.MediaLibraryModule.getManifestPermissions(boolean):java.lang.String[]");
    }

    private final String[] getGranularPermissions(boolean writeOnly, boolean shouldAdd) {
        boolean z = !writeOnly && shouldAdd;
        String[] strArr = new String[3];
        strArr[0] = z ? "android.permission.READ_MEDIA_IMAGES" : null;
        strArr[1] = z ? "android.permission.READ_MEDIA_VIDEO" : null;
        strArr[2] = z ? "android.permission.READ_MEDIA_AUDIO" : null;
        return (String[]) CollectionsKt.listOfNotNull((Object[]) strArr).toArray(new String[0]);
    }

    private final void throwUnlessPermissionsGranted(boolean isWrite, Function0<Unit> block) {
        boolean isMissingWritePermission = isWrite ? isMissingWritePermission() : isMissingPermissions();
        String str = isWrite ? MediaLibraryConstantsKt.ERROR_NO_WRITE_PERMISSION_MESSAGE : MediaLibraryConstantsKt.ERROR_NO_PERMISSIONS_MESSAGE;
        if (isMissingWritePermission) {
            throw new PermissionsException(str);
        }
        block.invoke();
    }

    static /* synthetic */ void throwUnlessPermissionsGranted$default(MediaLibraryModule mediaLibraryModule, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        boolean isMissingWritePermission = z ? mediaLibraryModule.isMissingWritePermission() : mediaLibraryModule.isMissingPermissions();
        String str = z ? MediaLibraryConstantsKt.ERROR_NO_WRITE_PERMISSION_MESSAGE : MediaLibraryConstantsKt.ERROR_NO_PERMISSIONS_MESSAGE;
        if (isMissingWritePermission) {
            throw new PermissionsException(str);
        }
        function0.invoke();
    }

    private final boolean hasReadPermissions() {
        String[] strArr;
        if (Build.VERSION.SDK_INT >= 33) {
            strArr = new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_AUDIO", "android.permission.READ_MEDIA_VIDEO"};
        } else {
            strArr = new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
        }
        if (getAppContext().getPermissions() != null) {
            return !r1.hasGrantedPermissions((String[]) Arrays.copyOf(strArr, strArr.length));
        }
        return false;
    }

    private final boolean hasWritePermissions() {
        Permissions permissions;
        if (Build.VERSION.SDK_INT < 33 && (permissions = getAppContext().getPermissions()) != null) {
            return !permissions.hasGrantedPermissions("android.permission.WRITE_EXTERNAL_STORAGE");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void runActionWithPermissions(List<String> assetsId, Action action) {
        if (Build.VERSION.SDK_INT >= 30) {
            List<Uri> assetsUris = MediaLibraryUtils.INSTANCE.getAssetsUris(getContext(), assetsId);
            ArrayList arrayList = new ArrayList();
            for (Object obj : assetsUris) {
                if (getContext().checkUriPermission((Uri) obj, Binder.getCallingPid(), Binder.getCallingUid(), 2) != 0) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            if (!arrayList2.isEmpty()) {
                PendingIntent createWriteRequest = MediaStore.createWriteRequest(getContext().getContentResolver(), arrayList2);
                Intrinsics.checkNotNullExpressionValue(createWriteRequest, "createWriteRequest(conte… pathsWithoutPermissions)");
                try {
                    this.awaitingAction = action;
                    getCurrentActivity().startIntentSenderForResult(createWriteRequest.getIntentSender(), WRITE_REQUEST_CODE, null, 0, 0, 0);
                    return;
                } catch (IntentSender.SendIntentException e) {
                    this.awaitingAction = null;
                    throw e;
                }
            }
        }
        action.runWithPermissions(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Action actionIfUserGrantedPermission(final Function0<Unit> block) {
        return new Action() { // from class: expo.modules.medialibrary.MediaLibraryModule$$ExternalSyntheticLambda0
            @Override // expo.modules.medialibrary.MediaLibraryModule.Action
            public final void runWithPermissions(boolean z) {
                MediaLibraryModule.actionIfUserGrantedPermission$lambda$57(Function0.this, z);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void actionIfUserGrantedPermission$lambda$57(Function0 block, boolean z) {
        Intrinsics.checkNotNullParameter(block, "$block");
        if (!z) {
            throw new PermissionsException(MediaLibraryConstantsKt.ERROR_USER_DID_NOT_GRANT_WRITE_PERMISSIONS_MESSAGE);
        }
        block.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MediaLibraryModule.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lexpo/modules/medialibrary/MediaLibraryModule$MediaStoreContentObserver;", "Landroid/database/ContentObserver;", "handler", "Landroid/os/Handler;", "mMediaType", "", "(Lexpo/modules/medialibrary/MediaLibraryModule;Landroid/os/Handler;I)V", "mAssetsTotalCount", "getAssetsTotalCount", "mediaType", "onChange", "", "selfChange", "", "uri", "Landroid/net/Uri;", "expo-media-library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    final class MediaStoreContentObserver extends ContentObserver {
        private int mAssetsTotalCount;
        private final int mMediaType;
        final /* synthetic */ MediaLibraryModule this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MediaStoreContentObserver(MediaLibraryModule mediaLibraryModule, Handler handler, int i) {
            super(handler);
            Intrinsics.checkNotNullParameter(handler, "handler");
            this.this$0 = mediaLibraryModule;
            this.mMediaType = i;
            this.mAssetsTotalCount = getAssetsTotalCount(i);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            onChange(selfChange, null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            int assetsTotalCount = getAssetsTotalCount(this.mMediaType);
            if (this.mAssetsTotalCount != assetsTotalCount) {
                this.mAssetsTotalCount = assetsTotalCount;
                this.this$0.sendEvent(MediaLibraryConstantsKt.LIBRARY_DID_CHANGE_EVENT, new Bundle());
            }
        }

        private final int getAssetsTotalCount(int mediaType) {
            Cursor query = this.this$0.getContext().getContentResolver().query(MediaLibraryConstantsKt.getEXTERNAL_CONTENT_URI(), null, "media_type == " + mediaType, null, null);
            try {
                Cursor cursor = query;
                int count = cursor != null ? cursor.getCount() : 0;
                CloseableKt.closeFinally(query, null);
                return count;
            } finally {
            }
        }
    }

    /* compiled from: MediaLibraryModule.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lexpo/modules/medialibrary/MediaLibraryModule$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG$expo_media_library_release", "()Ljava/lang/String;", "WRITE_REQUEST_CODE", "", "expo-media-library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG$expo_media_library_release() {
            return MediaLibraryModule.TAG;
        }
    }
}
