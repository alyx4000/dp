package androidx.credentials.exceptions.domerrors;

import kotlin.Metadata;

/* compiled from: ConstraintError.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Landroidx/credentials/exceptions/domerrors/ConstraintError;", "Landroidx/credentials/exceptions/domerrors/DomError;", "()V", "Companion", "credentials_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ConstraintError extends DomError {
    public static final String TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_CONSTRAINT_ERROR = "androidx.credentials.TYPE_CONSTRAINT_ERROR";

    public ConstraintError() {
        super(TYPE_CREATE_PUBLIC_KEY_CREDENTIAL_CONSTRAINT_ERROR);
    }
}
