package aTank.strategy.fire;

import aTank.decorator.RectDecorator;
import aTank.decorator.TailDecorator;
import aTank.entity.Bullet;
import aTank.entity.Tank;
import aTank.service.GameModel;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/10 14:16
 * @descrption
 */
public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        // 计算子弹x轴
        int bX = t.getX() + t.getWidth() / 2 - Bullet.WIDTH / 2;
        // 计算子弹y轴
        int bY = t.getY() + t.getHeight() / 2 - Bullet.HEIGHT / 2;
        // 实例化一颗子弹
        GameModel.getInstance().add(
                new RectDecorator(
                new TailDecorator(
                        new Bullet(bX, bY, t.getDir(), t.getGroup()))));
        // 播放开火的音效
//        if (t.getGroup() == Group.BAD) new Thread(() -> new Audio("tank_fire.wav").play()).start();
    }
}
