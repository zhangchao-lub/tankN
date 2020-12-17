package tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.util.List;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/8/27 15:09
 * @descrption
 */
public class TankFrame extends Frame {

    private static class TankFrameHolder {
        private final static TankFrame INSTANCE = new TankFrame();
    }

    public static TankFrame getInstance() {
        return TankFrameHolder.INSTANCE;
    }

    static final int GAME_WITCH = 1080;
    static final int GAME_HEIGHT = 960;

    Random r = new Random();
    Tank myTank = new Tank(r.nextInt(GAME_WITCH), r.nextInt(GAME_HEIGHT), Dir.values()[r.nextInt(Dir.values().length)], Group.GOOD);
    Map<UUID, Tank> enemyTanks = new HashMap<>();
    //    Bullet b = new Bullet(myTank.getX(), myTank.getY(), Dir.DOWN);
    List<Bullet> bullets = new ArrayList<Bullet>();
    //    Explode e=new Explode(50,50,this);
    List<Explode> explodes = new ArrayList<Explode>();

    Boolean b = false;

    public TankFrame() {
        setSize(GAME_WITCH, GAME_HEIGHT);
        setResizable(false);
        setTitle("tank war");
        setVisible(true);

        addKeyListener(new MyKeyListener());

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    Image offScreenImage = null;

    @Override
    public void update(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WITCH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WITCH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量:" + bullets.size(), 10, 60);
        g.drawString("敌人的数量:" + enemyTanks.size(), 10, 80);
        g.drawString("爆炸的数量:" + explodes.size(), 10, 100);
        g.setColor(c);

//        for (int i = 0; i < enemyTanks.size(); i++) {
//            enemyTanks.get(i).paint(g);
//        }
        //画出自己
        myTank.paint(g);
        //画出其他坦克
        enemyTanks.values().stream().forEach((e) -> e.paint(g));
//        enemyList.add(new Tank((int)(Mat0h.random()*GAME_WITCH-50),(int)(Math.random()*GAME_HEIGHT-50),null,this));
//        for (int i = 0; i < enemyList.size(); i++) {
//            enemyList.get(i).paint(g);
//        }
//        for(Bullet b:bullets){ //会报 java.util.ConcurrentModificationException 错误
//            b.paint(g);
//        }
        //画出子弹
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
        }
        //画出爆炸效果
        for (int i = 0; i < explodes.size(); i++) {
            explodes.get(i).paint(g);
        }

        //子弹和敌方坦克的碰撞检测
        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < enemyTanks.size(); j++) {
                b = bullets.get(i).collideWith(enemyTanks.get(j));
//                if (b) {
//                    explodes.add(new Explode(bullets.get(i).getX(), bullets.get(i).getY(), this));
//                }
            }
        }
//        for (Iterator<Bullet> it = bullets.iterator(); it.hasNext(); ) {
//            Bullet b = it.next();
//            if (!b.isLive()) it.remove();
//        }
    }

    class MyKeyListener extends KeyAdapter {
        boolean bU = false;
        boolean bD = false;
        boolean bL = false;
        boolean bR = false;

        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_SPACE:
//                    b=myTank.fire();
//                    bList.add(b);
                    myTank.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if (!bU && !bD && !bL && !bR) {
                myTank.setMoving(false);
            } else {
                myTank.setMoving(true);
            }
            if (bR) myTank.setDir(Dir.RIGHT);
            if (bU) myTank.setDir(Dir.UP);
            if (bD) myTank.setDir(Dir.DOWN);
            if (bL) myTank.setDir(Dir.LEFT);

        }

    }

    public Tank getMainTank() {
        return this.myTank;
    }

    public void addTank(Tank t) {
        enemyTanks.put(t.getId(), t);
    }

    public boolean findByUUID(UUID id) {
        return enemyTanks.get(id) != null;
    }

    public Map<UUID, Tank> getEnemyTanks() {
        return enemyTanks;
    }

    public void setEnemyTanks(Map<UUID, Tank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }
}
