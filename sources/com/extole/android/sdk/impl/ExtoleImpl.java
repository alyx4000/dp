package com.extole.android.sdk.impl;

import android.webkit.WebView;
import com.amplitude.reactnative.DatabaseConstants;
import com.extole.android.sdk.Action;
import com.extole.android.sdk.CallExtensionKt;
import com.extole.android.sdk.Event;
import com.extole.android.sdk.Extole;
import com.extole.android.sdk.ExtoleLogger;
import com.extole.android.sdk.ExtoleWebView;
import com.extole.android.sdk.Id;
import com.extole.android.sdk.Operation;
import com.extole.android.sdk.ProtocolHandler;
import com.extole.android.sdk.RestException;
import com.extole.android.sdk.SendError;
import com.extole.android.sdk.impl.app.AppEvent;
import com.extole.android.sdk.impl.app.ExtoleServicesImpl;
import com.extole.android.sdk.impl.app.OperationImpl;
import com.extole.android.sdk.impl.app.action.LoadOperationsAction;
import com.extole.android.sdk.impl.app.condition.EventCondition;
import com.extole.android.sdk.impl.http.AuthorizationEndpoints;
import com.extole.webview.ExtoleWebViewImpl;
import com.iterable.iterableapi.IterableConstants;
import io.sentry.SentryEvent;
import io.sentry.protocol.App;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

