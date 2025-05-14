package com.extole.android.sdk.impl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import com.extole.android.sdk.Action;
import com.extole.android.sdk.Extole;
import com.extole.android.sdk.ExtoleLogger;
import com.extole.android.sdk.ExtoleSdkException;
import com.extole.android.sdk.Operation;
import com.extole.android.sdk.ProtocolHandler;
import io.sentry.SentryEvent;
import io.sentry.Session;
import io.sentry.protocol.App;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: ExtoleInternal.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005H&J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u0014\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\nH&J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH&J\u000e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007H&J\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\fH&J\b\u0010\u0011\u001a\u00020\u0003H&J\b\u0010\u0012\u001a\u00020\u0013H&J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H&¨\u0006\u0019"}, d2 = {"Lcom/extole/android/sdk/impl/ExtoleInternal;", "Lcom/extole/android/sdk/Extole;", "getAccessToken", "", "getData", "", "getDisabledActions", "", "Lcom/extole/android/sdk/Action$ActionType;", "getHeaders", "", "getJsonConfiguration", "", "Lorg/json/JSONObject;", "getLabels", "getOperations", "Lcom/extole/android/sdk/Operation;", "getProgramDomain", "getZonesResponse", "Lcom/extole/android/sdk/impl/Zones;", "setLogger", "", SentryEvent.JsonKeys.LOGGER, "Lcom/extole/android/sdk/ExtoleLogger;", "Companion", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface ExtoleInternal extends Extole {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    String getAccessToken();

    Map<String, String> getData();

    Set<Action.ActionType> getDisabledActions();

    Map<String, String> getHeaders();

    List<JSONObject> getJsonConfiguration();

    Set<String> getLabels();

    List<Operation> getOperations();

    String getProgramDomain();

    Zones getZonesResponse();

    void setLogger(ExtoleLogger logger);

    /* compiled from: ExtoleInternal.kt */
    @Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0092\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00112\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00112\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00112\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0015\u001a\u00020\u00162L\b\u0002\u0010\u0017\u001aF\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d\u0018\u00010\u00182\u000e\b\u0002\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u001d2\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u000f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0004¨\u0006$"}, d2 = {"Lcom/extole/android/sdk/impl/ExtoleInternal$Companion;", "", "()V", "getAppName", "", "context", "Lcom/extole/android/sdk/impl/ApplicationContext;", "getProgramDomain", Session.JsonKeys.INIT, "Lcom/extole/android/sdk/impl/ExtoleInternal;", "programDomain", "appName", "sandbox", "Landroid/content/Context;", "labels", "", "data", "", "appData", "appHeaders", "identifier", "listenToEvents", "", "configurationLoader", "Lkotlin/Function2;", "Lcom/extole/android/sdk/impl/app/App;", "Lkotlin/ParameterName;", "name", App.TYPE, "", "Lcom/extole/android/sdk/Operation;", "additionalProtocolHandlers", "Lcom/extole/android/sdk/ProtocolHandler;", "disabledActions", "Lcom/extole/android/sdk/Action$ActionType;", "jwt", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final ExtoleInternal init(String programDomain, String appName, String sandbox, Context context, Set<String> labels, Map<String, String> data, Map<String, String> appData, Map<String, String> appHeaders, String identifier, boolean listenToEvents, Function2<? super com.extole.android.sdk.impl.app.App, ? super Map<String, ? extends Object>, ? extends List<? extends Operation>> configurationLoader, List<? extends ProtocolHandler> additionalProtocolHandlers, Set<? extends Action.ActionType> disabledActions, String jwt) {
            Intrinsics.checkNotNullParameter(sandbox, "sandbox");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(labels, "labels");
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(appData, "appData");
            Intrinsics.checkNotNullParameter(appHeaders, "appHeaders");
            Intrinsics.checkNotNullParameter(additionalProtocolHandlers, "additionalProtocolHandlers");
            Intrinsics.checkNotNullParameter(disabledActions, "disabledActions");
            ApplicationContext applicationContext = new ApplicationContext(context, new SharedPreferencesPersistence(context));
            return new ExtoleImpl(programDomain == null ? getProgramDomain(applicationContext) : programDomain, appName == null ? getAppName(applicationContext) : appName, sandbox, applicationContext, labels, MapsKt.toMutableMap(data), MapsKt.toMutableMap(appData), MapsKt.toMutableMap(appHeaders), identifier, listenToEvents, additionalProtocolHandlers, configurationLoader, disabledActions, jwt);
        }

        private final String getAppName(ApplicationContext context) {
            Bundle bundle;
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String string = (applicationInfo == null || (bundle = applicationInfo.metaData) == null) ? null : bundle.getString("com.extole.APP_NAME");
            String str = string;
            if (str == null || str.length() == 0) {
                throw new ExtoleSdkException("Application name is not declared");
            }
            return string;
        }

        private final String getProgramDomain(ApplicationContext context) {
            Bundle bundle;
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String string = (applicationInfo == null || (bundle = applicationInfo.metaData) == null) ? null : bundle.getString("com.extole.PROGRAM_DOMAIN");
            String str = string;
            if (str == null || str.length() == 0) {
                throw new ExtoleSdkException("Program domain is not declared");
            }
            return string;
        }
    }
}
