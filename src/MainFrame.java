import actions.AbstractAction;
import render.Canva;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * school: Universidade Católica de Angola
 * author: Ismael Arnaldo Correia
 */
public class MainFrame extends JFrame {

    private final Canva canva;
    public MainFrame()
    {
        super("Java2D BootCamp");
        canva = new Canva();
        initFrame();
    }

    private void initFrame(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().add(canva);
        initFormEvents();

        setSize(Toolkit.getDefaultToolkit().getScreenSize().width,
                Toolkit.getDefaultToolkit().getScreenSize().height);
    }
    private void initFormEvents() {
        initMouseFormEvents();
        initKeyFormEvents();
    }

    private void initMouseFormEvents() {
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //TODO: our mouse click action
                canva.mouseEvents(e, AbstractAction.MouseEventType.CLICK);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            // TO IGNORE
            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }


            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                canva.mouseEvents(e, AbstractAction.MouseEventType.MOVE);
            }
        });
    }

    private void initKeyFormEvents() {
      addKeyListener(new KeyListener() {
          @Override
          public void keyTyped(KeyEvent e) {
          }

          @Override
          public void keyPressed(KeyEvent e) {

              canva.keyEvents(e);
          }

          @Override
          public void keyReleased(KeyEvent e) {

          }
      });
    }

    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }
}
