package aTank.strategy.collide;

import aTank.service.GameModel;
import aTank.service.GameObject;

import java.util.LinkedList;
import java.util.List;

/**
 * 责任链
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/23 15:33
 * @descrption
 */
public class ColliderChain {
    private List<Collider> colliders = new LinkedList<>();

    public ColliderChain() {
        add(new BulletTankCollider());
        add(new TankTankCollider());
    }

    public void add(Collider c){
        colliders.add(c);
    }

    public boolean collide(GameObject o1, GameObject o2, GameModel gm) {
        for(int i=0;i<colliders.size();i++){
            if(colliders.get(i).collide(o1,o2,gm)){
                return true;
            }
        }
        return false;
    }
}
