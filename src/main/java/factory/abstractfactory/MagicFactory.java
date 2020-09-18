package factory.abstractfactory;

import factory.method.CarFactory;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/11 11:43
 * @descrption
 */
public class MagicFactory extends AbstractFactory{

    private MagicFactory() {
    }

    private static class MagicFactoryHolder {
        private final static MagicFactory INSTANCE = new MagicFactory();
    }

    public static MagicFactory getInstance() {
        return MagicFactoryHolder.INSTANCE;
    }

    @Override
    Food createFood() {
        return new MushRoom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }
}
