package HamsterGame;

import java.util.Scanner;
import java.util.InputMismatchException;

public class GameController {
 private static final int TURN_LEFT = 1;
 private static final int TURN_RIGHT = 2;
 private static final int WALK_FORWARD = 3;
 private static final int DISPLAY_FOOD_COUNT = 4;
 private static final int EXIT = 5;

 private Scanner scanner;
 private Hamster hamster;
 private GameMap gameMap;

 public GameController() {
     scanner = new Scanner(System.in);
     gameMap = new GameMap();
     hamster = new Hamster(gameMap);
 }

 public void start() {
     boolean isRunning = true;

     while (isRunning) {
         displayMenu();
         int choice = getUserChoice();

         switch (choice) {
             case TURN_LEFT:
                 hamster.turnLeft();
                 break;
             case TURN_RIGHT:
                 hamster.turnRight();
                 break;
             case WALK_FORWARD:
                 hamster.walkForward();
                 break;
             case DISPLAY_FOOD_COUNT:
                 hamster.displayFoodCount();
                 break;
             case EXIT:
                 isRunning = false;
                 System.out.println("Goodbye! See you soon!");
                 break;
             default:
                 handleInvalidInput();
                 break;
         }
         System.out.println();
     }
     scanner.close();
 }

 private void displayMenu() {
     gameMap.printWorldMap();
     System.out.println("------------------------------------------------------------------------");
     System.out.println("1. Turn left\t\t\t2. Turn right\t\t3. Walk forward");
     System.out.println("4. Amount of grains eaten\t5. Exit");
     System.out.println("------------------------------------------------------------------------");
 }

 private int getUserChoice() {
     try {
         return scanner.nextInt();
     } catch (InputMismatchException e) {
         scanner.next(); 
         return -1; 
     }
 }

 private void handleInvalidInput() {
     System.out.println("Please enter a valid input!");
     pause(3000);
 }

 private void pause(int milliseconds) {
     try {
         Thread.sleep(milliseconds);
     } catch (InterruptedException ex) {
         Thread.currentThread().interrupt();
     }
 }

 public static void main(String[] args) {
     GameController game = new GameController();
     game.start();
 }
}
