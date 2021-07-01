package week2.standardexam3;

public class Admin {
	private Department[] depts;
	
	public Admin(Department[] depts) {
		this.depts = depts;
	}
	
	public String hourlyCompanyMessage() throws EmptyQueueException {
		StringBuilder sb = new StringBuilder();
		try {
			for (Department dept : depts) {
				sb.append(format(dept.getName(), dept.nextMessage()) + "\n");
			}
			return sb.toString();
		} catch (Exception e) {
			throw new EmptyQueueException();
		}
	}
	
	public String format(String name, String msg) {
		return name + ": " + msg;
	}
}
