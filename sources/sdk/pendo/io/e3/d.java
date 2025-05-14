package sdk.pendo.io.e3;

import com.facebook.common.callercontext.ContextChain;
import com.google.firebase.messaging.Constants;
import com.iterable.iterableapi.IterableConstants;
import com.socure.docv.capturesdk.common.utils.ApiConstant;
import expo.modules.interfaces.permissions.PermissionsResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.k3.a0;
import sdk.pendo.io.k3.o;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0007\nB\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR#\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000f\u001a\u0004\b\u0007\u0010\u0010¨\u0006\u0014"}, d2 = {"Lsdk/pendo/io/e3/d;", "", "", "Lsdk/pendo/io/k3/g;", "", "c", "name", "a", "", "Lsdk/pendo/io/e3/c;", "b", "[Lsdk/pendo/io/e3/c;", "getSTATIC_HEADER_TABLE", "()[Lokhttp3/internal/http2/Header;", "STATIC_HEADER_TABLE", "Ljava/util/Map;", "()Ljava/util/Map;", "NAME_TO_FIRST_INDEX", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 8, 0})
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f1012a;

    /* renamed from: b, reason: from kotlin metadata */
    private static final c[] STATIC_HEADER_TABLE;

    /* renamed from: c, reason: from kotlin metadata */
    private static final Map<sdk.pendo.io.k3.g, Integer> NAME_TO_FIRST_INDEX;

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020%\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005¢\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0002J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013J\u0006\u0010\f\u001a\u00020\u0002J\u0016\u0010\u0003\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\rR\u0014\u0010\u0017\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0016R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00110\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u001dR\u001e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010 R\u0016\u0010\"\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0016R\u0016\u0010#\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0016R\u0016\u0010$\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0016¨\u0006("}, d2 = {"Lsdk/pendo/io/e3/d$a;", "", "", "a", "b", "", "bytesToRecover", "index", "e", "g", "h", "nameIndex", "f", "Lsdk/pendo/io/k3/g;", "c", "", "d", "Lsdk/pendo/io/e3/c;", "entry", "", "firstByte", "prefixMask", "I", "headerTableSizeSetting", "maxDynamicTableByteCount", "", "Ljava/util/List;", "headerList", "Lsdk/pendo/io/k3/f;", "Lsdk/pendo/io/k3/f;", "source", "", "[Lsdk/pendo/io/e3/c;", "dynamicTable", "nextHeaderIndex", "headerCount", "dynamicTableByteCount", "Lsdk/pendo/io/k3/a0;", "<init>", "(Lokio/Source;II)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int headerTableSizeSetting;

        /* renamed from: b, reason: from kotlin metadata */
        private int maxDynamicTableByteCount;

        /* renamed from: c, reason: from kotlin metadata */
        private final List<c> headerList;

        /* renamed from: d, reason: from kotlin metadata */
        private final sdk.pendo.io.k3.f source;

        /* renamed from: e, reason: from kotlin metadata */
        public c[] dynamicTable;

        /* renamed from: f, reason: from kotlin metadata */
        private int nextHeaderIndex;

        /* renamed from: g, reason: from kotlin metadata */
        public int headerCount;

        /* renamed from: h, reason: from kotlin metadata */
        public int dynamicTableByteCount;

        public a(a0 source, int i, int i2) {
            Intrinsics.checkNotNullParameter(source, "source");
            this.headerTableSizeSetting = i;
            this.maxDynamicTableByteCount = i2;
            this.headerList = new ArrayList();
            this.source = o.a(source);
            this.dynamicTable = new c[8];
            this.nextHeaderIndex = 7;
        }

        private final void a() {
            int i = this.maxDynamicTableByteCount;
            int i2 = this.dynamicTableByteCount;
            if (i < i2) {
                if (i == 0) {
                    b();
                } else {
                    b(i2 - i);
                }
            }
        }

        private final void b() {
            ArraysKt.fill$default(this.dynamicTable, (Object) null, 0, 0, 6, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final boolean d(int index) {
            return index >= 0 && index <= d.f1012a.b().length - 1;
        }

        private final void g() {
            a(-1, new c(d.f1012a.a(e()), e()));
        }

        private final void h() {
            this.headerList.add(new c(d.f1012a.a(e()), e()));
        }

        public final List<c> c() {
            List<c> list = CollectionsKt.toList(this.headerList);
            this.headerList.clear();
            return list;
        }

        public final sdk.pendo.io.k3.g e() {
            int d = d();
            boolean z = (d & 128) == 128;
            long a2 = a(d, 127);
            if (!z) {
                return this.source.c(a2);
            }
            sdk.pendo.io.k3.d dVar = new sdk.pendo.io.k3.d();
            k.f1020a.a(this.source, a2, dVar);
            return dVar.t();
        }

        public final void f() {
            while (!this.source.i()) {
                int a2 = sdk.pendo.io.x2.b.a(this.source.readByte(), 255);
                if (a2 == 128) {
                    throw new IOException("index == 0");
                }
                if ((a2 & 128) == 128) {
                    e(a(a2, 127) - 1);
                } else if (a2 == 64) {
                    g();
                } else if ((a2 & 64) == 64) {
                    f(a(a2, 63) - 1);
                } else if ((a2 & 32) == 32) {
                    int a3 = a(a2, 31);
                    this.maxDynamicTableByteCount = a3;
                    if (a3 < 0 || a3 > this.headerTableSizeSetting) {
                        throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                    }
                    a();
                } else if (a2 == 16 || a2 == 0) {
                    h();
                } else {
                    g(a(a2, 15) - 1);
                }
            }
        }

        public /* synthetic */ a(a0 a0Var, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(a0Var, i, (i3 & 4) != 0 ? i : i2);
        }

        private final int a(int index) {
            return this.nextHeaderIndex + 1 + index;
        }

        private final int b(int bytesToRecover) {
            int i;
            int i2 = 0;
            if (bytesToRecover > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i = this.nextHeaderIndex;
                    if (length < i || bytesToRecover <= 0) {
                        break;
                    }
                    c cVar = this.dynamicTable[length];
                    Intrinsics.checkNotNull(cVar);
                    int i3 = cVar.hpackSize;
                    bytesToRecover -= i3;
                    this.dynamicTableByteCount -= i3;
                    this.headerCount--;
                    i2++;
                }
                c[] cVarArr = this.dynamicTable;
                int i4 = i + 1;
                System.arraycopy(cVarArr, i4, cVarArr, i4 + i2, this.headerCount);
                this.nextHeaderIndex += i2;
            }
            return i2;
        }

        private final sdk.pendo.io.k3.g c(int index) {
            c cVar;
            if (!d(index)) {
                int a2 = a(index - d.f1012a.b().length);
                if (a2 >= 0) {
                    c[] cVarArr = this.dynamicTable;
                    if (a2 < cVarArr.length) {
                        cVar = cVarArr[a2];
                        Intrinsics.checkNotNull(cVar);
                    }
                }
                throw new IOException("Header index too large " + (index + 1));
            }
            cVar = d.f1012a.b()[index];
            return cVar.name;
        }

        private final int d() {
            return sdk.pendo.io.x2.b.a(this.source.readByte(), 255);
        }

        private final void e(int index) {
            if (d(index)) {
                this.headerList.add(d.f1012a.b()[index]);
                return;
            }
            int a2 = a(index - d.f1012a.b().length);
            if (a2 >= 0) {
                c[] cVarArr = this.dynamicTable;
                if (a2 < cVarArr.length) {
                    List<c> list = this.headerList;
                    c cVar = cVarArr[a2];
                    Intrinsics.checkNotNull(cVar);
                    list.add(cVar);
                    return;
                }
            }
            throw new IOException("Header index too large " + (index + 1));
        }

        private final void f(int nameIndex) {
            a(-1, new c(c(nameIndex), e()));
        }

        private final void g(int index) {
            this.headerList.add(new c(c(index), e()));
        }

        private final void a(int index, c entry) {
            this.headerList.add(entry);
            int i = entry.hpackSize;
            if (index != -1) {
                c cVar = this.dynamicTable[a(index)];
                Intrinsics.checkNotNull(cVar);
                i -= cVar.hpackSize;
            }
            int i2 = this.maxDynamicTableByteCount;
            if (i > i2) {
                b();
                return;
            }
            int b = b((this.dynamicTableByteCount + i) - i2);
            if (index == -1) {
                int i3 = this.headerCount + 1;
                c[] cVarArr = this.dynamicTable;
                if (i3 > cVarArr.length) {
                    c[] cVarArr2 = new c[cVarArr.length * 2];
                    System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = cVarArr2;
                }
                int i4 = this.nextHeaderIndex;
                this.nextHeaderIndex = i4 - 1;
                this.dynamicTable[i4] = entry;
                this.headerCount++;
            } else {
                this.dynamicTable[index + a(index) + b] = entry;
            }
            this.dynamicTableByteCount += i;
        }

        public final int a(int firstByte, int prefixMask) {
            int i = firstByte & prefixMask;
            if (i < prefixMask) {
                return i;
            }
            int i2 = 0;
            while (true) {
                int d = d();
                if ((d & 128) == 0) {
                    return prefixMask + (d << i2);
                }
                prefixMask += (d & 127) << i2;
                i2 += 7;
            }
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\f\u0018\u00002\u00020\u0001B%\b\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0015¢\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0014\u0010\u0006\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\tJ\u001e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0004R\u0016\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0011R\u0016\u0010\u001c\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u0013R\u0016\u0010\u001e\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0011R\u001e\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u0011R\u0016\u0010&\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b%\u0010\u0011R\u0016\u0010(\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b'\u0010\u0011¨\u0006+"}, d2 = {"Lsdk/pendo/io/e3/d$b;", "", "", "b", "", "bytesToRecover", "a", "Lsdk/pendo/io/e3/c;", "entry", "", "headerBlock", "value", "prefixMask", "bits", "Lsdk/pendo/io/k3/g;", "data", "headerTableSizeSetting", "I", "", "Z", "useCompression", "Lsdk/pendo/io/k3/d;", "c", "Lsdk/pendo/io/k3/d;", "out", "d", "smallestHeaderTableSizeSetting", "e", "emitDynamicTableSizeUpdate", "f", "maxDynamicTableByteCount", "", "g", "[Lsdk/pendo/io/e3/c;", "dynamicTable", "h", "nextHeaderIndex", ContextChain.TAG_INFRA, "headerCount", "j", "dynamicTableByteCount", "<init>", "(IZLokio/Buffer;)V", "okhttp"}, k = 1, mv = {1, 8, 0})
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public int headerTableSizeSetting;

        /* renamed from: b, reason: from kotlin metadata */
        private final boolean useCompression;

        /* renamed from: c, reason: from kotlin metadata */
        private final sdk.pendo.io.k3.d out;

        /* renamed from: d, reason: from kotlin metadata */
        private int smallestHeaderTableSizeSetting;

        /* renamed from: e, reason: from kotlin metadata */
        private boolean emitDynamicTableSizeUpdate;

        /* renamed from: f, reason: from kotlin metadata */
        public int maxDynamicTableByteCount;

        /* renamed from: g, reason: from kotlin metadata */
        public c[] dynamicTable;

        /* renamed from: h, reason: from kotlin metadata */
        private int nextHeaderIndex;

        /* renamed from: i, reason: from kotlin metadata */
        public int headerCount;

        /* renamed from: j, reason: from kotlin metadata */
        public int dynamicTableByteCount;

        public b(int i, boolean z, sdk.pendo.io.k3.d out) {
            Intrinsics.checkNotNullParameter(out, "out");
            this.headerTableSizeSetting = i;
            this.useCompression = z;
            this.out = out;
            this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
            this.maxDynamicTableByteCount = i;
            this.dynamicTable = new c[8];
            this.nextHeaderIndex = 7;
        }

        private final void a() {
            int i = this.maxDynamicTableByteCount;
            int i2 = this.dynamicTableByteCount;
            if (i < i2) {
                if (i == 0) {
                    b();
                } else {
                    a(i2 - i);
                }
            }
        }

        private final void b() {
            ArraysKt.fill$default(this.dynamicTable, (Object) null, 0, 0, 6, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        public /* synthetic */ b(int i, boolean z, sdk.pendo.io.k3.d dVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? 4096 : i, (i2 & 2) != 0 ? true : z, dVar);
        }

        private final int a(int bytesToRecover) {
            int i;
            int i2 = 0;
            if (bytesToRecover > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i = this.nextHeaderIndex;
                    if (length < i || bytesToRecover <= 0) {
                        break;
                    }
                    c cVar = this.dynamicTable[length];
                    Intrinsics.checkNotNull(cVar);
                    bytesToRecover -= cVar.hpackSize;
                    int i3 = this.dynamicTableByteCount;
                    c cVar2 = this.dynamicTable[length];
                    Intrinsics.checkNotNull(cVar2);
                    this.dynamicTableByteCount = i3 - cVar2.hpackSize;
                    this.headerCount--;
                    i2++;
                }
                c[] cVarArr = this.dynamicTable;
                int i4 = i + 1;
                System.arraycopy(cVarArr, i4, cVarArr, i4 + i2, this.headerCount);
                c[] cVarArr2 = this.dynamicTable;
                int i5 = this.nextHeaderIndex + 1;
                Arrays.fill(cVarArr2, i5, i5 + i2, (Object) null);
                this.nextHeaderIndex += i2;
            }
            return i2;
        }

        public final void b(int headerTableSizeSetting) {
            this.headerTableSizeSetting = headerTableSizeSetting;
            int min = Math.min(headerTableSizeSetting, 16384);
            int i = this.maxDynamicTableByteCount;
            if (i == min) {
                return;
            }
            if (min < i) {
                this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, min);
            }
            this.emitDynamicTableSizeUpdate = true;
            this.maxDynamicTableByteCount = min;
            a();
        }

        private final void a(c entry) {
            int i = entry.hpackSize;
            int i2 = this.maxDynamicTableByteCount;
            if (i > i2) {
                b();
                return;
            }
            a((this.dynamicTableByteCount + i) - i2);
            int i3 = this.headerCount + 1;
            c[] cVarArr = this.dynamicTable;
            if (i3 > cVarArr.length) {
                c[] cVarArr2 = new c[cVarArr.length * 2];
                System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = cVarArr2;
            }
            int i4 = this.nextHeaderIndex;
            this.nextHeaderIndex = i4 - 1;
            this.dynamicTable[i4] = entry;
            this.headerCount++;
            this.dynamicTableByteCount += i;
        }

        public final void a(sdk.pendo.io.k3.g data) {
            int l;
            int i;
            Intrinsics.checkNotNullParameter(data, "data");
            if (this.useCompression) {
                k kVar = k.f1020a;
                if (kVar.a(data) < data.l()) {
                    sdk.pendo.io.k3.d dVar = new sdk.pendo.io.k3.d();
                    kVar.a(data, dVar);
                    data = dVar.t();
                    l = data.l();
                    i = 128;
                    a(l, 127, i);
                    this.out.a(data);
                }
            }
            l = data.l();
            i = 0;
            a(l, 127, i);
            this.out.a(data);
        }

        public final void a(List<c> headerBlock) {
            int i;
            int i2;
            Intrinsics.checkNotNullParameter(headerBlock, "headerBlock");
            if (this.emitDynamicTableSizeUpdate) {
                int i3 = this.smallestHeaderTableSizeSetting;
                if (i3 < this.maxDynamicTableByteCount) {
                    a(i3, 31, 32);
                }
                this.emitDynamicTableSizeUpdate = false;
                this.smallestHeaderTableSizeSetting = Integer.MAX_VALUE;
                a(this.maxDynamicTableByteCount, 31, 32);
            }
            int size = headerBlock.size();
            for (int i4 = 0; i4 < size; i4++) {
                c cVar = headerBlock.get(i4);
                sdk.pendo.io.k3.g m = cVar.name.m();
                sdk.pendo.io.k3.g gVar = cVar.value;
                d dVar = d.f1012a;
                Integer num = dVar.a().get(m);
                if (num != null) {
                    i2 = num.intValue() + 1;
                    if (2 <= i2 && i2 < 8) {
                        if (Intrinsics.areEqual(dVar.b()[i2 - 1].value, gVar)) {
                            i = i2;
                        } else if (Intrinsics.areEqual(dVar.b()[i2].value, gVar)) {
                            i2++;
                            i = i2;
                        }
                    }
                    i = i2;
                    i2 = -1;
                } else {
                    i = -1;
                    i2 = -1;
                }
                if (i2 == -1) {
                    int i5 = this.nextHeaderIndex + 1;
                    int length = this.dynamicTable.length;
                    while (true) {
                        if (i5 >= length) {
                            break;
                        }
                        c cVar2 = this.dynamicTable[i5];
                        Intrinsics.checkNotNull(cVar2);
                        if (Intrinsics.areEqual(cVar2.name, m)) {
                            c cVar3 = this.dynamicTable[i5];
                            Intrinsics.checkNotNull(cVar3);
                            if (Intrinsics.areEqual(cVar3.value, gVar)) {
                                i2 = d.f1012a.b().length + (i5 - this.nextHeaderIndex);
                                break;
                            } else if (i == -1) {
                                i = (i5 - this.nextHeaderIndex) + d.f1012a.b().length;
                            }
                        }
                        i5++;
                    }
                }
                if (i2 != -1) {
                    a(i2, 127, 128);
                } else {
                    if (i == -1) {
                        this.out.writeByte(64);
                        a(m);
                    } else if (!m.b(c.e) || Intrinsics.areEqual(c.j, m)) {
                        a(i, 63, 64);
                    } else {
                        a(i, 15, 0);
                        a(gVar);
                    }
                    a(gVar);
                    a(cVar);
                }
            }
        }

        public final void a(int value, int prefixMask, int bits) {
            int i;
            sdk.pendo.io.k3.d dVar;
            if (value < prefixMask) {
                dVar = this.out;
                i = value | bits;
            } else {
                this.out.writeByte(bits | prefixMask);
                i = value - prefixMask;
                while (i >= 128) {
                    this.out.writeByte(128 | (i & 127));
                    i >>>= 7;
                }
                dVar = this.out;
            }
            dVar.writeByte(i);
        }
    }

    static {
        d dVar = new d();
        f1012a = dVar;
        sdk.pendo.io.k3.g gVar = c.g;
        sdk.pendo.io.k3.g gVar2 = c.h;
        sdk.pendo.io.k3.g gVar3 = c.i;
        sdk.pendo.io.k3.g gVar4 = c.f;
        STATIC_HEADER_TABLE = new c[]{new c(c.j, ""), new c(gVar, "GET"), new c(gVar, "POST"), new c(gVar2, "/"), new c(gVar2, "/index.html"), new c(gVar3, "http"), new c(gVar3, "https"), new c(gVar4, "200"), new c(gVar4, "204"), new c(gVar4, "206"), new c(gVar4, "304"), new c(gVar4, "400"), new c(gVar4, "404"), new c(gVar4, "500"), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c("accept-ranges", ""), new c("accept", ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c("cache-control", ""), new c("content-disposition", ""), new c("content-encoding", ""), new c("content-language", ""), new c("content-length", ""), new c("content-location", ""), new c("content-range", ""), new c(ApiConstant.HEADER_CONTENT_TYPE, ""), new c("cookie", ""), new c("date", ""), new c("etag", ""), new c("expect", ""), new c(PermissionsResponse.EXPIRES_KEY, ""), new c(Constants.MessagePayloadKeys.FROM, ""), new c("host", ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c("link", ""), new c(IterableConstants.ITERABLE_IN_APP_LOCATION, ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c("range", ""), new c("referer", ""), new c("refresh", ""), new c("retry-after", ""), new c("server", ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c("www-authenticate", "")};
        NAME_TO_FIRST_INDEX = dVar.c();
    }

    private d() {
    }

    private final Map<sdk.pendo.io.k3.g, Integer> c() {
        c[] cVarArr = STATIC_HEADER_TABLE;
        LinkedHashMap linkedHashMap = new LinkedHashMap(cVarArr.length);
        int length = cVarArr.length;
        for (int i = 0; i < length; i++) {
            c[] cVarArr2 = STATIC_HEADER_TABLE;
            if (!linkedHashMap.containsKey(cVarArr2[i].name)) {
                linkedHashMap.put(cVarArr2[i].name, Integer.valueOf(i));
            }
        }
        Map<sdk.pendo.io.k3.g, Integer> unmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics.checkNotNullExpressionValue(unmodifiableMap, "unmodifiableMap(result)");
        return unmodifiableMap;
    }

    public final sdk.pendo.io.k3.g a(sdk.pendo.io.k3.g name) {
        Intrinsics.checkNotNullParameter(name, "name");
        int l = name.l();
        for (int i = 0; i < l; i++) {
            byte a2 = name.a(i);
            if (65 <= a2 && a2 < 91) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + name.o());
            }
        }
        return name;
    }

    public final c[] b() {
        return STATIC_HEADER_TABLE;
    }

    public final Map<sdk.pendo.io.k3.g, Integer> a() {
        return NAME_TO_FIRST_INDEX;
    }
}
