package org.bouncycastle.asn1;

import java.io.IOException;

/* loaded from: classes6.dex */
public interface ASN1ApplicationSpecificParser extends ASN1TaggedObjectParser {
    ASN1Encodable readObject() throws IOException;
}
