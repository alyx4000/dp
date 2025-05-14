package sdk.pendo.io.i2;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\"$\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00000\u0001*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"$\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0005\u001a\u0004\b\b\u0010\u0003¨\u0006\u000b"}, d2 = {"Lsdk/pendo/io/i2/f;", "", "getElementDescriptors", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Ljava/lang/Iterable;", "getElementDescriptors$annotations", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "elementDescriptors", "", "getElementNames", "getElementNames$annotations", "elementNames", "kotlinx-serialization-core"}, k = 2, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class h {

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0002J\t\u0010\u0005\u001a\u00020\u0002H\u0096\u0002R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"sdk/pendo/io/i2/h$a", "", "Lsdk/pendo/io/i2/f;", "", "hasNext", "a", "", "f", "I", "elementsLeft", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
    public static final class a implements Iterator<f>, KMappedMarker {

        /* renamed from: f, reason: from kotlin metadata */
        private int elementsLeft;
        final /* synthetic */ f s;

        a(f fVar) {
            this.s = fVar;
            this.elementsLeft = fVar.c();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f next() {
            f fVar = this.s;
            int c = fVar.c();
            int i = this.elementsLeft;
            this.elementsLeft = i - 1;
            return fVar.c(c - i);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.elementsLeft > 0;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0002J\t\u0010\u0005\u001a\u00020\u0002H\u0096\u0002R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"sdk/pendo/io/i2/h$b", "", "", "", "hasNext", "a", "", "f", "I", "elementsLeft", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0})
    public static final class b implements Iterator<String>, KMappedMarker {

        /* renamed from: f, reason: from kotlin metadata */
        private int elementsLeft;
        final /* synthetic */ f s;

        b(f fVar) {
            this.s = fVar;
            this.elementsLeft = fVar.c();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String next() {
            f fVar = this.s;
            int c = fVar.c();
            int i = this.elementsLeft;
            this.elementsLeft = i - 1;
            return fVar.a(c - i);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.elementsLeft > 0;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¨\u0006\u0004¸\u0006\u0000"}, d2 = {"kotlin/collections/CollectionsKt__IterablesKt$Iterable$1", "", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    public static final class c implements Iterable<f>, KMappedMarker {
        final /* synthetic */ f f;

        public c(f fVar) {
            this.f = fVar;
        }

        @Override // java.lang.Iterable
        public Iterator<f> iterator() {
            return new a(this.f);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¨\u0006\u0004¸\u0006\u0000"}, d2 = {"kotlin/collections/CollectionsKt__IterablesKt$Iterable$1", "", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    public static final class d implements Iterable<String>, KMappedMarker {
        final /* synthetic */ f f;

        public d(f fVar) {
            this.f = fVar;
        }

        @Override // java.lang.Iterable
        public Iterator<String> iterator() {
            return new b(this.f);
        }
    }

    public static final Iterable<f> a(f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "<this>");
        return new c(fVar);
    }

    public static final Iterable<String> b(f fVar) {
        Intrinsics.checkNotNullParameter(fVar, "<this>");
        return new d(fVar);
    }
}
