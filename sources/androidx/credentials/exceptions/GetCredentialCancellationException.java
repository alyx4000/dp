package androidx.credentials.exceptions;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: GetCredentialCancellationException.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0013\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Landroidx/credentials/exceptions/GetCredentialCancellationException;", "Landroidx/credentials/exceptions/GetCredentialException;", "errorMessage", "", "(Ljava/lang/CharSequence;)V", "Companion", "credentials_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GetCredentialCancellationException extends GetCredentialException {
    public static final String TYPE_GET_CREDENTIAL_CANCELLATION_EXCEPTION = "android.credentials.GetCredentialException.TYPE_USER_CANCELED";

    public GetCredentialCancellationException() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ GetCredentialCancellationException(CharSequence charSequence, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : charSequence);
    }

    public GetCredentialCancellationException(CharSequence charSequence) {
        super(TYPE_GET_CREDENTIAL_CANCELLATION_EXCEPTION, charSequence);
    }
}
