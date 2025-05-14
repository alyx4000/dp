package com.google.crypto.tink.internal;

import com.google.crypto.tink.Key;
import com.google.crypto.tink.Parameters;
import com.google.crypto.tink.SecretKeyAccess;
import com.google.crypto.tink.proto.KeyData;
import com.google.crypto.tink.proto.OutputPrefixType;
import com.google.crypto.tink.subtle.Bytes;
import com.google.errorprone.annotations.Immutable;
import java.security.GeneralSecurityException;
import java.util.Objects;
import javax.annotation.Nullable;

@Immutable
/* loaded from: classes5.dex */
public final class LegacyProtoKey extends Key {
    private final ProtoKeySerialization serialization;

    @Immutable
    private static class LegacyProtoParametersNotForCreation extends Parameters {
        private final OutputPrefixType outputPrefixType;
        private final String typeUrl;

        /* synthetic */ LegacyProtoParametersNotForCreation(String str, OutputPrefixType outputPrefixType, AnonymousClass1 anonymousClass1) {
            this(str, outputPrefixType);
        }

        @Override // com.google.crypto.tink.Parameters
        public boolean hasIdRequirement() {
            return this.outputPrefixType != OutputPrefixType.RAW;
        }

        private static String outputPrefixToString(OutputPrefixType outputPrefixType) {
            int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[outputPrefixType.ordinal()];
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "UNKNOWN" : "CRUNCHY" : "RAW" : "LEGACY" : "TINK";
        }

        public String toString() {
            return String.format("(typeUrl=%s, outputPrefixType=%s)", this.typeUrl, outputPrefixToString(this.outputPrefixType));
        }

        private LegacyProtoParametersNotForCreation(String typeUrl, OutputPrefixType outputPrefixType) {
            this.typeUrl = typeUrl;
            this.outputPrefixType = outputPrefixType;
        }
    }

    /* renamed from: com.google.crypto.tink.internal.LegacyProtoKey$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$KeyData$KeyMaterialType;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType;

        static {
            int[] iArr = new int[KeyData.KeyMaterialType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$KeyData$KeyMaterialType = iArr;
            try {
                iArr[KeyData.KeyMaterialType.SYMMETRIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$KeyData$KeyMaterialType[KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[OutputPrefixType.values().length];
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = iArr2;
            try {
                iArr2[OutputPrefixType.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.RAW.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[OutputPrefixType.CRUNCHY.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private static void throwIfMissingAccess(ProtoKeySerialization protoKeySerialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$proto$KeyData$KeyMaterialType[protoKeySerialization.getKeyMaterialType().ordinal()];
        if (i == 1 || i == 2) {
            SecretKeyAccess.requireAccess(access);
        }
    }

    public LegacyProtoKey(ProtoKeySerialization serialization, @Nullable SecretKeyAccess access) throws GeneralSecurityException {
        throwIfMissingAccess(serialization, access);
        this.serialization = serialization;
    }

    @Override // com.google.crypto.tink.Key
    public boolean equalsKey(Key key) {
        if (!(key instanceof LegacyProtoKey)) {
            return false;
        }
        ProtoKeySerialization protoKeySerialization = ((LegacyProtoKey) key).serialization;
        if (protoKeySerialization.getOutputPrefixType().equals(this.serialization.getOutputPrefixType()) && protoKeySerialization.getKeyMaterialType().equals(this.serialization.getKeyMaterialType()) && protoKeySerialization.getTypeUrl().equals(this.serialization.getTypeUrl()) && Objects.equals(protoKeySerialization.getIdRequirementOrNull(), this.serialization.getIdRequirementOrNull())) {
            return Bytes.equal(this.serialization.getValue().toByteArray(), protoKeySerialization.getValue().toByteArray());
        }
        return false;
    }

    @Override // com.google.crypto.tink.Key
    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.serialization.getIdRequirementOrNull();
    }

    public ProtoKeySerialization getSerialization(@Nullable SecretKeyAccess access) throws GeneralSecurityException {
        throwIfMissingAccess(this.serialization, access);
        return this.serialization;
    }

    @Override // com.google.crypto.tink.Key
    public Parameters getParameters() {
        return new LegacyProtoParametersNotForCreation(this.serialization.getTypeUrl(), this.serialization.getOutputPrefixType(), null);
    }
}
