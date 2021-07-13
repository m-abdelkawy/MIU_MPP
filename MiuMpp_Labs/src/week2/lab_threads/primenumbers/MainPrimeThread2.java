package week2.lab_threads.primenumbers;

public class MainPrimeThread2 {

	public static void main(String[] args) {
		long minPrime = 1000000L;
		int nThreads = 10;
		for (int i = 1; i <= nThreads; i++) {
			long st = minPrime / nThreads * i - minPrime / nThreads + 1;
			long end = minPrime / nThreads * i;
			PrimeThread p = new PrimeThread(st, end);
			p.start();
		}
	}

}
