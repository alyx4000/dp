package expo.modules.notifications.notifications.channels;

import android.app.NotificationChannel;
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
import expo.modules.notifications.notifications.channels.managers.NotificationsChannelManager;
import expo.modules.notifications.notifications.channels.serializers.NotificationsChannelSerializer;
import expo.modules.notifications.notifications.enums.NotificationImportance;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* compiled from: NotificationChannelManagerModule.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lexpo/modules/notifications/notifications/channels/NotificationChannelManagerModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "channelManager", "Lexpo/modules/notifications/notifications/channels/managers/NotificationsChannelManager;", "channelSerializer", "Lexpo/modules/notifications/notifications/channels/serializers/NotificationsChannelSerializer;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "getImportanceFromOptions", "", "channelOptions", "Lexpo/modules/core/arguments/ReadableArguments;", "getNameFromOptions", "", "expo-notifications_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public class NotificationChannelManagerModule extends Module {
    private NotificationsChannelManager channelManager;
    private NotificationsChannelSerializer channelSerializer;

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        NotificationChannelManagerModule notificationChannelManagerModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (notificationChannelManagerModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(notificationChannelManagerModule);
            moduleDefinitionBuilder.Name("ExpoNotificationChannelManager");
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelManagerModule$definition$lambda$5$$inlined$OnCreate$1
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
                        obj = NotificationChannelManagerModule.this.getAppContext().getLegacyModuleRegistry().getModule(NotificationsChannelsProvider.class);
                    } catch (Exception unused) {
                        obj = null;
                    }
                    NotificationsChannelsProvider notificationsChannelsProvider = (NotificationsChannelsProvider) obj;
                    if (notificationsChannelsProvider == null) {
                        throw new ModuleNotFoundException(Reflection.getOrCreateKotlinClass(NotificationsChannelsProvider.class));
                    }
                    NotificationChannelManagerModule notificationChannelManagerModule2 = NotificationChannelManagerModule.this;
                    NotificationsChannelManager channelManager = notificationsChannelsProvider.getChannelManager();
                    Intrinsics.checkNotNullExpressionValue(channelManager, "provider.channelManager");
                    notificationChannelManagerModule2.channelManager = channelManager;
                    NotificationChannelManagerModule notificationChannelManagerModule3 = NotificationChannelManagerModule.this;
                    NotificationsChannelSerializer channelSerializer = notificationsChannelsProvider.getChannelSerializer();
                    Intrinsics.checkNotNullExpressionValue(channelSerializer, "provider.channelSerializer");
                    notificationChannelManagerModule3.channelSerializer = channelSerializer;
                }
            }));
            AsyncFunctionComponent asyncFunctionComponent = new AsyncFunctionComponent("getNotificationChannelsAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelManagerModule$definition$lambda$5$$inlined$AsyncFunctionWithoutArgs$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    NotificationsChannelManager notificationsChannelManager;
                    NotificationsChannelSerializer notificationsChannelSerializer;
                    Intrinsics.checkNotNullParameter(it, "it");
                    notificationsChannelManager = NotificationChannelManagerModule.this.channelManager;
                    NotificationsChannelSerializer notificationsChannelSerializer2 = null;
                    if (notificationsChannelManager == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("channelManager");
                        notificationsChannelManager = null;
                    }
                    List<NotificationChannel> notificationChannels = notificationsChannelManager.getNotificationChannels();
                    Intrinsics.checkNotNullExpressionValue(notificationChannels, "channelManager\n        .notificationChannels");
                    List<NotificationChannel> list = notificationChannels;
                    notificationsChannelSerializer = NotificationChannelManagerModule.this.channelSerializer;
                    if (notificationsChannelSerializer == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("channelSerializer");
                    } else {
                        notificationsChannelSerializer2 = notificationsChannelSerializer;
                    }
                    ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                    Iterator<T> it2 = list.iterator();
                    while (it2.hasNext()) {
                        arrayList.add(notificationsChannelSerializer2.toBundle((NotificationChannel) it2.next()));
                    }
                    return arrayList;
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("getNotificationChannelsAsync", asyncFunctionComponent);
            AsyncFunctionComponent asyncFunctionComponent2 = asyncFunctionComponent;
            moduleDefinitionBuilder.getAsyncFunctions().put("getNotificationChannelAsync", String.class == Promise.class ? new AsyncFunctionWithPromiseComponent("getNotificationChannelAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelManagerModule$definition$lambda$5$$inlined$AsyncFunction$1
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    NotificationsChannelManager notificationsChannelManager;
                    NotificationsChannelSerializer notificationsChannelSerializer;
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    String str = (String) promise;
                    notificationsChannelManager = NotificationChannelManagerModule.this.channelManager;
                    NotificationsChannelSerializer notificationsChannelSerializer2 = null;
                    if (notificationsChannelManager == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("channelManager");
                        notificationsChannelManager = null;
                    }
                    NotificationChannel notificationChannel = notificationsChannelManager.getNotificationChannel(str);
                    notificationsChannelSerializer = NotificationChannelManagerModule.this.channelSerializer;
                    if (notificationsChannelSerializer == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("channelSerializer");
                    } else {
                        notificationsChannelSerializer2 = notificationsChannelSerializer;
                    }
                    notificationsChannelSerializer2.toBundle(notificationChannel);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("getNotificationChannelAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelManagerModule$definition$lambda$5$$inlined$AsyncFunction$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelManagerModule$definition$lambda$5$$inlined$AsyncFunction$3
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    NotificationsChannelManager notificationsChannelManager;
                    NotificationsChannelSerializer notificationsChannelSerializer;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj != null) {
                        String str = (String) obj;
                        notificationsChannelManager = NotificationChannelManagerModule.this.channelManager;
                        NotificationsChannelSerializer notificationsChannelSerializer2 = null;
                        if (notificationsChannelManager == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("channelManager");
                            notificationsChannelManager = null;
                        }
                        NotificationChannel notificationChannel = notificationsChannelManager.getNotificationChannel(str);
                        notificationsChannelSerializer = NotificationChannelManagerModule.this.channelSerializer;
                        if (notificationsChannelSerializer == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("channelSerializer");
                        } else {
                            notificationsChannelSerializer2 = notificationsChannelSerializer;
                        }
                        return notificationsChannelSerializer2.toBundle(notificationChannel);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("setNotificationChannelAsync", ReadableArguments.class == Promise.class ? new AsyncFunctionWithPromiseComponent("setNotificationChannelAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelManagerModule$definition$lambda$5$$inlined$AsyncFunction$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function2<Object[], Promise, Unit>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelManagerModule$definition$lambda$5$$inlined$AsyncFunction$5
                {
                    super(2);
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] args, Promise promise) {
                    NotificationsChannelManager notificationsChannelManager;
                    CharSequence nameFromOptions;
                    int importanceFromOptions;
                    NotificationsChannelSerializer notificationsChannelSerializer;
                    Intrinsics.checkNotNullParameter(args, "args");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    Object obj = args[0];
                    if (obj != null) {
                        String str = (String) obj;
                        ReadableArguments readableArguments = (ReadableArguments) promise;
                        notificationsChannelManager = NotificationChannelManagerModule.this.channelManager;
                        NotificationsChannelSerializer notificationsChannelSerializer2 = null;
                        if (notificationsChannelManager == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("channelManager");
                            notificationsChannelManager = null;
                        }
                        nameFromOptions = NotificationChannelManagerModule.this.getNameFromOptions(readableArguments);
                        importanceFromOptions = NotificationChannelManagerModule.this.getImportanceFromOptions(readableArguments);
                        NotificationChannel createNotificationChannel = notificationsChannelManager.createNotificationChannel(str, nameFromOptions, importanceFromOptions, readableArguments);
                        notificationsChannelSerializer = NotificationChannelManagerModule.this.channelSerializer;
                        if (notificationsChannelSerializer == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("channelSerializer");
                        } else {
                            notificationsChannelSerializer2 = notificationsChannelSerializer;
                        }
                        notificationsChannelSerializer2.toBundle(createNotificationChannel);
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("setNotificationChannelAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelManagerModule$definition$lambda$5$$inlined$AsyncFunction$6
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            })), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArguments.class), false, new Function0<KType>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelManagerModule$definition$lambda$5$$inlined$AsyncFunction$7
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ReadableArguments.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelManagerModule$definition$lambda$5$$inlined$AsyncFunction$8
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    NotificationsChannelManager notificationsChannelManager;
                    CharSequence nameFromOptions;
                    int importanceFromOptions;
                    NotificationsChannelSerializer notificationsChannelSerializer;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                    String str = (String) obj;
                    Object obj2 = it[1];
                    if (obj2 != null) {
                        ReadableArguments readableArguments = (ReadableArguments) obj2;
                        notificationsChannelManager = NotificationChannelManagerModule.this.channelManager;
                        NotificationsChannelSerializer notificationsChannelSerializer2 = null;
                        if (notificationsChannelManager == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("channelManager");
                            notificationsChannelManager = null;
                        }
                        nameFromOptions = NotificationChannelManagerModule.this.getNameFromOptions(readableArguments);
                        importanceFromOptions = NotificationChannelManagerModule.this.getImportanceFromOptions(readableArguments);
                        NotificationChannel createNotificationChannel = notificationsChannelManager.createNotificationChannel(str, nameFromOptions, importanceFromOptions, readableArguments);
                        notificationsChannelSerializer = NotificationChannelManagerModule.this.channelSerializer;
                        if (notificationsChannelSerializer == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("channelSerializer");
                        } else {
                            notificationsChannelSerializer2 = notificationsChannelSerializer;
                        }
                        return notificationsChannelSerializer2.toBundle(createNotificationChannel);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type expo.modules.core.arguments.ReadableArguments");
                }
            }));
            moduleDefinitionBuilder.getAsyncFunctions().put("deleteNotificationChannelAsync", String.class == Promise.class ? new AsyncFunctionWithPromiseComponent("deleteNotificationChannelAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelManagerModule$definition$lambda$5$$inlined$AsyncFunction$9
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object[] objArr, Promise promise) {
                    NotificationsChannelManager notificationsChannelManager;
                    Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(promise, "promise");
                    String str = (String) promise;
                    notificationsChannelManager = NotificationChannelManagerModule.this.channelManager;
                    if (notificationsChannelManager == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("channelManager");
                        notificationsChannelManager = null;
                    }
                    notificationsChannelManager.deleteNotificationChannel(str);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                    invoke2(objArr, promise);
                    return Unit.INSTANCE;
                }
            }) : new AsyncFunctionComponent("deleteNotificationChannelAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelManagerModule$definition$lambda$5$$inlined$AsyncFunction$10
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(String.class);
                }
            }))}, new Function1<Object[], Object>() { // from class: expo.modules.notifications.notifications.channels.NotificationChannelManagerModule$definition$lambda$5$$inlined$AsyncFunction$11
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    NotificationsChannelManager notificationsChannelManager;
                    Intrinsics.checkNotNullParameter(it, "it");
                    Object obj = it[0];
                    if (obj != null) {
                        String str = (String) obj;
                        notificationsChannelManager = NotificationChannelManagerModule.this.channelManager;
                        if (notificationsChannelManager == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("channelManager");
                            notificationsChannelManager = null;
                        }
                        notificationsChannelManager.deleteNotificationChannel(str);
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
    public final CharSequence getNameFromOptions(ReadableArguments channelOptions) {
        String string = channelOptions.getString("name");
        Intrinsics.checkNotNullExpressionValue(string, "channelOptions.getString…annelSerializer.NAME_KEY)");
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getImportanceFromOptions(ReadableArguments channelOptions) {
        return ((NotificationImportance) Objects.requireNonNull(NotificationImportance.fromEnumValue(channelOptions.getInt(NotificationsChannelSerializer.IMPORTANCE_KEY, NotificationImportance.DEFAULT.getEnumValue())))).getNativeValue();
    }
}
