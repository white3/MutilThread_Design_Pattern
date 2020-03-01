package GuardedSuspension;

import java.util.LinkedList;
import java.util.Queue;

public class RequestQueue {
	private final Queue<Request> queue = new LinkedList<Request>();
	
	public synchronized void putRequest(Request request) {
		queue.offer(request); // offer 与 add区别：插入的时候遇到溢出，offer会返回false，add抛出异常 
		this.notifyAll();
	}
	
	public synchronized Request getRequest() {
		while(queue.peek() == null) {
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		return queue.remove(); // remove与poll的区别：出队发现队空时，remove抛出异常，poll返回null
	}
}
