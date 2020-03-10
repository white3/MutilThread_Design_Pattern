package chapter1.Single_Threaded_Execution;

public class Gate{
	private int counter = 0;
	private String name;
	private String address;
	
	synchronized public void pass(String name, String address) {
		this.counter++;
		this.name = name;
		this.address = address;
		this.check();
	}

	private void check() {
		if(name.charAt(0) != address.charAt(0)) {
			System.out.println("********** BROKEN **********" + toString());
		}
	}
	
	@Override
	synchronized public String toString() {
		return "No." + this.counter + " : name - " + this.name + ", address - " + this.address;
	}
}
