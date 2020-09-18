package factory.abstractfactory;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/11 11:26
 * @descrption
 */
public abstract class AbstractFactory {
    abstract Food createFood();
    abstract Weapon createWeapon();
    abstract Vehicle createVehicle();
}
