package top.cfish.openapi.sdk.test.util.annotation;

import java.lang.annotation.*;

/**
 * @author: isisiwish
 * @date: 2019/6/19
 * @time: 17:29
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Passed
{
    String value() default "";
}
