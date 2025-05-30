package com.facebook.react.uimanager;

import java.util.Collection;
import javax.annotation.Nullable;

/* loaded from: classes3.dex */
public interface ViewManagerResolver {
    @Nullable
    ViewManager getViewManager(String str);

    Collection<String> getViewManagerNames();
}
