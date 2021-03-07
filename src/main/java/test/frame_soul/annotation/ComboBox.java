package test.frame_soul.annotation;

public enum ComboBox {
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
