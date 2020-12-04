package aTank.strategy.collide;

import aTank.entity.GameObject;
import aTank.service.GameModel;

import java.io.Serializable;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/22 16:58
 * @descrption
 */
public interface Collider extends Serializable {
    boolean collide(GameObject o1, GameObject o2);
}
