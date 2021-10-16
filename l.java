import java.util.*;
public class l{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), k = input.nextInt();
        String s = input.nextLine();
        Vector<Integer> alpha = new Vector<>();
        Vector<Integer> first_entries = new Vector<>(k);
        Vector<Integer> last_entries = new Vector<>(k);
        System.out.println(n + k + s);
        for(int i = 0; i < 26; ++i){
            alpha.add(-1);
        }
        ArrayList<Character> guests = new ArrayList<Character>();
        for (char c : s.toCharArray()) {
            guests.add(c);
        }
        for(int i = 0 ; i < guests.size(); ++i){
            System.out.println(guests.get(i) - 'A');
        }
    }
}