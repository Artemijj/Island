package island.animal.model;

import java.util.EnumMap;

public enum Animals {
    Wolf(50, 30, 3, 8, "🐺") {
		void fillCanEat() {
			canEat.put(Sheep, 70);
		}
	},
	Fox(8, 30, 2, 2, "🦊") {
		void fillCanEat() {
			canEat.put(Sheep, 30);
		}
	},
	Sheep(15, 140, 3, 7, "🐑") {
		void fillCanEat() {};
	};

	public double weight;
	public int quantity;
	public int speed;
	public double feed;
	public String icon;
	public EnumMap<Animals,Integer> canEat ;

	Animals(double weight, int quantity, int speed, double  feed, String icon) {
		this.weight = weight;
		this.quantity = quantity;
		this.speed = speed;
		this.feed = feed;
		this.icon = icon;
	}
	abstract void fillCanEat();

	// static initializator
	static {
	   for (Animals animal : Animals.values()) {
		animal.canEat = new EnumMap<>(Animals.class);
		animal.fillCanEat();
	   }
        }
}
