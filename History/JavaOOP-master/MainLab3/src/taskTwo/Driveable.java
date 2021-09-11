package taskTwo;

public interface Driveable extends Moveable { // Driveable interface for some vehicles, it can moves... + additional
												// methods
	void changeGear();

	void start();

	void shutDown();
}
