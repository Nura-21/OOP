package PROG.OOP;
import java.util.Scanner;

class example2{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n  = input.nextInt();
        String s = input.next();
        System.out.println(n);
        System.out.println(s);
        for(int i = 0; i < n; ++i){
            if(i % 2 == 0){
                System.out.print(i + " ");
            }
        }
    }
}
