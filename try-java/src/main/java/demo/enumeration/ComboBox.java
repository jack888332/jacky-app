package demo.enumeration;

/* 
	每个枚举常量实际上是枚举类的匿名成员类（静态），设定了调用枚举类构造方法的形参值，以及重写枚举类的抽象方法。
	当枚举常量被引用时，即引用枚举类的实例对象，该对象通过调用枚举类的构造方法来创建。
*/
public enum ComboBox {
	/*
		枚举常量的可选类主体隐式定义了一个匿名类，它扩展了直接封闭的枚举类。
		类主体由匿名类的通常规则管理；特别是它不能包含任何构造函数。
		只有当这些类主体中声明的实例方法覆盖封闭枚举类中的可访问方法时，它们才能在封闭枚举类之外调用。
	*/
	LOW("Low Level", 30) {
		public double getDistance() {
			return 30.0;
		}
	},
	MEDIUM("Medium Level", 15) {
		public double getDistance() {
			return 15.0;
		}
	},
	HIGH("High Level", 7) {
		public double getDistance() {
			return 7.0;
		}
	},
	URGENT("Urgent Level", 1) {
		public double getDistance() {
			return 1.0;
		}
	};

	private int levelValue;
	private String description;

	private ComboBox(String description, int levelValue) {
		this.description = description;
		this.levelValue = levelValue;
	}

	public int getLevelValue() {
		return levelValue;
	}

	@Override
	public String toString() {
		return this.description;
	}

	public abstract double getDistance();



}
