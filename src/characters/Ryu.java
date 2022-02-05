package characters;

import actions.AbstractAction;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;

public class Ryu extends AbstractAction {

    Cabeca cabeca;
    Tronco tronco;
    Pernas pernas;

    // Método construtor, inicializa os membros dos corpos
    public Ryu(){
        cabeca = new Cabeca();
        tronco = new Tronco();
        pernas = new Pernas();
    }


    public void draw(Graphics2D g) {
        AffineTransform transform = g.getTransform();
        cabeca.draw(g);
        tronco.draw(g);

        g.setTransform(transform);
    }


    class Cabeca{

        final Point pontoInicial = new Point(300, 20);
        final Face face = new Face(pontoInicial);
        final Cabelo cabelo = new Cabelo();

        public void draw(Graphics2D g) {
            AffineTransform transform = g.getTransform();

            craneo(g);
            cabelo.draw(g);

            g.setTransform(transform);

        }

        private void craneo(Graphics2D g) {
            AffineTransform transform = g.getTransform();
            Area area = new Area(

                    GeoDraw.getEllipse(
                            pontoInicial, new Dimension(70, 100)
                    )
            );

            area.subtract(
                new Area(

                        GeoDraw.getEllipse(
                                pontoInicial, new Dimension(70, 100-70)
                        )
                )
            );
            g.setPaint(new Color(249,181,132));
            g.fill(area);
            face.draw(g);

            g.setTransform(transform);
        }

        class Face {
            boolean zangado;
            boolean rindo;
            boolean neutro;

            void resetEstado() {
                zangado = false;
                rindo = false;
                neutro  = true;
            }

            void vericarEstado() {
                neutro  = !rindo && !zangado;
            }
            final Point pontoInicial;
            Face(Point pontoInicial) {
                this.pontoInicial = new Point(pontoInicial.x+ 18, pontoInicial.y+ 40);
                neutro = true;
            }
            public void draw(Graphics2D g) {
                vericarEstado();
                AffineTransform transform = g.getTransform();
                drawOlhos(g, true);
                g.translate(26, 0);
                drawOlhos(g, false);
                g.setTransform(transform);
                resetEstado();
            }

            private void drawOlhos(Graphics2D g, boolean direita) {
                AffineTransform transform = g.getTransform();

                if (neutro) {
                    GeoDraw.drawRoundedRectangle(g,new Color(62, 38, 20),
                            new Point(this.pontoInicial.x, this.pontoInicial.y+3),
                            new Dimension(20, 3),
                            5, 5
                    );
                    GeoDraw.drawEllipse(g,new Color(62, 38, 20),
                            new Point(this.pontoInicial.x+6, this.pontoInicial.y+10),
                            new Dimension(8, 8)
                    );
                }
                if (rindo){

                    g.setPaint(new Color(62, 38, 20));

                    g.setStroke(new BasicStroke(2));
                    g.drawLine(this.pontoInicial.x,direita?this.pontoInicial.y+3:this.pontoInicial.y-3 ,
                            this.pontoInicial.x+ 20, direita? this.pontoInicial.y-6:this.pontoInicial.y+3
                            );
                    g.setStroke(new BasicStroke(1));

                    Area areaOlhos = new Area(
                            GeoDraw.getEllipse(
                                    new Point(this.pontoInicial.x+6, this.pontoInicial.y+10),
                                    new Dimension(8, 8)
                            )
                    );

                    areaOlhos.subtract(
                            new Area(
                                    GeoDraw.getEllipse(
                                            new Point(this.pontoInicial.x+6, this.pontoInicial.y+10+3),
                                            new Dimension(8, 8)
                                    )
                            )
                    );

                    g.fill(areaOlhos);
                }
                if (zangado){

                    g.setPaint(new Color(62, 38, 20));

                    g.setStroke(new BasicStroke(2));
                    g.drawLine(this.pontoInicial.x,direita?this.pontoInicial.y-3:this.pontoInicial.y+3,
                            this.pontoInicial.x+ 20, direita?this.pontoInicial.y+3: this.pontoInicial.y-6
                    );
                    g.setStroke(new BasicStroke(1));

                    Area areaOlhos = new Area(
                            GeoDraw.getEllipse(
                                    new Point(this.pontoInicial.x+6, this.pontoInicial.y+10),
                                    new Dimension(8, 8)
                            )
                    );

                    areaOlhos.subtract(
                            new Area(
                                    GeoDraw.getRectangle(
                                            new Point(this.pontoInicial.x+6, this.pontoInicial.y+10-8/2),
                                            new Dimension(8, 8)
                                    )
                            )
                    );

                    g.fill(areaOlhos);
                }

                g.setTransform(transform);
            }

        }

