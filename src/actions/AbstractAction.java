package actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public abstract class AbstractAction extends Component{

    public void mouseEvents(MouseEvent event, MouseEventType type) {
        switch (type) {
            case DRAG:
                mouseDrag(event);
                break;
            case CLICK:
                mouseClick(event);
                break;
            case HOVER:
                mouseHover(event);
                break;
            case MOVE:
                mouseMove(event);
                break;
        }
        mouseClick(event);
    }

    protected abstract void mouseClick(MouseEvent event);
    protected abstract void mouseMove(MouseEvent event);
    protected abstract void mouseDrag(MouseEvent event);
    protected abstract void mouseHover(MouseEvent event);

    public enum MouseEventType{
        CLICK,
        MOVE,
        DRAG,
        HOVER
    }

    public abstract void keyEvents(KeyEvent event);

}
