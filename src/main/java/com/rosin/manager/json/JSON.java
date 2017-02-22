package com.rosin.manager.json;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2017/2/15.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JSON {
    Class<?> type();

    String include() default "";

    String filter() default "";
}