        class Cabelo {
            public void draw(Graphics2D g) {
                final Point pontosCabelo = new Point(300, 35);
                AffineTransform transform = g.getTransform();
                {
                    GeoDraw.fillGeneralPath(g, new Color(0x6D4E26),
                            new Point(pontosCabelo.x, pontosCabelo.y-=10),
                            new Point(pontosCabelo.x+=5, pontosCabelo.y+=7),
                            new Point(pontosCabelo.x+=14, pontosCabelo.y-=3),
                            new Point(pontosCabelo.x+=10, pontosCabelo.y+=4),
                            new Point(pontosCabelo.x+=15, pontosCabelo.y-=6),
                            new Point(pontosCabelo.x+=9, pontosCabelo.y+=5),
                            new Point(pontosCabelo.x+=10, pontosCabelo.y-=6),
                            new Point(pontosCabelo.x+=2, pontosCabelo.y+=6),
                            new Point(pontosCabelo.x+=10, pontosCabelo.y-=6),
                            new Point(pontosCabelo.x+=6, pontosCabelo.y+=6),
                            new Point(pontosCabelo.x-=7, pontosCabelo.y+=15),
                            new Point(pontosCabelo.x-=2, pontosCabelo.y+=7),
                            new Point(pontosCabelo.x-=8, pontosCabelo.y-=5),
                            new Point(pontosCabelo.x-=4, pontosCabelo.y+=8),
                            new Point(pontosCabelo.x-=8, pontosCabelo.y-=5),
                            new Point(pontosCabelo.x-=5, pontosCabelo.y+=4),
                            new Point(pontosCabelo.x-=8, pontosCabelo.y-=2),
                            new Point(pontosCabelo.x-=3, pontosCabelo.y+=2),
                            new Point(pontosCabelo.x-=35, pontosCabelo.y+=2)
                    );
                }
                GeoDraw.drawRoundedRectangle(g, Color.RED, new Point(300, 41), new Dimension(70,10), 10, 10);
                g.setTransform(transform);

            }



        }
    }


    class Tronco{


        public void draw(Graphics2D g) {
            AffineTransform transform = g.getTransform();
            int x = 240;
            int y = 120;
            GeoDraw.fillGeneralPath(g,  new Color(0xCACACA),
                    new Point(x, y),
                    new Point(x+=200, y),
                    new Point(x+=10, y+=50),
                    new Point(x-=110, y+=50),
                    new Point(x-=110, y-=50),
                    new Point(x-=10, y)
            );
            GeoDraw.drawRoundedRectangle(g,  new Color(0xCACACA), new Point(290, 160), new Dimension(90,90), 20, 20);

            bracoDireito(g);
            g.setTransform(transform);
        }

        public void bracoDireito(Graphics2D g){

            AffineTransform transform = g.getTransform();
            int x = 200;
            int y = 120;
            GeoDraw.drawEllipse(g,Color.WHITE, new Point(x, y), new Dimension(90,90));
            GeoDraw.drawEllipse(g,Color.WHITE, new Point(x, y+30), new Dimension(90,90));
//
//            g.translate(70,0);
//            g.rotate(Math.toRadians(-90),x+45, y+70);
            GeoDraw.drawEllipse(g,Color.WHITE, new Point(x, y+70), new Dimension(90,130));

            g.setTransform(transform);
        }


    }


    class Pernas{


        public void draw(Graphics2D g) {

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
    protected void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_UP)
            this.cabeca.face.rindo = true;

        if (event.getKeyCode() == KeyEvent.VK_DOWN)
            this.cabeca.face.zangado = true;

    }

    @Override
    protected void keyRealesed(KeyEvent event) {

    }
}
