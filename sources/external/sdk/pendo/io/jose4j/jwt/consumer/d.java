package external.sdk.pendo.io.jose4j.jwt.consumer;

import external.sdk.pendo.io.jose4j.jwt.consumer.b;
import java.util.Collections;

/* loaded from: classes2.dex */
public class d extends c {
    public d(sdk.pendo.io.e1.e eVar, g gVar) {
        super("JWT rejected due to invalid signature.", Collections.singletonList(new b.a(9, "Invalid JWS Signature: " + eVar)), gVar);
    }
}
