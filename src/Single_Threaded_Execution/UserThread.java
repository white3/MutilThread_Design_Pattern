package Single_Threaded_Execution;

public class UserThread extends Thread{

	private String name;
	private String address;
	private Gate gate;
	
	public UserThread() {	}

	public UserThread(String name, String address, Gate gate) {
		super();
		this.name = name;
		this.address = address;
		this.gate = gate;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(this.name + " Begin: ");
		while(true) {
			gate.pass(name, address);
		}
	}
}
