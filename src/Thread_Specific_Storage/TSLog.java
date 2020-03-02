package Thread_Specific_Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TSLog {
	private PrintWriter writer = null;

	public TSLog(String fileName) {
		try {
			writer = new PrintWriter(new File(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void println(String s) {
		writer.println(s);
	}

	public void close() {
		System.out.println("==== End of log ====");
		writer.close();
	}
}
