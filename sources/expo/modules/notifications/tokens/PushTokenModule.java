package expo.modules.notifications.tokens;

import android.os.Bundle;
import androidx.tracing.Trace;
import com.google.firebase.messaging.FirebaseMessaging;
import com.iterable.iterableapi.IterableConstants;
import expo.modules.core.interfaces.services.EventEmitter;
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
import expo.modules.notifications.ModuleNotFoundException;
import expo.modules.notifications.tokens.interfaces.PushTokenListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* compiled from: PushTokenModule.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lexpo/modules/notifications/tokens/PushTokenModule;", "Lexpo/modules/kotlin/modules/Module;", "Lexpo/modules/notifications/tokens/interfaces/PushTokenListener;", "()V", "eventEmitter", "Lexpo/modules/core/interfaces/services/EventEmitter;", "tokenManager", "Lexpo/modules/notifications/tokens/interfaces/PushTokenManager;", "getTokenManager", "()Lexpo/modules/notifications/tokens/interfaces/PushTokenManager;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "onNewToken", "", IterableConstants.KEY_TOKEN, "", "expo-notifications_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PushTokenModule extends Module implements PushTokenListener {
    private EventEmitter eventEmitter;

    /* JADX INFO: Access modifiers changed from: private */
    public final expo.modules.notifications.tokens.interfaces.PushTokenManager getTokenManager() {
        return (expo.modules.notifications.tokens.interfaces.PushTokenManager) getAppContext().getLegacyModuleRegistry().getSingletonModule("PushTokenManager", expo.modules.notifications.tokens.interfaces.PushTokenManager.class);
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent asyncFunctionComponent;
        AsyncFunctionComponent asyncFunctionComponent2;
        PushTokenModule pushTokenModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (pushTokenModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(pushTokenModule);
            moduleDefinitionBuilder.Name("ExpoPushTokenManager");
            moduleDefinitionBuilder.Events("onDevicePushToken");
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: expo.modules.notifications.tokens.PushTokenModule$definition$lambda$4$$inlined$OnCreate$1
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
                    Object obj;
                    expo.modules.notifications.tokens.interfaces.PushTokenManager tokenManager;
                    PushTokenModule pushTokenModule2 = PushTokenModule.this;
                    try {
                        obj = pushTokenModule2.getAppContext().getLegacyModuleRegistry().getModule(EventEmitter.class);
                    } catch (Exception unused) {
                        obj = null;
                    }
                    EventEmitter eventEmitter = (EventEmitter) obj;
                    if (eventEmitter != null) {
                        pushTokenModule2.eventEmitter = eventEmitter;
                        tokenManager = PushTokenModule.this.getTokenManager();
                        if (tokenManager != null) {
                            tokenManager.addListener(PushTokenModule.this);
                            return;
                        }
                        return;
                    }
                    throw new ModuleNotFoundException(Reflection.getOrCreateKotlinClass(EventEmitter.class));
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: expo.modules.notifications.tokens.PushTokenModule$definition$lambda$4$$inlined$OnDestroy$1
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
                    expo.modules.notifications.tokens.interfaces.PushTokenManager tokenManager;
                    tokenManager = PushTokenModule.this.getTokenManager();
                    if (tokenManager != null) {
                        tokenManager.removeListener(PushTokenModule.this);
                    }
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            if (Promise.class == Promise.class) {
                asyncFunctionComponent = new AsyncFunctionWithPromiseComponent("getDevicePushTokenAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.notifications.tokens.PushTokenModule$definition$lambda$4$$inlined$AsyncFunction$1
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
                        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new PushTokenModule$definition$1$3$1(promise, PushTokenModule.this));
                    }
                });
            } else {
                asyncFunctionComponent = new AsyncFunctionComponent("getDevicePushTokenAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.notifications.tokens.PushTokenModule$definition$lambda$4$$inlined$AsyncFunction$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Promise.class);
                    }
                }))}, new Function1<Object[], Object>() { // from class: expo.modules.notifications.tokens.PushTokenModule$definition$lambda$4$$inlined$AsyncFunction$3
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
                        return FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new PushTokenModule$definition$1$3$1((Promise) obj, PushTokenModule.this));
                    }
                });
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("getDevicePushTokenAsync", asyncFunctionComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            if (Promise.class == Promise.class) {
                asyncFunctionComponent2 = new AsyncFunctionWithPromiseComponent("unregisterForNotificationsAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.notifications.tokens.PushTokenModule$definition$lambda$4$$inlined$AsyncFunction$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        FirebaseMessaging.getInstance().deleteToken().addOnCompleteListener(new PushTokenModule$definition$1$4$1(promise));
                    }
                });
            } else {
                asyncFunctionComponent2 = new AsyncFunctionComponent("unregisterForNotificationsAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, new Function0<KType>() { // from class: expo.modules.notifications.tokens.PushTokenModule$definition$lambda$4$$inlined$AsyncFunction$5
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Promise.class);
                    }
                }))}, new Function1<Object[], Object>() { // from class: expo.modules.notifications.tokens.PushTokenModule$definition$lambda$4$$inlined$AsyncFunction$6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object[] it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object obj = it[0];
                        if (obj == null) {
                            throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
                        }
                        return FirebaseMessaging.getInstance().deleteToken().addOnCompleteListener(new PushTokenModule$definition$1$4$1((Promise) obj));
                    }
                });
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("unregisterForNotificationsAsync", asyncFunctionComponent2);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    @Override // expo.modules.notifications.tokens.interfaces.PushTokenListener
    public void onNewToken(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        EventEmitter eventEmitter = this.eventEmitter;
        if (eventEmitter != null) {
            Bundle bundle = new Bundle();
            bundle.putString("devicePushToken", token);
            eventEmitter.emit("onDevicePushToken", bundle);
        }
    }
}
