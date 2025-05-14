package sdk.pendo.io.p5;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0017\u0018\u00002\u00020\u0001B%\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u001f\u0010 J#\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J#\u0010\b\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0006J\b\u0010\u0005\u001a\u00020\tH\u0001J\b\u0010\u000b\u001a\u00020\nH\u0016R(\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\f8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010\r\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00138\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u001e\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lsdk/pendo/io/p5/a;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KClass;", "clazz", "a", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "b", "c", "", "", "toString", "", "Ljava/util/List;", "get_values", "()Ljava/util/List;", "get_values$annotations", "()V", "_values", "", "Ljava/lang/Boolean;", "getUseIndexedValues", "()Ljava/lang/Boolean;", "useIndexedValues", "", "I", "getIndex", "()I", "setIndex", "(I)V", "index", "<init>", "(Ljava/util/List;Ljava/lang/Boolean;)V", "koin-core"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<Object> _values;

    /* renamed from: b, reason: from kotlin metadata */
    private final Boolean useIndexedValues;

    /* renamed from: c, reason: from kotlin metadata */
    private int index;

    public a() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    private final <T> T a(KClass<?> clazz) {
        T t;
        Iterator<T> it = this._values.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (clazz.isInstance(t)) {
                break;
            }
        }
        if (t != null) {
            return t;
        }
        return null;
    }

    private final <T> T b(KClass<?> clazz) {
        Object obj = this._values.get(this.index);
        T t = null;
        if (!clazz.isInstance(obj)) {
            obj = null;
        }
        if (obj != null) {
            t = (T) obj;
        }
        if (t != null) {
            a();
        }
        return t;
    }

    public <T> T c(KClass<?> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (this._values.isEmpty()) {
            return null;
        }
        Boolean bool = this.useIndexedValues;
        if (bool == null) {
            T t = (T) b(clazz);
            if (t != null) {
                return t;
            }
        } else if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            return (T) b(clazz);
        }
        return (T) a(clazz);
    }

    public String toString() {
        return "DefinitionParameters" + CollectionsKt.toList(this._values);
    }

    public a(List<Object> _values, Boolean bool) {
        Intrinsics.checkNotNullParameter(_values, "_values");
        this._values = _values;
        this.useIndexedValues = bool;
    }

    public final void a() {
        if (this.index < CollectionsKt.getLastIndex(this._values)) {
            this.index++;
        }
    }

    public /* synthetic */ a(List list, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list, (i & 2) != 0 ? null : bool);
    }
}
