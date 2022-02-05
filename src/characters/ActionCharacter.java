package characters;

import actions.AbstractAction;
import controllers.GameEngine;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.List;

public class ActionCharacter extends AbstractAction {


    // Primeiro passo: extender a class AbstractAction e implementar todos os seus métodos abstractos
    // Criar classes do corpo (dividir em 3 partes)

    private GameEngine engine;

    private List<Integer> keyCodes;
    private int moveX = 0;
    private int step = 10;
    private boolean moveToRigth = false;
    private boolean moveToLeft = false;
    private Rectangle rectangle;
    private Point point;
    private Dimension dimension;
    private final Head head;
    private final Body body;
    private final Foot foot;
    private boolean reverse;
    private final boolean PLAYER2;

    public ActionCharacter(boolean player2) {
       this(player2, new Point(0,0));
    }
    public ActionCharacter(boolean player2, Point p) {
        PLAYER2 = player2;
        head = new Head(PLAYER2);
        body = new Body(PLAYER2);
        foot = new Foot(PLAYER2);
        keyCodes = new ArrayList<>();
        point = new Point(440+p.x, 95+p.y);
        moveX = p.x;
        dimension = new Dimension(420, 550);
        rectangle = new Rectangle(point, dimension);
        engine = new GameEngine(rectangle);
    }

    public void setExternalRectangles(Rectangle... rectangles) {
        this.engine.setExternalRectangles(rectangles);
    }

    public void draw(Graphics2D g){
        AffineTransform transform = g.getTransform();

        if (moveToRigth) {

            rectangle.x += 10;
            if(this.engine.checkColision())
                rectangle.x -= 10;
            else
                moveX += 10;
        }

        if (moveToLeft) {

            rectangle.x -= 10;
            if(this.engine.checkColision())
                rectangle.x += 10;
            else
                moveX -= 10;
        }


        g.translate(moveX, 0);

        if (reverse) {
            g.translate(600*2,0);
            g.scale(-1,1);
        }

        foot.draw(g);
        body.draw(g);
        head.draw(g);


        head.eyeClosed = body.moveHand;
        head.mothClosed = body.moveHand;
        moveToRigth = false;
        moveToLeft = false;
        g.setTransform(transform);

        g.setPaint(new Color(0,0,0,0));
        g.drawRect(rectangle.x,rectangle.y, rectangle.width, rectangle.height);
    }

    public Rectangle getRectangle() {
        return rectangle;
    }


    static class Head{

        //Constructor
        Head(boolean player2) {
            this.PLAYER2 = player2;
        }


        private final boolean PLAYER2;


        private final Point startPoint = new Point(600, 100);
        public  boolean eyeClosed = true;
        public  boolean mothClosed = true;

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

        // Olho: desenha olhos, recebe o parametro closed para dizer se o olho está fechado ou não
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

        Body(boolean player2) {
            PLAYER2 = player2;
        }

        private final boolean PLAYER2;
        private final Point startPoint = new Point(560, 200);
        private int move = 0;
        private int step = 5;
        private boolean toDown = false;
        public boolean moveHand = false;

        private final Color[] tshirtColors = {
                new Color(189, 4, 4),
                new Color(0, 51, 127)

        };

        public void draw(Graphics2D g){
            AffineTransform transform = g.getTransform();
            Color mainColor = tshirtColors[PLAYER2?1:0
                    ];
            Color secondaryColor = new Color(mainColor.getRed()+10, mainColor.getGreen()+10, mainColor.getBlue()+10);
            g.rotate(Math.toRadians(move), startPoint.x-130+210, startPoint.y+40 + ((startPoint.y+40+100)/2)-100-25);
            drawHand(g);
            g.setTransform(transform);

            GeoDraw.drawEllipse(g, mainColor,
                    new Point(startPoint.x, startPoint.y),
                    new Dimension(220, 220));

            GeoDraw.drawRoundedRectangle(g, secondaryColor,
                    new Point(startPoint.x+ 50, startPoint.y+170 ),
                    new Dimension(80, 20), 20 , 20);
            drawHand2(g);
            g.setTransform(transform);

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


        private final boolean PLAYER2;
        Foot(boolean player2) {
            PLAYER2 = player2;
        }
        private final Point startPoint = new Point(620, 390);
        private final Color[] pantsColor = {
                new Color(21, 92, 97),
                new Color(40, 40, 40)

        };

        public void draw(Graphics2D g){
            AffineTransform transform = g.getTransform();

            GeoDraw.drawRectangle(g, pantsColor[
                        PLAYER2?1:0
                    ]
                    ,
                    new Point(startPoint.x, startPoint.y),
                    new Dimension(200, 50));
            drawLeg(g, new Point(0,0) );
            g.translate(100,0);
            drawLeg(g, new Point(0,0));
            g.setTransform(transform);
        }
        private boolean maxPoint = false;
        private int moveCoxa = 0;
        private int rotatePerna = 0;
        private Point movePerna = new Point(0,0);

        public void drawLeg(Graphics2D g, Point moveTo){
            AffineTransform transform = g.getTransform();

            // Coxa da perna


            g.rotate(Math.toRadians(moveCoxa), startPoint.x + 40/2, startPoint.y);
            GeoDraw.drawRectangle(g, pantsColor[
                            PLAYER2?1:0
                            ],
                    new Point(startPoint.x, startPoint.y),
                    new Dimension(40, 150));

            g.setTransform(transform);


            g.translate(movePerna.x,movePerna.y);

            g.rotate(Math.toRadians(rotatePerna), startPoint.x-10 + 40/2,startPoint.y+25+100);
            // Joelho da perna
            GeoDraw.drawEllipse(g, pantsColor[
                            PLAYER2?1:0
                            ],
                    new Point(startPoint.x-10, startPoint.y+25+100),
                    new Dimension(40, 40));


            // Perna
            GeoDraw.drawRectangle(g, pantsColor[
                            PLAYER2?1:0
                            ],
                    new Point(startPoint.x, startPoint.y+50+100),
                    new Dimension(40, 100));

            // Sapato

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
//            GeoDraw.drawEllipse(g, Color.WHITE,  new Point(startPoint.x + 40/2, startPoint.y+50), new Dimension(5, 5));
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
    protected synchronized void keyPressed(KeyEvent event) {
        if(!keyCodes.contains(event.getKeyCode()))
            keyCodes.add(event.getKeyCode());
        for(int keyCode: keyCodes)
            if (!PLAYER2)
            {
                if (keyCode == KeyEvent.VK_RIGHT)
                    moveToRigth = true;
                if (keyCode == KeyEvent.VK_LEFT)
                    moveToLeft = true;
                body.moveHand = (moveToLeft||moveToRigth);

                if(keyCode==KeyEvent.VK_NUMPAD5)
                    reverse = !reverse;
            }else {

                if (keyCode == KeyEvent.VK_D)
                    moveToRigth = true;
                if (keyCode == KeyEvent.VK_A)
                    moveToLeft = true;
                body.moveHand = (moveToLeft||moveToRigth);

                if(keyCode==KeyEvent.VK_SPACE)
                    reverse = !reverse;

            }
    }

    @Override
    protected void keyRealesed(KeyEvent event) {
        keyCodes.clear();
    }


}
