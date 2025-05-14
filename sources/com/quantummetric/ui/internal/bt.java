package com.quantummetric.ui.internal;

/* loaded from: classes5.dex */
public final class bt {
    public static j[] a(j[] jVarArr, j jVar) {
        int length = jVarArr != null ? 1 + jVarArr.length : 1;
        j[] jVarArr2 = new j[length];
        int i = length - 1;
        if (jVarArr != null) {
            System.arraycopy(jVarArr, 0, jVarArr2, 0, i);
        }
        jVarArr2[i] = jVar;
        return jVarArr2;
    }
}
