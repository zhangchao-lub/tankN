package factory.abstractfactory;



/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/11 9:37
 * @descrption
 */
public class Main {
    public static void main(String[] args) {
        AbstractFactory af= MagicFactory.getInstance();
        Vehicle c=af.createVehicle();
        c.go();
        Weapon w=af.createWeapon();
        w.shoot();
        Food f=af.createFood();
        f.printName();
    }
}
