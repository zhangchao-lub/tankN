package proxy.v04;

import java.util.Random;

/**
 * 问题1:我想记录坦克的移动时间？？？
 * 最简单的方法：修改代码，打印时间
 * 问题2:如果无法改变方法源码呢？？？
 * 用继承？
 * v04:使用代理
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

    public static void main(String[] args) {
        new TankTimeProxy(new Tank()).move();
    }
}

class TankTimeProxy implements Moveable {
    private Tank tank;

    public TankTimeProxy(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void move() {
        long startTime = System.currentTimeMillis();
        tank.move();
        long endTime = System.currentTimeMillis();
        System.out.print(">>>to ");
        System.out.print(endTime - startTime);
        System.out.print(" ms ");
    }
}

interface Moveable {
    void move();
}
