package sdk.pendo.io.network.responses.validators;

import external.sdk.pendo.io.jose4j.jwt.consumer.JwtConsumer;
import external.sdk.pendo.io.jose4j.jwt.consumer.JwtConsumerBuilder;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.a1.c;
import sdk.pendo.io.d1.f;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.u0.a;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004J\u0010\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u0004R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lsdk/pendo/io/network/responses/validators/JsonWebTokenValidator;", "", "Lexternal/sdk/pendo/io/jose4j/jwt/consumer/JwtConsumer;", "generateJWT", "", "getEnvironmentPublicKey", "Lsdk/pendo/io/d1/f;", "generatePublicKey", "environment", "", "setEnvironment", "json", "validate", "Lsdk/pendo/io/network/responses/validators/JsonWebTokenValidator$Environment;", "ENV", "Lsdk/pendo/io/network/responses/validators/JsonWebTokenValidator$Environment;", "RSA_JSON_WEB_KEY", "Lsdk/pendo/io/d1/f;", "JWT_CONSUMER", "Lexternal/sdk/pendo/io/jose4j/jwt/consumer/JwtConsumer;", "<init>", "()V", "Environment", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class JsonWebTokenValidator {
    private static Environment ENV;
    public static final JsonWebTokenValidator INSTANCE;
    private static JwtConsumer JWT_CONSUMER;
    private static f RSA_JSON_WEB_KEY;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lsdk/pendo/io/network/responses/validators/JsonWebTokenValidator$Environment;", "", "(Ljava/lang/String;I)V", "PRODUCTION", "STAGING", "DEV", "pendoIO_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Environment {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Environment[] $VALUES;
        public static final Environment PRODUCTION = new Environment("PRODUCTION", 0);
        public static final Environment STAGING = new Environment("STAGING", 1);
        public static final Environment DEV = new Environment("DEV", 2);

        private static final /* synthetic */ Environment[] $values() {
            return new Environment[]{PRODUCTION, STAGING, DEV};
        }

        static {
            Environment[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private Environment(String str, int i) {
        }

        public static EnumEntries<Environment> getEntries() {
            return $ENTRIES;
        }

        public static Environment valueOf(String str) {
            return (Environment) Enum.valueOf(Environment.class, str);
        }

        public static Environment[] values() {
            return (Environment[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Environment.values().length];
            try {
                iArr[Environment.STAGING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Environment.DEV.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        JsonWebTokenValidator jsonWebTokenValidator = new JsonWebTokenValidator();
        INSTANCE = jsonWebTokenValidator;
        ENV = Environment.PRODUCTION;
        RSA_JSON_WEB_KEY = jsonWebTokenValidator.generatePublicKey();
        JWT_CONSUMER = jsonWebTokenValidator.generateJWT();
    }

    private JsonWebTokenValidator() {
    }

    private final synchronized JwtConsumer generateJWT() {
        if (RSA_JSON_WEB_KEY == null) {
            return null;
        }
        JwtConsumerBuilder b = new JwtConsumerBuilder().b();
        f fVar = RSA_JSON_WEB_KEY;
        Intrinsics.checkNotNull(fVar);
        return b.a(fVar.a()).a(c.d).a();
    }

    private final synchronized f generatePublicKey() {
        try {
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(a.a(getEnvironmentPublicKey())));
            Intrinsics.checkNotNull(generatePublic, "null cannot be cast to non-null type java.security.interfaces.RSAPublicKey");
            return new f((RSAPublicKey) generatePublic);
        } catch (NoSuchAlgorithmException e) {
            PendoLogger.d(e);
            PendoLogger.e("CANNOT GENERATE PUBLIC KEY!", new Object[0]);
            return null;
        } catch (InvalidKeySpecException e2) {
            PendoLogger.w(e2);
            PendoLogger.e("CANNOT GENERATE PUBLIC KEY!", new Object[0]);
            return null;
        }
    }

    private final String getEnvironmentPublicKey() {
        int i = WhenMappings.$EnumSwitchMapping$0[ENV.ordinal()];
        return i != 1 ? i != 2 ? "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC1B6qsa2sbpc4CuFEjgRWez9nN\nMtburcr/RZ6n4iEIGcLZFfQ34whx3aGQ8ZuImAOOHnhjohaZzaW8bITEnZNa+v/h\n0vFrDGYtyJQdh1H7ejasIvWYDt+S/Pd1b8b8/ZZ6czA8fNcDDGgXmcGOCi8tK2nJ\n972K3gVzG7F581Tw6QIDAQAB" : "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCbelsiqvdpzGmRF3pex4Ar1HNI\nMcadFr9rwxGUMGOn8qIcjLE4vr9T1rxm6DekW9IBGNAwGOynuA+ebTfpfPMYY8nO\nZ7gvgJ/czWhiH8IDnmHnxVeLd6O8Z+/4hl++9Yae1093QTb2k5FIekNae54Klg4N\nT0Qiqky2MfXLee1lYwIDAQAB" : "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCv8IqRRwpH8s7EnWhLwuFqnbTA\n6iT8LqQ+nPL0WvwCtHPABV4hXd0+qj4TZo3nEew13M5uEFiD6cFlA1/l/dydjGjT\nvknbo5+6pBVWVZpCg5Rtpii3JUKMxOmJrccBCo7ICIqPIj/L9Nc5zmWMH2igKHLq\nx4N4CYzAsWwSc505vwIDAQAB";
    }

    public final synchronized void setEnvironment(String environment) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        try {
            Locale US = Locale.US;
            Intrinsics.checkNotNullExpressionValue(US, "US");
            String upperCase = environment.toUpperCase(US);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
            ENV = Environment.valueOf(upperCase);
            RSA_JSON_WEB_KEY = generatePublicKey();
            JWT_CONSUMER = generateJWT();
        } catch (Exception unused) {
            PendoLogger.w("Invalid environment: [" + environment + "], will use current values", new Object[0]);
        }
    }

    public final String validate(String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        if (RSA_JSON_WEB_KEY == null) {
            throw new IllegalStateException("RSA key is null");
        }
        JwtConsumer jwtConsumer = JWT_CONSUMER;
        if (jwtConsumer == null) {
            throw new IllegalStateException("JWT consumer null");
        }
        Intrinsics.checkNotNull(jwtConsumer);
        return jwtConsumer.b(json).j();
    }
}
