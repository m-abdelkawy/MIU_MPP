package inclass.threads.lectureexample;

public class SingleThreadedTest {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			createAndStartThread();
			System.out.println("Num instances: " + Singleton.counter);
		}
	}
	
	public static void createAndStartThread() {
		Runnable r=()->{
			for (int i = 0; i < 1000; i++) {
				Singleton.getInstance();
			}
		};
		Thread thread = new Thread(r);
		thread.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}

}
