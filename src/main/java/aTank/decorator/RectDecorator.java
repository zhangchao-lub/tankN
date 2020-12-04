package aTank.decorator;

import aTank.service.GameModel;
import aTank.entity.GameObject;

import java.awt.*;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/25 11:49
 * @descrption
 */
public class RectDecorator extends GODecorator {



    public RectDecorator(GameObject go) {
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
        g.setColor(Color.YELLOW);
        g.drawRect(super.go.getX(), super.go.getY(), super.go.getWidth() + 2, super.go.getHeight() + 2);
//        g.drawRect(go.getX(), go.getY(), go.getWidth() + 2, go.getHeight() + 2);
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
