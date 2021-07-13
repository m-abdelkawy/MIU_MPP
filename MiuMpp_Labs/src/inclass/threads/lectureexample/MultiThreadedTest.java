package inclass.threads.lectureexample;

public class MultiThreadedTest {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			multipleCalls();

			System.out.println("Num instances (multiple calls): " + Singleton.counter);// expected 1 or more

			/*
			 * Competing threads are creating multiple instances of the Singleton class. The
			 * test "instance == null* is being interrupted so that it appears to be true to
			 * more than one thread before the first instance is ever created, and so the
			 * constructor is called multiple times, "race" condition
			 */ 
		}
	}

	public static void multipleCalls() {
		Runnable r = () -> {
			for (int i = 0; i < 5000; i++) {
				Singleton.getInstance();
			}
		};

		for (int i = 0; i < 1000; i++) {

			Thread thread = new Thread(r);
			thread.start();
			/*
			 * try { thread.sleep(1); } catch (InterruptedException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */
		}
		// System.out.println(Thread.currentThread());
	}

}
