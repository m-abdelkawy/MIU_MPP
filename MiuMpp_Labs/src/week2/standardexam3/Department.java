package week2.standardexam3;

public abstract class Department {
	private StringQueue queue = new StringQueue();
	
	public abstract String getName();
	
	public void addMessage(String msg) {
		queue.enqueue(msg);
	}
	
	public String nextMessage() throws EmptyQueueException {
		try {
			return queue.dequeue();
		} catch (EmptyQueueException e) {
			throw new EmptyQueueException();
		}
	}
	
	public StringQueue getQueue() {
		return queue;
	}
}
