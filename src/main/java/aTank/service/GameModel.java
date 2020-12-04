package aTank.service;

import aTank.config.PropertyMgr;
import aTank.entity.*;
import aTank.enums.Dir;
import aTank.enums.Group;
import aTank.strategy.collide.ColliderChain;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/18 15:42
 * @descrption
 */
public class GameModel implements Serializable{

    private static final GameModel INSTANCE =new GameModel();

    static {
        INSTANCE.init();
    }

    Tank myTank;

    /**碰撞-责任链*/
    ColliderChain chain = new ColliderChain();

    private List<GameObject> objects = new ArrayList<>();

    private GameModel() {

    }

    public static GameModel getInstance() {
        return INSTANCE;
    }
    private void init() {
        // 初始化主站坦克
        myTank = new Tank(350, 500, Dir.UP, Group.GOOD);
        // 获取敌人初始化数量
        int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));
        // 初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            new Tank(50 + i * 80, 200, Dir.DOWN, Group.BAD);
        }
        // 初始化墙
        new Wall(200,150,200,50);
        new Wall(600,150,200,50);
        new Wall(300,500,50,200);
        new Wall(500,350,50,200);
    }

//    public List<Tank> enemyTanks = new ArrayList();
//    //    Bullet b = new Bullet(myTank.getX(), myTank.getY(), Dir.DOWN);
//    public List<Bullet> bullets = new ArrayList<>();
//    //    Explode e=new Explode(50,50,this);
//    public List<Explode> explodes = new ArrayList<>();

    //    Collider collider = new BulletTankCollider();
//    Collider collider2 = new TankTankCollider();

    public void add(GameObject go) {
        this.objects.add(go);
    }

    public void remove(GameObject go) {
        this.objects.remove(go);
    }

    public List<GameObject> getObjects() {
        return objects;
    }

    public void setObjects(List<GameObject> objects) {
        this.objects = objects;
    }

    public void paint(Graphics g) {
        int sumBullet = 0, sumTank = 0, sumExplode = 0;
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i) instanceof Bullet) {
                sumBullet++;
            }
            if (objects.get(i) instanceof Tank) {
                sumTank++;
            }
            if (objects.get(i) instanceof Explode) {
                sumExplode++;
            }

        }
        g.drawString("子弹的数量:" + sumBullet, 10, 60);
        g.drawString("敌人的数量:" + sumTank, 10, 80);
        g.drawString("爆炸的数量:" + sumExplode, 10, 100);
        g.setColor(c);

        myTank.paint(g);

        //画出敌人坦克
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }

        //互相碰撞的逻辑
        for (int i = 0; i < objects.size(); i++) {
            for (int j = i + 1; j < objects.size(); j++) {
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);

//                collider.collide(o1, o2, this);
//                collider2.collide(o1, o2, this);
                if (chain.collide(o1, o2)) {
                    break;
                }
            }
        }

    }

    public Tank getMyTank() {
        return myTank;
    }

    public void setMyTank(Tank myTank) {
        this.myTank = myTank;
    }

    //Memento 备忘录模式 记录快照
    //存盘
    public void save(){
        File file=new File("C:\\Users\\GZWX\\Desktop\\tank.data");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ObjectOutputStream oos=null;
        try {
            oos=new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(myTank);
            oos.writeObject(objects);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //读取
    public void load() {
        File file=new File("C:\\Users\\GZWX\\Desktop\\tank.data");
        ObjectInputStream ois=null;
        try {
            ois=new ObjectInputStream(new FileInputStream(file));
            myTank=(Tank) ois.readObject();
            objects=(List)ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
