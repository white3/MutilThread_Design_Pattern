package ActiveObject;

public class DisplayClientThread extends Thread{
	private final ActiveObject activeObject;

	public DisplayClientThread(String name, ActiveObject activeObject) {
		super(name);
		this.activeObject = activeObject;
	}

	@Override
	public void run() {
		try {
			for (int i = 0; true; i++) {
				String string = getName() + " " + i;
				activeObject.displayString(string);
				Thread.sleep(200);
			}
		} catch (InterruptedException e) {
		}
	}
}
