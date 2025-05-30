package expo.modules.kotlin.types;

import com.facebook.react.bridge.Dynamic;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UnitTypeConverter.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lexpo/modules/kotlin/types/UnitTypeConverter;", "Lexpo/modules/kotlin/types/DynamicAwareTypeConverters;", "", "isOptional", "", "(Z)V", "convertFromAny", "value", "convertFromDynamic", "Lcom/facebook/react/bridge/Dynamic;", "getCppRequiredTypes", "Lexpo/modules/kotlin/jni/ExpectedType;", "expo-modules-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UnitTypeConverter extends DynamicAwareTypeConverters<Object> {
    public UnitTypeConverter(boolean z) {
        super(z);
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public Object convertFromDynamic(Dynamic value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return Unit.INSTANCE;
    }

    @Override // expo.modules.kotlin.types.DynamicAwareTypeConverters
    public Object convertFromAny(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return Unit.INSTANCE;
    }

    @Override // expo.modules.kotlin.types.TypeConverter
    /* renamed from: getCppRequiredTypes */
    public ExpectedType get$cppRequireType() {
        return new ExpectedType(CppType.ANY);
    }
}
