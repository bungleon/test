package com.test.reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
//@Target(value=ElementType.METHOD)
public @interface Mask {
    String value() default "default value";
}
