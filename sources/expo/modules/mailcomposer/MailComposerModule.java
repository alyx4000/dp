package expo.modules.mailcomposer;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Parcelable;
import androidx.core.net.MailTo;
import androidx.tracing.Trace;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* compiled from: MailComposerModule.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lexpo/modules/mailcomposer/MailComposerModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "composerOpened", "", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity", "()Landroid/app/Activity;", "pendingPromise", "Lexpo/modules/kotlin/Promise;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "Companion", "expo-mail-composer_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MailComposerModule extends Module {
    private static final int REQUEST_CODE = 8675;
    private boolean composerOpened;
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
        throw new Exceptions.MissingActivity();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        MailComposerModule mailComposerModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (mailComposerModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(mailComposerModule);
            moduleDefinitionBuilder.Name("ExpoMailComposer");
            AsyncFunctionComponent asyncFunctionComponent = new AsyncFunctionComponent("isAvailableAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.mailcomposer.MailComposerModule$definition$lambda$7$$inlined$AsyncFunctionWithoutArgs$1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return true;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("isAvailableAsync", asyncFunctionComponent);
            AsyncFunctionComponent asyncFunctionComponent2 = asyncFunctionComponent;
            moduleDefinitionBuilder.getAsyncFunctions().put("composeAsync", Promise.class == Promise.class ? new AsyncFunctionWithPromiseComponent("composeAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(MailComposerOptions.class), false, new Function0<KType>() { // from class: expo.modules.mailcomposer.MailComposerModule$definition$lambda$7$$inlined$AsyncFunction$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(MailComposerOptions.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.mailcomposer.MailComposerModule$definition$lambda$7$$inlined$AsyncFunction$2
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    Activity currentActivity;
                    Context context;
                    Activity currentActivity2;
                    Context context2;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.mailcomposer.MailComposerOptions");
                    }
                    MailComposerOptions mailComposerOptions = (MailComposerOptions) obj;
                    Intent intent = new Intent("android.intent.action.SENDTO");
                    intent.setData(Uri.parse(MailTo.MAILTO_SCHEME));
                    currentActivity = MailComposerModule.this.getCurrentActivity();
                    Application application = currentActivity.getApplication();
                    context = MailComposerModule.this.getContext();
                    List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
                    Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "context.packageManager.q…tentActivities(intent, 0)");
                    List<ResolveInfo> list = queryIntentActivities;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    for (ResolveInfo resolveInfo : list) {
                        MailIntentBuilder mailIntentBuilder = new MailIntentBuilder(mailComposerOptions);
                        String str = resolveInfo.activityInfo.packageName;
                        Intrinsics.checkNotNullExpressionValue(str, "info.activityInfo.packageName");
                        String str2 = resolveInfo.activityInfo.name;
                        Intrinsics.checkNotNullExpressionValue(str2, "info.activityInfo.name");
                        MailIntentBuilder putSubject = mailIntentBuilder.setComponentName(str, str2).putRecipients("android.intent.extra.EMAIL").putCcRecipients("android.intent.extra.CC").putBccRecipients("android.intent.extra.BCC").putSubject("android.intent.extra.SUBJECT");
                        Boolean isHtml = mailComposerOptions.isHtml();
                        MailIntentBuilder putBody = putSubject.putBody("android.intent.extra.TEXT", isHtml != null ? isHtml.booleanValue() : false);
                        Intrinsics.checkNotNullExpressionValue(application, "application");
                        Intent mailIntent = putBody.putAttachments("android.intent.extra.STREAM", application).getMailIntent();
                        String str3 = resolveInfo.activityInfo.packageName;
                        context2 = MailComposerModule.this.getContext();
                        arrayList.add(new LabeledIntent(mailIntent, str3, resolveInfo.loadLabel(context2.getPackageManager()), resolveInfo.icon));
                    }
                    List mutableList = CollectionsKt.toMutableList((Collection) arrayList);
                    Intent createChooser = Intent.createChooser((Intent) mutableList.remove(mutableList.size() - 1), null);
                    createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) mutableList.toArray(new LabeledIntent[0]));
                    createChooser.addFlags(1);
                    MailComposerModule.this.pendingPromise = promise;
                    currentActivity2 = MailComposerModule.this.getCurrentActivity();
                    currentActivity2.startActivityForResult(createChooser, 8675);
                    MailComposerModule.this.composerOpened = true;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("composeAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(MailComposerOptions.class), false, new Function0<KType>() { // from class: expo.modules.mailcomposer.MailComposerModule$definition$lambda$7$$inlined$AsyncFunction$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(MailComposerOptions.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.mailcomposer.MailComposerModule$definition$lambda$7$$inlined$AsyncFunction$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(Promise.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.mailcomposer.MailComposerModule$definition$lambda$7$$inlined$AsyncFunction$5
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Activity currentActivity;
                    Context context;
                    Activity currentActivity2;
                    Context context2;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.mailcomposer.MailComposerOptions");
                    }
                    MailComposerOptions mailComposerOptions = (MailComposerOptions) obj;
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                    }
                    Promise promise = (Promise) obj2;
                    Intent intent = new Intent("android.intent.action.SENDTO");
                    intent.setData(Uri.parse(MailTo.MAILTO_SCHEME));
                    currentActivity = MailComposerModule.this.getCurrentActivity();
                    Application application = currentActivity.getApplication();
                    context = MailComposerModule.this.getContext();
                    List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
                    Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "context.packageManager.q…tentActivities(intent, 0)");
                    List<ResolveInfo> list = queryIntentActivities;
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    for (ResolveInfo resolveInfo : list) {
                        MailIntentBuilder mailIntentBuilder = new MailIntentBuilder(mailComposerOptions);
                        String str = resolveInfo.activityInfo.packageName;
                        Intrinsics.checkNotNullExpressionValue(str, "info.activityInfo.packageName");
                        String str2 = resolveInfo.activityInfo.name;
                        Intrinsics.checkNotNullExpressionValue(str2, "info.activityInfo.name");
                        MailIntentBuilder putSubject = mailIntentBuilder.setComponentName(str, str2).putRecipients("android.intent.extra.EMAIL").putCcRecipients("android.intent.extra.CC").putBccRecipients("android.intent.extra.BCC").putSubject("android.intent.extra.SUBJECT");
                        Boolean isHtml = mailComposerOptions.isHtml();
                        MailIntentBuilder putBody = putSubject.putBody("android.intent.extra.TEXT", isHtml != null ? isHtml.booleanValue() : false);
                        Intrinsics.checkNotNullExpressionValue(application, "application");
                        Intent mailIntent = putBody.putAttachments("android.intent.extra.STREAM", application).getMailIntent();
                        String str3 = resolveInfo.activityInfo.packageName;
                        context2 = MailComposerModule.this.getContext();
                        arrayList.add(new LabeledIntent(mailIntent, str3, resolveInfo.loadLabel(context2.getPackageManager()), resolveInfo.icon));
                    }
                    List mutableList = CollectionsKt.toMutableList((Collection) arrayList);
                    Intent createChooser = Intent.createChooser((Intent) mutableList.remove(mutableList.size() - 1), null);
                    createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (Parcelable[]) mutableList.toArray(new LabeledIntent[0]));
                    createChooser.addFlags(1);
                    MailComposerModule.this.pendingPromise = promise;
                    currentActivity2 = MailComposerModule.this.getCurrentActivity();
                    currentActivity2.startActivityForResult(createChooser, 8675);
                    MailComposerModule.this.composerOpened = true;
                    return Unit.INSTANCE;
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.ON_ACTIVITY_RESULT, new EventListenerWithSenderAndPayload(EventName.ON_ACTIVITY_RESULT, new Function2<Activity, OnActivityResultPayload, Unit>() { // from class: expo.modules.mailcomposer.MailComposerModule$definition$lambda$7$$inlined$OnActivityResult$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Activity activity, OnActivityResultPayload onActivityResultPayload) {
                    invoke2(activity, onActivityResultPayload);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Code restructure failed: missing block: B:5:0x001a, code lost:
                
                    r3 = r2.this$0.pendingPromise;
                 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void invoke2(android.app.Activity r3, expo.modules.kotlin.events.OnActivityResultPayload r4) {
                    /*
                        r2 = this;
                        java.lang.String r0 = "sender"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                        java.lang.String r3 = "payload"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
                        int r3 = r4.getRequestCode()
                        r4 = 8675(0x21e3, float:1.2156E-41)
                        if (r3 != r4) goto L40
                        expo.modules.mailcomposer.MailComposerModule r3 = expo.modules.mailcomposer.MailComposerModule.this
                        expo.modules.kotlin.Promise r3 = expo.modules.mailcomposer.MailComposerModule.access$getPendingPromise$p(r3)
                        if (r3 == 0) goto L40
                        expo.modules.mailcomposer.MailComposerModule r3 = expo.modules.mailcomposer.MailComposerModule.this
                        expo.modules.kotlin.Promise r3 = expo.modules.mailcomposer.MailComposerModule.access$getPendingPromise$p(r3)
                        if (r3 != 0) goto L23
                        goto L40
                    L23:
                        expo.modules.mailcomposer.MailComposerModule r4 = expo.modules.mailcomposer.MailComposerModule.this
                        boolean r4 = expo.modules.mailcomposer.MailComposerModule.access$getComposerOpened$p(r4)
                        if (r4 == 0) goto L40
                        expo.modules.mailcomposer.MailComposerModule r4 = expo.modules.mailcomposer.MailComposerModule.this
                        r0 = 0
                        expo.modules.mailcomposer.MailComposerModule.access$setComposerOpened$p(r4, r0)
                        android.os.Bundle r4 = new android.os.Bundle
                        r4.<init>()
                        java.lang.String r0 = "status"
                        java.lang.String r1 = "sent"
                        r4.putString(r0, r1)
                        r3.resolve(r4)
                    L40:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: expo.modules.mailcomposer.MailComposerModule$definition$lambda$7$$inlined$OnActivityResult$1.invoke2(android.app.Activity, expo.modules.kotlin.events.OnActivityResultPayload):void");
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
