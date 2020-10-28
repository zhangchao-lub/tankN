package spring.v2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/10/28 10:57
 * @descrption AOP 注解
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("app_auto.xml");
        Tank t= (Tank) context.getBean("tank");
        t.move();
    }
}
