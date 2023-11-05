import javax.swing.*;
import java.awt.*;

/**
 * Spirograph class.
 * Combines multiple Hypocloid objects to create a Spirograph.
 * HOLY SHIT I THINK ITS WORKING
 */
public class Spirograph extends JPanel {

  private Hypocloid[] hypocloids = {
//    new Hypocloid(105, 80, 1, Color.CYAN, 4),
//    new Hypocloid(105, 80, 6, Color.RED, 4),
//    new Hypocloid(105, 80, 11, Color.ORANGE, 4),
//    new Hypocloid(105, 80, 16, Color.RED, 4),
//    new Hypocloid(105, 80, 21, Color.CYAN, 4),

      new Hypocloid(105, 30, 1, 7, Color.MAGENTA, 4),
      new Hypocloid(105, 30, 2, 7, Color.MAGENTA, 4),
      new Hypocloid(105, 30, 3, 7, Color.MAGENTA, 4),
      new Hypocloid(105, 30, 4, 7, Color.MAGENTA, 4),
      new Hypocloid(105, 30, 5, 7, Color.MAGENTA, 4),
      new Hypocloid(105, 45, 1, 16, Color.ORANGE, 4),
      new Hypocloid(105, 45, 2,16, Color.ORANGE, 4),
      new Hypocloid(105, 45, 3, 16, Color.ORANGE, 4),
      new Hypocloid(105, 45, 4, 16, Color.ORANGE, 4),
      new Hypocloid(105, 45, 5, 16, Color.ORANGE, 4),
      new Hypocloid(105, 60, 1, 23, Color.RED, 4),
      new Hypocloid(105, 60, 2, 23, Color.RED, 4),
      new Hypocloid(105, 60, 3, 23, Color.RED, 4),
      new Hypocloid(105, 60, 4, 23, Color.RED, 4),
      new Hypocloid(105, 60, 5, 23, Color.RED, 4),

//      new Hypocloid(105, 24, 5, Color.ORANGE, 4),
//      new Hypocloid(105, 80, 13, Color.RED, 4),
//      new Hypocloid(105, 80, 14, Color.RED, 4),
//      new Hypocloid(105, 80, 15, Color.RED, 4),
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