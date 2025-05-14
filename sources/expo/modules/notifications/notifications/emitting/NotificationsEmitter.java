package expo.modules.notifications.notifications.emitting;

import android.os.Bundle;
import androidx.tracing.Trace;
import expo.modules.core.interfaces.services.EventEmitter;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.notifications.ModuleNotFoundException;
import expo.modules.notifications.notifications.NotificationSerializer;
import expo.modules.notifications.notifications.interfaces.NotificationListener;
import expo.modules.notifications.notifications.interfaces.NotificationManager;
import expo.modules.notifications.notifications.model.Notification;
import expo.modules.notifications.notifications.model.NotificationResponse;
import expo.modules.notifications.service.NotificationsService;
import io.sentry.protocol.Response;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: NotificationsEmitter.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\rH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lexpo/modules/notifications/notifications/emitting/NotificationsEmitter;", "Lexpo/modules/kotlin/modules/Module;", "Lexpo/modules/notifications/notifications/interfaces/NotificationListener;", "()V", "eventEmitter", "Lexpo/modules/core/interfaces/services/EventEmitter;", "lastNotificationResponse", "Lexpo/modules/notifications/notifications/model/NotificationResponse;", "notificationManager", "Lexpo/modules/notifications/notifications/interfaces/NotificationManager;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "onNotificationReceived", "", NotificationsService.NOTIFICATION_KEY, "Lexpo/modules/notifications/notifications/model/Notification;", "onNotificationResponseReceived", "", Response.TYPE, "onNotificationsDropped", "expo-notifications_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public class NotificationsEmitter extends Module implements NotificationListener {
    private EventEmitter eventEmitter;
    private NotificationResponse lastNotificationResponse;
    private NotificationManager notificationManager;

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        NotificationsEmitter notificationsEmitter = this;
        Trace.beginSection("[ExpoModulesCore] " + (notificationsEmitter.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(notificationsEmitter);
            moduleDefinitionBuilder.Name("ExpoNotificationsEmitter");
            moduleDefinitionBuilder.Events("onDidReceiveNotification", "onNotificationsDeleted", "onDidReceiveNotificationResponse");
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: expo.modules.notifications.notifications.emitting.NotificationsEmitter$definition$lambda$3$$inlined$OnCreate$1
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
                    NotificationManager notificationManager;
                    NotificationsEmitter notificationsEmitter2 = NotificationsEmitter.this;
                    NotificationManager notificationManager2 = null;
                    try {
                        obj = notificationsEmitter2.getAppContext().getLegacyModuleRegistry().getModule(EventEmitter.class);
                    } catch (Exception unused) {
                        obj = null;
                    }
                    EventEmitter eventEmitter = (EventEmitter) obj;
                    if (eventEmitter != null) {
                        notificationsEmitter2.eventEmitter = eventEmitter;
                        NotificationsEmitter notificationsEmitter3 = NotificationsEmitter.this;
                        Object singletonModule = notificationsEmitter3.getAppContext().getLegacyModuleRegistry().getSingletonModule("NotificationManager", NotificationManager.class);
                        if (singletonModule != null) {
                            notificationsEmitter3.notificationManager = (NotificationManager) singletonModule;
                            notificationManager = NotificationsEmitter.this.notificationManager;
                            if (notificationManager == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("notificationManager");
                            } else {
                                notificationManager2 = notificationManager;
                            }
                            notificationManager2.addListener(NotificationsEmitter.this);
                            return;
                        }
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    throw new ModuleNotFoundException(Reflection.getOrCreateKotlinClass(EventEmitter.class));
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: expo.modules.notifications.notifications.emitting.NotificationsEmitter$definition$lambda$3$$inlined$OnDestroy$1
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
                    NotificationManager notificationManager;
                    notificationManager = NotificationsEmitter.this.notificationManager;
                    if (notificationManager == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("notificationManager");
                        notificationManager = null;
                    }
                    notificationManager.removeListener(NotificationsEmitter.this);
                }
            }));
            AsyncFunctionComponent asyncFunctionComponent = new AsyncFunctionComponent("getLastNotificationResponseAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.notifications.notifications.emitting.NotificationsEmitter$definition$lambda$3$$inlined$AsyncFunctionWithoutArgs$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    NotificationResponse notificationResponse;
                    Intrinsics.checkNotNullParameter(it, "it");
                    notificationResponse = NotificationsEmitter.this.lastNotificationResponse;
                    if (notificationResponse != null) {
                        return NotificationSerializer.toBundle(notificationResponse);
                    }
                    return null;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("getLastNotificationResponseAsync", asyncFunctionComponent);
            AsyncFunctionComponent asyncFunctionComponent2 = asyncFunctionComponent;
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    @Override // expo.modules.notifications.notifications.interfaces.NotificationListener
    public void onNotificationReceived(Notification notification) {
        Intrinsics.checkNotNullParameter(notification, "notification");
        EventEmitter eventEmitter = this.eventEmitter;
        if (eventEmitter != null) {
            eventEmitter.emit("onDidReceiveNotification", NotificationSerializer.toBundle(notification));
        }
    }

    @Override // expo.modules.notifications.notifications.interfaces.NotificationListener
    public boolean onNotificationResponseReceived(NotificationResponse response) {
        Intrinsics.checkNotNullParameter(response, "response");
        this.lastNotificationResponse = response;
        EventEmitter eventEmitter = this.eventEmitter;
        if (eventEmitter == null) {
            return false;
        }
        eventEmitter.emit("onDidReceiveNotificationResponse", NotificationSerializer.toBundle(response));
        return true;
    }

    @Override // expo.modules.notifications.notifications.interfaces.NotificationListener
    public void onNotificationsDropped() {
        EventEmitter eventEmitter = this.eventEmitter;
        if (eventEmitter != null) {
            eventEmitter.emit("onNotificationsDeleted", Bundle.EMPTY);
        }
    }
}
