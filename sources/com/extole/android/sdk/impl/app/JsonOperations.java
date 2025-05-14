package com.extole.android.sdk.impl.app;

import com.extole.android.sdk.Action;
import com.extole.android.sdk.Condition;
import com.extole.android.sdk.Operation;
import com.extole.android.sdk.impl.gson.ActionDeserializer;
import com.extole.android.sdk.impl.gson.ConditionDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JsonOperations.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B#\b\u0016\u0012\u001a\u0010\u0005\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00070\u0006¢\u0006\u0002\u0010\bJ\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0006R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/extole/android/sdk/impl/app/JsonOperations;", "", "operationsJson", "", "(Ljava/lang/String;)V", "operationsMap", "", "", "(Ljava/util/List;)V", "operations", "Lcom/extole/android/sdk/Operation;", "getOperations", "Companion", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class JsonOperations {
    private static final Gson gson = new GsonBuilder().registerTypeAdapter(Action.class, new ActionDeserializer()).registerTypeAdapter(Condition.class, new ConditionDeserializer()).create();
    private static final Type operationsType = new TypeToken<List<? extends OperationImpl>>() { // from class: com.extole.android.sdk.impl.app.JsonOperations$Companion$operationsType$1
    }.getType();
    private final List<Operation> operations;

    public JsonOperations(String operationsJson) {
        Intrinsics.checkNotNullParameter(operationsJson, "operationsJson");
        Object fromJson = gson.fromJson(operationsJson, operationsType);
        Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson<List<Opera…ionsJson, operationsType)");
        this.operations = (List) fromJson;
    }

    public JsonOperations(List<? extends Map<String, ? extends Object>> operationsMap) {
        Intrinsics.checkNotNullParameter(operationsMap, "operationsMap");
        Gson gson2 = gson;
        Object fromJson = gson2.fromJson(gson2.toJson(operationsMap), operationsType);
        Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson<List<Opera…ionsJson, operationsType)");
        this.operations = (List) fromJson;
    }

    public final List<Operation> getOperations() {
        return this.operations;
    }
}
