package characters;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class GeoDraw {

    public static void drawEllipse(Graphics2D g, Paint paint, Point point, Dimension dimension){
        g.setPaint(paint);
        Ellipse2D ellipse2D = new Ellipse2D.Double(point.x, point.y, dimension.width, dimension.height);
        g.fill(ellipse2D);
    }

    public static void drawRoundedRectangle(Graphics2D g, Paint paint, Point point, Dimension dimension, int arcW, int arcH){
        g.setPaint(paint);
        RoundRectangle2D rectangle2D = new RoundRectangle2D.Double(point.x, point.y, dimension.width, dimension.height, arcW, arcH);
        g.fill(rectangle2D);
    }
    public static void drawRectangle(Graphics2D g, Paint paint, Point point, Dimension dimension){
        g.setPaint(paint);
        Rectangle2D rectangle2D = new Rectangle2D.Double(point.x, point.y, dimension.width, dimension.height);
        g.fill(rectangle2D);
    }
    public static void fill(Graphics2D g, Paint paint, Shape shape){
        g.setPaint(paint);
        g.fill(shape);
    }


    public static Ellipse2D getEllipse(Point point, Dimension dimension){
        return new Ellipse2D.Double(point.x, point.y, dimension.width, dimension.height);
    }

    public static RoundRectangle2D  getRoundedRectangle(Point point, Dimension dimension, int arcW, int arcH){
        return new RoundRectangle2D.Double(point.x, point.y, dimension.width, dimension.height, arcW, arcH);
    }
    public static Rectangle2D getRectangle(Point point, Dimension dimension){
        return new Rectangle2D.Double(point.x, point.y, dimension.width, dimension.height);
    }
}
