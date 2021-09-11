package second;

import java.util.Objects;

public class User {
	private String nickname;
	private String password;

	public User() {
		nickname = "Anonim";
		password = "123456";
	}

	public User(String nickname, String password) {
		this.nickname = nickname;
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void logIn() {
		System.out.println("User " + getNickname() + " has been authorized");
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;
		User usr = (User) obj;
		return this.getNickname().equals(usr.getNickname()) && this.getPassword().equals(usr.getPassword());
	}

	public int hashCode() {
		return Objects.hash(this.getNickname(), this.getPassword());
	}

}
