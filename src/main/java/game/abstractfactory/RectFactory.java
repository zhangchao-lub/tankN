package game.abstractfactory;

import game.entity.RectBullet;
import game.entity.RectExplode;
import game.entity.RectTank;
import game.enums.Dir;
import game.enums.Group;
import game.frames.TankFrame;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/18 9:09
 * @descrption
 */
public class RectFactory extends GameFactory {
    private RectFactory() {
    }

    private static class RectFactoryHolder {
        private final static RectFactory INSTANCE = new RectFactory();
    }

    public static RectFactory getInstance() {
        return RectFactoryHolder.INSTANCE;
    }

    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new RectTank(x,y,dir,group,tf);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new RectBullet(x,y,dir,group,tf);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new RectExplode(x, y, tf);
    }
}
