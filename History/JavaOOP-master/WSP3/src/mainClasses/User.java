package mainClasses;

import java.io.Serializable;
import java.util.Objects;

import wspEnums.UserType;

public abstract class User implements Comparable, Cloneable, Serializable {
	private static final long serialVersionUID = 8524235537709089798L;
	private int id;
	private String login;
	private String password;
	private String name;
	private String surname;
	private UserType userType;

	public User() {
		userType = UserType.DEFAULT;
		id = generateId();
		login = "default_user_" + id;
		password = Integer.toString(Objects.hashCode("kbtu1234"));
	}

	public User(String name, String surname, UserType userType) {
		this();
		this.name = name;
		this.surname = surname;
		String s = String.valueOf(Character.toLowerCase(name.charAt(0)));
		this.login = s + "_" + surname.toLowerCase();
		this.userType = userType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public boolean generateLogin() {
		if (!name.equals(null) && !surname.equals(null)) {
			String s = String.valueOf(Character.toLowerCase(name.charAt(0)));
			this.login = s + "_" + surname.toLowerCase();
			return true;
		}
		return false;
	}

	public int generateId() {
		int mx = -1;
		for(User u : DataBase.getInstance().getUsers())
			if(u.getId()>mx)
				mx = u.getId();
		return ++mx;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = Integer.toString(Objects.hashCode(password));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + ", name=" + name + ", surname="
				+ surname + ", userType=" + userType + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, login, password, name, surname, userType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (userType != other.userType)
			return false;
		return true;
	}

	@Override
	public int compareTo(Object o) {
		User u = (User) o;
		return Integer.compare(this.id, u.id);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		User clone = (User) super.clone();
		return clone;
	}

}