package ActiveObject;

public class Main {

	public static void main(String[] args) {
		ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
		new MakerClientThread("Alice", activeObject).start();
		new MakerClientThread("Bob", activeObject).start();
		new DisplayClientThread("Menzel3", activeObject).start();
	}

}
