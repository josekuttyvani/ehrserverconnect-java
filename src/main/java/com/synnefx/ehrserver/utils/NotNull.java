package com.synnefx.ehrserver.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Josekutty
 * 22-11-2019
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.PARAMETER)
public @interface NotNull {
    String value() default "A mandatory parameter. Must not be null";
}
