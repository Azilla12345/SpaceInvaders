public class Ship {

    private int health;
    Weapon weapon;
    public Ship(int weapon, boolean extraHealth) {
        this.weapon = new Weapon(weapon);
        health = 100;
        if (extraHealth) {
            health*= 2;
        }
    }

    public void move() {

    }

}
