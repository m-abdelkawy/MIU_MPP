package inclass.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysAndStreams2 {

	public static void main(String[] args) {
		String[] strings = { "Red", "orange", "Yellow", "green", "Blue", "indigo", "Violet" };

		System.out.println(String.format("Original Values:%n%s", Arrays.asList(strings)));

		System.out.println(String.format("%nStrings > m sorted ascending:%n%s",
				Arrays.stream(strings).filter(s -> s.compareToIgnoreCase("m") > 0).sorted(String.CASE_INSENSITIVE_ORDER)
						.collect(Collectors.toList())));

		System.out.println(String.format("%nStrings > m sorted descending:%n%s",
				Arrays.stream(strings).filter(s -> s.compareToIgnoreCase("m") > 0)
						.sorted(String.CASE_INSENSITIVE_ORDER.reversed()).collect(Collectors.toList())));

		System.out.println(String.format("%nStrings To Upper Case:%n%s",
				Arrays.stream(strings).map(String::toUpperCase).collect(Collectors.toList())));

		
	}

}
