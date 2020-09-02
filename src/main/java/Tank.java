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
    public static int WIDTH = ResourceMgr.heroU.getWidth();
    public static int HEIGHT = ResourceMgr.heroU.getHeight();
    private Dir dir = Dir.UP;
    private static final int SPEED = 3;
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
        if (!living) tf.enemyTanks.remove(this);

        switch (dir) {
            case UP:
                if (group == Group.GOOD ? g.drawImage(ResourceMgr.heroU, x, y, null) : g.drawImage(ResourceMgr.enemyU, x, y, null))
                    break;
            case DOWN:
                if (group == Group.GOOD ? g.drawImage(ResourceMgr.heroD, x, y, null) : g.drawImage(ResourceMgr.enemyD, x, y, null))
                    break;
            case LEFT:
                if (group == Group.GOOD ? g.drawImage(ResourceMgr.heroL, x, y, null) : g.drawImage(ResourceMgr.enemyL, x, y, null))
                    break;
            case RIGHT:
                if (group == Group.GOOD ? g.drawImage(ResourceMgr.heroR, x, y, null) : g.drawImage(ResourceMgr.enemyR, x, y, null))
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
//                    if (y - SPEED >= 0)
                    y -= SPEED;
                    break;
                case DOWN:
//                    if (y + SPEED <= tf.GAME_HEIGHT - HEIGHT)
                    y += SPEED;
                    break;
                case LEFT:
//                    if (x - SPEED >= 0)
                    x -= SPEED;
                    break;
                case RIGHT:
//                    if (x + SPEED <= tf.GAME_WITCH - WIDTH)
                    x += SPEED;
                    break;
                default:
                    break;
            }
        }
        //敌人坦克随机打子弹
        if (group == Group.BAD) {
            moving = true;
            if (random.nextInt(1000) > 990) {
                this.fire();
            }
            if (random.nextInt(1000) > 990) {
                randomDir();
            }
        }
        //边界检测
        boundsCheck();
    }

    private void boundsCheck() {
        if (this.x < 0) {
            x = 0;
        }
        if (this.x > TankFrame.GAME_WITCH - WIDTH) {
            x = TankFrame.GAME_WITCH - WIDTH;
        }
        if (this.y < 0) {
            y = 0;
        }
        if (this.y > TankFrame.GAME_HEIGHT - HEIGHT) {
            y = TankFrame.GAME_HEIGHT - HEIGHT;
        }
    }

    //敌人坦克随机移动
    private void randomDir() {
        this.dir = Dir.values()[random.nextInt(4)];
//        int randomInt = random.nextInt(100);
//        if (randomInt < 25) {
//            dir = Dir.UP;
//        } else if (25 <= randomInt && randomInt < 50) {
//            dir = Dir.DOWN;
//        } else if (50 <= randomInt && randomInt < 75) {
//            dir = Dir.LEFT;
//        } else {
//            dir = Dir.RIGHT;
//        }
    }

    public void fire() {
        int bX = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        tf.bullets.add(new Bullet(bX, bY, this.dir, this.group, this.tf));
//        switch (dir) {
//            case UP:
//                tf.bullets.add(new Bullet(this.x + WIDTH / 2 - Bullet.WIDTH / 2, this.y, this.dir, this.group, this.tf));
//                break;
//            case DOWN:
//                tf.bullets.add(new Bullet(this.x + WIDTH / 2 - Bullet.WIDTH / 2, this.y + HEIGHT, this.dir, this.group, this.tf));
//                break;
//            case LEFT:
//                tf.bullets.add(new Bullet(this.x, this.y + HEIGHT / 2 - Bullet.HEIGHT / 2, this.dir, this.group, this.tf));
//                break;
//            case RIGHT:
//                tf.bullets.add(new Bullet(this.x + WIDTH, this.y + HEIGHT / 2 - Bullet.HEIGHT / 2, this.dir, this.group, this.tf));
//                break;
//            default:
//                break;

        //播放开火的音效
        if (this.group == Group.GOOD) new Thread(() -> new Audio("src/audio/tank_fire.wav"));
    }

    public void die() {
        this.living = false;
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
