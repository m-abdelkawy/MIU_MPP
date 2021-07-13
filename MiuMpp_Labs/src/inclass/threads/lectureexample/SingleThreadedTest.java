package inclass.threads.lectureexample;

public class SingleThreadedTest {

	public static void main(String[] args) {
		for (int i = 0; i < 1; i++) {
			createAndStartThread();
			System.out.println(String.format("Num instances: %d", Singleton.counter)); // expected 1
		}
	}

	public static void createAndStartThread() {
		Runnable r = () -> {
			for (int i = 0; i < 1000; i++) {
				Singleton.getInstance(); // creates new and increments if new
			}
		};

		new Thread(r).start();
		try {
			/*
			 * If we do not do this, the first 1 or 2 calls to the method
			 * "createAndStartThread" will record 0 instances this is because the change
			 * made by each thread may not be visible to the main thread immediatelty
			 */
			Thread.sleep(10);
		} catch (InterruptedException e) {
		}
	}

}
