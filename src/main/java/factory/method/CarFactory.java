package factory.method;


/**
 * 工厂方法
 *
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/11 9:52
 * @descrption
 */
public class CarFactory {
    private CarFactory() {
    }

    private static class CarFactoryHolder {
        private final static CarFactory INSTANCE = new CarFactory();
    }

    public static CarFactory getInstance() {
        return CarFactoryHolder.INSTANCE;
    }

    Moveable create(){
        return new Car();
    }
}
