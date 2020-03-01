package Balk;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Data {
	private final String billId; // the id of bill
	private String content;
	private boolean changed; // if the content is not saved, the changed is true.

	public Data(String billId, String content) {
		this.billId = billId;
		this.changed = true;
		this.content = content;
	}

	public synchronized void change(String content) {
		this.content = content;
		this.changed = true;
	}

	public synchronized void save() throws IOException {
		if (!changed)
			return ;
		doSave();
		changed = false;
	}

	private void doSave() throws IOException {
		System.out.println(Thread.currentThread() + "billId: " + billId + " | update new content: " + content);
		Writer writer = new FileWriter(new File(billId + ".bill"));
		writer.write(content);
		writer.close();
	}
}
