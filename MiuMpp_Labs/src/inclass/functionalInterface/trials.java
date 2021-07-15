package inclass.functionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class trials {

	public static void main(String[] args) {
		Stream.generate(() -> "Echo").limit(10).forEach(x -> System.out.print(x + "\t"));

		System.out.println();
		Stream.generate(Math::random).limit(5).forEach(x -> System.out.print(x + "\t"));// generate takes Supplier

		System.out.println();
		Stream.iterate(1, x -> x + 2)/* .skip(1) */.limit(5).forEach(x -> System.out.print(x + "\t")); // iterate takes
																										// UnaryOperator

		System.out.println("\nConcatenating streams: -----");
		Stream<Character> helloStream = createCharacterStream("Hello ");
		Stream<Character> worldStream = createCharacterStream("World");

		Stream<Character> combined = Stream.concat(helloStream, worldStream);
		combined.forEach(x -> System.out.print(x + "\t"));

		System.out.println();
		String[] words = { "Mohamed", "Ahmed", "Ali", "Mississippi","Jason", "Indigo", "Yasser" };
		List<String> lstString = Arrays.asList(words);
		System.out.println(lstString.stream()
				.max((s1, s2) -> (new Integer(s1.length())).compareTo(new Integer(s2.length()))).orElse(null));

	}

	public static Stream<Character> createCharacterStream(String str) {
		List<Character> lstCharacter = new ArrayList<Character>();
		char[] charArr = str.toCharArray();
		for (char c : charArr) {
			lstCharacter.add(c);
		}
		return lstCharacter.stream();
	}

}
