package expo.modules.notifications.notifications.background;

import androidx.tracing.Trace;
import expo.modules.interfaces.taskManager.TaskManagerInterface;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.notifications.ModuleNotFoundException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* compiled from: ExpoBackgroundNotificationTasksModule.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lexpo/modules/notifications/notifications/background/ExpoBackgroundNotificationTasksModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "taskManager", "Lexpo/modules/interfaces/taskManager/TaskManagerInterface;", "getTaskManager", "()Lexpo/modules/interfaces/taskManager/TaskManagerInterface;", "taskManager$delegate", "Lkotlin/Lazy;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-notifications_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ExpoBackgroundNotificationTasksModule extends Module {

    /* renamed from: taskManager$delegate, reason: from kotlin metadata */
    private final Lazy taskManager = LazyKt.lazy(new Function0<TaskManagerInterface>() { // from class: expo.modules.notifications.notifications.background.ExpoBackgroundNotificationTasksModule$taskManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TaskManagerInterface invoke() {
            Object obj;
            try {
                obj = ExpoBackgroundNotificationTasksModule.this.getAppContext().getLegacyModuleRegistry().getModule(TaskManagerInterface.class);
            } catch (Exception unused) {
                obj = null;
            }
            TaskManagerInterface taskManagerInterface = (TaskManagerInterface) obj;
            if (taskManagerInterface != null) {
                return taskManagerInterface;
            }
            throw new ModuleNotFoundException(Reflection.getOrCreateKotlinClass(TaskManagerInterface.class));
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final TaskManagerInterface getTaskManager() {
        return (TaskManagerInterface) this.taskManager.getValue();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent asyncFunctionComponent;
        AsyncFunctionComponent asyncFunctionComponent2;
        ExpoBackgroundNotificationTasksModule expoBackgroundNotificationTasksModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (expoBackgroundNotificationTasksModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(expoBackgroundNotificationTasksModule);
            moduleDefinitionBuilder.Name("ExpoBackgroundNotificationTasksModule");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            if (String.class == Promise.class) {
                asyncFunctionComponent = new AsyncFunctionWithPromiseComponent("registerTaskAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.notifications.notifications.background.ExpoBackgroundNotificationTasksModule$definition$lambda$2$$inlined$AsyncFunction$1
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        TaskManagerInterface taskManager;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        taskManager = ExpoBackgroundNotificationTasksModule.this.getTaskManager();
                        taskManager.registerTask((String) promise, BackgroundRemoteNotificationTaskConsumer.class, MapsKt.emptyMap());
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                asyncFunctionComponent = new AsyncFunctionComponent("registerTaskAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.notifications.notifications.background.ExpoBackgroundNotificationTasksModule$definition$lambda$2$$inlined$AsyncFunction$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }))}, new Function1<Object[], Object>() { // from class: expo.modules.notifications.notifications.background.ExpoBackgroundNotificationTasksModule$definition$lambda$2$$inlined$AsyncFunction$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object[] it) {
                        TaskManagerInterface taskManager;
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object obj = it[0];
                        if (obj != null) {
                            taskManager = ExpoBackgroundNotificationTasksModule.this.getTaskManager();
                            taskManager.registerTask((String) obj, BackgroundRemoteNotificationTaskConsumer.class, MapsKt.emptyMap());
                            return Unit.INSTANCE;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                });
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("registerTaskAsync", asyncFunctionComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            if (String.class == Promise.class) {
                asyncFunctionComponent2 = new AsyncFunctionWithPromiseComponent("unregisterTaskAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.notifications.notifications.background.ExpoBackgroundNotificationTasksModule$definition$lambda$2$$inlined$AsyncFunction$4
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        TaskManagerInterface taskManager;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        taskManager = ExpoBackgroundNotificationTasksModule.this.getTaskManager();
                        taskManager.unregisterTask((String) promise, BackgroundRemoteNotificationTaskConsumer.class);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                asyncFunctionComponent2 = new AsyncFunctionComponent("unregisterTaskAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.notifications.notifications.background.ExpoBackgroundNotificationTasksModule$definition$lambda$2$$inlined$AsyncFunction$5
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }))}, new Function1<Object[], Object>() { // from class: expo.modules.notifications.notifications.background.ExpoBackgroundNotificationTasksModule$definition$lambda$2$$inlined$AsyncFunction$6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object[] it) {
                        TaskManagerInterface taskManager;
                        Intrinsics.checkNotNullParameter(it, "it");
                        Object obj = it[0];
                        if (obj != null) {
                            taskManager = ExpoBackgroundNotificationTasksModule.this.getTaskManager();
                            taskManager.unregisterTask((String) obj, BackgroundRemoteNotificationTaskConsumer.class);
                            return Unit.INSTANCE;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                });
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("unregisterTaskAsync", asyncFunctionComponent2);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
