import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GraphicsPanel extends JPanel {
    private BufferedImage starImg;
    private double stringX;
    private double starY;

    public GraphicsPanel() {
        stringX = 50;
        starY = 50;
        try {
            starImg = ImageIO.read(new File("src/star.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);  // just do this
        stringX += 0.2;
        if (stringX > 500) {
            stringX = 0;
        }
        starY += 0.05;
        if (starY > 400) {
            starY = 0;
        }
        g.setColor(Color.BLUE);
        g.drawRect(50, 100, 40, 20);
        g.setColor(Color.RED);
        g.fillRect(50, 200, 40, 20);
        g.drawImage(starImg, 200, (int) starY, null);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Courier New", Font.BOLD, 18));
        g.drawString("HELLO!", (int) stringX, 300);
    }
}