import java.io.*;

public class Deserialization {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("books.out");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Book b = (Book) ois.readObject();
		System.out.println(b);
		fis.close();
		ois.close();
	}

}
