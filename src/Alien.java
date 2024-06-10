import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Alien {
    private int damage;
    private int hp;
    private int Xvalue;
    private int Yvalue;
    private BufferedImage image ;
    private boolean right;

    private boolean isDead;

    public Alien(int damage, int hp) {
        this.damage = damage;
        this.hp = hp;
        Xvalue = 0;
        Yvalue = 0;
        right = true;
        isDead = false;
        try {
            image = ImageIO.read(new File("src/AlienSprite.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //that's just temporary, change it later
    }

    public void setDamage(int x) {
        damage = x;
    }

    public void setHp(int x) {
        hp = x;
    }

    public int getHp() {
        return hp;
    }
    public void setXvalue(int xvalue) {
        Xvalue = xvalue;
    }

    public int getXvalue() {
        return Xvalue;
    }

    public int getYvalue() {
        return Yvalue;
    }

    public BufferedImage getAlienImage() {
        return image;
    }

    public Rectangle AlienRect() {
        int height = getAlienImage().getHeight();
        int width = getAlienImage().getWidth();
        Rectangle rect = new Rectangle(getXvalue(), getYvalue(), width, height);
        return rect;
    }

    public void moveRight() {
        Xvalue += 5;
    }

    public void moveLeft() {
     Xvalue -= 5;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean enter) {
        right =enter;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }
}
