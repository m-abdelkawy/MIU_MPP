package week3.inclass_exercises;

import java.util.Random;

@FunctionalInterface
public interface MyIface<Integer> {
	int produce();
}

class MyRandomGen implements MyIface<Integer>{
	@Override
	public int produce() {
		Random r = new Random();
		return r.nextInt();
	}
}
