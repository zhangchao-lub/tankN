/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/10 14:16
 * @descrption
 */
public class FourDirFireStrategy implements FireStrategy{
    @Override
    public void fire(Tank t) {
        // 计算子弹x轴
        int bX = t.getX() + Tank.getWIDTH()/ 2 - Bullet.WIDTH / 2;
        // 计算子弹y轴
        int bY = t.getY() + Tank.getHEIGHT() / 2 - Bullet.HEIGHT / 2;
        Dir[] dirs=Dir.values();
        for(Dir dir:dirs){
            // 实例化一颗子弹
            new Bullet(bX, bY, dir, t.getGroup(), t.getTf());
        }
        // 播放开火的音效
//        if (t.getGroup() == Group.GOOD) new Thread(() -> new Audio("tank_fire.wav").play()).start();
    }
}
