package Thread_Per_Messaage;

public class Helper {

	public void handle(int count, char c) {
		System.out.println(" Handle ( " + count + ", " + c + " ) BEGING");

		for (int i = 0; i < count; i++) {
			slowly();
			System.out.print(c);
		}

		System.out.println(" Handle ( " + count + ", " + c + " ) END");

	}

	private void slowly() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;
	}

}
