package week2.lab_threads.primenumbers;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainPrimeThreadWithExec {
	private static Executor exec = Executors.newCachedThreadPool();
	
	
	public static void main(String[] args) {
		long minPrime = 1000000L;
		int nThreads = 10;
		for (int i = 1; i <= nThreads; i++) {
			long st = minPrime / nThreads * i - minPrime / nThreads + 1;
			long end = minPrime / nThreads * i;
			PrimeThread p = new PrimeThread(st, end);
			exec.execute(p);
			try {
				exec.wait(10);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
