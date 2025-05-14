package sdk.pendo.io.e2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import sdk.pendo.io.b2.g;
import sdk.pendo.io.b2.h;

/* loaded from: classes6.dex */
public class b implements e<Object> {
    @Override // sdk.pendo.io.e2.e
    public <E> void a(E e, Appendable appendable, g gVar) {
        Method method;
        Object invoke;
        Class<?> type;
        try {
            gVar.j(appendable);
            boolean z = false;
            for (Class<?> cls = e.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
                for (Field field : cls.getDeclaredFields()) {
                    int modifiers = field.getModifiers();
                    if ((modifiers & 152) <= 0) {
                        if ((modifiers & 1) > 0) {
                            invoke = field.get(e);
                        } else {
                            try {
                                method = cls.getDeclaredMethod(h.a(field.getName()), new Class[0]);
                            } catch (Exception unused) {
                                method = null;
                            }
                            if (method == null && ((type = field.getType()) == Boolean.TYPE || type == Boolean.class)) {
                                method = cls.getDeclaredMethod(h.b(field.getName()), new Class[0]);
                            }
                            if (method != null) {
                                invoke = method.invoke(e, new Object[0]);
                            }
                        }
                        if (invoke != null || !gVar.a()) {
                            if (z) {
                                gVar.i(appendable);
                            } else {
                                z = true;
                            }
                            d.a(field.getName(), invoke, appendable, gVar);
                        }
                    }
                }
            }
            gVar.k(appendable);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
