package io.castle.android.api.model;

import android.app.Activity;

/* loaded from: classes2.dex */
public class ScreenEvent extends Event {
    public ScreenEvent(String str) {
        super(str);
        this.type = Event.EVENT_TYPE_SCREEN;
    }

    public ScreenEvent(Activity activity) {
        this(activity.getTitle() != null ? activity.getTitle().toString() : activity.getClass().getSimpleName());
    }
}
