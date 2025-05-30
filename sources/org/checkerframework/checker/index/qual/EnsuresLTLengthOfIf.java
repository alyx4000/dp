package org.checkerframework.checker.index.qual;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.framework.qual.ConditionalPostconditionAnnotation;
import org.checkerframework.framework.qual.InheritedAnnotation;
import org.checkerframework.framework.qual.JavaExpression;
import org.checkerframework.framework.qual.QualifierArgument;

@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@InheritedAnnotation
@ConditionalPostconditionAnnotation(qualifier = LTLengthOf.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes6.dex */
public @interface EnsuresLTLengthOfIf {
    String[] expression();

    @QualifierArgument("offset")
    @JavaExpression
    String[] offset() default {};

    boolean result();

    @QualifierArgument("value")
    @JavaExpression
    String[] targetValue();
}
