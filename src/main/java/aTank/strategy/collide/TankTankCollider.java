package aTank.strategy.collide;

import aTank.entity.Bullet;
import aTank.entity.Explode;
import aTank.entity.Tank;
import aTank.service.GameModel;
import aTank.service.GameObject;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/22 17:23
 * @descrption
 */
public class TankTankCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2, GameModel gm) {
        if (o1 instanceof Tank && o2 instanceof Tank) {
            Tank t1 = (Tank) o1;
            Tank t2 = (Tank) o2;
            //TODO: 用一个rect来记录子弹的位置
            if (t1.getRectangle().intersects(t2.getRectangle())) {
                t1.stop();
                t2.stop();
            }
        }
        return false;
    }
}
