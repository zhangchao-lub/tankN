package tank;

import java.awt.*;

/**
 * 爆炸
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/2 11:06
 * @descrption
 */
public class Explode {
    public static int WIDTH = ResourceMgr.getExplodes()[0].getWidth();
    public static int HEIGHT = ResourceMgr.getExplodes()[0].getHeight();

    private int x, y;

    private int step = 0;

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g) {
//        Color c = g.getColor();
//        g.setColor(Color.GREEN);
//        g.fillRect(x, y, tankX, tankY);
//        g.setColor(c);
        g.drawImage(ResourceMgr.getExplodes()[step++], x, y, null);
        if (step >= ResourceMgr.getExplodes().length) {
            TankFrame.getInstance().explodes.remove(this);
        }
    }
}
