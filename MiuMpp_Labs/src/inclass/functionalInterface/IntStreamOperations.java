package inclass.functionalInterface;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class IntStreamOperations {

	public static void main(String[] args) {
		int[] values = { 3, 10, 6, 1, 4, 8, 2, 5, 9, 7 };

		System.out.println("Original Values: ");
		IntStream.of(values).forEach(v -> System.out.print(v + "\t"));

		/*
		 * IntConsumer printer1 = new IntConsumer() {
		 * 
		 * @Override public void accept(int n) { System.out.println(n); } };
		 */

		OptionalInt max = IntStream.of(values).max();
		OptionalInt min = IntStream.of(values).min();
		System.out.println(String.format("%nMax of values: %d", max.orElse(-1)));
		System.out.println(String.format("Max of values: %d", max.isPresent() ? max.getAsInt() : -1));

		// Count
		Long count = IntStream.of(values).count();
		System.out.println(String.format("%nCount: %d", count));

		// Average
		OptionalDouble avg = IntStream.of(values).average();
		System.out.println(String.format("%nAverage: %.2f", avg.orElse(-1)));
		System.out.println(String.format("Average: %.2f", avg.isPresent() ? avg.getAsDouble() : -1));

		// sum
		int sum = IntStream.of(values).sum();
		System.out.println(String.format("%nSum: %d", sum));

		// sum using reduce method
		int[] values2 = {};
		System.out.println("%nSum of values using reduce: ");
		IntBinaryOperator accumulator = new IntBinaryOperator() {

			@Override
			public int applyAsInt(int left, int right) {
				return left + right;
			}
		};
		int sum1 = IntStream.of(values2).reduce(0, accumulator);
		System.out.println(String.format("Sum1 using reduce: %d", sum1));

		int sum2 = IntStream.of(values2).reduce(0, (l, r) -> l + r);
		System.out.println(String.format("Sum2 using reduce: %d", sum2));

		OptionalInt sum3 = IntStream.of(values2).reduce(accumulator);
		// throws NoSuchElementException if the array is empty
		System.out.println(String.format("Sum3 using reduce: %d", sum3.orElse(0)));

		// sum of squares
		System.out.printf("%n%nSum of squares -----: ");
		int sumSquaresLoop = 0;
		for (int i = 0; i < values.length; i++) {
			sumSquaresLoop += Math.pow(values[i], 2);
		}
		System.out.println(String.format("%nSumSquares from Loop: %d", sumSquaresLoop));

		// using reduce
		int sumSquaresReduce1 = IntStream.of(values).reduce(0, (l, r) -> l + r * r);
		System.out.println(String.format("SumSquares from reduce: %d", sumSquaresReduce1));
		
		/*------------Product of values-------------*/
		System.out.println(String.format("%nProduct -------------", 0));
		int productFromLoop = 1;
		for (int i = 0; i < values.length; i++) {
			productFromLoop*=values[i];
		}
		System.out.println(String.format("Product from loop: %d", productFromLoop));
		
		//using reduce
		int productReduce1 = IntStream.of(values).reduce(1, (l,r)->l*r);
		System.out.println(String.format("Product1 using reduce method: %d", productReduce1));
		
		OptionalInt productReduce2 = IntStream.of(values).reduce((l,r)->l*r);
		System.out.println(String.format("Product2 using reduce method: %d", productReduce2.orElse(0)));
		
		/*------------display even values-------------*/
		System.out.println("\nOriginal Values: ");
		IntStream.of(values).forEach(v -> System.out.print(v + "\t"));
		System.out.println(String.format("%nEven Values -------------", 0));
		IntPredicate predicateEven = new IntPredicate() {
			@Override
			public boolean test(int value) {
				return value%2==0;
			}
		};
		IntConsumer printer2 = new IntConsumer() {
			@Override
			public void accept(int value) {
				System.out.print(value + "\t");
			}
		};
		System.out.println(String.format("Values sorted1: ", 0));
		IntStream.of(values).filter(predicateEven).sorted().forEach(printer2);
		//using lambda expression
		System.out.println(String.format("%nValues sorted2: ", 0));
		IntStream.of(values).filter(v->v%2==0).sorted().forEach(v->System.out.print(v+"\t"));
		
		/*------------Odd values * 10 sorted-------------*/
		System.out.println(String.format("%nOdd values * 10 sorted -------------", 0));
		IntStream.of(values).filter(v->v%2!=0).sorted().map(v->v*10).forEach(v->System.out.print(v+"\t"));
		
		/*------------Sum Range-------------*/
		int sumRangeExclusive = IntStream.range(1, 3).sum(); //expected 3
		System.out.println(String.format("%n%nSum Range(1,3) exclusive: %d", sumRangeExclusive));
		
		int sumRangeInclusive = IntStream.rangeClosed(1, 3).sum(); //expected 6
		System.out.println(String.format("Sum Range(1,3) inclusive: %d", sumRangeInclusive));
		

	}

}
