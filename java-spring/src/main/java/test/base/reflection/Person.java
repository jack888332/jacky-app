package test.base.reflection;

public class Person {

	public String name;
	protected int age;
	int height;
	private int weight;

	public Person() {
		super();
	}

	public Person(String name, int age, int height, int weight) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setName(String firstName, String lastName) {
		this.name = firstName + " " + lastName;
	}

	protected int getAge() {
		return age;
	}

	protected void setAge(int age) {
		this.age = age;
	}

	protected int getHeight() {
		return height;
	}

	protected void setHeight(int height) {
		this.height = height;
	}

	protected int getWeight() {
		return weight;
	}

	protected void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + ", weight=" + weight + "]";
	}

}
