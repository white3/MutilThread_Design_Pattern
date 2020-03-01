package edu.menzel3.GuardedSuspension;

import java.util.LinkedList;
import java.util.Queue;

public class RequestQueue {
	private final Queue<Request> queue = new LinkedList<Request>();
	private int times = 0;
	private int depth = 100;

	public synchronized boolean putRequest(Request request) {
		queue.offer(request); // offer 与 add区别：插入的时候遇到溢出，offer会返回false，add抛出异常
		times++;
		return times != depth;
	}

	public synchronized Request getRequest() {
		times--;
		return queue.poll(); // remove与poll的区别：出队发现队空时，remove抛出异常，poll返回null
	}
}
