package proxy.v08;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
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
 * v07:如果有stop方法需要代理...
 * 如果想让 LogProxy可以重用，不仅可以代理Tank，还可以代理任何其他可以代理的类型 Object
 * （毕竟记录日志，时间计算是很多方法都需要的东西），这时该怎么做呢
 * 答案：分离代理行为与被代理对象
 * 使用jdk的{@动态代理}
 *
 * v08: 横切代码和业务逻辑代码分离 AOP
 *
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/10/15 16:01
 * @descrption
 */
public class Tank implements Movable {
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
        Tank tank = new Tank();

        Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{Movable.class},
                new TimeProxy(tank)
        );

        m.move();
    }
}

class TimeProxy implements InvocationHandler {

    Tank tank;

    public TimeProxy(Tank tank) {
        this.tank = tank;
    }

    public void before() {
        System.out.println(">>>start moving");
    }

    private void after() {
        System.out.println(">>>end moving");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object o = method.invoke(tank, args);
        after();
        return o;
    }
}

interface Movable {
    void move();
}
