package expo.modules.sharing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.core.content.FileProvider;
import androidx.tracing.Trace;
import com.socure.docv.capturesdk.common.utils.ApiConstant;
import expo.modules.core.errors.InvalidArgumentException;
import expo.modules.interfaces.filesystem.FilePermissionModuleInterface;
import expo.modules.interfaces.filesystem.Permission;
import expo.modules.kotlin.Promise;
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
import java.io.File;
import java.net.URLConnection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* compiled from: SharingModule.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012H\u0002J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u0017\u001a\u0004\u0018\u00010\u0012H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lexpo/modules/sharing/SharingModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity", "()Landroid/app/Activity;", "pendingPromise", "Lexpo/modules/kotlin/Promise;", "createSharingIntent", "Landroid/content/Intent;", "uri", "Landroid/net/Uri;", "mimeType", "", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "getLocalFileFoUrl", "Ljava/io/File;", "url", "isAllowedToRead", "", "Companion", "expo-sharing_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SharingModule extends Module {
    private static final int REQUEST_CODE = 8524;
    private Promise pendingPromise;

    /* JADX INFO: Access modifiers changed from: private */
    public final Context getContext() {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.ReactContextLost();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Activity getCurrentActivity() {
        Activity currentActivity = getAppContext().getCurrentActivity();
        if (currentActivity != null) {
            return currentActivity;
        }
        throw new MissingCurrentActivityException();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        SharingModule sharingModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (sharingModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(sharingModule);
            moduleDefinitionBuilder.Name("ExpoSharing");
            moduleDefinitionBuilder.getAsyncFunctions().put("shareAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("shareAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.sharing.SharingModule$definition$lambda$3$$inlined$AsyncFunction$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(SharingOptions.class), false, new Function0<KType>() { // from class: expo.modules.sharing.SharingModule$definition$lambda$3$$inlined$AsyncFunction$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(SharingOptions.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.sharing.SharingModule$definition$lambda$3$$inlined$AsyncFunction$3
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    Promise promise2;
                    File localFileFoUrl;
                    Context context;
                    Context context2;
                    Intent createSharingIntent;
                    Context context3;
                    Activity currentActivity;
                    Context context4;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    String str = (String) args[0];
                    Object obj = args[1];
                    if (obj != null) {
                        SharingOptions sharingOptions = (SharingOptions) obj;
                        promise2 = SharingModule.this.pendingPromise;
                        if (promise2 == null) {
                            try {
                                localFileFoUrl = SharingModule.this.getLocalFileFoUrl(str);
                                context = SharingModule.this.getContext();
                                context2 = SharingModule.this.getContext();
                                Uri contentUri = FileProvider.getUriForFile(context, context2.getApplicationInfo().packageName + ".SharingFileProvider", localFileFoUrl);
                                String mimeType = sharingOptions.getMimeType();
                                if (mimeType == null) {
                                    mimeType = URLConnection.guessContentTypeFromName(localFileFoUrl.getName());
                                }
                                if (mimeType == null) {
                                    mimeType = ApiConstant.ALL_MEDIA_TYPE;
                                }
                                SharingModule sharingModule2 = SharingModule.this;
                                Intrinsics.checkNotNullExpressionValue(contentUri, "contentUri");
                                createSharingIntent = sharingModule2.createSharingIntent(contentUri, mimeType);
                                Intent createChooser = Intent.createChooser(createSharingIntent, sharingOptions.getDialogTitle());
                                context3 = SharingModule.this.getContext();
                                List<ResolveInfo> queryIntentActivities = context3.getPackageManager().queryIntentActivities(createChooser, 65536);
                                Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "context.packageManager.q…CH_DEFAULT_ONLY\n        )");
                                Iterator<T> it = queryIntentActivities.iterator();
                                while (it.hasNext()) {
                                    String str2 = ((ResolveInfo) it.next()).activityInfo.packageName;
                                    context4 = SharingModule.this.getContext();
                                    context4.grantUriPermission(str2, contentUri, 1);
                                }
                                SharingModule.this.pendingPromise = promise;
                                currentActivity = SharingModule.this.getCurrentActivity();
                                currentActivity.startActivityForResult(createChooser, 8524);
                                return;
                            } catch (InvalidArgumentException e) {
                                throw new SharingInvalidArgsException(e.getMessage(), e);
                            } catch (Exception e2) {
                                throw new SharingFailedException("Failed to share the file: " + e2.getMessage(), e2);
                            }
                        }
                        throw new SharingInProgressException();
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.sharing.SharingOptions");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("shareAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.sharing.SharingModule$definition$lambda$3$$inlined$AsyncFunction$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.nullableTypeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(SharingOptions.class), false, new Function0<KType>() { // from class: expo.modules.sharing.SharingModule$definition$lambda$3$$inlined$AsyncFunction$5
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(SharingOptions.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.sharing.SharingModule$definition$lambda$3$$inlined$AsyncFunction$6
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.sharing.SharingModule$definition$lambda$3$$inlined$AsyncFunction$7
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Promise promise;
                    File localFileFoUrl;
                    Context context;
                    Context context2;
                    Intent createSharingIntent;
                    Context context3;
                    Activity currentActivity;
                    Context context4;
                    Intrinsics.checkNotNullParameter(it, "it");
                    String str = (String) it[0];
                    Object obj = it[1];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.sharing.SharingOptions");
                    }
                    SharingOptions sharingOptions = (SharingOptions) obj;
                    Object obj2 = it[2];
                    if (obj2 != null) {
                        Promise promise2 = (Promise) obj2;
                        promise = SharingModule.this.pendingPromise;
                        if (promise == null) {
                            try {
                                localFileFoUrl = SharingModule.this.getLocalFileFoUrl(str);
                                context = SharingModule.this.getContext();
                                context2 = SharingModule.this.getContext();
                                Uri contentUri = FileProvider.getUriForFile(context, context2.getApplicationInfo().packageName + ".SharingFileProvider", localFileFoUrl);
                                String mimeType = sharingOptions.getMimeType();
                                if (mimeType == null) {
                                    mimeType = URLConnection.guessContentTypeFromName(localFileFoUrl.getName());
                                }
                                if (mimeType == null) {
                                    mimeType = ApiConstant.ALL_MEDIA_TYPE;
                                }
                                SharingModule sharingModule2 = SharingModule.this;
                                Intrinsics.checkNotNullExpressionValue(contentUri, "contentUri");
                                createSharingIntent = sharingModule2.createSharingIntent(contentUri, mimeType);
                                Intent createChooser = Intent.createChooser(createSharingIntent, sharingOptions.getDialogTitle());
                                context3 = SharingModule.this.getContext();
                                List<ResolveInfo> queryIntentActivities = context3.getPackageManager().queryIntentActivities(createChooser, 65536);
                                Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "context.packageManager.q…CH_DEFAULT_ONLY\n        )");
                                Iterator<T> it2 = queryIntentActivities.iterator();
                                while (it2.hasNext()) {
                                    String str2 = ((ResolveInfo) it2.next()).activityInfo.packageName;
                                    context4 = SharingModule.this.getContext();
                                    context4.grantUriPermission(str2, contentUri, 1);
                                }
                                SharingModule.this.pendingPromise = promise2;
                                currentActivity = SharingModule.this.getCurrentActivity();
                                currentActivity.startActivityForResult(createChooser, 8524);
                                return Unit.INSTANCE;
                            } catch (InvalidArgumentException e) {
                                throw new SharingInvalidArgsException(e.getMessage(), e);
                            } catch (Exception e2) {
                                throw new SharingFailedException("Failed to share the file: " + e2.getMessage(), e2);
                            }
                        }
                        throw new SharingInProgressException();
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.ON_ACTIVITY_RESULT, new EventListenerWithSenderAndPayload(EventName.ON_ACTIVITY_RESULT, new Function2<Activity, OnActivityResultPayload, Unit>() { // from class: expo.modules.sharing.SharingModule$definition$lambda$3$$inlined$OnActivityResult$1
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
                    Promise promise;
                    Promise promise2;
                    Intrinsics.checkNotNullParameter(sender, "sender");
                    Intrinsics.checkNotNullParameter(payload, "payload");
                    if (payload.getRequestCode() == 8524) {
                        promise = SharingModule.this.pendingPromise;
                        if (promise != null) {
                            promise2 = SharingModule.this.pendingPromise;
                            if (promise2 != null) {
                                promise2.resolve(null);
                            }
                            SharingModule.this.pendingPromise = null;
                        }
                    }
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getLocalFileFoUrl(String url) throws InvalidArgumentException {
        if (url == null) {
            throw new InvalidArgumentException("URL to share cannot be null.");
        }
        Uri parse = Uri.parse(url);
        if (!Intrinsics.areEqual("file", parse.getScheme())) {
            throw new InvalidArgumentException("Only local file URLs are supported (expected scheme to be 'file', got '" + parse.getScheme() + "'.");
        }
        String path = parse.getPath();
        if (path == null) {
            throw new InvalidArgumentException("Path component of the URL to share cannot be null.");
        }
        if (!isAllowedToRead(path)) {
            throw new InvalidArgumentException("Not allowed to read file under given URL.");
        }
        return new File(path);
    }

    private final boolean isAllowedToRead(String url) {
        EnumSet<Permission> pathPermissions;
        FilePermissionModuleInterface filePermission = getAppContext().getFilePermission();
        if (filePermission == null || (pathPermissions = filePermission.getPathPermissions(getContext(), url)) == null) {
            return false;
        }
        return pathPermissions.contains(Permission.READ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Intent createSharingIntent(Uri uri, String mimeType) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", uri);
        intent.setTypeAndNormalize(mimeType);
        intent.addFlags(1);
        return intent;
    }
}
