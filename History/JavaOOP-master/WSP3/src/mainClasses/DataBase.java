package mainClasses;

import java.util.*;

import wspEnums.UserType;

import java.io.*;

public class DataBase {
	private static DataBase instance = null;
	private HashSet<User> users = new HashSet<User>();
	private HashSet<Admin> admins = new HashSet<Admin>();
	private HashSet<Manager> managers = new HashSet<Manager>();
	private HashSet<Teacher> teachers = new HashSet<Teacher>();
	private HashSet<Student> students = new HashSet<Student>();
	private HashSet<TechSupporter> techSupporters = new HashSet<TechSupporter>();

	private Vector<Message> messages = new Vector<Message>();

	private Vector<Order> currentOrders = new Vector<Order>();
	private Vector<Order> doneOrders = new Vector<Order>();

	private Vector<Course> courses = new Vector<Course>();

	private DataBase() {

	}

	public static DataBase getInstance() {
		if (instance == null)
			instance = new DataBase();
		return instance;
	}

	public HashSet<User> getUsers() {
		return users;
	}

	public void setUsers(HashSet<User> users) {
		this.users = users;
	}

	public HashSet<Admin> getAdmins() {
		return admins;
	}

	public void setAdmins(HashSet<Admin> admins) {
		this.admins = admins;
	}

	public HashSet<Manager> getManagers() {
		return managers;
	}

	public void setManagers(HashSet<Manager> managers) {
		this.managers = managers;
	}

	public HashSet<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(HashSet<Teacher> teachers) {
		this.teachers = teachers;
	}

	public HashSet<Student> getStudents() {
		return students;
	}

	public void setStudents(HashSet<Student> students) {
		this.students = students;
	}

	public HashSet<TechSupporter> getTechSupporters() {
		return techSupporters;
	}

	public void setTechSupporters(HashSet<TechSupporter> techSupporters) {
		this.techSupporters = techSupporters;
	}

	public Vector<Message> getMessages() {
		return messages;
	}

	public void setMessages(Vector<Message> messages) {
		this.messages = messages;
	}

	public Vector<Order> getCurrentOrders() {
		return currentOrders;
	}

	public void setCurrentOrders(Vector<Order> currentOrders) {
		this.currentOrders = currentOrders;
	}

	public Vector<Order> getDoneOrders() {
		return doneOrders;
	}

	public void setDoneOrders(Vector<Order> doneOrders) {
		this.doneOrders = doneOrders;
	}

	public Vector<Course> getCourses() {
		return courses;
	}

	public void setCourses(Vector<Course> courses) {
		this.courses = courses;
	}

	public boolean clearObjects() {
		users.clear();
		admins.clear();
		managers.clear();
		teachers.clear();
		students.clear();
		techSupporters.clear();
		messages.clear();
		currentOrders.clear();
		doneOrders.clear();
		courses.clear();
		return true;
	}

	public boolean initDatabase() throws ClassNotFoundException, IOException {
		if (new File("users.out").exists() && new File("courses.out").exists() && new File("messages.out").exists()
				&& new File("orders.out").exists()) {
			clearObjects();
			deserializeDatabase();
		}
		return true;
	}

	public boolean deserializeDatabase() throws ClassNotFoundException, IOException {
		deserializeUsers();
		deserializeMessages();
		deserializeOrders();
		deserializeCourses();
		return true;
	}

	public boolean serializeDatabase() throws ClassNotFoundException, IOException {
		serializeUsers();
		serializeMessages();
		serializeOrders();
		serializeCourses();
		return true;
	}

	public boolean determineUsers() {
		for (User u : users) {
			if (u.getUserType() == UserType.ADMIN)
				admins.add((Admin) u);
			else if (u.getUserType() == UserType.MANAGER)
				managers.add((Manager) u);
			else if (u.getUserType() == UserType.TEACHER)
				teachers.add((Teacher) u);
			else if (u.getUserType() == UserType.TECHSUPPORT)
				techSupporters.add((TechSupporter) u);
			else if (u.getUserType() == UserType.STUDENT)
				students.add((Student) u);
		}
		return true;
	}

	public boolean determineOrders() {
		for (Order o : currentOrders)
			if (o.getStatus()) {
				doneOrders.add(o);
				currentOrders.remove(o);
			}
		return true;
	}

	public boolean deserializeUsers() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("users.out");
		ObjectInputStream oin = new ObjectInputStream(fis);
		users = (HashSet<User>) oin.readObject();
		determineUsers();
		fis.close();
		oin.close();
		return true;
	}

	public boolean serializeUsers() throws IOException, ClassNotFoundException {
		users.addAll(students);
		users.addAll(admins);
		users.addAll(managers);
		users.addAll(teachers);
		users.addAll(techSupporters);
		FileOutputStream fos = new FileOutputStream("users.out");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(users);
		oos.flush();
		oos.close();
		return true;
	}

	public boolean deserializeMessages() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("messages.out");
		ObjectInputStream oin = new ObjectInputStream(fis);
		messages = (Vector<Message>) oin.readObject();
		fis.close();
		oin.close();
		return true;
	}

	public boolean serializeMessages() throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("messages.out");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(messages);
		oos.flush();
		oos.close();
		return true;
	}

	public boolean deserializeOrders() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("orders.out");
		ObjectInputStream oin = new ObjectInputStream(fis);
		currentOrders = (Vector<Order>) oin.readObject();
		determineOrders();
		fis.close();
		oin.close();
		return true;
	}

	public boolean serializeOrders() throws IOException, ClassNotFoundException {
		currentOrders.addAll(doneOrders);
		FileOutputStream fos = new FileOutputStream("orders.out");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(currentOrders);
		determineOrders();
		oos.flush();
		oos.close();
		return true;
	}

	public boolean deserializeCourses() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("courses.out");
		ObjectInputStream oin = new ObjectInputStream(fis);
		courses = (Vector<Course>) oin.readObject();
		fis.close();
		oin.close();
		return true;
	}

	public boolean serializeCourses() throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("courses.out");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(courses);
		oos.flush();
		oos.close();
		return true;
	}

}
