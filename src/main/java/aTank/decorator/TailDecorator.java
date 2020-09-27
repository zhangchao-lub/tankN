package aTank.decorator;

import aTank.service.GameModel;
import aTank.service.GameObject;

import java.awt.*;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/25 11:49
 * @descrption
 */
public class TailDecorator extends GODecorator {


    public TailDecorator(GameObject go, GameModel gm) {
        super(go);
//        this.x = go.getX();
//        this.y = go.getY();
//        this.gm = gm;
//        gm.add(this);
    }

    @Override
    public void paint(Graphics g) {
        this.x = go.getX();
        this.y = go.getY();
        go.paint(g);

        Color c = g.getColor();
        g.setColor(Color.RED);
        g.drawLine(super.go.getX(), super.go.getY(), super.go.getX() + getWidth(), super.go.getY() + getHeight());
//        g.drawLine(go.getX(), go.getY(), go.getX() + getWidth(), go.getY() + getHeight());
        g.setColor(c);
    }

    @Override
    public int getWidth() {
        return super.go.getWidth();
    }

    @Override
    public int getHeight() {
        return super.go.getHeight();
    }
}
