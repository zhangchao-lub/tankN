package aTank.observer;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/10/10 11:05
 * @descrption 观察者模式
 */
public interface TankFireObserver {
    void actionOnFire(TankFireEvent e);
}