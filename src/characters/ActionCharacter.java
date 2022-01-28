package characters;

import actions.AbstractAction;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.NoninvertibleTransformException;

public class ActionCharacter extends AbstractAction {


    // Primeiro passo: extender a class AbstractAction e implementar todos os seus métodos abstractos
    // Criar classes do corpo (dividir em 3 partes)

    private int moveX = 0;
    private int step = 10;
    private static boolean moveToRigth = false;
    private static boolean moveToLeft = false;

    private final Head head = new Head();
    private final Body body = new Body();
    private final Foot foot = new Foot();

    public void draw(Graphics2D g){
        AffineTransform transform = g.getTransform();

        if (moveToRigth)
            moveX += 10;
        if (moveToLeft)
            moveX -= 10;

        g.translate(moveX, 0);

        foot.draw(g);
        body.draw(g);
        head.draw(g);


        moveToRigth = false;
        moveToLeft = false;
        g.setTransform(transform);
    }


    static class Head{



        private final Point startPoint = new Point(600, 100);
        public static boolean eyeClosed = true;
        public static boolean mothClosed = true;
        public void draw(Graphics2D g){
            AffineTransform transform = g.getTransform();

            GeoDraw.drawEllipse(g,new Color(248,192,157), startPoint, new Dimension(140, 150));
            GeoDraw.drawRoundedRectangle(g,
                    new Color(242,171,131),
                    new Point(startPoint.x+ 130/2 -40, startPoint.y + 130/2 -27), new Dimension(60, 3), 5, 5);
            GeoDraw.drawRoundedRectangle(g,
                    new Color(242,171,131),
                    new Point(startPoint.x+ 130/2 -30, startPoint.y + 130/2 -35), new Dimension(60, 3), 5, 5);
            drawEye(g, eyeClosed);
            g.translate(57, 0);
            drawEye(g, false);
            g.setTransform(transform);
            drawNoises(g);
            drawMouth(g, mothClosed);
            drawEar(g);
        }

        private void drawEye(Graphics2D g, boolean closed) {

            AffineTransform transform = g.getTransform();

            if (closed)
                GeoDraw.drawRoundedRectangle(g,
                    new Color(199,96,101),
                    new Point(startPoint.x+ 130/2 -47, startPoint.y + 130/2 -10), new Dimension(20, 4), 5, 5);
           else
                GeoDraw.drawEllipse(g,
                    new Color(42,171,131),
                    new Point(startPoint.x+ 130/2 -47, startPoint.y + 130/2  -15), new Dimension(20, 20));

            g.setTransform(transform);
        }

        private void drawNoises(Graphics2D g ) {

            AffineTransform transform = g.getTransform();
                GeoDraw.drawEllipse(g,
                        new Color(234,143,120),
                        new Point(startPoint.x+ 130/2 -20, startPoint.y + 150/2  ), new Dimension(5, 5));

            GeoDraw.drawEllipse(g,
                    new Color(234,143,120),
                    new Point(startPoint.x+ 130/2 -5, startPoint.y + 150/2  ), new Dimension(5, 5));

            g.setTransform(transform);
        }

        private void drawEar(Graphics2D g ) {

            AffineTransform transform = g.getTransform();
            GeoDraw.drawEllipse(g,
                    new Color(248,192,157),
                    new Point(startPoint.x+ 150 -24, startPoint.y + 150/2 -10 ),
                    new Dimension(30, 30));

            GeoDraw.drawEllipse(g,
                    new Color(242,112,117),
                    new Point(startPoint.x+ 150 -24+15/2, startPoint.y + 150/2 -10 +15/2 ),
                    new Dimension(15, 15));

            GeoDraw.drawEllipse(g,
                    new Color(0, 0, 0),
                    new Point(startPoint.x+ 150 -5, startPoint.y + 150/2+ 12 ),
                    new Dimension(10, 10));

            g.setTransform(transform);
        }

