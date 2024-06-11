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
    private Alien alien4;
    private Alien alien5;
    private Alien alien6;
    private Alien alien7;
    private Alien alien8;
    private Alien alien9;
    private Weapon weapon;
    private boolean[] pressedKeys;
    private ArrayList<Laser> lasers;
    private ArrayList<Alien> enemies;
    private Timer timer;
    private int time;


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
        alien4 = new Alien(4,10);
        alien5 = new Alien(4, 10);
        alien6 = new Alien(5, 10);
        alien7 = new Alien(4, 20);
        alien8 = new Alien(4, 20);
        alien9 = new Alien(6, 90);
        lasers = new ArrayList<Laser>();
        enemies = new ArrayList<Alien>();
        pressedKeys = new boolean[128];
        time = 0;
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
        if ((alien4.isDead())|| !(alien1.isDead()))  {
            alien4.setXvalue(1920);
        } else {
            if ((alien4.isRight())) {
                alien4.moveRight();
                if (alien4.getXvalue() >= 1920 - alien4.getAlienImage().getWidth()) {
                    alien4.setRight(false);
                }
            } else {
                alien4.moveLeft();
                if (alien4.getXvalue() <= 0) {
                    alien4.setRight(true);
                }
            }
        }if ((alien5.isDead()||!(alien1.isDead()))) {
            alien5.setXvalue(1920);
        } else {
            if ((alien5.isRight())) {
                alien5.moveRight();
                if (alien5.getXvalue() >= 1920 - alien5.getAlienImage().getWidth()) {
                    alien5.setRight(false);
                }
            } else {
                alien5.moveLeft();
                if (alien5.getXvalue() <= 0) {
                    alien5.setRight(true);
                }
            }
        }
        if ((alien6.isDead())||!(alien2.isDead())) {
            alien6.setXvalue(1920);
        } else {
            if ((alien6.isRight())) {
                alien6.moveRight();
                if (alien6.getXvalue() >= 1920 - alien6.getAlienImage().getWidth()) {
                    alien6.setRight(false);
                }
            } else {
                alien6.moveLeft();
                if (alien6.getXvalue() <= 0) {
                    alien6.setRight(true);
                }
            }
        }
        if ((alien7.isDead())|| !(alien2.isDead()))  {
            alien7.setXvalue(1920);
        } else {
            if ((alien7.isRight())) {
                alien7.moveRight();
                if (alien7.getXvalue() >= 1920 - alien7.getAlienImage().getWidth()) {
                    alien7.setRight(false);
                }
            } else {
                alien7.moveLeft();
                if (alien7.getXvalue() <= 0) {
                    alien7.setRight(true);
                }
            }
        }if ((alien8.isDead()) ||!(alien3.isDead())){
            alien8.setXvalue(1920);
        } else {
            if ((alien8.isRight())) {
                alien8.moveRight();
                if (alien8.getXvalue() >= 1920 - alien8.getAlienImage().getWidth()) {
                    alien8.setRight(false);
                }
            } else {
                alien8.moveLeft();
                if (alien8.getXvalue() <= 0) {
                    alien8.setRight(true);
                }
            }
        }
        if ((alien9.isDead()) || !(alien3.isDead())){
            alien9.setXvalue(1920);
        } else {
            if ((alien9.isRight())) {
                alien9.moveRight();
                if (alien9.getXvalue() >= 1920 - alien9.getAlienImage().getWidth()) {
                    alien9.setRight(false);
                }
            } else {
                alien9.moveLeft();
                if (alien9.getXvalue() <= 0) {
                    alien9.setRight(true);
                }
            }
        }




        super.paintComponent(g);  // just do this
        g.drawImage(background, 0, 0, null);  // the order that things get "painted" matter; we put background down first
        g.drawImage(player.getPlayerImage(), player.getxCoord(), player.getyCoord(), null);
        if (!(alien1.isDead())) {
            g.drawImage(alien1.getAlienImage(), alien1.getXvalue(), alien1.getYvalue(), null);
        }else {
            g.drawImage(alien4.getAlienImage(), alien4.getXvalue(), alien4.getYvalue(), null);
            g.drawImage(alien5.getAlienImage(), alien5.getXvalue(), alien5.getYvalue(), null);
        }
        if (!(alien2.isDead())) {
            g.drawImage(alien2.getAlienImage(), alien2.getXvalue(), alien2.getYvalue(), null);
        } else {
            g.drawImage(alien6.getAlienImage(), alien6.getXvalue(), alien6.getYvalue(), null);
            g.drawImage(alien7.getAlienImage(), alien7.getXvalue(), alien7.getYvalue(), null);
        }

        if (!(alien3.isDead())) {
            g.drawImage(alien3.getAlienImage(), alien3.getXvalue(), alien3.getYvalue(), null);
        } else {
            g.drawImage(alien8.getAlienImage(), alien8.getXvalue(), alien8.getYvalue(), null);
            g.drawImage(alien9.getAlienImage(), alien9.getXvalue(), alien9.getYvalue(), null);
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
                lasers.remove(i);
                if ((alien1.getXvalue() >= 1920 + 400)) {
                    alien4.setXvalue(alien1.getXvalue());
                    if (alien4.getXvalue() <= 1000) {
                        alien5.setXvalue(alien1.getXvalue());
                    }
                } else {
                    alien4.setXvalue(alien1.getXvalue()+100);
                    alien5.setXvalue(alien1.getXvalue()+400);
                }
                alien1.setDead(true);
                i--;
            }
            if (alien2.AlienRect().intersects(laser.laserRect())) { // check for collision
                player.collectCoin();
                lasers.remove(i);
                if ((alien2.getXvalue() >= 1920 + 400)) {
                    alien6.setXvalue(alien2.getXvalue());
                    if (alien6.getXvalue() <= 1000) {
                        alien7.setXvalue(alien2.getXvalue());
                    }
                } else {
                    alien6.setXvalue(alien2.getXvalue()+100);
                    alien7.setXvalue(alien2.getXvalue()+400);
                }
                alien2.setDead(true);
                i--;
            }
            if (alien3.AlienRect().intersects(laser.laserRect())) { // check for collision
                player.collectCoin();
                lasers.remove(i);
                if ((alien3.getXvalue() >= 1920 + 400)) {
                    alien8.setXvalue(alien3.getXvalue());
                    if (alien8.getXvalue() <= 1000) {
                        alien9.setXvalue(alien3.getXvalue());
                    }
                } else {
                    alien8.setXvalue(alien3.getXvalue()+100);
                    alien9.setXvalue(alien3.getXvalue()+400);
                }
                alien3.setDead(true);
                i--;
            }
            if (alien4.AlienRect().intersects(laser.laserRect())) { // check for collision
                player.collectCoin();
                lasers.remove(i);
                alien4.setDead(true);
                i--;
            }
            if (alien5.AlienRect().intersects(laser.laserRect())) { // check for collision
                player.collectCoin();
                lasers.remove(i);
                alien5.setDead(true);
                i--;
            }
            if (alien6.AlienRect().intersects(laser.laserRect())) { // check for collision
                player.collectCoin();
                lasers.remove(i);
                alien6.setDead(true);
                i--;
            }
            if (alien7.AlienRect().intersects(laser.laserRect())) { // check for collision
                player.collectCoin();
                lasers.remove(i);
                alien7.setDead(true);
                enemies.remove(alien7);
                i--;
            }
            if (alien8.AlienRect().intersects(laser.laserRect())) { // check for collision
                player.collectCoin();
                lasers.remove(i);
                alien8.setDead(true);
                enemies.remove(alien8);
                i--;
            }
            if (alien9.AlienRect().intersects(laser.laserRect())) { // check for collision
                player.collectCoin();
                lasers.remove(i);
                alien9.setDead(true);
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
