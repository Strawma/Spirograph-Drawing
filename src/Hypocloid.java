import java.awt.*;

/**
 * Hyperbolic Cycloid class.
 */
public class Hypocloid {
  private double R; //outer radius
  private double r; //inner radius
  private double O; //offset
  private Color color;

  public Hypocloid(double R, double r, double O, Color color) {
    this.R = R;
    this.r = r;
    this.O = O;
    this.color = color;

  }

  public void drawInLoop(Graphics g, double t) {
    g.setColor(color);
    int x = (int) ((R - r) * Math.cos(t) + O * Math.cos(((R - r) / r) * t));
    int y = (int) ((R - r) * Math.sin(t) - O * Math.sin(((R - r) / r) * t));
    g.fillOval(x, y, 2, 2);
  }
}
