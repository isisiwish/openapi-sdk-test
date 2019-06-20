package top.cfish.openapi.sdk.test.util.config.annotation;

import java.lang.annotation.*;


/**
 * @author: isisiwish
 * @date: 2019/6/13
 * @time: 18:31
 *
 * 自定义@Conf注解，自动将properties注入到静态变量（模仿Spring @Value注解功能）
 *
 * tips
 * 1.配置文件名默认为config.properties
 * 2.main目录和test目录下配置不通用（运行时根目录不同）
 * 3.具体使用参看单元测试用例
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Conf
{
    String value() default "";
}
