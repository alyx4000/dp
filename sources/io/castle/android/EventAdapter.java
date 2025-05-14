package io.castle.android;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import io.castle.android.api.model.CustomEvent;
import io.castle.android.api.model.Event;
import io.castle.android.api.model.ScreenEvent;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
class EventAdapter implements JsonDeserializer<Event> {
    private static final Gson gson = new Gson();

    EventAdapter() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.JsonDeserializer
    public Event deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (type.equals(Event.class)) {
            String asString = jsonElement.getAsJsonObject().get("type").getAsString();
            asString.hashCode();
            if (asString.equals(Event.EVENT_TYPE_CUSTOM)) {
                type = CustomEvent.class;
            } else if (asString.equals(Event.EVENT_TYPE_SCREEN)) {
                type = ScreenEvent.class;
            }
        }
        return (Event) gson.fromJson(jsonElement, type);
    }
}
