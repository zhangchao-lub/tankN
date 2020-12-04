package aTank.entity;

import aTank.service.GameModel;

import java.awt.*;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/23 17:22
 * @descrption
 */
public class Wall extends GameObject {
    private int w,h;
    private Rectangle rectangle;

    public Wall(int x,int y,int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.rectangle = new Rectangle(x,y,w,h);

        GameModel.getInstance().add(this);
    }

    @Override
    public void paint(Graphics g) {
        Color c=g.getColor();
        g.setColor(Color.cyan);
        g.fillRect(x,y,w,h);
        g.setColor(c);
    }

    @Override
    public int getWidth() {
        return w;
    }

    @Override
    public int getHeight() {
        return h;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }
}
