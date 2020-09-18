package game;

import game.config.PropertyMgr;
import game.entity.Tank;
import game.enums.Dir;
import game.enums.Group;
import game.frames.TankFrame;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/8/27 14:57
 * @descrption
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();

        int initTankCount= Integer.parseInt((String) PropertyMgr.get("initTankCount")) ;
        //获取敌人初始化数量
//        int initTankCount= (int) PropertyMgr.get("initTankCount");

        //初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            tf.enemyTanks.add(tf.gf.createTank(50+i*80,200, Dir.DOWN, Group.BAD,tf));
        }
        while (true) {
            Thread.sleep(25);
            tf.repaint();
        }
    }
}
