package task5;

import java.util.concurrent.Semaphore;

public class Tester {
	public static void main(String[] args) {
		Semaphore sem = new Semaphore(1);
		ThreadGroup group = new ThreadGroup("group");
		State s1 = new State("Stormcloaks", 10000, 20000, null, sem); // Братья бури
		State s2 = new State("Imperial legion", 10000, 20000, s1, sem); // Имперский легион
		s1.enemy = s2;

		Thread s1Thread = new Thread(group, s1);
		Thread s2Thread = new Thread(group, s2);
		s1Thread.start();
		s2Thread.start();
		boolean done = false;
		while (!done) {
			if (group.activeCount() == 0) {
				done = true;
			}
		}
		System.out.println("");
		System.out.println("---War ends---");
		System.out.println(s1);
		System.out.println(s2);
	}

}
