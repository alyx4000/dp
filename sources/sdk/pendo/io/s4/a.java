package sdk.pendo.io.s4;

import java.security.AlgorithmParameters;
import java.security.Key;
import java.util.Set;

/* loaded from: classes6.dex */
public interface a {
    boolean permits(Set<b> set, String str, AlgorithmParameters algorithmParameters);

    boolean permits(Set<b> set, String str, Key key, AlgorithmParameters algorithmParameters);

    boolean permits(Set<b> set, Key key);
}
