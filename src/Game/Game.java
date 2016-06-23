package Game;

import Controls.KeyboardController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author (Your Name Here)
 */
public class Game extends JPanel {

    // Instance variables declared here
    private KeyboardController controller;
    Ball ball;

    Paddle paddle;
    Brick[][] bricks;

    @Override
    public void paint(Graphics g) {
        // Draw GameObjects and anything else here
        super.paint(g);
        ball.draw(g);
        paddle.draw(g);
        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < 12; i++) {
                if (bricks[k][i] != null) {
                    bricks[k][i].draw(g);
                    bricks[k][i].draw(g);
                    bricks[k][i].draw(g);
                    bricks[k][i].draw(g);
                }
            }
        }
        }

    

    public void updateGameState() {
        // Move GameObjects and check for collisions here

        ball.move();

        paddle.move();

        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < 12; i++) {
                if(bricks[k][i] != null){
                if (ball.isColliding(bricks[k][i])) {
                    ball.setXSpeed(ball.getXSpeed());
                    ball.setYSpeed(-ball.getYSpeed());
                    bricks[k][i] = null;
                }
            }
        }
        }
        if (ball.isColliding(paddle)) {
            ball.setXSpeed(ball.getXSpeed()*1);
            ball.setYSpeed(-ball.getYSpeed());
        }

        if (ball.getXPosition() < 0) {
            ball.setXSpeed(ball.getXSpeed()*-1);
            ball.setYSpeed(ball.getYSpeed());
        }
        if (ball.getXPosition() + ball.getDiameter() > this.getWidth()) {
            ball.setXSpeed(ball.getXSpeed()*-1);
            ball.setYSpeed(ball.getYSpeed());
        }

    }

    public final void setupGame() {
        // Instantiate instance variables here
//        ball = new Ball(100, 400, 20, Color.yellow);
//
//        paddle = new Paddle(200, 400, 30, 15, 25, Color.BLUE, controller);
//        bricks = new Brick[4][12];
//        for (int i = 0; i < 12; i++) {
//            Brick row1 = new Brick(i*50, 50, 40, 15, Color.red);
//            Brick row2 = new Brick(i*50, 100, 40, 15, Color.red);
//            Brick row3 = new Brick(i*50, 150, 40, 15, Color.red);
//            Brick row4 = new Brick(i*50, 200, 40, 15, Color.red);
//
//            bricks[3][i] = row4;
//            bricks[2][i] = row3;
//            bricks[1][i] = row2;
//            bricks[0][i] = row1;
//        }
        ball = new Ball(100, 400, 20, Color.yellow);

        paddle = new Paddle(300, 600, 15, 50, 6, Color.BLUE, controller);
        bricks = new Brick[4][12];
        for (int i = 0; i < 12; i++) {
            bricks[3][i] = new Brick(i * 50, 50, 40, 15, Color.red);
            bricks[2][i] = new Brick(i * 50, 100, 40, 15, Color.red);
            bricks[1][i] = new Brick(i * 50, 150, 40, 15, Color.red);
            bricks[0][i] = new Brick(i * 50, 200, 40, 15, Color.red);

        }

    }

    // Constructor method should not be modified
    public Game() {
        // Set the size of the Panel to the correct size
        this.setPreferredSize(new Dimension(600, 800));

        // Set the background color of the Panel to black
        this.setBackground(Color.BLACK);

        // Instantiate a KeyboardController and listen for input with it
        controller = new KeyboardController();
        this.addKeyListener(controller);

        // Call the setupGame method to initialize instance variables
        this.setupGame();

        // Get focus in the window
        this.setFocusable(true);
        this.requestFocusInWindow();
    }

    // Start method should not be modified
    public void start() {
        // Set up a new Timer to repeat every 25 milliseconds (40 FPS)
        timer = new Timer(25, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // update the game state and redraw the screen.
                updateGameState();
                repaint();
            }
        });

        timer.setRepeats(true);
        timer.start();
    }

    Timer timer;
}
