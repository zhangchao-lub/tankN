package aTank.entity;

import aTank.config.ResourceMgr;
import aTank.service.GameModel;
import aTank.util.Audio;

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

    GameModel gm=GameModel.getInstance();
    public Explode(int x, int y) {
        this.x = x;
        this.y = y;

        GameModel.getInstance().add(this);
        //播放爆炸音效
//        new Thread(()->new Audio("explode.wav").play()).start();
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
