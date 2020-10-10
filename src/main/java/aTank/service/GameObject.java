package aTank.service;

import java.awt.*;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/22 13:48
 * @descrption
 */
public abstract class GameObject {
    public int x, y;

    public abstract void paint(Graphics g);
    public abstract int getWidth();
    public abstract int getHeight();

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
