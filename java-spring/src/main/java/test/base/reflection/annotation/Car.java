package test.base.reflection.annotation;

@WithConfig(name = "Jacky", exclude = { @Excluder(name = "Mike") })
public class Car {
	private String brand;
	private Double speed;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}
}

