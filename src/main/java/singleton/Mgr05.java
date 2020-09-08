package singleton;

import java.util.Date;

/**
 * lazy loading
 * 也是懒汉式
 * 什么时候需要，什么时候初始化
 * 通过加锁解决线程安全问题
 * 缺点：效率降低
 *
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/9/7 17:07
 * @descrption
 */
public class Mgr05 {
    private static Mgr05 INSTANCE;

    private Mgr05() {
    }

    public static Mgr05 getInstance() {
        if (INSTANCE == null) {
            //多线程测试会有问题
            synchronized(Mgr05.class){
                try{
                    Thread.sleep(1);
                }catch (Exception e){
                    e.printStackTrace();
                }
                INSTANCE = new Mgr05();
            }
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        Long startTime=new Date().getTime();
        for (int i = 0; i < 100; i++) {
//            //匿名内部类写法
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    //
//                }
//            });
            //lambob表达式  只有一个方法的匿名内部类简写方法
            new Thread(() -> {
                System.out.println(Mgr05.getInstance().hashCode());
            }).start();
        }
        Long endTime=new Date().getTime();
        System.out.println("耗时:"+(endTime-startTime));
    }
}
