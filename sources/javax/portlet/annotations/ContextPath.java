package javax.portlet.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.inject.Qualifier;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface ContextPath {
}
