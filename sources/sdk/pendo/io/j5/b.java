package sdk.pendo.io.j5;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a$\u0010\u0006\u001a\u00020\u00052\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0002*>\u0010\f\u001a\u0004\b\u0000\u0010\u0007\"\u0019\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\b\u000b2\u0019\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0002\b\u000b*\n\u0010\r\"\u00020\u00052\u00020\u0005¨\u0006\u000e"}, d2 = {"Lkotlin/reflect/KClass;", "clazz", "Lsdk/pendo/io/q5/a;", "typeQualifier", "scopeQualifier", "", "a", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "Lsdk/pendo/io/s5/a;", "Lsdk/pendo/io/p5/a;", "Lkotlin/ExtensionFunctionType;", "Definition", "IndexKey", "koin-core"}, k = 2, mv = {1, 9, 0})
/* loaded from: classes6.dex */
public final class b {
    public static final String a(KClass<?> clazz, sdk.pendo.io.q5.a aVar, sdk.pendo.io.q5.a scopeQualifier) {
        String str;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(scopeQualifier, "scopeQualifier");
        if (aVar == null || (str = aVar.getValue()) == null) {
            str = "";
        }
        return sdk.pendo.io.u5.a.a(clazz) + ':' + str + ':' + scopeQualifier;
    }
}
