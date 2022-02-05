package render;

import actions.AbstractAction;
import characters.*;
import controllers.GameEngine;
import scene.Lua;
import scene.Street;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;

/** Para comentar façam ctrl + / */
public class Canva extends AbstractAction {


    private void paint(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        AffineTransform affineTransform = g.getTransform();

        g.setPaint(new Color(0x01205E));
        g.fillRect(0, 0, getWidth(), getHeight());

        actionCharacter1.draw(g);
        actionCharacter2.draw(g);


        g.setTransform(affineTransform);
    }

    @Override
    protected void mouseClick(MouseEvent event) {
        System.out.println("Clicou-me");
    }

    @Override
    protected void mouseMove(MouseEvent event) {
        System.out.println("Moveu-me");

    }

    @Override
    protected void mouseDrag(MouseEvent event) {

    }

    @Override
    protected void mouseHover(MouseEvent event) {

    }

    @Override
    protected synchronized void keyPressed(KeyEvent event) {
        actionCharacter1.keyEvents(event, KeyEventType.PRESSED );
        actionCharacter2.keyEvents(event, KeyEventType.PRESSED);
    }

    @Override
    protected synchronized void keyRealesed(KeyEvent event) {
        actionCharacter1.keyEvents(event, KeyEventType.RELEASED);
        actionCharacter2.keyEvents(event, KeyEventType.RELEASED);
    }

    private DemoCharacter demo;
    private ActionCharacter actionCharacter1;
    private ActionCharacter actionCharacter2;
    private Street street;
    private GameEngine engine;
    private final int GAME_DELAY;
    Ryu ryu;
    public Canva(final int delay) {
        GAME_DELAY = delay;
        ryu = new Ryu();
        actionCharacter1 = new ActionCharacter(true,new Point(-300, 0));
        actionCharacter2 = new ActionCharacter(false,new Point(350, 0));
        actionCharacter1.setExternalRectangles(actionCharacter2.getRectangle());
        actionCharacter2.setExternalRectangles(actionCharacter1.getRectangle());


        street = new Street();
        demo = new DemoCharacter();
        new Thread(()-> {
            while (true) {
                try{
                    Thread.sleep(GAME_DELAY);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
                repaint();
            }
        }).start();
    }


    public Canva() {
        this(1024/24);
    }

    @Override
    public void paint(Graphics g) {
        paint( (Graphics2D) g);
    }

}
