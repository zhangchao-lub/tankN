package spring.v2;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/10/28 10:58
 * @descrption
 */

@Aspect
public class TimeProxy {

    @Before("execution(void spring.v2.Tank.move())")
    public void before() {
        System.out.println(">>>start moving.." + System.currentTimeMillis());
    }

    @After("execution(void spring.v2.Tank.move())")
    private void after() {
        System.out.println(">>>end moving.." + System.currentTimeMillis());
    }

}
