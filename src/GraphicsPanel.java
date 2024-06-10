import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GraphicsPanel extends JPanel implements KeyListener, MouseListener, ActionListener {
    private BufferedImage background;
    private Ship player;
    private Alien alien1;
    private Alien alien2;
    private Alien alien3;
    private Weapon weapon;
    private boolean[] pressedKeys;
    private ArrayList<Laser> lasers;
    private ArrayList<Alien> enemies;
    private Timer timer;
    private int time;
    private boolean dead = false;

    private boolean right;

    public GraphicsPanel(String name) {
        try {
            background = ImageIO.read(new File("src/background.jpg"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        player = new Ship("src/ShipSprite.png", "src/ShipSprite.png", name);
        weapon = new Weapon(2);
        alien1 = new Alien(5, 10);
        alien2 = new Alien(5, 10);
        alien2.setXvalue(400);
        alien3 = new Alien(5, 10);
        alien3.setXvalue(800);
        lasers = new ArrayList<Laser>();
        enemies = new ArrayList<Alien>();
        pressedKeys = new boolean[128];
        time = 0;
        right = true;
        timer = new Timer(1000, this); // this Timer will call the actionPerformed interface method every 1000ms = 1 second
        timer.start();
        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true); // this line of code + one below makes this panel active for keylistener events
        requestFocusInWindow(); // see comment above
        int i = 0;
        while (i != 5) {
            Alien alien = new Alien(5, 10);
            enemies.add(alien);
            i++;
        }
    }

    @Override
    public void paintComponent(Graphics g) {

        enemies.add(alien1);
        enemies.add(alien2);
        enemies.add(alien3);
        if (alien1.isDead())  {
            alien1.setXvalue(1920);
        } else {
            if ((alien1.isRight())) {
                alien1.moveRight();
                if (alien1.getXvalue() >= 1920 - alien1.getAlienImage().getWidth()) {
                    alien1.setRight(false);
                }
            } else {
                alien1.moveLeft();
                if (alien1.getXvalue() <= 0) {
                    alien1.setRight(true);
                }
            }
        }if (alien2.isDead()) {
            alien2.setXvalue(1920);
        } else {
            if ((alien2.isRight())) {
                alien2.moveRight();
                if (alien2.getXvalue() >= 1920 - alien2.getAlienImage().getWidth()) {
                    alien2.setRight(false);
                }
            } else {
                alien2.moveLeft();
                if (alien2.getXvalue() <= 0) {
                    alien2.setRight(true);
                }
            }
        }
        if (alien3.isDead()) {
            alien3.setXvalue(1920);
        } else {
            if ((alien3.isRight())) {
                alien3.moveRight();
                if (alien3.getXvalue() >= 1920 - alien3.getAlienImage().getWidth()) {
                    alien3.setRight(false);
                }
            } else {
                alien3.moveLeft();
                if (alien3.getXvalue() <= 0) {
                    alien3.setRight(true);
                }
            }
        }
        super.paintComponent(g);  // just do this
        g.drawImage(background, 0, 0, null);  // the order that things get "painted" matter; we put background down first
        g.drawImage(player.getPlayerImage(), player.getxCoord(), player.getyCoord(), null);
        if (!(alien1.isDead())) {
            g.drawImage(alien1.getAlienImage(), alien1.getXvalue(), alien1.getYvalue(), null);
        }else {
            enemies.remove(alien1);
        }
        if (!(alien2.isDead())) {
            g.drawImage(alien2.getAlienImage(), alien2.getXvalue(), alien2.getYvalue(), null);
        }
        if (!(alien3.isDead())) {
            g.drawImage(alien3.getAlienImage(), alien3.getXvalue(), alien3.getYvalue(), null);
        }






        // this loop does two things:  it draws each Coin that gets placed with mouse clicks,
        // and it also checks if the player has "intersected" (collided with) the Coin, and if so,
        // the score goes up and the Coin is removed from the arraylist
        for (int i = 0; i < lasers.size(); i++) {
            Laser laser = lasers.get(i);
            g.drawImage(laser.getImage(), laser.getxCoord(), laser.getyCoord(), null); // draw Coin
            laser.shoot();
            if (alien1.AlienRect().intersects(laser.laserRect())) { // check for collision
                player.collectCoin();
                dead = true;
                lasers.remove(i);
                alien1.setDead(true);
                enemies.remove(alien1);
                i--;
            }
            if (alien2.AlienRect().intersects(laser.laserRect())) { // check for collision
                player.collectCoin();
                dead = true;
                lasers.remove(i);
                alien2.setDead(true);
                enemies.remove(alien2);
                i--;
            }
            if (alien3.AlienRect().intersects(laser.laserRect())) { // check for collision
                player.collectCoin();
                dead = true;
                lasers.remove(i);
                alien3.setDead(true);
                i--;
            }
            if (laser.getyCoord() <= 0) {
                lasers.remove(i);
                i--;
            }
        }



        // draw score
        g.setFont(new Font("Courier New", Font.BOLD, 24));
        g.drawString(player.getName() + "'s Score: " + player.getScore(), 20, 40);
        g.drawString("Time: " + time, 20, 70);

        // player moves left (A)
        if (pressedKeys[65]) {
            player.faceLeft();
            player.moveLeft();
        }

        // player moves right (D)
        if (pressedKeys[68]) {
            player.faceRight();
            player.moveRight();
        }

        // player moves up (W)
        if (pressedKeys[87]) {
            player.moveUp();
        }

        // player moves down (S)
        if (pressedKeys[83]) {
            player.moveDown();
        }




    }

    // ----- KeyListener interface methods -----
    public void keyTyped(KeyEvent e) { } // unimplemented

    public void keyPressed(KeyEvent e) {
        // see this for all keycodes: https://stackoverflow.com/questions/15313469/java-keyboard-keycodes-list
        // A = 65, D = 68, S = 83, W = 87, left = 37, up = 38, right = 39, down = 40, space = 32, enter = 10
        int key = e.getKeyCode();
        pressedKeys[key] = true;
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        pressedKeys[key] = false;
    }

    // ----- MouseListener interface methods -----
    public void mouseClicked(MouseEvent e) { }  // unimplemented; if you move your mouse while clicking,
    // this method isn't called, so mouseReleased is best

    public void mousePressed(MouseEvent e) { } // unimplemented

    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {  // left mouse click
            int tempX = player.getxCoord();
            int tempY = player.getyCoord();
            Laser laser = new Laser(tempX,tempY, 0);
            laser.laserRect();
            lasers.add(laser);
            laser.shoot();
        } else {
            Point mouseClickLocation = e.getPoint();
            if (player.playerRect().contains(mouseClickLocation)) {
                player.turn();
            }
        }
    }

    public void mouseEntered(MouseEvent e) { } // unimplemented

    public void mouseExited(MouseEvent e) {

    } // unimplemented

    // ACTIONLISTENER INTERFACE METHODS: used for buttons AND timers!
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Timer) {
            time++;
        }
    }
}
