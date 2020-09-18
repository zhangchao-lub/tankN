package game.abstractfactory;

import game.enums.Dir;
import game.enums.Group;
import game.frames.TankFrame;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/16 9:33
 * @descrption
 */
public abstract class GameFactory {
    public abstract BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf);
    public abstract BaseBullet createBullet(int x, int y, TankFrame tf);
    public abstract BaseExplode createExplode(int x, int y, TankFrame tf);
}
