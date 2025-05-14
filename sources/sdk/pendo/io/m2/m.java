package sdk.pendo.io.m2;

import io.sentry.protocol.ViewHierarchyNode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0014R\u001a\u0010\u000f\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/m2/m;", "Lsdk/pendo/io/m2/c;", "Lsdk/pendo/io/i2/f;", "descriptor", "", "e", "", ViewHierarchyNode.JsonKeys.TAG, "Lsdk/pendo/io/l2/h;", "b", "Lsdk/pendo/io/l2/u;", "f", "Lsdk/pendo/io/l2/u;", "getValue", "()Lkotlinx/serialization/json/JsonPrimitive;", "value", "Lsdk/pendo/io/l2/a;", "json", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonPrimitive;)V", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
final class m extends c {

    /* renamed from: f, reason: from kotlin metadata */
    private final sdk.pendo.io.l2.u value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(sdk.pendo.io.l2.a json, sdk.pendo.io.l2.u value) {
        super(json, value, null);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
        j((m) "primitive");
    }

    @Override // sdk.pendo.io.m2.c
    protected sdk.pendo.io.l2.h b(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        if (tag == "primitive") {
            return s();
        }
        throw new IllegalArgumentException("This input can only handle primitives with 'primitive' tag".toString());
    }

    @Override // sdk.pendo.io.j2.b
    public int e(sdk.pendo.io.i2.f descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return 0;
    }

    @Override // sdk.pendo.io.m2.c
    /* renamed from: t, reason: from getter and merged with bridge method [inline-methods] */
    public sdk.pendo.io.l2.u s() {
        return this.value;
    }
}
