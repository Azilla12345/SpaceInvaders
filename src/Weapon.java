public class Weapon {
    private int type;
    private int damage;
    private int attackSpeed;
    public Weapon(int type) {
        this.type = type;

        if (type==1) {
            damage = 10;
            attackSpeed = 10;
        }
        else if (type == 2) {
            damage = 30;
            attackSpeed = 30;
        }
        else if (type == 3) {
            damage = 20;
            attackSpeed = 20;
        }
    }

    public int getType() {
        return type;
    }
    public int getDamage() {
        return damage;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }
}
