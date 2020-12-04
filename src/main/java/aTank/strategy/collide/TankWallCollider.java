package aTank.strategy.collide;

import aTank.entity.Tank;
import aTank.entity.Wall;
import aTank.service.GameModel;
import aTank.entity.GameObject;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/22 17:23
 * @descrption
 */
public class TankWallCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Wall) {
            Tank t = (Tank) o1;
            Wall w = (Wall) o2;
            //TODO: 用一个rect来记录子弹的位置
            if (t.getRectangle().intersects(w.getRectangle())) {
                t.back();
            }
        }
        if (o1 instanceof Wall && o2 instanceof Tank) {
            collide(o2, o1);
        }
        return false;
    }
}
