package aTank.service;

import aTank.config.PropertyMgr;
import aTank.entity.Bullet;
import aTank.entity.Explode;
import aTank.entity.Tank;
import aTank.enums.Dir;
import aTank.enums.Group;
import aTank.strategy.collide.BulletTankCollider;
import aTank.strategy.collide.Collider;
import aTank.strategy.collide.ColliderChain;
import aTank.strategy.collide.TankTankCollider;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/18 15:42
 * @descrption
 */
public class GameModel {

    Tank myTank = new Tank(350, 500, Dir.UP, Group.GOOD, this);
//    public List<Tank> enemyTanks = new ArrayList();
//    //    Bullet b = new Bullet(myTank.getX(), myTank.getY(), Dir.DOWN);
//    public List<Bullet> bullets = new ArrayList<>();
//    //    Explode e=new Explode(50,50,this);
//    public List<Explode> explodes = new ArrayList<>();

    //    Collider collider = new BulletTankCollider();
//    Collider collider2 = new TankTankCollider();
    ColliderChain chain = new ColliderChain();

    private List<GameObject> objects = new ArrayList<>();

    public GameModel() {
        //获取敌人初始化数量
        int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));
        //初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            objects.add(new Tank(50 + i * 80, 200, Dir.DOWN, Group.BAD, this));
        }
        objects.add(myTank);
    }

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
                if (chain.collide(o1, o2, this)) {
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


}
