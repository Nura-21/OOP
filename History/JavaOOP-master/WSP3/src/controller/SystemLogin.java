package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

import mainClasses.*;
import wspEnums.*;

public class SystemLogin {
	public SystemLogin() {
	}

	public static boolean login(String login, String password) {
		for (User u : DataBase.getInstance().getUsers())
			if (u.getLogin().equals(login) && u.getPassword().equals(Integer.toString(Objects.hashCode(password))))
				return true;
		return false;
	}

	public static void start() throws IOException, CloneNotSupportedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Welcome to the WSP 5.0");
		System.out.println("Write your login and password.");
		String l = "", p = "";
		int tries = 0;
		boolean isLogin = false;
		while (!isLogin) {
			System.out.print("Login:");
			l = br.readLine();
			System.out.print("Password:");
			p = br.readLine();
			isLogin = login(l, p);
			tries++;
			if (tries == 3) {
				System.out.println("Your IP was banned for too many attempts");
				return;
			}
			if (!isLogin)
				System.out.println("Wrong login/password");
		}
		User usr = null;
		for (User u : DataBase.getInstance().getUsers())
			if (u.getLogin().equals(l) && u.getPassword().equals(Integer.toString(Objects.hashCode(p)))) {
				usr = u;
				break;
			}
		System.out.println("Welcome! " + usr.getUserType() + " " + usr.getName());
		if (usr.getUserType() == UserType.STUDENT) {
			StudentController contr = new StudentController();
			contr.startAction(usr);
		} else if (usr.getUserType() == UserType.ADMIN) {
			AdminController contr = new AdminController();
			contr.startAction(usr);
		} else if (usr.getUserType() == UserType.TEACHER) {
			TeacherController contr = new TeacherController();
			contr.startAction(usr);
		} else if (usr.getUserType() == UserType.MANAGER) {
			ManagerController contr = new ManagerController();
			contr.startAction(usr);
		} else if (usr.getUserType() == UserType.TECHSUPPORT) {
			TechSupporterController contr = new TechSupporterController();
			contr.startAction(usr);
		}
		System.out.println("Logout...");
	}
}