package task1;

import java.util.Random;

public class QueueThread extends Thread {
	String[] NAMES = { "Ivan", "Daniil", "Kyamran", "Ernur", "Ernazar", "John Wick", "Naruto", "Sasuke", "Madara",
			"Sanjar", "Sherlock", "Elliot", "Satoshi Nakomoto", "Arni", "Rock Lee", "Ergeldi", "Ali", "Yato", "Shoto",
			"Alesha", "Chingiz", "Nurbek", "Elon" };

	public QueueThread() {

	}

	public void run() {
		BarberThread barber = new BarberThread("Master Jack");
		final Random random = new Random();
		QueueClients.addToQueue("Michail");
		QueueClients.addToQueue("Ergeldi");
		System.out.println("--Day starts--");
		int hours = 0;
		barber.start();
		while (hours < 48) {
			int chance = random.nextInt(16); // chance 1/20 to add new person into the queue
			if (chance == 1) {
				String clientName = NAMES[random.nextInt(NAMES.length - 1)];
				QueueClients.addToQueue(clientName);
				if (!barber.isAlive()) {
					System.out.println(clientName + " woke up barber " + barber.getName());
					barber.run();
				}
			}
			hours++;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		barber.stop();
		System.out.println("Barber " + barber.getName() + " goes home");
		System.out.println("--Day ends--");
		System.out.println("Remaining clients:");
		System.out.println(QueueClients.clients);
	}
}
