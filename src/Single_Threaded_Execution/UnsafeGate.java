package Single_Threaded_Execution;

public class UnsafeGate extends Gate{
	private int counter = 0;
	private String name;
	private String address;
	
	public void pass(String name, String address) {
		this.counter++;
		this.name = name;
		this.address = address;
		this.check();
	}

	private void check() {
		// TODO Auto-generated method stub
		if(name.charAt(0) != address.charAt(0)) {
			System.out.println("********** BROKEN **********" + toString());
		}
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "No." + this.counter + " : name - " + this.name + ", address - " + this.address;
	}
}
