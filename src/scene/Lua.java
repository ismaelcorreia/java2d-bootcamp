package scene;

import characters.GeoDraw;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;



public class Lua {
    public static boolean isLuaCheia=false;
    public static void draw(Graphics2D g){
        AffineTransform affineTransform = g.getTransform();
           Area a = new Area(

                GeoDraw.getEllipse(
                        new Point(200, 100),
                        new Dimension(220, 220))
        );
        if(!isLuaCheia) {
            a.subtract(

                    new Area(

                            GeoDraw.getEllipse(
                                    new Point(200 + 10, 100 - 10),
                                    new Dimension(220, 220))
                    )
            );
        }
        g.setPaint(Color.GRAY);
        g.fill(a);
        g.setTransform(affineTransform);


    }
}
