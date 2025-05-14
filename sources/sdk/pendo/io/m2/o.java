package sdk.pendo.io.m2;

import io.sentry.protocol.ViewHierarchyNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0006H\u0014J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0016R\u001a\u0010\u0012\u001a\u00020\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014¨\u0006\u001c"}, d2 = {"Lsdk/pendo/io/m2/o;", "Lsdk/pendo/io/m2/c;", "Lsdk/pendo/io/i2/f;", "desc", "", "index", "", "k", ViewHierarchyNode.JsonKeys.TAG, "Lsdk/pendo/io/l2/h;", "b", "descriptor", "e", "Lsdk/pendo/io/l2/b;", "f", "Lsdk/pendo/io/l2/b;", "getValue", "()Lkotlinx/serialization/json/JsonArray;", "value", "g", "I", "size", "h", "currentIndex", "Lsdk/pendo/io/l2/a;", "json", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonArray;)V", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
final class o extends c {

    /* renamed from: f, reason: from kotlin metadata */
    private final sdk.pendo.io.l2.b value;

    /* renamed from: g, reason: from kotlin metadata */
    private final int size;

    /* renamed from: h, reason: from kotlin metadata */
    private int currentIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(sdk.pendo.io.l2.a json, sdk.pendo.io.l2.b value) {
        super(json, value, null);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
        this.size = s().size();
        this.currentIndex = -1;
    }

    @Override // sdk.pendo.io.m2.c
    protected sdk.pendo.io.l2.h b(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return s().get(Integer.parseInt(tag));
    }

    @Override // sdk.pendo.io.j2.b
    public int e(sdk.pendo.io.i2.f descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        int i = this.currentIndex;
        if (i >= this.size - 1) {
            return -1;
        }
        int i2 = i + 1;
        this.currentIndex = i2;
        return i2;
    }

    @Override // sdk.pendo.io.k2.l0
    protected String k(sdk.pendo.io.i2.f desc, int index) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        return String.valueOf(index);
    }

    @Override // sdk.pendo.io.m2.c
    /* renamed from: t, reason: from getter and merged with bridge method [inline-methods] */
    public sdk.pendo.io.l2.b s() {
        return this.value;
    }
}