/* compiled from: ExtoleImpl.kt */
@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 p2\u00020\u0001:\u0001pB\u0085\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012L\b\u0002\u0010\u0015\u001aF\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u000b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u0013\u0018\u00010\u0016\u0012\u000e\b\u0002\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\t\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010 J\b\u0010;\u001a\u00020<H\u0002J\b\u0010=\u001a\u00020<H\u0002J·\u0001\u0010>\u001a\u00020?2\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u000e\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0014\u0010B\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\u0012\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010DJ \u0010E\u001a\u00020<2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u0002J;\u0010F\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020I0G2\u0006\u0010J\u001a\u00020\u00032\u0014\u0010K\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u000bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010LJ\n\u0010M\u001a\u0004\u0018\u00010\u0003H\u0016J\u0006\u0010N\u001a\u00020\u0003J\u0006\u0010O\u001a\u00020\u0003J\b\u0010P\u001a\u00020\u0007H\u0016J\u0014\u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\rH\u0016J\u000e\u0010R\u001a\b\u0012\u0004\u0012\u00020\u001e0\tH\u0016J\u0014\u0010S\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000bH\u0016J\u000e\u0010T\u001a\b\u0012\u0004\u0012\u00020+0*H\u0016J\u000e\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0016J\b\u0010V\u001a\u000204H\u0016J\u000e\u0010W\u001a\b\u0012\u0004\u0012\u00020\u001c0*H\u0016J\b\u0010X\u001a\u00020\u0003H\u0016J\b\u0010Y\u001a\u00020-H\u0016J\b\u0010Z\u001a\u00020:H\u0016J3\u0010[\u001a\b\u0012\u0004\u0012\u00020]0\\2\u0006\u0010\u000f\u001a\u00020\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010LJ3\u0010^\u001a\b\u0012\u0004\u0012\u00020]0\\2\u0006\u0010\u001f\u001a\u00020\u00032\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010LJ \u0010_\u001a\u00020<2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u0002J\b\u0010`\u001a\u00020<H\u0016J\u0011\u0010a\u001a\u00020?H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010bJ?\u0010c\u001a\b\u0012\u0004\u0012\u00020]0\\2\u0006\u0010d\u001a\u00020\u00032\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010eJ\u0012\u0010f\u001a\u00020<2\b\u0010!\u001a\u0004\u0018\u00010\u0003H\u0002J\u0018\u0010g\u001a\u00020<2\u0006\u0010h\u001a\u00020\u00032\u0006\u0010i\u001a\u00020\u0003H\u0002J\u0010\u0010j\u001a\u00020<2\u0006\u00103\u001a\u000204H\u0016J\b\u0010k\u001a\u00020<H\u0002J8\u0010l\u001a\u00020m2\u0006\u0010l\u001a\u00020n2\u0012\u0010o\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000bH\u0016R\u0010\u0010!\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*X\u0082\u000e¢\u0006\u0002\n\u0000RR\u0010\u0015\u001aF\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001b0\u000b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u0013\u0018\u00010\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010(R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010(R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020\u001c0*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010(R\u000e\u00107\u001a\u000208X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006q"}, d2 = {"Lcom/extole/android/sdk/impl/ExtoleImpl;", "Lcom/extole/android/sdk/impl/ExtoleInternal;", "programDomain", "", "appName", "sandbox", "context", "Lcom/extole/android/sdk/impl/ApplicationContext;", "labels", "", "data", "", "appData", "", "appHeaders", "identifier", "listenToEvents", "", "additionalProtocolHandlers", "", "Lcom/extole/android/sdk/ProtocolHandler;", "configurationLoader", "Lkotlin/Function2;", "Lcom/extole/android/sdk/impl/app/App;", "Lkotlin/ParameterName;", "name", App.TYPE, "", "Lcom/extole/android/sdk/Operation;", "disabledActions", "Lcom/extole/android/sdk/Action$ActionType;", "jwt", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/extole/android/sdk/impl/ApplicationContext;Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;ZLjava/util/List;Lkotlin/jvm/functions/Function2;Ljava/util/Set;Ljava/lang/String;)V", "accessToken", "getAdditionalProtocolHandlers", "()Ljava/util/List;", "getAppData", "()Ljava/util/Map;", "getAppHeaders", "getAppName", "()Ljava/lang/String;", "configuration", "", "Lorg/json/JSONObject;", "extoleServices", "Lcom/extole/android/sdk/impl/app/ExtoleServicesImpl;", "flowController", "getIdentifier", "getJwt", "getListenToEvents", "()Z", SentryEvent.JsonKeys.LOGGER, "Lcom/extole/android/sdk/ExtoleLogger;", "operations", "getSandbox", "tokenApi", "Lcom/extole/android/sdk/impl/http/AuthorizationEndpoints;", "zonesResponse", "Lcom/extole/android/sdk/impl/Zones;", "clearAccessToken", "", "clearZonesCache", "clone", "Lcom/extole/android/sdk/Extole;", "newLabels", "extendCurrentLabels", "newData", "extendCurrentData", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/extole/android/sdk/impl/ApplicationContext;Ljava/util/Set;Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createAccessToken", "fetchZone", "Lkotlin/Pair;", "Lcom/extole/android/sdk/Zone;", "Lcom/extole/android/sdk/Campaign;", "zoneName", "fethZoneData", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAccessToken", "getApplicationSignature", "getApplicationVersion", "getContext", "getData", "getDisabledActions", "getHeaders", "getJsonConfiguration", "getLabels", "getLogger", "getOperations", "getProgramDomain", "getServices", "getZonesResponse", ExtoleImpl.IDENTIFY_EVENT_NAME, "Lcom/extole/android/sdk/Id;", "Lcom/extole/android/sdk/Event;", "identifyJwt", "initApiClient", "logout", "refresh", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendEvent", IterableConstants.KEY_EVENT_NAME, "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAccessToken", "setCache", DatabaseConstants.KEY_FIELD, "value", "setLogger", "subscribe", "webView", "Lcom/extole/android/sdk/ExtoleWebView;", "Landroid/webkit/WebView;", "headers", "Companion", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ExtoleImpl implements ExtoleInternal {
    private static final String ACCESS_TOKEN = "access_token";
    private static final String ACCESS_TOKEN_CHANGED_EVENT_NAME = "access_token_changed";
    private static final String ACCESS_TOKEN_HEADER_NAME = "x-extole-token";
    private static final String APP_HEADER = "X-Extole-App";
    private static final String APP_SHA_HEADER = "X-Extole-App-Sha";
    private static final String APP_TYPE_HEADER = "X-Extole-App-Type";
    private static final String APP_VERSION_HEADER = "X-Extole-App-Version";
    private static final String FLOW_CONFIGURATION_ZONE = "mobile_bootstrap";
    private static final String IDENTIFY_EVENT_NAME = "identify";
    private static final String SANDBOX_HEADER = "X-Extole-Sandbox";
    private static final String USER_AGENT_HEADER = "User-Agent";
    private String accessToken;
    private final List<ProtocolHandler> additionalProtocolHandlers;
    private final Map<String, String> appData;
    private final Map<String, String> appHeaders;
    private final String appName;
    private List<JSONObject> configuration;
    private final Function2<com.extole.android.sdk.impl.app.App, Map<String, ? extends Object>, List<Operation>> configurationLoader;
    private final ApplicationContext context;
    private final Map<String, String> data;
    private final Set<Action.ActionType> disabledActions;
    private ExtoleServicesImpl extoleServices;
    private final com.extole.android.sdk.impl.app.App flowController;
    private final String identifier;
    private final String jwt;
    private final Set<String> labels;
    private final boolean listenToEvents;
    private ExtoleLogger logger;
    private List<Operation> operations;
    private final String programDomain;
    private final String sandbox;
    private AuthorizationEndpoints tokenApi;
    private Zones zonesResponse;

    /* JADX WARN: Multi-variable type inference failed */
    public ExtoleImpl(String programDomain, String appName, String sandbox, ApplicationContext context, Set<String> labels, Map<String, String> data, Map<String, String> appData, Map<String, String> appHeaders, String str, boolean z, List<? extends ProtocolHandler> additionalProtocolHandlers, Function2<? super com.extole.android.sdk.impl.app.App, ? super Map<String, ? extends Object>, ? extends List<? extends Operation>> function2, Set<? extends Action.ActionType> disabledActions, String str2) {
        Intrinsics.checkNotNullParameter(programDomain, "programDomain");
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(sandbox, "sandbox");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(labels, "labels");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(appData, "appData");
        Intrinsics.checkNotNullParameter(appHeaders, "appHeaders");
        Intrinsics.checkNotNullParameter(additionalProtocolHandlers, "additionalProtocolHandlers");
        Intrinsics.checkNotNullParameter(disabledActions, "disabledActions");
        this.programDomain = programDomain;
        this.appName = appName;
        this.sandbox = sandbox;
        this.context = context;
        this.labels = labels;
        this.data = data;
        this.appData = appData;
        this.appHeaders = appHeaders;
        this.identifier = str;
        this.listenToEvents = z;
        this.additionalProtocolHandlers = additionalProtocolHandlers;
        this.configurationLoader = function2;
        this.disabledActions = disabledActions;
        this.jwt = str2;
        this.operations = new ArrayList();
        this.configuration = new ArrayList();
        this.zonesResponse = new Zones(new LinkedHashMap());
        this.flowController = com.extole.android.sdk.impl.app.App.INSTANCE;
        this.logger = new ExtoleLoggerImpl(null, 1, 0 == true ? 1 : 0);
        appData.put("appName", appName);
        initApiClient(str, str2);
        if (z) {
            subscribe();
        }
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getSandbox() {
        return this.sandbox;
    }

    public /* synthetic */ ExtoleImpl(String str, String str2, String str3, ApplicationContext applicationContext, Set set, Map map, Map map2, Map map3, String str4, boolean z, List list, Function2 function2, Set set2, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, applicationContext, (i & 16) != 0 ? new LinkedHashSet() : set, (i & 32) != 0 ? MapsKt.emptyMap() : map, (i & 64) != 0 ? new LinkedHashMap() : map2, (i & 128) != 0 ? new LinkedHashMap() : map3, (i & 256) != 0 ? null : str4, (i & 512) != 0 ? true : z, list, (i & 2048) != 0 ? null : function2, (i & 4096) != 0 ? SetsKt.emptySet() : set2, (i & 8192) != 0 ? null : str5);
    }

    public final Map<String, String> getAppData() {
        return this.appData;
    }

    public final Map<String, String> getAppHeaders() {
        return this.appHeaders;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final boolean getListenToEvents() {
        return this.listenToEvents;
    }

    public final List<ProtocolHandler> getAdditionalProtocolHandlers() {
        return this.additionalProtocolHandlers;
    }

    public final String getJwt() {
        return this.jwt;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.extole.android.sdk.Extole
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object fetchZone(java.lang.String r7, java.util.Map<java.lang.String, ? extends java.lang.Object> r8, kotlin.coroutines.Continuation<? super kotlin.Pair<com.extole.android.sdk.Zone, ? extends com.extole.android.sdk.Campaign>> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.extole.android.sdk.impl.ExtoleImpl$fetchZone$1
            if (r0 == 0) goto L14
            r0 = r9
            com.extole.android.sdk.impl.ExtoleImpl$fetchZone$1 r0 = (com.extole.android.sdk.impl.ExtoleImpl$fetchZone$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            com.extole.android.sdk.impl.ExtoleImpl$fetchZone$1 r0 = new com.extole.android.sdk.impl.ExtoleImpl$fetchZone$1
            r0.<init>(r6, r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3b
            if (r2 != r4) goto L33
            java.lang.Object r7 = r0.L$1
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r0.L$0
            com.extole.android.sdk.impl.ExtoleImpl r8 = (com.extole.android.sdk.impl.ExtoleImpl) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L83
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3b:
            kotlin.ResultKt.throwOnFailure(r9)
            java.util.LinkedHashMap r9 = new java.util.LinkedHashMap
            r9.<init>()
            java.util.Map r9 = (java.util.Map) r9
            r9.putAll(r8)
            java.util.Map<java.lang.String, java.lang.String> r2 = r6.data
            r9.putAll(r2)
            org.greenrobot.eventbus.EventBus r9 = org.greenrobot.eventbus.EventBus.getDefault()
            com.extole.android.sdk.impl.app.AppEvent r2 = new com.extole.android.sdk.impl.app.AppEvent
            r2.<init>(r7, r8)
            r9.post(r2)
            com.extole.android.sdk.impl.Zones r9 = r6.zonesResponse
            com.extole.android.sdk.Zone r9 = r9.get(r7)
            if (r9 != 0) goto Lb8
            com.extole.android.sdk.impl.app.ExtoleServicesImpl r9 = r6.extoleServices
            if (r9 != 0) goto L6b
            java.lang.String r9 = "extoleServices"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
            r9 = r3
        L6b:
            com.extole.android.sdk.ZoneService r9 = r9.getZoneService()
            java.util.Set r2 = kotlin.collections.SetsKt.setOf(r7)
            java.util.Set<java.lang.String> r5 = r6.labels
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r9 = r9.getZones(r2, r8, r5, r0)
            if (r9 != r1) goto L82
            return r1
        L82:
            r8 = r6
        L83:
            com.extole.android.sdk.impl.Zones r9 = (com.extole.android.sdk.impl.Zones) r9
            java.util.Map r9 = r9.getAll()
            java.util.Set r9 = r9.entrySet()
            java.util.Iterator r9 = r9.iterator()
        L91:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto Lb1
            java.lang.Object r0 = r9.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getValue()
            com.extole.android.sdk.Zone r1 = (com.extole.android.sdk.Zone) r1
            if (r1 == 0) goto L91
            com.extole.android.sdk.impl.Zones r2 = r8.zonesResponse
            java.lang.Object r0 = r0.getKey()
            com.extole.android.sdk.impl.ZoneResponseKey r0 = (com.extole.android.sdk.impl.ZoneResponseKey) r0
            r2.add(r0, r1)
            goto L91
        Lb1:
            com.extole.android.sdk.impl.Zones r9 = r8.zonesResponse
            com.extole.android.sdk.Zone r9 = r9.get(r7)
            goto Lb9
        Lb8:
            r8 = r6
        Lb9:
            com.extole.android.sdk.impl.CampaignImpl r7 = new com.extole.android.sdk.impl.CampaignImpl
            if (r9 == 0) goto Lc1
            com.extole.android.sdk.Id r3 = r9.getCampaignId()
        Lc1:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r7.<init>(r3, r9, r8)
            com.extole.android.sdk.Campaign r7 = (com.extole.android.sdk.Campaign) r7
            kotlin.Pair r8 = new kotlin.Pair
            r8.<init>(r9, r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.extole.android.sdk.impl.ExtoleImpl.fetchZone(java.lang.String, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.extole.android.sdk.Extole
    public ExtoleLogger getLogger() {
        return this.logger;
    }

    @Override // com.extole.android.sdk.Extole
    public ApplicationContext getContext() {
        return this.context;
    }

    @Override // com.extole.android.sdk.Extole
    public Object sendEvent(String str, Map<String, ? extends Object> map, String str2, Continuation<? super Id<Event>> continuation) {
        EventBus.getDefault().post(new AppEvent(str, map));
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.putAll(map);
            linkedHashMap.put("labels", CollectionsKt.joinToString$default(this.labels, ",", null, null, 0, null, null, 62, null));
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            linkedHashMap2.put("event_name", str);
            linkedHashMap2.put("data", linkedHashMap);
            if (str2 != null) {
                linkedHashMap2.put("jwt", str2);
            }
            ExtoleServicesImpl extoleServicesImpl = this.extoleServices;
            if (extoleServicesImpl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("extoleServices");
                extoleServicesImpl = null;
            }
            ResponseEntity<JSONObject> post = extoleServicesImpl.getEventsEndpoints().post(linkedHashMap2);
            Set<Map.Entry<String, Collection<String>>> entrySet = post.getHeaders().entrySet();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = entrySet.iterator();
            while (true) {
                boolean z = true;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((Map.Entry) next).getKey() == null) {
                    z = false;
                }
                if (z) {
                    arrayList.add(next);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                String lowerCase = ((String) ((Map.Entry) obj).getKey()).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                if (Intrinsics.areEqual(lowerCase, ACCESS_TOKEN_HEADER_NAME)) {
                    arrayList2.add(obj);
                }
            }
            ArrayList arrayList3 = arrayList2;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                arrayList4.add((Collection) ((Map.Entry) it2.next()).getValue());
            }
            String str3 = (String) CollectionsKt.first(CollectionsKt.flatten(arrayList4));
            if ((!StringsKt.isBlank(str3)) && !Intrinsics.areEqual(str3, this.accessToken)) {
                clearZonesCache();
                setAccessToken(str3);
                EventBus.getDefault().post(new AppEvent(ACCESS_TOKEN_CHANGED_EVENT_NAME, null, 2, null));
            }
            return new Id(post.getEntity().getString("id"));
        } catch (RestException e) {
            this.logger.error(e, "Unable to send event=" + str + ", data=" + map + ", labels=" + this.labels + ", programDomain=" + this.programDomain, new Object[0]);
            throw new SendError(e.getUniqueId(), e.getErrorCode(), e.getHttpStatusCode(), e.getMessage(), e.getParameters());
        }
    }

    @Override // com.extole.android.sdk.Extole
    public void logout() {
        clearAccessToken();
        clearZonesCache();
        createAccessToken$default(this, null, null, 3, null);
    }

    @Override // com.extole.android.sdk.Extole
    public Object identify(String str, Map<String, String> map, Continuation<? super Id<Event>> continuation) {
        Map mutableMap = MapsKt.toMutableMap(map);
        mutableMap.put("email", str);
        return Extole.DefaultImpls.sendEvent$default(this, IDENTIFY_EVENT_NAME, mutableMap, null, continuation, 4, null);
    }

    @Override // com.extole.android.sdk.Extole
    public Object identifyJwt(String str, Map<String, String> map, Continuation<? super Id<Event>> continuation) {
        return sendEvent(IDENTIFY_EVENT_NAME, map, str, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    @Override // com.extole.android.sdk.Extole
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object clone(java.lang.String r24, java.lang.String r25, java.lang.String r26, com.extole.android.sdk.impl.ApplicationContext r27, java.util.Set<java.lang.String> r28, java.util.Set<java.lang.String> r29, java.util.Map<java.lang.String, java.lang.String> r30, java.util.Map<java.lang.String, java.lang.String> r31, java.util.Map<java.lang.String, java.lang.String> r32, java.util.Map<java.lang.String, java.lang.String> r33, java.lang.String r34, kotlin.coroutines.Continuation<? super com.extole.android.sdk.Extole> r35) {
        /*
            Method dump skipped, instructions count: 207
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.extole.android.sdk.impl.ExtoleImpl.clone(java.lang.String, java.lang.String, java.lang.String, com.extole.android.sdk.impl.ApplicationContext, java.util.Set, java.util.Set, java.util.Map, java.util.Map, java.util.Map, java.util.Map, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.extole.android.sdk.Extole
    public ExtoleWebView webView(WebView webView, Map<String, String> headers, Map<String, String> data) {
        Intrinsics.checkNotNullParameter(webView, "webView");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(data, "data");
        this.context.getPersistence().put("partner_share_id", CallExtensionKt.randomAlphaNumericString$default(0, 1, null));
        Map mutableMap = MapsKt.toMutableMap(headers);
        mutableMap.put("Authorization", IterableConstants.HEADER_SDK_AUTH_FORMAT + this.accessToken);
        Map mutableMap2 = MapsKt.toMutableMap(data);
        mutableMap2.putAll(this.data);
        mutableMap2.putAll(this.appData);
        return new ExtoleWebViewImpl(this.programDomain, webView, this.context, this, mutableMap, mutableMap2, this.additionalProtocolHandlers);
    }

    public final Object refresh(Continuation<? super Extole> continuation) {
        return CoroutineScopeKt.coroutineScope(new ExtoleImpl$refresh$2(this, null), continuation);
    }

    private final void setCache(String key, String value) {
        this.context.getPersistence().put(key, value);
    }

    static /* synthetic */ void initApiClient$default(ExtoleImpl extoleImpl, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        extoleImpl.initApiClient(str, str2);
    }

    private final void initApiClient(String identifier, String jwt) {
        ExtoleLogger.INSTANCE.builder().build().debug("Initialized Extole for programDomain=" + this.programDomain, new Object[0]);
        this.accessToken = this.context.getPersistence().get("access_token");
        AuthorizationEndpoints authorizationEndpoints = new AuthorizationEndpoints(this.programDomain, this.accessToken, getHeaders());
        this.tokenApi = authorizationEndpoints;
        try {
        } catch (RestException unused) {
            createAccessToken$default(this, null, null, 3, null);
        }
        if (this.accessToken != null && identifier == null) {
            authorizationEndpoints.getTokenDetails(MapsKt.mapOf(TuplesKt.to("access_token", this.accessToken)));
            this.extoleServices = new ExtoleServicesImpl(this);
            ExtoleLogger.INSTANCE.builder().withProgramDomain(this.programDomain).withAccessToken(this.accessToken).build().debug("Access Token initialized: " + this.accessToken, new Object[0]);
        }
        createAccessToken(identifier, jwt);
        this.extoleServices = new ExtoleServicesImpl(this);
        ExtoleLogger.INSTANCE.builder().withProgramDomain(this.programDomain).withAccessToken(this.accessToken).build().debug("Access Token initialized: " + this.accessToken, new Object[0]);
    }

    static /* synthetic */ void createAccessToken$default(ExtoleImpl extoleImpl, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        extoleImpl.createAccessToken(str, str2);
    }

    private final void createAccessToken(String identifier, String jwt) {
        AuthorizationEndpoints authorizationEndpoints = this.tokenApi;
        if (authorizationEndpoints == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tokenApi");
            authorizationEndpoints = null;
        }
        setAccessToken(authorizationEndpoints.createToken(identifier, jwt).getEntity().getString("access_token"));
    }

    private final void setAccessToken(String accessToken) {
        if (accessToken != null) {
            this.accessToken = accessToken;
            setCache("access_token", accessToken);
        }
    }

    private final void clearAccessToken() {
        setAccessToken("");
    }

    private final void clearZonesCache() {
        this.zonesResponse = new Zones(new LinkedHashMap());
    }

    private final void subscribe() {
        Function2<com.extole.android.sdk.impl.app.App, Map<String, ? extends Object>, List<Operation>> function2 = this.configurationLoader;
        if (function2 != null) {
            this.operations.addAll(function2.invoke(com.extole.android.sdk.impl.app.App.INSTANCE, MapsKt.emptyMap()));
        }
        int i = 2;
        Map map = null;
        byte b = 0;
        if (this.configurationLoader == null) {
            this.operations.add(new OperationImpl(CollectionsKt.listOf(new EventCondition(CollectionsKt.listOf("app_initialized"), null, null, 6, null)), CollectionsKt.listOf(new LoadOperationsAction(CollectionsKt.listOf(FLOW_CONFIGURATION_ZONE), map, i, b == true ? 1 : 0))));
        }
        com.extole.android.sdk.impl.app.App.INSTANCE.setExtole(this);
        if (!EventBus.getDefault().isRegistered(this.flowController)) {
            EventBus.getDefault().register(this.flowController);
        }
        EventBus.getDefault().post(new AppEvent("app_initialized", null, 2, null));
    }

    @Override // com.extole.android.sdk.impl.ExtoleInternal
    public void setLogger(ExtoleLogger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.logger = logger;
    }

    @Override // com.extole.android.sdk.Extole
    public ExtoleServicesImpl getServices() {
        return new ExtoleServicesImpl(this);
    }

    @Override // com.extole.android.sdk.impl.ExtoleInternal
    public Map<String, String> getHeaders() {
        Map<String, String> mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to(SANDBOX_HEADER, this.sandbox), TuplesKt.to("User-Agent", "Extole Android SDK/1.0"), TuplesKt.to(APP_HEADER, this.appName), TuplesKt.to(APP_VERSION_HEADER, getApplicationVersion()), TuplesKt.to(APP_TYPE_HEADER, "mobile_sdk_android"), TuplesKt.to(APP_SHA_HEADER, getApplicationSignature()));
        mutableMapOf.putAll(this.appHeaders);
        return mutableMapOf;
    }

    public final String getApplicationVersion() {
        String str = this.context.getContext().getPackageManager().getPackageInfo(this.context.getContext().getPackageName(), 0).versionName;
        return str == null ? "" : str;
    }

    public final String getApplicationSignature() {
        String str = this.context.getContext().getPackageManager().getPackageInfo(this.context.getContext().getPackageName(), 134217728).packageName;
        Intrinsics.checkNotNullExpressionValue(str, "info.packageName");
        return str;
    }

    @Override // com.extole.android.sdk.impl.ExtoleInternal
    public Set<String> getLabels() {
        return this.labels;
    }

    @Override // com.extole.android.sdk.impl.ExtoleInternal
    public Map<String, String> getData() {
        return this.appData;
    }

    @Override // com.extole.android.sdk.impl.ExtoleInternal
    public String getProgramDomain() {
        return this.programDomain;
    }

    @Override // com.extole.android.sdk.impl.ExtoleInternal
    public String getAccessToken() {
        return this.accessToken;
    }

    @Override // com.extole.android.sdk.impl.ExtoleInternal
    public Zones getZonesResponse() {
        return this.zonesResponse;
    }

    @Override // com.extole.android.sdk.impl.ExtoleInternal
    public List<Operation> getOperations() {
        return this.operations;
    }

    @Override // com.extole.android.sdk.impl.ExtoleInternal
    public List<JSONObject> getJsonConfiguration() {
        return this.configuration;
    }

    @Override // com.extole.android.sdk.impl.ExtoleInternal
    public Set<Action.ActionType> getDisabledActions() {
        return this.disabledActions;
    }
}
