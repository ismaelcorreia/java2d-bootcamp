package controllers;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class Canva extends Component {

    @Override
    public void paint(Graphics g) {
        paint((Graphics2D) g);
    }

    public void paint(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        AffineTransform affineTransform = g.getTransform();

        drawRectangle(g);
        g.setTransform(affineTransform);
    }

    public void drawRectangle(Graphics2D g) {
        AffineTransform affineTransform = g.getTransform();
        g.setPaint(new Color(255,107,137));


        // este é o método que permite criar um rectângulo, sem muitas complicações (o fill serve para preencher o espaço entre o contorno)
        g.fillRect(50, 50, 70, 70);

        // este é o método que permite criar um rectângulo, sem muitas complicações (o draw serve apenas para desenhar o contorno, sem preenchimento)
//        g.drawRect(50, 50, 70, 70);

        g.setTransform(affineTransform);
    }
}
