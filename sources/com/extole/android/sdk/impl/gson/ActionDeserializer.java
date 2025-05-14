package com.extole.android.sdk.impl.gson;

import com.extole.android.sdk.Action;
import com.extole.android.sdk.impl.app.action.FetchAction;
import com.extole.android.sdk.impl.app.action.LoadOperationsAction;
import com.extole.android.sdk.impl.app.action.NativeShareAction;
import com.extole.android.sdk.impl.app.action.PromptAction;
import com.extole.android.sdk.impl.app.action.SetLogLevelAction;
import com.extole.android.sdk.impl.app.action.UnknownAction;
import com.extole.android.sdk.impl.app.action.ViewFullScreenAction;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ActionDeserializer.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/extole/android/sdk/impl/gson/ActionDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/extole/android/sdk/Action;", "()V", "deserialize", "json", "Lcom/google/gson/JsonElement;", "type", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonDeserializationContext;", "Companion", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ActionDeserializer implements JsonDeserializer<Action> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<String, Class<? extends Action>> typeMap;

    /* compiled from: ActionDeserializer.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R%\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/extole/android/sdk/impl/gson/ActionDeserializer$Companion;", "", "()V", "typeMap", "", "", "Ljava/lang/Class;", "Lcom/extole/android/sdk/Action;", "getTypeMap", "()Ljava/util/Map;", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<String, Class<? extends Action>> getTypeMap() {
            return ActionDeserializer.typeMap;
        }
    }

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        typeMap = linkedHashMap;
        linkedHashMap.put("VIEW_FULLSCREEN", ViewFullScreenAction.class);
        linkedHashMap.put("FETCH", FetchAction.class);
        linkedHashMap.put("SET_LOG_LEVEL", SetLogLevelAction.class);
        linkedHashMap.put("PROMPT", PromptAction.class);
        linkedHashMap.put("LOAD_OPERATIONS", LoadOperationsAction.class);
        linkedHashMap.put("NATIVE_SHARE", NativeShareAction.class);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public Action deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(context, "context");
        Class<? extends Action> cls = typeMap.get(json.getAsJsonObject().get("type").getAsString());
        if (cls == null) {
            cls = UnknownAction.class;
        }
        Object deserialize = context.deserialize(json, cls);
        Intrinsics.checkNotNullExpressionValue(deserialize, "context.deserialize(json, actionType)");
        return (Action) deserialize;
    }
}
