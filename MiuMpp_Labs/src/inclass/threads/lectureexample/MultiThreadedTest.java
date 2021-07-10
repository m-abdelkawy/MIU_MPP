package inclass.threads.lectureexample;

public class MultiThreadedTest {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			multipleCalls();
			
			System.out.println("Num instances: " + Singleton.counter);
		}
	}
	
	public static void multipleCalls() {
		Runnable r=()->{
			for (int i = 0; i < 5000; i++) {
				Singleton.getInstance();
			}
		};
		
		for (int i = 0; i < 1000; i++) {
			
			Thread thread = new Thread(r);
			thread.start();
			/*try {
				thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		//System.out.println(Thread.currentThread());
	}

}
