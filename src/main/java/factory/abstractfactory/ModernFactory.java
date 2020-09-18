package factory.abstractfactory;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/11 11:43
 * @descrption
 */
public class ModernFactory extends AbstractFactory{

    private ModernFactory() {
    }

    private static class ModernFactoryHolder {
        private final static ModernFactory INSTANCE = new ModernFactory();
    }

    public static ModernFactory getInstance() {
        return ModernFactory.ModernFactoryHolder.INSTANCE;
    }

    @Override
    Food createFood() {
        return new Bread();
    }

    @Override
    Weapon createWeapon() {
        return new Ak47();
    }

    @Override
    Vehicle createVehicle() {
        return new Car();
    }
}
