package PROG.OOP.acmp;
import java.util.*;
public class A25 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int a = input.nextInt(), b = input.nextInt();
        if(a > b){System.out.println(">");}
        else if(a < b){System.out.println("<");}
        else{System.out.println("=");}
    }
}
