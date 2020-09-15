package factory.method;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/11 9:43
 * @descrption
 */
public class Broom implements Moveable{

    @Override
    public void go() {
        System.out.println("扫把冲呀~");
    }
}
