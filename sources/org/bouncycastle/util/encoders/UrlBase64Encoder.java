package org.bouncycastle.util.encoders;

import org.tensorflow.lite.schema.BuiltinOptions;

/* loaded from: classes6.dex */
public class UrlBase64Encoder extends Base64Encoder {
    public UrlBase64Encoder() {
        this.encodingTable[this.encodingTable.length - 2] = 45;
        this.encodingTable[this.encodingTable.length - 1] = BuiltinOptions.NonMaxSuppressionV4Options;
        this.padding = BuiltinOptions.LessEqualOptions;
        initialiseDecodingTable();
    }
}
