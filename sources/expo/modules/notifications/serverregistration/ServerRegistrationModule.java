package expo.modules.notifications.serverregistration;

import android.content.Context;
import androidx.tracing.Trace;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* compiled from: ServerRegistrationModule.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\t\u001a\u00020\u0014H\u0016R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0015"}, d2 = {"Lexpo/modules/notifications/serverregistration/ServerRegistrationModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "installationId", "Lexpo/modules/notifications/serverregistration/InstallationId;", "getInstallationId", "()Lexpo/modules/notifications/serverregistration/InstallationId;", "installationId$delegate", "Lkotlin/Lazy;", "mRegistrationInfo", "Lexpo/modules/notifications/serverregistration/RegistrationInfo;", "getMRegistrationInfo", "()Lexpo/modules/notifications/serverregistration/RegistrationInfo;", "mRegistrationInfo$delegate", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "", "expo-notifications_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public class ServerRegistrationModule extends Module {

    /* renamed from: installationId$delegate, reason: from kotlin metadata */
    private final Lazy installationId = LazyKt.lazy(new Function0<InstallationId>() { // from class: expo.modules.notifications.serverregistration.ServerRegistrationModule$installationId$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final InstallationId invoke() {
            return new InstallationId(ServerRegistrationModule.this.getContext());
        }
    });

    /* renamed from: mRegistrationInfo$delegate, reason: from kotlin metadata */
    private final Lazy mRegistrationInfo = LazyKt.lazy(new Function0<RegistrationInfo>() { // from class: expo.modules.notifications.serverregistration.ServerRegistrationModule$mRegistrationInfo$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final RegistrationInfo invoke() {
            return new RegistrationInfo(ServerRegistrationModule.this.getContext());
        }
    });

    public final Context getContext() {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.ReactContextLost();
    }

    protected final InstallationId getInstallationId() {
        return (InstallationId) this.installationId.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RegistrationInfo getMRegistrationInfo() {
        return (RegistrationInfo) this.mRegistrationInfo.getValue();
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        AsyncFunctionComponent asyncFunctionComponent;
        ServerRegistrationModule serverRegistrationModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (serverRegistrationModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(serverRegistrationModule);
            moduleDefinitionBuilder.Name("NotificationsServerRegistrationModule");
            AsyncFunctionComponent asyncFunctionComponent2 = new AsyncFunctionComponent("getInstallationIdAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.notifications.serverregistration.ServerRegistrationModule$definition$lambda$2$$inlined$AsyncFunctionWithoutArgs$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return ServerRegistrationModule.this.m1059getInstallationId();
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("getInstallationIdAsync", asyncFunctionComponent2);
            AsyncFunctionComponent asyncFunctionComponent3 = asyncFunctionComponent2;
            AsyncFunctionComponent asyncFunctionComponent4 = new AsyncFunctionComponent("getRegistrationInfoAsync", new AnyType[0], new Function1<Object[], Object>() { // from class: expo.modules.notifications.serverregistration.ServerRegistrationModule$definition$lambda$2$$inlined$AsyncFunctionWithoutArgs$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object[] it) {
                    RegistrationInfo mRegistrationInfo;
                    Intrinsics.checkNotNullParameter(it, "it");
                    mRegistrationInfo = ServerRegistrationModule.this.getMRegistrationInfo();
                    return mRegistrationInfo.get();
                }
            });
            moduleDefinitionBuilder.getAsyncFunctions().put("getRegistrationInfoAsync", asyncFunctionComponent4);
            AsyncFunctionComponent asyncFunctionComponent5 = asyncFunctionComponent4;
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            if (String.class == Promise.class) {
                asyncFunctionComponent = new AsyncFunctionWithPromiseComponent("setRegistrationInfoAsync", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.notifications.serverregistration.ServerRegistrationModule$definition$lambda$2$$inlined$AsyncFunction$1
                    {
                        super(2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        RegistrationInfo mRegistrationInfo;
                        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        mRegistrationInfo = ServerRegistrationModule.this.getMRegistrationInfo();
                        mRegistrationInfo.set((String) promise);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                asyncFunctionComponent = new AsyncFunctionComponent("setRegistrationInfoAsync", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.notifications.serverregistration.ServerRegistrationModule$definition$lambda$2$$inlined$AsyncFunction$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(String.class);
                    }
                }))}, new Function1<Object[], Object>() { // from class: expo.modules.notifications.serverregistration.ServerRegistrationModule$definition$lambda$2$$inlined$AsyncFunction$3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object[] it) {
                        RegistrationInfo mRegistrationInfo;
                        Intrinsics.checkNotNullParameter(it, "it");
                        String str = (String) it[0];
                        mRegistrationInfo = ServerRegistrationModule.this.getMRegistrationInfo();
                        mRegistrationInfo.set(str);
                        return Unit.INSTANCE;
                    }
                });
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put("setRegistrationInfoAsync", asyncFunctionComponent);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* renamed from: getInstallationId, reason: collision with other method in class */
    public String m1059getInstallationId() {
        String orCreateUUID = getInstallationId().getOrCreateUUID();
        Intrinsics.checkNotNullExpressionValue(orCreateUUID, "installationId.orCreateUUID");
        return orCreateUUID;
    }
}
