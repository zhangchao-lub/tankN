package factory.abstractfactory;

/**
 * 魔法棒
 *
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/11 10:57
 * @descrption
 */
public class MagicStick extends Weapon {
    @Override
    void shoot() {
        System.out.println("魔法棒哔哔哔~");
    }
}
