package sdk.pendo.io.m2;

import kotlin.Metadata;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.text.Typography;
import org.apache.commons.io.IOUtils;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002R\u0014\u0010\r\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\fR\u0014\u0010\u0010\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u000f¨\u0006\u0013"}, d2 = {"Lsdk/pendo/io/m2/d;", "", "", "b", "a", "", "c", "", "esc", "", "cl", "", "[C", "ESCAPE_2_CHAR", "", "[B", "CHAR_TO_TOKEN", "<init>", "()V", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f1377a;

    /* renamed from: b, reason: from kotlin metadata */
    public static final char[] ESCAPE_2_CHAR;

    /* renamed from: c, reason: from kotlin metadata */
    public static final byte[] CHAR_TO_TOKEN;

    static {
        d dVar = new d();
        f1377a = dVar;
        ESCAPE_2_CHAR = new char[117];
        CHAR_TO_TOKEN = new byte[126];
        dVar.b();
        dVar.a();
    }

    private d() {
    }

    private final void a(char c, char esc) {
        a((int) c, esc);
    }

    private final void b() {
        for (int i = 0; i < 32; i++) {
            a(i, 'u');
        }
        a(8, 'b');
        a(9, 't');
        a(10, 'n');
        a(12, 'f');
        a(13, 'r');
        a(IOUtils.DIR_SEPARATOR_UNIX, IOUtils.DIR_SEPARATOR_UNIX);
        a(Typography.quote, Typography.quote);
        a(IOUtils.DIR_SEPARATOR_WINDOWS, IOUtils.DIR_SEPARATOR_WINDOWS);
    }

    private final void a(int c, char esc) {
        if (esc != 'u') {
            ESCAPE_2_CHAR[esc] = (char) c;
        }
    }

    private final void a(char c, byte cl) {
        a((int) c, cl);
    }

    private final void a(int c, byte cl) {
        CHAR_TO_TOKEN[c] = cl;
    }

    private final void a() {
        for (int i = 0; i < 33; i++) {
            a(i, ByteCompanionObject.MAX_VALUE);
        }
        a(9, (byte) 3);
        a(10, (byte) 3);
        a(13, (byte) 3);
        a(32, (byte) 3);
        a(',', (byte) 4);
        a(':', (byte) 5);
        a('{', (byte) 6);
        a('}', (byte) 7);
        a('[', (byte) 8);
        a(']', (byte) 9);
        a(Typography.quote, (byte) 1);
        a(IOUtils.DIR_SEPARATOR_WINDOWS, (byte) 2);
    }
}
