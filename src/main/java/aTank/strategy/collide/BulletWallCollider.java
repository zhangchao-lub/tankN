package aTank.strategy.collide;

import aTank.entity.Bullet;
import aTank.entity.Wall;
import aTank.service.GameModel;
import aTank.entity.GameObject;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/22 17:23
 * @descrption
 */
public class BulletWallCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Wall) {
            Bullet b = (Bullet) o1;
            Wall w = (Wall) o2;

            if (b.getRectangle().intersects(w.getRectangle())) {
                b.die();
                return true;
            }
        }else if(o1 instanceof Wall && o2 instanceof Bullet){
            collide(o2,o1);
        }else{
            return false;
        }
        return false;
    }
}
