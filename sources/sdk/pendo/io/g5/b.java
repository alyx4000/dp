package sdk.pendo.io.g5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes6.dex */
public class b {
    private static final List d = Collections.unmodifiableList(new ArrayList());

    /* renamed from: a, reason: collision with root package name */
    private String f1119a;
    private List b;
    private byte[] c;

    public b(String str, List list, byte[] bArr) {
        this.f1119a = str;
        this.b = Collections.unmodifiableList(list);
        this.c = bArr;
    }

    public byte[] a() {
        return this.c;
    }
}
