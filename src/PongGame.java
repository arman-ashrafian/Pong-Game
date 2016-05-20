
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.WindowConstants;

/**
 * @author Arman Ashrafian
 * 
 * Press 'esc' to start the game
 */
public class PongGame extends JComponent implements ActionListener,
                                                    MouseMotionListener,
                                                    KeyListener {

    private static final int WINDOW_WIDTH = 1700;
    private static final int WINDOW_HEIGHT = 1800;
    
    private static int difficulty = 0;
    private static boolean isRunning = false;
    
    // Position of paddle
    private int paddleX = 0;
    private int paddleY = 700;

    // Position + Speed of ball
    private int ballX = 1600;
    private int ballY = 800;
    private int ballYSpeed = -2;
    private int ballXSpeed = -10;
    
    private static BufferedImage gameOver;
    private static Timer t;
    
    public PongGame() throws IOException {
        gameOver = ImageIO.read(getClass().getResource("gameover4.png"));
    }

    public static void main(String[] args) throws IOException{
        JFrame window = new JFrame("Pong Game by Arman");
        PongGame game = new PongGame();
        t = new Timer(1,game);
        
        // Window Setup
        window.add(game);
        window.pack();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        window.addKeyListener(game);
        window.addMouseMotionListener(game);
    }

    @Override
    protected void paintComponent(Graphics g) {
        //background
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, 4000, 4000);
        //paddle
        g.setColor(Color.WHITE);
        g.fillRect(paddleX, paddleY, 20, 300);
        //draw ball
        g.setColor(Color.WHITE);
        g.fillOval(ballX, ballY, 75, 75);
        
        
        if(ballX < paddleX - 50) {
            //g.drawImage(gameOver, 200, 400, null);
            g.drawImage(gameOver, 0,0,WINDOW_WIDTH,WINDOW_WIDTH, null);
            t.stop();
            isRunning = false;
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ballX < paddleX + 20 && (ballY > paddleY - 15 && ballY < paddleY + 40)) {
            ballXSpeed = 10 + difficulty;
            ballYSpeed = -4;
            difficulty+=2;
        }
        if(ballX < paddleX + 20 && (ballY >= paddleY + 40  && ballY < paddleY + 110)) {
            ballXSpeed = 10 + difficulty;
            ballYSpeed = 3;
            difficulty+=2;
        }
        
        if(ballX < paddleX + 20 && (ballY >= paddleY + 110 && ballY < paddleY + 190)) {
            ballXSpeed = 10 + difficulty;
            ballYSpeed = 2;
            difficulty+=2;
        }
        if(ballX < paddleX + 20 && (ballY >= paddleY + 190 && ballY < paddleY + 260)) {
            ballXSpeed = 10 + difficulty;
            ballYSpeed = -3;
            difficulty+=2;
        }
        
        if(ballX < paddleX + 20 && (ballY >= paddleY + 260 && ballY < paddleY + 300)) {
            ballXSpeed = 10 + difficulty;
            ballYSpeed = 4;
            difficulty+=2;
        }
        
        if(ballY <= 0) {
            ballYSpeed = 3;
        }
        if(ballX >= WINDOW_WIDTH - 75) {
            ballXSpeed = -10 - difficulty;
        }
        if(ballY >= WINDOW_HEIGHT - 150) {
            ballYSpeed = -4;
        }
        

        ballX += ballXSpeed;
        ballY += ballYSpeed; 
        
        System.out.println(difficulty);
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        paddleY = me.getY() - 150;
        if(isRunning) {
            repaint();
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_ESCAPE) {
            isRunning = !isRunning;
        }
        if(ke.getKeyCode() == KeyEvent.VK_ESCAPE && isRunning == false) {
            t.stop();
        }
        if(ke.getKeyCode() == KeyEvent.VK_ESCAPE && isRunning == true) {
            t.start();
        }
    }

    @Override
    public void mouseDragged(MouseEvent me) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }


}
