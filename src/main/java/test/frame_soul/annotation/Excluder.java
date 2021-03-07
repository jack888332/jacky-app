package test.frame_soul.annotation;

import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Retention;

@Retention(CLASS)
public @interface Excluder {
	String name();

	double cost();

	ComboBox type() default ComboBox.HIGH;
}
