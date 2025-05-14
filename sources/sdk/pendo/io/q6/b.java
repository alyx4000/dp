package sdk.pendo.io.q6;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes6.dex */
public enum b implements Callable<List<Object>>, sdk.pendo.io.d6.h<Object, List<Object>> {
    INSTANCE;

    @Override // sdk.pendo.io.d6.h
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<Object> apply(Object obj) {
        return new ArrayList();
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public List<Object> call() {
        return new ArrayList();
    }

    public static <T> Callable<List<T>> a() {
        return INSTANCE;
    }
}
