package sdk.pendo.io.i2;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b$\u0010%J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\n\u001a\u00020\tR\u0017\u0010\u0010\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR.\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\f\u0010\u0013\"\u0004\b\f\u0010\u0014R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0013R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001cR \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00178\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0012\u001a\u0004\b\u0018\u0010\u0013R&\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00178\u0000X\u0080\u0004¢\u0006\f\n\u0004\b \u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R \u0010#\u001a\b\u0012\u0004\u0012\u00020\t0\u00178\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\"\u0010\u0012\u001a\u0004\b\u001e\u0010\u0013¨\u0006&"}, d2 = {"Lsdk/pendo/io/i2/a;", "", "", "elementName", "Lsdk/pendo/io/i2/f;", "descriptor", "", "", "annotations", "", "isOptional", "", "a", "Ljava/lang/String;", "getSerialName", "()Ljava/lang/String;", "serialName", "b", "Ljava/util/List;", "()Ljava/util/List;", "(Ljava/util/List;)V", "getAnnotations$annotations", "()V", "", "c", "d", "elementNames", "", "Ljava/util/Set;", "uniqueNames", "e", "elementDescriptors", "f", "elementAnnotations", "g", "elementOptionality", "<init>", "(Ljava/lang/String;)V", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String serialName;

    /* renamed from: b, reason: from kotlin metadata */
    private List<? extends Annotation> annotations;

    /* renamed from: c, reason: from kotlin metadata */
    private final List<String> elementNames;

    /* renamed from: d, reason: from kotlin metadata */
    private final Set<String> uniqueNames;

    /* renamed from: e, reason: from kotlin metadata */
    private final List<f> elementDescriptors;

    /* renamed from: f, reason: from kotlin metadata */
    private final List<List<Annotation>> elementAnnotations;

    /* renamed from: g, reason: from kotlin metadata */
    private final List<Boolean> elementOptionality;

    public a(String serialName) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        this.serialName = serialName;
        this.annotations = CollectionsKt.emptyList();
        this.elementNames = new ArrayList();
        this.uniqueNames = new HashSet();
        this.elementDescriptors = new ArrayList();
        this.elementAnnotations = new ArrayList();
        this.elementOptionality = new ArrayList();
    }

    public final void a(String elementName, f descriptor, List<? extends Annotation> annotations, boolean isOptional) {
        Intrinsics.checkNotNullParameter(elementName, "elementName");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        if (!this.uniqueNames.add(elementName)) {
            throw new IllegalArgumentException(("Element with name '" + elementName + "' is already registered").toString());
        }
        this.elementNames.add(elementName);
        this.elementDescriptors.add(descriptor);
        this.elementAnnotations.add(annotations);
        this.elementOptionality.add(Boolean.valueOf(isOptional));
    }

    public final List<List<Annotation>> b() {
        return this.elementAnnotations;
    }

    public final List<f> c() {
        return this.elementDescriptors;
    }

    public final List<String> d() {
        return this.elementNames;
    }

    public final List<Boolean> e() {
        return this.elementOptionality;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void a(a aVar, String str, f fVar, List list, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            list = CollectionsKt.emptyList();
        }
        if ((i & 8) != 0) {
            z = false;
        }
        aVar.a(str, fVar, list, z);
    }

    public final List<Annotation> a() {
        return this.annotations;
    }

    public final void a(List<? extends Annotation> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.annotations = list;
    }
}
