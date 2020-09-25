package aTank.service;

import java.awt.*;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/22 13:48
 * @descrption
 */
public abstract class GameObject {
    protected int x, y;

    public abstract void paint(Graphics g);

}
