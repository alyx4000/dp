package sdk.pendo.io.k3;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\f\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u00012\u00060\u0003j\u0002`\u0004:\u0001\u0007B!\b\u0002\u0012\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0002R\"\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0013\u001a\u00020\u000e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lsdk/pendo/io/k3/r;", "Lkotlin/collections/AbstractList;", "Lsdk/pendo/io/k3/g;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "index", "a", "", "f", "[Lsdk/pendo/io/k3/g;", "getByteStrings$okio", "()[Lokio/ByteString;", "byteStrings", "", "s", "[I", "b", "()[I", "trie", "getSize", "()I", "size", "<init>", "([Lokio/ByteString;[I)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class r extends AbstractList<g> implements RandomAccess {

    /* renamed from: A, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: from kotlin metadata */
    private final g[] byteStrings;

    /* renamed from: s, reason: from kotlin metadata */
    private final int[] trie;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018JT\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0002J#\u0010\u0012\u001a\u00020\u00112\u0012\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u0010\"\u00020\tH\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0016\u001a\u00020\u0002*\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lsdk/pendo/io/k3/r$a;", "", "", "nodeOffset", "Lsdk/pendo/io/k3/d;", "node", "", "byteStringOffset", "", "Lsdk/pendo/io/k3/g;", "byteStrings", "fromIndex", "toIndex", "indexes", "", "a", "", "Lsdk/pendo/io/k3/r;", "of", "([Lokio/ByteString;)Lokio/Options;", "getIntCount", "(Lokio/Buffer;)J", "intCount", "<init>", "()V", "external.sdk.pendo.io.okio"}, k = 1, mv = {1, 9, 0})
    /* renamed from: sdk.pendo.io.k3.r$a, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void a(long nodeOffset, d node, int byteStringOffset, List<? extends g> byteStrings, int fromIndex, int toIndex, List<Integer> indexes) {
            int i;
            int i2;
            int i3;
            int i4;
            d dVar;
            int i5 = byteStringOffset;
            if (!(fromIndex < toIndex)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            for (int i6 = fromIndex; i6 < toIndex; i6++) {
                if (!(byteStrings.get(i6).l() >= i5)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
            g gVar = byteStrings.get(fromIndex);
            g gVar2 = byteStrings.get(toIndex - 1);
            int i7 = -1;
            if (i5 == gVar.l()) {
                int intValue = indexes.get(fromIndex).intValue();
                int i8 = fromIndex + 1;
                g gVar3 = byteStrings.get(i8);
                i = i8;
                i2 = intValue;
                gVar = gVar3;
            } else {
                i = fromIndex;
                i2 = -1;
            }
            if (gVar.a(i5) == gVar2.a(i5)) {
                int min = Math.min(gVar.l(), gVar2.l());
                int i9 = 0;
                for (int i10 = i5; i10 < min && gVar.a(i10) == gVar2.a(i10); i10++) {
                    i9++;
                }
                long a2 = nodeOffset + a(node) + 2 + i9 + 1;
                node.writeInt(-i9);
                node.writeInt(i2);
                int i11 = i5 + i9;
                while (i5 < i11) {
                    node.writeInt(gVar.a(i5) & UByte.MAX_VALUE);
                    i5++;
                }
                if (i + 1 == toIndex) {
                    if (!(i11 == byteStrings.get(i).l())) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    node.writeInt(indexes.get(i).intValue());
                    return;
                } else {
                    d dVar2 = new d();
                    node.writeInt(((int) (a(dVar2) + a2)) * (-1));
                    a(a2, dVar2, i11, byteStrings, i, toIndex, indexes);
                    node.a((a0) dVar2);
                    return;
                }
            }
            int i12 = 1;
            for (int i13 = i + 1; i13 < toIndex; i13++) {
                if (byteStrings.get(i13 - 1).a(i5) != byteStrings.get(i13).a(i5)) {
                    i12++;
                }
            }
            long a3 = nodeOffset + a(node) + 2 + (i12 * 2);
            node.writeInt(i12);
            node.writeInt(i2);
            for (int i14 = i; i14 < toIndex; i14++) {
                byte a4 = byteStrings.get(i14).a(i5);
                if (i14 == i || a4 != byteStrings.get(i14 - 1).a(i5)) {
                    node.writeInt(a4 & UByte.MAX_VALUE);
                }
            }
            d dVar3 = new d();
            while (i < toIndex) {
                byte a5 = byteStrings.get(i).a(i5);
                int i15 = i + 1;
                int i16 = i15;
                while (true) {
                    if (i16 >= toIndex) {
                        i3 = toIndex;
                        break;
                    } else {
                        if (a5 != byteStrings.get(i16).a(i5)) {
                            i3 = i16;
                            break;
                        }
                        i16++;
                    }
                }
                if (i15 == i3 && i5 + 1 == byteStrings.get(i).l()) {
                    node.writeInt(indexes.get(i).intValue());
                    i4 = i3;
                    dVar = dVar3;
                } else {
                    node.writeInt(((int) (a3 + a(dVar3))) * i7);
                    i4 = i3;
                    dVar = dVar3;
                    a(a3, dVar3, i5 + 1, byteStrings, i, i3, indexes);
                }
                dVar3 = dVar;
                i = i4;
                i7 = -1;
            }
            node.a((a0) dVar3);
        }

        static /* synthetic */ void a(Companion companion, long j, d dVar, int i, List list, int i2, int i3, List list2, int i4, Object obj) {
            companion.a((i4 & 1) != 0 ? 0L : j, dVar, (i4 & 4) != 0 ? 0 : i, list, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? list.size() : i3, list2);
        }

        private final long a(d dVar) {
            return dVar.getSize() / 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:46:0x00e5, code lost:
        
            continue;
         */
        @kotlin.jvm.JvmStatic
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final sdk.pendo.io.k3.r a(sdk.pendo.io.k3.g... r17) {
            /*
                Method dump skipped, instructions count: 308
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.k3.r.Companion.a(sdk.pendo.io.k3.g[]):sdk.pendo.io.k3.r");
        }
    }

    private r(g[] gVarArr, int[] iArr) {
        this.byteStrings = gVarArr;
        this.trie = iArr;
    }

    public /* bridge */ boolean a(g gVar) {
        return super.contains(gVar);
    }

    /* renamed from: b, reason: from getter */
    public final int[] getTrie() {
        return this.trie;
    }

    public /* bridge */ int c(g gVar) {
        return super.lastIndexOf(gVar);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof g) {
            return a((g) obj);
        }
        return false;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.byteStrings.length;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof g) {
            return b((g) obj);
        }
        return -1;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof g) {
            return c((g) obj);
        }
        return -1;
    }

    public /* synthetic */ r(g[] gVarArr, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(gVarArr, iArr);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public g get(int index) {
        return this.byteStrings[index];
    }

    public /* bridge */ int b(g gVar) {
        return super.indexOf(gVar);
    }

    /* renamed from: a, reason: from getter */
    public final g[] getByteStrings() {
        return this.byteStrings;
    }
}
