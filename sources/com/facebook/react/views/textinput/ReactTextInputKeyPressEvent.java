package com.facebook.react.views.textinput;

import com.amplitude.reactnative.DatabaseConstants;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

/* loaded from: classes3.dex */
public class ReactTextInputKeyPressEvent extends Event<ReactTextInputEvent> {
    public static final String EVENT_NAME = "topKeyPress";
    private String mKey;

    @Override // com.facebook.react.uimanager.events.Event
    public boolean canCoalesce() {
        return false;
    }

    @Override // com.facebook.react.uimanager.events.Event
    public String getEventName() {
        return EVENT_NAME;
    }

    @Deprecated
    ReactTextInputKeyPressEvent(int i, String str) {
        this(-1, i, str);
    }

    ReactTextInputKeyPressEvent(int i, int i2, String str) {
        super(i, i2);
        this.mKey = str;
    }

    @Override // com.facebook.react.uimanager.events.Event
    protected WritableMap getEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putString(DatabaseConstants.KEY_FIELD, this.mKey);
        return createMap;
    }
}
