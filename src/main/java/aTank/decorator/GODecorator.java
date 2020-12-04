package aTank.decorator;

import aTank.entity.GameObject;

import java.awt.*;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/25 11:49
 * @descrption 装饰器模式
 */
public abstract class GODecorator extends GameObject {
    protected GameObject go;

    public GODecorator(GameObject go) {
//        this.x = go.getX();
//        this.y = go.getY();
        this.go = go;
    }

    @Override
    public abstract void paint(Graphics g);
}
