import java.awt.*;
import java.util.Random;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/2 11:06
 * @descrption
 */
public class Explode {
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();

    private int x, y;

    private boolean living = true;
    private int step = 0;
    private TankFrame tf = null;

    public Explode(int x, int y,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
    }

    public void paint(Graphics g) {
//        Color c = g.getColor();
//        g.setColor(Color.GREEN);
//        g.fillRect(x, y, tankX, tankY);
//        g.setColor(c);
        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        if (step >= ResourceMgr.explodes.length) {
            step = 0;
        }
    }
}
