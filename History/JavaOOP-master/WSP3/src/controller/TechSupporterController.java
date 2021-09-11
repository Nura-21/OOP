package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import mainClasses.*;

public class TechSupporterController implements IDoAction {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public void actionViewCurrentOrders(TechSupporter ts) throws IOException {
		String input = "";
		String help = "\nInput order id to accept it." + " \nPress [check] to check current orders database"
				+ " \nPress [exit] to back to menu";
		while (true) {
			System.out.println(help);
			System.out.print("Input: ");
			input = br.readLine();
			if (input.equals("exit"))
				break;
			else if (input.equals("check")) {
				System.out.println("Current Orders Database:");
				System.out.println(ts.viewCurrentOrders());
			} else {
				if (ts.acceptOrder(Integer.parseInt(input)))
					System.out.println("The order has been accepted");
				else
					System.out.println("There is no order with this id");
			}
		}
	}

	public void actionViewDoneOrders(TechSupporter ts) throws IOException {
		String input = "";
		String help = "Press [check] to check done orders database" + " \nPress [exit] to back to menu";
		while (true) {
			System.out.println(help);
			System.out.print("Input: ");
			input = br.readLine();
			if (input.equals("exit"))
				break;
			else if (input.equals("check")) {
				System.out.println("Current Orders Database:");
				System.out.println(ts.viewDoneOrders());
			} else {
					System.out.println("Wrong command");
			}
		}
	}

	@Override
	public void startAction(User u) throws IOException {
		TechSupporter ts = (TechSupporter) u;
		String input = "";
		String help = "\nHere is the list of actions available to you as a TechSupporter"
				+ " \nPress [1] to view new orders in the database"
				+ " \nPress [2] to view done orders in the database";
		System.out.println(help);
		while (true) {
			System.out.println("If you need menu again, press [9] (You can always press [0] to quit).");
			System.out.print("Your input: ");
			input = br.readLine();
			if (input.equals("0")) {
				break;
			} else if (input.equals("9")) {
				System.out.println(help);
			} else if (input.equals("1")) {
				actionViewCurrentOrders(ts);
			} else if (input.equals("2")) {
				actionViewDoneOrders(ts);
			}

		}

	}
}