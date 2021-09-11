import java.util.StringTokenizer;
import java.io.*;

public class Test {

	public static void main(String[] args) throws Exception {
		System.out.println("Welcome");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			menu: while (true) {
				System.out.println("What do u wanna do? :)");
				System.out.println("1. Add a book  \n 2. View books  \n 3. Exit");
				int choice = Integer.parseInt(in.readLine());
				if (choice == 1) {
					System.out.println("Enter author and title separated by ,");
					String s = in.readLine();
					StringTokenizer st = new StringTokenizer(s, ",");
					String author = st.nextToken();
					String title = st.nextToken();
					Book b = new Book(author, title);
					Book.books.add(b);
				} else if (choice == 2) {
					if (!Book.books.isEmpty()) {
						for (Book book : Book.books) {
							System.out.println(book);
						}
					} else
						System.out.println("No books added!");
				} else if (choice == 3) {
					Book.saveBooks();
					System.exit(0);
				}
			}
		} catch (Exception e) {
			System.out.println("Some problem happened... Saving data");
			Book.saveBooks();
		}

	}

}
