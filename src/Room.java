import java.util.ArrayList;

public class Room {
    private String name;
    private ArrayList<Dragon> dragons;
    private boolean containshealthPot;
    private boolean roomCleared;

    public Room() {
        name = "Dragon's den";
        containshealthPot = true;
        roomCleared = false;
        int numberOfDragons = (int) (Math.random() * 3 + 1);
        for (int i = 1; i <= numberOfDragons; i++) {
            dragons.add(new Dragon());
        }
    }

    public void searchRoom() {

    }
}