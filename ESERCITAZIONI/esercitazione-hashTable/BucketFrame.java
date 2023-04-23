import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * Visualizza le collisioni di un bucket
 */
public class BucketFrame extends JFrame {
    public static BucketFrame show(BucketArray a,String description) {
        BucketFrame f = new BucketFrame(a, description);
        f.setSize(400, 600);
        f.setVisible(true);
        return f;
    }

    public BucketFrame(final BucketArray a, final String descrizione) {
        JPanel panelView = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int empty = 0;
                int collision = 0;
                int correct = 0;
                Graphics2D g2 = (Graphics2D) g;
                for (int i = 0; i < a.getCapacita(); i++) {
                    if (a.isCollision(i)) {
                        g2.setColor(Color.RED);
                        collision++;
                    } else if (a.isEmpty(i)) {
                        g2.setColor(Color.WHITE);
                        empty++;
                    } else {
                        g2.setColor(Color.GREEN);
                        correct++;
                    }
                    g2.fill(new Rectangle2D.Double(5, 30 + i * 4, 200, 4));

                    g2.setColor(Color.BLACK);
                    g2.draw(new Rectangle2D.Double(5, 30 + i * 4, 200, 4));
                }

                g2.setFont(g2.getFont().deriveFont(Font.BOLD));
                g2.drawString(descrizione, 5, 20);
                g2.drawString("Empty     : " + empty, 230, 60);
                g2.drawString("Collisions: " + collision, 230, 80);
                g2.drawString("Valid     : " + correct, 230, 100);

                g2.setColor(Color.WHITE);
                g2.fill(new Rectangle2D.Double(215, 50, 10, 10));
                g2.setColor(Color.BLACK);
                g2.draw(new Rectangle2D.Double(215, 50, 10, 10));

                g2.setColor(Color.red);
                g2.fill(new Rectangle2D.Double(215, 70, 10, 10));
                g2.setColor(Color.BLACK);
                g2.draw(new Rectangle2D.Double(215, 70, 10, 10));

                g2.setColor(Color.GREEN);
                g2.fill(new Rectangle2D.Double(215, 90, 10, 10));
                g2.setColor(Color.BLACK);
                g2.draw(new Rectangle2D.Double(215, 90, 10, 10));
            }
        };
        panelView.setPreferredSize(new Dimension(400, a.getCapacita() * 4+50));
        panelView.setDoubleBuffered(true);
        setContentPane(new JScrollPane(panelView));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void close() {
        dispose();
    }
}
