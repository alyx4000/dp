package expo.modules.notifications.notifications.channels;

import android.app.NotificationChannelGroup;
import androidx.tracing.Trace;
import expo.modules.core.arguments.ReadableArguments;
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
import expo.modules.notifications.notifications.channels.managers.NotificationsChannelGroupManager;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelGroupSerializer;
import java.util.ArrayList;
import java.util.Iterator;
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

/* compiled from: NotificationChannelGroupManagerModule.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lexpo/modules/notifications/notifications/channels/NotificationChannelGroupManagerModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "groupManager", "Lexpo/modules/notifications/notifications/channels/managers/NotificationsChannelGroupManager;", "groupSerializer", "Lexpo/modules/notifications/notifications/channels/serializers/NotificationsChannelGroupSerializer;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "getNameFromOptions", "", "groupOptions", "Lexpo/modules/core/arguments/ReadableArguments;", "expo-notifications_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NotificationChannelGroupManagerModule extends Module {
    private NotificationsChannelGroupManager groupManager;
    private NotificationsChannelGroupSerializer groupSerializer;

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        NotificationChannelGroupManagerModule notificationChannelGroupManagerModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (notificationChannelGroupManagerModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(notificationChannelGroupManagerModule);
            moduleDefinitionBuilder.Name("ExpoNotificationChannelGroupManager");
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelGroupManagerModule$definition$lambda$5$$inlined$OnCreate$1
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
                    try {
                        obj = NotificationChannelGroupManagerModule.this.getAppContext().getLegacyModuleRegistry().getModule(NotificationsChannelsProvider.class);
                    } catch (Exception unused) {
                        obj = null;
                    }
                    NotificationsChannelsProvider notificationsChannelsProvider = (NotificationsChannelsProvider) obj;
                    if (notificationsChannelsProvider == null) {
                        throw new ModuleNotFoundException(Reflection.getOrCreateKotlinClass(NotificationsChannelsProvider.class));
                    }
                    NotificationChannelGroupManagerModule notificationChannelGroupManagerModule2 = NotificationChannelGroupManagerModule.this;
                    NotificationsChannelGroupManager groupManager = notificationsChannelsProvider.getGroupManager();
                    Intrinsics.checkNotNullExpressionValue(groupManager, "provider.groupManager");
                    notificationChannelGroupManagerModule2.groupManager = groupManager;
                    NotificationChannelGroupManagerModule notificationChannelGroupManagerModule3 = NotificationChannelGroupManagerModule.this;
                    NotificationsChannelGroupSerializer groupSerializer = notificationsChannelsProvider.getGroupSerializer();
                    Intrinsics.checkNotNullExpressionValue(groupSerializer, "provider.groupSerializer");
                    notificationChannelGroupManagerModule3.groupSerializer = groupSerializer;
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("getNotificationChannelGroupAsync", String.class == Promise.class ? new AsyncFunctionWithPromiseComponent("getNotificationChannelGroupAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelGroupManagerModule$definition$lambda$5$$inlined$AsyncFunction$1
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    NotificationsChannelGroupManager notificationsChannelGroupManager;
                    NotificationsChannelGroupSerializer notificationsChannelGroupSerializer;
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    String str = (String) promise;
                    notificationsChannelGroupManager = NotificationChannelGroupManagerModule.this.groupManager;
                    NotificationsChannelGroupSerializer notificationsChannelGroupSerializer2 = null;
                    if (notificationsChannelGroupManager == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("groupManager");
                        notificationsChannelGroupManager = null;
                    }
                    NotificationChannelGroup notificationChannelGroup = notificationsChannelGroupManager.getNotificationChannelGroup(str);
                    notificationsChannelGroupSerializer = NotificationChannelGroupManagerModule.this.groupSerializer;
                    if (notificationsChannelGroupSerializer == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("groupSerializer");
                    } else {
                        notificationsChannelGroupSerializer2 = notificationsChannelGroupSerializer;
                    }
                    notificationsChannelGroupSerializer2.toBundle(notificationChannelGroup);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("getNotificationChannelGroupAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelGroupManagerModule$definition$lambda$5$$inlined$AsyncFunction$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelGroupManagerModule$definition$lambda$5$$inlined$AsyncFunction$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    NotificationsChannelGroupManager notificationsChannelGroupManager;
                    NotificationsChannelGroupSerializer notificationsChannelGroupSerializer;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj != null) {
                        String str = (String) obj;
                        notificationsChannelGroupManager = NotificationChannelGroupManagerModule.this.groupManager;
                        NotificationsChannelGroupSerializer notificationsChannelGroupSerializer2 = null;
                        if (notificationsChannelGroupManager == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("groupManager");
                            notificationsChannelGroupManager = null;
                        }
                        NotificationChannelGroup notificationChannelGroup = notificationsChannelGroupManager.getNotificationChannelGroup(str);
                        notificationsChannelGroupSerializer = NotificationChannelGroupManagerModule.this.groupSerializer;
                        if (notificationsChannelGroupSerializer == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("groupSerializer");
                        } else {
                            notificationsChannelGroupSerializer2 = notificationsChannelGroupSerializer;
                        }
                        return notificationsChannelGroupSerializer2.toBundle(notificationChannelGroup);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }));
            AsyncFunctionComponent asyncFunctionComponent = new AsyncFunctionComponent("getNotificationChannelGroupsAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelGroupManagerModule$definition$lambda$5$$inlined$AsyncFunctionWithoutArgs$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    NotificationsChannelGroupManager notificationsChannelGroupManager;
                    NotificationsChannelGroupSerializer notificationsChannelGroupSerializer;
                    Intrinsics.checkNotNullParameter(it, "it");
                    notificationsChannelGroupManager = NotificationChannelGroupManagerModule.this.groupManager;
                    NotificationsChannelGroupSerializer notificationsChannelGroupSerializer2 = null;
                    if (notificationsChannelGroupManager == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("groupManager");
                        notificationsChannelGroupManager = null;
                    }
                    List<NotificationChannelGroup> notificationChannelGroups = notificationsChannelGroupManager.getNotificationChannelGroups();
                    Intrinsics.checkNotNullExpressionValue(notificationChannelGroups, "groupManager\n          .notificationChannelGroups");
                    List<NotificationChannelGroup> list = notificationChannelGroups;
                    notificationsChannelGroupSerializer = NotificationChannelGroupManagerModule.this.groupSerializer;
                    if (notificationsChannelGroupSerializer == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("groupSerializer");
                    } else {
                        notificationsChannelGroupSerializer2 = notificationsChannelGroupSerializer;
                    }
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    Iterator<T> it2 = list.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(notificationsChannelGroupSerializer2.toBundle((NotificationChannelGroup) it2.next()));
                    }
                    return arrayList;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("getNotificationChannelGroupsAsync", asyncFunctionComponent);
            AsyncFunctionComponent asyncFunctionComponent2 = asyncFunctionComponent;
            moduleDefinitionBuilder.getAsyncFunctions().put("setNotificationChannelGroupAsync", ReadableArguments.class == Promise.class ? new AsyncFunctionWithPromiseComponent("setNotificationChannelGroupAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelGroupManagerModule$definition$lambda$5$$inlined$AsyncFunction$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelGroupManagerModule$definition$lambda$5$$inlined$AsyncFunction$5
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    NotificationsChannelGroupManager notificationsChannelGroupManager;
                    String nameFromOptions;
                    NotificationsChannelGroupSerializer notificationsChannelGroupSerializer;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj != null) {
                        String str = (String) obj;
                        ReadableArguments readableArguments = (ReadableArguments) promise;
                        notificationsChannelGroupManager = NotificationChannelGroupManagerModule.this.groupManager;
                        NotificationsChannelGroupSerializer notificationsChannelGroupSerializer2 = null;
                        if (notificationsChannelGroupManager == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("groupManager");
                            notificationsChannelGroupManager = null;
                        }
                        nameFromOptions = NotificationChannelGroupManagerModule.this.getNameFromOptions(readableArguments);
                        NotificationChannelGroup createNotificationChannelGroup = notificationsChannelGroupManager.createNotificationChannelGroup(str, nameFromOptions, readableArguments);
                        notificationsChannelGroupSerializer = NotificationChannelGroupManagerModule.this.groupSerializer;
                        if (notificationsChannelGroupSerializer == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("groupSerializer");
                        } else {
                            notificationsChannelGroupSerializer2 = notificationsChannelGroupSerializer;
                        }
                        notificationsChannelGroupSerializer2.toBundle(createNotificationChannelGroup);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("setNotificationChannelGroupAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelGroupManagerModule$definition$lambda$5$$inlined$AsyncFunction$6
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, new Function0<KType>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelGroupManagerModule$definition$lambda$5$$inlined$AsyncFunction$7
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableArguments.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelGroupManagerModule$definition$lambda$5$$inlined$AsyncFunction$8
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    NotificationsChannelGroupManager notificationsChannelGroupManager;
                    String nameFromOptions;
                    NotificationsChannelGroupSerializer notificationsChannelGroupSerializer;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = it[1];
                    if (obj2 != null) {
                        ReadableArguments readableArguments = (ReadableArguments) obj2;
                        notificationsChannelGroupManager = NotificationChannelGroupManagerModule.this.groupManager;
                        NotificationsChannelGroupSerializer notificationsChannelGroupSerializer2 = null;
                        if (notificationsChannelGroupManager == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("groupManager");
                            notificationsChannelGroupManager = null;
                        }
                        nameFromOptions = NotificationChannelGroupManagerModule.this.getNameFromOptions(readableArguments);
                        NotificationChannelGroup createNotificationChannelGroup = notificationsChannelGroupManager.createNotificationChannelGroup(str, nameFromOptions, readableArguments);
                        notificationsChannelGroupSerializer = NotificationChannelGroupManagerModule.this.groupSerializer;
                        if (notificationsChannelGroupSerializer == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("groupSerializer");
                        } else {
                            notificationsChannelGroupSerializer2 = notificationsChannelGroupSerializer;
                        }
                        return notificationsChannelGroupSerializer2.toBundle(createNotificationChannelGroup);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.core.arguments.ReadableArguments");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("deleteNotificationChannelGroupAsync", String.class == Promise.class ? new AsyncFunctionWithPromiseComponent("deleteNotificationChannelGroupAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelGroupManagerModule$definition$lambda$5$$inlined$AsyncFunction$9
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    NotificationsChannelGroupManager notificationsChannelGroupManager;
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    String str = (String) promise;
                    notificationsChannelGroupManager = NotificationChannelGroupManagerModule.this.groupManager;
                    if (notificationsChannelGroupManager == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("groupManager");
                        notificationsChannelGroupManager = null;
                    }
                    notificationsChannelGroupManager.deleteNotificationChannelGroup(str);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("deleteNotificationChannelGroupAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelGroupManagerModule$definition$lambda$5$$inlined$AsyncFunction$10
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelGroupManagerModule$definition$lambda$5$$inlined$AsyncFunction$11
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    NotificationsChannelGroupManager notificationsChannelGroupManager;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj != null) {
                        String str = (String) obj;
                        notificationsChannelGroupManager = NotificationChannelGroupManagerModule.this.groupManager;
                        if (notificationsChannelGroupManager == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("groupManager");
                            notificationsChannelGroupManager = null;
                        }
                        notificationsChannelGroupManager.deleteNotificationChannelGroup(str);
                        return Unit.INSTANCE;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getNameFromOptions(ReadableArguments groupOptions) {
        String string = groupOptions.getString("name");
        Intrinsics.checkNotNullExpressionValue(string, "groupOptions.getString(N…GroupSerializer.NAME_KEY)");
        return string;
    }
}
