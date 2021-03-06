package aTank.strategy.fire;

import aTank.entity.Bullet;
import aTank.entity.Tank;
import aTank.enums.Dir;
import aTank.enums.Group;
import aTank.util.Audio;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/10 14:16
 * @descrption
 */
public class FourDirFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        // 计算子弹x轴
        int bX = t.getX() + t.getWidth()/ 2 - Bullet.WIDTH / 2;
        // 计算子弹y轴
        int bY = t.getY() + t.getHeight()/ 2 - Bullet.HEIGHT / 2;
        Dir[] dirs= Dir.values();
        for(Dir dir:dirs){
            // 实例化一颗子弹
            new Bullet(bX, bY, dir, t.getGroup());
        }
        // 播放开火的音效
//        if (t.getGroup() == Group.GOOD) new Thread(() -> new Audio("tank_fire.wav").play()).start();
    }
}
