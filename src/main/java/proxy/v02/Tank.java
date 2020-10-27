package proxy.v02;

import java.util.Random;

/**
 * 问题1:我想记录坦克的移动时间？？？
 * 最简单的方法：修改代码，打印时间
 * 问题2:如果无法改变方法源码呢？？？
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
        long startTime=System.currentTimeMillis();
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime=System.currentTimeMillis();
        System.out.print(">>>to ");
        System.out.println(endTime-startTime);
        System.out.print(">>>ms ");
    }

    public static void main(String[] args) {
        new Tank().move();
    }
}

interface Moveable {
    void move();
}