        private void drawMouth(Graphics2D g, boolean closed ) {

            AffineTransform transform = g.getTransform();

            g.setPaint(Color.BLACK);
            Area area = new Area(
                            GeoDraw.getRectangle(
                                            new Point(startPoint.x, startPoint.y + 150/2  +10),
                                            new Dimension(140, 120))
                    );
            area.add(new Area(
                GeoDraw.getEllipse(
                        new Point(startPoint.x, startPoint.y + 150/2  +10 + 40),
                        new Dimension(140, 140))
                )
            );
            g.fill(area);

            Area area2 = new Area(
                    GeoDraw.getEllipse(
                            new Point(startPoint.x + 10, startPoint.y + 150/2 - 30),
                            new Dimension(100, 100))
            );
            area2.subtract(new Area(

                    GeoDraw.getRectangle(
                            new Point(startPoint.x + 10, startPoint.y + 150/2 - 30),
                            new Dimension(100, 100/2))
                    )
            );



            Area area3 = new Area(
                    GeoDraw.getEllipse(
                            new Point(startPoint.x + 10, startPoint.y + 150/2 + 30),
                            new Dimension(100, 100))
            );
            area3.intersect(area2);

            if (closed) {

                g.setPaint(new Color(196,39,84));
                g.fill(area2);

                g.setPaint(new Color(238,52,102));
                g.fill(area3);

            }
            g.setTransform(transform);
        }
    }


    static class Body{


        private final Point startPoint = new Point(560, 200);
        private int move = 0;
        private int step = 5;
        private boolean toDown = false;
        public static boolean moveHand = false;

        public void draw(Graphics2D g){
            AffineTransform transform = g.getTransform();

            g.rotate(Math.toRadians(move), startPoint.x-130+210, startPoint.y+40 + ((startPoint.y+40+100)/2)-100-25);
            drawHand(g);
            g.setTransform(transform);

            GeoDraw.drawEllipse(g, new Color(189, 4, 4),
                    new Point(startPoint.x, startPoint.y),
                    new Dimension(220, 220));

            GeoDraw.drawRoundedRectangle(g, new Color(113, 12, 12),
                    new Point(startPoint.x+ 50, startPoint.y+170 ),
                    new Dimension(80, 20), 20 , 20);
            drawHand2(g);
            g.setTransform(transform);

            Head.eyeClosed = moveHand;
            Head.mothClosed = moveHand;
            if (moveHand) {

                if (!toDown) {
                    if (move<= 70)
                        move += step;
                    else
                        toDown = !toDown;
                }else {

                    if (move>= -50)
                        move -= step;
                    else {
                        toDown = !toDown;
                        moveHand = false;

                    }
                }
            }


        }

        private void drawHand(Graphics2D g) {

            AffineTransform transform = g.getTransform();
            Area area = new Area(GeoDraw.getRectangle(new Point(startPoint.x - 300, startPoint.y-130),
                    new Dimension(250, 210)));

            Area area1 = new Area(
                    GeoDraw.getEllipse(new Point((startPoint.x -300) + 50 - 30, startPoint.y-130-15),
                            new Dimension(250, 240))
            );

            area.subtract(new Area(
                    GeoDraw.getEllipse(new Point((startPoint.x -300) + (350/2 - 250/2),( startPoint.y-130)-140),
                            new Dimension(350, 210))
            ));
            area.subtract(new Area(
                    GeoDraw.getEllipse(new Point((startPoint.x -300) + (350/2 - 250/2), startPoint.y-130 + 140),
                            new Dimension(350, 210))
            ));


            area1.subtract(new Area(
                    GeoDraw.getEllipse(new Point((startPoint.x -300) + (350/2 - 250/2),( startPoint.y-130)-140),
                            new Dimension(350, 210))
            ));
            area1.subtract(new Area(
                    GeoDraw.getEllipse(new Point((startPoint.x -300) + (350/2 - 250/2), startPoint.y-130 + 140),
                            new Dimension(350, 210))
            ));
            area.intersect(new Area(
                    GeoDraw.getEllipse(new Point((startPoint.x -300) + 50, startPoint.y-130),
                            new Dimension(250, 210))
            ));
            area.subtract(new Area(GeoDraw.getEllipse(new Point((startPoint.x - 300)+210, (startPoint.y-130)+210/2 - 20/2),
                    new Dimension(20,20))));
            area1.subtract(new Area(GeoDraw.getEllipse(new Point((startPoint.x - 300)+210, (startPoint.y-130)+210/2 - 20/2),
                    new Dimension(20,20))));


            Area area2 = new Area(
                    GeoDraw.getRectangle(
                            new Point(startPoint.x-130+30, startPoint.y-100),
                            new Dimension(30, 600))

            );

//


            GeoDraw.drawRoundedRectangle(g, new Color(240,146,126),
                    new Point(startPoint.x-130, startPoint.y+40),
                    new Dimension(210, 100), 100
                    , 100);


            GeoDraw.drawRoundedRectangle(g, new Color(240,146,126),
                    new Point(startPoint.x-130+50, startPoint.y+40-20),
                    new Dimension(40, 100), 40
                    , 40);
            GeoDraw.fill(g, new Color(0), area2);

            area1.exclusiveOr(area);
            g.setPaint(new Color(180,200,211));
            g.fill(area);
            g.setPaint(new Color(234, 234, 234));
            g.fill(area1);

            GeoDraw.drawRoundedRectangle(g, new Color(248,192,157),
                    new Point(startPoint.x-130, startPoint.y+40),
                    new Dimension(100, 100), 100
                    , 100);
        }

