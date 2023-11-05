import java.awt.*;

/**
 * Hyperbolic Cycloid class.
 * Takes in parameters for a hypocloid and draws it.
 * DUDE WHAT THE ACTUAL HELL IS A SPIROGRAPH HOW THE HELL DOES IT WORK I DON'T UNDERSTAND IT AT ALL
 * I'M SO CONFUSED
 * I'M SO CONFUSED
 * HELP ME PLEASE
 * useful :) https://spirographicart.com/2014/05/02/chart-spirograph-wheels-rings/
 */
public class Hypocloid {
  private static final double TWO_PI = 2 * Math.PI;
  private double R; //outer radius
  private double r; //inner radius
  private double O; //offset
  private Color color; //color of hypocloid
  private double maxTheta; //number of rotations required to complete the hypocloid

  public Hypocloid(double R, double r, double O, int maxO, Color color, double scale) {
    this.R = R * scale;
    this.r = r * scale;
    this.O = this.r * (maxO-O) / maxO; // random bullcrap, go!
    this.color = color;
    int rotations = (int) R / HCF((int) R, (int) r);
    maxTheta = rotations * TWO_PI;
  }

  public Hypocloid(double R, double r, double O, int maxO, Color color) {
    this(R, r, O, maxO, color, 1);
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
