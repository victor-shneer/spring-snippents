package com.carmel.executor.api.customAnnotation;

import java.lang.annotation.*;

//@Retention(RetentionPolicy.SOURCE) // visibility of a usage of annotation from different points
//@Retention(RetentionPolicy.CLASS)
@Retention(RetentionPolicy.RUNTIME)
@Documented // Include in Java Doc
@Inherited // Makes all subclasses also annotated
@Target(ElementType.TYPE) // suitable only with types, no methods, fields etc.
public @interface MyAnnotation {
    String name() default "";
    int count() default 0;
    String[] tags() default {"Java"};
}
