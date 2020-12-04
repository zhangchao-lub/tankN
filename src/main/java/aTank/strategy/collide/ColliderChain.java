package aTank.strategy.collide;

import aTank.config.PropertyMgr;
import aTank.service.GameModel;
import aTank.entity.GameObject;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.LinkedList;
import java.util.List;

/**
 * 责任链
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/23 15:33
 * @descrption
 */
public class ColliderChain  implements Collider,Serializable {
    private List<Collider> colliders = new LinkedList<>();

    /** 责任链初始化*/
    public ColliderChain() {
        /** 1，配置文件写法*/
//        String collider = (String) PropertyMgr.get("colliders");
//        try {
//            Constructor[] ct = Class.forName(collider).getDeclaredConstructors();
//            System.out.println(ct);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        /** 2.new对象*/
        add(new BulletTankCollider());
        add(new TankTankCollider());
        add(new BulletWallCollider());
        add(new TankWallCollider());
    }

    public void add(Collider c){
        colliders.add(c);
    }

    public boolean collide(GameObject o1, GameObject o2) {
        for(int i=0;i<colliders.size();i++){
            if(colliders.get(i).collide(o1,o2)){
                return true;
            }
        }
        return false;
    }
}
