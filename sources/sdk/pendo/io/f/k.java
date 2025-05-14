package sdk.pendo.io.f;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lsdk/pendo/io/f/k;", "", "<init>", "()V", "a", "b", "Lsdk/pendo/io/f/k$b;", "Lsdk/pendo/io/f/k$a;", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public abstract class k {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lsdk/pendo/io/f/k$a;", "Lsdk/pendo/io/f/k;", "<init>", "()V", "a", "b", "c", "d", "Lsdk/pendo/io/f/k$a$c;", "Lsdk/pendo/io/f/k$a$d;", "Lsdk/pendo/io/f/k$a$b;", "Lsdk/pendo/io/f/k$a$a;", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
    public static abstract class a extends k {

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lsdk/pendo/io/f/k$a$a;", "Lsdk/pendo/io/f/k$a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/security/NoSuchAlgorithmException;", "a", "Ljava/security/NoSuchAlgorithmException;", "getException", "()Ljava/security/NoSuchAlgorithmException;", "exception", "<init>", "(Ljava/security/NoSuchAlgorithmException;)V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
        /* renamed from: sdk.pendo.io.f.k$a$a, reason: collision with other inner class name */
        public static final /* data */ class C0129a extends a {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            private final NoSuchAlgorithmException exception;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0129a(NoSuchAlgorithmException exception) {
                super(null);
                Intrinsics.checkNotNullParameter(exception, "exception");
                this.exception = exception;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof C0129a) && Intrinsics.areEqual(this.exception, ((C0129a) other).exception);
            }

            public int hashCode() {
                return this.exception.hashCode();
            }

            public String toString() {
                return "Invalid signature (public key) with " + sdk.pendo.io.j.c.a(this.exception);
            }
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lsdk/pendo/io/f/k$a$b;", "Lsdk/pendo/io/f/k$a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/security/InvalidKeyException;", "a", "Ljava/security/InvalidKeyException;", "getException", "()Ljava/security/InvalidKeyException;", "exception", "<init>", "(Ljava/security/InvalidKeyException;)V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
        public static final /* data */ class b extends a {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            private final InvalidKeyException exception;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(InvalidKeyException exception) {
                super(null);
                Intrinsics.checkNotNullParameter(exception, "exception");
                this.exception = exception;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof b) && Intrinsics.areEqual(this.exception, ((b) other).exception);
            }

            public int hashCode() {
                return this.exception.hashCode();
            }

            public String toString() {
                return "Invalid signature (public key) with " + sdk.pendo.io.j.c.a(this.exception);
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lsdk/pendo/io/f/k$a$c;", "Lsdk/pendo/io/f/k$a;", "", "toString", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
        public static final class c extends a {

            /* renamed from: a, reason: collision with root package name */
            public static final c f1053a = new c();

            private c() {
                super(null);
            }

            public String toString() {
                return "Invalid signature";
            }
        }

        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÖ\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lsdk/pendo/io/f/k$a$d;", "Lsdk/pendo/io/f/k$a;", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/security/SignatureException;", "a", "Ljava/security/SignatureException;", "getException", "()Ljava/security/SignatureException;", "exception", "<init>", "(Ljava/security/SignatureException;)V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
        public static final /* data */ class d extends a {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata */
            private final SignatureException exception;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(SignatureException exception) {
                super(null);
                Intrinsics.checkNotNullParameter(exception, "exception");
                this.exception = exception;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof d) && Intrinsics.areEqual(this.exception, ((d) other).exception);
            }

            public int hashCode() {
                return this.exception.hashCode();
            }

            public String toString() {
                return "Invalid signature (public key) with " + sdk.pendo.io.j.c.a(this.exception);
            }
        }

        private a() {
            super(null);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, d2 = {"Lsdk/pendo/io/f/k$b;", "Lsdk/pendo/io/f/k;", "", "toString", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
    public static final class b extends k {

        /* renamed from: a, reason: collision with root package name */
        public static final b f1055a = new b();

        private b() {
            super(null);
        }

        public String toString() {
            return "Valid signature";
        }
    }

    private k() {
    }

    public /* synthetic */ k(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
