public class Player {
    private String name;
    private int health;
    private int gold;
    private boolean hasHealthPot;
    private Sword sword;

    public Player() {
        health = 1000;
        sword = new Sword();
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
        hasHealthPot = false;
        health += 10;
    }

    public int getHealth() {
        return health;
    }
}
