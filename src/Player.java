public class Player {
    private String name;
    private int health;
    private int gold;
    private boolean hasHealthPot;
    private Sword sword;
    private int dragonsDefeated;

    public Player() {
        health = 10000;
        sword = new Sword();
        dragonsDefeated = 0;
    }

    public int attackDragon(Dragon dragon) {
        int damageDealt = sword.getAttackPower() * (int) ((Math.random() + 1) * 10);
        dragon.takeDamage(damageDealt);
        return damageDealt;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public void useHealthPot() {
        if (hasHealthPot) {
            hasHealthPot = false;
            int healthGain = (int) (Math.random() * 26 + 50);
            heal(healthGain);
            System.out.println("You drank your health potion and gained " + healthGain + " health");
            System.out.println("You now have " + health + " health");
        } else {
            System.out.println("You dont have a health potion. Find one by searching a room");
        }
    }

    public int getHealth() {
        return health;
    }

    public void heal(int heal) {
        health += heal;
    }

    public void incrementDragonsDefeated() {
        dragonsDefeated++;
    }

    public int getDragonsDefeated() {
        return dragonsDefeated;
    }
    public Sword getSword() {
        return sword;
    }

    public void setGold(int newGold) {
        gold = newGold;
    }

    public int getGold() {
        return gold;
    }

    public void getHealthPotion() {
        hasHealthPot = true;
    }
}
