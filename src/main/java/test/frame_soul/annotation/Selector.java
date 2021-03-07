package test.frame_soul.annotation;

import static java.lang.annotation.RetentionPolicy.CLASS;
import java.lang.annotation.Retention;

@Retention(CLASS)
public @interface Selector {
	String[] name() default { "Jack", "Rose" };

	double[] cost() default { 11.1, 99.9 };

	ComboBox[] type() default { ComboBox.HIGH, ComboBox.LOW };

	Excluder[] exclude();

	Class<?> element1() default Object.class; // Any Class type

	Class<String> element2() default String.class; // Only Test class type

	Class<? extends String> element3() default String.class; // Test or its subclass type
}