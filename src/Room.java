import java.util.ArrayList;

public class Room {
    private String name;
    private ArrayList<Dragon> dragons;
    private boolean containshealthPot;
    private boolean roomCleared;
    private DragonSlayer dragonSlayer;

    public Room(String name, DragonSlayer dragonSlayer) {
        this.dragonSlayer = dragonSlayer;
        this.name = name;
        containshealthPot = true;
        roomCleared = false;
        dragons = new ArrayList<>();
        int numberOfDragons = (int) (Math.random() * 3 + 1);
        for (int i = 1; i <= numberOfDragons; i++) {
            dragons.add(new Dragon());
        }
    }

    public void searchRoom() {
        if (containshealthPot) {
            if ((int) (Math.random() * 3) == 0) {
                System.out.println("You found a health potion");
                containshealthPot = false;
            } else {
                System.out.println("You found nothing");
            }
        } else {
            System.out.println("You already found the health potion from this room");
        }
    }

    public void fightDragons(Player plr) {
        for (int i = dragons.size() - 1; i >= 0; i--) {
            if (plr.getHealth() <= 0) {
                break;
            }
            System.out.println("You encountered a dragon with " + dragons.get(i).gethealth() + " health");
            while (plr.getHealth() > 0) {
                System.out.println("You attacked the dragon and dealt " + plr.attackDragon(dragons.get(i)) + " damage");
                if (dragons.get(i).gethealth() > 0) {
                    System.out.println("The dragon has " + dragons.get(i).gethealth() + " health remaining");
                    System.out.println("The dragon swings at you and deals " + dragons.get(i).attackPlayer(plr) + " damage");
                    if (plr.getHealth() > 0) {
                        System.out.println("You have " + plr.getHealth() + " health remaining");
                    } else {
                        System.out.println("You died");
                        dragonSlayer.endGame();
                    }
                } else {
                    System.out.println("You slayed the dragon!");
                    plr.incrementDragonsDefeated();
                    break;
                }
            }

            if (plr.getHealth() > 0) {
                System.out.println("You have defeated all the dragons in this room!");
            }
        }

        roomCleared = true;
    }

    public int getDragonCount() {
        return dragons.size();
    }

    public boolean getRoomCleared() {
        return roomCleared;
    }
}