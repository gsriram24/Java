import java.util.*;
public class OddsAndEvens {

    public static void main(String[] args) {
        System.out.println("Let's play a game of odds and evens. ");
        System.out.print("What is your name? ");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        System.out.print("Hi, " + name + ", What do you choose? (O)dds or (E)vens: ");
        String ch = input.next();
        if (ch.equals("O")) System.out.println(name + " has picked Odds. The computer will choose even.");
        else {
            System.out.println(name + " has picked Evens. The computer will choose Odds.");
        }
        System.out.print("How many fingers do you put out? ");
        int user=input.nextInt();
        Random rand = new Random();
        int computer= rand.nextInt(6);
        System.out.println("The computer plays "+ computer + " fingers.");
        System.out.println("-------------------------------");
        System.out.println();
        System.out.println();
        int sum= user+computer;
        System.out.println(user + " + "  + computer + " = " + sum);
        boolean oddOrEven = ((sum % 2) == 0);

        if(oddOrEven && ch.equals("E")) System.out.println("You win.");
        else if(!oddOrEven && ch.equals("O")) System.out.println("You win.");
        else {
            System.out.println("Computer Wins.");

        }
    }
}