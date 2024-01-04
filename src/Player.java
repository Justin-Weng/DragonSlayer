public class Player {
    private String name;
    private int health;
    private int gold;
    private boolean hasHealthPot;
    private Sword sword;

    public Player() {
        health = 100;
        sword = new Sword();
    }

    public void attackDragon(Dragon dragon) {
        dragon.takeDamage(sword.getAttackPower());
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public void useHealthPot() {
        hasHealthPot = false;
        health += 10;
    }
}
