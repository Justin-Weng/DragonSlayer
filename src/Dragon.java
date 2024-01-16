public class Dragon {
    private int health;
    private int level;

    public Dragon() {
        health = 1000;
        level = (int) (Math.random() * 3 + 1);
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public int gethealth() {
        return health;
    }

    public int attackPlayer(Player plr) {
        int rand = (int) (Math.random() * 100 + 1);
        if (rand > plr.getSword().getDodgeRating()) {
            int damageDealt = level * (int) ((Math.random() + 1) * 10);
            plr.takeDamage(damageDealt);
            return damageDealt;
        }
        return -1;
    }
}
