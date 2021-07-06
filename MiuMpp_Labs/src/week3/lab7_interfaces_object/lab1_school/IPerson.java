package week3.lab7_interfaces_object.lab1_school;

public interface IPerson {
	public default String myDefault() {
		String output = "From default method";
		System.out.println(output);
		return output;
	}

	public static String myStatic() {
		String output = "From static method";
		System.out.println(output);
		return output;
	}

	String myAbstract();
}
