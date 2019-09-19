package com.boshuo.annotation;

import java.lang.annotation.*;

/**
 * @Author: gan.hu
 * @Date: 2019/4/9 18:58
 */
@Documented
@Inherited
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DB {

    String value() default "";

}
