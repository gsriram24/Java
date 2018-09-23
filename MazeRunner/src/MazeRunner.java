import java.util.*;
public class MazeRunner {
    public static void main(String[] args) {
        Maze myMap = new Maze();
        int moves = 0;

        intro(myMap);

        while(myMap.didIWin()==false){

            if (moves == 100) {
                System.out.println("Sorry, but you didn't escape in time- you lose!");
                break;
            } else {
                String dir = userMove();
                moving(dir, myMap);
                moves++;
                movesMessage(moves);
            }
        }

        if (moves < 100 && myMap.didIWin() == true) {
            System.out.println("Congratulations, you made it out alive!");
            System.out.println("and you did it in " + moves + " moves");
        }

    }
    public static void intro(Maze myMap) {
        System.out.println("Welcome to Maze Runner! ");
        System.out.println("Here is your current position: ");
        myMap.printMap();
    }
    public static String userMove() {
        Scanner input = new Scanner(System.in);
        System.out.print("Where would you like to move? (R)right, (L)left, (U)up or (D)down ");
        String selectMove = input.next().toUpperCase();

        while(!(selectMove.equals("R") || selectMove.equals("L") || selectMove.equals("U") || selectMove.equals("D"))) {
            System.out.print("You can only chose either (R)right, (L)left, (U)up or (D)down ");
            selectMove = input.next().toUpperCase();
        }
        return selectMove;
    }
    public static void moving(String dir, Maze myMap) {

        if (dir.equals("R") && (myMap.canIMoveRight() == true)) {
            myMap.moveRight();
            myMap.printMap();

        } else if (dir.equals("L") && (myMap.canIMoveLeft() == true)) {
            myMap.moveLeft();
            myMap.printMap();

        } else if (dir.equals("U") && (myMap.canIMoveUp() == true)) {
            myMap.moveUp();
            myMap.printMap();

        } else if (dir.equals("D") && (myMap.canIMoveDown() == true)) {
            myMap.moveDown();
            myMap.printMap();

        }else if (myMap.isThereAPit(dir) == true) {
            navigatePit(myMap, dir);

        } else {
            myMap.printMap();
            System.out.println("Sorry, you've hit a wall.");

        }
    }

    public static void movesMessage(int moves) {

        if (moves == 50) {
            System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes");
        }

        if (moves == 75) {
            System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
        }

        if (moves == 90) {
            System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
        }

        if (moves == 100) {
            System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
        }
    }

    public static void navigatePit(Maze myMap, String dir) {
        Scanner input = new Scanner(System.in);
        System.out.println("Watch out! There's a pit ahead, jump it?");
        String pitNavigate = input.next();

        if (pitNavigate.charAt(0) == 'y') {
            myMap.jumpOverPit(dir);
            myMap.printMap();
        }




    }

}

