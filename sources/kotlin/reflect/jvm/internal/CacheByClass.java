package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import com.amplitude.reactnative.DatabaseConstants;
import kotlin.Metadata;

/* compiled from: CacheByClass.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\u0019\u0010\u0006\u001a\u00028\u00002\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH&¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/CacheByClass;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "()V", "clear", "", "get", DatabaseConstants.KEY_FIELD, "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "kotlin-reflection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CacheByClass<V> {
    public abstract void clear();

    public abstract V get(Class<?> key);
}
