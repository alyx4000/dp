package org.bouncycastle.pqc.jcajce.interfaces;

import java.security.PrivateKey;

/* loaded from: classes6.dex */
public interface XMSSPrivateKey extends XMSSKey, PrivateKey {
    XMSSPrivateKey extractKeyShard(int i);

    long getIndex();

    long getUsagesRemaining();
}
