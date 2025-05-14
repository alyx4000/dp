package sdk.pendo.io.j9;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import sdk.pendo.io.e9.b;
import sdk.pendo.io.logging.PendoLogger;
import sdk.pendo.io.x5.j;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u000e2\u00020\u0001:\u0003\u0018\u0019\u001aB\u0007¢\u0006\u0004\b\u0017\u0010\u0015J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J,\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\rR<\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u000fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0002`\u00108\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\t\u0010\u0011\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001b"}, d2 = {"Lsdk/pendo/io/j9/b;", "", "Lsdk/pendo/io/j9/a;", "file", "", "fileName", "Ljava/io/File;", "fileLocation", "", "a", "Lsdk/pendo/io/j9/b$d;", "openMode", "failIfExist", "", "b", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "getFiles", "()Ljava/util/HashMap;", "getFiles$annotations", "()V", "files", "<init>", "c", "d", "e", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class b {

    /* renamed from: b, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static b c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final HashMap<String, sdk.pendo.io.j9.a> files = new HashMap<>();

    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lsdk/pendo/io/e9/b$c;", "state", "", "a", "(Lsdk/pendo/io/e9/b$c;)Ljava/lang/Boolean;"}, k = 3, mv = {1, 9, 0})
    static final class a extends Lambda implements Function1<b.c, Boolean> {
        public static final a f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(b.c state) {
            Intrinsics.checkNotNullParameter(state, "state");
            return Boolean.valueOf(state == b.c.IN_BACKGROUND);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lsdk/pendo/io/e9/b$c;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lsdk/pendo/io/e9/b$c;)V"}, k = 3, mv = {1, 9, 0})
    /* renamed from: sdk.pendo.io.j9.b$b, reason: collision with other inner class name */
    static final class C0167b extends Lambda implements Function1<b.c, Unit> {
        C0167b() {
            super(1);
        }

        public final void a(b.c cVar) {
            b.this.b();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(b.c cVar) {
            a(cVar);
            return Unit.INSTANCE;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lsdk/pendo/io/j9/b$c;", "", "Lsdk/pendo/io/j9/b;", "a", "()Lsdk/pendo/io/j9/b;", "INSTANCE", "INSTANCE_NULLABLE", "Lsdk/pendo/io/j9/b;", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    /* renamed from: sdk.pendo.io.j9.b$c, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b a() {
            if (b.c == null) {
                b.c = new b();
            }
            b bVar = b.c;
            Intrinsics.checkNotNull(bVar);
            return bVar;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00152\u00020\u0001:\u0001\bB\t\b\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\b\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u001a\u0010\r\u001a\u00020\t8\u0016X\u0096D¢\u0006\f\n\u0004\b\b\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0012\u001a\u00020\u00068\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\b\u0010\u0010\"\u0004\b\b\u0010\u0011\u0082\u0001\u0001\u0016¨\u0006\u0017"}, d2 = {"Lsdk/pendo/io/j9/b$d;", "", "Lsdk/pendo/io/j9/a;", "file", "", "fileName", "Ljava/io/File;", "fileLocation", "a", "", "I", "getMode", "()I", "mode", "b", "Ljava/io/File;", "()Ljava/io/File;", "(Ljava/io/File;)V", "realFile", "<init>", "()V", "c", "Lsdk/pendo/io/j9/b$e;", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static abstract class d {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int mode;

        /* renamed from: b, reason: from kotlin metadata */
        public File realFile;

        private d() {
            this.mode = -1;
        }

        public final File a(String fileName, File fileLocation) {
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            Intrinsics.checkNotNullParameter(fileLocation, "fileLocation");
            return new File(fileLocation, fileName);
        }

        public abstract sdk.pendo.io.j9.a a(sdk.pendo.io.j9.a file, String fileName, File fileLocation);

        public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final File a() {
            File file = this.realFile;
            if (file != null) {
                return file;
            }
            Intrinsics.throwUninitializedPropertyAccessException("realFile");
            return null;
        }

        public final void a(File file) {
            Intrinsics.checkNotNullParameter(file, "<set-?>");
            this.realFile = file;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\"\u0010\b\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"Lsdk/pendo/io/j9/b$e;", "Lsdk/pendo/io/j9/b$d;", "Lsdk/pendo/io/j9/a;", "file", "", "fileName", "Ljava/io/File;", "fileLocation", "a", "", "openMode", "", "<init>", "()V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
    public static final class e extends d {
        public e() {
            super(null);
        }

        @Override // sdk.pendo.io.j9.b.d
        public sdk.pendo.io.j9.a a(sdk.pendo.io.j9.a file, String fileName, File fileLocation) {
            Intrinsics.checkNotNullParameter(fileName, "fileName");
            Intrinsics.checkNotNullParameter(fileLocation, "fileLocation");
            if (file != null) {
                a(file.getOpenMode());
                return file;
            }
            a(a(fileName, fileLocation));
            if (a().exists()) {
                a().delete();
            }
            a().createNewFile();
            return new sdk.pendo.io.j9.a(a(), 0, null, 4, null);
        }

        public boolean a(int openMode) {
            if (openMode == 0 || openMode == 1) {
                return true;
            }
            throw new Exception("File open in a different mode");
        }
    }

    public b() {
        j<b.c> a2 = sdk.pendo.io.e9.b.e().a(true);
        final a aVar = a.f;
        j<b.c> a3 = a2.a(new sdk.pendo.io.d6.j() { // from class: sdk.pendo.io.j9.b$$ExternalSyntheticLambda0
            @Override // sdk.pendo.io.d6.j
            public final boolean test(Object obj) {
                boolean a4;
                a4 = b.a(Function1.this, obj);
                return a4;
            }
        });
        final C0167b c0167b = new C0167b();
        a3.a(new sdk.pendo.io.d6.e() { // from class: sdk.pendo.io.j9.b$$ExternalSyntheticLambda1
            @Override // sdk.pendo.io.d6.e
            public final void accept(Object obj) {
                b.b(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean a(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        return ((Boolean) tmp0.invoke(obj)).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void b() {
        Collection<sdk.pendo.io.j9.a> values = this.files.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        Iterator<T> it = values.iterator();
        while (it.hasNext()) {
            ((sdk.pendo.io.j9.a) it.next()).a();
        }
    }

    public final sdk.pendo.io.j9.a a(String fileName, File fileLocation, d openMode, boolean failIfExist) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(fileLocation, "fileLocation");
        Intrinsics.checkNotNullParameter(openMode, "openMode");
        try {
            sdk.pendo.io.j9.a aVar = this.files.get(fileLocation.getPath() + "/" + fileName);
            if (failIfExist && a(aVar, fileName, fileLocation)) {
                throw new Exception("file exist");
            }
            sdk.pendo.io.j9.a a2 = openMode.a(aVar, fileName, fileLocation);
            this.files.put(fileLocation + "/" + fileName, a2);
            return a2;
        } catch (Exception e2) {
            PendoLogger.d(e2, "FileUtilsManager createFile", new Object[0]);
            return null;
        }
    }

    public static /* synthetic */ sdk.pendo.io.j9.a a(b bVar, String str, File file, d dVar, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            dVar = new e();
        }
        if ((i & 8) != 0) {
            z = false;
        }
        return bVar.a(str, file, dVar, z);
    }

    private final boolean a(sdk.pendo.io.j9.a file, String fileName, File fileLocation) {
        return file != null ? file.c() : new File(fileLocation, fileName).exists();
    }
}
