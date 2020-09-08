package singleton;

import java.util.Date;

/**
 * 不但可以解决线程同步问题，还可以防止反序列化
 *
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/7 17:07
 * @descrption
 */
public enum Mgr08 {

    INSTANCE;

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        Long startTime=new Date().getTime();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                System.out.println(Mgr08.INSTANCE.hashCode());
            }).start();
        }
        Long endTime=new Date().getTime();
        System.out.println("耗时:"+(endTime-startTime));
    }
}
