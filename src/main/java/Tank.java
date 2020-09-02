import java.awt.*;
import java.util.Random;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/8/28 10:00
 * @descrption
 */
public class Tank {
    // 坦克坐标
    private int x, y;
    // 坦克 长宽
    public static int WIDTH = ResourceMgr.tankD.getWidth();
    public static int HEIGHT = ResourceMgr.tankD.getHeight();
    private Dir dir = Dir.UP;
    private static final int SPEED = 5;
    private boolean living = true;
    private boolean moving = false;

    private TankFrame tf = null;

    private Random random = new Random();

    private Group group = Group.GOOD;

    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;
    }

    public void paint(Graphics g) {
//        Color c = g.getColor();
//        g.setColor(Color.GREEN);
//        g.fillRect(x, y, tankX, tankY);
//        g.setColor(c);
        if (!living) return;

        switch (dir) {
            case UP:
                g.drawImage(ResourceMgr.tankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.tankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR, x, y, null);
                break;
            default:
                break;
        }
        move();
    }

    private void move() {
        if (moving) {
            System.out.println(dir);
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
        }
        //敌人坦克打子弹
        if (random.nextInt(10) > 8) this.fire();
        randomDir();
    }

    private void randomDir() {

    }

    public void fire() {
        switch (dir) {
            case UP:
                tf.bullets.add(new Bullet(this.x + WIDTH / 2 - Bullet.WIDTH / 2, this.y, this.dir,this.group, this.tf));
                break;
            case DOWN:
                tf.bullets.add(new Bullet(this.x + WIDTH / 2 - Bullet.WIDTH / 2, this.y + HEIGHT, this.dir, this.group,this.tf));
                break;
            case LEFT:
                tf.bullets.add(new Bullet(this.x, this.y + HEIGHT / 2 - Bullet.HEIGHT / 2, this.dir,this.group,this.tf));
                break;
            case RIGHT:
                tf.bullets.add(new Bullet(this.x + WIDTH, this.y + HEIGHT / 2 - Bullet.HEIGHT / 2, this.dir, this.group,this.tf));
                break;
            default:
                break;
        }
    }

    public void die() {
        this.living = false;
        tf.enemyTanks.remove(this);
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

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
