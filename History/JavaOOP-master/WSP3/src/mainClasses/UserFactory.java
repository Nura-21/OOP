package mainClasses;

public class UserFactory {
	private static UserFactory instance = null;

	private UserFactory() {

	}

	public static UserFactory getInstance() {
		if (instance == null)
			instance = new UserFactory();
		return instance;
	}

	public User getUser(String userType) {
		if (userType == null)
			return null;
		if (userType.equalsIgnoreCase("student"))
			return new Student();
		else if (userType.equalsIgnoreCase("teacher"))
			return new Teacher();
		else if (userType.equalsIgnoreCase("admin"))
			return new Admin();
		else if (userType.equalsIgnoreCase("manager"))
			return new Manager();
		else if (userType.equalsIgnoreCase("techsupporter"))
			return new TechSupporter();
		return null;
	}
}
