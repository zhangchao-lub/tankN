package factory.abstractfactory;


/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/11 9:35
 * @descrption
 */
public class Car extends Vehicle{
    @Override
    public void go() {
        System.out.println("小汽车滴滴滴~");
    }
}
