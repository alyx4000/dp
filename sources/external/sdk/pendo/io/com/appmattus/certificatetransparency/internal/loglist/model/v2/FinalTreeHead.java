package external.sdk.pendo.io.com.appmattus.certificatetransparency.internal.loglist.model.v2;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.g2.b;
import sdk.pendo.io.i2.f;
import sdk.pendo.io.j2.c;
import sdk.pendo.io.k2.p0;
import sdk.pendo.io.k2.z0;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0081\b\u0018\u0000 $2\u00020\u0001:\u0002%$B1\b\u0017\u0012\u0006\u0010\u001e\u001a\u00020\t\u0012\b\b\u0001\u0010\r\u001a\u00020\t\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b!\u0010\"B\u0017\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b!\u0010#J!\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005HÇ\u0001J\t\u0010\n\u001a\u00020\tHÆ\u0003J\t\u0010\f\u001a\u00020\u000bHÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000bHÆ\u0001J\t\u0010\u0010\u001a\u00020\u000bHÖ\u0001J\t\u0010\u0011\u001a\u00020\tHÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003R \u0010\r\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\r\u0010\u0015\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R \u0010\u000e\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010\u001a\u0012\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001b\u0010\u001c¨\u0006&"}, d2 = {"Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/FinalTreeHead;", "", "self", "Lsdk/pendo/io/j2/c;", "output", "Lsdk/pendo/io/i2/f;", "serialDesc", "", "write$Self", "", "component1", "", "component2", "treeSize", "sha256RootHash", "copy", "toString", "hashCode", "other", "", "equals", "I", "getTreeSize", "()I", "getTreeSize$annotations", "()V", "Ljava/lang/String;", "getSha256RootHash", "()Ljava/lang/String;", "getSha256RootHash$annotations", "seen1", "Lsdk/pendo/io/k2/z0;", "serializationConstructorMarker", "<init>", "(IILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(ILjava/lang/String;)V", "Companion", "$serializer", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes2.dex */
public final /* data */ class FinalTreeHead {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String sha256RootHash;
    private final int treeSize;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¨\u0006\u0007"}, d2 = {"Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/FinalTreeHead$Companion;", "", "Lsdk/pendo/io/g2/b;", "Lexternal/sdk/pendo/io/com/appmattus/certificatetransparency/internal/loglist/model/v2/FinalTreeHead;", "serializer", "<init>", "()V", "certificatetransparency"}, k = 1, mv = {1, 6, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b<FinalTreeHead> serializer() {
            return FinalTreeHead$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ FinalTreeHead(int i, int i2, String str, z0 z0Var) {
        if (3 != (i & 3)) {
            p0.a(i, 3, FinalTreeHead$$serializer.INSTANCE.getDescriptor());
        }
        this.treeSize = i2;
        this.sha256RootHash = str;
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(str.length() == 44)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public static /* synthetic */ FinalTreeHead copy$default(FinalTreeHead finalTreeHead, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = finalTreeHead.treeSize;
        }
        if ((i2 & 2) != 0) {
            str = finalTreeHead.sha256RootHash;
        }
        return finalTreeHead.copy(i, str);
    }

    public static /* synthetic */ void getSha256RootHash$annotations() {
    }

    public static /* synthetic */ void getTreeSize$annotations() {
    }

    @JvmStatic
    public static final void write$Self(FinalTreeHead self, c output, f serialDesc) {
        Intrinsics.checkNotNullParameter(self, "self");
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(serialDesc, "serialDesc");
        output.a(serialDesc, 0, self.treeSize);
        output.a(serialDesc, 1, self.sha256RootHash);
    }

    /* renamed from: component1, reason: from getter */
    public final int getTreeSize() {
        return this.treeSize;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSha256RootHash() {
        return this.sha256RootHash;
    }

    public final FinalTreeHead copy(int treeSize, String sha256RootHash) {
        Intrinsics.checkNotNullParameter(sha256RootHash, "sha256RootHash");
        return new FinalTreeHead(treeSize, sha256RootHash);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FinalTreeHead)) {
            return false;
        }
        FinalTreeHead finalTreeHead = (FinalTreeHead) other;
        return this.treeSize == finalTreeHead.treeSize && Intrinsics.areEqual(this.sha256RootHash, finalTreeHead.sha256RootHash);
    }

    public final String getSha256RootHash() {
        return this.sha256RootHash;
    }

    public final int getTreeSize() {
        return this.treeSize;
    }

    public int hashCode() {
        return (Integer.hashCode(this.treeSize) * 31) + this.sha256RootHash.hashCode();
    }

    public String toString() {
        return "FinalTreeHead(treeSize=" + this.treeSize + ", sha256RootHash=" + this.sha256RootHash + ')';
    }

    public FinalTreeHead(int i, String sha256RootHash) {
        Intrinsics.checkNotNullParameter(sha256RootHash, "sha256RootHash");
        this.treeSize = i;
        this.sha256RootHash = sha256RootHash;
        if (!(i >= 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(sha256RootHash.length() == 44)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }
}
