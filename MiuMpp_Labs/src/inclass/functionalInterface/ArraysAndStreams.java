package inclass.functionalInterface;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArraysAndStreams {

	public static void main(String[] args) {
		Integer[] values = { 2, 9, 5, 0, 3, 7, 1, 4, 8, 6 };

		// Display original values
		System.out.println("Original Values: \n" + Arrays.asList(values));

		System.out.println(
				String.format("%nSorted Ascending:%n%s", Arrays.stream(values).sorted().collect(Collectors.toList())));

		System.out.println(String.format("%nSorted Descending:%n%s",
				Arrays.stream(values).sorted((x, y) -> Integer.compare(y, x)).collect(Collectors.toList())));

		System.out.println(String.format("%nValues greater than 4:%n%s",
				Arrays.stream(values).filter(x -> x > 4).collect(Collectors.toList())));
		
		System.out.println(String.format("%nValues greater than 4 Sorted:%n%s",
				Arrays.stream(values).filter(x -> x > 4).sorted().collect(Collectors.toList())));
	}

}
