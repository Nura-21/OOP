package controller;

import java.io.IOException;
import mainClasses.*;
import wspEnums.*;

// superuser: login : superuser, password: superuser
public class MainTester {

	public static void fillDataBase() {
		Admin a = new Admin("S", "S");
		a.setLogin("superuser");
		a.setPassword("superuser");
		DataBase.getInstance().getUsers().add(a);
		Student s1 = new Student("Daniil", "Koilybayev", Degree.BACHELOR, 2, Faculty.FIT, "IS");
		DataBase.getInstance().getUsers().add(s1);
		Student s2 = new Student("Ivan", "Stepanenko", Degree.BACHELOR, 2, Faculty.FIT, "AUshnik");
		DataBase.getInstance().getUsers().add(s2);
		Student s3 = new Student("Shayakhmet", "Bakimov", Degree.BACHELOR, 2, Faculty.FIT, "IS");
		DataBase.getInstance().getUsers().add(s3);
		Student s4 = new Student("Aruzhan", "Sadakbaeva", Degree.BACHELOR, 2, Faculty.FIT, "IS");
		DataBase.getInstance().getUsers().add(s4);
		Student s5 = new Student("Dmitry", "Zalishuk", Degree.BACHELOR, 3, Faculty.KMA, "Pirat");
		DataBase.getInstance().getUsers().add(s5);
		Student s6 = new Student("Miras", "Sultanbay", Degree.BACHELOR, 2, Faculty.KMA, "Kapitan");
		DataBase.getInstance().getUsers().add(s6);
		Student s7 = new Student("John", "Smith", Degree.BACHELOR, 1, Faculty.BS, "Businessman");
		DataBase.getInstance().getUsers().add(s7);
		Student s8 = new Student("Floid", "Meivezers", Degree.BACHELOR, 2, Faculty.BS, "Businessman");
		DataBase.getInstance().getUsers().add(s8);
		Student s9 = new Student("Aslan", "Askarbek", Degree.BACHELOR, 2, Faculty.ISE, "DataSatanist");
		DataBase.getInstance().getUsers().add(s9);
		Student s10 = new Student("Nurbolat", "Sagynbek", Degree.BACHELOR, 2, Faculty.MCM, "Mathematic");
		DataBase.getInstance().getUsers().add(s10);
		Teacher t1 = new Teacher("Johny", "Mark", 4000, 3, TeacherTitle.PROFESSOR);
		DataBase.getInstance().getUsers().add(t1);
		Teacher t2 = new Teacher("Elizabeth", "Stoun", 6000, 10, TeacherTitle.PHD);
		DataBase.getInstance().getUsers().add(t2);
		Manager m1 = new Manager("Catherine", "Brown", 4500, 5);
		DataBase.getInstance().getUsers().add(m1);
		Manager m2 = new Manager("Michael", "Krajn", 5800, 8);
		DataBase.getInstance().getUsers().add(m2);
		TechSupporter ts1 = new TechSupporter("Vasiliy", "Rumyancev", 3000, 4);
		DataBase.getInstance().getUsers().add(ts1);
		TechSupporter ts2 = new TechSupporter("Magomed", "Magomedov", 4000, 30);
		DataBase.getInstance().getUsers().add(ts2);
		Course crs1 = new Course("MATH2201", "Calculus", "Math", 4, 1, Faculty.FIT);
		crs1.setAvailable(true);
		t2.getCourses().add(crs1);
		DataBase.getInstance().getCourses().add(crs1);
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, CloneNotSupportedException {
		DataBase.getInstance().initDatabase();
//		fillDataBase();
		for (User u : DataBase.getInstance().getUsers()) {
			System.out.println(u);
		}
		SystemLogin.start();
		DataBase.getInstance().serializeDatabase();

	}

}
