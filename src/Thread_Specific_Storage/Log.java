package Thread_Specific_Storage;

public class Log {
	private static ThreadLocal<TSLog> tsLogCollection = new ThreadLocal<>();

	public static void println(String s) {
		getTSLog().println(s);
	}

	public static void close() {
		getTSLog().close();
	}

	private static TSLog getTSLog() {
		TSLog tsLog = tsLogCollection.get();

		if (tsLog == null) {
			tsLog = new TSLog("res/" + Thread.currentThread().getName() + "-Log.txt");
			tsLogCollection.set(tsLog);
		}
		return tsLog;
	}
}
