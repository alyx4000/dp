package javax.portlet.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes2.dex */
public @interface PortletLifecycleFilter {
    LocaleString[] description() default {};

    LocaleString[] displayName() default {};

    String filterName() default "";

    InitParameter[] initParams() default {};

    int ordinal() default 0;

    String[] portletNames() default {"*"};
}
