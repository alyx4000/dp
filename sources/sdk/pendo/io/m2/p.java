package sdk.pendo.io.m2;

import com.facebook.react.uimanager.ViewProps;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0006H\u0014J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u001a\u0010\u0013\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019¨\u0006!"}, d2 = {"Lsdk/pendo/io/m2/p;", "Lsdk/pendo/io/m2/n;", "Lsdk/pendo/io/i2/f;", "desc", "", "index", "", "k", "descriptor", "e", ViewHierarchyNode.JsonKeys.TAG, "Lsdk/pendo/io/l2/h;", "b", "", "c", "Lsdk/pendo/io/l2/s;", "Lsdk/pendo/io/l2/s;", "getValue", "()Lkotlinx/serialization/json/JsonObject;", "value", "", "l", "Ljava/util/List;", UserMetadata.KEYDATA_FILENAME, "m", "I", "size", "n", ViewProps.POSITION, "Lsdk/pendo/io/l2/a;", "json", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonObject;)V", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
final class p extends n {

    /* renamed from: k, reason: from kotlin metadata */
    private final sdk.pendo.io.l2.s value;

    /* renamed from: l, reason: from kotlin metadata */
    private final List<String> keys;

    /* renamed from: m, reason: from kotlin metadata */
    private final int size;

    /* renamed from: n, reason: from kotlin metadata */
    private int position;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(sdk.pendo.io.l2.a json, sdk.pendo.io.l2.s value) {
        super(json, value, null, null, 12, null);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
        List<String> list = CollectionsKt.toList(s().keySet());
        this.keys = list;
        this.size = list.size() * 2;
        this.position = -1;
    }

    @Override // sdk.pendo.io.m2.n, sdk.pendo.io.m2.c
    protected sdk.pendo.io.l2.h b(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return this.position % 2 == 0 ? sdk.pendo.io.l2.i.a(tag) : (sdk.pendo.io.l2.h) MapsKt.getValue(s(), tag);
    }

    @Override // sdk.pendo.io.m2.n, sdk.pendo.io.m2.c, sdk.pendo.io.j2.b
    public void c(sdk.pendo.io.i2.f descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    @Override // sdk.pendo.io.m2.n, sdk.pendo.io.j2.b
    public int e(sdk.pendo.io.i2.f descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        int i = this.position;
        if (i >= this.size - 1) {
            return -1;
        }
        int i2 = i + 1;
        this.position = i2;
        return i2;
    }

    @Override // sdk.pendo.io.m2.n, sdk.pendo.io.k2.l0
    protected String k(sdk.pendo.io.i2.f desc, int index) {
        Intrinsics.checkNotNullParameter(desc, "desc");
        return this.keys.get(index / 2);
    }

    @Override // sdk.pendo.io.m2.n, sdk.pendo.io.m2.c
    /* renamed from: t, reason: from getter and merged with bridge method [inline-methods] */
    public sdk.pendo.io.l2.s getValue() {
        return this.value;
    }
}
