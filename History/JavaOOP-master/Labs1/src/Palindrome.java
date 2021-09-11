import java.util.*;

public class Palindrome {
	static boolean isPalindrome(String word) {
		for (int i = 0; i < word.length(); i++)
			if (word.charAt(i) != word.charAt(word.length() - i - 1))
				return false;
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String word = in.nextLine();
		System.out.println(isPalindrome(word));
		in.close();
	}

}
