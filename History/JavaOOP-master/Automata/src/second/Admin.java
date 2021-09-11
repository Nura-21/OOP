package second;

import java.util.Objects;

public class Admin extends Moder {
	private String adminPanelPassword;

	public Admin() {
		super();
		adminPanelPassword = "1q2w3r";
	}

	public Admin(String nickname, String password, String moderPanelPassword, String adminPanelPassword) {
		super(nickname, password, moderPanelPassword);
		this.adminPanelPassword = adminPanelPassword;
	}

	public String getAdminPanelPassword() {
		return adminPanelPassword;
	}

	public void setAdminPanelPassword(String adminPanelPassword) {
		this.adminPanelPassword = adminPanelPassword;
	}

	public void logIn() {
		System.out.println("Administrator " + getNickname() + " has been authorized");
	}

	public void changeInfo() {
		System.out.println("Administrator " + getNickname() + " has changed info");
	}

	public void ban() {
		System.out.println("Administrator " + getNickname() + " has banned user");
	}

	public boolean equals(Object obj) {
		if (!super.equals(obj))
			return false;
		Admin adm = (Admin) obj;
		return this.getAdminPanelPassword().equals(adm.getAdminPanelPassword());

	}

	public int hashCode() {
		return Objects.hash(this.getNickname(), this.getPassword(), this.getModerPanelPassword(),
				this.getAdminPanelPassword());
	}

}
