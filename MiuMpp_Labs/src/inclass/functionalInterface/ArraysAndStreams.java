package inclass.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArraysAndStreams {

	public static void main(String[] args) {
		String[] strings = { "Red", "orange", "Yellow", "green", "Blue", "indigo", "Violet" };

		System.out.println(
				String.format("%s", Arrays.stream(strings).map(String::toUpperCase).collect(Collectors.toList())));
		
		List<String> lstStringM = Arrays.stream(strings).filter(s->s.compareToIgnoreCase("m")>0)
				.sorted(String.CASE_INSENSITIVE_ORDER.reversed()) //o r v y //reversed: y v r o
				.collect(Collectors.toList());

				System.out.println(lstStringM);
	}

}
