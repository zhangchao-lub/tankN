package game.abstractfactory;

import game.entity.Tank;

import java.awt.*;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/16 9:34
 * @descrption
 */
public abstract class BaseBullet {
    public abstract void paint(Graphics g);

    public abstract boolean collideWith(BaseTank baseTank);
}
