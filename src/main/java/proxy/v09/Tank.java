package proxy.v09;

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
 *
 * v08: 横切代码和业务逻辑代码分离 AOP
 * v09: 通过反射观察生成的代理对象
 *      jdk 反射生成代理必需面向接口，这是由Proxy的内部实现决定的
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

        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles","true");

        Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{Movable.class},
                new LogHandler(tank)
        );

        m.move();
    }
}

class LogHandler implements InvocationHandler {

    Tank tank;

    public LogHandler(Tank tank) {
        this.tank = tank;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("method: " + method.getName() + ">>>start moving");
        Object o = method.invoke(tank, args);
        System.out.println("method: " + method.getName() + ">>>end moving");
        return o;
    }
}

interface Movable {
    void move();
}
