package objetossimples;

import java.awt.*;
import java.awt.geom.*;

public class FigurasGeometricas {


    public void desenharHexagono(Graphics2D g) {
        AffineTransform transform = g.getTransform();
        GeneralPath generalPath = new GeneralPath();
        int x = 300, y = 20;
        g.setPaint(new Color(35,201,227));
        generalPath.moveTo(x, y);
        generalPath.lineTo(x -= 100, y += 100);
        generalPath.lineTo(x , y += 100);
        generalPath.lineTo(x += 100, y += 100);
        generalPath.lineTo(x += 100, y -= 100);
        generalPath.lineTo(x , y -= 100);
        generalPath.closePath();

        g.fill(generalPath);
        g.setTransform(transform);

    }



    public void desenharGit(Graphics2D g) {
        AffineTransform transform = g.getTransform();
        int x = 300, y = 100;
        int w = 300, h = 300;
        int arcW = 30, arcH = 30;
        int lineSize = 45;
        g.setPaint(new Color(240,81,51));

        RoundRectangle2D rectangle2D = new RoundRectangle2D.Double( x, y, w, h, arcW, arcH);
        Area symbol = new Area(rectangle2D);
        Rectangle2D line = new Rectangle2D.Double( x, y + lineSize, w - lineSize, 20);
        Ellipse2D circle = new Ellipse2D.Double( x +  ((w - lineSize)/2) - lineSize/2, y + lineSize - lineSize/2 + arcW/2, lineSize, lineSize);
        Ellipse2D circle2 = new Ellipse2D.Double( x +  ((w - lineSize)) - lineSize/2, y + lineSize - lineSize/2 + arcW/2, lineSize, lineSize);
        symbol.subtract(new Area(line));
        symbol.subtract(new Area(circle));
        symbol.subtract(new Area(circle2));
        g.rotate(Math.toRadians(45), x + (w/2), y + (h/2));
        g.fill(symbol);
        g.setTransform(transform);

    }



    public void desenharTrapezio(Graphics2D g) {
        AffineTransform transform = g.getTransform();
        GeneralPath generalPath = new GeneralPath();
        int x = 300, y = 20;

        g.setPaint(new Color(255,206,57));

        generalPath.moveTo(x, y);
        generalPath.lineTo(x -= 30, y += 130);
        generalPath.lineTo(x +=160, y );
        generalPath.lineTo(x -= 30, y -= 130);
        generalPath.closePath();

        g.fill(generalPath);



        g.setTransform(transform);

    }
}
