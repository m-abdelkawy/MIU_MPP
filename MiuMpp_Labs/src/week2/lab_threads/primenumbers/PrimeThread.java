package week2.lab_threads.primenumbers;

public class PrimeThread extends Thread {
	public static int counter = 0;
	long start;
	long end;

	public PrimeThread(long start, long end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		System.out.println("Inside thread: " + (++counter));
		for (long i = start; i < end; i++) {
			if (isPrime(i))
				System.out.println(i);
			
			/*try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}*/
		}
		
		
	}

	private synchronized boolean isPrime(long n) {
		if (n <= 1L)
			return false;

		for (long i = 2L; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
