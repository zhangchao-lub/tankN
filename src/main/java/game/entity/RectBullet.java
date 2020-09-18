package game.entity;

import game.abstractfactory.BaseBullet;
import game.abstractfactory.BaseTank;
import game.config.ResourceMgr;
import game.enums.Dir;
import game.enums.Group;
import game.frames.TankFrame;

import java.awt.*;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/8/28 11:46
 * @descrption
 */
public class RectBullet extends BaseBullet {
    private int x, y;
    public static int WIDTH = ResourceMgr.getBulletD().getWidth();
    public static int HEIGHT = ResourceMgr.getBulletD().getHeight();
    private Dir dir;
    private static final int SPEED = 6;

    private boolean living = true;

    private TankFrame tf = null;

    Rectangle rectangle = new Rectangle();

    private Group group = Group.BAD;

    public RectBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;

        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;

        tf.bullets.add(this);
    }

    public void paint(Graphics g) {
        if (!living) tf.bullets.remove(this);
//        switch (dir) {
//            case UP:
//                g.drawImage(ResourceMgr.getBulletU(), x, y, null);
//                break;
//            case DOWN:
//                g.drawImage(ResourceMgr.getBulletD(), x, y, null);
//                break;
//            case LEFT:
//                g.drawImage(ResourceMgr.getBulletL(), x, y, null);
//                break;
//            case RIGHT:
//                g.drawImage(ResourceMgr.getBulletR(), x, y, null);
//                break;
//            default:
//                break;
//        }
        Color c=g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x,y,20,20);
        g.setColor(c);
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
        rectangle.x = this.x;
        rectangle.y = this.y;

        if (x < 0 || y < 0 || x > TankFrame.GAME_WITCH || y > TankFrame.GAME_HEIGHT) living = false;
    }

    public boolean isLive() {
        return living;
    }

    public void setLive(boolean live) {
        this.living = live;
    }

    public boolean collideWith(BaseTank baseTank) {
        if (this.group == baseTank.getGroup()) return false;

        //TODO: 用一个rect来记录子弹的位置
        if (this.rectangle.intersects(baseTank.getRectangle())) {
            baseTank.die();
            this.die();
            int eX = baseTank.getX() + Tank.getWIDTH() / 2 - Explode.WIDTH / 2;
            int eY = baseTank.getY() + Tank.getHEIGHT() / 2 - Explode.HEIGHT / 2;
//            tf.explodes.add(new Explode(eX, eY, tf));
            tf.explodes.add(tf.gf.createExplode(eX,eY,tf));
            return true;
        }
        return false;
    }

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

    private void die() {
        this.living = false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
