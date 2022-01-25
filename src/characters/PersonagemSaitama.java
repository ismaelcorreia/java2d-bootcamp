package characters;

import java.awt.*;
import java.awt.geom.*;

public class PersonagemSaitama {

            // devemos informar em qual posição o nosso desenho vai começar

    public void draw(Graphics2D g) {

        AffineTransform transform = g.getTransform();

        Cabeca.draw(g);
        Tronco.draw(g);
        g.setTransform(transform);
    }
    private static class Tronco {
        public static Point point = new Point(250, 140); // posicao inicial
        public static void draw(Graphics2D g) {
            AffineTransform transform = g.getTransform();
            drawOmbro(g);
            g.setTransform(transform);
        }

        private static void resetPoint(){
            point.x = 200;
            point.y = 140;
        }

        public static void drawOmbro(Graphics2D g) {

            AffineTransform transform = g.getTransform();
            GeneralPath path = new GeneralPath();
            path.moveTo(point.x, point.y);
            path.curveTo(point.x =+ 20, point.y =+ 100, point.x , point.y, point.x +=20, point.y-=100);
            path.closePath();
            g.setPaint(new Color(190,212,223));
            g.fill(path);
            g.setTransform(transform);
            resetPoint();
        }
    }
    private static class Membros {

    }
    private static class Cabeca {
        public static Point point = new Point(300, 30); // posicao inicial
        //TODO: vamos fazer todos os elementos (órgãos) da cabeça do
        // nosso super hero


        public static void draw(Graphics2D g) {
            AffineTransform transform = g.getTransform();
            drawOrelhas(g);
            drawCranio(g);
            drawOlhos(g);
            drawNarizes(g);
            drawBoca(g, 1);
            g.setTransform(transform);
        }

        //vamos começar mesmo com a estrutura e vamos chamar ela de
        //crânio

        public static void drawOrelhas(Graphics2D g) {
            AffineTransform transform = g.getTransform();
            drawOrelha(g);
            g.translate(70, 0);
            drawOrelha(g);
            g.setTransform(transform);
        }
        public static void drawOrelha(Graphics2D g) {
            AffineTransform transform = g.getTransform();

            Ellipse2D orelha = new Ellipse2D.Double(point.x - 7, point.y+35+7, 20, 20);
            Ellipse2D orelhaInterior = new Ellipse2D.Double(point.x - 7 + 3, point.y+35+7+3, 13, 13);

            g.setPaint(new Color(248,193,157));
            g.fill(orelha);
            g.setPaint(new Color(177, 99, 77));
            g.fill(orelhaInterior);
            g.setTransform(transform);
        }
        public static void drawCranio(Graphics2D g) {
            AffineTransform transform = g.getTransform();
            g.setPaint(new Color(248,193,157));
            // o seu crâneo tem uma forma oval

            RoundRectangle2D ellipse2D = new RoundRectangle2D.Double(point.x, point.y, 75, 100, 70,70);
            g.fill(ellipse2D);
            g.setTransform(transform);
        }

        public static void drawOlhos(Graphics2D g) {
            AffineTransform transform = g.getTransform();
            // o seu crâneo tem uma forma oval
            int k = -2;

            drawOlho(g, k);
            g.translate(35, 0);
            drawOlho(g, -2 -k);
            g.setTransform(transform);
        }

        public static void drawOlho(Graphics2D g, int s) {
            AffineTransform transform = g.getTransform();
            // o seu crâneo tem uma forma oval

            Line2D line2D = new Line2D.Double(point.x + 10, point.y+28 - s,point.x + 10+20, point.y+28 + s);
            RoundRectangle2D eye = new RoundRectangle2D.Double(point.x + 10, point.y+35, 20, 14, 14,14);
            Ellipse2D pupil = new Ellipse2D.Double(point.x + 10+8, point.y+35+6, 3, 3);

            g.setPaint(new Color(177, 99, 77));
            g.setStroke(new BasicStroke(2));
            g.draw(line2D);
            g.setStroke(new BasicStroke(1));


            g.setPaint(new Color(255, 255, 255));
            g.fill(eye);

            g.setPaint(new Color(24, 24, 24));
            g.fill(pupil);
            g.setTransform(transform);
        }


        public static void drawNarizes(Graphics2D g) {
            AffineTransform transform = g.getTransform();

            drawNariz(g);
            g.translate(14, 0);
            drawNariz(g);
            g.setTransform(transform);
        }


        public static void drawNariz(Graphics2D g) {
            AffineTransform transform = g.getTransform();

            Ellipse2D nariz = new Ellipse2D.Double(point.x + 10+17, point.y+35+30, 3, 3);

            g.setPaint(new Color(177, 99, 77));
            g.setStroke(new BasicStroke(2));
            g.draw(nariz);
            g.setTransform(transform);
        }


        public static void drawBoca(Graphics2D g, int abertura) {
            AffineTransform transform = g.getTransform();

            Ellipse2D boca = new Ellipse2D.Double(point.x + 20, point.y+35+45, 30, abertura);

            g.setPaint(new Color(177, 99, 77));
            g.fill(boca);
            g.setTransform(transform);
        }

    }

}
