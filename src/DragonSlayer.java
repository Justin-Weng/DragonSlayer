import java.util.Scanner;
import java.util.ArrayList;

public class DragonSlayer {
    private Scanner scan;
    private Player plr;
    private int score;
    private int highScore;
    private int gameResetNumber;
    public DragonSlayer() {
        scan = new Scanner(System.in);
        gameResetNumber = 0;
    }

    public void play() {
        mainMenu();
    }

    private void mainMenu() {
        ConsoleUtility.clearScreen();
        int input;
        boolean endLoop = false;
        while (!endLoop) {
            System.out.println("--------------- Main menu ---------------");
            System.out.println("(1) Start new game");
            System.out.println("(2) End current game");
            System.out.println("(3) View top score");
            System.out.println("Select an option: ");
            try {
                input = scan.nextInt();
                if (input == 1) {
                    endLoop = true;
                    startGame();
                } else if (input == 2) {
                    endLoop = true;
                    endGame();
                } else if (input == 3) {
                    System.out.println("Your top score is " + highScore);
                    ConsoleUtility.wait(3000);
                }
            } catch (Exception e) { }
            if (!endLoop) {
                System.out.println("Invalid Option");
                scan.nextLine();
                ConsoleUtility.wait(1000);
            }
        }
    }
    private void startGame() {
        resetGame();
        int currentGameKey = gameResetNumber;
        score = 0;
        plr = new Player();
        int roomsCleared = 0;
        ArrayList<String> roomNames = new ArrayList<>();
        roomNames.add("Dragon Den");
        roomNames.add("Dragon Cave");
        roomNames.add("Dragon Castle");
        roomNames.add("Dragon Cage");
        roomNames.add("Dragon Lair");

        System.out.println("Welcome to Dragon Slayer!");
        System.out.println("Your goal in this game is to clear all 5 rooms by defeating the dragons!");
        System.out.println("Your able to collect powerups to make yourself stronger along the way");

        while (currentGameKey == gameResetNumber && roomsCleared < 5) {
            System.out.println(1);
            int chosenIdx = (int) (Math.random() * roomNames.size() + 1);
            String name = roomNames.get(chosenIdx);
            roomNames.remove(chosenIdx);

            Room currentRoom = new Room(name);

            System.out.println("You stumbled into " + name + ". You see " + currentRoom.getDragonCount() + " dragons!");
            while (!currentRoom.getRoomCleared()) {
                System.out.println("What do you want to do?");
                System.out.println("(1) Search for a health potion");
                System.out.println("(2) Fight the dragons");
                int input = getIntFromUser();

                if (input == 1) {
                    currentRoom.searchRoom();
                } else if (input == 2) {
                    currentRoom.fightDragons(plr);
                }
            }

            roomsCleared++;
        }
    }
    
    private void endGame() {
        System.out.println("Your game has ended!");
        System.out.println("Your score this game is " + score);
        resetGame();
        ConsoleUtility.wait(3000);
        mainMenu();
    }

    private void resetGame() {
        score = 0;
        plr = null;
        gameResetNumber++;
    }

    private int getIntFromUser() {
        int input = 0;
        boolean endLoop = false;

        while (!endLoop) {
            try {
                input = scan.nextInt();
                endLoop = true;
            } catch (Exception e) {
                System.out.println("Invalid choice!");
            }
        }

        return input;
    }
}