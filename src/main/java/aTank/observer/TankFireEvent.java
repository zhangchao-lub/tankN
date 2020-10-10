package aTank.observer;

import aTank.entity.Tank;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/10/10 11:02
 * @descrption
 */
public class TankFireEvent {
    Tank tank;

    public TankFireEvent(Tank tank) {
        this.tank=tank;
    }

    public Tank getSource() {
        return tank;
    }
}
