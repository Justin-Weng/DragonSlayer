public class Sword {
    private int attackPower;
    private int dodgeRating;

    public Sword() {
        attackPower = 10;
        dodgeRating = 20;
    }

    public int getAttackPower() {
        return attackPower;
    }
    public int getDodgeRating() {
        return dodgeRating;
    }

    public void setAttackPower(int newAttackPower) {
        attackPower = newAttackPower;
    }

    public void setDodgeRating(int newDodgeRating) {
        dodgeRating = newDodgeRating;
    }
}
