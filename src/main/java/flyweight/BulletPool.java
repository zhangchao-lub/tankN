package flyweight;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 享元模式 共享单元 线程池
 *
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/10/10 15:03
 * @descrption
 */
class Bullet {
    public UUID id = UUID.randomUUID();
    boolean living = true;

    public void setLiving(boolean living) {
        this.living = living;
    }

    @Override
    public String toString() {
        return "Bullet{" +
                "id=" + id +
                ", living=" + living +
                '}';
    }
}

public class BulletPool {
    List<Bullet> bullets=new ArrayList<>();
    {
        for(int i=0;i<5;i++){
            bullets.add(new Bullet());
        }
    }

    public Bullet getBullet(){
        for(int i=0;i<bullets.size();i++){
            if (bullets.get(i).living){
                bullets.get(i).setLiving(false);
                return bullets.get(i);
            }
        }
        if(bullets.size()>10){
            try {
                Thread.sleep(1000);
                this.getBullet();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            Bullet b=new Bullet();
            bullets.add(b);
            b.setLiving(false);
            return b;
        }
        return null;
    }

    public static void main(String[] args) {
        BulletPool bp=new BulletPool();

        for(;;){
            System.out.println(bp.bullets.size());
            for(int j=0;j<bp.bullets.size();j++){
              if(Math.random()>0.6){
                  bp.bullets.get(j).setLiving(true);
              }
            }
            Bullet b=bp.getBullet();
            System.out.println(b);
        }
    }
}
