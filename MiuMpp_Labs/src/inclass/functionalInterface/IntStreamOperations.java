package inclass.functionalInterface;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class IntStreamOperations {

	public static void main(String[] args) {
		int[] values = { 3, 10, 6, 1, 4, 8, 2, 5, 9, 7 };
		System.out.println("Original Values: ");
		IntConsumer printer1 = new IntConsumer() {
			@Override
			public void accept(int n) {
				System.out.println(n);
			}
		};

		/*
		 * IntConsumer printer2 = s -> System.out.println(s);
		 * 
		 * System.out.println("Using printer1: ");
		 * 
		 * IntStream.of(values).forEach(printer1);
		 * 
		 * System.out.println("Using printer2: ");
		 * 
		 * IntStream.of(values).forEach(printer2);
		 * 
		 * System.out.println("Using Lambda exepression: ");
		 * 
		 * IntStream.of(values).forEach(v -> System.out.println(v));
		 */

		OptionalInt max = IntStream.of(values).max();
		OptionalInt min = IntStream.of(values).min();
		Long count = IntStream.of(values).count();

		System.out.println(String.format("Max of values: %d", max.orElse(-1)));
		System.out.println(String.format("Max of values: %d", max.isPresent() ? max.getAsInt() : -1));

		System.out.println(String.format("Count: %d", count));

		OptionalDouble avg = IntStream.of(values).average();
		System.out.println(String.format("Average: %.2f", avg.orElse(-1)));
		System.out.println(String.format("Average: %.2f", avg.isPresent() ? avg.getAsDouble() : -1));

		System.out.println("Sum of values using reduce: ");
		IntBinaryOperator biSum1 = new IntBinaryOperator() {

			@Override
			public int applyAsInt(int left, int right) {
				return left + right;
			}
		};
		IntBinaryOperator biSum2 = (l, r) -> l + r;

		int sum1Int = IntStream.of(values).reduce(0, biSum1);
		int sum2Int = IntStream.of(values).reduce(0, biSum2);
		int sum3Int = IntStream.of(values).reduce(0, (x, y) -> x + y);
		System.out.println(String.format("Sum from int: %d, %d, %d", sum1Int, sum2Int, sum3Int));

		OptionalInt sum1Optional = IntStream.of(values).reduce(biSum1);
		OptionalInt sum2Optopnal = IntStream.of(values).reduce(biSum2);
		OptionalInt sum3Optional = IntStream.of(values).reduce((x, y) -> x + y);

		System.out.println(String.format("Sum from OptionalInt: %d, %d, %d", sum1Optional.orElse(-1),
				sum2Optopnal.isPresent() ? sum2Optopnal.getAsInt() : -1,
				sum3Optional.isPresent() ? sum3Optional.getAsInt() : -1));

		System.out.println("Sum of Squares------------");

		OptionalInt sumSquareOptional = IntStream.of(values).reduce((x, y) -> x + y * y);
		System.out.println(
				String.format("Sum of Squares (sumSquareOptional) Not correct: %d", sumSquareOptional.orElse(0)));

		int sumSquareInt = IntStream.of(values).reduce(0, (x, y) -> x + y * y);
		System.out.println(String.format("Sum of Squares (sumSquareInt) Correct: %d", sumSquareInt));

		int sumSquares = 0;
		for (int i = 0; i < values.length; i++) {
			sumSquares += Math.pow(values[i], 2);
		}
		System.out.println(sumSquares);

		System.out.println("\nSum of Squares------------");

		OptionalInt productOptionalInt = IntStream.of(values).reduce((x, y) -> x * y);
		System.out.println(String.format("Product(OptionalInt): %d", productOptionalInt.orElse(0)));

		int productInt = IntStream.of(values).reduce(1, (x, y) -> x * y);
		System.out.println(String.format("Product(int): %d", productInt));

		System.out.println("\nEven Values: ------------");
		IntStream.of(values).filter(x -> x % 2 == 0).sorted().forEach(v -> System.out.println(v));

		System.out.println("\nEven Values: ------------");
		int sumRangeEndExclusive = IntStream.range(1, 10).sum();
		System.out.println(String.format("Sum Range End Exclusive: %d", sumRangeEndExclusive));

		int sumRangeEndInclusive = IntStream.rangeClosed(1, 10).sum();
		System.out.println(String.format("Sum Range End Inclusive: %d", sumRangeEndInclusive));

		int sumRangeFromLoop = 0;
		for (int i = 0; i < values.length; i++) {
			sumRangeFromLoop += values[i];
		}
		System.out.println(String.format("For Confirmation: %d", sumRangeFromLoop));

	}

}
