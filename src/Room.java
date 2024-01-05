import java.util.ArrayList;

public class Room {
    private String name;
    private ArrayList<Dragon> dragons;
    private boolean containshealthPot;
    private boolean roomCleared;

    public Room(String name) {
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

    public int getDragonCount() {
        return dragons.size();
    }

    public boolean getRoomCleared() {
        return roomCleared;
    }
}