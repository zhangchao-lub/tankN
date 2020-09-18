package factory.method;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/11 9:39
 * @descrption
 */
public class Plane implements Moveable{

    @Override
    public void go() {
        System.out.println("飞飞飞~");
    }
}
