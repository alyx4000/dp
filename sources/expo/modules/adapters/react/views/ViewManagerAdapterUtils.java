package expo.modules.adapters.react.views;

import com.facebook.react.uimanager.ViewProps;

/* loaded from: classes3.dex */
public class ViewManagerAdapterUtils {
    public static String normalizeEventName(String str) {
        return str.startsWith("on") ? ViewProps.TOP + str.substring(2) : str;
    }
}
