package week3.lab7_interfaces_object.lvl4.q10_enumexample;

/**
 * 
 * @author Mohammed {@summary} Enum example from "Effective Java" page 132-133
 * @since 6 Jul 2021
 */
class Figure {
	enum Shape {
		RECTANGLE, CIRCLE
	};

	final Shape shape;

	double length;
	double width;

	double radius;

	Figure(double radius) {
		this.radius = radius;
		this.shape = Shape.CIRCLE;
	}

	Figure(double length, double width) {
		this.length = length;
		this.width = width;
		this.shape = Shape.RECTANGLE;
	}

	double area() {
		switch (shape) {
		case RECTANGLE:
			return length * width;
		case CIRCLE:
			return Math.PI * Math.pow(radius, 2);
		default:
			throw new AssertionError(shape);
		}
	}

	public static void main(String[] args) {
		Figure c1 = new Figure(4);
		Figure r1 = new Figure(3, 6);

		System.out.println(String.format("c1 Area: %.2f", c1.area()));
		System.out.println(String.format("r1 Area: %.2f", r1.area()));
	}

}
