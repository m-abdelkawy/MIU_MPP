package inclass.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class trials {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Lec example");
		List<Integer> ints = Arrays.asList(3, 5, 2, 3, 8);
		List<int[]>intArrs = ints.stream().map(int[]::new)
				.collect(Collectors.toList());
		List<String> intArrsStr = intArrs.stream().map(Arrays::toString)
				.collect(Collectors.toList());
		String[] arr = new String[intArrsStr.size()];
		arr = intArrsStr.toArray(arr);
		System.out.println(Arrays.toString(arr));
	}

}
