package Read_Write_Lock;

public final class ReadWriteLock {
	private int readingReaders = 0; // 实际正在读取中的线程个数
	private int waitingWriters = 0; // 正在等待写入的线程个数
	private int writingWriters = 0; // 实际正在写入中的线程个数
	private boolean preferWriters = true;

	public synchronized void readLock() throws InterruptedException {
		while (writingWriters > 0 || (preferWriters && waitingWriters > 0)) {
			wait();
		}
		readingReaders++; // 实际正在读取的线程个数加1
	}

	public synchronized void readUnlock() {
		readingReaders--;
		preferWriters = true;
		notifyAll();
	}

	public synchronized void writeLock() {
		waitingWriters++;
		try {
			while (writingWriters > 0 || readingReaders > 0) {
				wait();
			}
		} catch (Exception e) {
			waitingWriters--;
		}
		writingWriters++;
	}

	public synchronized void writeUnlock() {
		writingWriters--;
		preferWriters = false;
		notifyAll();
	}
}
