package singleton;

import java.util.Date;

/**
 * lazy loading
 * 也是懒汉式
 * 什么时候需要，什么时候初始化
 * 通过加锁解决线程安全问题
 * 双重检查，提高效率
 * 缺点：
 *
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/7 17:07
 * @descrption
 */
public class Mgr06 {
    private static volatile Mgr06 INSTANCE;

    private Mgr06() {
    }

    public static Mgr06 getInstance() {
        if (INSTANCE == null) {
            //多线程测试会有问题
            synchronized (Mgr06.class) {
                if (INSTANCE == null) {
                    try {
                        Thread.sleep(1);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Mgr06();
                }
            }
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        Long startTime=new Date().getTime();
        for (int i = 0; i < 100000; i++) {
//            //匿名内部类写法
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    //
//                }
//            });
            //lambob表达式  只有一个方法的匿名内部类简写方法
            new Thread(() -> {
                System.out.println(Mgr06.getInstance().hashCode());
            }).start();
        }
        Long endTime=new Date().getTime();
        System.out.println("耗时:"+(endTime-startTime));
    }
}
