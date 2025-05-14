package sdk.pendo.io.q;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/* loaded from: classes6.dex */
public interface f {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f1506a = Charset.forName("UTF-8");

    boolean equals(Object obj);

    int hashCode();

    void updateDiskCacheKey(MessageDigest messageDigest);
}
