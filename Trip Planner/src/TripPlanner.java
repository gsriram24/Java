import java.util.Scanner;
public class TripPlanner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Vacation Planner!");
        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.print("Nice to meet you " + name + ", where are you travelling to? ");
        String destination = input.nextLine();
        System.out.println("Great! " + destination + " sounds like a great trip");
        System.out.println("********");
        System.out.println();
        System.out.println();
        System.out.print("How many days are you going to spend in Travelling? ");
        int days = input.nextInt();
        System.out.print("How much money are you going to spend in USD? ");
        double money=input.nextDouble();
        System.out.print("What is the Three letter currency Symbol of the country you are travelling to? ");
        String sym=input.next();
        System.out.print("How many "+sym+" are there in one USD? ");
        float curr= input.nextFloat();
        System.out.println();
        System.out.println("If you are travelling for "+ days + " days then that is equal to "+days*24*60+" minutes or "+days * 24*60*60 + "seconds.");
        System.out.println("If you are going to spend "+ money + "USD that means you can spend upto " + money/days + " USD per day");
        System.out.println("Your total budget in " + sym +" is "+ (money*curr) + sym + ", which per day is " + (money*curr)/days + sym);
        System.out.println("********");
        System.out.println();
        System.out.println();
        System.out.print("What is the time difference, in hours, between your home and the destination? ");
        int diff=input.nextInt();
        System.out.println("That means that when it is midnight at home it would be " + (int)(0 + diff) + ":00 in your destination and when it is noon at home it would be " + (int)(12 + diff) + ":00 at your destination.");
        System.out.println("********");
        System.out.println();
        System.out.println();
        System.out.print("What is the square area of your destination? ");
        double area= input.nextDouble();
        System.out.println("In miles2 it is: "+ area/(1.6*1.6));

    }
}
