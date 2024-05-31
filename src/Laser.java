import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Laser {
    private double X;
    private double Y;
    private int maxHeight;
    private BufferedImage image;

    public Laser(double x, double y, int maxHeight) {
        X = x;
        Y = y;
        this.maxHeight = maxHeight;
        try {
            image = ImageIO.read(new File("src/coin.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void shoot() {
        if (Y >= maxHeight) {
            Y--;
        }
    }

    public int getxCoord() {
        return (int) X;
    }

    public int getyCoord() {
        return (int) Y;
    }

    public BufferedImage getImage() {
        return image;
    }
    public Rectangle laserRect() {
        int imageHeight = getImage().getHeight();
        int imageWidth = getImage().getWidth();
        Rectangle rect = new Rectangle((int)X, (int)Y, imageWidth, imageHeight);
        return rect;
    }
}
