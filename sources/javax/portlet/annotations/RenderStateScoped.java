package javax.portlet.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.enterprise.context.NormalScope;

@Target({ElementType.TYPE})
@NormalScope
@Inherited
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface RenderStateScoped {
    String paramName() default "";
}
