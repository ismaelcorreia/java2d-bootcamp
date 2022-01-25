package scene;

import javafx.scene.shape.Line;

import javax.tools.Tool;
import java.awt.*;
import java.awt.geom.*;

public class Street {

    private static final int w = Toolkit.getDefaultToolkit().getScreenSize().width;
    private static final int h = Toolkit.getDefaultToolkit().getScreenSize().height;
    Edificio edificio;
    Road road;
    public Street(){
        edificio = new Edificio();
        road = new Road();
    }

    public void draw(Graphics2D g) {
        AffineTransform affineTransform = g.getTransform();
        edificio.ed1(g);
        road.draw(g);
        g.setTransform(affineTransform);
    }

    public static class Edificio {

        public void ed1(Graphics2D g) {

            AffineTransform affineTransform = g.getTransform();
            RoundRectangle2D rectangle2D = new RoundRectangle2D.Double(0, (h - 100) - 500, 300, 510, 0, 0);
            g.setPaint(new Color(0x3D0F0F));
            g.fill(rectangle2D);
            g.setTransform(affineTransform);

        }
    }
    public static class Road{
        private int traceH = 10;

        public void draw(Graphics2D g) {
            AffineTransform transform = g.getTransform();
            Rectangle2D rectangle2D = new Rectangle2D.Double( 0, h - 100, w, 100);
            g.setPaint(new Color(0x686565));
            g.fill(rectangle2D);
            drawTrace(g);
            drawTrafficLight(g);
            g.setTransform(transform);
        }

        private void drawTrace(Graphics2D g) {
            AffineTransform transform = g.getTransform();
            g.setPaint(new Color(0xBDBDBD));
            for (int i = 0; i < w; i+= 100) {
                g.fillRect( i, ((h - 100) + 100/2) - traceH/2, 100, traceH);
                g.translate(100, 0);
            }
            g.setTransform(transform);

        }
        private void drawTrafficLight(Graphics2D g) {
            AffineTransform transform = g.getTransform();
            RoundRectangle2D pantalla = new RoundRectangle2D.Double(200 - 50/2, 300, 50, 150, 20, 20);
            Line2D line2D = new Line2D.Double(200, h-100, 200, 300);

            g.setTransform(transform);
            g.setPaint(new Color(0));
            g.setStroke(new BasicStroke(3));
            g.draw(line2D);
            g.setStroke(new BasicStroke(1));

            g.setPaint(new Color(0x393939));
            g.fill(pantalla);

            final Color[] colors = new Color[]{new Color(0x00FF00), new Color(0x998500), new Color(0x700000)};
            for (Color color: colors) {
                g.setPaint(color);
                g.fillOval((200 - 50/2) + 30/2, 300 + 10, 30, 30);
                g.translate(0, 40);
            }
            g.setTransform(transform);
        }
    }
}
