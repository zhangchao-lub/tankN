package factory.method;

/**
 * 交通工具工厂
 * 简单工厂，可扩展性不好
 *
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/11 9:49
 * @descrption
 */
public class SimpleVehicleFactory {
    public Car createCar() {
        return new Car();
    }

    public Broom createBroom() {
        return new Broom();
    }

    public Plane createPlane() {
        return new Plane();
    }
}
