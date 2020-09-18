package game.entity;

import game.abstractfactory.BaseExplode;
import game.config.ResourceMgr;
import game.frames.TankFrame;

import java.awt.*;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/18 9:09
 * @descrption
 */
public class RectExplode extends BaseExplode {
    public static int WIDTH = ResourceMgr.getExplodes()[0].getWidth();
    public static int HEIGHT = ResourceMgr.getExplodes()[0].getHeight();

    private int x, y;

    private int step = 0;
    private TankFrame tf = null;

    public RectExplode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.GREEN);
        g.fillRect(x, y, 10 * step, 10 * step);
        step++;
//        g.drawImage(ResourceMgr.getExplodes()[step++], x, y, null);
        if (step >= 5) {
            tf.explodes.remove(this);
        }
        g.setColor(c);
    }
}
