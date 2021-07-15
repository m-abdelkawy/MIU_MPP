package week3.inclass_exercises;

import java.util.Random;

public class MyRandGen {

	public static void main(String[] args) {
		MyIface<Integer> mrg1 = new MyIface<Integer>() {

			@Override
			public int produce() {
				Random r = new Random();
				return r.nextInt();
			}
		};
		
		MyIface<Integer> mrg2 = new MyRandomGen();
		
		MyIface<Integer> mrg3 = ()->{
			Random r = new Random();
			return r.nextInt();
		};
		
		System.out.println(mrg1.produce());
		System.out.println(mrg2.produce());
		System.out.println(mrg3.produce());
	}
}
