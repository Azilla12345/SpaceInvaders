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

    String sprite;

    public Alien(int damage, int hp) {
        this.damage = damage;
        this.hp = hp;
        Xvalue = 0;
        Yvalue = 0;
        try {
            image = ImageIO.read(new File("src/aliens.png"));
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
}
