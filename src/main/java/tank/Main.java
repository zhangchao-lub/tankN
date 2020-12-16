package tank;

import netty.Client;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/8/27 14:57
 * @descrption
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = TankFrame.getInstance();
        tf.setVisible(true);
//        int initTankCount= Integer.parseInt((String) PropertyMgr.get("initTankCount")) ;
//        //获取敌人初始化数量
////        int initTankCount= (int) PropertyMgr.get("initTankCount");
//
//        //初始化敌方坦克
//        for (int i = 0; i < initTankCount; i++) {
//            tf.enemyTanks.add(new Tank(50+i*80,200, Dir.DOWN, Group.BAD,tf));
//        }
//        while (true) {
//            Thread.sleep(25);
//            tf.repaint();
//        }
        new Thread(()-> {
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            tf.repaint();
        }).start();

        Client c=new Client();
        c.connect();
    }
}
