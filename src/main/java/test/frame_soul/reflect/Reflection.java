package test.frame_soul.reflect;

import java.lang.reflect.Method;

public class Reflection {
	static Class<?> type;

	public static void main(String[] args) throws Exception {
		init();
		printMethod(type);
	};

	public static void init() throws Exception {
		// 通过类加载器反射类
		type = Class.forName("test.frame_soul.reflect.Person");
		// 通过类字面常量反射类
		type = Person.class;
		// 通过对象反射类
		Person p = new Person();
		type = p.getClass();
	}

	private static void printMethod(Class<?> type) throws Exception {
		Method[] methods;
		Method method;

		System.out.println("-> getMethods");
		methods = type.getMethods();
		for (Method _method : methods) {
			if (_method.getDeclaringClass().getName().equals(type.getName())) {
				System.out.println(_method.getName());
			}
		}

		System.out.println("-> getMethod");
		method = type.getMethod("setName", String.class, String.class);
		System.out.println(method.getName());

		System.out.println("-> getDeclaredMethods");
		methods = type.getDeclaredMethods();
		for (Method _method : methods) {
			if (_method.getDeclaringClass().getName().equals(type.getName())) {
				System.out.println(_method.getName());
			}
		}

		System.out.println("-> getDeclaredMethod");
		method = type.getDeclaredMethod("setName", String.class, String.class);
		System.out.println(method.getName());
	}

}
