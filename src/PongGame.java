
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.WindowConstants;

/**
 *
 * @author Arman Ashrafian
 */
public class PongGame extends JComponent implements ActionListener,
        MouseMotionListener {

    private static final int WINDOW_WIDTH = 2000;
    private static final int WINDOW_HEIGHT = 1800;
    
    // Position of paddle
    private int paddleX = 0;
    private int paddleY = 700;

    // Position of ball
    private int ballX = 1600;
    private int ballY = 800;

    private int ballYSpeed = -2;
    private int ballXSpeed = -5;

    public static void main(String[] args) {
        JFrame window = new JFrame("Pong Game by Arman");
        PongGame game = new PongGame();

        // Window Setup
        window.add(game);
        window.pack();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        // Action Listener
        Timer t = new Timer(10, game);
        t.start();
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
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ballX < paddleX + 20 && (ballY > paddleY && ballY < paddleY + 300)) {
            ballXSpeed = 10;
            ballYSpeed = 2;
        }
        if(ballY <= 0) {
            ballYSpeed = 2;
        }
        if(ballX >= WINDOW_WIDTH - 75) {
            ballXSpeed = -10;
        }
        if(ballY >= WINDOW_HEIGHT - 150) {
            ballYSpeed = -4;
        }
        

        ballX += ballXSpeed;
        ballY += ballYSpeed;

        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        paddleY = me.getY() - 150;
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent me) {
    }

}
