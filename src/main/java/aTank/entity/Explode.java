package aTank.entity;

import aTank.config.ResourceMgr;
import aTank.service.GameModel;
import aTank.service.GameObject;
import aTank.service.TankFrame;

import java.awt.*;

/**
 * 爆炸
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/2 11:06
 * @descrption
 */
public class Explode extends GameObject {
    public static int WIDTH = ResourceMgr.getExplodes()[0].getWidth();
    public static int HEIGHT = ResourceMgr.getExplodes()[0].getHeight();

    private int step = 0;
//    private TankFrame tf = null;

    GameModel gm;
    public Explode(int x, int y, GameModel gm) {
        this.x = x;
        this.y = y;
        this.gm = gm;
    }

    @Override
    public void paint(Graphics g) {
//        Color c = g.getColor();
//        g.setColor(Color.GREEN);
//        g.fillRect(x, y, tankX, tankY);
//        g.setColor(c);
        g.drawImage(ResourceMgr.getExplodes()[step++], x, y, null);
        if (step >= ResourceMgr.getExplodes().length) {
            gm.remove(this);
        }
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }
}
