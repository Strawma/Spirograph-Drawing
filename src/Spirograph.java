import javax.swing.*;
import java.awt.*;

public class Spirograph extends JPanel {

  private Hypocloid[] hypocloids = {
    new Hypocloid(4, 1, 4, Color.RED),
    //new Hypocloid(144, 96, 80, Color.GREEN),
    //new Hypocloid(144, 96, 80, Color.BLUE)
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


    for (double t = 0; t <= 100; t += 0.01) {
      for (Hypocloid hypocloid : hypocloids) {
        hypocloid.drawInLoop(g, t);
      }
    }

    g.translate(-width / 2, -height / 2); // Move back to the original position
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Hyperbolic Cycloid");
    frame.setSize(800, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(new Spirograph());
    frame.setVisible(true);
  }
}