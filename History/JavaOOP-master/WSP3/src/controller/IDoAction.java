package controller;

import java.io.IOException;

import mainClasses.User;

public interface IDoAction {
	void startAction(User u) throws IOException, CloneNotSupportedException;
}