        private void drawHand2(Graphics2D g) {

            AffineTransform transform = g.getTransform();

            GeoDraw.drawRoundedRectangle(g, new Color(248,192,157),
                    new Point(startPoint.x+ 180, startPoint.y+40),
                    new Dimension(100, 310), 100
                    , 100);

            GeoDraw.drawRoundedRectangle(g, new Color(248,192,157),
                    new Point(startPoint.x+ 180+20, startPoint.y+40+210),
                    new Dimension(100, 100), 100, 100);
            for (int i = 1; i <= 6; i++) {

                GeoDraw.drawRoundedRectangle(g, new Color(238, 164, 120),
                        new Point(startPoint.x+ 180+20, startPoint.y+40+150 + (i*10)),
                        new Dimension(60, 5), 5 , 5);
            }

            g.setTransform(transform);
        }
    }


    static class Foot{


        private final Point startPoint = new Point(620, 390);

        public void draw(Graphics2D g){
            AffineTransform transform = g.getTransform();

            GeoDraw.drawRectangle(g, new Color(21, 92, 97),
                    new Point(startPoint.x, startPoint.y),
                    new Dimension(200, 50));
            drawLeg(g, new Point(0,0) );
            g.translate(100,0);
            drawLeg(g, new Point(0,0));
            g.setTransform(transform);
        }

        public void drawLeg(Graphics2D g, Point moveTo){
            AffineTransform transform = g.getTransform();

            GeoDraw.drawRectangle(g, new Color(21, 92, 97),
                    new Point(startPoint.x, startPoint.y+50),
                    new Dimension(40, 100));

            GeoDraw.drawEllipse(g, new Color(21, 92, 97),
                    new Point(startPoint.x-10, startPoint.y+25+100),
                    new Dimension(40, 40));


            GeoDraw.drawRectangle(g, new Color(21, 92, 97),
                    new Point(startPoint.x, startPoint.y+50+100),
                    new Dimension(40, 100));


            Area footArea = new Area( GeoDraw.getEllipse(
                    new Point(startPoint.x-70/2, startPoint.y+50+100+100-70/2),
                    new Dimension(70, 70)));

            footArea.subtract(
                    new Area(
                            GeoDraw.getRectangle(
                                    new Point(startPoint.x-70/2, startPoint.y+50+100+100-70/2 + 70/2),
                                    new Dimension(70, 70))
                    )
            );
            GeoDraw.fill(g, new Color(0), footArea);
            g.setTransform(transform);
        }
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
        if (event.getKeyCode() == KeyEvent.VK_RIGHT)
            moveToRigth = true;
        if (event.getKeyCode() == KeyEvent.VK_LEFT)
            moveToLeft = true;
        Body.moveHand = (moveToLeft||moveToRigth);

    }
}
