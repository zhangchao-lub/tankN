package aTank.strategy.fire;

import aTank.entity.Tank;

import java.io.Serializable;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/10 14:14
 * @descrption
 */
public interface FireStrategy extends Serializable {
    void fire(Tank t);
}
