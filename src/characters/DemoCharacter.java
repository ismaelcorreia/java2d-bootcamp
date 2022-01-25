package characters;

import actions.AbstractAction;
import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

public class DemoCharacter extends AbstractAction {

    public void draw(Graphics2D g) {
        AffineTransform affineTransform = g.getTransform();
        Character.Head.air(g);
        Character.Leg.draw(g);
        g.setTransform(affineTransform);
    }

    @Override
    protected void mouseClick(MouseEvent event) {

    }

    @Override
    protected void mouseMove(MouseEvent event) {

    }

    @Override
    protected void mouseDrag(MouseEvent event) {

    }

    @Override
    protected void mouseHover(MouseEvent event) {

    }

    @Override
    public void keyEvents(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_LEFT)
            Character.Leg.X_MOVE-=10;
        if (event.getKeyCode() == KeyEvent.VK_RIGHT)
            Character.Leg.X_MOVE+=10;
    }


    public static class Character {


        public static class Head{

            public static void air(Graphics2D g){
                int x = 490, y = 10;

                AffineTransform affineTransform = g.getTransform();
                g.setPaint(new Color(106,72,45));
                GeneralPath path = new GeneralPath();
                path.moveTo(x, y);
                path.curveTo(x+=5, y+=6,x+=5, y+=6, x+=30, y+=40);
                path.curveTo(x+=20, y+=20, x, y+=15, x, y);
                path.closePath();
                g.fill(path);

                g.setTransform(affineTransform);
            }

        }
        public static class Body{

        }
        public static class Arm{

        }
        public static class Leg{

            static int mx = 50;
            static int lx = 0;
            static boolean flag = false;
            private static int X_MOVE = 0,Y_MOVE = 0;
            private static void draw(Graphics2D g) {
                int x = 490, y = 400;
                AffineTransform transform = g.getTransform();
                GeneralPath generalPath = new GeneralPath();
                g.translate(X_MOVE, Y_MOVE);
                generalPath.moveTo(x, y);
                generalPath.curveTo(x+=10, y+=60, x+=120, y, x+=10, y-=60 );
                generalPath.closePath();

                g.setPaint(new Color(8,50,58));
                g.fill(generalPath);

                pants(g, mx);
                g.translate(85, 0);
                pants(g, mx);
                g.setTransform(transform);
            }
            private static void pants(Graphics2D g, int k) {
                int x = 490, y = 400;
                AffineTransform transform = g.getTransform();
                GeneralPath generalPath = new GeneralPath();
                GeneralPath generalPat2 = new GeneralPath();
                g.setPaint(new Color(8,50,58));
                generalPath.moveTo(x = 500, y = 400);
                generalPath.lineTo(x +=lx, y+=150);
                generalPath.lineTo(x+=30,y);
                generalPath.lineTo(x-=lx, y-=150);
                generalPath.closePath();


                generalPath.moveTo(x = 500+lx, y = 400+150);
                //
                generalPath.lineTo(x+=k, y+=150);
                generalPath.lineTo(x+=30,y);
                generalPath.lineTo(x-=k, y-=150);
                generalPath.closePath();

                g.fill(generalPath);

                g.setPaint(Color.BLACK);
                x = 500+lx; y = 700;
                generalPat2.moveTo( x+=k, y);
                generalPat2.curveTo( x-= 10, y+=10, x-=30, y+=5, x+=40, y);
                generalPat2.lineTo(x+=20,y-=7);
                generalPat2.lineTo(x,y+=7);
                generalPat2.lineTo(x+=10,y);
                generalPat2.curveTo(x+=3, y-=4, x, y, x+=1, y-=4);
                generalPat2.curveTo(x-=3, y+=4, x+=3, y-=4, x-=5, y-=10);
                generalPat2.lineTo(x-=20,y);
                generalPat2.closePath();

                g.fill(generalPat2);
                g.setTransform(transform);
                if (mx==50)
                    flag = false;

                if(mx==0)
                    flag = true;

                if (flag) {
                    mx+=5;
                    lx+=2;

                }

                if (!flag) {

                    mx-=5;
                    lx-=2;
                }



            }
//            private static void drawFoot(Graphics2D g) {
//                int x = 500, y = 700;
//                AffineTransform transform = g.getTransform();
//                GeneralPath generalPath = new GeneralPath();
//
//                g.setTransform(transform);
//            }
        }
    }
}
