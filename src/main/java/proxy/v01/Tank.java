package proxy.v01;

import java.util.Random;

/**
 * 问题:我想记录坦克的移动时间???
 *
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/10/15 16:01
 * @descrption
 */
public class Tank implements Moveable {
    /**
     * 模拟坦克移动了一段时间
     */
    @Override
    public void move() {
        System.out.println(">>>Tank is moving");
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

interface Moveable {
    void move();
}
