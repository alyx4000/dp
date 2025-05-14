package com.extole.android.sdk.impl.app.action;

import com.extole.android.sdk.Action;
import com.extole.android.sdk.ExtoleLogger;
import com.extole.android.sdk.LogLevel;
import com.extole.android.sdk.impl.ExtoleInternal;
import com.extole.android.sdk.impl.app.AppEvent;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SetLogLevelAction.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J!\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010\u001a\u001a\u00020\u0003H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/extole/android/sdk/impl/app/action/SetLogLevelAction;", "Lcom/extole/android/sdk/Action;", "logLevel", "", "(Ljava/lang/String;)V", "getLogLevel", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "execute", "", "event", "Lcom/extole/android/sdk/impl/app/AppEvent;", "extole", "Lcom/extole/android/sdk/impl/ExtoleInternal;", "(Lcom/extole/android/sdk/impl/app/AppEvent;Lcom/extole/android/sdk/impl/ExtoleInternal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getType", "Lcom/extole/android/sdk/Action$ActionType;", "hashCode", "", "toLogLevel", "Lcom/extole/android/sdk/LogLevel;", "toString", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class SetLogLevelAction implements Action {

    @SerializedName("log_level")
    private final String logLevel;

    public static /* synthetic */ SetLogLevelAction copy$default(SetLogLevelAction setLogLevelAction, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = setLogLevelAction.logLevel;
        }
        return setLogLevelAction.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getLogLevel() {
        return this.logLevel;
    }

    public final SetLogLevelAction copy(String logLevel) {
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        return new SetLogLevelAction(logLevel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SetLogLevelAction) && Intrinsics.areEqual(this.logLevel, ((SetLogLevelAction) other).logLevel);
    }

    public int hashCode() {
        return this.logLevel.hashCode();
    }

    public SetLogLevelAction(String logLevel) {
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        this.logLevel = logLevel;
    }

    public final String getLogLevel() {
        return this.logLevel;
    }

    @Override // com.extole.android.sdk.Action
    public String getTitle() {
        return Action.DefaultImpls.getTitle(this);
    }

    @Override // com.extole.android.sdk.Action
    public Object execute(AppEvent appEvent, ExtoleInternal extoleInternal, Continuation<? super Unit> continuation) {
        extoleInternal.setLogger(ExtoleLogger.INSTANCE.builder().withProgramDomain(extoleInternal.getProgramDomain()).withAccessToken(extoleInternal.getAccessToken()).withLogLevel(toLogLevel(this.logLevel)).build());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final LogLevel toLogLevel(String logLevel) {
        switch (logLevel.hashCode()) {
            case -1905676600:
                if (logLevel.equals("DISABLE")) {
                    return LogLevel.DISABLE;
                }
                break;
            case 2251950:
                if (logLevel.equals("INFO")) {
                    return LogLevel.INFO;
                }
                break;
            case 2656902:
                if (logLevel.equals("WARN")) {
                    return LogLevel.WARN;
                }
                break;
            case 64921139:
                if (logLevel.equals("DEBUG")) {
                    return LogLevel.DEBUG;
                }
                break;
            case 66247144:
                if (logLevel.equals("ERROR")) {
                    return LogLevel.ERROR;
                }
                break;
        }
        return LogLevel.ERROR;
    }

    @Override // com.extole.android.sdk.Action
    public Action.ActionType getType() {
        return Action.ActionType.SET_LOG_LEVEL;
    }

    public String toString() {
        return "Action: " + getType() + ", logLevel: " + this.logLevel;
    }
}
