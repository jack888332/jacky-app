package demo.reflection.annotation;

import demo.enumeration.ComboBox;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
注释类型不能从另一个注释类型继承。
注释类型隐式地继承java.lang.annotation.Annotation

注释类型中的方法声明不能带有形式参数。
注释类型中的方法声明不能有throws子句。

在注释类型中声明的方法的返回类型必须是以下类型之一：
任何原始类型：byte，short，int，long，float，double，boolean和char
java.lang.String
java.lang.Class
枚举类型
注释类型
上述任何类型的数组，例如String[]，int[]等

返回类型不能是嵌套数组。例如，您不能具有String[][]或int[][]的返回类型。

注释类型不能是泛型的。
*/

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface WithConfig {
	String name() default "Jack";

	double[] scope() default { 11.1, 99.9 };

	ComboBox[] classify() default { ComboBox.HIGH, ComboBox.LOW };

	Class<? extends Object>[] element() default {String.class, Integer.class};
	
	Excluder[] exclude();
}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Excluder {
	String name();
}
