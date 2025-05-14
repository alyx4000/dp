package sdk.pendo.io.e9;

import io.sentry.protocol.Device;
import io.sentry.protocol.Response;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;
import sdk.pendo.io.PendoInternal;
import sdk.pendo.io.actions.ActivationManager;
import sdk.pendo.io.c8.f;
import sdk.pendo.io.c8.h;
import sdk.pendo.io.d6.e;
import sdk.pendo.io.g9.g;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.models.GlobalEventProperties;
import sdk.pendo.io.network.interfaces.GetAuthToken;
import sdk.pendo.io.utilities.AndroidUtils;
import sdk.pendo.io.x5.j;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0007H\u0002J \u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0007H\u0002J\u0006\u0010\u000b\u001a\u00020\u0004J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00022\b\u0010\r\u001a\u0004\u0018\u00010\u0002J\u0016\u0010\b\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\u000fJ\u0012\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R\u0017\u0010\u0019\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\b\u0010\u0018R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u001e¨\u0006\""}, d2 = {"Lsdk/pendo/io/e9/a;", "Lsdk/pendo/io/p8/b;", "Lorg/json/JSONObject;", "event", "", "b", "json", "", "a", "screenData", "screenId", "d", "currentScreenData", "previousScreenData", "viewElementInfo", "", "isTriggeredByCode", "trackEventJSON", "c", "Lsdk/pendo/io/network/interfaces/GetAuthToken$GetAuthTokenResponse;", Response.TYPE, "onGetAccessTokenResponseReceived", "Lsdk/pendo/io/models/GlobalEventProperties;", "Lsdk/pendo/io/models/GlobalEventProperties;", "()Lsdk/pendo/io/models/GlobalEventProperties;", "globalEventProperties", "Lsdk/pendo/io/b6/b;", "Lsdk/pendo/io/b6/b;", "screenChangedSubscription", "Lsdk/pendo/io/f9/f;", "()Lsdk/pendo/io/f9/f;", "screenManager", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class a implements sdk.pendo.io.p8.b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f1035a;

    /* renamed from: b, reason: from kotlin metadata */
    private static final GlobalEventProperties globalEventProperties;

    /* renamed from: c, reason: from kotlin metadata */
    private static final sdk.pendo.io.b6.b screenChangedSubscription;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/String;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0})
    /* renamed from: sdk.pendo.io.e9.a$a, reason: collision with other inner class name */
    static final class C0123a extends Lambda implements Function1<String, Boolean> {
        public static final C0123a f = new C0123a();

        C0123a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(String str) {
            return Boolean.valueOf(a.f1035a.c());
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 9, 0})
    static final class b extends Lambda implements Function1<String, Unit> {
        public static final b f = new b();

        b() {
            super(1);
        }

        public final void a(String str) {
            a aVar = a.f1035a;
            JSONObject n = aVar.b().n();
            JSONObject jSONObject = n != null ? new JSONObject(n.toString()) : null;
            JSONObject p = aVar.b().p();
            aVar.a(jSONObject, p != null ? new JSONObject(p.toString()) : null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            a(str);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0003\u001a\u00020\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "kotlin.jvm.PlatformType", "isInitiated", "a", "(Ljava/lang/Boolean;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0})
    static final class c extends Lambda implements Function1<Boolean, Boolean> {
        public static final c f = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Boolean bool) {
            Intrinsics.checkNotNull(bool);
            return bool;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/lang/Object;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 9, 0})
    static final class d extends Lambda implements Function1<Object, Unit> {
        final /* synthetic */ JSONObject f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(JSONObject jSONObject) {
            super(1);
            this.f = jSONObject;
        }

        public final void a(Object obj) {
            f.e().d().onNext(this.f);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            a(obj);
            return Unit.INSTANCE;
        }
    }

    static {
        sdk.pendo.io.b6.b bVar;
        j<String> a2;
        a aVar = new a();
        f1035a = aVar;
        globalEventProperties = new GlobalEventProperties();
        j<String> r = aVar.b().r();
        if (r != null && (a2 = r.a(sdk.pendo.io.v6.a.b())) != null) {
            final C0123a c0123a = C0123a.f;
            j<String> a3 = a2.a(new sdk.pendo.io.d6.j() { // from class: sdk.pendo.io.e9.a$$ExternalSyntheticLambda0
                @Override // sdk.pendo.io.d6.j
                public final boolean test(Object obj) {
                    boolean a4;
                    a4 = a.a(Function1.this, obj);
                    return a4;
                }
            });
            if (a3 != null) {
                final b bVar2 = b.f;
                bVar = a3.a(new e() { // from class: sdk.pendo.io.e9.a$$ExternalSyntheticLambda1
                    @Override // sdk.pendo.io.d6.e
                    public final void accept(Object obj) {
                        a.b(Function1.this, obj);
                    }
                }, new sdk.pendo.io.a9.a("ScreenManager, screenChangedSubscription"));
                screenChangedSubscription = bVar;
                aVar.b().m();
            }
        }
        bVar = null;
        screenChangedSubscription = bVar;
        aVar.b().m();
    }

    private a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final boolean c() {
        return PendoInternal.p() && !sdk.pendo.io.y8.a.d().h();
    }

    public final void d() {
    }

    @Override // sdk.pendo.io.p8.b
    public void onGetAccessTokenResponseReceived(GetAuthToken.GetAuthTokenResponse response) {
        Map<String, List<String>> promotedMetadataFields;
        if (response == null || (promotedMetadataFields = response.getPromotedMetadataFields()) == null) {
            return;
        }
        globalEventProperties.setPromotedMetadataKeys(promotedMetadataFields, PendoInternal.y());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final sdk.pendo.io.f9.f b() {
        sdk.pendo.io.f9.f x = PendoInternal.x();
        Intrinsics.checkNotNullExpressionValue(x, "getScreenManager(...)");
        return x;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final synchronized JSONObject a(JSONObject screenData, String screenId, String event) {
        JSONObject put;
        put = a(new JSONObject(), event).put("id", screenId).put("data", new JSONObject().put(ActivationManager.SCREEN_DATA_KEY, screenData));
        Intrinsics.checkNotNullExpressionValue(put, "put(...)");
        return put;
    }

    private final void b(final JSONObject event) {
        ActivationManager activationManager = ActivationManager.INSTANCE;
        if (activationManager.isInited()) {
            f.e().d().onNext(event);
            return;
        }
        sdk.pendo.io.w6.a<Boolean> isInitedObservable = activationManager.isInitedObservable();
        final c cVar = c.f;
        isInitedObservable.a(new sdk.pendo.io.d6.j() { // from class: sdk.pendo.io.e9.a$$ExternalSyntheticLambda3
            @Override // sdk.pendo.io.d6.j
            public final boolean test(Object obj) {
                boolean c2;
                c2 = a.c(Function1.this, obj);
                return c2;
            }
        }).f().b(sdk.pendo.io.v6.a.d()).a(sdk.pendo.io.v6.a.d()).a(sdk.pendo.io.d9.b.a(new e() { // from class: sdk.pendo.io.e9.a$$ExternalSyntheticLambda4
            @Override // sdk.pendo.io.d6.e
            public final void accept(Object obj) {
                a.a(event, (Boolean) obj);
            }
        }, "Observer for handleScreenViewEvent prior to ActivationManager being initialised"));
    }

    public final GlobalEventProperties a() {
        return globalEventProperties;
    }

    public final synchronized void a(JSONObject viewElementInfo, boolean isTriggeredByCode) {
        Intrinsics.checkNotNullParameter(viewElementInfo, "viewElementInfo");
        if (c()) {
            JSONObject n = b().n();
            if (n == null || !n.has("retroactiveScreenId")) {
                PendoLogger.w("AnalyticsManager", "handleClickEvent, currentScreenData is null or there is no currentScreenIDd within");
            } else {
                JSONObject a2 = a(n, n.get("retroactiveScreenId").toString(), "RAClick");
                viewElementInfo.put("triggeredByCode", isTriggeredByCode);
                JSONObject jSONObject = a2.getJSONObject("data");
                jSONObject.put("retroElementInfo", viewElementInfo);
                a2.put("data", jSONObject);
                f.e().d().onNext(a2);
            }
        }
    }

    public final synchronized void a(JSONObject currentScreenData, JSONObject previousScreenData) {
        String str = "";
        String str2 = "";
        if (previousScreenData != null) {
            if (previousScreenData.has("retroactiveScreenId")) {
                if (previousScreenData.get("retroactiveScreenId").toString().length() > 0) {
                    str2 = previousScreenData.get("retroactiveScreenId").toString();
                    f.e().d().onNext(a(previousScreenData, str2, "RAScreenLeft"));
                }
            }
        }
        if (currentScreenData != null && currentScreenData.has("retroactiveScreenId")) {
            if (currentScreenData.get("retroactiveScreenId").toString().length() > 0) {
                str = currentScreenData.get("retroactiveScreenId").toString();
                b(a(currentScreenData, str, "RAScreenView"));
            }
        }
        PendoLogger.d("AnalyticsManager", "New screen identified! ScreenId: '" + str + "', Current (old) screenId: '" + str2 + "'");
    }

    public final synchronized void a(JSONObject trackEventJSON) {
        Intrinsics.checkNotNullParameter(trackEventJSON, "trackEventJSON");
        PendoLogger.i("AnalyticsManager-> handleTrackEvent with trackEvent: " + trackEventJSON, new Object[0]);
        if (PendoInternal.M()) {
            ActivationManager.INSTANCE.getTrackEventsBeforeSessionStart().add(new h.a(sdk.pendo.io.c8.c.TRACK_EVENT.b(), trackEventJSON, null));
        } else if (c()) {
            f.f().a(sdk.pendo.io.c8.c.TRACK_EVENT.b(), trackEventJSON, null);
        }
    }

    private final JSONObject a(JSONObject json, String event) {
        json.put("event", event).put("accountId", PendoInternal.k()).put("visitorId", PendoInternal.D()).put("actionType", event).put(Device.JsonKeys.ORIENTATION, g.g()).put("device_time", System.currentTimeMillis()).put("appVersion", AndroidUtils.d());
        return json;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(JSONObject event, Boolean bool) {
        Intrinsics.checkNotNullParameter(event, "$event");
        j a2 = j.a(new Object()).b(sdk.pendo.io.v6.a.d()).a(sdk.pendo.io.v6.a.d());
        final d dVar = new d(event);
        a2.a(new e() { // from class: sdk.pendo.io.e9.a$$ExternalSyntheticLambda2
            @Override // sdk.pendo.io.d6.e
            public final void accept(Object obj) {
                a.d(Function1.this, obj);
            }
        }, new sdk.pendo.io.a9.a("ActivationManager, screenChangedSubscription"));
    }
}
