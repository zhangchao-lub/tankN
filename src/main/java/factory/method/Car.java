package factory.method;


/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/11 9:35
 * @descrption
 */
public class Car implements Moveable{

    @Override
    public void go() {
        System.out.println("滴滴滴~");
    }
}
