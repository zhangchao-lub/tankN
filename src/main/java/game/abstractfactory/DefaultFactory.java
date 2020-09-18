package game.abstractfactory;

import game.entity.Bullet;
import game.entity.Explode;
import game.entity.Tank;
import game.enums.Dir;
import game.enums.Group;
import game.frames.TankFrame;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/16 11:32
 * @descrption
 */
public class DefaultFactory extends GameFactory{
    private DefaultFactory() {
    }
    private static class DefaultFactoryHolder {
        private final static DefaultFactory INSTANCE = new DefaultFactory();
    }

    public static DefaultFactory getInstance() {
        return DefaultFactoryHolder.INSTANCE;
    }

    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new Tank(x,y,dir,group,tf);
    }

    @Override
    public BaseBullet createBullet(int x, int y, TankFrame tf) {
        return null;
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new Explode(x,y,tf);
    }
}
