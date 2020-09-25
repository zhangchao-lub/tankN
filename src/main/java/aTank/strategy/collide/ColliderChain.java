package aTank.strategy.collide;

import aTank.config.PropertyMgr;
import aTank.service.GameModel;
import aTank.service.GameObject;
import aTank.strategy.fire.FireStrategy;

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
        /** 1，配置文件写法*/
        String collider = (String) PropertyMgr.get("colliders");
//        try {
//            colliders = (Collider) Class.forName(collider).getDeclaredConstructors().;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        add(new BulletTankCollider());
        add(new TankTankCollider());
        add(new BulletWallCollider());
        add(new TankWallCollider());
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
