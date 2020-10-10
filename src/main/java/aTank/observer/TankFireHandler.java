package aTank.observer;

import aTank.entity.Tank;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/10/10 11:07
 * @descrption
 */
public class TankFireHandler implements TankFireObserver{
    @Override
    public void actionOnFire(TankFireEvent e) {
        e.getSource().fire();
    }
}
