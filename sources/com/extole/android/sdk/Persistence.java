package com.extole.android.sdk;

import com.amplitude.reactnative.DatabaseConstants;
import com.iterable.iterableapi.IterableConstants;
import kotlin.Metadata;

/* compiled from: Persistence.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0007J\u0017\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0002\u0010\nJ\u001d\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0001H&¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/extole/android/sdk/Persistence;", "KEY_TYPE", "VALUE_TYPE", "", IterableConstants.ITERABLE_IN_APP_ACTION_DELETE, "", DatabaseConstants.KEY_FIELD, "(Ljava/lang/Object;)V", "get", "", "(Ljava/lang/Object;)Ljava/lang/String;", "put", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "mobile-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface Persistence<KEY_TYPE, VALUE_TYPE> {
    void delete(KEY_TYPE key);

    String get(KEY_TYPE key);

    void put(KEY_TYPE key, VALUE_TYPE value);
}
