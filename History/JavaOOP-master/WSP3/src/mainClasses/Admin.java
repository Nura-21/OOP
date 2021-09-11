
package mainClasses;

import wspEnums.UserType;

public class Admin extends User {

	private static final long serialVersionUID = -7691055661016631393L;

	public Admin() {
		super();
		super.setUserType(UserType.ADMIN);
	}

	public Admin(String name, String surname) {
		super(name, surname, UserType.ADMIN);
	}

	public boolean addUser(User user) {
		if (!DataBase.getInstance().getUsers().contains(user)) {
			user.generateLogin();
			DataBase.getInstance().getUsers().add(user);
			DataBase.getInstance().determineUsers();
			return true;
		}
		return false;
	}

	public boolean removeUser(User user) {
		if (DataBase.getInstance().getUsers().contains(user)) {
			DataBase.getInstance().getUsers().remove(user);
			if (user.getUserType().equals(UserType.ADMIN))
				DataBase.getInstance().getAdmins().remove(user);
			else if (user.getUserType().equals(UserType.TEACHER))
				DataBase.getInstance().getTeachers().remove(user);
			else if (user.getUserType().equals(UserType.MANAGER))
				DataBase.getInstance().getManagers().remove(user);
			else if (user.getUserType().equals(UserType.STUDENT))
				DataBase.getInstance().getStudents().remove(user);
			else if (user.getUserType().equals(UserType.TECHSUPPORT))
				DataBase.getInstance().getTechSupporters().remove(user);
			return true;
		}
		return false;
	}

	public boolean updateUser(User user) {
		return false;
	}

	public boolean checkLogs() {
		return false;
	}

	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Admin [" + super.toString() + "]";
	}

}
