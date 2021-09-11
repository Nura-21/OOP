import java.io.*;

public class Serialization {

	public static void main(String[] args) throws Exception {
		FileOutputStream fos = new FileOutputStream("books.out");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		Book b = new Book("Chehov", "Vishneviy Sad");
		oos.writeObject(b);
		oos.flush();
		oos.close();
	}

}
