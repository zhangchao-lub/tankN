package game.abstractfactory;

import game.enums.Dir;
import game.enums.Group;
import game.frames.TankFrame;

import java.awt.*;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/16 9:34
 * @descrption
 */
public abstract class BaseTank {

    public Rectangle rectangle=new Rectangle();
    public Group group;

    public abstract void paint(Graphics g);
    public abstract int getX();

    public abstract int getY();

    public abstract TankFrame getTf();


    public abstract Dir getDir();

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public abstract void die();

}
