package aTank.service;

import aTank.config.PropertyMgr;
import aTank.entity.Bullet;
import aTank.entity.Explode;
import aTank.entity.Tank;
import aTank.enums.Dir;
import aTank.enums.Group;

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
    public List<Tank> enemyTanks = new ArrayList();
    //    Bullet b = new Bullet(myTank.getX(), myTank.getY(), Dir.DOWN);
    public List<Bullet> bullets = new ArrayList<>();
    //    Explode e=new Explode(50,50,this);
    public List<Explode> explodes = new ArrayList<>();

    public GameModel() {
        //获取敌人初始化数量
        int initTankCount= Integer.parseInt((String) PropertyMgr.get("initTankCount")) ;
        //初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            enemyTanks.add(new Tank(50+i*80,200, Dir.DOWN, Group.BAD,this));
        }
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量:" + bullets.size(), 10, 60);
        g.drawString("敌人的数量:" + enemyTanks.size(), 10, 80);
        g.drawString("爆炸的数量:" + explodes.size(), 10, 100);
        g.setColor(c);

        //画出敌人坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            enemyTanks.get(i).paint(g);
        }
        myTank.paint(g);

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
                bullets.get(i).collideWith(enemyTanks.get(j));

            }
        }

    }

    public Tank getMyTank() {
        return myTank;
    }

    public void setMyTank(Tank myTank) {
        this.myTank = myTank;
    }

    public List<Tank> getEnemyTanks() {
        return enemyTanks;
    }

    public void setEnemyTanks(List<Tank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    public List<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(List<Bullet> bullets) {
        this.bullets = bullets;
    }

    public List<Explode> getExplodes() {
        return explodes;
    }

    public void setExplodes(List<Explode> explodes) {
        this.explodes = explodes;
    }
}
