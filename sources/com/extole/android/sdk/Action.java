package com.extole.android.sdk;

import com.extole.android.sdk.impl.ExtoleInternal;
import com.extole.android.sdk.impl.app.AppEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: Action.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\rJ!\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH&\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/extole/android/sdk/Action;", "", "execute", "", "event", "Lcom/extole/android/sdk/impl/app/AppEvent;", "extole", "Lcom/extole/android/sdk/impl/ExtoleInternal;", "(Lcom/extole/android/sdk/impl/app/AppEvent;Lcom/extole/android/sdk/impl/ExtoleInternal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTitle", "", "getType", "Lcom/extole/android/sdk/Action$ActionType;", "ActionType", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface Action {

    /* compiled from: Action.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/extole/android/sdk/Action$ActionType;", "", "(Ljava/lang/String;I)V", "VIEW_FULLSCREEN", "PROMPT", "SET_LOG_LEVEL", "FETCH", "LOAD_OPERATIONS", "NATIVE_SHARE", "CUSTOM", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum ActionType {
        VIEW_FULLSCREEN,
        PROMPT,
        SET_LOG_LEVEL,
        FETCH,
        LOAD_OPERATIONS,
        NATIVE_SHARE,
        CUSTOM
    }

    Object execute(AppEvent appEvent, ExtoleInternal extoleInternal, Continuation<? super Unit> continuation);

    String getTitle();

    ActionType getType();

    /* compiled from: Action.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static String getTitle(Action action) {
            return action.getType().name();
        }
    }
}
