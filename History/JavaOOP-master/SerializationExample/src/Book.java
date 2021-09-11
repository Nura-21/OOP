import java.util.Date;
import java.util.Vector;
import java.io.*;

public class Book implements Serializable {
	String author;
	String title;
	Date publishDate;
	static Vector<Book> books;
	static {
		if (new File("books.out").exists()) {
			try {
				books = readBooks();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else
			books = new Vector<Book>();
	}

	public Book() {
	}

	public Book(String author, String title) {
		this.author = author;
		this.title = title;
		publishDate = new Date();
	}

	public String toString() {
		return "Author: " + author + " " + title + " " + publishDate;
	}

	public static Vector<Book> readBooks() throws Exception {
		FileInputStream fis = new FileInputStream("books.out");
		ObjectInputStream ois = new ObjectInputStream(fis);
		books = (Vector<Book>)ois.readObject();
		fis.close();
		ois.close();
		return books;
	}

	public static void saveBooks() throws Exception {
		FileOutputStream fos = new FileOutputStream("books.out");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(books);
		oos.flush();
		oos.close();
	}
}
