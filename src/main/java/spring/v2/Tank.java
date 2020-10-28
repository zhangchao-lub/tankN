package spring.v2;

import java.util.Random;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/10/28 10:57
 * @descrption
 */
public class Tank {
    /**
     * 模拟坦克移动了一段时间
     */
    public void move() {
        System.out.println(">>>Tank is moving");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
