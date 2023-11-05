import java.awt.*;

/**
 * Hyperbolic Cycloid class.
 * Takes in parameters for a hypocloid and draws it.
 */
public class Hypocloid {
  private static final double TWO_PI = 2 * Math.PI;
  private double R; //outer radius
  private double r; //inner radius
  private double O; //offset
  private Color color; //color of hypocloid
  private double maxTheta; //number of rotations required to complete the hypocloid

  public Hypocloid(double R, double r, double O, Color color, double scale) {
    this.R = R * scale;
    this.r = r * scale;
    this.O = O * scale;
    this.color = color;
    int rotations = (int) R / HCF((int) R, (int) r);
    maxTheta = rotations * TWO_PI;
  }

  public Hypocloid(double R, double r, double O, Color color) {
    this.R = R;
    this.r = r;
    this.O = O;
    this.color = color;
  }

  private static final double STEP = 0.01;
  public void drawSeparate (Graphics g) {
    g.setColor(color);
    for (double t = 0; t < maxTheta; t += STEP) {
      int x = (int) ((R - r) * Math.cos(t) + O * Math.cos(((R - r) / r) * t));
      int y = (int) ((R - r) * Math.sin(t) - O * Math.sin(((R - r) / r) * t));
      g.fillOval(x, y, 4, 4);
    }
  }

  private int HCF(int a, int b) {
    if (b == 0) {
      return a;
    }
    return HCF(b, a % b);
  }
}
