package render;

import actions.AbstractAction;
import characters.ActionCharacter;
import characters.Bola;
import characters.DemoCharacter;
import characters.PersonagemSaitama;
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


        actionCharacter.draw(g);
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
    public void keyEvents(KeyEvent event) {
        bola.keyEvents(event);
        demo.keyEvents(event);
        actionCharacter.keyEvents(event);
    }

    private DemoCharacter demo;
    private Street street;
    private final int GAME_DELAY;
    ActionCharacter actionCharacter;
    PersonagemSaitama saitamaCharacter;
    Bola bola;

    public Canva(final int delay) {
        GAME_DELAY = delay;
        actionCharacter = new ActionCharacter();
        saitamaCharacter = new PersonagemSaitama();
        bola = new Bola();
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
