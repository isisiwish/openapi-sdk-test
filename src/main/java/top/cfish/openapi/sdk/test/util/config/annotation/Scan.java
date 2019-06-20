package top.cfish.openapi.sdk.test.util.config.annotation;

import java.lang.annotation.*;


/**
 * @author: isisiwish
 * @date: 2019/6/17
 * @time: 10:35
 *
 * 自定义@Scan注解，可以自定义配置文件路径
 *
 * tips
 * 对于未使用@Scan的类，不进行自动配置注入
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scan
{
    String value() default "config.properties";
}
