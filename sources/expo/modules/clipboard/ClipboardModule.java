package expo.modules.clipboard;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.Log;
import androidx.core.os.BundleKt;
import androidx.tracing.Trace;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import expo.modules.clipboard.ClipboardModule;
import expo.modules.clipboard.ClipboardModule.ClipboardEventEmitter;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.functions.AsyncFunctionBuilder;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.SuspendFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* compiled from: ClipboardModule.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\t\u001a\u00060\nR\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u0014*\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001e"}, d2 = {"Lexpo/modules/clipboard/ClipboardModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "clipboardCacheDir", "Ljava/io/File;", "getClipboardCacheDir", "()Ljava/io/File;", "clipboardCacheDir$delegate", "Lkotlin/Lazy;", "clipboardEventEmitter", "Lexpo/modules/clipboard/ClipboardModule$ClipboardEventEmitter;", "clipboardManager", "Landroid/content/ClipboardManager;", "getClipboardManager", "()Landroid/content/ClipboardManager;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "firstItem", "Landroid/content/ClipData$Item;", "getFirstItem", "(Landroid/content/ClipboardManager;)Landroid/content/ClipData$Item;", "clipboardHasItemWithType", "", "mimeType", "", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "ClipboardEventEmitter", "expo-clipboard_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ClipboardModule extends Module {

    /* renamed from: clipboardCacheDir$delegate, reason: from kotlin metadata */
    private final Lazy clipboardCacheDir = LazyKt.lazy(new Function0<File>() { // from class: expo.modules.clipboard.ClipboardModule$clipboardCacheDir$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final File invoke() {
            Context context;
            context = ClipboardModule.this.getContext();
            File file = new File(context.getCacheDir(), ClipboardModuleKt.CLIPBOARD_DIRECTORY_NAME);
            file.mkdirs();
            return file;
        }
    });
    private ClipboardEventEmitter clipboardEventEmitter;

    /* compiled from: ClipboardModule.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[StringFormat.values().length];
            try {
                iArr[StringFormat.PLAIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[StringFormat.HTML.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        ClipboardModule clipboardModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (clipboardModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(clipboardModule);
            moduleDefinitionBuilder.Name("ExpoClipboard");
            moduleDefinitionBuilder.getAsyncFunctions().put("getStringAsync", GetStringOptions.class == Promise.class ? new AsyncFunctionWithPromiseComponent("getStringAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$AsyncFunction$1
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    ClipData.Item firstItem;
                    Context context;
                    Context context2;
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    ClipboardModule clipboardModule2 = ClipboardModule.this;
                    firstItem = clipboardModule2.getFirstItem(clipboardModule2.getClipboardManager());
                    int i = ClipboardModule.WhenMappings.$EnumSwitchMapping$0[((GetStringOptions) promise).getPreferredFormat().ordinal()];
                    if (i == 1) {
                        if (firstItem != null) {
                            context = ClipboardModule.this.getContext();
                            ClipboardModuleKt.coerceToPlainText(firstItem, context);
                            return;
                        }
                        return;
                    }
                    if (i != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (firstItem != null) {
                        context2 = ClipboardModule.this.getContext();
                        firstItem.coerceToHtmlText(context2);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("getStringAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(GetStringOptions.class), false, new Function0<KType>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$AsyncFunction$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(GetStringOptions.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$AsyncFunction$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    ClipData.Item firstItem;
                    Context context;
                    Context context2;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.clipboard.GetStringOptions");
                    }
                    ClipboardModule clipboardModule2 = ClipboardModule.this;
                    firstItem = clipboardModule2.getFirstItem(clipboardModule2.getClipboardManager());
                    int i = ClipboardModule.WhenMappings.$EnumSwitchMapping$0[((GetStringOptions) obj).getPreferredFormat().ordinal()];
                    String str = null;
                    if (i != 1) {
                        if (i != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        if (firstItem != null) {
                            context2 = ClipboardModule.this.getContext();
                            str = firstItem.coerceToHtmlText(context2);
                        }
                    } else if (firstItem != null) {
                        context = ClipboardModule.this.getContext();
                        str = ClipboardModuleKt.coerceToPlainText(firstItem, context);
                    }
                    return str == null ? "" : str;
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("setStringAsync", SetStringOptions.class == Promise.class ? new AsyncFunctionWithPromiseComponent("setStringAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$AsyncFunction$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$AsyncFunction$5
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    ClipData newPlainText;
                    String plainTextFromHtml;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    int i = ClipboardModule.WhenMappings.$EnumSwitchMapping$0[((SetStringOptions) promise).getInputFormat().ordinal()];
                    if (i == 1) {
                        newPlainText = ClipData.newPlainText(null, str);
                    } else {
                        if (i != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        plainTextFromHtml = ClipboardModuleKt.plainTextFromHtml(str);
                        newPlainText = ClipData.newHtmlText(null, plainTextFromHtml, str);
                    }
                    ClipboardModule.this.getClipboardManager().setPrimaryClip(newPlainText);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("setStringAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$AsyncFunction$6
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(SetStringOptions.class), false, new Function0<KType>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$AsyncFunction$7
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(SetStringOptions.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$AsyncFunction$8
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    ClipData newPlainText;
                    String plainTextFromHtml;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = it[1];
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type expo.modules.clipboard.SetStringOptions");
                    }
                    int i = ClipboardModule.WhenMappings.$EnumSwitchMapping$0[((SetStringOptions) obj2).getInputFormat().ordinal()];
                    if (i == 1) {
                        newPlainText = ClipData.newPlainText(null, str);
                    } else {
                        if (i != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        plainTextFromHtml = ClipboardModuleKt.plainTextFromHtml(str);
                        newPlainText = ClipData.newHtmlText(null, plainTextFromHtml, str);
                    }
                    ClipboardModule.this.getClipboardManager().setPrimaryClip(newPlainText);
                    return true;
                }
            }));
            AsyncFunctionComponent asyncFunctionComponent = new AsyncFunctionComponent("hasStringAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$AsyncFunctionWithoutArgs$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    boolean hasTextContent;
                    Intrinsics.checkNotNullParameter(it, "it");
                    ClipDescription primaryClipDescription = ClipboardModule.this.getClipboardManager().getPrimaryClipDescription();
                    if (primaryClipDescription != null) {
                        hasTextContent = ClipboardModuleKt.getHasTextContent(primaryClipDescription);
                        return Boolean.valueOf(hasTextContent);
                    }
                    return false;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("hasStringAsync", asyncFunctionComponent);
            AsyncFunctionComponent asyncFunctionComponent2 = asyncFunctionComponent;
            AsyncFunctionBuilder AsyncFunction = moduleDefinitionBuilder.AsyncFunction("getImageAsync");
            AsyncFunction.setAsyncFunctionComponent(new SuspendFunctionComponent(AsyncFunction.getName(), new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(GetImageOptions.class), false, new Function0<KType>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$Coroutine$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(GetImageOptions.class);
                }
            }))}, new ClipboardModule$definition$lambda$12$$inlined$Coroutine$2(null, this)));
            AsyncFunctionBuilder AsyncFunction2 = moduleDefinitionBuilder.AsyncFunction("setImageAsync");
            AsyncFunction2.setAsyncFunctionComponent(new SuspendFunctionComponent(AsyncFunction2.getName(), new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$Coroutine$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new ClipboardModule$definition$lambda$12$$inlined$Coroutine$4(null, this)));
            AsyncFunctionComponent asyncFunctionComponent3 = new AsyncFunctionComponent("hasImageAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$AsyncFunctionWithoutArgs$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ClipDescription primaryClipDescription = ClipboardModule.this.getClipboardManager().getPrimaryClipDescription();
                    boolean z = false;
                    if (primaryClipDescription != null && primaryClipDescription.hasMimeType("image/*")) {
                        z = true;
                    }
                    return Boolean.valueOf(z);
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("hasImageAsync", asyncFunctionComponent3);
            AsyncFunctionComponent asyncFunctionComponent4 = asyncFunctionComponent3;
            moduleDefinitionBuilder.Events(ClipboardModuleKt.CLIPBOARD_CHANGED_EVENT_NAME);
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$OnCreate$1
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
                    ClipboardModule.ClipboardEventEmitter clipboardEventEmitter;
                    ClipboardModule.this.clipboardEventEmitter = ClipboardModule.this.new ClipboardEventEmitter();
                    clipboardEventEmitter = ClipboardModule.this.clipboardEventEmitter;
                    if (clipboardEventEmitter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("clipboardEventEmitter");
                        clipboardEventEmitter = null;
                    }
                    clipboardEventEmitter.attachListener();
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$OnDestroy$1
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
                    ClipboardModule.ClipboardEventEmitter clipboardEventEmitter;
                    clipboardEventEmitter = ClipboardModule.this.clipboardEventEmitter;
                    if (clipboardEventEmitter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("clipboardEventEmitter");
                        clipboardEventEmitter = null;
                    }
                    clipboardEventEmitter.detachListener();
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.ACTIVITY_ENTERS_BACKGROUND, new BasicEventListener(EventName.ACTIVITY_ENTERS_BACKGROUND, new Function0<Unit>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$OnActivityEntersBackground$1
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
                    ClipboardModule.ClipboardEventEmitter clipboardEventEmitter;
                    clipboardEventEmitter = ClipboardModule.this.clipboardEventEmitter;
                    if (clipboardEventEmitter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("clipboardEventEmitter");
                        clipboardEventEmitter = null;
                    }
                    clipboardEventEmitter.pauseListening();
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.ACTIVITY_ENTERS_FOREGROUND, new BasicEventListener(EventName.ACTIVITY_ENTERS_FOREGROUND, new Function0<Unit>() { // from class: expo.modules.clipboard.ClipboardModule$definition$lambda$12$$inlined$OnActivityEntersForeground$1
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
                    ClipboardModule.ClipboardEventEmitter clipboardEventEmitter;
                    clipboardEventEmitter = ClipboardModule.this.clipboardEventEmitter;
                    if (clipboardEventEmitter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("clipboardEventEmitter");
                        clipboardEventEmitter = null;
                    }
                    clipboardEventEmitter.resumeListening();
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
        throw new IllegalArgumentException("React Application Context is null".toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClipboardManager getClipboardManager() {
        Object systemService = getContext().getSystemService("clipboard");
        ClipboardManager clipboardManager = systemService instanceof ClipboardManager ? (ClipboardManager) systemService : null;
        if (clipboardManager != null) {
            return clipboardManager;
        }
        throw new ClipboardUnavailableException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File getClipboardCacheDir() {
        return (File) this.clipboardCacheDir.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ClipboardModule.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\u0001J\r\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lexpo/modules/clipboard/ClipboardModule$ClipboardEventEmitter;", "", "(Lexpo/modules/clipboard/ClipboardModule;)V", "isListening", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Landroid/content/ClipboardManager$OnPrimaryClipChangedListener;", "maybeClipboardManager", "Landroid/content/ClipboardManager;", "timestamp", "", "attachListener", "detachListener", "", "()Lkotlin/Unit;", "pauseListening", "resumeListening", "expo-clipboard_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    final class ClipboardEventEmitter {
        private final ClipboardManager.OnPrimaryClipChangedListener listener;
        private final ClipboardManager maybeClipboardManager;
        private boolean isListening = true;
        private long timestamp = -1;

        public ClipboardEventEmitter() {
            Object m1227constructorimpl;
            this.listener = new ClipboardManager.OnPrimaryClipChangedListener() { // from class: expo.modules.clipboard.ClipboardModule$ClipboardEventEmitter$$ExternalSyntheticLambda0
                @Override // android.content.ClipboardManager.OnPrimaryClipChangedListener
                public final void onPrimaryClipChanged() {
                    ClipboardModule.ClipboardEventEmitter.listener$lambda$7(ClipboardModule.this, this);
                }
            };
            try {
                Result.Companion companion = Result.INSTANCE;
                ClipboardEventEmitter clipboardEventEmitter = this;
                m1227constructorimpl = Result.m1227constructorimpl(ClipboardModule.this.getClipboardManager());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                m1227constructorimpl = Result.m1227constructorimpl(ResultKt.createFailure(th));
            }
            this.maybeClipboardManager = (ClipboardManager) (Result.m1233isFailureimpl(m1227constructorimpl) ? null : m1227constructorimpl);
        }

        public final void resumeListening() {
            this.isListening = true;
        }

        public final void pauseListening() {
            this.isListening = false;
        }

        public final Object attachListener() {
            Unit unit;
            String str;
            ClipboardManager clipboardManager = this.maybeClipboardManager;
            if (clipboardManager != null) {
                clipboardManager.addPrimaryClipChangedListener(this.listener);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit != null) {
                return unit;
            }
            str = ClipboardModuleKt.TAG;
            return Integer.valueOf(Log.e(str, "'CLIPBOARD_SERVICE' unavailable. Events won't be received"));
        }

        public final Unit detachListener() {
            ClipboardManager clipboardManager = this.maybeClipboardManager;
            if (clipboardManager == null) {
                return null;
            }
            clipboardManager.removePrimaryClipChangedListener(this.listener);
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void listener$lambda$7(ClipboardModule this$0, ClipboardEventEmitter this$1) {
            ClipDescription primaryClipDescription;
            boolean hasTextContent;
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(this$1, "this$1");
            if (this$0.getAppContext().getHasActiveReactInstance()) {
                ClipboardManager clipboardManager = this$1.maybeClipboardManager;
                if (!this$1.isListening) {
                    clipboardManager = null;
                }
                if (clipboardManager == null || (primaryClipDescription = clipboardManager.getPrimaryClipDescription()) == null || this$1.timestamp == primaryClipDescription.getTimestamp()) {
                    return;
                }
                this$1.timestamp = primaryClipDescription.getTimestamp();
                Pair[] pairArr = new Pair[1];
                ContentType[] contentTypeArr = new ContentType[3];
                ContentType contentType = ContentType.PLAIN_TEXT;
                hasTextContent = ClipboardModuleKt.getHasTextContent(primaryClipDescription);
                if (!hasTextContent) {
                    contentType = null;
                }
                contentTypeArr[0] = contentType;
                ContentType contentType2 = ContentType.HTML;
                if (!primaryClipDescription.hasMimeType("text/html")) {
                    contentType2 = null;
                }
                contentTypeArr[1] = contentType2;
                contentTypeArr[2] = primaryClipDescription.hasMimeType("image/*") ? ContentType.IMAGE : null;
                List listOfNotNull = CollectionsKt.listOfNotNull((Object[]) contentTypeArr);
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listOfNotNull, 10));
                Iterator it = listOfNotNull.iterator();
                while (it.hasNext()) {
                    arrayList.add(((ContentType) it.next()).getJsName());
                }
                pairArr[0] = TuplesKt.to("contentTypes", arrayList);
                this$0.sendEvent(ClipboardModuleKt.CLIPBOARD_CHANGED_EVENT_NAME, BundleKt.bundleOf(pairArr));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean clipboardHasItemWithType(String mimeType) {
        ClipDescription primaryClipDescription = getClipboardManager().getPrimaryClipDescription();
        if (primaryClipDescription != null) {
            return primaryClipDescription.hasMimeType(mimeType);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClipData.Item getFirstItem(ClipboardManager clipboardManager) {
        ClipData primaryClip = clipboardManager.getPrimaryClip();
        if (primaryClip == null) {
            return null;
        }
        if (!(primaryClip.getItemCount() > 0)) {
            primaryClip = null;
        }
        if (primaryClip != null) {
            return primaryClip.getItemAt(0);
        }
        return null;
    }
}
