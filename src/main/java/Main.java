/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/8/27 14:57
 * @descrption
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();

        //初始化敌方坦克
        for (int i = 0; i < 5; i++) {
            tf.enemyTanks.add(new Tank(50+i*80,200,Dir.DOWN,Group.BAD,tf));
        }
        while (true) {
            Thread.sleep(25);
            tf.repaint();
        }
    }
}
