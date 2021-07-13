package inclass.threads.lectureexample;

public class SynchronizedSingleton {
	private static SynchronizedSingleton instance;
	public static int counter = 0;

	private SynchronizedSingleton() {
		incrementCounter();
	}

	public synchronized static SynchronizedSingleton getInstance() {
		if (instance == null)
			instance = new SynchronizedSingleton();
		return instance;
	}

	private synchronized static void incrementCounter() {
		counter++;
	}
}
