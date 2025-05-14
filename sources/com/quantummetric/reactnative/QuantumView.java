package com.quantummetric.reactnative;

import android.content.Context;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.views.view.ReactViewGroup;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class QuantumView extends ReactViewGroup {
    private final Map<String, Object> metadata;
    private String privacy;

    public QuantumView(Context context) {
        super(context);
        this.privacy = "";
        this.metadata = new HashMap();
    }

    public void setPrivacy(String str) {
        this.privacy = str;
    }

    public void setMetadata(ReadableMap readableMap) {
        if (readableMap != null) {
            this.metadata.putAll(Utilities.readableMapToHashMap(readableMap));
        }
    }

    public boolean mask() {
        return this.privacy.equals("mask");
    }

    public boolean encrypt() {
        return this.privacy.equals("encrypt");
    }

    public boolean unmask() {
        return this.privacy.equals("unmask");
    }

    public Map<String, Object> getMetadata() {
        return this.metadata;
    }
}
