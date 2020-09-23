package aTank.entity;

import aTank.config.PropertyMgr;
import aTank.config.ResourceMgr;
import aTank.enums.Dir;
import aTank.enums.Group;
import aTank.service.GameModel;
import aTank.service.GameObject;
import aTank.service.TankFrame;
import aTank.strategy.fire.FireStrategy;

import java.awt.*;
import java.util.Random;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/8/28 10:00
 * @descrption
 */
public class Tank extends GameObject {
    // 坦克坐标
    private int x, y;
    // 坦克上一次坐标
    private int prevX, prevY;
    // 坦克 长宽
    private static int WIDTH = ResourceMgr.getHeroU().getWidth();
    private static int HEIGHT = ResourceMgr.getHeroU().getHeight();
    private Dir dir = Dir.UP;
    private static final int SPEED = 3;
    private boolean living = true;
    private boolean moving = false;

//    private TankFrame tf = null;

    Rectangle rectangle = new Rectangle();

    private Random random = new Random();

    private Group group = Group.GOOD;

    GameModel gm;
    FireStrategy fs;

    public Tank(int x, int y, Dir dir, Group group, GameModel gm) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.gm = gm;

        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;

        if (group == Group.GOOD) {
            /** 1，配置文件写法*/
            String goodFs = (String) PropertyMgr.get("goodFsS");
            try {
                fs = (FireStrategy) Class.forName(goodFs).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            /** 2，lambda写法*/
            fs = (t) -> {
                int bX = t.getX() + Tank.getWIDTH() / 2 - Bullet.WIDTH / 2;
                // 计算子弹y轴
                int bY = t.getY() + Tank.getHEIGHT() / 2 - Bullet.HEIGHT / 2;
                // 实例化一颗子弹
                new Bullet(bX, bY, t.getDir(), t.getGroup(), t.getGm());
            };
        }
    }

    public void paint(Graphics g) {
//        Color c = g.getColor();
//        g.setColor(Color.GREEN);
//        g.fillRect(x, y, tankX, tankY);
//        g.setColor(c);
        if (!living) gm.remove(this);

        switch (dir) {
            case UP:
                if (group == Group.GOOD ? g.drawImage(ResourceMgr.getHeroU(), x, y, null) : g.drawImage(ResourceMgr.getEnemyU(), x, y, null))
                    break;
            case DOWN:
                if (group == Group.GOOD ? g.drawImage(ResourceMgr.getHeroD(), x, y, null) : g.drawImage(ResourceMgr.getEnemyD(), x, y, null))
                    break;
            case LEFT:
                if (group == Group.GOOD ? g.drawImage(ResourceMgr.getHeroL(), x, y, null) : g.drawImage(ResourceMgr.getEnemyL(), x, y, null))
                    break;
            case RIGHT:
                if (group == Group.GOOD ? g.drawImage(ResourceMgr.getHeroR(), x, y, null) : g.drawImage(ResourceMgr.getEnemyR(), x, y, null))
                    break;
            default:
                break;
        }
        move();
    }

    private void move() {
        if (moving) {
//            System.out.println(dir);
            prevX = x;
            prevY = y;
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
            }
        }

        if (group == Group.BAD) {
            moving = true;
            //敌人坦克随机打子弹
//            if (random.nextInt(1000) > 990) {
//                this.fire();
//            }
            //敌人坦克随机移动
            if (random.nextInt(1000) > 950) {
                randomDir();
            }
        }
        //边界检测
        boundsCheck();
        //update rectangle
        rectangle.x = this.x;
        rectangle.y = this.y;
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
//        int bX = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
//        int bY = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
//        tf.bullets.add(new Bullet(bX, bY, this.dir, this.group, this.tf));
//
//        //播放开火的音效
//        if (this.group == Group.GOOD) new Thread(() -> new Audio("tank_fire.wav").play()).start();
        /** 使用策略模式开火*/
        fs.fire(this);
    }

    public void die() {
        this.living = false;
    }

    public void stop() {
        this.moving = false;
        this.x=prevX;
        this.y=prevY;
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

    public int getPrevX() {
        return prevX;
    }

    public void setPrevX(int prevX) {
        this.prevX = prevX;
    }

    public int getPrevY() {
        return prevY;
    }

    public void setPrevY(int prevY) {
        this.prevY = prevY;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static void setWIDTH(int WIDTH) {
        Tank.WIDTH = WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static void setHEIGHT(int HEIGHT) {
        Tank.HEIGHT = HEIGHT;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public static int getSPEED() {
        return SPEED;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
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

    public GameModel getGm() {
        return gm;
    }

    public void setGm(GameModel gm) {
        this.gm = gm;
    }

    public FireStrategy getFs() {
        return fs;
    }

    public void setFs(FireStrategy fs) {
        this.fs = fs;
    }
}
