package controllers;

import actions.AbstractAction;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class GameEngine {

    private Rectangle[] rectangles;
    private Rectangle rectangle;



    public GameEngine(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public void setExternalRectangles(Rectangle... rectangles) {
        this.rectangles = rectangles;
    }

    public boolean checkColision(){
        for (int i = 0; i < rectangles.length; i++) {
            if(colision(rectangle,rectangles[i]))
                return true;
        }
        return false;
    }

    private boolean colision(Rectangle r, Rectangle r1){

        return ((r.x <= (r1.x+r1.width) && (r.x+r.width)>=(r1.x+r1.width))
                && (r.y <= (r1.y+r1.height) && (r.y+r.height)>=(r1.y+r1.height)))
                ||((r.x <= (r1.x) && (r.x+r.width)>=(r1.x))
                && (r.y <= (r1.y+r1.height) && (r.y+r.height)>=(r1.y+r1.height)))
                ||((r.x <= (r1.x+r1.width) && (r.x+r.width)>=(r1.x+r1.width))
                && (r.y <= (r1.y) && (r.y+r.height)>=(r1.y)))
                ||((r.x <= (r1.x) && (r.x+r.width)>=(r1.x))
                && (r.y <= (r1.y) && (r.y+r.height)>=(r1.y)));

    }
}
