
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
    // Position of paddle
    private int paddleX = 0;
    private int paddleY = 700;
    
    // Position of ball
    private int ballX = 1600;
    private int ballY = 800;
    
    public static void main(String[] args) {
        JFrame window = new JFrame("Pong Game by Arman");
        PongGame game = new PongGame();
        
        // Window Setup
        window.add(game);
        window.pack();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setSize(2000,1800);
        
        // Action Listener
        Timer t = new Timer(100, game);
        t.start();
        window.addMouseMotionListener(game);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        //background
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,0,2000,1800);
        //paddle
        g.setColor(Color.WHITE);
        g.fillRect(paddleX,paddleY,20,300);
        //draw ball
        g.setColor(Color.WHITE);
        g.fillOval(ballX,ballY,75,75);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        ballX = ballX - 5;
        ballY = ballY + 3;
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
