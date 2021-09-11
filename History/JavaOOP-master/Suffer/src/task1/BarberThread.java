package task1;

public class BarberThread extends Thread {
	public BarberThread(String name) {
		this.setName(name);
	}

	public void run() {
		System.out.println("Barber " + this.getName() + " checks the queue");
		while (!QueueClients.clients.isEmpty()) {
			System.out.println("Barber takes " + QueueClients.deleteFromQueue() + " from the queue");
			System.out.println("Barber works...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Barber's work done");
			System.out.println("Barber " + this.getName() + " checks the queue");
		}
		System.out.println("Barber " + this.getName() + " goes sleep");
	}
}
