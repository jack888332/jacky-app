package demo.reflection.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

@Scanner(referencedClass = "test.base.reflection.annotation.Car")
public class AnnotationParser {

	public static void main(String[] args) {
		Class<AnnotationParser> ap = AnnotationParser.class;
		Scanner scanner = (Scanner) ap.getAnnotation(Scanner.class);
		
		try {
			Class<?> targetClass = Class.forName(scanner.referencedClass());
			for (Annotation annotation : targetClass.getAnnotations()) {
				if (annotation instanceof WithConfig) {
					WithConfig wc = (WithConfig) annotation;
					Method[] methods = targetClass.getDeclaredMethods();
					for(Method _method : methods) {
						for(Parameter para : _method.getParameters()) {
							System.out.println(para.getType());
						}	
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}

@Retention(RetentionPolicy.RUNTIME)
@interface Scanner {
	String referencedClass();
}