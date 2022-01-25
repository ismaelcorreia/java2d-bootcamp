package characters;

import actions.AbstractAction;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

public class Bola extends AbstractAction {
    private int x = 0, y =0;
    private int speed = 10;
    public void draw(Graphics2D g) {
        AffineTransform affineTransform = g.getTransform();
        g.setPaint(new Color(0xFF0000));
        Ellipse2D ellipse2D = new Ellipse2D.Double(x, y, 400 , 400);

        g.fill(ellipse2D);
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
        if (event.getKeyCode() == KeyEvent.VK_RIGHT){
            x+=speed;
        }
        if (event.getKeyCode() == KeyEvent.VK_LEFT){
            x-=speed;
        }
        if (event.getKeyCode() == KeyEvent.VK_UP){
            y-=speed;
        }
        if (event.getKeyCode() == KeyEvent.VK_DOWN){
            y+=speed;
        }
    }
}
