package week3.lab7_interfaces_object.lvl4.q11_immutableclass;

/**
 * 
 * @author Mohammed
 * @since 6 Jul 2021
 * @see effective java p 103-104 Immutable class example
 */
public final class Complex {
	private final double real;
	private final double imag;

	public Complex(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}

	public double getRealPart() {
		return real;
	}

	public double getImagPart() {
		return imag;
	}

	public Complex plus(Complex other) {
		return new Complex(real + other.real, imag + other.imag);
	}

	public Complex minus(Complex other) {
		return new Complex(real - other.real, imag - other.imag);
	}

	public Complex times(Complex other) {
		double tmp = other.real * other.real + other.imag * other.imag;
		return new Complex((real * other.real + imag * other.imag) / tmp,
				(imag * other.real - real * other.imag) / tmp);
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Complex))
			return false;
		Complex c = (Complex) o;
		// See page 47 to find out why we use compare instead of ==
		return Double.compare(c.real, real) == 0 && Double.compare(c.imag, imag) == 0;
	}

	@Override
	public int hashCode() {
		return 31 * Double.hashCode(real) + Double.hashCode(imag);
	}

	@Override
	public String toString() {
		return "(" + real + " + " + imag + "i)";
	}

	public static void main(String[] args) {
		Complex c1 = new Complex(1, 3);
		Complex c2 = new Complex(3, 4);
		
		System.out.println(String.format("summation of %s and %s equals %s", c1, c2, c1.plus(c2)));
	}

}
