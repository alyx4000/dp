package sdk.pendo.io.p0;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import sdk.pendo.io.k0.j;

/* loaded from: classes6.dex */
public class a {
    private static String a(Constructor<?> constructor) {
        StringBuilder append = new StringBuilder(constructor.getDeclaringClass().getName()).append('#').append(constructor.getDeclaringClass().getSimpleName()).append('(');
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        for (int i = 0; i < parameterTypes.length; i++) {
            if (i > 0) {
                append.append(", ");
            }
            append.append(parameterTypes[i].getSimpleName());
        }
        return append.append(')').toString();
    }

    public static String b(Constructor<?> constructor) {
        try {
            constructor.setAccessible(true);
            return null;
        } catch (Exception e) {
            return "Failed making constructor '" + a(constructor) + "' accessible; either change its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: " + e.getMessage();
        }
    }

    public static void a(Field field) {
        try {
            field.setAccessible(true);
        } catch (Exception e) {
            throw new j("Failed making field '" + field.getDeclaringClass().getName() + "#" + field.getName() + "' accessible; either change its visibility or write a custom TypeAdapter for its declaring type", e);
        }
    }
}
