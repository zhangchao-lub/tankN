package proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * cglib实现动态代理不需要接口
 *
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/10/15 16:01
 * @descrption
 */
public class Main {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Tank.class);
        enhancer.setCallback(new TimeMethodInterceptor());
        Tank tank= (Tank) enhancer.create();
        tank.move();
    }
}

class TimeMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println(o.getClass().getSuperclass().getName());
        System.out.println(">>>start moving");
        Object result=null;
        result=methodProxy.invokeSuper(o,objects);
        System.out.println(">>>end moving");
        return result;
    }
}

class Tank {
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


