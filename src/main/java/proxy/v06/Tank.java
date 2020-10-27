package proxy.v06;

import java.util.Random;

/**
 * 问题1:我想记录坦克的移动时间？？？
 * 最简单的方法：修改代码，打印时间
 * 问题2:如果无法改变方法源码呢？？？
 * 用继承？
 * v04:使用代理
 * v05:使用有各种类型
 * 问题：如何实现代理的各种组合？继承？Decorator？
 * v06:使用静态代理 代理的对象改为Movable类型-越来越像Decorator
 *
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

        new TankTimeProxy(
                new TankLogProxy(
                        new Tank()
                )
        ).move();
    }
}

class TankTimeProxy implements Moveable {
    private Moveable m;

    public TankTimeProxy(Moveable m) {
        this.m = m;
    }

    @Override
    public void move() {
        long startTime = System.currentTimeMillis();
        m.move();
        long endTime = System.currentTimeMillis();
        System.out.print(">>>to ");
        System.out.print(endTime - startTime);
        System.out.print(" ms ");
    }
}

class TankLogProxy implements Moveable {
    private Moveable m;

    public TankLogProxy(Moveable m) {
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println(">>>start moving");
        m.move();
        System.out.println(">>>end moving");
    }
}

interface Moveable {
    void move();
}
