package task1;

import java.util.LinkedList;
import java.util.Queue;

public class QueueClients {
	public static Queue<String> clients = new LinkedList<String>();

	static void addToQueue(String name) {
		System.out.println(name + " got in the queue...");
		clients.offer(name);
	}

	static String deleteFromQueue() {
		String name = clients.element();
		clients.poll();
		return name;
	}
}
