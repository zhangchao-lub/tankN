package aTank.strategy.collide;

import aTank.service.GameModel;
import aTank.service.GameObject;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/22 16:58
 * @descrption
 */
public interface Collider {
    boolean collide(GameObject o1, GameObject o2, GameModel gm);
}
