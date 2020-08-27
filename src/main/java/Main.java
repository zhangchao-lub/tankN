/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/8/27 14:57
 * @descrption
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf=new TankFrame();
        while (true){
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
