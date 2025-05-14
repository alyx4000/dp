package com.socure.idplus.device.context;

import com.reactnativedevicerisk.util.Constants;
import com.socure.idplus.device.internal.common.utils.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\t\b\t\n\u000b\f\r\u000e\u000f\u0010B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u0082\u0001\t\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019¨\u0006\u001a"}, d2 = {"Lcom/socure/idplus/device/context/SigmaDeviceContext;", "", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "setValue", "CheckOut", "Default", "Home", "Login", "Other", "Password", "Profile", "SignUp", "Transaction", "Lcom/socure/idplus/device/context/SigmaDeviceContext$CheckOut;", "Lcom/socure/idplus/device/context/SigmaDeviceContext$Default;", "Lcom/socure/idplus/device/context/SigmaDeviceContext$Home;", "Lcom/socure/idplus/device/context/SigmaDeviceContext$Login;", "Lcom/socure/idplus/device/context/SigmaDeviceContext$Other;", "Lcom/socure/idplus/device/context/SigmaDeviceContext$Password;", "Lcom/socure/idplus/device/context/SigmaDeviceContext$Profile;", "Lcom/socure/idplus/device/context/SigmaDeviceContext$SignUp;", "Lcom/socure/idplus/device/context/SigmaDeviceContext$Transaction;", "device-risk-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class SigmaDeviceContext {
    private String value;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/socure/idplus/device/context/SigmaDeviceContext$CheckOut;", "Lcom/socure/idplus/device/context/SigmaDeviceContext;", "()V", "device-risk-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class CheckOut extends SigmaDeviceContext {
        public CheckOut() {
            super(Constants.CHECKOUT, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/socure/idplus/device/context/SigmaDeviceContext$Default;", "Lcom/socure/idplus/device/context/SigmaDeviceContext;", "()V", "device-risk-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Default extends SigmaDeviceContext {
        public Default() {
            super("default", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/socure/idplus/device/context/SigmaDeviceContext$Home;", "Lcom/socure/idplus/device/context/SigmaDeviceContext;", "()V", "device-risk-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Home extends SigmaDeviceContext {
        public Home() {
            super(Constants.HOMEPAGE, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/socure/idplus/device/context/SigmaDeviceContext$Login;", "Lcom/socure/idplus/device/context/SigmaDeviceContext;", "()V", "device-risk-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Login extends SigmaDeviceContext {
        public Login() {
            super(Constants.LOGIN, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/socure/idplus/device/context/SigmaDeviceContext$Other;", "Lcom/socure/idplus/device/context/SigmaDeviceContext;", "otherValue", "", "(Ljava/lang/String;)V", "device-risk-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Other extends SigmaDeviceContext {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Other(String otherValue) {
            super(a.b(otherValue), null);
            Intrinsics.checkNotNullParameter(otherValue, "otherValue");
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/socure/idplus/device/context/SigmaDeviceContext$Password;", "Lcom/socure/idplus/device/context/SigmaDeviceContext;", "()V", "device-risk-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Password extends SigmaDeviceContext {
        public Password() {
            super("password", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/socure/idplus/device/context/SigmaDeviceContext$Profile;", "Lcom/socure/idplus/device/context/SigmaDeviceContext;", "()V", "device-risk-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Profile extends SigmaDeviceContext {
        public Profile() {
            super("profile", null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/socure/idplus/device/context/SigmaDeviceContext$SignUp;", "Lcom/socure/idplus/device/context/SigmaDeviceContext;", "()V", "device-risk-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SignUp extends SigmaDeviceContext {
        public SignUp() {
            super(Constants.SIGNUP, null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/socure/idplus/device/context/SigmaDeviceContext$Transaction;", "Lcom/socure/idplus/device/context/SigmaDeviceContext;", "()V", "device-risk-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Transaction extends SigmaDeviceContext {
        public Transaction() {
            super("transaction", null);
        }
    }

    private SigmaDeviceContext(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setValue(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.value = str;
    }

    public /* synthetic */ SigmaDeviceContext(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }
}
