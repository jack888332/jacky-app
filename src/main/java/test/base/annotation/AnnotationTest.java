package test.base.annotation;

public class AnnotationTest {

	public static void main(String[] args) {

	}

}

@Selector(exclude = { @Excluder(name = "iPhone", cost = 9999.9), @Excluder(name = "iPod", cost = 999.9) })
class Person {
	
}
