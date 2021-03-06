package aTank.strategy.collide;

import aTank.entity.Bullet;
import aTank.entity.Explode;
import aTank.entity.Tank;
import aTank.service.GameModel;
import aTank.entity.GameObject;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/22 17:23
 * @descrption
 */
public class BulletTankCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank) {
            Bullet b = (Bullet) o1;
            Tank t = (Tank) o2;
            if (b.getGroup()== t.getGroup()) return false;

            //TODO: 用一个rect来记录子弹的位置
            if (b.getRectangle().intersects(t.getRectangle())) {
                t.die();
                b.die();
                int eX = t.getX() + t.getWidth() / 2 - Explode.WIDTH / 2;
                int eY = t.getY() + t.getHeight() / 2 - Explode.HEIGHT / 2;
                new Explode(eX, eY);
                return true;
            }
        }else if(o1 instanceof Tank && o2 instanceof Bullet){
            collide(o2,o1);
        }else{
            return false;
        }
        return false;
    }
}
