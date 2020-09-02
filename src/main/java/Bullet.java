import java.awt.*;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/8/28 11:46
 * @descrption
 */
public class Bullet {
    private int x, y;
    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int HEIGHT =ResourceMgr.bulletD.getHeight();
    private Dir dir;
    private static final int SPEED = 10;

    private boolean live = true;

    private TankFrame tf = null;

    public Bullet(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        if (!live) {
            tf.bullets.remove(this);
        }
//        Color c = g.getColor();
//        g.setColor(Color.RED);
//        g.fillOval(x, y, WIDTH, HEIGHT);
        switch (dir) {
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            default:
                break;
        }
        move();

    }

    private void move() {
        switch (dir) {
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            default:
                break;
        }
        if (x < 0 || y < 0 || x > TankFrame.GAME_WITCH || y > TankFrame.GAME_HEIGHT) live = false;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }
}
