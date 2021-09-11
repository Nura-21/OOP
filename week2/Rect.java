package PROG.OOP.week2;

import java.util.Scanner;

class Rect{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Write width and height of rectangle : ");
        int a = input.nextInt(), b = input.nextInt();
        System.out.print("Write colour : ");
        String colour = input.nextLine();
        rect myRect = new rect(a, b, colour);
        String s = "exit";
        while(s != "exit"){
            if(s == "perimetr"){
                System.out.println("Perimetr : " + myRect.getPerimetr());
            }
            else if(s == "area"){
                System.out.println("Area : " + myRect.getArea());
            }
            else if(s == "width"){
                System.out.println("Width : " + myRect.getWidth());
            }
            else if(s == "height"){
                System.out.println("Height : " + myRect.getHeight());
            }
            else if(s == "square"){
                if(myRect.isSquare() == true){
                    System.out.println("It's square");
                }
                else{System.out.println("It's not square");}
            }
            else if(s == "change"){
                String new_colour = input.nextLine();
                System.out.println("New colour : " + myRect.changeColour(new_colour));
            }
            s = input.nextLine();
        }
        System.out.println("Perimetr : " + myRect.getPerimetr());
        System.out.println("Area : " + myRect.getArea());
        System.out.println("Width : " + myRect.getWidth());
        System.out.println("Height : " + myRect.getHeight());
        if(myRect.isSquare() == true){
            System.out.println("It's square");
        }
        else{System.out.println("It's not square");}
    }
}

class rect{
    int height,width;
    String colour;

    public rect(int a, int b, String colour){
        this.height = a;
        this.width = b;
        this.colour = colour;
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    public int getPerimetr(){
        return (2 * (this.height + this.width));
    }

    public boolean isSquare(){
        return this.height == this.width;
    }

    public int getArea(){
        return this.height * this.width;
    }

    public String changeColour(String new_colour){
        this.colour = new_colour;
        return this.colour;
    }
}
