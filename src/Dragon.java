public class Dragon {
    private int health;
    private int level;

    public Dragon() {
        health = 100;
        level = (int) (Math.random() * 3 + 1);
    }

    public void takeDamage(int damage) {
        health -= damage;
    }
}
