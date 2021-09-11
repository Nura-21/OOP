package second;

import java.util.Objects;

public class Moder extends User {
	private String moderPanelPassword;

	public Moder() {
		super();
		moderPanelPassword = "qwerty";
	}

	public Moder(String nickname, String password, String moderPanelPassword) {
		super(nickname, password);
		this.moderPanelPassword = moderPanelPassword;

	}

	public String getModerPanelPassword() {
		return moderPanelPassword;
	}

	public void setModerPanelPassword(String moderPanelPassword) {
		this.moderPanelPassword = moderPanelPassword;
	}

	public void logIn() {
		System.out.println("Moderator " + getNickname() + " has been authorized");
	}

	public void changeInfo() {
		System.out.println("Moderator " + getNickname() + " has changed info");
	}

	public boolean equals(Object obj) {
		if (!super.equals(obj))
			return false;
		Moder mdr = (Moder) obj;
		return this.getModerPanelPassword().equals(mdr.getModerPanelPassword());

	}

	public int hashCode() {
		return Objects.hash(this.getNickname(), this.getPassword(),this.getModerPanelPassword());
	}
}
