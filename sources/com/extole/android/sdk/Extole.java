package com.extole.android.sdk;

import android.content.Context;
import android.webkit.WebView;
import com.extole.android.sdk.Action;
import com.extole.android.sdk.impl.ApplicationContext;
import com.extole.android.sdk.impl.gson.ActionDeserializer;
import com.extole.android.sdk.impl.gson.ConditionDeserializer;
import com.iterable.iterableapi.IterableConstants;
import io.sentry.Session;
import io.sentry.protocol.App;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: Extole.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 .2\u00020\u0001:\u0001.JÍ\u0001\u0010\u0002\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\r2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J?\u0010\u0013\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u00160\u00142\u0006\u0010\u0017\u001a\u00020\u00042\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\rH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\bH&J\b\u0010\u001b\u001a\u00020\u001cH&J\b\u0010\u001d\u001a\u00020\u001eH&J5\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\u0011\u001a\u00020\u00042\u0014\b\u0002\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\rH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J5\u0010#\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010$\u001a\u00020\u00042\u0014\b\u0002\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\rH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\b\u0010%\u001a\u00020&H&JC\u0010'\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010(\u001a\u00020\u00042\u0016\b\u0002\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0004H¦@ø\u0001\u0000¢\u0006\u0002\u0010)J<\u0010*\u001a\u00020+2\u0006\u0010*\u001a\u00020,2\u0014\b\u0002\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\r2\u0014\b\u0002\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\rH&\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006/"}, d2 = {"Lcom/extole/android/sdk/Extole;", "", "clone", "programDomain", "", "appName", "sandbox", "context", "Lcom/extole/android/sdk/impl/ApplicationContext;", "newLabels", "", "extendCurrentLabels", "newData", "", "extendCurrentData", "appData", "appHeaders", "identifier", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/extole/android/sdk/impl/ApplicationContext;Ljava/util/Set;Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchZone", "Lkotlin/Pair;", "Lcom/extole/android/sdk/Zone;", "Lcom/extole/android/sdk/Campaign;", "zoneName", "fethZoneData", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getContext", "getLogger", "Lcom/extole/android/sdk/ExtoleLogger;", "getServices", "Lcom/extole/android/sdk/ExtoleServices;", "identify", "Lcom/extole/android/sdk/Id;", "Lcom/extole/android/sdk/Event;", "data", "identifyJwt", "jwt", "logout", "", "sendEvent", IterableConstants.KEY_EVENT_NAME, "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "webView", "Lcom/extole/android/sdk/ExtoleWebView;", "Landroid/webkit/WebView;", "headers", "Companion", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface Extole {
    public static final String ACCESS_TOKEN_PREFERENCES_KEY = "access_token";
    public static final String APP_NAME_KEY = "com.extole.APP_NAME";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String PARTNER_SHARE_ID_PREFERENCES_KEY = "partner_share_id";
    public static final String PROGRAM_DOMAIN_KEY = "com.extole.PROGRAM_DOMAIN";

    Object clone(String str, String str2, String str3, ApplicationContext applicationContext, Set<String> set, Set<String> set2, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, String str4, Continuation<? super Extole> continuation);

    Object fetchZone(String str, Map<String, ? extends Object> map, Continuation<? super Pair<Zone, ? extends Campaign>> continuation) throws RestException;

    ApplicationContext getContext();

    ExtoleLogger getLogger();

    ExtoleServices getServices();

    Object identify(String str, Map<String, String> map, Continuation<? super Id<Event>> continuation) throws RestException;

    Object identifyJwt(String str, Map<String, String> map, Continuation<? super Id<Event>> continuation) throws RestException;

    void logout();

    Object sendEvent(String str, Map<String, ? extends Object> map, String str2, Continuation<? super Id<Event>> continuation) throws RestException;

    ExtoleWebView webView(WebView webView, Map<String, String> headers, Map<String, String> data);

    /* compiled from: Extole.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object fetchZone$default(Extole extole, String str, Map map, Continuation continuation, int i, Object obj) throws RestException {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchZone");
            }
            if ((i & 2) != 0) {
                map = MapsKt.emptyMap();
            }
            return extole.fetchZone(str, map, continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object sendEvent$default(Extole extole, String str, Map map, String str2, Continuation continuation, int i, Object obj) throws RestException {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendEvent");
            }
            if ((i & 2) != 0) {
                map = MapsKt.emptyMap();
            }
            if ((i & 4) != 0) {
                str2 = null;
            }
            return extole.sendEvent(str, map, str2, continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object identify$default(Extole extole, String str, Map map, Continuation continuation, int i, Object obj) throws RestException {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: identify");
            }
            if ((i & 2) != 0) {
                map = MapsKt.emptyMap();
            }
            return extole.identify(str, map, continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Object identifyJwt$default(Extole extole, String str, Map map, Continuation continuation, int i, Object obj) throws RestException {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: identifyJwt");
            }
            if ((i & 2) != 0) {
                map = MapsKt.emptyMap();
            }
            return extole.identifyJwt(str, map, continuation);
        }

        public static /* synthetic */ Object clone$default(Extole extole, String str, String str2, String str3, ApplicationContext applicationContext, Set set, Set set2, Map map, Map map2, Map map3, Map map4, String str4, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                return extole.clone((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : applicationContext, (i & 16) != 0 ? null : set, (i & 32) != 0 ? SetsKt.emptySet() : set2, (i & 64) != 0 ? null : map, (i & 128) != 0 ? MapsKt.emptyMap() : map2, (i & 256) != 0 ? MapsKt.emptyMap() : map3, (i & 512) != 0 ? MapsKt.emptyMap() : map4, (i & 1024) != 0 ? null : str4, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clone");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ExtoleWebView webView$default(Extole extole, WebView webView, Map map, Map map2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: webView");
            }
            if ((i & 2) != 0) {
                map = MapsKt.emptyMap();
            }
            if ((i & 4) != 0) {
                map2 = MapsKt.emptyMap();
            }
            return extole.webView(webView, map, map2);
        }
    }

    /* compiled from: Extole.kt */
    @Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u009d\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0014\b\u0002\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00122\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00122\u0014\b\u0002\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0016\u001a\u00020\u00172L\b\u0002\u0010\u0018\u001aF\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0018\u00010\u00192\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u001e2\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00102\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010%J\u001e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00042\u000e\u0010)\u001a\n\u0012\u0006\b\u0001\u0012\u00020+0*J\u001e\u0010,\u001a\u00020'2\u0006\u0010-\u001a\u00020\u00042\u000e\u0010.\u001a\n\u0012\u0006\b\u0001\u0012\u00020/0*R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u00060"}, d2 = {"Lcom/extole/android/sdk/Extole$Companion;", "", "()V", "ACCESS_TOKEN_PREFERENCES_KEY", "", "APP_NAME_KEY", "PARTNER_SHARE_ID_PREFERENCES_KEY", "PROGRAM_DOMAIN_KEY", Session.JsonKeys.INIT, "Lcom/extole/android/sdk/Extole;", "programDomain", "appName", "sandbox", "context", "Landroid/content/Context;", "labels", "", "data", "", "appData", "appHeaders", "email", "listenToEvents", "", "configurationLoader", "Lkotlin/Function2;", "Lcom/extole/android/sdk/impl/app/App;", "Lkotlin/ParameterName;", "name", App.TYPE, "", "Lcom/extole/android/sdk/Operation;", "additionalProtocolHandlers", "Lcom/extole/android/sdk/ProtocolHandler;", "disabledActions", "Lcom/extole/android/sdk/Action$ActionType;", "jwt", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;ZLkotlin/jvm/functions/Function2;Ljava/util/List;Ljava/util/Set;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerAction", "", "actionType", "action", "Ljava/lang/Class;", "Lcom/extole/android/sdk/Action;", "registerCondition", "conditionType", "condition", "Lcom/extole/android/sdk/Condition;", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String ACCESS_TOKEN_PREFERENCES_KEY = "access_token";
        public static final String APP_NAME_KEY = "com.extole.APP_NAME";
        public static final String PARTNER_SHARE_ID_PREFERENCES_KEY = "partner_share_id";
        public static final String PROGRAM_DOMAIN_KEY = "com.extole.PROGRAM_DOMAIN";

        private Companion() {
        }

        public final void registerAction(String actionType, Class<? extends Action> action) {
            Intrinsics.checkNotNullParameter(actionType, "actionType");
            Intrinsics.checkNotNullParameter(action, "action");
            Map<String, Class<? extends Action>> typeMap = ActionDeserializer.INSTANCE.getTypeMap();
            String upperCase = actionType.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            typeMap.put(upperCase, action);
        }

        public final void registerCondition(String conditionType, Class<? extends Condition> condition) {
            Intrinsics.checkNotNullParameter(conditionType, "conditionType");
            Intrinsics.checkNotNullParameter(condition, "condition");
            Map<String, Class<? extends Condition>> typeMap = ConditionDeserializer.INSTANCE.getTypeMap();
            String upperCase = conditionType.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            typeMap.put(upperCase, condition);
        }

        public final Object init(String str, String str2, String str3, Context context, Set<String> set, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, String str4, boolean z, Function2<? super com.extole.android.sdk.impl.app.App, ? super Map<String, ? extends Object>, ? extends List<? extends Operation>> function2, List<? extends ProtocolHandler> list, Set<? extends Action.ActionType> set2, String str5, Continuation<? super Extole> continuation) {
            return BuildersKt.withContext(Dispatchers.getIO(), new Extole$Companion$init$2(str, str2, str3, context, set, map, map2, map3, str4, z, function2, list, set2, str5, null), continuation);
        }
    }
}
