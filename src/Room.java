import java.util.ArrayList;

public class Room {
    private String name;
    private ArrayList<Dragon> dragons;
    private boolean searched;
    private boolean roomCleared;
    private DragonSlayer dragonSlayer;

    public Room(String name, DragonSlayer dragonSlayer) {
        this.dragonSlayer = dragonSlayer;
        this.name = name;
        searched = false;
        roomCleared = false;
        dragons = new ArrayList<>();
        int numberOfDragons = (int) (Math.random() * 3 + 1);
        for (int i = 1; i <= numberOfDragons; i++) {
            dragons.add(new Dragon());
        }
    }

    public void searchRoom(Player plr) {
        if (!searched) {
            searched = true;
            if ((int) (Math.random() * 3) == 0) {
                plr.getHealthPotion();
                System.out.println("You found a health potion");
            } else {
                System.out.println("You found nothing");
            }
        } else {
            System.out.println("You cannot search this room again");
        }
    }

    public void fightDragons(Player plr) {
        for (int i = dragons.size() - 1; i >= 0; i--) {
            if (plr.getHealth() <= 0) {
                break;
            }
            System.out.println("You encountered a dragon with " + dragons.get(i).gethealth() + " health");
            while (plr.getHealth() > 0) {
                ConsoleUtility.wait(500);
                System.out.println("You attacked the dragon and dealt " + plr.attackDragon(dragons.get(i)) + " damage");
                if (dragons.get(i).gethealth() > 0) {
                    System.out.println("The dragon has " + dragons.get(i).gethealth() + " health remaining");
                    ConsoleUtility.wait(500);
                    int damageFromDragon = dragons.get(i).attackPlayer(plr);
                    if (damageFromDragon != -1) {
                        System.out.println("The dragon swings at you and deals " + damageFromDragon + " damage");
                        if (plr.getHealth() > 0) {
                            System.out.println("You have " + plr.getHealth() + " health remaining");
                        } else {
                            System.out.println("You died");
                            dragonSlayer.endGame();
                        }
                    } else {
                        System.out.println("The dragon swings at you but misses!");
                    }
                } else {
                    plr.incrementDragonsDefeated();
                    System.out.println("You slayed the dragon!");
                    int randomChoice = (int) (Math.random() * 4) + 1;
                    if (randomChoice == 1) {
                        int goldGain = (int) ((Math.random() * 51) + 50);
                        plr.setGold(plr.getGold() + goldGain);
                        System.out.println("The dragon dropped " + goldGain + " gold");
                    } else if (randomChoice == 2) {
                        int attackGain = (int) ((Math.random() * 4) + 1);
                        plr.getSword().setAttackPower(plr.getSword().getAttackPower() + attackGain);
                        int dodgeGain = (int) ((Math.random() * 6) + 1);
                        plr.getSword().setDodgeRating(plr.getSword().getDodgeRating() + dodgeGain);
                        System.out.println("After defeating the dragon, your sword gains " + attackGain + " more damage and " + dodgeGain + " more dodge chance");
                        System.out.println("Your sword now has a total of " + plr.getSword().getAttackPower() + " damage and " + plr.getSword().getDodgeRating() + " dodge chance");
                    } else if (randomChoice == 3) {
                        int heal = (int) ((Math.random() * 31) + 30);
                        plr.heal(heal);
                        System.out.println("You feel better after your victory and gain " + heal + " health");
                    } else if (randomChoice == 4) {
                        System.out.println("You received nothing from the dragon...");
                    }
                    break;
                }
            }
        }

        if (plr.getHealth() > 0) {
            System.out.println("You have defeated all the dragons in this room!");
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