package controllers;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
/** Para comentar façam ctrl + / */
public class Canva extends Component {

    @Override
    public void paint(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

        g2.setPaint(new Color(34, 105, 210, 137));
        desenharGrelha(g2);



        GeneralPath lapis = new GeneralPath(); // O nosso lápis
        Point coordenadas = new Point(500, 100); // coordenadas do lápis

        g2.setPaint(new Color(32, 56, 100)); // cor do lápis

        lapis.moveTo(coordenadas.x, coordenadas.y); // movendo o lápis para a coordenadas
        lapis.lineTo(coordenadas.x -= 100, coordenadas.y += 100); // Atualizando x - 100px e + 100px para y
        lapis.lineTo(coordenadas.x += 200, coordenadas.y); // Atualizando + 200px em x e mantendo y
        lapis.closePath(); // Unindo as extremidades

        g2.fill(lapis); // representado o desenho de forma preenchida


//        lapis.moveTo(coordenadas.x, coordenadas.y); // movendo o lápis para a coordenadas
//        lapis.lineTo(coordenadas.x - 100, coordenadas.y + 100); // Desenhando - 100px em x e + 100px para y
//        lapis.lineTo(coordenadas.x + 100, coordenadas.y + 100); // Desenhando + 100px em x e + 100px para y
//        lapis.closePath();  // Unir este ponto ao ponto incial
//
//        g2.fill(lapis); // representado o desenho de forma preenchida

//        lapis.closePath();

//        g2.scale(1.5, 1.5);
//            for (int i = 0; i < 5; i++) {
//                desenharCirculo(g2, 150 + ((100 + 10) * i) ,100, 100, 100, new Color(199, 97, 227));
//            }


//        for (int espaco = 0, i = 0; i < (100+espaco) * 5; i += (100+espaco)) {
//            desenharRectangulo(g2, 150 + i ,100, 100, 100, new Color(107, 181, 255));
//        }
    }

    private Ellipse2D desenharCirculo(Graphics2D g, int x, int y, int w, int h, Color color) {
        Ellipse2D ellipse2D = new Ellipse2D.Double(x,  y,  w,  h);
        g.setPaint(color);
        g.fill(ellipse2D);
        g.fillRect(10, 10, 120, 100);
        g.fillOval(10, 10, 120, 120);
        return ellipse2D;
    }

//    private Rectangle2D desenharRectangulo(Graphics2D g, int x, int y, int w, int h, Color color) {
//        Rectangle2D rectangle = new Rectangle2D.Double(x,  y,  w,  h);
//        g.setPaint(color);
//        g.fill(rectangle);
//        return rectangle;
//    }

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
