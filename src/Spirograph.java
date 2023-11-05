import javax.swing.*;
import java.awt.*;

/**
 * Spirograph class.
 * Combines multiple Hypocloid objects to create a Spirograph.
 */
public class Spirograph extends JPanel {

  private Hypocloid[] hypocloids = {
    new Hypocloid(144, 96, 80, Color.RED, 2),
  };

  public Spirograph() {
    setPreferredSize(new Dimension(800, 800));
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    int width = getWidth();
    int height = getHeight();

    g.translate(width / 2, height / 2); // Move to the center

    drawHypocloidsSeparate(g);

    g.translate(-width / 2, -height / 2); // Move back to the original position
  }

  private void drawHypocloidsSeparate(Graphics g) {
    for (Hypocloid hypocloid : hypocloids) {
      hypocloid.drawSeparate(g);
    }
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Hyperbolic Cycloid");
    frame.setSize(800, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(new Spirograph());
    frame.setVisible(true);
  }
}