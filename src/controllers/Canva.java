package controllers;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Canva extends Component {

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
//        g2.scale(1.5, 1.5);
        g2.setPaint(new Color(11, 77, 164));
        desenharGrelha(g2);
            for (int i = 0; i < 5; i++) {
                desenharCirculo(g2, 150 + ((100 + 10) * i) ,100, 100, 100, new Color(199, 97, 227));
            }


//        for (int espaco = 0, i = 0; i < (100+espaco) * 5; i += (100+espaco)) {
//            desenharRectangulo(g2, 150 + i ,100, 100, 100, new Color(107, 181, 255));
//        }
    }

    private Ellipse2D desenharCirculo(Graphics2D g, int x, int y, int w, int h, Color color) {
        Ellipse2D ellipse2D = new Ellipse2D.Double(x,  y,  w,  h);
        g.setPaint(color);
        g.fill(ellipse2D);
        return ellipse2D;
    }

    private Rectangle2D desenharRectangulo(Graphics2D g, int x, int y, int w, int h, Color color) {
        Rectangle2D rectangle = new Rectangle2D.Double(x,  y,  w,  h);
        g.setPaint(color);
        g.fill(rectangle);
        return rectangle;
    }

    private void desenharGrelha(Graphics2D g) {
        for (int i = 0; i < getWidth(); i+= 10) {
            g.drawLine( i, 0, i, getHeight());
        }

        for (int i = 0; i < getHeight(); i+= 10) {
            g.drawLine( 0, i, getWidth(), i);
        }
    }

//    public void paint(Graphics2D g) {
//        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
//        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
//        AffineTransform affineTransform = g.getTransform();
//
//        drawRectangle(g);
//        g.setTransform(affineTransform);
//    }
//
//    public void drawRectangle(Graphics2D g) {
//        AffineTransform affineTransform = g.getTransform();
//        g.setPaint(new Color(255,107,137));
//
////        g.fillRect();
//
//        g.setTransform(affineTransform);
//    }
}
