package Immutable;

public class Person {
	private final String name;	// 并非immutable模式的必要条件, 主要目的是为了明确编程人员的意图
	private final String address;
	
	public Person(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", address=" + address + "]";
	}
	
}
