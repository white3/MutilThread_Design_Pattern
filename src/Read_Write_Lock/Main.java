package Read_Write_Lock;

public class Main {

	public static void main(String[] args) {
		Data data = new Data(5);
		for (int i = 0; i < 10; i++) {
			new ReaderThread(data).start();
		}
		new WriterThread(data, "abcdefghijklmnopqrstuvwxyz").start();
		new WriterThread(data, "ABCDEFGHIJKLMNOPQRSTUVWXYZ").start();
		
		/**
		 * Test ReentrantReadWriteLock
		 * 
		 * ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
		 */
		
	}

}
