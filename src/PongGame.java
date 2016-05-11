
import java.awt.*;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;


/**
 *
 * @author Arman Ashrafian
 */
public class PongGame extends JComponent {
    
    public static void main(String[] args) {
        JFrame window = new JFrame("Pong Game by Arman");
        
        // Making Window
        window.add(new PongGame() );
        window.pack();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setSize(2000,1800);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        //background
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,0,2000,1800);
        //paddle
        g.setColor(Color.WHITE);
        g.fillRect(0,700,20,300);
        //draw ball
        g.setColor(Color.WHITE);
        g.fillOval(1600,800,75,75);
    }
    
    
    
}
